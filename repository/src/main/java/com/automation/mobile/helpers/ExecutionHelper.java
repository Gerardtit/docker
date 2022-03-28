package com.automation.mobile.helpers;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.entities.ConfigType;
import com.automation.mobile.entities.FileLocations;
import com.automation.mobile.entities.MobileConfType;
import com.automation.mobile.enums.WorkflowType;
import com.automation.mobile.models.ApiResponse;
import com.automation.mobile.models.HttpResponse;
import com.automation.mobile.services.ahem.AhemEmailService;
import com.automation.mobile.services.bitrise.ArtifactService;
import com.automation.mobile.services.bitrise.BuildService;
import com.automation.mobile.services.perfecto.RepositoryService;
import com.google.common.base.CharMatcher;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ExecutionHelper {

    public static void downloadBuild(AppiumDevice appiumDevice) throws IOException {

        String artifactSlug = null;

        String appSlug = appiumDevice.getConfigureData("app_slug");

        String buildSlug = appiumDevice.getConfigureData("build_slug");

        String platformName = appiumDevice.getConfigureData(MobileConfType.PLATFORM_NAME);

        String banner = appiumDevice.getConfigureData(ConfigType.BANNER);

        String environment = appiumDevice.getConfigureData(ConfigType.APP_ENVIRONMENT);

        StringBuilder fileName = new StringBuilder(banner + "-" + buildSlug);

        HttpResponse artifactRes = ArtifactService.getArtifactList(appSlug, buildSlug);
        JSONArray artifacts;
        try {
            artifacts = artifactRes.getJsonResponse().getJSONArray("data");
        } catch (JSONException jsonException) {
            throw new RuntimeException("Exception caught when trying to download build from bitrise, please check app/build slug, API Response:" + artifactRes);
        }

        for (int i = 0; i < artifacts.length(); i++) {

            JSONObject artifactObj = artifacts.getJSONObject(i);

            if (artifactObj.getString("artifact_type").equalsIgnoreCase("ios-ipa")) {

                artifactSlug = artifactObj.getString("slug");

                fileName.append(".ipa");

                break;
            } else if (artifactObj.getString("artifact_type").equalsIgnoreCase("android-apk")) {

                artifactSlug = artifactObj.getString("slug");

                fileName.append(".apk");

                break;
            }
        }

        HttpResponse response = ArtifactService.getArtifact(appSlug, buildSlug, artifactSlug);

        String result = java.net.URLDecoder.decode(response.getJsonResponse().getJSONObject("data").getString("expiring_download_url"), "UTF-8");

        byte[] fileContents = ArtifactService.downloadArtifact(result);

        Path filePath = Paths.get(FileLocations.MOBILE_APP_LOCATION + platformName + "/" + environment);

        if (Files.notExists(filePath)) {

            Files.createDirectories(filePath);
        }

        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath.toString() + "/" + fileName));

        fileOutputStream.write(fileContents);

        fileOutputStream.close();
    }

    public static String startBitriseBuild(AppiumDevice appiumDevice) throws InterruptedException {

        JSONObject bitriseData = appiumDevice.getBitriseData();

        JSONObject environmentObject = bitriseData.getJSONObject("environment");

        String appSlug = bitriseData.getString("appSlug");

        String banner = appiumDevice.getConfigureData(ConfigType.BANNER);

        String platformName = appiumDevice.getConfigureData(MobileConfType.PLATFORM_NAME);

        JSONObject body = new JSONObject();

        JSONObject hookObj = new JSONObject();

        JSONObject buildParams = new JSONObject();

        JSONArray environments = new JSONArray();

        if (!environmentObject.isEmpty()) {
            environmentObject.keySet().forEach(key ->
            {
                JSONObject envObj = new JSONObject();

                String value = environmentObject.getString(key);

                envObj.put("is_expand", true);

                envObj.put("mapped_to", key);

                envObj.put("value", value);

                environments.put(envObj);
            });

            buildParams.put("environments", environments);
        }

        hookObj.put("type", "bitrise");

        body.put("hook_info", hookObj);

        if (platformName.equalsIgnoreCase("ios")) {

            buildParams.put("workflow_id", WorkflowType.valueOf(banner).getWorkflow());
        } else {

            buildParams.put("workflow_id", "DebugOnSteroids");
        }

        buildParams.put("branch", bitriseData.getString("branch"));

        body.put("build_params", buildParams);

        HttpResponse response = BuildService.startBuild(appSlug, body.toString());

        String buildSlug = response.getJsonResponse().getString("build_slug");

        waitForBuildStatus(appSlug, buildSlug);

        return buildSlug;
    }

    private static void waitForBuildStatus(String appSlug, String buildSlug) throws InterruptedException {

        while (true) {
            String statusText = "";

            HttpResponse response = BuildService.getBuild(appSlug, buildSlug);

            if (response.getStatusCode() == 200) {

                statusText = response.getJsonResponse().getJSONObject("data").getString("status_text");

                if (statusText.equalsIgnoreCase("in-progress")) {

                    TimeUnit.MINUTES.sleep(2);

                    continue;
                } else if (statusText.equalsIgnoreCase("success")) {

                    break;
                } else if (statusText.equalsIgnoreCase("error")) {

                    break;
                }
            } else {

                throw new InterruptedException("Get Build Status Call Failed");
            }
        }
    }

    public static boolean getRepositoryList(String platformName, String cloudToken, String appName) {

        HttpResponse response = RepositoryService.getFileList(platformName.toUpperCase(), cloudToken);

        JSONArray artifacts;

        try {
            artifacts = response.getJsonResponse().getJSONArray("artifacts");
        } catch (JSONException jsonException) {
            throw new RuntimeException("Exception caught when trying to get artifacts list, API Response:" + response);
        }

        for (int i = 0; i < artifacts.length(); i++) {

            JSONObject artifactObj = artifacts.getJSONObject(i);

            if (artifactObj.getString("artifactLocator").equalsIgnoreCase(appName)) {

                return true;
            }
        }
        return false;
    }

    /*public static String getOtp(String email) {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException ie) {
            // Do nothing
        }

        String otp = null;

        int index = email.indexOf('@');

        String mailBoxName = email.substring(0, index);

        String token = AhemEmailService.getToken().getJsonResponse().getString("token");

        JSONArray emails = AhemEmailService.getEmailList(token, mailBoxName).getJsonArrayResponse();

        String emailId = emails.getJSONObject(0).getString("emailId");

        String content = AhemEmailService.getEmailContent(token, mailBoxName, emailId)
                .getJsonResponse().getString("text");

        Scanner sc = new Scanner(content);

        String line = null;
        while (sc.hasNextLine()) {
            line = sc.nextLine().trim();
            try {
                otp = String.format("%06d", Integer.parseInt(line));
                break;
            } catch (NumberFormatException nfx) {
                //Ignore the exception
            }
        }

        AhemEmailService.deleteEmailContent(token, mailBoxName, emailId);

        return otp;
    }*/


    public static String getOtp(String email, long currentEpochTime) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ie) {
            // Do nothing
        }

        String mailBoxName = email.split("@")[0];
        String token = AhemEmailService.getToken().getJsonResponse().getString("token");
        String emailId = null;
        String otp = null;
        SCAN_MAILBOX:
        for (int cntVal = 0; cntVal <= 5; cntVal++) {
            List<ApiResponse.AllEmails> allEmails = new Gson().fromJson(AhemEmailService.getEmailList(token, mailBoxName).getContent(), new TypeToken<List<ApiResponse.AllEmails>>() {
            }.getType());
            if (allEmails.stream().filter(indEmail -> indEmail.timestamp >= currentEpochTime).collect(Collectors.toList()).size() != 0) {
                emailId = allEmails.stream().filter(indEmail -> indEmail.timestamp > currentEpochTime).collect(Collectors.toList()).get(0).emailId;
                String content = AhemEmailService.getEmailContent(token, mailBoxName, emailId)
                        .getJsonResponse().getString("text");
                otp = CharMatcher.inRange('0', '9').retainFrom(content);
                break;
            } else {
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException ie) {
                    // Do nothing
                }
            }
        }
        AhemEmailService.deleteEmailContent(token, mailBoxName, emailId);
        return otp;
    }

    public static int getCurrentEmailsCount(String email) {
        int emailCount = 0;
        String token;
        String mailBoxName = email.split("@")[0];
        try {
            token = AhemEmailService.getToken().getJsonResponse().getString("token");
        } catch (JSONException je) {
            return 0;
        }

        int statusCode = AhemEmailService.getEmailList(token, mailBoxName).getStatusCode();
        if (statusCode != 404) {
            JSONArray emails = AhemEmailService.getEmailList(token, mailBoxName).getJsonArrayResponse();
            emailCount = emails.length();
        }
        return emailCount;
    }

    public static String getOtp(String email, int emailCount) {
        final String[] otp = {null};
     /*   boolean newEmailArrived = false;
        // Loop until a new email has arrived
        for (int i = 0; i < 40; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                // Do nothing
            }

            int currentCount = getCurrentEmailsCount(email);
            if (currentCount > emailCount) {
                newEmailArrived = true;
                break;
            }
        }
*/

        String mailBoxName = email.split("@")[0];
       /* String token = AhemEmailService.getToken().getJsonResponse().getString("token");
        String emailId = null;
        JSONArray emails = AhemEmailService.getEmailList(token, mailBoxName).getJsonArrayResponse();
        emailId = emails.getJSONObject(0).getString("emailId");*/
      /*  Mail7SDK.Initialize init = new Mail7SDK.Initialize();

        init.setApiKey("f5077094-01fd-422f-a05d-48fb787d6393");
        init.setApiSecret("79ec3cbc-a171-4aee-a57f-ef3e363397cd");

        EmailApi Mail7EmailAPI = new EmailApi();

        Mail7EmailAPI.getEmails(mailBoxName,
                "mail7.io",
                new AsyncHandler() {
                    @Override
                    public void onSuccess(String response) {
                        System.out.println(response);
                        otp[0] = CharMatcher.inRange('0', '9').retainFrom(response.toString());
                    }

                    @Override
                    public void onSuccess(Object o) {

                    }

                    @Override
                    public void onFailure(ErrorResponse error) {
                        System.out.println(error.getMessage());
                    }
                });


        //   String content = AhemEmailService.getEmailContent(token, mailBoxName, emailId).getJsonResponse().getString("text");
*/


        String content = AhemEmailService.getEmailContent(mailBoxName).toString();
        Document doc = Jsoup.parse(content);
        Elements id = doc.getElementsByTag("tbody").get(1).getElementsByTag("span");

        String OTP = CharMatcher.inRange('0', '9').retainFrom(id.toString());
        String OTPNumber = OTP.substring(2);
        System.out.println(OTPNumber);
        return OTPNumber;

    }

    public static void clearEmailInbox(String email) {
        String mailBoxName = email.split("@")[0];
        String token = AhemEmailService.getToken().getJsonResponse().getString("token");
        String emailId = null;
        int statusCode = AhemEmailService.getEmailList(token, mailBoxName).getStatusCode();
        if (statusCode != 404) {
            JSONArray emails = AhemEmailService.getEmailList(token, mailBoxName).getJsonArrayResponse();
            for (int i = 0; i < emails.length(); i++) {
                emailId = emails.getJSONObject(i).getString("emailId");
                AhemEmailService.deleteEmailContent(token, mailBoxName, emailId);
            }
        }
    }
}


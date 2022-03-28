package com.automation.mobile;

import com.automation.mobile.entities.CommandArgument;
import com.automation.mobile.helpers.TestRailHelper;
import com.automation.mobile.manager.ConfigFileManager;
import com.automation.mobile.services.testrail.APIException;
import com.automation.mobile.util.GlobalVar;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.*;

public class MobileRunner {
    private static List<Integer> portList = new ArrayList<>();

    @Test
    public void executeRunner() throws Exception {
        String testType = System.getProperty("testType", "parallel");
        System.out.println(testType);

        Map<String, List<String>> parsedArgument = parseCommandArgument();
        GlobalVar.DEVICE_LIST = generateDeviceList(parsedArgument);
        //GlobalVar.BITRISE_DATA = parseBitriseData(parsedArgument);
        GlobalVar.GLOBAL_PARAMS = generateGlobalParams();
        System.out.println(GlobalVar.DEVICE_LIST);

        int threadCount = GlobalVar.DEVICE_LIST.size();

        TestNGGenerator testng = new TestNGGenerator(testType, threadCount);
        try {
            testng.runTest();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private Map<String, List<String>> parseCommandArgument() {

        Map<String, List<String>> testParameters = new HashMap<String, List<String>>();
        if (null != System.getProperty(CommandArgument.MOBILE_DEVICES) && !System.getProperty(CommandArgument.MOBILE_DEVICES).isEmpty()) {
            if (System.getProperty(CommandArgument.MOBILE_DEVICES).contains(",")) {
                testParameters.put(CommandArgument.BANNERS,
                        Arrays.asList(System.getProperty(CommandArgument.BANNERS).split(",")));
                testParameters.put(CommandArgument.MOBILE_DEVICES,
                        Arrays.asList(System.getProperty(CommandArgument.MOBILE_DEVICES).split(",")));
                testParameters.put(CommandArgument.APP_SLUG, Arrays.asList(null != System.getenv(CommandArgument.APP_SLUG) ?
                        System.getenv(CommandArgument.APP_SLUG).split(",") :
                        System.getProperty(CommandArgument.APP_SLUG).split(",")));
                testParameters.put(CommandArgument.BUILD_SLUG, Arrays.asList(null != System.getenv(CommandArgument.BUILD_SLUG) ?
                        System.getenv(CommandArgument.BUILD_SLUG).split(",") :
                        System.getProperty(CommandArgument.BUILD_SLUG).split(",")));
                if (System.getProperty(CommandArgument.APP_PATH) != null && !System.getProperty(CommandArgument.APP_PATH).isEmpty()) {
                    testParameters.put(CommandArgument.APP_PATH, Arrays.asList(System.getProperty(CommandArgument.APP_PATH)));
                }
                if (System.getProperty(CommandArgument.APP_NAME) != null && !System.getProperty(CommandArgument.APP_NAME).isEmpty()) {
                    testParameters.put(CommandArgument.APP_NAME, Arrays.asList(System.getProperty(CommandArgument.APP_NAME)));
                }
            } else {
                testParameters.put(CommandArgument.BANNERS,
                        Arrays.asList(System.getProperty(CommandArgument.BANNERS)));
                testParameters.put(CommandArgument.MOBILE_DEVICES,
                        Arrays.asList(System.getProperty(CommandArgument.MOBILE_DEVICES)));
                testParameters.put(CommandArgument.APP_SLUG, Arrays.asList(null != System.getenv(CommandArgument.APP_SLUG) ?
                        System.getenv(CommandArgument.APP_SLUG) :
                        System.getProperty(CommandArgument.APP_SLUG)));
                testParameters.put(CommandArgument.BUILD_SLUG, Arrays.asList(null != System.getenv(CommandArgument.BUILD_SLUG) ?
                        System.getenv(CommandArgument.BUILD_SLUG) :
                        System.getProperty(CommandArgument.BUILD_SLUG)));
                if (System.getProperty(CommandArgument.APP_PATH) != null && !System.getProperty(CommandArgument.APP_PATH).isEmpty()) {
                    testParameters.put(CommandArgument.APP_PATH, Arrays.asList(System.getProperty(CommandArgument.APP_PATH)));
                }
                if (System.getProperty(CommandArgument.APP_NAME) != null && !System.getProperty(CommandArgument.APP_NAME).isEmpty()) {
                    testParameters.put(CommandArgument.APP_NAME, Arrays.asList(System.getProperty(CommandArgument.APP_NAME)));
                }
            }

            testParameters.put("environment", Arrays.asList(System.getProperty(CommandArgument.MOBILE_ENVIRONMENT)));
        } else {
            if (System.getenv(CommandArgument.DEVICES).contains(",")) {
                testParameters.put(CommandArgument.BANNERS,
                        Arrays.asList(System.getenv(CommandArgument.BANNER).split(",")));
                testParameters.put(CommandArgument.MOBILE_DEVICES,
                        Arrays.asList(System.getenv(CommandArgument.DEVICES).split(",")));
                testParameters.put(CommandArgument.APP_SLUG,
                        Arrays.asList(System.getenv(CommandArgument.APP_SLUG).split(",")));
                testParameters.put(CommandArgument.BUILD_SLUG,
                        Arrays.asList(System.getenv(CommandArgument.BUILD_SLUG).split(",")));
//				testParameters.put(CommandArgument.PLAN_NAME,
//						Arrays.asList(System.getenv(CommandArgument.PLAN_NAME).split(",")));
            } else {
                testParameters.put(CommandArgument.BANNERS,
                        Arrays.asList(System.getenv(CommandArgument.BANNER)));
                testParameters.put(CommandArgument.MOBILE_DEVICES,
                        Arrays.asList(System.getenv(CommandArgument.DEVICES)));
                testParameters.put(CommandArgument.APP_SLUG,
                        Arrays.asList(System.getenv(CommandArgument.APP_SLUG)));
                testParameters.put(CommandArgument.BUILD_SLUG,
                        Arrays.asList(System.getenv(CommandArgument.BUILD_SLUG)));
//				testParameters.put(CommandArgument.PLAN_NAME,
//						Arrays.asList(System.getenv(CommandArgument.PLAN_NAME)));
            }

            testParameters.put("environment", Arrays.asList(System.getenv(CommandArgument.ENVIRONMENT)));
        }

        testParameters.put("app", Arrays.asList("shop"));

        System.out.println(testParameters);
        return testParameters;
    }

    public Map<String, Map<String, String>> generateDeviceList(Map<String, List<String>> inputParameters) throws IOException {
        Map<String, Map<String, String>> totalParameters = new HashMap<String, Map<String, String>>();
        List<String> banners = inputParameters.get("banner");
        List<String> mobileDevices = inputParameters.get("mobileDevice");
        String app = inputParameters.get("app").get(0);
        String env = inputParameters.get("environment").get(0);
        int wdaLocalPort = 8100;
        for (int i = 0; i < mobileDevices.size(); i++) {
            String banner = banners.get(i);
            String mobile = mobileDevices.get(i);
            Map<String, String> deviceParam = new HashMap<>();
            System.out.println(mobile);
            deviceParam.putAll(new ConfigFileManager().getMobilePropertyMap(mobile));
            deviceParam.putAll(new ConfigFileManager().getBannerPropertyMap(banner, env));
            deviceParam.put("banner", banner);
            deviceParam.put("env", env);
            deviceParam.put("app", app);
            deviceParam.put("STATE", "AVAILABLE");
            deviceParam.put("REGISTERUSER", "");
            String appPath = inputParameters.containsKey(CommandArgument.APP_PATH) ? inputParameters.get(CommandArgument.APP_PATH).get(i) : "";
            String appName = inputParameters.containsKey(CommandArgument.APP_NAME) ? inputParameters.get(CommandArgument.APP_NAME).get(i) : "";
            deviceParam.put("app_path", appPath);
            deviceParam.put("app_name", appName);
            if (!mobile.contains("emulator") && !mobile.contains("simulator")) {
                deviceParam.put("build_slug", inputParameters.get(CommandArgument.BUILD_SLUG).get(i));
                deviceParam.put("app_slug", inputParameters.get(CommandArgument.APP_SLUG).get(i));
            } else {
                int port = findFreePort();
                if (portList.contains(port)) {
                    port = findFreePort();
                } else {
                    portList.add(Integer.valueOf(port));
                }
                deviceParam.put("wdaLocalPort", String.valueOf(port));
            }
            totalParameters.put(mobile, deviceParam);
            wdaLocalPort++;
        }
        return totalParameters;
    }

    public Map<String, JSONObject> parseBitriseData(Map<String, List<String>> inputParameters) {

        Map<String, JSONObject> bitriseData = new HashMap<>();

        List<String> mobileDevices = inputParameters.get("mobileDevice");

        for (int i = 0; i < mobileDevices.size(); i++) {

            String mobile = mobileDevices.get(i);

            JSONObject bitriseObj = new JSONArray(System.getenv("BITRISE_BUILDS")).getJSONObject(i);

            bitriseData.put(mobile, bitriseObj);
        }

        return bitriseData;
    }

    private Map<String, Map<String, String>> generateGlobalParams() throws IOException, APIException {

        Map<String, Map<String, String>> globalParams = new HashMap<>();

        Map<String, String> testrail = null;

        String planName = null != System.getenv("PLAN_NAME") ? System.getenv("PLAN_NAME") :
                System.getProperty("PLAN_NAME");

        if (null != planName && !planName.isEmpty()) {

            testrail = new HashMap<>();

            testrail.put("plan_name", planName);

            testrail.put("userName", null != System.getenv("TESTRAIL_USER") ? System.getenv("TESTRAIL_USER") :
                    System.getProperty("TESTRAIL_USER"));

            testrail.put("password", null != System.getenv("TESTRAIL_PASSWORD") ? System.getenv("TESTRAIL_PASSWORD") :
                    System.getProperty("TESTRAIL_PASSWORD"));

            TestRailHelper.initTesPlan(planName);

            GlobalVar.testrail = true;
        }

        globalParams.put("testrail", testrail);

        return globalParams;
    }

    private static int findFreePort() {
        int port = 0;
        // For ServerSocket port number 0 means that the port number is automatically allocated.
        try (ServerSocket socket = new ServerSocket(0)) {
            // Disable timeout and reuse address after closing the socket.
            socket.setReuseAddress(true);
            port = socket.getLocalPort();
        } catch (IOException ignored) {
        }
        if (port > 0) {
            return port;
        }
        throw new RuntimeException("Could not find a free port");
    }
}

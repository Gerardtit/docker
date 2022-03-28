package com.automation.rest.signup;

import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.google.common.util.concurrent.Uninterruptibles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class EmailOTP {

    public class GuerillaEmailService {
        String HOST = "https://www.guerrillamail.com/ajax.php";
        Logger logger = LogManager.getLogger(getClass());
        String userName;
        String mailID;
        String sidToken;

        public GuerillaEmailService(String userName) {
            this.userName = userName;
        }

        public void setUser() {
            String url = HOST + "?f=set_email_user";
            HttpRequest request = new HttpRequest();
            request.setUrl(url);
            Map<String, String> headers = getHeadersForGuerrillaMail();
            headers.remove("Cookie");
            request.setHeaders(headers);

            Map<String, Object> queryParams = new HashMap<>();
            queryParams.put("email_user", userName);
            queryParams.put("lang", "en");
            queryParams.put("site", "guerrillamail.com");
            queryParams.put("in", "Set cancel");
            request.setParams(queryParams);

            HttpResponse response = HttpHandler.post(request);
            logger.info(String.format("Set email response: %s", response));
            this.sidToken = "" + response.getJsonResponse().get("sid_token");
            if (response.getStatusCode() != 200 && response.getStatusCode() != 201) {
                logger.info(String.format("Set email request: %s", request));
                logger.info(String.format("Set email response: %s", response));
            }
        }

        private String getOtpFromDesiredMail() {
            String url = HOST + "?f=fetch_email&email_id=mr_" + this.mailID + "&site=guerrillamail.com&in=" + userName;
            HttpRequest request = new HttpRequest();
            request.setUrl(url);
            request.setHeaders(getHeadersForGuerrillaMail());

            HttpResponse response = HttpHandler.get(request);
            if (response.getStatusCode() != 200 && response.getStatusCode() != 201) {
                logger.info(String.format("Fetch mail detail request: %s", request));
                logger.info(String.format("Fetch mail detail response: %s", response));
            }

            String mailBody = "" + response.getJsonResponse().get("mail_body");
            String optText = mailBody.split("verification code:")[1].split("For your privacy")[0].split("</span>")[0];
            return optText.substring(optText.length() - 6);
        }

        public String getTheOTP() {
            String otp = null;
            try {
                setUser();
                this.mailID = ((JSONObject) getEmailList().get(0)).get("mail_id").toString();
                otp = getOtpFromDesiredMail();
            } catch (JSONException jse) {
            }
            return otp;
        }

        private JSONArray getEmailList() {
            String url = HOST + "?f=get_email_list&offset=0&site=guerrillamail.com&in=" + userName;
            HttpRequest request = new HttpRequest();
            request.setUrl(url);
            request.setHeaders(getHeadersForGuerrillaMail());

            HttpResponse response = HttpHandler.get(request);
            if (response.getStatusCode() != 200 && response.getStatusCode() != 201) {
                logger.info(String.format("Get all emails list request: %s", request));
                logger.info(String.format("Get all emails list response: %s", response));
            }
            return response.getJsonResponse().getJSONArray("list");
        }

        public int getEmailCount() {
            setUser();
            return getEmailList().length();
        }

        public String getLatestEmailId() {
            String emailId = "";
            setUser();
            if (getEmailList().length() > 0) {
                if (((JSONObject) getEmailList().get(0)).get("mail_subject").toString().contains("Verification Code")) {
                    emailId = ((JSONObject) getEmailList().get(0)).get("mail_id").toString();
                }
            }
            return emailId;
        }

        private Map<String, String> getHeadersForGuerrillaMail() {
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("authority", "www.guerrillamail.com");
            headers.put("authorization", "ApiToken be43d4757368ceb54a604cf0bc1b2a235eb38b55d6413c197d0eb4025a2ae69d");
            headers.put("Cache-Control", "no-cache");
            headers.put("Postman-Token", UUID.randomUUID().toString());
            headers.put("Host", "www.guerrillamail.com");
            headers.put("Accept-Encoding", "gzip, deflate, br");
            headers.put("Connection", "keep-alive");
            headers.put("Cookie", "PHPSESSID=" + this.sidToken);
            return headers;
        }
    }

    public class Mail7EmailService {
        private static final int GET_MAIL_MAX_RETRIES = 2;
        String HOST = "https://api.mail7.io";
        String API_KEY = "9c08d406-59fd-49ae-b5fd-bdddc1d6cecb";
        String DOMAIN = "mail7.io";
        Logger logger = LogManager.getLogger(getClass());
        String userName;

        public Mail7EmailService(String userName) {
            this.userName = userName;
        }

        public JSONArray getAllEmails() {
            String url = HOST + "/inbox";
            HttpRequest request = new HttpRequest();
            request.setUrl(url);

            Map<String, Object> queryParams = new HashMap<>();
            queryParams.put("to", userName);
            queryParams.put("domain", DOMAIN);
            queryParams.put("apikey", API_KEY);
            request.setParams(queryParams);

            request.setHeaders(getAuthHeaders());
            HttpResponse response = getWithRetry("Get all emails", request);

            if (response.getStatusCode() != 200 && response.getStatusCode() != 201) {
                logger.info(String.format("Get all emails request: %s", request));
                logger.info(String.format("Get all emails response: %s", response));
            }

            return response.getJsonResponse().getJSONArray("data");
        }

        private void deleteEmailById(String messageId) {
            String url = HOST + "/delete";
            HttpRequest request = new HttpRequest();
            request.setUrl(url);

            Map<String, Object> queryParams = new HashMap<>();
            queryParams.put("mesid", messageId);
            queryParams.put("domain", DOMAIN);
            queryParams.put("apikey", API_KEY);
            request.setParams(queryParams);

            request.setHeaders(getAuthHeaders());

            HttpResponse response = getWithRetry("Delete email", request);

            if (response.getStatusCode() != 200 && response.getStatusCode() != 201) {
                logger.info(String.format("Delete email request: %s", request));
                logger.info(String.format("Delete email response: %s", response));
            }
        }

        public void clearInbox() {
            logger.info("About to clear inbox for user: " + userName + "@mail7.io");
            Set<String> mailIds = new HashSet<>();
            StreamSupport.stream(getAllEmails().spliterator(), false).map(JSONObject.class::cast).forEach(json -> mailIds.add(json.getString("_id")));
            mailIds.forEach(mail -> deleteEmailById(mail));
        }

        public String getTheOTP() {
            Optional<JSONObject> mailObj = StreamSupport.stream(getAllEmails().spliterator(), false).map(JSONObject.class::cast).filter(mail -> mail.getJSONObject("mail_source").getJSONObject("headers").getJSONObject("from").getJSONArray("value").getJSONObject(0).getString("name").contentEquals("Verification code")).findFirst();
            if (mailObj.isPresent()) {
                String mailBody = ((JSONObject) mailObj.get().get("mail_source")).getString("html");
                String otpText = mailBody.split("verification code:")[1].split("For your privacy")[0].split("</span>")[0];
                return otpText.substring(otpText.length() - 6);
            } else {
                return null;
            }
        }

        public int getInboxSize() {
            return getAllEmails().length();
        }

        private Map<String, String> getAuthHeaders() {
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("accept", "application/json");
            headers.put("Content-Type", "text/plain");
            return headers;
        }

        //Get with retry in case of failure
        private HttpResponse getWithRetry(String resourceName, HttpRequest request) {
            HttpResponse response = null;
            for (int retryCounter = 1; retryCounter <= GET_MAIL_MAX_RETRIES; retryCounter++) {
                response = HttpHandler.get(request);
                if (response.getStatusCode() == 200) {
                    break;
                } else {
                    Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
                    logger.info(resourceName + " request failed, retrying...");
                }
            }
            return response;
        }
    }
}

package com.automation.rest.signup;

import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.automation.mobile.util.CommonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RegisterUser {
    String HOST = "https://www-qa2.%s.com";
    Logger logger = LogManager.getLogger(getClass());
    String bannerName;
    String emailID;

    public RegisterUser(String banner, String emailID) {
        this.HOST = String.format(HOST, new CommonUtil().resolveBannerNameForHost(banner));
        this.bannerName = banner;
        this.emailID = emailID;
    }


    public RegisterUser checkEmailID() {
        String url = HOST + "/abs/acceptancepub/cnc/ucaservice/api/uca/email";
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        boolean emailIDNotPresent;

        Map<String, String> headers = getAuthHeaders();
        request.setHeaders(headers);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("emailAddress", emailID);
        request.setServiceBody(requestBody);
        HttpResponse response = null;
        try {
            response = HttpHandler.post(request);
            emailIDNotPresent = (boolean) response.getJsonResponse().get("notInUse");
            if (response.getStatusCode() != 200 && !emailIDNotPresent) {
                logger.info(String.format("Create email request: %s", request));
                logger.info(String.format("Create email response: %s", response));
            }
        } catch (Exception e) {
            logger.info(String.format("Create email request: %s", request));
            logger.info(String.format("Create email response: %s", response));
            throw new RuntimeException("Create Email failed" + e.getMessage());
        }

        return this;
    }

    private Map<String, String> getAuthHeaders() {
        Map<String, String> authHeaders = new HashMap<String, String>();
        authHeaders.put("Host", HOST.split("//")[1]);
        authHeaders.put("x-swy_banner", bannerName);
        authHeaders.put("ocp-apim-subscription-key", "d8c6d7783b604f618dd446e7c39c7c08");
        authHeaders.put("x-swy-correlation-id", "00650693-3a87-4cf5-87cc-328046848c6d");
        authHeaders.put("x-swy-client-id", "web-portal");
        authHeaders.put("origin", HOST);
        authHeaders.put("referer", HOST + "/");

        authHeaders.put("accept", "application/vnd.safeway.v1+json");
        authHeaders.put("content-type", "application/vnd.safeway.v1+json");
        return authHeaders;
    }


    private HttpResponse registerUser(String storeId, String zipCode) {
        String url = HOST + "/abs/acceptancepub/cnc/ucaservice/api/uca/customers/register";
        HttpRequest request = new HttpRequest();
        request.setUrl(url);
        String customerId = null;

        Map<String, String> headers = getAuthHeaders();
        headers.put("x-swy-date", new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss z").format(new Date()));
        request.setHeaders(headers);


        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("rememberMe", "N");
        requestBody.put("clubCardNumber", "");
        requestBody.put("emailIdvalidate", this.emailID);
        requestBody.put("pOrCcValidate", "5523823530");
        requestBody.put("firstName", "Test");
        requestBody.put("lastName", "Test");
        requestBody.put("emailId", this.emailID);
        requestBody.put("password", "test@1234");

        Map<String, String> phoneNo = new HashMap<String, String>();
        phoneNo.put("type", "mobile");
        phoneNo.put("number", "5523" + String.format("%06d", new Random().nextInt(999999)));
        Object[] phone = new Object[]{phoneNo};
        requestBody.put("phone", phone);
        requestBody.put("terms", "Y");


        Map<String, Object> prefsInfo = new HashMap<String, Object>();
        prefsInfo.put("emailOffers", "");
        Map<String, String> storeDetails = new HashMap<String, String>();
        storeDetails.put("storeId", storeId);
        storeDetails.put("storePreference", "Preferred");
        Object[] storeInfo = new Object[]{storeDetails};
        prefsInfo.put("stores", storeInfo);

        requestBody.put("preferences", prefsInfo);
        requestBody.put("sourceProgram", "");
        requestBody.put("stores", storeId);
        requestBody.put("zipCode", zipCode);
        requestBody.put("banner", this.bannerName);
        request.setServiceBody(requestBody);

        HttpResponse response = HttpHandler.post(request);
        if (("" + response.getStatusCode()).startsWith("4")) {
            logger.info(String.format("Register email request: %s", request));
            logger.info(String.format("Register email response: %s", response));
        }
        return response;
    }

    public String registerUserWithRetryForDuplicatePhoneNo(String storeId, String zipCode) {
        String customerId = null;
        for (int cntVal = 0; cntVal < 5; cntVal++) {
            // In-case of error the request is resent till cust id is received
            HttpResponse registerUserResp = registerUser(storeId, zipCode);
            if (("" + registerUserResp.getStatusCode()).startsWith("2")) {
                customerId = "" + registerUserResp.getJsonResponse().get("customerId");
                break;
            }
        }
        return customerId;
    }

}

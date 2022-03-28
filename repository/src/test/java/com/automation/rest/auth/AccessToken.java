package com.automation.rest.auth;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.automation.rest.cache.CommonCache;
import com.automation.rest.config.RestApiConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


public class AccessToken {
    Logger logger = LogManager.getLogger(getClass());
    private final String userName;
    private final String password;

    public AccessToken(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getAccessToken() {
        String accessToken = null;
        HttpRequest request = new HttpRequest();
        String url = ThreadLocalHelper.testCaseData.get().get("ACCESS_TOKEN_HOST_URL") + "/oauth2/ausdvuyculRIYitXg0h7/v1/token";
        HttpResponse response = null;
        Map<String, Object> params = new HashMap<>();
        params.put("username", userName);
        params.put("password", password);
        params.put("grant_type", "password");
        params.put("scope", "openid profile offline_access");
        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();
        headers.put("authorization", "Basic MG9hZDhhaXd0N1pBN3NXY3owaDc6dGhRaTh6a3gzaVJ4YkpfbDliTno5RzJ3bkR0OXJTcVgyZkxncktwVw==");
        headers.put("accept", "application/json");
        request.setUrl(url);
        request.setHeaders(headers);
        request.setParams(params);

        try {
            response = HttpHandler.post(request);
            for (int cntVal = 0; cntVal < 5; cntVal++) {
                accessToken = response.getJsonResponse().getString("access_token");
                if (response.getStatusCode() == 200) {
                    accessToken = response.getJsonResponse().getString("access_token");
                    CommonCache.tokenCache.put("accessToken", accessToken);
                    break;
                }
            }
        } catch (Exception e) {
            logger.info("Get access token request: " + request);
            logger.info("Get access token response: " + response);
            throw new RuntimeException("Get access token failed, exception message: " + e.getMessage());
        }

        return accessToken;
    }
}

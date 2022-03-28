package com.automation.rest;

import java.util.HashMap;
import java.util.Map;

import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.automation.mobile.models.Result;
import com.automation.rest.cache.CommonCache;
import com.automation.rest.config.RestApiConfig;

import io.appium.java_client.AppiumDriver;

public class LoginService extends RestService {

    public LoginService(AppiumDriver driver) {

        super(driver);
    }

    public Result getAccessToken() {

        Result result = new Result();

        HttpRequest request = new HttpRequest();

        String url = this.authUrl + "/ausdvuyculRIYitXg0h7/v1/token";

        Map<String, Object> params = new HashMap<String, Object>();

        params.put("username", "test_rewards1@example.com");

        params.put("password", "testpwd1");

        params.put("grant_type", "password");

        params.put("scope", "openid profile offline_access");

        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();

        headers.put("x-app_version", "10.3.0");

        headers.put("authorization", "Basic MG9hZDhhaXd0N1pBN3NXY3owaDc6dGhRaTh6a3gzaVJ4YkpfbDliTno5RzJ3bkR0OXJTcVgyZkxncktwVw==");

        headers.put("appversion", "10.3.0");

        headers.put("swy_api_key", "0fdb13ac50972b700f8a9e352d8ea123414ae1f1.safeway.j4u.iphone");

        headers.put("platform", "ios");

        headers.put("banner", "safeway");

        headers.put("charset", "utf-8");

        headers.put("x-swy_banner", "safeway");

        request.setUrl(url);

        request.setHeaders(headers);

        request.setParams(params);
        try {
            HttpResponse response = HttpHandler.post(request);

            if (response.getStatusCode() == 200) {

                CommonCache.tokenCache.put("accessToken", response.getJsonResponse().getString("access_token"));

                result.setStatus(true);

                result.setStatusMsg("Get Access Token Successfull");
            }

        } catch (Exception e) {

            result.setStatus(false);

            result.setStatusMsg("Get Access Token Failed with Exception :: " + e.toString());
        }

        return result;
    }


}

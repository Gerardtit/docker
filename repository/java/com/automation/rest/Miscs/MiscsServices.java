package com.automation.rest.Miscs;

import java.util.Map;

import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.automation.mobile.models.Result;
import com.automation.rest.RestService;
import com.automation.rest.config.RestApiConfig;

import io.appium.java_client.AppiumDriver;

public class MiscsServices extends RestService {

    public MiscsServices(AppiumDriver driver) {
        super(driver);

    }


    public Result getmobileAds() {


        Result result = new Result();

        HttpRequest request = new HttpRequest();

        String url = this.hostUrl + "/content/dam/data/mobile/mobileads/mobileadsv3.json";

        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();

        headers.put("x-swy-correlation-id", "9F6CFD99-0D19-4E19-A05A-D8578210E83E");

        headers.put("X-SWY_VERSION", "1.5");

        headers.put("Cookie", "swyConsumerDirectoryPro=eyJraWQiOiJHT1RLUXY2NG40N3ZRVjVuaGNGSVVveVNtaWhtQTM5V0N4TFNxVXY4WFVrIiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULktxSkkyalRENnZlMzZjR3h0U25FZk04bzA2WTl4UUg0WVNGcElCUnJBeGMub2FycnYyaDljcEFvQllXUVYwaDYiLCJpc3MiOiJodHRwczovL2Ficy1xYTEub2t0YXByZXZpZXcuY29tL29hdXRoMi9hdXNkdnV5Y3VsUklZaXRYZzBoNyIsImF1ZCI6IkFsYmVydHNvbnMiLCJpYXQiOjE2MDM5MTM3NjUsImV4cCI6MTYwMzkxNDY2NSwiY2lkIjoiMG9hZDhhaXd0N1pBN3NXY3owaDciLCJ1aWQiOiIwMHV1aWpyazVheFBteU1tYzBoNyIsInNjcCI6WyJwcm9maWxlIiwib2ZmbGluZV9hY2Nlc3MiLCJvcGVuaWQiXSwiemlwIjoiOTQxMTEiLCJzdWIiOiJnb2xkZW5nYXRlQHNhZmV3YXkuY29tIiwiaGlkIjoiODc0MDM1MDI5ODkyIiwiZG5tIjoiR29sZGVuIiwiYWxuIjoiNDkzMTg0MzQxNjYiLCJnaWQiOiI1NTctMTc2LTE2MDI4MTkzNzQ5NzAiLCJmbm0iOiJHb2xkZW4iLCJlY2MiOiIiLCJsbm0iOiJHYXRlIiwianByIjoiIiwidXVpZCI6IjYyZGU5ZWMyLWFlNGUtNGM3My04OTRkLWU1ZDIxZmMyNDJhYSIsImJhbiI6InNhZmV3YXkiLCJzdHIiOiI0NjAxIiwicGhuIjoiMzkzOTM5OTk5OSIsImJpZCI6IiJ9.E8vyXi3NIbchlLNjep52x_glscaD02GWVeQqoyWmoGt7pmO8WD0HueFgmMNZQwlwRm_7By2YCUwQuX5YbRmiUCkYAyAMmG3Ds-3_-IIl39SmyMy4fZuD9JFZr6ZU3PNmAoJF6YpR4WzBUg2puuVChNAv4hB94-CGA5oq1OaGCJKBd7v-hQu7mRW3JqwEtqHHpZY1eq-B7Q0j6kSj7sRA32CMBFUVJG4-Gm5xSTQhn4igOMZziCqagV8FWS0P_UzycKNbdcg38OvBYH2kXf_I7xWpqxRVIL4u8e6zUA1Y3i1EzoHF5G2cZPfdBs-BJaG7pgrSNFlL6Q_7FPLy4KklfQ");

        headers.put("User-Agent", "iphone");

        headers.put("X-SWY_API_KEY", "0fdb13ac50972b700f8a9e352d8ea123414ae1f1.safeway.j4u.iphone");

        headers.put("x-swy-date", "Wed, 28 Oct 2020 18:10:11");

        headers.put("ADRUM_1", "isMobile:true");

        headers.put("CLIENT_APP_VERSION", "8.5.0");

        headers.put("Accept-Language", "en-us");

        headers.put("CLIENT_ID", " ");

        headers.put("ADRUM", "isAjax:true");

        headers.put("Accept", "application/vnd.safeway.v1+json");

        headers.put("Content-Type", "application/vnd.safeway.v1+json;charset=UTF-8");

        headers.put("x-swy-client-id", "mobile-ios-portal");

        headers.put("x-swy_banner", "safeway");

        headers.put("Ocp-Apim-Subscription-Key", "d8c6d7783b604f618dd446e7c39c7c08");


        request.setUrl(url);

        request.setHeaders(headers);

        try {
            HttpResponse response = HttpHandler.get(request);

            if (response.getStatusCode() == 200) {

                result.setStatus(true);

                result.setStatusMsg("Get mobile Ads Successfull");
            }

        } catch (Exception e) {

            result.setStatus(false);

            result.setStatusMsg("Get mobile Ads Failed with Exception :: " + e.toString());
        }

        return result;
    }

    public Result getNimbusFeatureAPI() {


        Result result = new Result();

        HttpRequest request = new HttpRequest();

        String url = this.nimbusUrl + "/emmd/service/misc/features/v2?appName=safeway.j4u.iphone&storeId=4601&appVersion=8.5.0&osVersion=14.0.1&zipCode=94111&envt=qa1";

        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();


        headers.put("Accept", "*/*");

        headers.put("REQUEST_TIME", "1603909025640");

        headers.put("Accept-Language", "en-us");

        headers.put("ADRUM_1", "isMobile:true");

        headers.put("SWY_CLOUD_API_VER", "2.0");

        headers.put("User-Agent", "Safeway/7052 CFNetwork/1197 Darwin/20.0.0");

        headers.put("ADRUM", "isAjax:true");

        headers.put("X-SWY_VERSION", "8.5.0");


        request.setUrl(url);

        request.setHeaders(headers);

        try {
            HttpResponse response = HttpHandler.get(request);

            if (response.getStatusCode() == 200) {

                result.setStatus(true);

                result.setStatusMsg("Get Nimbus Feature API Successfull");
            }

        } catch (Exception e) {

            result.setStatus(false);

            result.setStatusMsg("Get Nimbus Feature API Failed with Exception :: " + e.toString());
        }

        return result;
    }

}

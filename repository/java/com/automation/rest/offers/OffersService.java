package com.automation.rest.offers;

import java.util.HashMap;
import java.util.Map;

import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.automation.mobile.models.Result;
import com.automation.rest.RestService;
import com.automation.rest.cache.CommonCache;
import com.automation.rest.config.RestApiConfig;

import io.appium.java_client.AppiumDriver;

public class OffersService extends RestService {

    public OffersService(AppiumDriver driver) {

        super(driver);
    }

    public Result getAllOffers() {

        Result result = new Result();

        HttpRequest request = new HttpRequest();

        String url = this.hostUrl + "/abs/acceptancepub/xapi/offers/companiongalleryoffer?storeId=4601";

        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();

        headers.put("Authorization", "Bearer " + CommonCache.tokenCache.get("accessToken"));

        headers.put("Content-Type", "application/json");

        request.setUrl(url);

        request.setHeaders(headers);

        try {
            HttpResponse response = HttpHandler.get(request);

            if (response.getStatusCode() == 200) {

                result.setStatus(true);

                result.setStatusMsg("Get All Offers Successfull");
            }

        } catch (Exception e) {

            result.setStatus(false);

            result.setStatusMsg("Get All Offers Failed with Exception :: " + e.toString());
        }

        return result;
    }


    public Result getCategory() {

        Result result = new Result();


        HttpRequest request = new HttpRequest();

        String url = this.nimbusUrl + "/emmd/service/misc/categorysort";


        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();


        headers.put("ADRUM_1", "isMobile:true");

        headers.put("CLIENT_APP_VERSION", "9.5.0");

        headers.put("Authorization", "Bearer " + CommonCache.tokenCache.get("accessToken"));

        headers.put("REQUEST_TIME", "1603903260514");

        headers.put("Accept", "*/*");

        headers.put("User-Agent", "Safeway/6965 CFNetwork/1197 Darwin/20.0.0");

        headers.put("Accept-Language", "en-us");

        headers.put("Content-Type", "application/json");

        headers.put("X-SWY_API_KEY", "0fdb13ac50972b700f8a9e352d8ea123414ae1f1.safeway.j4u.iphone");

        headers.put("X-SWY_BANNER", "safeway");

        headers.put("CLIENT_ID", " ");

        headers.put("ADRUM", "isAjax:true");

        headers.put("X-SWY_VERSION", "9.5.0");

        headers.put("SWY_SIGNATURE", "l7chnrkPifgLTNjch+bJ3Q96Oh8=");

        headers.put("Cookie", "swyConsumerDirectoryPro=eyJraWQiOiJxYkpsN1lDa2NiYW5nNzlUWURYNk5HOER4Y2hhY2tPdG9tenVPVURqaFA4IiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULnpiMUZBb2dNRmdJYUZkdUhReG9QdXJvT3FGUnV2RHB5ajAtYjBWWWtJN3Mub2FyZ2M2dTJ1UGZFUnl2TDUycDYiLCJpc3MiOiJodHRwczovL2FsYmVydHNvbnMub2t0YS5jb20vb2F1dGgyL2F1c3A2c294ckl5UHJtOHJTMnA2IiwiYXVkIjoiQWxiZXJ0c29ucyIsImlhdCI6MTYwMzkwMTk1NywiZXhwIjoxNjAzOTA0NjU3LCJjaWQiOiIwb2FwNmtrcDdTZWZnMjRyQjJwNiIsInVpZCI6IjAwdWp4bWk0c2gwanpxY0N2MnA2Iiwic2NwIjpbIm9mZmxpbmVfYWNjZXNzIiwicHJvZmlsZSIsIm9wZW5pZCJdLCJ6aXAiOiI4NTcxOSIsInN1YiI6ImdyZWRkaWFyQGdtYWlsLmNvbSIsImhpZCI6IjI1MDA0MTMzMzc0NiIsImRubSI6IkdhbmVzaCIsImFsbiI6IjQxMDMzODU1NDIwIiwiZ2lkIjoiMzAwLTM2OC0xMDAzOTkxMDIxIiwiZWNjIjoiNDEwMzM4NTU0MjAiLCJmbm0iOiJHYW5lc2giLCJsbm0iOiJSZWRkaWFyIiwidXVpZCI6ImJjNTU4ZjBjLWU1OTgtNDcxNy1iNTU3LTU2NmRlNzcwODk1NCIsImpwciI6IiIsImJhbiI6InNhZmV3YXkiLCJzdHIiOiIxNjg0IiwicGhuIjoiNDA4ODM0NjY3MiIsImJpZCI6Ijc1YWM4ZDRhLWYxZjctNGM3OS1iZjRiLWJhMDRjYzNkNjBlOSJ9.OKCtz5SqbSWcnBLp1btBq5sv64b8o0SSKHgyHk5UVl5Ryfu1KGJoJqFXUcaodWzc6pYxUMKgaEufPfReCBZszAJAgJj5oLt1M1CVLyoveRH10yT0Nmw-CjvtrTAOdH2nPdbAVsEJoleXJihF0-RTrJmkWnaCc5jHv41SWzEH3T5JomYeuUjpRsp0CxUaSM6iZ8KVSuzOYk5lK11h_vAIWY5XV084yFpDy3VtQkchTxw-dGgIRhaRQ9ZlQtb-EX1SEf7B1BHlMaxlOlIGGStj67NMJ9458bD258lU6lktRI5Wk6QRHvNRuveFXlDVAQa5gGl6t88EC-F19jQyUTgHuA");

        headers.put("SWY_TIMESTAMP", "1603903260514");

        request.setUrl(url);

        request.setHeaders(headers);

        try {
            HttpResponse response = HttpHandler.get(request);

            if (response.getStatusCode() == 200) {

                result.setStatus(true);

                result.setStatusMsg("Get Category Successfull");
            }

        } catch (Exception e) {

            result.setStatus(false);

            result.setStatusMsg("Get Category Failed with Exception :: " + e.toString());
        }


        return result;

    }

    public Result getWeeklySpecials() {

        Result result = new Result();


        HttpRequest request = new HttpRequest();

        String url = this.nimbusUrl + "/emmd/service/offer/weeklySpecial/2606?Brand=safeway";


        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();


        headers.put("ADRUM_1", "isMobile:true");

        headers.put("User-Agent", "Safeway/7052 CFNetwork/1197 Darwin/20.0.0");

        headers.put("REQUEST_TIME", "1603913906691");

        headers.put("Accept", "*/*");

        headers.put("Accept-Language", "en-us");

        headers.put("SWY_TIMESTAMP", "1603913907");

        headers.put("X-SWY_API_KEY", "0fdb13ac50972b700f8a9e352d8ea123414ae1f1.safeway.j4u.iphone");

        headers.put("SWY_CLOUD_API_VER", "2.0");

        headers.put("X-SWY_BANNER", "safeway");

        headers.put("CLIENT_ID", " ");

        headers.put("X-SWY_VERSION", "8.5.0");

        headers.put("ADRUM", "isAjax:true");

        headers.put("SWY_SIGNATURE", "D3qSwpYqIKtQCxC+3rIXB34CdLw=");

        headers.put("Cookie", "swyConsumerDirectoryPro=eyJraWQiOiJxYkpsN1lDa2NiYW5nNzlUWURYNk5HOER4Y2hhY2tPdG9tenVPVURqaFA4IiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULnpiMUZBb2dNRmdJYUZkdUhReG9QdXJvT3FGUnV2RHB5ajAtYjBWWWtJN3Mub2FyZ2M2dTJ1UGZFUnl2TDUycDYiLCJpc3MiOiJodHRwczovL2FsYmVydHNvbnMub2t0YS5jb20vb2F1dGgyL2F1c3A2c294ckl5UHJtOHJTMnA2IiwiYXVkIjoiQWxiZXJ0c29ucyIsImlhdCI6MTYwMzkwMTk1NywiZXhwIjoxNjAzOTA0NjU3LCJjaWQiOiIwb2FwNmtrcDdTZWZnMjRyQjJwNiIsInVpZCI6IjAwdWp4bWk0c2gwanpxY0N2MnA2Iiwic2NwIjpbIm9mZmxpbmVfYWNjZXNzIiwicHJvZmlsZSIsIm9wZW5pZCJdLCJ6aXAiOiI4NTcxOSIsInN1YiI6ImdyZWRkaWFyQGdtYWlsLmNvbSIsImhpZCI6IjI1MDA0MTMzMzc0NiIsImRubSI6IkdhbmVzaCIsImFsbiI6IjQxMDMzODU1NDIwIiwiZ2lkIjoiMzAwLTM2OC0xMDAzOTkxMDIxIiwiZWNjIjoiNDEwMzM4NTU0MjAiLCJmbm0iOiJHYW5lc2giLCJsbm0iOiJSZWRkaWFyIiwidXVpZCI6ImJjNTU4ZjBjLWU1OTgtNDcxNy1iNTU3LTU2NmRlNzcwODk1NCIsImpwciI6IiIsImJhbiI6InNhZmV3YXkiLCJzdHIiOiIxNjg0IiwicGhuIjoiNDA4ODM0NjY3MiIsImJpZCI6Ijc1YWM4ZDRhLWYxZjctNGM3OS1iZjRiLWJhMDRjYzNkNjBlOSJ9.OKCtz5SqbSWcnBLp1btBq5sv64b8o0SSKHgyHk5UVl5Ryfu1KGJoJqFXUcaodWzc6pYxUMKgaEufPfReCBZszAJAgJj5oLt1M1CVLyoveRH10yT0Nmw-CjvtrTAOdH2nPdbAVsEJoleXJihF0-RTrJmkWnaCc5jHv41SWzEH3T5JomYeuUjpRsp0CxUaSM6iZ8KVSuzOYk5lK11h_vAIWY5XV084yFpDy3VtQkchTxw-dGgIRhaRQ9ZlQtb-EX1SEf7B1BHlMaxlOlIGGStj67NMJ9458bD258lU6lktRI5Wk6QRHvNRuveFXlDVAQa5gGl6t88EC-F19jQyUTgHuA");

        headers.put("CLIENT_APP_VERSION", "8.5.0");


        request.setUrl(url);

        request.setHeaders(headers);

        try {
            HttpResponse response = HttpHandler.get(request);

            if (response.getStatusCode() == 200) {

                result.setStatus(true);

                result.setStatusMsg("Get Weekly Specials Successfull");
            }

        } catch (Exception e) {

            result.setStatus(false);

            result.setStatusMsg("Get Weekly Specials Failed with Exception :: " + e.toString());
        }

        return result;

    }

    public Result postOfferClip() {

        Result result = new Result();


        HttpRequest request = new HttpRequest();

        String url = this.nimbusUrl + "Clipping1/services/clip/items?storeId=4601";


        Map<String, String> headers = RestApiConfig.getUrlEncodeHeaders();


        headers.put("ADRUM_1", "isMobile:true");

        headers.put("User-Agent", "Safeway/7052 CFNetwork/1197 Darwin/20.0.0");


        headers.put("Accept", "*/*");

        headers.put("Accept-Language", "en-us");

        headers.put("Content-Type", "application/json");

        headers.put("SWY_TIMESTAMP", "1603913907");

        headers.put("X-SWY_API_KEY", "0fdb13ac50972b700f8a9e352d8ea123414ae1f1.safeway.j4u.iphone");

        headers.put("X-SWY_BANNER", "safeway");

        headers.put("CLIENT_ID", " ");

        headers.put("X-SWY_VERSION", "1.1");

        headers.put("ADRUM", "isAjax:true");

        headers.put("Cookie", "swyConsumerDirectoryPro=eyJraWQiOiJxYkpsN1lDa2NiYW5nNzlUWURYNk5HOER4Y2hhY2tPdG9tenVPVURqaFA4IiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULnpiMUZBb2dNRmdJYUZkdUhReG9QdXJvT3FGUnV2RHB5ajAtYjBWWWtJN3Mub2FyZ2M2dTJ1UGZFUnl2TDUycDYiLCJpc3MiOiJodHRwczovL2FsYmVydHNvbnMub2t0YS5jb20vb2F1dGgyL2F1c3A2c294ckl5UHJtOHJTMnA2IiwiYXVkIjoiQWxiZXJ0c29ucyIsImlhdCI6MTYwMzkwMTk1NywiZXhwIjoxNjAzOTA0NjU3LCJjaWQiOiIwb2FwNmtrcDdTZWZnMjRyQjJwNiIsInVpZCI6IjAwdWp4bWk0c2gwanpxY0N2MnA2Iiwic2NwIjpbIm9mZmxpbmVfYWNjZXNzIiwicHJvZmlsZSIsIm9wZW5pZCJdLCJ6aXAiOiI4NTcxOSIsInN1YiI6ImdyZWRkaWFyQGdtYWlsLmNvbSIsImhpZCI6IjI1MDA0MTMzMzc0NiIsImRubSI6IkdhbmVzaCIsImFsbiI6IjQxMDMzODU1NDIwIiwiZ2lkIjoiMzAwLTM2OC0xMDAzOTkxMDIxIiwiZWNjIjoiNDEwMzM4NTU0MjAiLCJmbm0iOiJHYW5lc2giLCJsbm0iOiJSZWRkaWFyIiwidXVpZCI6ImJjNTU4ZjBjLWU1OTgtNDcxNy1iNTU3LTU2NmRlNzcwODk1NCIsImpwciI6IiIsImJhbiI6InNhZmV3YXkiLCJzdHIiOiIxNjg0IiwicGhuIjoiNDA4ODM0NjY3MiIsImJpZCI6Ijc1YWM4ZDRhLWYxZjctNGM3OS1iZjRiLWJhMDRjYzNkNjBlOSJ9.OKCtz5SqbSWcnBLp1btBq5sv64b8o0SSKHgyHk5UVl5Ryfu1KGJoJqFXUcaodWzc6pYxUMKgaEufPfReCBZszAJAgJj5oLt1M1CVLyoveRH10yT0Nmw-CjvtrTAOdH2nPdbAVsEJoleXJihF0-RTrJmkWnaCc5jHv41SWzEH3T5JomYeuUjpRsp0CxUaSM6iZ8KVSuzOYk5lK11h_vAIWY5XV084yFpDy3VtQkchTxw-dGgIRhaRQ9ZlQtb-EX1SEf7B1BHlMaxlOlIGGStj67NMJ9458bD258lU6lktRI5Wk6QRHvNRuveFXlDVAQa5gGl6t88EC-F19jQyUTgHuA");

        headers.put("CLIENT_APP_VERSION", "8.5.0");


        request.setUrl(url);

        request.setHeaders(headers);

        try {
            HttpResponse response = HttpHandler.post(request);

            if (response.getStatusCode() == 200) {

                CommonCache.tokenCache.put("accessToken", response.getJsonResponse().getString("access_token"));

                result.setStatus(true);

                result.setStatusMsg("Post Offer Clip Successfull");
            }

        } catch (Exception e) {

            result.setStatus(false);

            result.setStatusMsg("Post Offer Clip Failed with Exception :: " + e.toString());
        }


        return result;

    }


}

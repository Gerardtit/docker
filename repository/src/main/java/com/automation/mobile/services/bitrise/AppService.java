package com.automation.mobile.services.bitrise;

import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.automation.mobile.services.bitrise.config.BitriseApiConfig;
import com.automation.mobile.services.bitrise.constants.BitriseConstants;

public class AppService {

    public static HttpResponse getAppList() {

        HttpRequest request = new HttpRequest();

        request.setUrl(BitriseConstants.URL + BitriseConstants.APPS);

        request.setHeaders(BitriseApiConfig.getHeaders());

        HttpResponse response = HttpHandler.get(request);

        return response;
    }
}

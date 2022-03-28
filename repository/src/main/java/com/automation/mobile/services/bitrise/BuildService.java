package com.automation.mobile.services.bitrise;

import com.automation.mobile.handlers.HttpHandler;
import com.automation.mobile.models.HttpRequest;
import com.automation.mobile.models.HttpResponse;
import com.automation.mobile.services.bitrise.config.BitriseApiConfig;
import com.automation.mobile.services.bitrise.constants.BitriseConstants;

import java.util.Map;

public class BuildService {

    public static HttpResponse getBuildList(String appSlug) {

        HttpRequest request = new HttpRequest();

        String url = BitriseConstants.URL + BitriseConstants.APPS + "/" + appSlug + BitriseConstants.BUILDS;

        request.setUrl(url);

        request.setHeaders(BitriseApiConfig.getHeaders());

        HttpResponse response = HttpHandler.get(request);

        return response;
    }

    public static HttpResponse getBuild(String appSlug, String buildSlug) {

        HttpRequest request = new HttpRequest();

        String url = BitriseConstants.URL + BitriseConstants.APPS + "/" +
                appSlug + BitriseConstants.BUILDS + "/" + buildSlug;

        request.setUrl(url);

        request.setHeaders(BitriseApiConfig.getHeaders());

        HttpResponse response = HttpHandler.get(request);

        return response;

    }

    public static HttpResponse startBuild(String appSlug, String body) {

        HttpRequest request = new HttpRequest();

        String url = BitriseConstants.URL + BitriseConstants.APPS + "/" + appSlug + BitriseConstants.BUILDS;

        Map<String, String> headers = BitriseApiConfig.getHeaders();

        headers.put("Content-Type", "application/json");

        request.setUrl(url);

        request.setStringBody(body);

        request.setHeaders(headers);

        HttpResponse response = HttpHandler.post(request);

        return response;
    }
}

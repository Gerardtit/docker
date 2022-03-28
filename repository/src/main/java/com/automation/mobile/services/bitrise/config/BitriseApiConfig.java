package com.automation.mobile.services.bitrise.config;

import java.util.HashMap;
import java.util.Map;

public class BitriseApiConfig {

    public static Map<String, String> getHeaders() {

        Map<String, String> headers = new HashMap<String, String>();

        String token = null != System.getenv("BITRISE_TOKEN") ? System.getenv("BITRISE_TOKEN") :
                System.getProperty("BITRISE_TOKEN");

        headers.put("Authorization", token);

        headers.put("accept", "application/json");

        return headers;
    }
}

package com.automation.rest.config;

import java.util.HashMap;
import java.util.Map;

public class RestApiConfig {

    public static Map<String, String> getUrlEncodeHeaders() {

        Map<String, String> headers = new HashMap<String, String>();

        headers.put("content-type", "application/x-www-form-urlencoded");

        return headers;
    }

}

package com.automation.mobile.services.testrail;


import org.json.simple.JSONObject;

import java.io.IOException;

public class TestService extends TestRailService {

    public TestService() {

        super();
    }

    public JSONObject getTests(int runId) throws IOException, APIException {

        JSONObject result;

        result = (JSONObject) apiClient.sendGet("get_tests/" + runId);

        return result;
    }
}

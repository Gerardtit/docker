package com.automation.mobile.services.testrail;

import org.json.simple.JSONObject;

import java.io.IOException;

public class TestRunService extends TestRailService {

    public TestRunService() {

        super();
    }

    public JSONObject getRun(String runId) throws IOException, APIException {

        JSONObject result;

        result = (JSONObject) apiClient.sendGet("get_run/" + runId);

        return result;
    }

    public JSONObject addRun(JSONObject body) throws IOException, APIException {

        JSONObject result;

        result = (JSONObject) apiClient.sendPost("add_run/" + 2, body);

        return result;
    }
}

package com.automation.mobile.services.testrail;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;

public class ResultService extends TestRailService {

    public ResultService() {

        super();
    }

    public void addResultsForCases(String runId, JSONObject body) throws IOException, APIException {

        JSONArray result;

        result = (JSONArray) apiClient.sendPost("add_results_for_cases/" + runId, body);
    }

    public JSONObject addResult(JSONObject body, int testId) throws IOException, APIException {

        JSONObject result;

        result = (JSONObject) apiClient.sendPost("add_result/" + testId, body);

        return result;
    }
}

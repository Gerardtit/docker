package com.automation.mobile.services.testrail;

import org.json.simple.JSONObject;

import java.io.IOException;

public class TestPlanService extends TestRailService {

    public TestPlanService() {

        super();
    }

    public JSONObject getPlans() throws IOException, APIException {

        JSONObject result;

        result = (JSONObject) apiClient.sendGet("get_plans/" + 2);

        return result;
    }

    public JSONObject addPlan(JSONObject body) throws IOException, APIException {

        JSONObject result;

        result = (JSONObject) apiClient.sendPost("add_plan/" + 2, body);

        return result;
    }

    public JSONObject addPlanEntry(JSONObject body, int planId) throws IOException, APIException {

        JSONObject result;

        result = (JSONObject) apiClient.sendPost("add_plan_entry/" + planId, body);

        return result;
    }

    public void closePlan(int planId) throws IOException, APIException {

        apiClient.sendPost("close_plan/" + planId, new JSONObject());
    }
}

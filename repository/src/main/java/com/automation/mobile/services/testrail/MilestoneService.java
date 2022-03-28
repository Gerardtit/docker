package com.automation.mobile.services.testrail;

import org.json.simple.JSONObject;

import java.io.IOException;

public class MilestoneService extends TestRailService {

    public MilestoneService() {

        super();
    }

    public JSONObject getMilestones() throws IOException, APIException {

        JSONObject response;

        response = (JSONObject) apiClient.sendGet("get_milestones/" + 2);

        return response;
    }

    public JSONObject addMilestone(JSONObject body) throws IOException, APIException {

        JSONObject response;

        response = (JSONObject) apiClient.sendPost("add_milestone/" + 2, body);

        return response;
    }
}

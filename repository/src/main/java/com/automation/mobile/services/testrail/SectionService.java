package com.automation.mobile.services.testrail;

import org.json.simple.JSONObject;

import java.io.IOException;

public class SectionService extends TestRailService {

    public SectionService() {
        super();
    }

    public JSONObject addSection(JSONObject body) throws IOException, APIException {

        JSONObject response;

        response = (JSONObject) apiClient.sendPost("add_section/" + 2, body);

        return response;
    }

    public JSONObject getSections() throws IOException, APIException {

        JSONObject response;

        response = (JSONObject) apiClient.sendGet("get_sections/" + 2 + "&suite_id=142");

        return response;
    }
}

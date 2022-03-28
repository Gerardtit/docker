package com.automation.mobile.services.testrail;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;

public class CaseService extends TestRailService {

    public CaseService() {

        super();
    }

    public JSONArray getCases() throws IOException, APIException {

        JSONArray result;

        result = (JSONArray) apiClient.sendGet("get_cases/" + 1);

        return result;
    }

    public JSONObject getCases(int sectionId) throws IOException, APIException {

        JSONObject result;

        result = (JSONObject) apiClient.sendGet("get_cases/" + 2 + "&suite_id=142&section_id=" + sectionId);

        return result;
    }

    public JSONObject addCase(JSONObject body, String sectionId) throws IOException, APIException {

        JSONObject result;

        result = (JSONObject) apiClient.sendPost("add_case/" + sectionId, body);

        return result;
    }

    public JSONObject updateCase(JSONObject body, String caseId) throws IOException, APIException {

        JSONObject result;

        result = (JSONObject) apiClient.sendPost("update_case/" + caseId, body);

        return result;
    }

    public void deleteCases(JSONObject body) throws IOException, APIException {

        apiClient.sendPost("delete_cases/" + 2, body);
    }
}

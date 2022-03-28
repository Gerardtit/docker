package com.automation.mobile.services.testrail;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;

public class ConfigService extends TestPlanService {

    public ConfigService() {

        super();
    }

    public JSONArray getConfigs() throws IOException, APIException {

        JSONArray result;

        result = (JSONArray) apiClient.sendGet("get_configs/" + 2);

        return result;
    }

    public JSONObject addConfigGroup(JSONObject body) throws IOException, APIException {

        JSONObject result;

        result = (JSONObject) apiClient.sendPost("add_config_group/" + 2, body);

        return result;
    }

    public JSONObject addConfig(JSONObject body, int configGroupId) throws IOException, APIException {

        JSONObject result;

        result = (JSONObject) apiClient.sendPost("add_config/" + configGroupId, body);

        return result;
    }
}

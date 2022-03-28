package com.automation.mobile.services.testrail;

import com.automation.mobile.services.testrail.constants.TestRailConstants;

public class TestRailService {

    protected APIClient apiClient;

    public TestRailService() {

        apiClient = new APIClient(TestRailConstants.URL);

        apiClient.setUser(System.getProperty("TESTRAIL_USER"));

        apiClient.setPassword(System.getProperty("TESTRAIL_PASSWORD"));
    }

}

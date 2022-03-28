package com.automation.mobile.listener;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.appium.AppiumServerManager;
import com.automation.mobile.services.perfecto.RepositoryService;
import com.automation.mobile.util.ExecutionData;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.io.IOException;

public class TestNGListener implements ISuiteListener {
    Logger logger = LogManager.getLogger(getClass());

    public void onStart(ISuite iSuite) {
        new AppiumServerManager().startAppiumServer();
        System.out.println("*************start server*************");
    }

    @SneakyThrows
    @Override
    public void onFinish(ISuite iSuite) {
        AppiumDriverManager.closeAllDrivers();
        new AppiumServerManager().stopAppiumServer();
        System.out.println("*************stop server*************");
        if ((Boolean) ExecutionData.executionData.get("IS_ADA")) {
            //Adding static wait here to enable reports to be generated in perfecto after execution; source:https://help.perfecto.io/perfecto-help/content/perfecto/test-analysis/smart_reporting_public_api.htm
            logger.info("Waiting 2 minutes for accessibility reports to be generated in perfecto...");
            Thread.sleep(120000);
            if (ExecutionData.executionData.get("EXECUTION_ID") != null) {
                downloadAccessibilityReport((String) ExecutionData.executionData.get("EXECUTION_ID"));
            }
        }
    }

    private void downloadAccessibilityReport(String executionId) throws IOException {
        new RepositoryService().downloadAccessibilityReports((String) ExecutionData.executionData.get("PERFECTO_TOKEN"), executionId);
    }
}

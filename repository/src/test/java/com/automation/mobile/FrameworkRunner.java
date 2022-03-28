package com.automation.mobile;

import com.automation.mobile.core.framework.Framework;
import com.automation.mobile.services.testrail.APIException;
import org.testng.annotations.Test;

import java.io.IOException;

public class FrameworkRunner {

    @Test
    public void executeRunner() throws IOException, APIException {

        Framework framework = new Framework();

        framework.startExecution();
    }
}

package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_idealconditionPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;


public class GG_idealconditionSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_idealconditionPage idealconditionPage = new GG_idealconditionPage(driver);
    AppiumDevice device = AppiumDeviceManager.getDevice();

    @Then("user minimise the app")
    public void userMinimiseTheApp() throws Exception {
        idealconditionPage.runbackground();
    }

}
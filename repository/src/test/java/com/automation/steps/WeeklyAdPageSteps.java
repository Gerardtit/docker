package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.WeeklyAdPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;

public class WeeklyAdPageSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public AppiumDevice device = AppiumDeviceManager.getDevice();
    WeeklyAdPage weeklyAdPage = new WeeklyAdPage(driver);

    @Then("^WeeklyAd page should be displayed$")
    public void Weekly_Ad_page_should_be_displayed() {
        weeklyAdPage.verifyWeeklyAdPageTitle();
    }
}

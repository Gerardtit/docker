package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.ChooseAccountPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;

public class ChooseAccountPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public AppiumDevice device = AppiumDeviceManager.getDevice();
    ChooseAccountPage chooseAccountPage = new ChooseAccountPage(driver);

    @Then("^choose account page is displayed$")
    public void choose_account_page_displayed() {
        chooseAccountPage.waitForChooseAccountPageDisplayed();
    }

    @When("^user clicks continue as guest button from choose account page$")
    public void click_continue_as_guest() {
        chooseAccountPage.clickContinueAsGuest();
    }
}

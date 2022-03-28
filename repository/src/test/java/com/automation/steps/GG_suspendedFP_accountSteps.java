package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_suspendedFP_AccountPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GG_suspendedFP_accountSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public AppiumDevice device = AppiumDeviceManager.getDevice();
    GG_suspendedFP_AccountPage suspendedFP_accountPage = new GG_suspendedFP_AccountPage(driver);

    @And("^Validate suspended text$")
    public void validateSuspendedText() {
        suspendedFP_accountPage.supendedtext();
    }

    @And("^validate card expired text$")
    public void validateCardExpiredText() {
        suspendedFP_accountPage.cardexpiredText();
    }

    @Then("^suspended text is displayed$")
    public void suspendedTextIsDisplayed() {
        suspendedFP_accountPage.suspendedatmembertab();
    }

    @Then("^user clicks card expired text$")
    public void userClicksCardExpiredText() {
        suspendedFP_accountPage.clickExpired();
    }

    @When("^user clicks navigate to freshpass page$")
    public void userClicksNavigateToFreshpassPage() {
        suspendedFP_accountPage.backicon();
    }

    @Then("^user clicks unsubscribed$")
    public void userClicksGetStarted() {
        suspendedFP_accountPage.clicksunsubscribed();
    }


}

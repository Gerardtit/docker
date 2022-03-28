package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_checkout_COAPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GG_Checkout_COASteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_checkout_COAPage contactCOAPage = new GG_checkout_COAPage(driver);
    AppiumDevice device = AppiumDeviceManager.getDevice();

    @Then("validate applycredit on account is displayed")
    public void validateApplycreditOnAccountIsDisplayed() {
        contactCOAPage.applycredit();

    }

    @When("applied credit is clicked and text box is displayed")
    public void appliedCreditIsClickedAndTextBoxIsDisplayed() {
        contactCOAPage.applycreditclicked();
    }


    @Then("user apply a value to be credited")
    public void userApplyAValueToBeCredited() {
        contactCOAPage.creditamountentered();

    }

    @Then("Creditedapplied is displayed")
    public void creditedappliedIsDisplayed() {
        contactCOAPage.creditedtext();
    }

    @When("Creditapplied is closed")
    public void creditappliedIsClosed() {
        contactCOAPage.cancelcredit();
    }

    @Then("user is able to see same apply credit text")
    public void userIsAbleToSeeSameApplyCreditText() {
        contactCOAPage.regainCredit();

    }
}

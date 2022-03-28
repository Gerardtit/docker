package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_Cancellation_freshpassPage;
import com.automation.pages.GG_Verify_FreshPassPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class GG_Cancellation_freshpassSteps {


    public AppiumDevice device = AppiumDeviceManager.getDevice();
    AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_Cancellation_freshpassPage cancellationFreshPassPage = new GG_Cancellation_freshpassPage(driver);
    public GG_Verify_FreshPassPage FreshPassPage = new GG_Verify_FreshPassPage(driver);


    @Then("^user selects cancel reason$")
    public void userSelectsCancelReason() {
        cancellationFreshPassPage.cancelreason();
    }


    @And("^user clicks on yes tab$")
    public void userClicksOnYesTab() {
        cancellationFreshPassPage.yestext();
    }

    @Then("^validate cancel subscription page$")
    public void validateCancelSubscriptionPage() {
        cancellationFreshPassPage.freetrialtext();
        cancellationFreshPassPage.endnoticetext();

        cancellationFreshPassPage.shopnow();
    }

    @Then("^user verify freshpass page from account$")
    public void userVerifyFreshpassPageFromAccount() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {

            FreshPassPage.homeiconselected();
            FreshPassPage.clickprofileicon();
        }
    }
}

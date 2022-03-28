package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_E2E_freshpassPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GG_E2E_freshpassSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_E2E_freshpassPage gg_e2E_freshpassPage = new GG_E2E_freshpassPage(driver);
    AppiumDevice device = AppiumDeviceManager.getDevice();

    @Then("CVV text is entered")
    public void cvvTextIsEntered() {
        gg_e2E_freshpassPage.cvvtext();
    }


    @Then("user save credit card details")
    public void userSaveCreditCardDetails() {
        gg_e2E_freshpassPage.savecard();
    }

    @Then("close payment description page")
    public void closePaymentDescriptionPage() {
        gg_e2E_freshpassPage.closepaymentad();
    }

    @And("user verify upon landing on CVV screen, cursor will active")
    public void userVerifyUponLandingOnCVVScreenCursorWillBeActive() {
        driver.switchTo().activeElement();
//        gg_e2E_freshpassPage.cvvpage();
    }

    @When("sign in with New OTP for delivery orders")
    public void sign_in_with_new_otp_for_delivery_orders() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}


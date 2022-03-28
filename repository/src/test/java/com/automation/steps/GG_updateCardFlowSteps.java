package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_Verify_FreshPassPage;
import com.automation.pages.GG_updateCardFlowPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GG_updateCardFlowSteps {


    public AppiumDevice device = AppiumDeviceManager.getDevice();
    AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_updateCardFlowPage updatecardflowPage = new GG_updateCardFlowPage(driver);
    public GG_Verify_FreshPassPage FreshPassPage = new GG_Verify_FreshPassPage(driver);

    @When("^user clicks on selecttab of annual plan$")
    public void userClicksOnSelecttabOfannualPlan() {
        updatecardflowPage.planSelect();
    }

    @Then("^user click on card detail arrow$")
    public void userClickOnCardDetailArrow() {
        updatecardflowPage.cardarrow();
    }

    @Then("^confirm cvv text is displayed$")
    public void confirmCvvTextIsDisplayed() {
        updatecardflowPage.confirmcvv();
    }

    @Then("^user validates card number \"([^\"]*)\" entered from freshpass page$")
    public void userValidatesCardNumberEnteredFromFreshpassPage(String cardNumber) throws Throwable {
        updatecardflowPage.cardnumber();
        updatecardflowPage.validateCard(cardNumber);
    }

    @Then("^Freshpass page is displayed$")
    public void validateFreshpasstitle() {
        updatecardflowPage.titletvalidate();
    }
}
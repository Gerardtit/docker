package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_checkout_promoPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GG_Checkout_promoSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_checkout_promoPage contactPromoPage = new GG_checkout_promoPage(driver);
    AppiumDevice device = AppiumDeviceManager.getDevice();

    @Then("validate promo on account is displayed and get cost")
    public void validatePromoOnAccountIsDisplayedAndGetCost() {
        contactPromoPage.promocode();
    }


    @When("promo code is clicked and text box is displayed")
    public void promoCodeIsClickedAndTextBoxIsDisplayed() {
        contactPromoPage.promocodeclicked();
    }

    @When("textbox is empty,Apply CTA is inactive")
    public void textboxIsEmptyApplyCTAIsInactive() {
        contactPromoPage.ctainactive();
    }

    @When("user enters invalid promocode, error messageis displayed")
    public void userEntersInvalidPromocodeErrorMessageisDisplayed() {
        contactPromoPage.errormessage();
    }

    @Then("user clear the text box")
    public void userClearTheTextBox() {
        contactPromoPage.clearbox();
    }

    @Then("user enters promo code and click Apply CTA")
    public void userEntersPromoCodeAndClickApplyCTA() {
        contactPromoPage.Applyclicked();
    }

    @Then("promocode is displayed and price is adjusted")
    public void promocodeIsDisplayedAndPriceIsAdjusted() {
        contactPromoPage.pricesaved();
    }

    @When("user clicks on cross sign of promocode")
    public void userClicksOnCrossSignOfPromocode() {
        contactPromoPage.clearpromo();
    }

    @Then("user can add any number of promocodes")
    public void userCanAddAnyNumberOfPromocodes() {
        contactPromoPage.extrapromocode();
    }
}

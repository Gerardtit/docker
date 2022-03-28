package com.automation.steps;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.manager.ConfigFileManager;
import com.automation.pages.BasePage;
import com.automation.pages.GG_SMS_Opt_InPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class GG_SMS_Opt_InPageSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_SMS_Opt_InPage gg_sms_opt_inPage = new GG_SMS_Opt_InPage(driver);
    public BasePage basePage = new BasePage(driver);

    public Map<String, String> getBannerPropertiesMap() throws IOException {
        String banner = basePage.getCurrentBanner();
        String env = basePage.getCurrentEnv();
        Map<String, String> bannerProperties = ConfigFileManager.getBannerPropertyMap(banner, env);
        return bannerProperties;
    }

    @Then("^verify SMS Opt-in status to ON$")
    public void verifySMSOptInStatusIsON() {
        gg_sms_opt_inPage.isSMSOptInIsOnByDefault();
    }

    @And("^change SMS-Opt-in status to ON$")
    public void changeSMSOptInStatusToON() {
        gg_sms_opt_inPage.changeSmsOptInToON();
    }

    @Then("^change SMS-Opt-in status to OFF$")
    public void changeSMSOptInToOff() {
        gg_sms_opt_inPage.changeSmsOptInToOff();
    }

    @Then("^verify status of SMS Opt-in is OFF$")
    public void verifySMSOptInStatusIsChangedToOff() {
        gg_sms_opt_inPage.verifySMSOptInIsOff();
    }

    @And("^Add Item to Cart$")
    public void clickOnPlusToAddItemToCart() {
        gg_sms_opt_inPage.addItemToCart();
    }

    @Then("^click on Contact to change Phone Number$")
    public void clickOnContactToChangePhoneNumber() {
        gg_sms_opt_inPage.clickOnContactToChangePhoneNumber();
    }

    @And("^click on Place Order Button to Place an Order$")
    public void clickOnPlaceOrderButton() {
        gg_sms_opt_inPage.clickOnPlaceOrderButton();
    }

    @Then("^click on Save And Review Button$")
    public void clickOnSaveAndReviewButton() {
        gg_sms_opt_inPage.clickOnSaveAndReviewButton();
    }

    @Then("^Update the Contact Number$")
    public void enterTheContactNumber() throws IOException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("PHONE_NUMBER");
        gg_sms_opt_inPage.enterPhoneNumberInTextField(zipCode);
    }

    @And("^Update new Contact Number$")
    public void updateNewContactNumber() throws IOException {
        //String phoneNo = "(234) "+new SimpleDateFormat("ddM-hhmm").format(new Date());
        String phoneNo = "(234) 333" + new SimpleDateFormat("hhmm").format(new Date());
        gg_sms_opt_inPage.enterPhoneNumberInTextField(phoneNo);
    }

    @And("^Update Contact Number in checkout page$")
    public void updateContactNumberInCheckoutPage() throws IOException {
        String phoneNo = "(234) 333" + new SimpleDateFormat("hhmm").format(new Date());
        gg_sms_opt_inPage.enterPhoneNumberInPhoneNumberTextField(phoneNo);
    }

    @And("^click edit on pickup sheet")
    public void editPickupSheet() {
        gg_sms_opt_inPage.editPickupsheet();
    }

    @And("^Validate the Store card is displayed")
    public void storeCardDisplayed() {
        gg_sms_opt_inPage.storeCardDisplayed();
    }


    @And("^validate the store on the card")
    public void storedetails() {
        gg_sms_opt_inPage.storedetails();
    }

    @Then("^swipe left on store card")
    public void swipeLeftonStoreCard() {
        gg_sms_opt_inPage.swipeLeftonstorecard();
    }


}


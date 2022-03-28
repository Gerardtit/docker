package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_checkout_contactinfoPage;
import com.automation.pages.PaymentPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class GG_Checkout_contactinfoSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_checkout_contactinfoPage contactinfoPage = new GG_checkout_contactinfoPage(driver);
    AppiumDevice device = AppiumDeviceManager.getDevice();
    PaymentPage paymentPage = new PaymentPage(driver);

    @Then("validate only name and phone number is displayed")
    public void validateOnlynameAndPhoneNumberIsDisplayed() {
        contactinfoPage.namedisplay();
        contactinfoPage.phonenumberdisplay();
    }


    @Then("pickup time slot is selected")
    public void pickupTimeSlotIsSelected() {
        contactinfoPage.selectslot();
    }


    @Then("pickup time slot is selected and slot details are stored for verification")
    public void pickup_time_slot_is_selected_and_slot_details_are_stored_for_verification() {
        contactinfoPage.selectslot();
    }


    @Then("user enters contact details in screen")
    public void userEntersContactDetails() throws InterruptedException {

        contactinfoPage.contactdetails();
    }

    @Then("^user enters contact information on conatct details screen$")
    public void user_enters_contact_information_on_conatct_details_screen() throws Throwable {
        contactinfoPage.contactdetails();
    }

    @When("^user enters \"([^\"]*)\" as CVV on CVV screen and clicks continue$")
    public void user_enters_something_as_cvv_on_cvv_screen_and_clicks_continue(String strArg1) {
        contactinfoPage.enterCvvNumberonScreen(strArg1);
    }

    @And("user enter credit card details in card")
    public void userEnterCreditCardDetails() {
        contactinfoPage.entercreditcard();
    }

    @Then("close payment page")
    public void closePaymentPage() {
        contactinfoPage.closepayment();
    }

    @Then("validate Enter name and enter mobile number text is displayed")
    public void validateEnterNameAndEnterMobileNumberTextIsDisplayed() {
        contactinfoPage.nameAndnumber();
    }

    @And("user click cross sign checkout flow")
    public void userClickCrossSignCheckoutFlow() {
        contactinfoPage.closes();
    }

    @And("user click cross sign")
    public void userClickCrossSign() {
        contactinfoPage.closes();
    }


    @Then("validate warning message")
    public void validateWarningMessage() {
        contactinfoPage.warningmessage();
    }

    @When("Contact CTA is clicked,phone number is editable")
    public void contactCTAIsClickedPhoneNumberIsEditable() {
        contactinfoPage.ctaclick();
    }


    @When("toggle for sms is clicked")
    public void toggleForSmsIsClicked() throws IOException, InterruptedException {
        contactinfoPage.smsOn();
    }


    @And("user clicks on cross sign of order conformation page")
    public void userClicksOnCrossSignOfOrderConformationPage() {
        contactinfoPage.closeodrder();
    }


    @Then("user clicks on edit at slotpage")
    public void userClicksOnEditAtSlotpage() {
        contactinfoPage.editAddress();

    }

    @And("selects different store")
    public void selectsDifferentStore() {
        contactinfoPage.anotherstore();
        contactinfoPage.continuetab();
    }

    @Then("user clicks on cross sign of cart page")
    public void userClicksOnCrossSignOfCartPage() {
        contactinfoPage.closrcart();
    }

    @And("user clicks back arrow on cart page")
    public void userClicksBackArrowOnCartPage() {
        contactinfoPage.backatCart();
    }

    @Then("pickup time slot is selected and tap on edit")
    public void editCard() {
        contactinfoPage.editcarddetails();
    }

    @Then("delivery time slot is selected oflaterdays")
    public void deliveryTimeSlotIsSelected() throws InterruptedException {
        contactinfoPage.selectdeliveryslotoflaterdays();
    }

}


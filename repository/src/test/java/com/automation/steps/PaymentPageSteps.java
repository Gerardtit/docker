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

public class PaymentPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();

    PaymentPage paymentPage = new PaymentPage(driver);
    public GG_checkout_contactinfoPage contactinfoPage = new GG_checkout_contactinfoPage(driver);

    @Then("^payment CVV window is displayed$")
    public void paymentCVVWindowIsDisplayed() {
        paymentPage.waitForCvvWindowDisplayed();
    }


    @When("^user enters CVV number and clicks next$")
    public void userEntersCVVandClicksNext() throws InterruptedException {
        paymentPage.enterCVVNumber();
    }


    @When("^user enters \"([^\"]*)\" as CVV and clicks next$")
    public void userEntersAsCVVAndClicksNext(String arg0) throws Exception {
        paymentPage.enterCvvInfo(arg0);

    }


    @When("^user enters \"([^\"]*)\" as CVV$")
    public void userEntersAsCVV(String arg0) throws Exception {
        paymentPage.enterCvv(arg0);
    }

    @When("^user enters \"([^\"]*)\" as name on credit card$")

    public void userEntersAsNameOnCreditCard(String name) throws InterruptedException {


        paymentPage.enterNameOnCreditCard(name);
    }

    @And("^user enters \"([^\"]*)\" as credit card number$")
    public void userEntersAsCreditCardNumber(String cardNumber) {
        paymentPage.enterCardNumber(cardNumber);
    }

    @And("^user enters \"([^\"]*)\" as card expiration month year$")
    public void userEntersAsCardExpirationMonthYear(String monthYear) {
        paymentPage.enterExpirationMonthYear(monthYear);
    }

    @And("^user enters \"([^\"]*)\" as billing zip code$")
    public void userEntersAsBillingZipCode(String zipcode) throws IOException, InterruptedException {
        paymentPage.enterBillingZipCode(zipcode);
    }

    @And("^user enters \"([^\"]*)\" as billing zip code on payment page$")
    public void user_enters_something_as_billing_zip_code_on_payment_page(String zipcode) throws Throwable {
        paymentPage.enterBillingZipCode(zipcode);
    }

    @When("^user enters \"([^\"]*)\" as CVV on payment page$")
    public void user_enters_something_as_cvv_on_payment_page(String strArg1) throws Throwable {
        AppiumDevice device = AppiumDeviceManager.getDevice();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            contactinfoPage.enterCvvNumberonScreen(strArg1);
        } else {
            paymentPage.enterCvvNew(strArg1);
        }


    }


    @When("^enters \"([^\"]*)\" as CVV$")
    public void EntersAsCVVAndClicksNext(String arg0) throws InterruptedException {
        paymentPage.enterCvv(arg0);

    }

    @And("^user enters \"([^\"]*)\" as cvv number$")
    public void userEntersCVVNumber(String cvvNumber) {
        paymentPage.enterCVVNumber(cvvNumber);
    }

    @And("^user enters CVV number \"([^\"]*)\"")
    public void userEntersCVV(String cvvNumber) {
        paymentPage.enterCVV(cvvNumber);
    }


    @And("user click save card details checkbox and continue")
    public void user_Click_Save_Card_Details_Checkbox() throws InterruptedException {
        paymentPage.clickSaveCardDetailsCheckbox();
        paymentPage.clickContinue();
    }


    @And("user click save or continue button on payment page")
    public void user_clicks_the_save_button() {
        paymentPage.clickSaveButton();
    }

    @And("^user enters \"([^\"]*)\" billing zip code$")
    public void userEntersBillingZipCode(String zipcode) {
        paymentPage.enterBillingZipCodeWithoutEnter(zipcode);
    }


    @When("^user click continue on payment page$")
    public void userClickContinueOnPaymentPage() throws InterruptedException {
        paymentPage.clickContinue();
    }

    @When("^user clicks payment on checkout pagex$")
    public void userClicksPaymentOnCheckoutPagex() {
        paymentPage.clickPayment();
    }

    @When("user click Edit Payment Button")
    public void userClickEditPaymentButton() {
        paymentPage.clickEditCard();
    }

    @And("^user enters \"([^\"]*)\" as billing zip code and stores the card$")
    public void userEntersAsBillingZipCodeAndStores(String zipcode) {
        paymentPage.enterBillingZipCodeWithStoring(zipcode);
    }

    @And("^user clicks on store card details on payment page$")
    public void userChecksStoreCardDetails() throws InterruptedException {
        paymentPage.saveCardDetails();
    }

    @Then("user validates Visa and card number in review order page")
    public void validateCardNumber() {
        paymentPage.validateCardNumberInOrderSummary();
    }
}

package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.PaymentPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;

public class PaymentPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    PaymentPage paymentPage = new PaymentPage(driver);

    @Then("^payment CVV window is displayed$")
    public void paymentCVVWindowIsDisplayed() {
        paymentPage.waitForCvvWindowDisplayed();
    }

    @When("^user enters \"([^\"]*)\" as CVV and clicks next$")
    public void userEntersAsCVVAndClicksNext(String arg0) {
        paymentPage.enterCvvInfo(arg0);
    }

    @When("^user enters \"([^\"]*)\" as name on credit card$")
    public void userEntersAsNameOnCreditCard(String name) {
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
    public void userEntersAsBillingZipCode(String zipcode) {
        paymentPage.enterBillingZipCode(zipcode);
    }
}

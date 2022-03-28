package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_FoodLot_PaymentPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GG_FoodLot_PaymentPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_FoodLot_PaymentPage gg_foodLot_paymentPage = new GG_FoodLot_PaymentPage(driver);

    @Then("^verify user lands on payment screen$")
    public void verify_user_lands_on_payment_screen() {
        gg_foodLot_paymentPage.verifyPaymentPage();
    }

    @When("^user enters \"([^\"]*)\" as name on credit card in foodlot")
    public void userEntersAsNameOnCreditCard(String name) {
        gg_foodLot_paymentPage.enterCardName(name);
    }

    @And("^user enters CVC as \"([^\"]*)\" appears on card$")
    public void user_enters_cvc_as_something_appears_on_card(String CVC) throws Throwable {
        gg_foodLot_paymentPage.enterCardCVC(CVC);
    }

    @And("^user enters \"([^\"]*)\" as credit card number in foodlot$")
    public void userEntersAsCreditCardNumber(String cardNumber) {
        gg_foodLot_paymentPage.enterCreditCardNo(cardNumber);
    }

    @And("^user enters \"([^\"]*)\" as card expiration month year in foodlot$")
    public void userEntersAsCardExpirationMonthYear(String monthYear) {
        gg_foodLot_paymentPage.enterCreditCadExpiryDate(monthYear);
    }

    @And("^user enters \"([^\"]*)\" as billing zip code in foodlot$")
    public void userEntersAsBillingZipCode(String zipcode) {
        gg_foodLot_paymentPage.enterPostalCode(zipcode);
    }

    @When("^user clicks pay button$")
    public void user_clicks_pay_button() {
        gg_foodLot_paymentPage.clickPayButton();
    }

}

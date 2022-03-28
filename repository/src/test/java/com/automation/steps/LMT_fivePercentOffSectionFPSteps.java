package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.FivePercentFPPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LMT_fivePercentOffSectionFPSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public FivePercentFPPage fivePercentFPPage = new FivePercentFPPage(driver);


    @Then("user validates the {string} off {string} products in carousel")
    public void user_validates_the_off_products_in_carousel(String string, String string2) {

        fivePercentFPPage.validateOOragnicProductsWidget();
    }

    @Then("user validates the \"{int}% off {string} products in carousel")
    public void user_validates_the_off_products_in_carousel(Integer int1, String string) {
        fivePercentFPPage.validateOpenNatureProductsWidget();
    }

    @When("user enters {string} as name on FP credit card page")
    public void user_enters_as_name_on_fp_credit_card_page(String string) {
        fivePercentFPPage.enterCreditCardNameFP(string);
    }

    @When("user enters {string} as FP credit card number")
    public void user_enters_as_fp_credit_card_number(String string) {
        fivePercentFPPage.enterCreditCardNumberFP(string);
    }

    @When("user enters {string} as FP card expiration month year")
    public void user_enters_as_fp_card_expiration_month_year(String string) {
        fivePercentFPPage.enterCreditExpNumberFP(string);
    }

    @When("user enters {string} as billing zip code on FP credit card page")
    public void user_enters_as_billing_zip_code_on_fp_credit_card_page(String string) {
        fivePercentFPPage.enterZipcodeFP(string);

    }

    @Then("{string} text is displayed on the FP payment screen")
    public void text_is_displayed_on_the_fp_payment_screen(String string) {
        fivePercentFPPage.cvvScreenValidation(string);
    }

}

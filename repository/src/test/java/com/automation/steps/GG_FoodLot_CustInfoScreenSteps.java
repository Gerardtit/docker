package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_FoodLot_CustInfoScreenPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GG_FoodLot_CustInfoScreenSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_FoodLot_CustInfoScreenPage gg_foodLot_custInfoScreenPage = new GG_FoodLot_CustInfoScreenPage(driver);

    @Then("^verify customer info screen appears$")
    public void verify_customer_info_screen_appears() throws InterruptedException {
        gg_foodLot_custInfoScreenPage.verifyCustInfoScreen();
    }

    @And("^verify all fields are working as expected on customer info screen$")
    public void verify_all_fields_are_working_as_expected_on_customer_info_screen() {
        gg_foodLot_custInfoScreenPage.verifyEmail();
        gg_foodLot_custInfoScreenPage.verifyFirstName();
        gg_foodLot_custInfoScreenPage.verifyLastName();
    }

    @When("^user provide customer phone number and clicks on checkout$")
    public void user_provide_customer_phone_number_and_clicks_on_checkout() {
        gg_foodLot_custInfoScreenPage.enterCustPhoneNo();
        gg_foodLot_custInfoScreenPage.clickBFTTermsAndConditionsCheckbox();
        gg_foodLot_custInfoScreenPage.clickCheckoutCTA();
    }

}

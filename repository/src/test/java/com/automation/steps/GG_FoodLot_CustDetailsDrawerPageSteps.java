package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_FoodLot_CustDetailsDrawerPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GG_FoodLot_CustDetailsDrawerPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_FoodLot_CustDetailsDrawerPage gg_foodLot_custDetailsDrawerPage = new GG_FoodLot_CustDetailsDrawerPage(driver);

    @Then("verify customer details drawer screen appears")
    public void verifyCustomerDetailsDrawerScreen() throws InterruptedException {
        gg_foodLot_custDetailsDrawerPage.verifyCustDetailDrawerScreen();
    }

    @And("verify food lot logo on customer details drawer screen")
    public void verifyFoodLotLogoOnDrawerScreen() {
        gg_foodLot_custDetailsDrawerPage.verifyFoodLotLogo();
    }

    @And("verify food lot header on customer details drawer screen")
    public void verifyFoodLotHeaderOnDrawerScreen() {
        gg_foodLot_custDetailsDrawerPage.verifyCustDetailHeader();
    }

    @And("verify first and last name fields appears and enter its values")
    public void verifyFirstLastNameFieldAppearsAndEnterValues() {
        gg_foodLot_custDetailsDrawerPage.verifyFirstNameLastNameField();
        gg_foodLot_custDetailsDrawerPage.enterFirstName("fname");
        gg_foodLot_custDetailsDrawerPage.enterLastName("lname");
    }

    @And("verify Email field is auto-filled and non editable")
    public void verifyEmailFieldAutoFilledAndNonEditable() {
        gg_foodLot_custDetailsDrawerPage.isEmailFieldAutoFilled();
        gg_foodLot_custDetailsDrawerPage.verifyEmailFieldNonEditable();
    }

    @And("verify Confirm CTA button is enabled")
    public void verifyConfirmCTAButtonEnabled() {
        gg_foodLot_custDetailsDrawerPage.isConfirmCTAButtonEnabled();
    }

    @When("user clicks on Confirm CTA button on customer detail drawer screen")
    public void userClicksConfirmCTA() {
        gg_foodLot_custDetailsDrawerPage.clickConfirmCTAButton();
    }

    @Then("verify {string} is displayed at header")
    public void verify_is_displayed_at_header(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify Select date and time will be displayed")
    public void verify_select_date_and_time_will_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("verify Store card is displayed on reserve time screen")
    public void verify_store_card_is_displayed_on_reserve_time_screen() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify {string} is displayed")
    public void verify_is_displayed(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify Selected date and time will be displayed")
    public void verify_selected_date_and_time_will_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    //    @When("go to {string} Tab")
//    public void go_to_tab(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }     //Shradha: This flow is impacting 'user navigate to 'BOGO' Tab' flow in GG_DealsPageSteps.java file. Please rename the step if required.
    @When("user sees a pop-up with View Cart CTA")
    public void user_sees_a_pop_up_with_view_cart_cta() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}

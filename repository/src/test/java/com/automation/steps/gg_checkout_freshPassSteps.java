package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_checkout_freshPassPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class gg_checkout_freshPassSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    GG_checkout_freshPassPage gg_checkout_freshPassPage = new GG_checkout_freshPassPage(driver);

    @And("Verify Fresh Pass banner for new user")
    public void verifyFreshPassBannerForNewUser() {

        gg_checkout_freshPassPage.verifyFreshPassBanner();
    }

    @And("Verify select Plan Screen for new user")
    public void verifySelectPlanScreenForNewUser() {
        gg_checkout_freshPassPage.verifySelectPlanScreen();
        gg_checkout_freshPassPage.verifyAnnualPlanInSelectPlanScreen();
        gg_checkout_freshPassPage.verifyMonthlyPlanInSelectPlanScreen();
        gg_checkout_freshPassPage.verifySignUpButton();
        gg_checkout_freshPassPage.verifyTermsAndConditions();
    }

    @When("user clicks on freshpass banner")
    public void userClicksOnFreshpassBanner() throws Exception {
        gg_checkout_freshPassPage.clickOnFreshPassBanner();
    }

    @And("Verify Fresh Pass banner for reenrol user")
    public void verifyFreshPassBannerForReenrolUser() {
        gg_checkout_freshPassPage.verifyFPBannerReenrollUser();

    }

    @And("Verify select Plan Screen for reenroll user")
    public void verifySelectPlanScreenForReenrollUser() {

        gg_checkout_freshPassPage.verifySelectPlanScreen();
        gg_checkout_freshPassPage.verifyAnnualPlanInSelectPlanScreenReenroll();
        gg_checkout_freshPassPage.verifyMonthlyPlanInSelectPlanScreenReenroll();
        gg_checkout_freshPassPage.verifySignUpButton();
        gg_checkout_freshPassPage.verifyTermsAndConditionsReenrollUser();

    }

    @And("Verify Fresh Pass banner for Active user")
    public void verifyFreshPassBannerForActiveUser() {
        gg_checkout_freshPassPage.verifyFPBannerActiveUser();
    }

    @And("Verify Delivery Fee is FREE")
    public void verifyDeliveryFeeIsFREE() throws Exception {
        gg_checkout_freshPassPage.verifyDeliveryFeeFree();
    }


    @And("Verify Delivery Fee is not FREE")
    public void verifyDeliveryFeeIsNotFREE() {
        gg_checkout_freshPassPage.verifyDeliveryFeeNotFree();
    }

    @And("Selects Annual free trail plan")
    public void selectsAnnualFreeTrailPlan() {
        gg_checkout_freshPassPage.selectAnnualPlanNewUser();
    }

    @When("user taps on signup button on select plan screen")
    public void userTapsOnSignupButtonOnSelectPlanScreen() {
        gg_checkout_freshPassPage.tapOnSignUpButton();
    }

    @Then("Verify Fresh Plan Added banner in checkout screen")
    public void verifyFreshPlanAddedBannerInCheckoutScreen() {
        gg_checkout_freshPassPage.verifyFPPlanAddedBanner();
    }

    @And("Selects Monthly free trail plan")
    public void selectsMonthlyFreeTrailPlan() {
        gg_checkout_freshPassPage.selectMonthlyPlanNewUser();
    }

    @And("Selects Annual plan")
    public void selectsAnnualPlan() {
        gg_checkout_freshPassPage.selectAnnualPlanReenrollUser();
    }

    @Then("user taps on back button in select plan screen")
    public void userTapsOnBackButtonInSelectPlanScreen() {
        gg_checkout_freshPassPage.tapOnBackButton();
    }

    @And("Selects Monthly plan")
    public void selectsMonthlyPlan() {
        gg_checkout_freshPassPage.selectMonthlyPlanReenrollUser();
    }

    @And("verify Delivery fee is Free with FreshPass displayed in order summary")
    public void verifyDeliveryFeeIsFreeWithFreshPassDisplayedInOrderSummary() {
        gg_checkout_freshPassPage.verifyFreeWithFreshPass();
    }


    @And("verify Delivery fee is Free with FreshPass displayed in order confirmation page")
    public void verifyDeliveryFeeIsFreeWithFreshPassDisplayedInOrderConfirmationPage() {
        gg_checkout_freshPassPage.verifyFreeWithFreshPass();
    }

    @And("verify disclaimer for user signed up annual plan")
    public void verifyDisclaimerForUserSignedUpAnnualPlan() {
        gg_checkout_freshPassPage.verifyDisclaimerNewUserAnnual();
    }

    @And("verify Disclaimer for new user signed up for monthly plan")
    public void verifyDisclaimerForNewUserSignedUpForMonthlyPlan() {
        gg_checkout_freshPassPage.verifyDisclaimerNewUserMonthly();
    }

    @And("deselects Annual free trail plan")
    public void deselectsAnnualFreeTrailPlan() {
        gg_checkout_freshPassPage.deSelectAnnualPlan();
    }

    @And("deselects Monthly free trail plan")
    public void deselectsMonthlyFreeTrailPlan() {
        gg_checkout_freshPassPage.deSelectMonthlyPlan();
    }

    @And("verify disclaimer for reenrol user signed up for annaul plan")
    public void verifyDisclaimerForReenrolUserSignedUpForAnnaulPlan() {

        gg_checkout_freshPassPage.verifyDisclaimerReenrollAnnual();
    }

    @And("verify disclaimer for reenrol user signed up for monthly plan")
    public void verifyDisclaimerForReenrolUserSignedUpForMonthlyPlan() {
        gg_checkout_freshPassPage.verifyDisclaimerReenrollMonthly();
    }

    @And("verify Disclaimer for new user signed up for monthly plan in order confirmation screen")
    public void verifyDisclaimerForNewUserSignedUpForMonthlyPlanInOrderConfirmationScreen() {
        gg_checkout_freshPassPage.verifyDisclaimerNewMonthlyOrderConfirmation();
    }

    @And("verify Disclaimer for new user signed up for annual plan in order confirmation screen")
    public void verifyDisclaimerForNewUserSignedUpForAnnualPlanInOrderConfirmationScreen() {
        gg_checkout_freshPassPage.verifyDisclaimerNewAnnualOrderConfirmation();
    }

    @And("enter cvv if cvv screen is displayed")
    public void enterCvvIfCvvScreenIsDisplayed() throws Exception {
        gg_checkout_freshPassPage.enterCVVifDisplayed("123");
    }

    @And("click on continue to payment or Continue to review order Or Save")
    public void clickOnContinueToPaymentOrContinueToReviewOrderOrSave() throws Exception {
        gg_checkout_freshPassPage.clickOnbuttonSlotsScreen();
    }

    @And("go to slots screen")
    public void goToSlotsScreen() throws Exception {
        gg_checkout_freshPassPage.navigateToSlotsscreen();
    }

    @And("verify Disclaimer for new user signed up for monthly plan is not displayed")
    public void verifyDisclaimerForNewUserSignedUpForMonthlyPlanIsNotDisplayed() {
        gg_checkout_freshPassPage.verifyDisclaimerMonthlyPlanNotDisplay();
    }

    @And("verify disclaimer for user signed up annual plan is not displayed")
    public void verifyDisclaimerForUserSignedUpAnnualPlanIsNotDisplayed() {
        gg_checkout_freshPassPage.verifidisclaimerAnnualPlanNotDisplay();
    }

}

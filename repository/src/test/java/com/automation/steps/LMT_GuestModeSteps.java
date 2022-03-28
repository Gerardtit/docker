package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pageElements.HomePageElements;
import com.automation.pages.GG_OtpPasswordPage;
import com.automation.pages.SignInPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LMT_GuestModeSteps<cart> {


    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_OtpPasswordPage otpPasswordPage = new GG_OtpPasswordPage(driver);
    public SignInPage signInPage = new SignInPage(driver);

    public HomePageElements homePageElements = new HomePageElements();


    @Then("user landed on onboarding screen")
    public void user_landed_on_onboarding_screen() {
        otpPasswordPage.validateOnboardingScreen();
    }

    @Then("user validates Guest mode CTA in Mobile workflow")
    public void user_validates_guest_mode_cta_in_mobile_workflow() {
        otpPasswordPage.validatesGuestModeCTA();
    }

    @When("user clicks on CTA continue as guest")
    public void user_clicks_on_cta_continue_as_guest() {
        otpPasswordPage.clickOnContinueAsGuest();
    }

    @When("user relaunch the application")
    public void user_relaunch_the_application() {
        otpPasswordPage.reLaunchApp();
    }

    @When("user clicks on Email workflow")
    public void user_clicks_on_email_workflow() {
        otpPasswordPage.tapOnEmail();
    }

    @Then("user validates Guest mode CTA in Email workflow")
    public void user_validates_guest_mode_cta_in_email_workflow() {
        otpPasswordPage.validatesGuestModeCTA();
    }

    @Then("user lands on sign in to continue screen")
    public void user_lands_on_sign_in_to_continue_screen() {
        signInPage.validatesSignInContinueScreen();
    }

    @When("user clicks on the product and clicks add to cart")
    public void clickProductToAdd() {
        signInPage.clickProduct();
    }

    @When("user clicks on Reserve a time on Home page")
    public void userClicksOnReserveATimeOnHomePage() {
        signInPage.clickOnReserveaTime();
    }

    @When("user clicks on Hamburger menu on Home page")
    public void userClicksOnHamburgerMenuOnHomePage() {
        signInPage.clickOnHamburgerMenu();
    }

    @When("user clicks on Sign in button in Hamburger menu")
    public void userClicksOnSignInButtonInHamburgerMenu() {
        signInPage.clickOnSignInHamburgerMenu();
    }
}

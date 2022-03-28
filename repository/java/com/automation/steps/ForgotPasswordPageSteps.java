package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.ForgotPasswordPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;

public class ForgotPasswordPageSteps {
    AppiumDriver driver = AppiumDriverManager.getDriver();
    public ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

    @Then("^forgot password page is displayed$")
    public void forgotPasswordPageIsDisplayed() {
        forgotPasswordPage.waitForForgotPasswordPageDisplayed();
    }

    @When("^user enters \"([^\"]*)\" on forgot password page$")
    public void userEntersOnForgotPasswordPage(String arg0) throws Throwable {
        forgotPasswordPage.enterEmail(arg0);
    }

    @And("^user click next button on forgot password page$")
    public void userClickNextButtonOnForgotPasswordPage() {
        forgotPasswordPage.clickNextButton();
    }

    @Then("^verify Password Reset Email Sent displayed$")
    public void verifyPasswordResetEmailSentDisplayed() {
        forgotPasswordPage.waitForPasswordResetDisplayed();
    }
}

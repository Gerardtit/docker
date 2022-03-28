package com.automation.steps;

import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.manager.ConfigFileManager;
import com.automation.pages.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;

import java.util.Map;

public class SignInPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public SignInPage signInPage = new SignInPage(driver);
    public StartUpPage startUpPage = new StartUpPage(driver);
    private String[] banners = {"safeway", "vons"};


    public String getCurrentBanner() {
        return driver.getCapabilities().getCapability("banner").toString();
    }

    public String getCurrentEnv() {
        return driver.getCapabilities().getCapability("env").toString();
    }


    @Given("^user launch app$")
    public void user_launch_app() {
        startUpPage.clickContinue();
    }

    @Then("^sign in page is displayed$")
    public void sign_in_page_is_displayed() {
        signInPage.waitForSignInPageDisplayed();
    }

    @When("^user enters \"([^\"]*)\" in username field on Sign In page$")
    public void user_enters_in_username_field_on_Sign_In_page(String arg1) throws Throwable {
        if (arg1.equalsIgnoreCase("email")) {
            signInPage.enterUsername(AppiumDeviceManager.getDevice().getAccountUser());
        } else {
            signInPage.enterUsername(arg1);
        }
    }

    @When("^user enters \"([^\"]*)\" in password field on Sign In page$")
    public void user_enters_in_password_field_on_Sign_In_page(String arg1) throws Throwable {
        if (arg1.equalsIgnoreCase("password")) {
            signInPage.enterPassword("Pass1234");
        } else {
            signInPage.enterPassword(arg1);
        }
    }

    @When("^user clicks sign in on sign in page$")
    public void user_clicks_sign_in_on_sign_in_page() throws Throwable {
        signInPage.clickSignIn();
    }

    @When("^user clicks CreateAccount on Sign In Page$")
    public void user_clicks_CreateAccount_on_Sign_In_Page() throws Throwable {
        signInPage.clickCreateAccountButton();
    }

    @When("^user click forgot password link on Sign In page$")
    public void userClickForgotPasswordLinkOnSignInPage() {
        signInPage.clickForgotPasswordLink();

    }

    @When("^user enters different banner \"([^\"]*)\" in username field on Sign In page$")
    public void userEntersDifferentBannerInUsernameFieldOnSignInPage(String arg0) throws Throwable {
        String banner = getCurrentBanner();
        for (String brand : banners) {
            if (banner.equalsIgnoreCase(brand)) {
                continue;
            } else {
                banner = brand;
                break;
            }

        }
        signInPage.enterUsername(ThreadLocalHelper.testCaseData.get().get("USERNAME"));
    }

    @When("^user close application and relaunch$")
    public void userCloseApplicationAndRelaunch() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        MenuPage menuPage = new MenuPage(driver);
        SelectOrderTypePage selectOrderTypePage = new SelectOrderTypePage(driver);
        signInPage.closeAndRelaunch();
    }

    @Then("^verify email and password mismatch error message is displayed$")
    public void verifyEmailAndPasswordMismatchErrorMessageIsDisplayed() {
        signInPage.waitForInvalidPasswordError();
    }

    @Then("^verify no account record error message is displayed on forgot password page$")
    public void verifyNoAccountRecordErrorMessageIsDisplayedOnForgotPasswordPage() {
        signInPage.verifyNoRecordError();
    }

    @Then("^verify next button is not enabled for send forgot password email$")
    public void verifyNextButtonIsNotEnabledForSendForgotPasswordEmail() {
        Assert.assertFalse(signInPage.forgotPasswordNextButtonEnabled());
    }

    @When("^user clicks cancel from signin page$")
    public void userClicksCancelFromSigninPage() {
        signInPage.clickCancelButton();

    }
}

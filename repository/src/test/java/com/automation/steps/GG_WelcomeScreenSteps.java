package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_WelcomePage;
import com.automation.pages.HomePage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class GG_WelcomeScreenSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_WelcomePage welcomePage = new GG_WelcomePage(driver);

    public HomePage homePage = new HomePage(driver);
    // public FindStorePage findStorePage = new FindStorePage(driver);


    @Then("^Click on Get Started Button$")
    public void clickGetStartedBtn() throws Throwable {
        Assert.assertTrue(welcomePage.waitForWelcomeScreenDisplayed());
        Thread.sleep(2000);
        welcomePage.clickGetStartedBtn();
    }

    @And("^allow push notification permission$")
    public void allowPushNotificationPermission() throws InterruptedException {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Thread.sleep(3000);
            welcomePage.clickAllowNotificationButton();
            //    welcomePage.clickAllowInNotificaitonPopUp();
            Thread.sleep(5000);
        } else {
            Thread.sleep(5000);
            welcomePage.clickAllowNotificationButton();

        }
    }


    @Then("^Verify the Welcome Title is visible$")
    public void verifyWelcomeTitle() throws Throwable {

        welcomePage.waitForWelcomeScreenDisplayed();
    }

    @Then("^Verify the Welcome Text is visible$")
    public void verifyWelcomeText() throws Throwable {

        welcomePage.verifyWelcomeText();
    }


    @When("^authenticate the app$")

    public void authenticateTheApp() throws IOException {
        if (welcomePage.isSignInButtonDisplayed(10)) {
            if (welcomePage.isContinueButtonDisplayed(3)) {
                welcomePage.clickContinueButton();
            }
            welcomePage.enterUsername();
            welcomePage.enterPassword();
            welcomePage.clickSignInButton();
        } else {
            welcomePage.clickContinueButton();
        }
    }

    @Then("^Verify First Image is Displayed$")
    public void verifyImageOneIsDisplayed() {
        welcomePage.isFirstImageDisplayed();
//        Assert.assertTrue(welcomePage.isFirstImageDisplayed());
    }

    @Then("^Verify Second Image is Displayed$")
    public void verifySecondImageIsDisplayed() {
        welcomePage.isSecondImageDisplayed();
//        Assert.assertTrue(welcomePage.isSecondImageDisplayed());
    }

    @Then("^Verify Third Image is Displayed$")
    public void verifyThirdImageIsDisplayed() {
        welcomePage.isThirdImageDisplayed();
//        Assert.assertTrue(welcomePage.isThirdImageDisplayed());
    }

    @Then("^Verify Fourth Image is Displayed$")
    public void verifyFourthImageIsDisplayed() {
        welcomePage.isFourthImageDisplayed();
//        Assert.assertTrue(welcomePage.isFourthImageDisplayed());
    }

    @Then("^Verify Images are Scrollable$")
    public void verifyFourImagesAreScrollable() {
        welcomePage.isFourImagesAreScrollable();
    }

    @Then("^verify Let's Get Started CTA is Displayed$")
    public void verifyLetsGetStartedCTA() {
        welcomePage.isLetsGetStartedButtonDisplayed();
    }

    @Then("^click on Let's Get Started Button$")
    public void clickOnLetsGetStartedButton() {
        welcomePage.clickOnLetsGetStaretedButton();
    }

    @Then("^verify Welcome Screen post splash is Displayed$")
    public void verifyWelcomeScreenIsDisplayed() {
        welcomePage.isLetsGetStartedButtonDisplayed();
    }

    @Then("^verify Navigated to Next Page$")
    public void verifyNavigatedToNextPage() {

        welcomePage.isNextPageDisplayed();
    }

    @Then("^verify A little difference A lot easier title is displayed$")
    public void verifyALittleDifferenceALotEasierTitleIsDisplayed() {
        welcomePage.isALittleDifferenceALotEasierTitleDisplayed();
    }

    @When("^click on close button in app to app sign in$")
    public void clickOnCloseButtonInAppToAppSignIn() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            welcomePage.clickCloseButton();
        }
    }

    @Then("^welcome page message is displayed$")
    public void welcomePageMessageIsDisplayed() {
        Assert.assertTrue(welcomePage.isWelcomeScreenMessageDisplayed(), "The welcome page is not displayed");
    }

    @Then("^verify Allow notification button is displayed$")
    public void verifyAllowPushNotificationDisplayed() {
        welcomePage.isAllowPushNotificationDisplayed();
//        Assert.assertTrue(welcomePage.isAllowPushNotificationDisplayed(), "Allow push notification is not displayed");
    }

    @Then("^verify Not right now cta is displayed$")
    public void verifyNotRightNowCTADisplayed() {
        Assert.assertTrue(welcomePage.isNotRightNowPushNotificationDisplayed(), "Not right now cta is not displayed");
    }

    @Then("^click on allow notification button$")
    public void clickOnAllowNotification() {
        welcomePage.clickOnAllowNotificationButton();
    }

    @Then("^click allow on push notification permission popup$")
    public void allowNotificationPermissionPopUp() {
        welcomePage.allowNotificationPermissionPopUp();
    }

    @Then("^verify Allow notification button is not displayed$")
    public void verifyAllowPushNotificationIsNotDisplayed() {
        welcomePage.isAllowPushNotificationDisplayed();
//        Assert.assertFalse(welcomePage.isAllowPushNotificationDisplayed(), "Allow push notification is displayed");
    }

    @Then("^verify permission pop up is displayed$")
    public void verifyPermissionPopupDisplayed() {
        welcomePage.isPermissionPopupDisplayed();
//        Assert.assertFalse(welcomePage.isPermissionPopupDisplayed(), "Allow push notification is displayed");
    }

    @Then("^click Dont Allow on push notification permission popup$")
    public void clickDontAllowNotification() {
        welcomePage.dontAllowNotificationPermissionPopUp();
    }

    @Then("^click on Not right now cta$")
    public void clickOnNotRightNowCTA() {
        welcomePage.clickNotRightNowNotificationButton();
    }


}

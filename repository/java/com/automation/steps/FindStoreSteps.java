package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.FindStorePage;
import com.automation.pages.LocalStorePage;

import com.automation.pages.WelcomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;

public class FindStoreSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public FindStorePage findStorePage = new FindStorePage(driver);
    public WelcomePage welcomePage = new WelcomePage(driver);

    @When("^Verify Find your local store screen is visible$")
    public void verifyFindStoreScreen() throws Throwable {

        findStorePage.waitForFindStoreScreenDisplayed();
    }

    @Then("^Tap on Share my Location Button$")
    public void clickShareLocationBtn() throws Throwable {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            findStorePage.clickShareLocationBtn();
        } else {
            Boolean allowNotificationButton = welcomePage.getAllowNotificationButton();
            if (allowNotificationButton) {
                welcomePage.clickAllowNotificationButton();
                welcomePage.clickAllowInNotificaitonPopUp();
                findStorePage.clickShareLocationBtn();
            } else {
                findStorePage.clickShareLocationBtn();
            }
        }
    }


    @Then("^The share location permission popup should appear$")
    public void verifyPopup() throws Throwable {
        findStorePage.waitForAllowPermissionPopupDisplayed();
    }

    @When("^Click on Dont Allow button$")
    public void clickDenyBtn() throws Throwable {

        findStorePage.clickDontAllowBtn();
    }

    @When("^Click on Allow share location button$")
    public void clickAllowBtn() throws Throwable {

        findStorePage.clickAllowBtn();
        ;
    }

    @Then("^User should remain in the Find Local Store screen$")
    public void verifyFindLocalStoreScreen() throws Throwable {

        findStorePage.waitForFindStoreScreenDisplayed();
        ;
    }

    @Then("^Select Dont Ask Again check box in popup$")
    public void selectDontAskAgain() throws Throwable {

        findStorePage.selectDontAskAgain();
    }

    @Then("^User should not see sharing permission popup$")
    public void verifyPopupNotDisplayed() throws Throwable {

        findStorePage.verifyPermissionPopupDisplayed();
    }

    @Then("^verify location permission pop up state$")
    public void verifyLocationPermissionPopUpState() throws InterruptedException {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            findStorePage.selectDontAskAgain();
            findStorePage.clickDontAllowBtn();
            Thread.sleep(2000);
            findStorePage.clickShareLocationBtn();
//			findStorePage.verifyPermissionPopupDisplayed();
            Assert.assertTrue(findStorePage.verifyPermissionPopupDisplayed());
        } else {
            findStorePage.verifyDefaultLocationPreferencePopup();
        }
    }
}

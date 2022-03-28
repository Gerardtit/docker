package com.automation.steps;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.SelectOrderTypePage;
import com.automation.pages.SignInPage;
import com.automation.pages.Temp_signInPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;


public class AddAddress_OrderPageSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public AppiumDevice device = AppiumDeviceManager.getDevice();
    Temp_signInPage pageElements = new Temp_signInPage(driver);
    SignInPage signInPage = new SignInPage(driver);
    SelectOrderTypePage selectOrderTypePage = new SelectOrderTypePage(driver);

    public String getCurrentBanner() {
        return driver.getCapabilities().getCapability("banner").toString();
    }

    public String getCurrentEnv() throws IOException {
        return driver.getCapabilities().getCapability("env").toString();
    }

    @When("^user clicks Maybe Later$")
    public void MaybeLater() {
        pageElements.clickMaybeLater();
    }

    @When("^user enter \"([^\"]*)\" in username field on Sign In page$")
    public void userEntersDifferentBannerInUsernameFieldOnSignInPage(String arg0) throws Throwable {

        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            signInPage.enterUsername(ThreadLocalHelper.testCaseData.get().get("LOGIN_USERNAME"));
        } else if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            signInPage.enterUsername(ThreadLocalHelper.testCaseData.get().get("LOGIN_USERNAME"));
        }

    }


    @When("^user enter \"([^\"]*)\" in password field on Sign In page$")
    public void user_enters_in_password_field_on_Sign_In_page(String arg1) throws Throwable {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            signInPage.enterPassword(ThreadLocalHelper.testCaseData.get().get("LOGIN_PASSWORD"));
        } else if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            signInPage.enterPassword(ThreadLocalHelper.testCaseData.get().get("LOGIN_PASSWORD"));
        }
    }

    @When("^user clicks continue for CacheText$")
    public void user_clicks_continue_message_on_signin_page() {

        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            pageElements.ClickCacheText();
            pageElements.ClickNextButton();
        } else if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            pageElements.ClickCacheText();
            pageElements.ClickDismiss();
            pageElements.clickNextPopup();
        }

    }

    @When("^user clicks Shopping mode option on home page$")
    public void user_clicks_Shopping_mode_option_on_home_page() {
        pageElements.ClickShoppingMode();
    }

    @And("^user enter zipcode and search in zipcode field$")
    public void userEntersZipcodeAndSearchInZipcodeField() throws IOException, InterruptedException {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            pageElements.enterZipCode(ThreadLocalHelper.testCaseData.get().get("LOGIN_ZIPCODE"));
            pageElements.clickSearchButton();
        } else if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            pageElements.enterZipCode(ThreadLocalHelper.testCaseData.get().get("LOGIN_ZIPCODE"));
        }
    }

    @When("^user clicks Instore on select order type page$")
    public void userClicksInstoreOnDeliverySelectPage() {
        try {
            pageElements.selectInStoreDeliveryOpion();
        } catch (Exception e) {
        }
        pageElements.selectInstoreTomThumb();
    }


    @When("^user clicks start shopping button on Sign In page$")
    public void user_click_start_shopping_button_on_Sign_In_page() throws Throwable {
        try {
            pageElements.clickStartShopping();
        } catch (Exception e) {
        }
    }


    @Then("^Home page is displayed$")
    public void home_page_displayed() throws Throwable {
//        Thread.sleep(2000);
        pageElements.waitForHomePageDisplayed();
    }

    @Then("^Zipcode page is displayed$")
    public void zipcode_page_is_displayed() throws Throwable {
        pageElements.waitForZipCodePageDisplayed();
    }

}


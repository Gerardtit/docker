package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.entities.BannerConfType;
import com.automation.pages.ZipCodePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;

public class ZipCodePageSteps {
    AppiumDevice device = AppiumDeviceManager.getDevice();
    AppiumDriver driver = AppiumDriverManager.getDriver();
    public ZipCodePage zipCodePage = new ZipCodePage(driver);

    @Then("^zipcode page is displayed$")
    public void zipcode_page_is_displayed() throws Throwable {
        zipCodePage.waitForZipCodePageDisplayed();
    }

    @When("^user clicks Sign in button on zipcode page$")
    public void user_clicks_Sign_in_button_on_zipcode_page() throws Throwable {
        zipCodePage.clickSignInButton();
    }

    @When("^user enters \"([^\"]*)\" in zipcode page$")
    public void user_enters_in_zipcode_page(String zipcode) throws Throwable {
        if (zipcode.equalsIgnoreCase("zipcode")) {
            zipCodePage.enterZipCode(device.getZipCode());
        } else if (zipcode.equalsIgnoreCase("zipcode_diff")) {
            zipCodePage.enterZipCode(device.getConfigureData(BannerConfType.BANNER_ZIPCODE_DIFF));
        } else {
            zipCodePage.enterZipCode(zipcode);
        }
    }

    @When("^user clicks next button on zipcode page$")
    public void user_clicks_next_button_on_zipcode_page() throws Throwable {
        zipCodePage.clickNextButton();
    }

    @When("^user clicks use current location on zipcode page$")
    public void userClicksUseCurrentLocationOnZipcodePage() {
        zipCodePage.clickUseMyLocation();
    }

    @Then("^non-service zip code page is displayed$")
    public void nonServiceZipCodePageIsDisplayed() {
        zipCodePage.waitForNonServiceZipCodePageDisplayed();
    }

    @When("^user enter \"([^\"]*)\" and click next to register on non-service zipcode page$")
    public void userEnterAndClickNextToRegisterOnNonServiceZipcodePage(String email) throws Throwable {
        zipCodePage.enterEmail(email);
    }

    @Then("^service email confirmation is displayed on zipcode page$")
    public void serviceEmailConfirmationIsDisplayedOnZipcodePage() {
        zipCodePage.waitForNonServiceConfirmationPage();
    }

    @And("^user click next button on non-service zipcode page$")
    public void userClickNextButtonOnNonServiceZipcodePage() {
        zipCodePage.emailTextNextButton();
    }

    @And("^user clicks next button after registration on zipcode page$")
    public void userClicksNextButtonAfterRegistrationOnZipcodePage() {
        zipCodePage.clickNextAfterRegistration();
    }
}

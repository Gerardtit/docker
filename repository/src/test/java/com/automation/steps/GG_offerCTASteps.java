package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_offerCTAPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class GG_offerCTASteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_offerCTAPage contactinfoPage = new GG_offerCTAPage(driver);
    AppiumDevice device = AppiumDeviceManager.getDevice();

    @And("user clicks on weekly ad coupons at homepage")
    public void userClicksOnWeeklyAdCouponsAtHomepage() {
        contactinfoPage.weeklyadHomepage();
    }

    @Then("validate Added text is displayed on dealspage")
    public void validateAddedTextIsDisplayedOnDealspage() {
        contactinfoPage.addedtext();
    }

    @Then("validate Added text is displayed")
    public void validateAddedTextIsDisplayed() {
        contactinfoPage.clickproduct();
        contactinfoPage.validatetext();
    }
}

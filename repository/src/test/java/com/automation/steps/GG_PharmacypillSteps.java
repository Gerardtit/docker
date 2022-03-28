package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_PharmacypillPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class GG_PharmacypillSteps {

    AppiumDevice device = AppiumDeviceManager.getDevice();
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_PharmacypillPage gg_pharmacypillPage = new GG_PharmacypillPage(driver);


    @Then("user clicks on pharmacy pill")
    public void userClicksOnPharmacyPill() {
        gg_pharmacypillPage.pharmacypill();
    }

    @And("user is at Pharmacy page")
    public void userIsAtPharmacyPage() {
        gg_pharmacypillPage.pharmacyPage();
    }
}


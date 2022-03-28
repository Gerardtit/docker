package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.BasePage;
import com.automation.pages.GG_Dashboard_MoreServicesPage;
import com.automation.pages.GG_SelectStorePage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.IOException;

public class GG_Dashboard_MoreServicesSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_Dashboard_MoreServicesPage dashboardMoreServicesPage = new GG_Dashboard_MoreServicesPage(driver);
    public GG_SelectStorePage selectStorePage = new GG_SelectStorePage(driver);
    public BasePage basePage = new BasePage(driver);

    @And("^scroll down upto more services$")
    public void scrollDownUptoMoreServices() throws InterruptedException {
        dashboardMoreServicesPage.scrollDownUptoMoreServices();
    }

    @And("^scroll up to more services$")
    public void scrollUptoMoreServices() {
        dashboardMoreServicesPage.scrollUptoMoreServices();
    }

    @Then("^verify delivery & pick up pod is displayed$")
    public void verifyDeliveryPickUpPodIsDisplayed() {
        Assert.assertTrue(dashboardMoreServicesPage.verifyDeliveryPickUpPod(), "Delivery & Pick Up pod is not displayed");
    }

    @Then("^verify Pharmacy pod is displayed$")
    public void verifyPharmacyPodIsDisplayed() throws IOException {
        Assert.assertTrue(dashboardMoreServicesPage.verifyPharmacyPod(), "Pharmacy pod is not displayed");
    }

    @Then("^verify Fuel pod is displayed$")
    public void verifyFuelPodIsDisplayed() throws IOException {
        Assert.assertTrue(dashboardMoreServicesPage.verifyFuelPod(), "Fuel pod is not displayed");
    }

    @Then("^verify both fuel and pharmacy pods are displayed$")
    public void verifyFuelPharmacyPodsAreDisplayed() throws IOException {
        Assert.assertTrue(dashboardMoreServicesPage.verifyPharmacyFuelPods(), "Fuel and pharmacy pods are not displayed");
    }

    @Then("^change the store$")
    public void changeTheStore() {
        selectStorePage.chooseNthStoreFromStoreList(1);
    }

    @Then("^verify more services module is displayed$")
    public void verifyMoreServicesModuleIsDisplayed() {
        Assert.assertTrue(dashboardMoreServicesPage.verifyMoreServicesModule(), "More services module is not present");
    }

    @Then("^Scroll Up To Shopping Mode Arrow$")
    public void scrollUpToShoppingModeArrow() {
        dashboardMoreServicesPage.scrollUpToShoppingModeArrow();
    }

    @Then("^verify we can help section is present$")
    public void verifyWeCanHelpSectionIsPresent() {
        Assert.assertTrue(dashboardMoreServicesPage.verifyWeCanHelpSectionIsPresent());
    }

}

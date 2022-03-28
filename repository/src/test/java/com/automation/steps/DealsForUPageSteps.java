package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.DealsForUPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DealsForUPageSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public AppiumDevice device = AppiumDeviceManager.getDevice();
    DealsForUPage dealsForUPage = new DealsForUPage(driver);

    @When("user clicks on Deals page")
    public void user_clicks_on_Deals_page() {
        dealsForUPage.clickOnDealsTab();
    }

    @Then("user is landed on Deals page")
    public void user_is_landed_on_Deals_page() {
        dealsForUPage.validateDealsPage();
    }

    @And("user clicks on for U page")
    public void user_clicks_on_for_U_page() {
        dealsForUPage.clickOnForU();
    }

    @Then("user is landed on for U page")
    public void user_is_landed_on_for_U_page() {
        dealsForUPage.validateForU();
    }

}

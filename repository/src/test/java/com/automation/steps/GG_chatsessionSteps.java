package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_ChatsessionPage;
import com.automation.pages.GG_DealsPage;
import com.automation.pages.GG_SaveCategoryPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GG_chatsessionSteps {


    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_SaveCategoryPage categoryPage = new GG_SaveCategoryPage(driver);
    public GG_DealsPage dealsPage = new GG_DealsPage(driver);
    public GG_ChatsessionPage chatsessionPage = new GG_ChatsessionPage(driver);
    AppiumDevice device = AppiumDeviceManager.getDevice();

    @Then("user clicks on edit box")
    public void userClicksOneditbox() {
        chatsessionPage.editbox();
    }

    @And("user types {string}")
    public void userTypes(String arg0) {
        chatsessionPage.textyped(arg0);
    }

    @And("verify see Results text is displayed")
    public void verifyTextIsDisplayed() {
        chatsessionPage.seeresult();
    }

    @And("verify specific text is displayed")
    public void verifyspecificTextIsDisplayed() {
        chatsessionPage.viewProduct();
    }

    @And("user clicks See results")
    public void userClicks() throws Exception {
        chatsessionPage.resultclicked();
    }

    @And("user clicks View Product Details for specific product")
    public void userClicksspecificproductview() {
        chatsessionPage.viewclicked();
    }

    @Then("user clicks on edittime")
    public void userClicksOnEdittime() {
        chatsessionPage.edittime();
    }

    @Then("user clicks confirmchanges tab")
    public void userClicksConfirmchangesTab() {
        chatsessionPage.confirmtab();
    }

    @When("user enters {string}")
    public void userEnters(String arg0) {
        chatsessionPage.zipcodeentered(arg0);
    }

    @When("user click back button or cancel button")
    public void userClickBackButtonOrCancelButton() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            categoryPage.clickBackBtn();
        }
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            dealsPage.clickCancelButtonOnSearchScreen();
        }
    }
}

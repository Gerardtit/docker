package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.DealsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;

public class DealsPageSteps {
    AppiumDriver driver = AppiumDriverManager.getDriver();
    public DealsPage dealsPage = new DealsPage(driver);

    @Then("^deals page is displayed$")
    public void dealsPageIsDisplayed() {
        dealsPage.waitForPageDisplayed();
    }

    @When("^user clicks back button on deals page$")
    public void userClicksBackButtonOnDealsPage() {
        dealsPage.clickBackButton();
    }

    @When("^user clicks Promo Code Deals on deals page$")
    public void userClicksPromoCodeDealsOnDealsPage() {
        dealsPage.clickPromoCode();
    }

    @Then("^promo code deals window is displayed$")
    public void promoCodeDealsWindowIsDisplayed() {
        dealsPage.waitForPromoCodeWindowDisplayed();
    }

    @When("^user clicks Club Card Deals on deals page$")
    public void userClicksClubCardDealsOnDealsPage() {
        dealsPage.clickClubCard();
    }

    @When("^user clicks Buy one get one free on deals page$")
    public void userClicksBuyOneGetOneFreeOnDealsPage() {
        dealsPage.clickBuyOneGetOneFree();
    }

    @Then("^club card deals window is displayed$")
    public void clubCardDealsWindowIsDisplayed() {
        dealsPage.waitForClubCardDealsWindowDisplayed();
    }

    @Then("^buy one get on free window is displayed$")
    public void buyOneGetOnFreeWindowIsDisplayed() {
        dealsPage.waitForBuyOneGetOneFreeDisplayed();
    }


    @When("^user clicks search icon from deals page$")
    public void userClicksSearchIconFromDealsPage() {
        dealsPage.clickSearchIcon();
    }

    @And("^buy one get on free text is displayed on the screen$")
    public void buyOneGetOnFreeTextIsDisplayedOnTheScreen() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            dealsPage.containTextDisplayed("Buy One Get One Free");
        } else {
            dealsPage.containTextDisplayed("Buy One, Get One Free");
        }
    }
}

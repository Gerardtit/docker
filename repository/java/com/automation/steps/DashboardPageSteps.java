package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.DashboardPage;
import com.automation.pages.LocalStorePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;

public class DashboardPageSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public DashboardPage dashboardPage = new DashboardPage(driver);
    public LocalStorePage localStorePage = new LocalStorePage(driver);


    @Then("^verify home screen is displayed$")
    public void verifyHomeScreenIsDisplayed() {
        dashboardPage.verifyGreetingInfo();
    }

    @Then("^verify deal card present in personalised section$")
    public void verifyDealCardPresentInPersonalisedSection() {
        dashboardPage.verifyDealCardDescription();
    }

    @Then("^personalised section title is displayed$")
    public void personalisedSectionTitleIsDisplayed() {
        dashboardPage.verifyPersonalisedSectionTitle();
    }

    @When("^tap on store location detail$")
    public void tapOnStoreLocationDetail() {
        dashboardPage.clickStoreLocationDetail();
    }

    @Then("^loader displayed in home screen$")
    public void loaderDisplayedInHomeScreen() {
        dashboardPage.verifyLoader();
    }

    @Then("^reward information is displayed$")
    public void rewardInformationIsDisplayed() {
        dashboardPage.verifyRewardInformation();
    }

    @Then("^verify Home tab bar is displayed$")
    public void verifyHomeTabBarIsDisplayed() {
        dashboardPage.verifyHomeTab();
    }

    @Then("^verify Deals tab bar is displayed$")
    public void verifyDealsTabBarIsDisplayed() {
        dashboardPage.verifyDealsTab();
    }

    @Then("^verify Mylist tab bar is displayed$")
    public void verifyMylistTabBarIsDisplayed() {
        dashboardPage.verifyMylistTab();
    }

    @Then("^verify Wallet tab bar is displayed$")
    public void verifyWalletTabBarIsDisplayed() {
        dashboardPage.verifyWalletTab();
    }

    @When("^go to Deals tab$")
    public void goToDealsTab() {
        dashboardPage.clickDealsTab();
    }

    @When("^go to Mylist tab$")
    public void goToMylistTab() {
        dashboardPage.clickMylistTab();
    }

    @When("^go to Wallet tab$")
    public void goToWalletTab() {
        dashboardPage.clickWalletTab();
    }

    @When("^go to Home tab$")
    public void goToHomeTab() {
        dashboardPage.clickHomeTab();
    }

    @Then("^verify deals screen is displayed$")
    public void verifyDealsScreenIsDisplayed() {
        dashboardPage.verifyDealSectionHeader();
    }

    // Need to move mylist page steps definitions
    @Then("^verify mylist screen is displayed$")
    public void verifyMylistScreenIsDisplayed() {
        dashboardPage.verifyAddNewItemButton();
    }

    // Need to move wallet page steps definitions
    @Then("^verify wallet screen is displayed$")
    public void verifyWalletScreenIsDisplayed() {
        // Not yet implemeted.
    }

    @Then("^verify search bar is displayed$")
    public void verifySearchBarIsDisplayed() {
        dashboardPage.verifySearchBar();
    }

    @Then("^verify scan icon is displayed in search bar section$")
    public void verifyScanIconIsDisplayedInSearchBarSection() {
        dashboardPage.verifyScanIcon();
    }

    @Then("^verify see all option is displayed$")
    public void verifySeeAllOptionIsDisplayed() {
        dashboardPage.verifySeeAll();
    }

    @Then("^verify personalised section title static text$")
    public void verifyPersonalisedSectionTitleStaticText() {
        dashboardPage.verifyPersonalisedSectionTitleText();

    }

}

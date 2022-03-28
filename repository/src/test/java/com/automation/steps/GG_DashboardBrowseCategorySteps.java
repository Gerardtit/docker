package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.BasePage;
import com.automation.pages.GG_DashboardBrowseCategoryPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GG_DashboardBrowseCategorySteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_DashboardBrowseCategoryPage dashboardBrowseCategoryPage = new GG_DashboardBrowseCategoryPage(driver);
    public BasePage basePage = new BasePage(driver);

    @Then("^verify multiple cards displayed on browse category module$")
    public void verifyMultipleCardsDisplayedOnBrowseCategoryModule() {
        dashboardBrowseCategoryPage.verifyBrowseCategory();
    }

    @Then("^verify see all button is displayed$")
    public void verifySeeAllButtonIsDisplayed() {
        dashboardBrowseCategoryPage.verifySeeAll();
    }

    @When("^click see all in browse category$")
    public void clickSeeAll() {
        dashboardBrowseCategoryPage.clickSeeAll();
    }

    @Then("^verify category card name is displayed$")
    public void verifyCategoryCardNameIsDisplayed() {
        Assert.assertTrue(!dashboardBrowseCategoryPage.getCategoryName().isEmpty(), "Category name is not displayed on category card");
    }

    @Then("^verify category card image is displayed$")
    public void verifyCategoryCardImageIsDisplayed() {
        dashboardBrowseCategoryPage.verifyCardImage();
    }

    @Then("^verify browse category section title$")
    public void verifyBrowseCategorySectionTitle() {
        dashboardBrowseCategoryPage.verifyBrowseCategorySectionTitle();
    }

    @And("^scroll down upto browse category$")
    public void scrollDownToBrowseCategory() {

        Assert.assertTrue(dashboardBrowseCategoryPage.scrollDownToBrowseCategory(), "Browse categories module is not displayed on dashboard");
        //dashboardBrowseCategoryPage.scrollDownBySmallAmount();

    }

    @When("^click on category card$")
    public void clickOnCategoryCard() {
        dashboardBrowseCategoryPage.clickCardName();
    }

    @And("^click back button$")
    public void clickBackButton() {
        dashboardBrowseCategoryPage.clickBackButtonInDetailsPage();
    }

    @And("^click back button in checkout page$")
    public void clickBackButtonCheckoutPage() {
        dashboardBrowseCategoryPage.clickBackButtonCheckoutPageInDetailsPage();
    }

    @Then("^verify refine button in category details page$")
    public void verifyRefineButtonInCategoryDetailsPage() {
        dashboardBrowseCategoryPage.verifyRefineButton();
    }


    @Then("^verify carousel view in browse Category$")
    public void verifyCarouselViewInBrowseCategory() throws InterruptedException {
        Assert.assertTrue(dashboardBrowseCategoryPage.hasCarouselViewCategories("LEFT"), "Browse categories cards doesn't have a carousel view");
    }

    @Then("^verify category cards movement from left to right$")
    public void verifyCategoryCardsMovementFromLeftToRight() throws InterruptedException {
        dashboardBrowseCategoryPage.verifyCategoryCardsMovementFromLeftToRight();
    }

    @Then("^verify category cards movement from right to left$")
    public void verifyCategoryCardsMovementFromRightToLeft() throws InterruptedException {
        dashboardBrowseCategoryPage.verifyCategoryCardsMovementFromRightToLeft();
    }

    @Then("^verify browse category section is displayed$")
    public void verifyBrowseCategorySectionDisplayed() {
        Assert.assertTrue(dashboardBrowseCategoryPage.getCategoriesCountOnBrowsePage() > 1);
    }

    @Then("^verify Browse page is displayed$")
    public void verifyBrowseCategoryModuleDisplayed() {
        Assert.assertTrue(dashboardBrowseCategoryPage.isBrowseTabNavigated());
    }

    @And("^scroll down to Browse deals")
    public void scrollDownToBrowseDeals() {
        dashboardBrowseCategoryPage.scrollDownToBrowseDeals();
    }
}

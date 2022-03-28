package com.automation.steps;

import com.automation.helpers.AppActions;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_BrowsePage;
import com.automation.pages.GG_MyCartPage;
import com.automation.pages.GG_ProductDetailsPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GG_BrowseSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();

    public GG_BrowsePage browsePage = new GG_BrowsePage(driver);
    public GG_MyCartPage gg_myCartPage = new GG_MyCartPage(driver);

    @Then("^go to browse tab$")
    public void goToBrowseTab() throws InterruptedException {
        browsePage.clickBrowseTab();
    }

    @Then("^verify navigated to browse page title$")
    public void verifyNavigatedToBrowseTitle() {
        Assert.assertTrue(browsePage.verifyBrowsePageTitle());
    }

    @Then("^verify navigated to browse tab$")
    public void verifyNavigatedToBrowseTab() {
        browsePage.verifyBrowseCategoryTitle();
//        Assert.assertTrue(browsePage.verifyBrowseCategoryTitle());
    }

    @Then("^verify all the categories$")
    public void verifyAllTheCategories() {
        browsePage.verifyAllTheCategories();
    }

    @Then("^verify all the categories are collapsed$")
    public void verifyAllTheCategoriesAreCollapsed() {
        browsePage.verifyAllTheCategoriesAreCollapsed();
//        Assert.assertTrue(browsePage.verifyAllTheCategoriesAreCollapsed());
    }

    @Then("^verify expand option for categories$")
    public void verifyExpandOptionForCategories() {
        Assert.assertTrue(browsePage.verifyExpandOptionForCategories());
    }

    @Then("^verify collapse option for categories$")
    public void verifyCollapseOptionForCategories() {
        Assert.assertTrue(browsePage.verifyCollapseOptionForCategories());
    }

    @Then("^verify expand option for sub categories$")
    public void verifyExpandOptionForSubCategories() {
        Assert.assertTrue(browsePage.verifyExpandOptionForSubCategories());
    }

    @Then("^verify collapse option for sub categories$")
    public void verifyCollapseOptionForSubCategories() {
        Assert.assertTrue(browsePage.verifyCollapsedOptionForSubCategories());
    }

    @When("^click on expand option for categories$")
    public void clickOnExpandOptionForCategories() {
        browsePage.clickOnExpandOptionForCategories();
    }

    @And("^click on expand option for sub categories$")
    public void clickOnExpandOptionForSubCategories() {
        browsePage.clickOnExpandOptionForSubCategories();
    }

    @Then("^verify Browse tab in Navigation bar$")
    public void verifyBrowseTabInNavigationBar() {
        browsePage.verifyBrowseTabInNavigationBar();
    }

    @Then("^verify search bar is displayed in browse tab$")
    public void verifySearchBarIsDisplayedInBrowseTab() {
        Assert.assertTrue(browsePage.verifySearchBarIsDisplayedInBrowseTab());
    }

    @Then("^verify scan icon is displayed in browse tab$")
    public void verifyScanIconIsDisplayedInBrowseTab() {
        Assert.assertTrue(browsePage.verifyScanIconIsDisplayedInBrowseTab());
    }

    @Then("^verify my cart is displayed in browse tab$")
    public void verifyMyCartIsDisplayedInBrowseTab() {
        Assert.assertTrue(browsePage.verifyMyCartIsDisplayedInBrowseTab());
    }

    @Then("^Expand the Browse category$")
    public void clickOnExpandCollapseOfCategory() {
        browsePage.clickOnExpandCollapseOfCategory();
    }

    @Then("^click on Baby Care category$")
    public void clickOnBabyCareCategoryCard() {
        browsePage.clickOnBabyCareCategoryCard();
    }

    @Then("^click on Beverages category$")
    public void clickOnBeveragesCategoryCard() {
        browsePage.clickOnBeveragesCategoryCard();
    }

    @Then("^add a product if cart is empty$")
    public void addProductIfCartEmpty() throws InterruptedException {
        int productCount = gg_myCartPage.getItemsCountFromCart();
        if (productCount == 0) {
            scrollDownToCategoriesListInBrowseTab();
            browsePage.clickOnBeveragesCategoryCard();
            browsePage.clickOnCoffeeSubCategoryCard();
            browsePage.clickOnCoffeeGroundSubCategoryCard();
            Assert.assertTrue(browsePage.isProductsListingPageDisplayed(), "Products listing page is not displayed");
            new GG_ProductDetailsPage(driver).addMultipleProductCountsToCart(1);
        }
    }

    @Then("^click on Baby Accessories sub category card$")
    public void clickOnBabyAccessoriesSubCategoryCard() {
        browsePage.clickOnBabyAccessoriesSubCategoryCard();
    }

    @Then("^click on Coffee sub category card$")
    public void clickOnCoffeeSubCategoryCard() {
        browsePage.clickOnCoffeeSubCategoryCard();
    }

    @Then("^click on Coffee-Ground sub category card$")
    public void clickOnCoffeeGroundSubCategoryCard() {
        browsePage.clickOnCoffeeGroundSubCategoryCard();
    }

    @Then("^click on Bottles & Nursing sub category card$")
    public void clickOnBottlesNursingSubCategoryCard() {
        browsePage.clickOnBottlesNursingSubCategoryCard();
    }

    @Then("^verify products listing page displayed$")
    public void isProductsListingPageDisplayed() {
        Assert.assertTrue(browsePage.isProductsListingPageDisplayed(), "Products listing page is not displayed");
    }

    @When("^move app to background and bring it to foreground while being on product listing page$")
    public void keepAppInBackgroundAndRelaunchingTheSame() {
        new AppActions().moveAppToBackground();
    }

    @Then("^verify that the category is Expandable$")
    public void verifyCategoryIsExpandable() {
        Assert.assertTrue(browsePage.verifyExpandOptionForSubCategories());
    }

    @Then("^Collapse the Browse category$")
    public void clickOnExpandCollapseOfBrowseCategory() {
        browsePage.clickOnExpandCollapseOfCategory();
    }


    @Then("^verify page with \"([^\"]*)\" title is displayed$")
    public void verifyPageWithTitleIsDisplayed(String categoryTitleExpected) {
        Assert.assertEquals(browsePage.getCategoryTitleTextDisplayed(), categoryTitleExpected, "The desired category is not displayed in Title");

    }

    @Then("^verify sub categories are displayed$")
    public void verifySubCategoriesAreDisplayed() {
        Assert.assertEquals(browsePage.getAllSubCategoryProductNamesForTheExpandedCategory().size() != 0, true, "All the sub categories are not displayed");
    }

    @And("^click GotoDeals button on browse page$")
    public void clickGoToDealsButtonBrowse() {
        browsePage.clickGoToDealsButton();
    }

    @And("^verify all categories are sorted alphabetically$")
    public void verifyAllCategoriesAreSortedAlphabetically() throws InterruptedException {
        browsePage.isCategoriesDisplayedAlphabetical();
    }

    @Then("^verify category name is displayed$")
    public void isCategoryeNameIsDisplayed() {
        browsePage.isCategoryTitleDisplayed();
//        Assert.assertTrue(browsePage.isCategoryTitleDisplayed(), "category name is not displayed");
    }

    @Then("^verify category image is displayed$")
    public void isCategoryeImageIsDisplayed() {
        browsePage.isCategoryImageDisplayed();
//        Assert.assertTrue(browsePage.isCategoryImageDisplayed(), "category Image is not displayed");
    }


    @And("scroll down to categories list in browse tab")
    public void scrollDownToCategoriesListInBrowseTab() {
        browsePage.scrollDownToCategoriesListInBrowseTab();

//        Assert.assertTrue(browsePage.scrollDownToCategoriesListInBrowseTab(), "category list is not displayed");
    }

    @When("user taps on the Refine button")
    public void clickOnRefineButton() {
        browsePage.clickOnRefineButton();
    }

    @Then("verify Sort & Filter page is opened")
    public void verifySortAndFilterPageOpened() {
        Assert.assertTrue(browsePage.verifySortAndFilterPageOpened(), "Sort and Filter page is not opened");
    }

    @When("user clicks on Best Match")
    public void clickOnBestMatch() {
        browsePage.clickOnBestMatch();
    }

    @Then("verify Sort By page is opened")
    public void verifySortByPageOpened() {
        Assert.assertTrue(browsePage.verifySortByPageOpened(), "Sort By page is not opened");
    }

    @When("user selects Club Card Specials from Sort By page")
    public void selectClubCardSpecials() {
        browsePage.selectClubCardSpecials();
    }

    @And("user clicks on back button")
    public void clickBackButton() {
        browsePage.clickBackButton();
    }

    @And("user taps on SAVE in Sort & Filter page")
    public void clickSaveButton() {
        browsePage.clickSaveButton();
    }
}

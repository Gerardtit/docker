package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_SearchPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class GG_SearchSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_SearchPage gg_searchPage = new GG_SearchPage(driver);

    public String getCurrentBanner() {
        return driver.getCapabilities().getCapability("banner").toString();
    }

    public String getCurrentEnv() {
        return driver.getCapabilities().getCapability("env").toString();
    }

    @When("^click on search field$")
    public void clickOnSearchField() {
        gg_searchPage.clickSearchField();
    }

    @When("^user click on search field$")
    public void user_click_on_search_field() throws Throwable {
        gg_searchPage.UserclickSearchField();
    }

    @When("^click on search Products Or Deals field$")
    public void clickOnSearchProductsOrDealsField() {
        gg_searchPage.clickSearchProductsOrDealsField();
    }

    @When("^user clicks search icon on Aisles page$")
    public void clickOnSearchIcon() {
        gg_searchPage.clickSearchIcon();
    }

    @When("^When click on Deals toggle in Shop by Aisles page$")
    public void clickOnDealsToggle() {
        gg_searchPage.clickDealsToggle();
    }

    @When("^click cancel button on product search page$")
    public void clickCancelSearch() {
        gg_searchPage.clickCancelSearch();
    }

    @Then("^verify keyboard opened$")
    public void verifyKeyboardOpened() {
        Assert.assertTrue(gg_searchPage.verifyKeyboardOpened());
    }

    @And("^click search field$")
    public void clickSearchField() {
        gg_searchPage.clickDetailSearchField();
    }

    @Then("^cross button is displayed$")
    public void crossButtonIsDisplayed() {
        Assert.assertTrue(gg_searchPage.checkCrossButtonIsDisplayed());
    }

    @And("^select item from search result list$")
    public void selectItemFromSearchResult() throws IOException {
        gg_searchPage.selectKeywordFromSearchResult();
    }

    @Then("^verify products are displayed on clicking search results item$")
    public void isProductsDisplayedOnClickingSearchResultsList() throws IOException {
        Assert.assertTrue(gg_searchPage.isProductsDisplayedOnClickingSearchResultsList(), "products are not displayed on clicking search results item");
    }

    @Then("^verify deals toggle is displayed in search result page$")
    public void verifyDealsToggleIsDisplayed() {
        Assert.assertTrue(gg_searchPage.isDealToggleIsPresent());
    }

    @Then("^switch to toggle Deal$")
    public void switchToToggleDeal() {
        gg_searchPage.clickOnDealToggle();
    }

    @Then("^verify deal cards are displayed$")
    public void verifyDealCardIsDisplayed() {
        gg_searchPage.isDealCardIsDisplayed();
    }

    @Then("^verify deals title is displayed$")
    public void dealsPageIsDisplayed() {
        gg_searchPage.waitForPageDisplayed();
    }

    @Then("^verify deals toggle is displayed$")
    public void verifyDealsToggle() {
        Assert.assertEquals(gg_searchPage.isDealToggleIsPresent(), true, "Deals toggle is not present");
    }

    @Then("^verify deals toggle is not displayed$")
    public void verifyDealsToggleNotDisplayed() {
        Assert.assertEquals(gg_searchPage.isDealToggleIsPresent(), false, "Deals toggle is present");
    }

    @Then("^click on deals toggle$")
    public void clickDealsToggle() {
        gg_searchPage.clickOnDealToggle();
    }

    @Then("^verify filter button is displayed$")
    public void verifyFilter() {
        Assert.assertEquals(gg_searchPage.isFilterButtonPresent(), true, "Filter button is not present");
    }

    @Then("^verify search results$")
    public void verifySearchResult() throws IOException {
        gg_searchPage.verifySearchResult();
    }

    @Then("^verify filter button is not displayed$")
    public void verifyFilterNotDisplayed() {
        Assert.assertEquals(gg_searchPage.isFilterButtonPresent(), false, "Filter button is present");
    }

    @Then("^the deals toggle is in ON state$")
    public void theDealsToggleIsInONState() {
        Assert.assertEquals(gg_searchPage.getDealsToggleBtnStatus(), true, "Deals Toggle button is not working");
    }

    @Then("^the deals toggle is in OFF state$")
    public void theDealsToggleIsInOFFState() {
        Assert.assertEquals(gg_searchPage.getDealsToggleBtnStatus(), false, "Deals Toggle button is not working");
    }

    @Then("^hide keyboard if opened$")
    public void hideKeyboardIfOpened() {

        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            gg_searchPage.hideKeyBoard();
        }

    }

    @Then("^verify keyboard is not opened$")
    public void verifyKeyboardNotOpened() {
        Assert.assertFalse(gg_searchPage.verifyKeyboardOpened());
    }

    @Then("^user click on cancel button in search bar$")
    public void clickCancelButtonInDealsSearchBar() {
        gg_searchPage.clickCancelCTA();
    }

    @And("verify Cancel CTA appears on the left of search bar")
    public void verify_Cancel_CTA_appears_on_the_left_of_search_bar() {
        Assert.assertTrue(gg_searchPage.isCancelDisplayed());
    }

    @And("^user click on refine button in search page$")
    public void user_click_on_refine_button_in_search_page() throws Throwable {
        gg_searchPage.clickRefineButton();
    }

    @And("^verify products with and without deals is displayed$")
    public void verifyProductsWithAndWithoutDealsDisplayed() throws Throwable {
        gg_searchPage.productWithAndWithoutDeals();
    }

    @And("^verify products with deals is displayed$")
    public void verifyProductsWithDealsDisplayed() throws Throwable {
        gg_searchPage.productWithDealsDisplayed();
    }

    @Then("^verify \"([^\"]*)\" header sub section in Refine menu$")
    public void verifyHeaderSubSectionInRefineMenu(String savingsHeaderTitleExpected) {
        Assert.assertEquals(gg_searchPage.savingsHeaderDisplayed(), savingsHeaderTitleExpected, "Savings title is not displayed in header sub section");
    }

    @Then("^verify \"([^\"]*)\" under Savings header$")
    public void verifyProductWithDealsUnderSavings(String productWithDealsExpected) {
        Assert.assertEquals(gg_searchPage.productWithDealsDisplayed(), productWithDealsExpected, "Product with deals is not displayed under savings title");
    }

    @And("^click on Product with deals$")
    public void click_on_Product_with_deals() throws Throwable {
        gg_searchPage.clickProductWithDeals();
    }

    @Then("verify Product with Deals is selected")
    public void verify_Product_with_Deals_selected() {
        gg_searchPage.isProductWithDealsSelected();
    }

    @And("^user click on save button$")
    public void user_click_on_save_button() throws Throwable {
        gg_searchPage.clickSave();
    }

    @Then("^verify \"([^\"]*)\" for invalid product search$")
    public void verifyNoResultMessageDisplayedOnOmnisearchScreen(String arg0) throws Throwable {
        Thread.sleep(2000);
        gg_searchPage.verifyNoResultMessageDisplayed(arg0);
    }

    @Then("^verify \"([^\"]*)\" displayed below the search box$")
    public void verifyZeroResultsDisplayed(String zero) throws Throwable {
        Thread.sleep(2000);
        gg_searchPage.verifyZeroResultsDisplayed(zero);
    }

    @And("user clicks OutofStock Item and validate the page")
    public void userClicksOutofStockItemAndValidateThePage() {
        gg_searchPage.clickOutOfStockItem();
        gg_searchPage.clickDismiss();

    }

    @And("^user clicks back button to close the cart$")
    public void userClicksBackButtonToClose() throws Throwable {
        gg_searchPage.clickBackBtnToClose();
    }

    @And("^user navigates back to landing page$")
    public void userNavigateBackToLandingPage() {
        gg_searchPage.navigateBackToLandingPage();
    }

    @And("^user navigates to landing page for ios$")
    public void userNavigateToLandingPage() {
        try {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                gg_searchPage.navigateBackToLandingPage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

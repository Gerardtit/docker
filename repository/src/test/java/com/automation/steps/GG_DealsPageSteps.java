package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_DealsPage;
import com.automation.pages.GG_SelectStorePage;
import com.automation.rest.cache.CommonCache;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GG_DealsPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_DealsPage dealsPage = new GG_DealsPage(driver);
    public GG_SelectStorePage selectStorePage = new GG_SelectStorePage(driver);
    int cartValueBefore;

//    // To be modified/removed later
//    @Then("^verify home screen is displayed$")
//    public void verifyForYouTabIsDisplayed() throws IOException, InterruptedException {
//        Assert.assertTrue(dealsPage.isForYouTabDisplayed(), "Login failed!!!");
//    }

    @And("^user clicks on Next button$")
    public void clickOnNextBtn() throws IOException, InterruptedException {
        // Assert.assertTrue(dealsPage.isForYouTabDisplayed(), "Login failed!!!");
        dealsPage.clickOnNextBtn();
       /* Dimension dimension = driver.manage().window().getSize();
        int height = (int) (dimension.getHeight() * .90);
        int width = (int) (dimension.getWidth() * .92);
        tapCoordinate(width, height);*/
    }

    @Then("^verify that 'For you' Tab is displayed$")
    public void verifyForYouTabDisplayed() {
        Assert.assertTrue(dealsPage.isForYouTabDisplayed());
    }

    @Then("^navigate to dashboard$")
    public void navigateToDashboardPage() {
        dealsPage.goToDashboardPage();
    }

    @When("go to 'For you' Tab")
    public void goToForYouTab() throws InterruptedException {
        dealsPage.goToForYouTab();
    }

    @When("go to 'All Deals' Tab")
    public void goToAllDealsTab() {
        dealsPage.goToAllDealsTab();
    }


    @When("^user navigate to 'BOGO' Tab$")
    public void goToBOGOTab() {
        dealsPage.goToBOGOTab();
    }

    @When("^clicks on first BOGO category$")
    public void clicks_On_First_BOGO_Category() {
        dealsPage.clickFirstBOGOCategory();
    }

    @And("^adds the first BOGO offer$")
    public void adds_The_First_BOGO_Offer() {
        dealsPage.addFirstBOGOOffer();
    }

    @Then("^verify BOGO offer is added in cart$")
    public void verify_BOGO_offer_is_added_in_cart() throws Throwable {
        dealsPage.verifyBOGOOfferAddedInCart();
    }

    @Then("^user scroll down for Buy One Get One Free offer$")
    public void user_scroll_down_for_element() throws Throwable {
        dealsPage.searchElement();
    }

    @When("^go to 'Categories' Tab$")
    public void goToCategoriesTab() throws InterruptedException {
        dealsPage.goToCategoriesTab();
    }

    @When("^go to 'Promo' Tab$")
    public void goToPromoTab() {
        dealsPage.goToPromoTab();
    }

    @Then("^verify that navigation bar is not displayed$")
    public void verifyNavigationBarPresent() {
        Assert.assertFalse(dealsPage.isNavigationBarDisplayed(), "Navigation bar is still displayed, which isn't expected");
    }

    @Then("^verify store address is displayed$")
    public void verifyStoreAddressDisplayed() {
        Assert.assertTrue(selectStorePage.getCurrentStoreAddress() != "");
    }

    @And("^click cancel button on search screen$")
    public void clickCancelButtonOnSearchScreen() {
        dealsPage.clickCancelButtonOnSearchScreen();
    }

    @Then("^verify search icon is displayed$")
    public void verifySearchIconIsDisplayed() {
        Assert.assertTrue(dealsPage.isSearchIconDisplayed());
    }

    @Then("^scroll down on the page$")
    public void verifyCartIconAndNavigationBarRemainFixed() {
        dealsPage.scrollToCheckSearchBarAndIconRemainFixed();
    }

    @Then("^click on categories tab$")
    public void clickOnCategoriesTab() {
        dealsPage.goToCategoriesTab();
    }

    @Then("^verify My Cart icon is displayed$")
    public void verifyMyCartIconIsDisplayed() {
        Assert.assertTrue(dealsPage.isMyCartIconDisplayed());
    }

    @Then("^refresh the page$")
    public void refreshScreen() {
        dealsPage.pullToRefreshScreen();
    }

    @Then("^refresh the page and verify progress spinner is displayed$")
    public void verifyProgressSpinnerIsDisplayed() {
        dealsPage.isProgressSpinnerDisplayed();
    }

    @Then("^verify progress spinner is not displayed after waiting for few seconds$")
    public void verifyProgressSpinnerIsNotDisplayed() throws InterruptedException {
        Assert.assertFalse(dealsPage.isProgressSpinnerDisplayedAfterWaiting(), "Loading spinner is still displayed after waiting for few seconds");
    }

    @Then("^verify clipped label is displayed$")
    public void isClippedDealsLabelDisplayed() {
        Assert.assertTrue(dealsPage.isClippedDealsLabelDisplayed(), "There is no clipped deals");
    }

    @Then("^verify clipped deals label is displayed$")
    public void isClippedLabelDisplayed() {
        Assert.assertTrue(dealsPage.isClippedLabelDisplayed(), "There is no clipped deals");
    }


    @Then("^verify user lands on \"([^\"]*)\" tab in deals$")
    public void verifyUserLandsOnTabInDeals(String tabNameExpected) throws Throwable {
        Assert.assertTrue(dealsPage.getCurrentlySelectedTab().contains(tabNameExpected), "The tab name is not selected in deals " + tabNameExpected);
    }

    @And("^verify Deals displayed in header$")
    public void verifyDealsDisplayedInHeader() {
        Assert.assertTrue(dealsPage.isDealsHeaderDisplayed(), "The deals header isn't displayed");
    }

    @And("^scroll up on the page$")
    public void scrollUpOnThePage() {
        dealsPage.scrollUpOnThePage();
    }

    @Then("^verify Deals navigation bar \"([^\"]*)\" displayed$")
    public void verifyDealsNavigationBarIsDisplayed(String displayOptn) {
        Assert.assertTrue(dealsPage.verifyDealsNavigationIsVisible(displayOptn), "Deals navigation bar visibility is not as expected");
    }

    @Then("^get cart count after keeping app in foreground and verify if they are same in deal page$")
    public void getCartCountAfterKeepingAppInForegroundInDealPage() {
        Assert.assertEquals(dealsPage.getItemsCountFromCart(), cartValueBefore, "Cart values are not same after moving app to foreground to background");
    }

    @And("^user clicks on clip coupon on deals page$")
    public void userClicksClipCouponOnDealsPage() {
        dealsPage.clickClipCoupon();
    }

    @Then("^get count of products from cart on deals page$")
    public void getItemsCountCartInDealsPage() {
        cartValueBefore = dealsPage.getItemsCountFromCart();
    }

    @Then("^Verify Clipped label on the clipped deal card has no buy it again label$")
    public void verifyClippedLabelOnTheClippedDealCardHasNoBuyItAgainLabel() {
        Assert.assertTrue(dealsPage.verifyBuyItAgainLabelOnClippedDeals(), "Buy it again label displayed on clipped deals");
    }

    @And("^click search icon on deals page$")
    public void clickOnSearchIconInDealPage() {
        dealsPage.clickOnSearchIcon();
    }

    @Then("^verify Item You Buy Module is displayed$")
    public void verifyItemYouBuyModuleDisplayed() {
        Assert.assertTrue(dealsPage.isItemYouBuyModuleDisplayed(), "Item You Buy Module is Not Displayed");
    }

    @Then("^verify Item You Buy Module is not displayed$")
    public void verifyItemYouBuyModuleNotDisplayed() {
        Assert.assertFalse(dealsPage.isItemYouBuyModuleDisplayed(), "Item You Buy Module is Displayed");
    }

    @And("scroll up till deals top nav bar is visible")
    public void scrollUpTillTopNavBar() {
        dealsPage.scrollUpTillDealsTopNavigationBarDisplayed();
    }

    @Then("^verify search bar is displayed$")
    public void verifySearchBarIsDisplayed() {
        Assert.assertTrue(dealsPage.isSearchBarDisplayed(), "search bar is Not Displayed");
    }

    @And("click on search bar displayed on deals page")
    public void clickOnSearchbar() {
        dealsPage.clickOnSearchBar();
    }

    @Then("^verify cancel button is displayed$")
    public void verifyCancelButtonIsDisplayed() {
        Assert.assertTrue(dealsPage.isCancelButtonDisplayed(), "cancel button is Not Displayed");
    }

    @And("search for deals on {string} on deals page search bar")
    public void searchByProductName(String productName) {
        dealsPage.searchByProductNameInSearchBar(productName);
    }

    @Then("verify deals related to {string} are displayed")
    public void searchedProductDisplayed(String productName) {
        dealsPage.verifySearchedProductDisplayed(productName);
    }

    @Then("verify Clipped label is displayed for the deal in deal details page")
    public void isClippedLabelDisplayedDealDetails() {
        Assert.assertTrue(dealsPage.isClippedLabelDisplayedOnDealDetailsPage(), "'Clipped!' label is not displayed on deal details page");
    }

    @When("^verify user navigates to All deals tab$")
    public void verifyUserNavigatestoAllDeals() throws InterruptedException {
        Assert.assertTrue(dealsPage.isAllDealsTabDisplayed(), "All deals tab is not displayed");
    }

    @When("^verify user navigates to Categories tab$")
    public void verifyUserNavigatestoCategoriesTab() throws InterruptedException {
        Assert.assertTrue(dealsPage.isCategoriesTabDisplayed(), "Categories tab is not displayed");
    }

    @When("^verify user navigates to Expiring Soon tab$")
    public void verifyUserNavigatestoExpiringSoonTab() throws InterruptedException {
        Assert.assertTrue(dealsPage.isExpiringSoonTabDisplayed(), "Expiring Soon tab is not displayed");
    }

    @When("^verify user navigates to Promo tab$")
    public void verifyUserNavigatestoPromoTab() throws InterruptedException {
        Assert.assertTrue(dealsPage.isPromoTabDisplayed(), "Promo tab is not displayed");
    }

    @Then("verify View list CTA is displayed for the deal in deal details page")
    public void isViewListDisplayedDealDetails() {
        Assert.assertTrue(dealsPage.isViewListCTADisplayedOnDealDetails(), "View list CTA is not displayed on deal details page");
    }

    private Map<String, Map> searchADealOnDealsPageAndGetEligibleProducts(String dealName) throws InterruptedException {
        //Search a Deal
        scrollUpTillTopNavBar();
        goToAllDealsTab();
        //Click on the first item from search
        //Get eligible products from deal card
        Map<String, Map> eligibleProducts = dealsPage.getEligibleProducts(5);
        return eligibleProducts;
    }

    @And("find an eligible product for {string} deal on all deals search page")
    public void findAnEligibleProductForDealOnAllDealsSearchPage(String dealName) throws InterruptedException {
        List<String> availableProducts = new ArrayList<String>();
        Map<String, Map> eligibleProducts = searchADealOnDealsPageAndGetEligibleProducts(dealName);
        for (Map.Entry<String, Map> entry : eligibleProducts.entrySet()) {
            //Get in stock products
            if (!("" + entry.getValue().get("prodAvailability")).toLowerCase().contains("out")) {
                availableProducts.add(entry.getKey());
            }
        }
        CommonCache.commonCache.put(dealName, availableProducts.get(0));
    }
}

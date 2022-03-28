package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.HomePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;

public class HomePageSteps {
    AppiumDriver driver = AppiumDriverManager.getDriver();
    public HomePage homePage = new HomePage(driver);

    @Then("^home page is displayed$")
    public void home_page_is_displayed() throws Throwable {
        homePage.waitForHomePageDisplayed();
    }

    @When("^user click menu icon on home page$")
    public void user_click_menu_icon_on_home_page() throws Throwable {
        homePage.clickMenuIcon();
    }

    @Then("^menu showed user is signed in$")
    public void menu_showed_user_is_signed_in() throws Throwable {
        homePage.waitForHomePageDisplayed();
    }

    @When("^user clicks shopping cart button on home page$")
    public void user_clicks_shopping_cart_button_on_home_page() throws Throwable {
        homePage.hideKeyBoard();
        homePage.clickShoppingCartButton();
    }

    @When("^user add an item to shopping cart on homepage$")
    public void user_add_an_item_to_shopping_cart_on_homepage() throws Throwable {
        homePage.clickAddButton();
    }

    @When("^user click menu button on home page$")
    public void user_click_menu_button_on_home_page() throws Throwable {
        try {
            homePage.clickMenuIcon();
        } catch (Exception e) {
        }
    }

    @When("^user click aisles tab on home page$")
    public void userClickAislesTabOnHomePage() throws InterruptedException {
        homePage.clickAislesTab();
    }

    @Then("^sub list is displayed under aisle list$")
    public void subListIsDisplayedUnderAisleList() {
        homePage.waitForSubListDisplayed();
    }

    @When("^user clicks on \"([^\"]*)\" item on sub list$")
    public void userClicksOnItemOnSubList(String arg0) throws Throwable {
        homePage.clickSubListItem(arg0);
    }

    @Then("^aisles department list is displayed on home page$")
    public void aislesDepartmentListIsDisplayedOnHomePage() {
        homePage.waitForDepartmentListDisplayed();
    }

    @Then("^category list is displayed under sub list$")
    public void categoryListIsDisplayedUnderSubList() {
        homePage.waitForCategoryListDisplayed();
    }

    @When("^user clicks on \"([^\"]*)\" item on category list$")
    public void userClicksOnItemOnCategoryList(String arg0) throws Throwable {
        homePage.clickCategoryListItem(arg0);
    }

    @When("^user clicks on \"([^\"]*)\" item on department list$")
    public void userClicksOnItemOnDepartmentList(String arg0) throws Throwable {
        homePage.clickDepartmentListItem(arg0);
    }

    @Then("^verify item is found from aisle$")
    public void verifyItemIsFoundFromAisle() {
        homePage.waitForItemFoundFromAisle();
    }

    @When("^user clicks \"([^\"]*)\" item add button on first item$")
    public void userClicksItemAddButtonOnFirstItem(String arg0) throws Throwable {
        homePage.clickAddItem(arg0);
    }

    @When("^user click my purchase tab on home page$")
    public void userClickMyPurchaseTabOnHomePage() {
        homePage.clickMyPurchaseTab();
    }

    @When("^user clicks search bar on home page$")
    public void userClicksSearchBarOnHomePage() {
        homePage.clickSearchBar();
        homePage.waitForSearchWindowDisplayed();
    }

    @And("^user clicks the (\\d+) displayed item on search bar$")
    public void userClicksTheStDisplayedItemOnSearchBar(int arg0) {
        homePage.clickElementsByIndex(arg0);
    }

    @And("^user types \"([^\"]*)\" on search bar and click search on home page$")
    public void userTypesOnSearchBarAndClickSearchOnHomePage(String arg0) throws Throwable {
        homePage.enterSearchItem(arg0);
    }

    @When("^user clicks deals on home page$")
    public void userClicksDealsOnHomePage() {
        homePage.clickDealTab();
    }

    @Then("^verify popular items is displayed on home page$")
    public void verifyPopularItemsIsDisplayedOnHomePage() {
        homePage.verifyPopularItemsDisplayed();
    }

    @And("^verify most viewed is displayed on home page$")
    public void verifyMostViewedIsDisplayedOnHomePage() {
        homePage.verifyMostViewedDisplayed();
    }

    @Then("^verify result is displayed on the page$")
    public void verifyResultIsDisplayedOnThePage() {
        homePage.waitForResultFoundDisplayed();
    }

    @And("^user goes back to home page from search page$")
    public void userGoesBackToHomePageFromSearchPage() {
        homePage.clickCancelButton();
    }

    @When("^user increase the (\\d+)st item quantity by (\\d+) on search page$")
    public void userIncreaseTheStItemQuantityByOnSearchPage(int arg0, int arg1) throws InterruptedException {
        homePage.increaseItemQuantity(arg0, arg1);

    }

    @When("^user clicks delivery option on home page$")
    public void userClicksDeliveryOptionOnHomePage() {
        homePage.clickDeliveryOption();
    }

    @Then("^popup feedback alert window$")
    public void PopupFeedbackAlertWindow() {
        try {
            homePage.waitForLoveShoppingPopUpDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("^user select yes on alert window$")
    public void UserSelectYesOnAlertWindow() {
        try {
            homePage.clickLoveShoppingYesButton();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^popup rating window$")
    public void PopupRatingWindow() {
        try {
            homePage.waitForRateShopPopup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("^user select not now button$")
    public void UserSelectNotNowButton() {
        try {
            homePage.clickRateShopNotNowButton();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^user clicks (\\d+) item on auto suggest list$")
    public void userClicksRdItemOnAutoSuggestList(int arg0) {
        homePage.clickAutoSuggestItem(arg0);
    }

    @Then("^ios notification window displayed$")
    public void iosNotificationWindowDisplayed() {
        if (driver.getPlatformName().equalsIgnoreCase("ios"))
            try {
                homePage.waitForNotificationAlert();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @When("^ios user clicks not allow on notification window$")
    public void iosUserClicksNotAllowOnNotificationWindow() {
        if (driver.getPlatformName().equalsIgnoreCase("ios"))
            try {
                homePage.clickDoNotAllowNotification();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @When("^user clicks item \"([^\"]*)\" on aisle list$")
    public void userClicksOnAisleList(String item) throws Throwable {
        homePage.clickItemOnAisleList(item);
    }

    @Then("^verify \"([^\"]*)\" option is selected as preference on home page$")
    public void verifyOptionIsSelectedAsPreferenceOnHomePage(String preference) {
        Assert.assertTrue(homePage.verifyPreferenceDisplayed(preference));
    }

    @Then("^\"([^\"]*)\" window is displayed$")
    public void windowIsDisplayed(String title) throws InterruptedException {
        Thread.sleep(3000);
        homePage.waitForLoadingComplete();
        homePage.waitForWindowDisplayed(title);
    }

    @When("^user clicks reserve a time option on home page$")
    public void userClicksReserveATimeOptionOnHomePage() {
        homePage.clickReserveTimeOption();
    }

    @When("^user clicks view all from popular items$")
    public void userClicksViewAllFromPopularItems() {
        homePage.clickViewAllPopularItems();
    }

    @When("^user click sort or filters from item list window$")
    public void userClickSortOrFiltersFromItemListWindow() {
        homePage.clickSortAndFilterButton();
    }

    @Then("^verify no result is displayed on the page$")
    public void verifyNoResultIsDisplayedOnThePage() {
        homePage.waitForNoResultDisplayed();
    }

    @Then("^product detail page is displayed$")
    public void productDetailPageIsDisplayed() {
        homePage.waitForProductDetailPageDisplayed();
    }

    @And("^related item is displayed on the product detail page$")
    public void relatedItemIsDisplayedOnTheProductDetailPage() {
        homePage.waitForRelatedItemDisplayed();
    }

    @When("^user clicks add button on the product detail page$")
    public void userClicksAddButtonOnTheProductDetailPage() {
        homePage.clickAddProductButton();
    }

    @When("^user clicks (\\d+) product in the search list$")
    public void userClicksProductInTheSearchList(int arg0) throws InterruptedException {
        homePage.clickProductFromSearchList(arg0);
    }

    @And("^Android Navigate Back arrow$")
    public void androidNavigateBackArrow() {
        homePage.androidNavigateBackArrow();
    }

    @Then("^verify recent searched item is displayed$")
    public void verifyRecentSearchedItemIsDisplayed() {
        homePage.waitForRecentSearchedItemDisplayed();
    }

    @And("^verify \"([^\"]*)\" is displayed in recent search$")
    public void verifyIsDisplayedInRecentSearch(String arg0) {
        Assert.assertTrue(homePage.textDisplayed(arg0));
    }

    @And("^Deals toggle switch is displayed on the page$")
    public void dealsToggleSwitchIsDisplayedOnThePage() {
        homePage.waitForDealsToggleSwitchDisplayed();
    }

    @When("^user clicks deals toggle switch on the search page$")
    public void userClicksDealsToggleSwitchOnTheSearchPage() {
        homePage.clickDealsToggleSwitch();
    }

    @Then("^deals switch is displayed as \"([^\"]*)\" on the search page$")
    public void dealsSwitchIsDisplayedAsOnTheSearchPage(String switchStatus) {
        Assert.assertTrue(homePage.dealsToggleSwitch(switchStatus));
    }

    @And("^\"([^\"]*)\" deal is displayed on the page$")
    public void dealIsDisplayedOnThePage(String arg0) {
        Assert.assertTrue(homePage.textDisplayed(arg0));
    }

    @And("^user change quantity to \"([^\"]*)\" number of items$")
    public void userChangeQuantityToNumberOfItems(String arg0) {
        homePage.changeQuantityto(arg0);
    }

    @Then("^\"([^\"]*)\" button is displayed on the screen$")
    public void buttonIsDisplayedOnTheScreen(String arg0) {
        homePage.waitForLoadingComplete();
        Assert.assertTrue(homePage.textDisplayed(arg0));
    }

    @When("^user clicks \"([^\"]*)\" button on page$")
    public void userClicksButtonOnPage(String button) {
        homePage.clickButtonText(button);
    }
}

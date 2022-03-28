package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pages.GG_DealsPage;
import com.automation.pages.HomePage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomePageSteps {
    AppiumDriver driver = AppiumDriverManager.getDriver();
    public HomePage homePage = new HomePage(driver);
    public GG_DealsPage dealsPage = new GG_DealsPage(driver);

    public HomePage getHomePage() {
        return homePage;
    }

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

    @And("^user clicks shopping cart button on home page$")
    public void user_clicks_shopping_cart_button_on_home_page() throws Throwable {
        // homePage.hideKeyBoard();
        homePage.clickShoppingCartButton();
    }


    @Then("^click on Hamburger image, developer settings and scroll for \"([^\"]*)\" feature$")
    public void clickHamburgerMenuAndScrollForFreature(String feature) throws Exception {
        homePage.clickHamburgerMenuAndScrollForFeature(feature);
    }


    @Then("^click on Hamburger menu and select developer settings")
    public void clickHamburgermenu() {
        homePage.clickHamburgerMenu();
    }


    @Then("^Navigate to account")
    public void navigateToAccount() throws InterruptedException {
        homePage.navigateToAccount();
    }

    @Then("^click on hamburger menu")
    public void clickhamburgerMenu() {
        homePage.clickhamburgerMenu();
    }

    @And("^click on Account from settings and verify")
    public void clickAccount() {
        homePage.accountforsettings();

    }

    @Then("^click on home")
    public void clickhometab() {
        homePage.clickhometab();
    }

    @And("^click on freshpass from settings and verify")
    public void feshpassfromsettings() throws InterruptedException {
        homePage.feshpassfromsettings();
    }

    @And("^validate help/FAQ header")
    public void validatehelpheader() throws InterruptedException {
        homePage.validatehelpheader();
    }

    @And("^Validate Feedback header")
    public void validateFeedbackheader() {
        homePage.validatefeedbackheader();
    }

    @And("^click on Help/FAQ button in settings")
    public void clickHelpFAQ() throws InterruptedException {
        homePage.clickHelpFAQ();

    }

    @And("^validate Contact us header")
    public void validateContactUsheader() throws InterruptedException {
        homePage.validateContactUsheader();
    }

    @And("^Validate Terms and Policies header")
    public void validateTermsPolicies() throws InterruptedException {
        homePage.validateTermsPolicies();
    }

    @Then("^capture name of product to be added in cart$")
    public void captureNameOfProductAddedInCart() {
        dealsPage.bufferProductName();
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

    @When("^user click 'yes' love the app$")
    public void user_click_yes_love_app_on_home_page() throws Throwable {
        try {
            homePage.clickAppLovePopup();
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

    @When("^user click on plus button to add more product on first item$")
    public void user_click_on_plus_button_to_add_more_product_on_first_item() throws Throwable {
        homePage.addMoreProduct();
    }

    @When("^user clicks \"([^\"]*)\" item add button on second item$")
    public void userClicksItemAddButtonOnSecondItem(String arg0) throws Throwable {
        homePage.clickAddItemSecondProduct(arg0);
    }

    @Then("^verify add button is displayed$")
    public void verifyAddCTAOnHomePage() {
        homePage.waitForAddCTAOnHomePage();
    }

    @Then("^verify add to List button is displayed$")
    public void verifyAddToListCTAOnHomePage() {
        homePage.scrollDown();
        homePage.waitForAddToListCTAOnHomePage();
    }

    @And("^user scroll down$")
    public void userScrollDown() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            homePage.scrollDown();
        }
    }

    @When("^user click my purchase tab on home page$")
    public void userClickMyPurchaseTabOnHomePage() {
        homePage.clickMyPurchaseTab();
    }

    @Then("^verify Product is added in cart$")
    public void verifyProductAddedInCart() {
        dealsPage.verifymustHaveGrabsOfferAddedInCart();
    }

    @When("^user clicks search bar on home page$")
    public void userClicksSearchBarOnHomePage() {
        homePage.clickSearchBar();
        //   homePage.waitForSearchWindowDisplayed();
    }

    @And("^verify search bar on home page$")
    public void verifySearchBarOnHomePage() {
        homePage.verifySearchBar();
        //   homePage.waitForSearchWindowDisplayed();
    }

    @And("^verify search icon on home page$")
    public void verifySearchIconOnHomePage() {
        homePage.verifySearchIcon();
        //   homePage.waitForSearchWindowDisplayed();
    }

    @And("^user clicks the (\\d+) displayed item on search bar$")
    public void userClicksTheStDisplayedItemOnSearchBar(int arg0) {
        homePage.clickElementsByIndex(arg0);
    }

    @And("^user types \"([^\"]*)\" on search bar and click search on home page$")
    public void userTypesOnSearchBarAndClickSearchOnHomePage(String arg0) throws Throwable {
        homePage.enterSearchItem(arg0);
    }

    @And("^user types \"([^\"]*)\" on search bar$")
    public void userTypesOnSearchBarInHomePage(String arg0) throws Throwable {
        homePage.enterSearchItemInSearchBar(arg0);
    }

    @And("^user see option to select \"([^\"]*)\"$")
    public void userSeeOptionSearchOnHomePage(String arg0) throws Throwable {
        homePage.verifySearchItem(arg0);
    }

    @Then("^user see results found for searched item$")
    public void userSeeResultsForSearchOnHomePage() throws Throwable {
        homePage.verifySearchResults();
    }

    @When("^user clicks deals on home page$")
    public void userClicksDealsOnHomePage() {
        homePage.clickDealTab();
    }

    @When("^user clicks on home page Tab$")
    public void userClicksOnHomePage() {
        homePage.clickHomePageTab();
    }

    @Then("^verify popular items is displayed on home page$")
    public void verifyPopularItemsIsDisplayedOnHomePage() {
        homePage.verifyPopularItemsDisplayed();
    }

    @Then("^verify Must-Have grabs section is displayed on home page$")
    public void verifyMustHaveGrabsItemsIsDisplayedOnHomePage() {
        homePage.verifyMustHaveGrabsItemsDisplayed();
    }

    @When("^user clicks on See all in Must have grabs$")
    public void clickSeeAllInMustHaveGrabs() {
        homePage.clickSeeAllMustHaveGrabs();
    }

    @Then("^verify title of screen is Must-have grabs$")
    public void verifyMustHaveGrabsScreenTitle() {
        homePage.verifyMustHaveGrabsItemsTitle();
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

    @Then("^verify next button is displayed$")
    public void verifyNextButtonIsDisplayed() throws InterruptedException {
        //   Assert.assertTrue(dashboardPage.isProfileIconDisplayed(), "Home page not loaded");
        homePage.verifyNextButtonisDisplayed();
    }

    @When("^user click on Next button on home page$")
    public void userClickonNextButton() throws InterruptedException {
        //   Assert.assertTrue(dashboardPage.isProfileIconDisplayed(), "Home page not loaded");
        //     homePage.clickonNextButton();

    }

    @Then("^user clicks delivery option on home page$")
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

    @And("^scroll down for \"([^\"]*)\" category$")
    public void scrollDownForCategory(String item) {
        homePage.scrollDownForCategory(item);
    }


    @When("^scroll down to see \"([^\"]*)\"$")
    public void scrollDownForNonSnapCategory(String arg0) throws Throwable {
        homePage.scrollDownForNonSnapCategory(arg0);
    }

    @When("^user expands category \"([^\"]*)\" on category list$")
    public void clickCategoryOnCategoryList(String item) throws Throwable {
        homePage.clickCategoryOnCategoryList(item);
    }

    @And("^\"([^\"]*)\" category is displayed on the page$")
    public void categoryIsDisplayedOnThePage(String arg0) {
        Assert.assertTrue(homePage.textDisplayed(arg0));

    }

    @Then("^verify \"([^\"]*)\" option is selected as preference on home page$")
    public void verifyOptionIsSelectedAsPreferenceOnHomePage(String preference) throws InterruptedException {
        Assert.assertTrue(homePage.verifyPreferenceDisplayed(preference));
    }
/*

    @Then("^verify \"([^\"]*)\" preference text on home page$")
    public void verifyPreferenceTextOnHomePage(String preference) {
        Assert.assertTrue(homePage.verifyPreferenceDisplayed(preference));
    }

*/

    @Then("^\"([^\"]*)\" window is displayed$")
    public void windowIsDisplayed(String title) {
//        Thread.sleep(3000);
        new WaitAction(driver).waitForLoadingComplete();
        homePage.waitForWindowDisplayed(title);
        homePage.waitForLoadingComplete();

    }

    @When("^user clicks reserve a time option on home page$")
    public void userClicksReserveATimeOptionOnHomePage() {
        homePage.clickReserveTimeOption();
    }

    @When("^user clicks view all from popular items$")
    public void userClicksViewAllFromPopularItems() {
        homePage.clickViewAllPopularItems();
    }

    @When("^user clicks see all from popular items$")
    public void userClicksSeeAllFromPopularItems() {
        homePage.clickSeeAllPopularItems();
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

    @And("^Android user click on SAVE button$")
    public void androidSaveButton() {
        homePage.clickonSaveButton();
    }

    @When("user click shopping cart button on home page")
    public void user_click_shopping_cart_button_on_home_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
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
        new WaitAction(driver).waitForLoadingComplete();
        Assert.assertTrue(homePage.textDisplayed(arg0));
    }

    @When("^user clicks \"([^\"]*)\" button on page$")
    public void userClicksButtonOnPage(String button) {
        new CommonActions(driver).new ClickAction().clickButtonText(button);
    }


    @When("^user clicks shopping cart button on homepage$")
    public void user_clicks_shopping_cart_button() throws Throwable {
        homePage.hideKeyBoard();
        homePage.clickShoppingCartButton();
    }

    @When("^user set up in store mode on home page$")
    public void inStoreModeSetUpOnHomepage() throws InterruptedException {
        homePage.InStoreModeSetUpOnHomepage();
    }

    @And("^user types \"([^\"]*)\" on search bar and click search on home page and enter first milk$")
    public void userTypesOnSearchBarAndClickSearchOnHomePageEnterFirstMilk(String arg0) throws Throwable {

        homePage.enterSearchItemAndClickMilk(arg0);
    }

    @When("^user handle the toggle to access search page$")
    public void tabOnToggle() {
        homePage.iosToggleClose();
    }

    @When("^user add first milk on search page$")
    public void addFirstMilkOnSearchPage() throws InterruptedException {
        homePage.addFirstOnSearchpage();
    }

    @When("^user click on start shopping button$")
    public void tabOnStartShoppingButton() throws InterruptedException {
        homePage.clickOnStartShoppingButton();
    }

    @When("^user clicks on Shop page$")
    public void user_clicks_on_Shop_page() {
        homePage.clickonshoptab();
    }

    @When("^user click on shopping cart button on homepage$")
    public void user_click_on_shopping_cart_button_on_home_page() throws Throwable {
        homePage.hideKeyBoard();
        homePage.tapShoppingCartButton();
    }

    @Then("^user close sign in page$")
    public void closesigninpage() {
        homePage.clickonclosesigninpage();
    }

    @Then("^verify sign in page$")
    public void varifysigninpage() {
        homePage.validatesigninpage();
    }

    @When("^user setup pick up  mode on home page$")
    public void pickUpModeSetUpOnHomepage() throws InterruptedException {
        homePage.pickUpModeSetUpOnHomepage();
    }

    @When("^user setup delivery mode on homepage$")
    public void deliveryModeSetUpOnHomepage() throws InterruptedException {
        homePage.deliveryModeSetUpOnHomepage();
    }

    @When("^user add first milk to be thirty dollar on cart page$")
    public void addFirstMilkOnCartPage() {
        homePage.addItemOnCartPage();
    }

    @When("^user click on cancel on search page$")
    public void clickOnCancel() throws InterruptedException {
        homePage.clickOnCancelOnSearch();
    }

    @When("^user click on pick up option$")
    public void clickOnPickUp() throws InterruptedException {
        homePage.clickOnPickUpInSignInPage();
    }

    @Then("^click on radio to select 7499 dublin store")
    public void clickDublinradio() {
        homePage.clickDublinradio();
    }


    @And("user store first address of store")
    public void storeFirstAddress() {

        homePage.firstStoreAddressValue();

    }

    @Then("the first store gets selected by default")
    public void first_storeAddress_selected_By_Default() {
        homePage.verifyStoreAddress();

    }

    @Then("^verify no search results are displayed$")
    public void verifyNoSearchResultsDisplayed() {
        homePage.verifyNoSearchResultsDisplayed();
    }

    @Then("^user navigates back to Home Page$")
    public void userNavigatesBackToHomePage() {
        homePage.userNavigateBackToHomePage();
    }

    @When("^sign out if user is logged in to app$")
    public void signOutIfUserLoggedInToApp() {
        homePage.signOutIfSignedIn();
    }

    @And("^user clicks any item from the selected category in aisle list$")
    public void userClicksAnyItemFromTheSelectedCategoryInAisleList() throws InterruptedException {
        homePage.clickOnAnySubCategoryFromTheCategorySelected();

    }

    @When("^click on View All in PDP$")
    public void clickViewAllRelatedProducts() {
        homePage.viewAllRelatedProducts();
    }

    @Then("^verify refine button is present$")
    public void verifyRefineButtonInCategoryDetailsPage() {
        Assert.assertTrue(homePage.isRefineButtonDisplayed());
    }

    @Then("verify products toggle selected by default")
    public void verify_products_toggle_selected_by_default() {
        homePage.isProductsSelected();
    }

    @Then("verify deals toggle is selected")
    public void verify_deals_toggle_selected() {
        homePage.isDealsSelected();
    }

    @And("verify results is displayed with the count")
    public void verify_results_is_displayed_with_the_count() {
        Assert.assertTrue(homePage.isTotalCountDisplayed());
    }

    @Then("user click on Browse Tab")
    public void user_click_on_browse_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user clicks on clip coupon with double tap")
    public void user_clicks_on_clip_coupon_with_double_tap() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user click on Go to Deals")
    public void user_click_on_go_to_deals() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Click on {string}")
    public void click_on(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user clicks on clip coupon with fast tab")
    public void user_clicks_on_clip_coupon_with_fast_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("click on Reward")
    public void click_on_reward() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Search product")
    public void search_product() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Click on Product")
    public void click_on_product() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Click on Add to Cart")
    public void click_on_add_to_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Click on Add Quantity")
    public void click_on_add_quantity() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Click on Decrease Product quantity")
    public void click_on_decrease_product_quantity() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Remove item from cart")
    public void remove_item_from_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Search product half Name")
    public void search_product_half_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user click on Deals Tab")
    public void user_click_on_deals_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("sign in to the application using account with purchase history")
    public void sign_in_to_the_application_using_account_with_purchase_history() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("click on my items tab")
    public void click_on_my_items_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Search product with {string}")
    public void search_product_with(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Click on Search Product")
    public void click_on_search_product() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Click on Add Quantity for Search Product")
    public void click_on_add_quantity_for_search_product() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Click on cart")
    public void click_on_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("click Delivery window hours")
    public void click_delivery_window_hours() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("click on save button")
    public void click_on_save_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("user clicks delivery option")
    public void user_clicks_delivery_option() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("shopping cart page displayed")
    public void shopping_cart_page_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user click checkout button on cart page")
    public void user_click_checkout_button_on_cart_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Checkout page is displayed")
    public void checkout_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User clicks {string} text on page")
    public void user_clicks_text_on_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks {string} to add new delivery address")
    public void user_clicks_to_add_new_delivery_address(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user enters the {string} to check for the order availability")
    public void user_enters_the_to_check_for_the_order_availability(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user enters AddressLines as {string} and FloorNumber as {string} and AddressType as {string}")
    public void user_enters_address_lines_as_and_floor_number_as_and_address_type_as(String string, String string2, String string3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user clicks on the save button")
    public void user_clicks_on_the_save_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user clicks continue to update zipcode with new delivery address")
    public void user_clicks_continue_to_update_zipcode_with_new_delivery_address() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks View cart button to view the cart changes")
    public void user_clicks_view_cart_button_to_view_the_cart_changes() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("verify Estimated Subtotal is displayed")
    public void verify_estimated_subtotal_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify Estimated Taxes and Fees is displayed")
    public void verify_estimated_taxes_and_fees_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify Estimated Total is displayed")
    public void verify_estimated_total_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify Estimated Total is the total of Estimated Subtotal and Taxes")
    public void verify_estimated_total_is_the_total_of_estimated_subtotal_and_taxes() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify user navigates to For you page")
    public void verify_user_navigates_to_for_you_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks Categories tab")
    public void user_clicks_categories_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify user navigates to Categories page")
    public void verify_user_navigates_to_categories_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("verify user navigates to All Deals page")
    public void verify_user_navigates_to_all_deals_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks For you tab")
    public void user_clicks_for_you_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user click on Expiring Soon tab")
    public void user_click_on_expiring_soon_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify user navigates to Expiring Soon page")
    public void verify_user_navigates_to_expiring_soon_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks Promo tab")
    public void user_clicks_promo_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify user navigates to Promo page")
    public void verify_user_navigates_to_promo_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks BOGO tab")
    public void user_clicks_bogo_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify user navigates to BOGO page")
    public void verify_user_navigates_to_bogo_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("user click on All Deals pill")
    public void user_click_on_all_deals_pill() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify All Deals pill is selected")
    public void verify_all_deals_pill_is_selected() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("verify Expiring Soon Pill is selected")
    public void verify_expiring_soon_pill_is_selected() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user scroll horizontally through pills")
    public void user_scroll_horizontally_through_pills() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("verify New Deals pill is selected")
    public void verify_new_deals_pill_is_selected() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user click on Recommended Deals pill")
    public void user_click_on_recommended_deals_pill() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify Recommended Deals pill is selected")
    public void verify_recommended_deals_pill_is_selected() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("verify Coupon Centre Deals Pill is selected")
    public void verify_coupon_centre_deals_pill_is_selected() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user scroll vertically to clip more coupons")
    public void user_scroll_vertically_to_clip_more_coupons() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify pills are scrollable and not pinned")
    public void verify_pills_are_scrollable_and_not_pinned() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify search bar appears in For you page")
    public void verify_search_bar_appears_in_for_you_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify {string} option selected by default in Coupons type")
    public void verify_option_selected_by_default_in_coupons_type(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("user click on refine button")
    public void user_click_on_refine_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify Refine tab displayed with count on Show Result button")
    public void verify_refine_tab_displayed_with_count_on_show_result_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user navigates to All Deals search bar")
    public void user_navigates_to_all_deals_search_bar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks cancel")
    public void user_clicks_cancel() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify {string} option selected by default in Sort By")
    public void verify_option_selected_by_default_in_sort_by(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user click on Show Result Button")
    public void user_click_on_show_result_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("verify search result is displayed on the page")
    public void verify_search_result_is_displayed_on_the_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("verify the default text in search bar")
    public void verify_the_default_text_in_search_bar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user types {string} on Deals page search bar")
    public void user_types_on_deals_page_search_bar(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify {string} displayed below the search box")
    public void verify_displayed_below_the_search_box(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify the default text displayed for the search result {string}")
    public void verify_the_default_text_displayed_for_the_search_result(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify search bar appears in Categories page")
    public void verify_search_bar_appears_in_categories_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user navigates to Categories page")
    public void user_navigates_to_categories_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("verify search bar is not pinned and scrolls with the page")
    public void verify_search_bar_is_not_pinned_and_scrolls_with_the_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user edit address on edit delivery address page")
    public void user_edit_address_on_edit_delivery_address_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify updated Address saved in Account page matches the address on checkout page")
    public void verify_updated_address_saved_in_account_page_matches_the_address_on_checkout_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("click on close button")
    public void click_on_close_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify confirmation mail recieved {string}")
    public void verify_confirmation_mail_recieved(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify my items screen is displayed")
    public void verify_my_items_screen_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify Clipped deals is displayed in my items tab")
    public void verify_clipped_deals_is_displayed_in_my_items_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("verify Deal Detail page is displayed")
    public void verify_deal_detail_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("navigate to {string} Tab")
    public void go_to_tab(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("search for product {string} on deals page search bar")
    public void search_for_product_on_deals_page_search_bar(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("go to Mylist tab")
    public void go_to_mylist_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("go to member tab")
    public void go_to_member_tab() throws InterruptedException {
        homePage.clickMemberTab();
        // Write code here that turns the phrase above into concrete actions

    }

    @When("user enter some invalid email format error message should appear")
    public void user_enter_some_invalid_email_format_error_message_should_appear() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user enter valid email after error message navigate to otp screen")
    public void user_enter_valid_email_after_error_message_navigate_to_otp_screen() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user enters invalid mobile number verify invalid mobile error message")
    public void user_enters_invalid_mobile_number_verify_invalid_mobile_error_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("clear invalid mobile number verify error message gone")
    public void clear_invalid_mobile_number_verify_error_message_gone() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify home screen is displayed after POPup")
    public void verify_home_screen_is_displayed_after_po_pup() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user clicks Add button of first item")
    public void user_clicks_add_button_of_first_item() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("add quantity to selected item")
    public void add_quantity_to_selected_item() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("validate COATEXT on checkoutPage")
    public void validate_coatext_on_checkout_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Textbox is clicked")
    public void textbox_is_clicked() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user enters {string} on text bar")
    public void user_enters_on_text_bar(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("coa credits are displayed")
    public void coa_credits_are_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user navigate to checkout page")
    public void user_navigate_to_checkout_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("validate COATEXT on checkoutPage back")
    public void validate_coatext_on_checkout_page_back() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify reward balance as zero")
    public void verify_reward_balance_as_zero() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("search using keyword")
    public void search_using_keyword() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("sign in to the application using account with no redeemed rewards and no deals clipped")
    public void sign_in_to_the_application_using_account_with_no_redeemed_rewards_and_no_deals_clipped() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("go to MyItems tab")
    public void go_to_my_items_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Clicks categories on deals page")
    public void clicks_categories_on_deals_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Saving deal is displayed")
    public void saving_deal_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user select weekly ads in saving deals")
    public void user_select_weekly_ads_in_saving_deals() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify Weekly Ads coupons on homepage")
    public void verify_weekly_ads_coupons_on_homepage() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("validate coupon counts are same on both display")
    public void validate_coupon_counts_are_same_on_both_display() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("fill list with four different items")
    public void fill_list_with_four_different_items() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks ListIcon on home page")
    public void user_clicks_list_icon_on_home_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Validate ApologyText on ListPage")
    public void validate_apology_text_on_list_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks delivery option on home page on return")
    public void user_clicks_delivery_option_on_home_page_on_return() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Validate ApologyText not available")
    public void validate_apology_text_not_available() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user Clip one deal")
    public void user_clip_one_deal() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user selects MyItem on HomePage")
    public void user_selects_my_item_on_home_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify clipped with see all")
    public void verify_clipped_with_see_all() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("clipped deal is selected at myitems page")
    public void clipped_deal_is_selected_at_myitems_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("MyWallet page is displayed")
    public void my_wallet_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("clipped deals with see all is displayed at mywallet Page")
    public void clipped_deals_with_see_all_is_displayed_at_mywallet_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("validate clipped deals at itempage and mywalletpage are same")
    public void validate_clipped_deals_at_itempage_and_mywalletpage_are_same() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("sign in to the application as a new user")
    public void sign_in_to_the_application_as_a_new_user() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user clicks continue Popups for new user")
    public void user_clicks_continue_popups_for_new_user() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Clipped deal at Myitems are not displayed")
    public void clipped_deal_at_myitems_are_not_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on InfoIcon beside the estimation total")
    public void user_clicks_on_info_icon_beside_the_estimation_total() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Estimation Page is open with text before")
    public void estimation_page_is_open_with_text_before() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("clicks {string} text on page")
    public void clicks_text_on_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Select and save open window")
    public void select_and_save_open_window() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("placeorder is clicked")
    public void placeorder_is_clicked() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on InfoIcon At Order page")
    public void user_clicks_on_info_icon_at_order_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Estimation Page is open from order page")
    public void estimation_page_is_open_from_order_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("validate text thro' order page is same as Estimation page")
    public void validate_text_thro_order_page_is_same_as_estimation_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("home page is displayed back")
    public void home_page_is_displayed_back() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("At OrderConfirmationPage,OrderLink is displayed")
    public void at_order_confirmation_page_order_link_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user click promocode on checkoutpage")
    public void user_click_promocode_on_checkoutpage() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user enter promo code {string} and enters")
    public void user_enter_promo_code_and_enters(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("PromoCode is Removed")
    public void promo_code_is_removed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("invalid Promocode is applied")
    public void invalid_promocode_is_applied() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("invalid Promocode message")
    public void invalid_promocode_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user Clicks on checkoutCart")
    public void user_clicks_on_checkout_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user enter promo code {string} with empty cart")
    public void user_enter_promo_code_with_empty_cart(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("message is displayed")
    public void message_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify My account field")
    public void verify_my_account_field() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("user click on the link at page")
    public void user_click_on_the_link_at_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify Account page is opened")
    public void verify_account_page_is_opened() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user verify all the section on account page")
    public void user_verify_all_the_section_on_account_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify Weekly Ads")
    public void verify_weekly_ads() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user click see all")
    public void user_click_see_all() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify browse is opened")
    public void verify_browse_is_opened() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user verify different elements")
    public void user_verify_different_elements() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Verify wallet header")
    public void verify_wallet_header() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify that Clip button is displayed")
    public void verify_that_clip_button_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("search for product {string} on home page")
    public void search_for_product_on_home_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify title of Loyalty card")
    public void verify_title_of_loyalty_card() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("sign in to the application using account with contactless pay banner")
    public void sign_in_to_the_application_using_account_with_contactless_pay_banner() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("click on monopoly deal card with one time use")
    public void click_on_monopoly_deal_card_with_one_time_use() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("click on all past purchases tab")
    public void click_on_all_past_purchases_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify all past purchases tab selected on My Items page")
    public void verify_all_past_purchases_tab_selected_on_my_items_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify my last orders are displayed")
    public void verify_my_last_orders_are_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("zipCode new Updated text is displayed")
    public void zip_code_new_updated_text_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("zipCode Updated Statement is displayed")
    public void zip_code_updated_statement_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("validate title and statement")
    public void validate_title_and_statement() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("checkout contact phone number should be same as the My Account phone number")
    public void checkout_contact_phone_number_should_be_same_as_the_my_account_phone_number() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on Hemberger on home Page")
    public void user_clicks_on_hemberger_on_home_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user types {string} on search bar and click search on menu page")
    public void user_types_on_search_bar_and_click_search_on_menu_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks cancel button")
    public void user_clicks_cancel_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks Browse on home page")
    public void user_clicks_browse_on_home_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user types {string} on search bar and click search on browse page")
    public void user_types_on_search_bar_and_click_search_on_browse_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user types {string} on search bar and click search on My Items page")
    public void user_types_on_search_bar_and_click_search_on_my_items_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("^User click on See All in Browse Categories on Home Page$")
    public void userClicksSeeAllBrowseCategories() {
        homePage.clickSeeAllBrowseCategories();
    }

    @When("^user clicks search bar on result page$")
    public void userClicksSearchButton() {
        homePage.clickSearchButton();
    }

    @When("^clip Deal in Home Page$")
    public void clipDealHomePage() {
        homePage.clipDealHomePage();
    }

    @Then("^verify user is able to see toast message$")
    public void verifyToastMessage() {
        homePage.verifyToastMessage();
    }

    @When("user clicks on Shop page and navigates to Past Purchases")
    public void userClicksOnShopPageAndNavigatesToPastPurchases() {
        homePage.clickShopPageBottomNav();
    }

    @When("user clicks on Deals bottom navigation")
    public void userClicksOnDealsBottomNavigation() {
        homePage.clickDealsBottomNav();
    }

    @When("user clicks on My List bottom navigation")
    public void userClicksOnMyListBottomNavigation() {
        homePage.clickMyListBottomNav();
    }

    @When("user clicks on Member tab bottom navigation")
    public void userClicksOnMemberTabBottomNavigation() {
        homePage.clickMemberTabBottomNav();
    }
}

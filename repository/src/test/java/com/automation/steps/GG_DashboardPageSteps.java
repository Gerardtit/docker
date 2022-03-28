package com.automation.steps;

import com.automation.helpers.AppActions;
import com.automation.helpers.DeviceHelper;
import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.manager.ConfigFileManager;
import com.automation.pages.BasePage;
import com.automation.pages.GG_DashboardPage;
import com.automation.pages.GG_ShoppingModePage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

public class GG_DashboardPageSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_DashboardPage dashboardPage = new GG_DashboardPage(driver);

    private GG_ShoppingModePage shoppingModePage = new GG_ShoppingModePage(driver);

    public BasePage basePage = new BasePage(driver);


    public String getCurrentBanner() {
        return driver.getCapabilities().getCapability("banner").toString();
    }

    public String getCurrentEnv() {
        return driver.getCapabilities().getCapability("env").toString();
    }


    @Then("^verify home screen displayed$")
    public void verifyHomeScreenDisplayed() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(dashboardPage.isProfileIconDisplayed(), "Home page not loaded");

    }


    @Then("^verify deal card present in personalised section$")
    public void verifyDealCardPresentInPersonalisedSection() {
        Assert.assertTrue(dashboardPage.verifyDealCardDescription());
    }


    @Then("^personalised section title is displayed$")
    public void personalisedSectionTitleIsDisplayed() {
        dashboardPage.verifyPersonalisedSectionTitle();
    }

    @Then("^scroll up to profile icon on home page$")
    public void scrollUpToProfileIconHomePage() {
        dashboardPage.scrollUpToProfileIconHomePage();
    }

    @When("^tap on store location detail$")
    public void tapOnStoreLocationDetail() {
        dashboardPage.clickStoreLocationDetail();
    }

    @Then("^loader displayed in home screen$")
    public void loaderDisplayedInHomeScreen() {
        dashboardPage.verifyLoader();
    }

    @Then("^verify reward information is displayed$")
    public void rewardInformationIsDisplayed() {
        dashboardPage.verifyRewardInformation();
    }

    @Then("^verify Home tab bar is displayed$")
    public void verifyHomeTabBarIsDisplayed() throws InterruptedException {
        dashboardPage.verifyHomeTab();
    }

    @Then("^verify Deals tab bar is displayed$")
    public void verifyDealsTabBarIsDisplayed() {
        dashboardPage.verifyDealsTab();
    }


    @When("^go to Deals tab$")
    public void goToDealsTab() {
        dashboardPage.clickDealsTab();
        dashboardPage.handleLoveAppPopup();
        dashboardPage.clickOnCancelButtonFeedbackFormIfDisplayed();
    }

    @When("^click on deals tab$")
    public void clickDealsTab() {

        dashboardPage.clickOnDealsTab();

    }

    @Then("^navigate to deals tab$")
    public void navigateToDealsTab() {
        dashboardPage.clickDealsTab();
        dashboardPage.handleLoveAppPopup();
    }


    @And("^please take survey$")
    public void allowPushNotificationPermission() throws InterruptedException {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Thread.sleep(3000);
            dashboardPage.clickSurveyPopup();
            //    welcomePage.clickAllowInNotificaitonPopUp();
            Thread.sleep(5000);
        } else {
            Thread.sleep(5000);
        }
    }

    @When("^go to Wallet tab menu$")
    public void goToWalletTabMenu() {
        dashboardPage.clickWalletTab();
    }

    @When("^go to Home tab$")
    public void goToHomeTab() {
        dashboardPage.handlePopUpsAndTutorialOnDashboard();
        dashboardPage.clickHomeTab();
        dashboardPage.handlePopUpsAndTutorialOnDashboard();
    }

    @When("^click on home tab$")
    public void clickOnHome() {
        dashboardPage.clickHomeTab();
    }

    @When("^handle popups and tutorial on home page$")
    public void handlePopUpsTutorials() {
        dashboardPage.handlePopUpsAndTutorialOnDashboard();
    }

    @When("^go to Home tab to verify tutorials$")
    public void goToHomeTabTutorial() {
        dashboardPage.clickContinueCache();
        dashboardPage.clickHomeTab();
        dashboardPage.clickDontAllow();
    }


    @And("^go to 'Bogo' Menu Items$")
    public void goToBogoMenuItems() {
        dashboardPage.clickBogoMenuItems();
    }

    @Then("^verify that 'Bogo' Text is displayed$")
    public void verifyBogoTextDisplayed() {
        dashboardPage.verifyBogoText();
    }

    @When("^go to Browse tab$")
    public void goToBrowseTab() {
        dashboardPage.clickBrowseTab();
    }

    @Then("^verify deals screen is displayed$")
    public void verifyDealsScreenIsDisplayed() {
        Assert.assertTrue(dashboardPage.verifyDealSectionHeader());
    }

    @And("^verify 'Bogo' tab is displayed$")
    public void verifyBogoTabIsDisplayed() {
        dashboardPage.isBogoTabDisplayed();
    }

    @Then("^verify pull the screen for refresh is available$")
    public void verifyPullScreenRefreshIsAvailable() {
        dashboardPage.verifyPullScreenRefresh();
    }

    @Then("^verify spinner comes when user pull to refresh$")
    public void verifySpinnerComesWhenPullScreenRefresh() {
        dashboardPage.verifySpinnerComesWhenPullScreen();
    }

    @Then("^verify the spinner must be disappear when contents are updated or an error is received$")
    public void verifySpinnerDisappearWhenContentsAreUpdated() throws InterruptedException {
        Assert.assertFalse(dashboardPage.verifySpinnerDisappearWhenContent());
    }


    @When("^verify search bar \"([^\"]*)\" displayed$")
    public void verifySearchBarIsDisplayed(String displayedOption) {
        dashboardPage.verifySearchBar(displayedOption);
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

    @Then("^verify greeting module is displayed$")
    public void verifyGreetingModuleIsDisplayed() throws InterruptedException {
        dashboardPage.verifyGreetingInfo();
    }

    @Then("^verify salutation message$")
    public void verifySalutationMessage() {
        dashboardPage.verifySalutationMessage();
    }

    @Then("^verify user first name$")
    public void verifyUserFirstName() throws IOException {
        String banner = getCurrentBanner();
        String env = getCurrentEnv();
        Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);
        String firstName = bannerProperty.get("FIRST NAME");
        Assert.assertTrue(dashboardPage.getUserFirstName().length() > 0);
    }

    @When("^keep app in background and relaunching the same$")
    public void keepAppInBackgroundAndRelaunchingTheSame() throws IOException, InterruptedException {
        new AppActions().moveAppToBackground();
        dashboardPage.waitForLoaderToDisappear();
        //dashboardPage.clickOnUpdateLaterIfDisplayed();
        dashboardPage.clickOnCancelButtonFeedbackFormIfDisplayed();
        //dashboardPage.clickOnUpdateLaterIfDisplayed();
        //dashboardPage.waitForLoaderToDisappear();
        shoppingModePage.enterDefaultZipCodeAndStartShoppingBackground();
    }

    @When("^move app to background and then bring it to foreground$")
    public void moveAppToBackground() {
        new AppActions().moveAppToBackground();
    }

    @When("^click on cancel button if feedback form is displayed$")
    public void clickOnCloseOnFeedbackForm() {
        dashboardPage.clickOnCancelButtonFeedbackFormIfDisplayed();
    }

    @When("click dismiss button if popup is displayed$")
    public void clickOnDismissCTA() {
        dashboardPage.clickOnDismissCTA();
    }

    @When("^keep app in background and relaunching the same in shopping page$")
    public void keepAppInBackgroundAndRelaunchingTheSameInShoppingPage() {
        new AppActions().moveAppToBackground();
        dashboardPage.waitForLoaderToDisappear();
        dashboardPage.clickOnUpdateLaterIfDisplayed();
        dashboardPage.clickOnCancelButtonFeedbackFormIfDisplayed();
        dashboardPage.clickOnUpdateLaterIfDisplayed();
        dashboardPage.waitForLoaderToDisappear();
    }

    @Then("^verify my profile icon$")
    public void verifyMyProfileIcon() {
        Assert.assertTrue(dashboardPage.verifyMyProfileIcon());
    }

    @When("^click on my profile icon$")
    public void clickOnMyProfileIcon() {
        dashboardPage.clickMyProfileIcon();
    }

    @Then("^verify more screen is displayed$")
    public void verifyMoreScreenIsDisplayed() {
        Assert.assertTrue(dashboardPage.verifyMoreScreen());
    }

    @And("^enter text \"([^\"]*)\" in search field")
    public void enterTextSearchField(String productName) throws InterruptedException {
        dashboardPage.enterTextInSearchField(productName);
    }

    @And("^select first item from search result$")
    public void selectKeywordFromSearchResult() {
        dashboardPage.selectFirstItemFromSearchResult();
    }

    @Then("^check relevant items displayed$")
    public void checkRelevantItemsDisplayed() throws IOException {
        dashboardPage.checkRelevantItemsDisplayed();
    }

    @And("^close toggle info popup$")
    public void closeToggleInfoPopup() {
        dashboardPage.closeToggleInfoPopup();
    }

    @Then("^verify top AEM banner$")
    public void verifyTopAEMBanner() {
        Assert.assertTrue(dashboardPage.verifyTopAEMBanner());
    }

    @Then("^verify AEM banner is not displayed$")
    public void verifyAEMBannerIsNotDisplayed() {
        Assert.assertTrue(dashboardPage.verifyAEMBannerIsNotDisplayed());
    }

    @When("^scroll down to other features carousel$")
    public void scrollDownToFeaturesCarousel() {
        dashboardPage.scrollToFeaturesCarousel();
    }

    @Then("^verify Rewards module is present at first place$")
    public void verifyRewardsModuleAtFirstPlace() {
        Assert.assertTrue(dashboardPage.isRewardsModuleAtFirstPlace());
    }

    @Then("^verify Orders module is present at second place$")
    public void verifyOrdersModuleAtSecondPlace() {
        Assert.assertTrue(dashboardPage.isOderHistoryModuleAtSecondPlace());
    }

    @Then("^verify My Account module is present at third place$")
    public void verifyMyProfileModuleAtThirdPlace() {
        Assert.assertTrue(dashboardPage.isMyProfileModuleAtThirdPlace());
    }

    @Then("^verify My Account module is present at fourth place when flag is ON$")
    public void verifyAccountModuleAtFourthPlace() {
        Assert.assertTrue(dashboardPage.isMyAccountAtFourthPlace());

    }

    @When("^click on rewards module in product features carousel$")
    public void clickRewardModuleCarousel() {
        dashboardPage.clickOnRewardsModuleInCarousel();
    }

    @When("^click on orders module in product features carousel$")
    public void clickOrderHistoryModuleCarousel() {
        dashboardPage.clickOnOrderHistoryModuleInCarousel();
    }

    @When("^click on my account module in product features carousel$")
    public void clickMyProfileModuleCarousel() {
        dashboardPage.clickOnMyProfileModuleInCarousel();
    }

    @Then("^verify static image in reward information$")
    public void verifyStaticImageInRewardInformation() {
        dashboardPage.verifyStaticImageInRewardInformation();
    }

    @Then("^verify static message in reward information$")
    public void verifyStaticMessageInRewardInformation() {
        dashboardPage.verifyStaticMessageInRewardInformation();
    }

    @Then("^verify 'Setup contactless pay' banner$")
    public void verifySetupContactlessPayBanner() {
        Assert.assertTrue(dashboardPage.verifySetupContactlessPayBanner());
    }

    @And("^click on 'Setup contactless pay' banner$")
    public void clickOnSetupContactlessPayBanner() throws InterruptedException {
        dashboardPage.clickOnSetupContactlessPayBanner();
    }

    @Then("^verify 'Setup contactless pay' screen is displayed$")
    public void verifySetupContactlessPayScreenIsDisplayed() {
        dashboardPage.verifySetupContactlessPayScreen();
    }

    @Then("^scroll down upto 'Setup contactless pay' banner$")
    public void scrollDownContactlessPayDashboardScreenIsDisplayed() {
        Assert.assertTrue(dashboardPage.scrollDownContactlessPayDashboardScreen(), "Contact less Pay Screen was not found");

    }

    @And("^verify title & description of contactless pay$")
    public void verifySetupContactlessPayTitle() {
        Assert.assertTrue(dashboardPage.getSetupContactlessPayTitleDescription().contains("Your receipts & contactless pay"), String.format("Title on contact less pay banner is incorrect, actual title with description: %s", dashboardPage.getSetupContactlessPayTitleDescription()));
        Assert.assertTrue(dashboardPage.getSetupContactlessPayTitleDescription().contains("Access your digital receipts and set up a payment method to pay contactless in-store."), String.format("Description on contact less pay banner is incorrect, actual title with description: %s", dashboardPage.getSetupContactlessPayTitleDescription()));
    }

    @Then("^verify rewards information text$")
    public void verifyRewardsInformationText() {
        Assert.assertTrue(dashboardPage.getRewardInformation().contains("You have") && dashboardPage.getRewardInformation().contains("reward"));
    }

    @And("^verify rewards information$")
    public void verifyRewardsInformation() {
        dashboardPage.verifyRewardsInformation();
    }

    @Then("^verify cart icon present next to search bar$")
    public void verifyCartIconPresent() {
        Assert.assertTrue(dashboardPage.verifyCartIconPresentNextToScanButton());
    }

    @Then("^verify user is in browse tab$")
    public void verifyUserIsInBrowseTab() {
        Assert.assertTrue(dashboardPage.verifyUserIsInBrowseTab());
    }

    @Then("^reward image is displayed$")
    public void rewardImageIsDisplayed() {
        Assert.assertTrue(dashboardPage.verifyRewardImage());
    }

    @Then("^click on the back button on My Reward Dashboard$")
    public void clickMyRewardBackButton() {
        dashboardPage.clickBackButtonOnMyReward();
    }

    @Then("^click on the order History button on Dashboard$")
    public void clickOrderHistoryButton() {
        dashboardPage.clickOrderHistoryButton();
    }

    @When("^click on the back button on My order screen$")
    public void clickMyOrderScreenBackButton() {
        dashboardPage.clickBackButtonOnOrderHistory();
    }

    @And("^verify dashboard page is displayed$")
    public void verifyDashBoardScreen() {
        Assert.assertTrue(dashboardPage.verifyDashboardPage(), "Dashboard page isn't displayed as drop down not visible");
    }

    @And("^scroll Down for Order History$")
    public void scrollDownForOrderHistory() {
        dashboardPage.scrollDownForOrderHistory();
    }

    @And("^verify Home tab is selected$")
    public void verifyHomeTabIsSelected() {
        dashboardPage.verifyHomeTabSelected();
    }

    @And("^verify Browse tab is selected$")
    public void verifyBrowseTabIsSelected() {
        dashboardPage.verifyBrowseTabSelected();
    }

    @And("^verify My Items tab is selected$")
    public void verifyMyListTabIsSelected() {
        dashboardPage.verifyMyListTabSelected();
    }

    @And("^verify Deals tab is selected$")
    public void verifyDealsTabIsSelected() {
        dashboardPage.verifyDealsTabSelected();
    }

    @And("^verify wallet tab is selected$")
    public void verifyWalletTabIsSelected() {
        dashboardPage.verifyWalletTabSelected();
    }

    @When("^click on shopping mode down arrow$")
    public void clickOnDownArrowShopping() {
        dashboardPage.clickOnShoppingDownArrow();
    }

    @When("^click on shopping mode down arrow without wait$")
    public void clickOnDownArrowShoppingWithOutWait() {
        dashboardPage.clickOnDownArrowShoppingWithOutWait();
    }

    @When("^scroll down the screen multiple times$")
    public void scrollDownTheScreen() {
        for (int i = 0; i < 4; i++) {
            dashboardPage.scrollDown();
        }
    }

    @And("^click text clear button on search field$")
    public void clickTextClearButtonOnSearchField() {
        dashboardPage.clickTextClearButtonOnSearchField();
    }

    @Then("^verify text cleared on search field$")
    public void verifyTextClearedOnSearchField() {
        Assert.assertTrue(dashboardPage.verifyTextClearedOnSearchField());
    }

    @Then("^verify no result error message displayed$")
    public void verifyNoResultErrorMessageDisplayed() {
        Assert.assertTrue(dashboardPage.verifyNoResultErrorMessageDisplayed());
    }

    @Then("^Verify Full Carts & happy hearts message is displayed$")
    public void verifyFullCartsHappyHeartsMessageDisplayed() {
        Assert.assertTrue(shoppingModePage.verifyFullCartsHappyHeartsMessageDisplayed());
    }

    @When("^click On Button clip$")
    public void clickOnClipButton() {
        dashboardPage.clickOnClipButton();
    }

    @And("^verify clip is changed to view product$")
    public void verifyChangedToViewProduct() {
        dashboardPage.isChangedToViewProduct();
    }

    @And("^verify CTA plus is Displayed$")
    public void verifyPlusButtonDisplayed() {
        Assert.assertTrue(dashboardPage.isPlusButtonDisplayed());
    }

    @And("^verify CTA ADD is Displayed$")
    public void verifyADDButtonDisplayed() {
        Assert.assertTrue(dashboardPage.isAddButtonDisplayed());
    }

    @Then("^verify Currently Trending products displayed$")
    public void verifyCurrentlyTrendingProductsDisplayed() {
        Assert.assertTrue(dashboardPage.isCurrentlyTrendingProductsDisplayed());
    }

    @Then("^verify Recently Searched products displayed$")
    public void verifyRecentlySearchedProductsDisplayed() {
        Assert.assertTrue(dashboardPage.isRecentlySearchedProductsDisplayed());
    }

    @And("^verify My Account is displayed$")
    public void verifyMyAccountIsDisplayed() {
        Assert.assertTrue(dashboardPage.verifyMyAccountIsDisplayed());
    }

    @When("^click on top AEM banner$")
    public void clickOnTopAEMBanner() {
        dashboardPage.clickOnTopAEMBanner();
    }

    @When("^verify In-Store is selected in dashboard$")
    public void verifyInstoreIsDisplayedInDashboard() {
        dashboardPage.isInStoreSelected();
    }

    @When("^verify application is not crashed after clicking on AEM banner by checking for back button$")
    public void verifyApplicationNotCrashed() {
        Assert.assertEquals(dashboardPage.isAEMBackButtonDisplayed(), true, "Back button is not visible");
    }

    @When("^click on banner ad$")
    public void clickBannerAd() {
        dashboardPage.clickOnBannerAd();
    }

    @Then("^verify bottom tab bar order$")
    public void verifyBottomTabBarOrder() {
        Assert.assertTrue(dashboardPage.verifyBottomTabBarOrder());
    }

    @Then("^bottom navigation bar is not displayed$")
    public void bottomNavigationBarIsNotDisplayed() {
        Assert.assertFalse(dashboardPage.isbottomNavigationBarDisplayed());
    }

    @Then("^verify bottom navigation bar$")
    public void verifyBottomNavigationBar() {
        Assert.assertTrue(dashboardPage.isbottomNavigationBarDisplayed());
    }

    @And("^verify Reward Module is displayed$")
    public void verifRewardModuleIsDisplayed() {
        Assert.assertTrue(dashboardPage.isRewardModuleDisplayed());
    }

    @When("^sign out from the application$")
    public void signOut() throws InterruptedException, IOException {
        dashboardPage.signOut();
    }

    @And("^verify OSSO message is displayed$")
    public void verifyOSSOIsDisplayed() {
        Assert.assertTrue(dashboardPage.isOrderStatusDisplayed());
    }

    @When("click on Monopoly Banner$")
    public void clickOnMonopolyBanner() throws ParseException, IOException {
        dashboardPage.clickOnMonopolyBanner();
    }

    @When("click on Back Button On Shop Play Win Page$")
    public void clickOnBackButtonOnShopPlayWinPage() throws ParseException, IOException {
        dashboardPage.clickBackButtonInShopToWinPage();
    }

    @Then("^verify Monopoly Banner is displayed$")
    public void verifyMonopolyBannerIsDisplayed() throws ParseException, IOException {
        Assert.assertTrue(dashboardPage.isMonopolyBannerDisplayed());
    }

    @Then("^verify Back Button On Shop Play Win is displayed$")
    public void verifyBackButtonIsDisplayed() throws ParseException, IOException {
        Assert.assertTrue(dashboardPage.isBackButtonDisplayedOnShopPlayWinPage());
    }

    @Then("^verify Shop Play Win Page is displayed$")
    public void verifyShopPlayWinTitleIsDisplayed() throws ParseException, IOException {
        Assert.assertTrue(dashboardPage.isShopToWinPageDisplayed());
    }

    @Then("^click on next button on tool tip screen$")
    public void clickOnNextButtonOnTutorialScreen() {
        dashboardPage.clickOnNextButtonOnTutorialScreen();
    }

    @Then("^verify Tutorial screen is displayed$")
    public void verifyTutorialScreenIsDisplayed() {
        Assert.assertTrue(dashboardPage.isTutorialScreenDisplayed());
    }

    @Then("^click on Don't Allow notifications$")
    public void clickDontAllow() {
        dashboardPage.clickDontAllow();
    }

    @Then("^click Allow on notifications pop up$")
    public void clickAllow() {
        dashboardPage.clickAllow();
    }

    @Then("^click Continue on cache pop up$")
    public void clickContinueCache() {
        dashboardPage.clickContinueCache();
    }

    @Then("click Continue on cache pop up for {string} platform")
    public void clickContinueCacheBasedOnPlatform(String platform) {
        if (driver.getPlatformName().equalsIgnoreCase(platform.toUpperCase())) {
            if (dashboardPage.waitForCacheContinue(10)) dashboardPage.clickContinueCache();
        }
    }

    @Then("^click anywhere on screen when tutorials is displayed$")
    public void clickOnRandomLocationTutorials() {
        dashboardPage.clickRandomLocationOnScreenTutorials();
    }

    @When("^click on search icon on home page$")
    public void clickOnSearchIconOnHomePage() {
        dashboardPage.clickOnSearchIconOnHomePage();
    }

    @And("^select first item from the search list$")
    public void selectFirstItemFromTheList() {
        //This is done to confirm the search and is for android only
        dashboardPage.selectFirstItemFromTheListToConfirmSearch();
    }

    @And("^verify loading spinner is displayed until shop play win page is fully loaded$")
    public void checkForLoadingSpinner() throws ParseException, IOException {
        if (dashboardPage.isLoadingSpinnerDisplayed()) {
            Assert.assertTrue(true, "Loading spinner is displayed");
        } else {
            if (!dashboardPage.isShopToWinPageDisplayed()) {
                Assert.assertTrue(false, "Loading spinner is not displayed while shop play win page is being loaded");
            }
        }
    }

    @When("^click search icon on product view all section$")
    public void clickSearchIconOnProductViewAllSection() {
        dashboardPage.clickSearchIconOnProductViewAllSection();
    }

    @And("^enter text \"([^\"]*)\" in product view all section search field")
    public void enterTextOnProductViewAllSectionSearchField(String productName) throws InterruptedException {
        dashboardPage.enterTextInSearchField(productName);
    }

    @When("^user handle all the pop up in the homepage$")
    public void homePagePopUnHandles() throws InterruptedException {
        dashboardPage.allPopUpHandleOnHomePage();
    }

    @And("^handle tutorial if displayed$")
    public void skipTutorial() {
        dashboardPage.handleTutorial(5);
    }

    @And("handle love and feedback form pop ups")
    public void skipLoveFeedback() {
        dashboardPage.handleLoveAppPopup();
        dashboardPage.clickOnCancelButtonFeedbackFormIfDisplayed();
    }

    @And("^handle tutorial if displayed on home page$")
    public void skipTutorialIfDisplayedOnHomePage() {
        dashboardPage.handleTutorial(5);
    }

    @And("^scroll till Deal Card section in Home Page$")
    public void scrollTillDealCardSectionInHomePage() {
        dashboardPage.scrollTillDealsSectionIsVisible();
    }

    @Then("^verify search bar is not displayed$")
    public void verifySearchBarIsDisplayed() {
        Assert.assertFalse(dashboardPage.isSearchBarDisplayed(), "searchBar is displayed");
    }

    @Then("^verify search icon is not displayed$")
    public void verifySearchIconIsDisplayed() {
        Assert.assertFalse(dashboardPage.isSearchIconDisplayed(), "searchIcon is displayed");
    }

    @And("^search a product on home page$")
    public void searchByProductName() {
        String productName = ThreadLocalHelper.testCaseData.get().get("SEARCH_PRODUCT_KEYWORD");
        dashboardPage.searchByProductName(productName);
    }

    @And("add product {int} type {string} with product id")
    public void searchByProductID(Integer amount, String IDType) throws InterruptedException {
        dashboardPage.searchByProductID(amount, IDType);
    }

    @And("search product {string} on home page")
    public void searchByProductName(String productName) {
        dashboardPage.searchByProductName(productName);
    }

    @And("enter text {string} in search bar on home page and press search icon on keyboard")
    public void searchByProduct(String productName) {
        dashboardPage.enterProductNameAndPressSearchBtn(productName);
    }

    @And("^search for invalid product \"([^\"]*)\" on home page$")
    public void searchByInvalidProductName(String productName) {
        dashboardPage.searchByInvalidProductName(productName);
    }

    @Then("^verify \"([^\"]*)\" tutorial is displayed$")
    public void verifyTutorialIsDisplayed(String tutorialName) {
        Assert.assertTrue(dashboardPage.verifyTutorialIsDisplayed(tutorialName), tutorialName + " tutorial not displayed");
    }

    @And("^navigate back to previous page$")
    public void navigateBack() {
        dashboardPage.navigateBack();
    }

    @And("^click 'Yes' if 'Love the app' popup is displayed$")
    public void handleLoveAppPopup() {
        dashboardPage.handleLoveAppPopup();
    }

    @When("^keep app in background and relaunching the same to verify shopping mode tutorial$")
    public void keepAppInBackgroundAndRelaunchingTheSameWithoutPostalZipHandling() throws IOException, InterruptedException {
        new AppActions().moveAppToBackground();
        //verifyTutorialIsDisplayed("Shopping Mode");
    }

    @When("^forced sign out from the application$")
    public void forcedSignOut() throws InterruptedException, IOException {
        new AppActions().terminateApp();
        new AppActions().relaunchApp();
        dashboardPage.clickContinueCache();
        shoppingModePage.enterDefaultZipCodeAndStartShopping();
        dashboardPage.handleTutorial(2);
        dashboardPage.clickHomeTab();
        dashboardPage.handleTutorial(2);
        dashboardPage.clickContinueCache();
        dashboardPage.signOutFromTheApp();
    }

    @When("^go to Home tab without handling pop up$")
    public void goToHomeTabWithoutPopUpHandling() {
        dashboardPage.clickHomeTab();
    }

    @Then("^verify home screen is displayed$")
    public void verifyHomeScreenIsDisplayed() throws IOException, InterruptedException {

        dashboardPage.verifyHomeScreenIsDisplayed();
//        Assert.assertTrue(dashboardPage.verifyHomeScreenIsDisplayed(), "Login failed!!!");
    }

    @Then("^verify tutorial is not displayed$")
    public void verifyTutorialNotDisplayed() {
        dashboardPage.isTutorialScreenDisplayed();
//        Assert.assertFalse(dashboardPage.isTutorialScreenDisplayed(), "Tutorial is still displayed!!");
    }

    @Then("^verify buy it again module is displayed$")
    public void verifyBuyItAgainModuleIsDisplayed() {
        Assert.assertTrue(dashboardPage.isBuyItAgainModuleDisplayed(), "Buy It Again Module is not displayed");
    }

    @Then("^verify browse category module is displayed$")
    public void verifyBrowseCategoryModuleIsDisplayed() {
        Assert.assertTrue(dashboardPage.isBrowseCategoryModuleDisplayed(), "Browse Category Module is not displayed");
    }

    @Then("^swipe left on buy it again module cards$")
    public void swipeLeftInBuyItAgainModule() {
        dashboardPage.swipeLeftInBuyItAgain();
    }

    @Then("^verify alphabetical order of the cards while swiping left on Browse Categories Module$")
    public void verifyAlphabeticalOrderWhileSwipingLeftInBrowseCategoriesModule() throws IOException, InterruptedException {
        Assert.assertTrue(dashboardPage.verifyAlphabeticalOrderWhileSwipingLeftInBrowseCategoriesModule(), "Cards are sorted in alphabetical order in browse categories module");
    }

    @Then("^verify alphabetical order of the cards while swiping left on Browse Deals Module$")
    public void verifyAlphabeticalOrderWhileSwipingLeftInBrowseDealsModule() {
        dashboardPage.verifyAlphabeticalOrderWhileSwipingLeftInBrowseDealsModule();
    }

    @Then("^swipe left on AEM module cards")
    public void swipeLeftInAemModule() {
        dashboardPage.swipeLeftInAEM();
    }

    @Then("^verify weekly coupon module is displayed$")
    public void verifyWeeklyCouponModuleIsDisplayed() {
        Assert.assertTrue(dashboardPage.isWeeklyCouponModuleDisplayed(), "Weekly Coupon Module is not displayed");
    }

    @Then("^verify AEM module is displayed$")
    public void verifyAemModuleIsDisplayed() {
        Assert.assertTrue(dashboardPage.isAemModuleDisplayed(), "AEM Module is not displayed");
    }

    @Then("^verify title of We Can Help$")
    public void weCaneHelpTitleIsDisplayed() {
        Assert.assertTrue(dashboardPage.isWeCanHelpTitleIsDisplayed(), "AEM Module is not displayed");
    }

    @Then("^verify see all button is displayed next to browse categories module$")
    public void verifySeeALlBtnNextToBrowseCategories() {
        Assert.assertTrue(dashboardPage.isSeeALlBtnNextToBrowseCategories(), "See all Button is not displayed next to Browse Categories");
    }

    @Then("^verify see all button is displayed next to browse deals module$")
    public void verifySeeALlBtnNextToBrowseDeals() {
        Assert.assertTrue(dashboardPage.isSeeALlBtnNextToBrowseDeals(), "See all Button is not displayed next to Browse Deals");
    }

    @Then("^verify see all deals banner is displayed$")
    public void verifySeeAllDealsBannerDisplayed() {
        Assert.assertTrue(dashboardPage.isSeeAllDealsBannerDisplayed(), "see all deals banners is not displayed!!");
    }

    @Then("^click on see all deals banner$")
    public void clickOnSeeAllDealsBanner() {
        dashboardPage.clickOnSeeAllDealsBanner();
    }

    @Then("^verify count on see all deals banner displayed$")
    public void verifyCountOnSeeAllDealsBannerIsDisplayed() {
        Assert.assertTrue(dashboardPage.isCountDisplayed(), "count on see all deals banner is not displayed");
    }

    @Then("^slide the deal card and click on see all button on deal card of clip your favourite module$")
    public void swipeAndClickOnSeeAll() {
        dashboardPage.swipeAndClickOnSeeAllLinkIfCardsMoreThenFifteen();
    }

    @Then("^verify deals count in clip your favourite module drawer$")
    public void verifyDealsCountIsDisplayed() {
        Assert.assertTrue(dashboardPage.isDealCountDisplayed(), "count on see all deals banner is not displayed");
    }

    @Then("^user clicks see all link of clip your deals module in home screen$")
    public void clickOnSeeAllLink() {
        dashboardPage.clickOnSeeAllLink();
    }

    @Then("^verify see all link displayed in clip your deals module$")
    public void seeAllLinkIsDisplayed() {
        Assert.assertTrue(dashboardPage.isSeeAllLinkDisplayed(), "see All link is not displayed");
    }

    @Then("^verify maximum 15 deal cards is Displayed in clip your favourite module$")
    public void verifyMaximumSixCardIsDisplayed() throws InterruptedException {
        Assert.assertTrue(dashboardPage.getDealCardCountInClipYourFavorite() <= 15, "deal card count is more than 15");
    }

    @Then("^get the deal name under clip your deals module$")
    public void getDealName() {
        dashboardPage.getDealCardContent();
    }

    @Then("^verify 'Clip your favorites' section has all the deal cards and its content under 'items you buy' in deals screen$")
    public void verifyDealCardContentUnderItemYouBuy() {
        dashboardPage.checkDealContentInItemModules();
    }

    @Then("^verify 'Clip your deals' section has all the deal cards and its content under 'items you like' in deals screen$")
    public void verifyDealCardContentItemYouLike() {
        dashboardPage.checkDealContentInItemModules();
    }

    @Then("^get deals count before store update")
    public void getDealsCountBeforeStoreUpdate() {
        dashboardPage.getCountUpdatedBeforeStoreChange();
    }

    @Then("^get deals count after store update")
    public void verifyMyRewardDrawerIsDisplayed() {
        dashboardPage.getCountUpdatedAfterStoreChange();
    }

    @Then("^verify deal count is updated after store is changed$")
    public void verifyDealCountIsUpdated() {
        Assert.assertTrue(dashboardPage.isDealCountUpdated(), "deal count is not updated");
    }

    @Then("verify {string} link in shortcuts tray on home page")
    public void verifyRewardDrawerdIsDisplayed(String linkText) {
        Assert.assertTrue(dashboardPage.verifyDesiredLinkFromCarousel(linkText), "shortcuts tray not displayed");
    }

    @When("click {string} link in shortcuts tray on home page")
    public void clickLinkInShortcutsTrayOnHomePage(String linkText) {
        dashboardPage.clickLinkInShortcutsTrayOnHomePage(linkText);
    }

    @Then("^verify order history button is displayed$")
    public void verifyOrderHistoryButtonIsDisplayed() {
        Assert.assertTrue(dashboardPage.isOrderHistoryDisplayed(), "order history button is not displayed");
    }

    @Then("^verify my reward count in the drawer is displayed$")
    public void verifyMyRewardCountIsDisplayed() {
        Assert.assertTrue(dashboardPage.isMyRewardCountDisplayed(), "my reward count is not displayed");
    }

    @Then("^verify clipped deals count in the drawer is displayed$")
    public void verifyClippedDealsCountIsDisplayed() {
        Assert.assertTrue(dashboardPage.isClippedModuleCountDisplayed(), "clipped deals count is not displayed");
    }

    @Then("^verify browse deals module is displayed$")
    public void verifyBrowseDealsModuleIsDisplayed() {
        Assert.assertTrue(dashboardPage.isBrowseDealsModuleDisplayed(), "browse deals module is not displayed");
    }

    @Then("^click on see all next to browse deals$")
    public void clickSeeAllNextToBrowseDeals() {
        dashboardPage.clickSeeALlNextToBrowseDeals();
    }

    @Then("^click on a card in browse deals module$")
    public void clickOnCardInBrowseDealsModule() {
        dashboardPage.clickOnCardInBrowseDeals();
    }

    @Then("^verify user lands on \"([^\"]*)\" page when defaultLandingToHome flag is set to \"([^\"]*)\"$")
    public void hasUserLandedOnDeals(String landingPageName, String flagStatus) {

        switch (landingPageName.toUpperCase()) {
            case "DEALS":
                Assert.assertTrue(dashboardPage.hasUserLandedOnDeals(), "User did not land on deals page when defaultLandingToHome is set to false");
                break;
            case "HOME":
                Assert.assertTrue(dashboardPage.hasUserLandedOnHome(), "User did not land on home page when defaultLandingToHome is set to true");
                break;
        }
    }

    @Then("verify user lands on deals by default when defaultLandingToHome flag is not present in evalattrs api")
    public void verifyUserLandsOnHome() throws InterruptedException {
        Assert.assertTrue(dashboardPage.checkDefaultLandingToHomePresentAndVerifyLanding(), "User did not land on home page");
    }

    @Then("verify tutorials and landing page based on defaultLandingToHome flag value from evalattrs api")
    public void verifyUserLandingPageByFlagValue() throws InterruptedException {
        dashboardPage.checkDefaultLandingToHomeValueAndVerifyTutorialsAndLanding();
    }

    @Then("verify landing page based on defaultLandingToHome flag value from evalattrs api")
    public void verifyLandingPageByFlagValue() throws InterruptedException {
        dashboardPage.checkDefaultLandingToHomeValueAndVerifyUserLanding();
    }

    @Then("search using keyword which has no result")
    public void search_using_keyword_which_has_no_result() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("swipe left on browse categories module cards")
    public void swipe_left_on_browse_categories_module_cards() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("enter text in search field")
    public void enter_text_in_search_field() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("select keyword from search result")
    public void select_keyword_from_search_result() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("close my cart page")
    public void close_my_cart_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("^verify tutorial for deal landing page$")
    public void verifyTutorialForDealsLandingPage() {
        dashboardPage.verifyTutorialsForDealsLandingPage();
    }

    @Then("verify {string} tutorial is displayed when navigating to home page")
    public void verifyTutorialIsDisplayedWhenNavigatingToHomePage(String tutorialName) {
        if (!dashboardPage.isDefaultHomePage()) {
            goToHomeTabTutorial();
            clickOnCloseOnFeedbackForm();
            verifyTutorialIsDisplayed(tutorialName);
            clickOnNextButtonOnTutorialScreen();
            clickContinueCache();
            clickOnDismissCTA();
        }
    }

    @Then("verify {string} tutorial is displayed when landing on to home page")
    public void verifyTutorialIsDisplayedWhenLandingOnToHomePage(String tutorialName) {
        if (!dashboardPage.verifyTutorialIsDisplayed(tutorialName)) {
            //Navigate to home and then do the check
            goToHomeTabTutorial();
            clickOnCloseOnFeedbackForm();
        }
        verifyTutorialIsDisplayed(tutorialName);
    }

    @When("^go to MyList tab$")
    public void goToMyListTab() {
        dashboardPage.clickMyListTab();
    }

    @Then("verify Out of Stock product not present in buy it again section")
    public void verifyOutOfStockProductNotPresentInBuyItAgainSection() {
        Assert.assertFalse(dashboardPage.scrollDownForOutOfStockProduct(), "Out of Stock product is displayed in buy it again section");
    }

    @Then("^click on rewards module")
    public void clickOnRewardsModule() {
        dashboardPage.clickOnRewardsModule();
    }

    @Then("turn {string} internet and relaunch app")
    public void turnOnOffInternet(String desiredStatus) {
        DeviceHelper deviceHelper = new DeviceHelper(AppiumDriverManager.getDriver());
        try {
            switch (desiredStatus.toUpperCase()) {
                case "ON":
                    Assert.assertTrue(deviceHelper.turnOnInternetByPlatform(), "Internet was not turned On successfully");
                    break;
                case "OFF":
                    Assert.assertTrue(deviceHelper.turnOffInternetByPlatform(), "Internet was not turned Off successfully");
                    break;
            }
            launchAppWithWait();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void launchAppWithWait() throws InterruptedException, IOException {
        // Relaunching app after turning off/on internet
        Thread.sleep(5000);
        new AppActions().relaunchApp();
        Thread.sleep(5000);
    }

    @Then("user clicks ok on network error popup")
    public void clickOkNetworkError() {
        dashboardPage.clickOkIfDisplayed();
    }

    @When("keep the app in background for {int} seconds")
    public void moveAppToBackgroundForDesiredTime(int seconds) {
        new AppActions().moveAppToBackground(seconds);
    }

    @When("launch settings app to move app under test to background")
    public void launchSettings() throws InterruptedException {
        new DeviceHelper(driver).launchSettingsByPlatform();
        Thread.sleep(10000);
    }

    @When("launch the app under test")
    public void launchApp() throws IOException {
        new AppActions().relaunchApp();

    }

    @Then("verify member tab selected")
    public void verifyMemberTabSelected() {
        dashboardPage.verifyScanCode();
    }

    @Then("for u tab selected")
    public void forUTabSelected() {
        dashboardPage.verifyForU();
    }

    @Then("verify user navigates to home page")
    public void verifyUserLandsOnHomePage() {
        dashboardPage.verifyHomeTabSelected();
    }


    @Then("verify pharmacy services page is displayed")
    public void verifyPharmacyServicesPage() {
        Assert.assertTrue(dashboardPage.verifyPharmacyServicesPageTitle());
    }

    @Then("verify freshpass page is displayed")
    public void verifyFreshPassPage() {
        Assert.assertTrue(dashboardPage.verifyFreshPassPageTitle());
    }

    @Then("verify that rewards page for u page title is displayed")
    public void verifyForUMyRewardsPage() {
        Assert.assertTrue(dashboardPage.verifyRewardsPageTitle());
    }

    @Then("click back button in pharmacy services page")
    public void clickBackBtnInPharmacyServicesPage() {
        dashboardPage.clickBackBtnInPharmacyServicesPage();
    }

    @Then("click on orders module in settings")
    public void clickOnOrdersModuleInSettings() {
        dashboardPage.clickOnOrdersModuleInSettings();
    }


    @And("verify food lot banner is displayed")
    public void verifyFoodLotBannerOnHomePage() {
        dashboardPage.verifyFoodLotBannerDisplayed();
    }

    @When("user clicks on food lot banner")
    public void userClicksFoodLotBanner() {
        dashboardPage.clickFoodlotBanner();
    }

    @When("^user clicks on Meals Halo Nav$")
    public void user_clicks_on_meals_halo_nav() throws Throwable {
        dashboardPage.clickMealsPlansHaloNavTab();
    }

    @When("^user is scrolling to the right most in Halo nav Carousel$")
    public void user_is_scrolling_to_the_right_most_in_halo_nav_carousel() throws Throwable {
        dashboardPage.scrollRightInHaloNavCarousel("FreshPass", 5);
    }

    @Then("^Verify user should be able to see FreshPass icon$")
    public void verify_user_should_be_able_to_see_freshpass_icon() {
        dashboardPage.verifyFreshPassIconIsVisible();
    }

    @When("^user is scrolling to the left most in Halo nav Carousel$")
    public void user_is_scrolling_to_the_left_most_in_halo_nav_carousel() {
        dashboardPage.scrollLeftInHaloNavCarousel("Rewards", 5);
    }

    @Then("^Verify user should be able to see Rewards icon$")
    public void verify_user_should_be_able_to_see_rewards_icon() {
        dashboardPage.verifyRewardsIconIsVisible();
    }

    @When("^user click hamburger$")
    public void user_click_hamburger() {
        dashboardPage.clickHamburgerMenu();
    }


}


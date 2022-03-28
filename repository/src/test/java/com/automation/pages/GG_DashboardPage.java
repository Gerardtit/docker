package com.automation.pages;


import com.automation.helpers.PageActions;
import com.automation.helpers.StringUtil;
import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.entities.BannerConfType;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.TapAction;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.*;
import com.automation.rest.RestApiUtils;
import com.automation.rest.settings.EvalAttrs;
import com.automation.rest.settings.model.EvalAttrsRequestBody;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;


public class GG_DashboardPage extends BasePage {
    private GG_DashboardPageElements dashboardPageElements = new GG_DashboardPageElements();
    private GG_DealsPageElements dealsPageElements = new GG_DealsPageElements();
    private GG_OtpPasswordPageElements otpPasswordPageElements = new GG_OtpPasswordPageElements();
    private GG_ProductDetailsPageElements productDetailsPageElements = new GG_ProductDetailsPageElements();

    PageActions.SwipeActions swipeActions = new PageActions(driver).new SwipeActions();

    private GG_MyRewardsPageElements rewardpageElements = new GG_MyRewardsPageElements();
    private GG_Verify_FreshpassElements freshpassElements = new GG_Verify_FreshpassElements();
    private WalletPageElements walletPageElements = new WalletPageElements();

    PageActions pageActions = new PageActions(driver);

    private boolean isDefaultHomePage = false;

    private GG_DealsPage dealsPage = new GG_DealsPage(driver);

    AppiumDevice device = AppiumDeviceManager.getDevice();


    public GG_DashboardPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dashboardPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dealsPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), otpPasswordPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), productDetailsPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), rewardpageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), freshpassElements);
    }

    public void verifyGreetingInfo() throws InterruptedException {
        waitForLoaderToDisappear();
        if (!isElementDisplayed(dashboardPageElements.greetingInfo, 30)) {
            Assert.assertTrue(false, "Greeting not displayed on dashboard");
        }
    }

    public void waitForLoaderToDisappear() {
        new WaitAction(driver).waitForElementToDisappear(dashboardPageElements.loadingSpinner, 60);
    }

    public boolean verifyDealCardDescription() {
        scrollDownForElement(dashboardPageElements.dealExpiry);
        return isElementDisplayed(dashboardPageElements.dealDescription);
    }

    public boolean verifyDealCardName() {
        return isElementDisplayed(dashboardPageElements.dealName);
    }

    public boolean verifyDealCardExpiry() {
        return isElementDisplayed(dashboardPageElements.dealExpiry);
    }

    public boolean verifyDealCardPrice() {
        return isElementDisplayed(dashboardPageElements.dealPrice);
    }

    public void verifyPersonalisedSectionTitle() {
        waitVar.until(ExpectedConditions.visibilityOf(dashboardPageElements.personalisedSectionTitle));
    }

    public void clickStoreLocationDetail() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.storeLocationDetail);
    }

    public void verifyLoader() {
        waitVar.until(ExpectedConditions.visibilityOf(dashboardPageElements.loader));
    }

    public void verifyRewardInformation() {
        waitVar.until(ExpectedConditions.visibilityOf(dashboardPageElements.rewardInformation));
    }

    public String getRewardInformation() {
        return dashboardPageElements.rewardInformation.getText();
    }

    public void verifyHomeTab() throws InterruptedException {
        if (!isElementDisplayed(dashboardPageElements.homeTab, 30)) {
            Assert.assertTrue(false, "Home Page not displayed");
        }
        Thread.sleep(2000);
    }

    public void verifyDealsTab() {
        waitVar.until(ExpectedConditions.visibilityOf(dashboardPageElements.dealsTab));
    }


    public void verifyWalletTab() {
        waitVar.until(ExpectedConditions.visibilityOf(dashboardPageElements.walletTab));
    }

    public void verifySearchBar(String displayedOption) {
        if (displayedOption.contains("not")) {
            Assert.assertFalse(isElementDisplayed(dashboardPageElements.searchBar), "Search Bar shouldn't be displayed");
        } else {
            Assert.assertTrue(isElementDisplayed(dashboardPageElements.searchBar), "Search Bar should be displayed");
        }
    }


   /* public void clickDealsTab() throws InterruptedException {
        new WaitAction(driver).waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.dealsTab);
        Thread.sleep(2000);
        try {
            if (getPlatformName().equalsIgnoreCase("ios")) {
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.dismiss);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public void clickBogoTab() throws IndexOutOfBoundsException {
        new WaitAction(driver).waitForLoadingComplete();

        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.bogoTab);
        //    Thread.sleep(2000);
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void clickBogoMenuItems() throws IndexOutOfBoundsException {
        new WaitAction(driver).waitForLoadingComplete();

        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.bogoMenuItems);
        //    Thread.sleep(2000);
        new WaitAction(driver).waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.bogoProduct);
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void clickSurveyPopup() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.tooBusy);
    }

    public void verifyScanIcon() {
        waitVar.until(ExpectedConditions.visibilityOf(dashboardPageElements.scanIcon));
    }

    public boolean verifyDealSectionHeader() {
        return isElementDisplayed(dashboardPageElements.dealSectionHeader);
    }

    public void verifyPullScreenRefresh() {
        TouchAction touch = new TouchAction(driver);

        int windWidth = driver.manage().window().getSize().getWidth();
        int windHeight = driver.manage().window().getSize().getHeight();

        touch.press(PointOption.point(windWidth, windHeight / 2)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
                .moveTo(PointOption.point(windWidth, windHeight / 6)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .release().perform();

    }

    public void verifySpinnerComesWhenPullScreen() {
        waitVar.until(ExpectedConditions.visibilityOf(dashboardPageElements.PullScreenRefresh));

    }


    public void verifyBogoText() {
        waitVar.until(ExpectedConditions.visibilityOf(dashboardPageElements.bogoText));
    }

    public boolean verifySpinnerDisappearWhenContent() throws InterruptedException {

        Thread.sleep(3000);
        return isElementDisplayed(dashboardPageElements.PullScreenRefresh);


    }

    public void verifySeeAll() {
        waitVar.until(ExpectedConditions.visibilityOf(dashboardPageElements.seeAll));
    }

    public void verifyPersonalisedSectionTitleText() {
        Assert.assertTrue(dashboardPageElements.personalisedSectionTitle.getText().equalsIgnoreCase("Rise. Shine. Save."));
    }

    public boolean isBogoTabDisplayed() {
        return isElementDisplayed(dashboardPageElements.bogoTab, 100);
    }

    public boolean isProfileIconDisplayed() {
        boolean isDisplayed = false;
        if (isElementDisplayed(dashboardPageElements.profileIcon, 10)) {
            isDisplayed = true;
        } else {
            if (isElementDisplayed(dashboardPageElements.signInButton, 3)) {
                dashboardPageElements.signInButton.click();
                if (isElementDisplayed(dashboardPageElements.profileIcon, 10)) {
                    isDisplayed = true;
                }
            }
        }
        return isDisplayed;
    }

    public void scrollUpToProfileIconHomePage() {
        scrollUpForElement(dashboardPageElements.profileIcon);
    }

    public void scrollUptoShoppingMethod() {
        //scrollUpForElement(dashboardPageElements.shoppingModeDownArrow);
    }

    public void verifySalutationMessage() {
        String salutation = "";
        salutation = dashboardPageElements.greetingInfo.getText().substring(0, 4);
        Assert.assertEquals(salutation, "Good");
    }

    public String getUserFirstName() throws IOException {
        String greetingInfoText = "";
        greetingInfoText = dashboardPageElements.greetingInfo.getText().substring(0, 4);
        String firstName = greetingInfoText.substring(greetingInfoText.indexOf(",") + 1);
        return firstName;
    }


    public boolean verifyMyProfileIcon() {
        return isElementDisplayed(dashboardPageElements.profileIcon);
    }

    public void clickMyProfileIcon() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.profileIcon);
    }

    public boolean verifyMoreScreen() {
        return isElementDisplayed(dashboardPageElements.moreScreenTitle);
    }

    public void searchByProductName(String productName) {
        if (isElementDisplayed(dashboardPageElements.searchTextField, 10)) {
            new TapAction(driver).tapCoordinate(dashboardPageElements.searchTextField.getCenter().getX(), dashboardPageElements.searchTextField.getCenter().getY());
            switch (driver.getPlatformName().toUpperCase()) {
                case "ANDROID":
                    enterTextNoPressEnter(dashboardPageElements.detailSearchField, productName);
                    if (isElementDisplayed(dashboardPageElements.firstSearchResult, 10)) {
                        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.searchKeywordFromResult.get(0));
                    } else {
                        throw new RuntimeException("Search results were not displayed for search key: " + productName);
                    }
                    break;
                case "IOS":
                    enterKey(dashboardPageElements.detailSearchField, productName);
                    break;
            }
        } else {
            throw new RuntimeException("Search bar is not displayed on home page!!");
        }
    }

    public void searchByProductID(Integer amount, String IDType) throws InterruptedException {
        GG_ProductDetailsPage productDetailsPage = new GG_ProductDetailsPage(driver);
        GG_BrowsePage browsePage = new GG_BrowsePage(driver);
        if (isElementDisplayed(dashboardPageElements.searchTextField, 10)) {
            new TapAction(driver).tapCoordinate(dashboardPageElements.searchTextField.getCenter().getX(), dashboardPageElements.searchTextField.getCenter().getY());
            switch (IDType) {
                case "BOGO_1":
                    searchProductByOS(dashboardPageElements.detailSearchField, dashboardPageElements.clearTextSearchBar, ThreadLocalHelper.testCaseData.get().get("PRODUCT_ID_BOGO"));
                    break;
                case "BOGO_2":
                    searchProductByOS(dashboardPageElements.detailSearchField, dashboardPageElements.clearTextSearchBar, ThreadLocalHelper.testCaseData.get().get("PRODUCT_ID_BOGO_2"));
                    break;
                case "BOGO_3":
                    searchProductByOS(dashboardPageElements.detailSearchField, dashboardPageElements.clearTextSearchBar, ThreadLocalHelper.testCaseData.get().get("PRODUCT_ID_BOGO_3"));
                    break;
                default:
                    searchProductByOS(dashboardPageElements.detailSearchField, dashboardPageElements.clearTextSearchBar, IDType);
                    break;
            }
        }
        Assert.assertTrue(browsePage.isProductsListingPageDisplayed(), "Products listing page is not displayed");

        productDetailsPage.addMultipleProductCountsToCart(amount);
        productDetailsPage.goBackToHomePageFromProductDetailsPage();
    }

    public void searchByInvalidProductName(String productName) {
        new TapAction(driver).tapCoordinate(dashboardPageElements.searchTextField.getCenter().getX(), dashboardPageElements.searchTextField.getCenter().getY());
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                enterTextNoPressEnter(dashboardPageElements.detailSearchField, productName);
                new TapAction(driver).tapSearchEnterAndroid();
                break;
            case "IOS":
                enterKey(dashboardPageElements.detailSearchField, productName);
                break;
        }
    }

    public void enterTextInSearchField(String productName) throws InterruptedException {
        enterTextNoPressEnter(dashboardPageElements.detailSearchField, productName);
        Thread.sleep(2000);
    }

    public void selectFirstItemFromSearchResult() {
        new WaitAction(driver).waitForDisplayed(dashboardPageElements.searchKeywordFromResult.get(0));
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.searchKeywordFromResult.get(0));
    }

    public void selectFirstItemFromTheListToConfirmSearch() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new WaitAction(driver).waitForLoadingComplete();
            selectFirstItemFromSearchResult();
        }
    }

    public void checkRelevantItemsDisplayed() throws IOException {
        String searchKeyword = ThreadLocalHelper.testCaseData.get().get("SEARCH_KEYWORD");
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            dashboardPageElements.searchKeywordFromResult.get(0).getText().contains(searchKeyword);
        } else {
            dashboardPageElements.searchKeywordFromResult.get(0).getAttribute("text").contains(searchKeyword);
        }
    }

    public void closeToggleInfoPopup() {
        if (platformName.equalsIgnoreCase("iOS")) {
            if (isElementDisplayed(dashboardPageElements.toggleClose, 2)) {
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.toggleClose);
            }
        }
    }

    public boolean verifyTopAEMBanner() {
        return isElementDisplayed(dashboardPageElements.aemBanner);
    }

    public boolean verifyAEMBannerIsNotDisplayed() {
        return dashboardPageElements.aemBannerList.size() == 0;
    }

    public void scrollToFeaturesCarousel() {
        scrollDownForElement(dashboardPageElements.otherFeaturesRewards);
    }

    public boolean isRewardsModuleAtFirstPlace() {
        int rewardsStartX = dashboardPageElements.otherFeaturesRewards.getLocation().getX();
        int orderHistoryStartX = dashboardPageElements.otherFeaturesOrderHistory.getLocation().getX();
        int myProfileStartX = dashboardPageElements.otherFeaturesMyAccount.getLocation().getX();

        return rewardsStartX < orderHistoryStartX && orderHistoryStartX < myProfileStartX;
    }

    public boolean isOderHistoryModuleAtSecondPlace() {
        int rewardsStartX = dashboardPageElements.otherFeaturesRewards.getLocation().getX();
        int orderHistoryStartX = dashboardPageElements.otherFeaturesOrderHistory.getLocation().getX();
        int myProfileStartX = dashboardPageElements.otherFeaturesMyAccount.getLocation().getX();

        return orderHistoryStartX > rewardsStartX && orderHistoryStartX < myProfileStartX;
    }

    public boolean isMyProfileModuleAtThirdPlace() {
        int rewardsStartX = dashboardPageElements.otherFeaturesRewards.getLocation().getX();
        int orderHistoryStartX = dashboardPageElements.otherFeaturesOrderHistory.getLocation().getX();
        int myProfileStartX = dashboardPageElements.otherFeaturesMyAccount.getLocation().getX();

        return myProfileStartX > orderHistoryStartX && orderHistoryStartX > rewardsStartX;
    }

    public boolean isMyAccountAtFourthPlace() {
        int rewardsStartX = rewardpageElements.rewardsButton.getLocation().getX();
        int freshpassStartX = freshpassElements.FreshPassAtAccount.getLocation().getX();
        int walletStartX = walletPageElements.walletSubTab.getLocation().getX();
        int myAccountStartX = dashboardPageElements.otherFeaturesMyAccount.getLocation().getX();

        if (myAccountStartX > walletStartX && walletStartX > freshpassStartX && freshpassStartX > rewardsStartX) {
            return true;
        } else {
            return false;
        }
    }

    public void clickOnRewardsModuleInCarousel() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.otherFeaturesRewards);
        if (isElementDisplayed(dashboardPageElements.dismissCTA, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.dismissCTA);
        }
    }

    public void clickOnOrderHistoryModuleInCarousel() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.otherFeaturesOrderHistory);
    }

    public void clickOnMyProfileModuleInCarousel() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.otherFeaturesMyAccount);
    }

    public void verifyStaticImageInRewardInformation() {
        waitVar.until(ExpectedConditions.visibilityOf(dashboardPageElements.staticImageRewardInfo));
    }

    public void verifyStaticMessageInRewardInformation() {
        waitVar.until(ExpectedConditions.visibilityOf(dashboardPageElements.staticMsgRewardInfo));
    }

    public boolean verifySetupContactlessPayBanner() {
        return isElementDisplayed(dashboardPageElements.setupContactlessPayBannerDashboard);
    }

    public void clickOnSetupContactlessPayBanner() throws InterruptedException {
        scrollDown();
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.setupContactlessPayBannerDashboard);
        Thread.sleep(2000);
    }

    public void verifySetupContactlessPayScreen() {
        waitVar.until(ExpectedConditions.visibilityOf(dashboardPageElements.setupContactlessPayScreen));
    }

    public boolean scrollDownContactlessPayDashboardScreen() {
        return scrollDownForElement(dashboardPageElements.setupContactlessPayBannerDashboard);
    }

    public void verifyRewardsInformation() {
        waitVar.until(ExpectedConditions.visibilityOf(dashboardPageElements.staticImageRewardInfo));
    }

    public boolean verifyCartIconPresentNextToScanButton() {
        Point scanLoc = dashboardPageElements.scanIcon.getLocation();
        Point cartLoc = dashboardPageElements.cartIcon.getLocation();

        int scanX = scanLoc.getX();
        int scanY = scanLoc.getY();
        int cartX = cartLoc.getX();
        int cartY = cartLoc.getY();
        return Math.abs(cartX - scanX) > 35 && Math.abs(cartY - scanY) < 15;

    }

    public boolean verifyUserIsInBrowseTab() {
        return isElementDisplayed(dashboardPageElements.browsePageTitleHeader);
    }


    public void clickBackButtonOnMyReward() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.closeOrBackArrow);
        } else {
            navigateBack();
        }

    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void clickOrderHistoryButton() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.orderHistoryButton);
    }

    public void clickBackButtonOnOrderHistory() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.orderHistoryBackButton);
    }

    public boolean verifyRewardImage() {
        return isElementDisplayed(dashboardPageElements.rewardImage);
    }

    public boolean verifyDashboardPage() {
        return isElementDisplayed(dashboardPageElements.shoppingModeDownArrow);
    }

    public void scrollDownForOrderHistory() {
        scrollDownForElement(dashboardPageElements.orderHistoryButton);
    }


    public boolean signOut() throws InterruptedException {
        boolean signedOut = false;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
//            closeAndRelaunch();
//            if (!isElementDisplayed(dashboardPageElements.homeTab, 1)) {
//                for (int i = 0; i < 2; i++) {
//                    if (isElementDisplayed(dashboardPageElements.closeOrBackArrow, 1)) {
//                        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.closeOrBackArrow);
//                    }
//                    if (isElementDisplayed(dashboardPageElements.closeDrawer, 1)) {
//                        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.closeDrawer);
//                    }
//                }
//                int counter = 0;
//                while (counter < 4) {
//                    if (!isElementDisplayed(dashboardPageElements.homeTab, 1)) {
//                        driver.navigate().back();
//                    } else {
//                        break;
//                    }
//                    counter++;
//                } }
            if (isHomeScreenDisplayed()) {
                //do nothing here
            } else if (isElementDisplayed(dashboardPageElements.zipCodeEditText, 3)) {
                if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                    deleteCurrentTextInEditText(dashboardPageElements.zipCodeEditText);
                } else {
                    dashboardPageElements.zipCodeEditText.clear();
                }
                if (driver.getPlatformName().equalsIgnoreCase("android")) {
                    enterKey(dashboardPageElements.zipCodeEditText, device.getConfigureData(BannerConfType.BANNER_ZIPCODE));
                    new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.registerZipCodeNext);
                } else if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                    enterKey(dashboardPageElements.zipCodeEditText, device.getConfigureData(BannerConfType.BANNER_ZIPCODE));
                }
                new WaitAction(driver).waitForLoadingComplete();
                dashboardPageElements.deliverToZipButton.click();
                new WaitAction(driver).waitForClickableAndClick(dashboardPageElements.startShoppingButton);
                isHomeScreenDisplayed();
            }
            signOutOfApp();
            signedOut = true;
        }
        return signedOut;
    }

    public void signOutOfApp() throws InterruptedException {
//        for (int i = 0; i < 3; i++) {
//            if (isElementDisplayed(dashboardPageElements.Delivery_Next, 5))
//                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.Delivery_Next);
//            else {
//                break;
//            }
//        }
        scrollUpForElement(dashboardPageElements.profileIcon);
        new WaitAction(driver).waitForClickableAndClick(dashboardPageElements.profileIcon);
        new WaitAction(driver).waitForClickableAndClick(dashboardPageElements.signOutButton);
        new WaitAction(driver).waitForClickableAndClick(dashboardPageElements.confirmSignOutOkButton);
        Thread.sleep(3000);
//        closeApp();
    }


    public boolean isHomeScreenDisplayed() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (isElementDisplayed(dashboardPageElements.Allow, 10))
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.Allow);
        }


        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            try {
                if (dashboardPageElements.Continue.isDisplayed()) {
                    dashboardPageElements.Continue.click();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 3; i++) {
            if (isElementDisplayed(dashboardPageElements.Delivery_Next, 10))
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.Delivery_Next);
            else {
                break;
            }
        }
        waitVar.until(ExpectedConditions.visibilityOf(
                dashboardPageElements.UMA_Home));
        return isElementDisplayed(dashboardPageElements.UMA_Home, 10);
    }


    public void verifyHomeTabSelected() {
        Assert.assertTrue(dashboardPageElements.homeTab.isSelected());
    }

    public void clickHomeTab() {

        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.homeTab);
    }

    public void closeTestingSheetIfDisplayed() {
        if (driver.getPlatformName().equalsIgnoreCase("ANDROID"))
            if (isElementDisplayed(dashboardPageElements.testingSheetClose, 2)) {
                dashboardPageElements.testingSheetClose.click();
            }

    }

    public void clickOnDealsTab() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.dealsTab);
    }

    public void clickOnDealsTabWithLoveAppPopUpHandling() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.dealsTab);
        handleLoveAppPopup();
    }

    public void clickDealsTab() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.dealsTab);
        for (int i = 0; i < 2; i++) {
            if (isElementDisplayed(dashboardPageElements.nextButtonOfTutorialScreen, 2)) {
                dashboardPageElements.nextButtonOfTutorialScreen.click();
            } else {
                break;
            }
        }

        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            if (isElementDisplayed(dashboardPageElements.closeFeedback, 2)) {
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.closeFeedback);
            }
        }
    }

    public void clickBrowseTab() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.browseTab);
        waitForLoaderToDisappear();
    }

    public void clickWalletTab() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.walletTab);
        waitForLoaderToDisappear();
    }

    public void verifyDealsTabSelected() {
        Assert.assertTrue(dashboardPageElements.dealsTab.isSelected());
    }

    public void verifyBrowseTabSelected() {
        Assert.assertTrue(dashboardPageElements.browseTab.isSelected());
    }

    public void verifyMyListTabSelected() {
        Assert.assertTrue(dashboardPageElements.myListTab.isSelected());
    }

    public void verifyWalletTabSelected() {
        Assert.assertTrue(dashboardPageElements.walletTab.isSelected());
    }

    public void clickOnUpdateLaterIfDisplayed() {
        if (isElementDisplayed(dashboardPageElements.updateLater, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.updateLater);
        }
    }

    public void clickOnCancelButtonFeedbackFormIfDisplayed() {
        if (isElementDisplayed(dashboardPageElements.feedBackForm, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.cancelButtonOnFeedBackForm);
        }
    }

    public void clickOnNotNowWhenRatingFormIfDisplayed() {
        if (isElementDisplayed(dashboardPageElements.notNowRating, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.notNowRating);
        }
    }

    public void clickOnShoppingDownArrow() {
        waitForLoaderToDisappear();
        scrollUpForElement(dashboardPageElements.shoppingModeDownArrow);
        new TapAction(driver).tapCoordinate(dashboardPageElements.shoppingModeDownArrow.getCenter().getX(), dashboardPageElements.shoppingModeDownArrow.getCenter().getY());
    }

    public void clickOnDownArrowShoppingWithOutWait() {
        scrollUpForElement(dashboardPageElements.shoppingModeDownArrow);
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.shoppingModeDownArrow);
    }

    public void clickTextClearButtonOnSearchField() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.TextClearButtonOnSearchField);
        }
    }

    public boolean verifyTextClearedOnSearchField() {
        boolean isEmpty = false;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            try {
                isEmpty = dashboardPageElements.detailSearchField.getAttribute("value").isEmpty();
            } catch (NullPointerException npe) {
                isEmpty = true;
            }
        } else {
            isEmpty = (dashboardPageElements.detailSearchField.getText().isEmpty() || dashboardPageElements.detailSearchField.getText().contains("Search"));
        }
        return isEmpty;
    }

    public boolean verifyNoResultErrorMessageDisplayed() {
        return isElementDisplayed(dashboardPageElements.noResultErrorMessage);
    }

    public boolean isCurrentlyTrendingProductsDisplayed() {
        return isElementDisplayed(dashboardPageElements.currentlyTrendingLabel) && dashboardPageElements.currentlyTrendingProducts.size() > 0;
    }

    public boolean isRecentlySearchedProductsDisplayed() {
        return isElementDisplayed(dashboardPageElements.recentlySearchedLabel) && dashboardPageElements.recentlySearchedProducts.size() > 0;
    }

    public void clickOnClipButton() {
        scrollDownForElement(dashboardPageElements.clipButton);
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.clipButton);
    }

    public void isChangedToViewProduct() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Assert.assertTrue(dashboardPageElements.clipButton.getAttribute("label").equalsIgnoreCase("View product"));
        } else {
            Assert.assertTrue(dashboardPageElements.clipButton.getAttribute("text").equalsIgnoreCase("View product"));
        }
    }

    public boolean isPlusButtonDisplayed() {
        boolean isAddButtonDisplayed = false;
        if (driver.getPlatformName().equalsIgnoreCase("android"))
            if (isElementDisplayed(dashboardPageElements.plusButton)) {
                isAddButtonDisplayed = true;
            }
        return isAddButtonDisplayed;
    }

    public void allPopUpHandleOnHomePage() throws InterruptedException {
        new WaitAction(driver).waitForLoadingComplete();

        try {
            if (dashboardPageElements.dontAllowPopUpHandle.size() > 0) {
                new WaitAction(driver).waitForLoadingComplete();
                Thread.sleep(5000);
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.dontAllowPopUp);
                Thread.sleep(2000);
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.pickUpNext);
                Thread.sleep(2000);
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.dealsNext);
                Thread.sleep(2000);
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.walletNext);
            } else {
                System.out.println("there is no pop up in the homePage");
            }
        } catch (Exception ex) {
        }
    }

    public boolean isAddButtonDisplayed() {
        boolean isAddButtonDisplayed = false;
        if (driver.getPlatformName().equalsIgnoreCase("ios"))
            if (isElementDisplayed(dashboardPageElements.addButton)) {
                isAddButtonDisplayed = true;
            }
        return isAddButtonDisplayed;
    }

    public void verifySearchAndCartIcons() {

        Assert.assertTrue(isElementDisplayed(dashboardPageElements.searchIcon, 3) &&
                isElementDisplayed(dashboardPageElements.cartIcon, 3));
    }

    public boolean verifySearchAndCartIconsNotDisplayed() {

        return isElementDisplayed(dashboardPageElements.searchIcon) &&
                isElementDisplayed(dashboardPageElements.cartIcon, 3);
    }

    public boolean verifyMyAccountIsDisplayed() {
        return isElementDisplayed(dashboardPageElements.otherFeaturesMyAccount);
    }

    public void clickOnTopAEMBanner() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.aemBanner);
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            if (isElementDisplayed(dashboardPageElements.cachingContinueBtn, 3)) {
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.cachingContinueBtn);
            }
        }
    }

    public void isInStoreSelected() {
        Assert.assertTrue(dashboardPageElements.shoppingModeDownArrow.getAttribute("label").contains("In-store"));
    }

    public boolean isAEMBackButtonDisplayed() {
        return isElementDisplayed(dashboardPageElements.aemBannerBack);
    }

    public void clickOnBannerAd() {
        scrollDownForElement(dashboardPageElements.bannerAd);
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.bannerAd);
    }

    public boolean verifyBottomTabBarOrder() {
        Boolean tabBarOrder = null;
        int homeTabStartX = dashboardPageElements.homeTab.getLocation().getX();
        int browseTabStartX = dashboardPageElements.browseTab.getLocation().getX();
        int dealsTabStartX = dashboardPageElements.dealsTab.getLocation().getX();
        int mylistTabStartX = dashboardPageElements.myListTab.getLocation().getX();
        int walletTabStartX = dashboardPageElements.walletTab.getLocation().getX();

        tabBarOrder = walletTabStartX > mylistTabStartX && mylistTabStartX > dealsTabStartX && dealsTabStartX > browseTabStartX && browseTabStartX > homeTabStartX;
        return tabBarOrder;
    }

    public boolean isbottomNavigationBarDisplayed() {
        return isElementDisplayed(dashboardPageElements.bottomNavigationBar);
    }

    public boolean isRewardModuleDisplayed() {
        scrollDownForElement(dashboardPageElements.rewardModule);
        return isElementDisplayed(dashboardPageElements.rewardModule);
    }

    public boolean isOrderStatusDisplayed() {
        return isElementDisplayed(dashboardPageElements.orderStatus);
    }

    public boolean isMonopolyBannerDateValid() throws ParseException, IOException {
        boolean isMonopolyBannerDateValid = false;
        DateFormat df = new SimpleDateFormat("MMMM dd, yyyy");
        String deviceDate = df.format(Calendar.getInstance().getTime());
        Date todayDate = new SimpleDateFormat("MMMM dd, yyyy").parse(deviceDate);
        String date = ThreadLocalHelper.testCaseData.get().get("MONOPOLY_DATE");
        Date monopolyDate = new SimpleDateFormat("MMMM dd, yyyy").parse(date);
        if (todayDate.compareTo(monopolyDate) <= 0) {
            isMonopolyBannerDateValid = true;
        }
        return isMonopolyBannerDateValid;
    }

    public boolean isMonopolyBannerDisplayed() throws ParseException, IOException {
        boolean isMonopolyBannerDisplayed = false;
        if (isMonopolyBannerDateValid()) {
            scrollDownForElement(dashboardPageElements.monopolyBanner);
            Boolean monopolyBannerStatus = isElementDisplayed(dashboardPageElements.monopolyBanner);
            if (monopolyBannerStatus == false) {
                scrollUpForElement(dashboardPageElements.monopolyBanner);
            }
            if (isElementDisplayed(dashboardPageElements.monopolyBanner)) {
                isMonopolyBannerDisplayed = true;
            }
        } else {
            isMonopolyBannerDisplayed = true;
        }
        return isMonopolyBannerDisplayed;
    }

    public void clickOnMonopolyBanner() throws ParseException, IOException {
        if (isMonopolyBannerDateValid()) {
            scrollDownForElement(dashboardPageElements.monopolyBanner);
            new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.monopolyBanner);
        }
    }

    public boolean isBackButtonDisplayedOnShopPlayWinPage() throws ParseException, IOException {
        boolean isBackButtonDisplayedOnShopPlayWinPage = false;
        if (isMonopolyBannerDateValid()) {
            waitForLoaderToDisappear();
            if (isElementDisplayed(dashboardPageElements.backToDashboardButton)) {
                isBackButtonDisplayedOnShopPlayWinPage = true;
            }
        } else {
            isBackButtonDisplayedOnShopPlayWinPage = true;
        }
        return isBackButtonDisplayedOnShopPlayWinPage;
    }


    public void clickBackButtonInShopToWinPage() throws ParseException, IOException {
        if (isMonopolyBannerDateValid()) {
            new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.backToDashboardButton);
        }

    }

    public boolean isShopToWinPageDisplayed() throws ParseException, IOException {
        boolean isShopToWinPageDisplayed = false;
        if (isMonopolyBannerDateValid()) {
            if (dashboardPageElements.shopPlayWinTitle.getText().equals("Shop Play Win")) {
                isShopToWinPageDisplayed = true;
            }
        } else {
            isShopToWinPageDisplayed = true;
        }
        return isShopToWinPageDisplayed;
    }

    public void clickOnNextButtonOnTutorialScreen() {
        if (isElementDisplayed(dashboardPageElements.nextButtonOfTutorialScreen)) {
            new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.nextButtonOfTutorialScreen);
        }
    }

    public void clickDontAllow() {
        if (isElementDisplayed(dashboardPageElements.dontAllowBtn, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.dontAllowBtn);
        }
    }

    public void clickAllow() {
        if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
            if (isElementDisplayed(dashboardPageElements.allowNotificationPermissionPopup, 2)) {
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.allowNotificationPermissionPopup);
            }
        }
    }

    public void clickContinueCache() {
        waitForLoaderToDisappear();
        if (isElementDisplayed(dashboardPageElements.cachingContinueBtn, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.cachingContinueBtn);
        }
    }

    public void clickRandomLocationOnScreenTutorials() {
        if (!isElementDisplayed(dashboardPageElements.nextButtonOfTutorialScreen, 5)) {
            return;
        }

        if (!isElementDisplayed(dashboardPageElements.homeTab, 5)) {
            TouchAction action = new TouchAction(driver);
            int windowWidth = driver.manage().window().getSize().getWidth();
            int windowHeight = driver.manage().window().getSize().getHeight();
            action.tap(PointOption.point(windowWidth, windowHeight / 2)).perform();
        }
    }

    public boolean isTutorialScreenDisplayed() {
        boolean isTutorialScreenDisplayed = isElementDisplayed(dashboardPageElements.nextButtonOfTutorialScreen);
        return isTutorialScreenDisplayed;
    }

    public boolean isSearchBarDisplayed() {
        return isElementDisplayed(dashboardPageElements.searchBar);
    }

    public boolean isSearchIconDisplayed() {
        return isElementDisplayed(dashboardPageElements.searchIconInHomePage);
    }

    public void clickOnSearchIconOnHomePage() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.searchIconInHomePage);
    }

    public boolean isLoadingSpinnerDisplayed() {
        return isElementDisplayed(dashboardPageElements.loadingSpinnerMonopoly);
    }

    public void clickSearchIconOnProductViewAllSection() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.searchIconOnProductViewAllSection);
    }

    public void skipTutorial() {
        if (isElementDisplayed(dashboardPageElements.nextButtonTutorial, 4)) {
            TouchAction action = new TouchAction(driver);
            int windowWidth = driver.manage().window().getSize().getWidth();
            int windowHeight = driver.manage().window().getSize().getHeight();
            action.tap(PointOption.point(windowWidth, windowHeight / 2)).perform();
        }
    }

    public void skipTutorialV2() {
        if (!isElementDisplayed(dashboardPageElements.homeTab, 5)) {
            TouchAction action = new TouchAction(driver);
            int windowWidth = driver.manage().window().getSize().getWidth();
            int windowHeight = driver.manage().window().getSize().getHeight();
            action.tap(PointOption.point(windowWidth / 2, windowHeight * 5 / 6)).perform();
        }
    }

    public void handleTutorial(int waitSeconds) {
        for (int i = 0; i < 3; i++) {
            if (isElementDisplayed(dashboardPageElements.nextButtonTutorial, waitSeconds)) {
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.nextButtonTutorial);
            } else {
                break;
            }
        }
    }

    public void scrollTillDealsSectionIsVisible() {
        scrollDownForElement(dashboardPageElements.dealExpiry);
    }


    public boolean verifyTutorialIsDisplayed(String tutorialName) {
        boolean isDisplayed = false;
        switch (tutorialName.toUpperCase()) {
            case "SHOPPING MODE":
                isDisplayed = (driver.getPlatformName().equalsIgnoreCase("ios")) ? isElementDisplayed(dashboardPageElements.shoppingMethodTutorialMsg) : getText(dashboardPageElements.shoppingMethodTutorialMsg).contains("Choose delivery");
                break;
            case "DEALS":
                isDisplayed = (driver.getPlatformName().equalsIgnoreCase("ios")) ? isElementDisplayed(dashboardPageElements.dealsTutorialMsg) : getText(dashboardPageElements.dealsTutorialMsg).contains("coupons");
                break;
            case "WALLET":
                isDisplayed = (driver.getPlatformName().equalsIgnoreCase("ios")) ? isElementDisplayed(dashboardPageElements.walletTutorialMsg) : getText(dashboardPageElements.walletTutorialMsg).contains("Wallet");
                break;
        }

        return isDisplayed;
    }

    public void handleLoveAppPopup() {
        if (isElementDisplayed(dashboardPageElements.loveAppPopupLabel, 2)) {
            if (isElementDisplayed(dashboardPageElements.loveAppPopupYesBtn, 2)) {
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.loveAppPopupYesBtn);
            }
            if (isElementDisplayed(dashboardPageElements.dismissCTA, 2)) {
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.dismissCTA);
            }
            clickOnNotNowWhenRatingFormIfDisplayed();
        }
    }

    public void clickOnDismissCTA() {
        if (isElementDisplayed(dashboardPageElements.dismissCTA)) {
            new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.dismissCTA);
        }
    }

    public void signOutFromTheApp() {
        if (isElementDisplayed(otpPasswordPageElements.SSO_Screen_Message, 2) || isElementDisplayed(otpPasswordPageElements.switchEmail, 1)) {
            return;
        }

        scrollUpForElement(dashboardPageElements.profileIcon);
        new TapAction(driver).tapCoordinate(dashboardPageElements.profileIcon.getCenter().getX(), dashboardPageElements.profileIcon.getCenter().getY());
        if (!(isElementDisplayed(dashboardPageElements.signOutButton, 8)))
            new TapAction(driver).tapCoordinate(dashboardPageElements.profileIcon.getCenter().getX(), dashboardPageElements.profileIcon.getCenter().getY());
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.signOutButton);
        new WaitAction(driver).waitForDisplayed(dashboardPageElements.confirmSignOutOkButton, 8);
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.confirmSignOutOkButton);
        new WaitAction(driver).waitForElementToBeClickable(otpPasswordPageElements.switchEmail, 5);
    }

    public boolean isStartupPageDisplayed() {
        return isElementDisplayed(otpPasswordPageElements.SSO_Screen_Message, 2) || isElementDisplayed(otpPasswordPageElements.switchEmail, 1);
    }

    public void handlePopUpsAndTutorialOnDashboard() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (isElementDisplayed(dashboardPageElements.profileIcon, 2)) {
                return;
            }

            if (isElementDisplayed(dashboardPageElements.dontAllowBtn, 1)) {
                dashboardPageElements.dontAllowBtn.click();
            }

            // Skipping tutorial by clicking on random position on screen
            if (isElementDisplayed(dashboardPageElements.nextButtonOfTutorialScreen, 2)) {
                skipTutorial();
            }

            if (isElementDisplayed(dashboardPageElements.cachingContinueBtn, 1)) {
                dashboardPageElements.cachingContinueBtn.click();
            }
        } else {
            if (isElementDisplayed(dashboardPageElements.cachingContinueBtn, 5)) {
                dashboardPageElements.cachingContinueBtn.click();
            }
            try {
                for (int i = 0; i < 3; i++) {
                    if (isElementDisplayed(dashboardPageElements.nextButtonOfTutorialScreen, 3)) {
                        dashboardPageElements.nextButtonOfTutorialScreen.click();
                    } else {
                        break;
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean verifyHomeScreenIsDisplayed() throws IOException, InterruptedException {
        if (!isElementDisplayed(dashboardPageElements.profileIcon, 2)) {
            clickHomeTab();
            handlePopUpsAndTutorialOnDashboard();
        }
        return isElementDisplayed(dashboardPageElements.profileIcon, 10);
    }

    public void goToHomeTabWithTutorialHandling() {
        clickHomeTab();
        try {
            handlePopUpsAndTutorialOnDashboard();
        } catch (Exception e) {
            // Do nothing
        }
    }

    public boolean isWelcomeTutorialDisplayedOnDeals() {
        return driver.getPlatformName().equalsIgnoreCase("ios") ? isElementDisplayed(dashboardPageElements.welcomeDealsTutorialMsg) : getText(dashboardPageElements.welcomeDealsTutorialMsg).contains("Welcome to our new app! All coupons");
    }

    public boolean isHomeBrowseTutorialDisplayedOnDeals() {
        return driver.getPlatformName().equalsIgnoreCase("ios") ? isElementDisplayed(dashboardPageElements.homeBrowseTutorialMsg) : getText(dashboardPageElements.homeBrowseTutorialMsg).contains("Find your favorite products and browse categories");
    }

    public boolean isBuyItAgainModuleDisplayed() {
        return isElementDisplayed(dashboardPageElements.buyItAgainModule);
    }

    public boolean isBrowseCategoryModuleDisplayed() {
        if (isElementDisplayed(dashboardPageElements.browseCategoriesModule, 10)) {
            return true;
        } else {
            return scrollDownForElement(dashboardPageElements.browseCategoriesModule);
        }
    }

    public void swipeLeftInBuyItAgain() {
        for (int i = 0; i < 5; i++) {
            swipeLeftOnElement(dashboardPageElements.buyItAgainCards);
        }
    }

    public boolean verifyAlphabeticalOrderWhileSwipingLeftInBrowseCategoriesModule() {
        scrollDownForElement(dashboardPageElements.browseCategoriesCardText);
        ArrayList<String> originalList = new ArrayList<>();
        String firstLetterInCard = "";
        for (int i = 0; i < 4; i++) {
            if (driver.getPlatformName().equalsIgnoreCase("android")) {
                firstLetterInCard = dashboardPageElements.browseCategoriesCardsList.get(i).getAttribute("text").split("")[0];
            } else {
                firstLetterInCard = dashboardPageElements.browseCategoriesCardsList.get(i).getAttribute("label").split("")[0];
            }
            originalList.add(firstLetterInCard);
            swipeLeftOnElement(dashboardPageElements.browseCategoriesCards);
        }
        ArrayList<String> sortedList = new ArrayList<>(originalList);
        Collections.sort(sortedList);
        boolean isSorted = sortedList.equals(originalList);
        return isSorted;
    }

    public boolean verifyAlphabeticalOrderWhileSwipingLeftInBrowseDealsModule() {
        scrollDownForElement(dashboardPageElements.browseDealsCardText);
        ArrayList<String> originalList = new ArrayList<>();
        String firstLetterInCard = "";
        for (int i = 0; i < 4; i++) {
            if (driver.getPlatformName().equalsIgnoreCase("android")) {
                firstLetterInCard = dashboardPageElements.browseDealsCardsList.get(i).getAttribute("text").split("")[0];
            } else {
                firstLetterInCard = dashboardPageElements.browseCategoriesCardsList.get(i).getAttribute("label").split("")[0];
            }
            originalList.add(firstLetterInCard);
            swipeLeftOnElement(dashboardPageElements.browseDealsCards);
        }
        ArrayList<String> sortedList = new ArrayList<>(originalList);
        Collections.sort(sortedList);
        boolean isSorted = sortedList.equals(originalList);
        return isSorted;
    }

    public void swipeLeftInAEM() {
        scrollDownForElement(dashboardPageElements.aemAddButton);
        for (int i = 0; i < 5; i++) {
            swipeLeftOnElement(dashboardPageElements.aemCard);
        }
    }

    public boolean isWeeklyCouponModuleDisplayed() {
        scrollDownForElement(dashboardPageElements.weeklyCouponModule);
        return isElementDisplayed(dashboardPageElements.weeklyCouponModule);
    }

    public boolean isAemModuleDisplayed() {
        scrollDownForElement(dashboardPageElements.aemModule);
        return isElementDisplayed(dashboardPageElements.aemModule);
    }

    public boolean isWeCanHelpTitleIsDisplayed() {
        scrollDownForElement(dashboardPageElements.weCanHelpTitle);
        return isElementDisplayed(dashboardPageElements.weCanHelpTitle);
    }

    public boolean isSeeALlBtnNextToBrowseCategories() {
        scrollDownForElement(dashboardPageElements.seeAllBtnBrowseCategories);
        return isElementDisplayed(dashboardPageElements.seeAllBtnBrowseCategories);
    }

    public boolean isSeeALlBtnNextToBrowseDeals() {
        scrollDownForElement(dashboardPageElements.seeAllBtnBrowseDeals);
        return isElementDisplayed(dashboardPageElements.seeAllBtnBrowseDeals);
    }

    public boolean isSeeAllDealsBannerDisplayed() {
        return isElementDisplayed(dashboardPageElements.clipYourDealsLabel);
    }

    public void clickOnSeeAllDealsBanner() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.clipYourDealsLabel);
    }

    public boolean isCountDisplayed() {

        boolean isCountDisplayed = false;
        String count;
        count = dashboardPageElements.clipYourDealsLabel.getText().replaceAll("[^0-9]", "");
        if (count != null) {
            isCountDisplayed = true;
        }
        return isCountDisplayed;
    }

    public void swipeAndClickOnSeeAllLinkIfCardsMoreThenFifteen() {
        if (dashboardPageElements.dealCardContainer.size() == 1) {
            new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.seeAllLinkClipYourFavourite);
        } else {
            int counter = 1;
            int counter_max = 60;
            while (counter <= counter_max) {
                swipeActions.slideTheCardFromRightToLeft(dashboardPageElements.dealCardContainer.get(1));
                if (isElementDisplayed(dashboardPageElements.seeAllButtonInDealCard, 1)) {
                    break;
                }
                counter++;
            }
            new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.seeAllButtonInDealCard);
        }
    }

    public boolean isDealCountDisplayed() {
        return isElementDisplayed(dashboardPageElements.dealsCount);
    }

    public void clickOnSeeAllLink() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.seeAllLinkClipYourFavourite);
    }

    public boolean isSeeAllLinkDisplayed() {
        return scrollDownForElement(dashboardPageElements.seeAllLinkClipYourFavourite);
    }


    public int getDealCardCountInClipYourFavorite() throws InterruptedException {
        if (dashboardPageElements.dealsName.size() == 1) {
            return 1;
        }

        int maxSwipesForCard;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            maxSwipesForCard = 25;
        } else {
            maxSwipesForCard = 15;

        }

        ArrayList<String> savingEventList = new ArrayList<>();
        String currentSavingEventDescription = dashboardPageElements.dealsName.get(0).getText();
        savingEventList.add(currentSavingEventDescription);
        if (dashboardPageElements.dealsName.size() > 1) {
            int counter = 0;

            boolean moreDealsLeftToSwipe = true;
            while (moreDealsLeftToSwipe) {
                while (counter < maxSwipesForCard) {
                    swipeActions.slideTheCardFromRightToLeft(dashboardPageElements.dealsCard.get(1));
                    Thread.sleep(500);
                    currentSavingEventDescription = dashboardPageElements.dealsName.get(0).getText();
                    if (!savingEventList.contains(currentSavingEventDescription)) {
                        savingEventList.add(currentSavingEventDescription);
                        break;
                    }
                    counter++;
                }

                if (counter >= maxSwipesForCard) {
                    for (int k = 0; k < dashboardPageElements.dealsName.size(); k++) {
                        if (!savingEventList.contains(dashboardPageElements.dealsName.get(k).getText())) {
                            savingEventList.add(dashboardPageElements.dealsName.get(k).getText());
                        }
                    }

                    moreDealsLeftToSwipe = false;
                }
            }
        }
        return savingEventList.size();
    }

    public String getDealCardContent() {
        String dealName = dashboardPageElements.dealName.getText();
        return dealName;
    }

    public void checkDealContentInItemModules() {
        scrollDown();
        String dealCardNameUnderClipYourfavorite = getDealCardContent();
        String dealCardNameUnderItemModule = dashboardPageElements.dealName.getText();
        Assert.assertEquals(dealCardNameUnderClipYourfavorite, dealCardNameUnderItemModule);
    }

    public int getDealsCount() {
        int dealsCount;
        String count;
        count = dashboardPageElements.clipYourDealsLabel.getText().replaceAll("[^0-9]", "");
        dealsCount = Integer.valueOf(count);
        return dealsCount;
    }

    public int getCountUpdatedBeforeStoreChange() {
        int dealsCountBeforeStoreUpdate = getDealsCount();
        return dealsCountBeforeStoreUpdate;
    }

    public int getCountUpdatedAfterStoreChange() {
        int dealsCountAfterStoreUpdate = getDealsCount();
        return dealsCountAfterStoreUpdate;
    }

    public boolean isDealCountUpdated() {
        boolean isStoreUpdated = getCountUpdatedBeforeStoreChange() >= getCountUpdatedAfterStoreChange() || getCountUpdatedBeforeStoreChange() <= getCountUpdatedAfterStoreChange();
        return isStoreUpdated;
    }

    public boolean verifyDesiredLinkFromCarousel(String linkText) {
        boolean desiredLinkDisplayed = false;
        switch (linkText.toUpperCase()) {
            case "MY REWARDS":
                desiredLinkDisplayed = isElementDisplayed(dashboardPageElements.myRewardsDrawer);
                break;
            case "PHARMACY":
                desiredLinkDisplayed = isElementDisplayed(dashboardPageElements.pharmacyDrawer);
                break;
            case "MEALS":
                if (!isElementDisplayed(dashboardPageElements.freshPassDrawer, 2)) {
                    swipeLeftOnElement(dashboardPageElements.pharmacyDrawer);
                }
                desiredLinkDisplayed = isElementDisplayed(dashboardPageElements.freshPassDrawer);
                break;
            case "CLIPPED DEALS":
                if (!isElementDisplayed(dashboardPageElements.dealsDrawer, 2)) {
                    swipeLeftOnElement(dashboardPageElements.pharmacyDrawer);
                }
                desiredLinkDisplayed = isElementDisplayed(dashboardPageElements.dealsDrawer);
                break;
            case "WEEKLY AD":
                if (!isElementDisplayed(dashboardPageElements.weeklyAdDrawer, 2)) {
                    swipeLeftOnElement(dashboardPageElements.dealsDrawer);
                }
                desiredLinkDisplayed = isElementDisplayed(dashboardPageElements.weeklyAdDrawer);
                break;
        }
        return desiredLinkDisplayed;
    }

    public void clickLinkInShortcutsTrayOnHomePage(String linkText) {

        switch (linkText.toUpperCase()) {
            case "REWARDS":
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.myRewardsDrawer);
                scrollUp();
                break;
            case "Pharmacy":
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.pharmacyDrawer);
                break;
            case "FreshPass":
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.freshPassDrawer);
                break;
            case "Deals":
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.dealsDrawer);
                break;
            case "Weekly Ad":
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.weeklyAdDrawer);
                break;
        }
        waitForLoaderToDisappear();
    }

    public boolean isOrderHistoryDisplayed() {
        return isElementDisplayed(dashboardPageElements.orderHistoryButton);
    }

    public boolean isMyRewardCountDisplayed() {
        String rewardsCount = dashboardPageElements.myRewardModuleCount.getText().replaceAll("[^0-9]", "");
        return Integer.valueOf(rewardsCount) >= 1;
    }

    public boolean isClippedModuleCountDisplayed() {
        swipeLeftOnElement(dashboardPageElements.dealsDrawer);
        String clippedDealCount = dashboardPageElements.clippedModuleCount.getText().replaceAll("[^0-9]", "");
        return Integer.valueOf(clippedDealCount) >= 1;
    }

    public boolean isBrowseDealsModuleDisplayed() {
        if (isElementDisplayed(dashboardPageElements.browseDealsModule, 10)) {
            return true;
        } else {
            return scrollDownForElement(dashboardPageElements.browseDealsModule);
        }

    }

    public void clickOnCardInBrowseDeals() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.browseDealsCards);
    }

    public void clickSeeALlNextToBrowseDeals() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.seeAllBtnBrowseDeals);
    }

    public boolean hasUserLandedOnDeals() {
        return isElementDisplayed(dashboardPageElements.dealsTitleHeader, 5);
    }

    public boolean hasUserLandedOnHome() {
        return isElementDisplayed(dashboardPageElements.profileIcon, 5);
    }

    public boolean checkDefaultLandingToHomePresentAndVerifyLanding() {
        boolean landedOnDeals = true;
        EvalAttrs evalAttrs = new EvalAttrs(getCurrentEnv(), getCurrentBanner());
        boolean featureFound = false;
        JSONArray featureFlagArray = evalAttrs.getFeatureFlagStatusObject(StringUtil.convertObjectToString(constructEvalAttrsRequestBody(ThreadLocalHelper.testCaseData.get().get("APP_CODE_EVALATTRS_API"), ThreadLocalHelper.testCaseData.get().get("VERSION_EVALATTRS_API"), ThreadLocalHelper.testCaseData.get().get("APP_VERSION"))));
        for (int i = 0; i < featureFlagArray.length(); i++) {
            try {
                JSONObject obj = (JSONObject) featureFlagArray.get(i);
                if (obj.getString("featureFlagName").equalsIgnoreCase("defaultLandingToHomeV2")) {
                    featureFound = true;
                    break;
                }
            } catch (JSONException je) {
                Assert.assertTrue(false, "Exception caught while reading 'featureFlagName' key from evalattrs api, message: " + je.getMessage());
                break;
            }
        }
        if (!featureFound) {
            if (!isElementDisplayed(dashboardPageElements.dealsTitleHeader, 1)) {
                landedOnDeals = false;
            }
        }
        return landedOnDeals;
    }

    public void checkDefaultLandingToHomeValueAndVerifyTutorialsAndLanding() {
        if (EvalAttrs.isFeatureEnabledForGivenBanner("defaultLandingToHomeV2", getCurrentBanner(), getCurrentEnv(), constructEvalAttrsRequestBody(ThreadLocalHelper.testCaseData.get().get("APP_CODE_EVALATTRS_API"), ThreadLocalHelper.testCaseData.get().get("VERSION_EVALATTRS_API"), ThreadLocalHelper.testCaseData.get().get("APP_VERSION")))) {
            // Default landing to home doesn't work for iOS in QA2(works in PROD)
            if (driver.getPlatformName().equalsIgnoreCase("android")) {
                isDefaultHomePage = true;
                verifyTutorialIsDisplayed("SHOPPING MODE");
                clickOnNextButtonOnTutorialScreen();
                verifyTutorialIsDisplayed("DEALS");
                clickOnNextButtonOnTutorialScreen();
                verifyTutorialIsDisplayed("WALLET");
                clickOnNextButtonOnTutorialScreen();
                Assert.assertTrue(isElementDisplayed(dashboardPageElements.profileIcon, 4), "User did not land on home page");
            } else {
                verifyTutorialsForDealsLandingPage();
            }
        } else {
            verifyTutorialsForDealsLandingPage();
        }
    }

    public void checkDefaultLandingToHomeValueAndVerifyUserLanding() {
        if (EvalAttrs.isFeatureEnabledForGivenBanner("defaultLandingToHomeV2", getCurrentBanner(), getCurrentEnv(), constructEvalAttrsRequestBody(ThreadLocalHelper.testCaseData.get().get("APP_CODE_EVALATTRS_API"), ThreadLocalHelper.testCaseData.get().get("VERSION_EVALATTRS_API"), ThreadLocalHelper.testCaseData.get().get("APP_VERSION")))) {
            Assert.assertTrue(isElementDisplayed(dashboardPageElements.profileIcon, 4), "User did not land on home page");
        } else {
            Assert.assertTrue(isElementDisplayed(dashboardPageElements.dealsTitleHeader, 4), "User did not land on deals page");
        }
    }

    private EvalAttrsRequestBody constructEvalAttrsRequestBody(String appCode, String version, String appVersion) {
        EvalAttrsRequestBody evalAttrsRequestBody = new EvalAttrsRequestBody();
        EvalAttrsRequestBody.Attributes attributes = evalAttrsRequestBody.new Attributes();
        attributes.setBanner(RestApiUtils.resolveBannerNameForHost(getCurrentBanner()));
        attributes.setAppVersion(appVersion);
        evalAttrsRequestBody.setAppCode(appCode);
        evalAttrsRequestBody.setVersion(version);
        evalAttrsRequestBody.setAttributes(attributes);
        return evalAttrsRequestBody;
    }

    public boolean isDefaultHomePage() {
        return isDefaultHomePage;
    }

    public void verifyTutorialsForDealsLandingPage() {
        Assert.assertTrue(isWelcomeTutorialDisplayedOnDeals(), "Welcome tutorial on deals page is not displayed");
        clickOnNextButtonOnTutorialScreen();
        Assert.assertTrue(isHomeBrowseTutorialDisplayedOnDeals(), "Home-Browse tutorial on deals page is not displayed");
        clickOnNextButtonOnTutorialScreen();
        Assert.assertTrue(isElementDisplayed(dashboardPageElements.dealsTitleHeader, 4), "User did not land on deals page");
    }

    public void clickMyListTab() {
        new GG_DashboardPage(driver).clickOnCancelButtonFeedbackFormIfDisplayed();
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.myListTab);
        waitForLoaderToDisappear();
    }

    public boolean scrollDownForOutOfStockProduct() {
        return scrollDownForElement(productDetailsPageElements.outOfStockLabel);
    }

    public void clickOnRewardsModule() {
        scrollDownForElement(dashboardPageElements.rewardModule);
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.rewardModule);
    }

    public boolean waitForCacheContinue(int waitSeconds) {
        return isElementDisplayed(dashboardPageElements.cachingContinueBtn, waitSeconds);
    }

    public boolean waitForFeedbackForm(int waitSeconds) {
        return isElementDisplayed(dashboardPageElements.feedBackForm, waitSeconds);
    }

    public void clickOkIfDisplayed() {
        if (isElementDisplayed(dashboardPageElements.okBtn, 5)) {
            new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.okBtn);
        }
    }

    public String getSetupContactlessPayTitleDescription() {
        String contactLessTitleDescription;
        if (driver.getPlatformName().equalsIgnoreCase("Android")) {
            contactLessTitleDescription = (dashboardPageElements.setupContactlessPayBannerDashboard).getAttribute("content-desc");
        } else {
            contactLessTitleDescription = (dashboardPageElements.setupContactlessPayBannerDashboard).getText();
        }
        return contactLessTitleDescription;
    }

    public void verifyScanCode() {
        // Assert.assertTrue(isElementDisplayed(dashboardPageElements.memberScanCode, 5), "Internet was not turned Off successfully");
    }

    public void verifyForU() {
        //Assert.assertTrue(isElementDisplayed(dashboardPageElements.forYou, 5), "Internet was not turned Off successfully");

    }

    public void verifyFoodLotBannerDisplayed() {
        Assert.assertTrue(dashboardPageElements.foodLotBanner.isDisplayed(), "Food lot banner is not displayed");
    }

    public void clickFoodlotBanner() {
        dashboardPageElements.foodLotBanner.click();
    }

    public void clickMealsPlansHaloNavTab() {
        dashboardPageElements.mealPlansHaloNavTab.click();
    }

    public void scrollRightInHaloNavCarousel(String tabNameDesired, int maxScrollCnt) {
        List<MobileElement> tabNamesDisplayed = null;
        boolean flag = false;
        for (int scrollCnt = 0; scrollCnt < maxScrollCnt; scrollCnt++) {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                tabNamesDisplayed = driver.findElementsByXPath("//XCUIElementTypeCell/XCUIElementTypeButton[contains(@label,'View ')]");
            } else {
                tabNamesDisplayed = driver.findElementsByXPath("//*[contains(@content-desc,'Button for')]");
            }
            for (MobileElement tabName : tabNamesDisplayed) {
                if (tabName.getText().contains(tabNameDesired)) {
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                break;
            }
            scroll(tabNamesDisplayed.get(tabNamesDisplayed.size() - 1).getCenter().getX(), tabNamesDisplayed.get(tabNamesDisplayed.size() - 1).getCenter().getY(), tabNamesDisplayed.get(0).getCenter().getX(), tabNamesDisplayed.get(0).getCenter().getY());

        }
    }

    public void verifyFreshPassIconIsVisible() {
        Assert.assertTrue(isElementDisplayed(dashboardPageElements.freshPassIcon), "Fresh pass icon on halo nav is not displayed");
    }

    public void scrollLeftInHaloNavCarousel(String tabNameDesired, int maxScrollCnt) {
        List<MobileElement> tabNamesDisplayed = null;
        ELEMENT_FOUND_LOOP:
        for (int scrollCnt = 0; scrollCnt < maxScrollCnt; scrollCnt++) {

            //Fetch all the tab names and check if the tab is displayed
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                tabNamesDisplayed = driver.findElementsByXPath("//XCUIElementTypeCell/XCUIElementTypeButton[contains(@label,'View ')]");
            } else {
                tabNamesDisplayed = driver.findElementsByXPath("//*[contains(@content-desc,'Button for')]");
            }

            for (MobileElement tabName : tabNamesDisplayed) {
                if (getText(tabName).contains(tabNameDesired)) {
                    break ELEMENT_FOUND_LOOP;
                }
            }
            //Scroll from  first to last element
            scroll(tabNamesDisplayed.get(0).getCenter().getX(), tabNamesDisplayed.get(0).getCenter().getY(), tabNamesDisplayed.get(tabNamesDisplayed.size() - 1).getCenter().getX(), tabNamesDisplayed.get(tabNamesDisplayed.size() - 1).getCenter().getY());
        }


    }

    public void verifyRewardsIconIsVisible() {
        Assert.assertTrue(isElementDisplayed(dashboardPageElements.rewardsIcon), "Rewards icon on halo nav is not displayed");
    }

    public void clickHamburgerMenu() {
        waitForDisplayed(dashboardPageElements.userProfile, 10);
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.userProfile);
    }

    public boolean verifyPharmacyServicesPageTitle() {
        return isElementDisplayed(dashboardPageElements.pharmacyPageTitle);
    }

    public boolean verifyFreshPassPageTitle() {
        return isElementDisplayed(dashboardPageElements.freshPassPageTitle);
    }

    public boolean verifyRewardsPageTitle() {
        return isElementDisplayed(dashboardPageElements.rewardsPageTitle);
    }

    public void clickBackBtnInPharmacyServicesPage() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.backBtnInPharmacyServicesPage);
    }

    public void clickOnOrdersModuleInSettings() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.ordersModuleInSettings);
    }

    public String getCurrentShoppingMode() {
        return driver.getPlatformName().equalsIgnoreCase("IOS") ? dashboardPageElements.shoppingModeDownArrow.getText().split("address")[0].trim() : dashboardPageElements.shoppingMode.getText();
    }

    public String getCurrentShoppingAddress() {
        return driver.getPlatformName().equalsIgnoreCase("IOS") ? dashboardPageElements.shoppingModeDownArrow.getText().split("address")[1].trim() : dashboardPageElements.shoppingAddress.getText();
    }

    public void enterProductNameAndPressSearchBtn(String productName) {
        if (isElementDisplayed(dashboardPageElements.searchTextField, 10)) {
            new TapAction(driver).tapCoordinate(dashboardPageElements.searchTextField.getCenter().getX(), dashboardPageElements.searchTextField.getCenter().getY());
            switch (driver.getPlatformName().toUpperCase()) {
                case "ANDROID":
                    // Clicking search icon by coordinates for android
                    enterTextNoPressEnter(dashboardPageElements.detailSearchField, productName);
                    int height = driver.findElement(By.id("drawer_layout")).getSize().getHeight();
                    int width = driver.findElement(By.id("drawer_layout")).getSize().getWidth();
                    int searchX = driver.findElement(By.id("drawer_layout")).getLocation().getX() + width;
                    int searchY = driver.findElement(By.id("drawer_layout")).getLocation().getY() + height;
                    for (int i = 5; i < 20; i = i + 5) {
                        new TapAction(driver).tapCoordinate(searchX - i, searchY - i);
                        if (isElementDisplayed(dashboardPageElements.clearTextSearchBar, 2)) {
                            enterTextNoPressEnter(dashboardPageElements.detailSearchField, productName);
                            // This is for different keyboard
                            driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
                        } else {
                            break;
                        }
                    }
                    break;
                case "IOS":
                    enterKey(dashboardPageElements.detailSearchField, productName);
                    break;
            }
        } else {
            throw new RuntimeException("Search bar is not displayed on home page!!");
        }
    }
}

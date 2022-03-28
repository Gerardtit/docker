package com.automation.steps;

import com.automation.helpers.AppActions;
import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.BasePage;
import com.automation.pages.GG_DashboardPage;
import com.automation.pages.GG_ShoppingModePage;
import com.automation.pages.GG_SignInPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class GG_ShoppingModePageSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_ShoppingModePage gg_shoppingModePage = new GG_ShoppingModePage(driver);
    public BasePage basePage = new BasePage(driver);
    public GG_SignInPage signInPage = new GG_SignInPage(driver);

    @When("^select Pick UP shopping mode$")
    public void clickOnPickUpShoppingMode() throws InterruptedException {
        gg_shoppingModePage.clickOnPickupShoppingMode();
    }

    @Then("^select Delivery shopping mode$")
    public void clickOnDeliveryShoppingMode() throws InterruptedException {
        gg_shoppingModePage.clickOnDeliveryShoppingMode();
    }

    @When("^select In-Store shopping mode$")
    public void clickOnInStoreShoppingMode() throws InterruptedException {
        gg_shoppingModePage.clickOnInStoreShoppingMode();
    }

    @And("^click on start Shopping Button$")
    public void clickOnStartShoppingButton() {
        gg_shoppingModePage.clickOnStartShoppingButton();
    }


    @And("^click on right arrow button on zipcode page$")
    public void clickOnZipCodeButton() {
        gg_shoppingModePage.clickOnZipCodeRightArrow();
    }

    @Then("^verify reserve a time option is present$")
    public void verifyReserveATimeOptionIsPresent() {
        Assert.assertTrue(gg_shoppingModePage.verifyReserveATimeOptionIsPresent());
    }

    @Then("^user clicks reserve a time option on hompage$")
    public void userclicks_ReserveTime() {
        gg_shoppingModePage.clickOnReserveTime();
    }

    @Then("^verify pickup shopping mode is selected$")
    public void verifyPickupShoppingModeIsSelected() {
        Assert.assertTrue(gg_shoppingModePage.verifyPickupShoppingModeIsSelected());
    }

    @And("^change to delivery shopping mode$")
    public void changeToDeliveryShoppingMode() throws InterruptedException {
        gg_shoppingModePage.changeToDeliveryShoppingMode();
    }

    @Then("^verify delivery shopping mode is selected$")
    public void verifyDeliveryShoppingModeIsSelected() {
        gg_shoppingModePage.verifyDeliveryShoppingModeIsSelected();
//        Assert.assertTrue(gg_shoppingModePage.verifyDeliveryShoppingModeIsSelected());
    }

    @Then("^verify reserve a time option is not present$")
    public void verifyReserveATimeOptionIsNotPresent() {
        Assert.assertFalse(gg_shoppingModePage.verifyReserveATimeOptionIsPresent());
    }

    @And("^scroll up the screen$")
    public void scrollUpTheScreen() {
        basePage.scrollUp();
    }

    @When("^click on reserve a time$")
    public void clickOnReserveATime() {
        gg_shoppingModePage.clickOnReserveATime();
    }

    @Then("^verify reserve a time page is displayed$")
    public void verifyReserveATimePageIsDisplayed() {
        Assert.assertTrue(gg_shoppingModePage.verifyReserveATimePageIsDisplayed());
    }

    @And("^click back button on reserve a time page$")
    public void clickBackButtonOnReserveATimePage() {
        gg_shoppingModePage.clickBackButtonOnReserveATimePage();
    }

    @And("^change to instore shopping mode$")
    public void changeToInstoreShoppingMode() throws InterruptedException {
        gg_shoppingModePage.changeToInstoreShoppingMode();
    }

    @Then("^verify instore shopping mode is selected$")
    public void verifyInstoreShoppingModeIsSelected() {
        Assert.assertTrue(gg_shoppingModePage.verifyInstoreShoppingModeIsSelected());
    }

    @Then("^verify shopping address$")
    public void verifyShoppingAddress() {
        Assert.assertTrue(gg_shoppingModePage.verifyShoppingAddress());
    }

    @Then("^verify user is in shopping mode screen$")
    public void verifyUserIsInShoppingModeScreen() {
        Assert.assertTrue(gg_shoppingModePage.verifyUserIsInShoppingModeScreen());
    }

    @And("^select the store which has AEM products enabled$")
    public void selectPickupStoreWithAEM() throws IOException, InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_AEM_CAROUSEL");
        String storeName = "";
        String shoppingMode = ThreadLocalHelper.testCaseData.get().get("SHOPPING_MODE_AEM_CAROUSEL");
        if (!shoppingMode.equalsIgnoreCase("DELIVERY")) {
            storeName = ThreadLocalHelper.testCaseData.get().get("STORENAME_AEM_CAROUSEL");
        }
        changeStoreIfShoppingModeOrStoreIsDifferent(shoppingMode, zipCode, storeName);
    }

    @And("^select the store which has exclusive brands enabled$")
    public void selectStoreWithExclusiveBrands() throws InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_EXCLUSIVE");
        String storeName = ThreadLocalHelper.testCaseData.get().get("STORENAME_EXCLUSIVE");
        String shoppingMode = ThreadLocalHelper.testCaseData.get().get("SHOPPING_MODE_EXCLUSIVE");
        changeStoreIfShoppingModeOrStoreIsDifferent(shoppingMode, zipCode, storeName);
    }

    @And("^select the store which supports fuel service$")
    public void selectStoreWithFuelService() throws InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_FUEL");
        String storeName = ThreadLocalHelper.testCaseData.get().get("STORENAME_FUEL");
        String shoppingMode = ThreadLocalHelper.testCaseData.get().get("SHOPPING_MODE_FUEL");
        if (storeName.equalsIgnoreCase("NA")) {
            Assert.assertTrue(false, "This banner doesn't have a store that supports fuel service!!");
        } else {
            changeStoreIfShoppingModeOrStoreIsDifferent(shoppingMode, zipCode, storeName);
        }
    }

    @And("^select the store which supports pharmacy service$")
    public void selectStoreWithPharmacyService() throws InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_PHARMACY");
        String storeName = ThreadLocalHelper.testCaseData.get().get("STORENAME_PHARMACY");
        String shoppingMode = ThreadLocalHelper.testCaseData.get().get("SHOPPING_MODE_PHARMACY");
        if (storeName.equalsIgnoreCase("NA")) {
            Assert.assertTrue(false, "This banner doesn't have a store that supports pharmacy service!!");
        } else {
            changeStoreIfShoppingModeOrStoreIsDifferent(shoppingMode, zipCode, storeName);
        }
    }

    @And("^select the store which supports both fuel and pharmacy services$")
    public void selectStoreWithFuelPharmacyService() throws InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_FUEL_PHARMACY");
        String storeName = ThreadLocalHelper.testCaseData.get().get("STORENAME_FUEL_PHARMACY");
        String shoppingMode = ThreadLocalHelper.testCaseData.get().get("SHOPPING_MODE_FUEL_PHARMACY");
        if (!storeName.equalsIgnoreCase("NA")) {
            changeStoreIfShoppingModeOrStoreIsDifferent(shoppingMode, zipCode, storeName);
        }
    }

    @And("^select the store which has contact less pay banner$")
    public void selectStoreWithPayCard() throws InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_PAYBANNER");
        String storeName = ThreadLocalHelper.testCaseData.get().get("STORENAME_PAYBANNER");
        String shoppingMode = ThreadLocalHelper.testCaseData.get().get("SHOPPING_MODE_PAYBANNER");
        changeStoreIfShoppingModeOrStoreIsDifferent(shoppingMode, zipCode, storeName);
    }

    @And("select different store using zip, shopping type and store")
    public void selectStore() throws InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_DIFF");
        String storeName = ThreadLocalHelper.testCaseData.get().get("STORENAME_DIFF");
        String shoppingMode = ThreadLocalHelper.testCaseData.get().get("SHOPPING_MODE_DIFF");
        new GG_DashboardPage(driver).clickOnShoppingDownArrow();
        selectStore(zipCode, shoppingMode, storeName);
    }

    public void selectStore(String zipCode, String shoppingMode, String storeName) throws InterruptedException {
        switch (shoppingMode) {
            case "DELIVERY":
                gg_shoppingModePage.changeDeliveryZipCode(zipCode);
                break;
            case "PICKUP":
                gg_shoppingModePage.changePickupStore(zipCode, storeName);
                break;
            default:
                gg_shoppingModePage.changeInStoreRunStore(zipCode, storeName);
        }
    }

    @And("^select the pick-up store$")
    public void selectPickupStoreWithProductsInBrowseTab() throws InterruptedException, IOException {
        String zipCode = basePage.getBannerPropertiesMap().get("ZIPCODE_PICKUP");
        String storeName = basePage.getBannerPropertiesMap().get("STORENAME_PICKUP");
        changePickUpStoreIfCurrentStoreIsDifferent(zipCode, storeName);
    }

    @And("select store with no product out of stock")
    public void selectStoreWithNoProductOutOfStock() throws InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_CART_2");
        String storeName = ThreadLocalHelper.testCaseData.get().get("STORENAME_CART_2");
        changePickUpStoreIfCurrentStoreIsDifferent(zipCode, storeName);
    }

    @And("select store with no product out of stock forced")
    public void selectStoreWithNoProductOutOfStockForced() throws InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_CART_2");
        String storeName = ThreadLocalHelper.testCaseData.get().get("STORENAME_CART_2");
        changePickUpStore(zipCode, storeName);
    }

    @And("select pick-up store with substitutionV2 enabled")
    public void selectStoreWithSubV2() throws InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_SUBV2");
        String storeName = ThreadLocalHelper.testCaseData.get().get("STORENAME_SUBV2");
        changePickUpStore(zipCode, storeName);
    }

    @And("select store with product out of stock")
    public void selectStoreWithProductOutOfStock() throws InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_CART_OUT_OF_STOCK");
        String storeName = ThreadLocalHelper.testCaseData.get().get("STORENAME_CART_OUT_OF_STOCK");
        changePickUpStoreIfCurrentStoreIsDifferent(zipCode, storeName);
    }

    @And("select store with product out of stock forced")
    public void selectStoreWithProductOutOfStockForced() throws InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_CART_OUT_OF_STOCK");
        String storeName = ThreadLocalHelper.testCaseData.get().get("STORENAME_CART_OUT_OF_STOCK");
        changePickUpStore(zipCode, storeName);
    }

    @And("select store with club card saving forced")
    public void selectStoreWithClubCardSavingsForced() throws InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_CLUB_CARD_SAVINGS");
        String storeName = ThreadLocalHelper.testCaseData.get().get("STORENAME_CLUB_CARD_SAVINGS");
        changePickUpStore(zipCode, storeName);
    }

    @And("select store with club card saving")
    public void selectStoreWithClubCardSavings() throws InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_CLUB_CARD_SAVINGS");
        String storeName = ThreadLocalHelper.testCaseData.get().get("STORENAME_CLUB_CARD_SAVINGS");
        changePickUpStoreIfCurrentStoreIsDifferent(zipCode, storeName);
    }

    @And("select store with product no stock")
    public void selectStoreWithProductNoStock() throws InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_CART_NO_STOCK");
        String storeName = ThreadLocalHelper.testCaseData.get().get("STORENAME_CART_NO_STOCK");
        changePickUpStoreIfCurrentStoreIsDifferent(zipCode, storeName);
    }

    @And("^select the delivery store$")
    public void selectDeliveryStoreWithProductsInBrowseTab() throws IOException, InterruptedException {
        String zipCode = basePage.getBannerPropertiesMap().get("ZIPCODE_DELIVERY");
        changeDeliveryZipIfZipIsDifferent(zipCode);
    }

    @And("^select in-store run using zip code and store name")
    public void selectInStoreRunUsingZipCodeAndStoreName() throws IOException, InterruptedException {
        String zipCode = basePage.getBannerPropertiesMap().get("ZIPCODE_INSTORE");
        String storeName = basePage.getBannerPropertiesMap().get("STORENAME_INSTORE");
        changeInStoreRunStoreIfCurrentStoreIsDifferent(zipCode, storeName);
    }

    @And("^click On use my location button$")
    public void clickOnUseMyLocationLink() {
        gg_shoppingModePage.clickOnUseMyLocation();
    }

    @And("^verify 'How do you want your groceries' is Displayed$")
    public void verifyHowDoYouWantYourGroceriesTitle() {
        gg_shoppingModePage.verifyHowDoYouWantYourGroceriesTitle();
    }

    @And("^Enter the ZipCode$")
    public void enterZipCode() {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_DEFAULT");
        gg_shoppingModePage.enterZipCode(zipCode);
    }

    @And("^user enters zipcode belonging to different banner$")
    public void enterZipCodeDifferentBanner() {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_DIFFERENT_BANNER");
        gg_shoppingModePage.enterZipCode(zipCode);
    }

    @And("^change the zipcode in zipcode screen$")
    public void changeTheZipCode() throws IOException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_DIFFERENT");
        gg_shoppingModePage.changeTheZipCode(zipCode);
    }

    @And("^verify zipcode search bar with default zipcode$")
    public void verifyZipcodeBarWithDefaultZipcode() throws IOException, InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_INSTORE");
        gg_shoppingModePage.verifySearchBarWithDefaultZipCode(zipCode);
    }

    @And("^verify Delivery Shopping Mode Option is Displayed$")
    public void verifyDeliveryShoppingModeOptionIsDisplayed() {
        Assert.assertTrue(gg_shoppingModePage.verifyDeliveryShoppingModeOption());
    }

    @And("^verify Pick Up Shopping Mode Option is Displayed$")
    public void verifyPickUPShoppingModeOptionIsDisplayed() {
        Assert.assertTrue(gg_shoppingModePage.verifyPickUpShoppingModeOption());
    }

    @And("^click On Back Button of Shopping Mode Page$")
    public void clickOnBackButtonOfShoppingModePage() {
        gg_shoppingModePage.clickOnShoppingModeBackButton();
    }

    @And("^verify user is navigated to zipcode screen$")
    public void verifyZipcodeScreenNavigation() {
        Assert.assertTrue(gg_shoppingModePage.isZipcodeScreenDisplayed(), "Zip code screen not displayed");
    }

    @And("^verify start shopping CTA is displayed$")
    public void verifyStartShoppingCTAIsDisplayed() {
        gg_shoppingModePage.isStartShoppingCTADisplayed();
    }

    @And("^Enter the ZipCode on Shopping Mode page$")
    public void enterZipCodeOnShoppingModePage() throws IOException, InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_DIFFERENT");
        gg_shoppingModePage.enterZipCodeInShoppingModePage(zipCode);
    }

    @And("^verify store is Listed for entered zipcode in the shopping mode page$")
    public void isStoreListedForEnteredZipcode() throws IOException, InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_BUY_AGAIN");
        gg_shoppingModePage.isStoreListedForEnteredZipcode(zipCode);
    }

    @And("^verify store is Listed for entered zipcode on the zipcode screen$")
    public void isStoreListedForZipcodeEntered() throws IOException, InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_INSTORE");
        gg_shoppingModePage.isStoreListedForEnteredZipcode(zipCode);
    }

    @And("user selects a pickup store that supports SNAP EBT payment")
    public void selectPickupStoreWithSNAPEBTInBrowseTab() throws InterruptedException {
        if (!ThreadLocalHelper.testCaseData.get().get("STORENAME_SNAP").trim().equals("NA")) {
            String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_SNAP");
            String storeName = ThreadLocalHelper.testCaseData.get().get("STORENAME_SNAP");
            changePickUpStoreIfCurrentStoreIsDifferent(zipCode, storeName);
            ThreadLocalHelper.testCaseData.get().put("SNAP_ENABLED", "true");
        }
    }

    @And("^verify Distance on the cards are sorted in ascending order$")
    public void verifyDistanceAreInAscendingOrder() {
        Assert.assertTrue(gg_shoppingModePage.isStoreCardSorted());
    }

    @Then("^verify first store card is selected$")
    public void verifyFirstStoreCardIsSelected() {
        gg_shoppingModePage.isFirstStoreCardSelected();
    }

    @And("^verify In Store Option is Displayed$")
    public void verifyInStoreOptionDisplayed() {
        Assert.assertTrue(gg_shoppingModePage.isInStoreOptionDisplayed());
    }

    @And("^verify cancel button is not Displayed$")
    public void verifyCancelButtonIsDisplayed() {
        Assert.assertFalse(gg_shoppingModePage.isCancelButtonDisplayed());
    }

    @Then("^click on cancel button on shopping mode screen$")
    public void clickOnCancelButton() {
        gg_shoppingModePage.clickOnCancelButton();
    }

    @And("^Enter the ZipCode which has Only In-Store Available$")
    public void enterZipCodeWhichHasOnlyInStoreAvailable() throws IOException, InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_ONLY_INSTORE");
        gg_shoppingModePage.enterZipCodeWhereOnlyInStoreIsAvailable(zipCode);
    }

    @And("^verify In Store Shopping Mode is Selected$")
    public void verifyInStoreShoppingModeIsSelectedByDefault() {
        Assert.assertTrue(gg_shoppingModePage.isInStoreSelected(), "In store mode is not selected");
    }

    @And("^verify Delivery Shopping Mode is Selected$")
    public void verifyDeliveryIsSelected() {
        Assert.assertTrue(gg_shoppingModePage.isDeliverySelected());
    }

    @Then("^verify no shopping method is selected$")
    public void verifyNoShoppingMethodIsSelected() {
        Assert.assertTrue(gg_shoppingModePage.isStartShoppingCTADisabled());
    }

    @Then("^verify FulfilledBy label is displayed on delivery option when user enters zipcode of different banner$")
    public void verifyFulFilledByLabel() {
        Assert.assertEquals(gg_shoppingModePage.isFulFilledByDisplayedForDeliveryMode(), true, "Fulfilled By label is not displayed on Delivery option when user enters zipcode of different banner");
    }

    @Then("^verify Download/Open App button is displayed when user clicks Start Shopping button$")
    public void verifyDownloadAppButtonDisplayed() {
        Assert.assertEquals(gg_shoppingModePage.isDownloadOpenAppButtonDisplayed(), true, "Download/Open App button is not displayed when user enters zipcode of different banner");
    }

    @Then("^verify Please Note Message is Displayed$")
    public void verifyPleaseNoteMessageIsDisplayed() throws InterruptedException {
        Assert.assertEquals(gg_shoppingModePage.isMessageDisplayed(), true, "Please Note: *Any Drive Up & Go™ orders not claimed by 8 PM on the day of scheduled pick up will be canceled.");
    }

    @Then("^verify Choose Date And Time label is displayed$")
    public void verifyOrderDeliveryTitleIsDisplayed() {
        Assert.assertTrue(gg_shoppingModePage.isChooseDateAndTimeLabelDisplayed(), "Choose Date And Time label is not displayed");
    }

    @Then("^verify store address is displayed on reserve time screen$")
    public void verifyOrderDeliveryAddressIsDisplayed() {
        Assert.assertTrue(gg_shoppingModePage.isStoreAddressDisplayed(), "Store address is not displayed");
    }

    @Then("^verify Earliest Available Pickup Times label is displayed$")
    public void verifyOrderDeliveryAddressPreBookIsDisplayed() {
        Assert.assertEquals(gg_shoppingModePage.isEarliestAvailablePickUpTimesLabelDisplayed(), true, "Earliest Available Pickup Times label is not displayed");

    }

    @Then("^verify Select your order Delivery is Displayed$")
    public void verifyOrderDeliveryWindowDisplayed() {
        Assert.assertTrue(gg_shoppingModePage.isOrderDeliveryWindowDisplayed());
    }

    @Then("^verify order date picker is displayed$")
    public void verifyOrderDeliveryDatePickerDisplayed() {
        Assert.assertTrue(gg_shoppingModePage.isOrderDatePickerDisplayed(), "Date picker is not displayed");
    }

    @Then("^verify order time picker is displayed$")
    public void verifyOrderDeliveryTimeDeliveryDisplayed() {
        Assert.assertTrue(gg_shoppingModePage.isOrderTimePickerDisplayed(), "Time picker is not displayed");
    }

    @Then("^user clicks on the save CTA on reserve time screen$")
    public void user_clicksOnSaveCTA() {
        //  Assert.assertTrue(gg_shoppingModePage.isOrderDeliverySaveButtonDisplayed(), "Save button is not displayed");
        gg_shoppingModePage.clickOnSaveCTA();
    }

    @Then("^verify Save button is displayed on reserve time screen$")
    public void verifyOrderDeliverySaveButtonDisplayed() {
        Assert.assertTrue(gg_shoppingModePage.isOrderDeliverySaveButtonDisplayed(), "Save button is not displayed");
    }

    @Then("^verify In-store Shopping Mode Option is Displayed$")
    public void verifyInStoreShoppingModeDisplayed() {
        Assert.assertTrue(gg_shoppingModePage.isInStoreShoppingModeOptionDisplayed());
    }

    @Then("^verify Start Shopping Button is Displayed$")
    public void verifyStartShoppingDisplayed() {
        Assert.assertTrue(gg_shoppingModePage.isStartShoppingOpDisplayed());
    }


    @When("^keep app in background and relaunching the same in shopping mode screen$")
    public void keepAppInBackgroundAndRelaunchingTheSame() {
        new AppActions().moveAppToBackground();
    }

    @Then("^complete tutorial flow$")
    public void completeTutorialFlow() throws IOException, InterruptedException {
        signInPage.postSignInActions();
    }

    @Then("^verify shopping mode is selected by default if shopping mode preference is already set$")
    public void verifyShoppingModeSelectedByDefault() {
        //verify shopping mode is selected by default by checking Start Shopping button is enabled
        Assert.assertFalse(gg_shoppingModePage.isStartShoppingCTADisabled(), "Shopping mode is not selected by default");
    }

    @Then("^verify \"([^\"]*)\" mode is selected in shopping mode select screen$")
    public void verifyModeIsSelectedInShoppingModeSelectScreen(String shoppingMode) throws Throwable {
        Assert.assertEquals(gg_shoppingModePage.checkIfDesiredShoppingModeIsSelected(shoppingMode), true, "The desired mode is not selected");
    }

    @And("^select store which does not have contact less pay banner$")
    public void selectStoreWhichDoesNotHaveContactLessPayBanner() throws InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_NO_PAYBANNER");
        String storeName = ThreadLocalHelper.testCaseData.get().get("STORENAME_NO_PAYBANNER");
        String shoppingMode = ThreadLocalHelper.testCaseData.get().get("SHOPPING_MODE_NO_PAYBANNER");
        changeStoreIfShoppingModeOrStoreIsDifferent(shoppingMode, zipCode, storeName);
    }

    @And("^enters zipcode belonging to pickup order status two$")
    public void entersZipcodeBelongingToPickupOrderStatusTwo() throws IOException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_PICKUPSTATUSTWO");
        gg_shoppingModePage.enterZipCode(zipCode);
    }

    @And("^enters zipcode belonging to pickup order status three$")
    public void entersZipcodeBelongingToPickupOrderStatusThree() throws IOException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_PICKUPSTATUSTHREE");
        gg_shoppingModePage.enterZipCode(zipCode);
    }

    @And("^enters zipcode belonging to pickup order status four$")
    public void entersZipcodeBelongingToPickupOrderStatusFour() throws IOException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_PICKUPSTATUSFOUR");
        gg_shoppingModePage.enterZipCode(zipCode);
    }

    @Then("^handle zip code page if displayed$")
    public void enterDefaultZipCodeAndStartShopping() throws InterruptedException, IOException {
        gg_shoppingModePage.enterDefaultZipCodeAndStartShopping();
    }

    @Then("verify cancel button {string} displayed on zip code page")
    public void verifyCancelButton(String desiredState) {
        boolean isDisplayed = gg_shoppingModePage.isCloseOrBackButtonDisplayedOnZipCodePage();
        if (desiredState.contains("not")) {
            Assert.assertFalse(isDisplayed, "Cancel(back) button is displayed");
        } else {
            Assert.assertTrue(isDisplayed, "Cancel(back) button is not displayed");
        }
    }

    @And("^select the pick-up for Cart API")
    public void selectPickupStoreForCartAPI() throws InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_CART_API");
        String storeName = ThreadLocalHelper.testCaseData.get().get("STORENAME_CART_API");
        changePickUpStoreIfCurrentStoreIsDifferent(zipCode, storeName);
    }

    @And("user selects a store in california location")
    public void selectStoreInCalifornia() throws InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_PROP65");
        String storeName = ThreadLocalHelper.testCaseData.get().get("STORENAME_PROP65");
        String shoppingMode = ThreadLocalHelper.testCaseData.get().get("SHOPPINGMODE_PROP65");
        if (!storeName.equalsIgnoreCase("NA")) {
            changeStoreIfShoppingModeOrStoreIsDifferent(shoppingMode, zipCode, storeName);
        }
    }

    @And("user selects a pick-up store in california location that supports SNAP EBT payment mode")
    public void selectStoreInCaliforniaWithSNAPEBT() throws InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_SNAP_PROP65");
        String storeName = ThreadLocalHelper.testCaseData.get().get("STORENAME_SNAP_PROP65");
        if (!storeName.equalsIgnoreCase("NA")) {
            changePickUpStoreIfCurrentStoreIsDifferent(zipCode, storeName);
        }
    }

    @And("^select the in-store run store for Cart Api$")
    public void selectInstoreRunStoreForAPI() throws InterruptedException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_CART_API");
        String storeName = ThreadLocalHelper.testCaseData.get().get("STORENAME_CART_API");
        changeInStoreRunStoreIfCurrentStoreIsDifferent(zipCode, storeName);
    }

    @And("^the pick-up store with WYSIWYG OFF$")
    public void selectInStoreWithWYSIWYGOFF() throws IOException, InterruptedException {
        String zipCode = basePage.getBannerPropertiesMap().get("ZIPCODE_WYSIWYG");
        String storeName = basePage.getBannerPropertiesMap().get("STORENAME_WYSIWYG");
        changePickUpStoreIfCurrentStoreIsDifferent(zipCode, storeName);
    }

    @Then("verify zip code screen is displayed")
    public void verifyZipCodePage() {
        Assert.assertTrue(gg_shoppingModePage.isZipcodeScreenDisplayed(), "Zip code screen is not displayed!!");
    }

    @And("user clicks cancel button in zip code screen")
    public void clickCancelOnZipCode() {
        gg_shoppingModePage.clickOnCancelButtonZipCode();
    }

    private void changePickUpStoreIfCurrentStoreIsDifferent(String zipCode, String storeName) throws InterruptedException {
        GG_DashboardPage gg_dashboardPage = new GG_DashboardPage(driver);
        gg_dashboardPage.scrollUptoShoppingMethod();
        if (!gg_dashboardPage.getCurrentShoppingMode().toUpperCase().contains("PICKUP")) {
            gg_dashboardPage.clickOnShoppingDownArrow();
            gg_shoppingModePage.changePickupStore(zipCode, storeName);
        } else {
            if (!gg_dashboardPage.getCurrentShoppingAddress().toUpperCase().contains(storeName.toUpperCase())) {
                gg_dashboardPage.clickOnShoppingDownArrow();
                gg_shoppingModePage.changePickupStore(zipCode, storeName);
            }
        }
    }

    private void changePickUpStore(String zipCode, String storeName) throws InterruptedException {
        GG_DashboardPage gg_dashboardPage = new GG_DashboardPage(driver);
        gg_dashboardPage.scrollUptoShoppingMethod();
        gg_dashboardPage.clickOnShoppingDownArrow();
        gg_shoppingModePage.changePickupStore(zipCode, storeName);
    }

    private void changeInStoreRunStoreIfCurrentStoreIsDifferent(String zipCode, String storeName) throws InterruptedException {
        GG_DashboardPage gg_dashboardPage = new GG_DashboardPage(driver);
        gg_dashboardPage.scrollUptoShoppingMethod();
        if (!gg_dashboardPage.getCurrentShoppingMode().toUpperCase().contains("IN-STORE")) {
            gg_dashboardPage.clickOnShoppingDownArrow();
            gg_shoppingModePage.changeInStoreRunStore(zipCode, storeName);
        } else {
            if (!gg_dashboardPage.getCurrentShoppingAddress().toUpperCase().contains(storeName.toUpperCase())) {
                gg_dashboardPage.clickOnShoppingDownArrow();
                gg_shoppingModePage.changeInStoreRunStore(zipCode, storeName);
            }
        }
    }

    private void changeDeliveryZipIfZipIsDifferent(String zipCode) throws InterruptedException {
        GG_DashboardPage gg_dashboardPage = new GG_DashboardPage(driver);
        gg_dashboardPage.scrollUptoShoppingMethod();
        if (!gg_dashboardPage.getCurrentShoppingMode().toUpperCase().contains("DELIVERY")) {
            gg_dashboardPage.clickOnShoppingDownArrow();
            gg_shoppingModePage.changeDeliveryZipCode(zipCode);
        } else {
            if (!gg_dashboardPage.getCurrentShoppingAddress().contentEquals(zipCode)) {
                gg_dashboardPage.clickOnShoppingDownArrow();
                gg_shoppingModePage.changeDeliveryZipCode(zipCode);
            }
        }
    }

    private void changeStoreIfShoppingModeOrStoreIsDifferent(String shoppingMode, String zipCode, String storeName) throws InterruptedException {
        GG_DashboardPage gg_dashboardPage = new GG_DashboardPage(driver);
        gg_dashboardPage.scrollUptoShoppingMethod();
        switch (shoppingMode.toUpperCase()) {
            case "PICKUP":
                changePickUpStoreIfCurrentStoreIsDifferent(zipCode, storeName);
                break;
            case "DELIVERY":
                changeDeliveryZipIfZipIsDifferent(zipCode);
                break;
            case "IN-STORE":
            case "INSTORE":
            case "IN STORE":
                changeInStoreRunStoreIfCurrentStoreIsDifferent(zipCode, storeName);
                break;
        }
    }

    @And("select the chase pick-up store")
    public void selectTheChasePickUpStore() throws InterruptedException, IOException {
        String zipCode = basePage.getBannerPropertiesMap().get("ZIPCODE_CHASE_PRODUCTS");
        String storeName = basePage.getBannerPropertiesMap().get("STORENAME_CHASE_PRODUCTS");
        gg_shoppingModePage.changePickupStore(zipCode, storeName);
    }


    @And("user selects {string} shopping method in home page")
    public void selectShoppingMethodHomePage(String shoppingMode) throws InterruptedException, IOException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_CART_API");
        String storeName = ThreadLocalHelper.testCaseData.get().get("STORENAME_CART_API");
        switch (shoppingMode.toUpperCase()) {
            case "PICKUP":
                changePickUpStoreIfCurrentStoreIsDifferent(zipCode, storeName);
                break;
            case "DELIVERY":
                changeDeliveryZipIfZipIsDifferent(zipCode);
                break;
            case "IN-STORE":
            case "INSTORE":
            case "IN STORE":
                changeInStoreRunStoreIfCurrentStoreIsDifferent(zipCode, storeName);
                break;
        }
    }

    @Then("^verify user should see delivery store list$")
    public void verify_user_should_see_delivery_store_list() {
        gg_shoppingModePage.verifyDeliveryStoreListIsDisplayed();

    }
}


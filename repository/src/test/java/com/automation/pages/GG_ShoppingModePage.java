package com.automation.pages;


import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.TapAction;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_DashboardPageElements;
import com.automation.pageElements.GG_ShoppingModePageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;


public class GG_ShoppingModePage extends BasePage {
    public GG_DashboardPage dashboardPage = new GG_DashboardPage(driver);
    private final GG_ShoppingModePageElements gg_shoppingModePageElements = new GG_ShoppingModePageElements();
    private final GG_DashboardPageElements dashboardPageElements = new GG_DashboardPageElements();

    public GG_ShoppingModePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_shoppingModePageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dashboardPageElements);
    }

    public void changePickupStore(String zipCode, String storeName) throws InterruptedException {
        if (isElementDisplayed(gg_shoppingModePageElements.zipCodeRightArrow, 5)) {
            enterTextNoPressEnter(gg_shoppingModePageElements.zipCodeTextField, zipCode);
            new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.zipCodeRightArrow);
        }

        new WaitAction(driver).waitForDisplayed(gg_shoppingModePageElements.pickUpShoppingMode, 10);
        new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.pickUpShoppingMode);
        if (!isElementDisplayed(gg_shoppingModePageElements.firstStoreCard, 10)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.pickUpShoppingMode);
        }

        findStoreAndClick(storeName);
        new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.startShoppingButton);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (isElementDisplayed(gg_shoppingModePageElements.dismissCTA, 2)) {
                new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.dismissCTA);
                new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.startShoppingButton);
            }
        }
        new WaitAction(driver).waitForElementToDisappear(gg_shoppingModePageElements.loadingSpinner, 30);
        Thread.sleep(3000);
    }


    public void changeInStoreRunStore(String zipCode, String storeName) throws InterruptedException {
        if (isElementDisplayed(gg_shoppingModePageElements.zipCodeRightArrow, 5)) {
            enterTextNoPressEnter(gg_shoppingModePageElements.zipCodeTextField, zipCode);
            new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.zipCodeRightArrow);
        }

        new WaitAction(driver).waitForDisplayed(gg_shoppingModePageElements.inStoreShoppingMode, 10);
        new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.inStoreShoppingMode);
        if (!isElementDisplayed(gg_shoppingModePageElements.firstStoreCard, 10)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.inStoreShoppingMode);
        }

        findStoreAndClick(storeName);
        new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.startShoppingButton);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (isElementDisplayed(gg_shoppingModePageElements.dismissCTA, 2)) {
                new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.dismissCTA);
                new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.startShoppingButton);
            }
        }
        new WaitAction(driver).waitForElementToDisappear(gg_shoppingModePageElements.loadingSpinner, 30);
        Thread.sleep(3500);
    }

    public void findStoreAndClick(String storeName) throws InterruptedException {
        Thread.sleep(2500);
        scrollDownForElement(gg_shoppingModePageElements.firstStoreCard);
        boolean storeFound = false;
        int maxScrolls = 10;
        int counter = 0;
        while (!storeFound) {
            while (counter < maxScrolls) {
                for (int i = 0; i < gg_shoppingModePageElements.allStoreCardsList.size(); i++) {
                    String add = gg_shoppingModePageElements.allStoreCardsList.get(i).getText();
                    if (add.contains(storeName)) {
                        new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.allStoreCardsList.get(i));
                        if (!gg_shoppingModePageElements.startShoppingButton.isEnabled()) {
                            new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.allStoreCardsList.get(i));
                        }

                        counter = maxScrolls;
                        storeFound = true;
                        break;
                    }
                }
                if (!storeFound) {
                    scrollDown();
                    counter++;
                }
            }
            if (counter >= maxScrolls) {
                break;
            }
        }
        Assert.assertTrue(storeFound, "The store you are searching is not found");
    }

    public void changeDeliveryZipCode(String zipCode) throws InterruptedException {
        enterTextNoPressEnter(gg_shoppingModePageElements.zipCodeTextField, zipCode);
        new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.zipCodeRightArrow);
        new WaitAction(driver).waitForDisplayed(gg_shoppingModePageElements.deliveryShoppingMode, 10);
        new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.deliveryShoppingMode);
        new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.startShoppingButton);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (isElementDisplayed(gg_shoppingModePageElements.dismissCTA, 2)) {
                new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.dismissCTA);
                new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.startShoppingButton);
            }
        }
        new WaitAction(driver).waitForElementToDisappear(gg_shoppingModePageElements.loadingSpinner, 30);
        Thread.sleep(2000);
    }

    public void clickOnDeliveryShoppingMode() throws InterruptedException {
        new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.deliveryShoppingMode);
        Thread.sleep(1500);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (gg_shoppingModePageElements.startShoppingButton.getAttribute("enabled").equals("false")) {
                new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.deliveryShoppingMode);
            }
        }
    }

    public void clickOnPickupShoppingMode() throws InterruptedException {
        new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.pickUpShoppingMode);
        Thread.sleep(1500);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (gg_shoppingModePageElements.startShoppingButton.getAttribute("enabled").equals("false")) {
                new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.pickUpShoppingMode);
            }
        }
    }

    public void clickOnInStoreShoppingMode() throws InterruptedException {
        new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.inStoreShoppingMode);
        Thread.sleep(1500);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (gg_shoppingModePageElements.startShoppingButton.getAttribute("enabled").equals("false")) {
                new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.inStoreShoppingMode);
            }
        }
    }

    public void clickOnStartShoppingButton() {
        waitForLoaderToDisappear();
        new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.startShoppingButton);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (isElementDisplayed(gg_shoppingModePageElements.dismissCTA, 2)) {
                new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.dismissCTA);
                new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.startShoppingButton);
            }
        }
        waitForLoaderToDisappear();
    }

    public void waitForLoaderToDisappear() {
        new WaitAction(driver).waitForElementToDisappear(gg_shoppingModePageElements.loadingSpinner, 20);
    }

    public void clickOnZipCodeRightArrow() {
        isElementDisplayed(gg_shoppingModePageElements.zipCodeRightArrow, 5);
        new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.zipCodeRightArrow);
    }

    public void clickOnReserveTime() {
        new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.reserveATime);
    }

    public boolean verifyReserveATimeOptionIsPresent() {
        return isElementDisplayed(gg_shoppingModePageElements.reserveATime);
    }

    public boolean verifyPickupShoppingModeIsSelected() {
        return isElementDisplayed(gg_shoppingModePageElements.pickUpShoppingModeInDashboard);
    }

    public void changeToDeliveryShoppingMode() throws InterruptedException {
        if (isElementDisplayed(gg_shoppingModePageElements.zipCodeRightArrow, 5)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.zipCodeRightArrow);
        }
        new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.deliveryShoppingMode);
        Thread.sleep(1000);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (gg_shoppingModePageElements.startShoppingButton.getAttribute("enabled").equals("false")) {
                new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.deliveryShoppingMode);
            }
        }
        new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.startShoppingButton);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (isElementDisplayed(gg_shoppingModePageElements.dismissCTA, 2)) {
                new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.dismissCTA);
                new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.startShoppingButton);
            }
        }
        waitForLoaderToDisappear();
    }

    public boolean verifyDeliveryShoppingModeIsSelected() {
        return isElementDisplayed(gg_shoppingModePageElements.deliveryShoppingModeInDashboard, 2);
    }

    public void clickOnReserveATime() {

        if ((gg_shoppingModePageElements.reserveATime).isDisplayed())
            new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.reserveATime);
        else
            new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.reserveATime2);

    }

    public boolean verifyReserveATimePageIsDisplayed() {
        return isElementDisplayed(gg_shoppingModePageElements.reserveATimePage);
    }

    public void clickBackButtonOnReserveATimePage() {
        waitForLoaderToDisappear();
        new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.backButtonOnReserveATimePage);
        new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.backButtonOnReserveATimePage);
        if (isElementDisplayed(gg_shoppingModePageElements.windowPopUpReserveATimePage)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.NowindowPopUpReserveATimePage);
        }

    }

    public void changeToInstoreShoppingMode() throws InterruptedException {
        if (isElementDisplayed(gg_shoppingModePageElements.zipCodeRightArrow, 5)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.zipCodeRightArrow);
        }
        new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.inStoreShoppingMode);
        Thread.sleep(1500);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (gg_shoppingModePageElements.startShoppingButton.getAttribute("enabled").equals("false")) {
                new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.inStoreShoppingMode);
            }
        }
        new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.startShoppingButton);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (isElementDisplayed(gg_shoppingModePageElements.dismissCTA, 2)) {
                new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.dismissCTA);
                new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.startShoppingButton);
            }
        }
        waitForLoaderToDisappear();
    }

    public boolean verifyInstoreShoppingModeIsSelected() {
        return isElementDisplayed(gg_shoppingModePageElements.instoreShoppingModeInDashboard, 3);
    }

    public boolean verifyShoppingAddress() {
//        return isElementDisplayed(gg_shoppingModePageElements.shoppingAddressInDashboard;
        String[] storeAddress = gg_shoppingModePageElements.shoppingAddressInDashboard.getText().split("\\s");
        return !storeAddress[0].isEmpty();
    }

    public boolean verifyUserIsInShoppingModeScreen() {
        return isElementDisplayed(gg_shoppingModePageElements.startShoppingButton);
    }

    public void clickOnUseMyLocation() {
        new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.useMyLocation);
    }

    public void verifyHowDoYouWantYourGroceriesTitle() {
        Assert.assertTrue(gg_shoppingModePageElements.howDoYouWantYourGroceriesTitle.getText().equalsIgnoreCase("How do you want your groceries?"));
    }

    public void enterZipCode(String zipCode) {
        gg_shoppingModePageElements.zipCodeTextField.clear();
        enterTextNoPressEnter(gg_shoppingModePageElements.zipCodeTextField, zipCode);
    }

    public boolean verifyDeliveryShoppingModeOption() {
        return isElementDisplayed(gg_shoppingModePageElements.deliveryShoppingMode);
    }

    public boolean verifyPickUpShoppingModeOption() {
        return isElementDisplayed(gg_shoppingModePageElements.pickUpShoppingMode);
    }

    public void clickOnShoppingModeBackButton() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.shoppingPageBackButton);
        } else {
            navigateBack();
        }
    }

    public boolean isZipcodeScreenDisplayed() {
        return isElementDisplayed(gg_shoppingModePageElements.zipCodePageTitle);
    }

//    public String isZipcodePageDisplayed() {
//        return  (gg_shoppingModePageElements.zipCodePageTle).getText();
//    }

    public void isStartShoppingCTADisplayed() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Assert.assertTrue(gg_shoppingModePageElements.startShoppingButton.getAttribute("label").equalsIgnoreCase("START SHOPPING"));
        } else {
            Assert.assertTrue(gg_shoppingModePageElements.startShoppingButton.getAttribute("text").equalsIgnoreCase("Start Shopping"));
        }
    }

    public void enterZipCodeInShoppingModePage(String zipCode) throws InterruptedException {
        gg_shoppingModePageElements.shoppingPageZipCodeTextField.clear();
        enterKey(gg_shoppingModePageElements.shoppingPageZipCodeTextField, zipCode);
    }

    public void changeTheZipCode(String zipCode) {
        waitForLoaderToDisappear();
        gg_shoppingModePageElements.zipCodeTextField.clear();
        enterTextNoPressEnter(gg_shoppingModePageElements.zipCodeTextField, zipCode);
    }

    public void verifySearchBarWithDefaultZipCode(String zipCode) throws InterruptedException {
        Assert.assertTrue(gg_shoppingModePageElements.shoppingPageZipCodeTextField.getText().equalsIgnoreCase(zipCode));
    }

    public void isStoreListedForEnteredZipcode(String zipCode) throws InterruptedException {
        //gg_shoppingModePageElements.shoppingPageZipCodeTextField.clear();
        //enterKey(gg_shoppingModePageElements.shoppingPageZipCodeTextField, zipCode);
        scrollDownForElement(gg_shoppingModePageElements.firstStoreCard);
        for (int i = 0; i < gg_shoppingModePageElements.allStoreCardsList.size(); i++) {
            if (gg_shoppingModePageElements.allStoreCardsList.get(i).getText().contains(zipCode)) {
                new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.allStoreCardsList.get(i));
                break;
            }
        }
    }

    public boolean isStoreCardSorted() {
        boolean isStoreCardSorted = false;
        int count = 0;
        ArrayList<Float> storeCardDistance = new ArrayList<>();
        scrollDown();
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            for (int i = 0; gg_shoppingModePageElements.allStoreCardsList.size() - 1 > i; i++) {
                String dist = gg_shoppingModePageElements.storeDistance.get(i).getText().split(" mi")[0].trim();
                float distance = Float.parseFloat(dist);
                storeCardDistance.add(distance);
                scrollDown();
            }
        } else {
            for (int i = 0; gg_shoppingModePageElements.allStoreCardsList.size() - 1 > i; i++) {
                String dist = gg_shoppingModePageElements.storeDistance.get(i).getText().split(" mi\\.")[0].trim();
                float distance = Float.parseFloat(dist);
                storeCardDistance.add(distance);
                scrollDown();
            }
        }
        scrollUpForElement(gg_shoppingModePageElements.deliveryShoppingMode);
        for (int i = 0; i < storeCardDistance.size() - 1; i++) {
            if (storeCardDistance.get(i) <= storeCardDistance.get(i + 1)) {
                count++;
                scrollDown();
            }
        }
        if (count == storeCardDistance.size() - 1) {
            isStoreCardSorted = true;
        }
        return isStoreCardSorted;
    }

    public void isFirstStoreCardSelected() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Assert.assertTrue(gg_shoppingModePageElements.allStoreCardsList.get(0).isSelected());
        } else {
            Assert.assertTrue(gg_shoppingModePageElements.selectedCard.get(0).getAttribute("checked").equalsIgnoreCase("true"));
        }
    }

    public boolean isInStoreOptionDisplayed() {
        return isElementDisplayed(gg_shoppingModePageElements.inStoreShoppingMode);
    }

    public boolean isCancelButtonDisplayed() {
        return isElementDisplayed(gg_shoppingModePageElements.shoppingModeCancelButton);
    }

    public void clickOnCancelButton() {
        if (isElementDisplayed(gg_shoppingModePageElements.shoppingModeCancelButton, 5)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.shoppingModeCancelButton);
        }
    }

    public void enterZipCodeWhereOnlyInStoreIsAvailable(String zipCode) throws InterruptedException {
        gg_shoppingModePageElements.zipCodeTextField.clear();
        enterTextNoPressEnter(gg_shoppingModePageElements.zipCodeTextField, zipCode);
    }

    public boolean isInStoreSelected() {
        boolean isInStoreSelected = false;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (gg_shoppingModePageElements.inStoreSelected.getAttribute("value").equals("Selected")) {
                isInStoreSelected = true;
            }
        } else {
            isInStoreSelected = isElementDisplayed(gg_shoppingModePageElements.inStoreSelected);
        }
        return isInStoreSelected;
    }

    public boolean isDeliverySelected() {
        boolean isDeliverySelected = false;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (gg_shoppingModePageElements.deliverySelected.getAttribute("value").equals("Selected")) {
                isDeliverySelected = true;
            }
        } else {
            isDeliverySelected = isElementDisplayed(gg_shoppingModePageElements.deliverySelected);
        }
        return isDeliverySelected;
    }


    public boolean isStartShoppingCTADisabled() {
        return gg_shoppingModePageElements.startShoppingButton.getAttribute("enabled").equalsIgnoreCase("false");
    }

    public boolean isFulFilledByDisplayedForDeliveryMode() {
        return isElementDisplayed(gg_shoppingModePageElements.fulfilledByLabel);
    }

    public boolean isDownloadOpenAppButtonDisplayed() {
        return isElementDisplayed(gg_shoppingModePageElements.downloadAppButton) || isElementDisplayed(gg_shoppingModePageElements.openAppButton);
    }

    public boolean isMessageDisplayed() {
        return isElementDisplayed(gg_shoppingModePageElements.pleaseNoteText, 7);
    }

    public boolean isChooseDateAndTimeLabelDisplayed() {
        return isElementDisplayed(gg_shoppingModePageElements.chooseDateAndTimeLabel);
    }

    public boolean isStoreAddressDisplayed() {
        return isElementDisplayed(gg_shoppingModePageElements.storeAddress);
    }

    public boolean isEarliestAvailablePickUpTimesLabelDisplayed() {
        return isElementDisplayed(gg_shoppingModePageElements.earliestAvailablePickUpTimesLabel);
    }

    public boolean isOrderDeliveryWindowDisplayed() {
        return isElementDisplayed(gg_shoppingModePageElements.orderDeliveryWindow);
    }

    public boolean isOrderDatePickerDisplayed() {
        return isElementDisplayed(gg_shoppingModePageElements.orderDatePicker, 5);
    }

    public boolean isOrderTimePickerDisplayed() {
        return isElementDisplayed(gg_shoppingModePageElements.orderTimePicker, 5);
    }

    public void clickOnSaveCTA() {
        new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.orderDeliverySaveButton);
        new WaitAction(driver).waitForLoadingComplete();

    }

    public boolean isOrderDeliverySaveButtonDisplayed() {
        return isElementDisplayed(gg_shoppingModePageElements.orderDeliverySaveButton);
    }

    public boolean isStoreCardDisplayed() {
        return isElementDisplayed(gg_shoppingModePageElements.storeCard);
    }

    public boolean isStartShoppingOpDisplayed() {
        return isElementDisplayed(gg_shoppingModePageElements.startShoppingButton);
    }

    public boolean isInStoreShoppingModeOptionDisplayed() {
        return isElementDisplayed(gg_shoppingModePageElements.inStoreShoppingMode);
    }

    public void enterDefaultZipCodeAndStartShoppingBackground() throws IOException, InterruptedException {
        if (enterDefaultZipCodeAndStartShopping()) {
            if (driver.getPlatformName().equalsIgnoreCase("android")) {
                if (isElementDisplayed(dashboardPageElements.cachingContinueBtn, 12)) {
                    new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.cachingContinueBtn);
                }
            }
            new GG_DashboardPage(driver).handleTutorial(5);
        }
    }

    public boolean enterDefaultZipCodeAndStartShopping() throws InterruptedException, IOException {

        String zipCode = getBannerPropertiesMap().get("ZIPCODE_PICKUP");
        if (isElementDisplayed(gg_shoppingModePageElements.zipCodeRightArrow, 3)) {
            enterTextNoPressEnter(gg_shoppingModePageElements.zipCodeTextField, zipCode);
            new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.zipCodeRightArrow);
            new WaitAction(driver).waitForElementToBeClickable(gg_shoppingModePageElements.pickUpShoppingMode, 25);
            new TapAction(driver).tapCoordinate(gg_shoppingModePageElements.pickUpShoppingMode.getCenter().getX(), gg_shoppingModePageElements.pickUpShoppingMode.getCenter().getY());
            Thread.sleep(3500);

            if (!gg_shoppingModePageElements.startShoppingButton.isEnabled()) {
                new TapAction(driver).tapCoordinate(gg_shoppingModePageElements.pickUpShoppingMode.getCenter().getX(), gg_shoppingModePageElements.pickUpShoppingMode.getCenter().getY());
            }

            findStoreAndClick(getBannerPropertiesMap().get("STORENAME_PICKUP"));
            new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.startShoppingButton);

            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                if (isElementDisplayed(gg_shoppingModePageElements.dismissCTA, 1)) {
                    new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.dismissCTA);
                    new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.startShoppingButton);
                }
            }
            return true;
        } else {
            return false;
        }
    }


    public boolean enterDefaultZipCodeAndStartShoppingforDelivery() throws InterruptedException, IOException {
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE_PRODUCTS");
        // String zipCode = getBannerPropertiesMap().get("ZIPCODE_PRODUCTS");
        if (driver.getPlatformName().equalsIgnoreCase("iOS")) {
            if (isElementDisplayed(gg_shoppingModePageElements.AllowNotification, 10)) {
                new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.AllowNotification);
            }
            if (isElementDisplayed(gg_shoppingModePageElements.Allow, 10)) {
                new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.Allow);
            }
        }

        if (isElementDisplayed(gg_shoppingModePageElements.zipCodeTextField, 3)) {
//            gg_shoppingModePageElements.zipCodeTextField.sendKeys(zipCode);
            waitForLoadingComplete();
            enterTextNoPressEnter(gg_shoppingModePageElements.zipCodeTextField, zipCode);

            //   waitForTextPresentInElement(gg_shoppingModePageElements.zipCodeTextField, zipCode);
            new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.zipCodeRightArrow);
            // clickElement(gg_shoppingModePageElements.deliveryShoppingMode);
            Thread.sleep(2000);
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                enterTextNoPressEnter(gg_shoppingModePageElements.zipCodeTextFieldSearch, zipCode);
                new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.SearchforDeliverystore);
            }
            //findStoreAndClick(getDefaultStore(getCurrentBanner()));
            //findStoreAndClick(getBannerPropertiesMap().get("STORENAME_PRODUCTS"));
            new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.startShoppingButton);
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                if (isElementDisplayed(gg_shoppingModePageElements.dismissCTA, 1)) {
                    new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.dismissCTA);
                    new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.startShoppingButton);
                }
            }
            return true;
        } else {
            return false;
        }
    }


    public boolean checkIfDesiredShoppingModeIsSelected(String shoppingMode) {
        waitForLoaderToDisappear();
        boolean isSelected = false;
        switch (shoppingMode.toUpperCase()) {
            case "PICKUP":
                isSelected = driver.getPlatformName().equalsIgnoreCase("ios") ? getText(gg_shoppingModePageElements.pickupSelected).contains("Selected") : gg_shoppingModePageElements.pickupSelected.isDisplayed();
                break;
        }
        return isSelected;
    }

    public boolean verifyFullCartsHappyHeartsMessageDisplayed() {
        return isElementDisplayed(gg_shoppingModePageElements.fullCartsHappyHeartsMessage);
    }


    // Hardcoding this for now, will have to add store names to all yml files later
    public String getDefaultStore(String banner) {
        String storeName = "";
        switch (banner.toUpperCase()) {
            case "TOMTHUMB":
                storeName = "106 N Denton Tap Rd";
                break;
            case "SHAWS":
                storeName = "100 Shaws Ln";
                break;
            case "VONS":
                storeName = "3645 Midway Dr";
                break;
            case "STARMARKET":
                storeName = "53 Huntington Ave";
                break;
            case "SAFEWAY":
                storeName = "6790 Bernal Ave";
                break;
            case "RANDALLS":
                storeName = "12850 Memorial Dr";
                break;
            case "PAVILIONS":
                storeName = "8969 Santa Monica Blvd";
                break;
            case "JEWELOSCO":
                storeName = "2940 N Ashland Ave";
                break;
            case "ALBERTSONS":
                storeName = "4700 N Eagle Rd";
                break;
            case "ACME":
                storeName = "251 N Broadway";
                break;
        }

        return storeName;
    }


    public boolean isCloseOrBackButtonDisplayedOnZipCodePage() {
        return isElementDisplayed(gg_shoppingModePageElements.closeButtonZipCodePage, 5);
    }

    public void clickOnCancelButtonZipCode() {
        new CommonActions(driver).new ClickAction().clickElement(gg_shoppingModePageElements.closeButtonZipCodePage);
    }


    public void verifyDeliveryStoreListIsDisplayed() {
        Assert.assertTrue(isElementDisplayed(gg_shoppingModePageElements.deliveryAvailableFromStores, 10), "Delivery available from stores list heading is not displayed");
        Assert.assertTrue(isElementVisible(gg_shoppingModePageElements.deliveryStoresList), "Delivery Store list is not displayed");
    }
}


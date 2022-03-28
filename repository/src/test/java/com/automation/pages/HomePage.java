package com.automation.pages;


import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.TapAction;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    public HomePageElements homePageElements = new HomePageElements();
    private GG_SearchPageElements gg_searchPageElements = new GG_SearchPageElements();

    public MenuPageElements menuPageElements = new MenuPageElements();
    public GG_MyItemsPageElements myItemsElements = new GG_MyItemsPageElements();
    public CheckoutPageElements pageElements = new CheckoutPageElements();
    public String firstStoreAddress = null;
    SelectOrderTypePageElements selectOrderTypePageElements = new SelectOrderTypePageElements();
    private final GG_OtpPasswordPageElements otpPasswordPageElements = new GG_OtpPasswordPageElements();
    private final SelectOrderTypePage selectOrderTypePage = new SelectOrderTypePage(driver);
    private final String productInMustHaveGrabs = null;

    public HomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_searchPageElements);

        PageFactory.initElements(new AppiumFieldDecorator(driver), homePageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), menuPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), myItemsElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), otpPasswordPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), selectOrderTypePage);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), selectOrderTypePageElements);
    }

    public void waitForHomePageDisplayed() {
        new WaitAction(driver).waitForLoadingComplete();
        if (platformName.equalsIgnoreCase("ios")) {
            driver.closeApp();
            driver.launchApp();
            for (int i = 0; i < 1; i++) {
                if (isElementDisplayed(otpPasswordPageElements.Delivery_Next, 10))
                    new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.Delivery_Next);
                else {
                    break;
                }
            }
        } else {
            scrollUp();
            scrollUp();
        }

        waitVar.until(ExpectedConditions.visibilityOf(homePageElements.menuButton));
        Assert.assertTrue(homePageElements.menuButton.isDisplayed());
    }

    public void clickMenuIcon() {
        homePageElements.menuButton.click();
    }


    public void clickAppLovePopup() {
        homePageElements.yesButton.click();
        homePageElements.dismissAlert.click();
    }


    public void clickAddButton() {
        homePageElements.addItemButtons.get(0).click();
    }

    public void clickShoppingCartButton() throws InterruptedException {

        Thread.sleep(1000);
        new WaitAction(driver).waitForClickableAndClick(homePageElements.shoppingCartButton);

    }


    public void clickAislesTab() throws InterruptedException {
        homePageElements.aisleTab.click();
        Thread.sleep(1000);
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void waitForSubListDisplayed() {
        waitVar.until(ExpectedConditions.visibilityOf(homePageElements.subListElements.get(0)));
    }

    public void clickSubListItem(String arg0) {
        homePageElements.subListElements.get(Integer.parseInt(arg0) - 1).click();
    }

    public void waitForCategoryListDisplayed() {
        waitVar.until(ExpectedConditions.visibilityOf(homePageElements.categoryListElements.get(0)));
    }

    public void waitForDepartmentListDisplayed() {
        new WaitAction(driver).waitForDisplayed(homePageElements.aisleTitle);
    }

    public void clickCategoryListItem(String arg0) {
        if (driver.getPlatformName().equalsIgnoreCase("ios"))
            homePageElements.categoryListElements.get(Integer.parseInt(arg0) - 2).click();
        else
            homePageElements.categoryListElements.get(Integer.parseInt(arg0) - 1).click();
    }

    public void clickDepartmentListItem(String arg0) {
        homePageElements.departmentListElements.get(Integer.parseInt(arg0) - 1).click();
    }

    public void waitForItemFoundFromAisle() {
        waitVar.until(ExpectedConditions.visibilityOf(homePageElements.aisleResultText));
    }

    public void waitForAddCTAOnHomePage() {
        waitVar.until(ExpectedConditions.visibilityOf(homePageElements.addCTA));
    }

    public void waitForAddToListCTAOnHomePage() {
        //    scrollDownForElement(homePageElements.addToListCTA);
        waitVar.until(ExpectedConditions.visibilityOf(homePageElements.addToListCTA));
    }

    public void clickAddItem(String arg0) throws InterruptedException {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            try {
                if (homePageElements.iosTogglePopUp.isDisplayed())
                    homePageElements.iosCloseToggle.click();
            } catch (Exception e) {
            }
//            scrollDownForElement(homePageElements.addButtonOnfirstitem);
//            homePageElements.addButtonOnfirstitem.click();

        }
        Thread.sleep(1000);
        new WaitAction(driver).waitForLoadingComplete();

        MobileElement element = homePageElements.addButtonList.get(Integer.parseInt(arg0) - 1);
        element.click();

    }

    public void clickAddItemSecondProduct(String arg0) throws InterruptedException {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            try {
                if (homePageElements.iosTogglePopUp.isDisplayed())
                    homePageElements.iosCloseToggle.click();
            } catch (Exception e) {
            }
        }
        Thread.sleep(1000);
        waitForLoadingComplete();
        homePageElements.addButtonForSecondItem.click();
        //MobileElement element = homePageElements.addButtonList.get(Integer.parseInt(arg0) - 1);
        // element.click();

    }

    public void addMoreProduct() throws InterruptedException {
        homePageElements.increaseQuantityPlus.click();
        homePageElements.increaseQuantityPlus.click();
        Thread.sleep(2000);
        homePageElements.increaseQuantityPlus.click();
        homePageElements.increaseQuantityPlus.click();
        homePageElements.increaseQuantityPlus.click();
    }

    public void clickMyPurchaseTab() {
        homePageElements.myPurchaseTab.click();
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void clickSearchBar() {
        homePageElements.clickSearch.click();
//        driver.hideKeyboard();
    }

    public void verifySearchIcon() {
        //   homePageElements.clickSearch.click();
        waitVar.until(ExpectedConditions.visibilityOf(homePageElements.searchIconInHomePage));
        //   dashboardPage.clickOnSearchIconOnHomePage();
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void verifySearchBar() {
        //   homePageElements.clickSearch.click();
        waitVar.until(ExpectedConditions.visibilityOf(homePageElements.clickSearch));
        //   dashboardPage.clickOnSearchIconOnHomePage();
    }

    public void waitForSearchWindowDisplayed() {
        waitVar.until(ExpectedConditions.visibilityOf(homePageElements.currentTrendingText));
    }

    public void clickElementsByIndex(int arg0) {
        List<MobileElement> elements = homePageElements.autoSuggestSearchList;
        new CommonActions(driver).new ClickAction().clickElement(elements.get(arg0));
    }

    public void enterSearchItem(String arg0) {
        try {
            if (driver.getPlatformName().equalsIgnoreCase("android")) {

                if (AppiumDeviceManager.getDevice().getDeviceType().equalsIgnoreCase("cloud")) {
                    homePageElements.searchEditText.click();
                    homePageElements.searchEditText.sendKeys(arg0);

//                    tapCoordinate(990, 1983);
                    new TapAction(driver).tapSearchAndroidKeyboard();

                    driver.hideKeyboard();
                    waitForLoadingComplete();
                } else {
                    enterKey(homePageElements.searchEditText, arg0);
                    new TapAction(driver).tapCoordinate(990, 1983);
                    new CommonActions(driver).new ClickAction().androidKeyboardClickDone();

                }
            } else {
                if (isElementVisible(homePageElements.searchTextField)) {
                    tapCoordinate(gg_searchPageElements.searchTextField.getCenter().getX(), gg_searchPageElements.searchTextField.getCenter().getY());
                    Thread.sleep(5000);
                }
                enterKey(homePageElements.searchEditText, arg0 + Keys.RETURN);
                if (isElementVisible(myItemsElements.dealToggleSwitch)) {
                    myItemsElements.dealToggleSwitch.get(0).click();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
//            homePageElements.milkProduct.click();
            //homePageElements.sodaProduct.click();
        }
        /*try {
            homePageElements.closeToggle.click();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }


    public void enterSearchItemInSearchBar(String arg0) throws InterruptedException {

        if (driver.getPlatformName().equalsIgnoreCase("android")) {

            if (AppiumDeviceManager.getDevice().getDeviceType().equalsIgnoreCase("cloud")) {
                homePageElements.searchEditText.click();
                homePageElements.searchEditText.sendKeys(arg0);
                new TapAction(driver).tapSearchAndroidKeyboard();

            } else {
                enterKey(homePageElements.searchEditText, arg0);
                new CommonActions(driver).new ClickAction().androidKeyboardClickDone();
            }
        } else {

            new CommonActions(driver).new ClickAction().clickElement(homePageElements.searchEditText);
            enterKey(homePageElements.searchEditText, arg0 + Keys.RETURN.toString());

            try {
                if (myItemsElements.dealsToggleSwitch.isDisplayed()) {
                    myItemsElements.dealsToggleSwitch.click();
                }
            } catch (Exception e) {
                return;
            }

//            enterKey(homePageElements.searchEditText, arg0);
        }
    }

    public void verifySearchItem(String arg0) {

//        Assert.assertTrue(homePageElements.validSearchProduct.getText().contains(arg0));
//        Assert.assertTrue(homePageElements.validSearchProduct.isDisplayed());
        Assert.assertTrue(homePageElements.validSearchProduct.isDisplayed());
    }


    public void verifySearchResults() {

        Assert.assertTrue(homePageElements.searchResults.isDisplayed());
//        Assert.assertTrue(homePageElements.validSearchProduct.isDisplayed());
    }

    public void clickDealTab() {
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.dealsTab);
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void clickHomePageTab() {
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.homeTab);
        new WaitAction(driver).waitForLoadingComplete();
    }


    public void verifyPopularItemsDisplayed() {
        new WaitAction(driver).waitForDisplayed(homePageElements.popularItemText);
    }

    public void verifyMustHaveGrabsItemsDisplayed() {
        new WaitAction(driver).waitForDisplayed(homePageElements.mustHaveGrabsSection);
    }

    public void verifyMostViewedDisplayed() {
        scrollDownForElement(homePageElements.mostViewedText);
    }

    public void waitForResultFoundDisplayed() {
        waitForLoadingComplete();
        waitVar.until(ExpectedConditions.visibilityOf(homePageElements.searchResultText));
        Assert.assertTrue(homePageElements.searchResultText.isDisplayed());

    }

    public void clickCancelButton() {
        new WaitAction(driver).waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.cancelButton);
    }

    public void waitForNotificationAlert() {
        new WaitAction(driver).waitForDisplayed(homePageElements.notificationText);
    }

    public void clickDoNotAllowNotification() {
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.doNotAllowNotificationButton);
    }

    public void increaseItemQuantity(int item, int quantity) throws InterruptedException {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            MobileElement element = null;
            element = homePageElements.plusButtonList.get(item - 1);
            for (int i = 0; i < quantity; i++) {
                new TapAction(driver).tapElement(element);
            }
        }
    }

    public void clickDeliveryOption() {

        new WaitAction(driver).waitForLoadingComplete();

       /* Dimension dimension = driver.manage().window().getSize();
        int height = (int) (dimension.getHeight() * .90);
        int width = (int) (dimension.getWidth() * .92);
        tapCoordinate(width, height);*/

        // clickonNextButton();

        //   tapCoordinate((int) (driver.manage().window().getSize().width * 0.95), element.getCenter().getY());

       /* if (driver.getPlatformName().equalsIgnoreCase("ios")) {
          //  tapCoordinate(714, 1116);
            clickonNextButton();
        }*//*else{
            Dimension dimension = driver.manage().window().getSize();
            int height = (int) (dimension.getHeight() * .90);
            int width = (int) (dimension.getWidth() * .92);
            tapCoordinate(width, height);
        }
*/
        //   tapCoordinate(350, 1500);


      /*  IOSTouchAction touch = new IOSTouchAction (driver);
        touch.tap (TapOptions.tapOptions ()
                .withElement (ElementOption.element (e)))
                .perform ();
*/
        new WaitAction(driver).waitForLoadingComplete();


/*
        Dimension dimension = driver.manage().window().getSize();
        tapCoordinate(82, (int) ((dimension.getHeight()) * .32));*/
        //   tapCoordinate(60,800);
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.editDeliveryButton);


    }

    public void verifyNextButtonisDisplayed() {
        new WaitAction(driver).waitForLoadingComplete();


        Dimension dimension = driver.manage().window().getSize();
        int height = (int) (dimension.getHeight() * .90);
        int width = (int) (dimension.getWidth() * .92);
        new TapAction(driver).tapCoordinate(width, height);

    /*   if (isElementDisplayed(homePageElements.nextButton, 100)) {
                for (int i = 0; i < 3; i++) {
                    new CommonActions(driver).new ClickAction().clickElement(homePageElements.nextButton);
                }
            }*/
        new WaitAction(driver).waitForLoadingComplete();

    }

    public void clickonNextButton() {
        new WaitAction(driver).waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.nextButton);
    }

    public void waitForLoveShoppingPopUpDisplayed() {
        new WaitAction(driver).waitForDisplayed(homePageElements.loveShoppingPopUpText);
    }

    public void clickLoveShoppingYesButton() {
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.loveShoppingYesButton);
    }

    public void waitForRateShopPopup() {
        new WaitAction(driver).waitForDisplayed(homePageElements.ratingShopWindowText);
    }

    public void clickRateShopNotNowButton() {
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.ratingShopNotNowButton);
    }

    public void clickAutoSuggestItem(int arg0) {
        new WaitAction(driver).waitForDisplayed(homePageElements.currentTrendingText);
        if (getPlatformName().equalsIgnoreCase("ios")) {
            new CommonActions(driver).new ClickAction().clickElement(homePageElements.autoSuggestBread);
        } else {
            new CommonActions(driver).new ClickAction().clickElement(homePageElements.autoSuggestSearchList.get(arg0 - 1));
        }
    }


    public void clickItemOnAisleList(String item) throws InterruptedException {
        new WaitAction(driver).waitForLoadingComplete();
        Thread.sleep(4000);
//        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(findElementByName(item)));
        new TapAction(driver).tapElementCoordinate(findElementByName(item));
        new WaitAction(driver).waitForLoadingComplete();

    }


    public void scrollDownForNonSnapCategory(String item) {
        new WaitAction(driver).waitForLoadingComplete();
        for (int i = 0; i <= 15; i++) {
            try {
                if (homePageElements.nonSnapCategoryName.isDisplayed()) {
                    if (driver.getPlatformName().equalsIgnoreCase("android")) {
                        if (homePageElements.nonSnapCategoryName.getAttribute("text").contains(item)) {
                            new CommonActions(driver).new ClickAction().clickElement(homePageElements.nonSnapCategoryName);
                            break;
                        }
                    } else {
                        if (homePageElements.nonSnapCategoryName.getAttribute("label").contains(item)) {
                            new CommonActions(driver).new ClickAction().clickElement(homePageElements.nonSnapCategoryName);
                            break;
                        }
                    }
                } else {
                    scrollDown();
                }
            } catch (Exception e) {
                scrollDown();
            }
        }
    }


    public void clickCategoryOnCategoryList(String item) {
        new WaitAction(driver).waitForLoaderToDisappear();
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
//            new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(findElementByName(item)));

            scrollDownForElement(findElementByName(item));
            new TapAction(driver).tapElementCoordinate(findElementByName(item));
        } else {
            new TapAction(driver).tapElementCoordinate(findElementByLabel(item));
        }
        new WaitAction(driver).waitForLoadingComplete();
    }

    public boolean verifyPreferenceDisplayed(String preference) {
        new WaitAction(driver).waitForDisplayed(homePageElements.editDeliveryButton);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (preference.equalsIgnoreCase("delivery")) {
                return homePageElements.editDeliveryButton.getText().contains("Delivery");
            } else if (preference.equalsIgnoreCase("pickup")) {
                return homePageElements.editDeliveryButton.getText().contains("Pickup");
            } else if (preference.equalsIgnoreCase("inStore")) {
                return homePageElements.editDeliveryButton.getText().contains("In-store");
            }
        } else {
            if (preference.equalsIgnoreCase("delivery")) {
                return homePageElements.editDeliveryButton.getText().contains("Delivery");
            } else if (preference.equalsIgnoreCase("pickup")) {
                return homePageElements.editDeliveryButton.getText().contains("Pickup");
            } else if (preference.equalsIgnoreCase("inStore")) {
                return homePageElements.editDeliveryButton.getText().contains("In-store");

            }
        }
        return false;
    }

    public boolean verifyPreferenceTextDisplayed(String preference) {

        if (getPlatformName().equalsIgnoreCase("ios")) {
            //new CommonActions(driver).new ClickAction().clickElement(homePageElements.autoSuggestBread);
            if (preference.startsWith("In")) {
                return homePageElements.preferenceText.getText().contains("In-Store");
            }
        } else {
            if (preference.endsWith("run")) {
                return homePageElements.preferenceText.getText().contains("In-store run");
            }

        }
        return false;
    }

    public boolean waitForWindowDisplayed(String title) {
        new WaitAction(driver).waitForDisplayed(homePageElements.windowTitle);
        return homePageElements.windowTitle.getText().equalsIgnoreCase(title);
    }

    public void clickReserveTimeOption() {
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.editReserveTimeButton);
    }

    public void clickViewAllPopularItems() {
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.popularViewAllButton);
    }

    public void clickSeeAllPopularItems() {
        new WaitAction(driver).waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.popularSeeAllButton);
    }

    public void clickSeeAllMustHaveGrabs() {
        new WaitAction(driver).waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.mustHaveGrabsSeeAllButton);
    }

    public void clickSeeAllBrowseCategories() {
        waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.browseCategoriesSeeAllButton);
    }

    public void verifyMustHaveGrabsItemsTitle() {
        new WaitAction(driver).waitForDisplayed(homePageElements.mustHaveGrabsTitle);
    }

    public void clickSortAndFilterButton() {
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.sortAndFilterButton);
    }

    public void waitForNoResultDisplayed() {
        new WaitAction(driver).waitForDisplayed(homePageElements.noSearchResult);
    }

    public void waitForProductDetailPageDisplayed() {
        new WaitAction(driver).waitForDisplayed(homePageElements.productImage);
    }

    public void waitForRelatedItemDisplayed() {

        scrollDownForElement(homePageElements.relatedProductText);
        new WaitAction(driver).waitForDisplayed(homePageElements.relatedProductText);

    }

    public void clickAddProductButton() {
        scrollTop();
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.addProductButton);
    }

    public void clickProductFromSearchList(int arg0) throws InterruptedException {
        new WaitAction(driver).waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.searchResultProductList.get(arg0 - 1));
    }

    public void waitForRecentSearchedItemDisplayed() {
        new WaitAction(driver).waitForDisplayed(homePageElements.recentlySearchedText);
    }

    public void waitForDealsToggleSwitchDisplayed() {
        new WaitAction(driver).waitForDisplayed(homePageElements.dealsToggleSwitch);
    }

    public void clickDealsToggleSwitch() {
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.dealsToggleSwitch);
    }

    public boolean dealsToggleSwitch(String switchStatus) {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            return homePageElements.dealsToggleSwitch.
                    getAttribute("value").equalsIgnoreCase(switchStatus);
        } else if (driver.getPlatformName().equalsIgnoreCase("android")) {
            if (homePageElements.dealsToggleSwitch.
                    getAttribute("checked").equalsIgnoreCase("true") && switchStatus.equals("on"))
                return true;
            return homePageElements.dealsToggleSwitch.
                    getAttribute("checked").equalsIgnoreCase("false") && switchStatus.equals("off");
        }
        return false;
    }

    public void androidNavigateBackArrow() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new CommonActions(driver).new ClickAction().clickElement(homePageElements.androidBackArrow);
        }
    }

    public void clickonSaveButton() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new CommonActions(driver).new ClickAction().clickElement(homePageElements.saveButton);
        }
    }

    public void changeQuantityto(String arg0) {
        new WaitAction(driver).waitForLoadingComplete();
        new WaitAction(driver).waitForDisplayed(homePageElements.quantityButton);

        new TapAction(driver).tapElementCoordinate(homePageElements.quantityButton);
        new WaitAction(driver).waitForDisplayed(homePageElements.quantityTextEdit);
        homePageElements.quantityTextEdit.sendKeys(arg0);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            driver.findElementByName("Update").click();
        } else {
            new TapAction(driver).tapEnterAndroidKeyboard();
        }
    }


    public void verifyNoSearchResultsDisplayed() {

        Assert.assertTrue(homePageElements.zeroSearchResults.isDisplayed());

    }

    public void userNavigateBackToHomePage() {
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.backButton);
    }

    public void clickShoppingCartButtonOnHomePage() throws InterruptedException {
        Thread.sleep(1000);
        new WaitAction(driver).waitForClickableAndClick(homePageElements.shoppingCartButtonWithXpath);
    }


    public void InStoreModeSetUpOnHomepage() throws InterruptedException {
        new WaitAction(driver).waitForLoadingComplete();
        if (homePageElements.pickupFromHomepage.size() > 0) {
            new CommonActions(driver).new ClickAction().clickElement(homePageElements.homepagePickUp);
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                new WaitAction(driver).waitForLoadingComplete();
                driver.findElement(By.name("whiteRightArrow")).click();
                new WaitAction(driver).waitForLoadingComplete();
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.inStoreSignInPageButton);
                selectOrderTypePage.selectAnyStore();
                driver.findElement(By.name("Start shopping")).click();
            } else {
                new WaitAction(driver).waitForLoadingComplete();
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.whiteRightArrow);
                new WaitAction(driver).waitForLoadingComplete();
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.inStoreSignInPageButton);
                Thread.sleep(5000);
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.startShoppingButton);

            }
        } else if (homePageElements.deliveryFromHomepage.size() > 0) {
            new CommonActions(driver).new ClickAction().clickElement(homePageElements.deliveryHomePage);
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                new WaitAction(driver).waitForLoadingComplete();
                driver.findElement(By.name("whiteRightArrow")).click();
                new WaitAction(driver).waitForLoadingComplete();
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.inStoreSignInPageButton);
                Thread.sleep(5000);
                driver.findElement(By.name("Start shopping")).click();
            } else {
                new WaitAction(driver).waitForLoadingComplete();
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.whiteRightArrow);
                new WaitAction(driver).waitForLoadingComplete();
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.inStoreSignInPageButton);
                Thread.sleep(5000);
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.startShoppingButton);

            }
        } else {

            System.out.println("this is in store mode");
        }


    }

    public void enterSearchItemAndClickMilk(String arg0) throws InterruptedException {

        if (driver.getPlatformName().equalsIgnoreCase("android")) {

            if (AppiumDeviceManager.getDevice().getDeviceType().equalsIgnoreCase("cloud")) {
                new WaitAction(driver).waitForLoadingComplete();
                homePageElements.searchEditButton.click();
                homePageElements.searchMilkButton.click();
//                homePageElements.searchEditText.sendKeys(arg0);
//                tapSearchAndroidKeyboard();
//                driver.hideKeyboard();
            } else {
                new WaitAction(driver).waitForLoadingComplete();
                enterKey(homePageElements.searchEditButton, arg0);
                new CommonActions(driver).new ClickAction().androidKeyboardClickDone();
            }
        } else {
//            enterKey(homePageElements.searchEditText, arg0 + Keys.RETURN.toString());
            Thread.sleep(2000);
            homePageElements.searchEditButton.click();
            homePageElements.searchMilkButton.click();
        }
    }

    public void iosToggleClose() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            try {
//                Thread.sleep(4000);
                if (homePageElements.iosToggle.isDisplayed())
                    new CommonActions(driver).new ClickAction().clickElement(homePageElements.iosToggleClose);
            } catch (Exception e) {
            }
        }
    }

    public void addFirstOnSearchpage() throws InterruptedException {
        Thread.sleep(5000);
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.addFirstItemForMilkSearch);

    }

    public void clickOnStartShoppingButton() throws InterruptedException {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Thread.sleep(5000);
            driver.findElement(By.name("Start shopping")).click();
        } else {
            Thread.sleep(5000);
            new CommonActions(driver).new ClickAction().clickElement(homePageElements.startShoppingButton);
        }
    }

    public void tapShoppingCartButton() throws InterruptedException {
        Thread.sleep(1000);
        new WaitAction(driver).waitForClickableAndClick(homePageElements.clickOnShoppingCartButton);
    }

    public void pickUpModeSetUpOnHomepage() throws InterruptedException {

        new WaitAction(driver).waitForLoadingComplete();
        if (homePageElements.inStoreFromHomepage.size() > 0) {
            new CommonActions(driver).new ClickAction().clickElement(homePageElements.inStoreHomepage);
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                new WaitAction(driver).waitForLoadingComplete();
                driver.findElement(By.name("whiteRightArrow")).click();
                new WaitAction(driver).waitForLoadingComplete();
                Thread.sleep(3000);
                driver.findElement(By.name("Pickup")).click();
                Thread.sleep(5000);
                driver.findElement(By.name("Start shopping")).click();
            } else {
                new WaitAction(driver).waitForLoadingComplete();
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.whiteRightArrow);
                new WaitAction(driver).waitForLoadingComplete();
                Thread.sleep(3000);
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.pickUpButtonOnSignInPage);
                Thread.sleep(5000);
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.startShoppingButton);
            }

        } else if (homePageElements.deliveryFromHomepage.size() > 0) {
            new CommonActions(driver).new ClickAction().clickElement(homePageElements.deliveryOnHomePage);
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                new WaitAction(driver).waitForLoadingComplete();
                driver.findElement(By.name("whiteRightArrow")).click();
                new WaitAction(driver).waitForLoadingComplete();
                driver.findElement(By.name("Pickup")).click();
                Thread.sleep(5000);
                driver.findElement(By.name("Start shopping")).click();
            } else {
                new WaitAction(driver).waitForLoadingComplete();
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.whiteRightArrow);
                new WaitAction(driver).waitForLoadingComplete();
                Thread.sleep(3000);
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.pickUpButtonOnSignInPage);
                Thread.sleep(5000);
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.startShoppingButton);

            }

        } else {
            System.out.println("this is pick up mode");
        }


    }

    public void deliveryModeSetUpOnHomepage() throws InterruptedException {

        new WaitAction(driver).waitForLoadingComplete();
        if (homePageElements.inStoreFromHomepage.size() > 0) {
            new CommonActions(driver).new ClickAction().clickElement(homePageElements.inStoreHomepage);
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                new WaitAction(driver).waitForLoadingComplete();
                driver.findElement(By.name("whiteRightArrow")).click();
                new WaitAction(driver).waitForLoadingComplete();
                new CommonActions(driver).new ClickAction().clickElement(selectOrderTypePageElements.deliverSignInPage);
                Thread.sleep(5000);
                driver.findElement(By.name("Start shopping")).click();
            } else {
                new WaitAction(driver).waitForLoadingComplete();
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.whiteRightArrow);
                new WaitAction(driver).waitForLoadingComplete();
                new CommonActions(driver).new ClickAction().clickElement(driver.findElement(By.xpath("//*[@resource-id=\"com.safeway.client.android.tomthumb.debug:id/delivery_zipcode\"]")));
//                new CommonActions(driver).new ClickAction().clickElement(selectOrderTypePageElements.deliverSignInPage);
                Thread.sleep(5000);
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.startShoppingButton);

            }
        } else if (homePageElements.pickupFromHomepage.size() > 0) {
            new CommonActions(driver).new ClickAction().clickElement(homePageElements.homepagePickUp);
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                new WaitAction(driver).waitForLoadingComplete();
                driver.findElement(By.name("whiteRightArrow")).click();
                new WaitAction(driver).waitForLoadingComplete();
                new CommonActions(driver).new ClickAction().clickElement(selectOrderTypePageElements.deliverSignInPage);
                Thread.sleep(2000);
                driver.findElement(By.name("Start shopping")).click();
            } else {
                new WaitAction(driver).waitForLoadingComplete();
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.whiteRightArrow);
                new WaitAction(driver).waitForLoadingComplete();
                new CommonActions(driver).new ClickAction().clickElement(driver.findElement(By.xpath("//*[@resource-id=\"com.safeway.client.android.tomthumb.debug:id/delivery_zipcode\"]")));
//                new CommonActions(driver).new ClickAction().clickElement(selectOrderTypePageElements.deliverSignInPage);
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.startShoppingButton);
            }
        } else {
            System.out.println("this is delivery mode");

        }


    }

    public void addItemOnCartPage() {
        try {


            for (int i = 0; i < 12; i++) {
                Thread.sleep(1000);
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.addFirstItemForMilkCartpage);
            }
        } catch (Exception exe) {


        }
    }

    public void clickOnCancelOnSearch() {
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.clickOnCancelOnSearchPage);
    }

    public void clickOnPickUpInSignInPage() throws InterruptedException {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new WaitAction(driver).waitForLoadingComplete();
            Thread.sleep(4000);
            if (homePageElements.searchbttn.isDisplayed()) {

            } else {
                driver.findElement(By.name("Pickup")).click();
            }

        } else {
            new WaitAction(driver).waitForLoadingComplete();
            Thread.sleep(4000);
            new CommonActions(driver).new ClickAction().clickElement(homePageElements.pickUpButtonOnSignInPage);
        }
    }


    public void navigateToAccount() throws InterruptedException {
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.membertab);
        //wait(3000);
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.Account);
    }

    public void clickDublinradio() {
        try {
            scrollDown(2);
            new CommonActions(driver).new ClickAction().clickElement(homePageElements.dublinbttn);
        } catch (Exception e) {
            scrollDown(1);
            new CommonActions(driver).new ClickAction().clickElement(homePageElements.dublinbttn);
        }

   /*  scrollDown(1);
        if (!homePageElements.dublinbttn.isDisplayed()) {
            scrollDown(1);
        }
      new CommonActions(driver).new ClickAction().clickElement(homePageElements.dublinbttn);*/
    }

    public void clickhamburgerMenu() {
        try {
            if (homePageElements.signout.isDisplayed()) {

            } else {
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.hamburgermenu);
            }
        } catch (Exception e) {
            new CommonActions(driver).new ClickAction().clickElement(homePageElements.hamburgermenu);
        }
    }

    public void clickHamburgerMenu() {
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.hamburgermenu);
        scrollDown(1);
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.developersettings);
        scrollDownForElement(homePageElements.isMyAccountEnabled);
    }

    public void clickHamburgerMenuAndScrollForFeature(String feature) throws Exception {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new CommonActions(driver).new ClickAction().clickElement(homePageElements.hamburgermenu);
            scrollDown(1);
        } else if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (!feature.equalsIgnoreCase("multiCtaCarousals")) {
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.hamburgermenu);
                scrollDown(1);
            }
        }
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.developersettings);
        if (feature.equalsIgnoreCase("aemSimpleCarousel")) {
            scrollDownForElement(homePageElements.isAemSimpleCarouselEnabled);
        } else if (feature.equalsIgnoreCase("multiCtaCarousals")) {
            scrollDownForElement(homePageElements.isMultiCtaCarouselEnabled);

        } else if (feature.equalsIgnoreCase("aemLargeBanner")) {
            scrollDownForElement(homePageElements.isAemLargeBannerEnabled);
        } else if (feature.equalsIgnoreCase("aemLargeCarousel")) {
            scrollDownForElement(homePageElements.isAemLargeCarouselEnabled);

        } else if (feature.equalsIgnoreCase("removeWeeklyAdBanner")) {
            scrollDownForElement(homePageElements.isRemoveWeeklyAdBannerEnabled);

        } else {
            throw new Exception("Feature flag is not present");

        }
    }

    public void swithchonMyAccount() throws InterruptedException {
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.isMyAccountEnabledswitch);
        isElementDisplayed(homePageElements.savebttn);
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.savebttn);
        waitForLoadingComplete();
    }


    public void signOutIfSignedIn() {
        try {
            if (homePageElements.homeTab.isDisplayed()) {
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.homeTab);
                clickMenuIcon();
                menuPageElements.signOutButton.click();
                menuPageElements.confirmSignOutButton.click();
            }
        } catch (Exception e) {
            return;
        }
    }

    public void clickOnAnySubCategoryFromTheCategorySelected() {
        new WaitAction(driver).waitForLoadingComplete();
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(homePageElements.subCategoryNames.get(0)));
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.subCategoryNames.get(0));
        new WaitAction(driver).waitForLoadingComplete();

    }

    public void viewAllRelatedProducts() {

        new CommonActions(driver).new ClickAction().clickElement(homePageElements.viewAllDealButton);

    }

    public void scrollDownForCategory(String item) {
//        scrollDownForElement(findElementByName(item));
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            WebElement element = driver.findElementByName(item);
            for (int i = 0; i < 10; i++) {

                if (element.isDisplayed()) {
                    return;
                } else {
                    scrollDown();
                }
            }
        } else {
            for (int i = 0; i < 10; i++) {
                ArrayList<MobileElement> elementList = (ArrayList<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
                for (MobileElement element : elementList) {
                    if (element.getText().equalsIgnoreCase(item)) {
                        return;
                    }
                }
                scrollDown();
            }
        }
    }

    public boolean isRefineButtonDisplayed() {
        return isElementDisplayed(homePageElements.refineButton);
    }

    public boolean isTotalCountDisplayed() {
        return isElementDisplayed(homePageElements.totalCount);
    }

    public boolean isProductsSelected() {
        boolean isSelected = false;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (homePageElements.productsToggle.isEnabled()) {
                isSelected = true;
            }
        } else {
            if (homePageElements.productsToggle.getAttribute("selected").equalsIgnoreCase("true")) {
                isSelected = true;
            }
        }
        return isSelected;
    }

    public boolean isDealsSelected() {
        boolean isSelected = false;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (homePageElements.dealsToggle.isEnabled()) {
                isSelected = true;
            }
        } else {
            if (homePageElements.dealsToggle.getAttribute("selected").equalsIgnoreCase("true")) {
                isSelected = true;
            }
        }
        return isSelected;
    }


    public void firstStoreAddressValue() {


        waitForDisplayed(selectOrderTypePageElements.storeAddress.get(0), 1);

        waitForDisplayed(selectOrderTypePageElements.storeAddress.get(0), 1);

        firstStoreAddress = selectOrderTypePageElements.storeAddress.get(0).getText();
    }

    public void verifyStoreAddress() {

        waitForDisplayed(pageElements.addressFieldOnSlotSelectionScreen, 20);
        String actualAddress = pageElements.addressFieldOnSlotSelectionScreen.getText();

        Assert.assertTrue(actualAddress.toLowerCase().contains(firstStoreAddress.toLowerCase().substring(0, 5)));

        waitForDisplayed(pageElements.addressFieldOnSlotSelectionScreen, 20);
//        String actualAddress = pageElements.addressFieldOnSlotSelectionScreen.getText();

        Assert.assertTrue(actualAddress.toLowerCase().contains(firstStoreAddress.toLowerCase().substring(0, 5)));


    }

    public void clickSearchButton() {
        homePageElements.searchButton.click();
//        driver.hideKeyboard();
    }

    public void clickMemberTab() {

        homePageElements.memberTab.click();


        waitForLoaderToDisappear();
    }

    public void clipDealHomePage() {
       /* homePageElements.firstDeal.click();
        System.out.println(homePageElements.toastMessage.getText());
        Assert.assertTrue(homePageElements.toastMessage.getAttribute("text").contains("Added to My List"));
   */
    }

    public void verifyToastMessage() {
//        Assert.assertTrue(homePageElements.toastMessage.getText().contains("Added to My List!"));

    }

    public void accountforsettings() {
        isElementDisplayed(homePageElements.Accountinsetting);
        homePageElements.Accountinsetting.click();
        String actualtext = "";
        actualtext = homePageElements.Accountinsettingscreen.getText();
        System.out.println(actualtext);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Assert.assertEquals(actualtext, "Account Tab, 3 of 3");
        } else {
            Assert.assertEquals(actualtext, "Account");
        }

    }

    public void clickhometab() {
        try {
            if (homePageElements.homeTab.isDisplayed()) {
                homePageElements.HomeTab.click();
            } else {
                homePageElements.backBttn.click();
            }
        } catch (Exception e) {
            homePageElements.backBttn.click();
        }
    }

    public void feshpassfromsettings() throws InterruptedException {
        Thread.sleep(5000);
        homePageElements.freshpass.click();
        String actualtext = "";
        actualtext = homePageElements.freshpassscreen.getText();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Assert.assertEquals(actualtext, "FreshPass Tab, 2 of 3");
        } else {
            Assert.assertEquals(actualtext, "FreshPass");
        }
    }

    public void validatehelpheader() throws InterruptedException {
        String actualtext = "";
        Thread.sleep(5000);
        actualtext = homePageElements.helpheader.getText();
        Assert.assertEquals(actualtext, "Help/FAQs");
    }

    public void clickHelpFAQ() {
        homePageElements.helpheader.click();
    }

    public void validatefeedbackheader() {
        String actualtext = "";
        waitForLoadingComplete();
        actualtext = homePageElements.feedbackinsettings.getText();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Assert.assertEquals(actualtext, "FreshPass");
        } else {
            Assert.assertEquals(actualtext, "FreshPass");
        }
    }

    public void validateContactUsheader() throws InterruptedException {
        String actualtext = "";
        Thread.sleep(5000);
        actualtext = homePageElements.contactusinsettings.getText();
        Assert.assertEquals(actualtext, "Contact Us");
    }

    public void validateTermsPolicies() throws InterruptedException {
        String actualtext = "";
        Thread.sleep(5000);
        actualtext = homePageElements.termsinsettings.getText();
        Assert.assertEquals(actualtext, "Terms & Policies");
    }

    public void clickShopPageBottomNav() {
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.shopTabBottomNav);
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.pastPurchasesShopPage);
    }

    public void clickDealsBottomNav() {
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.dealsBottomNav);
    }

    public void clickMyListBottomNav() {
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.myListBottomNav);
    }

    public void clickMemberTabBottomNav() {
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.memberTabBottomNav);
    }

    public void clickonclosesigninpage() {

        homePageElements.closebuttonsigninpage.click();
    }

    public void validatesigninpage() {
        homePageElements.signinexperience.isDisplayed();
        homePageElements.signinbutton.isDisplayed();
    }


    public void clickonshoptab() {
        homePageElements.shopTabBottomNav1.click();
    }

}


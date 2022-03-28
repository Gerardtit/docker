package com.automation.pages;


import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.TapAction;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GG_DealsPage extends BasePage {

    public GG_DealsPageElements pageElements = new GG_DealsPageElements();
    private GG_OtpPasswordPageElements otpPasswordPageElements = new GG_OtpPasswordPageElements();

    public CartPageElements cartPageElements = new CartPageElements();
    public String bogoProduct;
    public String productInCart;
    private String productInMustHaveGrabs;
    public GG_DealsPageElements dealsPageElements = new GG_DealsPageElements();
    public GG_DashboardPageElements dashboardPageElements = new GG_DashboardPageElements();


    private final GG_MyRewardsElements rewadsforuElements = new GG_MyRewardsElements();


    public GG_DealsPage(AppiumDriver driver) {
        super(driver);

        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cartPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), otpPasswordPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), rewadsforuElements);

        PageFactory.initElements(new AppiumFieldDecorator(driver), dealsPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cartPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dashboardPageElements);
    }

    public void goToDashboardPage() {
        new CommonActions(driver).new ClickAction().clickElement(dealsPageElements.homeTab);
    }

    public void clickOnNextBtn() {
      /*  if (popUpHandleElements.Continue.isDisplayed()) {
            popUpHandleElements.Continue.click();
        }*/
        new CommonActions(driver).new ClickAction().clickElement(dealsPageElements.nextBtn);

        new CommonActions(driver).new ClickAction().clickElement(dealsPageElements.brosweNextBtn);
       /* if (driver.getPlatformName().equalsIgnoreCase("ios")) {

            new CommonActions(driver).new ClickAction().clickElement(dealsPageElements.brosweNextBtn);

        }*/

     /*   Dimension dimension = driver.manage().window().getSize();
        int height = (int) (dimension.getHeight() * .90);
        int width = (int) (dimension.getWidth() * .92);
        tapCoordinate(width, height);*/

    }

    public boolean isForYouTabDisplayed() {

        if (driver.getPlatformName().equalsIgnoreCase("Android")) {
            if (isElementDisplayed(dashboardPageElements.cachingContinueBtn, 20)) {
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.cachingContinueBtn);
            }
        } else {
            if (isElementDisplayed(dashboardPageElements.Allow, 20)) {
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.Allow);
            }
        }

        for (int i = 0; i < 3; i++) {
            if (isElementDisplayed(otpPasswordPageElements.Delivery_Next, 20))

                new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.Delivery_Next);
            else {
                break;
            }
        }
        return isElementDisplayed(dealsPageElements.forYouTab, 20);

    }

    public boolean isAlldealsTabDisplayed() {

        if (driver.getPlatformName().equalsIgnoreCase("Android")) {
            if (isElementDisplayed(dashboardPageElements.cachingContinueBtn, 10)) {
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.cachingContinueBtn);

            }
        } else {
            if (isElementDisplayed(dashboardPageElements.Allow, 10)) {
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.Allow);
            }
        }

        for (int i = 0; i < 3; i++) {
            if (isElementDisplayed(otpPasswordPageElements.Delivery_Next, 10))

                new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.Delivery_Next);
            else {
                break;
            }
        }
        return isElementDisplayed(dealsPageElements.forYouTab, 5);

    }

    public void goToAllDealsTab() {
        scrollLeftThroughDealsTab("All deals", 3);
        new CommonActions(driver).new ClickAction().clickElement(dealsPageElements.allDealsTab);
    }

    public void goToBOGOTab() {

//        scrollThroughDealsTab("BOGO", 5);
        swipeLeftOnElement(dealsPageElements.promoTab);
        new CommonActions(driver).new ClickAction().clickElement(dealsPageElements.bogoTab);
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.dealsTab);


    }

    public void clickFirstBOGOCategory() {
        new CommonActions(driver).new ClickAction().clickElement(dealsPageElements.firstBOGOCategory);
    }

    public void addFirstBOGOOffer() {
        Assert.assertTrue(dealsPageElements.firstBOGOCouponDisplayed.getText().equals("Buy One Get One Free"));
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            bogoProduct = dealsPageElements.firstBOGOOfferName.getAttribute("label");
        } else {
            bogoProduct = dealsPageElements.firstBOGOOfferName.getAttribute("text");
        }
        System.out.println(bogoProduct);
        new CommonActions(driver).new ClickAction().clickElement(dealsPageElements.firstBOGODealAdd);
    }

    public void verifyBOGOOfferAddedInCart() {
        productInCart = cartPageElements.bogoElementAdded.getText();
        System.out.println(productInCart);
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            Assert.assertTrue(productInCart.contains(bogoProduct) | bogoProduct.contains(productInCart));
        } else {

            Assert.assertTrue((productInCart + ".").contains(bogoProduct) | bogoProduct.contains(productInCart));
        }
    }

    public void searchElement() {

        if (driver.getPlatformName().equalsIgnoreCase("android")) {
//            scrollDown();
            scrollDown();
        } else {
            scrollDown();
        }
        scrollDownForElement(pageElements.firstBOGOCouponDisplayed);

    }

    public void bufferProductName() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            productInMustHaveGrabs = dealsPageElements.firstBOGOOfferName.getAttribute("text");
        } else {
            productInMustHaveGrabs = dealsPageElements.firstBOGOOfferName.getAttribute("label");
        }
    }

    public void verifymustHaveGrabsOfferAddedInCart() {
        productInCart = cartPageElements.bogoElementAdded.getText();
        System.out.println(productInCart);
        Assert.assertTrue(productInCart.contains(productInMustHaveGrabs) | productInMustHaveGrabs.contains(productInCart));
    }


    public void goToPromoTab() {
        scrollThroughDealsTab("Promo", 3);
        new CommonActions(driver).new ClickAction().clickElement(dealsPageElements.promoTab);
        new WaitAction(driver).waitForElementToBeClickable(dealsPageElements.promoDealCard, 7);
    }

    public void goToCategoriesTab() {
        scrollLeftThroughDealsTab("Categories", 3);
        new CommonActions(driver).new ClickAction().clickElement(dealsPageElements.categoriesTab);
    }


    public void scrollThroughDealsTab(String tabNameDesired, int maxScrollCnt) {
        List<MobileElement> tabNamesDisplayed = null;
        ELEMENT_FOUND_LOOP:
        for (int scrollCnt = 0; scrollCnt < maxScrollCnt; scrollCnt++) {
            //Fetch all the tab names and check if the tab is displayed
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                tabNamesDisplayed = dealsPageElements.tabNames;
            } else {
                tabNamesDisplayed = driver.findElementsByXPath("//*[contains(@resource-id,'tab_layout')]//android.widget.TextView");
            }
            for (MobileElement tabName : tabNamesDisplayed) {
                if (getText(tabName).contains(tabNameDesired)) {
                    break ELEMENT_FOUND_LOOP;
                }

                break;
            }
            //Scroll from  last to first element
            scroll(tabNamesDisplayed.get(tabNamesDisplayed.size() - 1).getCenter().getX(), tabNamesDisplayed.get(tabNamesDisplayed.size() - 1).getCenter().getY(), tabNamesDisplayed.get(0).getCenter().getX(), tabNamesDisplayed.get(0).getCenter().getY());
        }
    }


    public void scrollLeftThroughDealsTab(String tabNameDesired, int maxScrollCnt) {
        List<MobileElement> tabNamesDisplayed = null;
        ELEMENT_FOUND_LOOP:
        for (int scrollCnt = 0; scrollCnt < maxScrollCnt; scrollCnt++) {

            //Fetch all the tab names and check if the tab is displayed
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                tabNamesDisplayed = dealsPageElements.tabNames;
            } else {
                tabNamesDisplayed = driver.findElementsByXPath("//*[contains(@resource-id,'tab_layout')]//android.widget.TextView");
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

    public void goToForYouTab() {
        scrollLeftThroughDealsTab("for U", 3);
        new CommonActions(driver).new ClickAction().clickElement(dealsPageElements.forYouTab);
    }

    public boolean isNavigationBarDisplayed() {
        if (isElementDisplayed(dealsPageElements.forYouTab) && isElementDisplayed(dealsPageElements.allDealsTab)) {
            return true;
        } else {
            return false;
        }
    }

    public void clickOnSearchIcon() {
        new CommonActions(driver).new ClickAction().clickElement(dealsPageElements.searchIcon);
    }

    public void clickCancelButtonOnSearchScreen() {
        new CommonActions(driver).new ClickAction().clickElement(dealsPageElements.cancelButtonOnSearchScreen);
    }

    public boolean isSearchIconDisplayed() {
        return isElementDisplayed(dealsPageElements.searchIcon);
    }

    public void scrollToCheckSearchBarAndIconRemainFixed() {
        scrollDown();
    }

    public boolean isMyCartIconDisplayed() {
        return isElementDisplayed(dealsPageElements.myCart);

    }

    public void pullToRefreshScreen() {
        refreshScreen();
    }

    public boolean isProgressSpinnerDisplayed() {
        refreshScreen();
        return isElementDisplayed(dealsPageElements.progressIndicator);
    }

    public boolean isProgressSpinnerDisplayedAfterWaiting() throws InterruptedException {
        Thread.sleep(15000);
        return isElementDisplayed(dealsPageElements.progressIndicator);
    }

    public String getCurrentlySelectedTab() {
        return getText(dealsPageElements.selectedTabDealsNavigator);
    }

    public boolean isDealsHeaderDisplayed() {
        return dealsPageElements.dealsTitleHeader.isDisplayed();
    }

    public void scrollUpOnThePage() {
        scrollUp();
    }

    public boolean verifyDealsNavigationIsVisible(String visibleOptn) {
        if (visibleOptn.contains("not")) {
            return isElementDisplayed(dealsPageElements.dealsTopNavBar, 5) == false;
        }
        return dealsPageElements.dealsTopNavBar.isDisplayed();
    }

    public boolean isClippedDealsLabelDisplayed() {
        return isElementDisplayed(dealsPageElements.clipAddedLabel);
    }

    public boolean isClippedLabelDisplayed() {
        if (!scrollDownForElement(dealsPageElements.couponAddedLabel, 10)) {
            new CommonActions(driver).new ClickAction().clickElement(dealsPageElements.clipButton);

        }
        return isElementDisplayed(dealsPageElements.clippedLabel);
    }

    public boolean verifyBuyItAgainLabelOnClippedDeals() {
        scrollDownForElement(dealsPageElements.couponAddedLabel);
        return (isElementDisplayed(dealsPageElements.couponAddedLabel) && dealsPageElements.buyAgainLabel.size() == 0);
    }

    public int getItemsCountFromCart() {
        int itemsCount = 0;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            itemsCount = Integer.valueOf(dealsPageElements.myCartCount.getAttribute("text").split(" ")[0].trim());
        } else {
            itemsCount = Integer.valueOf(dealsPageElements.myCartCount.getText().split(" item")[0].trim());
        }
        return itemsCount;
    }


    public void clickClipCoupon() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new CommonActions(driver).new ClickAction().clickElement(dealsPageElements.dismissButton);
            scrollDownForElement(dealsPageElements.clipCoupon);
            new WaitAction(driver).waitForLoadingComplete();
            //  Thread.sleep(1000);
            new CommonActions(driver).new ClickAction().clickElement(dealsPageElements.clipCoupon);
            new TapAction(driver).tapCoordinate(329, 2093);
            new WaitAction(driver).waitForLoadingComplete();
        } else {
            new CommonActions(driver).new ClickAction().clickElement(dealsPageElements.clipCoupon);
            new WaitAction(driver).waitForLoadingComplete();
        }

    }

    public boolean isItemYouBuyModuleDisplayed() {
        return scrollDownForElement(dealsPageElements.ItemYouBuyTitle);
    }

    public void scrollUpTillDealsTopNavigationBarDisplayed() {
        scrollUpForElement(dealsPageElements.dealsTopNavBar, 15);
        scrollUp();
    }

    public boolean isSearchBarDisplayed() {
        return isElementDisplayed(dealsPageElements.searchBarTextFieldInDealsTab, 5);
    }

    public void clickOnSearchBar() {
        new CommonActions(driver).new ClickAction().clickElement(dealsPageElements.searchBarTextFieldInDealsTab);
    }

    public boolean isCancelButtonDisplayed() {
        return isElementDisplayed(dealsPageElements.searchCancelButton, 5);
    }

    public void searchByProductNameInSearchBar(String productName) {
        clickOnSearchBar();
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                enterTextNoPressEnter(dealsPageElements.searchBarTextFieldInDealsTab, productName);
                new TapAction(driver).tapSearchEnterAndroid();
                break;
            case "IOS":
                enterKey(dealsPageElements.searchBarTextFieldInDealsTab, productName);
                break;
        }
    }

    public void verifySearchedProductDisplayed(String productName) {
        String dealName = dealsPageElements.dealsName.getText();
        String dealsDescription = dealsPageElements.dealsDescription.getText();
        if (!(dealName.toUpperCase().contains(productName.toUpperCase()) || dealsDescription.toUpperCase().contains(productName.toUpperCase()))) {
            Assert.assertTrue(false, String.format("Deals related to %s are not displayed!!", productName));
        }
    }


    public boolean isClippedLabelDisplayedOnDealDetailsPage() {
        new WaitAction(driver).waitForDisplayed(dealsPageElements.clippedLabel, 10);

        return isElementDisplayed(dealsPageElements.clippedLabel);
    }

    public boolean isViewListCTADisplayedOnDealDetails() {
        return isElementDisplayed(dealsPageElements.viewList);
    }

    public boolean isAllDealsTabDisplayed() {
        return pageElements.allDealsTab.isEnabled();
    }

    public boolean isCategoriesTabDisplayed() {
        return pageElements.categoriesTab.isEnabled();

    }


    public boolean isExpiringSoonTabDisplayed() {
        return dealsPageElements.expiringSoonTab.isEnabled();
    }

    public boolean isPromoTabDisplayed() {
        return dealsPageElements.promoTab.isEnabled();
    }

    public void goToPROMOTab() {
    }

    public Map<String, Map> getEligibleProducts(int maxProducts) {
        new WaitAction(driver).waitForDisplayed(dealsPageElements.prodCellEligibleProducts.get(0), 5);
        Map<String, Map> productCards = new HashMap<String, Map>();
        for (int cntVal = 0; cntVal < maxProducts; cntVal++) {
            for (MobileElement indProduct : dealsPageElements.prodCellEligibleProducts) {
                productCards = getEligibleProductCardInfo(indProduct, productCards);
            }
            new CommonActions(driver).new ScrollGestures().scrollDownBySmallAmount();
        }
        return productCards;
    }

    private Map<String, Map> getEligibleProductCardInfo(MobileElement indProduct, Map<String, Map> productCards) {
        Map<String, String> prodElements = new HashMap<String, String>();
        String attributeName = driver.getPlatformName().equalsIgnoreCase("ios") ? "label" : "text";
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            MobileElement productDescription = indProduct.findElementByName("lblDescription");
            String prodDesc = productDescription.getAttribute(attributeName);
            prodElements.put("prodAvailability", indProduct.findElementByXPath("//XCUIElementTypeOther[@name='viewStepperView']//XCUIElementTypeButton//XCUIElementTypeButton[@visible='true']").getAttribute(attributeName));
            productCards.put(prodDesc, prodElements);
        } else if (driver.getPlatformName().equalsIgnoreCase("android")) {

        }
        return productCards;
    }


}



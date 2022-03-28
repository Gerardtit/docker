package com.automation.pages;

import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_MyItemsPageElements;
import com.automation.pageElements.InStorePageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class InstorePageCTA extends BasePage {
    public InStorePageElements inStorePageElements = new InStorePageElements();
    public GG_MyItemsPageElements myItemsPageElements = new GG_MyItemsPageElements();

    public InstorePageCTA(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), inStorePageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), myItemsPageElements);
    }

    public void searchButter(String arg0) throws InterruptedException {

        if (driver.getPlatformName().equalsIgnoreCase("android")) {

            if (AppiumDeviceManager.getDevice().getDeviceType().equalsIgnoreCase("cloud")) {
                new WaitAction(driver).waitForLoadingComplete();
                inStorePageElements.searchBar.click();
                inStorePageElements.searchButter.click();
            } else {
                new WaitAction(driver).waitForLoadingComplete();
                enterKey(inStorePageElements.searchBar, arg0);
                new CommonActions(driver).new ClickAction().androidKeyboardClickDone();
            }
        } else {
            Thread.sleep(2000);
            inStorePageElements.searchBar.click();
            inStorePageElements.searchButter.click();
        }
    }

    public void iosToggleClose() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            try {

                Thread.sleep(2000);
//                if (inStorePageElements.iosToggle.isDisplayed())
//                    new CommonActions(driver).new ClickAction().clickElement(inStorePageElements.iosToggleClose);
                if (myItemsPageElements.dealsToggleSwitch.isDisplayed()) {
                    myItemsPageElements.dealsToggleSwitch.click();
                }
            } catch (Exception e) {

            }
        }
    }

    public boolean verifySearchedProductsAvailable() {
        new WaitAction(driver).waitForLoadingComplete();

        return isElementDisplayed(inStorePageElements.verifySearchResult, 50);
    }

    public void clickOnProduct() {
        new CommonActions(driver).new ClickAction().clickElement(inStorePageElements.clickProduct);
    }

    public void addItems() {

        try {
            for (int i = 0; i < 10; i++) {

                Thread.sleep(2000);
                new CommonActions(driver).new ClickAction().clickElement(inStorePageElements.addItems);

            }
        } catch (Exception exe) {
        }
    }


    public void checkQuantity() {
        try {
            Thread.sleep(5000);
            String actualCount = "";
            actualCount = inStorePageElements.checkQuantity.getText();
            Assert.assertEquals(actualCount, "10 in cart");
        } catch (Exception e) {

        }
    }

    public void clickOnList() {
        new WaitAction(driver).waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(inStorePageElements.clickList);
    }

    public void cartPageProductIncrement() {
        try {
            for (int i = 0; i <= 2; i++) {

                Thread.sleep(1000);

                new CommonActions(driver).new ClickAction().clickElement(inStorePageElements.cartPageIncrement);
            }
        } catch (Exception exe) {
        }

    }

    public void intActualQuantity() {
        String actualCount = "";
        actualCount = inStorePageElements.actualQuantity.getText();
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            Assert.assertEquals(actualCount, "13");
        } else {
            Assert.assertEquals(actualCount, "13");
        }
    }

    public boolean verifyMyListPageDisplayed() {

        waitForLoadingComplete();

        if (driver.getPlatformName().equalsIgnoreCase("Android")) {

            hideKeyBoard();
        }
        return isElementDisplayed(inStorePageElements.MyListPage, 10);


    }

    public void clickDeliveryOrPickUp() {
        new CommonActions(driver).new ClickAction().clickElement(inStorePageElements.clickDeliveryOrPickUp);
    }

    public void deliveryOrPickUpEnabled() {
        Assert.assertTrue(inStorePageElements.clickDeliveryOrPickUp.getAttribute("enabled").equals("true"));
    }

    public void clickPayInStore() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            driver.hideKeyboard();
            new CommonActions(driver).new ClickAction().clickElement(inStorePageElements.clickPayInStore);
        } else {
            new CommonActions(driver).new ClickAction().clickElement(inStorePageElements.clickPayInStore);
        }
    }


    public void removeItems() {
        new CommonActions(driver).new ClickAction().clickElement(inStorePageElements.removeItems);
    }

    public void closeMyListPage() {
        new CommonActions(driver).new ClickAction().clickElement(inStorePageElements.closeMyListPage);
    }

    public void closeNewCartPage() {
        new CommonActions(driver).new ClickAction().clickElement(inStorePageElements.closeNewCartPage);
    }

    public void closePage() {
        new CommonActions(driver).new ClickAction().clickElement(inStorePageElements.closePage);
    }

    public void backbutton() {
        new CommonActions(driver).new ClickAction().clickElement(inStorePageElements.backbutton);
    }


}

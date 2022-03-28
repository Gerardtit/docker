package com.automation.pages;

import com.automation.helpers.PageActions;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_BuyItAgainPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GG_BuyItAgainPage extends BasePage {
    private GG_BuyItAgainPageElements buyItAgainPageElements = new GG_BuyItAgainPageElements();

    public GG_BuyItAgainPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), buyItAgainPageElements);
    }

    public void clickBuyItAgainTab() {
        new WaitAction(driver).waitForDisplayed(buyItAgainPageElements.buyItAgainTab);
        new CommonActions(driver).new ClickAction().clickElement(buyItAgainPageElements.buyItAgainTab);
        new WaitAction(driver).waitForLoaderToDisappear();
    }

    public boolean buyItAgainTabinMyItemsPage() {
        new WaitAction(driver).waitForDisplayed(buyItAgainPageElements.buyItAgainTab);
        return buyItAgainPageElements.buyItAgainTab.isEnabled();
    }

    public void clickRefineButton() {
        new CommonActions(driver).new ClickAction().clickElement(buyItAgainPageElements.clickOnRefineButton);
    }

    public String verifyRefineWindowDisplayed() {
        String refineWindowTitle = (buyItAgainPageElements.refineWindowTitle).getText();
        return refineWindowTitle;
    }

    public boolean clippedDealsTabinMyItemsPage() {
        new WaitAction(driver).waitForDisplayed(buyItAgainPageElements.clippedDealsTab);
        return buyItAgainPageElements.clippedDealsTab.isEnabled();
    }

    public boolean lastOrderTabinMyItemsPage() {
        new WaitAction(driver).waitForDisplayed(buyItAgainPageElements.lastOrderTab);
        return buyItAgainPageElements.lastOrderTab.isEnabled();
    }

    public String verifyBuyItAgainPageIsEmpty() {
        String verifyBuyItAgainPageDescriptionEmpty = (buyItAgainPageElements.buyItAgainPageDescription).getText();
        return verifyBuyItAgainPageDescriptionEmpty;
    }

    public boolean verifyViewlAllPreselected() {
        new WaitAction(driver).waitForDisplayed(buyItAgainPageElements.viewAllPill);
        return buyItAgainPageElements.viewAllPill.isEnabled();
    }

    public void clickDairyEggsCheesePill() {
        try {
            new CommonActions(driver).new ClickAction().clickElement(buyItAgainPageElements.dairyEggsCheesePill);
            new WaitAction(driver).waitForLoadingComplete();
        } catch (Exception e) {
        }
    }

    public void clickBeveragesPill() {
        try {
            new CommonActions(driver).new ClickAction().clickElement(buyItAgainPageElements.beveragesPill);
            new WaitAction(driver).waitForLoadingComplete();
        } catch (Exception e) {
        }
    }

    public void clickWineBeerSpiritsPill() {
        try {
            new CommonActions(driver).new ClickAction().clickElement(buyItAgainPageElements.wineBeerSpiritsPill);
            new WaitAction(driver).waitForLoadingComplete();
        } catch (Exception e) {
        }
    }

    public void clickCookiesSnacksCandiesPill() {
        try {
            new CommonActions(driver).new ClickAction().clickElement(buyItAgainPageElements.cookiesSnacksCandiesPill);
            new WaitAction(driver).waitForLoadingComplete();
        } catch (Exception e) {
        }
    }

    public void clickFruitsVegetablesPill() {
        try {
            new CommonActions(driver).new ClickAction().clickElement(buyItAgainPageElements.fruitsVegetablesPill);
            new WaitAction(driver).waitForLoadingComplete();
        } catch (Exception e) {
        }
    }

    public void clickFrozenFoodsPill() {
        try {
            new CommonActions(driver).new ClickAction().clickElement(buyItAgainPageElements.frozenFoodsPill);
            new WaitAction(driver).waitForLoadingComplete();
        } catch (Exception e) {
        }
    }

    public void fruitsVegetablesPill() {
        scrollThroughBIATab("Fruits & Vegetables", 5);
        new WaitAction(driver).waitForLoaderToDisappear();
    }

    public void scrollThroughBIATab(String tabNameDesired, int maxScrollCnt) {
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                List<MobileElement> tabNamesDisplayed = null;
                ELEMENT_FOUND_LOOP:
                for (int scrollCnt = 0; scrollCnt < maxScrollCnt; scrollCnt++) {
                    tabNamesDisplayed = driver.findElementsByXPath("//*[contains(@resource-id,'id/rv_categories')]//android.widget.Button");
                    for (MobileElement tabName : tabNamesDisplayed) {
                        if (getText(tabName).contains(tabNameDesired)) {
                            break ELEMENT_FOUND_LOOP;
                        }
                    }
                    scroll(tabNamesDisplayed.get(tabNamesDisplayed.size() - 1).getCenter().getX(), tabNamesDisplayed.get(tabNamesDisplayed.size() - 1).getCenter().getY(), tabNamesDisplayed.get(0).getCenter().getX(), tabNamesDisplayed.get(0).getCenter().getY());
                }
                break;
            case "IOS":
                int counter = 0;
                while (counter < 4) {

                    if (isElementDisplayed(buyItAgainPageElements.buyItAgainTab, 2)) {
                        if (isElementDisplayed(buyItAgainPageElements.beveragesPill, 2)) {
                            new PageActions(driver).new SwipeActions().slideTabFromRightToLeft(buyItAgainPageElements.beveragesPill);
                        } else if (isElementDisplayed(buyItAgainPageElements.fruitsVegetablesPill, 2)) {
                            new PageActions(driver).new SwipeActions().slideTabFromRightToLeft(buyItAgainPageElements.fruitsVegetablesPill);
                        }
                        counter++;
                    } else {
                        break;
                    }
                }
                break;
        }
    }

    public void sortByFrequentlyPurchasedOption() {
        if (!verifyPurchasedDateSelected()) {
            new CommonActions(driver).new ClickAction().clickElement(buyItAgainPageElements.sortByFrequentlyPurchase);
        }
    }

    public boolean verifyFrequentlyPurchasedSelected() {
        boolean isSelected = false;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (buyItAgainPageElements.sortByFrequentlyPurchase.getAttribute("value").equalsIgnoreCase("Selected")) {
                isSelected = true;
            }
        } else {
            if (buyItAgainPageElements.sortByFrequentlyPurchase.getAttribute("checked").equalsIgnoreCase("true")) {
                isSelected = true;
            }
        }
        return isSelected;
    }

    public boolean verifyPurchasedDateSelected() {
        boolean isSelected = false;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (buyItAgainPageElements.sortByPurchaseDate.getAttribute("value").equalsIgnoreCase("Selected")) {
                isSelected = true;
            }
        } else {
            if (buyItAgainPageElements.sortByPurchaseDate.getAttribute("checked").equalsIgnoreCase("true")) {
                isSelected = true;
            }
        }
        return isSelected;
    }

    public void sortByPurchasedDateOption() {
        new CommonActions(driver).new ClickAction().clickElement(buyItAgainPageElements.sortByPurchaseDate);
    }

    public void clickFilterByInStore() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            if (buyItAgainPageElements.filterByInStore.getAttribute("selected").equalsIgnoreCase("true")) {
            } else {
                new CommonActions(driver).new ClickAction().clickElement(buyItAgainPageElements.filterByInStore);
            }
        } else if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (buyItAgainPageElements.instoreOptionSelected.isDisplayed()) {
            } else {
                new CommonActions(driver).new ClickAction().clickElement(buyItAgainPageElements.filterByInStore);
            }
        }
    }

    public void clickFilterByInStoreToDeselect() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            try {
                if (buyItAgainPageElements.filterByInStore.getAttribute("selected").equalsIgnoreCase("true")) {
                    new CommonActions(driver).new ClickAction().clickElement(buyItAgainPageElements.filterByInStore);
                }
            } catch (Exception e) {

            }
        } else if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            try {
                if (buyItAgainPageElements.instoreOptionSelected.isDisplayed()) {
                    new CommonActions(driver).new ClickAction().clickElement(buyItAgainPageElements.filterByInStore);
                }
            } catch (Exception e) {
            }
        }
    }

    public boolean verifyInstoreSelected() {
        boolean isSelected = false;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            if (buyItAgainPageElements.filterByInStore.getAttribute("selected").equalsIgnoreCase("true")) {
                isSelected = true;
            }
        } else {
            if (buyItAgainPageElements.instoreOptionSelected.isDisplayed()) {
                isSelected = true;
            }
        }
        return isSelected;
    }

    public void clickFilterByOnline() {
        new CommonActions(driver).new ClickAction().clickElement(buyItAgainPageElements.filterByOnline);
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            if (buyItAgainPageElements.filterByOnline.getAttribute("selected").equalsIgnoreCase("true")) {
            } else {
                new CommonActions(driver).new ClickAction().clickElement(buyItAgainPageElements.filterByOnline);
            }
        } else if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (buyItAgainPageElements.onlineOptionSelected.isDisplayed()) {
            } else {
                new CommonActions(driver).new ClickAction().clickElement(buyItAgainPageElements.filterByOnline);
            }
        }
    }

    public boolean verifyOnlineSelected() {
        boolean isSelected = false;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            if (buyItAgainPageElements.filterByOnline.getAttribute("selected").equalsIgnoreCase("true")) {
                isSelected = true;
            }
        } else {
            if (buyItAgainPageElements.instoreOptionSelected.isDisplayed()) {
                isSelected = true;
            }
        }
        return isSelected;
    }

    public void scrollDownToPast13months() {
        scrollDownForElement(buyItAgainPageElements.past13monthsPurchaseDate);
    }

    public void clickApply() {
        new CommonActions(driver).new ClickAction().clickElement(buyItAgainPageElements.applyButton);
    }

    public boolean isBuyItAgainProductsDisplayed() {
        return isElementDisplayed(buyItAgainPageElements.buyItAgainProductsDisplayed);
    }

    public void clickLastOrder() {
        new CommonActions(driver).new ClickAction().clickElement(buyItAgainPageElements.lastOrderPurchaseDate);
    }

    public boolean verifyLastOrderSelected() {
        boolean isSelected = false;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            if (buyItAgainPageElements.lastOrderTab.getAttribute("checked").equalsIgnoreCase("true")) {
                isSelected = true;
            }
        } else if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (buyItAgainPageElements.sortByPurchaseDate.getAttribute("value").equalsIgnoreCase("Selected")) {
                isSelected = true;
            }
        }
        return isSelected;
    }

    public boolean clickAllPastMonths() {
        boolean isSelected = false;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            for (int i = 0; i < buyItAgainPageElements.pastmonthsPurchaseDate.size(); i++) {
                new CommonActions(driver).new ClickAction().clickElement(buyItAgainPageElements.pastmonthsPurchaseDate.get(i));
                if (buyItAgainPageElements.pastmonthsPurchaseDate.get(i).getAttribute("value").equalsIgnoreCase("Selected")) {
                    isSelected = true;
                } else {
                    for (int k = 0; k < buyItAgainPageElements.pastmonthsPurchaseDate.size(); k++) {
                        new CommonActions(driver).new ClickAction().clickElement(buyItAgainPageElements.pastmonthsPurchaseDate.get(k));
                        if (buyItAgainPageElements.pastmonthsPurchaseDate.get(k).getAttribute("checked").equalsIgnoreCase("true")) {
                            isSelected = true;
                        }
                    }
                }
            }
        }
        return isSelected;
    }
}

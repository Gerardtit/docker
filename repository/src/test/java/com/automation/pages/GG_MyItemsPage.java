package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.TapAction;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_MyItemsPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;


public class GG_MyItemsPage extends BasePage {
    public GG_MyItemsPageElements myItemsElements = new GG_MyItemsPageElements();
    public Temp_signInPage temppage = new Temp_signInPage(driver);

    public GG_MyItemsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), myItemsElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), temppage);

    }


    public void clickAllowNotificationButton() {
        new CommonActions(driver).new ClickAction().clickElement(myItemsElements.allowNotificationButton);
       /* if(driver.getPlatformName().equalsIgnoreCase("ios")) {
            new CommonActions(driver).new ClickAction().clickElement(myItemsElements.dismissAlert);
            new WaitAction(driver).waitForLoadingComplete();

        }
        else{
            new WaitAction(driver).waitForLoadingComplete();
        }*/
        //    new WaitAction(driver).waitForLoadingComplete();
        Dimension dimension = driver.manage().window().getSize();
        int height = (int) (dimension.getHeight() * .90);
        int width = (int) (dimension.getWidth() * .92);
        new TapAction(driver).tapCoordinate(width, height);
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void clickMyItemsButton() {

        new WaitAction(driver).waitForLoadingComplete();

        new CommonActions(driver).new ClickAction().clickElement(myItemsElements.myItemsTab);

    }

    public void clickMyItemsFoundonPastPurchase() {

        new WaitAction(driver).waitForLoadingComplete();

        new CommonActions(driver).new ClickAction().clickElement(myItemsElements.itemsFoundonPastPurchase);

    }

    public boolean isMyLastOrderPageDisplayed() {
        boolean isSelected = false;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            // if(myItemsElements.myLastOrderTitle.getAttribute("visible").equalsIgnoreCase("true")){
            if (myItemsElements.myLastOrderTitle.getAttribute("value").contains("Last Order")) {
                isSelected = true;
            }
        } else {
            if (myItemsElements.myLastOrderTitle.getAttribute("selected").equalsIgnoreCase("true")) {
                isSelected = true;
            }
        }
        return isSelected;
    }

    public boolean isAllPastPurchasesSelected() {
        boolean isSelected = false;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            if (myItemsElements.allPastPurchasesTab.getAttribute("checked").equalsIgnoreCase("true")) {
                isSelected = true;
            }
        } else {
            if (myItemsElements.allPastPurchasesTab.getAttribute("value").equalsIgnoreCase("1")) {
                if (myItemsElements.myLastOrderTitle.getAttribute("checked").equalsIgnoreCase("true")) {
                    isSelected = true;
                }
            }
            return isSelected;
        }
        return isSelected;
    }

    public void waitForPageDisplayed() {

        new WaitAction(driver).waitForDisplayed(myItemsElements.myListTitle);

    }

    public void waitForPDPScreenDisplayed() {

        temppage.ClickDismiss();
        waitForDisplayed(myItemsElements.pdpScreen);

        driver.navigate().back();
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void clickDealsToggleSwitch() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new CommonActions(driver).new ClickAction().clickElement(myItemsElements.dealsToggleSwitch);
            new WaitAction(driver).waitForLoadingComplete();
        } else {
            new WaitAction(driver).waitForLoadingComplete();
        }
    }

    public void clickOnMyLastOrderTab() {
        new CommonActions(driver).new ClickAction().clickElement(myItemsElements.myLastOrderTab);
        if (isElementDisplayed(myItemsElements.closeToggle, 5)) {
            new CommonActions(driver).new ClickAction().clickElement(myItemsElements.closeToggle);
        }
    }

    public boolean isClippedDealsSectionIsSelected() {
        Assert.assertTrue(myItemsElements.clippedDealstab.isSelected());
        return true;
    }


    public void waitForItemsFoundDisplayed() {
    }
}
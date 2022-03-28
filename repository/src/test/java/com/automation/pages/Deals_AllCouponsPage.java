package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.DealsAllCouponPageElements;
import com.automation.pageElements.WalletPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Deals_AllCouponsPage extends BasePage {
    public DealsAllCouponPageElements pageElements = new DealsAllCouponPageElements();
    public WalletPageElements walletPageElements = new WalletPageElements();

    public Deals_AllCouponsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
    }

    public void clickDealsTab() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.clickDeals);
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void clickAllCouponsTab() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.clickAllCoupons);
        new WaitAction(driver).waitForLoadingComplete();
    }

    public boolean clippingCouponsDisplayed() {
        return scrollDownForElement(pageElements.verifyClippingCoupons);
    }

    public void ProductClips() {
        try {
            new WaitAction(driver).waitForDisplayed((pageElements.clipProduct1));
            new CommonActions(driver).new ClickAction().clickElement(pageElements.clipProduct1);
            Assert.assertTrue(pageElements.viewProducts.isDisplayed());


            new CommonActions(driver).new ClickAction().clickElement(pageElements.clickProduct1);
            new WaitAction(driver).waitForDisplayed(pageElements.clickDrawer);
            new WaitAction(driver).waitForDisplayed(pageElements.clickClose);
            new CommonActions(driver).new ClickAction().clickElement(pageElements.clickClose);

        } catch (Exception e) {
        }

        try {
            scrollDownForElement((pageElements.clipProduct2));
            new CommonActions(driver).new ClickAction().clickElement(pageElements.clipProduct2);
            Assert.assertTrue(pageElements.viewProducts.isDisplayed());
            new CommonActions(driver).new ClickAction().clickElement(pageElements.clickProduct2);
            new WaitAction(driver).waitForDisplayed(pageElements.clickDrawer);
            new CommonActions(driver).new ClickAction().clickElement(pageElements.clickDrawer);
            new WaitAction(driver).waitForDisplayed(pageElements.clickClose);
            new CommonActions(driver).new ClickAction().clickElement(pageElements.clickClose);
        } catch (Exception e) {
        }

        try {
            scrollDown();
            scrollDownForElement((pageElements.clipProduct3));
            new CommonActions(driver).new ClickAction().clickElement(pageElements.clipProduct3);
            Assert.assertTrue(pageElements.viewProducts.isDisplayed());
            new CommonActions(driver).new ClickAction().clickElement(pageElements.clickProduct3);
            new WaitAction(driver).waitForDisplayed(pageElements.clickDrawer);
            new CommonActions(driver).new ClickAction().clickElement(pageElements.clickDrawer);
            new WaitAction(driver).waitForDisplayed(pageElements.clickClose);
            new CommonActions(driver).new ClickAction().clickElement(pageElements.clickClose);

        } catch (Exception e) {

            if (isElementDisplayed(pageElements.clickClose)) {
                new CommonActions(driver).new ClickAction().clickElement(pageElements.clickClose);

            }
        }

    }

    public void clipProducts() {
        waitForDisplayed((pageElements.clipProduct1));
        new CommonActions(driver).new ClickAction().clickElement(pageElements.clipProduct1);
        Assert.assertTrue(pageElements.viewProducts.isDisplayed());
        new CommonActions(driver).new ClickAction().clickElement(pageElements.clipProduct2);
    }

    public void clickClippedDeals() {

        new CommonActions(driver).new ClickAction().clickElement(pageElements.clickClippedDeals);
        scrollDown();


    }


    public void rewardsPillDisplayed() {
        Assert.assertTrue(pageElements.rewardsPill.isDisplayed());
    }

    public void clickOnRewardsPill() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.rewardsPill);
    }

    public void clippedDealsPillDisplayed() {
        Assert.assertTrue(pageElements.clippedDealPill.isDisplayed());
    }

    public void clickOnClippedDealsPill() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.clippedDealPill);
    }

    public void weeklyAdDisplayed() {
        Assert.assertTrue(pageElements.weeklyAdPill.isDisplayed());
    }

    public void clickWeeklyAdPill() {

        new CommonActions(driver).new ClickAction().clickElement(pageElements.weeklyAdPill);

    }

    public void offerdetails() {

        pageElements.detailsatClippeddeals.click();
        pageElements.viewListAtclipped.click();
    }
}

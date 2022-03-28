package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.WalletPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class WalletPage extends BasePage {
    public WalletPageElements walletPageElements = new WalletPageElements();

    public WalletPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), walletPageElements);
    }

    public void waitForHomePageDisplayed() {
        new WaitAction(driver).waitForLoadingComplete();
        waitVar.until(ExpectedConditions.visibilityOf(walletPageElements.menuButton));
        Assert.assertTrue(walletPageElements.menuButton.isDisplayed());
    }

    public boolean verifySearchBarDisplayed() {
        new WaitAction(driver).waitForLoadingComplete();
        return isElementDisplayed(walletPageElements.searchBar, 2);
    }

    public void clickOnWallet() {
        new WaitAction(driver).waitForClickableAndClick(walletPageElements.clickWallet);
    }

    public boolean waitForPageDisplayed(String title) {
        new WaitAction(driver).waitForDisplayed(walletPageElements.pageTitle);
        return walletPageElements.pageTitle.getText().equalsIgnoreCase(title);
    }

    public void clickWalletTab() {
        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.walletTab);
        new WaitAction(driver).waitForLoaderToDisappear();
    }

    public void clickWalletSubTab() {
        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.walletSubTab);
        waitForLoaderToDisappear();
    }

    public boolean verifyLoyaltyCardDisplayed() {

        new WaitAction(driver).waitForLoadingComplete();
        return isElementDisplayed(walletPageElements.loyaltyCard, 50);
    }

    public boolean verifyClippedRewardsDisplayed() {
        new WaitAction(driver).waitForLoadingComplete();
        return isElementDisplayed(walletPageElements.clippedRewards, 50);

    }

    public boolean verifyClippedDealsDisplayed() {
        new WaitAction(driver).waitForLoadingComplete();
        return isElementDisplayed(walletPageElements.clippedDeals, 5);
    }

    public void verifyClippedDealsNotDisplayed() {

        Assert.assertTrue(!isElementDisplayed(walletPageElements.clippedDeals), "You clipped X Deals is not displayed");

    }

    public boolean verifyClippedDealsPageisDisplayed() {
        new WaitAction(driver).waitForLoadingComplete();
        return isElementDisplayed(walletPageElements.clippedDealsPage, 50);
    }

    public void clickedDeals() {
        walletPageElements.clippedDeals.click();
        new WaitAction(driver).waitForLoadingComplete();
    }

    public boolean verifyClipCouponisDisplayed() {
        new WaitAction(driver).waitForLoadingComplete();
        return isElementDisplayed(walletPageElements.clipCoupon, 50);
    }

    public void clickMemberTab() {
        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.memberTab);
        new WaitAction(driver).waitForLoaderToDisappear();
    }

    public void verifyClippedDeals() {
        Assert.assertTrue(!isElementDisplayed(walletPageElements.yourClippedDeals), "You clipped X Deals is not displayed");
    }

    public void verifySeeyourclippeddeals() {
        Assert.assertTrue(isElementDisplayed(walletPageElements.checkClippedDeals), "You clipped X Deals is displayed for a user without clipped coupon");
    }

    public void verifySeeInWallet() {
    }


    public void clickSeeYourClippedDeals() {
        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.checkClippedDeals);
        new WaitAction(driver).waitForLoaderToDisappear();

    }

    public void rewardstab() {
//        walletPageElements.rewardstab.isDisplayed();
//        walletPageElements.rewardstab.click();
    }
}

package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_DashboardWeeklyAdElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class GG_DashboardWeeklyAdPage extends BasePage {

    private final GG_DashboardWeeklyAdElements dashboardWeeklyAdElements = new GG_DashboardWeeklyAdElements();

    public GG_DashboardWeeklyAdPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dashboardWeeklyAdElements);
    }

    public void verifyWeeklyAdBannerModule() {
        scrollUpForElement(dashboardWeeklyAdElements.weeklyAdBanner);
        new WaitAction(driver).pleaseWaitForTheLoadingToComplete();
        waitVar.until(ExpectedConditions.visibilityOf(dashboardWeeklyAdElements.weeklyAdBanner));
    }

    public void verifyWeeklyAdBannerImage() {
        waitVar.until(ExpectedConditions.visibilityOf(dashboardWeeklyAdElements.weeklyAdBannerImage));
    }

    public void clickWeeklyAdBanner() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardWeeklyAdElements.weeklyAdBanner);
    }

    public boolean scrollDownUptoWeeklyAdsSection() {
        if (scrollDownForElement(dashboardWeeklyAdElements.weeklyAdBanner)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean scrollUptoWeeklyAdsSection() {
        if (scrollUpForElement(dashboardWeeklyAdElements.weeklyAdBanner)) {
            return true;
        } else {
            return false;
        }
    }


    public boolean verifyWeeklyAdIframeTitle() {
        return (isElementDisplayed(dashboardWeeklyAdElements.weeklyAdBannerTitle));
    }

    public boolean isWeeklyAdCouponDetailsPageDisplayed() throws InterruptedException {
        waitForLoaderToDisappear();
        Thread.sleep(3000);
        return isElementDisplayed(dashboardWeeklyAdElements.weeklyAdCoverImage, 60);
    }

    public void waitForLoaderToDisappear() {
        new WaitAction(driver).waitForElementToDisappear(dashboardWeeklyAdElements.loadingSpinner, 60);
    }

    public boolean isLoadingSpinnerDisplayed() {
        return isElementDisplayed(dashboardWeeklyAdElements.loadingSpinner);
    }

    public boolean verifySkinnyVersionOfWeeklyAdBanner() {
        scrollDownForElement(dashboardWeeklyAdElements.skinnyWeeklyAdBanner);
        Dimension defaultDealDimension = dashboardWeeklyAdElements.skinnyWeeklyAdBanner.getSize();
        return defaultDealDimension.getHeight() <= 310;

    }

    public boolean verifyNormalVersionOfWeeklyAdBanner() {
        scrollDownForElement(dashboardWeeklyAdElements.weeklyAdBanner);
        boolean isNormalVersionDisplayed = false;
        Dimension defaultDealDimension = dashboardWeeklyAdElements.weeklyAdBanner.getSize();
        int skinnyWeeklyAdBannerWidth = defaultDealDimension.getWidth();
        int skinnyWeeklyAdBannerHeight = defaultDealDimension.getHeight();

        if (skinnyWeeklyAdBannerWidth < 1000 && skinnyWeeklyAdBannerHeight > 240) {
            isNormalVersionDisplayed = true;
        }
        return isNormalVersionDisplayed;
    }

    public void clickOnBackBtn() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardWeeklyAdElements.backButton);
    }

    public void userClickWeeklyAdBannerImage() {
        dashboardWeeklyAdElements.weeklyAdBannerImage.click();
    }

    public void verifyWeeklyAdBannerImageNotVisible() {
        Assert.assertTrue(!isDisplayed(dashboardWeeklyAdElements.weeklyAdBannerImage));
    }

    public boolean isDisplayed(MobileElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception exception) {
            return false;
        }
    }
}

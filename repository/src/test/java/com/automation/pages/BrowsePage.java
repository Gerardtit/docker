package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.BrowsePageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BrowsePage extends BasePage {

    private final BrowsePageElements browsePageElements = new BrowsePageElements();
    private final HomePage homepage;

    public BrowsePage(AppiumDriver driver) {
        super(driver);
        homepage = new HomePage(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), browsePageElements);
    }

    public void clickonSHOPTabofHomePage() {
        waitForLoadingComplete();
        waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(browsePageElements.Shop);
        waitForLoadingComplete();
    }

    public void scrollDowntillCTAlabel() {
        waitForLoadingComplete();
        waitForLoadingComplete();
        {
//            scrollDownForEnabledElement(browsePageElements.CTALabel);
        }
    }

    public void verifyElementCarouselTitle() {
        Assert.assertTrue(browsePageElements.CarouselTitle.isDisplayed());
        waitForLoadingComplete();
    }

    public void clickElementCTALabel() {
        new CommonActions(driver).new ClickAction().clickElement(browsePageElements.CTALabel);
    }

    public void verifysheetUIPage() {
        Assert.assertTrue(browsePageElements.ProductCollectionUIPage.isDisplayed());
        waitForLoadingComplete();
    }

    public void closeSheetUIPage() {
        new CommonActions(driver).new ClickAction().clickElement(browsePageElements.btnCloseUI);
    }

    public void scrollDownandUpinPage() {
        scrollDown();
        scrollDown();
        scrollDown();
        scrollUp();
        scrollUp();
        scrollUp();

    }

    public void userClicksFeaturedItemOnAislesTab(String arg0) {
        if (arg0.contains("Weekly Ad")) {
            new CommonActions(driver).new ClickAction().clickElement(browsePageElements.weeklyAdButton);
        } else if (arg0.contains("Pharmacy")) {
            new CommonActions(driver).new ClickAction().clickElement(browsePageElements.pharmacyButton);
        } else if (arg0.contains("Past Purchases")) {
            new CommonActions(driver).new ClickAction().clickElement(browsePageElements.pastPurchasesButton);
        }
    }

    public void scrollDownForFeaturedSection(String arg0) {
        if (arg0.contains("Weekly Ad")) {
            scrollDownForElement(browsePageElements.weeklyAdButton);
        } else if (arg0.contains("Pharmacy")) {
            scrollDownForElement(browsePageElements.pharmacyButton);
        } else if (arg0.contains("Past Purchases")) {
            scrollDownForElement(browsePageElements.pastPurchasesButton);
        }
    }

    public void verifyUserLandsOnFeaturedSectionPage(String arg0) {
        if (arg0.contains("Weekly Ad")) {
            Assert.assertTrue(browsePageElements.weeklyAdsPageTitle.isDisplayed());
        } else if (arg0.contains("Pharmacy")) {
            Assert.assertTrue(browsePageElements.pharmacyPageTitle.isDisplayed());
        } else if (arg0.contains("My List")) {
            Assert.assertTrue(browsePageElements.myListPageTitle.isDisplayed());
        }
    }


}




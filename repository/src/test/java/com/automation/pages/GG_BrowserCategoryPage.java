package com.automation.pages;


import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.BrowserCategoryPageElements;
import com.automation.pageElements.HomePageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class GG_BrowserCategoryPage extends BasePage {

    private final BrowserCategoryPageElements browserCategoryElements = new BrowserCategoryPageElements();
    private final HomePageElements homePageElements = new HomePageElements();

    public GG_BrowserCategoryPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), browserCategoryElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), homePageElements);
    }

    public void browserPageIsDisplayed() {
        new WaitAction(driver).waitForDisplayed(browserCategoryElements.browserPageSearchTab);
        browserCategoryElements.browserPageSearchTab.isDisplayed();
    }

    public void CategoryPageIsDisplayed() {
        scrollDownForElement(browserCategoryElements.browserAtHomePage);
        new WaitAction(driver).waitForDisplayed(browserCategoryElements.seeAll);
        new WaitAction(driver).waitForLoadingComplete();
        browserCategoryElements.seeAll.click();

    }

    public void validateElements() {
        new WaitAction(driver).waitForDisplayed(browserCategoryElements.browserPageSearchTab);
        new WaitAction(driver).waitForDisplayed(browserCategoryElements.browserPageSearchTab);
        browserCategoryElements.browserPageSearchTab.isDisplayed();
        browserCategoryElements.browserPageSearchIcon.isDisplayed();
        browserCategoryElements.browserPageCartIcon.isDisplayed();
    }


    public void validation() {
        new WaitAction(driver).waitForLoadingComplete();
        browserCategoryElements.browserPageBaByCare.isDisplayed();
        browserCategoryElements.browserPageBeverage.isDisplayed();
        browserCategoryElements.browserPageCereal.isDisplayed();
        browserCategoryElements.browserPageBakery.isDisplayed();
        scrollDownForElement(browserCategoryElements.browserPageCannedSoup);
        browserCategoryElements.browserPageCannedSoup.isDisplayed();
        scrollDownForElement(browserCategoryElements.browserPageSpiceNBake);
        browserCategoryElements.browserPageSpiceNBake.isDisplayed();
        scrollDownForElement(browserCategoryElements.browserPagecookies);
        browserCategoryElements.browserPagecookies.isDisplayed();
        scrollDownForElement(browserCategoryElements.browserPageDairy);
        new WaitAction(driver).waitForDisplayed(browserCategoryElements.browserPageDairy);
        browserCategoryElements.browserPageDairy.isDisplayed();
        scrollDownForElement(browserCategoryElements.browserPageDeli);
        browserCategoryElements.browserPageDeli.isDisplayed();
        browserCategoryElements.browserPageFlower.isDisplayed();
        scrollDownForElement(browserCategoryElements.browserPageFrozen);
        browserCategoryElements.browserPageFrozen.isDisplayed();
        browserCategoryElements.browserPageFruitsNVeg.isDisplayed();
        scrollDownForElement(browserCategoryElements.browserPageGrainNPasta);
        browserCategoryElements.browserPageGrainNPasta.isDisplayed();
        scrollDownForElement(browserCategoryElements.browserPageInternationalCuisine);
        new WaitAction(driver).waitForDisplayed(browserCategoryElements.browserPageInternationalCuisine);
        browserCategoryElements.browserPageInternationalCuisine.isDisplayed();
        scrollDownForElement(browserCategoryElements.browserPageMeatNSeafood);
        browserCategoryElements.browserPageMeatNSeafood.isDisplayed();
        browserCategoryElements.browserPagecleaning.isDisplayed();
        scrollDownForElement(browserCategoryElements.browserPagePetCare);
        new WaitAction(driver).waitForDisplayed(browserCategoryElements.browserPagePetCare);
        browserCategoryElements.browserPagePetCare.isDisplayed();
        scrollDownForElement(browserCategoryElements.browserPagePersonalCare);
        browserCategoryElements.browserPagePersonalCare.isDisplayed();
        scrollDownForElement(browserCategoryElements.browserPagewine);
        new WaitAction(driver).waitForDisplayed(browserCategoryElements.browserPagewine);
        browserCategoryElements.browserPagewine.isDisplayed();
        browserCategoryElements.browserPageTobacco.isDisplayed();

    }
}

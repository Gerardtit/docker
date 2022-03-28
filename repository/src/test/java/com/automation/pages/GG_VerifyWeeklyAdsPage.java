package com.automation.pages;


import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_verifyWeeklyAdsElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GG_VerifyWeeklyAdsPage extends BasePage {

    private final GG_verifyWeeklyAdsElements weeklyAdsElements = new GG_verifyWeeklyAdsElements();


    public GG_VerifyWeeklyAdsPage(AppiumDriver driver) {
        super(driver);

        PageFactory.initElements(new AppiumFieldDecorator(driver), weeklyAdsElements);
    }

    public void verifyWeeklyAdOnHomePage() {
        new WaitAction(driver).waitForLoadingComplete();
        scrollDownForElement(weeklyAdsElements.weeklyAdsOnHomepage);
        weeklyAdsElements.weeklyAdsOnHomepage.click();
    }

    public void validateError() {
        new WaitAction(driver).waitForLoadingComplete();
        new WaitAction(driver).waitForDisplayed(weeklyAdsElements.messageOnWeeklyAdPage);
        weeklyAdsElements.messageOnWeeklyAdPage.isDisplayed();
    }
}





















package com.automation.pages;


import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.WeeklyAdPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WeeklyAdPage extends BasePage {
    public WeeklyAdPageElements weeklyAdPageElements = new WeeklyAdPageElements();

    public WeeklyAdPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), weeklyAdPageElements);
    }

    public void verifyWeeklyAdPageTitle() {
        new WaitAction(driver).waitForDisplayed(weeklyAdPageElements.weeklyAdTitle);
        Assert.assertTrue(weeklyAdPageElements.weeklyAdTitle.isDisplayed());
    }
}

package com.automation.pages;


import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_DashboardPageElements;
import com.automation.pageElements.ZipCodePageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZipCodePage1 extends BasePage {

    public ZipCodePageElements zipCodePageElements = new ZipCodePageElements();
    public GG_DashboardPageElements dashboardPageElements = new GG_DashboardPageElements();

    public ZipCodePage1(AppiumDriver driver) {

        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), zipCodePageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dashboardPageElements);
    }

    public void waitForZipCodePageDisplayed1() {


        waitForLoadingComplete();


        if (driver.getPlatformName().equalsIgnoreCase("iOS")) {

            if (isElementDisplayed(dashboardPageElements.allownotificationsBtn, 10)) {

                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.allownotificationsBtn);
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.dontAllowBtn);
            }

            new WaitAction(driver).waitForLoadingComplete();

            waitVar.until(ExpectedConditions.elementToBeClickable(zipCodePageElements.zipCodeEditText));
            new WaitAction(driver).waitForLoadingComplete();


        }
    }
}

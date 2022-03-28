package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.manager.ConfigFileManager;
import com.automation.pages.HomePage;
import com.automation.pages.SelectOrderTypePage;
import com.automation.pages.StartUpPage;
import com.automation.pages.ZipCodePage;
import io.appium.java_client.AppiumDriver;

import java.io.IOException;
import java.util.Map;

public class PreExecutionStep {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public StartUpPage startUpPage = new StartUpPage(driver);
    public ZipCodePage zipCodePage = new ZipCodePage(driver);
    public SelectOrderTypePage selectOrderTypePage = new SelectOrderTypePage(driver);
    public HomePage homePage = new HomePage(driver);

    public PreExecutionStep() throws IOException, InterruptedException {
        try {
            driver.launchApp();
            startUpPage.waitForStartUpPageDisplayed();
            startUpPage.clickContinue();
            zipCodePage.waitForZipCodePageDisplayed();
            zipCodePage.enterZipCode(ThreadLocalHelper.testCaseData.get().get("ZIPCODE"));
            zipCodePage.clickNextButton();

            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                homePage.waitForNotificationAlert();
                homePage.clickDoNotAllowNotification();
            }
            homePage.waitForHomePageDisplayed();
            //click deal switch - ios
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                homePage.clickSearchBar();
                homePage.waitForSearchWindowDisplayed();
                //click baby health
                homePage.enterSearchItem("baby health");
                homePage.clickAddItem("1");
            }
        } catch (Exception e) {
        }
        driver.closeApp();
    }
}

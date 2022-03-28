package com.automation.pages;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_AccountProfilePageElements;
import com.automation.pageElements.GG_OtpPasswordPageElements;
import com.automation.pageElements.PopUpHandleElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class GG_OtpPasswordPage1 extends BasePage {


    private GG_OtpPasswordPageElements otpPasswordPageElements = new GG_OtpPasswordPageElements();
    private AppiumDevice device = AppiumDeviceManager.getDevice();
    public static String unregisteredPhoneNumber = "";
    public static String sso_User = "";
    private GG_AccountProfilePageElements myAccountPageElementsPage = new GG_AccountProfilePageElements();
    private PopUpHandleElements popUpHandleElements = new PopUpHandleElements();
    public GG_DealsPage dealsPage = new GG_DealsPage(driver);
    public GG_DashboardPage dashboardPage = new GG_DashboardPage(driver);


    public GG_OtpPasswordPage1(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), otpPasswordPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), myAccountPageElementsPage);
        PageFactory.initElements(new AppiumFieldDecorator(driver), popUpHandleElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dealsPage);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dashboardPage);
    }


    public void verifyHomePage() {
        Assert.assertTrue(isHomeScreenDisplayed(), "Home page not loaded");
//        if (driver.getPlatformName().equalsIgnoreCase("android")) {
//            scrollDown();
//        }

    }


    public boolean isHomeScreenDisplayed() {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (isElementDisplayed(otpPasswordPageElements.Allow, 2))

                new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.Allow);

        }

//    if (driver.getPlatformName().equalsIgnoreCase("android")) {
//        try {
//            if (popUpHandleElements.Continue.isDisplayed()) {
//                popUpHandleElements.Continue.click();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
        for (int i = 0; i < 3; i++) {
            if (isElementDisplayed(otpPasswordPageElements.Delivery_Next, 10))
                new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.Delivery_Next);

            else {
                break;
            }
        }


        if (driver.getPlatformName().equalsIgnoreCase("ios")) {

            try {
                if (popUpHandleElements.Continue.isDisplayed()) {
                    popUpHandleElements.Continue.click();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        waitVar.until(ExpectedConditions.visibilityOf(
                otpPasswordPageElements.UMA_Home));
        return isElementDisplayed(otpPasswordPageElements.UMA_Home, 1);
    }
}

package com.automation.pages;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_OtpPasswordPageElements;
import com.automation.pageElements.PopUpHandleElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class PopUpHandlePage extends BasePage {
    private final PopUpHandleElements popUpHandleElements = new PopUpHandleElements();
    private final GG_OtpPasswordPageElements otpPasswordPageElements = new GG_OtpPasswordPageElements();
    private final AppiumDevice device = AppiumDeviceManager.getDevice();

    public PopUpHandlePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), popUpHandleElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), otpPasswordPageElements);
    }

    public void closeSoftUpgradeMessage() {
        if (popUpHandleElements.SoftUpgradeMayBeLater.isDisplayed()) {
            popUpHandleElements.SoftUpgradeMayBeLater.click();
        }

        if (popUpHandleElements.Continue.isDisplayed()) {
            popUpHandleElements.Continue.click();
        }
    }

    public void clickDismiss() {

        if (isElementDisplayed(popUpHandleElements.dismissButton, 3)) {
            popUpHandleElements.dismissButton.click();
        }
    }

    public void clickAllow() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (isElementDisplayed(otpPasswordPageElements.Allow, 50))
                new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.Allow);
        }
    }

    public void clickYes() {
        if (isElementDisplayed(popUpHandleElements.clickYesIfYouLoveApp)) {
            popUpHandleElements.clickYesIfYouLoveApp.click();
            popUpHandleElements.dismissButton.click();
        }
    }

    public void clickCancel() {
        if (popUpHandleElements.clickCancel.isDisplayed()) {
            popUpHandleElements.clickCancel.click();
        }
    }

    public void clickNextOnPopup() {
        for (int i = 0; i < 4; i++) {
            if (isElementDisplayed(otpPasswordPageElements.Delivery_Next, 10))
                new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.Delivery_Next);
            else {
                break;
            }
        }
    }

    public void userShouldNotSeeAllowPermission() {

        Assert.assertFalse(isElementDisplayed(popUpHandleElements.openWithAppAlwaysButton));

    }

}

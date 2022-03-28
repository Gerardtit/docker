package com.automation.pages;


import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_FoodLotPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class GG_FoodTruck_OrderConfirmationPage extends BasePage {

    AppiumDevice device = AppiumDeviceManager.getDevice();
    private final GG_FoodLotPageElements foodLotPageElements = new GG_FoodLotPageElements();

    public GG_FoodTruck_OrderConfirmationPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), foodLotPageElements);
    }

    public void verifyOrderConfirmationPage() {
        Assert.assertTrue(isElementDisplayed(foodLotPageElements.orderConfirmationPage, 20), "Order confirmation page is not displayed");
    }

    public void clickBackButton() {
        new CommonActions(driver).new ClickAction().clickElement(foodLotPageElements.backButton);
    }

}

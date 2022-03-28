package com.automation.pages;


import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_FoodLotPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class GG_FoodTruck_LandingPage extends BasePage {
    private final static String STORE_DYNAMIC_ZIPCODE_ANDROID = "//*[contains(@text,'%s')]";
    private final static String STORE_DYNAMIC_ZIPCODE_IOS = "//*[contains(@label,'%s')]";
    AppiumDevice device = AppiumDeviceManager.getDevice();
    private final GG_FoodLotPageElements foodLotPageElements = new GG_FoodLotPageElements();

    public GG_FoodTruck_LandingPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), foodLotPageElements);
    }

    public void verifyStoreAddress(String storeAddress) throws InterruptedException {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            Assert.assertTrue(driver.findElement(By.xpath(String.format(STORE_DYNAMIC_ZIPCODE_ANDROID, storeAddress))).isDisplayed(), "");
        } else {
            Assert.assertTrue(driver.findElement(By.xpath(String.format(STORE_DYNAMIC_ZIPCODE_IOS, storeAddress))).isDisplayed(), "");
        }
    }

    public void verifyLandingPageDisplayed() {
        Assert.assertTrue(isElementDisplayed(foodLotPageElements.subscribeCTA, 15), "Food Truck landing page not displayed");
    }

    public void verifySubscribeCTALink() {
        Assert.assertTrue(isElementDisplayed(foodLotPageElements.subscribeCTA, 15), "Subscribe CTA link not displayed on food truck landing page");
    }

    public void clickSubscribeCTALink() {
        new CommonActions(driver).new ClickAction().clickElement(foodLotPageElements.subscribeCTA);
    }

    public void verifyUserIsSubscribed() throws InterruptedException {
        Thread.sleep(8000);
        Assert.assertFalse(isElementDisplayed(foodLotPageElements.subscribeCTA, 10), "User is not subscribed to receive vendor menus");
    }

    public void verifyAddToCartLink() {
        scrollDownForElement(foodLotPageElements.addToCartCTA);
        Assert.assertTrue(isElementDisplayed(foodLotPageElements.addToCartCTA), "Add to cart cta link is not displayed");
    }

    public void verifyProductDescription() {
        //scrollDownForElement(foodLotPageElements.foodProductDescription);
        Assert.assertTrue(foodLotPageElements.foodProductDescription.getText() != "", "Product description is not displayed on landing page");
    }

    public void clickAddToCartCTA() {
        new CommonActions(driver).new ClickAction().clickElement(foodLotPageElements.addToCartCTA);
    }

    public void verifyPreDrawerScreen() {
        Assert.assertTrue(isElementDisplayed(foodLotPageElements.preDrawerScreen));
    }

    public void verifyQuantityStepper() {
        Assert.assertTrue(scrollDownForElement(foodLotPageElements.quantityStepperAddIcon), "Quantity stepper is not displayed on preDrawer screen");
    }

    public void verifySpecialInstructionsNote() {
        Assert.assertTrue(scrollDownForElement(foodLotPageElements.specialInstructionsNote), "Special instructions note is not displayed on preDrawer screen");
    }

    public void verifyPreOrderAddToCartCTA() {
        Assert.assertTrue(scrollDownForElement(foodLotPageElements.preOrderAddToCartCTA), "preOrder add to cart CTA is not displayed on preDrawer screen");
    }

    public void clickPreOrderAddToCartCTA() {
        new CommonActions(driver).new ClickAction().clickElement(foodLotPageElements.preOrderAddToCartCTA);
    }

    public void verifyOrderNowDrawerScreen() {
        Assert.assertTrue(isElementDisplayed(foodLotPageElements.orderNowDrawerScreen, 10), "order now drawer screen is not displayed on preDrawer screen");
    }

    public void clickOrderNowCTA() {
        new CommonActions(driver).new ClickAction().clickElement(foodLotPageElements.orderNowDrawerScreen);
    }

}

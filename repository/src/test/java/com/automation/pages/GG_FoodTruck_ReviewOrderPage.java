package com.automation.pages;


import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_FoodLotPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class GG_FoodTruck_ReviewOrderPage extends BasePage {
    private final static String STORE_DYNAMIC_ZIPCODE_ANDROID = "//*[contains(@text,'%s')]";
    private final static String STORE_DYNAMIC_ZIPCODE_IOS = "//*[contains(@label,'%s')]";
    AppiumDevice device = AppiumDeviceManager.getDevice();
    private final GG_FoodLotPageElements foodLotPageElements = new GG_FoodLotPageElements();

    public GG_FoodTruck_ReviewOrderPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), foodLotPageElements);
    }

    public void verifyReviewOrderPage() {
        waitForDisplayed(foodLotPageElements.reviewOrderPage, 20);
        Assert.assertTrue(isElementDisplayed(foodLotPageElements.reviewOrderPage), "Review order page is not displayed on preDrawer screen");
    }

    public void verifyQuantityStepper() {
        Assert.assertTrue(isElementDisplayed(foodLotPageElements.quantityStepperAddIcon), "Quantity stepper is not displayed on review order page screen");
    }

    public void verifyTipSection() {
        Assert.assertTrue(scrollDownForElement(foodLotPageElements.tipSecton), "Tipping section is not displayed on review order page screen");
        Assert.assertTrue(isElementDisplayed(foodLotPageElements.tipSectionOptionZero), "Zero option for tipping section is not displayed");
        Assert.assertTrue(isElementDisplayed(foodLotPageElements.tipSectionOptionOthers), "Others option for tipping section is not displayed");
    }

    public void verifyAddSection() {
        Assert.assertTrue(isElementDisplayed(foodLotPageElements.reviewOrderPageAddSection), "Tipping section is not displayed on review order page screen");
    }

    public void verifyPickupTimeSection() {
        Assert.assertTrue(scrollDownForElement(foodLotPageElements.reviewOrderPagePickupTimeSection), "Tipping section is not displayed on review order page screen");
    }

    public void verifySubtotalField() {
        Assert.assertTrue(scrollDownForElement(foodLotPageElements.reviewOrderPageSubtotalField), "Subtotal section is not displayed on review order page screen");
    }

    public void verifyAllFees() {
        Assert.assertTrue(scrollDownForElement(foodLotPageElements.reviewOrderPageTipField), "Tipping section for fees is not displayed on review order page screen");
        Assert.assertTrue(isElementDisplayed(foodLotPageElements.reviewOrderPageTaxField), "Tax fee field is not displayed on review order page screen");
        Assert.assertTrue(isElementDisplayed(foodLotPageElements.reviewOrderPageConvenienceFeesField), "Convenience fees is not displayed on review order page screen");
    }

    public void verifyOrderTotal() {
        Assert.assertTrue(scrollDownForElement(foodLotPageElements.reviewOrderPageTotalAmountField), "Total amount is not displayed on review order page screen");
    }

    public void verifyAddCouponLink() {
        Assert.assertTrue(scrollDownForElement(foodLotPageElements.reviewOrderPageAddACouponLink), "Add a coupon link is not displayed on review order page screen");
    }

    public void verifyAnotherItemCTA() {
        Assert.assertTrue(scrollDownForElement(foodLotPageElements.reviewOrderPageAnotherItemCTA), "Another item CTA is not displayed on review order page screen");
    }

    public void verifyCheckoutCTA() {
        Assert.assertTrue(isElementDisplayed(foodLotPageElements.checkoutCTA), "Checkout CTA is not displayed on review order page screen");
    }

    public void verifyCheckoutCTAIsEnabledIfTipAndPickupTimeSelected() {
        scrollUpForElement(foodLotPageElements.tipSectionOptionZero);
        new CommonActions(driver).new ClickAction().clickElement(foodLotPageElements.tipSectionOptionZero);
        scrollDownForElement(foodLotPageElements.reviewOrderPagePickupTimeDropDown);
        new CommonActions(driver).new ClickAction().clickElement(foodLotPageElements.reviewOrderPagePickupTimeDropDown);
        scrollDownForElement(foodLotPageElements.pickupTimeOptionAsSoonAsReady);
        new CommonActions(driver).new ClickAction().clickElement(foodLotPageElements.pickupTimeOptionAsSoonAsReady);
        scrollDownForElement(foodLotPageElements.checkoutCTA);
        new CommonActions(driver).new ClickAction().clickElement(foodLotPageElements.checkoutCTA);
        Assert.assertFalse(isElementDisplayed(foodLotPageElements.chooseTipMsg), "Choose tip message is displayed");
        Assert.assertFalse(isElementDisplayed(foodLotPageElements.choosePickUpTimeMsg), "Choose pickup time message is displayed");
    }
}

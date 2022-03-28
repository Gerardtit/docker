package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.OrderCheckoutDisclaimerInfoElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderCheckoutDisclaimerInfoPage extends BasePage {
    OrderCheckoutDisclaimerInfoElements orderCheckoutDisclaimerInfoElements = new OrderCheckoutDisclaimerInfoElements();

    public OrderCheckoutDisclaimerInfoPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), orderCheckoutDisclaimerInfoElements);
    }

    public void backToOrderPageFromAddress() {
        new CommonActions(driver).new ClickAction().clickElement(orderCheckoutDisclaimerInfoElements.backFromAddress);
        new CommonActions(driver).new ClickAction().clickElement(orderCheckoutDisclaimerInfoElements.closeSlotButton);
        new CommonActions(driver).new ClickAction().clickElement(orderCheckoutDisclaimerInfoElements.saveChangesNo);
    }

    public void clickOnContactInfoButton() {
        new CommonActions(driver).new ClickAction().clickElement(orderCheckoutDisclaimerInfoElements.enterName);
    }

    public void enterContactInfo(String firstName, String lastName, String mobileNumber) {
        orderCheckoutDisclaimerInfoElements.enterFirstNameOnContactInfo.sendKeys(firstName);
        orderCheckoutDisclaimerInfoElements.enterLastNameOnContactInfo.sendKeys(lastName);
        orderCheckoutDisclaimerInfoElements.enterMobileNumberOnContactInfo.sendKeys(mobileNumber);
    }

    public void clickTextMeOrderInfoUpdateOnButton() throws InterruptedException {
        new CommonActions(driver).new ClickAction().clickElement(orderCheckoutDisclaimerInfoElements.textMeOrderInfoUpdateOffContactInfo);
        new CommonActions(driver).new ClickAction().clickElement(orderCheckoutDisclaimerInfoElements.saveContactInfo);
    }

    public void clickTextMeOrderInfoUpdateOffButton() throws InterruptedException {
        new CommonActions(driver).new ClickAction().clickElement(orderCheckoutDisclaimerInfoElements.saveContactInfo);
    }

    public void verifyLandedYourOrderPage() throws InterruptedException {
        Assert.assertTrue(orderCheckoutDisclaimerInfoElements.landedYourOrderPage.isDisplayed());
    }

    public void verifyTextMeMyOrderStatus() throws InterruptedException {
        Assert.assertTrue(orderCheckoutDisclaimerInfoElements.textMeMyOrderStatus.isDisplayed());
    }

    public void verifyTurnOnOrderStatusTextMessages() throws InterruptedException {
        Assert.assertTrue(orderCheckoutDisclaimerInfoElements.turnOnOrderStatusTextMessages.isDisplayed());
    }


}

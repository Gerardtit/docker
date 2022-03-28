package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class OrderCheckoutDisclaimerInfoElements {

    @AndroidFindBy(xpath = "//*[@content-desc=\"Back\"]")
    @iOSXCUITFindBy(xpath = "//*[@content-desc=\"Back\"]")
    public MobileElement backFromAddress;
    @AndroidFindBy(xpath = "//*[@content-desc=\"Close slot selection screen\"]")
    @iOSXCUITFindBy(xpath = "//*[@content-desc=\"Close slot selection screen\"]")
    public MobileElement closeSlotButton;
    @AndroidFindBy(xpath = "//*[@text=\"Yes\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Yes\"]")
    public MobileElement saveChangesYes;
    @AndroidFindBy(xpath = "//*[@text=\"No\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"No\"]")
    public MobileElement saveChangesNo;
    @AndroidFindBy(xpath = "//*[@text=\"Enter name\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Enter name\"]")
    public MobileElement enterName;
    @AndroidFindBy(xpath = "//*[@text=\"Save\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Save\"]")
    public MobileElement addressSaveButton;
    @AndroidFindBy(xpath = "//*[@text='Continue to payment method']")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Continue to payment method\"]")
    public MobileElement continueToPaymentMethod;
    @AndroidFindBy(xpath = "//*[@text=\"Enter first name\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Enter first name\"]")
    public MobileElement enterFirstNameOnContactInfo;
    @AndroidFindBy(xpath = "//*[@text=\"Enter last name\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Enter last name\"]")
    public MobileElement enterLastNameOnContactInfo;
    @AndroidFindBy(xpath = "//*[@text=\"Enter mobile number\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Enter mobile number\"]")
    public MobileElement enterMobileNumberOnContactInfo;
    @AndroidFindBy(xpath = "//*[@text=\"OFF\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"OFF\"]")
    public MobileElement textMeOrderInfoUpdateOffContactInfo;
    @AndroidFindBy(xpath = "//*[@text=\"ON\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"ON\"]")
    public MobileElement textMeOrderInfoUpdateOnContactInfo;
    @AndroidFindBy(xpath = "//*[@text=\"Save\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Save\"]")
    public MobileElement saveContactInfo;
    @AndroidFindBy(xpath = "//*[@text=\"Your order\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Your order\"]")
    public MobileElement landedYourOrderPage;
    @AndroidFindBy(xpath = "//*[@text=\"Text me my order status\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Text me my order status\"]")
    public MobileElement textMeMyOrderStatus;
    @AndroidFindBy(xpath = "//*[@text=\"Turn on order status text messages?\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Turn on order status text messages?\"]")
    public MobileElement turnOnOrderStatusTextMessages;


}

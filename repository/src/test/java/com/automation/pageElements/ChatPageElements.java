package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ChatPageElements {

    //XCUIElementTypeStaticText[@name="I need help signing in"]

    @iOSXCUITFindBy(xpath = "//*[contains(@value, 'I need help signing in')]")
    @AndroidFindBy(xpath = "//*[@text=\"I need help with Sign In\"]")
    public MobileElement needHelpWithSignIn;

    @iOSXCUITFindBy(xpath = "//*[contains(@value, 'Where is my order?')]")
    @AndroidFindBy(xpath = "//*[@text=\"Where is my order?\"]")
    public MobileElement whereIsMyOrder;

    @iOSXCUITFindBy(xpath = "//*[contains(@value, 'Edit my order')]")
    @AndroidFindBy(xpath = "//*[@text=\"Edit my order\"]")
    public MobileElement editMyOrder;


    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Loyalty Program info')]")
    @AndroidFindBy(xpath = "//*[@text=\"Loyalty Program info\"]")
    public MobileElement loyaltyProgramInfo;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,'I have a problem with my order')]")
    @AndroidFindBy(xpath = "//*[@text=\"I have a problem with my order\"]")
    public MobileElement problemWithOrder;

    @iOSXCUITFindBy(xpath = "//*[contains(@value,'Pickup and Delivery options')]")
    @AndroidFindBy(xpath = "//*[@text=\"Pickup and Delivery options\"]")
    public MobileElement pickUpDeliveryOptions;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'In order to help you with your account login, please select your issue:'")
    @AndroidFindBy(xpath = "//*[@text=\"In order to help you with your account login, please select your issue:\"]")
    public MobileElement signInHelpResolutionText;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Reset Password'")
    @AndroidFindBy(xpath = "//*[@text=\"Reset Password\"]")
    public MobileElement resetPassword;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Log in to Account'")
    @AndroidFindBy(xpath = "//*[@text=\"Log in to Account\"]")
    public MobileElement loginToAccount;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'My Account is Locked'")
    @AndroidFindBy(xpath = "//*[@text=\"My Account is Locked\"]")
    public MobileElement accountLocked;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Other'")
    @AndroidFindBy(xpath = "//*[@text=\"Other\"]")
    public MobileElement other;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'You currently have no pending orders.'")
    @AndroidFindBy(xpath = "//*[@text=\"You currently have no pending orders.\"]")
    public MobileElement noPendingOrdersText;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'You currently have no pending orders available to edit.'")
    @AndroidFindBy(xpath = "//*[@text=\"You currently have no pending orders available to edit.\"]")
    public MobileElement noPendingOrderToEdit;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Please indicate which program would you like more information on.'")
    @AndroidFindBy(xpath = "//*[@text=\"Please indicate which program would you like more information on.\"]")
    public MobileElement loyaltyProgramText;

    //@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Just for U'")
    // @iOSXCUITFindBy("//*[contains(@label,'Albertsons for U')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Albertsons for U')]")
    @AndroidFindBy(xpath = "//*[@text=\"Just for U\"]")
    public MobileElement justForULoyaltyProgram;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Gas Rewards'")
    @AndroidFindBy(xpath = "//*[@text=\"Gas Rewards\"]")
    public MobileElement gasRewardsLoyaltyProgram;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Grocery Rewards'")
    @AndroidFindBy(xpath = "//*[@text=\"Grocery Rewards\"]")
    public MobileElement groceryRewardsLoyaltyProgram;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'To ensure we make things right, please provide us with more detail.'")
    @AndroidFindBy(xpath = "//*[@text=\"To ensure we make things right, please provide us with more detail.\"]")
    public MobileElement problemWithOrderText;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Order Status'")
    @AndroidFindBy(xpath = "//*[@text=\"Order Status\"]")
    public MobileElement orderStatus;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Product Issue'")
    @AndroidFindBy(xpath = "//*[@text=\"Product Issue\"]")
    public MobileElement productIssue;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Charges'")
    @AndroidFindBy(xpath = "//*[@text=\"Charges\"]")
    public MobileElement charges;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Promo Code'")
    @AndroidFindBy(xpath = "//*[@text=\"Promo Code\"]")
    public MobileElement promoCode;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Digital offer / Coupon'")
    @AndroidFindBy(xpath = "//*[@text=\"Digital offer / Coupon\"]")
    public MobileElement digitalOfferCoupon;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Delivery Address / Pickup store'")
    @AndroidFindBy(xpath = "//*[@text=\"Delivery Address / Pickup store\"]")
    public MobileElement deliveryPickupAddress;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Edit / Cancel Order'")
    @AndroidFindBy(xpath = "//*[@text=\"Edit / Cancel Order\"]")
    public MobileElement editCancelOrder;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Order not delivered / picked up'")
    @AndroidFindBy(xpath = "//*[@text=\"Order not delivered / picked up\"]")
    public MobileElement orderNotDelivered;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Enjoy the convenience of online grocery shopping with these options.'")
    @AndroidFindBy(xpath = "//*[@text=\"Enjoy the convenience of online grocery shopping with these options.\"]")
    public MobileElement pickupDeliveryOptionsText;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Delivery'")
    @AndroidFindBy(xpath = "//*[@text=\"Delivery\"]")
    public MobileElement delivery;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Same or next day delivery right to your door.'")
    @AndroidFindBy(xpath = "//*[@text=\"Same or next day delivery right to your door.\"]")
    public MobileElement sameOrNextDayDelivery;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'DriveUp & Go'")
    @AndroidFindBy(xpath = "//*[@text=\"DriveUp & Go\"]")
    public MobileElement dUG;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Order your groceries ahead of time and have them brought to your car.'")
    @AndroidFindBy(xpath = "//*[@text=\"Order your groceries ahead of time and have them brought to your car.\"]")
    public MobileElement dUGText;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Rush Delivery'")
    @AndroidFindBy(xpath = "//*[@text=\"Rush Delivery\"]")
    public MobileElement rushDelivery;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Delivery within as little as 2 hours, powered by Instacart.'")
    @AndroidFindBy(xpath = "//*[@text=\"Delivery within as little as 2 hours, powered by Instacart.\"]")
    public MobileElement rushDeliveryText;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Unlimited Delivery Club'")
    @AndroidFindBy(xpath = "//*[@text=\"Unlimited Delivery Club\"]")
    public MobileElement uDC;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == '– Sign up for one of our Unlimited Delivery Club Service plans and we’ll waive the delivery fee on any order over $30 as long as you're enrolled. You can choose a monthly plan for $14.99 or an annual plan for $99. (The annual plan averages out to just $8.25/month.)'")
    @AndroidFindBy(xpath = "//*[@text=\" – Sign up for one of our Unlimited Delivery Club Service plans and we’ll waive the delivery fee on any order over $30 as long as you're enrolled. You can choose a monthly plan for $14.99 or an annual plan for $99. (The annual plan averages out to just $8.25/month.)\"]")
    public MobileElement uDCText;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'For additional details on any of these services, please review our'")
    @AndroidFindBy(xpath = "//*[@text=\"For additional details on any of these services, please review our \"]")
    public MobileElement additionalDetails;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Online Shopping FAQs'")
    @AndroidFindBy(xpath = "//*[@text=\"Online Shopping FAQs\"]")
    public MobileElement onlineShoppingFAQs;

}

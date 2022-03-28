package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.CacheLookup;

public class AddAddress_OrderPageElements {
    // click Maybe later -- App Update
    @iOSXCUITFindBy(xpath = "//*[@label='Maybe Later']")
    public MobileElement ClickLater;

    //Lets get started
    @AndroidFindBy(xpath = "//*[@text=\"Let's Get Started\"]")
    public MobileElement ClickStartButton;

    //text = This mobile application uses device caching to improve the user experience.
    @iOSXCUITFindBy(xpath = "//*[@label=\"Allow\"]")
    @AndroidFindBy(xpath = "//*[@text=\"CONTINUE\"]")
    public MobileElement ClickCacheText;

    // To click Next Button
    @AndroidFindBy(xpath = "//*[@text='Next']")
    public MobileElement ClickNextButton;

    // click pickup next button
    @iOSXCUITFindBy(xpath = "//*[@name=\"btnNext-Pick up tool tip\"]")
    public MobileElement pickUpNextButton;

    // to click deals next button
    @iOSXCUITFindBy(xpath = "//*[@name=\"btnNext-Deals tool tip\"]")
    public MobileElement dealsNextButton;

    // To Click Wallet next button
    @iOSXCUITFindBy(xpath = "//*[@name=\"btnNext-Wallet tool tip\"]")
    public MobileElement walletButton;

    //TO click dismiss
    @iOSXCUITFindBy(xpath = "//*[@label=\"Dismiss\"]")
    public MobileElement dismiss;

    //Select delivery
//    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Delivery' AND visible == 1")
    @AndroidFindBy(id = "delivery_zipcode")
    public MobileElement deliverToZipButton;

    // TO Enter Zipcode
    @AndroidFindBy(id = "edit_text")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND name BEGINSWITH 'Enter Zipcode' AND visible == 1")
    public MobileElement enterZipcode;

    // Confirm Zipcode
    @iOSXCUITFindBy(xpath = "//*[@label=\"Confirm ZipCode Button\"]")
    public MobileElement ConfirmZipcode;

    //"ShoppingMode" button
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"address\")]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"tv_shopping_mode\")]")
    public MobileElement clickShoppingMode;


    //click Start shopping
    @iOSXCUITFindBy(xpath = "//*[@value=\"Start shopping\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Start shopping\"]")
    public MobileElement startShopping;


    //click shopping cart button
    @iOSXCUITFindBy(xpath = "//*[@label=\"Cart\"]")
    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Cart\")]")
    public MobileElement clickShoppingCart;

    // cart title
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Cart\")]")
    @AndroidFindBy(xpath = "//*[@text=\"My Cart\"]")
    public MobileElement myCartTitle;

    //click Checkout Button
    //@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Checkout' AND visible == 1")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Checkout\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Checkout\"]/parent::XCUIElementTypeButton")
    @AndroidFindBy(xpath = "//*[@text=\"Checkout\"]")
    public MobileElement checkoutButton;

    //verify Checkout Page
    @iOSXCUITFindBy(xpath = "//*[@label=\"Checkout\"]")
    @AndroidFindBy(xpath = "//*[@text='Checkout']")
    public MobileElement verifyCheckoutPage;

    // click order info
    @AndroidFindBy(id = "order_info_nav")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name CONTAINS 'Order Info' AND visible == 1")
    @CacheLookup
    public MobileElement clickOrderInfo;

    //click Edit Address
    @AndroidFindBy(accessibility = "Edit Address")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name CONTAINS 'Edit' AND visible == 1")
    @CacheLookup
    public MobileElement clickOnEdit;

    // addDeliveryAddressButton
    @AndroidFindBy(id = "addDeliveryAddressButton")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name CONTAINS 'Add new address' AND visible == 1")
    @CacheLookup
    public MobileElement clickAddDeliveryAddressButton;

    // Click AddressPage zipcode
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.safeway.client.android.tomthumb.debug:id/zipCodeEditText\"]/")
    public MobileElement clickAddressPageZipcode;

    // Click Search
    @AndroidFindBy(accessibility = "Search")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name CONTAINS 'Confirm ZipCode Button' AND visible == 1")
    public MobileElement searchZipcode;

    // To Check Zipcode validation
    @AndroidFindBy(xpath = "//*[@label=\"Validation succeeded.\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name CONTAINS 'Validation succeeded' AND visible == 1")
    public MobileElement verifyZipcodeValidation;

    //     To Enter AddressLine
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.safeway.client.android.tomthumb.debug:id/edit_text_layout\"]/*[@resource-id=\"com.safeway.client.android.tomthumb.debug:id/edit_text\" and @instance=\"1\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Address Line 1 *\"]/parent::XCUIElementTypeTextField")
    public MobileElement enterAddressLine;

    // TO Enter FloorNumber
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"addressLine2TextView\")]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND name CONTAINS 'Enter Apartment Number, Suite, or Floor number' AND visible == 1")
    public MobileElement enterFloorNumber;

    // TO Enter City
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.safeway.client.android.tomthumb.debug:id/cityLayout\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND name CONTAINS 'City' AND visible == 1")
    public MobileElement EnterCity;

    // To Enter State
    @AndroidFindBy(xpath = "//*[@text=\"TX\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND name CONTAINS 'State' AND visible == 1")
    public MobileElement EnterState;

    // Select Residential tab
    @AndroidFindBy(xpath = "//*[@text=\"Residential\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name CONTAINS 'Select Residentials Address' AND visible == 1")
    public MobileElement clickOnResidentialTab;

    // Select Buisness tab
    @AndroidFindBy(xpath = "//*[@text=\"Business\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name CONTAINS 'Select Business Address' AND visible == 1")
    public MobileElement clickOnBuisnessTab;

    // Enter Delivery Instructions
    @AndroidFindBy(xpath = "//*[@text=\"Enter Comments (limit 250 characters)\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextView' AND name CONTAINS 'Enter Comments ' AND visible == 1")
    public MobileElement EnterDeliveryInstructions;

    // Click Save
    @AndroidFindBy(xpath = "//*[@text=\"SAVE\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Save\"]")
    public MobileElement clickSave;

    //click continue button for zipcode change
    @AndroidFindBy(xpath = "//*[@text=\"CONTINUE\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Continue\"]")
    public MobileElement clickContinue;

    @iOSXCUITFindBy(xpath = "//*[@value=\"Start shopping\"]")
    @AndroidFindBy(id = "start_shopping")
    public MobileElement startShoppingButton;

    @iOSXCUITFindBy(xpath = "//*[@label=\"User profile\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"iv_user_avatar\")]")
    public MobileElement menuButton;

    // click view cart in cart update
    @AndroidFindBy(xpath = "//*[@text=\"VIEW CART\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"View Cart\"]")
    public MobileElement viewCartUpdate;

}


//    //"CONTINUE" button
//    @iOSXCUITFindBy(accessibility = "Continue")
//    @AndroidFindBy(id = "android:id/button1")
//    public MobileElement continueButton;

//    //Handle Exception
//    @AndroidFindBy(xpath = "//*[@resource-id='android:id/button1']")
//    public MobileElement HandleUserCache;

//     // Estimated Total amount
//    @iOSXCUITFindBy(accessibility = "Learn More")
//    @AndroidFindBy(id = "txt_total_amount")
//    @CacheLookup
//    public MobileElement checkTotalAmount;
//
//    // click Checkout button
//    @AndroidFindBy(id = "btn_checkout_pay")
//    @CacheLookup
//    public MobileElement CheckoutButton;
//
//    // verify checkout page loaded
//    @AndroidFindBy(xpath = "//*[@text=\"Checkout\"]")
//    @CacheLookup
//    public MobileElement CheckoutPage;
//
//    // click order info
//    // @iOSXCUITFindBy(accessibility = "Order Info")
//    // @AndroidFindBy(id = "orderInfo_container")

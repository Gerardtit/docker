package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class OrderConfirmationPageElements {

    //orderConfirmationtitle
    @iOSXCUITFindBy(xpath = "//*[@label=\"Order Confirmation\"]")
    @AndroidFindBy(id = "tvTitle")
    public MobileElement orderConfirmationtitle;


    //ThankYoutext
    @iOSXCUITFindBy(xpath = "//*[@label=\"Thank You! We've emailed you a copy of this order confirmation.\"]")
    @AndroidFindBy(id = "thank_you_txt")
    public MobileElement ThankYoutext;

    //Ordernumber
    @iOSXCUITFindBy(xpath = "//*[@label=\"Order Number\"]")
    @AndroidFindBy(id = "order_number_txt")
    public MobileElement Ordernumber;

    //confirm CVV at checkout
    @iOSXCUITFindBy(xpath = "//*[@label=\"Confirm CVV\" and @name =\"Confirm CVV\" ]")
    @AndroidFindBy(id = "payment_error_msg")
    public MobileElement confirmCVV;

    //OrderinfotextAtOrderConf
    @iOSXCUITFindBy(xpath = "//*[@label=\"Order Info\"]")
    @AndroidFindBy(id = "orderInfo_txt")
    public MobileElement OrderinfotextAtOrderConf;

    //OrderlinktextAtOrderConf
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[4]/XCUIElementTypeButton[1]")
    @AndroidFindBy(id = "update_your_order_content")
//    To update your order, visit your Orders page, select the order you’d like to update, and confirm changes. You can edit your order until 4:00 PM on the same day your order is placed.
    public MobileElement OrderLinktextAtOrderConf;

    //place order button
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Place Order\"]")
    @AndroidFindBy(id = "btn_save")
//    @CacheLookup
    public MobileElement placeOrderButton;

}

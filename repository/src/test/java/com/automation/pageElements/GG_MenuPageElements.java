package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_MenuPageElements {

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Sign Out button\"]")
    @iOSXCUITFindBy(accessibility = "Sign Out")
    public MobileElement signOutButton;

    @AndroidFindBy(accessibility = "close")
    public MobileElement closeIcon;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Cancel order\"]")
    @AndroidFindBy(id = "tv_cancel_order")
    public MobileElement Cancelorder;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Please confirm that you would like to cancel this order.\"]")
    @AndroidFindBy(id = "dialogMessage")
    public MobileElement ConfirmationCancelorder;


//XCUIElementTypeButton[@name="Yes, cancel"]

    @AndroidFindBy(id = "primaryButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Yes, cancel\"]")
    public MobileElement ConfirmationYesButtonCancelorder;

    @AndroidFindBy(id = "secondaryButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"No, don’t cancel\"]")
    public MobileElement NobutttonCancel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Your order details\"]")
    @AndroidFindBy(id = "tv_order_title")
    public MobileElement OrderDetailsScreen;


    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Your Orders\"])[1]")
    @AndroidFindBy(id = "tv_order_title")
    public MobileElement YourOrderScreen;

    /*@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Canceled\"]")
    public MobileElement CancelledOrderStatus;*/


    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Back\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Your Orders\"]")
    public MobileElement BackButtonOrderHistory;

    @iOSXCUITFindBy(accessibility = "Order Status cancelled")
    @AndroidFindBy(id = "progressBar")
    public MobileElement OrderStatuscancel;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Canceled.\"]")
    @AndroidFindBy(id = "textViewTitle")
    public MobileElement OrderCancelledOrderDetailsScreen;
}

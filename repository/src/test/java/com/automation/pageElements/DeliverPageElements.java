package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;


public class DeliverPageElements {

    //title
    @iOSXCUITFindBy(accessibility = "Select your delivery window")
    @AndroidFindBy(id = "deliveryWindowTv")
    public MobileElement orderDeliveryWindowTitle;

    //unattend
    @iOSXCUITFindBy(accessibility = "Leave bags at my doorstep")
    @AndroidFindBy(id = "deliveryTypeUnattendedBtn")
    public MobileElement unattendedButton;

    //attend
    @iOSXCUITFindBy(accessibility = "I'll be there to receive my order")
    @AndroidFindBy(id = "deliveryTypeAttendedBtn")
    public MobileElement attendedButton;

    //1-hour window
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name BEGINSWITH '1‑' AND visible == 1")
    @AndroidFindBy(id = "deliveryWindowOneBtn")
    public MobileElement oneHourDeliveryButton;

    //2-hour window
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name BEGINSWITH '2‑' AND visible == 1")
    @AndroidFindBy(id = "deliveryWindowTwoBtn")
    public MobileElement twoHourDeliveryButton;

    //4-hour window
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name BEGINSWITH '4‑' AND visible == 1")
    @AndroidFindBy(id = "deliveryWindowFourBtn")
    public MobileElement fourHourDeliveryButton;

    //date picker
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypePickerWheel[1]")
    @AndroidFindBy(id = "datePicker")
    public MobileElement datePicker;


    //current reserved time
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypePickerWheel' AND value CONTAINS 'Current reserved time'")
    @AndroidFindBy(xpath = "//*[@text=\"Current reserved time\"]")
    public MobileElement currentReserveTimeText;

    //time picker
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypePickerWheel[2]")
    @AndroidFindBy(id = "timePicker")
    public MobileElement timePicker;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Save and Review\"] | //XCUIElementTypeButton[@label=\"Save\"]")
//    @AndroidFindBy(accessibility = "Save")
//    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Save'")
    @AndroidFindBy(id = "btn_save")
    public MobileElement saveButton;
    //iOSNsPredicate = "type == 'XCUIElementTypeCell' AND Label CONTAINS '2 of 7' AND visible == 1
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[2]")
    @AndroidFindBy(xpath = "//*[@class='android.view.ViewGroup']//*[@class='android.widget.FrameLayout'][2]")
    public MobileElement dayNextToToday;

    @iOSXCUITFindBy(accessibility = "Back")
    @AndroidFindBy(accessibility = "Navigate up")
    public MobileElement backButton;
}

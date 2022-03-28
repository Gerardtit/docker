package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_OrderInfoPageElements {

    @AndroidFindBy(id = "orderTypeAddressTv")
    @iOSXCUITFindBy(xpath = "(//*[contains(@name,'Delivery to:')]//following-sibling:: XCUIElementTypeOther)[1]")
    public MobileElement deliveryAddress;

    @AndroidFindBy(id = "orderTypeAddressTv")
    @iOSXCUITFindBy(xpath = "(//*[contains(@name,'Store Address:')]//following-sibling:: XCUIElementTypeOther)[1]")
    public MobileElement storeAddress;

    @AndroidFindBy(id = "dateTimeTv")
    @iOSXCUITFindBy(id = "Choose a date & time")
    public MobileElement chooseDateTimeLabel;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name BEGINSWITH '1‑' AND visible == 1")
    @AndroidFindBy(id = "deliveryWindowOneBtn")
    public MobileElement oneHourDeliveryButton;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name BEGINSWITH '2‑' AND visible == 1")
    @AndroidFindBy(id = "deliveryWindowTwoBtn")
    public MobileElement twoHourDeliveryButton;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name BEGINSWITH '4‑' AND visible == 1")
    @AndroidFindBy(id = "deliveryWindowFourBtn")
    public MobileElement fourHourDeliveryButton;

    @AndroidFindBy(id = "deliveryWindowTv")
    @iOSXCUITFindBy(id = "Delivery Info")
    public MobileElement deliveryWindowInfo;

    @AndroidFindBy(id = "btn_save")
    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Save\" AND type == \"XCUIElementTypeButton\"")
    public MobileElement saveButton;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypePickerWheel' and value BEGINSWITH 'All pickup times are reserved' and visible==1")
    public MobileElement noSlotsAvailableWheel;

    @AndroidFindBy(id = "timeTv")
    public MobileElement timeOnTimePicker;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@content-desc,'Edit Already Selected Address')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Edit\"`][3]")
    public MobileElement editDeliveryAddressButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"* Indicates required field\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"* Indicates required field\"")
    public MobileElement requiredFieldsWarning;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Please enter valid delivery instructions.\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Please enter valid delivery instructions.\" AND visible==1")
    public MobileElement enterValidInstructionsWarning;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[contains(@resource-id,'instructionsEditText')]//android.widget.LinearLayout[contains(@resource-id,'edit_text_layout')]//android.widget.EditText[contains(@resource-id,'edit_text')]")
    @iOSXCUITFindBy(xpath = "//*[@name='Delivery Instructions (optional)']//following-sibling:: XCUIElementTypeTextView")
    public MobileElement deliveryInstructionsEditBox;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    @iOSXCUITFindBy(id = "Enter Address Line One. Field is required")
    public MobileElement addressLine1TextField;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[contains(@resource-id,'addressLine2TextView')]//android.widget.LinearLayout[contains(@resource-id,'edit_text_layout')]//android.widget.EditText[contains(@resource-id,'edit_text')]")
    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'Enter Apartment Number'")
    public MobileElement addressLine2TextField;

    @AndroidFindBy(accessibility = "City Field is required")
    @iOSXCUITFindBy(accessibility = "City *")
    public MobileElement addressLineCityTextHeader;

    @AndroidFindBy(xpath = "//*[@text='Order Info' and contains(@resource-id,'tvTitle')]")
    @iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeNavigationBar' and name='Order Info' and visible==1")
    public MobileElement orderInfoPageHeader;

    @AndroidFindBy(accessibility = "Close")
    @iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton' AND name=='Checkout'")
    public MobileElement backButtonToCheckOut;

    @AndroidFindBy(id = "alertTitle")
    @iOSXCUITFindBy(iOSNsPredicate = "PENDING")
    public MobileElement serverErrorMessage;

    @AndroidFindBy(xpath = "//*[@text='DISMISS' and contains(@resource-id,'button2')]")
    @iOSXCUITFindBy(iOSNsPredicate = "PENDING")
    public MobileElement serverErrorDismissButton;

    @AndroidFindBy(accessibility = "Close")
    @iOSXCUITFindBy(accessibility = "Checkout")
    public MobileElement cancelButtonOnOrderInfoPage;

    @AndroidFindBy(id = "alertTitle")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Would you like to select'")
    public MobileElement selectDeliveryPopUp;

    @AndroidFindBy(id = "android:id/button2")
    @iOSXCUITFindBy(accessibility = "No")
    public MobileElement denyButton;

    @AndroidFindBy(xpath = "//*[@text=\"Street address\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Street address. Field is required\"]")
    public MobileElement streetaddress;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[4]/android.widget.RelativeLayout[1]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"State field is required\"]")
    public MobileElement state_delivery;

    @AndroidFindBy(xpath = "//*[@text=\"Apt., suite, etc. (optional)\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Enter Apartment, Suite, etc (optional)\"]")
    public MobileElement aptno;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[3]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Enter Zipcode. Field is required \"]")
    public MobileElement zipcode_delivery;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[5]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"City field is required\"]")
    public MobileElement city_delivery;
    //    @AndroidFindBy(xpath = "//*[@text=\"//android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.ImageView[2]\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Next:\"]")
    public MobileElement nextOnKeyboard;

    //    @AndroidFindBy(xpath = "//*[@text=\"//android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.ImageView[2]\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
    public MobileElement doneOnkeyboard;
}
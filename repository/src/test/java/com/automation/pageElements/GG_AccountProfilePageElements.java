package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_AccountProfilePageElements {

    @AndroidFindBy(id = "tvTitle")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Account\"")
    public MobileElement accountHeaderTitle;

    @AndroidFindBy(accessibility = "Sign Out Button")
    @iOSXCUITFindBy(accessibility = "Sign Out")
    public MobileElement signOutButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    @iOSXCUITFindBy(accessibility = "OK")
    public MobileElement confirmSignOutOkButton;

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeButton")
    public MobileElement backButton;

    @AndroidFindBy(id = "iv_user_avatar")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"User profile\"")
    public MobileElement accountIconOnHome;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Account button\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Account\"")
    public MobileElement accountButton;

    @AndroidFindBy(xpath = "//*[@text=\"Email Address\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Email Address\"")
    public MobileElement emailSection;


    @AndroidFindBy(id = "welcome_title")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Welcome\"")
    public MobileElement welcomeTitle;

    @AndroidFindBy(id = "email_content")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[4]/XCUIElementTypeStaticText[3]")
    public MobileElement emailValue;

    @AndroidFindBy(xpath = "//*[@text=\"Password\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Password\"")
    public MobileElement password;


    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")
    public MobileElement emailField;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[2]")
    public MobileElement confirmEmailField;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"btn_save\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Save\"]")
    public MobileElement saveButton;

    @iOSXCUITFindBy(xpath = "//*[@label=\"done\" or @label=\"Done\"]")
    public MobileElement doneButton;

    @AndroidFindBy(xpath = "//*[@text=\"Contact Phone Number\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Contact Phone Number\"]")
    public MobileElement contactNumber;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"id/edit_text\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    public MobileElement contactNumberField;

    @AndroidFindBy(xpath = "//*[@text=\"Phone Number Used in Store\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Phone Number Used in Store\"]")
    public MobileElement phoneNumber;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"store_phone_content\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[6]/XCUIElementTypeStaticText[3]")
    public MobileElement phoneNumberValue;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"delivery_contact_content\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[5]/XCUIElementTypeStaticText[3]")
    public MobileElement contactNumberValue;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"id/edit_text\") and @text=\"Phone Number\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")
    public MobileElement phoneNumberField;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"id/edit_text\") and @text=\"Confirm Phone Number\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[2]")
    public MobileElement confirmPhoneNumber;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"id/edit_text\") and @text=\"Confirm Phone Number\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[2]")
    public MobileElement keypadDoneButton;
}



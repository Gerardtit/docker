package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AddOffBannerAddress_AccountPageElements {

    // To Select Shopping mode
    @AndroidFindBy(accessibility = "Shopping mode info")
    public MobileElement clickShoppingMode;

    // Enter Zipcode
    @AndroidFindBy(id = "edit_text")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND name BEGINSWITH 'Enter Zipcode' AND visible == 1")
    public MobileElement enterZipcode;
    // Confirm Zipcode
    @iOSXCUITFindBy(xpath = "//*[@label=\"Confirm ZipCode Button\"]")
    public MobileElement ConfirmZipcode;

    // Confirm ZipCode
    @AndroidFindBy(accessibility = "Confirm Zip Code")
    public MobileElement ConfirmZipCode;
    //Select fullfilment

    //click continue button for zipcode change
    @AndroidFindBy(xpath = "//*[@text=\"CONTINUE\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Continue\"]")
    public MobileElement clickContinue;

    // To Check Zipcode validation
    @AndroidFindBy(xpath = "//*[@label=\"Validation succeeded.\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name CONTAINS 'Validation succeeded' AND visible == 1")
    public MobileElement verifyZipcodeValidation;

    //     To Enter AddressLine
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.safeway.client.android.tomthumb.debug:id/edit_text_layout\"]/*[@resource-id=\"com.safeway.client.android.tomthumb.debug:id/edit_text\" and @instance=\"1\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Address Line 1 *\"]/parent::XCUIElementTypeTextField")
    public MobileElement enterAddressLine;

    // Start Shopping
    @AndroidFindBy(id = "start_shopping")
    public MobileElement clickStartshopping;


    //Click menu
    @iOSXCUITFindBy(xpath = "//*[@label=\"User profile\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"iv_user_avatar\")]")
    public MobileElement clickMenuButton;

    //Click Account from Menu
    @iOSXCUITFindBy(xpath = "//*[@label=\"Account\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Account Button\"]")
    public MobileElement ClickAccount;

    //public WebElement myAccountPageTitle;
    @iOSXCUITFindBy(xpath = "//*[@label=\"Account\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Account\"]")
    public MobileElement myAccountPageTitle;

    //Click Edit Delivery Address
    @iOSXCUITFindBy(xpath = "//*[@label=\"Address\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Delivery Address\"]")
    public MobileElement ClickEditAddress;

    // Select OffBanner store
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='albertsons']")
    public MobileElement OffBannerStore;

    //Click on Save
    @AndroidFindBy(accessibility = "Save")
    public MobileElement ClickSave;

    //Click continue for location change
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"android:id/button1\")]")
    public MobileElement ClickContinue;

    // Tap on OffBanner App
    @AndroidFindBy(id = "buttonShop")
    public MobileElement OpenOffBannerApp;


}

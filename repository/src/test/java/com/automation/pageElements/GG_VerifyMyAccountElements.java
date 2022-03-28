package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_VerifyMyAccountElements {

    //My account on HomePage
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeCollectionView[1]/XCUIElementTypeOther[1]")
    @AndroidFindBy(xpath = "//*[@text=\"My account\"]")
    public MobileElement myAccountAtHomePage;


    //My account Page
    @iOSXCUITFindBy(xpath = "//*[@label=\"Account\"]")
    @AndroidFindBy(id = "tvTitle")
    public MobileElement AccountPage;


    //Savings summary
    @AndroidFindBy(id = "savings_summary")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Savings Summary\"]")
    public MobileElement SavingSummary;

    //Address
    @AndroidFindBy(xpath = "//*[@text=\"Delivery Address\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Address\"]")
    public MobileElement AddressOFMyAccount;

    //PickUp Store Address
    @iOSXCUITFindBy(xpath = "//*[@label=\"Pickup Store Address\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Pickup Store Address\"]")
    public MobileElement pickupAddress;

    //UnlimitedDeliveryAddress
    @iOSXCUITFindBy(xpath = "//*[@label=\"Unlimited Delivery Club\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Delivery Address\"]")
    public MobileElement UnlimitedDeliveryClub;

    //Phonenumber
    @iOSXCUITFindBy(xpath = "//*[@label=\"Contact Phone Number\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Contact Phone Number\"]")
    public MobileElement contactPhoneNumber;

    //Phone number in store
    @iOSXCUITFindBy(xpath = "//*[@label=\"Phone Number Used in Store\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Phone Number Used in Store\"]")
    public MobileElement PhoneNumberInStore;

    //EmailAddress
    @iOSXCUITFindBy(xpath = "//*[@label=\"Email Address\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Email Address\"]")
    public MobileElement EmailAddress;

    //communication preference
    @iOSXCUITFindBy(xpath = "//*[@label=\"Communication Preferences\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Communication Preferences\"]")
    public MobileElement communicationPreference;

    //NeedHelp
    @iOSXCUITFindBy(className = "XCUIElementTypeButton")
    @AndroidFindBy(id = "needHelpBtn")
    public MobileElement NeedHelp;

    //Update Security n Password
    @iOSXCUITFindBy(xpath = "//*[@label=\"Update Password / Security\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Update Password/Security\"]")
    public MobileElement SecurityNPassword;


}

package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ChooseAccountPageElements {

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name CONTAINS 'Choose an account' ")
    @AndroidFindBy(id = "txtChooseAcct")
    public MobileElement chooseAccountTitle;

    @iOSXCUITFindBy(accessibility = "Continue as Guest")
    @AndroidFindBy(id = "contAsGuest")
    public MobileElement continueAsGuestButton;

    @iOSXCUITFindBy(accessibility = "Continue")
    @AndroidFindBy(id = "selectbtn")
    public MobileElement continueButton;
}

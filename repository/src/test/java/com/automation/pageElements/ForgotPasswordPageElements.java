package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ForgotPasswordPageElements {

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Forgot Password' AND visible == 1")
    @AndroidFindBy(id = "tvTitle")
    public MobileElement forgotPasswordTitle;

    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    @AndroidFindBy(id = "editTextEmail")
    public MobileElement emailAddressEditText;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Next' AND visible == 1")
    @AndroidFindBy(id = "buttonNext")
    public MobileElement nextButton;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Cancel' AND visible == 1")
    @AndroidFindBy(accessibility = "Navigate up")
    public MobileElement cancelButton;

    @iOSXCUITFindBy(accessibility = "Password Reset Email Sent")
    @AndroidFindBy(id = "title")
    public MobileElement resetPasswordEmailSentText;
}

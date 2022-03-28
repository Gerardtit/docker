package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * This class contains elements that belong to Sign In page.
 */
public class GG_SignInPageElements {

    @AndroidFindBy(id = "editTextEmail")
    @iOSXCUITFindBy(id = "Email")
    public MobileElement emailTextField;

    @AndroidFindBy(id = "editTextPassword")
    @iOSXCUITFindBy(id = "Password")
    public MobileElement passwordTextField;

    @AndroidFindBy(id = "buttonLogin")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Sign In\" AND name == \"Sign In\" AND type == \"XCUIElementTypeButton\" and visible==1")
    public MobileElement signInButton;

    @AndroidFindBy(id = "selectbtn")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Continue\" AND name == \"Continue\" AND type == \"XCUIElementTypeButton\" and visible==1")
    public MobileElement continueButton;

    @AndroidFindBy(xpath = "//*[@resource-id='android:id/button1' and @text='CONTINUE']")
    public MobileElement continueButtonCache;

    @AndroidFindBy(id = "contAsGuest")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Continue as Guest\" AND name == \"Continue as Guest\" AND type == \"XCUIElementTypeButton\" and visible==1")
    public MobileElement continueAsGuestButton;

    @AndroidFindBy(xpath = "//*[contains(@text,'LATER')]")
    @iOSXCUITFindBy(accessibility = "Maybe Later")
    public MobileElement updateLater;
}

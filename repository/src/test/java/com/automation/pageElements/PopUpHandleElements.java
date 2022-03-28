package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PopUpHandleElements {

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Maybe Later'")
    @AndroidFindBy(id = "android:id/button3")
    public MobileElement SoftUpgradeMayBeLater;

    @AndroidFindBy(xpath = "//*[@text='CONTINUE']")
    //  @AndroidFindBy(id = "android:id/button1")
    public MobileElement Continue;

    @AndroidFindBy(xpath = "//*[@resource-id=\"android:id/button_always\"]")
    public MobileElement openWithAppAlwaysButton;

    @AndroidFindBy(xpath = "//*[@resource-id=\"android:id/button_once\"]")
    public MobileElement openWithAppJustOnceButton;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Dismiss'")
    @AndroidFindBy(xpath = "//*[contains(@text,'Dismiss')] | //*[contains(@text,'DISMISS')]")
    public MobileElement dismissButton;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Yes'")
    @AndroidFindBy(id = "yes")
    public MobileElement clickYesIfYouLoveApp;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Cancel'")
    @AndroidFindBy(id = "android:id/button3")
    public MobileElement clickCancel;

}

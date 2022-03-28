package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;


/**
 * This class contains elements that belong to start up page.
 */
public class GG_StartUpPageElements {

    @AndroidFindBy(id = "link_text_signin")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Sign In Here\" AND name == \"Sign In Here\" AND type == \"XCUIElementTypeButton\" and visible==1")
    public MobileElement signInHereButton;
}

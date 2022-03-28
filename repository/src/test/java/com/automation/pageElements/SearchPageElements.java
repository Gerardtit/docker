package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SearchPageElements {
    //edit search bar
    @iOSXCUITFindBy(accessibility = "Search for Products")
    @AndroidFindBy(id = "editSearch")
    public MobileElement editSearchBar;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND value == 'Cancel' AND visible == 1")
    @AndroidFindBy(id = "imageBack")
    public MobileElement backButton;
}

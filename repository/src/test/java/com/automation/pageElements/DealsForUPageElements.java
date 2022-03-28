package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class DealsForUPageElements {

    @iOSXCUITFindBy(xpath = "//*[@label=\"DEALS\"]")
    @AndroidFindBy(xpath = "//*[@text=\"DEALS\"]")
    public MobileElement dealsTab;

    @AndroidFindBy(xpath = "//*[@text=\"for U\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"for U\"]")
    public MobileElement forUTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='for U']")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'for U')][@visible='true']")
    public MobileElement dealsForUHeader;


}

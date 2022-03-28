package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_user_subscriptionElements {


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Current plan\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Current plan\"]")
//    @CacheLookup
    public MobileElement currentplan;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Annual plan\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Annual plan\"]")
//    @CacheLookup
    public MobileElement annualplan;

    @iOSXCUITFindBy(xpath = "//*[starts-with(@label,\"Your annual plan\")]")
    @AndroidFindBy(xpath = "//*[starts-with(@text,\"Your annual plan\")]")
//    @CacheLookup
    public MobileElement annualyrSubplan;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Your new plan\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Your new plan\"]")
//    @CacheLookup
    public MobileElement urnewplan;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Monthly plan\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Monthly plan\"]")
//    @CacheLookup
    public MobileElement newmonthlyplan;

    @iOSXCUITFindBy(xpath = "//*[starts-with(@label,\"Your monthly plan\")]")
    @AndroidFindBy(xpath = "//*[starts-with(@text,\"Your monthly plan\")]")
//    @CacheLookup
    public MobileElement newmonthlyplanSub;


    @iOSXCUITFindBy(xpath = "//*[@label=\"$12.99 / month + tax\"]")
    @AndroidFindBy(xpath = "//*[@text=\"$12.99 / month\"]")
//    @CacheLookup
    public MobileElement taxnmonthlyplan;


}

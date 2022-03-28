package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_suspendedFp_accountElements {


    @iOSXCUITFindBy(xpath = "//*[@label=\"Your subscription is currently suspended\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Your subscription is currently suspended.\"]")
//    @CacheLookup
    public MobileElement suspendedtext;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Visa ending in 4242 edit\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[4]/android.view.ViewGroup[1]/android.widget.ImageView[2]")
//    @CacheLookup
    public MobileElement cardArrow;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"Discover ending\")]")
    @AndroidFindBy(xpath = "//*[@text=\"•••• •••• •••• 4242\"]")
//    @CacheLookup
    public MobileElement cardNumber;


    @iOSXCUITFindBy(xpath = "//*[@label=\"back\"and @name=\"back\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Navigate up\"]")
//    @CacheLookup
    public MobileElement backicon;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Card expired\"]")
    @AndroidFindBy(xpath = "//*[@text=\"•••• •••• •••• 4242\"]")
//    @AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[4]/android.widget.TextView[1]")
//    @AndroidFindBy(xpath="//*[@text=\"Card expired\" and @clickable=\"true\"and @index=\"1\"]")
//    @CacheLookup
    public MobileElement cardExpiredText;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Suspended\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Suspended\"]")
//    @CacheLookup
    public MobileElement suspendedatmembertab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Unsubscribed\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Unsubscribed\"]")
//    @AndroidFindBy(xpath="//android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.Button[1]")
//    @AndroidFindBy(xpath= "//android.widget.Button[@text=\"Get started\" and @content-desc=\"Get started\ and @index=\"1\"]")
    public MobileElement unsubscribetab;
}



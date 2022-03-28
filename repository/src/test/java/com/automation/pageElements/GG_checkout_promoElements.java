package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_checkout_promoElements {
    @AndroidFindBy(xpath = "//*[@text=\"Add promo code\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Add promo code\"]")
    public MobileElement promocodetext;

    @AndroidFindBy(xpath = "//*[@text=\"Enter Promo Code\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    public MobileElement promoeditbox;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Estimated total.\")]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView[3]")
    public MobileElement costbefore;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Estimated total.\")]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.TextView[3]")
    public MobileElement afterpromoapplied;

    @iOSXCUITFindBy(xpath = "//*[@value=\"Apply\"and @name =\"Apply\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Apply\"]")
    public MobileElement applypromo;


    @AndroidFindBy(xpath = "//*[@content-desc=\"Clear text\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    public MobileElement crosssigninedit;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Promo code :luvfresh\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"LUVFRESH\")]")
    public MobileElement promoapplied;

    @AndroidFindBy(xpath = "//*[@content-desc=\"delete LUVFRESH promo code\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"closeButton\"]")
    public MobileElement closepromoapply;

    @AndroidFindBy(xpath = "//*[@text=\"This promo code is invalid and cannot be applied.\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"This promo code is invalid and cannot be applied.\"]")
    public MobileElement warningmessage;
}


package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_Tutorial_ToolTipPageElements {
    @AndroidFindBy(id = "tv_tooltip_message")
    @iOSXCUITFindBy(accessibility = "lblToolTipDescription-Welcome tool tip")
    public MobileElement toolTipDescriptionOnDealTab;

    @AndroidFindBy(id = "btn_tooltip")
    @iOSXCUITFindBy(accessibility = "btnNext-Welcome tool tip")
    public MobileElement toolTipNextButtonOnTab;

    @AndroidFindBy(id = "dealsContainerFragment")
    @iOSXCUITFindBy(id = "DEALS")
    public MobileElement dealsTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Choose delivery, pickup or in-store shopping.']")
    @iOSXCUITFindBy(id = "lblToolTipDescription-Pick up tool tip")
    public MobileElement shoppingModeToolTip;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Clip coupons and shop the Weekly Ad. Redeem in-store or online.']")
    @iOSXCUITFindBy(id = "lblToolTipDescription-Deals tool tip")
    public MobileElement dealsToolTip;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Wallet holds all clipped deals and rewards. Pay and apply discounts when you shop.']")
    @iOSXCUITFindBy(id = "lblToolTipDescription-Wallet tool tip")
    public MobileElement walletToolTip;

}

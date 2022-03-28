package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class WalletPageElements {

    // verify HomePage
    @iOSXCUITFindBy(xpath = "//*[@label=\"User profile\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"iv_user_avatar\")]")
    public MobileElement menuButton;

    //Search Bar
//    @AndroidFindBy(xpath = "//*[@text=\"Search for Products\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"iv_search\")]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Search bar\"]")
    public MobileElement searchBar;

    // Tap on Wallet
    @AndroidFindBy(xpath = "//*[@text=\"MEMBER\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"MEMBER\"]")
    public MobileElement clickWallet;

    //window title
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.TextView[1]")
    public MobileElement pageTitle;

    // Loyalty Card
    @AndroidFindBy(xpath = "//*[@text=\"Loyalty Card\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Selected Loyalty Card Tom Thumb Scan to get your savings applied.\"]")
    public MobileElement loyaltyCard;

    // Clipped Rewards
    @AndroidFindBy(xpath = "//*[@text=\"Show rewards\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Start earning rewards today\")]")
    public MobileElement clippedRewards;

    // Clipped Deals
    @AndroidFindBy(xpath = "//*[contains(@text,\"You clipped\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"You clipped\")]")
    public MobileElement clippedDeals;

    // Clipped Deals Page
    @AndroidFindBy(xpath = "//*[contains(@text,\"Clipped deals\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Clipped deals\")]")
    public MobileElement clippedDealsPage;


    @AndroidFindBy(xpath = "//*[@text=\"Wallet\"]")
    public MobileElement walletTab;

    @AndroidFindBy(xpath = "//*[@text=\"Wallet\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label, 'Wallet')]")
    public MobileElement walletSubTab;

    // @AndroidFindBy(id = "walletContainerFragment")
    @AndroidFindBy(xpath = "//*[@text=\"MEMBER\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"MEMBER\"]")
    public MobileElement memberTab;

    // @AndroidFindBy(id = "walletContainerFragment")

    @AndroidFindBy(xpath = "//*[@text=\"See your clipped deals\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"See your clipped deals; See all\"]")

    public MobileElement checkClippedDeals;

    @AndroidFindBy(xpath = "//*[contains(@text,\"You clipped\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"You clipped\")]")
    public MobileElement yourClippedDeals;

    // Clip Coupon
    @AndroidFindBy(xpath = "//*[contains(@text,\"Clip\")]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Clip coupon for\" and @value=\"test\"]")
    public MobileElement clipCoupon;


    @AndroidFindBy(xpath = "//*[contains(@text,\"Rewards\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Rewards\")]")
    public MobileElement rewardstab;


}

package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class GG_VerifyClipDealsElements {

    //    //My Items on HomePage
    @iOSXCUITFindBy(xpath = "//*[@label=\"MY ITEMS\"]")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[4]/android.widget.ImageView[1]")
    public MobileElement myItemsAtHomePage;
    //    //where i smy coupon
    @iOSXCUITFindBy(xpath = "//*[@label=\"Close\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Close\"]")
    public MobileElement crossSign;

    //Clip at uDeals-2ndPage
//    @iOSXCUITFindBy(xpath = "//*[@label=\"Clip coupon for\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.ImageView[1]")
    public MobileElement ClipAtUDeals;
//
//    //Clip at uDeals-burger
//    @iOSXCUITFindBy(xpath = "//*[@label=\"Clip coupon for\" and @value=\"OMS Offer Request test Automation\"]")
//    @AndroidFindBy(xpath = "")
//    public MobileElement ClipAtUDealsBurger;
//
//    //show rewards
//    @iOSXCUITFindBy(xpath = "//*[@label=\"Start earning rewards today\"]")
//    @AndroidFindBy(xpath = "")
//    public MobileElement showRewards;

    //all DEals at UDeals
    @iOSXCUITFindBy(xpath = "//*[@label=\"All deals\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.Button[1]")
    public MobileElement AllDealAtUDeal;

//    //back to wallet
//    @iOSXCUITFindBy(xpath = "//*[@label=\"Start earning rewards today\"]")
//    @AndroidFindBy(xpath = "")
//    public MobileElement RewardsToWallet;

    //to homepage
    @iOSXCUITFindBy(xpath = "//*[@label=\"Done\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Close\"]")
    public WebElement navigateToHomePage;

    //    //clipped DealsPage
    @iOSXCUITFindBy(xpath = "//*[@label=\"Clipped deals\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Clipped deals\"]")
    public WebElement clippedDealsPage;

    //ToCheckClippedItems
    @iOSXCUITFindBy(xpath = "//*[@label=\"Condiments, Spices & Bake 10 deals Collapsed\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Condiments, Spices & Bake\"]")
    public WebElement ToCheckClippedItems;

    //    //Clip at MyWallet
    @iOSXCUITFindBy(xpath = "//*[@name=\"viewClippedDealsButtonView\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[1]")
    public WebElement clipAtMyWallet;

    //    //showAll at MyWallet
    @iOSXCUITFindBy(xpath = "//*[@name=\"viewClippedDealsButtonView\"]")
    @AndroidFindBy(xpath = "//*[@text=\"See all\"]")
    public WebElement showAllatMyWallet;

    //ClippedText
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Clipped\"]")
//    @AndroidFindBy(xpath = "//*[@instance =\"3\" and @class=\"android.widget.ImageView\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Clipped\"]")
    public MobileElement ClippedText;


    //Clip at uDeals-Resolution

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]")
//    @AndroidFindBy(xpath = "//*[@instance =\"3\" and @class=\"android.widget.ImageView\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.widget.ImageView[2]")
    public MobileElement ClipAtUDealsREsolution;

    //ClipwithTerms&Condition
    @iOSXCUITFindBy(xpath = "//*[@label=\"Unclipped\"]")
//    @AndroidFindBy(xpath = "//*[@instance =\"3\" and @class=\"android.widget.ImageView\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"clip coupon\"]")
    public MobileElement ClipWithTermsNCondition;


    //Clipped items
    @iOSXCUITFindBy(xpath = "//*[@label=\"Clip coupon for\" and @value=\"High Resolution Test 274\"]")
//    @AndroidFindBy(xpath = "//*[@test=\"High Resolution Test 10\"]")
    @AndroidFindBy(xpath = "////android.view.ViewGroup[2]/android.widget.ImageView[2]")
    public MobileElement Clippeditems;

    //    //My Wallet at homePage
    @iOSXCUITFindBy(xpath = "//*[@label=\"WALLET\"]")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[5]/android.widget.ImageView[1]")
    public MobileElement MyWalletathomePage;

    //clip at myitems
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]")
    @AndroidFindBy(xpath = "//*[@id=\"txtButtonName\" or @class=\"android.widget.Button\" and @index=\"1\"]")
    public MobileElement ClipatMyItems;

    //showAll at Myitems
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]")
    @AndroidFindBy(xpath = "//*[@text=\"See in Wallet\"]")
    public WebElement showAllatMyitems;


    // MyWallet page
    @iOSXCUITFindBy(xpath = "//*[@label=\"Wallet\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Wallet\"]")
    public WebElement myWalletPage;

}

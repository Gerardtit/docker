package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
//import org.openqa.selenium.support.CacheLookup;

public class GG_verifyWeeklyAdsElements {


    //"ShoppingMode" button
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"address\")]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"tv_shopping_mode\")]")
    public MobileElement clickShoppingMode;

    //"Must grab text
    @iOSXCUITFindBy(xpath = "//*[@label=\"Must-have grabs\"]")
    @AndroidFindBy(id = "tv_salutation_header")
    public MobileElement mustGrabTextOnHomepage;

    //weekly ad on homepage
    @iOSXCUITFindBy(xpath = "//*[@label=\"Weekly Ads work wonders. Save better everyday.\"]")
    @AndroidFindBy(xpath = " //*[contains(@resource-id,\"weekly_ad_banner\")]")
    public MobileElement weeklyAdsOnHomepage;


    //message at weeklyAd page
    @iOSXCUITFindBy(xpath = "//*[@label=\"There are no weekly ads available at this time.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"There are no weekly ads available at this time.\"]")
    public MobileElement messageOnWeeklyAdPage;

    //weekly ad store location
    @iOSXCUITFindBy(xpath = "//*[@label=\"STORE LOCATOR PAGE\"]")
    @AndroidFindBy(xpath = "//*[@class=\"actionButton\"]")
    public MobileElement weeklyAdsstoreLocation;

    // landing on link(contains text= hot weekly ads)
    @iOSXCUITFindBy(xpath = "//*[@value=\" Hot Weekly Ad Items\"]")
    @AndroidFindBy(xpath = "//*[@value=\" Hot Weekly Ad Items\"]")
    public MobileElement weeklyAdstoLink;


    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"webview_tv_title\")]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Weekly Ads\" and @name=\"lblTopNavBarTitle\"]")
    public MobileElement weeklyAdTitle;

}


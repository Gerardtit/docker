package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_VerifyAdsCountElements {

    // weeklyad coupon on homepage
    @iOSXCUITFindBy(xpath = "//*[@label=\"Weekly ad coupons\" and @name=\"lblSeeAllTitle\"]")
//    @iOSXCUITFindBy(xpath ="//XCUIElementTypeCell[6]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(xpath = "//*[@text=\"Weekly ad coupons\"]")
    public MobileElement weeklyadcoupononHomepage;

    // SeeAllweeklyad coupon
    @iOSXCUITFindBy(xpath = "//*[@name=\"btnSeeAllButtonTitle-Weekly ad coupons\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Weekly ad coupons See all\"]")
    public MobileElement SeeAllweeklyadcoupon;

    // Deals page
    @iOSXCUITFindBy(xpath = "//*[@label=\"Deals\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Deals\"]")
    public MobileElement Dealspage;

    //Categories At Deals
    @iOSXCUITFindBy(xpath = "//*[@label=\"Categories Tab, 2 of 5\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Categories\"]")
    public MobileElement CategoriesAtDeals;

    //SavingEvents At Deals
    @iOSXCUITFindBy(xpath = "//*[@label=\"Saving events\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Saving events\"]")
    public MobileElement SavingEventsAtDeals;

    // count weeklyad coupon page
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]")
//    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[1]/android.widget.TextView[2]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"bottom_sheet_sub_title\") and @index=\"2\"]")
    public MobileElement CountDealsfromudeal;

    // count weeklyad coupon page
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"bottom_sheet_sub_title\") and @index=\"2\"]")
    public MobileElement CountDealsfromhomepage;

    // close Tab WeeklyAds
    @iOSXCUITFindBy(xpath = "//*[@label=\"iconClose\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"close\" and @class=\"android.widget.ImageView\"]")
//    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"bottom_sheet_close\")]")
//    @AndroidFindBy(xpath = "//*[@content-desc=\"close\" or @id=\"bottom_sheet_close\"]")
    public MobileElement closeTabWeeklyAds;

    // savingEvents see all
    @iOSXCUITFindBy(xpath = "//*[@name=\"btnSeeAllButtonTitle-Saving events\"]")
    @AndroidFindBy(xpath = "//*[@text=\"See all\"]")
    public MobileElement savingEventsseeall;

    // savingEvents weeklyads
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[8]/XCUIElementTypeButton[1]")
    @AndroidFindBy(xpath = "//*[@text=\"Weekly Ad Coupons\" or @id=\"tv_saving_title\"]")
    public MobileElement savingEventsweeklyads;

    // home icon
    @iOSXCUITFindBy(xpath = "//*[@label=\"HOME\"]")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.ImageView[1]")
    public MobileElement homeicon;

    // savingEvents close
    @iOSXCUITFindBy(xpath = "//*[@name=\"Close\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Close\"]")
    public MobileElement savingEventsClose;


}

package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class DealsAllCouponPageElements {

    // Click Deals tab
    @AndroidFindBy(xpath = "//*[@text=\"DEALS\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"DEALS\"]")
    public MobileElement clickDeals;

    //deals title
    @AndroidFindBy(xpath = "(//*[contains(@resource-id,\"title\")])[1]")
//    @iOSXCUITFindBy(xpath = "//*[@label=\"Deals\"]")
    public MobileElement dealsTitle;

    // Click All Coupons
    @AndroidFindBy(xpath = "//*[@text=\"All coupons\"] | //*[@text=\"All deals\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"All coupons\")] | //*[contains(@label,\"All deals\")]")
    public MobileElement clickAllCoupons;

    // verify clipping coupons are displayed
    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Clip coupon\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"lblRefineTableHeaderViewTitle\")]")
    public MobileElement verifyClippingCoupons;

    // Select Products to clip
    @iOSXCUITFindBy(xpath = "//*/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[2]")
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[1]/android.widget.Button[1]/android.widget.Button[1]")
    public MobileElement clipProduct1;

    @iOSXCUITFindBy(xpath = "//*/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.widget.ImageView[1]")
    public MobileElement clickProduct1;


    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[1]/android.widget.Button[2]/android.widget.Button[1]")
    @iOSXCUITFindBy(xpath = "//*/XCUIElementTypeCell[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[2]")
    public MobileElement clipProduct2;

    @AndroidFindBy(xpath = "//*/androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[3]")
    @iOSXCUITFindBy(xpath = "//*/XCUIElementTypeCell[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]")
    public MobileElement clickProduct2;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[1]/android.widget.Button[3]/android.widget.Button[1]")
    @iOSXCUITFindBy(xpath = "//*/XCUIElementTypeCell[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[2]")
    public MobileElement clipProduct3;

    @AndroidFindBy(xpath = "//*/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[4]")
    @iOSXCUITFindBy(xpath = "//*/XCUIElementTypeCell[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]")
    public MobileElement clickProduct3;

    @AndroidFindBy(xpath = "//*/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[4]/android.widget.ImageView[2]")
    @iOSXCUITFindBy(xpath = "//*/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[4]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[2]")
    public MobileElement clipProduct4;

    @AndroidFindBy(xpath = "//*/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[4]")
    @iOSXCUITFindBy(xpath = "//*/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[4]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]")
    public MobileElement clickProduct4;

    //    @AndroidFindBy(xpath ="//*/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout[3]/android.view.ViewGroup[1]/android.widget.Button[1]" )
    @iOSXCUITFindBy(xpath = "//*/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[4]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[2]")
    public MobileElement clipProduct5;

    //    @AndroidFindBy(xpath = "//*/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout[3]/android.view.ViewGroup[1]")
    @iOSXCUITFindBy(xpath = "//*/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[4]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]")
    public MobileElement clickProduct5;


    // clip unclipped coupons
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"ivOfferUnclipped\")]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Unclipped\"]")
    public MobileElement unclippedCoupons;

    // Clipped Coupons
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"ivOfferClipped\")]")
    public MobileElement clippedCoupons;


    // click Close Button
    @AndroidFindBy(xpath = "//*[@content-desc=\"Close\"] | //*[contains(@content-desc, \"Close\")]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Close\"] | //*[contains(@label,\"Close\")]")
    public MobileElement clickClose;

    // click drawer
    @AndroidFindBy(xpath = "//*[@text=\"Terms and Conditions\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Terms and Conditions\"]")
    public MobileElement clickDrawer;

    //View Products
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"tv_clipped_added\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Coupon Added\")]")
    public MobileElement viewProducts;

    //clickClippedDeals
    @AndroidFindBy(xpath = "//*[contains(@text,\"You clipped\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"You clipped\")]")
    public MobileElement clickClippedDeals;

    @AndroidFindBy(xpath = "//*[@text=\"My rewards\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"View My rewards\"]")
    public MobileElement rewardsPill;

    @AndroidFindBy(xpath = "//*[@text=\"Clipped deals\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"View Clipped deals\"]")
    public MobileElement clippedDealPill;

    @AndroidFindBy(xpath = "//*[@text=\"Weekly Ad\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Show Weekly ad Deals\"]")
    public MobileElement weeklyAdPill;

    @AndroidFindBy(xpath = "//*[@text=\"Added\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,\"Added\")]")
    public MobileElement detailsatClippeddeals;

    @AndroidFindBy(xpath = "//*[@text=\"View list\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label=\"View list\"]")
    public MobileElement viewListAtclipped;
}

package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_OfferCTAElements {

    @AndroidFindBy(xpath = "//*[contains(@text,\"$\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeStaticText[1][contains(@value,\"$\")]")
    public MobileElement pricetag;

    @AndroidFindBy(id = "offer_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeStaticText[2]")
    public MobileElement productdetail;

    //    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"oz\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeStaticText[3]")
    @AndroidFindBy(xpath = "//*[contains(@text,\"oz\")]")
    public MobileElement productdesc;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Expires\")][1]")
    @AndroidFindBy(xpath = "//*[contains(@text,\"Expires\")]")
    public MobileElement expiresdates;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[2]/android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]")
    public MobileElement AddProduct;


}


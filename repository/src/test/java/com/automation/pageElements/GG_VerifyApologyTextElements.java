package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_VerifyApologyTextElements {

    //select TT at zipcode page
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label=\"0.84 mi.\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"0.84 miles away\"]")
    public MobileElement TTshopAtZipcode;

    //select 2nd item
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[2]")
//    @AndroidFindBy(xpath = "//android.widget.FrameLayout[2]/android.widget.Button[1]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Ground Beef 80% Lean 20% Fat Value Pack - 3.50 Lbs.\"]")
    public MobileElement secondItem;


    //select 3rd item
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[3]")
//    @AndroidFindBy(xpath = "//android.widget.FrameLayout[3]/android.widget.Button[1]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Coca-Cola Soda Soft Drink, 12 fl oz, 12 Pack\"]")
    public MobileElement thirdItem;

    //close MYLIST page
    @iOSXCUITFindBy(xpath = "//*[@label=\"Done\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Close\"]")
    public MobileElement CloseTabAtMyList;

    //select fourth
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[4]")
//    @AndroidFindBy(xpath ="//android.widget.FrameLayout[4]/android.widget.Button[1]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Diet Coke Soda Soft Drink, 12 fl oz, 12 Pack\"]")
    public MobileElement fourthItem;


    //select ApologyText
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[5]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[starts-with(@label,\"Apologies\") and (@name,\"Apologies\") and @visible=\"true\"]")
//    @iOSXCUITFindBy(xpath ="//*[@label=\"Apologies, we are not able to guarantee the prices or availability of the items in your list. Please check in store for current prices and availability.\"]")
    @AndroidFindBy(id = "tvInStoreDisclaimer")
    public MobileElement ApologyText;

    //select ListiconOnHomePage
    @iOSXCUITFindBy(xpath = "//*[@label=\"List\"]")
    @AndroidFindBy(id = "iv_cart")
    public MobileElement ListAtHomePAge;


    //press enter at zipcode
    @AndroidFindBy(id = "//*[@content-desc=\"Confirm Zip Code\" or @id=\"btn_next\"]")
    public MobileElement enterZipcode;


    //select BackToHomePAge
    @iOSXCUITFindBy(xpath = "//*[@label=\"Back\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Navigate up\"]")
    public MobileElement BackToHomePAge;
}

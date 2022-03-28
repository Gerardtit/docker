package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_DashboardBrowseCategoryPageElements {

    @AndroidFindBy(id = "text_aisle_name")
    @iOSXCUITFindBy(id = "lblName")
    public List<MobileElement> browseCategoryCard;

    @AndroidFindBy(id = "text_aisle_name")
    @iOSXCUITFindBy(id = "lblName")
    public MobileElement firstBrowseCategoryCard;

    @AndroidFindBy(id = "cv_browse_by_aisle")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Browse categories']//parent:: XCUIElementTypeOther//following-sibling:: XCUIElementTypeCollectionView")
    public MobileElement categoryCardsCarousel;

    //  @AndroidFindBy(xpath = "//*[contains(@resource-id,\"tv_browse_by_aisle\")]//following-sibling::*[contains(@text,\"See all\")]")
//    @AndroidFindBy(accessibility = "Browse categories See all")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Browse categories See all\"]")
    @iOSXCUITFindBy(id = "btnSeeAllButtonTitle-Browse categories")
    public MobileElement browseCategorySeeAll;

    @AndroidFindBy(id = "text_aisle_name")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblName'")
    public MobileElement cardName;

    @AndroidFindBy(id = "iv_browse_aisle")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeImage' AND name == 'imgvAisleImage'")
    public MobileElement cardImage;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Browse categories\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Browse categories'")
    public MobileElement browseCategoriesLabel;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Browse deals\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Browse deals'")
    public MobileElement browseDealsLabel;

    @AndroidFindBy(id = "ic_back")
    @iOSXCUITFindBy(accessibility = "btnTopNavBarLeft")
    public MobileElement backButtonInDetailsPage;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Close\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' and name BEGINSWITH 'My Cart'")
    public MobileElement backButtonheckoutPageInDetailsPage;

    @AndroidFindBy(id = "tv_category_refine")
    @iOSXCUITFindBy(accessibility = "Refine")
    public MobileElement refineButton;

    @AndroidFindBy(id = "tv_deal_price")
    @iOSXCUITFindBy(accessibility = "lblDealsPriceLabel-0")
    public MobileElement dealCard;

    @AndroidFindBy(id = "aisleName")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblName'")
    public List<MobileElement> categoryName;


    //    @AndroidFindBy(accessibility = "BROWSE")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"SHOP\")")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'SHOP'")
    public MobileElement browseTab;

}

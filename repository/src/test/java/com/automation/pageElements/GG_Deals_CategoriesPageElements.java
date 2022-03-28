package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_Deals_CategoriesPageElements {

    @AndroidFindBy(id = "tv_savings_header")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Saving events' AND visible==1")
    public MobileElement savingEventsLabel;

    @AndroidFindBy(id = "tv_saving_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView//XCUIElementTypeStaticText[@name='lblTitle' and @visible='true']")
    public MobileElement firstSavingEventCardName;

    @AndroidFindBy(id = "tv_saving_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView//XCUIElementTypeStaticText[@name='lblTitle' and @visible='true']")
    public List<MobileElement> allSavingEventCardNames;

    @AndroidFindBy(id = "tv_saving_count")
    @iOSXCUITFindBy(accessibility = "lblDescription")
    public MobileElement firstSavingEventCardDealCount;

    @AndroidFindBy(id = "tv_saving_count")
    @iOSXCUITFindBy(accessibility = "lblDescription")
    public List<MobileElement> allSavingCardDealsCount;

    @AndroidFindBy(id = "hyphen_rb")
    @iOSXCUITFindBy(id = "indicatorView")
    public List<MobileElement> savingEventCardFocusIndicator;

    @AndroidFindBy(id = "hyphen_rb")
    @iOSXCUITFindBy(id = "indicatorView")
    public MobileElement firstSavingEventCardFocusIndicator;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"tv_savings_header\")]//following-sibling::*[contains(@text,\"See all\")]")
    @iOSXCUITFindBy(accessibility = "btnSeeAllButtonTitle-Saving events")
    public MobileElement seeAllSavingEventsButton;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Your categories\"])")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value == 'Your categories'")
    public MobileElement yourCategoriesTitle;

    @AndroidFindBy(id = "tv_my_category_name")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeOther[@visible='true']/XCUIElementTypeButton")
    public List<MobileElement> categoryNames;


    @AndroidFindBy(id = "tv_my_category_name")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeOther/XCUIElementTypeButton[@visible='true']")
    public MobileElement dealCategory;

    @AndroidFindBy(id = "iv_deal_image")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalNameLabel'")
    public MobileElement dealCategoryImage;

    @AndroidFindBy(id = "ic_back")
    @iOSXCUITFindBy(accessibility = "btnTopNavBarLeft")
    public MobileElement dealCategoryListingPageBackButton;

    @AndroidFindBy(id = "tv_category_details_title")
    @iOSXCUITFindBy(accessibility = "lblTopNavBarTitle")
    public MobileElement dealCategoryName;

    @AndroidFindBy(id = "tv_total_savings_count")
    @iOSXCUITFindBy(accessibility = "lblSavingEventsListEventsCount")
    public MobileElement countOfSavingEvents;

    @AndroidFindBy(id = "tv_saving_title")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblSavingEventsCellTitle'")
    public MobileElement savingEventCategoryTitle;

    @AndroidFindBy(id = "tv_saving_title")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblSavingEventsCellTitle' AND visible==1")
    public List<MobileElement> savingEventCategoryTitleList;

    @AndroidFindBy(id = "clip_coupon_layout")
    @iOSXCUITFindBy(iOSNsPredicate = "name=='btnCardMediumVerticalButton' AND label BEGINSWITH 'Clip' and visible==1")
    public MobileElement clipButton;

    @AndroidFindBy(id = "tv_clipped_added")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Coupon Added' and visible==1")
    public MobileElement couponAddedLabel;

    @AndroidFindBy(id = "bottom_sheet_close")
    @iOSXCUITFindBy(accessibility = "btnClose")
    public MobileElement crossBtnSavingEvent;

    @AndroidFindBy(id = "btn_close_large")
    @iOSXCUITFindBy(accessibility = "btnSavingEventsListCloseButton")
    public MobileElement closeButtonSavingEventList;

    @AndroidFindBy(id = "bottom_sheet_close")
    @iOSXCUITFindBy(accessibility = "btnClose")
    public MobileElement closeButtondealsEventList;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Clip deal\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Clip deal for' and name == 'btnCardMediumVerticalButton'")
    public MobileElement clipDealBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Clip deal\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Clip deal for' and name == 'btnCardMediumVerticalButton'")
    public List<MobileElement> clipDealBtnList;

    @AndroidFindBy(accessibility = "All coupons")
    @iOSXCUITFindBy(iOSNsPredicate = "value BEGINSWITH 'All deals Tab'")
    public MobileElement allDealsTab;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Saving events')]//following-sibling::*[contains(@text,'See all')]")
    @iOSXCUITFindBy(accessibility = "See all")
    public MobileElement seeAllSavingEvent;

    @AndroidFindBy(id = "walletContainerFragment")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'WALLET' OR name == 'MEMBER'")
    public MobileElement memberTab;

    @AndroidFindBy(id = "dealsContainerFragment")
    @iOSXCUITFindBy(id = "DEALS")
    public MobileElement dealsTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"DISMISS\")")
    @iOSXCUITFindBy(id = "Dismiss")
    public MobileElement dismissCTA;

    @AndroidFindBy(id = "tv_clipped_deals_count")
    @iOSXCUITFindBy(accessibility = "lblItemCount")
    public MobileElement dealsCountDealCategoryDetail;

    @AndroidFindBy(id = "tv_my_category_name")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeButton")
    public List<MobileElement> categoryNamesInList;

    @AndroidFindBy(id = "tv_deal_name")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'lblCardMediumVerticalDescritionLabel' AND visible==1")
    public MobileElement dealName;
}


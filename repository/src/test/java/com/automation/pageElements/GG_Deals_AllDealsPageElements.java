package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_Deals_AllDealsPageElements {
    @AndroidFindBy(id = "tv_deal_expiry")
    @iOSXCUITFindBy(iOSNsPredicate = "name=='lblCardMediumVerticalExpiryLabel' AND visible==1")
    public MobileElement firstDealExpiryLabel;

    @AndroidFindBy(id = "tv_category_refine")
    //@iOSXCUITFindBy(accessibility = "Refine")
    @iOSXCUITFindBy(accessibility = "btnRefine")
    public MobileElement refineButton;

    @AndroidFindBy(id = "tv_all_deals_total_deal_count")
    @iOSXCUITFindBy(accessibility = "lblRefineTableHeaderViewTitle")
    public MobileElement totalDealCount;

    @AndroidFindBy(id = "clip_coupon_layout")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"btnCardMediumVerticalButton\"])[1]")
//    @iOSXCUITFindBy(iOSNsPredicate = "name=='btnCardMediumVerticalButton' AND label BEGINSWITH 'Clip'")
    public MobileElement clipDealButton;

    @AndroidFindBy(id = "clip_coupon_layout")
    @iOSXCUITFindBy(iOSNsPredicate = "name=='btnCardMediumVerticalButton' AND label BEGINSWITH 'Clip' and visible==1")
    public List<MobileElement> clipDealAllButtons;

    @AndroidFindBy(accessibility = "All coupons")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='lblHorizontalTitleCVCellTitle' and contains(@label,'All deals')]")
    public MobileElement allDealsTab;

    @AndroidFindBy(id = "tv_eligible_products")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Coupon Added. View eligible product' and visible==1")
    public List<MobileElement> viewProductsAllButtons;

    @AndroidFindBy(id = "tv_refine_coupon_title")
    @iOSXCUITFindBy(accessibility = "lblRefineTableHeaderViewTitle")
    public MobileElement refineTitle;

    @AndroidFindBy(accessibility = "Refine")
    @iOSXCUITFindBy(accessibility = "btnRefine")
    public MobileElement refineButtonOnAllCoupon;

    @AndroidFindBy(id = "btn_refine_coupon_show_result")
    @iOSXCUITFindBy(accessibility = "btnRefineShowResults")
    public MobileElement showResultButton;

    @AndroidFindBy(id = "iv_refine_coupon_close")
    @iOSXCUITFindBy(accessibility = "btnRefineTableHeaderViewClose")
    public MobileElement refineDrawerCloseButton;

    @AndroidFindBy(id = "tv_deal_expiry")
    @iOSXCUITFindBy(iOSNsPredicate = "name=='lblCardMediumVerticalExpiryLabel' AND visible==1")
    public List<MobileElement> allDealsExpiryLabel;

    @AndroidFindBy(id = "tv_refine_coupon_reset_btn")
    @iOSXCUITFindBy(accessibility = "btnRefineReset")
    public MobileElement resetButton;

    @AndroidFindBy(id = "iv_browse_aisle")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeImage' AND name == 'imgvAisleImage'")
    public MobileElement dealCardOnForYou;

    @AndroidFindBy(accessibility = "Show All Deals")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Show All Deals'")
    public MobileElement allDealsFilter;

    @AndroidFindBy(id = "tv_local_search_cancel")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Cancel button' AND visible==1")
    public MobileElement cancelBtnDealSearch;

    @AndroidFindBy(id = "tv_all_deals_total_deal_count")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'lblRefineTableHeaderViewTitle' AND visible==1")
    public MobileElement filteredDealsCountSearch;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Network Problem\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label=='Network Problem' AND type='XCUIElementTypeStaticText' AND visible==1")
    public MobileElement networkProblemMsg;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"OK\")")
    @iOSXCUITFindBy(xpath = "//*[@label='OK' or @label='Ok']")
    public MobileElement okBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Service Problem\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label=='Service Problem' AND type='XCUIElementTypeStaticText' AND visible==1")
    public MobileElement serviceProblemMsg;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'title') and @text='Deals']")
    @iOSXCUITFindBy(iOSNsPredicate = "label=='Deals'")
    public MobileElement dealsPage;

    @AndroidFindBy(xpath = "//*[@text='All deals']")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'All deals Tab')]")
    public MobileElement allDeals;

}

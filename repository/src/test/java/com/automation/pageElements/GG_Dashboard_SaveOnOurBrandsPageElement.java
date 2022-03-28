package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_Dashboard_SaveOnOurBrandsPageElement {
    @AndroidFindBy(id = "tv_exclusive_store")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Save on our brands'")
    public MobileElement exclusiveBrandTitle;

    @AndroidFindBy(id = "iv_exclusive_stores")
    @iOSXCUITFindBy(accessibility = "backgroundImageView")
    public MobileElement exclusiveBrandImage;

    @AndroidFindBy(accessibility = "Save on our brands See all")
    @iOSXCUITFindBy(accessibility = "btnSeeAllButtonTitle-Save on our brands")
    public MobileElement seeAllLink;

    @AndroidFindBy(id = "tv_deal_expiry")
    @iOSXCUITFindBy(id = "lblCardMediumVerticalExpiryLabel")
    public MobileElement dealCardExpiryDate;

    @AndroidFindBy(id = "clip_coupon_layout")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Clip deal for' AND name == 'btnCardMediumVerticalButton' AND visible==1")
    public MobileElement dealCTAButton;

    @AndroidFindBy(id = "bottom_sheet_sub_title")
    @iOSXCUITFindBy(accessibility = "lblDealsCount")
    public MobileElement countExclusiveBrandDeals;

    @AndroidFindBy(accessibility = "close")
    @iOSXCUITFindBy(accessibility = "btnClose")
    public MobileElement closeExclusiveBrandDetails;

    @AndroidFindBy(id = "tv_exclusive_store")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Save on our brands'")
    public MobileElement saveOnYourBrandModuleTitle;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"tv_exclusive_store\")]//following-sibling::*[contains(@text,\"See all\")]")
    @iOSXCUITFindBy(id = "btnSeeAllButtonTitle-Save on our brands")
    public MobileElement saveOnYourBrandModuleSeeAll;

    @AndroidFindBy(id = "deal_detail_container")
    @iOSXCUITFindBy(accessibility = "Offer Terms and Conditions")
    public MobileElement dealCardDetailsPageAllCoupon;

    @AndroidFindBy(id = "tv_deal_desc")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalDescritionLabel'")
    public List<MobileElement> dealDescription;

}
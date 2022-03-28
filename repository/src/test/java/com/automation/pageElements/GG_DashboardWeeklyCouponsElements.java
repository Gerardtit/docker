package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;


public class GG_DashboardWeeklyCouponsElements {

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'iv_redeemed_reward_image')]")
    @iOSXCUITFindBy(accessibility = "selectedCouponView")
    public MobileElement dealCard;

    @AndroidFindBy(id = "cv_dashboard_coupon")
    @iOSXCUITFindBy(accessibility = "couponCollectionView")
    public MobileElement freshNewCouponCarousel;

    @AndroidFindBy(id = "cr_weekly_coupon_icon")
    @iOSXCUITFindBy(xpath = "//*[@name='imgvFreshNewCouponCellImageView']//parent:: XCUIElementTypeOther")
    public List<MobileElement> freshNewCouponsCarouselDealContainer;

    @AndroidFindBy(accessibility = "Weekly ad coupons")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Weekly ad coupons'")
    public MobileElement sectionTitle;

    @AndroidFindBy(accessibility = "Weekly ad coupons See all")
    @iOSXCUITFindBy(accessibility = "btnSeeAllButtonTitle-Weekly ad coupons")
    public MobileElement seeAllFreshNewCoupons;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'iv_redeemed_reward_image')]")
    @iOSXCUITFindBy(accessibility = "selectedCouponImageView")
    public MobileElement dealImage;

    @AndroidFindBy(id = "btn_clip_deal")
    @iOSXCUITFindBy(iOSNsPredicate = "name == \"clipButton\" AND type == \"XCUIElementTypeButton\"")
    public MobileElement dealClip;

    @AndroidFindBy(id = "tv_redeemed_reward_price")
    @iOSXCUITFindBy(xpath = "(//*[@name='selectedCouponView']/XCUIElementTypeStaticText)[1]")
    public MobileElement dealDiscountTitle;

    @AndroidFindBy(id = "tv_redeemed_reward_name")
    @iOSXCUITFindBy(xpath = "(//*[@name='selectedCouponView']/XCUIElementTypeStaticText)[1]")
    public MobileElement dealSubjectLine;

    @AndroidFindBy(id = "tv_redeemed_reward_desc")
    @iOSXCUITFindBy(id = "couponDescriptionLabel")
    public MobileElement dealDescription;

    @AndroidFindBy(id = "tv_redeemed_reward_expiry")
    @iOSXCUITFindBy(accessibility = "couponExpiryLabel")
    public MobileElement dealExpiryDate;

    @AndroidFindBy(id = "coupon_image")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='imgvFreshNewCouponCellImageView']//parent:: XCUIElementTypeOther//parent:: XCUIElementTypeCell")
    public List<MobileElement> freshNewCouponsCarouselDealImage;

    @AndroidFindBy(id = "coupon_image")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='imgvFreshNewCouponCellImageView']//parent:: XCUIElementTypeOther//parent:: XCUIElementTypeCell")
    public MobileElement freshNewCouponsCarouselFirstDealImage;

    @AndroidFindBy(accessibility = "Fresh new coupons")
    @iOSXCUITFindBy(accessibility = "lblPageTitle")
    public MobileElement freshNewCouponTitle;

    @AndroidFindBy(id = "bottom_sheet_close")
    @iOSXCUITFindBy(accessibility = "btnClose")
    public MobileElement crossButtonFreshNewCoupon;

    @AndroidFindBy(id = "bottom_sheet_sub_title")
    @iOSXCUITFindBy(accessibility = "lblDealsCount")
    public MobileElement dealsCountFreshNewCoupon;
}

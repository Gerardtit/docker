package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_Deals_PromoPageElements {

    @AndroidFindBy(id = "tv_deal_big_card_header")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'imgBackground')]//following-sibling:: XCUIElementTypeOther")
    public MobileElement promoCardSubjectTitle;

    @AndroidFindBy(id = "tv_deal_big_card_sub_header")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'imgBackground')]//following-sibling:: XCUIElementTypeOther")
    public MobileElement promoCardDescription;

    @AndroidFindBy(id = "tv_deal_big_card_sub_header")
    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'imgBackground' AND visible==1")
    public MobileElement promoCard;

    @AndroidFindBy(id = "btn_promo_coupon_navigation")
    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'btnAction'")
    public MobileElement promoCardCTAbutton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Promo code copied to clipboard\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/following-sibling::XCUIElementTypeOther")
    public MobileElement promoCodeCopiedAnimationLabel;

    @AndroidFindBy(id = "iv_promo_banner")
    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'imgBackground' AND visible==1")
    public MobileElement promoDealImage;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Eligible Products\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'Eligible Products' and visible==1")
    public MobileElement promoDealDetailPage;

    @AndroidFindBy(id = "menu_search")
    @iOSXCUITFindBy(iOSNsPredicate = "label=='Search'")
    public MobileElement searchIconOnPromoDealPage;
}


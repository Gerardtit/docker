package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_DashboardPersonalisePageElements {

    @AndroidFindBy(xpath = "//*[contains(@text,'Must-have grabs')]")
    @iOSXCUITFindBy(xpath = "//*[@value='Must-have grabs']")
    public MobileElement mustHaveGrabsLabel;

    @AndroidFindBy(xpath = "//*[contains(@text,'Buy it again')]")
    @iOSXCUITFindBy(xpath = "//*[@value='Buy it again']")
    public MobileElement buyItAgainLabel;

    @AndroidFindBy(xpath = "//*[contains(@text,'Must-have grabs')]//following-sibling::*[contains(@resource-id,'tv_see_all')]")
    @iOSXCUITFindBy(xpath = "//*[@value='Must-have grabs']//parent::*//following-sibling::*[contains(@name,'btnSeeAllButtonTitle')]")
    public MobileElement seeAllMustHaveGrabs;

    @AndroidFindBy(xpath = "//*[contains(@text,'Buy it again')]//following-sibling::*[contains(@resource-id,'tv_see_all')]")
    @iOSXCUITFindBy(xpath = "//*[@value='Buy it again']//parent::*//following-sibling::*[contains(@name,'btnSeeAllButtonTitle')]")
    public MobileElement seeAllBuyItAgain;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tvTitle') and @text='Must-have grabs']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeNavigationBar' AND name == 'Must-have grabs'")
    public MobileElement getMustHaveGrabsTitle;

    @AndroidFindBy(id = "itemParentLayout")
    @iOSXCUITFindBy(id = "productCell")
    public MobileElement productCard;

    @AndroidFindBy(id = "deals_cardview")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeButton[@visible='true']")
    public List<MobileElement> dealCardContainer;


    @AndroidFindBy(xpath = "//*[contains(@text,\"Clip your deals\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"btnSeeAllButtonTitle-Clip your deals\"]")
    public MobileElement clipYourdealsTitle;


    @AndroidFindBy(id = "tv_salutation_header")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Clip your deals'")
    public MobileElement clipYourDealsTitle;


    @AndroidFindBy(accessibility = "Back")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Back' AND visible==1")
    public MobileElement backBtnMustHaveGrabs;

    @AndroidFindBy(xpath = "//*[contains(@text,'Clip your deals')]//following-sibling::*[contains(@resource-id,'tv_salutation_no_deal')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Clip your deals')]")
    public MobileElement clipYourDealsCount;

    @AndroidFindBy(xpath = "//*[@text='See all']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'btnSeeAllButtonTitle-Clip your deals'")
    public MobileElement seeAllClipYourDeals;

    @AndroidFindBy(xpath = "(//*[contains(@resource-id,'all_coupon_item_root_layout')])[3]")
    @iOSXCUITFindBy(xpath = "(//*[@name='lblCardMediumVerticalNameLabel'])[3]")
    public MobileElement specialDeal;

    @AndroidFindBy(xpath = "//*[@text='Offer Details']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Offer Details\"]")
    public MobileElement specialDealOfferDetails;

    @AndroidFindBy(xpath = "//*[contains(@text,'Eligible Products')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains (@name,\"Eligible Products\")]")
    public MobileElement specialDealEligibleProducts;

    @AndroidFindBy(xpath = "//*[@text='Clip deal']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Clip Deal\"]")
    public MobileElement clipDeal;

    @AndroidFindBy(xpath = "//*[@text='View list']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"View list\"]")
    public MobileElement viewList;

    @AndroidFindBy(xpath = "(//*[contains(@resource-id,'id/cv_my_list_deals_item_overlay')])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"lblMyListDealCellName\"])[1]")
    public MobileElement offerMyList;

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]")
    public MobileElement clippedatlistOnMylist;

}

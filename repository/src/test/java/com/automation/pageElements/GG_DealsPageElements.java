package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_DealsPageElements {

    @AndroidFindBy(accessibility = "For you")
    @iOSXCUITFindBy(iOSNsPredicate = "value BEGINSWITH 'for U Tab'")
    public MobileElement forYouTab;

    //@AndroidFindBy(id = "btnNext")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Next\")")
    @iOSXCUITFindBy(accessibility = "btnNext-Welcome tool tip")
    public MobileElement nextBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Next\")")
    @iOSXCUITFindBy(accessibility = "btnNext-Browse tool tip")
    public MobileElement brosweNextBtn;


    @AndroidFindBy(id = "homeContainerFragment")
    @iOSXCUITFindBy(accessibility = "HOME")
    public MobileElement homeTab;

    @AndroidFindBy(accessibility = "All coupons")
    @iOSXCUITFindBy(iOSNsPredicate = "value BEGINSWITH 'All deals Tab'")
    public MobileElement allDealsTab;

    @AndroidFindBy(accessibility = "Categories")
    @iOSXCUITFindBy(iOSNsPredicate = "value BEGINSWITH 'Categories Tab'")
    public MobileElement categoriesTab;

    @AndroidFindBy(id = "tv_savings_header")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Saving events'")
    public MobileElement savingEventsLabel;

    @AndroidFindBy(accessibility = "BOGO")
    @iOSXCUITFindBy(iOSNsPredicate = "value BEGINSWITH 'BOGO Tab'")
    public MobileElement bogoTab;

    @AndroidFindBy(id = "search_src_text")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='scan']//parent::XCUIElementTypeOther")
    public MobileElement searchBar;

    @AndroidFindBy(accessibility = "Promo")
    @iOSXCUITFindBy(iOSNsPredicate = "value BEGINSWITH 'Promo Tab'")
    public MobileElement promoTab;

    @AndroidFindBy(accessibility = "Expiring soon")
    @iOSXCUITFindBy(iOSNsPredicate = "value BEGINSWITH 'Expiring soon Tab'")
    public MobileElement expiringSoonTab;

    @AndroidFindBy(id = "iv_scan")
    @iOSXCUITFindBy(accessibility = "scan")
    public MobileElement scanButton;

    @AndroidFindBy(id = "ic_back")
    @iOSXCUITFindBy(accessibility = "btnTopNavBarLeft")
    public MobileElement backButton;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[1]/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]")
    public MobileElement firstBOGOCategory;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.Button[1]/android.view.ViewGroup[3]/android.widget.ViewSwitcher[1]/android.widget.TextView[1] | //androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout[1]/android.widget.Button[1]/android.view.ViewGroup[3]/android.widget.ViewSwitcher[1]/android.widget.Button[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeButton[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeButton[1]/XCUIElementTypeButton[1] | //XCUIElementTypeCell[1]/XCUIElementTypeButton[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]")
    public MobileElement firstBOGODealAdd;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.Button[1]/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView[1]/XCUIElementTypeCell[1]/XCUIElementTypeButton[1] | //XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[1]/XCUIElementTypeButton[1]")
    public MobileElement firstBOGOOfferName;

    @AndroidFindBy(accessibility = "search")
    @iOSXCUITFindBy(iOSNsPredicate = "label=='Search products or deals' || label == 'search'")
    public MobileElement searchIcon;

    @AndroidFindBy(id = "tv_search_cancel")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Cancel'")
    public MobileElement cancelButtonOnSearchScreen;

    @AndroidFindBy(id = "progress_indicator")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeOther' AND name == 'Status Loading'")
    public MobileElement progressIndicator;

    @iOSXCUITFindBy(id = "closeGray")
    public MobileElement togglePopUp;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.Button[1]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.Button[1] | //androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout[1]/android.widget.Button[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.Button[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[2]")
    public MobileElement firstBOGOCouponDisplayed;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tab_layout')]//android.widget.TextView[@selected='true']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='imgvHorizontalTitleCVCellSelection' and @visible ='true']//preceding-sibling::*[1]")
    public MobileElement selectedTabDealsNavigator;

    @AndroidFindBy(accessibility = "deals")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Deals' AND visible==1")
    public MobileElement dealsTitleHeader;

    @AndroidFindBy(id = "tv_clipped_added")
    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'Clipped and added' and visible==1")
    public MobileElement couponAddedLabel;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Clipped!\")")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Clip Deal\"]")
    public MobileElement clipAddedLabel;

    @AndroidFindBy(id = "clip_coupon_layout")
    @iOSXCUITFindBy(iOSNsPredicate = "name=='btnCardMediumVerticalButton' AND label BEGINSWITH 'Clip' and visible==1")
    public MobileElement clipButton;

    @AndroidFindBy(id = "image_buy_again")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Buy Again' and visible==1")
    public List<MobileElement> buyAgainLabel;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tv_cart_count') or contains(@resource-id,'tvTotalItemCount')]")
    @iOSXCUITFindBy(id = "btnCartWithBadge")
    public MobileElement myCartCount;

    @AndroidFindBy(id = "clip_coupon_layout")
    @iOSXCUITFindBy(iOSNsPredicate = "name=='btnCardMediumVerticalButton' AND label BEGINSWITH 'Clip' and visible==1")
    public MobileElement clipCoupon;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Dismiss'")
    @AndroidFindBy(xpath = "//*[@text='DISMISS']")
    public MobileElement dismissButton;

    @AndroidFindBy(id = "tv_deal_big_card_sub_header")
    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'imgBackground' AND visible==1")
    public MobileElement promoDealCard;

    @AndroidFindBy(id = "iv_cart")
    @iOSXCUITFindBy(id = "btnCartWithBadge")
    public MobileElement myCart;

    @AndroidFindBy(xpath = "//*[contains(@text,'Items you buy')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Items you buy'")
    public MobileElement ItemYouBuyTitle;

    @AndroidFindBy(id = "tab_layout")
    @iOSXCUITFindBy(xpath = "//*[@label='Deals']/parent:: XCUIElementTypeOther//following-sibling:: XCUIElementTypeOther[1]/XCUIElementTypeCollectionView")
    public MobileElement dealsTopNavBar;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tv_local') or contains(@resource-id,'et_local_search')]")
    @iOSXCUITFindBy(accessibility = "Search bar")
    public MobileElement searchBarTextFieldInDealsTab;

    @AndroidFindBy(id = "tv_local_search_cancel")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Cancel button' AND visible==1")
    public MobileElement searchCancelButton;

    @AndroidFindBy(id = "tv_deal_desc")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalDescritionLabel'")
    public MobileElement dealsDescription;

    @AndroidFindBy(id = "tv_deal_name")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalNameLabel'")
    public MobileElement dealsName;

    @AndroidFindBy(id = "tv_all_deals_total_deal_count")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblItemCount' and visible==1")
    public MobileElement countDealsPage;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblHorizontalTitleCVCellTitle' AND visible==1")
    public List<MobileElement> tabNames;

    @AndroidFindBy(id = "tv_clipped_added")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Clipped and added to list']")
    public MobileElement clippedLabel;

    @AndroidFindBy(id = "tv_view_list")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'View list' AND type == 'XCUIElementTypeButton'")
    public MobileElement viewList;

    @AndroidFindBy(id = "PENDING")
    @iOSXCUITFindBy(iOSNsPredicate = "name =='productCell' and visible ==1")
    public List<MobileElement> prodCellEligibleProducts;

}

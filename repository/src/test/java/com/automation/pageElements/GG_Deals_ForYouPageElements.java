package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GG_Deals_ForYouPageElements {

    @AndroidFindBy(accessibility = "Show all weekly ads")
    @iOSXCUITFindBy(accessibility = "imageMoreServiceBannerImageView-promo")
    public MobileElement weeklyAdBanner;

    @AndroidFindBy(accessibility = "Toggle it. Toggle it real good.")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Toggle it. Toggle it real good.'")
    public MobileElement toggleItWindow;

    @AndroidFindBy(className = "android.widget.ProgressBar")
    @iOSXCUITFindBy(iOSNsPredicate = "type=\"XCUIElementTypeStaticText\" value=\"Loading\"")
    public MobileElement loadingSpinner;

    @AndroidFindBy(accessibility = "Save on your favorites")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value == 'Save on your favorites'")
    public MobileElement saveOnYourFavoriteTitle;

    @AndroidFindBy(id = "iv_promo_banner")
    @iOSXCUITFindBy(accessibility = "imgBackground-0 0")
    public MobileElement PromoDealDealCard;

    @AndroidFindBy(id = "tv_eligible_products")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    public MobileElement eligibleProductsButton;

    @AndroidFindBy(id = "offer_qualifying_products")
    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'Eligible Products'")
    public MobileElement QualifyingProducts;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Eligible Products\")")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Eligible Products'")
    public MobileElement QualifyingProductsPromoDeals;

    @AndroidFindBy(accessibility = "Fresh new coupons")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Fresh new coupons'")
    public MobileElement freshNewCouponsLabel;

    @AndroidFindBy(id = "btn_clip_deal")
    @iOSXCUITFindBy(accessibility = "clipButton")
    public MobileElement clipButtonDefaultDealFreshNewCoupon;

    @AndroidFindBy(id = "cv_dashboard_coupon")
    @iOSXCUITFindBy(accessibility = "couponCollectionView")
    public MobileElement couponCarousel;

    @AndroidFindBy(id = "tv_redeemed_reward_price")
    @iOSXCUITFindBy(xpath = "(//*[@name='selectedCouponView']/XCUIElementTypeStaticText)[1]")
    public MobileElement dealPriceONFreshNewCoupon;

    @AndroidFindBy(id = "tv_redeemed_reward_name")
    @iOSXCUITFindBy(xpath = "(//*[@name='selectedCouponView']/XCUIElementTypeStaticText)[1]")
    public MobileElement dealNameONFreshNewCoupon;

    @AndroidFindBy(id = "tv_redeemed_reward_desc")
    @iOSXCUITFindBy(accessibility = "couponDescriptionLabel")
    public MobileElement dealDescriptionONFreshNewCoupon;

    @AndroidFindBy(id = "tv_redeemed_reward_expiry")
    @iOSXCUITFindBy(accessibility = "couponExpiryLabel")
    public MobileElement dealExpiryONFreshNewCoupon;

    @AndroidFindBy(id = "iv_redeemed_reward_image")
    @iOSXCUITFindBy(accessibility = "selectedCouponView")
    public MobileElement freshNewCouponsDefaultDealImage;

    @AndroidFindBy(id = "coupon_image")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name='imgvFreshNewCouponCellImageView']//parent:: XCUIElementTypeOther//parent:: XCUIElementTypeCell")
    public List<MobileElement> freshNewCouponsCarouselDealImage;

    @AndroidFindBy(id = "cr_weekly_coupon_icon")
    @iOSXCUITFindBy(xpath = "//*[@name='couponCollectionView']/XCUIElementTypeCell")
    public List<MobileElement> freshNewCouponsCarouselDealContainer;

    @AndroidFindBy(id = "cr_weekly_coupon_icon")
    @iOSXCUITFindBy(xpath = "(//*[@name='couponCollectionView']/XCUIElementTypeCell)[1]")
    public MobileElement freshNewCouponsCarouselFirstDeal;

    @AndroidFindBy(id = "rv_favorite_deals")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeCollectionView' AND name == 'collectionDealsCollectionView'")
    public MobileElement CarouselViewSAVEONYOURFAV;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Fresh new coupons\")]//following-sibling::*[contains(@text,\"See all\")]")
    @iOSXCUITFindBy(accessibility = "btnSeeAllButtonTitle-Fresh new coupons")
    public MobileElement seeAllFreshNewCouponsButton;

    @AndroidFindBy(id = "img_my_category_right_arrow")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeImage' AND name == 'categoryImageView-1'")
    public MobileElement categoryName;

    @AndroidFindBy(id = "bottom_sheet_sub_title")
    @iOSXCUITFindBy(accessibility = "lblDealsCount")
    public MobileElement dealCountInFreshNewCouponsDrawer;

    @AndroidFindBy(id = "btn_clip_deal")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Clip deal for' and name == 'btnCardMediumVerticalButton'")
    public MobileElement clipStateOnFreshNewCouponsDrawerDealCard;

    @AndroidFindBy(id = "bottom_sheet_close")
    @iOSXCUITFindBy(accessibility = "btnClose")
    public WebElement crossButtonOnFreshNewCouponsDrawer;

    @AndroidFindBy(id = "tv_redeemed_reward_desc")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalDescritionLabel'")
    public MobileElement dealDescription;

    @AndroidFindBy(id = "tv_redeemed_reward_expiry")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalExpiryLabel'")
    public MobileElement dealExpiry;

    @AndroidFindBy(id = "tv_deal_name")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalNameLabel' AND visible==1")
    public MobileElement dealName;

    @AndroidFindBy(id = "tv_deal_name")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalNameLabel' AND visible==1")
    public List<MobileElement> dealNameList;

    @AndroidFindBy(xpath = "//*[@text='Eligible Products' or @text='Clip deal']")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Coupon Added. View eligible products' OR label BEGINSWITH 'Clip' AND visible==1")
    public MobileElement dealCTAButton;

    @AndroidFindBy(id = "tv_redeemed_reward_name")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalNameLabel'")
    public MobileElement dealNameOnFreshNewCouponBanner;

    @AndroidFindBy(id = "tv_redeemed_reward_name")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalNameLabel'")
    public MobileElement couponNameOnCouponCard;

    @AndroidFindBy(id = "tv_redeemed_reward_price")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalPriceLabel'")
    public MobileElement dealPrice;

    //    @AndroidFindBy(id = "//*[contains(@resource-id,'toolbar_webview')]//android.widget.ImageButton")
    @AndroidFindBy(accessibility = "Back")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Back'")
    public MobileElement backButtonOnWeeklyAddAppIFrame;

    @AndroidFindBy(id = "tv_saving_count")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblDescription'")
    public MobileElement savingEventCardDealCount;

    @AndroidFindBy(id = "tv_savings_header")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Saving events'")
    public MobileElement savingEventCardLabel;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Saving events\")]//following-sibling::*[contains(@text,\"See all\")]")
    @iOSXCUITFindBy(accessibility = "btnSeeAllButtonTitle-Saving events")
    public MobileElement seeAllSavingEvent;

    @AndroidFindBy(id = "tv_savings_header")
    @iOSXCUITFindBy(accessibility = "lblSavingEventsListTitle")
    public MobileElement savingEventDrawerTitle;

    @AndroidFindBy(id = "tv_saving_title")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblSavingEventsCellTitle'")
    public MobileElement savingEventCategoryTitle;

    @AndroidFindBy(id = "tv_saving_title")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblSavingEventsCellTitle'")
    public List<MobileElement> savingEventCategoryTitleList;

    @AndroidFindBy(id = "bottom_sheet_title")
    @iOSXCUITFindBy(accessibility = "lblPageTitle")
    public MobileElement savingEventPageTitle;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Save on your favorites\")]//following-sibling::*[contains(@text,\"See all\")]")
    @iOSXCUITFindBy(accessibility = "btnSeeAllButtonTitle-Save on your favorites")
    public MobileElement seeAllButtonOnSaveYourFavourtiesModule;

    @AndroidFindBy(id = "bottom_sheet_title")
    @iOSXCUITFindBy(accessibility = "lblPageTitle")
    public MobileElement saveYourFavourtiesDrawerTitle;

    @AndroidFindBy(id = "bottom_sheet_close")
    @iOSXCUITFindBy(accessibility = "btnClose")
    public MobileElement closeIconOnSaveYourFavoritesModuleDrawer;

    @AndroidFindBy(id = "tv_category_details_title")
    @iOSXCUITFindBy(id = "lblTopNavBarTitle")
    public MobileElement titleInCategoryDealsDetailsPage;

    @AndroidFindBy(id = "tv_deal_name")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalNameLabel'")
    public MobileElement cardNameInCategoryDealsDetailsPage;

    @AndroidFindBy(id = "tv_clipped_deals_count")
    @iOSXCUITFindBy(accessibility = "lblItemCount")
    public MobileElement offerCountInCategoryDealsDetailsPage;

    @AndroidFindBy(id = "ic_back")
    @iOSXCUITFindBy(accessibility = "btnTopNavBarLeft")
    public MobileElement backButtonOnCategoryDealsDetailsScreen;

    @AndroidFindBy(id = "tv_category_refine | tv_refine")
    @iOSXCUITFindBy(accessibility = "Refine")
    public MobileElement refineButton;

    @AndroidFindBy(id = "btn_close")
    @iOSXCUITFindBy(accessibility = "btnSavingEventsListCrossButton")
    public MobileElement crossButton;

    @AndroidFindBy(id = "btn_close_large")
    @iOSXCUITFindBy(accessibility = "btnSavingEventsListCloseButton")
    public MobileElement closeButton;

    @AndroidFindBy(accessibility = "close")
    @iOSXCUITFindBy(accessibility = "btnClose")
    public MobileElement closeButtonOnSavingEventDetailPage;

    @AndroidFindBy(id = "tv_total_savings_count")
    @iOSXCUITFindBy(accessibility = "lblSavingEventsListEventsCount")
    public MobileElement totalCountOnSavingEventDrawer;

    @AndroidFindBy(id = "tv_saving_count")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblSavingEventsCellDealsCount'")
    public MobileElement dealCountOnSavingEventDrawer;

    @AndroidFindBy(id = "rv_savings_item_list")
    @iOSXCUITFindBy(accessibility = "PENDING")
    public MobileElement carousel;

    @AndroidFindBy(id = "tv_saving_title")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblTitle'")
    public List<MobileElement> allSavingEventCardLabel;

    @AndroidFindBy(id = "clip_coupon_layout")
    @iOSXCUITFindBy(iOSNsPredicate = "name=='btnCardMediumVerticalButton' AND label BEGINSWITH 'Clip' and visible==1")
    public MobileElement clipDeal;

    @AndroidFindBy(id = "deal_detail_container")
    @iOSXCUITFindBy(accessibility = "Offer Details")
    public MobileElement offerTermsConditions;

    @AndroidFindBy(xpath = "//*[@text=\"Earning points\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Earning points\"]")
    public MobileElement earningPoints;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"For U Icon\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"forUBannerImage\"]/XCUIElementTypeOther[2]/XCUIElementTypeOther")
    public MobileElement howDoRewardsWork;

    @AndroidFindBy(id = "offer_terms_text")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Offer Type'")
    public MobileElement offerTermsConditionsText;

    @AndroidFindBy(id = "btn_browse_deals_category")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Deals by category, Browse'")
    public MobileElement dealsByCategoryNavigationCard;

    @AndroidFindBy(id = "btn_browse_all_deals")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'All deals, Browse'")
    public MobileElement allDealsNavigationCard;

    @AndroidFindBy(accessibility = "deals")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Deals'")
    public MobileElement dealsCategoryPage;

    @AndroidFindBy(xpath = "//*[contains(@text,'Items you may like')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Items you may like'")
    public MobileElement itemsYouMayLikeTitle;

    @AndroidFindBy(xpath = "//*[contains(@text,'Items you may buy')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Items you may buy'")
    public MobileElement itemsYouMayBuyTitle;

    @AndroidFindBy(id = "iv_clipped")
    @iOSXCUITFindBy(accessibility = "viewDealClippedTag")
    public MobileElement clippedlabel;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'rv_offers')]//*[contains(@resource-id,'tv_deal_expiry')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[@name=\"collectionDealsCollectionView\"]")
    public List<MobileElement> dealCardContainer;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'rv_offers')]//*[contains(@resource-id,'tv_deal_expiry')]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalExpiryLabel' AND visible==1")
    public MobileElement expiryDateOfItemYouMayLikeModule;

    @AndroidFindBy(id = "itemParentLayoutSeeAll")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='btnSeeAll']")
    public MobileElement seeAllButtonInDealCard;

    @AndroidFindBy(accessibility = "Items you may like See all")
    @iOSXCUITFindBy(accessibility = "btnSeeAllButtonTitle-Items you buy")
    public MobileElement seeAllLinkBesideItemYouMayLikeModule;

    @AndroidFindBy(accessibility = "Items you buy See all")
    @iOSXCUITFindBy(accessibility = "btnSeeAllButtonTitle-Items you buy")
    public MobileElement seeAllLinkBesideItemYouMayBuyModule;

    @AndroidFindBy(id = "bottom_sheet_title")
    @iOSXCUITFindBy(accessibility = "lblPageTitle")
    public MobileElement dealListingPage;

    @AndroidFindBy(accessibility = "close")
    @iOSXCUITFindBy(accessibility = "btnClose")
    public MobileElement closeButtonOnDealListingScreen;

    @AndroidFindBy(accessibility = "Close Offer Details")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeButton")
    public MobileElement closeOfferDetailsPage;

    @AndroidFindBy(accessibility = "Associate offers")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Associate Offers' AND  visible == 1")
    public MobileElement associateOfferModuleTitle;

    @AndroidFindBy(accessibility = "Associate offers See all")
    @iOSXCUITFindBy(accessibility = "btnSeeAllButtonTitle-Associate Offers")
    public MobileElement seeAllLinkBesideAssociateOfferModule;

    @AndroidFindBy(id = "clip_coupon_layout")
    //  @iOSXCUITFindBy(iOSNsPredicate = "name=='btnCardMediumVerticalButton' AND label BEGINSWITH 'Clip'")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Clip'")
    public MobileElement clipButton;

    @AndroidFindBy(id = "iv_search_deals")
    @iOSXCUITFindBy(iOSNsPredicate = "label=='Search'")
    public MobileElement searchIcon;

    @AndroidFindBy(id = "tv_eligible_products")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Coupon Added. View eligible product' and visible==1")
    public MobileElement eligibleProductBtn;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'My rewards')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'My rewards'")
    public MobileElement myRewardsLink;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Clipped deals')]")
    @iOSXCUITFindBy(accessibility = "View Clipped deals")
    public MobileElement clippedDealsLink;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Weekly ad')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Weekly Ads'")
    public MobileElement weeklyAdLink;

    @AndroidFindBy(accessibility = "For you")
    @iOSXCUITFindBy(iOSNsPredicate = "value BEGINSWITH 'for U Tab'")
    public MobileElement forYouTab;

    @AndroidFindBy(id = "btn_clipped_deals_explore")
    @iOSXCUITFindBy(accessibility = "btnClippedEmptyState")
    public MobileElement exploreDealsbtn;

    @AndroidFindBy(accessibility = "Back")
    @iOSXCUITFindBy(accessibility = "btnTopNavBarLeft")
    public MobileElement backButtonOnClippedDealsScreen;

    @AndroidFindBy(id = "dealsContainerFragment")
    @iOSXCUITFindBy(id = "DEALS")
    public MobileElement dealsTab;

    @AndroidFindBy(id = "tv_welcome_card_action_got_it")
    public MobileElement gotItFirstDibsDeal;

    @AndroidFindBy(id = "bottom_sheet_close")
    @iOSXCUITFindBy(accessibility = "btnClose")
    public MobileElement crossButtonOnDrawer;


    @AndroidFindBy(xpath = "//*[@content-desc=\"Back\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Back\"] | //*[@label=\"backArrow\"]")
    public MobileElement backButtonOnWeeklyAdsPage;

/*    @AndroidFindBy(id = "tv_eligible_products")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Coupon Added. View eligible product' and visible==1")
    public MobileElement eligibleProductBtn;*/

    @AndroidFindBy(id = "btn_add_to_list")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Clip Deal' and enabled ==1")
    public MobileElement clipDealBtnDealsDetails;

}

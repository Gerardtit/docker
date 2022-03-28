package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_WalletPageElements {

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"MEMBER\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'WALLET' OR name == 'MEMBER'")
    public MobileElement memberTab;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Wallet\"]/android.widget.TextView")
    @iOSXCUITFindBy(iOSNsPredicate = "value BEGINSWITH 'Wallet Tab' AND visible==1")
    public MobileElement walletTab;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Wallet\"])")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Wallet Tab'")
    public MobileElement walletHeader;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"tv_redeemed_history_title\")]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Wallet\"]")
    public MobileElement walletTittle;

    @AndroidFindBy(id = "category_chip")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Category selected'")
    public MobileElement viewProducts;

    @AndroidFindBy(id = "contactless_pay_bg")
    @iOSXCUITFindBy(accessibility = "buttonBannerMediumIllustration")
    public List<MobileElement> contactlessPaybanner;

    @AndroidFindBy(id = "rewards_count_tv")
    @iOSXCUITFindBy(accessibility = "viewClippedRewardsButtonView")
    public MobileElement zeroClippedRewards;

    @AndroidFindBy(id = "loyalty_card")
    @iOSXCUITFindBy(accessibility = "imgvCardViewImage")
    public MobileElement loyaltyCardTitle;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Pay Card\"])")
    @iOSXCUITFindBy(xpath = "//*[@name='lbltitleLabel' and @value='Pay Card']")
    public MobileElement payCardTitle;

    @AndroidFindBy(id = "loyalty_qr_code")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Loyalty QR code'")
    public MobileElement loyaltyCardQRCode;

    @AndroidFindBy(id = "loyalty_card_text")
    @iOSXCUITFindBy(accessibility = "imgvCardViewImage")
    public MobileElement loyaltyCardInfoText;

    @AndroidFindBy(accessibility = "You clipped 0 Deals")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'You clipped 0 Deals' AND visible==1")
    public MobileElement zeroClippedDeals;

    @AndroidFindBy(id = "contactless_pay_bg")
    @iOSXCUITFindBy(accessibility = "buttonBannerMediumIllustration")
    public MobileElement setupContactlessPayBannerWallet;

    @AndroidFindBy(xpath = "//*[@class='androidx.recyclerview.widget.RecyclerView']//*[@class='android.view.ViewGroup'][2]")
    @iOSXCUITFindBy(accessibility = "buttonBannerMediumIllustration")
    public MobileElement setupContactlessPayBannerAccount;

    @AndroidFindBy(id = "deals_count_tv")
    @iOSXCUITFindBy(id = "viewClippedDealsButtonView")
    public MobileElement clippedDealsCount;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Clipped rewards\"])")
    @iOSXCUITFindBy(iOSNsPredicate = "label contains 'Clipped rewards'")
    public MobileElement clippedRewardsTitle;

    @AndroidFindBy(id = "cl_rewards")
    @iOSXCUITFindBy(accessibility = "viewClippedRewardsButtonView")
    public MobileElement clippedRewardsTile;

    @AndroidFindBy(id = "tv_redeemed_history_title")
    @iOSXCUITFindBy(accessibility = "lblTopNavBarWithHintTitle")
    public MobileElement clippedRewards;

    @AndroidFindBy(id = "btn_redeemed_reward_clipped")
    @iOSXCUITFindBy(accessibility = "btnCardMediumVerticalButton")
    public MobileElement clippedBtn;

    @AndroidFindBy(id = "tv_redeemed_reward_expiry")
    @iOSXCUITFindBy(accessibility = "lblCardMediumVerticalExpiryLabel")
    public MobileElement enjoyByDate;

    @iOSXCUITFindBy(accessibility = "btnTopNavBarWithHintLeft")
    public MobileElement backToWallet;

    @AndroidFindBy(xpath = "//*[@text='Clipped deals']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label BEGINSWITH 'Clipped deals Tab' and visible==1")
    public MobileElement clippedDealsTitle;

    @AndroidFindBy(id = "cl_deals")
    @iOSXCUITFindBy(accessibility = "viewClippedDealsButtonView")
    public MobileElement clippedDealsTile;


    @AndroidFindBy(xpath = "//*[@text='Clipped deals']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label BEGINSWITH 'Clipped deals Tab' and visible==1")
    public MobileElement clippedDeals;

    @AndroidFindBy(id = "btn_clipped_deals_explore")
    @iOSXCUITFindBy(accessibility = "btnClippedEmptyState")
    public MobileElement exploreDealsbtn;

    @AndroidFindBy(id = "btn_clip_deal")
    @iOSXCUITFindBy(accessibility = "btnCardMediumVerticalButton")
    public MobileElement viewProductBtn;

    @AndroidFindBy(id = "tv_eligible_products")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Coupon Added. View eligible product' and visible==1")
    public MobileElement eligibleProductBtn;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Eligible Products\"])")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Coupon Added. View eligible product' and visible==1")
    public MobileElement eligibleProducttxt;

    @AndroidFindBy(id = "tv_clipped_deals_count")
    @iOSXCUITFindBy(id = "lblItemCount")
    public MobileElement countOfClippedDeals;

    @AndroidFindBy(id = "tv_redeemed_reward_count")
    @iOSXCUITFindBy(accessibility = "lblTopNavBarWithHintHint")
    public MobileElement countOfClippedRewards;

    @AndroidFindBy(id = "rewards_count_tv")
    @iOSXCUITFindBy(id = "viewClippedRewardsButtonView")
    public MobileElement clippedRewardsCount;

    @AndroidFindBy(id = "tv_clipped_deals_count")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblItemCount' and visible==1")
    public MobileElement countClippedDealsPage;

    @AndroidFindBy(id = "tv_deal_name")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalNameLabel' and visible==1")
    public MobileElement clippedDealName;

    @AndroidFindBy(id = "tv_deal_name")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalNameLabel' and visible==1")
    public List<MobileElement> clippedDealNameList;

    @AndroidFindBy(id = "ivOfferContent")
    @iOSXCUITFindBy(accessibility = "Offer Terms and Conditions")
    public MobileElement dealDetailPageTitle;

    @AndroidFindBy(id = "imgClose")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeStaticText/following-sibling::XCUIElementTypeButton")
    public MobileElement xButtonInSetUpContactLess;

    @AndroidFindBy(id = "tv_deal_name")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalNameLabel'")
    public MobileElement monopolyDealCard;

    @AndroidFindBy(id = "deal_detail_container")
    @iOSXCUITFindBy(accessibility = "Offer Details")
    public MobileElement offerTermsAndConditionCTA;

    @AndroidFindBy(xpath = "//*[@text=\"DISMISS\"]")
    @iOSXCUITFindBy(accessibility = "Dismiss")
    public MobileElement dismissCTA;

    @AndroidFindBy(xpath = "//*[contains(@text,'LATER')]")
    @iOSXCUITFindBy(accessibility = "Maybe Later")
    public MobileElement updateLater;

    @AndroidFindBy(id = "btnNext")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"NEXT\" AND name == \"NEXT\" AND type == \"XCUIElementTypeButton\"")
    public MobileElement nextButtonSetUpContactlessPay;

    @AndroidFindBy(xpath = "//*[@text='Allow' or @text='ALLOW' or @text='Allow all the time' or @text='Allow only while using the app']")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Allow While Using App\"")
    public MobileElement allowLocationWhileUsingApp;

    @AndroidFindBy(id = "btnNext")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"GET STARTED\" AND name == \"GET STARTED\" AND type == \"XCUIElementTypeButton\"")
    public MobileElement getStartedSetUpContactlessPay;

    @AndroidFindBy(id = "tv_cart_count")
    @iOSXCUITFindBy(accessibility = "btnCartWithBadge")
    public MobileElement myCartCount;

    @AndroidFindBy(id = "homeContainerFragment")
    @iOSXCUITFindBy(accessibility = "HOME")
    public MobileElement homeTab;

    @AndroidFindBy(id = "tv_clipped_deals_category_name")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='dealsCell']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'dealsCell'")
    public List<MobileElement> clippedDealsCategories;

    @AndroidFindBy(id = "tv_deal_name")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='lblCardMediumVerticalNameLabel']")
    public List<MobileElement> clippedDealsNameLabelCard;

    @AndroidFindBy(id = "tv_clipped_deals_category_count")
    public List<MobileElement> clippedDealsCategoryCount;

    @AndroidFindBy(id = "tv_clipped_deals_category_name")
    public List<MobileElement> clippedDealsCategoryName;

    @AndroidFindBy(id = "tv_deal_name")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalNameLabel' AND visible==1")
    public MobileElement dealTitle;

    @AndroidFindBy(id = "tv_deal_desc")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalDescritionLabel' AND visible==1")
    public MobileElement dealDescription;

    @AndroidFindBy(id = "tv_deal_expiry")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalExpiryLabel' AND visible==1")
    public MobileElement dealExpiry;

    @AndroidFindBy(id = "btn_clipped_deals_see_all")
    @iOSXCUITFindBy(id = "viewClippedDealsButtonView")  //Need to update See All button
    public MobileElement seeAllCTADeals;

    @AndroidFindBy(id = "btn_clipped_rewards_see_all")
    @iOSXCUITFindBy(id = "viewClippedRewardsButtonView")  //Need to update See All button
    public MobileElement seeAllCTARewards;

    @AndroidFindBy(id = "all_coupon_item_root_layout")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalExpiryLabel'")
    public MobileElement dealCardInClippedDealsCategoriesDetailPage;

    @AndroidFindBy(id = "tv_clipped_deals_count")
    @iOSXCUITFindBy(accessibility = "lblItemCount")
    public MobileElement clippedDealsCountInClippedDealsCategoriesDetailPage;

    @AndroidFindBy(id = "tvCenterTitle")
    @iOSXCUITFindBy(accessibility = "lblTopNavBarTitle")
    public MobileElement dealCategoryTitleInClippedDealsCategoriesDetailPage;

    @AndroidFindBy(accessibility = "back button to take you back")
    @iOSXCUITFindBy(accessibility = "btnTopNavBarLeft")
    public MobileElement backButtonOnClippedDealsCategoriesDetailPage;

    @AndroidFindBy(id = "offer_terms_text")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Offer Type'")
    public MobileElement offerTypeDetailsDisclaimer;

    @AndroidFindBy(accessibility = "Close Offer Details")
    @iOSXCUITFindBy(accessibility = "CloseOffer Details")
    public MobileElement closeDealDetailsPage;

    @AndroidFindBy(id = "btnInfo")
    @iOSXCUITFindBy(xpath = "//*[contains(@label, \"See in Wallet\")]")
    public MobileElement seeInWalletBtn;

    @AndroidFindBy(id = "iv_cart")
    @iOSXCUITFindBy(id = "btnCartWithBadge")
    public MobileElement myListIcon;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='My List'])")
    @iOSXCUITFindBy(iOSNsPredicate = "value == 'My List'")
    public MobileElement myListPage;

    @AndroidFindBy(id = "body")
    @iOSXCUITFindBy(iOSNsPredicate = "PENDING")
    public MobileElement whereIsMyaddedCouponsMessage;

    @AndroidFindBy(xpath = "//*[@text=\"Show rewards\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Show rewards')]")
    public MobileElement showRewardsButton;

    @AndroidFindBy(id = "loading_tv")
    @iOSXCUITFindBy(xpath = "//*[@label=\"If you have past purchases, they’ll show up in your account shortly. For new shoppers, “Buy it again” helps you shop from past orders quickly and easily.\"]")
    public MobileElement buyItAgainIsEmptyTxt;

    @AndroidFindBy(xpath = "//*[@text='Offer Details']")
    @iOSXCUITFindBy(xpath = "//*[@name='Offer Details']")
    public MobileElement offerDetailsLabel;


    @AndroidFindBy(xpath = "//*[@text='Offer Details']")
    @iOSXCUITFindBy(xpath = "//*[@name='Offer Details']")
    public MobileElement seeallatyourclipped;


}












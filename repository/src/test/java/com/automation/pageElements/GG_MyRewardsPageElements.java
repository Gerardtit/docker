package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_MyRewardsPageElements {

    @AndroidFindBy(xpath = "//*[@content-desc=\"Button for Rewards\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'lblRewardsTitle')]|//XCUIElementTypeButton[11][@label=\"View Rewards, 3 of 6\"]")
    public MobileElement rewardLink;

    @AndroidFindBy(xpath = "//*[@text=\"DISMISS\"]")
    @iOSXCUITFindBy(id = "Dismiss")
    public MobileElement dismissCTA;

    @AndroidFindBy(className = "android.widget.ProgressBar")
    @iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeStaticText' AND value='Loading'")
    public MobileElement loadingSpinner;


    @AndroidFindBy(xpath = "//*[contains(@resource-id , \"tv_rewards_header\")]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Rewards Tab, 1 of 4\"]")
    public MobileElement rewardTitle;


    @AndroidFindBy(xpath = "//*[@text=\"Rewards\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Rewards\"")
    public MobileElement rewardsButton;

    @AndroidFindBy(id = "iv_reward_info")
//    TechDebt Locator below
//    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Info' AND visible==1")
//    UMA Master Locator below
    @iOSXCUITFindBy(accessibility = "btnTopNavBarRight")
    public MobileElement rewardInfo;

    @AndroidFindBy(id = "tvRewardScorecardTitle")
    @iOSXCUITFindBy(accessibility = "rewardsSection")
    public MobileElement rewardBalance;

    @AndroidFindBy(id = "tv_balance_available")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]")

    //@iOSXCUITFindBy(iOSNsPredicate = "type =='XCUIElementTypeOther' and name=='rewardsSection'")
    public MobileElement rewardBalanceZero;


    @iOSXCUITFindBy(accessibility = "btnTopNavBarWithHintLeft")

    public MobileElement backButton;

    @AndroidFindBy(id = "tv_balance_expiring")
    @iOSXCUITFindBy(accessibility = "expirySection")
    public MobileElement expiringDate;

    @AndroidFindBy(id = "tv_reward_expiry")
    @iOSXCUITFindBy(iOSNsPredicate = "name == \"lblCardMediumVerticalExpiryLabel\" and visible==1")
    public MobileElement rewardExpiryDate;


    @AndroidFindBy(id = "tv_title_reward_balance")
    //  @iOSXCUITFindBy(accessibility = "lblRewardTitle")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeOther' AND label BEGINSWITH 'Rewards'")
    public MobileElement rewardBalanceText;

    @AndroidFindBy(id = "tv_title_reward_expiring")
    //@iOSXCUITFindBy(accessibility = "lblRewardExpiryTitle")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeOther[3]")
    public MobileElement ExpiringDateText;


    @AndroidFindBy(id = "pb_reward_point_progress")
    @iOSXCUITFindBy(accessibility = "lblRewardPointValue")
    public MobileElement rewardsProgressBar;

    @AndroidFindBy(id = "pb_reward_point_progress")
    @iOSXCUITFindBy(accessibility = "viewRewardProgress")
    public List<MobileElement> rewardsProgressBarList;

    @AndroidFindBy(id = "tv_more_points_header")
    @iOSXCUITFindBy(accessibility = "More points, please; Learn how to earn.")
    public MobileElement faqDescription;

    @AndroidFindBy(id = "tv_more_points_header")
    @iOSXCUITFindBy(iOSNsPredicate = "accessibility = 'lblTitleMorePointsView' AND visible = 'true'")
    public List<MobileElement> faqDescriptionList;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'FAQ') or contains(@resource-id,'btn_points_faq')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'FAQ') or contains(@name,'btnGoToFaqMorePointsView')]")
    public MobileElement faqButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Rewards FAQ\"]")
    //@iOSXCUITFindBy(accessibility = "Rewards FAQ")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Rewards FAQ'")
    public MobileElement faqPageTitle;

    @AndroidFindBy(id = "tv_more_rewards_header")
    @iOSXCUITFindBy(iOSNsPredicate = "type =='XCUIElementTypeOther' and name=='Points become rewards; We’ll show you how.'")
    public MobileElement programDetailsDescription;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Program Details heading']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Program Details'")
    public MobileElement programDetailsPageTitle;

    @AndroidFindBy(id = "tv_reward_name")
    @iOSXCUITFindBy(iOSNsPredicate = "name == \"lblCardMediumVerticalNameLabel\" and visible==1")
    public List<MobileElement> rewardName;

    @AndroidFindBy(id = "tv_reward_desc")
    @iOSXCUITFindBy(iOSNsPredicate = "name == \"lblCardMediumVerticalDescritionLabel\" and visible==1")
    public List<MobileElement> rewardDescription;

    @AndroidFindBy(id = "tv_reward_desc")
    @iOSXCUITFindBy(iOSNsPredicate = "name == \"lblCardMediumVerticalDescritionLabel\" and visible==1")
    public MobileElement firstRewardDescription;

    @AndroidFindBy(id = "carousel_list")
    public MobileElement rewardCardCarousel;

    @AndroidFindBy(id = "image_buy_again")
    @iOSXCUITFindBy(iOSNsPredicate = "name == \"viewCardMediumVerticalBuyAgainView\" and visible==1")
    public List<MobileElement> rewardCountTag;

    //@AndroidFindBy(id = "btn_redeem_reward")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Clip']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'btnCardMediumVerticalButton' AND label=='Clip Reward for'")
    public MobileElement clipRewardsNeedRewardsButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Clipped']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'btnCardMediumVerticalButton' AND label CONTAINS 'clipped'")
    public MobileElement clippedRwardsButton;

    @AndroidFindBy(id = "tv_reward_last_updated")
    @iOSXCUITFindBy(accessibility = "lblUpdatedValue")
    public MobileElement updatedTime;


    @AndroidFindBy(xpath = "(//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2])[2]\n")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Use your rewards to save at the pump' OR label == 'Use your points to save with gas rewards'")
    public MobileElement gasRewardsLink;

    @AndroidFindBy(id = "tv_rewards_header")
    @iOSXCUITFindBy(accessibility = "You’ve earned it; Clip your rewards now.")
    public MobileElement youHaveEarned;

    @AndroidFindBy(id = "tv_reward_price")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalPriceLabel'")
    public MobileElement rewardCardDiscountTitle;

    @AndroidFindBy(id = "tv_reward_desc")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalDescritionLabel'")
    public MobileElement rewardCardDescription;

    @AndroidFindBy(id = "tv_reward_expiry")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalExpiryLabel'")
    public MobileElement rewardCardExpiryDate;

    @AndroidFindBy(id = "tv_reward_name")
    @iOSXCUITFindBy(accessibility = "lblCardMediumVerticalNameLabel")
    public MobileElement rewardCardSubjectLine;


    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tv_see_all') or contains(@resource-id,'show_all_rewards')]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'See all' || type == 'XCUIElementTypeStaticText' AND label == 'See all rewards'")
    public MobileElement seeAllRewardButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Clip Rewards']")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Clip Rewards\" and name == \"lblTopNavBarWithHintTitle\"")
    public MobileElement title;

    @AndroidFindBy(id = "bottom_home_navigation")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTabBar")
    public MobileElement navigationBar;

    @AndroidFindBy(id = "iv_back")
    @iOSXCUITFindBy(accessibility = "btnTopNavBarWithHintLeft")
    public MobileElement backToMyReward;

    @AndroidFindBy(id = "tv_rewards_title")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == '10 Rewards'")
    public List<MobileElement> rewardList;

    @AndroidFindBy(id = "btn_redeem_reward")
    @iOSXCUITFindBy(accessibility = "btnRedeemButton")
    public MobileElement clipNeedRewardsButtonRewardDetails;

    @AndroidFindBy(id = "btn_redeem_reward")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'btnCardMediumVerticalButton'")
    public MobileElement rewardCardClipButtonClipRewards;


    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Clip your rewards now.\"])")
    @iOSXCUITFindBy(accessibility = "You’ve earned it; Clip your rewards now.")
    public MobileElement clipYourRewardsSubTitle;

    @AndroidFindBy(id = "btn_redeemed_reward_clipped")
    @iOSXCUITFindBy(accessibility = "btnCardMediumVerticalButton")
    public MobileElement clippedBtn;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Reward')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='lblHorizontalTitleCVCellTitle']")
    public MobileElement rewardCategory;

    @AndroidFindBy(accessibility = "4 Rewards")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH '4 Rewards'")
    public MobileElement fourRewardsCategory;

    @AndroidFindBy(accessibility = "close")
    @iOSXCUITFindBy(accessibility = "btnClose")
    public MobileElement drawerCloseButton;


    @AndroidFindBy(xpath = "//*[@content-desc=\"Button for Rewards\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeButton[8]")
    public MobileElement myRewardsLink;

    @AndroidFindBy(id = "iv_rewards_image")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblCardMediumVerticalExpiryLabel'")
    public MobileElement rewardsImage;

    @AndroidFindBy(id = "tv_see_all")
    @iOSXCUITFindBy(xpath = "//*[@value='See all']")
    public MobileElement seeAllRewardsBtnInMyRewardsPage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Clip Rewards']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Clip Rewards'")
    public MobileElement clipRewardsScreenTitle;

    @AndroidFindBy(id = "chevron")
    @iOSXCUITFindBy(iOSNsPredicate = "PENDING")
    public MobileElement rightArrowBtnInClipRewardsScreen;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'rewards_tab_bar')]//android.widget.LinearLayout[contains(@content-desc,'Rewards')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='lblHorizontalTitleCVCellTitle']")
    public List<MobileElement> rewardTypes;

    @iOSXCUITFindBy(iOSNsPredicate = "type== 'XCUIElementTypeButton' AND name == 'btnCardMediumVerticalButton' AND label ENDSWITH 'clipped'")
    @AndroidFindBy(id = "btn_redeem_reward")
    public MobileElement clippedBtnInMyRewardsDetailScreen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@label,'clipped')]")
    public MobileElement clippedBtnInCarouselInMyRewardsScreen;

    @AndroidFindBy(id = "btn_redeem_reward")
    @iOSXCUITFindBy(accessibility = "btnRedeemButton")
    public MobileElement clipRewardsButtonRewardDetails;

    @AndroidFindBy(xpath = "//*[@text='Clipped rewards']")
    @iOSXCUITFindBy(xpath = "//*[@label='Clipped rewards']")
    public MobileElement clippedRewardsScreenHeading;

    @AndroidFindBy(id = "tv_redeemed_reward_count")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Total clipped')]")
    public MobileElement totalClippedReward;


    @iOSXCUITFindBy(xpath = "//*[contains(@value,\"will be redeemed\")]")
    @AndroidFindBy(xpath = "//*[contains(@text,'will be redeemed')]")
    public MobileElement rewardsPopUp;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Continue\"]")
    @AndroidFindBy(xpath = "//*[(@text='CONTINUE')]")
    public MobileElement rewardsPopUpContinue;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Cancel\"]")
    @AndroidFindBy(xpath = "//*[@resource-id=\"android:id/button2\"]|//*[(@text='CANCEL')]")
    public MobileElement rewardsPopUpCancel;


    @AndroidFindBy(id = "clRewardScorecard")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeOther' AND name BEGINSWITH 'Shop to earn rewards' || type == 'XCUIElementTypeOther' AND name BEGINSWITH 'You have '")
    public MobileElement rewardsBar;

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Close'")
    public MobileElement closeButton;

    @AndroidFindBy(xpath = "//*[contains(@text,'U™ Program FAQs')]")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeStaticText' and contains(@label,'U™ Program FAQs')]")
    public MobileElement faqPage;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Earning points\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label =='Earning points' AND type == 'XCUIElementTypeStaticText' AND visible==1")
    public MobileElement programDetailsForU;

    @AndroidFindBy(id = "tvPointsSummary")
    @iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS 'expiring in' AND visible==1 || name CONTAINS 'Start spending to' AND visible==1 || name CONTAINS 'expiring at' AND visible==1")
    public MobileElement rewardPointsSummary;

    @iOSXCUITFindBy(iOSNsPredicate = "name =='Done'")
    public MobileElement doneButton;

    @AndroidFindBy(id = "tv_rewards_header")

    @iOSXCUITFindBy(accessibility = "Grocery Rewards; Spend rewards before they expire!")
    public MobileElement rewardsForUCarouselHeader;

    @AndroidFindBy(id = "tv_rewards_redeem_desc")
    @iOSXCUITFindBy(accessibility = "Grocery Rewards; Spend rewards before they expire!")
    public MobileElement rewardsForUCarouselSubHeader;


    @iOSXCUITFindBy(xpath = "//*[@label='back']")
    public MobileElement back;

    @AndroidFindBy(xpath = "//*[@text='Clip Rewards']")
    @iOSXCUITFindBy(xpath = "//*[@label='Clip Rewards']")
    public MobileElement rewardsGalleryHeader;


}


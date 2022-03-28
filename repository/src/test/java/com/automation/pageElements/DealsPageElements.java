package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class DealsPageElements {

    //deals title
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Deals' AND visible == 1")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"debug:id/title\")]")
    public MobileElement dealPageTitle;

    //top promo code deals with picture
    @AndroidFindBy(accessibility = "PROMO CODE DEAL")
    @iOSXCUITFindBy(id = "dealer_container")
    public MobileElement topDealItem;

    //promo code deals
    @AndroidFindBy(id = "promo_code_deals_tv")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Promo Code Deals'")
    public MobileElement promoCodeDeal;

    //club card specials
    @AndroidFindBy(id = "club_card_specials_tv")
    @iOSXCUITFindBy(accessibility = "Club Card Specials")
    public MobileElement clubCardSpecials;

    //buy one get one free
    @AndroidFindBy(id = "bogo_tv")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Buy One Get One Free'")
    public MobileElement buyOneGetOneFree;

    //back button
    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Deals\"])[1]")
    public MobileElement backButton;

    //promo code deal title
    @AndroidFindBy(id = "tvTitle") //text = "Promo Code Deals"
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Promo Code Deals' AND visible == 1")
    public MobileElement promoCodeTitle;

    //club card specials title
    @AndroidFindBy(id = "tvTitle") //text = "Club Card Specials"
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Club Card Specials' AND visible == 1")
    public MobileElement clubCardSpecialsTitle;

    //buy one get one free title
    @AndroidFindBy(id = "tvTitle")  //text = "Buy One, Get One Free"
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Buy One, Get One Free' AND visible == 1")
    public MobileElement buyOneGetOneTitle;

    // No Results found
    @iOSXCUITFindBy(xpath = "//*/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, \"tv_no_results_found\")]")
    public MobileElement verifyNoResultsFound;

    //search icon on the top right corner
    @AndroidFindBy(id = "menu_search")
    @iOSXCUITFindBy(accessibility = "Search")
    public WebElement searchIcon;

    //search bar
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"iv_search\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeSearchField[2]|//*[@label=\"Search bar\"]")

    public MobileElement searchBar;

    // Cancel CTA on the left of search bar
    @iOSXCUITFindBy(xpath = "//*[@label=\"Cancel button\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, \"tv_local_search_cancel\")]")
    public MobileElement cancelCTA;


    // default text in search bar
    @iOSXCUITFindBy(xpath = "//*[@value=\"Search within deals\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Search within deals\"]")
    public MobileElement searchBarDefaultText;

    // Verify search deals results
    @iOSXCUITFindBy(className = "XCUIElementTypeButton")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"tv_deal_name\")]|//*[contains(@resource-id,\"tv_deal_price\")]")
    public MobileElement verifySearchDeals;


    // For You Tab
    @AndroidFindBy(xpath = "//*[@text=\"For you\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"For you\")]")
    public MobileElement forYouTab;


    // Categories Tab
    @AndroidFindBy(xpath = "//*[@text=\"Categories\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Categories\")]")
    public MobileElement categoriesTab;

    //Expiring Soon Tab
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Expiring soon\")]")
    @AndroidFindBy(xpath = "//*[@text=\"Expiring soon\"]")
    public MobileElement expiringSoonTab;

    // Promo Tab
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Promo Tab\")]")
    @AndroidFindBy(xpath = "//*[@text=\"Promo\"]")
    public MobileElement promoTab;

    // BOGO Tab
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"BOGO Tab\")]")
    @AndroidFindBy(xpath = "//*[@text=\"BOGO\"]")
    public MobileElement bogoTab;


    // tap on search and verify deals count displayed
    @iOSXCUITFindBy(xpath = "//*[@name=\"lblItemCount\"]|//*[@name=\"lblRefineTableHeaderViewTitle\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, \"tv_all_deals_total_deal_count\")]")
    public MobileElement dealsCountDisplayed;


    // Deals
    @iOSXCUITFindBy(xpath = "//*[@label=\"Clip deal for\" and @value=\"Item 4 headline\"]")
    public MobileElement Deals;

    // All pills
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'deals_sort_filter_pills')]")
    @iOSXCUITFindBy(className = "XCUIElementTypeCollectionView")
    public MobileElement showAllPills;
    // All pills
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"debug:id/all_chip\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Show All Deals\")]")
    public MobileElement allDealsPill;

    // Expiring Soon Pills
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"debug:id/expiring_soon_chip\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Show Expiring soon Deals\")]")
    public MobileElement expiringSoonDealsPill;

    // New Pills
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"debug:id/new_chip\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Show New Deals\")]")
    public MobileElement newDealsPill;

    // Recommended pills
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"debug:id/recommended_chip\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Show Recommended Deals\")]")
    public MobileElement recommendedDealsPill;

    // Coupon centre Pills
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"debug:id/coupon_center_chip\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Show Coupon center Deals\")]")


    //All Deals
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"All deals\")]")
    @AndroidFindBy(xpath = "//*[@text=\"All deals\"]")
    public MobileElement AllDeals;


    // Refine Button
    @iOSXCUITFindBy(xpath = "//*[@name=\"btnRefine\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"debug:id/tv_category_refine\")]")
    public MobileElement clickOnRefineButton;

    // Refine Tab Displayed
    @iOSXCUITFindBy(xpath = "(//*[@label=\"Refine\"])[1]")
    @AndroidFindBy(xpath = "//*[@text=\"Refine\"]")
    public MobileElement refineTabDisplayed;

    //Show Result Button
    @iOSXCUITFindBy(xpath = "//*[@name=\"btnRefineShowResults\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"debug:id/btn_refine_coupon_show_result\")]")
    public MobileElement showResultButton;

    // Newest Option
    @iOSXCUITFindBy(xpath = "//*[@label=\"Newest\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"debug:id/rb_refine_coupons_newest\")]")
    public MobileElement newestOptionEnabled;

    // Expiring Soon Option
    @AndroidFindBy(xpath = "//*[@text=\"Expiring Soon\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Expiring Soon\"]")
    public MobileElement expiringSoonOptionEnabled;

    // All Deals Option
    @iOSXCUITFindBy(xpath = "//*[@label=\"All deals\"]")
    @AndroidFindBy(xpath = "//*[@text=\"All deals\"]")
    public MobileElement AllDealsOptionEnabled;

    // pill selection
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"selected\")]")
    @AndroidFindBy(xpath = "//*[contains(@text,\"selected\")]")
    public MobileElement verifyPillSelection;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"All deals Tab\")] ")
    @AndroidFindBy(xpath = "//*[@text=\"All deals\"]")
    public MobileElement Alldealstab;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Show Expiring soon Deals\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,\"Expiring soon\")]")
    public MobileElement Expiring_soon_pills;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Show New Deals\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,\"New\")]")
    public MobileElement New_pills;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Show Recommended Deals\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,\"Recommended\")]")
    public MobileElement Recommended_pills;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Show Coupon center Deals\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,\"Coupon center\")]")
    public MobileElement Coupon_center_pills;

    //click Search in deals page
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Search bar\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.EditText")
    public MobileElement clickDealsearch;

    //click cancel in deals page
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Cancel button\"])[2]")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Cancel\"]")
    public MobileElement cancelatdeal;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"lblRefineTableHeaderViewTitle\"]")
    @AndroidFindBy(id = "tv_all_deals_total_deal_count")
    public MobileElement dealscountnumber;


    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Items you may like See all\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value=\"Items you may like\"]")
    public MobileElement dealsItemsyoulike;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Items you may like See all\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"See all\"]")
    public MobileElement dealsSeeAllCTA;


    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Items you may like See all\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    public MobileElement expiringdeal;

    @AndroidFindBy(xpath = "androidx.recyclerview.widget.RecyclerView/android.widget.Button[1]/android.view.View[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"lblCardMediumVerticalExpiryLabel\"])[1]/following-sibling::XCUIElementTypeButton")
    public MobileElement addedAtDeal;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.Button[1]/android.view.View[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"btnCardMediumVerticalButton\"])[1]")
    public MobileElement firstcoupon;

}

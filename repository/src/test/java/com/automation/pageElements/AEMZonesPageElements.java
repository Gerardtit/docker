package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class AEMZonesPageElements {


    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"viewStepperView\")]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Add\")")
    public MobileElement addCTA_LandingPage;

    //  @iOSXCUITFindBy(xpath = "//*[@value=\"CTA LP\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"LP\")]")
//   @iOSXCUITFindBy(iOSNsPredicate = "value == \"CTA LP\"")
    //  @AndroidFindBy(xpath = "//*[@content-desc=\"LP banner CTA LP\"]")
    @AndroidFindBy(id = "tv_aem_card_open_app")
    public MobileElement carouselLPACTAHomePage;

    //  @iOSXCUITFindBy(xpath = "//*[@label=\"landing Page linked Banner\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"landing Page\")]")
    // @iOSXCUITFindBy(iOSNsPredicate = "label == \"landing Page linked Banner\"")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"landing Page linked Banner\")")
    public MobileElement carouselLPASubTitleHomePage;

    //  @iOSXCUITFindBy(xpath = "//*[@label=\"LP banner\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"LP banner\")]")
    // @iOSXCUITFindBy(iOSNsPredicate = "label == \"LP banner\"")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"LP banner\")")
    public MobileElement carouselLPATitleHomePage;

    //  @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[4]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Carousel Title\")]")
    @AndroidFindBy(id = "tv_salutation_header")
    public MobileElement carouselTitleHomePage;

    //  @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Carousel Title\")]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblSeeAllTitle' AND visible == 1")
    @AndroidFindBy(id = "tv_salutation_header")
    public MobileElement carouselTitle;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblSeeAllSubTitle' AND visible == 1")
    @AndroidFindBy(id = "tv_salutation_wish")
    public MobileElement carouselSubTitle;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'btnSeeAllButtonTitle' AND visible == 1")
    @AndroidFindBy(id = "tv_see_all")
    public MobileElement carouselCtaText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[5]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[2]/android.widget.RelativeLayout[1]/android.widget.Button[1]")
    public MobileElement carouselSimpleLpCtaText;

    @AndroidFindBy(xpath = "//*[@text=\"Landing Page CTA\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Landing Page CTA\")]")
    public MobileElement largeBannerLpCta;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[10]/XCUIElementTypeButton[2]")

    @iOSXCUITFindBy(xpath = "//*[@label=\"CTA search\"]")
    @AndroidFindBy(xpath = "//*[@text=\"CTA search\"]")
    public MobileElement ctaSearch;

    @iOSXCUITFindBy(xpath = "//*[@label=\"External CTA Banner\"]")
    @AndroidFindBy(xpath = "//*[@text=\"External CTA Banner\"]")
    public MobileElement ctaExternal;


    @AndroidFindBy(xpath = "//*[@content-desc=\"LP banner CTA LP\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"LP banner\"]")
    public MobileElement ctaLp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[10]/XCUIElementTypeButton[2]")
    @AndroidFindBy(xpath = "//*[@text=\"LP banner\"]")
    public MobileElement mediumBannerLpTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[1]/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"tv_title\")]")
    public MobileElement landingPageName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[1]/XCUIElementTypeButton[1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"back\")]")
    public MobileElement LpBackBtn;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[4]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.RelativeLayout[1]/android.widget.Button[1]")
    public MobileElement carouselCTA;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]")
    //@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]")
    //  @iOSXCUITFindBy(iOSNsPredicate = "label == \"Carousel Title\"")
    @AndroidFindBy(id = "bottom_sheet_title")
    public MobileElement carouselsheetTitle;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]")
    @AndroidFindBy(id = "bottom_sheet_sub_title")
    public MobileElement carouselsheetSubTitle;

    //  @iOSXCUITFindBy(xpath = "//*[@label="iconClose"]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"iconClose\"")
    @AndroidFindBy(id = "bottom_sheet_close")
    public MobileElement carouselsheetClose;


    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Landing Page\")]")
    @AndroidFindBy(id = "tv_aem_card_header")
    public MobileElement carouselLPATitleBrowsePage;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Landing Page\")]")
    @AndroidFindBy(id = "tv_aem_card_sub_header")
    public MobileElement carouselLPASubTitleBrowsePage;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Landing Page\")]")
    @AndroidFindBy(id = "tv_aem_card_open_app")
    public MobileElement carouselLPACTABrowsePage;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.Button[1]/android.view.ViewGroup[2]/android.widget.ViewSwitcher[1]/android.widget.TextView[1] | //android.widget.FrameLayout[1]/android.widget.Button[1]/android.view.ViewGroup[3]/android.widget.ViewSwitcher[1]/android.widget.TextView[1]|//android.widget.FrameLayout[1]/android.widget.Button[1]/android.view.ViewGroup[2]/android.widget.ViewSwitcher[1]/android.widget.Button[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name, \"viewStepperView\")]")
    public List<MobileElement> addButtonList;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[25]/XCUIElementTypeButton[2]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Banner- Landing Page CTA Label\"]")
    public MobileElement ctaLpBrowsePage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[25]/XCUIElementTypeButton[2]")
    @AndroidFindBy(xpath = "//*[@text=\"Banner- Landing Page\"]")
    public MobileElement mediumBannerLpTitleBrowsePage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[1]/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(id = "tv_title")
    public MobileElement landingPageNameBrowsePage;

    //none
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[10]/XCUIElementTypeButton[4]")
    @AndroidFindBy(xpath = "//*[@text=\"Banner- No CTA\"]")
    public MobileElement mediumBannerNoneTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[10]/XCUIElementTypeButton[4]")
    @AndroidFindBy(xpath = "//*[@text=\"CTA None\"]")
    public MobileElement ctaNone;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[26]/XCUIElementTypeButton[1]")
    @AndroidFindBy(xpath = "//*[@text=\"test banner\"]")
    public MobileElement mediumBannerNoneTitleBrowsePage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[26]/XCUIElementTypeButton[1]")
    @AndroidFindBy(xpath = "//*[(@text=\"CTA Link none\")]")
    public MobileElement ctaNoneBrowsePage;

    @AndroidFindBy(id = "addButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[10]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[1]/XCUIElementTypeButton[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]|//XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[1]/XCUIElementTypeButton[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]")
    public MobileElement summerGrillingCarouselAddButton;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Back\"] | //*[@label=\"back\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Back\"] | //*[@content-desc=\"Back / Navigation Up\"]")
    public MobileElement navigateBackFromExternalLink;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[1]/XCUIElementTypeButton[1] | //XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[1]/XCUIElementTypeButton[1]")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.Button[1]/android.widget.ImageView[1]")
    public MobileElement firstProductInSheet;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Cancel' AND visible == 1")
    @AndroidFindBy(id = "tv_search_cancel")
    public MobileElement searchCancelButton;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Products tab\")]")
    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Products\")]")
    public MobileElement productsToggleSelected;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Deals tab\")] | //*[@label=\"Deals\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"dealsToggle\")] | //*[@text=\"Deals\"]")
    public MobileElement dealsToggleSelected;

    @AndroidFindBy(xpath = "//android.widget.Switch[@text='Deals OFF']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Deals' and value =='off'")
    public MobileElement dealsToggleOFFState;

    @AndroidFindBy(xpath = "//android.widget.Switch[@text='Deals ON']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Deals' AND value =='on'")
    public MobileElement dealsToggleONState;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"The Pros in Produce\"]")
    @AndroidFindBy(xpath = "//*[@text=\"The Pros in Produce\"]")
    public MobileElement prosInProduce;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Banner- No CTA\"]")
    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Banner- No CTA\")]")
    public MobileElement BannerNoCTA;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"LP banner\"]")
    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"LP banner\")]")
    public MobileElement LPBanner;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@label,\"Meals made easy\")]")
    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Meals made easy\")]")
    public MobileElement Mealsmadeeasy;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@label,\"Your meals, your way\")]")
    @AndroidFindBy(xpath = "//*[@text=\"Your meals, your way\"]")
    public MobileElement MealsMadeEasyTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sign Out\"]")
    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Sign Out\")]")
    public MobileElement SignOutApp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    @AndroidFindBy(xpath = "//*[@text=\"OK\"]")
    public MobileElement clickConfirmSignout;


    @AndroidFindBy(id = "tv_browse_by_aisle")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Browse categories\"]")
    public MobileElement browserAtHomePage;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"back\")]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'btnTopNavBarLeft' AND visible == 1")
    public MobileElement clickBackButton;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"View All\"]")
    @AndroidFindBy(xpath = "//*[@text=\"View All\"]")
    public MobileElement clickViewAll;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ingredients\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Ingredients\"]")
    public MobileElement PdpIngredientsText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Details\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Details\"]")
    public MobileElement PdpDetailsText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"More\"]")
    @AndroidFindBy(xpath = "//*[@text=\"More\"]")
    public MobileElement pdpMoreText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Ingredients\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.ExpandableListView[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
    public MobileElement PdpIngredientsDescription;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.ExpandableListView[1]/android.widget.RelativeLayout[2]/android.widget.TextView[1]")
    public MobileElement PdpDetailsDescription;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[4]/XCUIElementTypeOther[1]/XCUIElementTypeOther]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.ExpandableListView[1]/android.widget.RelativeLayout[2]/android.widget.TextView[1]")
    public MobileElement pdpMoreDescription;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Search\"]")
    @AndroidFindBy(id = "menu_search")
    public MobileElement clickSearchOnpdpPage;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Add\"])[1]")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.Button[1]/android.view.ViewGroup[2]/android.widget.ViewSwitcher[1]/android.widget.Button[1]")
    public MobileElement clickFirstAddFromRelatedProduct;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Shop Now \"])[1]")
    @AndroidFindBy(xpath = "//*[@text=\"Shop Now\"]")
    public MobileElement clickctaShopNowLabel;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Back\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND visible == 1")
    public MobileElement clickBackButtonFromPdpPage;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"tv_aem_card_header_bottom\")]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Large Banner with Text Pla…\"]")
    public MobileElement clickOnLargeBannerWithPdpCta;

    @AndroidFindBy(xpath = "//*[@text=\"Related Products\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Related Products\"]")
    public MobileElement relatedProductsText;

    @AndroidFindBy(xpath = "//*[@text=\"+\"]")
    public MobileElement plusItemButton;

    @AndroidFindBy(xpath = "//*[@text=\"–\"]")
    public MobileElement minusItemButton;

    @AndroidFindBy(xpath = "//*[contains(@text,\"in cart\")]")
    public MobileElement quantityText;

}


package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import java.util.List;

public class HomePageElements {

    //notification

    //app send notification permission text
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value == '“Delivery & Pick Up” Would Like to Send You Notifications' AND visible == 1")
    public MobileElement notificationText;

    //do not allow notification button
    @iOSXCUITFindBy(accessibility = "Don’t Allow")
    public MobileElement doNotAllowNotificationButton;

    //allow notification button
    @iOSXCUITFindBy(accessibility = "Allow")
    public MobileElement allowNotificationButton;

    //More on ios, menu button on android
    @iOSXCUITFindBy(accessibility = "User profile")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, \":id/iv_user_avatar\")]")
//    @AndroidFindBy(accessibility = "Open navigation drawer")
    public MobileElement menuButton;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Yes\"]")
    @AndroidFindBy(id = "yes")
    public MobileElement yesButton;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Dismiss\"]")
    @AndroidFindBy(id = "Dismiss")
    public MobileElement dismissAlert;

    //home tab
//    @iOSXCUITFindBy(accessibility = "HOME")
//    @AndroidFindBy(id = "bb_menu_home")
    @iOSXCUITFindBy(xpath = "//*[@label=\"HOME\"]")
    @AndroidFindBy(xpath = "//*[@text=\"HOME\"]")
    public MobileElement homeTab;

    //my purchase tab
    @iOSXCUITFindBy(accessibility = "My Purchases")
    @AndroidFindBy(id = "bb_menu_scan")
    public MobileElement myPurchaseTab;

    //aisle tab
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'SHOP' AND visible == 1")
    @AndroidFindBy(id = "browseFragment")
    public MobileElement aisleTab;

    //deals tab
    @iOSXCUITFindBy(xpath = "//*[@label=\"DEALS\"]")
    @AndroidFindBy(xpath = "//*[@text=\"DEALS\"]")
    public MobileElement dealsTab;


    //search edit text
    //@iOSXCUITFindBy(xpath = "//*[contains(@label, \"Search \")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar[1]/XCUIElementTypeSearchField[1]")
    @AndroidFindBy(id = "et_search")
    public MobileElement searchEditText;

    //click Browse
    @iOSXCUITFindBy(xpath = "//*[@label=\"BROWSE\"]")
    @AndroidFindBy(xpath = "//*[@text=\"BROWSE\"]")
    public MobileElement clickBrowse;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Search\"]|//*[@label=\"Search for Products\"]")
    public MobileElement searchInMenuPage;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Search bar\"]|//*[@label=\"Search for Products\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"tv_browse_search_bar\")]|//*[@text=\"Search for Products\"]")
    public MobileElement searchInBrowsePage;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Search\"]|//*[@label=\"Search for Products\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"iv_search_deals\")]|//*[@text=\"Search for Products\"]")
    public MobileElement searchInDealsPage;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Search\"]|//*[@label=\"Search for Products\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"iv_search_deals\")]|//*[@text=\"Search for Products\"]")
    public MobileElement searchInMyItemsPage;

    //click Search in Home page
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1] | //XCUIElementTypeNavigationBar[1]/XCUIElementTypeSearchField[1] |//*[@label=\"Search products or deals\"]")
    @AndroidFindBy(id = "sv_global")
//    @AndroidFindBy(id = "//*[@text=\"Search products or deals\"]")

    //@AndroidFindBy(id = "sv_global")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"et_search\")] | //*[@text=\"Search products or deals\"]")
    public MobileElement clickSearch;

    @AndroidFindBy(accessibility = "Search")
    //  @iOSXCUITFindBy(iOSNsPredicate = "label=='Search icon'")
    @iOSXCUITFindBy(xpath = "//*[@label = \"Search icon\"]")
    public MobileElement searchIconInHomePage;

    //search milk text
    @iOSXCUITFindBy(xpath = "//*[@label=\"milk\"]")
    @AndroidFindBy(id = "//*[@text=\"milk\"]")
    public MobileElement milkProduct;

    //search soda text
    @iOSXCUITFindBy(xpath = "//*[@label=\"soda\"]")
    @AndroidFindBy(id = "//*[@text=\"soda\"]")
    public MobileElement sodaProduct;

    //close deals toggle
    @iOSXCUITFindBy(xpath = "//*[@label=\"close\"]")
    @AndroidFindBy(id = "//*[@text=\"close\"]")
    public MobileElement closeToggle;


    //current trending on search page
//    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeOther' AND name == 'lblTrendingHeader'")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Currently Trending\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Currently Trending\")")
    public MobileElement currentTrendingText;

    //Recently searched on search page
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value == 'Recently Searched'")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Recently Searched\")")
    @CacheLookup
    public MobileElement recentlySearchedText;

    //search result list
    //@iOSXCUITFindBy(className = "XCUIElementTypeImage")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value CONTAINS '$' ")
    @AndroidFindBy(id = "ivProduct")
    public List<MobileElement> searchResultProductList;

    //search auto suggest list
    @iOSXCUITFindBy(className = "XCUIElementTypeButton")
    @AndroidFindBy(id = "txt")
    public List<MobileElement> autoSuggestSearchList;

    //no result text in search
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] '0 Results' AND visible == 1")
    @AndroidFindBy(id = "noResultTitle")
    public MobileElement noSearchResult;

    //quantity button
    //@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND name == 'Quantity' ")
    @iOSXCUITFindBy(accessibility = "Quantity")
    //   @AndroidFindBy(id = "tvQuantity")
    @AndroidFindBy(id = "umaStepperPlus")
    public MobileElement quantityButton;

    //quantity text edit field
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND name == 'Quantity' ")
    @AndroidFindBy(id = "etQuantityNotEditable")
    public MobileElement quantityTextEdit;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@label, \"Wine, Beer & Spirits\")]")
    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Wine, Beer & Spirits\")]")
    public MobileElement nonSnapCategoryName;

    //deals toggle switch
    //@iOSXCUITFindBy(accessibility = "Deals")
    @iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton' AND name=='Deals' AND value CONTAINS 'o'")
    @AndroidFindBy(id = "dealsToggle")
    public MobileElement dealsToggleSwitch;

    //cart icon
    @iOSXCUITFindBy(accessibility = "Cart")
    @AndroidFindBy(accessibility = "Shopping Cart Button")
    @CacheLookup
    public MobileElement cartButton;

    //delivery zipcode
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND value BEGINSWITH[c] 'Delivery' AND visible == 1")
    @AndroidFindBy(id = "preferenceText")
    @CacheLookup
    public MobileElement deliveryAddressText;

    //edit delivery button

    /*@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name ENDSWITH 'Edit' AND visible == 1")
    @AndroidFindBy(id = "preferenceText")


    @CacheLookup
    public MobileElement editDeliveryButton;*/

    /*@iOSXCUITFindBy(xpath="//XCUIElementTypeTable/XCUIElementTypeButton[5]")*/
    //XCUIElementTypeTable/XCUIElementTypeButton[5]
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeButton[2]")
    //  @AndroidFindBy(id = "preferenceText")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
    @CacheLookup
    public MobileElement editDeliveryButton;


    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeButton[2]")
    public MobileElement preferenceText;
/*
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Next'")
    public MobileElement nextButton;*/


    @iOSXCUITFindBy(xpath = "//*[@name=\"btnNext-Pick up tool tip\"]")
    @AndroidFindBy(xpath = "(//android.widget.Button[@text='Next'])")
    public MobileElement nextButton;


/*
    @iOSXCUITFindBy(xpath="//XCUIElementTypeOther[1]/XCUIElementTypeButton[1]")
    @CacheLookup
    public MobileElement nextButton;*/

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[8]")
    @AndroidFindBy(id = "editSlotText")
    @CacheLookup
    public MobileElement editReserveTimeButton;

    //popular items text
    @iOSXCUITFindBy(accessibility = "Popular Items")
    @AndroidFindBy(id = "carousel_title")
    public MobileElement popularItemText;

    @iOSXCUITFindBy(accessibility = "Must-have grabs")
    @AndroidFindBy(id = "tv_salutation_header")
    public MobileElement mustHaveGrabsSection;

    @iOSXCUITFindBy(accessibility = "Must-have grabs")
    @AndroidFindBy(id = "tvTitle")
    public MobileElement mustHaveGrabsTitle;

    //most viewed text
    @iOSXCUITFindBy(accessibility = "Most Viewed")
    @AndroidFindBy(id = "carousel_title")
    public MobileElement mostViewedText;

    //popular items view all
    @iOSXCUITFindBy(accessibility = "View All")
    @AndroidFindBy(accessibility = "View All Popular Items")
    public MobileElement popularViewAllButton;

    // @iOSXCUITFindBy(accessibility = "See all")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tv_see_all')]")
    public MobileElement popularSeeAllButton;

    @AndroidFindBy(id = "tv_see_all")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'See all'")
    public MobileElement mustHaveGrabsSeeAllButton;

    @AndroidFindBy(accessibility = "Browse categories See all")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'See all'")
    public MobileElement browseCategoriesSeeAllButton;


    @AndroidFindBy(id = "btnPlus")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Add' AND visible == 1")
    public List<MobileElement> addItemButtons;

    @AndroidFindBy(id = "iv_cart")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, \"Cart\")] | //XCUIElementTypeButton[contains(@name, \"List\")]")

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Cart' AND visible == 1")

    public MobileElement shoppingCartButton;

    //Deals view all button
    @AndroidFindBy(id = "view_more")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'View All' AND visible == 1")
    public MobileElement viewAllDealButton;

    //aisles title
    @AndroidFindBy(id = "toolbar")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblTitle' AND visible == 1")
    public MobileElement aisleTitle;

    //aisles category list- level 1
    @AndroidFindBy(id = "deptName")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeCell' AND name BEGINSWITH 'Baby' AND visible == 1")
    public List<MobileElement> departmentListElements;

    //aisles category list - level 2
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeCell' AND name ENDSWITH 'Collapsed.' AND visible == 1")
    @AndroidFindBy(id = "row")
    public List<MobileElement> subListElements;

    //aisles category list - level 3
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeCell' AND name BEGINSWITH 'Bottles' AND visible == 1")
    @AndroidFindBy(id = "childDeptName")
    public List<MobileElement> categoryListElements;

    //item found from aisle
    @AndroidFindBy(id = "tvResults")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name ENDSWITH 'Found' AND visible == 1")
    public MobileElement aisleResultText;

    //item found from search
    @AndroidFindBy(id = "tv_search_count")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name CONTAINS 'results' AND visible == 1")
    public MobileElement searchResultText;

    @AndroidFindBy(xpath = "//*[@text=\"Add\"]")
    // @AndroidFindBy(xpath="//android.widget.FrameLayout[1]/android.widget.Button[1]/android.view.ViewGroup[2]/android.widget.ViewSwitcher[1]/android.widget.TextView[1] | //android.widget.FrameLayout[1]/android.widget.Button[1]/android.view.ViewGroup[3]/android.widget.ViewSwitcher[1]/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"viewStepperView\"])[1]")
    public MobileElement addButtonOnfirstitem;

    //add button from product list
    //@AndroidFindBy(id = "add_button_layout")
    @AndroidFindBy(xpath = "//*[@text=\"Add\"]")
    // @AndroidFindBy(xpath="//android.widget.FrameLayout[1]/android.widget.Button[1]/android.view.ViewGroup[2]/android.widget.ViewSwitcher[1]/android.widget.TextView[1] | //android.widget.FrameLayout[1]/android.widget.Button[1]/android.view.ViewGroup[3]/android.widget.ViewSwitcher[1]/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, \"Add\")] | //XCUIElementTypeOther[contains(@name, \"viewStepperView\")]")
    public List<MobileElement> addButtonList;


    @AndroidFindBy(id = "addButton")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Add' AND visible == 1")
    public MobileElement addCTA;

    //@AndroidFindBy(id = "addButton")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Add to list\")")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Add to list' AND visible == 1")
    public MobileElement addToListCTA;

    @AndroidFindBy(xpath = "//android.widget.Button[1]/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[1]/*/XCUIElementTypeButton[1]")
    public List<MobileElement> addedProductNameList;

    @iOSXCUITFindBy(accessibility = "Toggle it. Toggle it real good.")
    public MobileElement iosTogglePopUp;

    @iOSXCUITFindBy(accessibility = "close")
    public MobileElement iosCloseToggle;

    //back /cancel button from search screen
    @AndroidFindBy(id = "tv_search_cancel")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Cancel' AND visible == 1")
    public MobileElement cancelButton;

    // plus button list
    //@AndroidFindBy(id = "btnPlus")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Increase Quantity\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Increment quantity' AND visible == 1")
    public List<MobileElement> plusButtonList;

    //ios
    //ios :do you love online shopping popup
    @AndroidFindBy(id = "yes")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Do you love Vons Online Shopping?\"]")
    public MobileElement loveShoppingPopUpText;

    @AndroidFindBy(id = "yes")
    @iOSXCUITFindBy(accessibility = "Yes")
    public MobileElement loveShoppingYesButton;

    @AndroidFindBy(id = "no")
    @iOSXCUITFindBy(accessibility = "No")
    public MobileElement loveShoppingNoButton;

    //ios rating shop pop up
    @AndroidFindBy(id = "body")
    @iOSXCUITFindBy(accessibility = "Enjoying Delivery & Pick Up?")
    public MobileElement ratingShopWindowText;

    @AndroidFindBy(id = "decline")
    @iOSXCUITFindBy(accessibility = "Not Now")
    public MobileElement ratingShopNotNowButton;

    @iOSXCUITFindBy(accessibility = "bread")
    public WebElement autoSuggestBread;


    //window title
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[1]/XCUIElementTypeStaticText[1] | //XCUIElementTypeCollectionView/XCUIElementTypeCell[4]")
    @AndroidFindBy(id = "tvTitle")
    public MobileElement windowTitle;

    //option window title
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(id = "app_bar_title")
    public MobileElement optionWindowTitle;

    //sort and filter icon
    @iOSXCUITFindBy(accessibility = "Sort & Filter Options")
    @AndroidFindBy(id = "img_filterSort")
    public MobileElement sortAndFilterButton;

    //product detail page
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value CONTAINS '$'")
    @AndroidFindBy(id = "imageProduct")
    public MobileElement productImage;

    //related products text
    @iOSXCUITFindBy(accessibility = "Related Products")
    @AndroidFindBy(id = "carousel_title") //text: "Related Products"
    public MobileElement relatedProductText;

    //product detail page add button
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Add to cart' AND name == 'Add to cart' AND type == 'XCUIElementTypeButton'")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"1\")")
    public MobileElement addProductButton;

    //android back arrow
    @AndroidFindBy(id = "ic_back")
    public MobileElement androidBackArrow;


    // @AndroidFindBy(id = "SAVE")
    @AndroidFindBy(xpath = "//*[@text='SAVE']")
    public MobileElement saveButton;

    @iOSXCUITFindBy(xpath = "//*[@label=\"List\"]|//*[@label=\"Cart\"]")

    public MobileElement shoppingCartButtonWithXpath;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"In-Store\")]")
    @AndroidFindBy(xpath = "//*[contains(@text,\"In-store\")]")

    public List<MobileElement> inStoreFromHomepage;

    //*[@resource-id="com.safeway.client.android.tomthumb.debug:id/tv_shopping_mode"]
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Delivery\")]")

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tv_shopping_mode')]")
    @CacheLookup
    public List<MobileElement> deliveryFromHomepage;
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Pickup\")]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'/tv_shopping_mode')]")
    public List<MobileElement> pickupFromHomepage;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Delivery\")]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tv_shopping_mode')]")
    @CacheLookup
    public MobileElement deliveryHomePage;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Pickup\")]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tv_shopping_mode')]")
    public MobileElement homepagePickUp;
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"In-Store\")]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tv_shopping_mode')]")
    public MobileElement inStoreHomepage;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Search products or deals\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Search products or deals\"]")
    //(iOSNsPredicate = "type == 'XCUIElementTypeSearchField' AND name == 'Search for Products' AND visible == 1")
    public MobileElement searchEditButton;

    //search Milk
    @iOSXCUITFindBy(xpath = "//*[@label=\"milk\"]|//*[@name=\"milk\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Milk\"]")
    //(iOSNsPredicate = "type == 'XCUIElementTypeSearchField' AND name == 'Search for Products' AND visible == 1")
    public MobileElement searchMilkButton;


    @iOSXCUITFindBy(xpath = "//*[@label=\"close\"]")
    public MobileElement iosToggle;

    @iOSXCUITFindBy(xpath = "//*[@label=\"close\"]")
    public MobileElement iosToggleClose;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Add 1 unit of Lucerne Milk Whole 1 Gallon - 128 Fl. Oz.\"]//*[@label=\"Add to list\"]|//*[@label=\"Quantity in cart\"]//*[@label=\"Add\"]|//*[@label=\"Add 1 unit of Lucerne Milk Whole 1 Gallon - 128 Fl. Oz.\"]//*[@label=\"Add\"]|//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeButton[2]/XCUIElementTypeButton[1]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Lucerne Milk Whole 1 Gallon - 128 Fl. Oz.\"]//*[contains(@resource-id,'addButton')]")
    public MobileElement addFirstItemForMilkSearch;
    //*[@content-desc="Lucerne Milk Whole 1 Gallon - 128 Fl. Oz."]//*[@resource-id="com.safeway.client.android.tomthumb.debug:id/addButton"]
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'iv_cart')]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"List\"]|//*[@label=\"Cart\"]")

    public MobileElement clickOnShoppingCartButton;

    //*[@resource-id="com.safeway.client.android.tomthumb.debug:id/iv_cart"]
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'instore_title')]")

    @iOSXCUITFindBy(xpath = "//*[@label=\"Shop in-store or make your list\"]")
    public MobileElement inStoreSignInPageButton;

//*[@resource-id="com.safeway.client.android.tomthumb.debug:id/layout_textview"]

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Delivery\")]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tv_shopping_mode')]")
    @CacheLookup
    public MobileElement deliveryOnHomePage;
    //*[@resource-id="com.safeway.client.android.tomthumb.debug:id/tv_shopping_mode"]

    @iOSXCUITFindBy(xpath = "//AppiumAUT/XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]")
    public MobileElement deliveryOptions;

    @iOSXCUITFindBy(xpath = " //*[@label=\"﹢\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'increaseView')]")
    public MobileElement addFirstItemForMilkCartpage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Cancel\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'imageBack')]")
    @CacheLookup
    public MobileElement clickOnCancelOnSearchPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Cancel\"]")
    @AndroidFindBy(xpath = " //*[contains(@resource-id,'btn_next']")
    @CacheLookup
    public MobileElement whiteRightArrow;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Cancel\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'start_shopping')]")
    @CacheLookup
    public MobileElement startShoppingButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Cancel\"]")
    @AndroidFindBy(xpath = " //*[contains(@resource-id,'pickup_title')]")
    @CacheLookup
    public MobileElement pickUpButtonOnSignInPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Cancel\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'pickup_title')]")
    @CacheLookup
    public MobileElement deliveryButtonOnSignInPage;

    @iOSXCUITFindBy(xpath = "//*[contains(@label, \"0 results\")]")
    @AndroidFindBy(id = "error_title")
    public MobileElement zeroSearchResults;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Cancel\"]")
    @AndroidFindBy(id = "tv_search_cancel")
    public MobileElement backButton;

    @iOSXCUITFindBy(xpath = "//*[contains(@label, \"results\")]")
    @AndroidFindBy(xpath = "//*[contains(@text,\"results\")]")
    public MobileElement validSearchProduct;

    @iOSXCUITFindBy(xpath = "//*[contains(@label, \"results\")]")
    @AndroidFindBy(xpath = "//*[contains(@text,\"results\")]")
    public MobileElement searchResults;

    //Sub Category List
    @AndroidFindBy(id = "tv_aisle_shelf_item_title")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Increment quantity' AND visible == 1")
    public List<MobileElement> subCategoryNames;


    // verify Refine Button
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"tv_refine\")]")
    @iOSXCUITFindBy(accessibility = "Refine")
    public MobileElement refineButton;

    // Total count behind search bar
    @iOSXCUITFindBy(xpath = "(//*[contains(@label,\"results\")])[1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"tv_search_count\")]")
    public MobileElement totalCount;

    // Products Toggle
    @AndroidFindBy(xpath = "//*[@text=\"Products\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Products\")]")
    public MobileElement productsToggle;

    // Deals Toggle
    @AndroidFindBy(xpath = "//*[@text=\"Deals\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Deals\")]")
    public MobileElement dealsToggle;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Weekly ad coupons See all\"]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"btnSeeAllButtonTitle-Weekly ad coupons\"]")
    public MobileElement weeklyadcouponSEEALL;

    @AndroidFindBy(xpath = "//*[@text=\"Weekly ad coupons\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Weekly ad coupons\"]")
    public MobileElement weeklyadcoupons;


    @AndroidFindBy(xpath = "//*[@text=\"Added!\"]")
    @iOSXCUITFindBy(xpath = "//*[starts-with(@label,\"Coupon Added.\")]")
    public MobileElement AddedCoupons;


    //Halo carousel elements - Sprint 94
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.safeway.client.android.safeway.debug:id/carousel_list\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCollectionView[1]")
    public MobileElement haloNavCarouselList;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Weekly Ads']")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Weekly Ads\"]")
    public MobileElement weeklyAdsHeader;


    //Home Page - 'Search products or deals' search box
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.safeway.client.android.safeway.debug:id/sv_global\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Search products or deals\"]")
    public MobileElement searchProduct;

    //Home Page - Cart Icon on top
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.safeway.client.android.safeway.debug:id/tv_cart_count\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Cart\"]")
    public MobileElement cartIcon;


    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Search products or deals'")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[1]")
    public List<MobileElement> searchTextField;

    //Halo carousel elements - Sprint 94

    @AndroidFindBy(xpath = "//*[@content-desc=\"Button for Rewards\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeButton[contains(@name,'View Rewards')]")
    public MobileElement haloNavRewardsBtn;


    @AndroidFindBy(xpath = "//*[@content-desc=\"Button for Pharmacy\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'View Pharmacy')]")
    public MobileElement haloNavPharmacyBtn;


    @AndroidFindBy(xpath = "//*[@content-desc=\"Button for Weekly Ad\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'View Weekly Ad')]")
    public MobileElement haloNavWeeklyAdsBtn;


    @AndroidFindBy(xpath = "//*[@content-desc=\"Button for Deals\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeButton[contains(@name,'View Deals')]")
    public MobileElement haloNavDealsBtn;


    @AndroidFindBy(xpath = "//*[@content-desc=\"Button for FreshPass\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeButton[contains(@name,'View FreshPass')]")
    public MobileElement haloNavFreshPassBtn;

    @AndroidFindBy(xpath = "//*[@text=\"Rewards\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Rewards')][@visible='true']")
    public MobileElement rewardsBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Grocery Rewards']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Grocery Rewards; Spend rewards before they expire!\"]")
    public MobileElement groceryRrwardsLabel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Pharmacy Services']")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Pharmacy Services')]")
    public MobileElement pharmacyServicesHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='All deals']")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'All deals')][@visible='true']")
    public MobileElement allDealsHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FreshPass']")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'FreshPass Tab')][@visible='true']")
    public MobileElement freshPassHeader;

    @iOSXCUITFindBy(xpath = "//*[@label='Continue']")
    public MobileElement ContinueLabel;


    @AndroidFindBy(xpath = "//*[@content-desc=\"Back\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar//XCUIElementTypeButton")
    public MobileElement backNavigatePharmacy;


    @AndroidFindBy(xpath = "//*[@content-desc='Search Button']")
    public MobileElement searchButton;


    @AndroidFindBy(xpath = "//*[@content-desc=\"Back\"]")
    public MobileElement backBttn;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Sign Out button\"]")
    public MobileElement signout;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[7]/XCUIElementTypeOther[1]")
    @AndroidFindBy(xpath = "//*[@class='androidx.recyclerview.widget.RecyclerView']//*[@class='android.view.ViewGroup'][4]")
//            "//*[contains(@text,'7499 Dublin Blvd Dublin')]//preceding::android.widget.RadioButton[1]")
    //  "//*[contains(@text,'7499 Dublin Blvd Dublin')]/..")
    public MobileElement dublinbttn;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Hamburger menu Image\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"User profile\"]")
    public MobileElement hamburgermenu;


    @AndroidFindBy(xpath = "//*[@content-desc=\"Developer Settings button\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Developer Settings\"]")
    public MobileElement developersettings;

    @AndroidFindBy(xpath = "//*[@text=\"MY_ACCOUNT_FEATURE_ENABLED\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"isMyAccountFeatureEnabled\"]")
    public MobileElement isMyAccountEnabled;

    @AndroidFindBy(xpath = "//*[@text=\"AEM_SIMPLE_CAROUSEL\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"aemSimpleCarousel\"]")
    public MobileElement isAemSimpleCarouselEnabled;

    @AndroidFindBy(xpath = "//*[@text=\"MULTI_CTA_CAROUSALS\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"multiCtaCarousals\"]")
    public MobileElement isMultiCtaCarouselEnabled;


    @AndroidFindBy(xpath = "//*[@text=\"AEM_LARGE_BANNER\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"aemLargeBanner\"]")
    public MobileElement isAemLargeBannerEnabled;

    @AndroidFindBy(xpath = "//*[@text=\"AEM_LARGE_CAROUSEL\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"aemLargeCarousel\"]")
    public MobileElement isAemLargeCarouselEnabled;


    @AndroidFindBy(xpath = "//*[@text=\"REMOVE_WEEKLY_AD_BANNER\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"removeWeeklyAdBanner\"]")
    public MobileElement isRemoveWeeklyAdBannerEnabled;


    @AndroidFindBy(xpath = "//*[@text=\"MY_ACCOUNT_FEATURE_ENABLED\"]//following::android.widget.Switch[1]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"isMyAccountFeatureEnabled, This flag is to enable My Account\"]")
    public MobileElement isMyAccountEnabledswitch;

    @AndroidFindBy(xpath = "//*[@text=\"SAVE\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Save\"]")
    public MobileElement savebttn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeButton[1]")
    public MobileElement searchbttn;

    @iOSXCUITFindBy(xpath = "//*[@label=\"MEMBER\"]")
    public MobileElement membertab;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Account Tab, 3 of 3\"]")
    public MobileElement Account;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Account button\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Account\"]")
    public MobileElement Accountinsetting;

    @AndroidFindBy(xpath = "//*[@text=\"Account\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Account Tab, 3 of 3\"]")
    public MobileElement Accountinsettingscreen;

    @AndroidFindBy(xpath = "//*[@text=\"HOME\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"HOME\"]")
    public MobileElement HomeTab;

    @AndroidFindBy(xpath = "//*[@content-desc=\"FreshPass button\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"FreshPass\"]")
    public MobileElement freshpass;

    @AndroidFindBy(xpath = "//*[@text=\"FreshPass\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"FreshPass Tab, 2 of 3\"]")
    public MobileElement freshpassscreen;

    @AndroidFindBy(xpath = "//*[@text='Help/FAQs']")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Help/FAQs\"]")
    public MobileElement helpheader;

    @AndroidFindBy(xpath = "//*[@text=\"FreshPass\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Feedback\"]")
    public MobileElement feedbackinsettings;

    @AndroidFindBy(xpath = "//*[@text='Contact Us']")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Contact Us\"]")
    public MobileElement contactusinsettings;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Terms & Policies\"]")
    public MobileElement termsinsettings;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Third Party & Open Source\"]")
    public MobileElement thirdpartyinsettings;

    @AndroidFindBy(xpath = "//*[@text='+']")
    @iOSXCUITFindBy(xpath = "//*[@label='+']")
    public MobileElement increaseQuantityPlus;

    @AndroidFindBy(xpath = "//*[@text='Add']")
    @iOSXCUITFindBy(xpath = "//*[@label='Add']")
    public MobileElement addButtonForSecondItem;

    @AndroidFindBy(xpath = "//*[@text='Member']")
    @iOSXCUITFindBy(xpath = "//*[@label='Member']")
    public MobileElement memberTab;

    //  @AndroidFindBy(xpath = "//*[@text='']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeImage[1]")
    public MobileElement secondStore;


    @AndroidFindBy(xpath = "//*[@text='SHOP']")
    @iOSXCUITFindBy(xpath = "//*[@name='SHOP']")
    public MobileElement shopTabBottomNav;


    @AndroidFindBy(xpath = "//*[@text=\"SHOP\"]")
    @iOSXCUITFindBy(xpath = "//*[@name='SHOP']")
    public MobileElement shopTabBottomNav1;


    @AndroidFindBy(xpath = "//*[@text='Past Purchases']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Past Purchases\"]")
    public MobileElement pastPurchasesShopPage;

    @AndroidFindBy(xpath = "//*[@text='DEALS']")
    @iOSXCUITFindBy(xpath = "//*[@name='DEALS']")
    public MobileElement dealsBottomNav;

    @AndroidFindBy(xpath = "//*[@text='MY LIST']")
    @iOSXCUITFindBy(xpath = "//*[@name='MY LIST']")
    public MobileElement myListBottomNav;

    @AndroidFindBy(xpath = "//*[@text='MEMBER']")
    @iOSXCUITFindBy(xpath = "//*[@name='MEMBER']")
    public MobileElement memberTabBottomNav;

    @AndroidFindBy(xpath = "//*[@content-desc=\"back\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Back\"]")
    public MobileElement closebuttonsigninpage;

    @AndroidFindBy(xpath = "//*[@text=\"Sign in for full experience\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Sign in for full experience\"]")
    public MobileElement signinexperience;

    @AndroidFindBy(xpath = "//*[@text=\"Sign in\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Sign in\"]")
    public MobileElement signinbutton;

}

package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_SearchPageElements {


    @AndroidFindBy(xpath = "//*[contains(@resource-id,'sv_global') or contains(@resource-id,'iv_search_deals')]|//*[contains(@resource-id,\"tv_browse_search_bar\")] | //*[contains(@resource-id,\"et_search\")]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Search products or deals'")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"btnSearchBarViewButton\"]")
    public MobileElement searchTextField;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'sv_global') or contains(@resource-id,'iv_search_deals')]|//*[contains(@resource-id,\"tv_browse_search_bar\")] | //*[contains(@resource-id,\"et_search\")]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Search products or deals\"] ")
    public MobileElement searchProductsOrDealsField;

    //Search icon
    @AndroidFindBy(id = "menu_search")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Search\"]")
    public MobileElement searchIcon;

    @AndroidFindBy(accessibility = "scan barcode")
    @iOSXCUITFindBy(xpath = "//*[@label='Scan barcode']")
    public MobileElement scanIcon;

    @AndroidFindBy(id = "tv_see_all")
    @iOSXCUITFindBy(xpath = "//*[@name='btnSeeAllButtonTitle']//*[@label='See all']")
    public MobileElement seeAll;

    @AndroidFindBy(id = "editSearch")
    @iOSXCUITFindBy(accessibility = "Search for Products")
    public MobileElement detailSearchField;

    @AndroidFindBy(id = "recent_remove_icon")
    @iOSXCUITFindBy(id = "btnClear")
    public MobileElement crossButton;

    @AndroidFindBy(id = "tv_item")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell")
    public List<MobileElement> searchKeywordFromResult;

    @AndroidFindBy(id = "tv_search_cancel")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Cancel'")
    public MobileElement cancelSearchButton;

    @AndroidFindBy(id = "product_price")
    @iOSXCUITFindBy(id = "lblPrice")
    public MobileElement productPriceProductListingPage;

    @AndroidFindBy(id = "dealsToggle")
    @iOSXCUITFindBy(accessibility = "Deals")
    public MobileElement dealsToggle;

    @AndroidFindBy(id = "img_filterSort")
    @iOSXCUITFindBy(id = "Sort & Filter Options")
    public MobileElement filterButton;

    @AndroidFindBy(id = "deals_cardview")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'productCell'")
    public MobileElement dealsCard;

    @AndroidFindBy(accessibility = "deals")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Deals' AND visible == 1")
    public MobileElement dealPageTitle;

    // Refine Button
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"tv_refine\")]")
    @iOSXCUITFindBy(accessibility = "Refine")
    public MobileElement refineButton;

    // Savings header sub section
    @AndroidFindBy(xpath = "//*[@text=\"Savings\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Savings\"]")
    public MobileElement savingsHeader;

    // save Button
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"btnSave\")]|//*[@text='SAVE']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Done\"]")
    public MobileElement clickSave;

    // 0 Results
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"tv_search_count\")]")
    @iOSXCUITFindBy(xpath = "(//*[contains(@label,\"results\")])[1]")
    public MobileElement resultCount;


    // No Result Message
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"error_title\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"we didn’t find any results for\")]")
    public MobileElement noResultMessage;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"error_desc\")]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"You can check the spelling and try again, or it could be we don’t carry this item\"]")
    public MobileElement noResultDefaultMessage;

    // product with deals
    @AndroidFindBy(xpath = "//*[@content-desc=\"Products with Deals \"]")
    @iOSXCUITFindBy(xpath = "(//*[contains(@label,\"Products with Deals\")])[1]")
    public MobileElement productWithDeals;

    // Out Of Stock
    @iOSXCUITFindBy(xpath = "(//*[contains(@label,\"Include Out of Stock\")])[1]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Include Out of Stock \"]")
    public MobileElement outOfStock;

    // Cancel in search bar
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"tv_search_cancel\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Cancel\"]")
    public MobileElement cancelCTA;

    // verify Product with deals displayed
    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Oz.\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Oz.\")]")
    public MobileElement productWithDealsDisplayed;

    // verify Product with and without deals displayed
    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Oz.\")]|//*[contains(@content-desc,\"Gallon\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Oz.\")]|//*[contains(@label,\"Gallon\")]")
    public MobileElement productWithAndWithoutDeals;


    @AndroidFindBy(id = "imageBack")
    public MobileElement backButtonInProductListingPageInEditScreen;

    //ClickOutofStockItem
    @AndroidFindBy(accessibility = "imgvProductImage")
    @iOSXCUITFindBy(accessibility = "imgvProductImage")
    public MobileElement clickOutOfStockItem;

    //ClickOutofStockItem
    @AndroidFindBy(accessibility = "Dismiss")
    @iOSXCUITFindBy(accessibility = "Dismiss")
    public MobileElement clickDismiss;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"ctaClose\")]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Cart Back\"] | //*[@label=\"Double tap to close cart screen\"]  | //*[@label=\"Cart Close\"]")
    public MobileElement closeBackBtn;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Back\"] | //*[@content-desc=\"Back / Navigation Up\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar[1]/XCUIElementTypeButton[1]")
    public MobileElement navigateBack;


}

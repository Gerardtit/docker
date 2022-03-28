package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_BrowsePageElements {


    @AndroidFindBy(xpath = "//*[@text=\"SHOP\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'SHOP'")
    public MobileElement browseTab;

    //    @AndroidFindBy(accessibility = "BROWSE")
    @AndroidFindBy(xpath = "//*[@text=\"SHOP\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'SHOP'")
    public MobileElement browsePageTitle;

    //    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Browse Products']")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Shop products by categoryheading\"]")

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Browse Products' and name == 'lblTitle'")
    public MobileElement browseCategoryTitle;

    @AndroidFindBy(id = "tv_aisle_item_title")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeCell' AND name == 'catologueRootcell'")
    public MobileElement browseCategoryType;

    @AndroidFindBy(id = "tv_aisle_shelf_item_title")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeCell' AND name == 'catalogLevelCell'")
    public List<MobileElement> browseCategorySubType;

    @AndroidFindBy(id = "iv_aisle_item_expand")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"imgvArrowCatalogRootCellDown\"])[2]")
//    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeCell' AND label == 'Baby Care. Expanded.'")
    public MobileElement collapseOptionForCategories;

    @AndroidFindBy(id = "iv_aisle_sub_item_expand")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'catalogLevelCell' AND label contains 'Collapsed'")
    public MobileElement expandOptionForSubCategories;

    @AndroidFindBy(id = "iv_aisle_sub_item_expand")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'catalogLevelCell' AND label contains 'Expanded'")
    public MobileElement collapseOptionForSubCategories;

    @AndroidFindBy(id = "tv_browse_search_bar")
    @iOSXCUITFindBy(accessibility = "btnSearchBarViewButton")
    public MobileElement searchBar;

    @AndroidFindBy(id = "iv_browse_scan")
    @iOSXCUITFindBy(accessibility = "btnSearchBarViewScan")
    public MobileElement scanIcon;

    @AndroidFindBy(id = "iv_cart")
    @iOSXCUITFindBy(accessibility = "btnCartWithBadge")
    public MobileElement myCart;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Baby Care\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@label,'Baby Care')]")
    public MobileElement babyCareCategoryCardContainer;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Beverages\")")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@label,'Beverages')]")
    public MobileElement beveragesCategoryCardContainer;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Baby Accessories\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Baby Accessories\" and visible==1")
    public MobileElement babyAccessoriesSubCategoryCard;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Coffee\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Coffee\" and visible==1")
    public MobileElement coffeeSubCategoryCard;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Coffee - Ground\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Coffee - Ground\" and visible==1")
    public MobileElement coffeeGroundSubCategoryCard;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Bottles & Nursing\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Bottles & Nursing\" and visible==1")
    public MobileElement bottlesNursingSubCategoryCard;

    @AndroidFindBy(id = "tv_refine")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Refine' AND name == 'Refine' AND type == 'XCUIElementTypeButton' AND visible=1")
    public MobileElement refineFilterButton;

    @AndroidFindBy(id = "app_bar_title")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Sort & Filter' AND visible=1")
    public MobileElement sortAndFilter;

    @AndroidFindBy(id = "selectedSortText")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Best Match' AND name == 'Best Match' AND value == 'Best Match' AND visible=1")
    public MobileElement bestMatch;

    @AndroidFindBy(xpath = "//*[@text=\"Sort By\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Sort & Filter By' AND visible=1")
    public MobileElement sortByPage;

    @AndroidFindBy(xpath = "//*[@text=\"Club Card Specials\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Club Card Specials' AND visible=1")
    public MobileElement clubCardSpecials;

    @AndroidFindBy(id = "btnBack")
    public MobileElement backButton;

    @AndroidFindBy(id = "btnSave")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Done' AND name == 'Done' AND type == 'XCUIElementTypeButton'")
    public MobileElement saveButton;

    @AndroidFindBy(accessibility = "close")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'closeGray'")
    public MobileElement closeToggleIt;

    @AndroidFindBy(id = "tv_aisle_item_title")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeCell' AND name == 'catologueRootcell'")
    public List<MobileElement> browseCategoryTypeList;

    @AndroidFindBy(id = "tv_aisle_item_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"imgvArrowCatalogRootCellDown\"]")
//   @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'imgvArrowCatalogRootCellDown'")
    public List<MobileElement> browseCategoryTypeDropDown;


    @AndroidFindBy(id = "tv_aisle_item_title")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"imgvArrowCatalogRootCellDown\"])[1]")
//   @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'imgvArrowCatalogRootCellDown'")
    public MobileElement browseCategoryType1;

    @AndroidFindBy(id = "tv_aisle_item_title")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"imgvArrowCatalogRootCellDown\"])[2]")
//   @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'imgvArrowCatalogRootCellDown'")
    public MobileElement browseCategoryType2;

    @AndroidFindBy(id = "toolbar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"lblTitle\"]")
    public MobileElement categoryTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Go to Deals\")")
    @iOSXCUITFindBy(accessibility = "Looking for deals, Go to Deals")
    public MobileElement goToDealsBtn;

    @AndroidFindBy(accessibility = "Categoriesheading")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Categories'")
    public MobileElement categoryTypeImage;
}

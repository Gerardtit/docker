package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_ProductsListingPageElements {

    @AndroidFindBy(id = "tv_refine")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Refine'")
    public MobileElement filterButton;

    @AndroidFindBy(accessibility = "Cancel Sort or Filter page.")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'closeGray'")
    public MobileElement closeToggleIt;

    @AndroidFindBy(id = "tv_cart_count")
    @iOSXCUITFindBy(id = "Cart")
    public MobileElement cartIconWithCount;

    @AndroidFindBy(accessibility = "Sort")
    public MobileElement filterRightArrow;

    @AndroidFindBy(accessibility = "Back / Navigation Up")
    public MobileElement saveButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Reward Card Specials\")")
    @iOSXCUITFindBy(id = "Reward Card Specials")
    public MobileElement filterRewardCardSpecials;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Price - Low to High\")")
    @iOSXCUITFindBy(id = "Price - Low to High")
    public MobileElement sortByPriceLowToHigh;

    @AndroidFindBy(id = "itemParentLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='productCell']/XCUIElementTypeButton[@visible='true']")
    public List<MobileElement> productCards;

    @iOSXCUITFindBy(accessibility = "Back")
    public MobileElement backButton;

    @AndroidFindBy(id = "description")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='productCell']/XCUIElementTypeButton[@visible='true']")
    public List<MobileElement> productDescription;

    //This is for UMA master locator changes
    //@AndroidFindBy(id = "btnAdd")
    @AndroidFindBy(id = "addButton")
    @iOSXCUITFindBy(iOSNsPredicate = "label contains 'Add'")
    public MobileElement addToCartButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'viewStepperView' and visible == 1")
    public List<MobileElement> addToCartButtonListForIOS;

    @iOSXCUITFindBy(accessibility = "This item is currently Out of Stock")
    public MobileElement outOfStockLabel;


    //This is for UMA master locator changes
    //@AndroidFindBy(id = "btnPlus")
    @AndroidFindBy(id = "btnPlus")
    @iOSXCUITFindBy(id = "Increment quantity")
    public MobileElement incrementQuantity;

    //This is for UMA master locator changes
    //@AndroidFindBy(id = "btnMinus")
    @AndroidFindBy(id = "umaStepperMinus")
//    @iOSXCUITFindBy(id = "Decrement quantity")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"-\"]")
    //    @AndroidFindBy(id = "btnMinus")
//    @iOSXCUITFindBy(id = "Decrement quantity")
    public MobileElement decrementQuantity;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeButton[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]")
    public MobileElement productQuantityButton;

    @AndroidFindBy(id = "tvQuantity")
    @iOSXCUITFindBy(id = "Quantity")
    public MobileElement quantityProductDetailsPage;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'product_price_container')]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'lblPrice' and visible == 1")
    public List<MobileElement> productPriceCompleteTxt;

    @AndroidFindBy(id = "product_approx")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='lblApproxLabel']/..")
    public List<MobileElement> productApproxLbl;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Add to Cart\"]")
    @AndroidFindBy(id = "tvQuantity")
    public MobileElement Addtocartab;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton)[5]")
    @AndroidFindBy(xpath = "(//android.widget.Button)[1]")
    public MobileElement firstitem;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Increment quantity\"]")
    @AndroidFindBy(id = "btnPlus")
    public MobileElement addQuantity;

}

package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class InStorePageElements {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]")
    @AndroidFindBy(xpath = "//*[contains(@text,\"Search\")]")
    public MobileElement searchBar;

    //search Butter
    @iOSXCUITFindBy(xpath = "//*[@label=\"butter\"]|//*[@name=\"butter\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Butter\"]")
    public MobileElement searchButter;

    @iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton' AND name=='Deals' AND value CONTAINS 'o'")
    public MobileElement iosToggle;

    @iOSXCUITFindBy(xpath = "//*[@label=\"close\"]")
    public MobileElement iosToggleClose;

    // Verify search result- Butter
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Butter\")]|//*[contains(@label,\"butter\")] | //*[contains(@label,\"results\")]")
    @AndroidFindBy(xpath = "//*[contains(@text,\"Butter\")]|//*[contains(@text,\"butter\")] | //*[contains(@resource-id,\"tv_search_count\")]")
    public MobileElement verifySearchResult;

    // To add Butter
//    @iOSXCUITFindBy(xpath = "//*[@label=\"Lucerne Butter Salted Sweet Cream - 16 Oz.\"]//*[@label=\"Add to list\"]|//*/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[1]/XCUIElementTypeButton[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeButton[1]/XCUIElementTypeButton[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeButton[1]")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.Button[1]/android.widget.TextView[1]")
    public MobileElement clickProduct;

    // Add 10 counts
//    @iOSXCUITFindBy(xpath = " //*[@label=\"Quantity in cart\"]//*[@label=\"Add to list\"]")
    @iOSXCUITFindBy(xpath = "(//*[@label=\"Add to Cart\"])[position()=1] | //*[@label=\"Increment quantity\"] | //XCUIElementTypeButton[@label=\"Add to cart\"]")
    @AndroidFindBy(xpath = "(//*[contains(@resource-id,\"tvQuantity\")])[position()=1]|//*[@text=\"+\"]")
    public MobileElement addItems;

    // check quantity
    @iOSXCUITFindBy(xpath = "//*[@label=\"Quantity\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"tvQuantity\")]")
    public MobileElement checkQuantity;

    //click List
    @iOSXCUITFindBy(xpath = "//*[@label=\"Cart\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"iv_cart\")]")
    public MobileElement clickList;

    // cart Page increment
    @iOSXCUITFindBy(xpath = "//*[@label=\"﹢\"]")
    @AndroidFindBy(xpath = "(//*[contains(@content-desc,\"increase\")])[position()=1]")
    public MobileElement cartPageIncrement;

    // check quantity
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Quantity in cart\")]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"quantityView\")]")
    public MobileElement actualQuantity;

    // When user clicks "Delivery or PickUp" in My List Page
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Delivery or Pickup\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Delivery or Pickup\"]")
    public MobileElement clickDeliveryOrPickUp;

    // When user clicks "Pay-In Store" in My List Page
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Pay In-Store\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Pay In-Store\"]")
    public MobileElement clickPayInStore;

    // My List Page
    @AndroidBy(xpath = "//*[@text=\"My List\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"My List\")]")
    public MobileElement MyListPage;

    // remove items from cart
    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Remove\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeButton[1]")
    public MobileElement removeItems;

    // close MyList Page
    @AndroidFindBy(xpath = "//*[@content-desc=\"Back button\"]")
//    @iOSXCUITFindBy(xpath = "//*[@label=\"Done\" or @label=\"Back\"")
    @iOSXCUITFindBy(xpath = "//*[@label='Back']")
    public MobileElement closeMyListPage;

    // close New Cart Page
    @AndroidFindBy(xpath = "//*[@content-desc=\"close\"] | //*[@content-desc=\"Close\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Cart Close\"]")
    public MobileElement closeNewCartPage;

    //close search page
    @AndroidFindBy(xpath = "//*[@content-desc=\"Close\"] | //*[@content-desc=\"Navigate up\"] | //*[@content-desc=\"Back\"] | //*[@text=\"Cancel\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Back\"] | //XCUIElementTypeButton[@label=\"Cancel\"]")
    public MobileElement closePage;

    // Back button
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"tv_search_cancel\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Cancel\"]")
    public MobileElement backbutton;

}

package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ClubCardDealElements {
    // Search Milk
//    @iOSXCUITFindBy(
    @AndroidFindBy(xpath = "//*[@text=\"Milk\"]")
    public MobileElement searchMilk;

    // tap on filter
    @iOSXCUITFindBy(xpath = "//*[@label=\"Sort & Filter Options\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"img_filterSort\")]")
    public MobileElement clickFilter;

    // Sort & Filter Window
    @iOSXCUITFindBy(xpath = "//*[@label=\"Sort & Filter\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Sort & Filter\"]")
    public MobileElement SortFilter;

    // Click on Best Match
    @iOSXCUITFindBy(xpath = "//*[@value=\"Best Match\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Best Match\"]")
    public MobileElement bestMatch;

    // Sort By Window
    @iOSXCUITFindBy(xpath = "//*[@label=\"Sort & Filter By\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Sort By\"]")
    public MobileElement SortByWindow;

    // click club card specials
    @iOSXCUITFindBy(xpath = "//*[@label=\"Reward Card Specials\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Club Card Specials\"]")
    public MobileElement clickClubCardSpecials;

    // Back button on Sort By window
    @iOSXCUITFindBy(xpath = "//*//XCUIElementTypeNavigationBar[1]/XCUIElementTypeButton[1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"btnBack\")]")
    public MobileElement backButton;

    // Save button on Sort & Filter window
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Done\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"btnSave\")]")
    public MobileElement saveButton;

    // Select First product
    @AndroidFindBy(xpath = "//*/androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout[1]/android.widget.Button[1]")
    @iOSXCUITFindBy(xpath = "//*/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[1]/XCUIElementTypeButton[1]")
    public MobileElement selectProduct;

    // Add Product
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@label=\"Add to list\"])[position()=1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"btnPlusView\")]")
    public MobileElement addProduct;

    @iOSXCUITFindBy(xpath = "(//*[@label=\"Add to list\"])[position()=1]|//*[@label=\"Increment quantity\"]")
    @AndroidFindBy(xpath = "(//*[@label=\"Add to list\"])[position()=1]|//*[@text=\"+\"]")
    public MobileElement Increment;

    // decrease number of items
    @iOSXCUITFindBy(xpath = "//*[@label=\"Decrement quantity\"]")
    @AndroidFindBy(xpath = "//*[@text=\"-\"]")
    public MobileElement Decrement;

    //check cart item
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"cartItems\")]|(//*[contains(@resource-id,\"itemParentLayout\")])[position()=1]")
    @iOSXCUITFindBy(xpath = "//*/XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeButton[2]")
    public MobileElement checkCartItems;


}

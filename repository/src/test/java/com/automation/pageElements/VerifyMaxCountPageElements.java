package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class VerifyMaxCountPageElements {

    //text = This mobile application uses device caching to improve the user experience.
    @iOSXCUITFindBy(xpath = "//*[@label=\"Allow\"]")
    @AndroidFindBy(xpath = "//*[@text=\"CONTINUE\"]")
    public MobileElement ClickCacheText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
// @AndroidFindBy(xpath = "//*[@text=\"CONTINUE\"]")
    public MobileElement ClickCacheTextMA;

    //text = This mobile application uses device caching to improve the user experience.
    @iOSXCUITFindBy(xpath = "//*[@label=\"Maybe Later\"]")
    @AndroidFindBy(xpath = "//*[@text=\"CONTINUE\"]")
    public MobileElement softupgrademsg;

    // To click Next Button
    @iOSXCUITFindBy(xpath = "//*[@name=\"btnNext-Pick up tool tip\"or @name=\"btnNext-Deals tool tip\"or @name=\"btnNext-Wallet tool tip\"]")
    @AndroidFindBy(xpath = "//*[@text='Next']")
    public MobileElement ClickNextButton;

    // Search product
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]")
    @AndroidFindBy(xpath = "//*[@text=\"Search\"]")
    public MobileElement search;

    // Search product
    @iOSXCUITFindBy(xpath = "//*[@label=\"milk\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Milk\"]")
    public MobileElement searchmilk;

    // close toggle
    @iOSXCUITFindBy(xpath = "//*[@label=\"close\"]")
    public MobileElement closetoggle;

    // first product on search page
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeButton[1]")
    @AndroidFindBy(xpath = "//*/android.widget.FrameLayout[1]/android.widget.Button[1]/android.widget.ImageView[1]")
    public MobileElement firstproduct;

    // add to cart cta
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Add to Cart\"] | //XCUIElementTypeButton[@label=\"Add to list\"] | //XCUIElementTypeButton[@label=\"Add to cart\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,'ADD')] | //*[contains(@text,'Add')]")
    public MobileElement addtocart;

    // one product in cart
    @iOSXCUITFindBy(xpath = "//*[@label=\"Quantity\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tvQuantity')]")
    public MobileElement oneincart;

    // edit QTY
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'etQuantityNotEditable')]")
    public MobileElement editqty;

    // product QTY in cart
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Quantity in cart\")]/XCUIElementTypeStaticText[1] | //XCUIElementTypeOther[7]/XCUIElementTypeButton[1]/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tv_stepper_quantity')]")
    public MobileElement qtyincart;

    // one product in cart
    @iOSXCUITFindBy(xpath = "//*[@label=\"Update\"]")
    public MobileElement updateqty;

    // increment product qty
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'btnPlus')]")
    public MobileElement plusbtn;

    // one product in cart
    @iOSXCUITFindBy(xpath = "//*[@label=\"Increment quantity disabled\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'btnPlus') and @enabled = \"false\"]")
    public MobileElement incrementdisabled;

    // verify max quantity
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'max')]")
    @AndroidFindBy(xpath = "//*[contains(@text,'max')]")
    public MobileElement maxquantity;

}

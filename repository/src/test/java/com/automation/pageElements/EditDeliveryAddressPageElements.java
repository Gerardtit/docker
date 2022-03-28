package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class EditDeliveryAddressPageElements {
    //zip code
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND name CONTAINS 'Zipcode' AND visible == 1")
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    public MobileElement zipcodeTextField;

    //address line 1
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND name CONTAINS 'Address' AND visible == 1")
    @AndroidFindBy(xpath = "//*[@text=\"Street address\"] | //android.widget.RelativeLayout[2]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[1]")
    public MobileElement addressLine1TextField;

    //address line 1
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND name CONTAINS 'Address' AND visible == 1")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"addressLine2TextView\")]//*[contains(@resource-id,\"edit_text\")]")
    public MobileElement addressLine2TextField;

    //apt number
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND name CONTAINS 'Apartment' AND visible == 1")
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(2)")
    public MobileElement aptTextField;

    //enter comments
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND name CONTAINS 'Comments' AND visible == 1")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Comments\")")
    public MobileElement deliveryInstructionTextField;

    //back button: android arrow, ios arrow
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[6]")
    @AndroidFindBy(accessibility = "Navigate up")
    public MobileElement topLeftArrowBack;


    //    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Add new address'")
    @AndroidFindBy(xpath = "//*[@text=\"Delivery address\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Delivery Address\"]")
    public MobileElement addNewAddress;

    //    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Add Delivery Address'")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Add address\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Add address\"]")
    public MobileElement addDeliveryAddressTitle;

    @AndroidFindBy(xpath = "//*[@text=\"Address\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Address\"]")
    public MobileElement addressCarousel;

    @AndroidFindBy(xpath = "//*[@text=\"Address Preferences\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Address Preferences\"]")
    public MobileElement addresspreferances;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name BEGINSWITH 'Residential'")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Residential')]")
    public MobileElement addressAdded;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Save' AND visible == 1")
    @AndroidFindBy(id = "btn_save")
    public MobileElement saveButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"lblTopNavBarTitle\"]")
    @AndroidFindBy(id = "tvRegularTitle")
    public MobileElement editcartTitle;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[4]")
    @AndroidFindBy(id = "iv_cart_right_arrow")
    public MobileElement ItemsatEdit;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeOther[1]")
    @AndroidFindBy(xpath = "(//android.view.ViewGroup)[9]")
    public MobileElement Firstitem;


    //    @iOSXCUITFindBy(xpath="(//XCUIElementTypeButton[@name=\"Edit Order\"])[1]")
//    @AndroidFindBy(id="edit_button")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Edit order\"])[1]")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Edit order']")
    public MobileElement editbutton;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Increment quantity\"]")
    @AndroidFindBy(id = "btnPlus")
    public MobileElement addQuantity;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Add to cart\"]")
    // @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Add to Cart\")]")
    @AndroidFindBy(id = "tvQuantity")
    public MobileElement Addtocartab;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[@name=\"lblPopularSearchItem\"])[1]/XCUIElementTypeOther[1]")
    @AndroidFindBy(xpath = "(//android.widget.TextView)[4]")
    public MobileElement firstitemfromrecentsearch;


    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"imgvProductImage\"])[1])")
    @AndroidFindBy(xpath = "(//android.widget.Button)[1]")
    public MobileElement firstitemfromPLP;


    //@iOSXCUITFindBy(xpath="//XCUIElementTypeCell[contains(@name,\"Pick up \")]")
    @AndroidFindBy(xpath = "(//*[contains(@content-desc,\"Address and Slot Button Pick up\")])")
    public MobileElement PickupAtEdit;

}

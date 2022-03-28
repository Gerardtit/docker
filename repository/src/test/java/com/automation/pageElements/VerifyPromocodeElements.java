package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class VerifyPromocodeElements {

    @iOSXCUITFindBy(xpath = "//*[@label=\"Checkout\"] and name Contains 'Checkout'")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Checkout\"]")
//    @AndroidFindBy(id="//*[contains(@resource-id,\"btn_checkout_pay\")]")
    public MobileElement checkoutButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Add to Cart\"]")
    @AndroidFindBy(id = "btnPlusView")
//    @AndroidFindBy(id="//*[contains(@resource-id,\"btn_checkout_pay\")]")

    public MobileElement addButton;

    //    @iOSXCUITFindBy(xpath = "//*[@label=\"Add to list\" and @visible=\"true\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[2]/XCUIElementTypeButton[1]")
    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Increase Quantity\") and @index=\"1\" and @text=\"+\" or @id=\"btnPlusView\"]")
//   @AndroidFindBy(id="id = "btnPlusView"")
    public MobileElement addToListButton;

    //Quantity
    @iOSXCUITFindBy(xpath = "//*[@label=\"Quantity\"]")
    @AndroidFindBy(id = "tvQuantity")
//    tvQuantity
    public MobileElement quantity;

    //update to add quantity in IOS only
    @iOSXCUITFindBy(xpath = "//*[@label=\"Update\"]")
    public MobileElement UpdateBtn;


    //plus Sign at cart
    @iOSXCUITFindBy(xpath = "//*[@label=\"Increment quantity\"]")
    @AndroidFindBy(id = "btnPlus")
    public MobileElement plusSign;


    // increment product qty
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'btnPlus')]")
    public MobileElement plusbtn;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Checkout\"]")
//    @AndroidFindBy(id="tvTitle")
    @AndroidFindBy(xpath = "//*[@text=\"Checkout\"]")
    public MobileElement checkoutTitle;


    //     ok Reverse Time
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[8]")
    @AndroidFindBy(id = "android:id/button1")
//    @CacheLookup
    public MobileElement okReserveTimeButton;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Order Info\"]")
    @AndroidFindBy(xpath = "//*[@label=\"Order Info\"]")
    public MobileElement orderInfoText;

    // Save tab at orderInfo
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Save\"]")
    @AndroidFindBy(xpath = "//*[@text='SAVE']")
//    id = "btn_save"
    //    @CacheLookup
    public MobileElement SaveTab;


    //return to check out page
    @iOSXCUITFindBy(xpath = "//*[@label=\"Checkout\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Close\"]")
//    @CacheLookup
    public MobileElement ReturnToCheckOut;

    //    remove promocode
    @iOSXCUITFindBy(xpath = "//*[@label=\"Remove\"]")
    @AndroidFindBy(id = "delete_promo")
//    @CacheLookup
    public MobileElement RemovePromocode;


    //invalid promocode message
    @iOSXCUITFindBy(xpath = "//*[@label=\"This promo code is invalid and cannot be applied.\"]")
    @AndroidFindBy(id = "error_message")
//    @CacheLookup
    public MobileElement InvalidPromocode;

    //promo code
    @iOSXCUITFindBy(xpath = "//*[@label=\"Promo Code(s)\" and @name=\"Promo Code(s)\"]")
    @AndroidFindBy(id = "promo_code_title")
//    @CacheLookup
    public MobileElement promoCodeText;

    //reduce quantity to zero
    @iOSXCUITFindBy(xpath = "//*[@label=\"﹣\"]")
    @AndroidFindBy(id = "promo_code_title")
//    @CacheLookup
    public MobileElement minusSign;

    //Cart To Homepage
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar//*[@label=\"Checkout\"]")
    @AndroidFindBy(id = "promo_code_title")
//    @CacheLookup
    public MobileElement cartToHomePAge;


    //reduce quantity to zero
    @iOSXCUITFindBy(xpath = "//*[@label=\"Full carts & happy hearts\"]")
    @AndroidFindBy(id = "decreaseView")
//    @CacheLookup
    public MobileElement EmptyCartSign;
    //    //cart at checkout
    @iOSXCUITFindBy(xpath = "//*[@label=\"Cart\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Cart\"]")
    public MobileElement cartAtCheckout;

    //promo code text field

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    @AndroidFindBy(id = "edit_text")
//    @CacheLookup
    public MobileElement promoCodeTextField;

    //invalid code with empty cart

    @iOSXCUITFindBy(xpath = "//*[@label=\"Your promo code is only valid with a purchase of $30 or more.\"]")
    @AndroidFindBy(xpath = "//*[@text='Your promo code is only valid with a purchase of $30 or more.']")
//    @CacheLookup
    public MobileElement invalidmessage;

    //VALID TEXT PROMOCODE
    @iOSXCUITFindBy(xpath = "//*[@label=\"LUVFRESH\"]")
    @AndroidFindBy(id = "applied_tv")
//    @CacheLookup
    public MobileElement AppliedTextFieldCheck;


    @iOSXCUITFindBy(xpath = "//*[@label=\"This promo code is invalid and cannot be applied.\"]")
    @AndroidFindBy(id = "error_message")
    public MobileElement errormesage;
    // first pop up
    @iOSXCUITFindBy(xpath = "//*[@name=\"btnNext-Pick up tool tip\"]")
    @AndroidFindBy(xpath = "//*[@text='Next']")
    public MobileElement firstPOP;
    @iOSXCUITFindBy(xpath = "//*[@name=\"btnNext-Deals tool tip\"]")
    @AndroidFindBy(xpath = "//*[@text='Next']")
    public MobileElement secondpop;
    @iOSXCUITFindBy(xpath = "//*[@name=\"btnNext-Wallet tool tip\"]")
    @AndroidFindBy(xpath = "//*[@text='Next']")
    public MobileElement thirdpop;

    @iOSXCUITFindBy(xpath = "//*[@label=\"close\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Close\"]")
    public MobileElement cartClose;


    @AndroidFindBy(id = "iv_user_avatar")
    @iOSXCUITFindBy(accessibility = "User profile")
    public MobileElement profileIcon;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Cancel\"]")
    @AndroidFindBy(xpath = "//*[text='Cancel']")
    public WebElement close;


    //promo code enter button
    @iOSXCUITFindBy(accessibility = "Apply Promo Code")
    @AndroidFindBy(id = "btn_next")
    public MobileElement promoCodeEnterButton;

    // one product in cart
    @iOSXCUITFindBy(xpath = "//*[@label=\"Quantity\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tvQuantity')]")
    public MobileElement oneincart;

    // one product in cart
    @iOSXCUITFindBy(xpath = "//*[@label=\"Update\"]")
    public MobileElement updateqty;

    // edit QTY
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'etQuantityNotEditable')]")
    public MobileElement editqty;
    //daywheel
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[1]")
    @AndroidFindBy(id = "datePicker")
    public MobileElement dayWheel;

    //Timewheel
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[2]")
    @AndroidFindBy(id = "timePicker")
    public MobileElement Timewheel;

    //chooseDateAndTime
    @iOSXCUITFindBy(xpath = "//*[@label=\"Choose time and date\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Choose date and time\"]")
    public MobileElement choosedateandtime;


}

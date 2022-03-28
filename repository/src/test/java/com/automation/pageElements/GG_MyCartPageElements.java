package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_MyCartPageElements {

    @AndroidFindBy(id = "iv_cart")
//    @iOSXCUITFindBy(id = "btnCartWithBadge")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Cart'")
    public MobileElement myCart;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Checkout\"]")
    @AndroidFindBy(id = "checkoutButton")
    public MobileElement checkoutButton;

    @iOSXCUITFindBy(accessibility = "Full carts & happy hearts")
    @AndroidFindBy(id = "emptyCartImage")
    public MobileElement emptyCartImage;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name BEGINSWITH 'Remove'")
    @AndroidFindBy(id = "tvRemove")
    public MobileElement removeIcon;

    @iOSXCUITFindBy(accessibility = "Happy shopping!")
    @AndroidFindBy(id = "emptyCartImage")
    public MobileElement emptyCartImageV2;

    //    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Remove' AND name == 'Remove' AND type == 'XCUIElementTypeButton'")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Remove\"]")
    @AndroidFindBy(id = "iv_remove_cart_item_card")
    public MobileElement removeButtonWithPreviousSwipe;

    @AndroidFindBy(id = "tv_cart_count")
    @iOSXCUITFindBy(accessibility = "btnCartWithBadge")
    public MobileElement cartIconWithCount;

    @AndroidFindBy(className = "android.widget.ProgressBar")
    @iOSXCUITFindBy(iOSNsPredicate = "type=\"XCUIElementTypeStaticText\" AND label BEGINSWITH 'Loading'")
    public MobileElement loadingSpinner;


    @AndroidFindBy(id = "tvRegularTitle")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"lblTopNavBarTitle\"]")
    public MobileElement myCartScreenTitle;

    //Involves ALB screen and id is missing for iOS
    @AndroidFindBy(xpath = "//*[contains(@text,'-')]")
    @iOSXCUITFindBy(iOSNsPredicate = "PENDING")
    public List<MobileElement> decrementButton;

    //Involves ALB screen and id is missing for iOS
    @AndroidFindBy(xpath = "//*[contains(@text,'+')]")
    @iOSXCUITFindBy(iOSNsPredicate = "PENDING")
    public List<MobileElement> incrementButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tv_cart_count') or contains(@resource-id,'tvTotalItemCount')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'btnCartWithBadge') or contains(@name,'Cart')]")
    public MobileElement myCartCount;


    @AndroidFindBy(id = "checkoutButton")
    @iOSXCUITFindBy(id = "Checkout")
    public MobileElement checkOutButton;

    @AndroidFindBy(id = "addButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Checkout']")
    public MobileElement addButton;

    @AndroidFindBy(id = "homeContainerFragment")
    @iOSXCUITFindBy(accessibility = "HOME")
    public MobileElement homeTab;

    @AndroidFindBy(id = "estimatedTotalmoreInfo")
    @iOSXCUITFindBy(accessibility = "Est. Subtotal:")
    public MobileElement estimatedTotalLabel;

    @AndroidFindBy(accessibility = "Close")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeButton\" and label == \"Done\"")
    public MobileElement doneEstimatedTotalButton;

    @AndroidFindBy(id = "info_txt")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextView' AND name BEGINSWITH 'The actual amount'")
    public MobileElement estimatedTotalScreenText;

    @AndroidFindBy(id = "txt_total_amount")
    @iOSXCUITFindBy(xpath = "//*[@name='Estimated Total']//following-sibling:: XCUIElementTypeStaticText")
    public MobileElement cartTotalText;

    @AndroidFindBy(id = "txtOfferClipped")
    @iOSXCUITFindBy(xpath = "(//*[@name='Coupon Clipped']//following-sibling::XCUIElementTypeOther)[1]")
    public MobileElement offerDetails;

    @AndroidFindBy(id = "close")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name=='Edit Order'")
    public MobileElement backToEditOrder;

    @AndroidFindBy(id = "btn_checkout_pay")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Checkout' AND name == 'Checkout' AND value == 'Checkout'")
    public MobileElement checkoutButtonEditCart;


    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"close\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"btnTopNavBarRight\"]")
    public MobileElement closeIcon;

    @AndroidFindBy(id = "slot_selection_btn")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name=='Continue to payment method'")
    public MobileElement continueToPayment;


    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"slide\")][1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"lblpricePerQuantity\"])[1]")
    public MobileElement firstCard;


    @AndroidFindBy(id = "tvRegularTitle")
//    @AndroidFindBy(id = "tvTotal")
    @iOSXCUITFindBy(xpath = "//*[contains(@label, \"My Cart (\")]")
    public MobileElement quantityCounter;


}

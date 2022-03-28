package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import java.util.List;

public class CartPageElements {

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name BEGINSWITH 'Items'")
    @AndroidFindBy(id = "tvRegularTitle")
    public MobileElement totalNumber;

    @AndroidFindBy(id = "iv_cart")
    @iOSXCUITFindBy(id = "btnCartWithBadge")
    public MobileElement myCart;


    // @iOSXCUITFindBy(xpath="//*[contains(@label,\"Cart\")]")


    @iOSXCUITFindBy(xpath = "//*[contains(@label,'items')]")
    public MobileElement itemsCount;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Close\"]")
    public MobileElement CloseButton;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Estimated total, Info\"]")
    public MobileElement estimatedTotalInfoIcon;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"No\"]")
    public MobileElement confirmPopupNo;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Estimated Taxes And Fees\"]")
    public MobileElement taxFeesheet;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Estimated taxes and fees, Info\"]")
    public MobileElement informationIcon;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Estimated Taxes And Fees\"]")
    public MobileElement estimatedTaxSheet;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label=\"Estimated Total\"]")
    public MobileElement esttotalSheet;


    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Cart\")]")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Cart\")")
    public MobileElement myCartTitle;

    //note to personal shopper text edit field
    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    @AndroidFindBy(id = "etNote")
    public MobileElement noteForShopperEditText;

    @iOSXCUITFindBy(xpath = "//*[contains(@name, \"lblPrice\")] | //*[contains(@name, \"Quantity in cart\")] | //*[contains(@name, \"btnProductCartUnavailableViewSimilar\")] | //XCUIElementTypeCell[1]/XCUIElementTypeButton[1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"product_price\")] | //*[contains(@resource-id,\"tv_cart_title_price\")]")
    public List<MobileElement> cartItemsImageList;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name BEGINSWITH 'Increment quantity'")
    @AndroidFindBy(id = "btnPlus")
    public MobileElement plusButton;

    //increase quantity:
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name CONTAINS 'Increment'")
    @AndroidFindBy(id = "btnPlus")
    public List<MobileElement> plusButtonList;

    //decrease quantity
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name CONTAINS 'Decrement'")
    @AndroidFindBy(id = "btnMinus")
    public List<MobileElement> minusButtonList;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name BEGINSWITH 'Remove' AND visible == 1")
    @AndroidFindBy(id = "ctaClose")
    public MobileElement removeIcon;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Happy shopping!\"]")
    @AndroidFindBy(id = "emptyCartImage")
    public MobileElement emptyCartImage;

    //    @iOSXCUITFindBy(accessibility = "Done")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"btnTopNavBarRight\"]")
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='close'] | //android.widget.ImageButton[@content-desc='Close']")
    @CacheLookup
    public MobileElement closeButton;


    //old checkout btn//@AndroidFindBy(id = "btn_checkout_pay")

    @iOSXCUITFindBy(xpath = "//*[@name=\"Checkout\"]")
    @AndroidFindBy(id = "checkoutButton")
    public MobileElement checkoutButton;


    @AndroidFindBy(id = "back")
    public MobileElement backButton;

    // Toggle to PickUp
    @iOSXCUITFindBy(accessibility = "Pickup")
    public MobileElement toggleToPickup;

    // Toggle to Delivery
    @iOSXCUITFindBy(accessibility = "Delivery")
    public MobileElement toggleToDelivery;

    // Continue Payment CTA
    @iOSXCUITFindBy(xpath = "//*[@value=\"Continue to payment method\"]")
    public MobileElement continuePaymentCTA;

    // Continue Slot Selection
    @iOSXCUITFindBy(xpath = "//*[@value=\"Continue to slot selection\"]")
    public MobileElement continueSlotSelection;

    // Add Address Screen
    @iOSXCUITFindBy(xpath = "//*[@label=\"Add address\"]")
    public MobileElement verifyAddAddressPageIsDisplayed;

    // back button on Add Address Screen
    @iOSXCUITFindBy(xpath = "//*[@label=\"Back\"]")


    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Back\"]")


    public MobileElement backButtonAddAddressPage;

    // Close Slot Selection Screen
    @iOSXCUITFindBy(xpath = "//*[@label=\"Close\"]")
    public MobileElement closeSlotSelectionScreen;

    // click review order
    @iOSXCUITFindBy(xpath = "//*[@value=\"Continue to review order\"]")
    public MobileElement reviewOrder;

    // Continue Contact Info
    @iOSXCUITFindBy(xpath = "//*[@value=\"Continue to contact info\"]")
    public MobileElement continueContactInfo;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,'2 of 7')]")
    public MobileElement dayNextToToday;

    // Confirm Popup
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Yes\"]")
    public MobileElement confirmPopup;

    // click Enter Payment
    @iOSXCUITFindBy(xpath = "//*[@label=\"Enter payment\"]")
    public MobileElement clickEnterpayment;

    @AndroidFindBy(id = "btn_checkout_pay")
    //  @AndroidFindBy(xpath = "//*[@resource-id=\"com.safeway.client.android.tomthumb.debug:id/btn_checkout_pay\"]")
    public MobileElement inStoreButton;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeOther' AND name BEGINSWITH 'Items' AND visible == 1")
    @AndroidFindBy(id = "txt_total_amount")
    @CacheLookup
    public MobileElement totalAmount;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name BEGINSWITH 'Estimated Total' AND visible == 1")
    @AndroidFindBy(id = "estimatedTotalmoreInfo")
    public MobileElement EstimatedTotalInfoIcon;


    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name BEGINSWITH 'Estimated Reward Card Savings'")
    @AndroidFindBy(id = "moreInfo")
    public MobileElement EstimatedRewardSavingsInfoIcon;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Estimated Total\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Estimated Total\"]")
    public MobileElement EstimatedTotalText;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name BEGINSWITH 'Estimated Reward Card Savings'")
    @AndroidFindBy(xpath = "//*[@text=\"Estimated Reward Card Savings\"]")
    public MobileElement EstimatedRewardCardSavingsText;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Estimated Club Card Savings\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Estimated Club Card Savings\"]")
    public MobileElement EstimatedClubCardSavingsText;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name CONTAINS 'Savings'")
    @AndroidFindBy(id = "moreInfo")
    public MobileElement EstimatedSavingsInfoIcon;


    // @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeButton[5]")

    //@iOSXCUITFindBy(xpath = "//*[@label=\"ï¹¢\"] | //*[@label=\"Increment quantity\"]")
    //@AndroidFindBy(xpath="//android.view.ViewGroup[1]/android.widget.Button[1]/android.widget.Button[2] | //*[contains(@resource-id,'btnPlus')]")
    //@AndroidFindBy(id = "increaseView | iv_stepper_plus")//old id

    //@iOSXCUITFindBy(xpath = "//*[@label=\"Increment quantity\"]")
    //@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name CONTAINS 'Increment'")

    //  @iOSXCUITFindBy(xpath="//XCUIElementTypeCell/XCUIElementTypeOther[9] | //XCUIElementTypeTable/XCUIElementTypeOther[3]")
    //   @AndroidFindBy(xpath = "//*[contains(@resource-id,'iv_stepper_plus')]")
    //  public List<MobileElement> quantityFieldList;

//            "//*[contains(@resource-id,'btnPlus')]")

    @iOSXCUITFindBy(xpath = "//*[@label=\"Increment quantity\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'btnPlus') and @enabled = 'true']")
    public List<MobileElement> quantityFieldList;


    //@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeOther[9] | //XCUIElementTypeTable/XCUIElementTypeOther[3]")
    //@AndroidFindBy(xpath = "//*[contains(@resource-id,'iv_stepper_plus')]")
    // public List<MobileElement> quantityFieldList;

//            "//*[contains(@resource-id,'btnPlus')]")


    @iOSXCUITFindBy(xpath = "//*[@label=\"close\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Close\"]")
    public MobileElement cartClose;

    @iOSXCUITFindBy(xpath = "//*[@label=\"-\"]")
    @AndroidFindBy(id = "decreaseView | iv_stepper_minus")
    public List<MobileElement> reduceQuantityList;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Edit Cart Back\"]")
    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"back button to take you back\")]")
    public MobileElement EditCartBack;

    @iOSXCUITFindBy(xpath = "//*[@name=\"Save changes\"]")
    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Confirm changes\")]")
    public MobileElement SaveChanges;

    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"Cart Preview\")]")
    public MobileElement CartPreviewinEditOrder;

    @iOSXCUITFindBy(xpath = "//*[@name=\"btnRoundQuantity\"]")
    public MobileElement CartRoundBtnQuantity;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"btnStepperView\"]")
    public MobileElement btnStepperView;

    @iOSXCUITFindBy(xpath = "//*[@name=\"trailing0\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"iv_remove_cart_item_card\") and @focusable=\"true\"]")
    //  @AndroidFindBy(xpath = "//*[contains(@resource-id,'remove_cart_item')]")
    public MobileElement swipeRemoveButton;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"No substitution on all unavailable items\"])[1]")
    @AndroidFindBy(id = "substitution_checkbox")
    public WebElement globalSubstitutionCheckbox;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'No substitution if unavailable'")
    @AndroidFindBy(id = "no_substitution_checkbox")
    public List<MobileElement> itemSubstitutionCheckboxList;

    @iOSXCUITFindBy(accessibility = "Cart Summary")
    @AndroidFindBy(uiAutomator = "ew UiSelector().text(\"Cart Summary\")")
    public MobileElement cartSummary;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeButton[4] | //XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeButton[1]")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.TextView[1] | //android.widget.FrameLayout[1]/android.widget.Button[1]/android.widget.TextView[1]")
    public MobileElement bogoElementAdded;

    //    @iOSXCUITFindBy(xpath = "//*[@label=\"Cart\"]")
//    @AndroidFindBy(id = "cart_title")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"iv_cart_right_arrow\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"Cart Preview\")]")
    public MobileElement cartInEditOrder;

    @iOSXCUITFindBy(xpath = "//*[@name=\"Edit your order\"]")
    public MobileElement EditOrderPage;

    @AndroidFindBy(id = "tvOrderOperation")
    //@AndroidFindBy(xpath = "//*[contains(@resource-id,\"iv_cart_right_arrow\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Edit order\"]")
    public MobileElement EditOrder;
    @iOSXCUITFindBy(xpath = "//*[@label=\"Edit Order\"]")

    @AndroidFindBy(xpath = "//*[@content-desc=\"Close\"]")
    public MobileElement backInCartEditOrder;


    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"No substitution on all unavailable items\"])[1]")
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[2]/android.widget.TextView[1]")
    public MobileElement noSubstitutionPreference;


    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name BEGINSWITH 'My List'")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"My List\")")
    public MobileElement inStoreHeader;


    @iOSXCUITFindBy(xpath = " //*[@label=\"Quantity in cart\" and @value=\"2\"]//*[@label=\"ï¹¢\"]")
    @AndroidFindBy(xpath = "//*[@label=\"ï¹¢\"]")
    public WebElement cartPageIncremental;
    @iOSXCUITFindBy(xpath = "//*[@label=\"ï¹¢\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'increaseView')]")
    public WebElement cartPageFirstMilkIncremental;
    //*[@resource-id="com.safeway.client.android.tomthumb.debug:id/increaseView"]
    @iOSXCUITFindBy(xpath = "//*[@label=\"Cart\"]")
    @AndroidFindBy(xpath = "//*[@text=\"My Cart\"]")
    public WebElement cartSummarymyCart;
    @iOSXCUITFindBy(xpath = " //*[@label=\"Remove Lucerne Milk Whole 1 Gallon - 128 Fl. Oz.\"]")
    @AndroidFindBy(xpath = " //*[contains(@resource-id,'tvRemove')]")
    public List<WebElement> removeMilk;
    //*[@resource-id="com.safeway.client.android.tomthumb.debug:id/tvRemove"]

    @iOSXCUITFindBy(xpath = " //*[@label=\"Done\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Close\"]")
    public WebElement doneCartpage;

    //*[@content-desc="Close"]
    @iOSXCUITFindBy(xpath = "//*[@label=\"Remove Lucerne Milk Whole 1 Gallon - 128 Fl. Oz.\"]")
    @AndroidFindBy(xpath = " //*[contains(@resource-id,'tvRemove')]")
    public MobileElement removeButton;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Checkout\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'btn_checkout_pay')]")
    public MobileElement checkoutButtonCartPage;
    //*[@resource-id="com.safeway.client.android.tomthumb.debug:id/btn_checkout_pay"]
    //*[@resource-id="com.safeway.client.android.tomthumb.debug:id/btn_checkout_pay"]

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Change Shopping Method\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'btn_change_shop_method')]")
    public WebElement changeShoppingMethod;
    //*[@resource-id="com.safeway.client.android.tomthumb.debug:id/btn_change_shop_method"]
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Pay In-Store\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'btn_checkout_pay')]")
    public WebElement payInStore;
    //*[@resource-id="com.safeway.client.android.tomthumb.debug:id/btn_checkout_pay"]
    //*[@resource-id="com.safeway.client.android.tomthumb.debug:id/fragment_container"]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.Button[3]

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Checkout\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'btn_checkout_pay')]]")
    public MobileElement checkoutOnCartPage;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Estimated Total\")]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tvEstimatedTotal')]")
    public MobileElement EstimatedTotalInfoButton;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Save\")]")
    @AndroidFindBy(id = "buttonSave")
    public MobileElement preferencesSaveButton;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Cancel\")]")
    @AndroidFindBy(id = "buttonCancel")
    public MobileElement preferencesCancelButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]")
    public MobileElement noteCharacterLimit;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeButton[4]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView[1]/android.widget.Button[1]")
    public MobileElement clickfirstItem;


    @AndroidFindBy(id = "my_toolbar")
    @iOSXCUITFindBy(className = "XCUIElementTypeNavigationBar")
    public MobileElement navBanner;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Estimated SubTotal\")]")
    @AndroidFindBy(xpath = "//*[contains(@text,\"Estimated SubTotal\")]")
    public MobileElement estimatedSubTotal;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Estimated Total\")]")
    @AndroidFindBy(xpath = "//*[contains(@text,\"Estimated Total\")]")
    public MobileElement estimatedTotal;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Reward Card\")]")
    @AndroidFindBy(xpath = "//*[contains(@text,\"Reward Card\")]")
    public MobileElement rewardCard;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Estimated Tax\")]")
    @AndroidFindBy(xpath = "//*[contains(@text,\"Estimated Tax\")]")
    public MobileElement estimatedTax;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Delivery or Pickup\")]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'btn_change_shop_method')]")
    public WebElement deliveryPickUp;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tv_stepper_quantity') or contains(@resource-id,'itemParentLayout') or contains(@resource-id,'slide_to_refresh')]")

    //@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]")
    // @AndroidFindBy(xpath="//*[contains(@resource-id,'itemParentLayout')]")
    //  @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[1]")
    //   @AndroidFindBy(xpath="//*[contains(@resource-id,'tv_stepper_quantity') or contains(@resource-id,'itemParentLayout') or contains(@resource-id,'slide_to_refresh')]")

    public MobileElement firstCartItem;


    @AndroidFindBy(id = "iv_cart")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, \"Cart\")] | //XCUIElementTypeButton[contains(@name, \"List\")]")
    public MobileElement shoppingCartButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'btnMinus')]")
    public MobileElement cartMinusIcon;

    @AndroidFindBy(xpath = "//*[@text='ADD TO CART']")
    public List<MobileElement> addToCartButton;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"EBT Card\")]")
    @AndroidFindBy(xpath = "//*[contains(@text,\"EBT Card\")]")
    public MobileElement checkoutEBTCardCTA;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"EBT\")]")
    @AndroidFindBy(xpath = "//*[contains(@text,\"EBT\")]")
    public MobileElement checkoutEBTLink;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name BEGINSWITH 'Sign In' AND visible == 1")
    //old cart //@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"My Cart\")")
    @AndroidFindBy(xpath = "//*[contains(@text,\"Sign In\")]")
    public MobileElement snapSheetTitle;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Increment quantity\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'btnPlus')]")
    public List<MobileElement> pdp_quantityFieldList;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Close\"]")
    public MobileElement AddAdressCloseButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Driver tip\"]")
    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Driver tip heading\")]")
    public MobileElement DriverTip;

    @iOSXCUITFindBy(xpath = "//*[@name=\"Change\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Change Driver Tip Amount\"]")
    public MobileElement ChangeLink;

    @iOSXCUITFindBy(xpath = "//*[@name=\"Add a custom tip\"]")
    @AndroidFindBy(xpath = "//*[contains(@content-desc,\"Add a custom tip\")]")
    public MobileElement AddCustomTipWindow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Custom Tip\"]")
    @AndroidFindBy(xpath = "//android.widget.RadioButton[contains(@content-desc,\"Custom tip\")]")
    public MobileElement CustomTip;


    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeTextField']")
    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Enter tip amount\"]")
    public MobileElement CustomTipField;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Apply\"]")
    @AndroidFindBy(xpath = "//*[starts-with(@text,'Apply')]")
    public MobileElement customtipapply;

    @AndroidFindBy(id = "saveCustomTipButton")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Save\"]")
    public MobileElement customtipsave;

    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"Tip cannot exceed\")]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"Tip cannot exceed\")]")
    public MobileElement CustomTipErrMsg;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"messageLabel\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"NOTE: Your entered gratuity\")]")
    public MobileElement ToastMessage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@label,\"Your total\")]")
    @AndroidFindBy(id = "subtotalText")
//android.widget.TextView[@content-desc="$54.89"]
    public MobileElement CartTotalAmount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Apply\"]")
    @AndroidFindBy(xpath = " //*[@content-desc=\"Apply button\"]")
    public MobileElement ApplyButton;


    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Back\"]")
    public MobileElement BackButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Close slot selection screen\"]")
    public MobileElement CloseSlotScreen;


    @AndroidFindBy(id = "secondaryButton")
    public MobileElement NoSaveButton;
    //android.widget.Toast


    @AndroidFindBy(id = "iv_stepper_plus")
    @iOSXCUITFindBy(accessibility = "btnStepperView")
    public MobileElement stepperView;


    @AndroidFindBy(id = "iv_stepper_plus")
    public MobileElement incrementProductQty;

    @AndroidFindBy(id = "iv_stepper_minus")
    public MobileElement decrementProductQty;


}

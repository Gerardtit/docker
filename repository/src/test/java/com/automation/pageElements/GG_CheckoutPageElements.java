package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_CheckoutPageElements {

    @iOSXCUITFindBy(id = "Contact")
    @AndroidFindBy(id = "contact_title")
    public MobileElement contactLabel;

    @iOSXCUITFindBy(id = "Order Info")
    @AndroidFindBy(id = "orderInfo_txt")
    public MobileElement orderInfoLabel;

    @iOSXCUITFindBy(id = "Payment")
    @AndroidFindBy(id = "payment_title")
    public MobileElement paymentLabel;

    @iOSXCUITFindBy(id = "Promo Code(s)")
    @AndroidFindBy(id = "promo_code_title")
    public MobileElement promoCodeLabel;

    @iOSXCUITFindBy(id = "Cart")
    @AndroidFindBy(id = "cart_title")
    public MobileElement cartLabel;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label BEGINSWITH 'Contact'")
    @AndroidFindBy(id = "cart_title")
    public MobileElement addContactLink;

    @iOSXCUITFindBy(xpath = "(//*[@name='Contact']/following-sibling::XCUIElementTypeStaticText)[1]")
    @AndroidFindBy(id = "right_arrow")
    public MobileElement addPhoneNumber;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Phone Number Field is required']/..//android.widget.LinearLayout//android.widget.EditText")
    @iOSXCUITFindBy(id = "Phone Number textfield, field is required.")
    public MobileElement phoneNumberTextField;

    @AndroidFindBy(id = "type_pickup_card")
    @iOSXCUITFindBy(id = "Pickup")
    public MobileElement pickUpShoppingMode;

    @AndroidFindBy(id = "start_shopping")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Start shopping\"]")
    public MobileElement startShoppingButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'et_zip_code')]//android.widget.EditText[contains(@resource-id,'edit_text')]")
    @iOSXCUITFindBy(accessibility = "Zip Code")
    public MobileElement zipCodeTextField;

    @AndroidFindBy(id = "btn_next")
    @iOSXCUITFindBy(id = "whiteRightArrow")
    public MobileElement zipCodeRightArrow;

    @AndroidFindBy(id = "address")
    @iOSXCUITFindBy(xpath = "(//*[@name='lblStoreAddress' and @visible='true'])[1]")
    public MobileElement firstStoreCard;

    @AndroidFindBy(id = "address")
    @iOSXCUITFindBy(iOSNsPredicate = "name == \"lblStoreAddress\" and visible==1")
    public List<MobileElement> allStoreCardsList;

    @AndroidFindBy(id = "radioButtonSnapEbt")
    @iOSXCUITFindBy(iOSNsPredicate = "type =='XCUIElementTypeButton' AND label CONTAINS 'SNAP'")
    public MobileElement snapEBT;

    @AndroidFindBy(id = "checkoutButton")
    @iOSXCUITFindBy(accessibility = "btnCartCheckout")
    public MobileElement checkoutButton;

    @AndroidFindBy(id = "editSearch")
    @iOSXCUITFindBy(id = "Search for Products")
    public MobileElement searchField;

    @AndroidFindBy(id = "tv_change_address_store")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Edit\"]")
    public MobileElement editStore;

    @AndroidFindBy(id = "sv_global")
    @iOSXCUITFindBy(accessibility = "btnSearchBarViewButton")
    public MobileElement searchButton;

    // slot selection screen
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'SlotSelectionView')]")
    public MobileElement slotSelectionScreen;

    // Your order screen
    @iOSXCUITFindBy(xpath = "//*[@label=\"Your order\"]")


    @AndroidFindBy(xpath = "//*[@text='Your order']")

    public MobileElement verifyYourOrderScreen;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"View cart\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'View cart'  AND type='XCUIElementTypeButton' AND visible==1")
    public MobileElement viewCartPopUp;

    @AndroidFindBy(id = "tvRemove")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name BEGINSWITH 'Remove'")
    public List<MobileElement> removeButton;

    @AndroidFindBy(accessibility = "Close")
    @iOSXCUITFindBy(accessibility = "Checkout")
    public MobileElement backButtonToCheckOut;

    @AndroidFindBy(accessibility = "SNAP Eligible Item Subtotal:")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'SNAP Eligible Item Subtotal:'")
    public MobileElement snapEligibleTotal;

    @AndroidFindBy(accessibility = "Non-SNAP Eligible Item Subtotal:")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Non-SNAP Eligible Item Subtotal:'")
    public MobileElement nonSnapEligibleTotal;

    @AndroidFindBy(id = "iv_cart")
    @iOSXCUITFindBy(id = "btnCartWithBadge")
    public MobileElement myCart;

    @AndroidFindBy(id = "umaStepperPlus")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == '﹢'")
    public MobileElement plusButton;

    @AndroidFindBy(id = "payment_error_msg")
    @iOSXCUITFindBy(accessibility = "Confirm CVV")
    public MobileElement confirmCVV;

    @AndroidFindBy(xpath = "//*[@text=\"Continue\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Continue\"]")
    public MobileElement continuePopup;

    @AndroidFindBy(xpath = "//*[@text=\"Go back\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Go back\"]")
    public MobileElement goBack;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"/search_src_text\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeTextField[1]")
    public MobileElement zipCodeField;

    @AndroidFindBy(id = "order_info_nav")
    @iOSXCUITFindBy(accessibility = "Choose time and date")
    public MobileElement chooseDateAndTimeArrow;

    @AndroidFindBy(id = "order_info_nav")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"Delivery.SlotSelectionView\")]")
    public MobileElement selectPref;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"/map_checkout_store\")]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"viewStoreMapView\"]")
    public MobileElement mapView;


    @AndroidFindBy(xpath = "//*[@text=\"Your item prices, promos and item availability may change.\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Your item prices, promos and item availability may change.\"]")
    public MobileElement popUpMessage;

    @AndroidFindBy(id = "slot_selection_btn")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Save'")
    public MobileElement saveButton;

    @AndroidFindBy(accessibility = "Confirm CVV")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND label == 'Confirm CVV'")
    public MobileElement confirmCVVTextField;

    @AndroidFindBy(accessibility = "Estimated Total")
    @iOSXCUITFindBy(iOSNsPredicate = "PENDING")
    public MobileElement estimatedTotal;

    @AndroidFindBy(id = "promo_code_title")
    @iOSXCUITFindBy(accessibility = "Promo Code(s)")
    public MobileElement promoCodes;

    @AndroidFindBy(id = "substitution_checkbox")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'No substitution on all unavailable items'")
    public MobileElement globalSubstitution;

    @AndroidFindBy(id = "confirm_cvv")
    @iOSXCUITFindBy(id = "Confirm CVV")
    public MobileElement confirmCVVLabel;


    @AndroidFindBy(id = "btn_checkout")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Place order'")
    public MobileElement placeOrderButton;

    @AndroidFindBy(accessibility = "Close")
    @iOSXCUITFindBy(accessibility = "Done")
    public MobileElement doneButton;

    @AndroidFindBy(accessibility = "Close")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name BEGINSWITH 'My Cart'")
    public MobileElement backButtonToCartScreen;

    @AndroidFindBy(accessibility = "View order status details")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'View details'")
    public MobileElement viewDetailsButton;

    @AndroidFindBy(id = "cart_title")
    @iOSXCUITFindBy(accessibility = "Cart")
    public MobileElement editCart;

    @AndroidFindBy(id = "ctaCartSearch")
    @iOSXCUITFindBy(accessibility = "viewSearchView")
    public MobileElement searchFieldInEditCart;

    @AndroidFindBy(accessibility = "Back / Navigation Up")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Cancel' AND name == 'Cancel' AND value == 'Cancel'")
    public MobileElement cancelButton;

    @AndroidFindBy(accessibility = "2-hour Tom Thumb/Partner Delivery,")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == '2‑hour Tom Thumb Delivery'")
    public MobileElement timeDelivery;

    @AndroidFindBy(id = "currentReserveTimeTv")
    @iOSXCUITFindBy(iOSNsPredicate = "PENDING")
    public MobileElement changeTime;

    @AndroidFindBy(id = "orderInfo_txt")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Order Info\" AND visible==1")
    public MobileElement orderInfoLink;

    @AndroidFindBy(accessibility = "Place Order")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Confirm changes'")
    public MobileElement confirmChanges;

    @AndroidFindBy(id = "btn_continue_shopping")
    @iOSXCUITFindBy(accessibility = "continueShoppingButton")
    public MobileElement continueShoppingAfterEditButton;

    @AndroidFindBy(id = "update_your_order_content")
    @iOSXCUITFindBy(accessibility = "To update your order, visit your Orders page.")
    public MobileElement updateOrderLink;

    @AndroidFindBy(id = "cancel_order")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Cancel Order'")
    public MobileElement cancelOrderButton;

    @AndroidFindBy(id = "button1")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Cancel Order'")
    public MobileElement cancelOrderPopUpButton;

    @AndroidFindBy(accessibility = "Confirm CVV")
    public MobileElement confirmCVVArrow;

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(accessibility = "Orders")
    public MobileElement backToOrder;

    @AndroidFindBy(id = "promo_code")
    @iOSXCUITFindBy(id = "Confirm CVV")
    public MobileElement promoCode;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Order Info\" AND visible==1")
    @AndroidFindBy(id = "orderInfo_txt")
    public MobileElement orderInfoText;

    @AndroidFindBy(accessibility = "Please enter a valid phone number.")
    public MobileElement phoneNoInvalidErrMsg;


    @AndroidFindBy(xpath = "//*[contains(@resource-id,'iv_contact_right_arrow')]")
    public MobileElement editContactBtn;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue to review order\"]")
//@AndroidFindBy(xpath ="//android.widget.Button[@text=\"Save\"]")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button[2]")
    public MobileElement Continue_to_review_order;


    @AndroidFindBy(accessibility = "Close slot selection screen")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Close'")
    public MobileElement closeSlotSelectionSheet;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Yes\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Yes' AND type= 'XCUIElementTypeButton' AND visible==1")
    public MobileElement yesConfirmChanges;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"No\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'No' AND type= 'XCUIElementTypeButton' AND visible==1")
    public MobileElement noConfirmChanges;

    @AndroidFindBy(id = "btnClose")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Close'")
    public MobileElement closeContactInfoSheet;

    @AndroidFindBy(id = "bottom_sheet_close")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Close'")
    public MobileElement closePaymentSheet;

    @AndroidFindBy(xpath = "//*[contains(@text,'Non-SNAP eligible items (')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Non-SNAP eligible items (' AND visible==1")
    public MobileElement nonSNAPEligibleItemsHeader;

    @AndroidFindBy(id = "appCompatTextView")
    public MobileElement nonSNAPEligibleItemsSubHeader;

    @AndroidFindBy(id = "non_snap_cart_close")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Non-SNAP eligible items Close' AND visible==1")
    public MobileElement nonSNAPEligibleItemsClose;

    @AndroidFindBy(id = "btn_non_snap_remove_all")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Remove all items' AND name == 'Remove all items'")
    public MobileElement nonSNAPEligibleItemsRemoveAll;

    @AndroidFindBy(id = "tv_cart_dept_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='lblTitle']")
    public List<MobileElement> nonSNAPEligibleItemsCategories;

    @AndroidFindBy(id = "tv_snap_title_price")
    @iOSXCUITFindBy(id = "lblPrice")
    public List<MobileElement> nonSNAPEligibleItemsList;

    @AndroidFindBy(id = "tv_cart_description")
    @iOSXCUITFindBy(accessibility = "lblpricePerQuantity")
    public List<MobileElement> nonSNAPSCPEligibleItemsList;

    @AndroidFindBy(id = "tv_cart_description")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeButton[@visible='true' and not(contains(@label,'Remove'))]")
    public List<MobileElement> nonSNAPEligibleItemsProductCards;

    @AndroidFindBy(id = "progress_indicator")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Please' OR label BEGINSWITH 'Loading'")
    public MobileElement loadingSpinner;

    @AndroidFindBy(accessibility = "Back button")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Back'")
    public MobileElement backButtonToCart;

    @AndroidFindBy(id = "iv_remove_snap_item_card")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Remove' AND type='XCUIElementTypeButton' AND visible==1")
    public MobileElement removeBtn;

    @iOSXCUITFindBy(iOSNsPredicate = "value CONTAINS[c] 'Name on the Debit'")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'cc-name')]")
    public MobileElement creditCardNameField;
    
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Please enter a valid name.'")
    @AndroidFindBy(xpath = "//*[contains(@text,'Please enter a valid name')]")
    public MobileElement enterValidName;

    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Card number'")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'cc-number')]")
    public MobileElement creditCardNumberField;

    @iOSXCUITFindBy(iOSNsPredicate = "value CONTAINS[c] 'MM'")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'monthyear')]")
    public MobileElement creditCardExpirationDateField;

    @iOSXCUITFindBy(iOSNsPredicate = "value == 'ZIP Code'")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'zipcode')]")
    public MobileElement creditCardBillingZipCodeField;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Continue to review order'")
    @AndroidFindBy(id = "cvv_button")
    public MobileElement continueToReviewOrderBtn;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Edit your order'")
    @AndroidFindBy(id = "tv_rewards_title")
    public MobileElement editOrderPage;

    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS[c] 'items'")
    @AndroidFindBy(id = "tv_cart_preview_header")
    public MobileElement editCartAndPreferencesButton;


    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Edit Cart Back'")
    @AndroidFindBy(accessibility = "back button to take you back")
    public MobileElement backBtnInEditCartScreen;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Edit order' AND name == 'Edit order'")
    @AndroidFindBy(id = "tvOrderOperation")
    public MobileElement editOrderBtnInOrdersPage;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'View order' AND name == 'View order'")
    @AndroidFindBy(id = "tvOrderOperation")
    public MobileElement viewOrderBtnInOrdersPage;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name=='btnShopPastPurchases' AND label == 'Shop Past Purchases'")
    @AndroidFindBy(id = "ctaPastPurchases")
    public MobileElement pastPurchasesBtn;

    @iOSXCUITFindBy(accessibility = "lblTopNavBarTitle")
    @AndroidFindBy(id = "tvRegularTitle")
    public MobileElement cartCountInEditCart;

    @iOSXCUITFindBy(accessibility = "Search products or deals")
    @AndroidFindBy(id = "editSearch")
    public MobileElement searchFieldInEditCartInSearchPage;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Back'")
    @AndroidFindBy(accessibility = "Navigate up")
    public MobileElement backButtonInProductDetailsPage;

    @iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS 'Items'")
    @AndroidFindBy(id = "tvCartItems")
    public MobileElement itemsCountInEditCart;

    @iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS '$'")
    @AndroidFindBy(id = "subtotalText")
    public MobileElement estimatedSubTotalInEditCart;

    @iOSXCUITFindBy(accessibility = "btnRoundQuantity")
    @AndroidFindBy(id = "cl_stepper")
    public MobileElement numberOfItemsCircledButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == 'btnStepperView'")
    @AndroidFindBy(id = "iv_stepper_plus")
    public MobileElement addBtnInEditCartScreen;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Contact info button, Enter name, Enter mobile number, '")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'Contact info button')]")
    public MobileElement contactInfoButton;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Continue'")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'submit')]")
    public MobileElement continuePaymentButton;

    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS[c] '2 of 7'")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'cardView')][2]")
    public MobileElement nextDayPickupButtons;

    @iOSXCUITFindBy(accessibility = "thanksUserLabel")
    @AndroidFindBy(id = "thank_you_txt")
    public MobileElement orderSavedTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Edit order']")
    @AndroidFindBy(id = "tvOrderOperation")
    public MobileElement editOrderLink;

    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS[c] 'Disabled'")
    @AndroidFindBy(accessibility = "Place Order Disabled")
    public MobileElement confirmChangesDisable;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Edit your order']/XCUIElementTypeButton")
    @AndroidFindBy(accessibility = "Back button")
    public MobileElement cancelOrBackEditOrder;

    @iOSXCUITFindBy(accessibility = "Discard changes")
    @AndroidFindBy(id = "primaryButton")
    public MobileElement discardChanges;

    @iOSXCUITFindBy(iOSNsPredicate = "lable CONTAINS 'Please choose a different day' ")
    @AndroidFindBy(id = "tv_no_slots_available")
    public MobileElement noSlotAvailable;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Continue to payment method\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label =='Continue to payment method'")
    public MobileElement continueToPaymentCTA;

    @AndroidFindBy(id = "cardView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[@visible='true']")
    public List<MobileElement> daySlots;

    @AndroidFindBy(id = "dateRecyclerView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView")
    public MobileElement daySlotsContainer;

    @AndroidFindBy(id = "tv_slot_time")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]")
    public MobileElement pickUpSlotCTA;

    @AndroidFindBy(id = "textViewPayment")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Payment details'")
    public MobileElement enterPayment;

    @AndroidFindBy(id = "cvv_button")
    @iOSXCUITFindBy(accessibility = "Done")
    public MobileElement saveCVV;

    @AndroidFindBy(xpath = "//*[contains(@text,'Store card details')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Store card details'")
    public MobileElement storeCreditCardDetails;

    @AndroidFindBy(id = "switchOrderStatusUpdates")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'flagSwitch'")
    public MobileElement orderStatusUpdatesSwitch;

    @AndroidFindBy(id = "iv_contact_right_arrow")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Contact info' OR label CONTAINS 'First name'")
    public MobileElement contactInfo;

    @AndroidFindBy(id = "textview_confirm_cvv")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Confirm CVV'")
    public MobileElement btnConfirmCVVOrders;

    @AndroidFindBy(id = "tv_address_subheader")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell[1]")
    public MobileElement pickUpStoreOrderScreen;

    @AndroidFindBy(id = "tv_store_address")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='viewStoreListView']/XCUIElementTypeOther/XCUIElementTypeTable//XCUIElementTypeButton")
    public List<MobileElement> pickUpStoreInSelectScreen;

    @AndroidFindBy(id = "checkout_store_list_title")
    public MobileElement selectPickupStoreHeader;

    @AndroidFindBy(id = "bottom_sheet_head")
    public MobileElement bottomSheetHeader;

    @AndroidFindBy(id = "ctaClose")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Cart Back'")
    public MobileElement backBtnCartToCheckout;
}

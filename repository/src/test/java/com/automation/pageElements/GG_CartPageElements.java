package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_CartPageElements {

    @AndroidFindBy(id = "iv_cart")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Cart'")
    public MobileElement cartIcon;

    @AndroidFindBy(xpath = "//*[@text=\"Offer Complete!\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]")
    public MobileElement offerComplete;

    @AndroidFindBy(xpath = "//*[@text=\"Offer completed!\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Offer completed!\"]")
    public MobileElement offerCompleted;

    @iOSXCUITFindBy(id = "tvCenterTitle")
    @AndroidFindBy(id = "tv_cart_count")
    public MobileElement cartIconCount;

    @AndroidFindBy(id = "tvRegularTitle")
    @iOSXCUITFindBy(id = "lblTopNavBarTitle")
    public MobileElement cartHeaderWithCount;

    @AndroidFindBy(id = "ctaClose")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Cart Close' AND visible==1")
    public MobileElement closeCartButton;

    @AndroidFindBy(id = "ctaClose")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Cart Back'")
    public MobileElement closeCartBeforePlaceOrderButton;

    @AndroidFindBy(id = "iv_cart_product_image")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'lblPrice'")
    public MobileElement productImageCart;

    @AndroidFindBy(id = "tv_cart_title_price")
    @iOSXCUITFindBy(iOSNsPredicate = "label contains 'Price is'")
    public MobileElement productPriceCart;

    @AndroidFindBy(id = "cl_cart_view_item")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeButton")
    public MobileElement productTitleCart;

    @AndroidFindBy(id = "tv_cart_price_per_quantity")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'lblpricePerQuantity'")
    public MobileElement productPerUnitPriceCart;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Substitution']")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Substitution' AND name == 'btnSubstitution'")
    public MobileElement productLinkForSubstitutionCart;

    @AndroidFindBy(id = "primaryButton")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Yes' AND name == 'btnYes'")
    public MobileElement buttonOkSetSubstitutionForOtherItems;

    @AndroidFindBy(id = "secondaryButton")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'No' AND name == 'btnNo'")
    public MobileElement buttonNoSetSubstitutionForOtherItems;

    @AndroidFindBy(id = "tv_add_notes")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label=='Add Note'")
    public MobileElement productLinkForNoteCart;

    @AndroidFindBy(id = "tv_approx_title")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Approximate') and @visible='true']")
    public MobileElement productApproxPriceCart;

    @AndroidFindBy(id = "tv_strike_price")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Original Price is') and @visible='true']")
    public MobileElement productPriceStrikethroughCart;

    @AndroidFindBy(accessibility = "back button to take you back")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'lblTitle'")
    public MobileElement productDescriptionLongCart;

    @AndroidFindBy(id = "tv_cart_dept_title")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'lblTitle' AND visible==1")
    public List<MobileElement> productCategoriesCart;

    @AndroidFindBy(id = "ctaLabel")
    @iOSXCUITFindBy(id = "Happy shopping!")
    public MobileElement cartV2HappyShoppingText;

    @AndroidFindBy(id = "ctaButton")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Shop now' AND name == 'Shop now' AND type == 'XCUIElementTypeButton' AND visible==1")
    public MobileElement cartV2ShopNowCTA;

    @AndroidFindBy(id = "subtotalLabel")
    @iOSXCUITFindBy(accessibility = "lblCartEstSubtotalText")
    public MobileElement cartV2EstSubtotal;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'subtotalText')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='lblCartEstSubtotalValue' and @visible='true']")
    public MobileElement cartV2EstSubtotalAmount;

    @AndroidFindBy(id = "subtotalTextStrikePrice")
    public MobileElement cartV2EstSubtotalStrikeThroughAmount;

    @AndroidFindBy(id = "tvCartSummary")
    @iOSXCUITFindBy(id = "lblCartSummary")
    public MobileElement cartV2CartSummary;

    @AndroidFindBy(id = "tvCartItems")
    @iOSXCUITFindBy(iOSNsPredicate = "name contains 'Items'")
    public MobileElement cartV2CartItemsWithCount;

    @AndroidFindBy(id = "tvCartItemsPrice")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'$')]")
    public MobileElement cartV2CartItemsPrice;

    @AndroidFindBy(id = "tvEstimatedSavings")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Estimated savings'])[1]")
    public MobileElement cartV2EstimatedSavings;

    @AndroidFindBy(id = "tvEstimatedSavingsValue")
    @iOSXCUITFindBy(xpath = "//*[contains(@name ,'-$')]")
    public MobileElement cartV2EstimatedSavingsValue;

    @AndroidFindBy(uiAutomator = "new UiSelector(). textContains(\"-$\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label contains '-$' AND type == 'XCUIElementTypeStaticText'")
    public List<MobileElement> savingsList;

    @AndroidFindBy(id = "tvEstimatedSavings")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='newCheckoutInfoButton'])[1]")
    public MobileElement cartV2EstimatedSavingsInfoIcon;

    @AndroidFindBy(id = "tvTitle")
    @iOSXCUITFindBy(accessibility = "Estimated Savings")
    public MobileElement cartV2EstimatedSavingsSheetHeader;

    @AndroidFindBy(id = "ctaClose")
    @iOSXCUITFindBy(accessibility = "Estimated Savings close")
    public MobileElement cartV2EstimatedSavingsSheetCloseButton;

    @AndroidFindBy(id = "tvDescription")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS[c] 'The amount you'")
    public MobileElement cartV2EstimatedSavingsSheetStaticText;

    @AndroidFindBy(id = "tvCartSavings")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Member Price Savings')]")
    public MobileElement cartV2MemberPriceSavings;

    @AndroidFindBy(xpath = "//*[contains(@text,'Employee savings')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Employee Savings')]")
    public MobileElement cartV2EmployeeSavings;

    @AndroidFindBy(id = "tvEstimatedSavings")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Estimated Club Card Savings')]")
    public MobileElement cartV2ClubCardSavings;

    @AndroidFindBy(id = "tvCartSavingsValue")
    @iOSXCUITFindBy(xpath = "(//*[contains(@name,'-$')])[2]")
    public MobileElement cartV2MemberPriceSavingsValue;

    @AndroidFindBy(id = "subtotalLabel")
    @iOSXCUITFindBy(accessibility = "lblCartEstSubtotalText")
    public MobileElement cartV2StaticTextEstSubtotal;

    @AndroidFindBy(id = "tvDisclaimer")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'lblDisclaimerText')]")
    public MobileElement getTextOfCartV2DisclaimerText;

    @AndroidFindBy(id = "tv_cart_dept_title")
    @iOSXCUITFindBy(accessibility = "lblTitle")
    public List<MobileElement> cartV2Categories;

    @AndroidFindBy(id = "checkoutButton")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Checkout' AND name == 'btnCartCheckout'")
    public MobileElement cartV2CheckoutCTA;

    @AndroidFindBy(id = "Pending")
    @iOSXCUITFindBy(id = "Pending")
    public MobileElement cartV2ThresholdText;

    @AndroidFindBy(id = "tv_cart_description")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeButton[@visible='true']")
    public List<MobileElement> productName;

    @AndroidFindBy(id = "tv_stepper_quantity")
    @iOSXCUITFindBy(id = "btnRoundQuantity")
    public MobileElement productQuantity;

    @AndroidFindBy(id = "tv_stepper_quantity")
    @iOSXCUITFindBy(id = "btnRoundQuantity")
    public List<MobileElement> productQuantities;

    @AndroidFindBy(id = "tv_age_restricted")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Age Restricted Item'")
    public MobileElement ageRestrictedLabel;

    @AndroidFindBy(xpath = "//*[contains(@text,'removed from')]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='lblTitle'])[1]")
    public MobileElement unavailableLabel;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tvProductStatus')]")
    @iOSXCUITFindBy(iOSNsPredicate = "value CONTAINS[c] 'Out of' or value CONTAINS[c] 'Not Available for'")
    public MobileElement unavailableProductHeaderLabel;


    @AndroidFindBy(id = "minimumText")
    @iOSXCUITFindBy(accessibility = "lblCartThresholdMessage")
    public MobileElement orderMinimumAmountMessage;

    @AndroidFindBy(id = "iv_stepper_plus")
    public MobileElement incrementProductQty;

    @AndroidFindBy(id = "iv_stepper_minus")
    public MobileElement decrementProductQty;

    @AndroidFindBy(id = "tv_stepper_quantity")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"btnRoundQuantity\"]")
    public MobileElement stepperQty;

    @AndroidFindBy(id = "iv_stepper_plus")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'btnStepperView'")
    public MobileElement stepperView;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Network Problem\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label=='Network Problem' AND type='XCUIElementTypeStaticText' AND visible==1")
    public MobileElement networkProblemMsg;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"OK\")")
    @iOSXCUITFindBy(xpath = "//*[@label='OK' or @label='Ok']")
    public MobileElement okBtnErrorMsg;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Service Problem\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label=='Service Problem' AND type='XCUIElementTypeStaticText' AND visible==1")
    public MobileElement serviceProblemMsg;

    @AndroidFindBy(id = "tv_cart_title_price")
    @iOSXCUITFindBy(iOSNsPredicate = "label contains 'Price is'")
    public List<MobileElement> productPriceList;

    @AndroidFindBy(id = "iv_remove_cart_item_card")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Remove' AND name == 'Remove' AND type == 'XCUIElementTypeButton'")
    public MobileElement removeBtnCart;

    @AndroidFindBy(id = "tvCartItemsPrice")
    @iOSXCUITFindBy(iOSNsPredicate = "name contains '$'")
    public MobileElement cartSummaryTotalAmount;

    @AndroidFindBy(id = "minimumText")
    @iOSXCUITFindBy(accessibility = "lblCartThresholdMessage")
    public MobileElement minimumOrderAmountForCheckout;

    @AndroidFindBy(id = "tvProductDescription")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable//XCUIElementTypeCell")
    public List<MobileElement> productCardUnavailable;

    @AndroidFindBy(id = "ctaViewSimilar")
    @iOSXCUITFindBy(iOSNsPredicate = "label contains 'View Similar' and visible ==1")
    public List<MobileElement> viewSimilarCTA;

    @AndroidFindBy(id = "tvTitle")
    @iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND name='Related Products'")
    public MobileElement relatedProductsPageTitle;

    @AndroidFindBy(accessibility = "Back")
    @iOSXCUITFindBy(accessibility = "Back")
    public MobileElement backBtnInRelatedProductsPage;

    @AndroidFindBy(id = "tvTotalItemCount")
    @iOSXCUITFindBy(accessibility = "Cart")
    public MobileElement cartCountInRelatedProductsScreen;

    @AndroidFindBy(id = "tvProductStatus")
    @iOSXCUITFindBy(accessibility = "Out of stock")
    public MobileElement outOfStockCard;

    @AndroidFindBy(id = "tv_cart_title_price")
    @iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeStaticText' AND name='lblTitle'")
    public MobileElement inStockCard;

    @AndroidFindBy(id = "tv_prop")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Prop 65 Warning'")
    public MobileElement prop65Warning;

    @AndroidFindBy(id = "tvSubstitutionsTitle")
    @iOSXCUITFindBy(accessibility = "pending")
    public MobileElement substitutionTitle;

    @AndroidFindBy(id = "tvSubstitutionQuestion")
    @iOSXCUITFindBy(accessibility = "pending")
    public MobileElement substitutionQuestion;

    @AndroidFindBy(id = "rb_same_brand")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'btnCartRadioButton' and label CONTAINS[c] 'Same brand'")
    public MobileElement sameBrand;

    @AndroidFindBy(id = "rb_same_size")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'btnCartRadioButton' and label CONTAINS[c] 'Same size'")
    public MobileElement sameSize;

    @AndroidFindBy(id = "rb_no_sub")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'btnCartRadioButton' and label CONTAINS[c] 'No substitution'")
    public MobileElement noSubstitutions;

    @AndroidFindBy(id = "ctaSaveSubstitutions")
    @iOSXCUITFindBy(accessibility = "btnCartSubstitutionSave")
    public MobileElement saveSubstitutionsBtn;

    @AndroidFindBy(id = "ctaClose")
    @iOSXCUITFindBy(accessibility = "Substitution preferences close")
    public MobileElement closeSubstitutionsBtn;

    @AndroidFindBy(id = "ctvGlobalSubstitution")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'btnNoSubstitutionCheckbox'")
    public MobileElement noSubstitutionCheckboxBtn;


    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"Cart Preview\")]")
    @AndroidFindBy(xpath = " //androidx.cardview.widget.CardView[contains(@content-desc,\"Cart Button\")]")
    public MobileElement CartPreviewinEditOrder;

    @AndroidFindBy(id = "tv_stepper_quantity")
    @iOSXCUITFindBy(xpath = "//*[@name=\"btnRoundQuantity\"]")
    public MobileElement CartRoundBtnQuantity;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"btnStepperView\"]")
    public MobileElement btnStepperView;


    @AndroidFindBy(xpath = "//*[@text='Substitution']")
    @iOSXCUITFindBy(iOSNsPredicate = "TBD")
    public MobileElement substitutionCTAFirstProduct;

    @AndroidFindBy(id = "tv_add_notes")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Add Note' AND name == 'Add Note'")
    public List<MobileElement> addNoteBtn;

    @AndroidFindBy(id = "cartv2_edt_notes")
    @iOSXCUITFindBy(iOSNsPredicate = "label contains 'out of'")
    public MobileElement addNoteTextBox;

    @AndroidFindBy(id = "tvTitle")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Shopper notes'")
    public MobileElement addNoteHeader;

    @AndroidFindBy(accessibility = "Shopper notes close")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Shopper notes close'")
    public MobileElement addNoteCloseBtn;

    @AndroidFindBy(id = "addNoteSave")
    @iOSXCUITFindBy(accessibility = "btnSave")
    public MobileElement addNoteSaveBtn;

    @AndroidFindBy(id = "lbl_items_unavailable")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'lblTitle' and visible == 1")
    public MobileElement itemsUnavailableWarningMsg;

    @AndroidFindBy(id = "payInStore")
    @iOSXCUITFindBy(accessibility = "btnCartPayInStore")
    public MobileElement payInStoreBtn;

    @AndroidFindBy(id = "deliveryOrPickup")
    @iOSXCUITFindBy(accessibility = "btnCartDeliveryOrPickup")
    public MobileElement deliveryOrPickUpBtn;

    @AndroidFindBy(accessibility = "Proposition 65 Warning close")
    @iOSXCUITFindBy(accessibility = "Prop 65 warning close")
    public MobileElement prop65WarningSheetCloseBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Proposition 65 Warning\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Proposition 65 Warning' and visible==1")
    public MobileElement prop65WarningSheetHeader;

    @AndroidFindBy(xpath = "//*[@text='Proposition 65 Warning']//following-sibling::android.widget.TextView")
    @iOSXCUITFindBy(xpath = "//*[@label='Proposition 65 Warning']//following-sibling:: XCUIElementTypeStaticText")
    public MobileElement prop65WarningSheetMessage;

    @AndroidFindBy(id = "minimumText")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='lblCartThresholdMessage']")
    public MobileElement wysiQualifyingValue;

    @AndroidFindBy(id = "checkoutButton")
    @iOSXCUITFindBy(accessibility = "btnCartCheckout")
    public MobileElement checkoutButton;

    @AndroidFindBy(id = "umaProgressDialog")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Please' OR label BEGINSWITH 'Loading' AND visible==1")
    public MobileElement loadingSpinner;

    @AndroidFindBy(id = "tv_cart_disclaimer")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'lblInStoreDisclaimerText' and visible ==1")
    public MobileElement storeDisclaimer;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Edit Substitution\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Edit Substitution' AND visible==1")
    public MobileElement productLinkForChangeSubstitutionCart;

    @AndroidFindBy(id = "umaAppliedTv")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'lblClipStatus' and label =='APPLIED'")
    public MobileElement appliedLabelForAppliedDeal;

    @AndroidFindBy(id = "umaClippedTv")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'lblClipStatus' and label =='CLIPPED'")
    public MobileElement clippedLabelForClippedDeal;

    @AndroidFindBy(id = "cart_msg")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'more to reach the minimum')]")
    public MobileElement wysiQualifyingValueInEditOrder;

    @AndroidFindBy(id = "tv_cart_description")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeButton[@visible='true']")
    public List<MobileElement> productNamesList;

    @AndroidFindBy(id = "TBD")
    @iOSXCUITFindBy(xpath = "TBD")
    public MobileElement firstProductCard;

    @AndroidFindBy(xpath = "//*[@text='Edit Substitution']")
    @iOSXCUITFindBy(iOSNsPredicate = "label =='Edit Substitution' AND type == 'XCUIElementTypeButton'")
    public MobileElement changeSubstitution;

    @AndroidFindBy(xpath = "//*[@text='Edit Substitution']")
    @iOSXCUITFindBy(iOSNsPredicate = "label =='Edit Substitution' AND type == 'XCUIElementTypeButton'")
    public List<MobileElement> changeSubstitutionList;

    @AndroidFindBy(xpath = "PENDING")
    @iOSXCUITFindBy(iOSNsPredicate = "PENDING")
    public MobileElement justForUSavingsLabel;

    @AndroidFindBy(xpath = "PENDING")
    @iOSXCUITFindBy(iOSNsPredicate = "PENDING")
    public MobileElement justForUSavingsValue;

    @AndroidFindBy(uiAutomator = "new UiSelector(). textContains(\"savings\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label contains 'vings'AND type == 'XCUIElementTypeStaticText'")
    public List<MobileElement> savingsListLabels;

    @AndroidFindBy(id = "cl_cart_view_item")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='lblpricePerQuantity']/ancestor:: XCUIElementTypeCell")
    public List<MobileElement> cartProducts;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tv_cart_price_per_quantity')]")
    @iOSXCUITFindBy(accessibility = "lblPrice")
    public MobileElement cartV2Element;

    @AndroidFindBy(id = "ctaConfirm")
    @iOSXCUITFindBy(accessibility = "btnConfirmSubstitutionButton")
    public MobileElement confirmSubstitutionButton;

}

package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_FoodLotPageElements {

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'design_bottom_sheet')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView")
    public MobileElement custDetailDrawer;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'FoodLotHeader')]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'headerLabel'")
    public MobileElement custDetailHeader;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'ivFoodLotLogo')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Food Lot Truck Logo'")
    public MobileElement foodLotLogo;

    @AndroidFindBy(xpath = "//*[@text='Enter first name']")
    @iOSXCUITFindBy(xpath = "//*[@name='firstNameField']")
    public MobileElement firstName;

    @AndroidFindBy(xpath = "//*[@text='Enter last name']")
    @iOSXCUITFindBy(xpath = "//*[@name='lastNameField']")
    public MobileElement lastName;

    @AndroidFindBy(xpath = "//*[@text='Email']//following-sibling::*[contains(@resource-id,'edit_text')]//android.widget.EditText")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'emailField'")
    public MobileElement emailField;

    @AndroidFindBy(xpath = "//*[@text='Confirm']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'ctaButton'")
    public MobileElement confirmCTAButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tv_title')] ")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'lblTopNavBarWithHintTitle'")
    public MobileElement truckLandingPageHeader;

    @AndroidFindBy(xpath = "//*[@text='Subscribe To Receive Vendor Menus']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Subscribe To Receive Vendor Menus'")
    public MobileElement subscribeCTA;

    @AndroidFindBy(xpath = "(//*[@text='Add To Cart'])[1]")
    //@iOSXCUITFindBy(iOSNsPredicate = "name == 'Add To Cart'")
    @iOSXCUITFindBy(xpath = "(//*[@name='Add To Cart'])[1]")
    public MobileElement addToCartCTA;

    @AndroidFindBy(xpath = "(//*[@text='Add To Cart']/..//following-sibling::android.widget.TextView)[1]")
    @iOSXCUITFindBy(xpath = "(//*[@label='Add To Cart']/..//following-sibling::XCUIElementTypeOther[3]//XCUIElementTypeStaticText)[1]")
    public MobileElement foodProductDescription;

    @AndroidFindBy(xpath = "//*[@class=\"android.app.Dialog\"]/android.view.View[1]")
    @iOSXCUITFindBy(xpath = "//*[@label='web dialog']")
    public MobileElement preDrawerScreen;

    @AndroidFindBy(xpath = "//*[@text='+']")
    @iOSXCUITFindBy(xpath = "//*[@label='+']")
    public MobileElement quantityStepperAddIcon;

    @AndroidFindBy(xpath = "//*[@text=' Add Special Instructions']")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Add Special Instructions')]")
    public MobileElement specialInstructionsNote;

    @AndroidFindBy(xpath = "//*[contains(@text,'Pre-Order, Add to Cart')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@label,'Pre-Order, Add to Cart')]")
    public MobileElement preOrderAddToCartCTA;

    @AndroidFindBy(xpath = "//*[@text='Order Now']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='Order Now']")
    public MobileElement orderNowDrawerScreen;

    @AndroidFindBy(xpath = "//*[@text='Review Order']")
    @iOSXCUITFindBy(xpath = "//*[@value='Review Order']")
    public MobileElement reviewOrderPage;

    @AndroidFindBy(xpath = "//*[@text='Tip:']")
    @iOSXCUITFindBy(xpath = "//*[@value='Tip:']")
    public MobileElement tipSecton;

    @AndroidFindBy(xpath = "//*[@text='ZERO']")
    @iOSXCUITFindBy(xpath = "//*[@value='Tip:']/..//following-sibling::*[contains(@label,'ZERO')]")
    public MobileElement tipSectionOptionZero;

    @AndroidFindBy(xpath = "//*[@text='OTHER...']")
    @iOSXCUITFindBy(xpath = "//*[@value='Tip:']/..//following-sibling::*[contains(@label,'OTHER')]")
    public MobileElement tipSectionOptionOthers;

    @AndroidFindBy(xpath = "//*[@text='OTHER...']")
    @iOSXCUITFindBy(xpath = "//*[@value='Tip:']/..//following-sibling::*[contains(@label,'OTHER')]")
    public MobileElement reviewOrderPageAddSection;

    @AndroidFindBy(xpath = "//*[@text=\"Pickup Time:\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "label=='Pickup Time:'")
    public MobileElement reviewOrderPagePickupTimeSection;

    @AndroidFindBy(xpath = "//*[contains(@text,'Subtotal $')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Subtotal')]")
    public MobileElement reviewOrderPageSubtotalField;

    @AndroidFindBy(xpath = "//*[contains(@text,'Subtotal $')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Tip $')]")
    public MobileElement reviewOrderPageTipField;

    @AndroidFindBy(xpath = "//*[contains(@text,'Tax $')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Tax')]")
    public MobileElement reviewOrderPageTaxField;

    @AndroidFindBy(xpath = " //*[contains(@text,'Convenience Fee')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Convenience Fee')]")
    public MobileElement reviewOrderPageConvenienceFeesField;

    @AndroidFindBy(xpath = "//*[contains(@text,'Order Total')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Order Total')]")
    public MobileElement reviewOrderPageTotalAmountField;

    @AndroidFindBy(xpath = "//*[@text='Add a coupon']")
    @iOSXCUITFindBy(xpath = "//*[@value='Add a coupon']")
    public MobileElement reviewOrderPageAddACouponLink;

    @AndroidFindBy(xpath = "//*[@text='Another Item']")
    @iOSXCUITFindBy(xpath = "//*[@label='+ Another Item']")
    public MobileElement reviewOrderPageAnotherItemCTA;

    @AndroidFindBy(xpath = "//*[@text='Checkout']")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Checkout')]")
    public MobileElement checkoutCTA;

    @AndroidFindBy(xpath = "//*[@text=\"Select box activate\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Select box activate\"]/XCUIElementTypeOther[1]")
    public MobileElement reviewOrderPagePickupTimeDropDown;

    @AndroidFindBy(xpath = "//*[contains(@text,\"As soon as ready\") and contains(@resource-id,'select-choices')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@label=\"As soon as ready\"]")
    public MobileElement pickupTimeOptionAsSoonAsReady;

    @AndroidFindBy(xpath = "//*[@text='Please select how much you want to tip.']")
    @iOSXCUITFindBy(xpath = "//*[@label='Please select how much you want to tip.']")
    public MobileElement chooseTipMsg;

    @AndroidFindBy(xpath = "//*[@text=\"Please choose a pick up time\"]")
    @iOSXCUITFindBy(xpath = "//*[@label='Please choose a pick up time']")
    public MobileElement choosePickUpTimeMsg;

    @AndroidFindBy(xpath = "//*[contains(@text,'need your email')]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"email to send you receipts\"]")
    public MobileElement custInfoScreen;

    @AndroidFindBy(xpath = "//*[@resource-id='customer_email']")
    @iOSXCUITFindBy(xpath = "//*[@label='Email']/..//following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField")
    public MobileElement custEmail;

    @AndroidFindBy(xpath = "//*[@resource-id='customer_first_name']")
    @iOSXCUITFindBy(xpath = "//*[@label='First Name']//following-sibling::XCUIElementTypeTextField")
    public MobileElement custFirstName;

    @AndroidFindBy(xpath = "//*[@resource-id='customer_last_name']")
    @iOSXCUITFindBy(xpath = "//*[@label='Last Name']/..//following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField")
    public MobileElement custLastName;

    @AndroidFindBy(xpath = "//*[@resource-id='customer_phone']")
    @iOSXCUITFindBy(xpath = "//*[@label='Phone']//following-sibling::XCUIElementTypeTextField")
    public MobileElement custPhone;

    @AndroidFindBy(xpath = "//*[@text=\"BFT's terms and conditions\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"BFT's terms and conditions\"]")
    public MobileElement termsAndConditionsCheckbox;

    @AndroidFindBy(xpath = "//*[@resource-id=\"cardNumber\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"BFT's terms and conditions\"]")
    public MobileElement paymentScreen;

    @AndroidFindBy(xpath = "//*[@resource-id=\"cardNumber\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Card number'")
    public MobileElement creditCardNo;

    @AndroidFindBy(xpath = "//*[@resource-id=\"cardExpiry\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Expiration'")
    public MobileElement creditCardExpiryDate;

    @AndroidFindBy(xpath = "//*[@resource-id=\"cardCvc\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'CVC'")
    public MobileElement creditCardCVC;

    @AndroidFindBy(xpath = "//*[@resource-id=\"billingName\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'Name on card')]/../following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    public MobileElement billingName;

    @AndroidFindBy(xpath = "//*[@resource-id=\"billingPostalCode\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'ZIP'")
    public MobileElement billingPostalCode;

    @AndroidFindBy(xpath = "//*[@text=\"Pay\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Pay'")
    public MobileElement payButton;

    @AndroidFindBy(xpath = "//*[contains(@text,'Thank you, your order') and contains(@text,'was successfully placed!')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Thank you, your order') and contains(@label,'was successfully placed!')]")
    public MobileElement orderConfirmationPage;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Back\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Back'")
    public MobileElement backButton;
}

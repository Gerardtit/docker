package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.CacheLookup;

import java.util.List;

public class OrderPageElements {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar[1]/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(id = "tvTitle")
    public MobileElement orderTitle;

    @iOSXCUITFindBy(accessibility = "Back")
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Close\"]")
    @CacheLookup
    public MobileElement backButtonToMenu;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Cancel order\"]")
    @AndroidFindBy(id = "cancel_order")
    @CacheLookup
    public MobileElement cancelOrderButton;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name BEGINSWITH 'Order Number' AND visible == 1")
    @AndroidFindBy(id = "order_number")
    public List<MobileElement> orderNumberList;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Cancel Order' AND visible == 1")
    @AndroidFindBy(id = "alertTitle")
    @CacheLookup
    public MobileElement cancelOrderAlertWindow;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Cancel Order' AND visible == 1")
    @AndroidFindBy(id = "android:id/button1")
    @CacheLookup
    public MobileElement cancelOrderConfirmButton;

    @iOSXCUITFindBy(accessibility = "Past Orders")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Past Orders\")")
    public MobileElement pastOrder;

    @iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton' And name == 'Edit Order' ")
    @AndroidFindBy(id = "tvOrderOperation")
    public MobileElement editOrder;

    @iOSXCUITFindBy(accessibility = "Past Orders")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Past Orders\")")
    public MobileElement pastOrderText;

    @iOSXCUITFindBy(accessibility = "Current Orders")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Current Orders\")")
    public MobileElement currentOrderText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeButton[1]")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.ImageView[1]")
    public MobileElement needHelpText;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Order history\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Order history\"]")
    public MobileElement orderHistoryText;


    @iOSXCUITFindBy(xpath = "//*[@id=\"orderNumberTextValue\"]")
    //  @AndroidFindBy(xpath = "//*[@id=\"orderNumberTextValue\"]")
    public MobileElement orderNumber;

    @iOSXCUITFindBy(xpath = "//*[@content-desc=\"Google Map\"]")
    //   @AndroidFindBy(xpath = "//*[@content-desc=\"Google Map\"]")
    public MobileElement map;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Your Orders\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"tv_order_title\")]")
    public MobileElement orderHistoryTitle;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Edit your order\"]/XCUIElementTypeButton")
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Back button\"]")
    public MobileElement backButtonOnEditOrdersPage;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Contact info button\")]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"iv_contact_right_arrow\")]")
    public MobileElement contactInfoTitle;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"back button to take you back\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"btnTopNavBarLeft\"]")
    public MobileElement backarrowatEditCartPage;

    @AndroidFindBy(xpath = "//*[@text='Cancel Changes']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Cancel changes\"]")
    public MobileElement cancelChangesHeaderPopup;

    @AndroidFindBy(xpath = "//*[@text='Discard changes']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Discard changes\"]")
    public MobileElement discardChangesButtonPopup;

    @AndroidFindBy(xpath = "//*[@text='Keep editing']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Keep editing\"]")
    public MobileElement keepEditingButtonPopup;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"phoneField\"]")
//    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Enter Phone Number\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.LinearLayout/android.widget.EditText")
    public MobileElement enterPhoneNumber;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Save Changes\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    public MobileElement saveChangesInEditContactInfo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Add promo code']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add promo code']")
    public MobileElement addPromoCode;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[8]")
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter Promo Code']")
    public MobileElement enterPromoCodeTextBox;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Apply\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Apply']")
    public MobileElement applyPromoCode;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Order summary. .\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Order summary']")
    public MobileElement orderSummaryInEditYourOrderPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Estimated total, Info']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Estimated total']")
    public MobileElement estimatedTotalInEditYourOrderPage;


    //  @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"View Details or Track Order\"])[1]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"View Details\")]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='View Details or Track Order']")
    public MobileElement viewDetialsOrTrackOrder;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Edit order\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Edit order']")
    public MobileElement EditOrderInYourOrderDetailsPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Save changes\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Confirm Changes']")
    public MobileElement SaveChangesInEditYourOrderPage;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Edit order\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Edit order']")
    public MobileElement EditOrderInOrderConfirmationPage;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Continue shopping\"] | //*[@name=\"Continue shopping\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continue shopping'] |  //*[contains(@resource-id,\"btn_continue_shopping\")]")
    public MobileElement ContinueShoppingInOrderConfirmationPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"btnSearchBarViewButton\"]")
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Search products or deals']")
    public MobileElement SearchProductsOrDealsOnHomePage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"btnSearchBarViewButton\"]")
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Back button']")
    public MobileElement BackButtonOnYourOrderDetailsPage;

    @iOSXCUITFindBy(xpath = "//*[@value=\"Apply\"and @name =\"Apply\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Apply\"]")
    public MobileElement applypromoButton;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Your Orders\"]")
    //@AndroidFindBy(xpath = "//*[@text=\"Your order details\"]")
    @AndroidFindBy(id = "tv_order_title")
    public MobileElement yourOrderDetailsPageTitle;

    @AndroidFindBy(id = "headerTitle")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"In Progress\"]")
    public MobileElement orderInProgressStatus;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"progressBar\")]")
    @iOSXCUITFindBy(id = "Order Status created")
    public MobileElement orderCreatedStatusBar;

    @AndroidFindBy(xpath = "//*[@text=\"Delivery is confirmed\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Delivery is confirmed\"]")
    public MobileElement deliveryConfirmedTxt;


    // @iOSXCUITFindBy(xpath = "//*[contains(@label,\"View Details\")]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"View Details or Track Order\"]")
    @AndroidFindBy(xpath = "//android.widget.Button[@text='View Details or Track Order']")
    public MobileElement viewDetialsOrTrackOrderSection;
}

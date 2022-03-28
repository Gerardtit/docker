package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

public class GG_OrdersPageElements {

    //    @AndroidFindBy(id = "tvTitle")
//    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Orders\"")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Your Orders']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Your Orders\"]")
    public MobileElement ordersHeaderTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Your Order is Pending\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Cancel Order' ")
    public MobileElement pendingOrderLabel;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Cancel Order' ")
    @AndroidFindBy(id = "cancel_order")
    @CacheLookup
    public MobileElement cancelOrderButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"You have no pending orders.\"]")
    @iOSXCUITFindBy(id = "You have no pending orders.")
    public MobileElement noPendingOrders;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Cancel Order'")
    public MobileElement cancelOrderPopUpButton;

    @AndroidFindBy(id = "edit_text")
    @iOSXCUITFindBy(accessibility = "Enter Address Line One. Field is required")
    public MobileElement deliveryAddressField;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'1-hour')]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name BEGINSWITH'1‑h'")
    public WebElement deliveryWindow1h;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'2-hour')]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name BEGINSWITH'2‑h'")
    public WebElement deliveryWindow2h;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'4-hour')]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name BEGINSWITH '4‑h'")
    public WebElement deliveryWindow4h;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Save'")
    @AndroidFindBy(accessibility = "Save")
    public MobileElement saveButton;


    //  @AndroidFindBy(id = "order_number_info")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'txt_order_number')]")
    //@iOSXCUITFindBy(xpath = "//*[@label='Order Number']//following-sibling:: XCUIElementTypeStaticText[@visible='true']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='orderNumberLabel']")
    public MobileElement orderNumberOrderConfirmationPage;

    @AndroidFindBy(id = "orderNumberTextValue")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[7]")
    public MobileElement orderNumberOrderHistory;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'order_status_container')]//*[contains(@resource-id,'order_number')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Cancel Order']//following-sibling:: XCUIElementTypeStaticText[3]")
    public MobileElement orderNumberOrdersPage;


    @AndroidFindBy(accessibility = "Back")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeButton")
    public MobileElement backButton;

    @AndroidFindBy(accessibility = "Back")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Orders'")
    public MobileElement backOrdersDetailsButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'view_order_details')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'View Details' AND name == 'View Details' AND type == 'XCUIElementTypeButton'")
    public MobileElement firstViewDetailsButton;

    @AndroidFindBy(id = "tvOrderOperation")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Edit order' AND name == 'editButton'")
    public MobileElement editOrderButton;


    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Order date\")")
    @iOSXCUITFindBy(xpath = "//*[@label='Order date']")
    //  @iOSXCUITFindBy(xpath = "//*[@label='Order Number']//following-sibling:: XCUIElementTypeStaticText[@visible='true']")
    public MobileElement orderDate;

    @AndroidFindBy(id = "tvTitle")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Your Orders\"]")
    public MobileElement yourOrdersHeaderTitle;

    @AndroidFindBy(id = "tv_cart_preview_header")
    @iOSXCUITFindBy(accessibility = "numberOfCartItemsLabel")
    public MobileElement amountItemsInOrder;

    @AndroidFindBy(xpath = " //android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]")
    public MobileElement mapButton;


    @AndroidFindBy(xpath = "//*[contains(@resource-id,'txt_view_order_details')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Double Tap to show view Order Details\"]")
    public MobileElement chvronOrderDetail;

    @AndroidFindBy(id = "txt_view_order_details")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"View Details or Track Order\"]")
    public MobileElement trackOrderDetail;

    @AndroidFindBy(id = "textViewTitle")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Delivery is confirmed\"]")
    public MobileElement isconfirmed;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Your Orders']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Your Orders\"]")
    public MobileElement yourOrdersHeader;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Your order details']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Your order details\"]")
    public MobileElement yourOrderDetailsHeader;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'iv_item_details')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@index=0]/XCUIElementTypeCell[@index=3]")
    public MobileElement itemDetailsChevron;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Your item details']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Your item details\"]")
    public MobileElement itemDetailsHeading;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'textViewPaymentMethodTitle')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Payment Method\"]")
    public MobileElement paymentMethodTxt;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'textViewPaymentMethodTitle')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Payment Method\"]")
    public MobileElement creditAppliedTxt;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index=4]/android.widget.TextView[@index=2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Payment Method\"]")
    public MobileElement creditAppliedAmountValue;

    @AndroidFindBy(id = "textViewCardEnding")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SNAP EBT\"]")
    public MobileElement snapEBTTxt;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'textViewCardEnding')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Credit on Account\"]")
    public MobileElement creditAccountTxt;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'radioButtonSnapEbt')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@index=2]/XCUIElementTypeButton[@index=0]")
    public MobileElement ebtPaymentMethod;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Apply Credit On Account link\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@index=1]/XCUIElementTypeOther[@index=13]")
    public MobileElement applyCreditOnAccountBtn;

    @AndroidFindBy(id = "promo_code_edit_text")
    @iOSXCUITFindBy(xpath = "///XCUIElementTypeApplication[@name=\"Safeway\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeOther[2]/XCUIElementTypeOther[12]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
    public MobileElement applyCreditTxtFieldBox;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Save']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Continue to review order\"]")
    public MobileElement continueReviewOrderBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Apply button\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@index=1]/XCUIElementTypeOther[@index=13]")
    public MobileElement applyCreditBtn;


}

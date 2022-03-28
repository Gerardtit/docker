package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_checkout_contactinfoElements {


    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[3]/XCUIElementTypeStaticText[3]")
    public MobileElement nameatcontactinfo;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Close\"]")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Back\"]")
//    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Close slot selection screen\"]")
//    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]")
    public MobileElement closewindow;

    @AndroidFindBy(xpath = "//*[@text=\"Pickup\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"selected. Pickup 2 of 2\"]")
    public MobileElement pickupslotTile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"No\"]")
    @AndroidFindBy(xpath = "//*[@text=\"No\"]")
    public MobileElement confirmchanges;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[3]/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.TextView[2]")
    public MobileElement phoneatcontactinfo;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[4]/android.view.ViewGroup[1]/android.widget.TextView[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[4]")
    public MobileElement weekdaysobject;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.RadioButton[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]")
    public MobileElement hrsobject;

    @AndroidFindBy(xpath = "//*[@text=\"Enter first name\"]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"firstNameField\"]")
    public MobileElement firstnamecontact;

    @AndroidFindBy(xpath = "//*[@text=\"Enter last name\"]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"lastNameField\"]")
    public MobileElement lastnamecontact;

    @AndroidFindBy(xpath = "//*[@text=\"Enter mobile number\"]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"phoneField\"]")
    public MobileElement mobilenumber;

    @iOSXCUITFindBy(xpath = "//*[@value=\"Continue to review order\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Continue to review order\"]")
    public MobileElement Continuetorevieworder;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Close\"]")
    public MobileElement Close;

    @iOSXCUITFindBy(xpath = "//*[@value=\"Continue to contact info\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Continue to contact info\"]")
    public MobileElement Continuetocontactinfo;


    @AndroidFindBy(xpath = "//*[@text=\"Continue to payment method\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Continue to payment method\"]")
    public MobileElement continuetoPaymentTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Confirm CVV\"]")
//    @AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.TextView[1]")
    public MobileElement cvvText;

    @AndroidFindBy(xpath = "//*[@text=\"Confirm CVV\"]")
    @iOSXCUITFindBy(accessibility = "Confirm CVV")
    public MobileElement confirmCVVtext;

    //    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    @AndroidFindBy(xpath = "//*[@text=\"Store card details. (optional)\"]")
    public MobileElement savecreditcard;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Done\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"id/edit_text\") and @text=\"Confirm Phone Number\"]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[2]")
    public MobileElement keypadDoneButton;

    //    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    @AndroidFindBy(xpath = "//*[@text=\"Enter credit card\"]")
    public MobileElement EnterCreditcard;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Place order\"]")
//    @iOSXCUITFindBy(xpath ="//XCUIElementTypeStaticText[@name=\"Place order\"]")

    @AndroidFindBy(xpath = "//*[@text=\"Place order\"]")
    public MobileElement placeorder;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Save\"]")
    //@AndroidFindBy(id = "slot_selection_btn")

    @AndroidFindBy(xpath = "//*[@text=\"Save\"]")


    public MobileElement savetab;
    //cvv
    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    @AndroidFindBy(id = "edit_text")
    public MobileElement cvvEditText;

    @AndroidFindBy(xpath = "//*[@text=\"Continue to CVV\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Continue to CVV\"]")
    public MobileElement continuetoCVV;

    @AndroidFindBy(xpath = "//*[@text=\"Turn on order status text messages?\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Turn on order status text messages?\"]")
    public MobileElement warningtext;

    @AndroidFindBy(xpath = "//*[@text=\"Enter name\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Enter name\"]")
    public MobileElement enternametext;

    @AndroidFindBy(xpath = "//*[@text=\"Enter mobile number\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Enter mobile number\"]")
    public MobileElement enternumbertext;

    @AndroidFindBy(xpath = "//*[@text=\"//android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.ImageView[2]\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Close\"]")
    public MobileElement closepayment;


    @iOSXCUITFindBy(className = "//XCUIElementTypeStaticText[@label=\"Save\" and @name=\"Save\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Save\"]")
    public MobileElement cvvsave;

    @AndroidFindBy(xpath = "//*[@text=\"OFF\"]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"flagSwitch\"]")
    public MobileElement textsmstoggleoff;

    @AndroidFindBy(id = "secondaryButton")
    public MobileElement notoslotpage;

    //    @AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc=\"Back\"]")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Back']")
    public MobileElement androidBackArrow;


    @AndroidFindBy(xpath = "//*[@text=\"Street address\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Street address. Field is required\"]")
    public MobileElement streetaddress;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[4]/android.widget.RelativeLayout[1]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"State field is required\"]")
    public MobileElement state_delivery;

    @AndroidFindBy(xpath = "//*[@text=\"Apt., suite, etc. (optional)\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Enter Apartment, Suite, etc (optional)\"]")
    public MobileElement aptno;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[3]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Enter Zipcode. Field is required \"]")
    public MobileElement zipcode_delivery;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[5]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"City field is required\"]")
    public MobileElement city_delivery;

    //    @AndroidFindBy(xpath = "//*[@text=\"//android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.ImageView[2]\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Next:\"]")
    public MobileElement nextOnKeyboard;

    //    @AndroidFindBy(xpath = "//*[@text=\"//android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.ImageView[2]\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
    public MobileElement doneOnkeyboard;

    //   @AndroidFindBy(id = "tv_change_address_store")
    @AndroidFindBy(xpath = "//*[@text=\"Edit\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Edit\"]")
    public MobileElement editonslot;

    //    @AndroidFindBy(id = "checkout_store_list_title")
    @AndroidFindBy(xpath = "//*[@text=\"Select pickup store\"]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"viewStoreListView\"]/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeOther/XCUIElementTypeOther")
    public MobileElement selectlocation;


    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"jewelosco\"])[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"viewStoreListView\"]/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]")
    public MobileElement pickuplocation;

    //    @AndroidFindBy(id = "primaryButton")
    @AndroidFindBy(xpath = "//*[@text=\"Continue\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
    public MobileElement continueatEdit;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"close\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"btnTopNavBarRight\"]\n")
//    @iOSXCUITFindBy(xpath = "//*[@label=\"Close\"]")
    public MobileElement crosssign;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"close\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"btnTopNavBarLeft\"]")
    public MobileElement backarrowatCart;


    @AndroidFindBy(id = "search_src_text")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"viewStoreListView\"]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
    public MobileElement searchzipcode;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Clear query\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"viewStoreListView\"]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
    public MobileElement clearzipcode;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Clear query\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"viewStoreListView\"]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
    public MobileElement contactcta;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Clear query\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"viewStoreListView\"]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField")

    public MobileElement textsmstoggleon;


    @AndroidFindBy(xpath = "//*[@text=\"Save\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Continue to payment method\"]")
    public MobileElement saveButtonOnCart;


    @AndroidFindBy(xpath = "//*[@resource-id='com.safeway.client.android.safeway.debug:id/edit_card']")
    @iOSXCUITFindBy(xpath = "//*[@label='Edit']")
    public MobileElement editOnPayment;


}


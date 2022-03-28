package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_SMS_Opt_InPageElements {

    @AndroidFindBy(id = "switchPhone")
    @iOSXCUITFindBy(accessibility = "Text me order status updates.")
    public MobileElement smsOptInStatus;

    @AndroidFindBy(id = "umaStepperPlus")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == '﹢'")
    //@iOSXCUITFindBy(iOSNsPredicate = "PENDING")
    public MobileElement plusButton;

    @AndroidFindBy(id = "btn_save")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Place Order'")
    public MobileElement placeOrderButton;

    @AndroidFindBy(id = "right_arrow")
    @iOSXCUITFindBy(accessibility = "Contact")
    public MobileElement changeContactLink;

    //@AndroidFindBy(xpath  = "//*[@resource-id='com.safeway.client.android.tomthumb.debug:id/phone_edit_text']//*[@resource-id='com.safeway.client.android.tomthumb.debug:id/edit_text']")
    @AndroidFindBy(id = "edit_text")
    @iOSXCUITFindBy(accessibility = "Phone Number textfield, field is required.")
    public MobileElement phoneNumberTextField;

    @AndroidFindBy(id = "edit_text")
    @iOSXCUITFindBy(accessibility = "Phone Number textfield, field is required.")
    public List<MobileElement> phoneNumberTextFieldList;

    @AndroidFindBy(id = "btn_save")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Save and Review'")
    public MobileElement saveAndReviewButton;

    @AndroidFindBy(id = "addButton")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Add'")
    public MobileElement addButton;

    @AndroidFindBy(id = "tv_change_address_store")
    public MobileElement pickupedit;

    @AndroidFindBy(xpath = "//*[@class=\"androidx.recyclerview.widget.RecyclerView\"]//*[@class=\"androidx.cardview.widget.CardView\"]")
    public MobileElement storecard;

    @AndroidFindBy(xpath = "//*[@class=\"androidx.recyclerview.widget.RecyclerView\"]//*[@class=\"android.widget.TextView\"]")
    public MobileElement storedetails;


}




















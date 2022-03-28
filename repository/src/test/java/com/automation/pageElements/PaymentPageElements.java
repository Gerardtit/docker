package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PaymentPageElements {
    //back button
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Checkout' AND visible == 1")
    @AndroidFindBy(accessibility = "Navigate up")
    public MobileElement backToCheckoutPageButton;

    //cvv window title
    //@iOSXCUITFindBy(accessibility = "Current Payment Method")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView//*[@value=\"Confirm CVV\"]")
    //  @AndroidFindBy(id = "confirm_cvv_et")
    //@AndroidFindBy(xpath = "//*[@text=\"Payment\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Confirm CVV\"]")
    public MobileElement cvvWindowTitle;

    //Continue to slot selection button
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Continue\")]")
    @AndroidFindBy(xpath = "//*[@text=\"Continue\"]")
    public MobileElement continueCTA;

    //Continue to slot selection button
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"editCardButton\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"edit_card\")]")
    public MobileElement editPayment;


    //continue button
    @iOSXCUITFindBy(xpath = "//*[@label=\"Continue\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Continue\"]")
    //@AndroidFindBy(xpath = "//*[@resource-id=\"submit\"]")
    public MobileElement continueButton;

    //XCUIElementTypeButton[@name="Continue"]
    //cvv
//    @iOSXCUITFindBy(xpath = "//*//XCUIElementTypeTextField[contains(@label,\"Confirm CVV\")]|//XCUIElementTypeTextField[@name='Confirm CVV']")
//    @iOSXCUITFindBy(xpath = "//*/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")
    //   @iOSXCUITFindBy(xpath = "//*[@label=\"Confirm CVV\"]/following::XCUIElementTypeTextField")
    //@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@label=\"Confirm CVV\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Confirm CVV\"]")
    //   @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")
//    @iOSXCUITFindBy(xpath = "//*[@label=\"Confirm CVV\"]/following::XCUIElementTypeTextField")
    //@iOSXCUITFindBy(className = "XCUIElementTypeTextField")

    //  @AndroidFindBy(id = "edit_text")
    //  @AndroidFindBy(id = "textinput_placeholder")
    //@AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.TextView[1]")
    //@AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.TextView[1]")
//    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.EditText[1] | //android.widget.FrameLayout[1]/android.widget.TextView[1] | //android.widget.FrameLayout[1]/android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Confirm CVV\"]")
    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[1]/android.widget.EditText[1]|//android.widget.FrameLayout[1]/android.widget.TextView[1]|//android.widget.FrameLayout[1]/android.widget.EditText[1])[1]")
    public MobileElement cvvEditText;

    //Continue to contact info


    // @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Continue\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Continue\")] | //XCUIElementTypeButton[@label=\"Continue to contact info\"]")

    // @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Continue\")]")
    // @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Continue to contact info\"]")

    //@AndroidFindBy(xpath = "//*[@text=\"Continue to contact info\"]")
    //Element added due to change in checkout
    @AndroidFindBy(xpath = " //*[contains(@resource-id,\"cvv_button\")]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Continue to contact info\"]")
    public MobileElement continueToContactInfo;


    @iOSXCUITFindBy(xpath = "//*[@value=\"Continue to contact info\"]")
    public MobileElement continuetoContactbtn;

    @iOSXCUITFindBy(xpath = "//*[@label=\"done\" or @label=\"Done\"]")
    public MobileElement doneButton;

    @AndroidFindBy(id = "btn_next")
    public MobileElement cvvEnter;


    //enter cvv
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Confirm CVV' AND visible == 1")
    @AndroidFindBy(id = "btn_next")
    public MobileElement creditCvvNextButton;

    //name on card

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[4]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]|//*[@value=\"Name on the Debit/Credit card\"]")
    //@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND name == 'Full Name' AND visible == 1")
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    public MobileElement nameOnCard;

    //card number

    //@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND value == 'Card number' AND visible == 1")//might be new one
    //@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Credit Card Number\"]|//XCUIElementTypeTextField[@name=\"Card Number\"]")
    // @iOSXCUITFindBy(xpath="//*[@label=\"Credit Card Number\"]") //old one
    //@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")

    //@iOSXCUITFindBy(xpath = "//*[@value=\"Card number\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Card number\"] | //XCUIElementTypeTextField[@name=\"Credit Card Number\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    public MobileElement cardNumber;

    //Expiration Month year
    //   @iOSXCUITFindBy(xpath = "//*[@label=\"Payment V2\"]/XCUIElementTypeOther[8]")
    //@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND value == 'MM/YY' AND visible == 1")//might be new one
    // @iOSXCUITFindBy(xpath = "//*[@value=\"MM/YY\"])  //new one
    // @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND value == 'MM/YY' AND visible == 1")//might be new one
    //  @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Payment V2\"]/XCUIElementTypeTextField|//*[@value=\"MM / YY\"]")
    //@iOSXCUITFindBy(xpath="//*[@label=\"Expiration Date\"]")
    //  @iOSXCUITFindBy(xpath="//XCUIElementTypeOther[10]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")
    //@iOSXCUITFindBy(xpath ="//XCUIElementTypeOther[10]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")
    //@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND name == 'Expiration Date' AND visible == 1")

    //@iOSXCUITFindBy(iOSNsPredicate = "label == \"Expiration Date\" AND name == \"Expiration Date\" AND value == \"MM / YY\"")
    //@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[4]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='MM/YY'] | //XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[4] | //*[@value=\"MM/YY\"] | //XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[3]")
    @AndroidFindBy(xpath = "//*[@resource-id=\"monthyear\"]")
    public MobileElement expirationMonthYear;


    //Billing zip

    //  @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Payment V2\"]/XCUIElementTypeTextField|//*[@value=\"ZIP Code\"]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Payment V2\"]/XCUIElementTypeTextField[4]")
//    @AndroidFindBy(xpath = "//*[@resource-id=\"cc-zip\"] | //*[@resource-id=\"zipcode\"]") //old and new

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[4] | //*[@value=\"ZIP Code\"]")
    @AndroidFindBy(xpath = "//*[@resource-id=\"zipcode\"]")
    public MobileElement billingZip;


    // @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Add Credit Card\")]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Add Credit Card\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,\"Add Credit Card\")]")
    public MobileElement payment;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Store card details. (optional)\"]")
    @AndroidFindBy(xpath = "//android.view.View/android.view.View[8]/android.view.View[3]/android.view.View[1]")
    public MobileElement saveCardDetailsCheckbox;

    @AndroidFindBy(xpath = "//*[@text=\"Save\"]")
    public MobileElement saveButton;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Continue\")]")
    @AndroidFindBy(xpath = "//*[@text=\"Continue to review order\"] | //*[@text=\"Save\"]")
    public MobileElement continueToReviewOrderCTA;

    @iOSXCUITFindBy(xpath = "//*[@label='Continue']")
    public MobileElement continueBtnFPPayment;

    @iOSXCUITFindBy(xpath = "//*[@label=\"VISA 1111\"]")
//    @AndroidFindBy(xpath="//*[@resource-id=\"com.safeway.client.android.safeway.debug:id/textViewPayment\"]")
    @AndroidFindBy(id = "paymentTappableZone")
    public MobileElement verifyZipcodeValidation;

}

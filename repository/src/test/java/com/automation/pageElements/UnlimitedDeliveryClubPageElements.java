package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;


public class UnlimitedDeliveryClubPageElements {

    //Click UDC
    @AndroidFindBy(xpath = "//*[@text=\"Unlimited Delivery Club\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Unlimited Delivery Club\"]")
    public MobileElement clickUDC;

    //window title
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(id = "tvTitle")
    public MobileElement pageTitle;

    //Click Annual plan
    @iOSXCUITFindBy(xpath = "//*[@label=\"Annual Plan - 30 day Free Trial\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Annual - 30 day Free Trial\"]")
    public MobileElement clickAnnualPlan;

    //Click Monthly plan
    @iOSXCUITFindBy(xpath = "//*[@label=\"Monthly Plan - 30 day Free Trial\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Monthly - 30 day Free Trial\"]")
    public MobileElement clickMonthlyPlan;

    //Click FAQ
    @iOSXCUITFindBy(xpath = "//*[@label=\"FAQ\"]")
    @AndroidFindBy(xpath = "//*[@text=\"FAQ\"]")
    public MobileElement clickFAQ;

    //Click Terms and Conditions
    @iOSXCUITFindBy(xpath = "//*[@label=\"Terms and Conditions\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Terms and Conditions\"]")
    public MobileElement clickTermsAndConditions;

    //click back button
    @iOSXCUITFindBy(xpath = "//*[@label=\"Settings\"]")
    public MobileElement clickBackButton;

    //Click Payment in Annual Plan page
    @AndroidFindBy(xpath = "//*[@text=\"Payment\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Payment\"]")
    public MobileElement clickPayment;

    //Enter Name as appear on card
    @AndroidFindBy(xpath = "//*[@resource-id=\"name\"]")
    @iOSXCUITFindBy(xpath = "(//*[@value=\"Name as appears on card\"]/following::XCUIElementTypeTextField)[position()=1]")
    public MobileElement enterName;

    //Enter CardNumber
    @AndroidFindBy(xpath = "//*[@resource-id=\"card\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Credit Card Number\"]")
//    @iOSXCUITFindBy(xpath = "(//*[@value=\"Card Number\"]/following::XCUIElementTypeTextField)[position()=1]")
    public MobileElement enterCardNumber;

    //Enter Expiration Month & Year
    @AndroidFindBy(xpath = "//*[@resource-id=\"exp\"]")
    @iOSXCUITFindBy(xpath = "(//*[@value=\"Expiration Month & Year\"]/following::XCUIElementTypeTextField)[position()=1]")
    public MobileElement enterExpirationMonthYear;

    //Enter Billing Zipcode
    @AndroidFindBy(xpath = "//*[@resource-id=\"cc-zip\"]")
    @iOSXCUITFindBy(xpath = "(//*[@value=\"Billing ZIP Code\"]/following::XCUIElementTypeTextField)[position()=1]")
    public MobileElement enterZipcode;

    //Click Continue
    @AndroidFindBy(xpath = "//*[@resource-id=\"submit\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
//    @iOSXCUITFindBy(xpath = "//*[@label=\"Continue\"]")
    public MobileElement clickContinue;


    // Enter CVV number
    @AndroidFindBy(xpath = "(//*[contains(@resource-id,\"edit_text\")])[position()=1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"edit_text_layout\")]")
    @iOSXCUITFindBy(xpath = "//*/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Confirm CVV\"]/following::XCUIElementTypeTextField")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    public MobileElement enterCVV;

    // Confirm CVV
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"btn_next\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Confirm CVV\"]")
    public MobileElement confirmCVV;

    // Click Agree Checkbox
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"checkBox\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"I agree to the Unlimited Delivery Club Terms\")]")
    public MobileElement clickCheckbox;

    // Change Credit Card
    @AndroidFindBy(xpath = "//*[@text=\"Change Credit Card\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Change Credit Card\"]")
    public MobileElement changeCreditCard;

    //Switch to Monthly plan
    @iOSXCUITFindBy(xpath = "(//*[contains(@label,\"Switch to Monthly Plan\")])[position()=1]")
    public MobileElement switchToMonthlyPlan;

    //Switch to Annual plan
    @iOSXCUITFindBy(xpath = "(//*[contains(@label,\"Switch to Annual Plan\")])[position()=1]")
    public MobileElement switchToAnnualPlan;

    // update Payment
    @iOSXCUITFindBy(xpath = "//*[@value=\"Update Payment\"]")
    public MobileElement updatePayment;

    //click Save
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"btn_save\")]")
    public MobileElement clickSave;

    //start subscription
    @iOSXCUITFindBy(xpath = "//*[@value=\"Start Free Trial\"]|//*[@value=\"Start Subscription\"]")
    public MobileElement startSubscription;

    // Subscription Page
    @iOSXCUITFindBy(xpath = "(//*[contains(@label,\"You're All Set!\")])[position()=1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"subscription_header\")]")
    public MobileElement subscriptionPage;

    // Current Subscription
    @iOSXCUITFindBy(xpath = "//*[@label=\"Current Subscription Plan\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"current_subscription_message\")]")
    public MobileElement currentSubscriptionDisplayed;

    // Current Payment
    @iOSXCUITFindBy(xpath = "//*[@label=\"Current Payment Method\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"payment_method_header\")]")
    public MobileElement currentPaymentDisplayed;

    // click change plan Button
    @iOSXCUITFindBy(xpath = "//*[@label=\"Change\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"changePlanText\")]")
    public MobileElement clickChangePlan;

    // click update on current Payment
    @iOSXCUITFindBy(xpath = "//*[@label=\"Update\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"update_text\")]")
    public MobileElement clickUpdatePayment;

    // Cancel Subscription
    @iOSXCUITFindBy(xpath = "//*[@label=\"Cancel Subscription\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"cancel_susbcription_button\")]")
    public MobileElement cancelSubscription;

    // Reason for cancelling --> choose first one
    @iOSXCUITFindBy(xpath = "//*/XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(xpath = "//*/androidx.recyclerview.widget.RecyclerView[1]/android.widget.RadioButton[1]")
    public MobileElement cancellingReason;

    // confirm cancel
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"tv_confirm_cancel_plan\")]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Yes, Cancel Plan\"]")
    public MobileElement confirmCancellation;

    // Subacription Plan window
    @iOSXCUITFindBy(xpath = "(//*[contains(@label,\"Subscription Plan Details\")])[position()=1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"subscription_renewal_text\")]")
    public MobileElement subscriptionPlan;

    //close
    @iOSXCUITFindBy(xpath = "//*[@label=\"Done\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"closeImg\")]")
    public MobileElement clickClose;


}

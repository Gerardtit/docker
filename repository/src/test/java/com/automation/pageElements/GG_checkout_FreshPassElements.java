package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_checkout_FreshPassElements {
    //******************************************* checkout page *******************************************
    //checkoutTitle
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(id = "fp_subscriptionStatus")
    public MobileElement slotsScreenFPBanner;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Unlimited free delivery')]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Unlimited free delivery')]")
    public MobileElement FPTextNewUSer;


    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Enjoy free delivery and')]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Enjoy free delivery and')]")
    public MobileElement FPTextReturningUSer;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Select FreshPass plan\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Select FreshPass plan\"]")
    public MobileElement selectFPPlanScreenHeading;


    @iOSXCUITFindBy(xpath = "//*[@label=\"back\"]")
    @AndroidFindBy(id = "iv_back_arrow")
    public MobileElement backButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[@label='Annual plan']")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]//*[@text=\"Annual plan\"]")
    public MobileElement annualPlan;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[@label=\"$99.00 / year + tax\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]//*[@text=\"$99.00 / year\"]")
    public MobileElement planPrice;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[@label=\"Which is equal to just $8.25 / mo!\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]//*[contains(@text,\"Which is equal to just $8.25\")]")
    public MobileElement annualPlanPriceDetailText1;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[@label=\"Automatically renews\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]//*[contains(@text,\"Automatically renews\")]")
    public MobileElement annualPlanPriceDetailText2;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[@label=\"30-day free trial\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]//*[contains(@text,\"30 Day free trial\")]")
    public MobileElement thirtyDayFreeTrail;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[@label=\"$5 monthly credit - a $60 value\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]//*[contains(@text,\"$5 monthly credit - a $60 value\")]")
    public MobileElement fiveDollarMonthlyText;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[@label=\"Save 35%\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]//*[@text=\"Save 35%\"]")
    public MobileElement saveThirthyPercent;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeButton/XCUIElementTypeStaticText[@label=\"Select\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]//*[@text=\"Select\"]")
    public MobileElement annualPlanSelectButton;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeButton/XCUIElementTypeStaticText[@label=\"Select\"]")
    @AndroidFindBy(xpath = "//android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.Button[1][@text='Select']")
    public MobileElement monthlyPlanSelectButton;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeButton/XCUIElementTypeStaticText[@label=\"Selected\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]//*[@text=\"Selected\"]")
    public MobileElement annualPlanSelectedButton;


    @AndroidFindBy(accessibility = "Close")
    @iOSXCUITFindBy(accessibility = "Done")
    public MobileElement doneButton;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeButton/XCUIElementTypeStaticText[@label=\"Selected\"]")
    @AndroidFindBy(xpath = "//android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.Button[1][@text='Selected']")
    public MobileElement monthlyPlanSelectedButton;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[@label='Monthly plan']")
    @AndroidFindBy(xpath = "//android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView[1][@text=\"Monthly plan\"]")
    public MobileElement monthlyPlan;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[@label=\"$12.99 / month + tax\"]")
    @AndroidFindBy(xpath = "//android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView[2][@text=\"$12.99 / month\"]")
    public MobileElement monthlyPlanPrice;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[@label='Billed monthly']")
    @AndroidFindBy(xpath = "//android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView[4][contains(@text,\"Billed monthly\")]")
    public MobileElement billedMonthly;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[@label=\"Automatically renews\"]")
    @AndroidFindBy(xpath = "//android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView[4][contains(@text,\"Automatically renews\")]")
    public MobileElement automaticallyRenews;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[2]/XCUIElementTypeStaticText[@label=\"30-day free trial\"]")
    @AndroidFindBy(xpath = "//android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.TextView[1][@text='30 Day free trial']")
    public MobileElement mpnthlyThirtyFreeTrail;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[contains(@label,'By tapping')]")
    @AndroidFindBy(id = "tv_terms")
    public MobileElement termsAndConditions;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Sign up\"][@enabled='false']")
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Sign up\"][@enabled='false']")
    public MobileElement signUpButton;


    @iOSXCUITFindBy(xpath = "//*[@label=\"FreshPass terms\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,\"FreshPass terms\")]")
    public MobileElement freshPassLink;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Terms and Conditions\"]")
    @AndroidFindBy(xpath = "//*[@text='Terms and conditions']")
    public MobileElement termsAndConditionsScreen;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Select FreshPass plan\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Back\"]")
    public MobileElement backOnTermsAndCondition;


    //@iOSXCUITFindBy(xpath = "//*[contains(@label,'Free')]|//*[contains(@label,'Your price Free')]|//*[contains(@label,\"Your price Free 3 of \")]//*[contains(@label,\"Free\")]")

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[3]/XCUIElementTypeStaticText[3]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Free\"]")
    public MobileElement deliveryFree;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Sign up\"][@enabled='true']")
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Sign up\"][@enabled='true']")
    public MobileElement activeSignupButton;

    @AndroidFindBy(xpath = "//*[@text=\"FreshPass™ plan added! Enjoy your free deliveries.\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"FreshPass™ plan added! Enjoy your free deliveries.\"]")
    public MobileElement fpPlanAdded;


    @AndroidFindBy(xpath = "//*[@text=\"Free with FreshPass savings.\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Free\")]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Free with FreshPass\"]")
    public MobileElement freeWithFP;

    @AndroidFindBy(xpath = "//*[contains(@text,\"*Your FreshPass saved you\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"*Your FreshPass saved you\")]")
    public MobileElement urFPSavedU;

    @AndroidFindBy(xpath = "//*[contains(@text,\"Your FreshPass is billed separately\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Your FreshPass is billed separately\")]")
    public MobileElement disclaimerOrderSummary;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue to review order\"]|//XCUIElementTypeButton[@name=\"Save\"]|//XCUIElementTypeOther[2]/XCUIElementTypeButton[1]/XCUIElementTypeStaticText[1]")
    public MobileElement clickSlotsButton;
}

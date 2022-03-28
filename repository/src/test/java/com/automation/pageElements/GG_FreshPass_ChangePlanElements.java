package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_FreshPass_ChangePlanElements {
    @AndroidFindBy(xpath = "//*[@text=\"Select\"and @index=\"6\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[3]/XCUIElementTypeButton[1]/XCUIElementTypeStaticText[1]")
    public MobileElement AnnualselectPlan;

    @AndroidFindBy(xpath = "//*[@text=\"Select\"and @index=\"6\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[1]/XCUIElementTypeCell[4]/XCUIElementTypeButton[1]")
    public MobileElement monthlySelectPlan;

    @AndroidFindBy(xpath = "//*[@text=\"FreshPass\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"FreshPass\"and @name=\"FreshPass\"]")
    public MobileElement FreshPassAtTitle;

    @AndroidFindBy(xpath = "//*[@text=\"Annual plan\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Annual plan\"and @name=\"Annual plan\"]")
    public MobileElement AnnualPlan;

    @AndroidFindBy(xpath = "//*[@text=\"$99.00 / year\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"$99.00 / year + tax\"]")
    public MobileElement yrplan;

//    @AndroidFindBy(xpath  = "//*[@text=\"Selected\"]")
//    @iOSXCUITFindBy(xpath="//*[@name=\"Selected\"]")
//    public MobileElement Selectedtab;


    @AndroidFindBy(xpath = "//*[@text=\"Payment method\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Payment method\"]")
    public MobileElement Paymentmethod;


    @AndroidFindBy(xpath = "//android.view.ViewGroup[3]/android.widget.CheckBox[1]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"uncheckMarkTrans\"]")
    public MobileElement checkBox;

    @AndroidFindBy(xpath = "//*[starts-with(@text,\"I agree \")]")
    @iOSXCUITFindBy(xpath = "//*[starts-with(@label,\"I agree \")]")
    public MobileElement iagree;

    @AndroidFindBy(xpath = "//*[@text=\"Confirm\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Confirm\"]")
    public MobileElement Confirmtab;


    @AndroidFindBy(xpath = "//*[@text=\"Confirm CVV\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Confirm CVV\"]")
    public MobileElement ConfirmCVV;


    @AndroidFindBy(xpath = "//*[@text=\"FAQ\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"FAQ\"]")
    public MobileElement FAQtitle;

    @AndroidFindBy(xpath = "//*[@text=\"FAQ\"and @content-desc=\"FAQ\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"FAQ\"]")
    public MobileElement FAQtab;

    //    @AndroidFindBy(xpath  = "//*[@text=\"Terms and Conditions\"and @content-desc=\"Terms and Conditions\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Terms and conditions')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Terms and conditions\"]")
    public MobileElement TNCtab;


    //    @AndroidFindBy(xpath  = "//*[@text=\"Terms and Conditions\"and @content-desc=\"Terms and Conditions\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Terms and Conditions heading\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Terms and Conditions\"]")
    public MobileElement TNCtitle;


}

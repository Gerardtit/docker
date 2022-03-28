package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_Cancellation_FreshpassElements {


    // @iOSXCUITFindBy(xpath = "//*[@label=\"Start my 30-day free trial\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Start my 30-day free trial\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Start my 30-day free trial\"]")
    public MobileElement subscribebutton;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"FreshPass is too expensive\"]")
    @AndroidFindBy(xpath = "//*[@text=\"FreshPass is too expensive\"]")
    public MobileElement canceloption1;

    @iOSXCUITFindBy(xpath = "//*[@value=\"Yes, Cancel Plan\"]")
    @AndroidFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Yes, Cancel Plan\"]")
    public MobileElement yescancel;

    @iOSXCUITFindBy(xpath = "//*[starts-with(@label,\"Free Trial \")]")
//    @iOSXCUITFindBy(xpath="//*[@label=\"Free Trial - Annual  Subscription\" and @visible =\"true\"]")
    @AndroidFindBy(xpath = "//*[starts-with(@text,\"Free Trial \")]")

//    @AndroidFindBy(xpath= "//*[@text=\"Free Trial - Annual Subscription\" ]")
    public MobileElement freetrialtext;

    @iOSXCUITFindBy(xpath = "//*[starts-with(@label,\"Your Free Trial\") and @visible=\"true\"]")
    @AndroidFindBy(xpath = "//*[starts-with(@text,\"Your Free Trial\")]")
    public MobileElement endnotice;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Shop Now\"]")
    @AndroidFindBy(xpath = "//*[@text=\"SHOP NOW\"]")
    public MobileElement shopnowtext;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"lblHorizontalTitleCVCellTitle\"])[2]")
    @AndroidFindBy(xpath = "//*[@text=\"FreshPass\"]")
//    public MobileElement freshpassAtMemberpage;
//    @AndroidFindBy(xpath="//*[@text=\"FreshPass\"]")
    public MobileElement freshpassMembertab;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Welcome\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Welcome\"]")
    public MobileElement profileName;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Birthday\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Birthday\"]")
    public MobileElement dob;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Enter your birthday\"]")
    @AndroidFindBy(xpath = "//*[@text=\"MM / DD\"]")
    public MobileElement MMDD;


    @iOSXCUITFindBy(xpath = "//*[@value=\"Confirm\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Confirm\"]")
    public MobileElement confirm;

    @iOSXCUITFindBy(xpath = "//*[@label=\"MEMBER\"]")
    @AndroidFindBy(xpath = "//*[@text=\"MEMBER\"]")
    public MobileElement membertab;


    //    @iOSXCUITFindBy(xpath ="//XCUIElementTypeButton)[6]")
    @iOSXCUITFindBy(xpath = "///*[@label=\"Unsubscribed\" and @enabled =\"true\"and @type=\"XCUIElementTypeButton\"and @label=\"Unsubscribed\"]]")
//    @iOSXCUITFindBy(xpath="//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]")
//    @AndroidFindBy(xpath="//android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.Button[1]")
//   @AndroidFindBy(xpath = "//*[starts-with(@text,\"Unsubscribed\")]")
    @AndroidFindBy(xpath = "//*[@index=\"0\" and @clickable=\"true\"and @class=\"android.widget.Button\"]")
    public MobileElement NewUser;
    //*[@label="Annual Subscriber"]


    //    @iOSXCUITFindBy(xpath="//*[starts-with(@label,\"You're all\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]")
//    @iOSXCUITFindBy(xpath="//*[@label=\"You're all set!\"]")
    @AndroidFindBy(xpath = "//*[@text=\"You're all set!\"]")
    public MobileElement allSetText;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Your FreshPass membership is now active.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Your FreshPass membership is now active.\"]")
    public MobileElement allSetsubText;

    @iOSXCUITFindBy(xpath = "//*[@value=\"Start subscription\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Start Subscription\"]")
    public MobileElement subscribetab;


    @iOSXCUITFindBy(xpath = "//*[@value=\"Start subscription\"]")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]")
    public MobileElement closetab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Done\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Done\"]")
//    @CacheL
    public MobileElement DonePlansubcribe;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Not right now\" and @value=\"Not right now\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Done\"]")
//    @CacheL
    public MobileElement notnowtext;


}

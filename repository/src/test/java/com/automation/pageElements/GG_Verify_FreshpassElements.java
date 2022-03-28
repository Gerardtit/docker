package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.CacheLookup;

import java.util.List;

public class GG_Verify_FreshpassElements {
    @AndroidFindBy(xpath = "//*[@resource-id=\"android:id/button3\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView[2]/XCUIElementTypeOther[3]")
    public MobileElement SoftUpgrade;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Allow\"]")
    public MobileElement allowElement;

    //next button
    @iOSXCUITFindBy(accessibility = "Tap to Confirm zipcode")
    @AndroidFindBy(id = "btn_next")
    @CacheLookup
    public MobileElement enterButton;

    // home icon
    @iOSXCUITFindBy(xpath = "//*[@label=\"HOME\"]")
//    @AndroidFindBy(xpath ="//*[@text=\"HOME\"]")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.ImageView[1]")
//  @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.TextView[1]")
    public MobileElement homeicon;

    //text = This mobile application uses device caching to improve the user experience.
    @iOSXCUITFindBy(xpath = "//*[@label=\"Allow\"]")
    @AndroidFindBy(xpath = "//*[@text=\"CONTINUE\"]")
    public MobileElement ClickCacheText;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Dismiss\"]")
    @AndroidFindBy(xpath = "//*[@text=\"DISMISS\"]")
    public MobileElement dismissAlert;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Address\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Address\"]")
    public MobileElement Account;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]//*//*[@label=\"Add\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Add\"]")
    public MobileElement addbtn;


    @iOSXCUITFindBy(xpath = "//*[@value=\"Enter ZIP code to find stores\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Enter ZIP code to find stores\"]")
    public MobileElement searchpickupstore;
    // To click Next Button

    @iOSXCUITFindBy(xpath = "//*[@name=\"btnNext-Pick up tool tip\"or @name=\"btnNext-Deals tool tip\"or @label=\"Next\"or @name=\"btnNext-Wallet tool tip\"]")
//    @iOSXCUITFindBy(xpath = "//*[@name=\"btnNext-Pick up tool tip\"or @name=\"btnNext-Deals tool tip\"or @name=\"btnNext-Wallet tool tip\"]")
    @AndroidFindBy(xpath = "//*[@text='Next']")
    public MobileElement ClickNextButton;

    //text = This mobile application uses device caching to improve the user experience.
    @iOSXCUITFindBy(xpath = "//*[@label=\"Dismiss\"]")
    @AndroidFindBy(xpath = "//*[@text=\"CONTINUE\"]")
    public MobileElement dismiss;

    //    @AndroidFindBy(xpath  = "(//android.widget.TextView[@text=\"Wallet\"])")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeOther[1]")
    public MobileElement dugStore;

    //    @AndroidFindBy(xpath  = "(//android.widget.TextView[@text=\"Wallet\"])")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[4]/XCUIElementTypeStaticText[1]")
    public MobileElement neareststore;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[4]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
//    @AndroidFindBy(xpath  = "//*[@content-desc="Account Button"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Account\" and @name=\"Account\"]")
    public MobileElement accountText;

    @AndroidFindBy(xpath = "//*[@class=\"android.widget.ImageView\" and @content-desc=\"Hamburger menu Image\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"User profile\" and @name=\"User profile\"]")
//    @iOSXCUITFindBy(xpath="//XCUIElementTypeTable/XCUIElementTypeButton[6]")
    public MobileElement userProfile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"FreshPass button\"]")
//    @AndroidFindBy(xpath  ="//android.widget.RelativeLayout[5]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"FreshPass\"]")
    public MobileElement FreshPassAtSettings;

    @AndroidFindBy(xpath = "//*[@text=\"Change\"]")
//    @AndroidFindBy(xpath  ="//android.widget.RelativeLayout[5]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Change\"]")
    public MobileElement changeAtPlan;

    //  @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value == 'Email'")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Email'  and @visible='true']")
    @AndroidFindBy(xpath = "//android.widget.Switch[@text='Email']")
    public MobileElement switchEmail;

    //zipcode input
    @iOSXCUITFindBy(xpath = "//*[@label=\"FreshPass\" and @name=\"FreshPass\"]")
    @AndroidFindBy(xpath = "//*[@text=\"FreshPass\"]")
    //@CacheLookup
    public MobileElement FreshPassAtAccount;

    //zipcode input
    @iOSXCUITFindBy(accessibility = "Zip Code")
    @AndroidFindBy(id = "edit_text")
    //@CacheLookup
    public MobileElement zipCodeEditText;

    @AndroidFindBy(xpath = "//*[@text=\"FreshPass\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"FreshPass\"and @name=\"FreshPass\"]")
    public MobileElement FreshPassAtTitle;

    @iOSXCUITFindBy(xpath = "//*[starts-with(@label,\"You can update\")]")
    @AndroidFindBy(xpath = "//*[@text=\"You can update or cancel your plan, view FAQs and terms here.\"]")
//    @iOSXCUITFindBy(xpath="//*[@label=\"You can update or cancel your plan, view FAQs and terms here.\"]")
    public MobileElement subtextWithplan;

    @AndroidFindBy(xpath = "//*[starts-with(@text,\"Free trial ends\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeStaticText[2]")
    public MobileElement enrolledplantext;

    @AndroidFindBy(xpath = "//*[starts-with(@text,\" / year + tax\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeStaticText[1]")
    public MobileElement planperiod;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[2]/android.widget.TextView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeStaticText[1]")
    public MobileElement Crrentplantitle;

    @AndroidFindBy(xpath = "//*[starts-with(@text,\"$99.00\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeStaticText[3]")
    public MobileElement planamount;

    @AndroidFindBy(xpath = "//*[starts-with(@text,\"VIP Customer Service\")]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"VIP Customer Service Phone Line (855) 767-2545\"]")
    public MobileElement VIPtext;

    @AndroidFindBy(xpath = "//*[starts-with(@text,\"FreshPass Members receive\")]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"VIP Customer Service Phone Line 855-767-2545; FreshPass Members receive quick customer service from a dedicated support team.\"]")
    public MobileElement VIPsubtext;

    //    @AndroidFindBy(xpath  = "(//android.widget.TextView[@text=\"Wallet\"])")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Edit\"]")
    public MobileElement editButton;

    @AndroidFindBy(xpath = "//*[@text=\"Manage your plan\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Manage your plan\"]")
    public MobileElement Manageyourplan;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.ImageButton[1]")
//    @AndroidFindBy(xpath  = "//*[@content-desc=\"Back\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"back\"and @name=\"back\"]")
    public MobileElement navigatebacktoSettings;


    @AndroidFindBy(xpath = "//*[@text=\"Confirm\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Confirm\"]")
    public MobileElement Confirmtab;

    @AndroidFindBy(xpath = "//*[@text=\"Done\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Done\"]")
    public MobileElement Donetab;

    @AndroidFindBy(xpath = "//*[@text=\"FAQ\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"FAQ\"]")
    public MobileElement FAQtitle;

    @AndroidFindBy(xpath = "//*[@text=\"FAQ\"and @content-desc=\"FAQ\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"FAQ\"]")
    public MobileElement FAQtab;

    @AndroidFindBy(xpath = "//*[starts-with(@text,\"You’re eligible \")]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"You’re eligible for $20 off your first online order of $75 or more\"]")
    public MobileElement Eligibletext;

    //    @AndroidFindBy(xpath  = "//*[@text=\"Terms and Conditions\"and @content-desc=\"Terms and Conditions\"]")
    @AndroidFindBy(xpath = "//*[contains(@text,'Terms and conditions')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Terms and conditions\"]")
    public MobileElement TNCtab;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Terms and Conditions heading\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Terms and Conditions\"]")
    public MobileElement TNCtitle;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Cancel FreshPass button\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Cancel FreshPass\"]")
    public MobileElement CancelFreshPass;

    @AndroidFindBy(xpath = "//*[@text=\"Cancel Plan\" and @index=\"0\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar//*[@label=\"Cancel Plan\"]")
    public MobileElement CancelplanPageTitle;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Cancel FreshPass button\"]")
    @iOSXCUITFindBy(xpath = "//*[@text=\"NO, KEEP PLAN\"]")
    public MobileElement CancelplanToFreshpass;

    @AndroidFindBy(xpath = "//*[@text=\"Save big on delivery fees\" and @index=\"1\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Save big on delivery fees\"]")
    public MobileElement MarketingMessage;

    //    @AndroidFindBy(xpath  = "//*[@text=\"Save big on delivery fees\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Subscribe for a monthly or annual plan.\"]")
    public MobileElement subMessage;

    @AndroidFindBy(xpath = "//*[@text=\"Must-have grabs\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Must-have grabs\"]")
    public MobileElement homepage;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Current plan Button\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Current Plan\"]")
    public MobileElement CurrentPlan;

    @AndroidFindBy(xpath = "//*[@text=\"Select\"and @index=\"6\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[3]/XCUIElementTypeButton[1]/XCUIElementTypeStaticText[1]")
    public MobileElement AnnualselectPlan;

    @AndroidFindBy(xpath = "//*[@text=\"Select\"and @index=\"5\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[4]/XCUIElementTypeButton[1]/XCUIElementTypeStaticText[1]")
    public MobileElement MonthlyselectPlan;

    @AndroidFindBy(xpath = "//*[@text=\"Save 35%\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Save 35%\"]")
    public MobileElement savePercentage;

    @AndroidFindBy(xpath = "//*[@text=\"Select\"]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"Selected\"]")
    public List<MobileElement> SelectedMonthly;

    @AndroidFindBy(xpath = "//*[@text=\"Select\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Select\"]")
    public MobileElement Selecttab;

    @AndroidFindBy(xpath = "//*[starts-with(@text,\"I agree\") or @id=\"checkbox\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"uncheckMarkTrans\"]")
    public MobileElement IAgree;

    @AndroidFindBy(xpath = "//*[starts-with(@text,\"Start Subscription\") or @id=\"btnContinue\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Start subscription\"]")
    public MobileElement Start;

    //    @AndroidFindBy(xpath  = "//*[starts-with(@text,\"Start Subscription\") or @id=\"btnContinue\"]")
    @AndroidFindBy(xpath = "//*[@text='Add new card']")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Add new card\"]")
    public MobileElement AddnewCard;

    //    @AndroidFindBy(xpath  = "//*[starts-with(@text,\"Start Subscription\") or @id=\"btnContinue\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Need help?\"]")
    public MobileElement NeedHelp;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Shop in-store or make your list\"]")
    @AndroidFindBy(id = "instore_title")
    public MobileElement InStore;

    //select TT at zipcode page
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label=\"0.84 mi.\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"0.84 miles away\"]")
    public MobileElement TTshopAtZipcode;

    @AndroidFindBy(xpath = "//*[@text=\"Edit\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Edit\"]")
    public MobileElement editPayment;

    @AndroidFindBy(xpath = "//*[@resource-id=\"name\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Payment V2\"]/XCUIElementTypeOther[4]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")
    public MobileElement namePayment;

    @AndroidFindBy(xpath = "//*[@resource-id=\"card\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Credit Card Number\"]")
    public MobileElement cardNoPayment;

    @AndroidFindBy(xpath = "//*[@resource-id=\"cc-zip\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Payment V2\"]/XCUIElementTypeTextField[1]")
    public MobileElement zipcodePayment;

    @AndroidFindBy(xpath = "//*[@resource-id=\"exp\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Expiration Date\" and @value=\"￼\"]")
    public MobileElement ExpirePayment;


    @AndroidFindBy(xpath = "//*[@resource-id=\"submit\"]")
//    @iOSXCUITFindBy(xpath="//XCUIElementTypeScrollView[2]/XCUIElementTypeOther[3]")
    public MobileElement submitPayment;

    //cvv
    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    @AndroidFindBy(id = "edit_text")
    public MobileElement cvvEditText;

    //enter cvv
    @iOSXCUITFindBy(xpath = "//*[@label=\"Confirm CVV\" and @name=\"Confirm CVV\"]")
    @AndroidFindBy(id = "btn_next")
    public MobileElement creditCvvNextButton;

    @AndroidFindBy(xpath = "//*[@text=\"Selected\"]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"Selected\"]")
    public MobileElement Selectedtab;

    @iOSXCUITFindBy(xpath = "//*[@value=\"Start subscription\"]")
    @AndroidFindBy(id = "//*[@text=\"Start Subscription\"]")
    public MobileElement subscribetab;


    //confirm CVV at checkout
    @iOSXCUITFindBy(xpath = "//*[@label=\"Confirm CVV\" and @name =\"Confirm CVV\" ]")
    @AndroidFindBy(xpath = "//*[@text=\"Confirm CVV\"]")
//            @AndroidFindBy(id = "payment_error_msg")
    public MobileElement confirmCVV;


}

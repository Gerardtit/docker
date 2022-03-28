package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_birthdaycardElements {

    //    @AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[2]/android.widget.ImageView[2]")
//    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[3]/android.widget.TextView[1]")
//    @AndroidFindBy(xpath="//*[@text=\"Get a birthday treat on us!\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Right arrow\" and @index=\"3\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Get a birthday treat on us\" and @name=\"imgBirthdayCardBannerImage\"]")
    public MobileElement bdaycard;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Close\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"close\"]")
    public MobileElement crossSign;

    //      @AndroidFindBy(xpath="//android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText[1]")
    @AndroidFindBy(id = "edit_text")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Enter your birthday\"]")
    public MobileElement dobedit;


    //    @AndroidFindBy(xpath="//android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
    @AndroidFindBy(xpath = "//*[@text=\"Enter a valid birthday\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Enter a valid birthday\"]")
    public MobileElement entervaliddate;

    //    @AndroidFindBy(xpath="//android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.Button[1]")
    @AndroidFindBy(xpath = "//*[@text=\"Confirm\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Confirm\"]")
    public MobileElement confirmDOB;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.Button[1]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Close\"]")
    public MobileElement closeDOB;


    @AndroidFindBy(xpath = "//android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.Button[1]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Enter your birthday Validation failed.\"]")
    public MobileElement cleareditbox;

    //    @AndroidFindBy(xpath = "//*[@text=\"Get a little treat on your birthday, on us\"]")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView[1]")

    @iOSXCUITFindBy(xpath = "//*[@label=\"Get a little treat on your birthday, on us\"]")
    public MobileElement cardtitle;

    @AndroidFindBy(xpath = "//*[@text=\"Add your birthday below\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Add your birthday below\"]")
    public MobileElement cardsubtitle;


    @AndroidFindBy(xpath = "//*[contains(@text,\"Come back in your birthday month for a special treat\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Come back in your birthday month for a special treat\")]|//*[@name='messageLabel']")
    public MobileElement bdayToastMsg;

    @AndroidFindBy(id = "titlePartDropDownImage")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]")
    public MobileElement userName;

    @AndroidFindBy(xpath = "//*[@text=\"Birthday\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Birthday\"]")
    public MobileElement birthdayText;

    @AndroidFindBy(id = "ib_info_birthday")
    @iOSXCUITFindBy(xpath = "//*[@label=\"newCheckoutInfoButton\"]")
    public MobileElement infoIcon;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[4]/android.widget.LinearLayout[1]/android.widget.TextView[1][@text='Edit']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeStaticText[1][@label=\"Edit\"]")
    public MobileElement bdayEditButton;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[4]/android.widget.LinearLayout[1]/android.widget.TextView[1][@text='Edit']")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Member\"]")
    public MobileElement backToMemberTab;


}


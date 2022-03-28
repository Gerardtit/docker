package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class DeeplinksElements {

    @iOSXCUITFindBy(xpath = "//*[@name=\"NTPHomeFakeOmniboxAccessibilityID\"]")
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.google.android.googlequicksearchbox:id/hint_text_alignment\"]")
    public MobileElement urlBar;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Address and search bar\"]")
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.google.android.googlequicksearchbox:id/search_box\"]")
    public MobileElement urlBarAddress;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Back\"]")
    public MobileElement iOSUrlBack;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Notes\"]")
    public MobileElement iOSNotesBack;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Delete Note\"]")
    public MobileElement iOSDeleteNote;

    @iOSXCUITFindBy(xpath = "//*[@label=\"New note\"]")
    public MobileElement iOSNewNote;

    @iOSXCUITFindBy(xpath = "//*[@label=\"note\"]")
    public MobileElement iOSEnterNote;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Done\"]")
    public MobileElement Done;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeLink[contains(@name ,\"https://\")]")
    public MobileElement urlInNotes;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Show Tabs\"]")
    public MobileElement showTabs;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Close All\"]")
    public MobileElement closeAllTabs;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Create new tab.\"]")
    public MobileElement createNewTab;

    @iOSXCUITFindBy(xpath = "//*[@value=\"Tom Thumb\"]")
    public MobileElement tomThumbSetting;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[3]/XCUIElementTypeStaticText[2]")
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
    public MobileElement carrsCash;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Location Ask\"]")
    public MobileElement locationAskSetting;

    @iOSXCUITFindBy(xpath = "//*[@value=\"Always\"]")
    public MobileElement locationToAlways;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[2]/android.widget.TextView[1]")
    public MobileElement openWithBanner;

    @AndroidFindBy(id = "ivOfferContent")
    @iOSXCUITFindBy(xpath = "//*[contains(@label, \"Offer Terms and Conditions\")]")
    public MobileElement dealDetailPageTitle;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"button1\")]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Done\"]")
    public MobileElement closePopUp;

    @iOSXCUITFindBy(accessibility = "User profile")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, \":id/iv_user_avatar\")]")
//    @AndroidFindBy(accessibility = "Open navigation drawer")
    public MobileElement menuButton;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Prescription Transfer\"]")
    @AndroidFindBy(xpath = "//*[@text='Prescription Transfer']")
    public MobileElement PrescriptionTransferHeader;

    @iOSXCUITFindBy(xpath = "//*[@label='Clip Rewards']")
    @AndroidFindBy(xpath = "//*[@text='Clip Rewards']")
    public MobileElement allRewardsHeader;

    @iOSXCUITFindBy(xpath = "//*[@label=\"appcenter.ms\"]")
    @AndroidFindBy(xpath = "//*[text()=\"Did you create an account directly in App Center?\"]")
    public MobileElement appCenter;

}

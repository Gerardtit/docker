package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.CacheLookup;

public class MenuPageElements {

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'More' AND visible == 1")
    @AndroidFindBy(id = "imageView")
    public MobileElement titleMore;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Transfer Refill\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Transfer Refill\")")
    public MobileElement title_TranferRefill;

    @iOSXCUITFindBy(accessibility = "Sign Out")
    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"Sign Out Button\"])[1]")
    @CacheLookup
    public MobileElement signOutButton;

    @iOSXCUITFindBy(accessibility = "Orders")
    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"Orders button\"])[1]")
    @CacheLookup
    public MobileElement ordersButton;

    @iOSXCUITFindBy(accessibility = "Account")
    //  @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"Account Button\"])[1]")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Account\")")
    @CacheLookup
    public MobileElement accountButton;

    @iOSXCUITFindBy(accessibility = "Help / FAQs")
    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"Help/FAQs Button\"])[1]")
    @CacheLookup
    public MobileElement helpFAQbutton;

    @iOSXCUITFindBy(accessibility = "Feedback")
    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"Feedback Button\"])[1]")
    @CacheLookup
    public MobileElement feedbackButton;

    @iOSXCUITFindBy(accessibility = "Contact Us")
    @AndroidFindBy(accessibility = "Contact Us Button")
    @CacheLookup
    public MobileElement contactUsButton;

    //Terms & Policies
    @iOSXCUITFindBy(accessibility = "Terms & Policies")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Terms & Policies\")")
    @CacheLookup
    public MobileElement termsPoliciesButton;

    //Third Party & Open Source
    @iOSXCUITFindBy(accessibility = "Third Party & Open Source")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Third Party & Open Source\")")
    @CacheLookup
    public MobileElement thirdPartyButton;

    @iOSXCUITFindBy(accessibility = "Product Recalls")
    @AndroidFindBy(accessibility = "Product Recalls Button")
    @CacheLookup
    public MobileElement productRecallButton;

    //Need Help on menu page
    @iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton' AND name BEGINSWITH 'Need Help'")
    @AndroidFindBy(id = "needHelpBtn")
    public MobileElement needHelpInMenu;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Need Help?\"]")
    @AndroidFindBy(id = "needHelpBtn")
    public MobileElement needHelpInMenuAccount;

    //version
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name CONTAINS 'Version' AND visible == 1")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Version\")")
    @CacheLookup
    public MobileElement versionText;


    //window title
    @iOSXCUITFindBy(className = "XCUIElementTypeNavigationBar")
    @AndroidFindBy(id = "tvTitle")
    public MobileElement windowTitleElement;

    //back button: android arrow, ios arrow
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[6]")
    @AndroidFindBy(accessibility = "Navigate up")
    public MobileElement topLeftArrowBack;

    //************************************  sign out pop-up  ************************************
    @iOSXCUITFindBy(accessibility = "Are you sure you want to sign out?")
    @AndroidFindBy(id = "android:id/message")
    @CacheLookup
    public MobileElement confirmSignOutMessage;

    @iOSXCUITFindBy(accessibility = "Cancel")
    @AndroidFindBy(id = "android:id/button2")
    @CacheLookup
    public MobileElement cancelSignOut;

    @iOSXCUITFindBy(accessibility = "OK")
    @AndroidFindBy(id = "android:id/button1")
    @CacheLookup
    public MobileElement confirmSignOutButton;

    //************************************  Help FAQ  ************************************
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeNavigationBar' AND name CONTAINS 'Help' AND visible == 1")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Help/FAQs\")")
    public MobileElement helpWindowTitle;

    //************************************  Contact US  ************************************
    @iOSXCUITFindBy(accessibility = "Chat")
    @AndroidFindBy(id = "tv_chat_title")
    public MobileElement chatButton;

    @iOSXCUITFindBy(accessibility = "Delivery & Pickup Questions?")
    @AndroidFindBy(id = "tv_msg_title")
    public MobileElement deliveryPickupQuestion;
}

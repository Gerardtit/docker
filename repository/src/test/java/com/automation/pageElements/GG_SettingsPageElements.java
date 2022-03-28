package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_SettingsPageElements {


    @AndroidFindBy(id = "iv_user_avatar")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'User profile' AND visible==1")
    public MobileElement profileIcon;

    @AndroidFindBy(accessibility = "Sign Out Button")
    @iOSXCUITFindBy(accessibility = "Sign Out")
    public MobileElement signOutbtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Orders']")
    @iOSXCUITFindBy(accessibility = "Orders")
    public MobileElement orderModulebtn;

    @AndroidFindBy(accessibility = "Unlimited Delivery Club Button")
    @iOSXCUITFindBy(accessibility = "Unlimited Delivery Club")
    public MobileElement unlimitedDeliveryClubbtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Unlimited Delivery Club']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Unlimited Delivery Club' AND visible == 1")
    public MobileElement unlimitedDeliveryClubTitle;

    //back button/arrow
    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Settings'")
    public MobileElement backButtonToSettings;

    @iOSXCUITFindBy(accessibility = "Settings")
    @AndroidFindBy(accessibility = "Close")
    public MobileElement navigateButtonToSettings;

    @AndroidFindBy(className = "android.widget.ProgressBar")
    @iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeStaticText' value='Loading'")
    public MobileElement loadingSpinner;

    @AndroidFindBy(accessibility = "Vaccine Scheduler Button")
    @iOSXCUITFindBy(accessibility = "Vaccine Scheduler")
    public MobileElement vaccineSchedulerbtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Vaccine Scheduler']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Vaccine Scheduler' AND visible == 1")
    public MobileElement vaccineSchedulerTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Account']")
    @iOSXCUITFindBy(accessibility = "Account")
    public MobileElement accountbtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Account']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Account' AND visible == 1")
    public MobileElement accountTitle;

    @AndroidFindBy(accessibility = "Scan Setting Button")
    @iOSXCUITFindBy(accessibility = "Scan setting")
    public MobileElement scanSettingbtn;

    @AndroidFindBy(id = "tv_scan_setting")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Scan Setting' AND visible == 1")
    public MobileElement scanSettingTitle;

    @AndroidFindBy(accessibility = "Help/FAQs Button")
    @iOSXCUITFindBy(accessibility = "Help / FAQs")
    public MobileElement helpFAQbtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Help/FAQs']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Help / FAQs' AND visible == 1")
    public MobileElement helpFAQTitle;

 /*   @AndroidFindBy(accessibility = "Feedback Button")
    @iOSXCUITFindBy(accessibility = "Feedback")
    public MobileElement feedbackBtn;*/

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Feedback']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Feedback' AND visible == 1")
    public MobileElement feedbackTitle;

    /*@AndroidFindBy(accessibility = "Contact Us Button")
    @iOSXCUITFindBy(accessibility = "Contact Us")
    public MobileElement contactUsBtn;*/

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Contact Us']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Contact Us' AND visible == 1")
    public MobileElement contactUsTitle;

    @AndroidFindBy(accessibility = "Terms & Policies button")
    @iOSXCUITFindBy(accessibility = "Terms & Policies")
    public MobileElement termsandPoliciesBtn;

    @AndroidFindBy(xpath = "//*[@content-desc=\"FreshPass button\"]")
    @iOSXCUITFindBy(accessibility = "Feedback")
    public MobileElement feedbackBtn;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Contact Us button\"]")
    @iOSXCUITFindBy(accessibility = "Contact Us")
    public MobileElement contactUsBtn;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Terms & Policies']")

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Terms & Policies']")

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Terms & Policies' AND visible == 1")
    public MobileElement termsandPoliciesTitle;

    @AndroidFindBy(accessibility = "Third Party & Open Source Button")
    @iOSXCUITFindBy(accessibility = "Third Party & Open Source")
    public MobileElement thirdPartyandOpenSourceBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Third Party & Open Source']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Third Party & Open Source' AND visible == 1")
    public MobileElement thirdPartyandOpenSourceTitle;

    @AndroidFindBy(accessibility = "Product Recalls Button")
    @iOSXCUITFindBy(accessibility = "Product Recalls")
    public MobileElement productRecallBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Product Recalls']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Product Recalls' AND visible == 1")
    public MobileElement productRecallTitle;

    @AndroidFindBy(id = "needHelpBtn")
    @iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton' AND name BEGINSWITH 'Need Help'")
    public MobileElement needHelpBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Chat']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Chat' AND visible == 1")
    public MobileElement needHelpTitle;

    @AndroidFindBy(id = "tv_scan_setting_name")
    @iOSXCUITFindBy(accessibility = "lblAddOffersTitle")
    public MobileElement addOfferAutomaticallyTitle;

    @AndroidFindBy(id = "tv_scan_setting_desc")
    @iOSXCUITFindBy(accessibility = "lblAddOffersDescription")
    public MobileElement addOfferAutomaticallyDesc;

    @AndroidFindBy(id = "btn_setting_switch")
    @iOSXCUITFindBy(accessibility = "btnAddOffersSwitch")
    public MobileElement addOfferAutomaticallyTogglebtn;

    @AndroidFindBy(id = "tvTitle")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Type your question here...\" AND type == \"XCUIElementTypeTextView\"")
    public MobileElement chatTextField;

    @AndroidFindBy(id = "tv_chat_title")
    @iOSXCUITFindBy(id = "Chat")
    public MobileElement chatOptionContactUs;

    // @AndroidFindBy(accessibility = "Developer Settings Button")
    @AndroidFindBy(accessibility = "Developer Settings button")
    @iOSXCUITFindBy(accessibility = "Developer Settings")
    public MobileElement developerSettings;

    @AndroidFindBy(id = "btn_save")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Save' AND type == 'XCUIElementTypeButton'")
    public MobileElement saveDeveloperSettingBtn;

    @AndroidFindBy(accessibility = "close")
    @iOSXCUITFindBy(accessibility = "back")
    public MobileElement closeButtonOfSetting;

    @AndroidFindBy(id = "txt_footer")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Albertsons Companies' AND visible==1")
    public MobileElement appInfo;

    @AndroidFindBy(accessibility = "Terms & Policies button")
    @iOSXCUITFindBy(accessibility = "Terms & Policies")
    public List<MobileElement> termsandPoliciesButton;
}

package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.CacheLookup;

import java.util.List;

public class GG_AccountPageElements {

    @AndroidFindBy(id = "tvTitle")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Account\"")
    public MobileElement accountHeaderTitle;

    @AndroidFindBy(accessibility = "Sign Out Button")
    @iOSXCUITFindBy(id = "Sign Out")
    public MobileElement signOutButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    @iOSXCUITFindBy(id = "OK")
    public MobileElement confirmSignOutOkButton;

    @AndroidFindBy(id = "lifetime_amt")
    @iOSXCUITFindBy(accessibility = "Lifetime")
    public MobileElement lifetimeSavingsField;

    @AndroidFindBy(xpath = "PENDING")
    @iOSXCUITFindBy(accessibility = "PENDING")
    public MobileElement deliveryAddressOption;

    @AndroidFindBy(xpath = "PENDING")
    @iOSXCUITFindBy(accessibility = "PENDING")
    public MobileElement deliveryAddressPageTitle;

    @AndroidFindBy(xpath = "PENDING")
    @iOSXCUITFindBy(accessibility = "PENDING")
    public MobileElement backButton;

    @AndroidFindBy(xpath = "PENDING")
    @iOSXCUITFindBy(accessibility = "PENDING")
    public MobileElement saveButton;

    @AndroidFindBy(xpath = "PENDING")
    @iOSXCUITFindBy(accessibility = "PENDING")
    public MobileElement addressLineTextField;

    @AndroidFindBy(id = "edit_text")
    @iOSXCUITFindBy(xpath = "//*[@name='Delivery Instructions (optional)']//following-sibling:: XCUIElementTypeTextView")
    public MobileElement deliveryInstructionsSection;

    @AndroidFindBy(id = "error_message")
    @iOSXCUITFindBy(accessibility = "Please enter valid delivery instructions.")
    public MobileElement errorMessageOnDeliveryInstructionSection;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Pickup Store Address']")
    @iOSXCUITFindBy(accessibility = "Pickup Store Address")
    public MobileElement pickUpStoreSection;

    @AndroidFindBy(id = "address")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblStoreAddress'")
    public List<MobileElement> pickUpStoreAddressList;

    @AndroidFindBy(id = "btn_save")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Save'")
    public MobileElement saveButtonOnPickUpStoreSelection;

    @AndroidFindBy(id = "android:id/button2")
    @iOSXCUITFindBy(accessibility = "Back")
    public MobileElement backOptionOnPickUpStoreSelectionPopUp;

    @AndroidFindBy(id = "android:id/button2")
    @iOSXCUITFindBy(accessibility = "No")
    public MobileElement noOptionOnPickUpStoreSelectionPopUp;

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public MobileElement cancelButtonPickUpStoreSelection;

    @AndroidFindBy(id = "android:id/button1")
    @iOSXCUITFindBy(accessibility = "Continue")
    public MobileElement continueOptionOnPickUpStoreSelectionPopUp;

    @AndroidFindBy(id = "dug_address_content")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[14]")
    public MobileElement pickUpStoreAddressOnAccountPage;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND name == 'Email' AND visible == 1")
    @AndroidFindBy(id = "edit_text")
    public List<MobileElement> emailEditTextList;

    @AndroidFindBy(id = "Sorry, the email address you entered already exists.")
    @iOSXCUITFindBy(accessibility = "Sorry, the email address you entered already exists.")
    public MobileElement errorMessageIsDisplayedOnEmailAddressEditPage;

    @AndroidFindBy(id = "comm_pref_rl")
    @iOSXCUITFindBy(accessibility = "Communication Preferences")
    public MobileElement communicationPreferencesSection;

    @AndroidFindBy(id = "tvTitle")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Communication Preferences'")
    public MobileElement communicationPreferencesSectionTitle;

    @AndroidFindBy(id = "push_switch")
    @iOSXCUITFindBy(accessibility = "Push Notifications, Order updates, special deals and more.")
    public MobileElement pushNotificationToggle;

    @AndroidFindBy(className = "android.widget.Switch")
    @iOSXCUITFindBy(accessibility = "PENDING")
    public MobileElement nativeNotificationToggle;

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(accessibility = "PENDING")
    public MobileElement nativeNotifcationBackButton;

    @AndroidFindBy(id = "j4U_switch")
    @iOSXCUITFindBy(accessibility = "just for U, Receive your just for U savings in your inbox. Stay up to date on your personalized prices, get special promotions, and more.")
    public MobileElement justForUToggle;

    @AndroidFindBy(id = "weekly_specials_switch")
    @iOSXCUITFindBy(accessibility = "Weekly Specials, Stay on top of weekly specials, connect on food and recipes, and benefit from health and wellness news.")
    public MobileElement weeklySpecialsToggle;

    @AndroidFindBy(id = "grocery_delivery_switch")
    @iOSXCUITFindBy(accessibility = "Grocery Delivery, We make it easy to shop and save online, with the latest sale items plus online exclusive promotions.")
    public MobileElement groceryDeliveryToggle;

    @AndroidFindBy(id = "j4U_recalls_switch")
    @iOSXCUITFindBy(accessibility = "just for U Product Recalls, Just for U subscribers can also receive updates on applicable Class I product recalls.")
    public MobileElement justForUProductRecallsToggle;

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(accessibility = "Account")
    public MobileElement backButtonOnCommunicationPreferencesPage;

    @AndroidFindBy(id = "Navigate up")
    @iOSXCUITFindBy(accessibility = "Account")
    public MobileElement saveButtonOnEmailAddressEditPage;

    //@AndroidFindBy(id = "Orders Button")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Orders']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Orders'")
    public MobileElement orderSection;

    @AndroidFindBy(xpath = "//*[@text='Past Orders']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeOther' AND name == 'Past Orders'")
    public MobileElement pastOrderTitle;

    @iOSXCUITFindBy(accessibility = "OK")
    @AndroidFindBy(id = "android:id/button1")
    @CacheLookup
    public MobileElement confirmSignOutButton;

    @AndroidFindBy(id = "dug_address_content")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Pickup Store Address']/..//XCUIElementTypeStaticText[2]")
    public MobileElement pickupStoreAddressText;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Notifications, Banners, Sounds, Badges' AND visible == 1")
    public MobileElement pushNotificationSettings;
}


package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.CacheLookup;

import java.util.List;

public class CreateAccountPageElements {

    public final int android_firstNameIndex = 0;
    public final int ios_firstNameIndex = 0;
    public final int android_lastNameIndex = 1;
    public final int ios_lastNameIndex = 1;
    public final int android_emailIndex = 2;
    public final int ios_emailIndex = 2;
    public final int android_passwordIndex = 3;
    public final int android_phoneCardNoIndex = 4;
    public final int ios_phoneCardNoIndex = 3;
    //continue
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Continue' AND visible == 1")
    @AndroidFindBy(id = "buttonNext")
    public MobileElement continueButton;
    //back button - ios
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND value == 'Back' AND visible == 1")
    public MobileElement iosBackButton;
    //logo
    @iOSXCUITFindBy(accessibility = "ScriptLogo")
    @AndroidFindBy(id = "imageViewBanner")
    public MobileElement logoImage;
    //ZIP Code title
    @iOSXCUITFindBy(accessibility = "ZIP Code")
    @AndroidFindBy(id = "title")
    public MobileElement zipCodeTitle;
    //zip code editText
    @iOSXCUITFindBy(accessibility = "Zip Code")
    @AndroidFindBy(id = "edit_text_zip")
    public MobileElement zipCodeEditText;
    //enter zip button ->
    @iOSXCUITFindBy(accessibility = "Tap to Confirm zipcode")
    @AndroidFindBy(id = "btn_get_started")
    public MobileElement enterZipButton;
    //cancel button left top corner
    @iOSXCUITFindBy(accessibility = "Cancel")
    @AndroidFindBy(id = "img_cross")
    public MobileElement cancelButton;
    //create Account Page Title "Create Account button"
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value == 'Sign Up' AND visible == 1")
    @AndroidFindBy(id = "tvTitle")
    public MobileElement createAccountTitle;
    //tell us about yourself
    @iOSXCUITFindBy(accessibility = "Tell us about yourself. If you have an account, we'll find it.")
    @AndroidFindBy(id = "reg1_header_text")
    public MobileElement tellUsAboutYourselfText;
    //phone no or Club card no.
    @iOSXCUITFindBy(accessibility = "Phone Number or Club Card")
    @AndroidFindBy(id = "editTextLoyaltyCard")
    public MobileElement phoneCardEditNumber;
    //more info icon "!"
    @iOSXCUITFindBy(accessibility = "More Info")
    @AndroidFindBy(id = "img_info")
    public MobileElement moreInfoIcon;
    //error phone no
    @iOSXCUITFindBy(accessibility = "Your phone or loyalty card number is already registered with us. " +
            "Please Sign In. For additional help, contact Customer Support at 1-877-505-4040")
    @AndroidFindBy(id = "textinput_error")
    public MobileElement phoneNumberErrorMessage;
    //first name
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND value == 'First Name' AND visible == 1")
    @AndroidFindBy(id = "editTextFirstName")
    public MobileElement firstNameEditText;
    //last name
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND value == 'Last Name' AND visible == 1")
    @AndroidFindBy(id = "editTextLastName")
    public MobileElement lastNameEditText;
    //error email message
    @iOSXCUITFindBy(accessibility = "Your email address is already registered with us. Please Sign In. For assistance, contact Customer Support 1-877-505-4040")
    @AndroidFindBy(id = "textinput_error")
    public MobileElement emailErrorMessage;
    //email
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND value == 'Email' AND visible == 1")
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Email']")
    public MobileElement emailEditText;
    //password
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeSecureTextField' AND value == '8 - 40 characters' AND visible == 1")
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Password (8 - 40 Characters)']")
    public MobileElement passwordEditText;
    //show password
    @iOSXCUITFindBy(accessibility = "Show")
    @AndroidFindBy(id = "text_input_end_icon")
    public MobileElement showPasswordButton;
    //validation check mark
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value == 'Validation succeeded.' AND visible == 1")
    public MobileElement iosValidationCheck;
    //where should we bring your groceries
    @iOSXCUITFindBy(accessibility = "Where should we bring your groceries?")
    @AndroidFindBy(id = "reg2_header_text")
    public MobileElement deliverTextMessage;
    //Residential button
    @iOSXCUITFindBy(id = "Residential")
    @AndroidFindBy(id = "radio_residential")
    public MobileElement residentialButton;
    //Commercial button
    @iOSXCUITFindBy(id = "Business")
    @AndroidFindBy(id = "radio_bussiness")
    public MobileElement commercialButton;
    //street address 1
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND value == 'Address Line 1' AND visible == 1")
    @AndroidFindBy(id = "editTextAddress1")
    public MobileElement streetAddress1EditText;
    //street address 2
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND value == 'Street Address 2 (optional)' AND visible == 1")
    @AndroidFindBy(id = "editTextAddress2")
    public MobileElement streetAddress2EditText;
    //third page - term agreement
    @iOSXCUITFindBy(accessibility = "Do you agree to the terms of Service? Checkbox")
    @AndroidFindBy(id = "checkboxTerms")
    public MobileElement agreeCheckBox;
    //how do you hear about us
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND value BEGINSWITH[c] 'How did you hear about' AND visible == 1")
    @AndroidFindBy(id = "editTextHowHear")
    public MobileElement referenceDropDown;
    //drop down picker wheel - ios only
    @iOSXCUITFindBy(className = "XCUIElementTypePickerWheel")
    public MobileElement iosReferencePickerWheel;
    //Done button on pickerWheel ios only
    @iOSXCUITFindBy(accessibility = "Done")
    public MobileElement iosDoneButton;
    //shop now
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Shop Now' AND visible == 1")
    @AndroidFindBy(id = "buttonNext")
    public MobileElement shopNowButton;
    @AndroidFindBy(id = "android:id/text1")
    public List<MobileElement> referenceDropDownOption;
    @iOSXCUITFindBy(accessibility = "You can view and remove saved passwords in Passwords & Accounts settings.")
    public MobileElement savePasswordText;
    @iOSXCUITFindBy(accessibility = "Save Password")
    public MobileElement savePasswordButton;
    @iOSXCUITFindBy(accessibility = "Not Now")
    public MobileElement savePasswordNotNowButton;
    //new sign up page
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Create Account'")
    @AndroidFindBy(id = "buttonLogin")
    @CacheLookup
    public MobileElement createAccountButton;
    //create account page edit text
    @iOSXCUITFindBy(className = "XCUIElementTypeTextField")
    @AndroidFindBy(className = "android.widget.EditText")
    @CacheLookup
    public List<MobileElement> textFieldList;
    //ios password text edit field
    @iOSXCUITFindBy(className = "XCUIElementTypeSecureTextField")
    @CacheLookup
    public MobileElement ios_password;
    //First name check mark
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[1]/XCUIElementTypeStaticText[2]")
    @AndroidFindBy(accessibility = "First NameValidated")
    public MobileElement firstNameCheckMark;

    //First name error mark
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[1]/XCUIElementTypeButton[1]")
    @AndroidFindBy(accessibility = "First NameError")
    public MobileElement firstNamErrorMark;

    //Last name check mark
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[2]/XCUIElementTypeStaticText[2]")
    @AndroidFindBy(accessibility = "Last NameValidated")
    public MobileElement lastNameCheckMark;

    //Last name error mark
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[2]/XCUIElementTypeButton[1]")
    @AndroidFindBy(accessibility = "Last NameError")
    public MobileElement lastNamErrorMark;

    //Email Address check mark
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[3]/XCUIElementTypeStaticText[2]")
    @AndroidFindBy(accessibility = "Email AddressValidated")
    public MobileElement emailCheckMark;

    //Email Address error mark
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[3]/XCUIElementTypeButton[1]")
    @AndroidFindBy(accessibility = "Email AddressError")
    public MobileElement emailErrorMark;

    //Password check mark
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[1]/XCUIElementTypeStaticText[2]")
    //@AndroidFindBy(accessibility = "NameValidated")
    public MobileElement passwordCheckMark;

    //Password error mark
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[1]/XCUIElementTypeButton[1]")
    @AndroidFindBy(accessibility = "Password must be 8–40 characters")
    public MobileElement passwordErrorMark;

    //Phone card no check mark
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[4]/XCUIElementTypeStaticText[2]")
    @AndroidFindBy(accessibility = "Phone # or Club Card # used in StoreValidated")
    public MobileElement phoneCardNoCheckMark;

    //phone card no error mark
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[4]/XCUIElementTypeButton[1]")
    @AndroidFindBy(accessibility = "Phone # or Club Card # used in StoreError")
    public MobileElement phoneCardNoErrorMark;

    //term of use link
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Terms of Use' AND visible == 1")
    @AndroidFindBy(id = "buttonTerms")
    public MobileElement termOfUseLink;

    //privacy policy link
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Privacy Policy' AND visible == 1")
    @AndroidFindBy(id = "buttonPrivacy")
    public MobileElement privacyPolicyLink;

    //android just once button
    @AndroidFindBy(id = "android:id/button_once")
    public MobileElement android_JustOnceButton;

    //android choose webview browser
    @AndroidFindBy(xpath = "//android.widget.TextView [@text=\"WebView Browser Tester\"]")
    public MobileElement android_WebViewBrowserButton;
}

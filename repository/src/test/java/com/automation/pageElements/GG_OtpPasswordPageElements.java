package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class GG_OtpPasswordPageElements {

    // @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Mobile'")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Mobile'  and @visible='true']")
    @AndroidFindBy(id = "switchCompat")
    //@AndroidFindBy(xpath = "//android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.widget.Switch[1]")
    public MobileElement switchMobile;

    @iOSXCUITFindBy(accessibility = "Continue")
    @AndroidFindBy(xpath = "//*[@resource-id='android:id/button1']")
    public MobileElement continueButton;

    @iOSXCUITFindBy(accessibility = "return")
    //  @AndroidFindBy(xpath = "//*[@resource-id='android:id/button1']")
    public MobileElement DoneButton;

    @iOSXCUITFindBy(accessibility = "Invalid Email")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Invalid Email\")")
    public MobileElement invalidEmailText;

    @iOSXCUITFindBy(accessibility = "Privacy Policy.")
    // @iOSXCUITFindBy(xpath = "//*[contains(@label,'Privacy Policy.")
    @AndroidFindBy(xpath = "//*[contains(@text,'Terms of Use and Privacy Policy')]")
    public MobileElement privacyPolicyText;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar/XCUIElementTypeButton)[1]")
    public MobileElement backButton;

    @iOSXCUITFindBy(accessibility = "Terms of Use")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Terms of Use\")")
    public MobileElement termsOfUseText;


    @iOSXCUITFindBy(xpath = "//h1[text()='Privacy Policy']")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Privacy Policy\")")
    public WebElement privacyPolicyPage;

    @iOSXCUITFindBy(accessibility = "Hi, friend")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Hi, friend\")")
    public MobileElement hiFriendText;

    @iOSXCUITFindBy(accessibility = "Let’s get started")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Let’s get started\")")
    public MobileElement letsGetStartedText;

    // @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND value == 'name@email.com'")
    @iOSXCUITFindBy(xpath = "//*[@value='name@email.com']")
    // @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")
    @AndroidFindBy(id = "uma_edit_text")
    public MobileElement emailInput;

    //  @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField' AND value == '(000) 000 0000'")
    @iOSXCUITFindBy(xpath = "//*[@value='(000) 000 0000']")
    @AndroidFindBy(id = "uma_edit_text")
    public MobileElement mobileInput;


    @iOSXCUITFindBy(iOSNsPredicate = "type='XCUIElementTypeButton' AND name CONTAINS 'Email' || type='XCUIElementTypeStaticText' AND name CONTAINS 'Email'")

    @AndroidFindBy(id = "switchCompat")
    public MobileElement switchEmail;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Submit' ")
    @AndroidFindBy(id = "uma_btn_next")
    //   @AndroidFindBy(xpath="//android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.ImageButton[1]")
    //@AndroidFindBy(xpath = "//*[contains(@resource-id,'id/uma_btn_next')]")
    public MobileElement nextButton;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Submit' ")
//    @AndroidFindBy(accessibility = "Submit")
//    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/uma_btn_next')]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'id/btn_next')]")
    public MobileElement nextButtonInEmailTextField;

    @iOSXCUITFindBy(xpath = "//*[@label='Enter your email address to sign in or create your account. You will receive a verification code in your email inbox.']")
    @AndroidFindBy(id = "textInfo")
    public MobileElement instructionForEmailUser;

    @iOSXCUITFindBy(xpath = "//*[@label='Enter your mobile number to sign in or create your account. You will receive a verification code by text message.']")
    @AndroidFindBy(id = "textInfo")
    public MobileElement instructionForMobileUser;


    //  @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Entry must be a mobile number. Message and data rates may apply.'")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Entry must be a mobile number. Message and data rates may apply.']")
    @AndroidFindBy(id = "tv_desc_phone")
    public MobileElement instructionForMobileNumber;

    //    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Start over'")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Start over']")
    @AndroidFindBy(id = "textStartOver")
    public MobileElement startOverAgain;

    @iOSXCUITFindBy(xpath = "//*[@label=\"We see you’re already a customer\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"We see you're already a customer\")")
    public MobileElement lockedCustomerMsg;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Didn’t get a code?\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Didn’t get a code?\")")
    public MobileElement dintGetCodeText;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Resend code\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Resend code\")")
    public MobileElement resendCodeText;


    //  @iOSXCUITFindBy(xpath = "//*[contains(@label,'ve sent a code to')]")
    @AndroidFindBy(id = "didNotGetACodeDetail")
    public MobileElement codeDescriptionText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Try a different email\")")
    public MobileElement differentEmailText;

    @iOSXCUITFindBy(xpath = "//*[@label=\"We see you’re already a customer\"]")
    //  @AndroidFindBy(uiAutomator = "new UiSelector().text(\"We see you're already a customer\")")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView[1]")
    public MobileElement imageErrorIcon;

    @iOSXCUITFindBy(xpath = "//*[@label=\"\u202A1 (877) 258-2799\u202C\"]")
    //  @AndroidFindBy(id = "dialpad_search_list_view")
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.view.ViewGroup[1]")
    public MobileElement dialPadScreen;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Please contact support at 1 877 258 2799 to reactivate.\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Please contact support at 1-877-258-2799 to reactivate.\")")
    public MobileElement lockedoutMsg;

    @iOSXCUITFindBy(xpath = "//*[@value=\"Contact Support\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Contact Support\")")
    public MobileElement contactSupportCTA;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Call 1 (877) 258-2799\"]")
    //  @AndroidFindBy(id = "permission_allow_button")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.Button[1]")
    public MobileElement allowDialPad;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Cancel\"]")
    //  @AndroidFindBy(id = "permission_allow_button")
    public MobileElement navigateBack;

    @iOSXCUITFindBy(xpath = "//*[@value=\"Cancel\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Cancel\")")
    public MobileElement cancelLink;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Check your text message')]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Check your text message\")")
    public MobileElement msgOTPHeader;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,'ve sent a code to')]")
    @AndroidFindBy(id = "textWeHave")
    public MobileElement userText; // Text to identify Registered/New User.

    //Resend code Button
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Resend code\")]")
    @AndroidFindBy(id = "textResend")
    public MobileElement resendCode;

    //@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeOther' AND name == 'OTP textfield'")
    //@iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")
    @AndroidFindBy(id = "edit_text_layout")
    public MobileElement otpInput;

    //@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'edit_text_layout')]/android.widget.EditText[1]")
    public MobileElement otpInputkey1;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[2]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'edit_text_layout')]/android.widget.EditText[2]")
    public MobileElement otpInputkey2;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[3]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'edit_text_layout')]/android.widget.EditText[3]")
    public MobileElement otpInputkey3;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[4]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'edit_text_layout')]/android.widget.EditText[4]")
    public MobileElement otpInputkey4;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[5]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'edit_text_layout')]/android.widget.EditText[5]")
    public MobileElement otpInputkey5;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[6]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'edit_text_layout')]/android.widget.EditText[6]")
    public MobileElement otpInputkey6;

    // @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Validate OTP'")
    //@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Validate OTP']")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Validate OTP\"]")
    @AndroidFindBy(id = "btn_next")
    public MobileElement submitButton;


    @iOSXCUITFindBy(xpath = "//*[@id=\"inbox_field\"]")
    @AndroidFindBy(xpath = "//*[@id='login']")
    public MobileElement Email_UserNameTextField;

    @iOSXCUITFindBy(xpath = "//*[@class=\"primary-btn\"]")
    @AndroidFindBy(xpath = "//*[@class=\"sbut\"]")
    public MobileElement Email_loginButton;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeLink' AND label CONTAINS 'your one-time authentication code'")
    @AndroidFindBy(xpath = "//*[@class=\"lms_m\"]")
    public MobileElement Email_RecentOtpEmail;

    @iOSXCUITFindBy(xpath = "//*[@id=\"verification-code\"]")
    @AndroidFindBy(xpath = "//*[contains(text(),'To complete')]/../following-sibling::*[1]")
    public MobileElement Email_OTPCode;

    //@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'User profile'")
    @AndroidFindBy(id = "iv_user_avatar")
    public MobileElement UMA_Home;

    //  @iOSXCUITFindBy(iOSNsPredicate = "label == 'Allow'")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Allow'")
    // @AndroidFindBy(id = "iv_user_avatar")
    public MobileElement Allow;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Next'")
    @AndroidFindBy(xpath = "(//*[@text='Next'])")
    public MobileElement Delivery_Next;

    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"CONTINUE\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Continue\"")
    public MobileElement cachingContinueBtn;

    @AndroidFindBy(id = "ctaClose")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Cart Close' AND visible==1")
    public MobileElement closeForYouTestingSheetButton;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeLink[@label=\"select\"]")
    public MobileElement selectAllEmail;

    @iOSXCUITFindBy(xpath = "//*[@label=\"YOPmail\"]/XCUIElementTypeLink[4]")
    public MobileElement deleteAllEmail;

    @AndroidFindBy(xpath = "//*[@text='Try a different email']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Try a different email'")
    public MobileElement tryDiffEmailLink;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,'you can sign into your account')]")
    @AndroidFindBy(xpath = "//*[contains(@text,'you can sign into your account')]")
    public MobileElement otpMessageForSignedUser;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,'you can create your account')]")
    @AndroidFindBy(xpath = "//*[contains(@text,'you can create your account')]")
    public MobileElement otpMessageForNewUser;

    @AndroidFindBy(xpath = "PENDING")
    @iOSXCUITFindBy(iOSNsPredicate = "label=='Invalid verification code' and visible==1")
    public MobileElement invalidOtpLabel;

    @AndroidFindBy(id = "textResend")
    @iOSXCUITFindBy(iOSNsPredicate = "label=='Resend code' and visible==1")
    public MobileElement resendCodeLink;

    @AndroidFindBy(id = "PENDING")
    @iOSXCUITFindBy(iOSNsPredicate = "label=='Please wait 30 seconds before trying again.' and visible==1")
    public MobileElement wait30Seconds;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label CONTAINS 'Terms of Use and Privacy Policy.'")
    //  @AndroidFindBy(id = "legal")
    @AndroidFindBy(xpath = "//android.widget.ScrollView[1]/android.view.ViewGroup[1]/android.widget.TextView[6]")
    public MobileElement otp_TOS;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]")
    public MobileElement otp_TOS_text;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Terms of Use and Privacy Policy.\"]")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Terms of Use and Privacy Policy.\")")
    public MobileElement otp_TOP;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    @AndroidFindBy(id = "uma_edit_text")
    public MobileElement mobileEntered;

    @iOSXCUITFindBy(xpath = "//*[@label=\"You have an existing account\" and @visible=\"true\"]")
    @AndroidFindBy(id = "text_you_have_an")
    public MobileElement SSO_Screen_Message;

    @iOSXCUITFindBy(xpath = "//*[@value=\"Continue\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Continue\"]")
    public MobileElement continueSSOButton;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"@.com\")]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"textEmail\")]")
    public MobileElement EmailMessage;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Create a new account\" and @visible=\"true\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"v_create_account\")]")
    public MobileElement CreateAccount;

    @AndroidFindBy(id = "btn_next")
    @iOSXCUITFindBy(accessibility = "whiteRightArrow")
    public MobileElement zipCodeRightArrow;

    @AndroidFindBy(id = "editTextPhone")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Phone Number' AND visible==1")
    public MobileElement phoneNumberFieldContainer;


    //OTPVerificationMessage
    @iOSXCUITFindBy(xpath = "//*[@label=\"Please wait 30 seconds before requesting another verification code.\"]")
    @AndroidFindBy(id = "textResendWaitTime")
    public MobileElement otpMessage;


    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Expired/timed out verification code\")")
    @iOSXCUITFindBy(iOSNsPredicate = "Expired/timed out verification code")
    public MobileElement expiredOtpLabel;

    @AndroidFindBy(id = "textStartOver")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Start over' AND type == 'XCUIElementTypeButton'")
    public MobileElement startOver;


    @AndroidFindBy(accessibility = "Try again button")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Try again' AND type == 'XCUIElementTypeButton'")
    public MobileElement tryAgainBtn;


    @iOSXCUITFindBy(xpath = "//*[@label=\"MEMBER\"]")
    @AndroidFindBy(xpath = "//*[@text=\"MEMBER\"]")
    public MobileElement membersIcon;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Account\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Account\"]")
    public MobileElement Account;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Your receipts & contactless pay')]")
    public MobileElement contectlessCarosol;

    @AndroidFindBy(xpath = "//*[@content-desc='Hamburger menu Image'] | //XCUIElementTypeTable/XCUIElementTypeButton[6]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"User profile\"]")
    public MobileElement hamburgerMenu;

    @AndroidFindBy(xpath = " //*[@text=\"Developer Settings\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Developer Settings\"]")
    public MobileElement developerSetting;

    @AndroidFindBy(xpath = "//*[@text=\"MY_ACCOUNT_FEATURE_ENABLED\"]//following::android.widget.Switch[1]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"isMyAccountFeatureEnabled\"]//following::XCUIElementTypeSwitch[1]")
    public MobileElement myAccountFeatureEnabledSwitch;

    @AndroidFindBy(xpath = "//*[@text='SAVE']")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Save\"]")
    public MobileElement savebttnonDevSettings;

    @AndroidFindBy(xpath = "//*[@text=\"Developer Settings\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Developer Settings\"]")
    public MobileElement DeveloperSettingstitle;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Account\"]")
    public MobileElement AccountInSettings;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Account\"]")
    public MobileElement Accountscreen;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Let’s get started\"]")
    @AndroidFindBy(xpath = "//*[@text='Let’s get started']")
    public MobileElement letsGetStartedLbl;

    @iOSXCUITFindBy(xpath = "//*[@name='OR']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"OR\"]")
    public MobileElement orLblGuestMode;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Continue as Guest\"]")
    @AndroidFindBy(xpath = "//*[@text='Continue as Guest']")
    public MobileElement continueAsGuestLink;


    @AndroidFindBy(xpath = "//*[contains(@resource-id,'textWelcomeBack') and (@text='Welcome back')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Welcome back'")
    public MobileElement welcomeBackScreen;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'textVerificationCode') and contains(@text,'****.com')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@label,'****.com')]")
    public MobileElement maskedEmailOnWelcomeScreen;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Send code via email']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Send code via email'")
    public MobileElement sendCodeViaEmailCTA;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'textLetsStarted') and (@text='Thanks for signing back in')]")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Thanks for signing back in'")
    public MobileElement thanksForSigningBackInScreen;

    @AndroidFindBy(xpath = "//*[@text='Try a different email address']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Try a different email address'")
    public MobileElement tryDiffEmailAddLink;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'textWeHave') and contains(@text,'****.com')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[contains(@label,'****.com')]")
    public MobileElement maskedEmailOnThanksSigningInPage;

    //Resend code Button
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Resend code\")]")
    @AndroidFindBy(id = "textResend")
    public MobileElement resendCodeCTA;


    @AndroidFindBy(id = "dialogTitle")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@label=\"Try email\"]/../..//XCUIElementTypeStaticText[1])[1]")
    public MobileElement sorryScreen;

    @AndroidFindBy(id = "dialogMessage")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Try email\"]/../..//XCUIElementTypeStaticText[2]")
    public MobileElement sorryScreenMsg;

    @AndroidFindBy(id = "primaryButton")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Try email'")
    public MobileElement tryEmailCTA;


}

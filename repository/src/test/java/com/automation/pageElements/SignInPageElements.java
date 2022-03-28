package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.CacheLookup;

public class SignInPageElements {
    //sign in Text   "Sign In"
    @iOSXCUITFindBy(accessibility = "Sign In")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Sign In\")")
    public MobileElement signInTitle;

    //edit email
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Email\"]")
    @AndroidFindBy(id = "editTextEmail")
    @CacheLookup
    public MobileElement emailEditText;

    //edit password
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"Password\"]")
    @AndroidFindBy(id = "editTextPassword")
    @CacheLookup
    public MobileElement passwordEditText;

    //forgot Password
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Forgot Password' AND visible == 1")
    @AndroidFindBy(id = "buttonForgotPassword")
    @CacheLookup
    public MobileElement forgotPasswordLink;

    //sign in button
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Sign In' AND visible == 1")
    @AndroidFindBy(id = "buttonLogin")
    @CacheLookup
    public MobileElement signInButton;

    //create account button
    @iOSXCUITFindBy(accessibility = "Create Account")
    @AndroidFindBy(id = "signup_button")
    @CacheLookup
    public MobileElement createAccountButton;

    //cancel button
    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Cancel' AND visible == 1")
    public MobileElement cancelButton;

    //user and password mismatch error message
    @iOSXCUITFindBy(accessibility = "The email and password you entered do not match our records. Please try again.")
    @AndroidFindBy(id = "textViewServerError")
    @CacheLookup
    public MobileElement invalidAccountErrorMessage;

    //no account record error
    @iOSXCUITFindBy(accessibility = "The email address you have entered does not match our records. Please try again.")
    @AndroidFindBy(id = "alertTitle")
    public MobileElement noAccountRecordError;

    //forgot password page next button
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'NEXT' AND visible == 1")
    @AndroidFindBy(id = "buttonNext")
    public MobileElement forgotPasswordNextButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sign in for full experience\"]")
    @AndroidFindBy(xpath = "//*[@text='Sign in for full experience']")
    public MobileElement signInforFullExperienceLbl;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sign In\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'signin_btn')]")
    public MobileElement signInBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"btnTopNavBarWithHintLeft\"]")
    @AndroidFindBy(xpath = "//*[@content-desc='back']")
    public MobileElement backBtnSignInScreen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Reserve a time\"]")
    @AndroidFindBy(xpath = "//*[@text='Reserve a time']")
    public MobileElement reserveaTimeBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"User profile\"]")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Hamburger menu Image\"]")
    public MobileElement hamburgerMenuBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sign In\"]")
    @AndroidFindBy(xpath = "//*[@text='Sign In']")
    public MobileElement signInHamburgerMenu;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]")
    @AndroidFindBy(xpath = "//*/androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout[1]/android.widget.Button[1]")
    public MobileElement clickproduct;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Add to cart\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"btnPlusView\")]")
    public MobileElement clickAddToCart;


}

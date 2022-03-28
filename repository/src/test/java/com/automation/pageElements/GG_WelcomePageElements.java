package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.CacheLookup;

import java.util.List;

public class GG_WelcomePageElements {


    @AndroidFindBy(id = "welcome_title")
    @iOSXCUITFindBy(accessibility = "lblWelcomeTitle")
    @CacheLookup
    public MobileElement welcomeTitle;

    @AndroidFindBy(id = "welcome_slogan")
    @iOSXCUITFindBy(accessibility = "lblWelcomeDescription")
    @CacheLookup
    public MobileElement welcomeText;

    @AndroidFindBy(id = "get_start_button")
    @iOSXCUITFindBy(accessibility = "btnWelcomeCreateYourDeals")
    @CacheLookup
    public MobileElement getStartedBtn;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Allow'")
    @AndroidFindBy(xpath = "//android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.Button[2]")
    public MobileElement allowNotificationButton;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Maybe Later'")
    public MobileElement maybeLaterButton;

    @iOSXCUITFindBy(accessibility = "imgvNotificationPermissionsIllustration")
    @CacheLookup
    public List<MobileElement> allowNotificationButtonVisiblity;

    @iOSXCUITFindBy(accessibility = "Allow")
    @AndroidFindBy(xpath = "//android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.Button[2]")
    @CacheLookup
    public MobileElement clickAllowInNotificationPopUp;

    @iOSXCUITFindBy(accessibility = "Continue")
    @AndroidFindBy(id = "selectbtn")
    public MobileElement continueButton;

    @AndroidFindBy(id = "et_login_email")
    public MobileElement usernameTextField;

    @AndroidFindBy(id = "et_login_password")
    public MobileElement passwordTextField;

    @AndroidFindBy(id = "button_login")
    @iOSXCUITFindBy(accessibility = "btnSignIn")
    public MobileElement signInButton;


    @AndroidFindBy(xpath = "//*[@content-desc=\"A little different. A lot easier. Now, you can shop, save and pay with one app\"]")
//	@AndroidFindBy(accessibility = "A little different.\u2028A lot easier. Now, you can shop, save and pay with one app")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"goldenGate/OnboardDeals1\"]")
    public MobileElement onBoardingImageOne;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Shop right from the app. Shop from your previous in-store or online purchases\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"goldenGate/OnboardDeals2\"]")
    public MobileElement onBoardingImageTwo;

    @AndroidFindBy(xpath = "//*[@content-desc=\"All your deals in one place, Use the app wallet to pay and apply saved coupons when you shop\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"goldenGate/OnboardDeals3\"]")
    public MobileElement onBoardingImageThree;

    @AndroidFindBy(xpath = "//*[@content-desc=\"What’s on sale? You'll find exclusive online savings and hundreds of digital coupons to clip\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"goldenGate/OnboardDeals4\"]")
    public MobileElement onBoardingImageFourth;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'button_positive')]")
    public MobileElement okButton;


    @AndroidFindBy(id = "get_start_button")
    @iOSXCUITFindBy(accessibility = "btnLetsGetStarted")
    public MobileElement letsGetStartedButton;


    @AndroidFindBy(id = "PENDING")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblOnboardingImageTitle'")
    public MobileElement littleDifferecneLotEasierTitle;

    @AndroidFindBy(accessibility = "close")
    @iOSXCUITFindBy(id = "PENDING")
    public MobileElement closeBtn;


    @AndroidFindBy(id = "textLetsStarted")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Let’s get started'")
    public MobileElement welcomePageMsg;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Allow\"]")
    public MobileElement allowpushNotification;


    @iOSXCUITFindBy(accessibility = "Not right now")
    public MobileElement notRightNowpushNotification;

    @iOSXCUITFindBy(accessibility = "Allow")
    public MobileElement allowNotificationPermissionPopup;


    @iOSXCUITFindBy(accessibility = "Don’t Allow")
    public MobileElement dontAllowNotificationPermissionPopup;

}

package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.helpers.ExecutionHelper;
import com.automation.pages.*;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class GG_MFALoginSteps {
    public AppiumDevice device = AppiumDeviceManager.getDevice();
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_OtpPasswordPage otpPasswordPage = new GG_OtpPasswordPage(driver);
    public BasePage basePage = new BasePage(driver);
    public GG_SignInPage signInPage = new GG_SignInPage(driver);
    public ZipCodePage zipCodePage = new ZipCodePage(driver);
    public GG_ShoppingModePage gg_shoppingModePage = new GG_ShoppingModePage(driver);
    private String UMA_User_Signup = "";
    private String UMA_User_SignIn = null;


    public String getCurrentBanner() {
        return driver.getCapabilities().getCapability("banner").toString();
    }

    public String getCurrentAppPackage() {
        return device.getPackageName().toString();
    }

    public String getBundleId() {
        return device.getBundleId().toString();
    }

    public String getCurrentEnv() {
        return driver.getCapabilities().getCapability("env").toString();
    }

    public String getCurrentPackage() {
        return driver.getCapabilities().getCapability("env").toString();
    }

    public String getMfaUser() {
        return device.getMfaUser();
    }

    public String getExistingUser() {
        return device.getExistingUser();
    }


//    @When("^click on existing user signin for OTP$")
//    public void clickOnEmailForOTP() {
//        try {
//            String otpCode = null;
//
//            UMA_User_SignIn = device.getMfaUser();
//
//            otpPasswordPage.switchToEmail();
//
//            otpCode = otpPasswordPage.getOTPFromEmail("MFA_USERNAME_EXISTING", "MFA_PASSWORD_EXISTING");
//
//            otpPasswordPage.EnterAndSubmitOtp(otpCode);
//        }
//        catch(Exception e){
//            Assert.assertTrue(false, "Failed to obtain OTP from email");
//        }
//        //  zipCodePage.waitForZipCodePageDisplayed();
//    }

    @When("^Launch the MFA app$")
    public void launch_the_MFA_app() {
        otpPasswordPage.navigateToWelcomePage();
//        throw new PendingException();
    }

    @When("^click on existing user signin for OTP$")
    public void clickOnEmailForOTP() {

        boolean sso = false;
        String[] mfaUser = null;
        UMA_User_SignIn = device.getMfaUser();
        otpPasswordPage.handleSSO(sso);
        otpPasswordPage.switchToEmail(UMA_User_SignIn);

//        otpPasswordPage.verifyInputEmail();
//
//        String mfexistinguser = getMfaUser();
//        otpPasswordPage.provideInputEmail(mfexistinguser);
//
//        otpPasswordPage.verifySubmitEnable();
//        otpPasswordPage.clickSubmitButton();
//        otpPasswordPage.verifyOtpInputBox();


        String otpCode = otpPasswordPage.getOTPFromEmail(UMA_User_SignIn);
        otpPasswordPage.EnterAndSubmitOtp(otpCode);

        //  zipCodePage.waitForZipCodePageDisplayed();
    }

    @When("^click on \"([^\"]*)\" user signin for OTP$")
    public void clickOnRequiredUserForOTP(String arg0) {

        boolean sso = false;
        String[] mfaUser = null;
        if (arg0.equalsIgnoreCase("prod"))
            UMA_User_SignIn = device.getProdUser();
        else
            UMA_User_SignIn = device.getMfaUser();
        otpPasswordPage.handleSSO(sso);
        otpPasswordPage.switchToEmail(UMA_User_SignIn);
        String otpCode = otpPasswordPage.getOTPFromEmail(UMA_User_SignIn);
        otpPasswordPage.EnterAndSubmitOtp(otpCode);
    }


    @When("^click on NewSignup for OTP$")
    public void Newusersignup() throws Exception {
        // otpPasswordPageElements.CreateNewAcc.click();
        String otpCode = null;
        String mfaUser = otpPasswordPage.userEnterTheEmailIdForOTPToSignUp();
        otpPasswordPage.handleSSO(false);
        otpPasswordPage.switchToEmail(mfaUser);
        //mfaUser = UMA_User_Signup.split("@");
        otpCode = otpPasswordPage.getOTPFromEmail(mfaUser);
        otpPasswordPage.EnterAndSubmitOtp(otpCode);
    }

    @When("^click on NewSignup Api for OTP$")
    public void NewusersignupApi() throws Exception {
        String mfaUser = otpPasswordPage.userEnterTheEmailIdForOTPToSignUp();
        otpPasswordPage.handleSSO(false);
        //   ExecutionHelper.clearEmailInbox(mfaUser);
        long currentEpochTime = Instant.now().toEpochMilli();
        otpPasswordPage.switchToEmail(mfaUser);
        //String otpCode = ExecutionHelper.getOtp(mfaUser, currentEpochTime);
        String otpCode = ExecutionHelper.getOtp(mfaUser, 0);
        otpPasswordPage.EnterAndSubmitOtp(otpCode);
    }


    @When("^user enters \"([^\"]*)\" in zipcode page of the application$")
    public void user_enters_something_in_zipcode_page_of_the_application(String strArg1) throws Throwable {
        signInPage.postSignInActionsforDeliveryOption();
    }

    @When("^click on NewSignup message Api for OTP$")
    public void NewusersignupmessageApi() throws Exception {
        String mfaUser = otpPasswordPage.userEnterTheMobileForOTPToSignUp();
        otpPasswordPage.handleSSO(false);
        ExecutionHelper.clearEmailInbox(mfaUser);
        //     otpPasswordPage.switchToMobile(mfaUser);
        // ExecutionHelper.clearEmailInbox(mfaUser);
        //   long currentEpochTime = Instant.now().toEpochMilli();
//        otpPasswordPage.switchToEmail(mfaUser);
        //String otpCode = ExecutionHelper.getOtp(mfaUser, currentEpochTime);
        //   String otpCode = ExecutionHelper.getMobileOtp(mfaUser);
        //  otpPasswordPage.EnterAndSubmitOtp(otpCode);
    }


    @When("^click on NewSignup$")
    public void Newusersignup_PrivacyPolicy() {
        // otpPasswordPageElements.CreateNewAcc.click();
        String otpCode = null;
        String mfaUser = otpPasswordPage.userEnterTheEmailIdForOTPToSignUp();
        otpPasswordPage.handleSSO(false);
        otpPasswordPage.switchToEmail(mfaUser);
        //mfaUser = UMA_User_Signup.split("@");
        //  otpCode = otpPasswordPage.getOTPFromEmail(mfaUser);
        //  otpPasswordPage.EnterAndSubmitOtp(otpCode);

    }

    @Then("verify let get started screen is displayed")
    public void verify_let_get_started_screen_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        otpPasswordPage.isLetsGetStartedPageDisplayed();
    }

    @And("^verify 'Hi friend' text is displayed$")
    public void verifyTextIsDisplayed() throws IOException, InterruptedException {
        //Assert.assertTrue(otpPasswordPage.isHiFriendTextDisplayed(), "Login failed!!!");
        otpPasswordPage.isHiFriendTextDisplayed();
    }

    @Then("^verify 'Privacy Policy' text is displayed$")
    public void verifyPrivacyPolicyTextIsDisplayed() throws IOException, InterruptedException {
        //Assert.assertTrue(otpPasswordPage.isHiFriendTextDisplayed(), "Login failed!!!");
        otpPasswordPage.isPrivacyPolicyTextDisplayed();
    }

    @And("^user clicks on 'Privacy Policy' link$")
    public void clickOnPrivacyPolicyLink() throws IOException, InterruptedException {
        // Assert.assertTrue(dealsPage.isForYouTabDisplayed(), "Login failed!!!");
        otpPasswordPage.clickonPrivacyPolicyLink();

    }

    @Then("^verify 'Privacy Policy' page is displayed$")
    public void verifyPrivacyPolicyPageIsDisplayed() throws IOException, InterruptedException {
        //Assert.assertTrue(otpPasswordPage.isHiFriendTextDisplayed(), "Login failed!!!");
        otpPasswordPage.isPrivacyPolicyPageDisplayed();
    }

    @And("^navigate back to Welcome Page$")
    public void navigateBackToWelcomePage() throws IOException, InterruptedException {
        // Assert.assertTrue(dealsPage.isForYouTabDisplayed(), "Login failed!!!");
        driver.navigate().back();

    }

    /*   @When("^click on NewSignup$")
       public void Newusersignup_PrivacyPolicy() {
           // otpPasswordPageElements.CreateNewAcc.click();
           String otpCode = null;
           String mfaUser = otpPasswordPage.userEnterTheEmailIdForOTPToSignUp();
           otpPasswordPage.handleSSO(false);
           otpPasswordPage.switchToEmail(mfaUser);
           //mfaUser = UMA_User_Signup.split("@");
           //  otpCode = otpPasswordPage.getOTPFromEmail(mfaUser);
           //  otpPasswordPage.EnterAndSubmitOtp(otpCode);

       }
   */
    @Then("^Verify Input Field For Email$")
    public void verifyInputFieldForEmail() {
        otpPasswordPage.verifyInputEmail();
    }

    @Then("^Verify Submit button is enabled$")
    public void verifySubmitButton() {
        otpPasswordPage.verifySubmitEnable();
    }

    @Then("^Verify Submit button is disabled$")
    public void verifySubmitButtonisDisabled() {
        otpPasswordPage.verifySubmitIsDisabled();
        //   Assert.assertTrue(otpPasswordPage.isZipCodeScreenDisplayed(), "Zip code page is not loaded");
    }

    @And("^user tap on done button$")
    public void userTapOnDoneButton() {
        otpPasswordPage.tapOnDoneButton();
    }

    @Then("^Verify Invalid Email Text is displayed$")
    public void verifyInvalidEmailTextIsDisplayed() throws IOException, InterruptedException {
        //Assert.assertTrue(otpPasswordPage.isHiFriendTextDisplayed(), "Login failed!!!");
        otpPasswordPage.isInvalidEmailTextIsDisplayed();
    }

    @And("^verify OTP Page is displayed$")
    public void verifyOTPScreenIsDisplayed() {
        otpPasswordPage.verifyOTPPage();
    }

    @Then("^Verify Terms of Use text is visible without Scrolling$")
    public void verifyTermsOfUseTextIsDisplayedOnLandingPage() {
        otpPasswordPage.verifyTermsOfUseText();
    }

    @Then("^Verify Privacy Policy text is visible without Scrolling$")
    public void verifyPrivacyPolicyTextIsDisplayedOnLandingPage() {
        otpPasswordPage.verifyPrivacyPolicyText();
    }

    @Then("^verify Email Text box is displayed without Scrolling$")
    public void verifyEmailInputisDisplayed() {
        boolean sso = false;
        String[] mfaUser = null;
        UMA_User_SignIn = device.getMfaUser();
        otpPasswordPage.handleSSO(sso);
        //  otpPasswordPage.switchToEmail(UMA_User_SignIn);
        otpPasswordPage.switchToEmailFlow();
        otpPasswordPage.verifyInputEmail();
    }

    @Then("^verify Mobile Text box is displayed without Scrolling$")
    public void verifyMobileInputisDisplayed() {
        //    otpPasswordPage.verifyInputEmail();
        otpPasswordPage.verifyInputMobile();

    }

    @When("^user enters valid Email in Input Field$")
    public void userEnterTheEmailId() {
        otpPasswordPage.verifyInputEmail();
        otpPasswordPage.provideInputEmail();
    }

    @When("^user enters invalid Email in Input Field$")
    public void userEnterInvalidEmailId() {
        otpPasswordPage.verifyInputEmail();
        otpPasswordPage.provideInputInvalidEmail();
    }

    @When("^User Enter the Email Id For OTP$")
    public void userEnterTheEmailIdForOTP() {
        otpPasswordPage.verifyInputEmail();
        otpPasswordPage.provideInputEmail();
        otpPasswordPage.clickSubmitButton();
    }

    @When("^User Enter the Existing Email Id For OTP$")
    public void userEnterTheExistingEmailIdForOTP() {
        UMA_User_SignIn = device.getExistingAccountUser();
        otpPasswordPage.handleSSO(false);
        otpPasswordPage.switchToEmail(UMA_User_SignIn);

    }

    @When("^user clicks on the existing user signin for OTP$")
    public void userEnterExistingEmailforOTP() {
        boolean sso = false;
        String[] mfaUser = null;
        //     UMA_User_SignIn = device.getMfaUser();
        UMA_User_SignIn = device.getExistingAccountUser();
        otpPasswordPage.handleSSO(sso);
        otpPasswordPage.switchToEmail(UMA_User_SignIn);

        String otpCode = otpPasswordPage.getOTPFromEmail(UMA_User_SignIn);
        otpPasswordPage.EnterAndSubmitOtp(otpCode);
    }

    @And("^user enters OTP on the OTP Screen$")
    public void userEnterOTP() {
        String otp = "526545";
        otpPasswordPage.EnterAndSubmitMultipleOtp(otp);
    }

    @And("^verify code description text is collapsed$")
    public void verifyCodeDescriptionIsCollapsed() {
        //     otpPasswordPage.verifyCodeDescriptionTextIsCollapsed();
        Assert.assertFalse(otpPasswordPage.verifyCodeDescriptionTextIsDisplayed());


    }

    @And("^verify code description text is displayed$")
    public void verifyCodeDescriptionIsDisplayed() {
        otpPasswordPage.verifyCodeDescriptionTextIsDisplayed();
    }

    @And("^verify resend code text is displayed$")
    public void verifyResendCodeTextIsDisplayed() {
        otpPasswordPage.verifyResendCodeTextIsDisplayed();
    }

    @And("^verify try different email text is displayed$")
    public void verifyDifferentEmailTextIsDisplayed() {
        otpPasswordPage.verifyTryDiffEmailLink();
    }

    @When("^user clicks on \"Didn't get a code\" in the OTP Screen$")
    public void userclicksonDintgetaCodeText() {
        otpPasswordPage.clickonDintgetCode();
    }

    @And("^verify \"Didn't get a code\" text is displayed$")
    public void verifyDintgetaCodeTextIsDisplayed() {
        otpPasswordPage.verifyDintgetCodeTextIsDisplayed();
    }

    @Then("^verify Image error icon at center of page$")
    public void verifyImageErrorIcon() {
        otpPasswordPage.verifyImageErrorIconIsDisplayed();
    }

    @Then("^verify \"We see you're already a customer\" text is displayed$")
    public void verifyLockedCustomerTextIsDisplayed() {
        otpPasswordPage.verifyLockedCustomerTextIsDisplayed();
    }

    @Then("^verify \"Please contact support\" text is displayed$")
    public void verifyLockedOutTextIsDisplayed() {
        otpPasswordPage.verifyLockedOutTextIsDisplayed();
    }

    @And("^verify Contact Support CTA is displayed$")
    public void verifyContactCTAIsDisplayed() {
        otpPasswordPage.verifyContactSupportCTAIsDisplayed();
    }

    @When("^user clicks on the Cancel link under CTA button$")
    public void clickCancelLink() throws Throwable {
        otpPasswordPage.clickCancelLink();
    }

    @Then("^user clicks on Contact Support CTA$")
    public void userClicksContactSupportCTA() {
        otpPasswordPage.clickContactSupportCTA();
    }

    @And("^allow to contiue using dialpad$")
    public void allowDialPadOnScreen() {
        otpPasswordPage.clickAllowDialPad();
    }

    @And("^verify DialPad is displayed on the screen$")
    public void verifyDialPadOnScreen() {
        otpPasswordPage.verifyDialPadisDisplayed();
    }

    @When("^user navigates back to the application$")
    public void userNavigatesBack() throws Throwable {
        otpPasswordPage.navigateBackToApp();

    }

    @Then("^Submit Button Become Enable$")
    public void submitButtonBecomeEnable() {
        otpPasswordPage.verifySubmitEnable();
    }

    @When("^Click on Submit Button$")
    public void clickOnSubmitButton() {

        otpPasswordPage.clickSubmitButton();
    }

    @Then("^User Should See Text Box for Adding OTP$")
    public void userShouldSeeTextBoxForAddingOTP() {
        otpPasswordPage.verifyOtpInputBox();
    }

    @When("^user copy otp from email$")
    public void userCopyOtpFromEmail() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String otpCode = null;
        String mfaUser[] = null;
        UMA_User_SignIn = device.getMfaUser();
        mfaUser = UMA_User_SignIn.split("@");
        otpCode = otpPasswordPage.getOTPFromEmail(mfaUser[0]);
        otpPasswordPage.EnterAndSubmitOtp(otpCode);

    }

    @Then("^verify MFA home screen is displayed$")
    public void verifyMFAHomeScreenIsDisplayed() {
        otpPasswordPage.verifyHomePage();
    }


    @When("^User Enter the Email Id For OTP to SignUp$")
    public void userEnterTheEmailIdForOTPToSignUp() {
        String uniqueString = "";
        uniqueString = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "@yopmail.com";
        UMA_User_Signup = "UMA_" + uniqueString;
        otpPasswordPage.provideInputEmail(UMA_User_Signup);

    }

    @When("^new user copy otp from email$")
    public void newUserCopyOtpFromEmail() {
        String otpCode = null;
        String mfaUser[] = null;
        mfaUser = UMA_User_Signup.split("@");
        otpCode = otpPasswordPage.getOTPFromEmail(mfaUser[0]);
        otpPasswordPage.EnterAndSubmitOtp(otpCode);
    }

    @Then("^verify MFA Zip code screen is displayed$")
    public void verifyMFAZipCodeScreenIsDisplayed() {

        Assert.assertTrue(otpPasswordPage.isZipCodeScreenDisplayed(), "Zip code page is not loaded");
    }


    @And("^user wait for \"([^\"]*)\" seconds to pass$")

    public void userWaitForSecondsToPass(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        otpPasswordPage.waitForThirtySeconds();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
    }

    @Then("^User Should See Resend code link in OTP and click on that$")
    public void userShouldSeeResendCodeLinkInOTPAndClickOnThat() {
        otpPasswordPage.clickResendCodeLink();
    }

    @Then("^User Should See Try different email link$")
    public void userShouldSeeTryDifferentEmailLink() {
        otpPasswordPage.verifyTryDiffEmailLink();
    }

    @When("^user click on try different email link$")
    public void userClickOnTryDifferentEmailLink() {
        otpPasswordPage.clickTryDiffEmailLink();
    }

    @Then("^user allow notification popup for iOS$")
    public void userAllowNotificationPopupForIOS() {
        otpPasswordPage.checkForAllowNotification();
    }

    @And("^User should click resend OTP$")
    public void userShouldClickResendOTP() {
        otpPasswordPage.clickResendOTP();
    }

    @When("^user click Pickup option$")
    public void userClickPickupOption() {
    }

    @And("user selects {string} shopping method")
    public void userSelectShoppingMethod(String shoppingMethod) throws InterruptedException {
        switch (shoppingMethod) {
            case "Delivery":
                gg_shoppingModePage.clickOnDeliveryShoppingMode();
                break;
            case "Pickup":
                gg_shoppingModePage.clickOnPickupShoppingMode();
                break;
            default:
                gg_shoppingModePage.clickOnInStoreShoppingMode();
                break;
        }
    }

    @And("^USer verify message for create Account Steps$")
    public void userVerifyMessageForCreateAccountSteps() {
        otpPasswordPage.verifyCreateAccoutMessage(UMA_User_Signup);
    }

    @When("^User click on Start over button$")
    public void userClickOnStartOverButton() {

        otpPasswordPage.clickStartOverButton();
    }

    @Then("^User Should See signin text message for signin user$")
    public void userShouldSeeSigninTextMessageForSigninUser() {
        otpPasswordPage.verifySignInMessage(getMfaUser());
    }

    @And("^Verify TOS in OTP Screen$")
    public void verifyTOSInOTPScreen() {
        otpPasswordPage.verifyTOSOTPScreen();
    }

    @When("^user clicks on TOS in OTP screen$")
    public void userClicksOnTOSInOTPScreen() {
        otpPasswordPage.clickTOSOTPScreen();

    }

    @And("^come back to app and verify OTP screen$")
    public void comeBackToAppAndVerifyOTPScreen() {
        otpPasswordPage.navigateToApp();
        otpPasswordPage.verifyOtpInputBox();
    }

    @When("^New User Enters number and navigated to OTP screen with Create acc message$")
    public void userEntersUnregisteredNumberAndNavigatedToOTPScreen() {

        Boolean sameNumberNewUser = true;
        otpPasswordPage.handleSSO(false);
        otpPasswordPage.switchToMobile();
        otpPasswordPage.enterNewMobileVerifyCreateAccMsg(sameNumberNewUser);

    }

    @Then("^verify 'Check your text message' text is displayed on the OTP screen$")
    public void verifyMsgonOTPScreen() {

        otpPasswordPage.verifyMsgonOtpScreen();

    }

    @Then("^Verify user can enter same number and navigate to Otp screen with Signin Message$")
    public void verifyUserCanEnterSameNumberAndNavigateToOtpScreen() {
        Boolean sameNumberNewUser = false;
        otpPasswordPage.handleSSO(false);
        otpPasswordPage.switchToMobile();
        otpPasswordPage.enterNewMobileVerifyCreateAccMsg(sameNumberNewUser);
    }


    @When("^user login to the app using resend option after \"([^\"]*)\" sec$")
    public void userLoginToTheAppUsingResendOptionAfterSec(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String otpCode = null;
        String[] mfaUser = null;
        UMA_User_SignIn = device.getMfaUser();
        otpPasswordPage.handleSSO(false);
        otpPasswordPage.switchToEmail(UMA_User_SignIn);
        otpPasswordPage.waitForThirtySeconds();
        otpPasswordPage.clickResendCodeLink();
        otpCode = otpPasswordPage.getOTPFromEmail(UMA_User_SignIn);
        otpPasswordPage.EnterAndSubmitOtp(otpCode);
    }

    @When("^User login with email using try diff email link$")
    public void userLoginWithEmailUsingTryDiffEmailLink() {

        String otpCode = null;
        String[] mfaUser = null;
        UMA_User_SignIn = device.getMfaUser();
        otpPasswordPage.handleSSO(false);
        otpPasswordPage.enterEmailNavigateToOTP();
        otpPasswordPage.clickTryDiffEmailLink();
        otpPasswordPage.switchToEmail(UMA_User_SignIn);
        otpCode = otpPasswordPage.getOTPFromEmail(UMA_User_SignIn);
        otpPasswordPage.EnterAndSubmitOtp(otpCode);
    }

    @When("^User Signup with try diff email link$")
    public void userSignupWithTryDiffEmailLink() {

        String otpCode = null;
        otpPasswordPage.handleSSO(false);
        otpPasswordPage.enterEmailNavigateToOTP();
        otpPasswordPage.clickTryDiffEmailLink();
        String mfaUser = otpPasswordPage.userEnterTheEmailIdForOTPToSignUp();
//        otpPasswordPage.switchToEmail(mfaUser);
//        //mfaUser = UMA_User_Signup.split("@");
//        otpCode = otpPasswordPage.getOTPFromEmail(mfaUser);
//        otpPasswordPage.EnterAndSubmitOtp(otpCode);

        ExecutionHelper.clearEmailInbox(mfaUser);
        long currentEpochTime = Instant.now().toEpochMilli();
        otpPasswordPage.switchToEmail(mfaUser);
        //String otpCode = ExecutionHelper.getOtp(mfaUser, currentEpochTime);
        otpCode = ExecutionHelper.getOtp(mfaUser, 0);
        otpPasswordPage.EnterAndSubmitOtp(otpCode);
    }


    @When("^new user signup using resend code after \"([^\"]*)\" sec$")
    public void newUserSignupUsingResendCodeAfterSec(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String otpCode = null;

        String mfaUser = otpPasswordPage.userEnterTheEmailIdForOTPToSignUp();
        otpPasswordPage.handleSSO(false);
        otpPasswordPage.switchToEmail(mfaUser);
        otpPasswordPage.waitForThirtySeconds();
        ExecutionHelper.clearEmailInbox(mfaUser);
        otpPasswordPage.clickResendCodeLink();
        //mfaUser = UMA_User_Signup.split("@");
//        otpCode = otpPasswordPage.getOTPFromEmail(mfaUser);
//        otpPasswordPage.EnterAndSubmitOtp(otpCode);

//        ExecutionHelper.clearEmailInbox(mfaUser);
//        long currentEpochTime = Instant.now().toEpochMilli();
//        otpPasswordPage.switchToEmail(mfaUser);
        //String otpCode = ExecutionHelper.getOtp(mfaUser, currentEpochTime);
        otpCode = ExecutionHelper.getOtp(mfaUser, 0);
        otpPasswordPage.EnterAndSubmitOtp(otpCode);
    }


    @When("^click on SSO user signin$")
    public void clickOnSSOUserSignin() {
        otpPasswordPage.handleSSO(true);
    }


    @And("^user verify SSO email in email section$")
    public void userVerifySSOEmailInEmailSection() {
        otpPasswordPage.verifySsoEmail();
    }

    @And("^user is logged in to the app for Existing user$")
    public void userLoggedInToApp() throws IOException, InterruptedException {
        otpPasswordPage.verifyUserLoggedInToApp();
    }


    //below 5 stepdefinition methods for Scenario: on the Check your email page a validation message should be displayed under disabled Resend code
    @When("signing in and landing on Check your email page")
    public void signing_in_and_landing_on_check_your_email_page() throws InterruptedException, IOException {
        String mfaUser = otpPasswordPage.userEnterTheEmailIdForOTPToSignUp();
        otpPasswordPage.handleSSO(false);
        ExecutionHelper.clearEmailInbox(mfaUser);
        otpPasswordPage.switchToEmail(mfaUser);

    }


    @Then("verify OTP message is displayed under Resend code button")
    public void verify_otp_message_is_displayed_under_the_resend_code_button() {

        org.junit.Assert.assertEquals(otpPasswordPage.isOTPMessageDisplayed(), true);
    }

    @And("verify if Resend code button is disabled grey")
    public void verifyIfResendCodeTheButtonIsDisabledGrey() {

        org.junit.Assert.assertEquals(otpPasswordPage.isResendCodeDisabled(), true);
    }

    @Then("after thirty seconds verify OTP message is not displayed anymore")
    public void afterSecondsVerifyTheOTPMessageIsNotDisplayedAnymore() {

        otpPasswordPage.waitForThirtySeconds();
        org.junit.Assert.assertEquals(otpPasswordPage.isOTPMessageDisplayed(), false);
    }

    @And("verify if resend code button is enabled and click on it and OTP message is displayed again")
    public void verifyIfResendCodeButtonIsEnabledAndclickOnIt() {
        org.junit.Assert.assertEquals(otpPasswordPage.isResendCodeEnabled(), true);
        otpPasswordPage.clickResendCode();
        org.junit.Assert.assertEquals(otpPasswordPage.isOTPMessageDisplayed(), true);
    }

    @Then("^verify MFA home page is displayed$")
    public void verifyMFAHomePageIsDisplayed() {
        otpPasswordPage.verifyHomePageScreen();
    }


    @When("^click on SNAP Signup Api for OTP$")
    public void SnapusersignupApi() throws Exception {
        //   String mfaUser = otpPasswordPage.userEnterTheEmailIdForOTPToSignUp();
        // String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_SNAP");
        //   String mfaUser = device.getSnapAccountUser();
        //  UMA_User_SignIn = device.getSnapAccountUser();
    }

    @When("click on NewSignup Api for OTP with rewards with user {string}")
    public void click_on_new_signup_api_for_otp_with_rewards_with_user(String userName) {
        String mfaUser = otpPasswordPage.userEnterTheRewardsEmailIdForOTPToSignUp(userName);
        otpPasswordPage.handleSSO(false);
        ExecutionHelper.clearEmailInbox(mfaUser);
        long currentEpochTime = Instant.now().toEpochMilli();
        otpPasswordPage.switchToEmail(mfaUser);
        //String otpCode = ExecutionHelper.getOtp(mfaUser, currentEpochTime);
        String otpCode = ExecutionHelper.getOtp(mfaUser, 0);
        otpPasswordPage.EnterAndSubmitOtp(otpCode);
    }

    @When("^click on SNAP2 Signup Api for OTP$")
    public void Snap2UserSignupApi() throws Exception {
        //   String mfaUser = otpPasswordPage.userEnterTheEmailIdForOTPToSignUp();
        // String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_SNAP");
        //    String mfaUser = device.getSnap2AccountUser();
        //  UMA_User_SignIn = device.getSnapAccountUser();
    }

    @When("^user enter mobile number \"([^\"]*)\" on Let's get started screen$")
    public void user_enter_mobile_number_on_lets_get_started_screen(String strArg1) {
        otpPasswordPage.handleSSO(false);
        otpPasswordPage.provideInputMobile(strArg1);
        otpPasswordPage.verifySubmitEnable();
        otpPasswordPage.clickSubmitButton();
    }

    @Then("^verify Welcome back screen is displayed$")
    public void verify_welcome_back_screen_is_displayed() {
        otpPasswordPage.verifyWelcomeBackScreen();
    }

    @And("^verify Welcome back page components$")
    public void verify_welcome_back_page() {
        otpPasswordPage.verifyWelcomeBackPage();
    }

    @When("^User click send code via Email CTA$")
    public void user_click_send_code_via_email_cta() {
        otpPasswordPage.clickSendCodeViaEmailCTA();
    }

    @Then("^verify thanks for signing back in screen is displayed$")
    public void verify_thanks_for_signing_back_in_screen_is_displayed() {
        otpPasswordPage.verifyThanksForSigningBackScreen();
    }

    @And("^verify \"([^\"]*)\" is toggled and enabled$")
    public void verify_something_is_toggled_and_enabled(String strArg1) {
        otpPasswordPage.verifyToggledOption(strArg1);
    }

    @And("^verify thanks for signing back in screen components$")
    public void verify_thanks_for_signing_back_in_screen_components() {
        otpPasswordPage.verifyThanksForSigningBackScreenComponents();
    }

    @When("^user click on try different email address link$")
    public void user_click_on_try_different_email_address_link() {
        otpPasswordPage.clickTryDiffEmailAddLink();
    }


    @Then("^verify Sorry, there's a problem screen displays$")
    public void verify_sorry_theres_a_problem_screen_displays() {
        otpPasswordPage.verifySorryScreenDisplayed();
    }

    @And("^verify sorry screen components \"([^\"]*)\"$")
    public void verify_sorry_screen_components_something(String strArg1) {
        otpPasswordPage.verifySorryScreenComponents(strArg1);
    }

    @When("^user clicks try email CTA$")
    public void user_clicks_try_email_cta() {
        otpPasswordPage.clickTryEmailCTA();
    }

}




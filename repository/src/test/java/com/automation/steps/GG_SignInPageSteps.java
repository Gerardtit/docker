package com.automation.steps;

import com.automation.helpers.DeviceHelper;
import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.helpers.ExecutionHelper;
import com.automation.pages.BasePage;
import com.automation.pages.GG_OtpPasswordPage;
import com.automation.pages.GG_SignInPage;
import com.automation.pages.MailinatorInboxPage;
import com.automation.rest.cache.CommonCache;
import com.automation.rest.signup.EmailOTP;
import com.automation.rest.signup.RegisterUser;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.io.IOException;

/**
 * This class contains steps to handle app sign in
 */
public class GG_SignInPageSteps {
    Logger logger = LogManager.getLogger(this.getClass());
    public AppiumDriver driver = AppiumDriverManager.getDriver();

    public GG_SignInPage signInPage = new GG_SignInPage(driver);
    public GG_OtpPasswordPage otpPasswordPage = new GG_OtpPasswordPage(driver);
    public BasePage basePage = new BasePage(driver);

    /**
     * Step for app sign in
     */

    @Then("^sign in to the application$")
    public void signInToTheApp() throws Exception {
        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();
    }

    @When("^sign in to the application to verify cart feature$")
    public void signInToTheAppCart() throws Exception {
        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_CART_API");
        String mfaPass = ThreadLocalHelper.testCaseData.get().get("PASSWORD_CART_API");
        String mfaUserID = ThreadLocalHelper.testCaseData.get().get("CUSTOMERID_CART_API");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        ThreadLocalHelper.testCaseData.get().put("SIGNUP_USERNAME", mfaUser);
        CommonCache.commonCache.put("USERNAME_CART_API", mfaUser);
        CommonCache.commonCache.put("PASSWORD_CART_API", mfaPass);
        CommonCache.commonCache.put("CUSTOMERID_CART_API", mfaUserID);
        signInPage.postSignInActions();
    }

    @When("^sign in to the application to verify substitutionv2$")
    public void signInToTheAppSubV2() throws Exception {
        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_CART_API");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();
    }

    @When("^sign in to the application for pickup orders$")
    public void signInPickUp() throws Exception {
        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_PICKUPSTATUS");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();
    }

    @When("^sign in to the application for delivery orders$")
    public void signInDelivery() throws Exception {
        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_DELIVERYSTATUS");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();
    }

    @When("^sign in to the application for COA and SnapEBT member$")
    public void signInAsCOASnapEBTMember() throws Exception {
        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_COAMEMBER");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();


    }


    @When("^sign in to the application for COA member$")
    public void signInAsCOAmember() throws Exception {
        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_COASNAPEBTMEMBER");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();

    }


    /**
     * Step for app sign in
     */
    @When("^sign in to the application using MFA$")
    public void signInToTheAppMFA() throws Exception {
        signInPage.signInApp("REGULAR");
    }

    /**
     * Step for app sign in using account with existing rewards
     */

    @Then("^sign in to the application using account with existing rewards$")
    public void signInToTheAppUsingAccountWithRewards() throws Exception {
        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_REWARDS");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();
    }

    /**
     * Step for app sign in using account with no rewards
     */
    @When("^sign in to the application using account with no rewards$")
    public void signInToTheApplicationUsingAccountWithNoRewards() throws Exception {
        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_NOREWARDS");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();
    }

    @When("^sign in to the application using prod credentials$")
    public void signInToTheAppUsingProdCredentials() throws IOException {
        signInPage.signInWithProdCredentials();
    }

    @When("^sign in to the application using account with existing credentials$")
    public void signInToTheAppUsingExistingCredentials() throws IOException {
        signInPage.signInWithExistingCredentials();
    }

    @When("^sign in to the application using coa account$")
    public void signInToTheAppUsingCOACredentials() throws IOException, InterruptedException {
        signInPage.signInWithCOACredentials();
        signInPage.postSignInActions();
    }

    @When("^sign in to the application using account with no purchase history$")
    public void signInToTheApplicationUsingAccountWithNoPurchaseHistory() throws Exception {
        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_NOPURCHASEHISTORY");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();
    }

    /**
     * Step for app sign in using account with Monopoly deal card
     */
    @When("^sign in to the application using account with Monopoly$")
    public void signInToTheApplicationUsingAccountWithMonopoly() throws Exception {
        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_MONOPOLY");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();
    }

    @When("^install the application$")
    public void installApp() {
        new DeviceHelper(driver).installApp();
    }

    @When("^install the application for iOS$")
    public void installiOSApp() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new DeviceHelper(driver).installApp();
        }
    }

    @When("^un-install the application$")
    public void unInstallApp() {
        new DeviceHelper(driver).unInstallApp();
    }

    @When("^launch the application$")
    public void launchApp() {
        driver.launchApp();
    }

    @When("^sign in to the application to verify tutorials$")
    public void signInToAppTutorials() throws Exception {
        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_TUTORIALS");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActionsWithoutTutorialHandling();
    }

    /**
     * Step for app sign in using account with pickup order status two
     */
    @When("^sign in to the application using account with pickup order status two$")
    public void signInToTheApplicationUsingAccountWithPickupOrderStatusTwo() throws Exception {
        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_PICKUPSTATUSTWO");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();
    }

    @When("^sign in to the application using account with pickup order status three$")
    public void signInToTheApplicationUsingAccountWithPickupOrderStatusThree() throws Exception {
        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_PICKUPSTATUSTHREE");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();
    }

    @When("^sign in to the application using account with pickup order status four$")
    public void signInToTheApplicationUsingAccountWithPickupOrderStatusFour() throws Exception {
        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_PICKUPSTATUSFOUR");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();
    }

    @When("^sign in to the application using account with items you buy$")
    public void signInToTheApplicationUsingAccountWitItemYouBuy() throws Exception {
        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_ITEM");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();
    }


    @When("Signin to the application with existing Order placed")
    public void siginwithorderplaced() throws Exception {

        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_ORDERPLACED");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();
    }


    @When("Signin to the application with existing annual FreshPass user")
    public void NewotpclickOnExistingUserSignin() throws Exception {

        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_ANNUAL");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();
    }

    @When("Signin to the application with suspended FreshPass user")
    public void NewotpclickOnSuspendeUserSignin() throws Exception {

        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_suspended");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();
    }
//    @When("Signin to the application with existing annual FP user")
//    public void clickOnExistingUserSignin() throws Exception {
//
//        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_ANNUAL");
//        enterUserEmailAndOtpWithRetry(mfaUser);
//        signInPage.postSignInActions();
//    }

    @When("^close app update pop up if present$")
    public void closeAppUpdatePopupIfPresent() {
        signInPage.closeAppUpdatePopUp();
    }

    @Then("^sign up to the application$")
    public void signUpToApp() throws InterruptedException {
        String mfaUser = basePage.generateMFAUserForMail7();
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        otpPasswordPage.waitForZipCodePage();
    }

    @Then("^sign up to the application with popup handling$")
    public void signUpToAppPop() throws InterruptedException, IOException {
        signUpUsingMailinator();
    }

    @Then("^sign in to the application to verify notifications$")
    public void signInToTheAppWithout() throws Exception {
        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
    }


    @When("sign in to the application using account with no items in the cart")
    public void signInWithNoItemsInCart() throws Exception {
        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_NOITEMSINCART");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();
    }

    @Then("sign in to the application using account with one item in my list")
    public void signInWithOneItemInMyListAccount() throws Exception {
        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_ONEITEM");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();
    }

    private void enterUserEmailAndSubmitOtpMail7GuerrillaMail(String mfaUser) throws InterruptedException {
        EmailOTP.GuerillaEmailService guerillaEmailService = new EmailOTP().new GuerillaEmailService(mfaUser);
        guerillaEmailService.setUser();
        String otpCode = null;
        String mfaUserWithoutDomain = mfaUser.contains("@") ? mfaUser.split("@")[0] : mfaUser;
        String latestEmailId = guerillaEmailService.getLatestEmailId();
        otpPasswordPage.handleSSO(false);
        otpPasswordPage.switchToEmail(mfaUser);
        otpCode = waitAndGetOtpGuerrillaMail(mfaUserWithoutDomain, latestEmailId);
        if (otpCode == null) logger.error("*******  OTP did not arrive  *******");
        otpPasswordPage.EnterAndSubmitOtp(otpCode);
        signInPage.waitForOtpPageToDisappear();
        if (otpPasswordPage.isExpiredOtpLabelDisplayed()) {
            // If otp is expired/invalid, then retry again
            otpPasswordPage.clickStartOver();
            latestEmailId = guerillaEmailService.getLatestEmailId();
            otpCode = waitAndGetOtpGuerrillaMail(mfaUserWithoutDomain, latestEmailId);
            otpPasswordPage.EnterAndSubmitOtp(otpCode);
            signInPage.waitForOtpPageToDisappear();
        }
    }

    @When("Signin to the application with existing Monthly FreshPass user")
    public void NewotpsigninToTheApplicationWithExistingMonthlyFPUser() throws Exception {
        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_MONTHLY");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();
    }
//    @When("Signin to the application with existing Monthly FP user")
//    public void signinToTheApplicationWithExistingMonthlyFPUser() throws Exception {
//        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_MONTHLY");
//        enterUserEmailAndOtpWithRetry(mfaUser);
//        signInPage.postSignInActions();
//    }

    private String clearInboxAndEnterGetOtp(String mfaUser) {
//        ExecutionHelper.clearEmailInbox(mfaUser);
        otpPasswordPage.switchToEmail(mfaUser);
        for (int i = 0; i < 5; i++) {
            if (otpPasswordPage.isTryAgainDisplayed(2)) {
                //       ExecutionHelper.clearEmailInbox(mfaUser);
                otpPasswordPage.clickTryAgain();
                break;
            } else if (otpPasswordPage.isOTPScreenDisplayed(2)) {
                break;
            }
        }
        return ExecutionHelper.getOtp(mfaUser, 0);
    }

    private String waitAndGetOtpGuerrillaMail(String mfaUser, String prevEmailId) throws InterruptedException {
        String otpCode = null;
        EmailOTP.GuerillaEmailService guerillaEmailService = new EmailOTP().new GuerillaEmailService(mfaUser);
        for (int i = 0; i < 120; i++) {
            if (null != prevEmailId && !guerillaEmailService.getLatestEmailId().contentEquals(prevEmailId)) {
                otpCode = guerillaEmailService.getTheOTP();
                if (otpCode != null) {
                    break;
                }
            }
            Thread.sleep(500);
        }
        return otpCode;
    }

    private void enterUserEmailAndSubmitOtpMail7(String mfaUser) throws InterruptedException {
        String otpCode = null;
        String mfaUserWithoutDomain = mfaUser.contains("@") ? mfaUser.split("@")[0] : mfaUser;
        EmailOTP.Mail7EmailService mail7EmailService = new EmailOTP().new Mail7EmailService(mfaUserWithoutDomain);
        mail7EmailService.clearInbox();
        otpPasswordPage.handleSSO(false);
        otpPasswordPage.switchToEmail(mfaUser);
        otpCode = waitAndGetOtpMail7(mail7EmailService);
        if (otpCode == null) logger.error("*******  OTP did not arrive  *******");
        otpPasswordPage.EnterAndSubmitOtp(otpCode);
        signInPage.waitForOtpPageToDisappear();
        if (otpPasswordPage.isExpiredOtpLabelDisplayed()) {
            // If otp is expired/invalid, then retry again
            otpPasswordPage.clickStartOver();
            mail7EmailService.clearInbox();
            otpCode = waitAndGetOtpMail7(mail7EmailService);
            otpPasswordPage.EnterAndSubmitOtp(otpCode);
            signInPage.waitForOtpPageToDisappear();
        }
    }

    private String waitAndGetOtpMail7(EmailOTP.Mail7EmailService mail7EmailService) throws InterruptedException {
        for (int i = 0; i < 120; i++) {
            logger.info("Waiting 0.5s for otp to arrive...");
            if (mail7EmailService.getInboxSize() > 0) {
                break;
            }
            Thread.sleep(500);
        }
        return mail7EmailService.getTheOTP();
    }


    @Then("^sign up to the application with popup handling and registering the user")
    public void signUpToAppPopWithRegisterFlow() throws InterruptedException, IOException {
        signUpUsingMailinator();
    }


    @When("sign in to the application using reenroll user")
    public void signInToTheApplicationUsingReenrollUser() throws Exception {

        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_REENROLL");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();
    }

    @When("Signin to the application with existing FP user in Pending Cancellation")
    public void signinToTheApplicationWithExistingFPUserInPendingCancellation() throws Exception {

        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_PENCANCELLATION");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();
    }


    private void enterUserName(String mfaUser) {
        otpPasswordPage.handleSSO(false);
        otpPasswordPage.switchToEmail(mfaUser);
    }


    @When("Signin to the application with existing FP user in suspended state")
    public void signinToTheApplicationWithExistingFPUserInSuspendedState() throws Exception {
        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_SUSPEND");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();


    }


    @When("sign in to the application using account with existing rewards expiring EOM")
    public void signInToTheApplicationUsingAccountWithExistingRewardsExpiringEOM() throws Exception {
        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_REWARDSEOM");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();

    }


    @When("sign in to the application using account with some rewards points")
    public void signInToTheApplicationUsingAccountWithSomeRewardsPoints() throws Exception {

        String mfaUser = ThreadLocalHelper.testCaseData.get().get("USERNAME_POINTS");
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();


    }
    
    private void signUpUsingMailinator() throws IOException, InterruptedException {
        String mfaUser = basePage.generateMFAUserForMailinator();
        String customerId = new RegisterUser(basePage.getCurrentBanner(), mfaUser).checkEmailID().registerUserWithRetryForDuplicatePhoneNo(ThreadLocalHelper.testCaseData.get().get("STOREID_CART_API"), ThreadLocalHelper.testCaseData.get().get("ZIPCODE_CART_API"));
        enterUserName(mfaUser);
        String otpCode = new MailinatorInboxPage(driver).getLatestOTPFromInbox(mfaUser.split("@mailinator.com")[0]);
        otpPasswordPage.EnterAndSubmitOtp(otpCode);
        signInPage.postSignInActions();
        ThreadLocalHelper.testCaseData.get().put("SIGNUP_USERNAME", mfaUser);
        CommonCache.commonCache.put("USERNAME_CART_API", mfaUser);
        CommonCache.commonCache.put("PASSWORD_CART_API", "test@1234");
        CommonCache.commonCache.put("CUSTOMERID_CART_API", customerId);
        logger.info("********** Signed up user: " + mfaUser + " ************");
        Assert.assertFalse(customerId.isEmpty(), "Customer ID is not available !!!");
    }

    private void signUpUsingMail7() throws IOException, InterruptedException {
        String mfaUser = basePage.generateMFAUserForMail7();
        String customerId = new RegisterUser(basePage.getCurrentBanner(), mfaUser).checkEmailID().registerUserWithRetryForDuplicatePhoneNo(ThreadLocalHelper.testCaseData.get().get("STOREID_CART_API"), ThreadLocalHelper.testCaseData.get().get("ZIPCODE_CART_API"));
        enterUserEmailAndSubmitOtpMail7(mfaUser);
        signInPage.postSignInActions();
        ThreadLocalHelper.testCaseData.get().put("SIGNUP_USERNAME", mfaUser);
        CommonCache.commonCache.put("USERNAME_CART_API", mfaUser);
        CommonCache.commonCache.put("PASSWORD_CART_API", "test@1234");
        CommonCache.commonCache.put("CUSTOMERID_CART_API", customerId);
        logger.info("********** Signed up user: " + mfaUser + " ************");
        Assert.assertFalse(customerId.isEmpty(), "Customer ID is not available !!!");
    }


}


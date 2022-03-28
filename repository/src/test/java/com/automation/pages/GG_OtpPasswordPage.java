package com.automation.pages;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.TapAction;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_AccountProfilePageElements;
import com.automation.pageElements.GG_OtpPasswordPageElements;
import com.automation.pageElements.PopUpHandleElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class GG_OtpPasswordPage extends BasePage {
    private GG_OtpPasswordPageElements otpPasswordPageElements = new GG_OtpPasswordPageElements();
    private AppiumDevice device = AppiumDeviceManager.getDevice();
    public static String unregisteredPhoneNumber = "";
    public static String sso_User = "";
    private GG_AccountProfilePageElements myAccountPageElementsPage = new GG_AccountProfilePageElements();
    private PopUpHandleElements popUpHandleElements = new PopUpHandleElements();
    public GG_DealsPage dealsPage = new GG_DealsPage(driver);
    public GG_DashboardPage dashboardPage = new GG_DashboardPage(driver);

    public GG_OtpPasswordPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), otpPasswordPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), myAccountPageElementsPage);
        PageFactory.initElements(new AppiumFieldDecorator(driver), popUpHandleElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dealsPage);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dashboardPage);
    }

    public String getMfaUser() {
        return device.getMfaUser();
    }

    public void navigateToWelcomePage() {
        //driver.launchApp();
       /* if(driver.getPlatformName().equalsIgnoreCase("android"))
         new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.continueButton);*/
        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.switchEmail));
    }

    public void switchToMobile() {

        new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.switchMobile);
        //  new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.switchMobile);

    }

    public void provideInputMobile(String strArg1) {

        enterKey(otpPasswordPageElements.mobileInput, "5546657876");

    }

    public void enterNewMobileVerifyCreateAccMsg(Boolean sameNumberNewUser) {

        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.mobileInput));
        String enteredMobile = "";
        if (sameNumberNewUser) {
            long number = (long) Math.floor(Math.random() * 900000000L) + 100000000L;
            unregisteredPhoneNumber = "4" + String.valueOf(number);
            //String firstThree= unregisteredPhoneNumber.substring(0,2);
            //String = "("+firstThree+")"+unregisteredPhoneNumber.substring(3,unregisteredPhoneNumber.length());
            enterValue(otpPasswordPageElements.mobileInput, unregisteredPhoneNumber);
            enteredMobile = otpPasswordPageElements.mobileEntered.getText();
            clickSubmitButton();
            verifyOtpInputBox();
            System.out.println("Screen message" + otpPasswordPageElements.otpMessageForNewUser.getText());
            Assert.assertTrue(otpPasswordPageElements.otpMessageForNewUser.getText().contains(enteredMobile), "Create Account not displayed with Mobile number");

        } else {
            enterValue(otpPasswordPageElements.mobileInput, unregisteredPhoneNumber);
            enteredMobile = otpPasswordPageElements.mobileEntered.getText();
            waitForThirtySeconds();
            clickSubmitButton();
            verifyOtpInputBox();
            System.out.println("Screen message" + otpPasswordPageElements.otpMessageForSignedUser.getText());
            Assert.assertTrue(otpPasswordPageElements.otpMessageForSignedUser.getText().contains(enteredMobile), "Create Account not displayed with Mobile number");

        }

    }

    public void enterNewMobile(Boolean sameNumberNewUser) {

        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.mobileInput));
        String enteredMobile = "";
        if (sameNumberNewUser) {
            long number = (long) Math.floor(Math.random() * 900000000L) + 100000000L;
            unregisteredPhoneNumber = "5" + String.valueOf(number);
            //String firstThree= unregisteredPhoneNumber.substring(0,2);
            //String = "("+firstThree+")"+unregisteredPhoneNumber.substring(3,unregisteredPhoneNumber.length());
            enterValue(otpPasswordPageElements.mobileInput, unregisteredPhoneNumber);
            enteredMobile = otpPasswordPageElements.mobileEntered.getText();
            clickSubmitButton();
            verifyOtpInputBox();
            System.out.println("Screen message" + otpPasswordPageElements.otpMessageForNewUser.getText());
            Assert.assertTrue(otpPasswordPageElements.otpMessageForNewUser.getText().contains(enteredMobile), "Create Account not displayed with Mobile number");

        } else {
            enterValue(otpPasswordPageElements.mobileInput, unregisteredPhoneNumber);
            enteredMobile = otpPasswordPageElements.mobileEntered.getText();
            waitForThirtySeconds();
            clickSubmitButton();
            verifyOtpInputBox();
            System.out.println("Screen message" + otpPasswordPageElements.otpMessageForSignedUser.getText());
            Assert.assertTrue(otpPasswordPageElements.otpMessageForSignedUser.getText().contains(enteredMobile), "Create Account not displayed with Mobile number");

        }

    }

    public void verifyInputMobile() {
        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.mobileInput));
    }

    public void verifySubmitIsDisabled() {
        if (!otpPasswordPageElements.nextButton.isEnabled())
            System.out.println("Submit button is disabled");
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void verifySubmitEnable() {
        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.nextButton));
    }

    public void tapOnDoneButton() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.DoneButton);
        } else {
            //  androidKeyboardClickDone();
            //   tapCoordinate(960,1930);
            otpPasswordPageElements.nextButton.click();

        }

        new WaitAction(driver).waitForLoadingComplete();
    }
  /*  public void clickOTPSubmitButton() {
        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.submitButton));
        otpPasswordPageElements.submitButton.click();

    }*/

    public void clickSubmitButton() {
        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.nextButton));
        otpPasswordPageElements.nextButton.click();

    }

    public void verifyMsgonOtpScreen() {
        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.msgOTPHeader));

    }

    public void verifyOtpInputBox() {
        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.otpInput));
//        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.startOverAgain));
//        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.resendCode));
    }

    public void clickStartOverButton() {
        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.startOverAgain));
        otpPasswordPageElements.startOverAgain.click();
    }

    public void fillAndSubmitOtp() {
        // new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.otpInput);
        //enterKey(otpPasswordPageElements.otpInput, "345678");
        enterKey(otpPasswordPageElements.otpInputkey1, "3");
        enterKey(otpPasswordPageElements.otpInputkey2, "4");
        enterKey(otpPasswordPageElements.otpInputkey3, "5");
        enterKey(otpPasswordPageElements.otpInputkey4, "6");
        enterKey(otpPasswordPageElements.otpInputkey5, "7");
        enterKey(otpPasswordPageElements.otpInputkey6, "8");
        otpPasswordPageElements.submitButton.click();
    }

    public void verifyMessageForRegisteredUser() {

        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.instructionForMobileNumber));
    }

    public void switchToEmailFlow() {
        // otpPasswordPageElements.CreateNewAcc.click();
        //    scrollDown();
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            if (otpPasswordPageElements.switchEmail.getText().equalsIgnoreCase("MOBILE")) {
                new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.switchEmail);
            }
        } else {
            otpPasswordPageElements.switchEmail.click();
        }
        new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.switchEmail);
    }

    public void switchToEmail(String mfaUser) {
        scrollDown();
        if (driver.getPlatformName().equalsIgnoreCase("android")) {

            if (otpPasswordPageElements.switchEmail.getText().equalsIgnoreCase("MOBILE")) {
                new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.switchEmail);

            }
        } else {
            otpPasswordPageElements.switchEmail.click();
        }

        new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.switchEmail);

        verifyInputEmail();
        provideInputEmail(mfaUser);
        verifySubmitEnable();
        clickSubmitButton();
        new WaitAction(driver).waitForDisplayed(otpPasswordPageElements.otpInput, 10);
    }

    public String userEnterTheEmailIdForOTPToSignUp() {
        String uniqueString = "";
        String uma_user_signup = " ";
        uniqueString = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "@mail7.io";
        uma_user_signup = "uma_" + uniqueString;
        return uma_user_signup;

    }

    public String userEnterTheEmailIdForOTPToSignUpMail() {
        String uniqueString = "";
        String uma_user_signup = " ";
        uniqueString = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "@mailinator.com";
        uma_user_signup = "UMA_" + uniqueString;
        return uma_user_signup;

    }

    public void clickonPrivacyPolicyLink() {
        //   waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.privacyPolicyText));

        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new TapAction(driver).tapCoordinate(909, 1021);
        } else {
            new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.privacyPolicyText);
        }

        new WaitAction(driver).waitForLoaderToDisappear();

    }


    public void isPrivacyPolicyPageDisplayed() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.privacyPolicyPage));
        }

    }

    public void isInvalidEmailTextIsDisplayed() {
        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.invalidEmailText));
    }

    public void isPrivacyPolicyTextDisplayed() {
        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.privacyPolicyText));
    }

    public void isLetsGetStartedPageDisplayed() {
        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.letsGetStartedText));
    }

    public void isHiFriendTextDisplayed() {
        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.hiFriendText));
    }

    public void verifyInputEmail() {
        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.emailInput));
    }
   /* public void provideInputOTP() {
        enterValue(otpPasswordPageElements.otpInput, "326445");

    }*/

    /*  public void provideInputExistingEmail() {
          enterValue(otpPasswordPageElements.emailInput, "sha6789@example.com");
      }*/
    public void provideInputEmail() {
        enterValue(otpPasswordPageElements.emailInput, "qauser@example.com");
    }

    public void provideInputInvalidEmail() {
        enterValue(otpPasswordPageElements.emailInput, "test123");
    }

    public void verifyMessageForNewUser() {
        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.userText));

    }

    public void provideInputEmail(String arg0) {
        waitVar.until(ExpectedConditions.visibilityOf(
                otpPasswordPageElements.emailInput));

        enterValue(otpPasswordPageElements.emailInput, arg0);


    }


    public void enterEmailNavigateToOTP() {
        // otpPasswordPageElements.CreateNewAcc.click();
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            if (otpPasswordPageElements.switchEmail.isDisplayed())
                otpPasswordPageElements.switchEmail.click();
        } else {
            otpPasswordPageElements.switchEmail.click();
        }

        new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.switchEmail);

        verifyInputEmail();
        provideInputEmail();
        verifySubmitEnable();
        clickSubmitButton();
        verifyOtpInputBox();
    }

    public void provideInputEmailAndSubmit(String arg0) {
        waitVar.until(ExpectedConditions.visibilityOf(
                otpPasswordPageElements.emailInput));
        enterTextNoPressEnter(otpPasswordPageElements.emailInput, arg0);

        new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.nextButtonInEmailTextField);
        new WaitAction(driver).waitForLoaderToDisappear();
    }

    /*public String getOTPFromEmail(String arg1, String arg2) throws Exception {
        String banner = getCurrentBanner();
        String env = getCurrentEnv();
        Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);
        String username = bannerProperty.get(arg1);
        String password = bannerProperty.get(arg2);
        String otp = "";
        try {
            EmailHelper emailHelper = new EmailHelper(username, password);
            int initialMailsCount = emailHelper.getMailsCount();
            //provideInputEmailAndSubmit(username);
            emailHelper.waitForNewMail(initialMailsCount);
            new WaitAction(driver).waitForDisplayed(otpPasswordPageElements.otpInputkey1);
            otp = emailHelper.getVerificationCode();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(false, "Exception occurred while fetching OTP for user:" + username + " Message: " + e.getMessage());

        }
        verifyInputEmail();
        provideInputEmail();
        verifySubmitEnable();
        clickSubmitButton();
        verifyOtpInputBox();
    }

    public void provideInputEmailAndSubmit(String arg0) {
        waitVar.until(ExpectedConditions.visibilityOf(
                otpPasswordPageElements.emailInput));
        enterTextNoPressEnter(otpPasswordPageElements.emailInput, arg0);

        new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.nextButtonInEmailTextField);
        new WaitAction(driver).waitForLoaderToDisappear();
    }


    /*public String getOTPFromEmail(String arg1, String arg2) throws Exception {
        String banner = getCurrentBanner();
        String env = getCurrentEnv();
        Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);
        String username = bannerProperty.get(arg1);
        String password = bannerProperty.get(arg2);
        String otp = "";
        try {
            EmailHelper emailHelper = new EmailHelper(username, password);
            int initialMailsCount = emailHelper.getMailsCount();
            //provideInputEmailAndSubmit(username);
            emailHelper.waitForNewMail(initialMailsCount);
            new WaitAction(driver).waitForDisplayed(otpPasswordPageElements.otpInputkey1);
            otp = emailHelper.getVerificationCode();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertTrue(false, "Exception occurred while fetching OTP for user:" + username + " Message: " + e.getMessage());

        }
        verifyInputEmail();
        provideInputEmail();
        verifySubmitEnable();
        clickSubmitButton();
        verifyOtpInputBox();


    }
*/
    public String getConfirmationEmail(String arg0) {

        String mfaUser[] = null;
        String recentMsg = null;
        String url = "https://www.mailinator.com/v4/public/inboxes.jsp?to=" + arg0;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            Map<String, Object> params = new HashMap<>();
            params.put("identifier", "com.android.chrome");
            driver.executeScript("mobile:application:open", params);
            Set<String> contextNames = driver.getContextHandles();
            for (String contextName : contextNames) {
                System.out.println("context " + contextName);
                if (contextName.equalsIgnoreCase("WEBVIEW_1")) {
                    driver.context(contextName);
                    break;
                }
            }

            // driver.manage().deleteAllCookies();

            driver.get("http://www.google.com");
            // driver.get("https://www.mailinator.com/v4/public/inboxes.jsp?to=swy10");
            driver.get(url);

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement inputEmail = driver.findElementByXPath("//*[@id=\"inbox_field\"]");
            inputEmail.click();
            inputEmail.clear();
            inputEmail.sendKeys(arg0);
            WebElement loginButton = driver.findElementByXPath("//*[@class=\"primary-btn\"]");
            loginButton.click();
            new WaitAction(driver).waitForLoadingComplete();
            refreshScreen();
            recentMsg = driver.findElementByXPath("//*[contains(text(), 'Thank you')]").getText();
            System.out.println("recent msg" + recentMsg);

            //Launch UMA app again
            params.put("identifier", device.getPackageName());
            driver.executeScript("mobile:application:open", params);
            driver.context("NATIVE_APP");

        } else {

            Map<String, Object> args = new HashMap<>();
            args.put("bundleId", "com.apple.mobilesafari");
            driver.executeScript("mobile: launchApp", args);
            Set<String> contextNames = driver.getContextHandles();
            for (String contextName : contextNames) {
                System.out.println("context " + contextName);
                if (contextName.equalsIgnoreCase("WEBVIEW_1")) {
                    driver.context(contextName);

                    break;

                }
            }

            // driver.get("https://www.mailinator.com/v4/public/inboxes.jsp?to=swy10");
            driver.get(url);
            //driver.context("NATIVE_APP");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            //Clear already entered email from text box and enter email then login
            WebElement inputEmail = driver.findElementByXPath("//*[@id=\"inbox_field\"]");
            inputEmail.click();
            inputEmail.clear();
            inputEmail.sendKeys(arg0);
            WebElement loginButton = driver.findElementByXPath("//*[@class=\"primary-btn\"]");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            loginButton.click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            new WaitAction(driver).waitForLoadingComplete();
            refreshScreen();
            recentMsg = driver.findElementByXPath("//*[contains(text(), 'Thank you')]").getText();
            System.out.println("recent msg" + recentMsg);
            //Launch UMA app again
            driver.context("NATIVE_APP");
            driver.activateApp(device.getBundleId());

        }

        System.out.println("recent msg" + recentMsg);
        return recentMsg;
    }

    public String getOTPFromEmail(String arg0) {

        String mfaUser[] = null;
        String recentCode = null;
        String url = "https://www.mailinator.com/v4/public/inboxes.jsp?to=" + arg0;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            Map<String, Object> params = new HashMap<>();
            params.put("identifier", "com.android.chrome");
            driver.executeScript("mobile:application:open", params);
            Set<String> contextNames = driver.getContextHandles();
            for (String contextName : contextNames) {
                System.out.println("context " + contextName);
                if (contextName.equalsIgnoreCase("WEBVIEW_1")) {
                    driver.context(contextName);
                    break;
                }
            }

            // driver.manage().deleteAllCookies();

            driver.get("http://www.google.com");
            // driver.get("https://www.mailinator.com/v4/public/inboxes.jsp?to=swy10");
            driver.get(url);

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement inputEmail = driver.findElementByXPath("//*[@id=\"inbox_field\"]");
            inputEmail.click();
            inputEmail.clear();
            inputEmail.sendKeys(arg0);
            WebElement loginButton = driver.findElementByXPath("//*[@class=\"primary-btn\"]");
            loginButton.click();

            //Click on recent email

//            driver.findElementByXPath("//*[text()=\"                         Here’s your one-time authentication code                     \"]").click();
            Dimension dimension = driver.manage().window().getSize();
            new TapAction(driver).tapCoordinate((int) ((dimension.getWidth()) * .50), (int) ((dimension.getHeight()) * .32));
            //get otp code from email
            driver.switchTo().frame("html_msg_body");
            recentCode = driver.findElementByXPath("//*[@id=\"verification-code\"]").getText();
            System.out.println("subject " + recentCode);
            driver.switchTo().defaultContent();

            //   deleteAllEmail();
            //Commented as there is delete limit
            // WebElement deleteEmail = driver.findElementByXPath("//*[@class=\"btn-delete d-flex align-items-center text-decoration-none\"]");
            //deleteEmail.click();

            //Launch UMA app again
            params.put("identifier", device.getPackageName());
            driver.executeScript("mobile:application:open", params);
            driver.context("NATIVE_APP");

        } else {

            Map<String, Object> args = new HashMap<>();
            args.put("bundleId", "com.apple.mobilesafari");
            driver.executeScript("mobile: launchApp", args);
            Set<String> contextNames = driver.getContextHandles();
            for (String contextName : contextNames) {
                System.out.println("context " + contextName);
                if (contextName.equalsIgnoreCase("WEBVIEW_1")) {
                    driver.context(contextName);

                    break;

                }
            }

            // driver.get("https://www.mailinator.com/v4/public/inboxes.jsp?to=swy10");
            driver.get(url);
            //driver.context("NATIVE_APP");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            //Clear already entered email from text box and enter email then login
            WebElement inputEmail = driver.findElementByXPath("//*[@id=\"inbox_field\"]");
            inputEmail.click();
            inputEmail.clear();
            inputEmail.sendKeys(arg0);
            WebElement loginButton = driver.findElementByXPath("//*[@class=\"primary-btn\"]");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            loginButton.click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

/*
         /*   Dimension dimension = driver.manage().window().getSize();
            try {
                otpPasswordPageElements.Email_RecentOtpEmail.click();
            } catch (Exception e) {
                e.printStackTrace();
                if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                    tapCoordinate(82, (int) ((dimension.getHeight()) * .32));
                } else {
                    tapCoordinate(150, (int) ((dimension.getHeight()) * .32));
                }
                otpPasswordPageElements.Email_RecentOtpEmail.click();
            }


            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            try {
                recentCode = otpPasswordPageElements.Email_OTPCode.getText();
            } catch (Exception e) {
                e.printStackTrace();
                if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                    tapCoordinate(82, (int) ((dimension.getHeight()) * .3));
                } else {
                    tapCoordinate(150, (int) ((dimension.getHeight()) * .3));
                }


                recentCode = otpPasswordPageElements.Email_OTPCode.getText();
            }
*/

            Dimension dimension = driver.manage().window().getSize();
            int x = (int) (dimension.getWidth() * .36);

            //tapCoordinate(296,890);
            try {
                int y = (int) (dimension.getHeight() * .37);
                new TapAction(driver).tapCoordinate(x, y);
                driver.switchTo().frame("html_msg_body");
                recentCode = driver.findElementByXPath("//*[@id=\"verification-code\"]").getText();
            } catch (Exception e) {
                int y = (int) (dimension.getHeight() * .32);
                driver.switchTo().defaultContent();
                new TapAction(driver).tapCoordinate(x, y);
                driver.switchTo().frame("html_msg_body");
                recentCode = driver.findElementByXPath("//*[@id=\"verification-code\"]").getText();

            }

            //get otp code from email
            System.out.println("subject " + recentCode);
            driver.switchTo().defaultContent();

            //   deleteAllEmail();
            //Commented as there is delete limit
            // WebElement deleteEmail = driver.findElementByXPath("//*[@class=\"btn-delete d-flex align-items-center text-decoration-none\"]");
            //deleteEmail.click();

            driver.context("NATIVE_APP");
            driver.activateApp(device.getBundleId());

        }

        System.out.println("recent code" + recentCode);
        return recentCode;
    }

    public void EnterAndSubmitMultipleOtp(String otpCode) {
        for (int i = 0; i < 10; i++) {
            String otp[] = otpCode.split("");
            if (driver.getPlatformName().equalsIgnoreCase("android")) {
                new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.otpInput);
            }
            enterValue(otpPasswordPageElements.otpInputkey1, otp[0]);
            enterValue(otpPasswordPageElements.otpInputkey2, otp[1]);
            enterValue(otpPasswordPageElements.otpInputkey3, otp[2]);
            enterValue(otpPasswordPageElements.otpInputkey4, otp[3]);
            enterValue(otpPasswordPageElements.otpInputkey5, otp[4]);
            enterValue(otpPasswordPageElements.otpInputkey6, otp[5]);

            waitVar.until(ExpectedConditions.visibilityOf(
                    otpPasswordPageElements.submitButton));
            otpPasswordPageElements.submitButton.click();
            if (driver.getPlatformName().equalsIgnoreCase("Android")) {
                try {
                    new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.nextButtonInEmailTextField);
                } catch (Exception e) {

                }
            }
            new WaitAction(driver).waitForLoaderToDisappear();
        }
    }

    public void EnterAndSubmitOtp(String otpCode) {

        String otp[] = otpCode.split("");
        if (driver.getPlatformName().equalsIgnoreCase("android"))
            new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.otpInput);

        enterValue(otpPasswordPageElements.otpInputkey1, otp[0]);
        enterValue(otpPasswordPageElements.otpInputkey2, otp[1]);
        enterValue(otpPasswordPageElements.otpInputkey3, otp[2]);
        enterValue(otpPasswordPageElements.otpInputkey4, otp[3]);
        enterValue(otpPasswordPageElements.otpInputkey5, otp[4]);
        enterValue(otpPasswordPageElements.otpInputkey6, otp[5]);

        waitVar.until(ExpectedConditions.visibilityOf(
                otpPasswordPageElements.submitButton));
        otpPasswordPageElements.submitButton.click();
        if (driver.getPlatformName().equalsIgnoreCase("Android")) {
            try {
                new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.nextButtonInEmailTextField);
            } catch (Exception e) {

            }
        }
        new WaitAction(driver).waitForLoaderToDisappear();
    }

    public void clickCancelLink() {
        new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.cancelLink);
        new WaitAction(driver).waitForLoaderToDisappear();
    }

    public void clickContactSupportCTA() {
        new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.contactSupportCTA);
        new WaitAction(driver).waitForLoaderToDisappear();
    }

    public void clickAllowDialPad() {
        new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.allowDialPad);
        // new WaitAction(driver).waitForLoaderToDisappear();
    }

    public boolean verifyContactSupportCTAIsDisplayed() {

        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.contactSupportCTA));
        return isElementDisplayed(otpPasswordPageElements.contactSupportCTA, 10);
    }

    public boolean verifyDialPadisDisplayed() {

        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.dialPadScreen));
        return isElementDisplayed(otpPasswordPageElements.dialPadScreen, 10);
    }

    public void navigateBackToApp() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            driver.navigate().back();
            driver.navigate().back();
        } else {
            new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.navigateBack);
        }
    }

    public boolean verifyImageErrorIconIsDisplayed() {
        if (driver.getPlatformName().equalsIgnoreCase("Android")) {
            waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.imageErrorIcon));
        } else {
            new WaitAction(driver).waitForLoadingComplete();
        }
        return isElementDisplayed(otpPasswordPageElements.imageErrorIcon, 10);
    }

    public void clickonDintgetCode() {
        new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.dintGetCodeText);
    }

    public boolean verifyCodeDescriptionTextIsDisplayed() {
        return isElementDisplayed(otpPasswordPageElements.codeDescriptionText, 10);
    }

    public boolean verifyResendCodeTextIsDisplayed() {

        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.resendCodeText));
        return isElementDisplayed(otpPasswordPageElements.resendCodeText, 10);
    }

    public boolean verifyDintgetCodeTextIsDisplayed() {

        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.dintGetCodeText));
        return isElementDisplayed(otpPasswordPageElements.dintGetCodeText, 10);
    }

    public boolean verifyLockedCustomerTextIsDisplayed() {

        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.lockedCustomerMsg));
        return isElementDisplayed(otpPasswordPageElements.lockedCustomerMsg, 10);
    }

    public boolean verifyLockedOutTextIsDisplayed() {

        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.lockedoutMsg));
        return isElementDisplayed(otpPasswordPageElements.lockedoutMsg, 10);
    }

    public boolean isOTPScreenDisplayed(int waitTime) {
        return isElementDisplayed(otpPasswordPageElements.otpInputkey1, waitTime);
    }

    public boolean isHomeScreenDisplayed() {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (isElementDisplayed(otpPasswordPageElements.Allow, 2))
                new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.Allow);
        }

//    if (driver.getPlatformName().equalsIgnoreCase("android")) {
//        try {
//            if (popUpHandleElements.Continue.isDisplayed()) {
//                popUpHandleElements.Continue.click();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

     /*   if (driver.getPlatformName().equalsIgnoreCase("android")) {
            try {
                if (popUpHandleElements.Continue.isDisplayed()) {
                    popUpHandleElements.Continue.click();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/

        for (int i = 0; i < 3; i++) {
            if (isElementDisplayed(otpPasswordPageElements.Delivery_Next, 10))
                new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.Delivery_Next);
            else {
                break;
            }
        }


        try {
            if (popUpHandleElements.Continue.isDisplayed()) {
                popUpHandleElements.Continue.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        waitVar.until(ExpectedConditions.visibilityOf(
                otpPasswordPageElements.UMA_Home));
        return isElementDisplayed(otpPasswordPageElements.UMA_Home, 1);
    }

    public boolean isZipCodeScreenDisplayed() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (isElementDisplayed(otpPasswordPageElements.Allow, 50))
                new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.Allow);
        }

      /*  for(int i=0;i<3;i++) {
            if(otpPasswordPageElements.Delivery_Next.isDisplayed())
                new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.Delivery_Next);
        }*/
        waitVar.until(ExpectedConditions.visibilityOf(
                otpPasswordPageElements.UMA_Home));
        return isElementDisplayed(otpPasswordPageElements.UMA_Home, 50);
    }


    public void checkForAllowNotification() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (otpPasswordPageElements.Allow.isDisplayed())
                new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.Allow);
        }

    }

    public void clickResendOTP() {
        new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.resendCode);

    }

    public void verifyCreateAccoutMessage(String email) {
        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.otpInput));
        System.out.println("Screen message" + otpPasswordPageElements.otpMessageForNewUser.getText());
        Assert.assertTrue(otpPasswordPageElements.otpMessageForNewUser.getText().contains(email), "Create Account not dispayed with email id");

    }

    public void verifyTOSOTPScreen() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.otp_TOS));
            System.out.println("Screen message" + otpPasswordPageElements.otp_TOS.getText());

            Assert.assertTrue(otpPasswordPageElements.otp_TOS_text.getText().contains("From time to time we may contact you by email with details of offers and special promotions. You can opt out of receiving promotional emails by clicking"), "TOS text is not displayed");
            Assert.assertTrue(otpPasswordPageElements.otp_TOS.getText().contains("Terms of Use and Privacy Policy."), "TOS text is not displayed");
        } else {

            waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.otp_TOS));
            System.out.println("Screen message" + otpPasswordPageElements.otp_TOS.getText());

            Assert.assertTrue(otpPasswordPageElements.otp_TOS.getText().contains("From time to time we may contact you by email with details of offers and special promotions. You can opt out of receiving promotional emails by clicking"), "TOS text is not displayed");
            Assert.assertTrue(otpPasswordPageElements.otp_TOS.getText().contains("Terms of Use and Privacy Policy."), "TOS text is not displayed");

        }
    }

    public void clickTOSOTPScreen() {
        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.otp_TOS));

        new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.otp_TOS);
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }

    }

    public void deleteAllEmail() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            driver.navigate().back();
            driver.navigate().refresh();
            driver.switchTo().frame(2);
            driver.findElementByXPath("//*[@id=\"e0\"]").click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.switchTo().defaultContent();
            driver.findElementByXPath("(//*[@class='nw bara_m'])[3]").click();
        } else {
            driver.context("WEBVIEW_1");
            driver.navigate().refresh();
            //driver.navigate().back();
            driver.findElementByXPath("(//a[@id=\"rethome\"])[1]").click();
            driver.context("NATIVE_APP");
            otpPasswordPageElements.selectAllEmail.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            otpPasswordPageElements.deleteAllEmail.click();
        }
    }

    public void clickResendCodeLink() {
        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.resendCode));
        otpPasswordPageElements.resendCode.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void clickTryDiffEmailLink() {
        // waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.tryDiffEmailLink));
        otpPasswordPageElements.tryDiffEmailLink.click();
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;

    }

    public void verifyTryDiffEmailLink() {
        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.tryDiffEmailLink));
        Assert.assertTrue(otpPasswordPageElements.tryDiffEmailLink.isDisplayed(), "try diff link is not displayed");


    }

    public void verifySignInMessage(String email) {
        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.otpInput));
        System.out.println("Screen message" + otpPasswordPageElements.otpMessageForSignedUser.getText());
        Assert.assertTrue(otpPasswordPageElements.otpMessageForSignedUser.getText().contains(email), " signedin user message not dispayed with email id");

    }

    public void navigateToApp() {
        //letGetStratedPageElements.TOS.click();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            driver.activateApp(device.getBundleId());
        } else {

            Map<String, Object> params = new HashMap<>();
            params.put("identifier", device.getPackageName());
            driver.executeScript("mobile:application:open", params);
        }
    }

    public void waitForThirtySeconds() {
        try {
            Thread.sleep(30000);
        } catch (Exception e) {

        }
    }

    public void handleSSO(boolean sso) {
        int waitTimeForSSO = driver.getPlatformName().equalsIgnoreCase("IOS") ? 10 : 30;
        if (isElementDisplayed(otpPasswordPageElements.SSO_Screen_Message, waitTimeForSSO)) {
            //Assert.assertTrue(isElementDisplayed(otpPasswordPageElements.EmailMessage), "SSO Email not displayed");
            if (sso) {
                sso_User = otpPasswordPageElements.EmailMessage.getText();
                otpPasswordPageElements.continueSSOButton.click();
            } else
                otpPasswordPageElements.CreateAccount.click();
        }
    }

    public void verifySsoEmail() {

        waitVar.until(ExpectedConditions.visibilityOf(myAccountPageElementsPage.emailValue));

        Assert.assertTrue(myAccountPageElementsPage.emailValue.getText().equalsIgnoreCase(sso_User), " SSO Email Id not present in My Account");

    }

    public void verifyTermsOfUseText() {
        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.otp_TOP));
    }

    public void verifyPrivacyPolicyText() {
        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.otp_TOP));
    }

    public void verifyOTPPage() {
        waitVar.until(ExpectedConditions.visibilityOf(otpPasswordPageElements.startOverAgain));
    }

    /* public void verifyOTPPage() {
         Assert.assertTrue(isOTPScreenDisplayed(), "OTP page not loaded");
 //        if (driver.getPlatformName().equalsIgnoreCase("android")) {
 //            scrollDown();
 //        }
        // otpPasswordPage.isHiFriendTextDisplayed();
     }*/
    public void verifyHomePage() {
        Assert.assertTrue(isHomeScreenDisplayed(), "Home page not loaded");
//        if (driver.getPlatformName().equalsIgnoreCase("android")) {
//            scrollDown();
//        }

    }


    public void verifyUserLoggedInToApp() throws IOException, InterruptedException {
        if (dealsPage.isForYouTabDisplayed()) {
            dashboardPage.clickHomeTab();
            dashboardPage.handlePopUpsAndTutorialOnDashboard();
        }


    }

    public void waitForZipCodePage() {
        new WaitAction(driver).waitForDisplayed(otpPasswordPageElements.zipCodeRightArrow, 20);
    }


    public void verifyOTPMessage() {
        String message = otpPasswordPageElements.otpMessage.getText();
        org.junit.Assert.assertEquals(message, true, "a");
    }


    public boolean isResendCodeDisabled() {
        if (driver.getPlatformName().equalsIgnoreCase("Android")) {
            boolean b = otpPasswordPageElements.resendCode.isEnabled();
            return !b;
        } else {
            waitForElementToBeClickable(otpPasswordPageElements.resendCode, 2);
            return true;
        }

    }

    public boolean isResendCodeEnabled() {
        boolean b = otpPasswordPageElements.resendCode.isEnabled();
        return b;
    }


    public void clickResendCode() {
        otpPasswordPageElements.resendCode.click();
    }


    public boolean isExpiredOtpLabelDisplayed() {
        return isElementDisplayed(otpPasswordPageElements.expiredOtpLabel, 2);
    }

    public void clickStartOver() {
        new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.startOver);
    }

    public boolean isTryAgainDisplayed(int waitTime) {
        return isElementDisplayed(otpPasswordPageElements.tryAgainBtn, waitTime);
    }

    public void clickTryAgain() {
        new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.tryAgainBtn);
    }


    public void tapOnEmail() {
        new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.switchEmail);
    }

    public void validateOnboardingScreen() {
        waitForElementToAppear(otpPasswordPageElements.letsGetStartedLbl, 5);
        Assert.assertTrue(otpPasswordPageElements.letsGetStartedLbl.isDisplayed());
    }

    public void validatesGuestModeCTA() {
        Assert.assertTrue(otpPasswordPageElements.orLblGuestMode.isDisplayed());
        Assert.assertTrue(otpPasswordPageElements.continueAsGuestLink.isDisplayed());
    }

    public void clickOnContinueAsGuest() {
        new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.continueAsGuestLink);
    }

    public void reLaunchApp() {
        driver.closeApp();
        driver.launchApp();
    }


    public void verifyWelcomeBackScreen() {
        Assert.assertTrue(isElementDisplayed(otpPasswordPageElements.welcomeBackScreen, 10), "Welcome back screen is not displayed");
    }

    public void verifyWelcomeBackPage() {
        Assert.assertTrue(isElementDisplayed(otpPasswordPageElements.welcomeBackScreen, 10), "Welcome back screen is not displayed");
        Assert.assertTrue(isElementDisplayed(otpPasswordPageElements.startOver, 2), "Start Over CTA is not displayed");
        Assert.assertTrue(isElementDisplayed(otpPasswordPageElements.maskedEmailOnWelcomeScreen, 2), "Masked Email is not displayed in the text");
        Assert.assertTrue(isElementDisplayed(otpPasswordPageElements.sendCodeViaEmailCTA, 2), "Send Code via Email CTA is not displayed");
        Assert.assertTrue(isElementDisplayed(otpPasswordPageElements.tryDiffEmailLink, 2), "Try different email CTA is not displayed");

    }

    public void clickSendCodeViaEmailCTA() {
        new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.sendCodeViaEmailCTA);
    }

    public void verifyThanksForSigningBackScreen() {
        Assert.assertTrue(isElementDisplayed(otpPasswordPageElements.thanksForSigningBackInScreen, 10), "Welcome back screen is not displayed");
    }

    public void verifyToggledOption(String param) {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            Assert.assertTrue(driver.findElement(By.xpath(String.format("//android.widget.Switch[@text='%s' and @content-desc='selected']", param))).isDisplayed(), "feature : " + param + " is not enabled");
        } else {
            Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@label,'selected. " + param + "')]")).isDisplayed(), "feature : " + param + " is not enabled");
        }
    }

    public void verifyThanksForSigningBackScreenComponents() {
        Assert.assertTrue(isElementDisplayed(otpPasswordPageElements.thanksForSigningBackInScreen, 10), "Welcome back screen is not displayed");
        Assert.assertTrue(isElementDisplayed(otpPasswordPageElements.startOver, 2), "Start Over CTA is not displayed");
        Assert.assertTrue(isElementDisplayed(otpPasswordPageElements.tryDiffEmailAddLink, 2), "Try a diff email address CTA is not displayed");
        Assert.assertTrue(isElementDisplayed(otpPasswordPageElements.maskedEmailOnThanksSigningInPage, 2), "Masked Email is not displayed in the text");
        Assert.assertTrue(isElementDisplayed(otpPasswordPageElements.otpInput, 2), "Otp input box is not displayed");
        Assert.assertTrue(isElementDisplayed(otpPasswordPageElements.resendCodeCTA, 2), "Resend code CTA is not displayed");
    }

    public void clickTryDiffEmailAddLink() {
        new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.tryDiffEmailAddLink);
    }


    public boolean isOTPMessageDisplayed() {
        return isElementDisplayed(otpPasswordPageElements.otpMessage);
    }


    public void verifyHomePageScreen() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Assert.assertTrue(isElementDisplayed(otpPasswordPageElements.UMA_Home, 10000), "Home page not loaded");
        }
//        if (driver.getPlatformName().equalsIgnoreCase("android")) {
//            scrollDown();
//        }

    }

    //This is for rewards user account
    public String userEnterTheRewardsEmailIdForOTPToSignUp(String userName) {
        String uniqueString = userName + "@hostux.ninja";
        return uniqueString;
    }

    public String userEnterEmailIdForOTPToSignUp(String userName) {
        String uniqueString = userName + "@hostux.ninja";
        return uniqueString;
    }


    public String userEnterTheMobileForOTPToSignUp() {
        String uniqueString = "9105863302";
        return uniqueString;
    }

    public void clickTryEmailCTA() {
        new CommonActions(driver).new ClickAction().clickElement(otpPasswordPageElements.tryEmailCTA);
    }

    public void verifySorryScreenDisplayed() {
        Assert.assertTrue(getText(otpPasswordPageElements.sorryScreen).equals("Sorry, there’s a problem"), "Sorry there's a problem is not displayed");
    }

    public void verifySorryScreenComponents(String mobileNo) {
        mobileNo = mobileNo.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
        if (driver.getPlatformName().equalsIgnoreCase("Android")) {
            Assert.assertTrue(getText(otpPasswordPageElements.sorryScreenMsg).equals(mobileNo + " is linked to more than one account.\n" +
                    "\n" +
                    "Please sign in with the email associated with this number."), "Dialog message for sorry screen is not displayed correctly");
        } else {
            Assert.assertTrue(getText(otpPasswordPageElements.sorryScreenMsg).equals(mobileNo + " is linked to more  than one account.\n" +
                    "\n" +
                    "Please sign in with the email  associated with this number."), "Dialog message for sorry screen is not displayed correctly");
        }
        Assert.assertTrue(isElementDisplayed(otpPasswordPageElements.tryEmailCTA, 5), "Try Email button is not displayed");
    }


}

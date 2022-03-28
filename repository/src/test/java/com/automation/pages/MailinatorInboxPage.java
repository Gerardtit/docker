package com.automation.pages;

import com.automation.helpers.AppActions;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MailinatorInboxPage extends BasePage {
    public static final String VERIFICATION_CODE_SUBJECT_XPATH_ANDROID = "//*[@text='Verification code']";
    public static final String VERIFICATION_CODE_SUBJECT_XPATH_IOS = "//*[@label='Verification code']";
    public static final String VERIFICATION_CODE_BODY_XPATH_ANDROID = "//pre[contains(text(),'verification code:')]";
    public static final String VERIFICATION_CODE_BODY_XPATH_IOS = "//*[contains(@label,'To access your account')]/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther//XCUIElementTypeStaticText";

    public MailinatorInboxPage(AppiumDriver driver) {
        super(driver);
    }

    public String getLatestOTPFromInbox(String arg0) throws IOException {
        String otp = null;
        MobileElement subjectElement = null;
        String url = "https://www.mailinator.com/v4/public/inboxes.jsp?to=" + arg0;
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                driver.activateApp("com.android.chrome");
                WaitAction.sleep("BOTH", 2000);
                Set<String> contextNames = driver.getContextHandles();
                String webview = "";
                // Switch to web view to open URL
                for (String contextName : contextNames) {
                    if (contextName.contains("WEBVIEW")) {
                        webview = contextName;
                        driver.context(webview);
                        break;
                    }
                }
                WaitAction.sleep("BOTH", 1000);
                driver.get(url);
                driver.get(url);

                // Switch to native app to open mail
                driver.context("NATIVE_APP");
                subjectElement = new WaitAction(driver).waitForElement(By.xpath(VERIFICATION_CODE_SUBJECT_XPATH_ANDROID), 50);
                subjectElement.click();

                // Switch to web view to retrieve OTP
                driver.context(webview);
                MobileElement msgBodyElement = new WaitAction(driver).waitForElement(By.xpath(VERIFICATION_CODE_BODY_XPATH_ANDROID), 10);
                String msgBody = driver.executeScript("return arguments[0].innerText;", msgBodyElement).toString();
                otp = msgBody.split("verification code:")[1].split("For your privacy")[0].replaceAll("[^0-9]", "");

                // Switch back to native app
                driver.context("NATIVE_APP");
                break;
            case "IOS":
                Map<String, Object> args = new HashMap<>();
                args.put("bundleId", "com.apple.mobilesafari");
                driver.executeScript("mobile: launchApp", args);
                new WaitAction(driver).waitForElement(By.name("URL"), 10);
                if (AppiumDeviceManager.getDevice().getDeviceType().toUpperCase().contains("LOCAL")) {
                    driver.get(url);
                } else {
                    driver.findElement(By.name("URL")).click();
                    driver.findElement(By.name("URL")).sendKeys(url + "\n");
                }

                if (isElementPresent(MobileBy.iOSNsPredicateString("label CONTAINS \"Don’t Use Siri\""))) {
                    new CommonActions(driver).new ClickAction().clickElement(driver.findElement(MobileBy.iOSNsPredicateString("label CONTAINS \"Don’t Use Siri\"")));
                }
                subjectElement = new WaitAction(driver).waitForElement(By.xpath(VERIFICATION_CODE_SUBJECT_XPATH_IOS), 30);
                subjectElement.click();
                MobileElement otpTextElement = new WaitAction(driver).waitForElement(By.xpath(VERIFICATION_CODE_BODY_XPATH_IOS), 10);
                otp = otpTextElement.getText();
                break;
        }
        new AppActions().relaunchApp();
        return otp;
    }
}

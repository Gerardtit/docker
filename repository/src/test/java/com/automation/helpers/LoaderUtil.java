package com.automation.helpers;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.util.WaitAction;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.NoSuchElementException;

public class LoaderUtil {

    public static void waitForCartLoaderToDisappear() {
        try {
            switch (AppiumDriverManager.getDriver().getPlatformName().toUpperCase()) {
                case "IOS":
                    new WaitAction(AppiumDriverManager.getDriver()).waitForElementToDisappear((MobileElement) AppiumDriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString("label BEGINSWITH 'Please' OR label BEGINSWITH 'Loading' AND visible==1")), 30);
                    break;
                case "ANDROID":
                    new WaitAction(AppiumDriverManager.getDriver()).waitForElementToDisappear((MobileElement) AppiumDriverManager.getDriver().findElement(MobileBy.id("umaProgressDialog")), 30);
                    break;
            }
        } catch (NoSuchElementException nse) {
            return;
        }
    }

    public static void waitForSubstitutionsLoaderToDisappear() {
        try {
            switch (AppiumDriverManager.getDriver().getPlatformName().toUpperCase()) {
                case "IOS":
                    new WaitAction(AppiumDriverManager.getDriver()).waitForElementToDisappear((MobileElement) AppiumDriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString("label CONTAINS 'Load' AND visible==1 OR label CONTAINS 'load' AND visible==1  ")), 30);
                    break;
                case "ANDROID":
                    new WaitAction(AppiumDriverManager.getDriver()).waitForElementToDisappear((MobileElement) AppiumDriverManager.getDriver().findElement(MobileBy.id("umaProgressDialog")), 30);
                    break;
            }
        } catch (NoSuchElementException nse) {
            return;
        }
    }

    public static void waitForSavingPaymentInfoLoaderToDisappear() {
        try {
            switch (AppiumDriverManager.getDriver().getPlatformName().toUpperCase()) {
                case "IOS":
                    new WaitAction(AppiumDriverManager.getDriver()).waitForElementToDisappear((MobileElement) AppiumDriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString("label BEGINSWITH 'Saving'")), 30);
                    break;
                case "ANDROID":
                    new WaitAction(AppiumDriverManager.getDriver()).waitForElementToDisappear((MobileElement) AppiumDriverManager.getDriver().findElement(MobileBy.id("umaProgressDialog")), 30);
                    break;
            }
        } catch (NoSuchElementException nse) {
            return;
        }
    }

    public static void waitForPlacingOrderLoaderToDisappear() {
        try {
            switch (AppiumDriverManager.getDriver().getPlatformName().toUpperCase()) {
                case "IOS":
                    new WaitAction(AppiumDriverManager.getDriver()).waitForElementToDisappear((MobileElement) AppiumDriverManager.getDriver().findElement(MobileBy.iOSNsPredicateString("label BEGINSWITH 'Placing order' AND visible==1")), 30);
                    break;
                case "ANDROID":
                    new WaitAction(AppiumDriverManager.getDriver()).waitForElementToDisappear((MobileElement) AppiumDriverManager.getDriver().findElement(MobileBy.id("umaProgressDialog")), 30);
                    break;
            }
        } catch (NoSuchElementException nse) {
            return;
        }
    }
}
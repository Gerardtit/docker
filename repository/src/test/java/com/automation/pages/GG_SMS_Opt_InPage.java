package com.automation.pages;


import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_SMS_Opt_InPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class GG_SMS_Opt_InPage extends BasePage {
    private GG_SMS_Opt_InPageElements gg_sms_opt_inPageElements = new GG_SMS_Opt_InPageElements();


    public GG_SMS_Opt_InPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_sms_opt_inPageElements);
    }

    public void isSMSOptInIsOnByDefault() {
        new WaitAction(driver).waitForLoaderToDisappear();
        if (platformName.equalsIgnoreCase("iOS")) {
            Assert.assertTrue(gg_sms_opt_inPageElements.smsOptInStatus.getAttribute("value").equalsIgnoreCase("On"));
        } else {
            Assert.assertTrue(gg_sms_opt_inPageElements.smsOptInStatus.getAttribute("checked").equalsIgnoreCase("true"));
        }
    }

    public void changeSmsOptInToOff() {
        new WaitAction(driver).waitForLoaderToDisappear();
        if (platformName.equalsIgnoreCase("iOS")) {

            if (gg_sms_opt_inPageElements.smsOptInStatus.getAttribute("value").equalsIgnoreCase("On")) {
                new CommonActions(driver).new ClickAction().clickElement(gg_sms_opt_inPageElements.smsOptInStatus);
            }
        } else {
            if (gg_sms_opt_inPageElements.smsOptInStatus.getAttribute("checked").equalsIgnoreCase("true")) {
                new CommonActions(driver).new ClickAction().clickElement(gg_sms_opt_inPageElements.smsOptInStatus);

            }
        }
    }

    public void changeSmsOptInToON() {
        if (platformName.equalsIgnoreCase("iOS")) {

            if (gg_sms_opt_inPageElements.smsOptInStatus.getAttribute("value").equalsIgnoreCase("Off")) {
                new CommonActions(driver).new ClickAction().clickElement(gg_sms_opt_inPageElements.smsOptInStatus);
            }
        } else {
            if (gg_sms_opt_inPageElements.smsOptInStatus.getAttribute("checked").equalsIgnoreCase("false")) {
                new CommonActions(driver).new ClickAction().clickElement(gg_sms_opt_inPageElements.smsOptInStatus);

            }
        }
    }

    public void verifySMSOptInIsOff() {

        if (platformName.equalsIgnoreCase("iOS")) {

            if (gg_sms_opt_inPageElements.smsOptInStatus.getAttribute("value").equalsIgnoreCase("On")) {
                new CommonActions(driver).new ClickAction().clickElement(gg_sms_opt_inPageElements.smsOptInStatus);
            }
        } else {
            if (gg_sms_opt_inPageElements.smsOptInStatus.getAttribute("checked").equalsIgnoreCase("true")) {
                new CommonActions(driver).new ClickAction().clickElement(gg_sms_opt_inPageElements.smsOptInStatus);

            }
        }

        if (platformName.equalsIgnoreCase("iOS")) {
            Assert.assertTrue(gg_sms_opt_inPageElements.smsOptInStatus.getAttribute("value").equalsIgnoreCase("Off"));
        } else {
            Assert.assertTrue(gg_sms_opt_inPageElements.smsOptInStatus.getAttribute("checked").equalsIgnoreCase("false"));
        }
    }

    public void addItemToCart() {
        scrollDownForElement(gg_sms_opt_inPageElements.addButton);
        if (isElementDisplayed(gg_sms_opt_inPageElements.addButton)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_sms_opt_inPageElements.addButton);
        } else {
            new CommonActions(driver).new ClickAction().clickElement(gg_sms_opt_inPageElements.plusButton);

        }
    }

    public void clickOnContactToChangePhoneNumber() {
        new CommonActions(driver).new ClickAction().clickElement(gg_sms_opt_inPageElements.changeContactLink);
    }

    public void clickOnPlaceOrderButton() {
        new CommonActions(driver).new ClickAction().clickElement(gg_sms_opt_inPageElements.placeOrderButton);
    }


    public void clickOnSaveAndReviewButton() {
        new CommonActions(driver).new ClickAction().clickElement(gg_sms_opt_inPageElements.saveAndReviewButton);
        new WaitAction(driver).waitForDisplayed(gg_sms_opt_inPageElements.smsOptInStatus, 3);

    }

    public void enterPhoneNumberInTextField(String zipCode) throws IOException {
        gg_sms_opt_inPageElements.phoneNumberTextField.clear();
        enterKey(gg_sms_opt_inPageElements.phoneNumberTextField, zipCode);
    }

    public void enterPhoneNumberInPhoneNumberTextField(String phoneNumber) {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            gg_sms_opt_inPageElements.phoneNumberTextFieldList.get(2).clear();
            enterKey(gg_sms_opt_inPageElements.phoneNumberTextFieldList.get(2), phoneNumber);
        } else {
            gg_sms_opt_inPageElements.phoneNumberTextField.clear();
            enterKey(gg_sms_opt_inPageElements.phoneNumberTextField, phoneNumber);
        }
    }

    public void editPickupsheet() {
        new CommonActions(driver).new ClickAction().clickElement(gg_sms_opt_inPageElements.pickupedit);
    }

    public void storeCardDisplayed() {
        waitForDisplayed(gg_sms_opt_inPageElements.storecard, 20);
        Assert.assertTrue(gg_sms_opt_inPageElements.storecard.isDisplayed());
    }

    public void storedetails() {
        waitForDisplayed(gg_sms_opt_inPageElements.storedetails, 10);
        Assert.assertTrue(gg_sms_opt_inPageElements.storedetails.getText().contains("Pharmacy"));
    }

    public void swipeLeftonstorecard() {
        waitForDisplayed(gg_sms_opt_inPageElements.storecard, 10);
        swipeLeftOnElement(gg_sms_opt_inPageElements.storecard);
    }

}

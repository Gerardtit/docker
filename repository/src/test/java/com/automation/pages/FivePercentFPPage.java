package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.CheckoutPageElements;
import com.automation.pageElements.GG_FreshPassMemberTab_Elements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FivePercentFPPage extends BasePage {

    public GG_FreshPassMemberTab_Elements membertabElements = new GG_FreshPassMemberTab_Elements();
    public CheckoutPageElements checkoutPageElements = new CheckoutPageElements();

    public FivePercentFPPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), membertabElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), checkoutPageElements);
    }


    public void validateOOragnicProductsWidget() {
        scrollDown();
        Assert.assertTrue(isElementDisplayed(membertabElements.OrganicProductWidget, 8));
    }

    public void validateOpenNatureProductsWidget() {
        Assert.assertTrue(isElementDisplayed(membertabElements.OpenNatureProductWidget, 8));
    }

    public void enterCreditCardNameFP(String name) {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new CommonActions(driver).new ClickAction().clickElement(checkoutPageElements.CreditCardNameFP);
            checkoutPageElements.CreditCardNameFP.sendKeys(name);
        } else {
            driver.getKeyboard().sendKeys(name);
            tapSearchAndroidKeyboard();
        }

    }

    public void enterCreditCardNumberFP(String ccnumber) {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new CommonActions(driver).new ClickAction().clickElement(checkoutPageElements.CreditCardNumberFP);
            checkoutPageElements.CreditCardNumberFP.sendKeys(ccnumber);
        } else {
            new CommonActions(driver).new ClickAction().clickElement(checkoutPageElements.CreditCardNumberFP);
            checkoutPageElements.CreditCardNumberFP.sendKeys(ccnumber);
            tapSearchAndroidKeyboard();
        }
    }

    public void enterCreditExpNumberFP(String expnumber) {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new CommonActions(driver).new ClickAction().clickElement(checkoutPageElements.expdNumberFP);
            checkoutPageElements.expdNumberFP.sendKeys(expnumber);
        } else {
            checkoutPageElements.expdNumberFP.sendKeys(expnumber);
            tapSearchAndroidKeyboard();
        }
    }

    public void enterZipcodeFP(String zipcode) {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new CommonActions(driver).new ClickAction().clickElement(checkoutPageElements.zipCodeCreditCardFP);
            checkoutPageElements.zipCodeCreditCardFP.sendKeys(zipcode);
            waitForElementToBeClickable(checkoutPageElements.continueBtnFP, 10);
            new CommonActions(driver).new ClickAction().clickElement(checkoutPageElements.continueBtnFP);
        } else {
            checkoutPageElements.zipCodeCreditCardFP.sendKeys(zipcode);
            tapSearchAndroidKeyboard();
        }
    }

    public void cvvScreenValidation(String cvvcode) {
        Assert.assertTrue(isElementDisplayed(checkoutPageElements.confirmCvvLbl, 8));
    }

    public void searchIconFP() {

        Assert.assertTrue(isElementDisplayed(membertabElements.searchIconFP, 8));

    }

    public void cartIconFP() {
        Assert.assertTrue(isElementDisplayed(membertabElements.cartIconFP, 8));

    }

    public void vipPhoneLineFP() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            scrollDown();
            Assert.assertTrue(isElementDisplayed(membertabElements.vipPhoneLineFP, 8));
        } else {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            scrollDown();
            scrollDown();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Assert.assertTrue(isElementDisplayed(membertabElements.vipPhoneLineFP, 8));

        }
    }

    public void emptyStateFP() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(isElementDisplayed(membertabElements.emptyStateFP, 8));
    }

    public void noEmptyStateFP() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(isElementDisplayed(membertabElements.emptyStateFP, 8));
    }


}

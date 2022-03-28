package com.automation.pages;


import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_checkout_contactinfoElements;
import com.automation.pageElements.NewCheckoutPageElements;
import com.automation.pageElements.PaymentPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static java.lang.Thread.sleep;


public class PaymentPage extends BasePage {
    public PaymentPageElements pageElements = new PaymentPageElements();
    public NewCheckoutPageElements newcheckoutPageElements = new NewCheckoutPageElements();
    private final GG_checkout_contactinfoElements contactinfoElements = new GG_checkout_contactinfoElements();

    public PaymentPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
    }

    public void waitForCvvWindowDisplayed() {

        waitForDisplayed(pageElements.cvvWindowTitle, 10);

    }

    public void clickNext() {
        pageElements.cvvEditText.sendKeys("\n");
        new CommonActions(driver).new ClickAction().clickElement(pageElements.creditCvvNextButton);
    }

    public void enterCvvInfo(String arg0) {
        if ((getCurrentBanner().equalsIgnoreCase("tomthumb")) || (getCurrentBanner().equalsIgnoreCase("safeway")) || (getCurrentBanner().equalsIgnoreCase("shaws")) || (getCurrentBanner().equalsIgnoreCase("acme"))) {
            enterCVVNumber(arg0);
        } else {
            waitForDisplayed(pageElements.cvvEditText);

            if (platformName.equalsIgnoreCase("android")) {
                new CommonActions(driver).new ClickAction().clickElement(pageElements.cvvEnter);
                enterKey(pageElements.cvvEditText, arg0);
//              new CommonActions(driver).new ClickAction().clickElement(pageElements.creditCvvNextButton);
            }

            new CommonActions(driver).new ClickAction().clickElement(pageElements.creditCvvNextButton);

        }
    }


    public void enterCvv(String arg0) throws InterruptedException {
        //   WebElement ele = driver.findElement(By.xpath(xpath));
    /*WebElement cvv = driver.findElement(By.id("textinput_placeholder"));
    waitForLoadingComplete();*/
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            enterKey(pageElements.cvvEditText, arg0);
            new CommonActions(driver).new ClickAction().clickElement(pageElements.doneButton);
            waitForLoadingComplete();
            new CommonActions(driver).new ClickAction().clickElement(pageElements.continueCTA);
            //     pageElements.cvvEditText.sendKeys("\n");
            //   new CommonActions(driver).new ClickAction().clickElement(pageElements.creditCvvNextButton);
        } else {
            waitForLoadingComplete();
            //   waitForElement(pageElements.cvvEditText,5);
            waitForDisplayed(pageElements.cvvEditText, 30);
            enterKey(pageElements.cvvEditText, arg0);
            pressEnterAndroid();
            waitForLoadingComplete();

            androidKeyboardClickDone();

        }


    }


    public void enterCvvNew(String arg0) throws InterruptedException {


        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            waitForLoadingComplete();
            enterKey(pageElements.cvvEditText, arg0);
            contactinfoElements.keypadDoneButton.click();
            if (isElementDisplayed(contactinfoElements.Continuetocontactinfo)) {
                contactinfoElements.Continuetocontactinfo.click();
            }

        } else {
            waitForLoadingComplete();
            waitForDisplayed(pageElements.cvvEditText, 5);
            enterKey(pageElements.cvvEditText, arg0);
            pressEnterAndroid();
            //pressEnterAndroid();
            sleep(30);
            waitForLoadingComplete();

        }
    }


    public void enterCVVNumber() throws InterruptedException {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            sleep(2000);
            enterValue(pageElements.cvvEditText, "111");
            pageElements.doneButton.click();
        }
    }


    public void enterNameOnCreditCard(String name) throws InterruptedException {

        waitForLoadingComplete();
        Thread.sleep(10000);
        if (isElementDisplayed(pageElements.nameOnCard)) {

            waitForDisplayed(pageElements.nameOnCard, 10);
            new CommonActions(driver).new ClickAction().clickElement(pageElements.nameOnCard);
            enterKey(pageElements.nameOnCard, name);
        }
    }

    public void clickContinue() throws InterruptedException {
        sleep(5000);
        waitForClickableAndClick(pageElements.continueButton);

    }

    public void enterCVVNumber(String cvvNumber) {

        if (isElementDisplayed(pageElements.cvvEditText)) {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                //    enterKey(pageElements.cardNumber, cardNumber);
                enterKey(pageElements.cvvEditText, cvvNumber);
//              new CommonActions(driver).new ClickAction().clickElement(pageElements.doneButton);


                waitForLoadingComplete();
                if (isElementDisplayed(pageElements.continueToContactInfo)) {
                    new CommonActions(driver).new ClickAction().clickElement(pageElements.continueToContactInfo);
                    waitForLoadingComplete();
                }
            } else {
                enterKey(pageElements.cvvEditText, cvvNumber);


                //waitForLoadingComplete();
                androidKeyboardClickDone();
                // clickElement(pageElements.continueToContactInfo);
                //pageElements.creditCvvNextButton.click();

                waitForLoadingComplete();
            }
        }
    }

    //##
    public void enterCVV(String cvvNumber) {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            waitForDisplayed(pageElements.cvvEditText, 10);
            enterKey(pageElements.cvvEditText, cvvNumber);
            new CommonActions(driver).new ClickAction().clickElement(pageElements.doneButton);
            waitForLoadingComplete();
            new CommonActions(driver).new ClickAction().clickElement(pageElements.continueToReviewOrderCTA);

        } else {

            enterKey(pageElements.cvvEditText, cvvNumber);
            waitForLoadingComplete();
            new CommonActions(driver).new ClickAction().clickElement(pageElements.continueToReviewOrderCTA);
            waitForLoadingComplete();

        }

    }


    public void enterCardNumber(String cardNumber) {
        if (isElementDisplayed(pageElements.cardNumber)) {
            pageElements.cardNumber.click();
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                pageElements.cardNumber.click();
                // enterKey(pageElements.cardNumber, cardNumber);
                pageElements.cardNumber.sendKeys(cardNumber);
            } else {
                enterValue(pageElements.cardNumber, cardNumber);
            }

        }
    }
/*    public void clickExpirationMonthYear() {
      new CommonActions(driver).new ClickAction().clickElement(pageElements.expirationMonthYear);
        pageElements.continueButton.click();
        waitForLoadingComplete();
    }*/

    public void enterExpirationMonthYear(String monthYear) {

        if (isElementDisplayed(pageElements.expirationMonthYear)) {
            new CommonActions(driver).new ClickAction().clickElement(pageElements.expirationMonthYear);

            // hideKeyBoard();
            enterKey(pageElements.expirationMonthYear, monthYear);

            waitForLoadingComplete();
            //androidKeyboardClickDone();
        }
    }

    public void enterBillingZipCode(String zipcode) throws InterruptedException, IOException {
        if (isElementDisplayed(pageElements.billingZip)) {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                pageElements.billingZip.click();
                pageElements.billingZip.sendKeys(zipcode);
                pageElements.continueButton.click();
            } else {
                scrollDownForElement(pageElements.billingZip);

                pageElements.billingZip.click();
                pageElements.billingZip.sendKeys(zipcode);
                pageElements.nameOnCard.click();

                pageElements.nameOnCard.click();

                if (isElementDisplayed(pageElements.nameOnCard)) {
                    waitForDisplayed(pageElements.nameOnCard, 10);
                    pageElements.nameOnCard.click();
                    try {
                        tapNextAndroidKeyboard();
                        pageElements.continueCTA.click();
                    } catch (Exception e) {
                        tapNextAndroidFromKeyboard();
                    }
                }


            }
        }

    }


    public void clickPayment() {


        waitForDisplayed(pageElements.payment);

        pageElements.payment.click();

        if (!(getCurrentBanner().equalsIgnoreCase("tomthumb")) && (!getCurrentBanner().equalsIgnoreCase("safeway")) && (!getCurrentBanner().equalsIgnoreCase("shaws")) && (!getCurrentBanner().equalsIgnoreCase("acme")) && (!getCurrentBanner().equalsIgnoreCase("pavilions"))) {
            waitForDisplayed(pageElements.payment);
            pageElements.payment.click();
        }
    }

    public void clickSaveCardDetailsCheckbox() {
        pageElements.saveCardDetailsCheckbox.click();
    }

    public void clickEditCard() {
        pageElements.editPayment.click();

    }

    public void clickSaveButton() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            pageElements.saveButton.click();
        }
    }

    public void enterBillingZipCodeWithoutEnter(String zipcode) {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            enterValue(pageElements.billingZip, zipcode);
            waitForLoadingComplete();
            scrollDown();
            //hideKeyBoard();
        } else {
            scrollDown();
            enterValue(pageElements.billingZip, zipcode);
        }
    }

    public void enterBillingZipCodeWithStoring(String zipcode) {
        if (isElementDisplayed(pageElements.billingZip)) {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                pageElements.saveCardDetailsCheckbox.click();
                enterKey(pageElements.billingZip, zipcode);
            } else {
                scrollDown();
                pageElements.saveCardDetailsCheckbox.click();
                enterKey(pageElements.billingZip, zipcode);
            }
        }
    }

    public void saveCardDetails() throws InterruptedException {
        sleep(5000);
        waitForClickableAndClick(pageElements.saveCardDetailsCheckbox);
    }

    public boolean validateCardNumberInOrderSummary() {
        waitForLoadingComplete();
        return isElementDisplayed(pageElements.verifyZipcodeValidation, 50);
    }

}

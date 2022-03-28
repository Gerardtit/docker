package com.automation.pages;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_checkout_contactinfoElements;
import com.automation.pageElements.HomePageElements;
import com.automation.pageElements.PaymentPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class GG_checkout_contactinfoPage extends BasePage {
    public HomePageElements homePageElements = new HomePageElements();
    public PaymentPageElements pageElements = new PaymentPageElements();
    private final GG_checkout_contactinfoElements contactinfoElements = new GG_checkout_contactinfoElements();

    public GG_checkout_contactinfoPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), contactinfoElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);

        PageFactory.initElements(new AppiumFieldDecorator(driver), homePageElements);
    }

    public boolean namedisplay() {
        contactinfoElements.nameatcontactinfo.isDisplayed();
        String text = contactinfoElements.nameatcontactinfo.getText();
        String regex = "^[a-zA-Z]$";
        return text.matches(regex);

    }

    public void enterCvvNumber(String arg0) {

        if (isElementDisplayed(pageElements.cvvEditText)) {
            if (platformName.equalsIgnoreCase("android")) {

                waitForLoadingComplete();
                enterKey(pageElements.cvvEditText, arg0);

                if (isElementDisplayed(contactinfoElements.saveButtonOnCart)) {
                    waitForDisplayed(contactinfoElements.saveButtonOnCart, 10);
                    new CommonActions(driver).new ClickAction().clickElement(contactinfoElements.saveButtonOnCart);
                } else {
                    waitForDisplayed(contactinfoElements.Continuetocontactinfo, 10);
                    new CommonActions(driver).new ClickAction().clickElement(contactinfoElements.Continuetocontactinfo);
                    contactinfoElements.closewindow.click();
                }
                driver.hideKeyboard();

            } else {
                enterKey(pageElements.cvvEditText, arg0);
                contactinfoElements.keypadDoneButton.click();
            }

            if (isElementDisplayed(contactinfoElements.Continuetocontactinfo)) {
                contactinfoElements.Continuetocontactinfo.click();
            } else if (isElementDisplayed(contactinfoElements.continuetoPaymentTab)) {
                contactinfoElements.continuetoPaymentTab.isEnabled();
                contactinfoElements.continuetoPaymentTab.click();
            } else if (isElementDisplayed(contactinfoElements.Continuetorevieworder)) {
                contactinfoElements.Continuetorevieworder.isEnabled();
                contactinfoElements.Continuetorevieworder.click();
            }
            if (isElementDisplayed(contactinfoElements.cvvsave)) {
                contactinfoElements.cvvsave.isEnabled();
                contactinfoElements.cvvsave.click();
            }
        }

    }

    public void enterCvvNumberonScreen(String arg0) {

        if (isElementDisplayed(pageElements.cvvEditText)) {
            if (platformName.equalsIgnoreCase("android")) {

                waitForLoadingComplete();
                enterKey(pageElements.cvvEditText, arg0);
                driver.hideKeyboard();

//              new CommonActions(driver).new ClickAction().clickElement(pageElements.creditCvvNextButton);//
//              new CommonActions(driver).new ClickAction().clickElement(contactinfoElements.continuetoPaymentTab);
                if (isElementDisplayed(contactinfoElements.saveButtonOnCart)) {
                    waitForDisplayed(contactinfoElements.saveButtonOnCart, 10);
                    new CommonActions(driver).new ClickAction().clickElement(contactinfoElements.saveButtonOnCart);
                } else {
                    waitForDisplayed(contactinfoElements.Continuetocontactinfo, 10);
                    new CommonActions(driver).new ClickAction().clickElement(contactinfoElements.Continuetocontactinfo);
                    contactinfoElements.closewindow.click();
                }

//                contactinfoElements.keypadDoneButton.click();
                //apSearchAndroidKeyboard();
//                driver.pressKey(new KeyEvent(AndroidKey.BACK));
                //tapSearchAndroidKeyboard();
                driver.hideKeyboard();
//                if(getDriver().isKeyboardShown()) {   getDriver().hideKeyboard(); }
            } else {
                enterKey(pageElements.cvvEditText, arg0);
                contactinfoElements.keypadDoneButton.click();
            }

            if (isElementDisplayed(contactinfoElements.Continuetocontactinfo)) {
                contactinfoElements.Continuetocontactinfo.click();
            } else if (isElementDisplayed(contactinfoElements.continuetoPaymentTab)) {
                contactinfoElements.continuetoPaymentTab.isEnabled();
                contactinfoElements.continuetoPaymentTab.click();
            } else if (isElementDisplayed(contactinfoElements.Continuetorevieworder)) {
                contactinfoElements.Continuetorevieworder.isEnabled();
                contactinfoElements.Continuetorevieworder.click();
            }
            if (isElementDisplayed(contactinfoElements.cvvsave)) {
                contactinfoElements.cvvsave.isEnabled();
                contactinfoElements.cvvsave.click();

            }
        }


    }


    public boolean phonenumberdisplay() {
        contactinfoElements.phoneatcontactinfo.isDisplayed();
        String number = contactinfoElements.phoneatcontactinfo.getText();
        String regex = ("\\d{10}");
        return number.matches(regex);
    }

    public void closepayment() {
        contactinfoElements.closepayment.click();
    }

    public void nameAndnumber() {
        contactinfoElements.enternametext.isDisplayed();
        contactinfoElements.enternumbertext.isDisplayed();
    }

    public void closes() {
        waitForLoadingComplete();
        if (isElementDisplayed(contactinfoElements.closewindow)) {
            contactinfoElements.closewindow.click();
        }
//        contactinfoElements.androidBackArrow.click();
//        contactinfoElements.closewindow.click();
//        contactinfoElements.notoslotpage.click();
        waitForLoadingComplete();
        if (platformName.equalsIgnoreCase("android")) {
            contactinfoElements.androidBackArrow.click();
            waitForLoadingComplete();
        }
    }

    public void warningmessage() {
        String text = contactinfoElements.warningtext.getText();
        String displayedtext = "Turn on order status text messages?";
        Assert.assertEquals(displayedtext, text);
    }

    public void entercreditcard() {
        if (isElementDisplayed(contactinfoElements.EnterCreditcard)) {
            contactinfoElements.EnterCreditcard.click();

        }
    }

    public void selectdeliveryslotoflaterdays() throws InterruptedException {
        waitForLoadingComplete();
        waitForLoadingComplete();
        waitForLoadingComplete();
        Thread.sleep(30);

        if (isElementDisplayed(contactinfoElements.weekdaysobject)) {
            contactinfoElements.weekdaysobject.click();

            waitForLoadingComplete();
            Thread.sleep(30);
        }
        if (isElementDisplayed(contactinfoElements.Continuetocontactinfo)) {
            contactinfoElements.Continuetocontactinfo.click();
        } else if (isElementDisplayed(contactinfoElements.continuetoPaymentTab)) {
            contactinfoElements.continuetoPaymentTab.isEnabled();
            contactinfoElements.continuetoPaymentTab.click();
        } else if (isElementDisplayed(contactinfoElements.continuetoCVV)) {
            contactinfoElements.continuetoCVV.isEnabled();
            contactinfoElements.continuetoCVV.click();
        } else if (isElementDisplayed(contactinfoElements.Continuetorevieworder)) {
            contactinfoElements.Continuetorevieworder.isEnabled();
            contactinfoElements.Continuetorevieworder.click();
        }
        /*if (isElementDisplayed(contactinfoElements.savetab)) {
            contactinfoElements.savetab.isEnabled();
            contactinfoElements.savetab.click();
        }*/
    }

    public void selectslot() {

        if (!isElementDisplayed(contactinfoElements.pickupslotTile)) {
            if (isElementDisplayed(pageElements.nameOnCard)) {
                pageElements.nameOnCard.click();
            } else if (isElementDisplayed(contactinfoElements.firstnamecontact)) {
                contactinfoElements.firstnamecontact.click();
            } else if (isElementDisplayed(contactinfoElements.cvvText)) {
                contactinfoElements.cvvText.click();
            } else if (isElementDisplayed(contactinfoElements.firstnamecontact)) {
                contactinfoElements.firstnamecontact.click();
            } else {
                contactinfoElements.placeorder.isEnabled();
                contactinfoElements.placeorder.click();
            }
        } else if (isElementDisplayed(contactinfoElements.Continuetocontactinfo)) {
            contactinfoElements.Continuetocontactinfo.click();
        } else if (isElementDisplayed(contactinfoElements.continuetoPaymentTab)) {
            contactinfoElements.continuetoPaymentTab.isEnabled();
            contactinfoElements.continuetoPaymentTab.click();
        } else if (isElementDisplayed(contactinfoElements.continuetoCVV)) {
            contactinfoElements.continuetoCVV.isEnabled();
            contactinfoElements.continuetoCVV.click();
        } else if (isElementDisplayed(contactinfoElements.Continuetorevieworder)) {
            contactinfoElements.Continuetorevieworder.isEnabled();
            contactinfoElements.Continuetorevieworder.click();
        } else if (isElementDisplayed(contactinfoElements.savetab)) {
            contactinfoElements.savetab.isEnabled();
            contactinfoElements.savetab.click();
        } else {
            contactinfoElements.weekdaysobject.click();
            waitForLoadingComplete();
            waitForDisplayed(contactinfoElements.hrsobject);
            contactinfoElements.hrsobject.click();
            if (isElementDisplayed(contactinfoElements.Continuetocontactinfo)) {
                contactinfoElements.Continuetocontactinfo.click();
            } else if (isElementDisplayed(contactinfoElements.continuetoPaymentTab)) {
                contactinfoElements.continuetoPaymentTab.isEnabled();
                contactinfoElements.continuetoPaymentTab.click();
            } else if (isElementDisplayed(contactinfoElements.continuetoCVV)) {
                contactinfoElements.continuetoCVV.isEnabled();
                contactinfoElements.continuetoCVV.click();
            } else if (isElementDisplayed(contactinfoElements.Continuetorevieworder)) {
                contactinfoElements.Continuetorevieworder.isEnabled();
                contactinfoElements.Continuetorevieworder.click();

            }
            if (isElementDisplayed(contactinfoElements.savetab)) {
                contactinfoElements.savetab.isEnabled();
                contactinfoElements.savetab.click();
            }
        }
    }

    public void contactdetails() throws InterruptedException {
        String fname = ThreadLocalHelper.testCaseData.get().get("first_name");
        String lname = ThreadLocalHelper.testCaseData.get().get("last_name");
        String mobnumber = ThreadLocalHelper.testCaseData.get().get("mobile_number");
        if (isElementDisplayed(contactinfoElements.firstnamecontact)) {
            contactinfoElements.firstnamecontact.click();
            enterKey(contactinfoElements.firstnamecontact, fname);
            contactinfoElements.lastnamecontact.click();
            enterKey(contactinfoElements.lastnamecontact, lname);
            contactinfoElements.mobilenumber.click();
            enterKey(contactinfoElements.mobilenumber, mobnumber);

            if (driver.getPlatformName().equalsIgnoreCase("android")) {
                androidKeyboardClickDone();
            }
            if (isElementDisplayed(contactinfoElements.Continuetorevieworder)) {
                contactinfoElements.Continuetorevieworder.isEnabled();
                contactinfoElements.Continuetorevieworder.click();
               /* if(isElementDisplayed(contactinfoElements.Close))
                {
                    contactinfoElements.Close.click();
                }*/
            } else if (isElementDisplayed(contactinfoElements.savetab)) {
                contactinfoElements.savetab.isEnabled();
                contactinfoElements.savetab.click();
                waitForLoadingComplete();
            }
        }
    }

    public void ctaclick() {
        String mobnumber = ThreadLocalHelper.testCaseData.get().get("mobile_number");
        scrollDownForElement(contactinfoElements.contactcta);
        contactinfoElements.contactcta.isDisplayed();
        contactinfoElements.contactcta.click();
        contactinfoElements.mobilenumber.click();
        contactinfoElements.mobilenumber.clear();
        enterKey(contactinfoElements.mobilenumber, mobnumber);

    }

    public void smsOn() throws IOException, InterruptedException {
        contactinfoElements.textsmstoggleon.click();
        if (isElementDisplayed(contactinfoElements.Continuetorevieworder)) {
            contactinfoElements.Continuetorevieworder.isEnabled();
            contactinfoElements.Continuetorevieworder.click();
        } else if (isElementDisplayed(contactinfoElements.savetab)) {
            contactinfoElements.savetab.isEnabled();
            contactinfoElements.savetab.click();
            Thread.sleep(10000);
        }
    }

    public void closeodrder() {
        waitForLoadingComplete();
        waitForDisplayed(contactinfoElements.crosssign);
        waitForClickableAndClick(contactinfoElements.crosssign);

    }

    public void editAddress() {
        waitForClickableAndClick(contactinfoElements.editonslot);

    }

    public void anotherstore() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            waitForClickableAndClick(contactinfoElements.selectlocation);
        }
        String newzip = ThreadLocalHelper.testCaseData.get().get("New_Zipcode");
        waitForLoadingComplete();
        waitForClickableAndClick(contactinfoElements.clearzipcode);
        waitForLoadingComplete();
        waitForLoadingComplete();
        enterKey(contactinfoElements.searchzipcode, newzip);
        waitForClickableAndClick(contactinfoElements.pickuplocation);

    }

    public void continuetab() {
        waitForClickableAndClick(contactinfoElements.continueatEdit);
    }

    public void closrcart() {
        waitForLoadingComplete();
        contactinfoElements.crosssign.click();
    }

    public void backatCart() {
        waitForLoadingComplete();
        waitForDisplayed(contactinfoElements.backarrowatCart);
        waitForClickableAndClick(contactinfoElements.backarrowatCart);

    }


    public void editcarddetails() {
        if (isElementDisplayed(contactinfoElements.pickupslotTile)) {
            if (isElementDisplayed(contactinfoElements.continuetoPaymentTab)) {
                contactinfoElements.continuetoPaymentTab.isEnabled();
                contactinfoElements.continuetoPaymentTab.click();
            } else if (isElementDisplayed(contactinfoElements.editOnPayment)) {
                contactinfoElements.editOnPayment.click();
            }
        }
    }
}




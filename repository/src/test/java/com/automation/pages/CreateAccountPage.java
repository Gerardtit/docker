package com.automation.pages;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.CreateAccountPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateAccountPage extends BasePage {
    private final CreateAccountPageElements createAccountPageElements = new CreateAccountPageElements();
    private final AppiumDevice device = AppiumDeviceManager.getDevice();

    public CreateAccountPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), createAccountPageElements);
    }

    private static String generateRandomEmail() {
        String RandomEmail =
                RandomStringUtils.randomAlphabetic(5);
        String currentDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String mailID = RandomEmail + "_" + currentDate + "@example.com";
        return mailID;
    }

    public void enterPhoneOrCardNumber(String number) {
        createAccountPageElements.phoneCardEditNumber.click();
        createAccountPageElements.phoneCardEditNumber.sendKeys(number);
        driver.hideKeyboard();
    }

    public void enterFirstLastName(String firstname, String lastname) {
        createAccountPageElements.firstNameEditText.click();
        createAccountPageElements.firstNameEditText.sendKeys(firstname);
        createAccountPageElements.lastNameEditText.click();
        createAccountPageElements.lastNameEditText.sendKeys(lastname);
        driver.hideKeyboard();
    }

    public void clickContinueButton() throws InterruptedException {
        createAccountPageElements.continueButton.click();
    }

    public void waitForCreateAccountPageDisplayed(int pageNumber) {
        switch (pageNumber) {
            case 1:
                waitVar.until(ExpectedConditions.visibilityOf(createAccountPageElements.createAccountTitle));
                break;
            case 2:
                waitVar.until(ExpectedConditions.visibilityOf(createAccountPageElements.deliverTextMessage));
                break;
            case 3:
                waitVar.until(ExpectedConditions.visibilityOf(createAccountPageElements.agreeCheckBox));
                break;
        }
    }

    public void selectResidential() {
        createAccountPageElements.residentialButton.click();
    }

    public void selectCommertial() {
        createAccountPageElements.commercialButton.click();
    }

    public void enterAddress1(String address) {
        createAccountPageElements.streetAddress1EditText.click();
        createAccountPageElements.streetAddress1EditText.sendKeys(address);
        driver.hideKeyboard();
        driver.hideKeyboard();
    }

    public void checkAgreeBox() {
        createAccountPageElements.agreeCheckBox.click();
    }

    public void selectReference(String text) throws InterruptedException {
        createAccountPageElements.referenceDropDown.click();
        if (driver.getPlatformName().equalsIgnoreCase("android"))
            ((WebElement) createAccountPageElements.referenceDropDownOption.get(0)).click();
        else if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            createAccountPageElements.referenceDropDown.click();
            createAccountPageElements.iosReferencePickerWheel.sendKeys("Email");
            createAccountPageElements.iosDoneButton.click();
        }
        Thread.sleep(1000);
    }

    public void clickShopNowButton() {
        createAccountPageElements.shopNowButton.click();
    }

    public void waitForPasswordPopUp() {
        new WaitAction(driver).waitForDisplayed(createAccountPageElements.savePasswordText);
    }

    public void clickNotNowButton() {
        new CommonActions(driver).new ClickAction().clickElement(createAccountPageElements.savePasswordNotNowButton);
    }

    public void iosUserClickNotSaveFromPopup() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            try {

                new WaitAction(driver).waitForDisplayed(createAccountPageElements.savePasswordNotNowButton);
                new CommonActions(driver).new ClickAction().clickElement(createAccountPageElements.savePasswordNotNowButton);
            } catch (Exception e) {
            }

        }
    }

    public void waitForSignupPageDisplayed() {
        new WaitAction(driver).waitForDisplayed(createAccountPageElements.createAccountButton);
    }

    public void enterFirstName(String firstName) {
        int index = 0;

        if (device.getPlatform().equalsIgnoreCase("android")) {
            index = createAccountPageElements.android_firstNameIndex;
        } else {
            index = createAccountPageElements.ios_firstNameIndex;
        }
        enterKey(createAccountPageElements.textFieldList.
                get(index), firstName);
    }

    public void enterLastName(String lastName) {
        int index = 0;

        if (device.getPlatform().equalsIgnoreCase("android")) {
            index = createAccountPageElements.android_lastNameIndex;
        } else {
            index = createAccountPageElements.ios_lastNameIndex;
        }
        enterKey(createAccountPageElements.textFieldList.
                get(index), lastName);
    }

    public void enterEmail(String email) {
        int index = 0;

        if (device.getPlatform().equalsIgnoreCase("android")) {
            index = createAccountPageElements.android_emailIndex;
        } else {
            index = createAccountPageElements.ios_emailIndex;
        }
        enterKey(createAccountPageElements.textFieldList.
                get(index), email);
    }

    public void enterPassword(String password) {
        if (device.getPlatform().equalsIgnoreCase("android")) {
            enterKey(createAccountPageElements.textFieldList.get(createAccountPageElements.android_passwordIndex),
                    password);
        } else {
            enterKey(createAccountPageElements.ios_password, password);
        }
    }

    public void enterPhoneCardNo(String number) {
        int index = 0;

        if (device.getPlatform().equalsIgnoreCase("android")) {
            index = createAccountPageElements.android_phoneCardNoIndex;
        } else {
            index = createAccountPageElements.ios_phoneCardNoIndex;
        }
        enterKey(createAccountPageElements.textFieldList.
                get(index), number);
    }

    public void clickCreateAccountButton() {
        scrollDownForElement(createAccountPageElements.createAccountButton);
        if (device.getPlatform().equalsIgnoreCase("android")) {
            hideKeyBoard();
        }
        new CommonActions(driver).new ClickAction().clickElement(createAccountPageElements.createAccountButton);
    }

    public void clickTermOfUse() {
        scrollDownForElement(createAccountPageElements.termOfUseLink);
        new CommonActions(driver).new ClickAction().clickElement(createAccountPageElements.termOfUseLink);
    }

    public void clickUsingWebviewBrowser() {
        if (device.getPlatform().equalsIgnoreCase("android")) {
            new CommonActions(driver).new ClickAction().clickElement(createAccountPageElements.android_WebViewBrowserButton);
        }
    }

    public void clickPrivacyTerm() {
        scrollDownForElement(createAccountPageElements.privacyPolicyLink);
        new CommonActions(driver).new ClickAction().clickElement(createAccountPageElements.privacyPolicyLink);
    }

    public void verifyEmailErrorMark() {
        new WaitAction(driver).waitForDisplayed(createAccountPageElements.emailErrorMark);
    }

    public void verifyPhoneCardErrorMark() {
        new WaitAction(driver).waitForDisplayed(createAccountPageElements.phoneCardNoErrorMark);
    }

    public void verifyPasswordErrorMark() {
        new WaitAction(driver).waitForDisplayed(createAccountPageElements.passwordErrorMark);
    }

}

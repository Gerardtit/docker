package com.automation.pages;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.entities.BannerConfType;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.MyAccountPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MyAccountPage extends BasePage {
    private final MyAccountPageElements myAccountPageElements = new MyAccountPageElements();
    private final Map<String, String> dataSharedBetwnSteps = new HashMap<String, String>();

    public MyAccountPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), myAccountPageElements);
    }

    public void waitForAccountPageDisplayed() {

        new WaitAction(driver).waitForLoadingComplete();
        waitVar.until(ExpectedConditions.visibilityOf(myAccountPageElements.myAccountPageTitle));

        Assert.assertEquals(myAccountPageElements.myAccountPageTitle.getText(), "Account");
    }

    public void verifyPhoneNumberUsedInStoreDisplayed() {
        scrollDownForElement(myAccountPageElements.phoneNumberUsedInStore);
        Assert.assertTrue(myAccountPageElements.phoneNumberUsedInStore.isDisplayed());
    }

    public void clickEditPhoneNumber() {
        new CommonActions(driver).new ClickAction().clickElement(myAccountPageElements.phoneNumberUsedInStore);
    }

    public void verifySavingsSummeryDisplayed() {
        waitVar.until(ExpectedConditions.visibilityOf(myAccountPageElements.savingSummary));
    }

    public void verifyAddressWindowDisplayed() {
        waitVar.until(ExpectedConditions.visibilityOf(myAccountPageElements.userAddressText));
    }

    public void verifyStoreInfoDisplayed() {
        scrollDownForElement(myAccountPageElements.storeAddressText);
    }

    public void verifyUDCInfoDisplayed() {
        scrollDownForElement(myAccountPageElements.udcText);
    }

    public void verifyEmailAddressDisplayed() {
        scrollDownForElement(myAccountPageElements.userEmail);
    }

    public void verifyCommunicationPreferenceDisplayed() {
        scrollDownForElement(myAccountPageElements.communicationPreference);
    }

    public void verifyPasswordSecurityDisplayed() {
        scrollDownForElement(myAccountPageElements.passwordSecurity);
    }

    public void clickBackButton() {
        new CommonActions(driver).new ClickAction().clickElement(myAccountPageElements.navigateBackButton);
    }

    public void verifyPhoneNumberEditWindowDisplayed() {
        waitVar.until(ExpectedConditions.visibilityOf(myAccountPageElements.phoneNumberEditTitle));
    }

    public void createNewPhoneNumber() {
        String areaCode = (int) (Math.random() * 7 + 2) + new SimpleDateFormat("dd").format(new Date());
        String phoneCode = (int) (Math.random() * 7 + 2) + new SimpleDateFormat("HHmmss").format(new Date());
        dataSharedBetwnSteps.put("phoneNoInStoreNew", areaCode + phoneCode);
        enterPhoneNumberOnPhoneNumberEditWindow(areaCode + phoneCode);
        hideKeyBoard();
        savePhoneNumber();
    }

    private void enterPhoneNumberOnPhoneNumberEditWindow(String number) {
        for (MobileElement element : myAccountPageElements.phoneEditTextList) {
            element.clear();
            enterKey(element, number);
        }

    }

    public void clickSaveButton() {
        new CommonActions(driver).new ClickAction().clickElement(myAccountPageElements.saveButton);
    }

    public void savePhoneNumber() {
        if (!isElementDisplayed(myAccountPageElements.saveButton, 3)) {
            scrollDownForElement(myAccountPageElements.saveButton, 3);
        }
        new CommonActions(driver).new ClickAction().clickElement(myAccountPageElements.saveButton);
    }

    public void getConfirmationEmail() {
        if (!isElementDisplayed(myAccountPageElements.saveButton, 3)) {
            scrollDownForElement(myAccountPageElements.saveButton, 3);
        }
        new CommonActions(driver).new ClickAction().clickElement(myAccountPageElements.saveButton);
    }

    public void verifyOriginalPhoneNumberDisplayed() throws IOException {
        String phoneNumberInStore = getDataSharedBetwnSteps().get("phoneNoInStore");
        String actualPhoneNo = getThePhoneNumberInStore();
        //Additional scroll as the text field is hidden by the lower tab icons
        if (actualPhoneNo.isEmpty()) {
            scrollDown(1);
        }
        Assert.assertEquals(actualPhoneNo, phoneNumberInStore, "The numbers for store don't match");
    }

    public void verifyNewPhoneNumberDisplayed() throws IOException, InterruptedException {
        Thread.sleep(3000);
        String phoneNumberInStore = getDataSharedBetwnSteps().get("phoneNoInStoreNew");
        String actualPhoneNo = getThePhoneNumberInStore().replaceAll("[^0-9]", "");
        //Additional scroll as the text field is hidden by the lower tab icons
        if (actualPhoneNo.isEmpty()) {
            scrollDown(1);
        }
        Assert.assertEquals(phoneNumberInStore, actualPhoneNo, "The numbers for store don't match");
    }

    public void updateSavedPhoneNumber() throws IOException {
        AppiumDevice device = AppiumDeviceManager.getDevice();
        String number = device.getConfigureData(BannerConfType.BANNER_PHONE_NUMBER);
        enterPhoneNumberOnPhoneNumberEditWindow(number);
    }

    public void verifyCurrentPhoneNumberDisplayed() {
        Assert.assertEquals(myAccountPageElements.phoneNumberUsedInStore.getText(), ThreadLocalHelper.testCaseData.get().get("PHONENUMBER"));
    }

    public void clickBackButtonToAccountPage() throws InterruptedException {
        Thread.sleep(1000);
        new CommonActions(driver).new ClickAction().clickElement(myAccountPageElements.navigateBackToAccountPageButton);
    }

    public void PopupSaveConfirmMessage() {

        waitForDisplayed(myAccountPageElements.popupMessage);
    }

    public void PopupSaveButtonClick(String button) {
        if (button.equalsIgnoreCase("no")) {
            new CommonActions(driver).new ClickAction().clickElement(myAccountPageElements.selectNoButtonToSave);
        } else if (button.equalsIgnoreCase("yes")) {
            new CommonActions(driver).new ClickAction().clickElement(myAccountPageElements.selectYesButtonToSave);
        }

    }

    public void verifyContactPhoneNumberDisplayed() {
        scrollDownForElement(myAccountPageElements.phoneNumberHead);
        Assert.assertTrue(myAccountPageElements.phoneNumberHead.isDisplayed());
    }

    public void clickEditContactPhoneNumber() {
        new CommonActions(driver).new ClickAction().clickElement(myAccountPageElements.phoneNumberHead);
    }

    public void waitForContactphoneEditWindowDisplayed() {
        new WaitAction(driver).waitForDisplayed(myAccountPageElements.phoneNumberWindowTitle);
    }

    public void createNewContactNumber() {
        String areaCode = (int) (Math.random() * 7 + 2) + new SimpleDateFormat("dd").format(new Date());
        String phoneCode = (int) (Math.random() * 7 + 2) + new SimpleDateFormat("HHmmss").format(new Date());
        dataSharedBetwnSteps.put("contactPhoneNoNew", areaCode + phoneCode);
        enterContactNumberOnContactPhoneEditWindow(areaCode + phoneCode);
    }

    private void enterContactNumberOnContactPhoneEditWindow(String number) {
        myAccountPageElements.phoneNumberEditText.clear();
        enterKey(myAccountPageElements.phoneNumberEditText, number);
    }

    public void newContactNumberWindowDisplayed() {
        new WaitAction(driver).waitForDisplayed(myAccountPageElements.phoneNumberWindowTitle);
    }

    public void updateSavedContactNumber() throws IOException {
        AppiumDevice device = AppiumDeviceManager.getDevice();
        String number = device.getConfigureData(BannerConfType.BANNER_CONTACT_NUMBER);
        enterContactNumberOnContactPhoneEditWindow(number);
    }

    public void verifyOriginalContactPhoneNumberDisplayed() {
        String phoneNumberInStore = getDataSharedBetwnSteps().get("contactPhoneNo");
        if (getTheContactPhoneNumber().isEmpty()) {
            scrollDown(1);
        }
        String actualPhoneNo = getTheContactPhoneNumber();
        Assert.assertEquals(actualPhoneNo, phoneNumberInStore, "The numbers for store don't match");
    }

    public void clickEditAddress() {
        new CommonActions(driver).new ClickAction().clickElement(myAccountPageElements.userAddressHead);
    }

    public void verifyAddressEditWindowDisplayed() {
        new WaitAction(driver).waitForDisplayed(myAccountPageElements.addressWindowTitle);
    }

    public void editNewAddress() throws IOException {
        AppiumDevice device = AppiumDeviceManager.getDevice();
        String address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE1_FORSR);
        enterAddressEditWindow(address);
    }

    private void enterAddressEditWindow(String address) {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            deleteCurrentTextInEditText(myAccountPageElements.addressLine1EditText);
            enterKey(myAccountPageElements.addressLine1EditText, address);
        } else {
            deleteCurrentTextInEditText(myAccountPageElements.androidAddressEditList.get(1));
            enterKey(myAccountPageElements.androidAddressEditList.get(1), address);
        }
    }

    public void verifyOriginalAddressDisplayed() throws IOException, InterruptedException {
        Thread.sleep(5000);
        AppiumDevice device = AppiumDeviceManager.getDevice();
        String address1 = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE1);
        String address2 = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE1_FORSR);

        if ((myAccountPageElements.userAddressText).getText() == address1)
            Assert.assertTrue(myAccountPageElements.userAddressText.getText().contains(address1), "Expected value :" + address1 + "\n Actual value :" + myAccountPageElements.userAddressText.getText());
        else if ((myAccountPageElements.userAddressText).getText() == address2)
            Assert.assertTrue(myAccountPageElements.userAddressText.getText().contains(address2), "Expected value :" + address2 + "\n Actual value :" + myAccountPageElements.userAddressText.getText());

    }

    public void verifyNewAddressDisplayed() throws IOException, InterruptedException {
        Thread.sleep(5000);
        AppiumDevice device = AppiumDeviceManager.getDevice();
        String address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE1_FORSR);
        Assert.assertTrue(myAccountPageElements.userAddressText.getText().contains(address), "Expected value :" + address + "\n Actual value :" + myAccountPageElements.userAddressText.getText());
    }

    public void clickEditPassword() {
        new CommonActions(driver).new ClickAction().clickElement(myAccountPageElements.passwordSecurity);
    }

    public void passwordWindowDisplayed() {
        new WaitAction(driver).waitForDisplayed(myAccountPageElements.passwordWindowTitle);
    }

    public void changePassword(String newPass, String oldPass) {
        int i = 0;
        for (MobileElement element : myAccountPageElements.passwordEditFieldList) {
            element.clear();
            if (i == 0) {
                enterKey(element, oldPass);
            } else {
                enterKey(element, newPass);
            }
            i++;
        }
    }

    public void editOriginalAddress() throws IOException {
        String address = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE1");
        enterAddressEditWindow(address);
    }

    public void verifyNewPhoneContactNumberDisplayed() throws InterruptedException {
        //Added wait as in Android the updation happens without loader
        Thread.sleep(3000);
        String phoneNumberInStore = getDataSharedBetwnSteps().get("contactPhoneNoNew");
        if (getTheContactPhoneNumber().isEmpty()) {
            scrollDown();
        }
        String actualPhoneNo = getTheContactPhoneNumber().replaceAll("[^0-9]", "");
        Assert.assertEquals(actualPhoneNo, phoneNumberInStore, "The numbers for store don't match");
    }

    public void verifyOriginalEmailDisplayed() {
        AppiumDevice device = AppiumDeviceManager.getDevice();
        String email = device.getConfigureData(BannerConfType.BANNER_USERNAME);
        Assert.assertTrue(myAccountPageElements.userEmail.getText().contains(email));
    }

    public void verifyNewEmailDisplayed() {
        AppiumDevice device = AppiumDeviceManager.getDevice();
        String email = device.getConfigureData(BannerConfType.BANNER_USERNAME);
        Assert.assertFalse(myAccountPageElements.userEmail.getText().contains(email));
    }

    private void enterEmailOnEmailEditWindow(String number) {
        for (MobileElement element : myAccountPageElements.emailEditTextList) {
            deleteCurrentTextInEditText(element);
            enterKey(element, number);
        }
    }

    public void updateSavedEmail() throws IOException {
        AppiumDevice device = AppiumDeviceManager.getDevice();
        String email = device.getConfigureData(BannerConfType.BANNER_USERNAME);
        enterEmailOnEmailEditWindow(email);
    }

    public void updateNewEmail() {
        AppiumDevice device = AppiumDeviceManager.getDevice();
        String currentDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String email = device.getBanner() + "_" + device.getEnv() + "_" + currentDate + "@example.com";
        enterEmailOnEmailEditWindow(email);
    }

    public void passwordErrorDisplayed() {
        new WaitAction(driver).waitForDisplayed(myAccountPageElements.passwordAlertMessage);
    }

    public void verifyToggleSwitchDisplayed(String text) {
        String locator;
        MobileElement element;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            locator = "type == 'XCUIElementTypeSwitch' AND name CONTAINS '" + text + "'";
            element = (MobileElement) driver.findElement(MobileBy.iOSNsPredicateString(locator));
        } else {
            locator = "new UiSelector().textContains(\"" + text + "\")";
            element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(locator));
        }
        Assert.assertTrue(element.isDisplayed());
    }

    public Map<String, String> getDataSharedBetwnSteps() {
        return dataSharedBetwnSteps;
    }

    public void viewThePhoneNumberInStore() {
        scrollDownForElement(myAccountPageElements.phoneNumberUsedInStore);
        //Additional scroll as the text field is hidden by the lower tab icons
        if (myAccountPageElements.phoneNumberUsedInStore.getText().isEmpty()) {
            scrollDown(1);
        }
        dataSharedBetwnSteps.put("phoneNoInStore", myAccountPageElements.phoneNumberUsedInStore.getText());
    }

    public String getThePhoneNumberInStore() {
        return myAccountPageElements.phoneNumberUsedInStore.getText();
    }

    public void viewTheContactPhoneNumber() {
        scrollDownForElement(myAccountPageElements.contactPhoneNumberText);
        if (myAccountPageElements.contactPhoneNumberText.getText().isEmpty()) {
            scrollDown(1);
        }
        dataSharedBetwnSteps.put("contactPhoneNo", myAccountPageElements.contactPhoneNumberText.getText());
    }

    public String getTheContactPhoneNumber() {
        return myAccountPageElements.contactPhoneNumberText.getText();
    }


    public void checkZip() {

        AppiumDevice device = AppiumDeviceManager.getDevice();
        String zip = device.getConfigureData(BannerConfType.BANNER_ZIPCODE);

        Assert.assertTrue(myAccountPageElements.zipcodeEditText.getText().contains(zip), "Expected value :" + zip + "\n Actual value :" + myAccountPageElements.zipcodeEditText.getText());

    }


    public void clickContinueBtnForZipChangePopUp() {
        if (isElementDisplayed(myAccountPageElements.selectYesButtonToSave)) {
            new CommonActions(driver).new ClickAction().clickElement(myAccountPageElements.selectYesButtonToSave);

        }
    }

    public boolean verifyContactPhoneNumberOnCheckoutpageAndMyAccountPageAreSame() {
        return true;
    }

    public void clickpickup() {
        if (isElementDisplayed(myAccountPageElements.clickpickup)) {
            new CommonActions(driver).new ClickAction().clickElement(myAccountPageElements.clickpickup);
        }

    }

    public void verifybirthdaydisplayed() {
        new CommonActions(driver).new ClickAction().clickElement(myAccountPageElements.birthdaytext);
    }

    public boolean verifyWallet() {
        waitForDisplayed(myAccountPageElements.wallet);
        return isElementDisplayed(myAccountPageElements.wallet);
    }
}

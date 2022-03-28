package com.automation.pages;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_AccountPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GG_AccountPage extends BasePage {


    String pickupAddressBeforeAnyAction;
    private final GG_AccountPageElements accountPageElements = new GG_AccountPageElements();
    private final Map<String, String> testData = new HashMap<>();

    public GG_AccountPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), accountPageElements);
    }

    public Map<String, String> getTestData() {
        return testData;
    }

    public boolean isAccountProfilePageDisplayed() {
        return isElementDisplayed(accountPageElements.accountHeaderTitle) && accountPageElements.accountHeaderTitle.getText().equals("Account");
    }

    public void clickSignOut() {
        new CommonActions(driver).new ClickAction().clickElement(accountPageElements.signOutButton);
        new CommonActions(driver).new ClickAction().clickElement(accountPageElements.confirmSignOutOkButton);
    }

    public boolean isLifetimeSavingsFieldDisplayed() {
        return isElementDisplayed(accountPageElements.lifetimeSavingsField);
    }

    public void clickOnDeliveryAddressOption() {
        new CommonActions(driver).new ClickAction().clickElement(accountPageElements.deliveryAddressOption);
    }

    public boolean isDeliveryAddressPageDisplayed() {
        return isElementDisplayed(accountPageElements.deliveryAddressPageTitle);
    }

    public void clickOnBackButtonFromDeliveryAddressPage() {
        new CommonActions(driver).new ClickAction().clickElement(accountPageElements.backButton);
    }

    public void clickSaveButtonOnDeliveryAddressPage() {
        new CommonActions(driver).new ClickAction().clickElement(accountPageElements.saveButton);
    }

    public void enterAddressInAddressLineTextField(String deliveryAddress) {
        enterKey(accountPageElements.addressLineTextField, deliveryAddress);
    }

    public void updateAddressInAddressLineTextField(String updatedDeliveryAddress) {
        enterKey(accountPageElements.addressLineTextField, updatedDeliveryAddress);
    }

    public String savedNewDeliveryAddress() {
        return accountPageElements.addressLineTextField.getText();
    }

    public String savedUpdatedDeliveryAddress() {
        return accountPageElements.addressLineTextField.getText();
    }

    public boolean verifyAddressLineTextFieldIsEmpty() {
        return accountPageElements.addressLineTextField.getText().isEmpty();
    }

    public void enterMoreThanAcceptedCharactersDeliveryInstructionSection() throws IOException {
        String deliveryInstructions = ThreadLocalHelper.testCaseData.get().get("DELIVERYINSTRUCTIONS_NOTACCECPTED");
        enterKey(accountPageElements.deliveryInstructionsSection, deliveryInstructions);
    }

    public boolean isErrorMessageDisplayedOnDeliveryInstructionSection() {
        return isElementDisplayed(accountPageElements.errorMessageOnDeliveryInstructionSection);
    }

    public void clickPickUpStoreSectionOnAccountPage() {
        new WaitAction(driver).waitForLoadingComplete();
        pickupAddressBeforeAnyAction = accountPageElements.pickUpStoreAddressOnAccountPage.getText();
        new CommonActions(driver).new ClickAction().clickElement(accountPageElements.pickUpStoreSection);
    }

    public void changeThePickUpStore() {
        new WaitAction(driver).pleaseWaitForTheLoadingToComplete();
        // Change to a store which is supported by the banner
        testData.put("pickupStoreAddressUpdated", accountPageElements.pickUpStoreAddressList.get(2).getText());
        new CommonActions(driver).new ClickAction().clickElement(accountPageElements.pickUpStoreAddressList.get(2));
        if (accountPageElements.saveButtonOnPickUpStoreSelection.getAttribute("enabled").equalsIgnoreCase("false")) {
            new CommonActions(driver).new ClickAction().clickElement(accountPageElements.pickUpStoreAddressList.get(0));
        }
    }

    public void clickSaveButtonOnPickUpStoreSelection() {
        new CommonActions(driver).new ClickAction().clickElement(accountPageElements.saveButtonOnPickUpStoreSelection);
    }

    public void clickBackOptionOnPopUp() {
        new CommonActions(driver).new ClickAction().clickElement(accountPageElements.backOptionOnPickUpStoreSelectionPopUp);
    }

    public void clickCancelButtonPickUpStoreSelection() {
        new CommonActions(driver).new ClickAction().clickElement(accountPageElements.cancelButtonPickUpStoreSelection);
        new CommonActions(driver).new ClickAction().clickElement(accountPageElements.noOptionOnPickUpStoreSelectionPopUp);
    }

    public void clickContinueOptionOnPopUp() {
        if (isElementDisplayed(accountPageElements.continueOptionOnPickUpStoreSelectionPopUp)) {
            new CommonActions(driver).new ClickAction().clickElement(accountPageElements.continueOptionOnPickUpStoreSelectionPopUp);
            new WaitAction(driver).pleaseWaitForTheLoadingToComplete();
        }
    }

//    public String checkPickUpStoreAddress() {
//        String pickupAddress = accountPageElements.pickUpStoreAddressOnAccountPage.getText();
//        return pickupAddress;
//    }

    public void verifyPickUpStoreAddressNotUpdated() {
        String pickupAddDisplayed = getPickupStoreAddress();
        Assert.assertEquals(pickupAddDisplayed, getTestData().get("pickupStoreAddress"), "Pickup Address don't match");
    }

    public void verifyPickUpStoreAddressUpdated() throws InterruptedException {
        Thread.sleep(5000);
        String pickupAddDisplayed = getPickupStoreAddress();
        pickupAddDisplayed = getPickupStoreAddress().contains("\n") ? getPickupStoreAddress().replaceAll(System.getProperty("line.separator"), "") : pickupAddDisplayed;
        String expPickupAddress = getTestData().get("pickupStoreAddressUpdated").replaceAll(System.getProperty("line.separator"), " ");
        Assert.assertEquals(expPickupAddress.contains(pickupAddDisplayed), true, "Pickup Address don't match " + " Expected " + expPickupAddress + " Actual " + pickupAddDisplayed);
    }

    public void userEditWithAlreadyRegisteredEmail() throws IOException {
        String email = ThreadLocalHelper.testCaseData.get().get("ALREADY_REGISTERED_EMAIL_ID");
        for (MobileElement element : accountPageElements.emailEditTextList) {
            deleteCurrentTextInEditText(element);
            enterKey(element, email);
        }
    }

    public boolean iSErrorMessageIsDisplayedOnEmailAddressEditPage() {
        return isElementDisplayed(accountPageElements.errorMessageIsDisplayedOnEmailAddressEditPage);
    }

    public void clickCommunicationPreferencesSection() {
        scrollDownForElement(accountPageElements.communicationPreferencesSection);
        new CommonActions(driver).new ClickAction().clickElement(accountPageElements.communicationPreferencesSection);
    }

    public boolean isCommunicationPreferencesPageDisplayed() {
        new WaitAction(driver).waitForLoadingComplete();
        return isElementDisplayed(accountPageElements.communicationPreferencesSectionTitle);
    }

    public void verifyCommunicationPreferencesAreInONState() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            accountPageElements.pushNotificationToggle.getAttribute("value").equalsIgnoreCase("1");
            accountPageElements.justForUToggle.getAttribute("value").equalsIgnoreCase("1");
            accountPageElements.weeklySpecialsToggle.getAttribute("value").equalsIgnoreCase("1");
            accountPageElements.groceryDeliveryToggle.getAttribute("value").equalsIgnoreCase("1");
            scrollDownForElement(accountPageElements.justForUProductRecallsToggle);
            accountPageElements.justForUProductRecallsToggle.getAttribute("value").equalsIgnoreCase("1");
        } else {
            accountPageElements.pushNotificationToggle.getAttribute("checked").equalsIgnoreCase("true");
            accountPageElements.justForUToggle.getAttribute("checked").equalsIgnoreCase("true");
            accountPageElements.weeklySpecialsToggle.getAttribute("checked").equalsIgnoreCase("true");
            accountPageElements.groceryDeliveryToggle.getAttribute("checked").equalsIgnoreCase("true");
            scrollDownForElement(accountPageElements.justForUProductRecallsToggle);
            accountPageElements.justForUProductRecallsToggle.getAttribute("checked").equalsIgnoreCase("true");
        }
    }

    public void verifyCommunicationPreferencesAreInOFFState() {
        new WaitAction(driver).pleaseWaitForTheLoadingToComplete();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
//            accountPageElements.pushNotificationToggle.getAttribute("value").equalsIgnoreCase("0");
            accountPageElements.justForUToggle.getAttribute("value").equalsIgnoreCase("0");
            accountPageElements.weeklySpecialsToggle.getAttribute("value").equalsIgnoreCase("0");
            accountPageElements.groceryDeliveryToggle.getAttribute("value").equalsIgnoreCase("0");
            accountPageElements.justForUProductRecallsToggle.getAttribute("value").equalsIgnoreCase("0");
        } else {
            accountPageElements.pushNotificationToggle.getAttribute("checked").equalsIgnoreCase("false");
            accountPageElements.justForUToggle.getAttribute("checked").equalsIgnoreCase("false");
            accountPageElements.weeklySpecialsToggle.getAttribute("checked").equalsIgnoreCase("false");
            accountPageElements.groceryDeliveryToggle.getAttribute("checked").equalsIgnoreCase("false");
            accountPageElements.justForUProductRecallsToggle.getAttribute("checked").equalsIgnoreCase("false");
        }
    }

    public void setCommunicationPreferences() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new CommonActions(driver).new ClickAction().clickElement(accountPageElements.pushNotificationToggle);
            new CommonActions(driver).new ClickAction().clickElement(accountPageElements.nativeNotificationToggle);
            new CommonActions(driver).new ClickAction().clickElement(accountPageElements.nativeNotifcationBackButton);
            new CommonActions(driver).new ClickAction().clickElement(accountPageElements.justForUToggle);
            new CommonActions(driver).new ClickAction().clickElement(accountPageElements.weeklySpecialsToggle);
            scrollDownForElement(accountPageElements.groceryDeliveryToggle);
            new CommonActions(driver).new ClickAction().clickElement(accountPageElements.groceryDeliveryToggle);
            scrollDownForElement(accountPageElements.justForUProductRecallsToggle);
            new CommonActions(driver).new ClickAction().clickElement(accountPageElements.justForUProductRecallsToggle);
        } else {
//            new CommonActions(driver).new ClickAction().clickElement(accountPageElements.pushNotificationToggle);
//            new CommonActions(driver).new ClickAction().clickElement(accountPageElements.pushNotificationSettings);
//            new CommonActions(driver).new ClickAction().clickElement(accountPageElements.nativeNotificationToggle);
//            new CommonActions(driver).new ClickAction().clickElement(accountPageElements.nativeNotifcationBackButton);
            new CommonActions(driver).new ClickAction().clickElement(accountPageElements.justForUToggle);
            new CommonActions(driver).new ClickAction().clickElement(accountPageElements.weeklySpecialsToggle);
            scrollDownForElement(accountPageElements.groceryDeliveryToggle);
            new CommonActions(driver).new ClickAction().clickElement(accountPageElements.groceryDeliveryToggle);
            scrollDownForElement(accountPageElements.justForUProductRecallsToggle);
            new CommonActions(driver).new ClickAction().clickElement(accountPageElements.justForUProductRecallsToggle);
        }
    }

    public void clickBackButtonOnCommunicationPreferencesPage() {
        new CommonActions(driver).new ClickAction().clickElement(accountPageElements.backButtonOnCommunicationPreferencesPage);
    }

    public void clickOrderSection() {
        new CommonActions(driver).new ClickAction().clickElement(accountPageElements.orderSection);
    }

    public boolean isOldOrdersDisplayed() {
        return scrollDownForElement(accountPageElements.pastOrderTitle);

    }

    public void clickSignOutButtonOnMenuPage() {
        new CommonActions(driver).new ClickAction().clickElement(accountPageElements.signOutButton);
    }

    public void clickOkButtonToConfirmSignOut() {
        new CommonActions(driver).new ClickAction().clickElement(accountPageElements.confirmSignOutButton);
    }

    public void clickNoOptionOnConfirmationPopUp() {
        new CommonActions(driver).new ClickAction().clickElement(accountPageElements.noOptionOnPickUpStoreSelectionPopUp);
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void viewPickupStoreAddress() {
        testData.put("pickupStoreAddress", accountPageElements.pickupStoreAddressText.getText());
    }

    public String getPickupStoreAddress() {
        new WaitAction(driver).waitForDisplayed(accountPageElements.pickupStoreAddressText);
        return accountPageElements.pickupStoreAddressText.getText();
    }
}


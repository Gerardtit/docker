package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.entities.BannerConfType;
import com.automation.mobile.util.WaitAction;
import com.automation.pages.GG_SettingsPage;
import com.automation.pages.MyAccountPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class MyAccountPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public MyAccountPage myAccountPage = new MyAccountPage(driver);
    public GG_SettingsPage settingsPage = new GG_SettingsPage(driver);

    @Then("^my account page is displayed$")
    public void myAccountPageIsDisplayed() {
        myAccountPage.waitForAccountPageDisplayed();
    }

    @When("^user verify phone number used in store is displayed$")
    public void userVerifyPhoneNumberUsedInStoreIsDisplayed() {
        myAccountPage.verifyPhoneNumberUsedInStoreDisplayed();
    }

    @When("^user click edit phone number on account page$")
    public void userClickEditPhoneNumberOnAccountPage() {
        myAccountPage.clickEditPhoneNumber();
    }

    @When("^user verify savings summery is displayed on account page$")
    public void userVerifySavingsSummeryIsDisplayedOnAccountPage() {
        myAccountPage.verifySavingsSummeryDisplayed();
    }

    @And("^user verify address window is displayed on account page$")
    public void userVerifyAddressWindowIsDisplayedOnAccountPage() {
        myAccountPage.verifyAddressWindowDisplayed();
    }

    @And("^user verify birthday  is displayed on account page$")
    public void userVerifybirthday() {
        myAccountPage.verifybirthdaydisplayed();
    }


    @And("^user verify Dug store info is displayed on account page$")
    public void userVerifyDugStoreInfoIsDisplayedOnAccountPage() {
        myAccountPage.verifyStoreInfoDisplayed();
    }

    @And("^user verify email address is displayed on account page$")
    public void userVerifyEmailAddressIsDisplayedOnAccountPage() {
        myAccountPage.verifyEmailAddressDisplayed();
    }

    @And("^user verify communication preference is displayed on account page$")
    public void userVerifyCommunicationPreferenceIsDisplayedOnAccountPage() {
        myAccountPage.verifyCommunicationPreferenceDisplayed();
    }

    @And("^verify needhelp is displayed on account page$")
    public void userVerifyneedhelpIsDisplayedOnAccountPage() {
        settingsPage.ChatBotModuleIsDisplayed();
    }

    @And("^user verify password security is displayed on account page$")
    public void userVerifyPasswordSecurityIsDisplayedOnAccountPage() {
        myAccountPage.verifyPasswordSecurityDisplayed();
    }

    @When("^user clicks back button on account page$")
    public void userClicksBackButtonOnAccountPage() {
        myAccountPage.clickBackButton();
    }

    @Then("^phone number edit window is displayed$")
    public void phoneNumberEditWindowIsDisplayed() {
        myAccountPage.verifyPhoneNumberEditWindowDisplayed();
    }

    @When("^user edit and confirm new phone number on account edit window$")
    public void userEditAndConfirmNewPhoneNumberOnAccountEditWindow() {
        myAccountPage.createNewPhoneNumber();
    }

    @And("^user click save button on account edit window$")
    public void userClickSaveButtonOnAccountEditWindow() {
        myAccountPage.clickSaveButton();
        new WaitAction(driver).waitForLoadingComplete();
    }

    @Then("^user verify original phone number is displayed$")
    public void userVerifyOriginalPhoneNumberIsDisplayed() throws IOException {
        myAccountPage.verifyOriginalPhoneNumberDisplayed();
    }

    @When("^user edit and confirm saved phone number on account edit window$")
    public void userEditAndConfirmSavedPhoneNumberOnAccountEditWindow() throws IOException {
        myAccountPage.updateSavedPhoneNumber();
    }

    @Then("^user verify current phone number is displayed$")
    public void userVerifyCurrentPhoneNumberIsDisplayed() throws IOException {
        myAccountPage.verifyCurrentPhoneNumberDisplayed();
    }

    @And("^user clicks back button on store phone edit window$")
    public void userClicksBackButtonOnStorePhoneEditWindow() throws InterruptedException {
        myAccountPage.clickBackButtonToAccountPage();
        //myAccountPage.navigateBack();
    }

    @When("^popup save confirm message$")
    public void PopupSaveConfirmMessage() {
        myAccountPage.PopupSaveConfirmMessage();
    }

    @And("^user select \"([^\"]*)\" on save confirm window$")
    public void UserSelectOnSaveConfirmWindow(String button) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        myAccountPage.PopupSaveButtonClick(button);
    }

    @And("^user verify new phone number is displayed$")
    public void userVerifyNewPhoneNumberIsDisplayed() throws IOException, InterruptedException {
        myAccountPage.verifyNewPhoneNumberDisplayed();
    }

    @Given("^user verify contact phone number is displayed$")
    public void userVerifyContactPhoneNumberIsDisplayed() {
        myAccountPage.verifyContactPhoneNumberDisplayed();
    }

    @When("^user click edit contact phone number on account page$")
    public void userClickEditContactPhoneNumberOnAccountPage() {
        myAccountPage.clickEditContactPhoneNumber();
    }

    @Then("^contact phone number edit window is displayed$")
    public void contactPhoneNumberEditWindowIsDisplayed() {
        myAccountPage.waitForContactphoneEditWindowDisplayed();
    }

    @When("^user edit new contact phone number on account edit window$")
    public void userEditNewContactPhoneNumberOnAccountEditWindow() {
        myAccountPage.createNewContactNumber();
    }

    @And("^user verify new contact phone number window is displayed$")
    public void userVerifyNewContactPhoneNumberWindowIsDisplayed() {
        myAccountPage.newContactNumberWindowDisplayed();
    }

    @Then("^verify Wallet is displayed in place of Account$")
    public void verifyWalletTabBarIsDisplayed() {
        myAccountPage.verifyWallet();
    }

    @When("^user edit original contact phone number on account edit window$")
    public void userEditOriginalContactPhoneNumberOnAccountEditWindow() throws IOException {
        myAccountPage.updateSavedContactNumber();
    }

    @And("^user verify original contact phone number is displayed$")
    public void userVerifyOriginalContactPhoneNumberIsDisplayed() throws Exception {
        myAccountPage.verifyOriginalContactPhoneNumberDisplayed();
    }

    @When("^user click edit address on account page$")
    public void userClickEditAddressOnAccountPage() {
        myAccountPage.clickEditAddress();
    }

    @Then("^address edit window is displayed$")
    public void addressEditWindowIsDisplayed() {
        myAccountPage.verifyAddressEditWindowDisplayed();
    }

    @When("^user edit new address on account edit window$")
    public void userEditNewAddressOnAccountEditWindow() throws IOException {
        myAccountPage.editNewAddress();
    }

    @And("^user verify original address is displayed$")
    public void userVerifyOriginalAddressIsDisplayed() throws IOException, InterruptedException {
        myAccountPage.verifyOriginalAddressDisplayed();
    }

    @And("^user verify new address is displayed$")
    public void userVerifyNewAddressIsDisplayed() throws IOException, InterruptedException {
        myAccountPage.verifyNewAddressDisplayed();
    }

    @When("^user click edit password on account page$")
    public void userClickEditPasswordOnAccountPage() {
        myAccountPage.clickEditPassword();
    }

    @Then("^password edit window is displayed$")
    public void passwordEditWindowIsDisplayed() {
        myAccountPage.passwordWindowDisplayed();
    }

    @When("^user edit new password on account edit window$")
    public void userEditNewPasswordOnAccountEditWindow() {
        myAccountPage.changePassword("1234Pass", "Pass1234");
    }

    @When("^user edit original password on account edit window$")
    public void userEditOriginalPasswordOnAccountEditWindow() {
        myAccountPage.changePassword("Pass1234", "1234Pass");
    }

    @When("^user edit original address on account edit window$")
    public void userEditOriginalAddressOnAccountEditWindow() throws IOException {
        myAccountPage.editOriginalAddress();
    }

    @Then("^verify user is redirect back from address edit window$")
    public void verifyUserIsRedirectBackFromAddressEditWindow() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            //
        } else {  //android
            myAccountPage.waitForAccountPageDisplayed();
            myAccountPage.clickBackButton();
        }

    }

    @And("^user verify new contact phone number is displayed$")
    public void userVerifyNewContactPhoneNumberIsDisplayed() throws InterruptedException {
        myAccountPage.verifyNewPhoneContactNumberDisplayed();
    }

    @And("^user verify original email is displayed on account page$")
    public void userVerifyOriginalEmailIsDisplayedOnAccountPage() throws InterruptedException {
        Thread.sleep(3000);
        myAccountPage.verifyOriginalEmailDisplayed();
    }

    @And("^user verify new email is displayed on account page$")
    public void userVerifyNewEmailIsDisplayedOnAccountPage() throws InterruptedException {
        Thread.sleep(3000);
        myAccountPage.verifyNewEmailDisplayed();
    }

    @When("^user edit original email on account edit window$")
    public void userEditOriginalEmailOnAccountEditWindow() throws IOException {
        myAccountPage.updateSavedEmail();
    }

    @When("^user edit new email on account edit window$")
    public void userEditNewEmailOnAccountEditWindow() {
        myAccountPage.updateNewEmail();
    }

    @When("^user edit new password \"([^\"]*)\" on account edit window$")
    public void userEditNewPasswordOnAccountEditWindow(String password) {
        AppiumDevice device = AppiumDeviceManager.getDevice();
        myAccountPage.changePassword(password, device.getConfigureData(BannerConfType.BANNER_PASSWORD));
    }

    @Then("^password error is displayed on account edit page$")
    public void passwordErrorIsDisplayedOnAccountEditPage() {
        myAccountPage.passwordErrorDisplayed();
    }

    @And("^\"([^\"]*)\" toggle switch is displayed$")
    public void toggleSwitchIsDisplayed(String text) {
        myAccountPage.verifyToggleSwitchDisplayed(text);
    }


    @And("^user verify UDC info is displayed on account page$")
    public void userVerifyUDCInfoIsDisplayedOnAccountPage() {
        myAccountPage.verifyUDCInfoDisplayed();
    }

    @And("^user views the phone number used in store$")
    public void userViewsThePhoneNumberUsedInStore() {
        myAccountPage.viewThePhoneNumberInStore();
    }

    @And("^user views the contact phone number$")
    public void userViewsTheContactPhoneNumber() {
        myAccountPage.viewTheContactPhoneNumber();
    }

    @And("^user acknowledges Zip Code Change popup$")

    public void userAcknowledgesZipCodeChangePopup() {
        myAccountPage.clickContinueBtnForZipChangePopUp();
//        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
//        }
        /*
        myAccountPage.checkZip();

        if (true) {

        } else {
            myAccountPage.clickContinueBtnForZipChangePopUp();
            myAccountPage.pleaseWaitForTheLoadingToComplete();
        }


         */

    }

    @Then("^click on Click your deals")
    public void clickyourdeals() {
        myAccountPage.clickpickup();
    }

    @When("^user clicks developer settings")
    public void clickdevelopersettings() {
        settingsPage.clickDeveloperSettings();
    }

}

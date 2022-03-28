package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_AccountPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class GG_AccountPageSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    private final GG_AccountPage accountPage = new GG_AccountPage(driver);

    @Then("^verify lifetime savings field is displayed$")
    public void verifyLifetimeSavingsFieldIsDisplayed() throws InterruptedException {
        Assert.assertTrue(accountPage.isLifetimeSavingsFieldDisplayed());
        Thread.sleep(2000);
    }

    @When("^click on delivery address option$")
    public void clickOnDeliveryAddressOption() {
        accountPage.clickOnDeliveryAddressOption();
    }
//
//    @Then("^verify delivery address page is displayed$")
//    public void verifyDeliveryAddressPageIsDisplayed() {
//        Assert.assertTrue(accountPage.isDeliveryAddressPageDisplayed());
//    }
//
//    @And("^click back button from delivery address page$")
//    public void clickBackButtonFromDeliveryAddressPage() {
//        accountPage.clickOnBackButtonFromDeliveryAddressPage();
//    }
//
//    @And("^click save button on delivery address page$")
//    public void clickSaveButtonOnDeliveryAddressPage() {
//        accountPage.clickSaveButtonOnDeliveryAddressPage();
//    }
//
//    @When("^enter address in 'Address Line' text field$")
//    public void enterAddressInAddressLineTextField() {
//        accountPage.enterAddressInAddressLineTextField("Test Address");
//    }
//
//    @When("^update address in 'Address Line' text field$")
//    public void updateAddressInAddressLineTextField() {
//        accountPage.updateAddressInAddressLineTextField("Test Updated Address");
//    }
//
//    @Then("^verify saved new delivery address$")
//    public void verifySavedNewDeliveryAddress() {
//        Assert.assertEquals(accountPage.savedNewDeliveryAddress(), "Test Address");
//    }
//
//    @Then("^verify saved updated delivery address$")
//    public void verifySavedUpdatedDeliveryAddress() {
//        Assert.assertEquals(accountPage.savedUpdatedDeliveryAddress(), "Test Updated Address");
//    }
//
//    @Then("^verify 'Address Line' text field is empty$")
//    public void verifyAddressLineTextFieldIsEmpty() {
//        Assert.assertTrue(accountPage.verifyAddressLineTextFieldIsEmpty());
//    }

    @And("^click on 'Address Line' text field and clear the text$")
    public void clickOnAddressLineTextFieldAndClearTheText() {
//        Assert.assertTrue(accountPage.clearAddressLineTextField());
    }

    @And("^enter more than (\\d+) characters Delivery Instruction section$")
    public void enterMoreThanCharactersDeliveryInstructionSection() throws IOException {
        accountPage.enterMoreThanAcceptedCharactersDeliveryInstructionSection();
    }

    @Then("^error message displayed on Delivery Instruction section$")
    public void errorMessageDisplayedOnDeliveryInstructionSection() {
        Assert.assertTrue(accountPage.isErrorMessageDisplayedOnDeliveryInstructionSection());
    }

    @When("^click pick up store section on account page$")
    public void clickPickUpStoreSectionOnAccountPage() {
        accountPage.clickPickUpStoreSectionOnAccountPage();
    }

    @And("^change the pick up store$")
    public void changeThePickUpStore() {
        accountPage.changeThePickUpStore();
    }

    @And("^click save button on pick up store selection$")
    public void clickSaveButtonOnPickUpStoreSelection() {
        accountPage.clickSaveButtonOnPickUpStoreSelection();
    }

    @And("^click back option on pop up$")
    public void clickBackOptionOnPopUp() {
        accountPage.clickBackOptionOnPopUp();
    }

    @And("^click cancel button pick up store selection$")
    public void clickCancelButtonPickUpStoreSelection() {
        accountPage.clickCancelButtonPickUpStoreSelection();
    }

    @And("^click continue option on pop up$")
    public void clickContinueOptionOnPopUp() {
        accountPage.clickContinueOptionOnPopUp();
    }

    @Then("^verify pick up store address not updated$")
    public void verifyPickUpStoreAddressNotUpdated() {
        accountPage.verifyPickUpStoreAddressNotUpdated();
    }

    @Then("^verify pick up store address is updated$")
    public void verifyPickUpStoreAddressIsUpdated() throws InterruptedException {
        accountPage.verifyPickUpStoreAddressUpdated();
    }

    @When("^user edit with already registered email on account edit window$")
    public void userEditWithAlreadyRegisteredEmailOnAccountEditWindow() throws IOException {
        accountPage.userEditWithAlreadyRegisteredEmail();
    }

    @Then("^verify error message is displayed on email address edit page$")
    public void verifyErrorMessageIsDisplayedOnEmailAddressEditPage() {
        Assert.assertTrue(accountPage.iSErrorMessageIsDisplayedOnEmailAddressEditPage());
    }

    @When("^user clicks communication preferences section on account page$")
    public void userClickCommunicationPreferencesSectionOnAccountPage() {
        accountPage.clickCommunicationPreferencesSection();
    }

    @Then("^communication preferences page is displayed$")
    public void communicationPreferencesPageIsDisplayed() {
        Assert.assertTrue(accountPage.isCommunicationPreferencesPageDisplayed());
    }

    @And("^verify communication preferences are in ON state$")
    public void verifyCommunicationPreferencesAreInONState() {
        accountPage.verifyCommunicationPreferencesAreInONState();
    }

    @And("^verify communication preferences are in OFF state$")
    public void verifyCommunicationPreferencesAreInOFFState() {
        accountPage.verifyCommunicationPreferencesAreInOFFState();
    }

    @And("^set communication preferences are in OFF state$")
    public void setCommunicationPreferencesAreInState() {
        accountPage.setCommunicationPreferences();
    }

    @And("^set communication preferences are in ON state$")
    public void setCommunicationPreferencesAreInOFFState() {
        accountPage.setCommunicationPreferences();
    }

    @And("^click back button on communication preferences page$")
    public void clickBackButtonOnCommunicationPreferencesPage() {
        accountPage.clickBackButtonOnCommunicationPreferencesPage();
    }

    @When("^user clicks order section$")
    public void userClicksOrderSection() {
        accountPage.clickOrderSection();
    }

    @Then("^old orders are displayed$")
    public void oldOrdersAreDisplayed() {
        Assert.assertTrue(accountPage.isOldOrdersDisplayed());
    }

    @And("^sign out from app$")
    public void signOutFromApp() {
        accountPage.clickSignOutButtonOnMenuPage();
        accountPage.clickOkButtonToConfirmSignOut();
    }

    @And("^click ok button to confirm sign out$")
    public void clickOkButtonToConfirmSignOut() {
        accountPage.clickOkButtonToConfirmSignOut();
    }

    @And("^decline the save updated location popup$")
    public void declineTheSaveUpdatedLocationPopup() {
        accountPage.clickNoOptionOnConfirmationPopUp();
    }

    @And("^view the pickup store address$")
    public void userViewsThePickupStoreAddress() {
        accountPage.viewPickupStoreAddress();
    }
}

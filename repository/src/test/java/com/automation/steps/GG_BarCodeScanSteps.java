package com.automation.steps;

import com.automation.helpers.AppActions;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.util.WaitAction;
import com.automation.pages.GG_BarCodeScanPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class GG_BarCodeScanSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_BarCodeScanPage barCodeScanPage = new GG_BarCodeScanPage(driver);

    @And("^click scan setting option on settings screen$")
    public void clickScanSettingOptionOnSettingsScreen() {
        barCodeScanPage.clickScanSetting();
    }

    @Then("^verify scan setting option is present on settings screen$")
    public void verifyScanSettingOptionIsPresentOnSettingsScreen() {
        Assert.assertTrue(barCodeScanPage.verifyScanSettingOption());
    }

    @Then("^verify user is in scan setting page$")
    public void verifyUserIsInScanSettingPage() {
        Assert.assertTrue(barCodeScanPage.verifyUserIsInScanSettingPage());
    }

    @When("^click toggle to ON state$")
    public void clickToggleToONState() {
        barCodeScanPage.clickToggleToONState();
    }

    @Then("^verify toggle setting is ON state$")
    public void verifyToggleSettingIsONState() {
        Assert.assertTrue(barCodeScanPage.verifyToggleSettingIsONState());
    }

    @And("^click toggle to OFF state$")
    public void clickToggleToOFFState() {
        barCodeScanPage.clickToggleToOFFState();
    }

    @Then("^verify toggle setting is OFF state$")
    public void verifyToggleSettingIsOFFState() {
        Assert.assertTrue(barCodeScanPage.verifyToggleSettingIsOFFState());
    }

    @Then("^verify that barcode scan option is displayed$")
    public void verifyThatBarcodeScanOptionIsDisplayed() {
        Assert.assertTrue(barCodeScanPage.verifyThatBarcodeScanOption());
    }

    @When("^click on barcode scan option$")
    public void clickOnBarcodeScanOption() {
        barCodeScanPage.clickOnBarcodeScanOption();
    }

    @And("^click allow on camera permission popup$")
    public void clickAllowOnCameraPermissionPopup() {
        barCodeScanPage.clickAllowOnCameraPermissionPopup();
    }

    @Then("^user is allow to scan$")
    public void userIsAllowToScan() {
        Assert.assertTrue(barCodeScanPage.userIsAllowToScan());
    }

    @And("^click close icon on scan screen$")
    public void clickCloseIconOnScanScreen() {
        barCodeScanPage.clickCloseIconOnScanScreen();
    }

    @And("^click get started on tutorials$")
    public void clickGetStartedOnTutorials() {
        barCodeScanPage.clickGetStartedOnTutorials();
    }

    @And("^click on flash button$")
    public void clickOnFlash() {
        barCodeScanPage.clickOnFlash();
    }

    @Then("^verify flash option is displayed$")
    public void verifyFlashOptionIsDisplayed() {
        Assert.assertTrue(barCodeScanPage.verifyFlashOptionIsDisplayed());
    }

    @Then("^verify flash status as OFF$")
    public void verifyFlashStatusAsOFF() {
        Assert.assertTrue(barCodeScanPage.verifyFlashStatusAsOFF());
    }

    @Then("^verify toggle button$")
    public void verifyToggleButton() {
        Assert.assertTrue(barCodeScanPage.verifyToggleButton());
    }

    @Then("^verify Deals option present on toggle button$")
    public void verifyDealsOptionPresentOnToggleButton() {
        Assert.assertTrue(barCodeScanPage.verifyDealsOptionPresentOnToggleButton());
    }

    @Then("^verify Product option present on toggle button$")
    public void verifyProductOptionPresentOnToggleButton() {
        Assert.assertTrue(barCodeScanPage.verifyProductOptionPresentOnToggleButton());
    }

    @Then("^verify Deals option selected$")
    public void verifyDealsOptionSelected() {
        Assert.assertTrue(barCodeScanPage.verifyDealsOptionSelected());
    }

    @Then("^verify search bar changes view to typing state$")
    public void verify_search_bar_changes_view_to_typing_state() {
        Assert.assertTrue(barCodeScanPage.verifyTextView());
    }

    @Then("^verify scan icon is replaced by cancel icon$")
    public void verify_scan_icon_is_replaced_by_cancel_icon() {
        Assert.assertTrue(barCodeScanPage.verifyCancelButton());
    }

    @When("^toggle deals to product$")
    public void toggleDealsToProduct() {
        barCodeScanPage.toggleDealsToProduct();
    }

    @And("^toggle product to deals$")
    public void toggleProductToDeals() {
        barCodeScanPage.toggleProductToDeals();
    }

    @Then("^verify product option selected$")
    public void verifyProductOptionSelected() {
        Assert.assertTrue(barCodeScanPage.verifyProductOptionSelected());
    }

    @And("^verify scan to shop title is displayed$")
    public void verifyScanToShopTitleIsDisplayed() {
        barCodeScanPage.isScanToShopDisplayed();
    }

    @And("^verify scan to clip title is displayed$")
    public void verifyScanToClipTitleIsDisplayed() {
        barCodeScanPage.isScanToClipDisplayed();
    }

    @And("^Pull the drawer Up in Scan To Shop Screen$")
    public void VerifyDrawerIsPulledUp() {
        barCodeScanPage.pullTheDrawerUp();
    }

    @And("^Pull the drawer Down in Scan To Shop Screen$")
    public void VerifyDrawerIsPulledDown() {
        barCodeScanPage.pullTheDrawerDown();
    }

    @When("^verify scan and save dialog title$")
    public void verifyScanAndSaveDialogtitle() {
        Assert.assertTrue(barCodeScanPage.verifyScanAndSaveDialogtitle());
        Assert.assertTrue(barCodeScanPage.verifyScanAndSaveDialogSubtitle());
    }

    @Then("^verify flash status as ON$")
    public void verifyFlashStatusAsON() {
        Assert.assertTrue(barCodeScanPage.verifyFlashStatusAsON());
    }

    @And("^verify scan to clip drawer text$")
    public void verifyScanToClipDrawerText() throws InterruptedException {
        barCodeScanPage.verifyScanToClipDrawerText();
    }

    @Then("^verify Camera Please Pop Up is Displayed$")
    public void verifyCameraPleasePopUpIsDisplayed() {
        Assert.assertTrue(barCodeScanPage.isCameraPleasePopUpDisplayed());
    }

    @Then("^verify Open Settings CTA is Displayed$")
    public void verifyOpenSettingCTADisplayed() {
        barCodeScanPage.isOpenSettingCTADisplayed();
    }

    @Then("^click On Open Setting CTA$")
    public void clickOnOpenSettingCTA() {
        barCodeScanPage.clickOnOpenSettingCTA();
    }

    @Then("^click On deny Permission on pop up$")
    public void clickOnDenyPermissionPopUp() {
        barCodeScanPage.clickPermissionDenyOnPopUp();
    }

    @Then("^verify Setting Page is Displayed$")
    public void verifySettingPageIsDisplayed() {
        Assert.assertTrue(barCodeScanPage.isSettingPageDisplayed());
    }

    @Then("^verify Tutorial page is Displayed$")
    public void verifyOnboardingPageIsDisplayed() {
        Assert.assertTrue(barCodeScanPage.isGetStartedOnTutorialsDisplayed());
    }

    @When("^move app with barcode scan page to background and bring it back to foreground$")
    public void keepAppInBackgroundAndRelaunchingTheSameInBarcodeScanScreen() throws IOException {
        new AppActions().moveAppToBackground();
        new WaitAction(driver).waitForLoaderToDisappear();
        barCodeScanPage.clickOnUpdateLaterIfDisplayedOnBarCodeScanScreen();
        barCodeScanPage.clickOnCancelButtonFeedbackFormIfDisplayedOnBarCodeScanScreen();
        new WaitAction(driver).waitForLoaderToDisappear();
    }

    @When("^move app with scan setting page to background and bring it back to foreground$")
    public void keepAppInBackgroundAndRelaunchingTheSameInScanSettingPage() throws IOException {
        new AppActions().moveAppToBackground();
        new WaitAction(driver).waitForLoaderToDisappear();
        barCodeScanPage.clickOnUpdateLaterIfDisplayedOnBarCodeScanScreen();
        new WaitAction(driver).waitForLoaderToDisappear();
    }

    @When("^move app with camera please page to background and bring it back to foreground$")
    public void keepAppInBackgroundAndRelaunchingTheSameInCameraPleasePage() throws IOException {
        new AppActions().moveAppToBackground();
        new WaitAction(driver).waitForLoaderToDisappear();
        barCodeScanPage.clickOnUpdateLaterIfDisplayedOnBarCodeScanScreen();
        new WaitAction(driver).waitForLoaderToDisappear();
    }

    @Then("verify scan to shop drawer text when {string} mode is selected")
    public void verifyScanToShopDrawerTextWhenModeIsSelected(String shoppingMode) throws InterruptedException {
        barCodeScanPage.verifyScanToShopDrawerText(shoppingMode);
    }
}

package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_BirthdaycardPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class GG_birthdaycardSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_BirthdaycardPage bdaycardPage = new GG_BirthdaycardPage(driver);
    AppiumDevice device = AppiumDeviceManager.getDevice();

    @Then("birthday card is closed")
    public void birthdayCardIsclosed() {
        bdaycardPage.closebdaycard();
    }

    @And("user clicks on birthday card")
    public void userClicksOnBirthdayCard() {
        bdaycardPage.bdaycardselected();

    }

    @Then("close birthday card")
    public void birthdayCardclosed() {
        bdaycardPage.closebdaycard();
    }

    @Then("user enters invalid dates")
    public void userEntersInvalidDates() throws Exception {
        bdaycardPage.invaliddobenter();
    }

    @And("validate UI of enter birthday screen")
    public void validateTheTextOnBirthdayCardPage() {
        bdaycardPage.bdaycardtext();
    }


    @Then("user enters valid dates")
    public void userEntersValidDates() {
        bdaycardPage.validdobenter();
    }

    @And("Verify birthday card is displayed in Rewards tab")
    public void verifyBithdayCardText() {
        bdaycardPage.verifyBirthdayCardText();
    }

    @Then("Verify birthday toast message")
    public void verifyBirthdayToastMessage() {
        bdaycardPage.verifyToastMessage();
    }

    @Then("Verify Get special treat section is not displayed in rewards tab")
    public void verifyGetSpecialTreatSectionIsNotDisplayedInRewardsTab() {
        bdaycardPage.verifyBirthdayCardTextNotDisplayed();
    }

    @And("user clicks on user name")
    public void userClicksOnUserName() {

        bdaycardPage.clickOnUserName();
    }

    @And("validate birthday text and click on it")
    public void validateBirthdayTextAndClickOnIt() {
        bdaycardPage.verifyBirthdayInAccount();
        bdaycardPage.clickOnBirthday();
    }

    @Then("Verify Edit button in Birthday section")
    public void verifyEditButtonInBirthdaySection() {
        bdaycardPage.verifyEditButtonInBdayNotDisplay();
    }
}

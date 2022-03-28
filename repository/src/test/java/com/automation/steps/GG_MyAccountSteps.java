package com.automation.steps;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_MyAccountPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GG_MyAccountSteps {
    public AppiumDevice device = AppiumDeviceManager.getDevice();
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_MyAccountPage myAccountPage = new GG_MyAccountPage(driver);
    private final String UMA_User_Signup = "";
    private String UMA_User_SignIn = null;

    public String getCurrentBanner() {
        return driver.getCapabilities().getCapability("banner").toString();
    }

    public String getCurrentAppPackage() {
        return device.getPackageName();
    }

    public String getBundleId() {
        return device.getBundleId();
    }

    public String getCurrentEnv() {
        return driver.getCapabilities().getCapability("env").toString();
    }

    public String getCurrentPackage() {
        return driver.getCapabilities().getCapability("env").toString();
    }

    public String getMfaUser() {
        return device.getMfaUser();
    }


    @When("^User click on user profile icon$")
    public void userClickOnUserProfileIcon() {
        myAccountPage.clickOnUserProfile();


    }

    @Then("^User verify Account option in list$")
    public void userVerifyAccountOptionInList() {
        myAccountPage.verifyAccountOtion();
    }

    @When("^User click on Account option$")
    public void userClickOnAccountOption() {
        myAccountPage.clickAccountOtion();

    }


    @Then("^user see My account page$")
    public void userSeeMyAccountPage() {
        myAccountPage.verifyMyAccount();
    }

    @And("^user verify email id in email section$")
    public void userVerifyEmailIdInEmailSection() {
//        UMA_User_SignIn = device.getMfaUser();
        UMA_User_SignIn = ThreadLocalHelper.testCaseData.get().get("USERNAME");
        myAccountPage.verifyEmailIdInMyAccount(UMA_User_SignIn);
    }

    @And("^user not see password option$")
    public void userNotSeePasswordOption() {
        myAccountPage.verifyPasswordInMyAccount();
    }

    @And("^User update Email Id$")
    public void userUpdateEmailId() throws Exception {
        myAccountPage.updateNewEmail();
    }


    @And("^User update phone number$")
    public void userUpdatePhoneNumber() {
        myAccountPage.updatePhoneNumber();
    }

    @And("^user click phone number section$")
    public void userClickPhoneNumberSection() {

        myAccountPage.clickPhoneNumber();
    }

    @And("^User update contact number$")
    public void userUpdateContactNumber() {
        myAccountPage.updateContactNumber();
    }


    @And("^user click contact number section$")
    public void userClickContactNumberSection() {
        myAccountPage.clickContactNumber();
    }
}


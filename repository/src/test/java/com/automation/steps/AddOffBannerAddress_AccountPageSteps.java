package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.AddOffBannerAddress_AccountPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AddOffBannerAddress_AccountPageSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public AppiumDevice device = AppiumDeviceManager.getDevice();
    AddOffBannerAddress_AccountPage AddMultiAddress = new AddOffBannerAddress_AccountPage(driver);


    @When("^user clicks menu button on home page$")
    public void user_click_menu_button_on_home_page() {
        try {
            AddMultiAddress.clickMenuIcon();
        } catch (Exception e) {
        }
    }

    @Then("^user enters Address details as \"([^\"]*)\" and AddressType as \"([^\"]*)\"$")
    public void user_enters_AddressLines_as_and_AddressType_as(String address, String AddType) throws Throwable {
        AddMultiAddress.accountPage_AddressLine(address);

    }

    @Then("^user enter the \"([^\"]*)\" to check for the order availability$")
    public void user_enters_the_zipcode_to_check_for_the_order_availability(String zipcode) throws Throwable {
        AddMultiAddress.enterAccountPageZipcode(zipcode);
        AddMultiAddress.verifyZipcodeValidated();
    }

    @Then("^user click continue to update zipcode with new delivery address$")
    public void user_click_continue_to_update_zipcode_with_new_delivery_address() throws Throwable {
        AddMultiAddress.clickContinueZipcodeChage();
    }


    @When("^user click account on menu page$")
    public void userClicksAccountOnMenuPage() {
        AddMultiAddress.ClickAccount();
    }

    @Then("^user account page is displayed$")
    public void myAccountPageIsDisplayed() {
        AddMultiAddress.waitForAccountPageDisplayed();
    }

    @When("^user clicks edit address on account page$")
    public void userClickEditAddressOnAccountPage() {
        AddMultiAddress.clickEditAddress();
    }

}

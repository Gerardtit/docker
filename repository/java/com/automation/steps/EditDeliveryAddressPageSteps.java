package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.EditDeliveryAddressPage;
import com.automation.pages.MyAccountPage;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;

import java.io.IOException;

public class EditDeliveryAddressPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public EditDeliveryAddressPage editDeliveryAddressPage = new EditDeliveryAddressPage(driver);

    @When("^user edit new address on edit delivery address page$")
    public void userEditNewAddressOnEditDeliveryAddressPage() throws IOException {
        editDeliveryAddressPage.editNewAddress();
    }

    @When("^user edit original address on edit delivery address page$")
    public void userEditOriginalAddressOnEditDeliveryAddressPage() throws IOException {
        editDeliveryAddressPage.editOriginalAddress();
    }

    @When("^navigate back to previous level from address book page$")
    public void navigateBackToPreviousLevelFromAddressBookPage() throws Throwable {
        MenuPageSteps menuPageSteps = new MenuPageSteps();
        editDeliveryAddressPage.navigateBackTopLeftArrow();
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            menuPageSteps.menu_page_is_displayed();
            menuPageSteps.userClicksAccountOnMenuPage();
        }
    }
}

package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.AddAddress_NewcheckoutPage;
import com.automation.pages.SelectOrderTypePage;
import com.automation.pages.SignInPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class AddAddress_NewcheckoutSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public AppiumDevice device = AppiumDeviceManager.getDevice();
    AddAddress_NewcheckoutPage adress_newcheckoutPage = new AddAddress_NewcheckoutPage(driver);
    SignInPage signInPage = new SignInPage(driver);
    SelectOrderTypePage selectOrderTypePage = new SelectOrderTypePage(driver);

    public String getCurrentBanner() {
        return driver.getCapabilities().getCapability("banner").toString();
    }

    public String getCurrentEnv() throws IOException {
        return driver.getCapabilities().getCapability("env").toString();
    }

    @Then("validate cursor is at street address")
    public void validateCursorIsAtStreetAddress() {
        adress_newcheckoutPage.validatecursor();
    }

    @Then("City and state are pre-filled")
    public void cityAndStateArePreFilled() {
        adress_newcheckoutPage.city();
        adress_newcheckoutPage.state();
    }

    @And("State is not editable")
    public void stateIsNotEditable() {
        adress_newcheckoutPage.state_unchangable();
    }

    @And("apt number is optional")
    public void aptNumberIsOptional() {
        adress_newcheckoutPage.apt_optional();
    }

    @Then("user enters delivery address")
    public void userEntersDeliveryAddress() {
        adress_newcheckoutPage.addressdetails();
    }


    @Then("^user enters delivery address in progressive flow$")

    public void user_enters_delivery_address_in_progressive_flow() throws Throwable {


        AppiumDevice device = AppiumDeviceManager.getDevice();
        if (driver.getPlatformName().equalsIgnoreCase("ios"))
            adress_newcheckoutPage.addressdetails();
        else {
            adress_newcheckoutPage.addressdetailsonCartpage();
        }


    }

}

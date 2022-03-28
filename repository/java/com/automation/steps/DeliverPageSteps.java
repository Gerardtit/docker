package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.DeliverPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;

public class DeliverPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    DeliverPage deliverPage = new DeliverPage(driver);

    @Then("^OrderInfo window is displayed$")
    public void orderinfoWindowIsDisplayed() {
        deliverPage.waitForOrderInfoWindowDisplayed();
    }

    @When("^user select \"([^\"]*)\" option$")
    public void userSelectOption(String arg0) throws Throwable {
        deliverPage.selectDeliveryOption(arg0);
    }

    @And("^user click save button on orderInfo window$")
    public void userClickSaveButtonOnOrderInfoWindow() {
        deliverPage.clickSaveButton();
    }

    @Then("^date and time picker is displayed$")
    public void dateAndTimePickerIsDisplayed() {
        deliverPage.waitForDateTimePickerDisplayed();
    }

    @When("^user change date picker to enable save$")
    public void userChangeDatePickerToEnableSave() throws InterruptedException {
        deliverPage.changeDatePickerToEnableSave();
    }

    @And("^user select (\\d+) hour option on delivery window$")
    public void userSelectHourOptionOnDeliveryWindow(int hour) {
        deliverPage.selectHourOption(hour);
    }
}

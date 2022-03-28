package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.DeliverPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
    public void userClickSaveButtonOnOrderInfoWindow() throws InterruptedException {
        deliverPage.clickSaveButton();
    }

    @Then("^user change date picker on order info screen$")
    public void userChangeDatePickerinOrderInfoScreen() throws InterruptedException {
        deliverPage.changeDatePickerInOrderInfoScreen();
    }

    @Then("^\"Current reserved time\" text is displayed on the order info screen$")
    public void currentReservedTimeIsDisplayed() {
        deliverPage.waitForCurrentReservedTimeIsDisplayed();
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


    @And("user clicks on the shipping option for the following day")
    public void userClicksOnTheShippingOptionForTheFollowingDay() throws InterruptedException {
        deliverPage.dayNextToTodayCTA();

    }

    @And("user clicks on the shipping option for the following day without payment selection")
    public void userClicksOnTheShippingOptionForTheFollowingDayWithoutPaymentSelection() {
        deliverPage.selectslotonly();
    }
}

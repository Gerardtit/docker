package com.automation.steps;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_OrderInfoPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.util.Random;

public class GG_OrderInfoPageSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_OrderInfoPage gg_orderInfoPage = new GG_OrderInfoPage(driver);

    @Then("^verify delivery address and time slot displayed$")
    public void verifyDeliveryAddressAndTimeSlots() {
        Assert.assertTrue(gg_orderInfoPage.isDeliveryAddressDisplayed() && gg_orderInfoPage.isTimeSlotLabelDisplayed(), "Address/ time slot is not displayed for delivery mode");
    }

    @Then("^verify store address and time slot displayed$")
    public void verifyStoreAddressAndTimeSlots() {
        Assert.assertTrue(gg_orderInfoPage.isStoreAddressDisplayed() && gg_orderInfoPage.isTimeSlotLabelDisplayed(), "Address/ time slot is not displayed for Pickup(DUG) mode");
    }

    @Then("^verify all delivery window options displayed$")
    public void verifyDeliveryWindowOptionsDisplayed() {
        Assert.assertTrue(gg_orderInfoPage.areAllDeliveryWindowOptionsDisplayed(), "Delivery window options not displayed");
    }

    @Then("^verify delivery window info icon displayed$")
    public void verifyDeliveryInfoImageDisplayed() {
        Assert.assertTrue(gg_orderInfoPage.isDeliveryWindowInfoIconDisplayed(), "Delivery window info icon not displayed");
    }

    @Then("^verify save button on order info page is disabled$")
    public void verifySaveDisabled() {
        if (gg_orderInfoPage.isNoSlotsOnPickerWheelDisplayed()) {
            Assert.assertEquals(gg_orderInfoPage.isSaveButtonEnabled(), false, "Save button enabled");
        }
    }

    @Then("^verify save button on order info page is enabled$")
    public void verifySaveEnabled() {
        if (!gg_orderInfoPage.isNoSlotsOnPickerWheelDisplayed()) {
            Assert.assertEquals(gg_orderInfoPage.isSaveButtonEnabled(), true, "Save button disabled");
        }
    }

    @When("^click edit address on order info page$")
    public void clickEditOrderInfo() {
        gg_orderInfoPage.clickEditDeliveryAddress();
    }

    @When("^click edit address on Address Book page$")
    public void clickEditAddressBook() {
        gg_orderInfoPage.clickEditDeliveryAddress();
    }

    @Then("^user enters \"([^\"]*)\" number of digits in delivery instructions field$")
    public void enterDigitsInDeliveryInstruction(String arg0) {
        int min = 1;
        int max = 9;
        Random rand = new Random();
        int randomNum;
        String ins = "";
        for (int i = 0; i < Integer.valueOf(arg0); i++) {
            randomNum = rand.nextInt((max - min) + 1) + min;
            ins = ins + randomNum;
        }
        gg_orderInfoPage.enterDeliveryInstructions(ins);
    }

    @Then("^verify Enter Valid Instructions warning displayed")
    public void verifyEnterValidInstructionsWarningDisplayed() {
        Assert.assertEquals(gg_orderInfoPage.isEnterValidInstructionsWarningDisplayed(), true, "Enter Valid Instructions warning is not displayed");
    }

    @When("^user enters address on order info page$")
    public void enterAddress() throws IOException {
        String addressLine1 = ThreadLocalHelper.testCaseData.get().get("ADDRESS_LINE_1");
        String addressLine2 = ThreadLocalHelper.testCaseData.get().get("ADDRESS_LINE_2");
        gg_orderInfoPage.enterAddressLine1(addressLine1);
        gg_orderInfoPage.enterAddressLine2(addressLine2);
    }

    @Then("^verify Order Info page displayed")
    public void verifyOrderInfoPageDisplayed() {
        Assert.assertEquals(gg_orderInfoPage.isOrderInfoPageDisplayed(), true, "Order info page is not displayed");
    }

    @When("^click save button on Edit Delivery Address page$")
    public void clickSave() {
        gg_orderInfoPage.clickSaveButton();
    }

    @When("^click back button to go to Checkout page")
    public void clickBack() {
        gg_orderInfoPage.clickBackButton();
    }

    @When("^click back button on order info page")
    public void clickBackButtonOnOrderInfoPage() {
        gg_orderInfoPage.clickOnCancelButton();
    }

    @When("^handle alert pop up")
    public void handleSelectDeliveryPopUp() {
        gg_orderInfoPage.handleAlertPopUp();
    }


    @Then("user validates  orderdate is displayed")
    public void userValidatesOrderdateIsDisplayed() {
        gg_orderInfoPage.orderdate();
    }

    @Then("user validates ordernumber is displayed")
    public void userValidatesOrdernumberIsDisplayed() {
        gg_orderInfoPage.ordernumber();
    }

    @Then("user validates order total is displayed")
    public void userValidatesOrderTotalIsDisplayed() {
        gg_orderInfoPage.orderTotal();
    }
}

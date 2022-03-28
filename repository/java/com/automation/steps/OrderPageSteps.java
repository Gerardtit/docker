package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.OrderPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;

public class OrderPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    OrderPage orderPage = new OrderPage(driver);

    @Then("^order page is displayed$")
    public void orderPageIsDisplayed() {
        orderPage.waitForPageDisplayed();
    }

    @When("^user click cancel order on order page$")
    public void userClickCancelOrderOnOrderPage() {
        orderPage.clickCancelOrder();
    }

    @And("^user wait for cancel order pop up window$")
    public void userWaitForCancelOrderPopUpWindow() {
        orderPage.waitForCancelOrderPopUp();
    }

    @And("^user click cancel order button from pop up$")
    public void userClickCancelOrderButtonFromPopUp() {
        orderPage.clickCancelOrderConfirmation();
    }

    @Then("^verify no pending order is not presented$")
    public void verifyNoPendingOrderIsNotPresented() throws InterruptedException {
        Assert.assertTrue(orderPage.verifyNoPendingOrderDisplayed());
    }

    @When("^user click back button on order page$")
    public void userClickBackButtonOnOrderPage() {
        orderPage.clickBackButtonToMenuPage();
    }

    @Then("^past orders list is displayed on the order page$")
    public void pastOrdersListIsDisplayedOnTheOrderPage() {
        orderPage.waitForPastOrderList();
    }
}

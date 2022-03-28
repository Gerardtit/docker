package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_OrderStatusPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GG_OrderStatusSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_OrderStatusPage orderStatus = new GG_OrderStatusPage(driver);

    @Then("^verify pickup order status is displayed$")
    public void verifyPickupOrderStatusIsDisplayed() {
        Assert.assertTrue(orderStatus.isPickupOrderStatusDisplayed());
    }

    @Then("^verify pickup order first status is displayed$")
    public void verifyPickupOrderFirstStatusIsDisplayed() {
        Assert.assertTrue(orderStatus.isPickupOrderFirstStatusDisplayed(), "Pick up order first status is not displayed");
    }

    @Then("^verify change order link text on order status$")
    public void verifyChangeOrderLinkTextOnOrderStatus() {
        Assert.assertTrue(orderStatus.isChangeOrderLinkTextDisplayed());
    }

    @When("^click change order link on order status$")
    public void clickChangeOrderLinkOnOrderStatus() {
        orderStatus.clickChangeOrderLinkOnOrderStatus();
    }

    @Then("^edit order screen is displayed$")
    public void editOrderScreenIsDisplayed() {
        Assert.assertTrue(orderStatus.isEditOrderScreenDisplayed());
    }

    @When("^click view details on order status$")
    public void clickViewDetailsOnOrderStatus() {
        orderStatus.clickViewDetailsOnOrderStatus();
    }

    @Then("^verify order placed status icon highlited$")
    public void verifyOrderPlacedStatusIconHighlited() {
        Assert.assertTrue(orderStatus.isOrderPlacedStatusIconHighlited());
    }

    @Then("^verify order packed status icon not highlited$")
    public void verifyOrderPackedStatusIconNotHighlited() {
        Assert.assertTrue(orderStatus.isOrderPackedStatusIconNotHighlited());
    }

    @Then("^verify order on the way status icon not highlited$")
    public void verifyOrderOnTheWayStatusIconNotHighlited() {
        Assert.assertTrue(orderStatus.isOrderOnTheWayStatusIconNotHighlited());
    }

    @Then("^verify order delivered status icon not highlited$")
    public void verifyOrderDeliveredStatusIconNotHighlited() {
        Assert.assertTrue(orderStatus.isOrderDeliveredStatusIconNotHighlited());
    }

    @Then("^verify delivery order status is displayed$")
    public void verifyDeliveryOrderStatusIsDisplayed() {
        Assert.assertTrue(orderStatus.isDeliveryOrderStatusDisplayed());
    }

    @Then("^verify delivery order first status is displayed$")
    public void verifyDeliveryOrderFirstStatusIsDisplayed() {
        Assert.assertTrue(orderStatus.isDeliveryOrderFirstStatusDisplayed());
    }

    @Then("^verify order number on order status$")
    public void verifyOrderNumberOnOrderStatus() {
        Assert.assertTrue(orderStatus.isOrderNumberDisplayed());
    }

    @Then("^verify pickup order status is not displayed$")
    public void verifyPickupOrderStatusIsNotDisplayed() {
        Assert.assertTrue(orderStatus.isPickupOrderStatusNotDisplayed());
    }

    @Then("^verify pickup order second status is displayed$")
    public void verifyPickupOrderSecondStatusIsDisplayed() {
        Assert.assertTrue(orderStatus.isPickupOrderSecondStatusDisplayed(), "Pick up order second status is not displayed");
    }

    @Then("^verify pickup order third status is displayed$")
    public void verifyPickupOrderThirdStatusIsDisplayed() {
        Assert.assertTrue(orderStatus.isPickupOrderThirdStatusDisplayed(), "Pick up order third status is not displayed");
    }

    @Then("^verify pickup order fourth status is displayed$")
    public void verifyPickupOrderFourthStatusIsDisplayed() {
        Assert.assertTrue(orderStatus.isPickupOrderFourthStatusDisplayed(), "Pick up order fourth status is not displayed");
    }

}

package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_DashboardPage;
import com.automation.pages.GG_OrdersPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.IOException;

public class GG_OrdersPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_OrdersPage ordersPage = new GG_OrdersPage(driver);
    private int orderNumber;

    @Then("^verify orders page is displayed$")
    public void verifyOrdersPageDisplayed() {
        Assert.assertTrue(ordersPage.isOrdersPageDisplayed(), "Orders page is not displayed");
    }

    @Then("^verify pending orders displayed$")
    public void verifyPendingOrdersDisplayed() throws InterruptedException {
        Assert.assertTrue(ordersPage.isPendingOrdersDisplayed(), "Pending Order is not displayed");
    }

    @Then("^cancel all pending orders$")
    public void cancelAllOrders() throws InterruptedException {
        ordersPage.cancelAllPendingOrders();
    }

    @And("^cancel latest order$")
    public void cancelLatestOrders() throws InterruptedException {
        ordersPage.cancelLatestOrder();
    }

    @Then("^user don't have pending orders$")
    public void userDonTHavePendingOrders() {
        Assert.assertTrue(ordersPage.isPendingOrdersNotDisplayed(), "Pending Order is displayed");
    }

    @And("^Add address details in order info$")
    public void addAddressDetailsInOrderInfo() throws IOException {
        ordersPage.addAddressDetailsInOrderInfo();
    }

    @And("^select your delivery window$")
    public void selectYourDeliveryWindow() {
        ordersPage.selectYourDeliveryWindow();
    }

    @And("^get order number from order confirmation page$")
    public void getOrderNumber() {
        orderNumber = ordersPage.getOrderNumberFromOrderConfirmationPage();
        //     new GG_DashboardPage(AppiumDriverManager.getDriver()).clickOnCancelButtonFeedbackFormIfDisplayed();
    }

    @And("^cancel order by order number$")
    public void cancelOrder() throws InterruptedException {
        ordersPage.cancelOrderByOrderNumber(orderNumber);
        new GG_DashboardPage(AppiumDriverManager.getDriver()).clickOnCancelButtonFeedbackFormIfDisplayed();
    }

    @And("click on first view details button in orders page")
    public void clickFirstViewDetailsButton() {
        ordersPage.clickFirstViewDetailsButton();
    }

    @And("click on edit order button in orders details page")
    public void clickEditOrderButton() {
        ordersPage.clickEditOrderButton();
    }

    @And("click go back button in orders page")
    public void clickGoBackButtonOrdersPage() {
        ordersPage.clickGoBackButtonOrdersPage();
    }

    @And("click go back button in orders details page")
    public void clickGoBackButtonOrdersDetailsPage() {
        ordersPage.clickGoBackButtonOrdersDetailsPage();
    }

    @Then("^verify placed order displayed in the Order History screen$")
    public void placedOrderNumberIsDisplayed() throws InterruptedException {
        ordersPage.verifyOrderPlacedByOrderNumber();
    }

    @Then("^verify order date displayed in the Order History screen$")
    public void orderDateIsDisplayed() throws InterruptedException {
        //  ordersPage.verifyOrderDateIsDisplayed();
        Assert.assertTrue(ordersPage.isOrderDateDisplayed(), "Orders page is not displayed");

    }

    @Then("verify amount of items equals to {string} in your order screen")
    public void amountItemsInOrder(String amount) {
        Assert.assertEquals(ordersPage.amountItemsInOder(), amount, "Amount of items in cart in order screen is incorrect!");
    }


    @Then("^Verify Map is displayed or not$")
    public void verifyMapIsDisplayed() throws InterruptedException {
        ordersPage.isMapDisplayed();
    }

    @Then("user validates chevron next to order date")
    public void userValidatesChevronNextToOrderDate() {
        ordersPage.chevrondisplayed();
    }

    @Then("chevron is selected")
    public void chevronIsSelected() {
        ordersPage.chvronselected();
    }

    @Then("The order details are displayed")
    public void theOrderDetailsAreDisplayed() {
        ordersPage.orderdisplayed();
    }


    @Then("^verify your orders heading$")
    public void yourOrdersHeading() throws InterruptedException {
        ordersPage.ValidatesYourOrdersHeading();
    }

    @Then("validate view Details to track details")
    public void validateViewDetailstoTrackDetails() {
        ordersPage.trackdetaildisplayed();
    }

    @And("user clicks on view Details to track details chevron")
    public void clickOnViewDetailsTrackDetailsChevron() {
        ordersPage.chvronselected();
    }

    @Then("verify individual order details heading")
    public void verifyOrderDetailsHeading() {
        ordersPage.verifyOrderDetailsHeading();
    }

    @Then("user clicks on item details chevron")
    public void clickOnItemDetailsChevron() {
        ordersPage.clickOnItemDetailsChevron();
    }

    @And("verify item details heading")
    public void verifyItemDetailsHeading() {
        ordersPage.verifyItemDeatailsHeading();
    }

    @Then("verify COA and EBT payment method details")
    public void verifyCOAEBTPaymentMethodDetails() {
        ordersPage.verifyCOAEBTPaymentMethodDetails();
    }

    @Then("verify COA payment method details")
    public void verifyCOAPaymentMethodDetails() {
        ordersPage.verifyCOAPaymentMethodDetails();
    }

    @And("user selects snap EBT payment method")
    public void selectEBTPaymentMethod() {
        ordersPage.selectEBTPaymentMethod();
    }

    @Then("user selects apply credits on account")
    public void selectApplyCreditOnAccount() {
        ordersPage.applyCreditOnAccount();
    }

    @Then("user selects apply credits on account for whole amount")
    public void selectApplyCreditOnAccountWholeAmount() {
        ordersPage.applyCreditOnAccountWholeAmount();
    }

    @Then("user clicks on continue to review order")
    public void clicksOnCotinueToReviewOrder() {
        ordersPage.continuereviewOrder();
    }


}

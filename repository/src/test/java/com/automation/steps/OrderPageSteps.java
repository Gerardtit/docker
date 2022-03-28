package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.OrderPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

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


    @When("^user click on Edit Order$")
    public void userClickOnEditOrder() {
        orderPage.clickEditOrder();
    }


    @Then("^current orders text is displayed on the order page$")
    public void currentOrdersTextIsDisplayedOnTheOrderPage() {
        orderPage.waitForCurrentOrderText();
    }

    @Then("^past orders text is displayed on the order page$")
    public void pastOrdersTextIsDisplayedOnTheOrderPage() {
        orderPage.waitForPastOrderText();
    }

    @Then("^need help text is displayed on the order page$")
    public void needhelpTextIsDisplayedOnTheOrderPage() {
        orderPage.waitForNeedHelpText();
    }

    @And("^user scroll down to order history$")
    public void userScrollDownToOrderHistory() {
        orderPage.scrollDownToOrderHistory();
    }

    @And("^user clicks back button on edit order page$")
    public void backButtonOnEditOrdersPage() {
        orderPage.clickBackButtonOnEditOrderPage();
    }

    @And("^user click on contact info tile$")
    public void contactInfoTile() {
        orderPage.clickContactInfoTileOnEditOrderPage();
    }

    @And("^user clicks back button on edit cart page$")
    public void backButtonOnEditCartPage() {
        orderPage.clickBackButtonOnEditCartPage();
    }

    @And("^user verify cancel changes popup is displayed$")
    public void verifyCancelChangesPopup() {
        orderPage.verifyCancelChangesPopup();
    }


    @And("^user edits and enters \"([^\"]*)\" as phone number$")
    public void userEditAndEntersPhoneNumber(String phoneNumber) {
        orderPage.editAndEnterPhoneNumberInContactInfoPage(phoneNumber);
    }

    @And("^user adds \"([^\"]*)\" promo code and apply$")
    public void enterPromoCodeAndApply(String promoCode) {
        orderPage.addPromoCodeAndApplyInEditOrderPage(promoCode);
    }

    @And("^user clicks on Discard Changes in the popup$")
    public void clickOnDiscardChangesButtonOnPopup() {
        orderPage.clickOnDiscardChangesButton();
    }

    //    @And("^user verify popup is not displayed$")
//    public boolean verifyPopupIsNotDisplayed()
//        {
//            Assert.assertFalse(pageElements.cancelChangesHeaderPopup(), "Popup is displayed");
//        }
    @And("^user clicks on view order details in your orders page$")
    public void clickOnViewDetialsOrTrackOrder() {
        orderPage.clickOnViewDetialsOrTrackOrder();

    }

    @And("^user clicks on View Details or Track Order section in Order history page for Delivery")
    public void userClicksOnViewDetialsOrTrackOrderSection_Delivery() {
        orderPage.clickOnViewDetailsOrTrackOrderSection_Delivery();

    }

    @And("^user clicks on View Details or Track Order section in Order history page for DUG$")
    public void userClicksOnViewDetialsOrTrackOrderSection_DUG() {
        orderPage.clickOnViewDetailsOrTrackOrderSection_DUG();

    }

    @And("^user clicks Edit order in order details page$")
    public void clickOnEditOrderInYourOrderDetailsPage() {
        orderPage.clickOnEditOrderInYourOrderDetailsPage();
    }

    @And("^user clicks Save changes button in Edit your order page$")
    public void clickOnSaveChangesInEditYourOrderPage() {
        orderPage.clickOnSaveChangesInEditYourOrderPage();
    }

    @And("^user clicks Edit order in edit order confirmation page$")
    public void clickOnEditOrderInOrderConfirmationPage() {
        orderPage.clickOnEditOrderInOrderConfirmationPage();
    }

    @And("^user clicks on Continue shopping in order confirmation page$")
    public void clickOnContinueShoppingInOrderConfirmationPage() {
        orderPage.clickOnContinueShoppingInOrderConfirmationPage();
    }

    @And("^user lands on home page$")
    public void verifySearchProductsOrDeals() {
        orderPage.displaySearchProductsOrDeals();
    }

    @And("^verify Map is not displayed$")
    public void verifyMapNotDisplayed() {
        Assert.assertFalse(orderPage.isMapDisplayed());

    }

    @Then("^verify Order history page is displayed$")
    public void orderHistoryPageIsDisplayed() {
        // orderPage.waitForPageDisplayed();
        orderPage.waitForOrderHitstoryPageDisplayed();
        //  orderPage.containTextDisplayed("Your order");
    }

    @When("^user click on View Details or Track Order section to go to Order Details screen$")
    public void clickViewDetailsorTrackOrderSection() {

        orderPage.clickOnViewDetialsOrTrackOrder();
    }

    @Then("^verify Order details page is displayed$")
    public void orderDetailsPageIsDisplayed() {
        // orderPage.waitForPageDisplayed();
        orderPage.waitForOrderDetailsPageDisplayed();
        //  orderPage.containTextDisplayed("Your order");
    }

    @When("^click on the back arrow from top left in the Order Details screen$")
    public void navigateBackToOrderHistoryPage() {
        // orderPage.waitForPageDisplayed();
        driver.navigate().back();
        //  orderPage.containTextDisplayed("Your order");
    }

    @Then("^Verify status bar and the order status message and sub message displayed in Order Details screen$")
    public void orderHistoryPageStatusBarDetails() {
        orderPage.orderHistoryPageStatusBarDetails();

    }


}

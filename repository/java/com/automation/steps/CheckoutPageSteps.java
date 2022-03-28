package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.CheckoutPage;
import com.automation.pages.OrderPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckoutPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public AppiumDevice device = AppiumDeviceManager.getDevice();
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    OrderPage orderPage = new OrderPage(driver);

    @Then("^checkout page is displayed$")
    public void checkoutPageIsDisplayed() {
        checkoutPage.waitForCheckoutPageDisplayed();
    }

    @When("^user clicks OrderInfo on checkout page$")
    public void userClicksOrderInfoOnCheckoutPage() {
        checkoutPage.clickOrderInfo();
    }

    @When("^user clicks payment on checkout page$")
    public void userClicksPaymentOnCheckoutPage() {
        checkoutPage.clickPayment();
    }

    @Then("^order confirmation page is displayed$")
    public void orderConfirmationPageIsDisplayed() {
        checkoutPage.waitForConfirmationPageDisplayed();

    }

    @And("^place order button is clickable and click place order$")
    public void placeOrderButtonIsClickableAndClickPlaceOrder() {
        checkoutPage.waitForPlaceOrderButtonEnabled();
    }

    @When("^user clicks Done button$")
    public void userClicksDoneOrderConfirmationButton() {
        checkoutPage.clickDoneConfirmationButton();
    }

    @When("^user clicks promo code on checkout page$")
    public void userClicksPromoCodeOnCheckoutPage() {
        checkoutPage.clickPromoCode();
    }

    @Then("^promo code deals window is dislayed$")
    public void promoCodeDealsWindowIsDislayed() {
        checkoutPage.waitForPromoCodeWindow();
    }

    @When("^user enters promo code \"([^\"]*)\" and click next$")
    public void userEntersPromoCodeAndClickNext(String arg0) throws Throwable {
        checkoutPage.enterPromoCode(arg0);
    }

    @Then("^Applied is displayed on page$")
    public void appliedIsDisplayedOnPage() {
        checkoutPage.waitForPromoCodeApplied();
    }

    @When("^user select back button to checkout page$")
    public void userSelectBackButtonToCheckoutPage() {
        checkoutPage.clickBackButtonFromPromoCode();
    }


    @And("^\"([^\"]*)\" text is displayed on the screen$")
    public void textIsDisplayedOnTheScreen(String arg0) throws InterruptedException {
        //orderPage.waitForPageDisplayed();
        Thread.sleep(3000);
        Assert.assertTrue(checkoutPage.containTextDisplayed(arg0));
    }

    @When("^user enters \"([^\"]*)\" in phone number field on Contact window$")
    public void userEntersInPhoneNumberFieldOnContactWindow(String phoneNumber) {
        if (phoneNumber.equalsIgnoreCase("random")) {
            String areaCode = String.valueOf((int) (Math.random() * 7 + 2)) +
                    new SimpleDateFormat("DD").format(new Date());
            String phoneCode = String.valueOf((int) (Math.random() * 8 + 1)) +
                    new SimpleDateFormat("HHmmss").format(new Date());
            checkoutPage.enterPhoneNumber(areaCode + phoneCode);
        } else {
            checkoutPage.enterPhoneNumber(phoneNumber);
        }
    }

    @When("^user clear promo code from checkout page$")
    public void userClearPromoCodeFromCheckoutPage() {
        checkoutPage.clearPromoCode();
    }

    @And("^\"([^\"]*)\" text is displayed on the screen for California banner$")
    public void textIsDisplayedOnTheScreenForCaliforniaBanner(String arg0) throws Throwable {
        String banner = device.getBanner();
        if (banner.equalsIgnoreCase("vons")
                || banner.equalsIgnoreCase("safeway")
                || banner.equalsIgnoreCase("pavilions")) {
            checkoutPage.containTextDisplayed(arg0);
        }
    }

    @When("^scroll down the screen$")
    public void scrollDownTheScreen() {
        checkoutPage.scrollDown();
    }

    @When("^user scroll down to total summary$")
    public void userScrollDownToTotalSummary() {
        checkoutPage.scrollDownToTotalSummary();
    }
}

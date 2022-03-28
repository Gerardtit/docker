package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.OrderCheckoutDisclaimerInfoPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LMT_OrderCheckoutDisclaimerInfoSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public OrderCheckoutDisclaimerInfoPage orderCheckoutDisclaimerInfoPage = new OrderCheckoutDisclaimerInfoPage(driver);

    @Given("user click on contact info button")
    public void user_click_on_contact_info_button() throws InterruptedException {
        orderCheckoutDisclaimerInfoPage.backToOrderPageFromAddress();
        orderCheckoutDisclaimerInfoPage.clickOnContactInfoButton();
        orderCheckoutDisclaimerInfoPage.enterContactInfo("Aaa", "Bbb", "9294241166");
    }

    @Given("SMS alerts toggle is on content info screen")
    public void sms_alerts_toggle_is_on_content_info_screen() throws InterruptedException {
        orderCheckoutDisclaimerInfoPage.clickTextMeOrderInfoUpdateOnButton();
    }

    @Given("SMS alerts toggle is off content info screen")
    public void sms_alerts_toggle_is_off_content_info_screen() throws InterruptedException {
        orderCheckoutDisclaimerInfoPage.clickTextMeOrderInfoUpdateOffButton();
    }

    @When("user comes to Checkout landing screen")
    public void user_comes_to_checkout_landing_screen() throws InterruptedException {
        orderCheckoutDisclaimerInfoPage.verifyLandedYourOrderPage();
    }

    @Then("user sees an inline message within Content info box if enable")
    public void user_sees_an_inline_message_within_content_info_box_if_enable() throws InterruptedException {
        orderCheckoutDisclaimerInfoPage.verifyTextMeMyOrderStatus();

    }

    @Then("user sees an inline message within Content info box if not enable")
    public void user_sees_an_inline_message_within_content_info_box_if_not_enable() throws InterruptedException {
        orderCheckoutDisclaimerInfoPage.verifyTurnOnOrderStatusTextMessages();

    }


}

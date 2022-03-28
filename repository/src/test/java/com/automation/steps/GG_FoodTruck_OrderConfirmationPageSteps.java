package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_FoodTruck_OrderConfirmationPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GG_FoodTruck_OrderConfirmationPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_FoodTruck_OrderConfirmationPage gg_foodTruck_orderConfirmationPage = new GG_FoodTruck_OrderConfirmationPage(driver);

    @Then("^verify order confirmation screen appears$")
    public void verify_order_confirmation_screen_appears() {
        gg_foodTruck_orderConfirmationPage.verifyOrderConfirmationPage();
    }

    @When("^user clicks back button on order confirmation page$")
    public void user_clicks_back_button_on_order_confirmation_page() {
        gg_foodTruck_orderConfirmationPage.clickBackButton();
    }
}

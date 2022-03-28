package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_FoodTruck_ReviewOrderPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class GG_FoodTruck_ReviewOrderPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_FoodTruck_ReviewOrderPage gg_foodTruck_reviewOrderPage = new GG_FoodTruck_ReviewOrderPage(driver);

    @Then("^Review Order page appears$")
    public void review_order_page_appears() {
        gg_foodTruck_reviewOrderPage.verifyReviewOrderPage();
    }

    @And("^verify quantity stepper, Tip section, Add section, Pickup Time, Subtotal, all fees, order total, add a coupon, another item cta and Checkout cta$")
    public void verify_quantity_stepper_tip_section_add_section_pickup_time_subtotal_all_fees_order_total_add_a_coupon_another_item_cta_and_checkout_cta() throws Throwable {
        gg_foodTruck_reviewOrderPage.verifyQuantityStepper();
        gg_foodTruck_reviewOrderPage.verifyTipSection();
        //gg_foodTruck_reviewOrderPage.verifyAddSection();
        gg_foodTruck_reviewOrderPage.verifyPickupTimeSection();
        gg_foodTruck_reviewOrderPage.verifySubtotalField();
        gg_foodTruck_reviewOrderPage.verifyAllFees();
        gg_foodTruck_reviewOrderPage.verifyOrderTotal();
        gg_foodTruck_reviewOrderPage.verifyAddCouponLink();
        gg_foodTruck_reviewOrderPage.verifyAnotherItemCTA();
        gg_foodTruck_reviewOrderPage.verifyCheckoutCTA();
    }

    @And("^verify once tip and pickup time is selected only user can checkout$")
    public void verify_once_tip_and_pickup_time_is_selected_only_user_can_checkout() {
        gg_foodTruck_reviewOrderPage.verifyCheckoutCTAIsEnabledIfTipAndPickupTimeSelected();
    }

}

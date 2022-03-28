package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_FoodTruck_LandingPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GG_FoodTruck_LandingPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_FoodTruck_LandingPage gg_foodTruck_landingPage = new GG_FoodTruck_LandingPage(driver);


    @Then("^verify store address with zipcode \"([^\"]*)\" is displayed on food lot landing page$")
    public void verifyStoreAddressOnLandingPage(String storeAddress) throws InterruptedException {
        gg_foodTruck_landingPage.verifyStoreAddress(storeAddress);
    }

    @Then("Then Friday food truck landing page appears")
    public void verifyFoodTruckLandingPageDisplayed() {
        gg_foodTruck_landingPage.verifyLandingPageDisplayed();
    }

    @And("verify user can see subscribe cta link")
    public void verifySubscribeCTAAppears() {
        gg_foodTruck_landingPage.verifySubscribeCTALink();
    }

    @When("user clicks on Subscribe CTA link")
    public void userClicksSubscribeCTALink() {
        gg_foodTruck_landingPage.clickSubscribeCTALink();
    }

    @Then("verify user should be subscribed to receive vendor menus")
    public void verifyUserIsSubscribed() throws InterruptedException {
        gg_foodTruck_landingPage.verifyUserIsSubscribed();
    }

    @Then("verify add to cart cta and product description appears")
    public void verifyAddToCartCTAAndProductDescriptionAppears() {
        gg_foodTruck_landingPage.verifyAddToCartLink();
        gg_foodTruck_landingPage.verifyProductDescription();
    }

    @When("^user clicks add to cart CTA on foodlot landing page$")
    public void user_clicks_add_to_cart_cta_on_foodlot_landing_page() {
        gg_foodTruck_landingPage.clickAddToCartCTA();
    }

    @Then("^verify predrawer screen appears$")
    public void verify_predrawer_screen_appears() {
        gg_foodTruck_landingPage.verifyPreDrawerScreen();
    }

    @And("^verify quantity stepper, special instruction note and preorder add to cart CTA$")
    public void verify_quantity_stepper_special_instruction_note_and_preorder_add_to_cart_cta() {
        gg_foodTruck_landingPage.verifyQuantityStepper();
        gg_foodTruck_landingPage.verifySpecialInstructionsNote();
        gg_foodTruck_landingPage.verifyPreOrderAddToCartCTA();
    }

    @When("^user clicks preorder add to cart CTA link$")
    public void user_clicks_preorder_add_to_cart_cta_link() {
        gg_foodTruck_landingPage.clickPreOrderAddToCartCTA();
    }

    @Then("^verify order now drawer screen appears$")
    public void verify_order_now_drawer_screen_appears() {
        gg_foodTruck_landingPage.verifyOrderNowDrawerScreen();
    }

    @When("^user clicks order now CTA link$")
    public void user_clicks_order_now_cta_link() {
        gg_foodTruck_landingPage.clickOrderNowCTA();
    }
}

package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.Deals_AllCouponsPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Deals_AllCouponsPageSteps {
    AppiumDriver driver = AppiumDriverManager.getDriver();
    public Deals_AllCouponsPage dealsPage = new Deals_AllCouponsPage(driver);

    @When("^user clicks Deals on home page$")
    public void userClicksDealsOnHomePage() {
        dealsPage.clickDealsTab();
    }

    @When("^user clicks All coupons in deals page$")
    public void user_clicks_All_coupons_in_deals_page() throws Throwable {
        dealsPage.clickAllCouponsTab();
    }

    @Then("^user should see all the coupons$")
    public void user_should_see_all_the_coupons() throws Throwable {
        dealsPage.clippingCouponsDisplayed();
        Thread.sleep(3000);
    }

    @When("^user tap on clip then user should see View Products$")
    public void user_tap_on_clip() throws Throwable {
        dealsPage.ProductClips();
    }

    @When("^user clips products$")
    public void user_clips_products() throws Throwable {
        dealsPage.clipProducts();
    }

    @Then("^user should see all the coupons clipped from deals page$")
    public void user_should_see_all_the_coupons_clipped_from_deals_page() throws Throwable {
        dealsPage.clickClippedDeals();
    }

    @Then("^user clicks back button on wallet page$")
    public void user_clicks_back_button_on_wallet_page() throws Throwable {
        dealsPage.navigateBack();
    }

    @Then("^user is able to see Rewards pill in All deals tab$")
    public void user_see_Rewards_pill_in_All_deals_tab() {
        dealsPage.rewardsPillDisplayed();
    }

    @Then("^user is able to see Clipped deals pill in All deals tab$")
    public void user_see_Clipped_deals_pill_in_All_deals_tab() {
        dealsPage.clippedDealsPillDisplayed();
    }

    @Then("^user is able to see Weekly Ad pill in All deals tab$")
    public void user_see_weekly_Ad_pill_in_All_deals_tab() {
        dealsPage.weeklyAdDisplayed();
    }

    @When("^user clicks on Rewards pill$")
    public void user_click_Rewards_pill() {
        dealsPage.clickOnRewardsPill();
    }

    @When("^user clicks on Clipped deals pill$")
    public void user_click_Clipped_deals_pill() {
        dealsPage.clickOnClippedDealsPill();
    }

    @When("^user clicks on Weekly Ad pill$")
    public void user_click_Weekly_Ad_pill() {
        dealsPage.clickWeeklyAdPill();
    }

    @When("user clicks on offer details at clipped deals")
    public void userClicksOnOfferDetailsAtClippedDeals() {
        dealsPage.offerdetails();
    }
}

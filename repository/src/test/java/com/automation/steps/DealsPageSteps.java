package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.DealsPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DealsPageSteps {
    AppiumDriver driver = AppiumDriverManager.getDriver();
    public DealsPage dealsPage = new DealsPage(driver);

    @Then("^deals page is displayed$")
    public void dealsPageIsDisplayed() {
        dealsPage.waitForPageDisplayed();
    }

    @When("^user clicks back button on deals page$")
    public void userClicksBackButtonOnDealsPage() {
        dealsPage.clickBackButton();
    }

    @When("^user clicks Promo Code Deals on deals page$")
    public void userClicksPromoCodeDealsOnDealsPage() {
        dealsPage.clickPromoCode();
    }

    @Then("^promo code deals window is displayed$")
    public void promoCodeDealsWindowIsDisplayed() {
        dealsPage.waitForPromoCodeWindowDisplayed();
    }

    @When("^user clicks Club Card Deals on deals page$")
    public void userClicksClubCardDealsOnDealsPage() {
        dealsPage.clickClubCard();
    }

    @When("^user clicks Buy one get one free on deals page$")
    public void userClicksBuyOneGetOneFreeOnDealsPage() {
        dealsPage.clickBuyOneGetOneFree();
    }

    @Then("^club card deals window is displayed$")
    public void clubCardDealsWindowIsDisplayed() {
        dealsPage.waitForClubCardDealsWindowDisplayed();
    }

    @Then("^buy one get on free window is displayed$")
    public void buyOneGetOnFreeWindowIsDisplayed() {
        dealsPage.waitForBuyOneGetOneFreeDisplayed();
    }


    @When("^user clicks search icon from deals page$")
    public void userClicksSearchIconFromDealsPage() {
        dealsPage.clickSearchIcon();
    }

    @And("^buy one get on free text is displayed on the screen$")
    public void buyOneGetOnFreeTextIsDisplayedOnTheScreen() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            dealsPage.containTextDisplayed("Buy One Get One Free");
        } else {
            dealsPage.containTextDisplayed("Buy One, Get One Free");
        }
    }

    @And("^user clicks Bogo item on deals page$")
    public void userClicksOnDealsPage() throws Throwable {
        dealsPage.clickItemInDealsPage();
    }

    @When("clip a deal on all coupons page")
    public void clipADealOnAllCouponsPage() {
        dealsPage.clipAdeal();
    }

    @When("user clicks All Deals tab")
    public void user_clicks_all_deals_tab() {
        dealsPage.dealstab();
    }

    @When("user click on Coupon Centre Deals Pill")
    public void user_click_on_coupon_centre_deals_pill() {
        dealsPage.clickonCoupon_center_pills();
    }

    @When("user click on New Deals pill")
    public void user_click_on_new_deals_pill() {
        dealsPage.clickonNew_pills();
    }

    @When("user click on Expiring Soon pill")
    public void user_click_on_expiring_soon_pill() {
        dealsPage.clickonExpiring_soon_deals_pills();

    }

    @When("user clicks search bar on deals page")
    public void user_clicks_search_bar_on_deals_page() {
        dealsPage.clickDealsSearchBar();
    }

    @When("^user types \"([^\"]*)\" on search bar and click search on deals page$")
    public void user_types_on_search_bar_and_click_search_on_deals_page(String arg0) throws Throwable {
        dealsPage.enterSearchItemondeals(arg0);
    }

    @Then("user click cancel button")
    public void user_click_cancel_button() {
        dealsPage.cancelatdeals();
    }

    @Then("verify the total deals count is displayed")
    public void verify_the_total_deals_count_is_displayed() {
        dealsPage.dealscount();
    }

    @Then("^user click on item you may like see all$")
    public void user_click_on_item_you_may_like_see_all() throws Throwable {
        dealsPage.dealsItemsyoumaylike();

    }

    @When("clip a deal on exprirng soon")
    public void clipADealOnExprirngSoon() {
        dealsPage.expringdeals();
    }

    @Then("click on Added button")
    public void clickOnAddedButton() {
        dealsPage.addeddeal();
    }


}


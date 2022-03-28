package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pageElements.HomePageElements;
import com.automation.pages.HaloNavCarouselPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LMT_HaloNavSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public HaloNavCarouselPage haloNavCarouselPage = new HaloNavCarouselPage(driver);
    public HomePageElements homePageElements = new HomePageElements();


    @Then("HaloNav carousel section is displayed")
    public void halo_nav_carousel_section_is_displayed() {
        haloNavCarouselPage.validateHaloNavCarousel();

    }


    // Following 2 methods for Scenario: Scrolling down on the Home page, HaloNav carousel is not sticky or not displayed
    @When("scroll down to the weekly ads coupon section")
    public void scrollDownToTheWeeklyAdsCouponSection() throws InterruptedException {
        haloNavCarouselPage.scrollDownOnHomePage();

    }

    @Then("the Search bar and cart section remain sticky or displayed at the top of the screen")
    public void only_the_search_bar_and_cart_section_remain_sticky_or_displayed_at_the_top_of_the_screen() {
        org.junit.Assert.assertEquals(haloNavCarouselPage.isSearchProductDisplayed(), true);
        org.junit.Assert.assertEquals(haloNavCarouselPage.isCartIconDisplayed(), true);

    }

    @And("HaloNav Carousel section is not in view")
    public void HaloNavCarouselSectionIsNotInView() {
        haloNavCarouselPage.validateHaloNavCarouselNotDisplayed();
    }


    @When("user clicks on {string}")
    public void user_clicks_on(String string) {
        haloNavCarouselPage.haloNavOptions(string);

    }

    @Then("user is landed on {string} page")
    public void user_is_landed_on_page(String string) {
        haloNavCarouselPage.validateHaloNavInteractions(string);

    }

    @Then("user sees the {string}")
    public void user_sees_the(String string) {
        haloNavCarouselPage.validateCarouselPages(string);

    }

    @When("user clicks on Pharmacy back button")
    public void user_clicks_on_pharmacy_back_button() {
        haloNavCarouselPage.pharmacyNavigationBack();
    }

    @Then("user validates {string}, {string}, {string}, {string}, and {string}")
    public void userValidatesAnd(String arg0, String arg1, String arg2, String arg3, String arg4) {
        haloNavCarouselPage.validateStaticHaloNavGuest(arg0, arg1, arg2, arg3, arg4);
    }
}

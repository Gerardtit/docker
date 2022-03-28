package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.BrowsePage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class BrowsePageSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    BrowsePage browsePage = new BrowsePage(driver);
    /*@And("^verify Meals made easy AEM zone is present$")
    public void verify_meals_made_easy_aem_zone_is_present()  {
        aemZonesPage.VerifyMediumBanner("Meals Made Easy");

    }*/

    @Then("^user tabs on SHOP$")
    public void user_tabs_on_shop() throws Throwable {
        browsePage.clickonSHOPTabofHomePage();
    }

    @And("^scroll down for CTA Label$")
    public void scroll_down_for_cta_label() {
        browsePage.scrollDowntillCTAlabel();
    }

    @Then("^Verify Carousel Title is present for any zone Carousel$")
    public void verify_carousel_title_is_present_for_any_zone_carousel() {
        browsePage.verifyElementCarouselTitle();
    }

    @And("^user tabs on CTA Label of Browse for any zone Carousel$")
    public void user_tabs_on_cta_label_of_browse_for_any_zone_carousel() {
        browsePage.clickElementCTALabel();
    }

    @Then("^Verify User see sheet UI page of product Collection$")
    public void verify_user_see_sheet_ui_page_of_product_collection() {
        browsePage.verifysheetUIPage();
    }

    @Then("^Close the sheet UI page$")
    public void close_the_sheet_ui_page() {
        browsePage.closeSheetUIPage();
    }

    @Then("^Verify there is no infinity loader in browse tab$")
    public void verify_there_is_no_infinity_loader_in_browse_tab() {

        browsePage.scrollDownandUpinPage();

    }

    @Then("^Verify there is no infinity loader in home tab$")
    public void verify_there_is_no_infinity_loader_in_home_tab() {
        browsePage.scrollDownandUpinPage();
    }

    @When("user clicks on {string} featured section")
    public void userClicksFeaturedItemOnAislesTab(String arg0) {
        browsePage.userClicksFeaturedItemOnAislesTab(arg0);
    }

    @Then("scroll down for {string} featured section")
    public void scrollDownForFeaturedSection(String arg0) {
        browsePage.scrollDownForFeaturedSection(arg0);
    }

    @Then("verify user lands on {string} featured section page")
    public void verifyUserLandsOnFeaturedSectionPage(String arg0) {
        browsePage.verifyUserLandsOnFeaturedSectionPage(arg0);
    }
}

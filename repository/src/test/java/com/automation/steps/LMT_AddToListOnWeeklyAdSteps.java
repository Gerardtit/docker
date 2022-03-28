package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.AddToListOnWeeklyAdPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LMT_AddToListOnWeeklyAdSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public AddToListOnWeeklyAdPage addToListOnWeeklyAd = new AddToListOnWeeklyAdPage(driver);

    @Given("user is on the weekly ad card via PDF")
    public void user_is_on_the_weekly_ad_card_via_pdf() {
        addToListOnWeeklyAd.clickOnViewWeeklyAdButton();
    }

    @Given("user click on any AD")
    public void user_click_on_any_ad() throws InterruptedException {
        Thread.sleep(5000);
        addToListOnWeeklyAd.clickOnAnyAd();
        Thread.sleep(5000);
    }

    @When("user has added this ad to the list")
    public void user_has_added_this_ad_to_the_list() throws InterruptedException {
        addToListOnWeeklyAd.clickOnAdToList();
        Thread.sleep(5000);
    }

    @Then("CTA on the card is changed to {string} from Add to List")
    public void cta_on_the_card_is_changed_to_from(String string) throws InterruptedException {
        addToListOnWeeklyAd.validateRemoveFromList(string);
        Thread.sleep(5000);
    }

    @Then("verify ad is added to List under My List page")
    public void verify_ad_is_added_to_List_under_My_List_page() throws InterruptedException {
        addToListOnWeeklyAd.validateAdIsAddedToListUnderMyListPage();
    }

    @Then("verify validity date present on the third row in added my list item")
    public void verifyValidityDatePresentOnTheThirdRowInAddedMyListItem() throws InterruptedException {
        addToListOnWeeklyAd.validateValidityDateMyListPage();
    }

    @Then("user click on any first AD banner")
    public void userClickOnAnyFirstAdBanner() {
        addToListOnWeeklyAd.userClickOnAnyFirstAdBanner();
    }

    @Then("user choose first item of banner")
    public void userChooseFirstItemOfBanner() {
        addToListOnWeeklyAd.userChooseFirstItemOfBanner();
    }

    @When("user has added this item to the list")
    public void userHasAddedThisItemtoTheList() {
        addToListOnWeeklyAd.userHasAddedThisItemtoTheList();
    }

    @Then("^verify user is on the weekly ads page$")
    public void verify_user_is_on_the_weekly_ads_page() {
        addToListOnWeeklyAd.verifyWeeklyAdsPage();
    }

    /*@Then("Flyer preview should be displayed")
    public void flyer_preview_should_be_displayed() {
        addToListOnWeeklyAd.validateFlyerPreview();
    }

    @When("user click on Flyer detail view")
    public void user_click_on_flyer_detail_view() {
        addToListOnWeeklyAd.clickOnFlyerDetailView();
    }

    @When("user clicks on any offer")
    public void user_clicks_on_any_offer() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("offer details should be displayed")
    public void offer_details_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("user validates offer details and disclaimer section")
    public void user_validates_offer_details_and_disclaimer_section() {
        addToListOnWeeklyAd.validateOfferDetailsDisclaimerSection();
    }

    @Then("user validates weekly ad header and date")
    public void user_validates_weekly_ad_header_and_date() {
        addToListOnWeeklyAd.validateWeeklyAdHeaderAndDate();
    }

    @When("user clicks on an offer")
    public void user_clicks_on__offer() {
        addToListOnWeeklyAd.clickOnOffer();
    }
    @When("user clicks on scroll view")
    public void user_clicks_on_scroll_view() {
        addToListOnWeeklyAd.clickOnScrollView();
    }
    @When("user clicks on Meat and Seafood from Menu")
    public void user_clicks_on_meat_seafood_from_menu() {
        addToListOnWeeklyAd.clickOMenuItemMeatAndSeaFood();
    }

    @Then("user click on close offer details screen")
    public void user_clicks_close_offer_details_screen() {
        addToListOnWeeklyAd.clickOnCloseOfferDetailsScreen();
    }

    @Then("individual weekly offer details should be displayed")
    public void individual_offer_details_should_be_displayed() {
        addToListOnWeeklyAd.validatingIndividualWeeklyOfferDetails();
    }

    @Then("^verify user is on the weekly ads page$")
    public void verify_user_is_on_the_weekly_ads_page() {
        addToListOnWeeklyAd.verifyWeeklyAdsPage();
    }

    @And("^user click on any first AD banner$")
    public void user_click_on_any_first_ad_banner() {
        addToListOnWeeklyAd.clickOnFirstAdBanner();
    }

    @And("^user choose first item of banner$")
    public void user_choose_first_item_of_banner() {
        addToListOnWeeklyAd.chooseFirstItemFromBanner();
    }

    @When("^user has added this item to the list$")
    public void user_has_added_this_item_to_the_list() {
        addToListOnWeeklyAd.addItemToList();
    }

    @Then("CTA on the card is changed to Add to list")
    public void cta_on_the_card_is_changed_to_add_to_list() {
        addToListOnWeeklyAd.validateAddToList();
    }

    @When("^user has removed this item from the list$")
    public void user_has_removed_this_item_from_the_list() {
        addToListOnWeeklyAd.clickRemoveFromListButton();
    }*/


    @When("^user click on first flyer$")
    public void user_click_on_first_flyer() {
        addToListOnWeeklyAd.clickOnFirstAdBanner();
    }

    @Then("^user can see full view of flyer$")
    public void user_can_see_full_view_of_flyer() {
        addToListOnWeeklyAd.verifyFullViewOfFlyerPage();
    }

    @When("^user clicks back button on flyer detail page$")
    public void user_clicks_back_button_on_flyer_detail_page() {
        addToListOnWeeklyAd.clickBackToAdButton();
        addToListOnWeeklyAd.clickNavBarBackToButton();
    }


    @When("user select pickup on delivery select page")
    public void check_pickup() {
        addToListOnWeeklyAd.selectPickUpOption();
    }

    @Then("user selects pickup store")
    public void select_pickup_store() {
        addToListOnWeeklyAd.selectPickUpStore();
    }

    @Then("^verify user is on weekly ad flyer page$")
    public void verify_user_is_on_weekly_ad_flyer_page() {
        addToListOnWeeklyAd.verifyFlyerPageIsVisible();
    }

    @And("^user can scroll vertically on flyer page$")
    public void user_can_scroll_vertically_on_flyer_page() {
        addToListOnWeeklyAd.scrollVerticallyOnFlyerPage();
    }

    @And("^user can scroll vertically on full view page of flyer$")
    public void user_can_scroll_vertically_on_full_view_page_of_flyer() {
        addToListOnWeeklyAd.scrollVerticallyOnFlyerDetailViewPage();
    }

    @Then("user validates offer details and disclaimer section")
    public void user_validates_offer_details_and_disclaimer_section() {
        addToListOnWeeklyAd.validateOfferDetailsDisclaimerSection();
    }

    @When("user clicks on an offer")
    public void user_clicks_on__offer() {
        addToListOnWeeklyAd.clickOnOffer();
    }

    @Then("individual weekly offer details should be displayed")
    public void individual_offer_details_should_be_displayed() {
        addToListOnWeeklyAd.validatingIndividualWeeklyOfferDetails();
    }

    @Then("user click on close offer details screen")
    public void user_clicks_close_offer_details_screen() {
        addToListOnWeeklyAd.clickOnCloseOfferDetailsScreen();
    }

    @And("user validates weekly ad header date")
    public void user_validates_ad_header() {
        addToListOnWeeklyAd.validateWeeklyHeaderAndDate();
    }
}



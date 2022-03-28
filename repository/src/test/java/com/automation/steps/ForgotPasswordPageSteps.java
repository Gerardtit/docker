package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.ForgotPasswordPage;
import com.automation.pages.GG_DealsPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordPageSteps {
    AppiumDriver driver = AppiumDriverManager.getDriver();
    public ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
    public GG_DealsPage dealsPage = new GG_DealsPage(driver);

    @Then("^forgot password page is displayed$")
    public void forgotPasswordPageIsDisplayed() {
        forgotPasswordPage.waitForForgotPasswordPageDisplayed();
    }

    @When("^user enters \"([^\"]*)\" on forgot password page$")
    public void userEntersOnForgotPasswordPage(String arg0) throws Throwable {
        forgotPasswordPage.enterEmail(arg0);
    }

    @And("^user click next button on forgot password page$")
    public void userClickNextButtonOnForgotPasswordPage() {
        forgotPasswordPage.clickNextButton();
    }

    @Then("^verify Password Reset Email Sent displayed$")
    public void verifyPasswordResetEmailSentDisplayed() {
        forgotPasswordPage.waitForPasswordResetDisplayed();
    }


    @Then("user clicks on hamburger menu")
    public void user_clicks_on_hamburger_menu() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("view detail is clicked")
    public void view_detail_is_clicked() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("user clicks second store on the list")
    public void user_clicks_second_store_on_the_list() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Flyer preview should be displayed")
    public void flyer_preview_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user click on Flyer detail view")
    public void user_click_on_flyer_detail_view() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user validates weekly ad header and date")
    public void user_validates_weekly_ad_header_and_date() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
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


    @When("click on NewSignup Api for OTP with the long user name {string}")
    public void click_on_new_signup_api_for_otp_with_the_long_user_name(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("bday card is displayed")
    public void bday_card_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify Scorecard in for u tab for no rewards")
    public void verify_scorecard_in_for_u_tab_for_no_rewards() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify how for u screen")
    public void verify_how_for_u_screen() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify how for u screen for rewards user")
    public void verify_how_for_u_screen_for_rewards_user() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("validate the text on birthday card page")
    public void validate_the_text_on_birthday_card_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("go to Member tab")
    public void go_to_member_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("clicks ForU tab")
    public void clicks_for_u_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("click back button from my rewards")
    public void click_back_button_from_my_rewards() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify qualifying Products is displayed")
    public void verify_qualifying_products_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify Clip your favorites section is not displayed")
    public void verify_clip_your_favorites_section_is_not_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("sign up to the application using ahem email client with popup handling")
    public void sign_up_to_the_application_using_ahem_email_client_with_popup_handling() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("get clipped deal name")
    public void get_clipped_deal_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify deal is added under Most Recent tab")
    public void verify_deal_is_added_under_most_recent_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify deals and item are not listed under Most Recent tab")
    public void verify_deals_and_item_are_not_listed_under_most_recent_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify checked-In store is collapsed by default")
    public void verify_checked_in_store_is_collapsed_by_default() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("verify list and deals are sorted alphabetically under most recent tab")
    public void verify_list_and_deals_are_sorted_alphabetically_under_most_recent_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("deals items checked under category tab should be sorted alphabetically")
    public void deals_items_checked_under_category_tab_should_be_sorted_alphabetically() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("go to gas rewards section")
    public void go_to_gas_rewards_section() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify Rewards carousel header and sub header on For U")
    public void verify_rewards_carousel_header_and_sub_header_on_for_u() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify user is in Reward Listing screen")
    public void verify_user_is_in_reward_listing_screen() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("click back button on Redeem Reward Page")
    public void click_back_button_on_redeem_reward_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("verify rewards balance is decreased after clipping a reward from rewards navigation bar")
    public void verify_rewards_balance_is_decreased_after_clipping_a_reward_from_rewards_navigation_bar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify Wallet tab bar is displayed")
    public void verify_wallet_tab_bar_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify that {string} Page is displayed")
    public void verify_that_page_is_displayed(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("click on X button on Pay Screen")
    public void click_on_x_button_on_pay_screen() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("switch on My Account Feature Enabled")
    public void switch_on_my_account_feature_enabled() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("click on Account and Validate the header")
    public void click_on_account_and_validate_the_header() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user has removed this item from the list")
    public void user_has_removed_this_item_from_the_list() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("CTA on the card is changed to Add to list")
    public void cta_on_the_card_is_changed_to_add_to_list() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify Horizontal scroll will always be there")
    public void verify_horizontal_scroll_will_always_be_there() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify maximum {int} deal cards is Displayed in clip your deals module")
    public void verify_maximum_deal_cards_is_displayed_in_clip_your_deals_module(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("slide the deal card and click on see all button on deal card of clip your deals module")
    public void slide_the_deal_card_and_click_on_see_all_button_on_deal_card_of_clip_your_deals_module() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user see {string} tab opens")
    public void user_see_tab_opens(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify Clip your favorites section is displayed")
    public void verify_clip_your_favorites_section_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("change the pickup store")
    public void change_the_pickup_store() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("sign up to the application using ahem email client")
    public void sign_up_to_the_application_using_ahem_email_client() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user clicks on multiple stores to view the details of the store")
    public void user_clicks_on_multiple_stores_to_view_the_details_of_the_store() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("{string} text is displayed in checkout page")
    public void text_is_displayed_in_checkout_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user add item to cart")
    public void user_add_item_to_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user toggle pickup to delivery")
    public void user_toggle_pickup_to_delivery() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user click on the day next to today")
    public void user_click_on_the_day_next_to_today() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user click on Continue Payment on slot selection page")
    public void user_click_on_continue_payment_on_slot_selection_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on Continue to review order")
    public void user_clicks_on_continue_to_review_order() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("verify Add Address page is displayed")
    public void verify_add_address_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user click back arrow in Add Address page")
    public void user_click_back_arrow_in_add_address_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("close the slot selection screen")
    public void close_the_slot_selection_screen() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user confirms the selection")
    public void user_confirms_the_selection() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on Continue to slot selection")
    public void user_clicks_on_continue_to_slot_selection() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("sign in with newOTP for delivery orders")
    public void sign_in_with_new_otp_for_delivery_orders() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user validates change at driver tipping")
    public void user_validates_change_at_driver_tipping() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify global substitution is not checked on cart page")
    public void verify_global_substitution_is_not_checked_on_cart_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}

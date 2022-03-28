package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.WalletPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WalletPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public AppiumDevice device = AppiumDeviceManager.getDevice();
    WalletPage walletPage = new WalletPage(driver);

    @Then("^Home page should be displayed$")
    public void home_page_should_be_displayed() throws Throwable {
        walletPage.waitForHomePageDisplayed();
    }

    @Then("^verify search bar appears in home page$")
    public void verify_search_bar_appears_in_home_page() throws Throwable {
        walletPage.verifySearchBarDisplayed();
    }

    @When("^user clicks wallet on HomePage$")
    public void user_tap_on_wallet() throws Throwable {
        walletPage.clickOnWallet();
    }

    @Then("^the \"([^\"]*)\" page is displayed$")
    public void page_is_displayed(String title) throws Throwable {
        Thread.sleep(3000);
        walletPage.waitForPageDisplayed(title);
    }


    @When("go to Member tab wallet")
    public void goToMemberTab() {
        walletPage.clickWalletTab();
    }

    @When("^go to Wallet tab$")
    public void goToWalletTab() {
        walletPage.clickWalletTab();
    }

    @When("^click on wallet sub tab$")
    public void goToWalletSubTab() {
        walletPage.clickWalletSubTab();
    }


    @Then("^verify Loyalty card, clipped rewards and clipped deals are displayed$")
    public void verify_Loyalty_card_clipped_rewards_and_deals_section_are_loaded() throws Throwable {
        walletPage.verifyLoyaltyCardDisplayed();
        walletPage.verifyClippedRewardsDisplayed();
        walletPage.verifyClippedDealsDisplayed();
    }

    @When("^user click on clipped Deals$")
    public void userClickOnClippedDeals() {
        walletPage.verifyClippedDealsDisplayed();
        walletPage.clickedDeals();
    }

    @Then("\"You clipped Deal\" text is displayed$")
    public void clippedDealsTextisDisplayed() {
        //   walletPage.verifyClipCouponisDisplayed();
        walletPage.verifyClippedDealsDisplayed();
    }

    @Then("\"You clipped Deal\" text is not displayed$")
    public void clippedDealsTextisNotDisplayed() {
        walletPage.verifyClippedDealsNotDisplayed();
    }


    @Then("Clipped Deals page is displayed$")
    public void clippedDealsPageisDisplayed() {
        //   walletPage.verifyClipCouponisDisplayed();
        walletPage.verifyClippedDealsPageisDisplayed();

    }

    @And("navigate back to previous screen$")
    public void navigateBack() {
        //   walletPage.verifyClipCouponisDisplayed();

        driver.navigate().back();

    }


    @Then("add a product to product details page")
    public void add_a_product_to_product_details_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Applied is displayed on page")
    public void applied_is_displayed_on_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user enters {string} in zipcode page on MFA signup")
    public void user_enters_in_zipcode_page_on_mfa_signup(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Verify TOS in get started screen")
    public void verify_tos_in_get_started_screen() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User click on Privacy policy in get started screen")
    public void user_click_on_privacy_policy_in_get_started_screen() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Verify Privacy policy screen in browser")
    public void verify_privacy_policy_screen_in_browser() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("come back to to app verify let get started screen")
    public void come_back_to_to_app_verify_let_get_started_screen() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user click on Heamberger")
    public void user_click_on_heamberger() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify that terms & policies is displayed")
    public void verify_that_terms_policies_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("click on term & policies")
    public void click_on_terms_policies() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify that respective page is opening without any error")
    public void verify_that_respective_page_is_opening_without_any_error() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("click on search icon")
    public void click_on_search_icon() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @And("verify clipped Deals message")
    public void verify_clipped_Deals_message() {
        walletPage.verifyClippedDeals();
    }

    @And("verify See your clipped deals message")
    public void verifySeeYourClippedDealsMessage() {
        walletPage.verifySeeyourclippeddeals();
    }

    @When("user click on wallet at member tab")
    public void userClickOnWalletAtMemberTab() {
        walletPage.clickWalletSubTab();
    }

    @When("user clicks on Rewards at member tab")
    public void userClicksOnRewardsAtMemberTab() {
        walletPage.rewardstab();

    }
}

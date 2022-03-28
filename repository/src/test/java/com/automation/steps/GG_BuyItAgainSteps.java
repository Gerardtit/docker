package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_BuyItAgainPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GG_BuyItAgainSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();

    public GG_BuyItAgainPage buyItAgainPage = new GG_BuyItAgainPage(driver);

    @When("^user click on Buy it again tab in My List page$")
    public void user_click_on_Buy_it_again_tab_in_My_List_page() throws Throwable {
        buyItAgainPage.clickBuyItAgainTab();
    }

    @Then("^verify Buy it again page is empty$")
    public void verify_Buy_it_again_page_is_empty() throws Throwable {
        Assert.assertEquals(buyItAgainPage.verifyBuyItAgainPageIsEmpty(), "If you have past purchases, they’ll show up in your account shortly. For new shoppers, “Buy it again” helps you shop from past orders quickly and easily.");
    }

    @And("^user click on refine button in Buy it again page$")
    public void user_click_on_refine_button_in_Buy_it_again_page() throws Throwable {
        buyItAgainPage.clickRefineButton();
    }

    @Then("^verify refine window is displayed$")
    public void verify_refine_window_is_displayed() {
        Assert.assertEquals(buyItAgainPage.verifyRefineWindowDisplayed(), "Refine");
    }

    @When("user click on Dairy, Eggs & Cheese pill")
    public void user_click_on_dairy_eggs_cheese_pill() {
        buyItAgainPage.clickDairyEggsCheesePill();
    }

    @When("user click on Beverages pill")
    public void user_click_on_beverages_pill() {
        buyItAgainPage.clickBeveragesPill();
    }

    @When("user scroll horizontally through pills in BIA Page")
    public void user_scroll_horizontally_through_pills_in_bia_page() {
        buyItAgainPage.fruitsVegetablesPill();
    }

    @When("user click on Wine, Bear & Spirits pill")
    public void user_click_on_wine_bear_spirits_pill() {
        buyItAgainPage.clickWineBeerSpiritsPill();
    }

    @When("user click on Cookies, Snacks & Candy pill")
    public void user_click_on_cookies_snacks_candy_pill() {
        buyItAgainPage.clickCookiesSnacksCandiesPill();
    }

    @When("user click on Fruits & Vegetables pill")
    public void user_click_on_fruits_vegetables_pill() {
        buyItAgainPage.clickFruitsVegetablesPill();
    }

    @When("user click on Frozen Foods pill")
    public void user_click_on_frozen_foods_pill() {
        buyItAgainPage.clickFrozenFoodsPill();
    }

    @Then("^verify user navigates to Buy it Again page$")
    public void verify_user_navigates_to_Buy_it_Again_Page_by_default() throws Throwable {
        buyItAgainPage.buyItAgainTabinMyItemsPage();
    }

    @When("^user click 'Frequently Purchased' option from Sort By category$")
    public void user_click_Frequently_Purchased_option_from_Sort_By_category() throws Throwable {
        buyItAgainPage.sortByFrequentlyPurchasedOption();
    }

    @Then("^verify 'Frequently Purchased' option has been selected$")
    public void verify_Frequently_Purchased_option_has_been_selected() throws Throwable {
        buyItAgainPage.verifyFrequentlyPurchasedSelected();
    }

    @When("^user click on 'Purchased Date' option from Sort By category$")
    public void user_click_on_Purchased_Date_option_from_Sort_By_category() throws Throwable {
        buyItAgainPage.sortByPurchasedDateOption();
    }

    @Then("^verify 'Purchased Date' option has been selected$")
    public void verify_Purchased_Date_option_has_been_selected() throws Throwable {
        buyItAgainPage.verifyPurchasedDateSelected();
    }

    @When("^user click 'In-Store' option from Filter By category$")
    public void user_click_Instore_option_from_Filter_By_category() throws Throwable {
        buyItAgainPage.clickFilterByInStore();
    }

    @Then("^verify 'In-Store' option has been selected$")
    public void verify_Instore_option_has_been_selected() throws Throwable {
        buyItAgainPage.verifyInstoreSelected();
    }

    @Then("^verify 'In-Store' option has not been selected$")
    public void verify_Instore_option_has_not_been_selected() throws Throwable {
        buyItAgainPage.clickFilterByInStoreToDeselect();
        Assert.assertFalse(buyItAgainPage.verifyInstoreSelected());
    }

    @When("^user click 'Online' option from Filter By category$")
    public void user_click_Online_option_from_Filter_By_category() throws Throwable {
        buyItAgainPage.clickFilterByOnline();
    }

    @Then("^verify 'Online' option has been selected$")
    public void verify_Online_option_has_been_selected() throws Throwable {
        buyItAgainPage.verifyOnlineSelected();
    }

    @When("^user click on 'Last Order' option from Purchase Date$")
    public void user_click_on_Last_Order_option_from_Purchase_Date() throws Throwable {
        buyItAgainPage.clickLastOrder();
    }

    @Then("^verify 'Last Order' option has been selected$")
    public void verify_Last_Order_option_has_been_selected() throws Throwable {
        buyItAgainPage.verifyLastOrderSelected();
    }

    @When("^user click all the past month purchases and verify it is selected$")
    public void user_click_all_the_past_month_purchases_and_verify_it_is_selected() throws Throwable {
        buyItAgainPage.clickAllPastMonths();
    }

    @Then("^user scroll down through the past months of the page$")
    public void user_scroll_down_through_the_past_months_of_the_page() throws Throwable {
        buyItAgainPage.scrollDownToPast13months();
    }

    @When("^user clicks on Apply button$")
    public void user_clicks_on_Apply_button() throws Throwable {
        buyItAgainPage.clickApply();
    }

    @Then("^verify Buy it again Products displayed$")
    public void verify_Buy_it_again_Products_displayed() throws Throwable {
        Assert.assertTrue(buyItAgainPage.isBuyItAgainProductsDisplayed(), "Buy It Again products is not displayed");
    }
}

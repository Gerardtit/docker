package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.InstorePageCTA;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class InStorePageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public AppiumDevice device = AppiumDeviceManager.getDevice();
    InstorePageCTA pageElements = new InstorePageCTA(driver);

    @When("^user tap on search and perform product search as \"([^\"]*)\"$")
    public void user_tap_on_search_and_perform_product_search_as(String product) throws Throwable {
        pageElements.searchButter(product);
        Thread.sleep(3000);
        pageElements.iosToggleClose();
    }

    @Then("^user should see searched products$")
    public void user_should_see_searched_products() throws Throwable {
        pageElements.verifySearchedProductsAvailable();
    }

    @When("^user click on Add to List$")
    public void user_click_on_Add_to_List() throws Throwable {
        pageElements.clickOnProduct();
        pageElements.addItems();
    }

    @Then("^verify products are adding to List$")
    public void verify_products_are_adding_to_List() throws Throwable {
        pageElements.checkQuantity();
    }

    @When("^user clicks on List$")
    public void user_clicks_on_List() throws Throwable {
        pageElements.clickOnList();
    }

    @Then("^verify My List page is displayed$")
    public void the_My_List_page_is_displayed() throws Throwable {
        pageElements.verifyMyListPageDisplayed();
    }

    @Then("^verify products are adding to cart in My List Page$")
    public void verify_products_are_adding_to_cart_in_My_list_page() throws Throwable {
        pageElements.cartPageProductIncrement();
//        pageElements.intActualQuantity();
    }

    @When("^user clicks Delivery or Pick Up in My List Page$")
    public void user_clicks_Delivery_or_Pick_Up_in_My_List_Page() throws Throwable {
        pageElements.clickDeliveryOrPickUp();
    }

    @When("^verify Delivery or PickUp is enabled for Empty Shopping cart$")
    public void verifyDeliveryPickUpEnabledForEmptyCart() {
        pageElements.deliveryOrPickUpEnabled();
    }

    @Then("^user clicks Pay In-Store in My List Page$")
    public void user_clicks_Pay_In_Store_in_My_List_Page() throws Throwable {
        pageElements.clickPayInStore();
    }

    @And("^user remove items from cart$")
    public void remove_item_from_cart() throws Throwable {
        pageElements.removeItems();
    }

    @When("^user close the \"([^\"]*)\" page$")
    public void user_close_the_page(String arg1) throws Throwable {
        pageElements.closeMyListPage();
    }

    @When("^user close the new cart page$")
    public void user_close_the_cart_page() throws Throwable {
        pageElements.closeNewCartPage();
    }

    @When("^user clicks back button on search page$")
    public void user_clicks_back_button_on_search_page() throws Throwable {
        pageElements.closePage();
        pageElements.backbutton();
    }

    @And("^user clicks back button$")
    public void user_clicks_back_button() throws Throwable {
        pageElements.closeMyListPage();
    }

    @And("^verify user should not see \"([^\"]*)\" and \"([^\"]*)\" in InStore mode$")
    public void verfiy_user_should_not_see_Substitution_and_Preferences_in_InStore_mode(String arg0, String arg1) throws Throwable {
        Thread.sleep(2000);
        Assert.assertFalse(pageElements.containTextDisplayed(arg0));
        Assert.assertFalse(pageElements.containTextDisplayed(arg1));
    }
}

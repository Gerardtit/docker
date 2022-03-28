package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.mealsPages.ShopIngredientsPlanPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Meals_ShopIngredientsSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    ShopIngredientsPlanPage shopIngredientsPlanPage = new ShopIngredientsPlanPage(driver);

    @Then("^user clicks on shop ingredients")
    public void user_clicks_on_shop_ingredients() throws Throwable {
        shopIngredientsPlanPage.clickShopIngredientsButton();
    }

    @Then("^user clicks on shop for delivery or pickup")
    public void user_clicks_on_shop_for_delivery_or_pickup() throws Throwable {
        shopIngredientsPlanPage.clickShopForDeliveryOrPickUpButton();
    }

    @Then("^option for how to shop should be shown in prompt sheet$")
    public void option_for_how_to_shop_should_be_shown_in_prompt_sheet() {
        shopIngredientsPlanPage.shopIngredientsOptionsPromptSheetIsDisplayed();
    }

    @When("^user clicks on close button on prompt sheet$")
    public void user_clicks_on_close_button_on_prompt_sheet() {
        shopIngredientsPlanPage.clickCloseButtonOnPromptSheet();
    }

    @Then("^Shop ingredients page is displayed$")
    public void shop_ingredients_page_is_displayed() {
        shopIngredientsPlanPage.verifyShopIngredientsPageIsDisplayed();
    }

    @When("^user clicks on add products to cart$")
    public void user_clicks_on_add_products_to_cart() {
        shopIngredientsPlanPage.clickAddProductsToCart();
    }

    @Then("^products have been added to your cart confirmation is shown$")
    public void products_have_been_added_to_your_cart_confirmation_is_shown() {
        Assert.assertTrue(shopIngredientsPlanPage.productAddedSuccessfullyPrompt(), "error adding products to cart");
    }

    @When("^user clicks on go to cart to checkout$")
    public void user_clicks_on_go_to_cart_to_checkout() {
        shopIngredientsPlanPage.clickGoToCartToCheckout();
    }

    @Then("^verify cart is Displayed$")
    public void verify_cart_is_displayed() {
        shopIngredientsPlanPage.verifyCartIsDisplayed();
    }

    @When("^user clicks on view my meals$")
    public void user_clicks_on_view_my_meals() {
        shopIngredientsPlanPage.clickViewMyMeals();
    }

    @When("^user clicks on add ingredients to my list$")
    public void user_clicks_on_add_ingredients_to_my_list() {
        shopIngredientsPlanPage.clickAddIngredientsToMyListButton();
    }

    @When("^review ingredients page is displayed$")
    public void review_ingredients_page_is_displayed() {
        shopIngredientsPlanPage.verifyReviewIngredientsPageIsDisplayed();
    }

    @When("^user clicks on add items to list$")
    public void user_clicks_on_add_items_to_list() {
        shopIngredientsPlanPage.clickAddItemsToMyListButton();
    }

    @Then("^products have been added to your list confirmation is shown$")
    public void products_have_been_added_to_your_list_confirmation_is_shown() {
        shopIngredientsPlanPage.ingredientsAddedPromptSheetConfirmation();
    }

    @When("^user clicks on show my list$")
    public void user_clicks_on_show_my_list() {
        shopIngredientsPlanPage.clickOnShowMyListButton();
    }

    @When("^user clicks view my meals$")
    public void user_clicks_view_my_meals() {
        shopIngredientsPlanPage.clickViewMyMeals();
    }

    @When("^user clicks back to meals$")
    public void user_clicks_back_to_meals() {
        shopIngredientsPlanPage.clickBackToMeals();
    }
}

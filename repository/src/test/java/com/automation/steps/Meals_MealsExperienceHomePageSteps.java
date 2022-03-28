package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.mealsPages.MealsHomePage;
import com.automation.pages.mealsPages.RecipeListPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Meals_MealsExperienceHomePageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    MealsHomePage mealsHomePage = new MealsHomePage(driver);
    RecipeListPage recipeListPage = new RecipeListPage(driver);

    @Given("^User is on meals homepage$")
    public void user_is_on_meals_homepage() {
        mealsHomePage.goToMealsHomePage();
    }

    @Then("^recipe should appear on meals homepage favorite category$")
    public void recipe_should_appear_on_meals_homepage_favorite_category() {
        mealsHomePage.clickBackButtonUntilMealsHomePageIsDisplayed();
        Assert.assertTrue(mealsHomePage.verifyFavoriteRecipeIsDisplayed());
    }

    @Then("^recipe should disappear on meals homepage favorite category$")
    public void recipe_should_disappear_on_meals_homepage_favorite_category() {
        while (!mealsHomePage.verifyMealsHomePageIsDisplayed()) {
            mealsHomePage.clickBackButton();
        }
        if (mealsHomePage.verifyFavoriteRecipeIsDisplayed()) {
            user_clicks_on_favorite_recipe_item_one();
            recipeListPage.clickFavoriteButton();
            mealsHomePage.clickBackButtonUntilMealsHomePageIsDisplayed();
        }
        Assert.assertFalse(mealsHomePage.verifyFavoriteRecipeIsDisplayed());
    }

    @When("^user clicks on favorite recipe item one$")
    public void user_clicks_on_favorite_recipe_item_one() {
        mealsHomePage.clickFavoriteRecipeItemOne();
    }

    @Then("^meals experience homepage is displayed$")
    public void meals_experience_homepage_is_displayed() throws Throwable {
        Assert.assertTrue(mealsHomePage.verifyMealsHomePageIsDisplayed());
    }

    @When("^User clicks on first cuisine type$")
    public void user_clicks_on_first_cuisine_type() {
        mealsHomePage.clickOnCuisineType();
    }

    @When("^User clicks on third cuisine type$")
    public void user_clicks_on_third_cuisine_type() {
        mealsHomePage.clickOnThirdCuisineType();
    }

    @When("^User clicks on second cuisine type$")
    public void user_clicks_on_second_cuisine_type() {
        mealsHomePage.clickOnSecondCuisineType();
    }

    @When("^User clicks most popular recipe item one tile$")
    public void user_clicks_most_popular_recipe_item_one() {
        mealsHomePage.clickOnMostPopularRecipeItemOne();
        Assert.assertTrue(recipeListPage.recipeDetailsPageIsDisplayed());
    }

    @When("^User clicks top rated recipe item one quick add button$")
    public void user_clicks_top_rated_recipe_item_one_quick_add_button() {
        mealsHomePage.clickQuickAddTopRatedRecipeOne();
    }

    @Then("meals search is displayed")
    public void meals_search_is_displayed() {
        mealsHomePage.verifySearchIsDisplayed();
    }

    @Then("Meals text is displayed")
    public void meals_text_is_displayed() {
        mealsHomePage.verifyMealsTextIsDisplayed();
    }

    @Then("Edit preferences button is displayed")
    public void edit_preferences_button_is_displayed() {
        mealsHomePage.editPreferencesIsDisplayed();
    }

    @Then("Most popular recipe section is displayed")
    public void most_popular_recipe_section_is_displayed() {
        mealsHomePage.mostPopularRecipeIsDisplayed();
    }

    @Then("top rated recipe section is displayed")
    public void top_rated_recipe_section_is_displayed() {
        mealsHomePage.topRatedRecipeIsDisplayed();
    }

    @Then("vegetarian recipe section is displayed")
    public void vegetarian_recipe_section_is_displayed() {
        mealsHomePage.vegetarianRecipeIsDisplayed();
    }

    @Then("cuisine type halo cards are displayed")
    public void cuisine_type_halo_cards_are_displayed() {
        mealsHomePage.cuisineTypeCardIsDisplayed();
    }

    @Then("zipcode page is displayed in page")
    public void zipcodePageIsDisplayedInPage() {

    }
}

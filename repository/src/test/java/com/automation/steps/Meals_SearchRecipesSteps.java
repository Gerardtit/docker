package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.mealsPages.SearchRecipesPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Meals_SearchRecipesSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    SearchRecipesPage searchRecipesPage = new SearchRecipesPage(driver);

    @When("user clicks on search button on meals homepage")
    public void user_clicks_on_search_button_on_meals_homepage() {
        searchRecipesPage.clickOnSearchButtonOnMealsHomePage();
    }

    @Then("suggested category is shown")
    public void suggested_category_is_shown() {
        searchRecipesPage.verifySuggestedCategoryIsDisplayed();
    }

    @When("^user clicks back button on meals search page$")
    public void user_clicks_back_button_on_meals_search_page() {
        searchRecipesPage.clickBackButtonOnMealsSearchPage();
    }

    @Then("dish types category is shown")
    public void dish_types_category_is_shown() {
        searchRecipesPage.verifyDishTypeCategoryIsDisplayed();
    }

    @Then("calories per serving category is shown")
    public void calories_per_serving_category_is_shown() {
        searchRecipesPage.verifyCaloriesCategoryIsDisplayed();
    }

    @Then("cuisines category is shown")
    public void cuisines_category_is_shown() {
        searchRecipesPage.verifyCuisinesCategoryIsDisplayed();
    }
}

package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.mealsPages.RecipeListPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Meals_RecipeListPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    RecipeListPage recipeListPage = new RecipeListPage(driver);

    @Then("^recipes list page is displayed")
    public void recipes_list_page_is_displayed() throws Throwable {
        Assert.assertTrue(recipeListPage.recipeListPageIsDisplayed());
    }

    @When("^User selects recipe$")
    public void user_selects_recipe() {
        recipeListPage.clickOnFirstRecipeInList();
    }

    @Then("^recipe details page is displayed$")
    public void recipe_details_page_is_displayed() {
        Assert.assertTrue(recipeListPage.recipeDetailsPageIsDisplayed());
    }

    @Then("^user marks recipe favorite$")
    public void user_marks_recipe_favorite() {
        recipeListPage.clickFavoriteButton();
    }

    @Then("^user removes recipe from favorite$")
    public void user_removes_recipe_from_favorite() {
        recipeListPage.clickFavoriteButton();
    }

    @Then("^user adds to meal plan$")
    public void user_adds_to_meal_plan() {
        recipeListPage.clickAddToMealPlanButton();
    }

    @Then("^User selects recipe using quick add button on second item$")
    public void user_selects_recipe_using_quick_add_button_on_second_item() {
        recipeListPage.clickQuickAddButtonSecondItem();
    }

    @Then("^User selects recipe using quick add button on third item$")
    public void user_selects_recipe_using_quick_add_button_on_third_item() {
        recipeListPage.clickQuickAddButtonThirdItem();
    }
}

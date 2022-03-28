package com.automation.pages.mealsPages;

import com.automation.pageElements.meals.pageElements.SearchRecipesPageElements;
import com.automation.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchRecipesPage extends BasePage {

    SearchRecipesPageElements searchRecipePageElements = new SearchRecipesPageElements();
    RecipeListPage recipeListPage = new RecipeListPage(driver);

    public SearchRecipesPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), searchRecipePageElements);
    }

    public void clickOnSearchButtonOnMealsHomePage() {
        waitForClickableAndClick(searchRecipePageElements.searchButtonOnMealsHomePage);
    }

    public void verifySuggestedCategoryIsDisplayed() {
        //this step is performed to dismiss keyboard, can be replaced with a different option if there are issues with this
        waitForDisplayed(searchRecipePageElements.suggestedCategories);
        searchRecipePageElements.suggestedCategories.click();
        Assert.assertTrue(searchRecipePageElements.suggestedCategories.isDisplayed());
    }

    public void verifyDishTypeCategoryIsDisplayed() {
        //this step is performed to dismiss keyboard, can be replaced with a different option if there are issues with this
        searchRecipePageElements.dishTypesCategories.click();
        Assert.assertTrue(searchRecipePageElements.dishTypesCategories.isDisplayed());
    }

    public void verifyCaloriesCategoryIsDisplayed() {
        //this step is performed to dismiss keyboard, can be replaced with a different option if there are issues with this
        searchRecipePageElements.dishTypesCategories.click();
        scrollDownForElement(searchRecipePageElements.caloriesCategories);
        Assert.assertTrue(searchRecipePageElements.caloriesCategories.isDisplayed());
    }

    public void verifyCuisinesCategoryIsDisplayed() {
        //this step is performed to dismiss keyboard, can be replaced with a different option if there are issues with this
        searchRecipePageElements.dishTypesCategories.click();
        scrollDownForElement(searchRecipePageElements.cuisineCategories);
        Assert.assertTrue(searchRecipePageElements.cuisineCategories.isDisplayed());
    }

    public void clickBackButtonOnMealsSearchPage() {
        waitForClickableAndClick(searchRecipePageElements.mealsSearchBackButton);
    }
}

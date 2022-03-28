package com.automation.pages.mealsPages;

import com.automation.pageElements.meals.pageElements.RecipeListPageElements;
import com.automation.pageElements.meals.pageElements.ReviewPlanPageElements;
import com.automation.pages.BasePage;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RecipeListPage extends BasePage {

    RecipeListPageElements recipeListPageElements = new RecipeListPageElements();
    ReviewPlanPageElements reviewPlanPageElements = new ReviewPlanPageElements();

    public RecipeListPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), recipeListPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), reviewPlanPageElements);
    }

    public void clickOnFirstRecipeInList() {
        waitForDisplayed(recipeListPageElements.firstRecipeInView);
        waitForClickableAndClick(recipeListPageElements.firstRecipeInView);
    }

    public boolean recipeDetailsPageIsDisplayed() {
        try {
            if (removeRecipeFromMealPlanButtonIsDisplayed() || addToMealPlanButtonIsDisplayed()) {
                recipeListPageElements.recipeTitle.isDisplayed();
                recipeListPageElements.recipeContent.isDisplayed();
                recipeListPageElements.favoriteButton.isDisplayed();
                recipeListPageElements.numberOfServingsButton.isDisplayed();
                //todo scroll down till this is displayed
                //recipeListPageElements.recipeDetailPageShopIngredientsButton.isDisplayed();
                //recipeListPageElements.recipeDetailPageNutritionButton.isDisplayed();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private boolean addToMealPlanButtonIsDisplayed() {
        try {
            waitForDisplayed(recipeListPageElements.addToMealPlanButton, 10);
            recipeListPageElements.addToMealPlanButton.isDisplayed();
            return true;
        } catch (NoSuchElementException | ElementNotFoundException e) {
            return false;
        }
    }

    private boolean removeRecipeFromMealPlanButtonIsDisplayed() {
        try {
            recipeListPageElements.removeRecipeFromMealPlanButton.isDisplayed();
            return true;
        } catch (NoSuchElementException | ElementNotFoundException e) {
            return false;
        }
    }

    private void clickRemoveRecipeFromMealPlanButton() {
        recipeListPageElements.removeRecipeFromMealPlanButton.click();
    }

    public boolean recipeListPageIsDisplayed() {
        try {
            if (new MealsUtils(driver).checkMobileElementExist(recipeListPageElements.recipesTile)) {
                recipeListPageElements.backButton.isDisplayed();
                //Todo remove in next build after element identifier is added
                //recipeListPageElements.pageTitleHeader.isDisplayed();
                recipeListPageElements.recipesTile.isDisplayed();
                return true;
            } else {
                return false;
            }
        } catch (ElementNotFoundException e) {
            return false;
        }
    }

    public void clickAddToMealPlanButton() {
        if (removeRecipeFromMealPlanButtonIsDisplayed()) {
            clickRemoveRecipeFromMealPlanButton();
            clickOnFirstRecipeInList();
            waitForClickableAndClick(recipeListPageElements.addToMealPlanButton);
        } else {
            waitForClickableAndClick(recipeListPageElements.addToMealPlanButton);
        }
    }

    public void clickQuickAddButtonSecondItem() {
        waitForClickableAndClick(recipeListPageElements.quickAddButtonSecondItemRecipeListPage);
        Assert.assertTrue(reviewPlanPageElements.reviewPlanButton.isDisplayed());
        Assert.assertTrue(reviewPlanPageElements.reviewPlanFooterBarMealThumb.isDisplayed());
    }

    public void clickQuickAddButtonThirdItem() {
        if (isElementDisplayed(recipeListPageElements.quickRemoveButtonThirdItemRecipeListPage)) {
            recipeListPageElements.quickRemoveButtonThirdItemRecipeListPage.click();
        }
        waitForClickableAndClick(recipeListPageElements.quickAddButtonThirdItemRecipeListPage);
        Assert.assertTrue(reviewPlanPageElements.reviewPlanButton.isDisplayed());
        Assert.assertTrue(reviewPlanPageElements.reviewPlanFooterBarMealThumb.isDisplayed());
    }

    public void clickFavoriteButton() {
        waitForClickableAndClick(recipeListPageElements.favoriteButton);
    }

    public void clickBackButton() {
        waitForClickableAndClick(recipeListPageElements.backButton);
    }
}

package com.automation.pageElements.meals.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class RecipeListPageElements {

    //Todo - pending verification of unused elements, keeping for using it in future automation scenarios

    //todo - move all recipe details page elements to separate class

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/add-recipe-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/add-recipe-button\"]")
    public MobileElement addToMealPlanButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/remove-recipe-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/remove-recipe-button\"]")
    public MobileElement removeRecipeFromMealPlanButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/recipe-list-thumb-0\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/recipe-list-thumb-0\"]")
    public MobileElement firstRecipeInView;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/recipe-title\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/recipe-title\"]")
    public MobileElement recipeTitle;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/recipe-content-loaded\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/recipe-content-loaded\"]")
    public MobileElement recipeContent;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/favorite-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/favorite-button\"]")
    public MobileElement favoriteButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/set-servings-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/set-servings-button\"]")
    public MobileElement numberOfServingsButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/recipe-list-thumb-1-add\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/recipe-list-thumb-1-add\"]")
    public MobileElement quickAddButtonSecondItemRecipeListPage;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/recipe-list-thumb-2-add\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/recipe-list-thumb-2-add\"]")
    public MobileElement quickAddButtonThirdItemRecipeListPage;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/recipe-list-thumb-2-remove\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/recipe-list-thumb-2-remove\"]")
    public MobileElement quickRemoveButtonThirdItemRecipeListPage;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/recipe-list-thumb-3-add\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/recipe-list-thumb-3-add\"]")
    public MobileElement quickAddButtonFourthItemRecipeListPage;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/recipe-list-thumb-0\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/recipe-list-thumb-0\"]")
    public MobileElement recipesTile;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/back-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/back-button\"]")
    public MobileElement backButton;
}

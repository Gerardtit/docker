package com.automation.pageElements.meals.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MealsHomePageElements {

    //Todo - pending verification of unused elements, keeping for using it in future automation scenarios

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'home-scene')]")
    @iOSXCUITFindBy(iOSNsPredicate = "name== \"menu:id/home-scene\"")
    public MobileElement mealsText;

    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/back-button\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name== \"menu:id/back-button\"")
    public MobileElement mealsHomePageBackButton;

    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/search-button\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name== \"menu:id/search-button\"")
    public MobileElement searchIcon;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/filters-button\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'filters-button')]")
    public MobileElement editPreferencesButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/halo-0\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, \"menu:id/halo-0\")]")
    public MobileElement cuisineTypeCard;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/collection-recently-created\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/collection-recently-created\"]")
    public MobileElement recentlyCreated;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/collection-most-popular\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, \"menu:id/collection-most-popular\")]")
    public MobileElement mostPopularText;

    @iOSXCUITFindBy(iOSNsPredicate = "label ==  \"See all Most popular recipes\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/collection-most-popular\"]")
    public MobileElement seeAllMostPopularRecipes;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/collection-top-rated\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, \"menu:id/collection-top-rated\")]")
    public MobileElement topRatedText;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/collection-quick-&amp;-easy\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, \"menu:id/collection-quick-&amp;-easy\")]")
    public MobileElement quickAndEasyText;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/collection-breakfast\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, \"menu:id/collection-breakfast\")]")
    public MobileElement breakFastText;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/collection-vegetarian\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, \"menu:id/collection-vegetarian\")]")
    public MobileElement vegetarianText;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/see-all-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/see-all-button\"]")
    public MobileElement seeAllButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/add-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/add-button\"]")
    public MobileElement quickAddButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/collection-most-popular-thumb-0\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/collection-most-popular-thumb-0\"]")
    public MobileElement mostPopularRecipeItemOneTile;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/collection-most-popular-thumb-0-add\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, \"menu:id/collection-most-popular-thumb-0-add\")]")
    public MobileElement quickAddMostPopularRecipeItemOneTile;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/collection-most-popular-thumb-1-add\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, \"menu:id/collection-most-popular-thumb-1-add\")]")
    public MobileElement quickAddMostPopularRecipeItemTwoTile;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/collection-top-rated-thumb-1-add\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/collection-top-rated-thumb-1-add\"]")
    public MobileElement topRatedRecipeItemTileOneQuickAdd;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/collection-recently-created-thumb-0\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/collection-recently-created-thumb-0\"]")
    public MobileElement recentlyCreatedRecipeItemOneTile;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/collection-recently-created-thumb-0-add\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/collection-recently-created-thumb-0-add\"]")
    public MobileElement recentlyCreatedRecipeItemOneTileQuickAdd;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/collection-recently-created-thumb-0-add\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/collection-recently-created-thumb-0-add\"]")
    public MobileElement recentlyCreatedRecipeItemTwoTileQuickAdd;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/collection-vegetarian-thumb-0-add\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, \"menu:id/collection-vegetarian-thumb-0-add\")]")
    public MobileElement vegetarianRecipeItemTileOneQuickAdd;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/collection-vegetarian-thumb-0-remove\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, \"menu:id/collection-vegetarian-thumb-0-remove\")]")
    public MobileElement vegetarianRecipeItemTileOneQuickRemove;


    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/collection-favorites-thumb-0\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id, \"menu:id/collection-favorites-thumb-0\")]")
    public MobileElement collectionFavoriteThumbItemOne;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/collection-favorites-created-thumb-0-add\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/collection-favorites-created-thumb-0-add\"]")
    public MobileElement collectionFavoriteThumbItemOneAdd;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/collection-favorites\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/collection-favorites\"]")
    public MobileElement collectionFavorite;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/halo-1\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/halo-1\"]")
    public MobileElement secondCuisineTypeCard;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/halo-2\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/halo-2\"]")
    public MobileElement thirdCuisineTypeCard;
}

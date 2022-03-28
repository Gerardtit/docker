package com.automation.pageElements.meals.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SearchRecipesPageElements {

    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/search-button\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name== \"menu:id/search-button\"")
    public MobileElement searchButtonOnMealsHomePage;

    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/back-button\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name== \"menu:id/back-button\"")
    public MobileElement backButton;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Suggested\"")
    @AndroidFindBy(xpath = "//*[contains(@text,'Suggested')]")
    public MobileElement suggestedCategories;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Dish types\"")
    @AndroidFindBy(xpath = "//*[contains(@text,'Dish types')]")
    public MobileElement dishTypesCategories;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Calories per serving under\"")
    @AndroidFindBy(xpath = "//*[contains(@text,'Calories per serving under')]")
    public MobileElement caloriesCategories;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Cuisines\"")
    @AndroidFindBy(xpath = "//*[contains(@text,'Cuisines')]")
    public MobileElement cuisineCategories;

    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/back-button\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name== \"menu:id/back-button\"")
    public MobileElement mealsSearchBackButton;
}

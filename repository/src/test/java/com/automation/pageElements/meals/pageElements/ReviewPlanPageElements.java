package com.automation.pageElements.meals.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ReviewPlanPageElements {

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/planbox-shop-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/planbox-shop-button\"]")
    public MobileElement reviewPlanButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/planbox-meal-thumb\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/planbox-meal-thumb\"]")
    public MobileElement reviewPlanFooterBarMealThumb;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/navbar-header\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/navbar-header\"]")
    public MobileElement reviewYourPlanPageTitle;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/back-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/back-button\"]")
    public MobileElement backButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/right-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/right-button\"]")
    public MobileElement editButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/pending-meal-0\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/pending-meal-0\"]")
    public MobileElement recipeItemAddedInPlan;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/pending-meal-0-servings-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/pending-meal-0-servings-button\"]")
    public MobileElement numberOfServingsButtonInPlan;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/shop-ingredients-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/shop-ingredients-button\"]")
    public MobileElement shopIngredientsButton;
}

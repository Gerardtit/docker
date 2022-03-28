package com.automation.pageElements.meals.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;

public class MyMealsCookingPageElements {

    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/start-cooking-button\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name== \"menu:id/start-cooking-button\"")
    public MobileElement startCookingButton;

    @AndroidFindBy(xpath = "//*[contains(@text,'Show past meals')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Show past meals\"\n")
    public MobileElement showPastMealsButton;

    @iOSXCUITFindAll(value = {
            @iOSXCUITBy(iOSNsPredicate = "label == \"see-all-button See all my meals\""),
            @iOSXCUITBy(iOSNsPredicate = "name== \"menu:id/see-all-button\"")
    })
    @AndroidFindAll({
            @AndroidBy(xpath = "//*[@resource-id=\"menu:id/see-all-button\"]"),
            @AndroidBy(xpath = "//*[contains(@content-desc,'see-all-button')]"),
            @AndroidBy(xpath = "//*[contains(@text,'see-all-button')]")

    })
    public MobileElement seeAllMyMealsButton;

    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/got-it-button\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name== \"menu:id/got-it-button\"")
    public MobileElement gotItButton;

    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/back-button\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name== \"menu:id/back-button\"")
    public MobileElement backButton;

    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/overview-button\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name== \"menu:id/overview-button\"")
    public MobileElement overviewButton;

    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/next-button\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name== \"menu:id/next-button\"")
    public MobileElement nextButton;


    @iOSXCUITFindAll(value = {
            @iOSXCUITBy(iOSNsPredicate = "label == \"step 1\" AND name == \"step 1\""),
            @iOSXCUITBy(iOSNsPredicate = "label CONTAINS \"STEP 1\"")
    })
    @AndroidFindAll({
            @AndroidBy(xpath = "//*[contains(@text,\"STEP 1 / \")]")})
    public MobileElement step1Text;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Done\"\n")
    @AndroidFindAll(value = {
            @AndroidBy(xpath = "//*[contains(@content-desc,'Done')]"),
            @AndroidBy(xpath = "//*[contains(@text,'Done')]")

    })
    public MobileElement doneButton;

    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/browse-meal-list\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name== \"menu:id/browse-meal-list\"")
    public MobileElement myMealsPageScene;

    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/navbar-header\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name== \"menu:id/navbar-header\"")
    public MobileElement navBarHeader;

    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/tab-planned\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name== \"menu:id/tab-planned\"")
    public MobileElement plannedTab;

    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/tab-cooked\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name== \"menu:id/tab-cooked\"")
    public MobileElement cookedTab;

    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/cooked-thumb-0\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name== \"menu:id/cooked-thumb-0\"")
    public MobileElement cookedMealItemOne;

    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/timer-button\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name== \"menu:id/timer-button\"")
    public MobileElement timerButton;

    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/close-button\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "name== \"menu:id/close-button\"")
    public MobileElement closeButton;
}

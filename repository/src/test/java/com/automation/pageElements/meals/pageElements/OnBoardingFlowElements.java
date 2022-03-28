package com.automation.pageElements.meals.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class OnBoardingFlowElements {

    //Todo - pending verification of unused elements, keeping for using it in future automation scenarios

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/onboarding-welcome\"")
    //@AndroidFindBy(xpath = "//*[@text=\"Your meals, your way\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'onboarding-welcome')]")
    public MobileElement onboardingWelcomeScene;

    @iOSXCUITFindAll(value = {
            @iOSXCUITBy(iOSNsPredicate = "name == \"menu:id/back-button\""),
            @iOSXCUITBy(iOSNsPredicate = "type == \"XCUIElementTypeButton\" AND label == \"back\"")
    })
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeButton\" AND label == \"back\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'back-button')]")
    public MobileElement onboardingBackButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/continue-button\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'continue-button')]")
    public MobileElement pickYourDietButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/skip-button\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'skip-button')]")
    public MobileElement skipButton;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Pick your diet\"")
    @AndroidFindBy(xpath = "//*[@text=\"Pick your diet\"]")
    public MobileElement pickYourDietTextVerificationStep2Page;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Any dietary restrictions?\"\n")
    @AndroidFindBy(xpath = "//*[@text=\"Any dietary restrictions?\"]")
    public MobileElement anyAllergiesOrRestrictionsTextStep3Page;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"How about dislikes?\"\n")
    @AndroidFindBy(xpath = "//*[@text=\"How about dislikes?\"]")
    public MobileElement howAboutDislikesTextStep4Page;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/dislikes-lamb\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'dislikes-lamb')]")
    public MobileElement selectLambDislikesStep4Page;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"See all\"")
    @AndroidFindBy(xpath = "//*[@text=\"See all\"]")
    public MobileElement seeAllButtonStep4Page;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Total servings per meal?\"\n")
    @AndroidFindBy(xpath = "//*[@text=\"Total servings per meal?\"]")
    public MobileElement totalServingsPerMealTextStep5Page;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/servings-4\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'servings-4')]")
    public MobileElement selectTotalServingsPerMeal4ServingsButtonStep5Page;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/servings-6\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'servings-6')]")
    public MobileElement selectTotalServingsPerMeal6ServingsButtonStep5Page;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/servings-2\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'servings-2')]")
    public MobileElement selectTotalServingsPerMeal2ServingsButtonStep5Page;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/complete-button\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'complete-button')]")
    public MobileElement doneButtonStep5Page;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/onboarding-menu-scene\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'onboarding-menu-scene')]")
    public MobileElement onboardingPickYourDietScene;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/complete-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/complete-button\"]")
    public MobileElement onboardingNextButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/learn-diets-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/learn-diets-button\"]")
    public MobileElement learnAboutDietsButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/navbar-header\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/navbar-header\"]")
    public MobileElement pageTitle;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/close-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/close-button\"]")
    public MobileElement closeButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/diet-vegan\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/diet-vegan\"]")
    public MobileElement veganDiet;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/onboarding-restrictions\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'onboarding-restrictions')]")
    public MobileElement onboardingRestrictionsScene;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/onboarding-dislikes-scene\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'onboarding-dislikes-scene')]")
    public MobileElement onboardingDislikesScene;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/onboarding-servings\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'onboarding-servings')]")
    public MobileElement onboardingServingsScene;
}

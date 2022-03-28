package com.automation.pageElements.meals.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;

public class UMAHomePageElements {

    @iOSXCUITFindAll(value = {
            @iOSXCUITBy(iOSNsPredicate = "label CONTAINS \"mealsBannerImage\""),
            @iOSXCUITBy(iOSNsPredicate = "name == \"mealsBannerImage\""),
            @iOSXCUITBy(xpath = "//*[@label CONTAINS 'Meals made easy']"),
            @iOSXCUITBy(iOSNsPredicate = "label CONTAINS \"Meals made easy\""),
            @iOSXCUITBy(iOSNsPredicate = "label ==  \"mealsBannerImage\""),
    })
    @AndroidFindAll({
            @AndroidBy(xpath = "//*[contains(@resource-id,'meal_plan_medium_banner_img')]"),
            @AndroidBy(xpath = "//*[contains(@content-desc,'Meals made easy')]")
    })
    public MobileElement mealsHomeBanner;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Button for Meal Plans']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeButton[contains(@name,'Meal Plans')]")
    public MobileElement mealPlansCarouselButton;
}

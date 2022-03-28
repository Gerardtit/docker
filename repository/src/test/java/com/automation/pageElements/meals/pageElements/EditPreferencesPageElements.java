package com.automation.pageElements.meals.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class EditPreferencesPageElements {

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/filters-button\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'filters-button')]")
    public MobileElement editPreferenceButton;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Reset user data\"")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Reset user data\"]")
    public MobileElement resetUserData;

    @iOSXCUITFindBy(xpath = "//*[@label='OK' or @label='Ok']")
    @AndroidFindBy(id = "android:id/button1")
    public MobileElement confirmResetPopUp;

    @iOSXCUITFindBy(xpath = "//*[@label='OK' or @label='Ok']")
    @AndroidFindBy(id = "android:id/alertTitle")
    public MobileElement resetSuccessFulText;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/preferences-home\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'preferences-home')]")
    public MobileElement preferencesScene;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/navbar-header\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'navbar-header')]")
    public MobileElement pageTitle;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Diet\"")
    @AndroidFindBy(xpath = "//*[contains(@text,'Diet')]")
    public MobileElement dietText;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Restrictions\"")
    @AndroidFindBy(xpath = "//*[contains(@text,'Restrictions')]")
    public MobileElement restrictionsText;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Ingredients You Dislike\"")
    @AndroidFindBy(xpath = "//*[contains(@text,'Ingredients You Dislike')]")
    public MobileElement ingredientsYouDislikeText;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Serving Size\"")
    @AndroidFindBy(xpath = "//*[contains(@text,'Serving Size')]")
    public MobileElement servingSizeText;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/menu-select\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'menu-select')]")
    public MobileElement dietTypeSelectorButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/add-button\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'add-button')]")
    public MobileElement restrictionsAddButton;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"add dislikes\"\n")
    @AndroidFindAll({
            @AndroidBy(xpath = "//*[contains(@resource-id,'add dislikes')]"),
            @AndroidBy(xpath = "//*[contains(@content-desc,'add dislikes')]"),
            @AndroidBy(xpath = "//*[contains(@text,'add dislikes')]")
    })
    public MobileElement ingredientsYouDislikeButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/serving-select\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'serving-select')]")
    public MobileElement servingSizeSelectorButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/preferences-menu\"")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'preferences-menu')]")
    public MobileElement pickADietScene;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/back-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/back-button\"]")
    public MobileElement backButtonEditPreferences;
}


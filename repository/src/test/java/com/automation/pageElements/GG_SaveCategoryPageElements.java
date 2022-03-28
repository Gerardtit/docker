package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_SaveCategoryPageElements {

    @AndroidFindBy(className = "android.widget.ImageButton")
    @iOSXCUITFindBy(accessibility = "btnBack")
    public MobileElement backBtn;

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(accessibility = "btnBack")
    public MobileElement acountBackBtn;

    @AndroidFindBy(id = "text_title_save_aisle")
    @iOSXCUITFindBy(accessibility = "lblCategoryPreferenceTitle")
    public MobileElement categoryDescription;

    @AndroidFindBy(id = "txt_skip")
    @iOSXCUITFindBy(accessibility = "lblSkip")
    public MobileElement skip;

    @AndroidFindBy(id = "aisle_container")
    @iOSXCUITFindBy(accessibility = "lblCategoryTitle-0")
    public MobileElement selectFirstCategory;

    @AndroidFindBy(id = "aisle_container")
    @iOSXCUITFindBy(accessibility = "lblCategoryTitle-1")
    public MobileElement selectSecondCategory;

    @AndroidFindBy(id = "aisle_container")
    @iOSXCUITFindBy(accessibility = "lblCategoryTitle-0")
    public List<MobileElement> selectMultipleCategory;

    @AndroidFindBy(id = "button_continue")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Continue' AND name == 'Continue'")
    public List<MobileElement> continueButtonVisiblity;

    @AndroidFindBy(id = "button_continue")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Continue' AND name == 'Continue'")
    public MobileElement continueButton;
}

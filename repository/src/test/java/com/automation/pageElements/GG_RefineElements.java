package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_RefineElements {
    @AndroidFindBy(id = "tv_refine")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'Refine' and visible == 1")
    public MobileElement refineButton;

    @AndroidFindBy(id = "multipleSelectionCheckBoxCB")
    @iOSXCUITFindBy(iOSNsPredicate = "label contains 'checked' and visible == 1")
    public List<MobileElement> filterOptions;

    @AndroidFindBy(accessibility = "Save Button")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Done' AND type == 'XCUIElementTypeButton' AND visible==1")
    public MobileElement saveRefineFilterBtn;

    @AndroidFindBy(id = "img_filterSort")
    public MobileElement refineButtonInProductListSearchInEditCart;
}

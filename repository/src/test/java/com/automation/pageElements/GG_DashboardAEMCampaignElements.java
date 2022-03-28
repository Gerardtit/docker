package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_DashboardAEMCampaignElements {

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'cv_aem_zone')]//preceding-sibling::*/*[contains(@resource-id,'tv_salutation_header')]")
    @iOSXCUITFindBy(xpath = "//*[@name='lblSeeAllTitle' and not(@label='Must-have grabs') and not(@label='Browse categories') and not(@label='Weekly ad coupons') and not(@label='We can help') and not(@label='Save on our brands') and @visible='true']")
    public MobileElement aemTitle;

    @AndroidFindBy(id = "itemParentLayout")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[@visible='true']")
    public MobileElement dealCard;

    @AndroidFindBy(id = "description")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCollectionView/XCUIElementTypeCell//XCUIElementTypeButton[@visible='true'])[1]")
    public MobileElement firstDealDescription;

    @AndroidFindBy(id = "description")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell//XCUIElementTypeButton[@visible='true']")
    public List<MobileElement> dealDescription;

}

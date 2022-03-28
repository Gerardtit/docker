package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class BrowsePageElements {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"SHOP\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"SHOP\"]")
    public MobileElement Shop;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@label,\"CTA Label\")]")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,\"CTA Label\")]")
    public MobileElement CTALabel;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label = \"Carousel Title\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Carousel Title\"]")
    public MobileElement CarouselTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[@name=\"viewProductsCollection\"]")
    @AndroidFindBy(id = "aem_list")
    public MobileElement ProductCollectionUIPage;

    // @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"productCell\"]")
    //@AndroidFindBy(xpath = "//*[contains(@content-desc,\"Meals made easy\")]")
    //public MobileElement ProductCell;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"btnClose\"]")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"close\"]")
    public MobileElement btnCloseUI;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@label=\"Weekly Ad\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Weekly Ad\"]")
    public MobileElement weeklyAdButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@label=\"Pharmacy\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Pharmacy\"]")
    public MobileElement pharmacyButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@label=\"Past Purchases\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Past Purchases\"]")
    public MobileElement pastPurchasesButton;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Weekly Ads\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Weekly Ads heading\"]")
    public MobileElement weeklyAdsPageTitle;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Pharmacy\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Pharmacy\"]")
    public MobileElement pharmacyPageTitle;

    @iOSXCUITFindBy(xpath = "//*[@label=\"My List\"]")
    @AndroidFindBy(xpath = "//*[@text=\"My List\"]")
    public MobileElement myListPageTitle;
}
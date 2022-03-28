package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_DashboardMoreServicesPageElements {

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Choose delivery or pickup.\"])")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value == 'Choose delivery or pickup.'")
    public MobileElement DeliveryPickUpPod;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Schedule a refill today.\"])")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,'pharmacy app')]")
    public MobileElement PharmacyPod;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Find local stations and save with fuel points.\"])")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name =='lblDescriptionLabel' AND value == 'Find local stations and save with fuel points.'")
    public MobileElement FuelPod;

    @AndroidFindBy(id = "root_dashboard_help")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'We can help' and visible==1")
    public MobileElement moreServicesModule;

    @AndroidFindBy(id = "iv_arrow")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Delivery') or contains(@name,'Pickup') or contains(@name,'In-')]")
    public MobileElement shoppingModeDownArrow;
}

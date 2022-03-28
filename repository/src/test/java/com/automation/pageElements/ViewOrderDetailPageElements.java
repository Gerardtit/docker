package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.CacheLookup;

public class ViewOrderDetailPageElements {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Order #\"]/following-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(id = "")
    public MobileElement ordernumber;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Order date\"]/following-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(xpath = "")
    @CacheLookup
    public MobileElement orderDate;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Order total\"]/following-sibling::XCUIElementTypeStaticText")
    @AndroidFindBy(xpath = "")
    @CacheLookup
    public MobileElement orderTotalCost;


}

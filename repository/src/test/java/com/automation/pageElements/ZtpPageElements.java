package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ZtpPageElements {

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\":id/txtTitle\")]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Payments\"]")
    public MobileElement paymentsTitle;
}

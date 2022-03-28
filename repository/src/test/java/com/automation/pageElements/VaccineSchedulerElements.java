package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class VaccineSchedulerElements {

    @iOSXCUITFindBy(xpath = "//*[@label=\"Vaccine Scheduler\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"id/tvTitle\")]")
    public MobileElement vaccineSchedulerTitle;
}

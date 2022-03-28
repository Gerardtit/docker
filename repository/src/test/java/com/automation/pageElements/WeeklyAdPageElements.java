package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class WeeklyAdPageElements {

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"webview_tv_title\")]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Weekly Ads\"]")
    public MobileElement weeklyAdTitle;
}

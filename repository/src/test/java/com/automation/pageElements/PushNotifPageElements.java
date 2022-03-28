package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PushNotifPageElements {

    @iOSXCUITFindBy(xpath = "//*[@name=\"NotificationCell\"]")
    @AndroidFindBy(xpath = "//*[@resource-id=\"android:id/big_text\"]")
    public MobileElement allNotif;
}

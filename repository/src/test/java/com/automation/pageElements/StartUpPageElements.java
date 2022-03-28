package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class StartUpPageElements {

    //text = This mobile application uses device caching to improve the user experience.
    @iOSXCUITFindBy(accessibility = "This mobile application uses device caching to improve the user experience.")
    @AndroidFindBy(id = "android:id/message")
    public MobileElement useCacheText;

    //"LEARN MORE" button
    @iOSXCUITFindBy(accessibility = "Learn More")
    @AndroidFindBy(id = "android:id/button2")
    public MobileElement learnMoreButton;

    //"CONTINUE" button
    @iOSXCUITFindBy(accessibility = "Continue")
    //@AndroidFindBy(id = "android:id/button1")
    @AndroidFindBy(id = "btnContinue")
    public MobileElement continueButton;
}

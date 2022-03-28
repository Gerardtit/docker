package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MemberFreshPassPageElements {

    @AndroidFindBy(xpath = "//*[@text=\"Welcome\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Welcome\"]")
    public MobileElement welcomeText;

    @AndroidFindBy(xpath = "//*[@text=\"Daniel\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Daniel\"]")
    public MobileElement firstName;

    @AndroidFindBy(xpath = "//*[@text=\"Danielisalongfirstname\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Danielisalongfirstname\"]")
    public MobileElement longFirstName;

}
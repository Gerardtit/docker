package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_PharmacyPillElements {

    @AndroidFindBy(xpath = "//*[@text=\"Pharmacy\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"View Pharmacy\"]")
    public MobileElement pharmacypill;


    @AndroidFindBy(xpath = "//*[@content-desc=\"Pharmacy heading\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Pharmacy\"]")
    public MobileElement Pharmacypage;


}


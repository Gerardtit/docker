package com.automation.pageElements;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_COACheckoutPageElements {


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    @AndroidFindBy(id = "edit_text")
    public MobileElement textbar;


    @AndroidFindBy(xpath = "//*[@text='Credit On Account' or @id ='creditOnAccount_title' ]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Credit on Account\" or @name=\"Credit on Account\"]")
    //public MobileElement ALLCreditText;
    public MobileElement allcredit;

    // apply coa text
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Apply Credit on Account\" or @label=\"Apply Credit on Account\"]")
    @AndroidFindBy(id = "btn_next")
    public MobileElement applytab;


    // applied coa text
    @iOSXCUITFindBy(xpath = "//*[@label=\"Credit Amount Applied\" or @name=\"Credit Amount Applied\"]")
    @AndroidFindBy(id = "applied_credit")
    public MobileElement appliedtab;


    // navigate to checkout

    @iOSXCUITFindBy(xpath = "//*[@label=\"Checkout\" or @name=\"Checkout\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Close\"]")
    public MobileElement navigateToCheckout;


}



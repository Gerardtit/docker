package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_chatsessionElements {


    @AndroidFindBy(xpath = "//*[@resource-id=\"tcChat_txtInput_input\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Type your question here...\"]")
//    @iOSXCUITFindBy(xpath="//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextView[1]")
//    @iOSXCUITFindBy(xpath=" @name =\"Type your question here...\"and @label=\"Type your question here...\"]")
    public MobileElement editbox;

    @AndroidFindBy(xpath = "//*[@resource-id=\"tcChat_btnSend_img\"]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Send Message\"]")
    public MobileElement enterbutton;

    @AndroidFindBy(xpath = "//android.view.View[1]/android.view.View[1]/android.view.View[5]/android.widget.TextView[1]")
//    @AndroidFindBy(xpath="//*[@text="Edit Date/Time"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Edit Date/Time\" and @label=\"Edit Date/Time\" and @name=\"Edit Date/Time\"]")
    public MobileElement editdatentime;

    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"CONFIRM CHANGES\" and @content-desc=\"Place Order\"]")
//   @AndroidFindBy(xpath="//android.widget.Button[@text=\"CONFIRM CHANGES\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Confirm Changes\"]")
    public MobileElement confirmchanges;

    //   @AndroidFindBy(xpath="//*[@content-desc=\"See Results\"]")
    @AndroidFindBy(xpath = "(//android.view.View/android.view.View[4])[2]")
//    @AndroidFindBy(xpath= "//android.view.View[@text=\"See Results\"]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"See Results\"]")
    public MobileElement seeresult;


    //       @AndroidFindBy(xpath="//*[@content-desc=\"View Product Details\"]")
//      @iOSXCUITFindBy(xpath="//XCUIElementTypeOther[3]/XCUIElementTypeOther[1]/XCUIElementTypeLink[1]/XCUIElementTypeStaticText[1]")
    @iOSXCUITFindBy(xpath = "//*[@value=\"View Product Details\" and @label = \"View Product Details\"]")
    @AndroidFindBy(xpath = "//android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[3]")
    public MobileElement viewProduct;


}


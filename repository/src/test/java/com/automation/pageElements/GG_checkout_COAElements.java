package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_checkout_COAElements {
    @AndroidFindBy(xpath = "//*[@content-desc=\"Apply Credit On Account link\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@label,\"Apply credit on account\")]")
    public MobileElement postCOActa;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Apply Credit On Account link\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@label,\"Apply credit on account\")]")
    public MobileElement COActa;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Total credit on account\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Total credit on account\"]")
    public MobileElement totalCOA;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[10]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]")
    @AndroidFindBy(xpath = "//*[@text=\"No\"]")
    public MobileElement totalamount;

    @iOSXCUITFindBy(xpath = "//*[@value=\"Apply\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Apply\"]")
    public MobileElement applytext;


    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.EditText[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    public MobileElement COAeditbox;

    @AndroidFindBy(xpath = "//*[@content-desc=\"CREDITAPPLIED\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"CREDITAPPLIED\")]")
    public MobileElement creditapplied;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[4]/android.widget.ImageView[1]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"closeButton\"]")
    public MobileElement closecreditapply;


}


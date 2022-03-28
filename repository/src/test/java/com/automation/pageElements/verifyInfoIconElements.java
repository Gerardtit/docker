package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class verifyInfoIconElements {

    //info icon at checkout page beside estimated total
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Estimated Total, Info\" or @name=\"Estimated Total, Info\"]")
//    @iOSXCUITFindBy(xpath = "//*[@label=\"Estimated Total, Info\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Estimated Total, info.\"]")
    public MobileElement infoIconAtCheckout;

    //estimated total page
    @iOSXCUITFindBy(xpath = "//*[@label=\"Estimated Total\"]")
    @AndroidFindBy(id = "info_txt")
    public MobileElement EstimatedTotalPage;

    //Done at estimated page
    @iOSXCUITFindBy(xpath = "//*[@label=\"Done\"]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Close\"]")
    public MobileElement DoneAtEstimatedPage;

    //complete info text
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]")
//  @iOSXCUITFindBy(xpath = "//*[ends-with(@name,' Deductions')and (@label,\" Deductions\")]")
    @AndroidFindBy(xpath = "//*[@class=\"android.widget.ScrollView\"]//*[@class=\"android.view.ViewGroup\"]")
    public MobileElement infoText;

    //complete info text
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]")
//  @iOSXCUITFindBy(xpath = "//*[ends-with(@name,' Deductions')and (@label,\" Deductions\")]")
    @AndroidFindBy(xpath = "//*[@class=\"android.widget.ScrollView\"]//*[@class=\"android.view.ViewGroup\"]")
    public MobileElement AfterinfoText;

    //info icon at order confirmation page
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Estimated Total, Info\" or @name=\"Estimated Total, Info\" and @visible=\"true\"]")
//  @iOSXCUITFindBy(xpath = "//*[@label=\"Estimated Total, Info\"and @name=\"Estimated Total, Info\" ]")
    @AndroidFindBy(xpath = "//*[@content-desc=\"Estimated Total, info.\"]")
    //id="infoImg"
    public MobileElement infoIconAtOrder;

    //entire item frame
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[1]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]")
//   @AndroidFindBy(xpath= "//android.widget.FrameLayout[1]/android.widget.Button[1]")
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout[1]/android.widget.Button[1]")
//    @AndroidFindBy(xpath= "//*[@content-desc=\"Blueberries Prepackaged - 6 Oz.\" or @id=\"itemParentLayout\"]")
    public MobileElement firstItemFrame;

    //Add to cart button
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label=\"Add to Cart\"]")
    @AndroidFindBy(xpath = "//*[@text=\"CONTINUE\"]")
    public MobileElement addToCartButton;


}

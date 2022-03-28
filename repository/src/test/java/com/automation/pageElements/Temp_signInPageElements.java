package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.CacheLookup;

public class Temp_signInPageElements {
    //May be later
    @iOSXCUITFindBy(xpath = "//*[@label=\"Maybe Later\"]")
    public MobileElement clickMaybeLater;
    //text = This mobile application uses device caching to improve the user experience.
    @iOSXCUITFindBy(xpath = "//*[@label=\"Allow\"]")
    @AndroidFindBy(xpath = "//*[@text=\"CONTINUE\"]")
    public MobileElement ClickCacheText;

    // click Dismiss
//    @iOSXCUITFindBy(xpath = "//*[@label=\"Dismiss\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Dismiss\"]")
    @AndroidFindBy(xpath = "//*[@text='DISMISS']")
    public MobileElement clickDismiss;

    // To click Next Button
    @AndroidFindBy(xpath = "//*[@text='Next']")
    public MobileElement ClickNextButton;

    // click pickup next button
    @iOSXCUITFindBy(xpath = "//*[@name=\"btnNext-Pick up tool tip\"]")
    public MobileElement pickUpNextButton;

    // to click deals next button
    @iOSXCUITFindBy(xpath = "//*[@name=\"btnNext-Deals tool tip\"]")
    public MobileElement dealsNextButton;

    // To Click Wallet next button
    @iOSXCUITFindBy(xpath = "//*[@name=\"btnNext-Wallet tool tip\"]")
    public MobileElement walletButton;

    // To verify HomePage
    @iOSXCUITFindBy(xpath = "//*[@label=\"User profile\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"iv_user_avatar\")]")
    public MobileElement menuButton;

    //zipcode input
//    @iOSXCUITFindBy(accessibility = "Zip Code")
//    @AndroidFindBy(id = "edit_text")
    @iOSXCUITFindBy(xpath = "//*[@label=\"ZIP Code\"]")
    @AndroidFindBy(xpath = "//*[@text='ZIP Code']")
    public MobileElement zipCodeEditText;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Allow'")
    // @AndroidFindBy(id = "iv_user_avatar")
    public MobileElement Allow;

    //click Start shopping
    @iOSXCUITFindBy(xpath = "//*[@value=\"Start shopping\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Start shopping\"]")
    public MobileElement startShopping;

    //"ShoppingMode" button
    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"address\")]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"tv_shopping_mode\")]")
    public MobileElement clickShoppingMode;

    // Enter Zipcode in Zipcode page
    @iOSXCUITFindBy(xpath = "//*[@label=\"Zip Code\"]")
    @AndroidFindBy(id = "edit_text")
    @CacheLookup
    public MobileElement ZipodeEditText;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Search For Dug Store' AND visible == 1")
    @AndroidFindBy(id = "btn_next")
    @CacheLookup
    public MobileElement searchZipCodeButton;


    @iOSXCUITFindBy(xpath = "//*[@label=\"Shop in-store or make your list\"]")
    @AndroidFindBy(id = "instore_title")
    public MobileElement InStore;

    @iOSXCUITFindBy(xpath = "//*[@value=\"Selected\"]//XCUIElementTypeOther")
    public MobileElement InStoreSelected;

    // Hulen Instore
    @AndroidFindBy(xpath = "//*/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[2]/android.widget.ImageView[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[5]/XCUIElementTypeImage[1]")
    public MobileElement InstoreTomthumb;
}

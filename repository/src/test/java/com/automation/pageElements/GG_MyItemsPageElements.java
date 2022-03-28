package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_MyItemsPageElements {

    //@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'Allow'")
    @iOSXCUITFindBy(xpath = "//*[@label='Allow']")
    //@iOSXCUITFindBy(iOSNsPredicate = "label == \"Allow\"")
    @AndroidFindBy(xpath = "//android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.Button[2]")
    public MobileElement allowNotificationButton;

    // @iOSXCUITFindBy(xpath ="//*[@label='Dismiss']")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Dismiss\"")
    @AndroidFindBy(accessibility = "Dismiss")
    public MobileElement dismissAlert;

    @AndroidFindBy(xpath = "//*[@text=\"MY ITEMS\"] | //*[@text=\"MY LIST\"]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"MY LIST\"")
    public MobileElement myItemsTab;

    @AndroidFindBy(xpath = "//*[@text='My List'] | //*[contains(@text, 'My Items')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"My List\"")
    public MobileElement myListTitle;

    @AndroidFindBy(accessibility = "Clipped deals")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Clipped deals Tab, 3 of 4' and visible==1")
    public MobileElement clippedDealstab;

    @AndroidFindBy(xpath = "//*[@text=\"Last order\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label, \"Last Order\")]")
    public MobileElement myLastOrderTitle;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[1]/android.widget.FrameLayout[3]/android.widget.Button[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[2]/XCUIElementTypeButton[1]")
    public MobileElement itemsFoundonPastPurchase;

    @AndroidFindBy(xpath = "//androidx.drawerlayout.widget.DrawerLayout[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[1]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]")
    public MobileElement pdpScreen;

    @iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton' AND name=='Deals' AND value CONTAINS 'o'")
    @AndroidFindBy(id = "dealsToggle")
    public MobileElement dealsToggleSwitch;

    @iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton' AND name=='Deals' AND value CONTAINS 'o'")
    @AndroidFindBy(id = "dealsToggle")
    public List<MobileElement> dealToggleSwitch;

    @AndroidFindBy(id = "button_allPastPurchases")
    @iOSXCUITFindBy(accessibility = "All Past Purchases")
    public MobileElement allPastPurchasesTab;

    @AndroidFindBy(xpath = "//*[@text=\"Last order\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label, \"Last Order\")]")
    public MobileElement myLastOrderTab;

    @AndroidFindBy(accessibility = "close")
    @iOSXCUITFindBy(id = "closeGray")
    public MobileElement closeToggle;
}

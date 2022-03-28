package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SortFilterPageElements {
    //Sort & Filter title
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Sort & Filter'")
    @AndroidFindBy(accessibility = "Cancel Sort or Filter page.")
    public MobileElement sortFilterTitle;

    //Done or close button
    @iOSXCUITFindBy(accessibility = "Done")
    @AndroidFindBy(id = "btnSave")
    public MobileElement saveSortFilterPage;

    //Sort By text
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[3]")
    @AndroidFindBy(id = "selectedSortText")
    public MobileElement selectSortText;


    //Sort By text
    //@iOSXCUITFindBy(xpath = "//*[@label=\"Sort & Filter Options\"]")
    @iOSXCUITFindBy(accessibility = "Sort & Filter Options")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.ImageView[1]")
    public MobileElement sortfilterIcon;

    //Sort & Filter By window title
    @iOSXCUITFindBy(className = "XCUIElementTypeNavigationBar")
    @AndroidFindBy(id = "app_bar_title")
    public MobileElement sortByWindowTitle;

    //Best Match
    @iOSXCUITFindBy(accessibility = "Best Match")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Best Match\")")
    public MobileElement selectBestMatch;

    //Club Card Special
    @iOSXCUITFindBy(accessibility = "Reward Card Specials")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sale Prices\")")
    public MobileElement selectClubCardSpecial;

    @iOSXCUITFindBy(accessibility = "Reward Card Specials")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Reward Card Specials\")")
    //   @AndroidFindBy(xpath = "//*[@text=\"Reward Card Specials\"]"
    public MobileElement selectRewardCardSpecial;

    // @iOSXCUITFindBy(accessibility = "Reward Card Specials")
    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[2]")
    public MobileElement SortByOptions;

    //Most popular
    @iOSXCUITFindBy(accessibility = "Most Popular")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Most Popular\")")
    public MobileElement selectMostPopular;

    //Price Low to High
    @iOSXCUITFindBy(accessibility = "Price Low to High")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Price: Low to High\")")
    public MobileElement selectPriceLowToHigh;

    //Alphabetical
    @iOSXCUITFindBy(xpath = "//*[@label=\"Alphabetical\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Alphabetical\"]")
    public MobileElement selectAlphabetical;

}

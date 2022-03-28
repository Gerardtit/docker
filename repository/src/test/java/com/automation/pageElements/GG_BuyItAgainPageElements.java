package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_BuyItAgainPageElements {
    // Click Buy It Again Tab
    @AndroidFindBy(xpath = "//*[@text=\"Buy it again\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label, \"Buy it again\")]")
    public MobileElement buyItAgainTab;

    //Refine Button
    @iOSXCUITFindBy(xpath = "//*[@name=\"btnRefine\"]|//*[@label=\"Refine\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"debug:id/tv_category_refine\")]")
    public MobileElement clickOnRefineButton;

    // Refine window
    @iOSXCUITFindBy(xpath = "(//*[@name=\"lblRefineTableHeaderViewTitle\"])[1]|(//*[@label=\"Refine\"])[1]")
    @AndroidFindBy(xpath = "//*[@text=\"Refine\"]")
    public MobileElement refineWindowTitle;

    // Clipped Deals
    @AndroidFindBy(xpath = "//*[@text=\"Clipped deals\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label, \"Clipped deals\")]")
    public MobileElement clippedDealsTab;

    // Last Order
    @AndroidFindBy(xpath = "//*[@text=\"Last Order\"]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label, \"Last Order\")]")
    public MobileElement lastOrderTab;

    // Buy It Again Page Description
    @AndroidFindBy(xpath = "//*[contains(@resource-id, \"id/loading_tv\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label, \"If you have past purchases, they’ll show up in your account shortly\")]")
    public MobileElement buyItAgainPageDescription;

    // View All Pill
    @iOSXCUITFindBy(xpath = "//*[contains(@label, \"View All selected\")]")
    @AndroidFindBy(xpath = "//*[@text=\"View All selected\"]")
    public MobileElement viewAllPill;

    //Click on "Dairy, Eggs and cheese pill"
    @iOSXCUITFindBy(xpath = "//*[contains(@label, \"Dairy, Eggs & Cheese\")]")
    @AndroidFindBy(xpath = "//*[@text=\"Dairy, Eggs & Cheese\"]")
    public MobileElement dairyEggsCheesePill;

    // Click on Beverages Pill
    @iOSXCUITFindBy(xpath = "//*[contains(@label, \"Beverages\")]")
    @AndroidFindBy(xpath = "//*[@text=\"Beverages\"]")
    public MobileElement beveragesPill;

    // Click Wine, Beer and Spirits
    @iOSXCUITFindBy(xpath = "//*[contains(@label, \"Wine, Beer & Spirits\")]")
    @AndroidFindBy(xpath = "//*[@text=\"Wine, Beer & Spirits\"]")
    public MobileElement wineBeerSpiritsPill;

    // Click on Cookies, Snacks & Candies
    @iOSXCUITFindBy(xpath = "//*[contains(@label, \"Cookies, Snacks & Candy\")]")
    @AndroidFindBy(xpath = "//*[@text=\"Cookies, Snacks & Candy\"]")
    public MobileElement cookiesSnacksCandiesPill;

    // Click on Fruits & Vegetables
    @iOSXCUITFindBy(xpath = "//*[contains(@label, \"Fruits & Vegetables\")]")
    @AndroidFindBy(xpath = "//*[@text=\"Fruits & Vegetables\"]")
    public MobileElement fruitsVegetablesPill;

    //Click on Frozen Foods
    @iOSXCUITFindBy(xpath = "//*[contains(@label, \"Frozen Foods\")]")
    @AndroidFindBy(xpath = "//*[@text=\"Frozen Foods\"]")
    public MobileElement frozenFoodsPill;

    // Frequently Purchase option
    @iOSXCUITFindBy(xpath = "//*[@label=\"Frequently Purchased\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Frequently Purchased\"]")
    public MobileElement sortByFrequentlyPurchase;

    // Purchased Date
    @iOSXCUITFindBy(xpath = "//*[@label=\"Purchased date\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Purchased Date\"]")  // checked - true
    public MobileElement sortByPurchaseDate;

    // Filter By In-Store
    @iOSXCUITFindBy(xpath = "//*[contains(@label, \"In-Store\")]")
    @AndroidFindBy(xpath = "//*[contains(@text, \"In-Store\")]")
    public MobileElement filterByInStore;

    // Instore Selected by Default
    @iOSXCUITFindBy(xpath = "//*[@label=\"Show In-Store selected, \"]")
    public MobileElement instoreOptionSelected;

    // Filter By Online
    @iOSXCUITFindBy(xpath = "//*[contains(@label, \"Online\")]")
    @AndroidFindBy(xpath = "//*[contains(@text, \"Online\")]")
    public MobileElement filterByOnline;

    // Online Selected by Default
    @iOSXCUITFindBy(xpath = "//*[@label=\"Show Online selected, \"]")
    public MobileElement onlineOptionSelected;

    // Apply
    @AndroidFindBy(xpath = "//*[contains(@text, \"Apply\")]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"btnRefineShowResults\"]|//*[@name=\"Apply\"]|//*[@label=\"Apply\"]")
    public MobileElement applyButton;

    // verify Products Displayed
    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"image\")]")
    public MobileElement buyItAgainProductsDisplayed;

    // Purchase Date - Last Order
    @AndroidFindBy(xpath = "//*[contains(@text, \"Last Order\")]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Last Order\"]")
    public MobileElement lastOrderPurchaseDate;

    // Purchase Date - All Past Months
    @AndroidFindBy(xpath = "//*[contains(@text, \"Past\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label, \"Past\")]")
    public List<MobileElement> pastmonthsPurchaseDate;

    // Purchase Date - Past 13 Months
    @AndroidFindBy(xpath = "//*[contains(@text, \"Past 13 months\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label, \"Past 13 months\")]")
    public MobileElement past13monthsPurchaseDate;

}

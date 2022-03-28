package com.automation.pageElements;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class BrowserCategoryPageElements {


    //browser category at homepage
    @AndroidFindBy(id = "tv_browse_by_aisle")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Browse categories\"]")
    public MobileElement browserAtHomePage;


    //    see all at homepage
    @iOSXCUITFindBy(xpath = "//*[@label=\"See all\"]")
    @AndroidFindBy(id = "tv_see_all")
    public MobileElement seeAll;


    //    browserPage search bar
    @iOSXCUITFindBy(xpath = "//*[@label=\"Search bar\"]")
    @AndroidFindBy(id = "tv_browse_search_bar")
    public MobileElement browserPageSearchTab;

    //    browserPage searchIcon
    @iOSXCUITFindBy(xpath = "//*[@label=\"Search icon\"]")
    @AndroidFindBy(id = "iv_browse_search")
    public MobileElement browserPageSearchIcon;

    //    browserPage BabyCare
    @iOSXCUITFindBy(xpath = "//*[@label=\"Baby Care. Collapsed.\"]")
    //*[@content-desc="Baby Care  Collapsed"]
    //@text[contains(.,'Baby Care')]
    @AndroidFindBy(xpath = "//*[@text=\"Baby Care\"]")

    public MobileElement browserPageBaByCare;

    //    browserPage Beverage
    @iOSXCUITFindBy(xpath = "//*[@label=\"Beverages. Collapsed.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Beverages\"]")
    public MobileElement browserPageBeverage;

    //    browserPage Bread
    @iOSXCUITFindBy(xpath = "//*[@label=\"Bread & Bakery. Collapsed.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Bread & Bakery\"]")
    public MobileElement browserPageBakery;

    //    browserPage cereal
    @iOSXCUITFindBy(xpath = "//*[@label=\"Breakfast & Cereal. Collapsed.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Breakfast & Cereal\"]")
    public MobileElement browserPageCereal;

    //    browserPage Canned soups
    @iOSXCUITFindBy(xpath = "//*[@label=\"Canned Goods & Soups. Collapsed.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Canned Goods & Soups\"]")
    public MobileElement browserPageCannedSoup;

    //    browserPage Spicesn Bake
    @iOSXCUITFindBy(xpath = "//*[@label=\"Condiments, Spice & Bake. Collapsed.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Condiments, Spice & Bake\"]")
    public MobileElement browserPageSpiceNBake;

    //    browserPage cookies
    @iOSXCUITFindBy(xpath = "//*[@label=\"Cookies, Snacks & Candy. Collapsed.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Cookies, Snacks & Candy\"]")
    public MobileElement browserPagecookies;

    //    browserPage cart icon
    @AndroidFindBy(id = "iv_cart")
    @iOSXCUITFindBy(xpath = "//*[@label=\"List\"]|//*[@label=\"Cart\"]")
    //    @iOSXCUITFindBy(xpath = "//*[@label=\"Cart\"]")
//    @AndroidFindBy(id = "iv_cart")
    public MobileElement browserPageCartIcon;

    //    browserPage Dairy
    @iOSXCUITFindBy(xpath = "//*[@label=\"Dairy, Eggs & Cheese. Collapsed.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Dairy, Eggs & Cheese\"]")
    public MobileElement browserPageDairy;

    //    browserPage Deli
    @iOSXCUITFindBy(xpath = "//*[@label=\"Deli. Collapsed.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Deli\"]")
    public MobileElement browserPageDeli;

    //    browserPage Flower
    @iOSXCUITFindBy(xpath = "//*[@label=\"Flowerstest. Collapsed.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Flowerstest\"]")
    public MobileElement browserPageFlower;

    //    browserPage FruitsNVeg
    @iOSXCUITFindBy(xpath = "//*[@label=\"Fruits & Vegetables. Collapsed.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Fruits & Vegetables\"]")
    public MobileElement browserPageFruitsNVeg;

    //    browserPage FrozenFood
    @iOSXCUITFindBy(xpath = "//*[@label=\"Frozen Foods. Collapsed.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Frozen Foods\"]")
    public MobileElement browserPageFrozen;

    //    browserPage GrainsNPasta
    @iOSXCUITFindBy(xpath = "//*[@label=\"Grains, Pasta & Sides. Collapsed.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Grains, Pasta & Sides\"]")
    public MobileElement browserPageGrainNPasta;

    //    browserPage InternationalCuisine
    @iOSXCUITFindBy(xpath = "//*[@label=\"International Cuisine. Collapsed.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"International Cuisine\"]")
    public MobileElement browserPageInternationalCuisine;

    //    browserPage MeatNSeafood
    @iOSXCUITFindBy(xpath = "//*[@label=\"Meat & Seafood. Collapsed.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Meat & Seafood\"]")
    public MobileElement browserPageMeatNSeafood;


    //    browserPage cleaning
    @iOSXCUITFindBy(xpath = "//*[@label=\"Paper, Cleaning & Home. Collapsed.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Paper, Cleaning & Home\"]")
    public MobileElement browserPagecleaning;

    //    browserPage PetCare
    @iOSXCUITFindBy(xpath = "//*[@label=\"Pet Care. Collapsed.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Pet Care\"]")
    public MobileElement browserPagePetCare;

    //    browserPage Personal CAre
    @iOSXCUITFindBy(xpath = "//*[@label=\"Personal Care & Health. Collapsed.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Personal Care & Health\"]")
    public MobileElement browserPagePersonalCare;

    //    browserPage Tobacco
    @iOSXCUITFindBy(xpath = "//*[@label=\"Tobacco. Collapsed.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Tobacco\"]")
    public MobileElement browserPageTobacco;

    //    browserPage Wine
    @iOSXCUITFindBy(xpath = "//*[@label=\"Wine, Beer & Spirits. Collapsed.\"]")
    @AndroidFindBy(xpath = "//*[@text=\"Wine, Beer & Spirits\"]")
    public MobileElement browserPagewine;

}

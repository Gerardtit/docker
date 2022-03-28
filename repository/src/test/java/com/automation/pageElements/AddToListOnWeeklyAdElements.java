package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;

public class AddToListOnWeeklyAdElements {
    // WeeklyAd Button Element from HaloNav
    @AndroidFindBy(xpath = "//*[@text=\"VIEW WEEKLY AD - Browse the Weekly Ad & create a shopping list\"]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"VIEW WEEKLY AD - Browse the Weekly Ad & create a shopping list\"]")
    public MobileElement viewWeeklyAdButton;

    @AndroidFindBy(xpath = "//android.view.View[1]/android.widget.Button[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeButton[3]")
    public MobileElement weeklyAd3rd;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"back\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"btnTopNavBarWithHintLeft\"]")
    public MobileElement backToWeekAdPDF;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"back\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"btnTopNavBarLeft\"]")
    public MobileElement backToNavBarBtn;


    @AndroidFindBy(xpath = "//*[starts-with(@text,'Fresh Express Salad Kit or Blend, Taylor Farms Chopped Salad Kit or Signature Farms® Snacking Tomatoes')]")
    @iOSXCUITFindBy(xpath = "//*[starts-with(@text,'Fresh Express Salad Kit or Blend, Taylor Farms Chopped Salad Kit or Signature Farms® Snacking Tomatoes')]")
    public MobileElement freshExpressSaladKitTwoForSix1;

    @AndroidFindBy(xpath = "//*[@text=\"Add to list\"]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"Add to list\"]")
    public MobileElement addToListButton;

    @AndroidFindBy(xpath = "//*[@text=\"Remove from List\"]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"Remove from list\"]")
    public MobileElement removeFromListButton;

    @AndroidFindBy(xpath = "//*[@text=\"MY LIST\"]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"MY LIST\"]")
    public MobileElement myListTab;

    @AndroidFindBy(xpath = "//*[@text=\"Clipped deals\"]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"Clipped deals\"]")
    public MobileElement clippedDeals;


    @AndroidFindBy(id = "tv_store_details_header")
    @iOSXCUITFindBy(xpath = "(//*[@name=\"lblExpandableSectionHeaderTitle-0\"])[1]")
    public MobileElement addedItemsList;

    @AndroidFindBy(xpath = "//*[contains(@content-desc ,\"Valid\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@label ,\"Valid\")]")
    public MobileElement validityDate;

    @AndroidFindBy(xpath = "//*[@text=\"Fruits & Vegetables (1)\"]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"Fruits & Vegetables (1)\"]")
    public MobileElement fruitsAndVegetablesList;

    @AndroidFindBy(xpath = "//*[@text=\"Fresh Express Salad Kit, Taylor Farms Chopped Salad Kit or Signature Farms® Snacking Tomatoes\"]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"Fresh Express Salad Kit, Taylor Farms Chopped Salad Kit or Signature Farms® Snacking Tomatoes\"]")
    public MobileElement verifyFreshExpressSaladKitTwoForSix;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"imgWeeklyAdFlyer\"])[2]")
    @AndroidFindBy(xpath = "(//*[contains(@id,’FlyerPreview’)])[1]")
    public MobileElement flyerPreview;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name])[2]")
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc])[2]")
    public MobileElement flyerSpecificOffer;


    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name])[2]")
    @AndroidFindBy(xpath = "(//android.view.View)[2]")
    public MobileElement clickOnFlyerOffer;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name])[2]")
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc])[2]")
    public By flyerSpecificOfferBy;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"lblTopNavBarWithHintTitle\"]")
    @AndroidFindBy(xpath = "//*[@text='Weekly Ad']")
    public MobileElement weeklyAdHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"lblTopNavBarWithHintHint\"]")
    @AndroidFindBy(xpath = "//*[@text='Weekly Ad']")
    public MobileElement weeklyAdDate;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Weekly Ad\"]")
    @AndroidFindBy(xpath = "//*[@text='Weekly Ad']")
    public By weeklyAdHeaderBy;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView[@name=\"scrollView\"]")
    @AndroidFindBy(xpath = "android.widget.ScrollView")
    public MobileElement scrollView;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Meat & Seafood\"]")
    @AndroidFindBy(xpath = "//*[@text='Weekly Ad']")
    public MobileElement menuItemMeatSeafood;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"lblTopNavBarWithHintHint\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'weekly_ad_date')]")
    public MobileElement weeklyAdDateRange;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[1]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'offer_img')]")
    public MobileElement weeklyAdProductImage;


    @iOSXCUITFindBy(xpath = "///XCUIElementTypeStaticText[@name=\"Weekly Ad\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'offer_type_txt')]")
    public MobileElement weeklyAdSubHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[3]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'offer_price')]")
    public MobileElement weeklyAdOfferPrice;

    @iOSXCUITFindBy(xpath = "///XCUIElementTypeStaticText[@name=\"Weekly Ad\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'offer_title')]")
    public MobileElement weeklyAdProductName;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'offer_desc')]")
    public MobileElement weeklyAdProductDescription;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[4]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'offer_expiry_date')]")
    public MobileElement weeklyAdOfferExpiryDate;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Only valid at:\"]")
    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tv_valid')]")
    public MobileElement weeklyAdOfferValidText;

    @AndroidFindBy(xpath = "//*[@text='Weekly Ads']")
    @iOSXCUITFindBy(xpath = "//*[@label='Weekly Ads' and @name='lblTopNavBarTitle']")
    public MobileElement weeklyAdsTitle;

    @AndroidFindBy(xpath = "(//*[contains(@resource-id,'FlyerPreview')])[1]")
    @iOSXCUITFindBy(xpath = "(//*[@name='imgWeeklyAdFlyer'])[1]")
    public MobileElement firstAdBanner;

    @AndroidFindBy(xpath = "//com.flipp.sfml.views.SourceImageView//android.view.View[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeScrollView//XCUIElementTypeButton)[1]")
    public MobileElement firstItemOfBanner;

    @AndroidFindBy(id = "btn_add_to_list")
    @iOSXCUITFindBy(xpath = "//*[@value=\"Add to list\"]")
    public MobileElement addToListBtn;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'deal_detail_container')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\" Offer Details\"]")
    public MobileElement offerDetailsContainer;

    @AndroidFindBy(xpath = "//*[@content-desc=\"Close Offer Details\"]")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Close Offer Details\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar[1]/XCUIElementTypeButton[1]")
    public MobileElement closeOfferDetailsBtn;

    @AndroidFindBy(xpath = "//*[@text='Offer Details']")
    @iOSXCUITFindBy(xpath = "//*[@name='Offer Details']")
    public MobileElement offerDetailsLabel;

    @AndroidFindBy(xpath = "//*[contains(@text,'Disclaimer : Not all offers are redeemable in store')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Not all offers are redeemable in store')]")
    public MobileElement disclaimerSection;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Pickup' AND visible == 1")
    @AndroidFindBy(id = "pickup_title")
    @CacheLookup
    public MobileElement pickUpButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'type_delivery_card')]")
    @CacheLookup
    public MobileElement deliveryButton;

    @AndroidFindBy(id = "dug_address_container")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[@name=\"viewStoreCard\"])[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    public MobileElement selectPickUpStoreBtn;

}

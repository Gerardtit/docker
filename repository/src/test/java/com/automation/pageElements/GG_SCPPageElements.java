package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_SCPPageElements {

    //This is the CartCard Elements

    @AndroidFindBy(id = "tv_cart_title_price")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS[c] 'Total Price'")
    public MobileElement netPromotionPriceText;

    @AndroidFindBy(id = "subtotalText")
    @iOSXCUITFindBy(accessibility = "lblCartEstSubtotalValue")
    public MobileElement estSubTotalPrice;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'cl_stepper')]")
    @iOSXCUITFindBy(accessibility = "btnRoundQuantity")
    public MobileElement quantityIcon;


    @AndroidFindBy(id = "iv_checkMark")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'btnAppliedOffer'")
    public MobileElement promotionAppliedIcon;

    @AndroidFindBy(id = "tv_offer")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'btnClippedOffer'")
    public MobileElement promotionClippedIcon;


    @iOSXCUITFindBy(iOSNsPredicate = "name == 'btnStepperView'")
    public MobileElement stepperView;

    @AndroidFindBy(id = "iv_stepper_plus")
    public MobileElement plusIconStepper;

    @AndroidFindBy(id = "tv_strike_price")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS[c] 'Total Price'")
    public MobileElement strikethroughPriceText;

    @AndroidFindBy(id = "tvCartSummary")
    @iOSXCUITFindBy(id = "lblCartSummary")
    public MobileElement cartSummaryLabel;

    @AndroidFindBy(id = "PENDING")
    @iOSXCUITFindBy(id = "PENDING")
    public MobileElement dealsDescriptionCartCard;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,'Total Price is') and @visible='true']")
    public MobileElement price;

    @AndroidFindBy(id = "tv_cart_title_price")
    public MobileElement totalPriceOfProduct;

    @AndroidFindBy(id = "tv_each_price")
    public MobileElement priceOfEachProductCount;

    @AndroidFindBy(id = "tv_strike_price")
    public MobileElement strikeThroughOriginalPrice;

    @iOSXCUITFindBy(xpath = "//*[@name='btnClippedOffer' and @visible='true']")
    public MobileElement offerClippedIOS;

    @iOSXCUITFindBy(xpath = "//*[@name='btnAppliedOffer' and @visible='true']")
    public MobileElement offerAppliedIOS;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'_offer_item')]")
    public MobileElement offerClippedAppliedAndroid;

}

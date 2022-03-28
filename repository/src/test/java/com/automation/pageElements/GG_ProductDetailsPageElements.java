package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_ProductDetailsPageElements {
    @AndroidFindBy(id = "tvTotalItemCount")
    @iOSXCUITFindBy(accessibility = "Cart")
    public MobileElement cartInProductDetailPage;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Cancel' AND visible==1")
    @AndroidFindBy(id = "tv_search_cancel")
    public MobileElement cancelButton;

    @AndroidFindBy(id = "btnAdd")
    @iOSXCUITFindBy(iOSNsPredicate = "label contains 'Add to ' AND type == 'XCUIElementTypeButton'")
    public MobileElement addToCartButton;

    @AndroidFindBy(id = "btnPlus")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Increment quantity'")
    public MobileElement incrementQuantity;

    @AndroidFindBy(id = "tvQuantity")
    @iOSXCUITFindBy(id = "Quantity")
    public MobileElement currentAddedQuantity;

    @AndroidFindBy(id = "btnMinus")
    @iOSXCUITFindBy(id = "Decrement quantity")
    public MobileElement decrementQuantity;

    @AndroidFindBy(xpath = "//*[@content-desc='Navigate up' or @content-desc='Close']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeNavigationBar/XCUIElementTypeButton)[1]")
    public MobileElement backButton;

    @AndroidFindBy(id = "isProductOutOfStock")
    @iOSXCUITFindBy(id = "This item is currently Out of Stock")
    public MobileElement outOfStockLabel;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Related Products\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Related Products' and visible ==1")
    public MobileElement relatedProductsLabel;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"View All\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'View All' and visible ==1")
    public MobileElement relatedProductsViewAllLink;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"DISMISS\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Dismiss' AND visible == 1")
    public MobileElement serviceProblemDismiss;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"DISMISS\")")
    @iOSXCUITFindBy(accessibility = "Offer Details")
    public List<MobileElement> dealOfferDetails;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'button_clip')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS[c] 'Clip'")
    public List<MobileElement> dealsOffersList;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'button_clip')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS[c] 'Clip'")
    public MobileElement firstDealOffer;

    @AndroidFindBy(uiAutomator = "PENDING")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Clip Deal' and name ==  'Clip Deal' and value == 'Clip Deal'")
    public MobileElement clipDealBtnDetails;

    @AndroidFindBy(uiAutomator = "PENDING")
    @iOSXCUITFindBy(accessibility = "CloseOffer Details")
    public MobileElement closeBtnDealDetails;
}

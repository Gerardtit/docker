package com.automation.pageElements.meals.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ShopIngredientsPageElements {

    //Todo - pending verification of unused elements, keeping for using it in future automation scenarios

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/prompt-primary-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/prompt-primary-button\"]")
    public MobileElement shopForDeliveryOrPickup;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/prompt-sheet\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/prompt-sheet\"]")
    public MobileElement promptSheet;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/prompt-secondary-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/prompt-secondary-button\"]")
    public MobileElement addIngredientsToMyList;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/shop-ingredients-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/shop-ingredients-button\"]")
    public MobileElement shopIngredientsButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/add-to-cart-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/add-to-cart-button\"]")
    public MobileElement addProductsToCartButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/shop-item-0-amount-plus\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/shop-item-0-amount-plus\"]")
    public MobileElement quantityButtonPlus;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/shop-item-0-amount-minus\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/shop-item-0-amount-minus\"]")
    public MobileElement quantityButtonMinus;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/shop-item-0-swap\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/shop-item-0-swap\"]")
    public MobileElement swapButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/navbar-header\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/navbar-header\"]")
    public MobileElement pageTitle;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/shop-item-0\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/shop-item-0\"]")
    public MobileElement shopItem;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/shop-item-0-show-product-name\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/shop-item-0-show-product-name\"]")
    public MobileElement shopItemProductName;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/shop-item-0-show-product-img\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/shop-item-0-show-product-img\"]")
    public MobileElement shopItemProductImage;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/shop-plan\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/shop-plan\"]")
    public MobileElement shopPlanPage;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/close-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/close-button\"]")
    public MobileElement closeButtonOnPromptSheet;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/prompt-primary-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/prompt-primary-button\"]")
    public MobileElement goToCartToCheckoutButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/prompt-secondary-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/prompt-secondary-button\"]")
    public MobileElement viewMyMealsButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/add-to-my-list-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/add-to-my-list-button\"]")
    public MobileElement addItemsToMyListButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/shop-ingredients-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/shop-ingredients-button\"]")
    public MobileElement itemsInReviewList;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/shop-ingredients-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/shop-ingredients-button\"]")
    public MobileElement itemsInReviewListCheckBox;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/prompt-primary-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/prompt-primary-button\"]")
    public MobileElement showMyListButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/prompt-secondary-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/prompt-secondary-button\"]")
    public MobileElement backToMealsButton;

    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Checkout\" AND name == \"btnCartCheckout\"")
    @AndroidFindBy(xpath = "//*[@text='Checkout']")
    public MobileElement verifyCartButton;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"menu:id/back-button\"")
    @AndroidFindBy(xpath = "//*[@resource-id=\"menu:id/back-button\"]")
    public MobileElement backButton;
}

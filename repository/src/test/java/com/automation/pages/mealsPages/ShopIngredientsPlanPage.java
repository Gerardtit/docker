package com.automation.pages.mealsPages;

import com.automation.pageElements.meals.pageElements.ShopIngredientsPageElements;
import com.automation.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShopIngredientsPlanPage extends BasePage {

    ShopIngredientsPageElements shopIngredientsElements = new ShopIngredientsPageElements();
    MealsUtils mealsUtils = new MealsUtils(driver);

    public ShopIngredientsPlanPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), shopIngredientsElements);
    }

    public void clickShopForDeliveryOrPickUpButton() {
        waitForClickableAndClick(shopIngredientsElements.shopForDeliveryOrPickup);
        mealsUtils.checkMobileElementExist(shopIngredientsElements.shopItem);
        Assert.assertTrue(shopIngredientsElements.shopPlanPage.isDisplayed());
        Assert.assertTrue(shopIngredientsElements.shopItem.isDisplayed());
        Assert.assertTrue(shopIngredientsElements.swapButton.isDisplayed());
        Assert.assertTrue(shopIngredientsElements.shopItemProductName.isDisplayed());
        Assert.assertTrue(shopIngredientsElements.shopItemProductImage.isDisplayed());
        Assert.assertTrue(shopIngredientsElements.quantityButtonPlus.isDisplayed());
        Assert.assertTrue(shopIngredientsElements.quantityButtonMinus.isDisplayed());
        Assert.assertTrue(shopIngredientsElements.addProductsToCartButton.isDisplayed());
    }

    public void clickAddIngredientsToMyListButton() {
        waitForClickableAndClick(shopIngredientsElements.addIngredientsToMyList);
    }

    public boolean verifyReviewIngredientsPageIsDisplayed() {
        try {
            shopIngredientsElements.addItemsToMyListButton.isDisplayed();
            shopIngredientsElements.itemsInReviewList.isDisplayed();
            shopIngredientsElements.itemsInReviewListCheckBox.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickShopIngredientsButton() {
        waitForClickableAndClick(shopIngredientsElements.shopIngredientsButton);
        Assert.assertTrue(shopIngredientsElements.promptSheet.isDisplayed());
        Assert.assertTrue(shopIngredientsElements.closeButtonOnPromptSheet.isDisplayed());
        Assert.assertTrue(shopIngredientsElements.shopForDeliveryOrPickup.isDisplayed());
        Assert.assertTrue(shopIngredientsElements.addIngredientsToMyList.isDisplayed());
    }

    public void shopIngredientsOptionsPromptSheetIsDisplayed() {
        Assert.assertTrue(shopIngredientsElements.promptSheet.isDisplayed());
        Assert.assertTrue(shopIngredientsElements.closeButtonOnPromptSheet.isDisplayed());
        Assert.assertTrue(shopIngredientsElements.shopForDeliveryOrPickup.isDisplayed());
        Assert.assertTrue(shopIngredientsElements.addIngredientsToMyList.isDisplayed());
    }

    public void clickCloseButtonOnPromptSheet() {
        waitForClickableAndClick(shopIngredientsElements.closeButtonOnPromptSheet);
    }

    public void verifyShopIngredientsPageIsDisplayed() {
        Assert.assertTrue(shopIngredientsElements.shopItem.isDisplayed());
        Assert.assertTrue(shopIngredientsElements.swapButton.isDisplayed());
        Assert.assertTrue(shopIngredientsElements.shopItemProductName.isDisplayed());
        Assert.assertTrue(shopIngredientsElements.shopItemProductImage.isDisplayed());
        Assert.assertTrue(shopIngredientsElements.quantityButtonPlus.isDisplayed());
        Assert.assertTrue(shopIngredientsElements.quantityButtonMinus.isDisplayed());
        Assert.assertTrue(shopIngredientsElements.addProductsToCartButton.isDisplayed());
    }

    public void clickAddProductsToCart() {
        shopIngredientsElements.addProductsToCartButton.click();
    }

    public boolean productAddedSuccessfullyPrompt() {
        try {
            mealsUtils.checkMobileElementExist(shopIngredientsElements.promptSheet);
            shopIngredientsElements.goToCartToCheckoutButton.isDisplayed();
            shopIngredientsElements.viewMyMealsButton.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickGoToCartToCheckout() {
        try {
            waitForClickableAndClick(shopIngredientsElements.goToCartToCheckoutButton);
        } catch (Exception e) {
            if (shopIngredientsElements.goToCartToCheckoutButton.isDisplayed()) {
                shopIngredientsElements.goToCartToCheckoutButton.click();
            }
        }
    }

    public void clickViewMyMeals() {
        waitForDisplayed(shopIngredientsElements.viewMyMealsButton);
        waitForClickableAndClick(shopIngredientsElements.viewMyMealsButton);
    }

    public void clickBackToMeals() {
        waitForClickableAndClick(shopIngredientsElements.backToMealsButton);
    }

    public void clickAddItemsToMyListButton() {
        //todo remove comment
        //Assert.assertTrue(shopIngredientsElements.addItemsToMyListButton.getText().contains("Add ingredients to My List"));
        waitForClickableAndClick(shopIngredientsElements.addItemsToMyListButton);
    }

    public void ingredientsAddedPromptSheetConfirmation() {
        if (!mealsUtils.checkMobileElementExist(shopIngredientsElements.promptSheet)) {
            if (shopIngredientsElements.addItemsToMyListButton.isDisplayed()) {
                shopIngredientsElements.addItemsToMyListButton.click();
                waitForDisplayed(shopIngredientsElements.promptSheet, 10);
                Assert.assertTrue(shopIngredientsElements.promptSheet.isDisplayed());
                Assert.assertTrue(shopIngredientsElements.showMyListButton.isDisplayed());
                Assert.assertTrue(shopIngredientsElements.backToMealsButton.isDisplayed());
            } else {
                Assert.assertTrue(shopIngredientsElements.addItemsToMyListButton.isDisplayed());
            }
        } else {
            Assert.assertTrue(shopIngredientsElements.promptSheet.isDisplayed());
            Assert.assertTrue(shopIngredientsElements.showMyListButton.isDisplayed());
            Assert.assertTrue(shopIngredientsElements.backToMealsButton.isDisplayed());
        }
    }

    public void clickOnShowMyListButton() {
        waitForClickableAndClick(shopIngredientsElements.showMyListButton);
    }

    public void verifyCartIsDisplayed() {
        if (mealsUtils.isElementDisplayed(shopIngredientsElements.verifyCartButton)) {
            Assert.assertTrue(shopIngredientsElements.verifyCartButton.isDisplayed());
        } else if (isElementDisplayed(shopIngredientsElements.goToCartToCheckoutButton)) {
            shopIngredientsElements.goToCartToCheckoutButton.click();
            waitForDisplayed(shopIngredientsElements.verifyCartButton, 10);
            Assert.assertTrue(shopIngredientsElements.verifyCartButton.isDisplayed());
        } else {
            Assert.assertTrue(shopIngredientsElements.verifyCartButton.isDisplayed(), "cart not displayed");
        }

    }
}

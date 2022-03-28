package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.CartPageElements;
import com.automation.pageElements.GG_MyCartPageElements;
import com.google.common.base.CharMatcher;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.HashMap;

public class GG_MyCartPage extends BasePage {

    private final CartPageElements cartPageElements = new CartPageElements();
    private GG_MyCartPageElements myCartPageElements = new GG_MyCartPageElements();
    private HashMap<String, Object> testData = new HashMap<String, Object>();

    public GG_MyCartPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), myCartPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cartPageElements);
    }

    public HashMap<String, Object> getTestData() {
        return testData;
    }

    public void clickOnMyCart() {
        if (isElementDisplayed(myCartPageElements.cartIconWithCount, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.cartIconWithCount);
        } else if (isElementDisplayed(myCartPageElements.myCart, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.myCart);
        }
    }

    public void clickOnCheckoutButton() {
        new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.checkoutButton);
        if (isElementDisplayed(myCartPageElements.continueToPayment)) {
            new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.continueToPayment);
        }
    }

    public boolean isMyCartDisplayed() {
        return isElementDisplayed(myCartPageElements.myCart);
    }

    public boolean isNavigatedToMyCartScreen() {
        return getText(myCartPageElements.myCartScreenTitle).contains("My Cart");
    }

    public void waitForLoaderToDisappear() {
        new WaitAction(driver).waitForElementToDisappear(myCartPageElements.loadingSpinner, 50);
    }

    public boolean verifyMyCartNotDisplayed() {
        waitForLoaderToDisappear();
        return isElementDisplayed(myCartPageElements.myCart);
    }

    public boolean isCartCountIncremented() {
        boolean isCartIncremented = false;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            String beforeIncrement = myCartPageElements.myCart.getAttribute("value");
            String beforeIncrementCount = beforeIncrement.split(" item")[0];
            int beforeIncrementCartCount = Integer.parseInt(beforeIncrementCount);
            if (isElementDisplayed(myCartPageElements.addButton)) {
                new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.addButton);
            } else {
                new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.incrementButton.get(1));
            }
            String afterIncrement = myCartPageElements.myCart.getAttribute("value");
            String afterIncrementCount = afterIncrement.split(" item")[0];
            int afterIncrementCartCount = Integer.parseInt(afterIncrementCount);
            if (afterIncrementCartCount == beforeIncrementCartCount + 1) {

                new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.decrementButton.get(1));
                isCartIncremented = true;

            }

        } else {
            String beforeIncrement = myCartPageElements.myCartCount.getAttribute("text");
            int beforeIncrementCartCount = Integer.parseInt(beforeIncrement);
            if (isElementDisplayed(myCartPageElements.addButton)) {
                new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.addButton);
            } else {
                new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.incrementButton.get(1));
            }
            String afterIncrement = myCartPageElements.myCartCount.getAttribute("text");
            int afterIncrementCartCount = Integer.parseInt(afterIncrement);
            if (afterIncrementCartCount == beforeIncrementCartCount + 1) {

                new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.decrementButton.get(1));
                isCartIncremented = true;

            }
        }
        return isCartIncremented;

    }

    public int getItemsCountFromCart() {
        if (!isElementDisplayed(myCartPageElements.myCartCount, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.homeTab);
            scrollUpForElement(myCartPageElements.myCartCount);
        }
        int itemsCount = 0;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            itemsCount = Integer.valueOf(CharMatcher.inRange('0', '9').retainFrom(myCartPageElements.myCartCount.getText()));
        } else {
            itemsCount = Integer.valueOf(myCartPageElements.myCartCount.getText().split(" item")[0].trim());
        }
        testData.put("cartItems", itemsCount);
        return itemsCount;
    }

    public boolean isCheckoutEnabled() throws InterruptedException {
        Thread.sleep(4000);
        if (!isElementDisplayed(myCartPageElements.checkOutButton, 3)) {
            clickOnMyCart();
        }
        waitForLoaderToDisappear();
        return myCartPageElements.checkOutButton.isEnabled();
    }

    public boolean isCheckOutButtonDisplayed() {
        return isElementDisplayed(myCartPageElements.checkOutButton);
    }

    public void clickOnEstimatedTotal() {
        new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.estimatedTotalLabel);
    }

    public void clickDoneOnEstimatedTotal() {
        new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.doneEstimatedTotalButton);
    }

    public String getTextFromEstimatedTotalScreen() {
        return myCartPageElements.estimatedTotalScreenText.getText();
    }

    public void removeFirstCard() {
        swipeLeftOnElement(myCartPageElements.firstCard);
        new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.removeButtonWithPreviousSwipe);
    }

    public void clearCartItems() {
        if (isElementDisplayed(myCartPageElements.emptyCartImage, 3) || isElementDisplayed(myCartPageElements.emptyCartImageV2, 3)) {
            return;
        }
        while (true) {
            try {
                if (myCartPageElements.emptyCartImageV2.isDisplayed()) return;
            } catch (Exception e) {
                try {
                    if (myCartPageElements.emptyCartImage.isDisplayed()) return;
                } catch (Exception e2) {
                    try {
                        new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.removeIcon);
                    } catch (Exception e3) {
                        swipeLeftOnElement(myCartPageElements.firstCard);
                        new WaitAction(driver).waitForClickableAndClick(myCartPageElements.removeButtonWithPreviousSwipe);
//                            new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.removeButtonWithPreviousSwipe);
                    }
                }
            }
        }
    }

    public void clearCartV2Items() {
        if (isElementDisplayed(myCartPageElements.emptyCartImageV2, 3)) {
            return;
        }
        while (true) {
            try {
                Thread.sleep(1000);
                if (myCartPageElements.emptyCartImageV2.isDisplayed()) return;
            } catch (Exception e) {
                removeFirstCard();
            }
        }
    }

    public double getCartTotal() {
        if (!isElementDisplayed(myCartPageElements.checkOutButton, 2)) {
            clickOnMyCart();
        }
        new WaitAction(driver).waitForDisplayed(myCartPageElements.cartTotalText);
        String cartTotalText = myCartPageElements.cartTotalText.getText();
        double value = 0;
        if (cartTotalText.contains("$")) {
            value = Double.valueOf(cartTotalText.split("\\$")[1]);
        } else if (cartTotalText.length() == 0) {
            value = 0;
        } else {
            System.out.print("MY CART AMOUNT: " + cartTotalText);
            Assert.assertTrue(false, "Error while fetching cart total, cart total text=" + cartTotalText);
        }
        return value;
    }

    public void clickOfferDetails() {
        new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.offerDetails);
    }

    public void goBackToEditOrderPage() {
        new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.backToEditOrder);
    }

    public void clickOnCheckoutButtonInEditCart() {
        new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.checkoutButtonEditCart);
    }


    public boolean getItemsCount() {
        if (!isElementDisplayed(myCartPageElements.myCartCount, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.homeTab);
            scrollUpForElement(myCartPageElements.myCartCount);
        }
        int itemsCount = 0;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            itemsCount = Integer.valueOf(CharMatcher.inRange('0', '9').retainFrom(myCartPageElements.myCartCount.getText()));
        } else {
            itemsCount = Integer.valueOf(myCartPageElements.myCartCount.getText().split(" item")[0].trim());
        }
        return true;
    }

    public int getItemsCountFromCartAfterPerformingCartOps() {
        if (!isElementDisplayed(myCartPageElements.myCartCount, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.homeTab);
            scrollUpForElement(myCartPageElements.myCartCount);
        }
        int itemsCount = 0;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            itemsCount = Integer.valueOf(CharMatcher.inRange('0', '9').retainFrom(myCartPageElements.myCartCount.getText()));
        } else {
            itemsCount = Integer.valueOf(myCartPageElements.myCartCount.getText().split(" item")[0].trim());
        }
        return itemsCount;
    }

    public boolean itemsAddedtoCart() {
        if (!isElementDisplayed(myCartPageElements.myCartCount, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.homeTab);
            scrollUpForElement(myCartPageElements.myCartCount);
        }
        int itemsCount = 0;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            itemsCount = Integer.valueOf(CharMatcher.inRange('0', '9').retainFrom(myCartPageElements.myCartCount.getText()));
        } else {
            itemsCount = Integer.valueOf(myCartPageElements.myCartCount.getText().split(" item")[0].trim());
        }
//        return itemsCount;
        if (itemsCount > 0) {
            return true;
        }
        return false;
    }

    public boolean itemsRemovetoCart() {
        if (!isElementDisplayed(myCartPageElements.myCartCount, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.homeTab);
            scrollUpForElement(myCartPageElements.myCartCount);
        }
        int itemsCount = 0;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            itemsCount = Integer.valueOf(CharMatcher.inRange('0', '9').retainFrom(myCartPageElements.myCartCount.getText()));
        } else {
            itemsCount = Integer.valueOf(myCartPageElements.myCartCount.getText().split(" item")[0].trim());
        }
//        return itemsCount;
        if (itemsCount == 0) {
            return true;
        }
        return false;
    }

    public void clickOnCloseButtonOnMyCartScreen() {
        new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.closeIcon);
    }

    public void verifyTitleOfScreen(String text) {
        if (getPlatformName().equalsIgnoreCase("android")) {
            Assert.assertTrue(myCartPageElements.myCartScreenTitle.getAttribute("text").contains(text));
        } else {
            Assert.assertTrue(myCartPageElements.myCartScreenTitle.getAttribute("name").contains(text));
        }
    }

    public void verifyQuantityCounterCartTitle() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            Assert.assertTrue(myCartPageElements.quantityCounter.isDisplayed());
        }
    }

    public void clickOnDeliveryPickUp() {

        if (isElementDisplayed((MobileElement) cartPageElements.deliveryPickUp, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(cartPageElements.deliveryPickUp);
        }
    }

}

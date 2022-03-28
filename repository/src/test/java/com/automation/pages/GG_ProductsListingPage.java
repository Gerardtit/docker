package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.CartPageElements;
import com.automation.pageElements.GG_MyCartPageElements;
import com.automation.pageElements.GG_ProductsListingPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class GG_ProductsListingPage extends BasePage {
    private final static String CTA_BUTTON_DYNAMIC_XPATH_IOS = "//XCUIElementTypeButton[@name='%s']//*[@name='viewStepperView']/XCUIElementTypeButton[@visible='true']";
    private final static String ADD_BUTTON_DYNAMIC_XPATH_ANDROID = "//*[@content-desc='%s']//*[@text='Add']";
    private final static String INCREMENT_BUTTON_DYNAMIC_XPATH_ANDROID = "//*[contains(@resource-id,'umaStepperPlus') and contains(@content-desc,'%s')]";
    private final static String DECREMENT_BUTTON_DYNAMIC_XPATH_ANDROID = "//*[contains(@resource-id,'umaStepperMinus') and contains(@content-desc,'%s')]";
    private final static String OUT_OF_STOCK_BUTTON_DYNAMIC_XPATH_ANDROID = "//*[@content-desc='%s']//*[@text='Out of Stock']";
    private final static String QUANTITY_BUTTON_DYNAMIC_XPATH_ANDROID = "//*[@content-desc='%s']//*[contains(@resource-id,'umaStepperQty')]";
    private final static String CTA_BUTTON_CONTAINER_DYNAMIC_XPATH_ANDROID = "//*[@content-desc='%s']//*[contains(@resource-id,'pricePerWeight')]//following-sibling::android.view.ViewGroup";

    private CartPageElements cartPageElements = new CartPageElements();
    GG_MyCartPage gg_myCartPage = new GG_MyCartPage(driver);


    private GG_ProductsListingPageElements gg_productsListingPageElements = new GG_ProductsListingPageElements();
    private GG_MyCartPageElements myCartPageElements = new GG_MyCartPageElements();

    public GG_ProductsListingPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_productsListingPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), myCartPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cartPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_myCartPage);


    }

    public void filterByRewardCardSpecials() {
        new CommonActions(driver).new ClickAction().clickElement(gg_productsListingPageElements.filterButton);
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new CommonActions(driver).new ClickAction().clickElement(gg_productsListingPageElements.filterRightArrow);
        }
        new CommonActions(driver).new ClickAction().clickElement(gg_productsListingPageElements.filterRewardCardSpecials);
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new CommonActions(driver).new ClickAction().clickElement(gg_productsListingPageElements.saveButton);
        }
    }

    public void sortByPriceLowToHigh() {
        new CommonActions(driver).new ClickAction().clickElement(gg_productsListingPageElements.filterButton);
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new CommonActions(driver).new ClickAction().clickElement(gg_productsListingPageElements.filterRightArrow);
        }
        new CommonActions(driver).new ClickAction().clickElement(gg_productsListingPageElements.sortByPriceLowToHigh);
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new CommonActions(driver).new ClickAction().clickElement(gg_productsListingPageElements.saveButton);
        }
    }

    public boolean addAProductToCartAndRemove() throws InterruptedException {
        List<String> productInfoList = new ArrayList<String>();
        int maxScrolls = 10;
        boolean itemAdded = false;
        int counter = 0;
        while (!itemAdded) {
            while (counter < maxScrolls) {
                for (int i = 0; i < gg_productsListingPageElements.productCards.size(); i++) {
                    String currentProductInfo = "";
                    if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                        currentProductInfo = gg_productsListingPageElements.productCards.get(i).getAttribute("name");
                    } else {
                        currentProductInfo = gg_productsListingPageElements.productCards.get(i).getAttribute("content-desc");
                    }

                    if (!productInfoList.contains(currentProductInfo)) {
                        productInfoList.add(currentProductInfo);
                        if (addProductIfAvailableAndRemove(currentProductInfo)) {
                            itemAdded = true;
                            counter = maxScrolls;
                            break;
                        }
                    }
                }
                if (!itemAdded) {
                    scrollDown();
                    counter++;
                }
            }
            if (counter >= maxScrolls) {
                break;
            }
        }

        return itemAdded;
    }

    public boolean addProductIfAvailableAndRemove(String currentProductInfo) throws InterruptedException {
        int beforeCount = getItemsCountFromCart();
        int afterCount;
        boolean itemAvailable = true;
        boolean itemAdded = false;
        int currentAddedQty = 0;
        boolean isOutOfStock = false;
        String btnText = "";
        String buttonXpath = "";
        boolean addButtonPresentAndroid = false;
        boolean quantityButtonPresentAndroid = false;

        String incrementButtonXpathAndroid = String.format(INCREMENT_BUTTON_DYNAMIC_XPATH_ANDROID, currentProductInfo);
        String decrementButtonXpathAndroid = String.format(DECREMENT_BUTTON_DYNAMIC_XPATH_ANDROID, currentProductInfo);

        // Construct dynamic xpath for add button on product card based on product description
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            buttonXpath = String.format(CTA_BUTTON_DYNAMIC_XPATH_IOS, currentProductInfo);
            scrollDownForElement(buttonXpath);
            btnText = driver.findElement(By.xpath(buttonXpath)).getAttribute("name");
            if (btnText.contains("Out of stock")) {
                isOutOfStock = true;
            }
        } else {
            buttonXpath = String.format(CTA_BUTTON_CONTAINER_DYNAMIC_XPATH_ANDROID, currentProductInfo);
            if (!(driver.findElements(By.xpath(buttonXpath)).size() > 0)) {
                if (!scrollDownForElement(String.format(OUT_OF_STOCK_BUTTON_DYNAMIC_XPATH_ANDROID, currentProductInfo), 2)) {
                    scrollDownForElement(buttonXpath, 1);
                }
            }
            if (driver.findElements(By.xpath(String.format(OUT_OF_STOCK_BUTTON_DYNAMIC_XPATH_ANDROID, currentProductInfo))).size() > 0) {
                isOutOfStock = true;
            } else if (driver.findElements(By.xpath(String.format(ADD_BUTTON_DYNAMIC_XPATH_ANDROID, currentProductInfo))).size() > 0) {
                addButtonPresentAndroid = true;
            } else if (driver.findElements(By.xpath(String.format(QUANTITY_BUTTON_DYNAMIC_XPATH_ANDROID, currentProductInfo))).size() > 0) {
                quantityButtonPresentAndroid = true;
            }
        }

        if (!isOutOfStock) {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                if (btnText.contains("Quantity in cart")) {
                    currentAddedQty = Integer.valueOf(driver.findElement(By.xpath(buttonXpath)).getAttribute("value"));
                    if (currentAddedQty < 20) {
                        incrementProductCount(driver.findElement(By.xpath(buttonXpath)));
                    } else {
                        itemAvailable = false;
                    }
                } else {
                    driver.findElement(By.xpath(buttonXpath)).click();
                }
            } else {
                if (quantityButtonPresentAndroid) {
                    String qtyValueXpath = String.format(QUANTITY_BUTTON_DYNAMIC_XPATH_ANDROID, currentProductInfo) + "/android.widget.TextView";
                    currentAddedQty = Integer.valueOf(driver.findElement(By.xpath(qtyValueXpath)).getText());
                    if (currentAddedQty < 20) {
                        incrementProductCount(driver.findElement(By.xpath(buttonXpath)));
                    } else {
                        itemAvailable = false;
                    }
                } else {
                    driver.findElement(By.xpath(ADD_BUTTON_DYNAMIC_XPATH_ANDROID)).click();
                }
            }
        } else {
            itemAvailable = false;
        }

        if (itemAvailable) {
            afterCount = getItemsCountFromCart();
            if (afterCount > beforeCount) {
                itemAdded = true;
            }
        }

        // Removing/decrementing the item added
        if (itemAdded) {
            if (driver.getPlatformName().equalsIgnoreCase("android")) {
                decrementProductCount(driver.findElement(By.xpath(decrementButtonXpathAndroid)));
            } else {
                decrementProductCount(driver.findElement(By.xpath(buttonXpath)));
            }
            afterCount = getItemsCountFromCart();
            Assert.assertEquals(afterCount, beforeCount, "There was a problem while removing/decrementing item count");
        }

        return itemAdded;
    }

    public void decrementProductCount(WebElement ele) throws InterruptedException {
        Point pt = ele.getLocation();
        TouchAction action = new TouchAction(driver);
        action.tap(PointOption.point(pt.getX() + ele.getSize().getWidth() * 1 / 10, pt.getY())).perform();
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            if (isElementDisplayed(gg_productsListingPageElements.quantityProductDetailsPage, 3)) {
                driver.navigate().back();
                action.tap(PointOption.point(pt.getX() + ele.getSize().getWidth() * 1 / 10, pt.getY() * 11 / 10 + ele.getSize().getHeight())).perform();
                Thread.sleep(3500);
            }
        } else {
            Thread.sleep(3500);
        }
    }

    public void incrementProductCount(WebElement ele) throws InterruptedException {
        Point pt = ele.getLocation();
        TouchAction action = new TouchAction(driver);
        action.tap(PointOption.point(pt.getX() + ele.getSize().getWidth() * 9 / 10, pt.getY())).perform();
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            if (isElementDisplayed(gg_productsListingPageElements.quantityProductDetailsPage, 3)) {
                driver.navigate().back();
                action.tap(PointOption.point(pt.getX() + ele.getSize().getWidth() * 9 / 10, pt.getY() * 11 / 10 + ele.getSize().getHeight())).perform();
                Thread.sleep(3500);
            }
        } else {
            Thread.sleep(3500);
        }
    }

    public boolean addMultipleProductFirstCountsToCart(int productCount) throws InterruptedException {
        List<String> productInfoList = new ArrayList<String>();

        boolean itemAdded = false;
        int counter = 0;
        while (!itemAdded) {
            while (counter < productCount) {
                String currentProductInfo = "";
                if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                    currentProductInfo = gg_productsListingPageElements.productCards.get(0).getAttribute("name");
                } else {
                    currentProductInfo = gg_productsListingPageElements.productCards.get(0).getAttribute("content-desc");
                }
                productInfoList.add(currentProductInfo);
                if (addProductIfAvailable(currentProductInfo, productCount)) {
                    itemAdded = true;
                    break;
                }
                counter = counter + 1;
            }
            if (counter > productCount) {
                break;
            }
        }
        return itemAdded;
    }

    public boolean addMultipleProductCountsToCart(int productCount) throws InterruptedException {
        List<String> productInfoList = new ArrayList<String>();
        int maxScrolls = 10;
        boolean itemAdded = false;
        int counter = 0;
        while (!itemAdded) {
            while (counter < maxScrolls) {
                for (int i = 0; i < gg_productsListingPageElements.productCards.size(); i++) {
                    String currentProductInfo = "";
                    if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                        currentProductInfo = gg_productsListingPageElements.productCards.get(i).getAttribute("name");
                    } else {
                        currentProductInfo = gg_productsListingPageElements.productCards.get(i).getAttribute("content-desc");
                    }

                    if (!productInfoList.contains(currentProductInfo)) {
                        productInfoList.add(currentProductInfo);
                        if (addProductIfAvailable(currentProductInfo, productCount)) {
                            itemAdded = true;
                            counter = maxScrolls;
                            break;
                        }
                    }
                }
                if (!itemAdded) {
                    scrollDown();
                    counter++;
                }
            }
            if (counter >= maxScrolls) {
                break;
            }
        }
        return itemAdded;
    }

    public boolean addProductIfAvailable(String currentProductInfo, int productCount) throws InterruptedException {
        int afterCount;
        int currentAddedQty = 0;
        boolean itemAvailable = true;
        boolean isOutOfStock = false;
        String btnText = "";
        String buttonXpathiOS = "";
        String buttonXpathAndroid = "";
        boolean addButtonPresentAndroid = false;
        boolean quantityButtonPresentAndroid = false;
        String incrementButtonXpathAndroid = String.format(INCREMENT_BUTTON_DYNAMIC_XPATH_ANDROID, currentProductInfo);

        // Construct dynamic xpath for add button on product card based on product description
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            buttonXpathiOS = String.format(CTA_BUTTON_DYNAMIC_XPATH_IOS, currentProductInfo);
            scrollDownForElement(buttonXpathiOS);
            btnText = driver.findElement(By.xpath(buttonXpathiOS)).getAttribute("name");
            if (btnText.contains("Out of stock")) {
                isOutOfStock = true;
            }
        } else {
            buttonXpathAndroid = String.format(CTA_BUTTON_CONTAINER_DYNAMIC_XPATH_ANDROID, currentProductInfo);
            if (!(driver.findElements(By.xpath(buttonXpathAndroid)).size() > 0)) {
                if (!scrollDownForElement(String.format(OUT_OF_STOCK_BUTTON_DYNAMIC_XPATH_ANDROID, currentProductInfo), 2)) {
                    scrollDownForElement(buttonXpathAndroid, 1);
                }
            }
            if (driver.findElements(By.xpath(String.format(OUT_OF_STOCK_BUTTON_DYNAMIC_XPATH_ANDROID, currentProductInfo))).size() > 0) {
                isOutOfStock = true;
            } else if (driver.findElements(By.xpath(String.format(ADD_BUTTON_DYNAMIC_XPATH_ANDROID, currentProductInfo))).size() > 0) {
                addButtonPresentAndroid = true;
            } else if (driver.findElements(By.xpath(String.format(QUANTITY_BUTTON_DYNAMIC_XPATH_ANDROID, currentProductInfo))).size() > 0) {
                quantityButtonPresentAndroid = true;
            }
        }

        if (!isOutOfStock) {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                if (btnText.contains("Quantity in cart")) {
                    currentAddedQty = Integer.valueOf(driver.findElement(By.xpath(buttonXpathiOS)).getAttribute("value"));
                }
            } else {
                if (quantityButtonPresentAndroid) {
                    String qtyValueXpath = String.format(QUANTITY_BUTTON_DYNAMIC_XPATH_ANDROID, currentProductInfo) + "/android.widget.TextView";
                    currentAddedQty = Integer.valueOf(driver.findElement(By.xpath(qtyValueXpath)).getText());
                }
            }
            if (currentAddedQty == 20) {
                itemAvailable = false;
            }
        } else {
            itemAvailable = false;
        }

        int availQty = 20 - currentAddedQty;
        if (productCount > 20) {
            if (availQty < 20) {
                itemAvailable = false;
            }
        } else {
            if (productCount > availQty) {
                itemAvailable = false;
            }
        }

        if (itemAvailable) {
            for (int i = 1; i <= productCount; i++) {
                int beforeCount = getItemsCountFromCart();
                if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                    btnText = driver.findElement(By.xpath(buttonXpathiOS)).getAttribute("name");
                    if (btnText.contains("Quantity in cart")) {
                        // Increment
                        incrementProductCount(driver.findElement(By.xpath(buttonXpathiOS)));
                    } else {
                        // Add
                        driver.findElement(By.xpath(buttonXpathiOS)).click();
                    }
                } else {
                    if (driver.findElements(By.xpath(String.format(ADD_BUTTON_DYNAMIC_XPATH_ANDROID, currentProductInfo))).size() > 0) {
                        // Add
                        driver.findElement(By.xpath(String.format(ADD_BUTTON_DYNAMIC_XPATH_ANDROID, currentProductInfo))).click();
                    } else {
                        // Increment
                        incrementProductCount(driver.findElement(By.xpath(buttonXpathAndroid)));
                    }
                }

                Thread.sleep(3000);
                afterCount = getItemsCountFromCart();
                if (i > 20) {
                    // Verify that a maximum of 20 times a product can be added
                    if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                        Assert.assertEquals(driver.findElement(By.xpath(buttonXpathiOS)).getAttribute("value"), "20", "User was able to add the product more than 20 times");
                    } else {
                        String qtyValueXpath = String.format(QUANTITY_BUTTON_DYNAMIC_XPATH_ANDROID, currentProductInfo) + "/android.widget.TextView";
                        Assert.assertEquals(driver.findElement(By.xpath(qtyValueXpath)).getText(), "20", "User was able to add the product more than 20 times");
                    }

                    Assert.assertEquals(beforeCount, afterCount, "User was able to add the product more than 20 times");
                } else {
                    if (afterCount > beforeCount) {
                        itemAvailable = true;
                    } else {
                        itemAvailable = false;
                        // Break the loop because this product is unavailable
                        break;
                    }
                }
            }
        }

        return itemAvailable;
    }

    public int getItemsCountFromCart() {
        String cartText = "";
        int itemsCount = 0;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            itemsCount = Integer.valueOf(gg_productsListingPageElements.cartIconWithCount.getText().trim());
        } else {
            cartText = gg_productsListingPageElements.cartIconWithCount.getAttribute("value");
            if (cartText.contains("item")) {
                itemsCount = Integer.valueOf(cartText.split("item")[0].trim());
            } else {
                Assert.assertTrue(false, "Error while fetching items count from cart icon");
            }
        }

        return itemsCount;
    }

    public void navigateBackToBrowsetab() {
        driver.navigate().back();
    }


    public void addProductIfAvailableUsingAddIcon() throws InterruptedException {
        if (isElementDisplayed(gg_productsListingPageElements.closeToggleIt, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_productsListingPageElements.closeToggleIt);
        }
        if (driver.getPlatformName().equalsIgnoreCase("ANDROID")) {
            scrollDownForElement(gg_productsListingPageElements.addToCartButton, 10);
            new CommonActions(driver).new ClickAction().clickElement(gg_productsListingPageElements.addToCartButton);
            Thread.sleep(3000);
        } else {
            List<MobileElement> listOfAddButtons = gg_productsListingPageElements.addToCartButtonListForIOS;
            for (int i = 0; i < listOfAddButtons.size(); i++) {
                new CommonActions(driver).new ClickAction().clickElement(listOfAddButtons.get(i));
                if (isElementDisplayed(gg_productsListingPageElements.outOfStockLabel, 5)) {
                    new CommonActions(driver).new ClickAction().clickElement(gg_productsListingPageElements.backButton);
                } else if (gg_productsListingPageElements.cartIconWithCount.getAttribute("value").equals("1 item")) {
                    break;
                }
            }
        }
    }


    public void addProductIfAvailableUsingIncrementIcon() throws InterruptedException {
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                scrollDownForElement(gg_productsListingPageElements.productQuantityButton, 10);
                TouchAction action = new TouchAction(driver);
                int xCoordinateForTap = (int) (gg_productsListingPageElements.productQuantityButton.getCenter().getX() + (gg_productsListingPageElements.productQuantityButton.getSize().getWidth() / 2) * 0.90);
                action.tap(PointOption.point(xCoordinateForTap, gg_productsListingPageElements.productQuantityButton.getCenter().getY())).perform();
                break;
            case "ANDROID":
                scrollDownForElement(gg_productsListingPageElements.incrementQuantity, 10);
                new CommonActions(driver).new ClickAction().clickElement(gg_productsListingPageElements.incrementQuantity);
                break;
        }
        Thread.sleep(3000);
    }

    public void removeProductUsingDecrementIcon() throws InterruptedException {
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                scrollDownForElement(gg_productsListingPageElements.productQuantityButton, 10);
                TouchAction action = new TouchAction(driver);
                int xCoordinateForTap = (int) (gg_productsListingPageElements.productQuantityButton.getCenter().getX() - (gg_productsListingPageElements.productQuantityButton.getSize().getWidth() / 2) * 0.90);
                action.tap(PointOption.point(xCoordinateForTap, gg_productsListingPageElements.productQuantityButton.getCenter().getY())).perform();
                break;
            case "ANDROID":
                scrollDownForElement(gg_productsListingPageElements.decrementQuantity, 10);
                new CommonActions(driver).new ClickAction().clickElement(gg_productsListingPageElements.decrementQuantity);
                break;
        }
        Thread.sleep(3000);
    }

    public void clickProductCardOnProductsListingPage() {
        new CommonActions(driver).new ClickAction().clickElement(gg_productsListingPageElements.productCards.get(0));
    }

    public void add2checkout() {
        new WaitAction(driver).waitForLoadingComplete();
        gg_productsListingPageElements.firstitem.click();
        if (isElementDisplayed(gg_productsListingPageElements.addQuantity)) {
            gg_productsListingPageElements.addQuantity.click();
        }
//        new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.myCart);
//        new WaitAction(driver).waitForLoadingComplete();
//        if(!cartPageElements.checkoutButton.isEnabled()){
//            gg_myCartPage.clickOnCloseButtonOnMyCartScreen();
//            for (int i = 0; i <= 12; i++) {
//                gg_productsListingPageElements.addQuantity.click();
//                new WaitAction(driver).waitForLoadingComplete();
//            }
//            new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.myCart);
    }


}
//}


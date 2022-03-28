package com.automation.pages;


import com.automation.helpers.PageActions;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_Deals_BOGOPageElement;
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
import java.util.stream.Collectors;

public class GG_Deals_BOGOPage extends PageActions {
    private final static String BOGO_CARD_IOS = "//XCUIElementTypeButton[@name='%s']";
    private final static String BOGO_CARD_ANDROID = "//*[@content-desc='%s']";
    private final static String CTA_BUTTON_DYNAMIC_XPATH_IOS = "//XCUIElementTypeButton[@name='%s']//*[@name='viewStepperView']/XCUIElementTypeButton[@visible='true']";
    private final static String ADD_BUTTON_DYNAMIC_XPATH_ANDROID = "//*[@content-desc='%s']//*[@text='Add']";
    private final static String OUT_OF_STOCK_BUTTON_DYNAMIC_XPATH_ANDROID = "//*[@content-desc='%s']//*[@text='Out of Stock']";
    private final static String QUANTITY_BUTTON_DYNAMIC_XPATH_ANDROID = "//*[@content-desc='%s']//*[contains(@resource-id,'umaStepperQty')]";
    private final static String CTA_BUTTON_CONTAINER_DYNAMIC_XPATH_ANDROID = "//*[@content-desc='%s']//*[contains(@resource-id,'pricePerWeight')]//following-sibling::android.view.ViewGroup";
    private final static String INCREMENT_BUTTON_DYNAMIC_XPATH_ANDROID = "//*[contains(@resource-id,'umaStepperPlus') and contains(@content-desc,'%s')]";
    private final static String DECREMENT_BUTTON_DYNAMIC_XPATH_ANDROID = "//*[contains(@resource-id,'umaStepperMinus') and contains(@content-desc,'%s')]";
    public static String productNameOnBogoListingPage = "";
    public static String productAddedOnBogoDetailsPage = "";
    public GG_Deals_BOGOPageElement gg_deals_bogoPageElement = new GG_Deals_BOGOPageElement();
    public boolean isCategoryWithDesireCountFound = true;

    public GG_Deals_BOGOPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_deals_bogoPageElement);
    }

    public boolean isBogoTabDisplayed() {

        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new SwipeActions().slideTheCardFromRightToLeft(gg_deals_bogoPageElement.allCouponsTab);
            new SwipeActions().slideTheCardFromRightToLeft(gg_deals_bogoPageElement.promoTab);
        } else {
            int counter = 0;
            while (counter < 4) {
                if (!isElementDisplayed(gg_deals_bogoPageElement.bogo, 2)) {
                    new SwipeActions().slideTheCardFromRightToLeft(gg_deals_bogoPageElement.promoTab);
                    counter++;
                } else {
                    break;
                }
            }
        }
        return isElementDisplayed(gg_deals_bogoPageElement.bogo);
    }

    public boolean isBogoDealsPageDisplayed() {
        return isElementDisplayed(gg_deals_bogoPageElement.bogoDealPage);
    }

    public boolean isBogoCategoryNamesDisplayed() {
        return isElementDisplayed(gg_deals_bogoPageElement.categoryTile, 5);
    }

    public boolean isLoaderDisplayedUntilProductsLoad() {
        if (isElementDisplayed(gg_deals_bogoPageElement.loadingStatus, 3)) {
            return true;
        } else {
            // If loader is not displayed then product card MUST be displayed
            return isElementDisplayed(gg_deals_bogoPageElement.productCard, 3);
        }
    }

    public void clickOnProductCategory() {
        new WaitAction(driver).waitForDisplayed(gg_deals_bogoPageElement.categoryTile, 10);
        new CommonActions(driver).new ClickAction().clickElement(gg_deals_bogoPageElement.categoryTile);
        new WaitAction(driver).waitForDisplayed(gg_deals_bogoPageElement.firstProductCard, 5);
    }

    public void clickOnProductCard() {
        new WaitAction(driver).waitForDisplayed(gg_deals_bogoPageElement.firstProductCard, 5);
        new CommonActions(driver).new ClickAction().clickElement(gg_deals_bogoPageElement.productCards.get(0));
    }

    public boolean expandCategoryVerifyBOGOProductCardsDisplayed() throws InterruptedException {
        boolean foundProducts = false;
        Thread.sleep(3000);
        for (int i = 0; i < gg_deals_bogoPageElement.categoryTiles.size(); i++) {
            new CommonActions(driver).new ClickAction().clickElement(gg_deals_bogoPageElement.categoryTiles.get(i));
            if (isElementDisplayed(gg_deals_bogoPageElement.firstProductCard, 10)) {
                foundProducts = true;
                break;
            }
            new CommonActions(driver).new ClickAction().clickElement(gg_deals_bogoPageElement.categoryTiles.get(i));
        }
        return foundProducts;
    }

    public boolean isBOGOProductCardDisplayed() {
        return isElementDisplayed(gg_deals_bogoPageElement.firstProductCard, 6);
    }

    public boolean addBogoProductToCartOnBogoListingPageAndRemove() throws InterruptedException {
        List<String> productInfoList = new ArrayList<String>();
        int maxScrolls = 10;
        boolean itemAdded = false;
        int counter = 0;
        while (!itemAdded) {
            while (counter < maxScrolls) {
                for (int i = 0; i < gg_deals_bogoPageElement.productCards.size(); i++) {
                    String currentProductInfo = "";
                    if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                        currentProductInfo = gg_deals_bogoPageElement.productCards.get(i).getAttribute("name");
                    } else {
                        currentProductInfo = gg_deals_bogoPageElement.productCards.get(i).getAttribute("content-desc");
                    }

                    if (!productInfoList.contains(currentProductInfo)) {
                        productInfoList.add(currentProductInfo);
                        if (addBogoProductIfAvailableAndRemoveOnBogoListingPage(currentProductInfo)) {
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

    public boolean addBogoProductIfAvailableAndRemoveOnBogoListingPage(String currentProductInfo) throws InterruptedException {
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
            if (!scrollDownForElement(buttonXpath, 2)) {
                swipeLeftForElement(buttonXpath);
            }
            btnText = driver.findElement(By.xpath(buttonXpath)).getAttribute("name");
            if (btnText.contains("Out of stock")) {
                isOutOfStock = true;
            }
        } else {
            buttonXpath = String.format(CTA_BUTTON_CONTAINER_DYNAMIC_XPATH_ANDROID, currentProductInfo);
            if (!scrollDownForElement(buttonXpath, 3)) {
                swipeLeftForElement(buttonXpath);
            }
            if (driver.findElements(By.xpath(String.format(OUT_OF_STOCK_BUTTON_DYNAMIC_XPATH_ANDROID, currentProductInfo))).size() > 0) {
                isOutOfStock = true;
            } else if (driver.findElements(By.xpath(String.format(QUANTITY_BUTTON_DYNAMIC_XPATH_ANDROID, currentProductInfo))).size() > 0) {
                quantityButtonPresentAndroid = true;
            }
        }

        if (!isOutOfStock) {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                if (btnText.contains("Quantity in cart")) {
                    currentAddedQty = Integer.valueOf(driver.findElement(By.xpath(buttonXpath)).getAttribute("value"));
                    if (currentAddedQty < 20) {
                        String qtyButtonXpath = "(" + buttonXpath + "/XCUIElementTypeStaticText)[2]";
                        incrementProductCount(driver.findElement(By.xpath(qtyButtonXpath)));
                    } else {
                        itemAvailable = false;
                    }
                } else {
                    driver.findElement(By.xpath(buttonXpath)).click();
                }
            } else {
                if (quantityButtonPresentAndroid) {
                    String qtyValueXpath = QUANTITY_BUTTON_DYNAMIC_XPATH_ANDROID + "/android.widget.TextView";
                    currentAddedQty = Integer.valueOf(driver.findElement(By.xpath(qtyValueXpath)).getText());
                    if (currentAddedQty < 20) {
                        incrementProductCount(driver.findElement(By.xpath(incrementButtonXpathAndroid)));
                    } else {
                        itemAvailable = false;
                    }
                } else {
                    driver.findElement(By.xpath(String.format(ADD_BUTTON_DYNAMIC_XPATH_ANDROID, currentProductInfo))).click();
                }
            }
        } else {
            itemAvailable = false;
        }

        if (itemAvailable) {
            Thread.sleep(4000);
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
            Thread.sleep(4000);
            afterCount = getItemsCountFromCart();
            Assert.assertEquals(afterCount, beforeCount, "There was a problem while removing/decrementing item count");
        }

        return itemAdded;
    }

    public void decrementProductCount(WebElement ele) throws InterruptedException {
        Point pt = ele.getLocation();
        TouchAction action = new TouchAction(driver);
        action.tap(PointOption.point(pt.getX(), pt.getY() + 5)).perform();
    }

    public void incrementProductCount(WebElement ele) throws InterruptedException {
        Point pt = ele.getLocation();
        TouchAction action = new TouchAction(driver);
        action.tap(PointOption.point(pt.getX() + 50, pt.getY() + 5)).perform();
    }

    public boolean addMultipleBogoProductCountsToCartOnBogoListingPage(int productCount) throws InterruptedException {
        List<String> productInfoList = new ArrayList<String>();
        int maxScrolls = 10;
        boolean itemAdded = false;
        int counter = 0;
        while (!itemAdded) {
            while (counter < maxScrolls) {
                for (int i = 0; i < gg_deals_bogoPageElement.productCards.size(); i++) {
                    String currentProductInfo = "";
                    if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                        currentProductInfo = gg_deals_bogoPageElement.productCards.get(i).getAttribute("name");
                    } else {
                        currentProductInfo = gg_deals_bogoPageElement.productCards.get(i).getAttribute("content-desc");
                    }

                    if (!productInfoList.contains(currentProductInfo)) {
                        productInfoList.add(currentProductInfo);
                        if (addProductIfAvailableOnBogoListingPage(currentProductInfo, productCount)) {
                            itemAdded = true;
                            counter = maxScrolls;
                            break;
                        }
                    }
                }
                if (!itemAdded) {
                    swipeLeft();
                    counter++;
                }
            }
            if (counter >= maxScrolls) {
                break;
            }
        }

        return itemAdded;
    }

    public boolean addProductIfAvailableOnBogoListingPage(String currentProductInfo, int productCount) throws InterruptedException {
        int afterCount;
        int currentAddedQty = 0;
        boolean itemAvailable = true;
        boolean isOutOfStock = false;
        String btnText = "";
        String buttonXpathiOS = "";
        String buttonXpathAndroid = "";
        boolean quantityButtonPresentAndroid = false;
        String incrementButtonXpathAndroid = String.format(INCREMENT_BUTTON_DYNAMIC_XPATH_ANDROID, currentProductInfo);

        // Construct dynamic xpath for add button on product card based on product description
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            buttonXpathiOS = String.format(CTA_BUTTON_DYNAMIC_XPATH_IOS, currentProductInfo);
            if (!scrollDownForElement(buttonXpathiOS, 2)) {
                swipeLeftForElement(buttonXpathiOS);
            }
            btnText = driver.findElement(By.xpath(buttonXpathiOS)).getAttribute("name");
            if (btnText.contains("Out of stock")) {
                isOutOfStock = true;
            }
        } else {
            buttonXpathAndroid = String.format(CTA_BUTTON_CONTAINER_DYNAMIC_XPATH_ANDROID, currentProductInfo);
            if (!scrollDownForElement(buttonXpathAndroid, 3)) {
                swipeLeftForElement(buttonXpathAndroid);
            }
            if (driver.findElements(By.xpath(String.format(OUT_OF_STOCK_BUTTON_DYNAMIC_XPATH_ANDROID, currentProductInfo))).size() > 0) {
                isOutOfStock = true;
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

        int beforeCount = getItemsCountFromCart();

        if (itemAvailable) {
            int i;
            for (i = 1; i <= productCount; i++) {
                if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                    btnText = driver.findElement(By.xpath(buttonXpathiOS)).getAttribute("name");
                    if (btnText.contains("Quantity in cart")) {
                        // Increment
                        String qtyButton = "(" + buttonXpathiOS + "/XCUIElementTypeStaticText)[2]";
                        incrementProductCount(driver.findElement(By.xpath(qtyButton)));
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
                        incrementProductCount(driver.findElement(By.xpath(incrementButtonXpathAndroid)));
                    }
                }
                Thread.sleep(1000);

                // If the count is not increased after adding an item, this item is out of stock
                if (i == 2) {
                    Thread.sleep(2500);
                    if (beforeCount + 1 != getItemsCountFromCart()) {
                        itemAvailable = false;
                        return itemAvailable;
                    }
                }
            }

            if (productCount > 20 && i > 20) {
                if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                    String qtyButton = "(" + buttonXpathiOS + "/XCUIElementTypeStaticText)[2]";
                    incrementProductCount(driver.findElement(By.xpath(qtyButton)));
                } else {
                    incrementProductCount(driver.findElement(By.xpath(incrementButtonXpathAndroid)));
                }

                Thread.sleep(3500);
                afterCount = getItemsCountFromCart();
                // Verify that a maximum of 20 times a product can be added
                if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                    Assert.assertEquals(driver.findElement(By.xpath(buttonXpathiOS)).getAttribute("value"), "20", "User was able to add the product more than 20 times");
                } else {
                    String qtyValueXpath = String.format(QUANTITY_BUTTON_DYNAMIC_XPATH_ANDROID, currentProductInfo) + "/android.widget.TextView";
                    Assert.assertEquals(driver.findElement(By.xpath(qtyValueXpath)).getText(), "20", "User was able to add the product more than 20 times");
                }

                Assert.assertEquals(afterCount, beforeCount + 20, "User was able to add the product more than 20 times");
            } else {
                Thread.sleep(3500);
                afterCount = getItemsCountFromCart();
                Assert.assertEquals(afterCount, beforeCount + productCount, "User was not able to add the product desired number of times");
                itemAvailable = true;
            }
        }

        return itemAvailable;
    }

    public int getItemsCountFromCart() {
        String attributeName = driver.getPlatformName().equalsIgnoreCase("IOS") ? "value" : "text";
        return Integer.valueOf(gg_deals_bogoPageElement.myCartCount.getAttribute(attributeName).replaceAll("[^0-9]", ""));
    }

    public boolean isBOGOProductDetailsPageDisplayed() {
        scrollDownForElement(gg_deals_bogoPageElement.dealTitleProductDetail, 2);
        return isElementDisplayed(gg_deals_bogoPageElement.dealTitleProductDetail, 5);
    }

    public void clickViewAllRelatedProductsLink() {
        new CommonActions(driver).new ClickAction().clickElement(gg_deals_bogoPageElement.viewAllRelatedProductsBOGO);
    }

    public boolean isRelatedProductsPageDisplayed() {
        if (isElementDisplayed(gg_deals_bogoPageElement.closeToggleIt, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_deals_bogoPageElement.closeToggleIt);
        }
        return (isElementDisplayed(gg_deals_bogoPageElement.relatedProductsPageHeader) && gg_deals_bogoPageElement.productCards.size() > 0);
    }

    public boolean isCountOfDealsDisplayed() {
        boolean isCountDisplayed = false;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            String categoriesTitle = gg_deals_bogoPageElement.categoryTile.getAttribute("label");
            String count = categoriesTitle.replaceAll("[^0-9]", "");
            if (count != null) {
                isCountDisplayed = true;
            }
        } else {
            if (isElementDisplayed(gg_deals_bogoPageElement.categoryDealCount)) {
                isCountDisplayed = true;
            }
        }
        return isCountDisplayed;
    }

    public void clickOnSeeAllDealsButton() {
        if (isCategoryWithDesireCountFound) {
            new CommonActions(driver).new ClickAction().clickElement(gg_deals_bogoPageElement.seeAlldeals);
        }
    }

    public boolean isCategoryDetailPageDisplayed() {
        return !isCategoryWithDesireCountFound || isElementDisplayed(gg_deals_bogoPageElement.bogoDisclaimerCategoryDetails);
    }

    public void clickOnBogoOfferLinkOnProductCard() {
        scrollDownForElement(gg_deals_bogoPageElement.bogoOfferLinkProductCard);
        new CommonActions(driver).new ClickAction().clickElement(gg_deals_bogoPageElement.bogoOfferLinkProductCard);
    }

    public boolean isOfferDetailsPageDisplayed() {
        return isElementDisplayed(gg_deals_bogoPageElement.qualifyingProductsOfferDetailsPage);
    }

    public void clickItemOnAisleList(String category) throws InterruptedException {
        new WaitAction(driver).waitForLoadingComplete();
        Thread.sleep(1000);
        scrollDownForElement(findElementByLabel(category));
        new CommonActions(driver).new ClickAction().clickElement(findElementByLabel(category));
        new WaitAction(driver).waitForLoadingComplete();
    }

    public boolean addProductIfAvailableOnBogoDetailPage(int productCount) throws InterruptedException {
        int afterCount;
        boolean itemAvailable = true;
        int currentAddedQty = 0;

        if (isElementDisplayed(gg_deals_bogoPageElement.incrementQuantity, 2)) {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                if (gg_deals_bogoPageElement.currentAddedQuantity.getAttribute("value").contains("max")) {
                    itemAvailable = false;
                } else {
                    if (gg_deals_bogoPageElement.currentAddedQuantity.getAttribute("value").contains("in cart")) {
                        currentAddedQty = Integer.valueOf(gg_deals_bogoPageElement.currentAddedQuantity.getAttribute("value").split("in cart")[0].trim());
                    }
                }
            } else {
                if (gg_deals_bogoPageElement.currentAddedQuantity.getText().contains("max")) {
                    itemAvailable = false;
                } else {
                    if (gg_deals_bogoPageElement.currentAddedQuantity.getText().contains("in cart")) {
                        currentAddedQty = Integer.valueOf(gg_deals_bogoPageElement.currentAddedQuantity.getText().split("in cart")[0].trim());
                    }
                }
            }
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
            int i;
            int beforeCount = getItemsCountFromCartInCartDetailpage();
            for (i = 1; i <= productCount; i++) {
                if (isElementDisplayed(gg_deals_bogoPageElement.incrementQuantity, 2)) {
                    new CommonActions(driver).new ClickAction().clickElement(gg_deals_bogoPageElement.incrementQuantity);
                } else if (isElementDisplayed(gg_deals_bogoPageElement.addToCartButton, 2)) {
                    new CommonActions(driver).new ClickAction().clickElement(gg_deals_bogoPageElement.addToCartButton);
                }
                Thread.sleep(4000);
            }

            if (productCount > 20 && i > 20) {
                new CommonActions(driver).new ClickAction().clickElement(gg_deals_bogoPageElement.incrementQuantity);
                Thread.sleep(3000);
                afterCount = getItemsCountFromCartInCartDetailpage();
                // Verify that a maximum of 20 times a product can be added
                if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                    Assert.assertEquals(gg_deals_bogoPageElement.currentAddedQuantity.getAttribute("value"), "20 max", "User was able to add the product more than 20 times");
                } else {
                    Assert.assertEquals(gg_deals_bogoPageElement.currentAddedQuantity.getText(), "20 max", "User was able to add the product more than 20 times");
                }
                Assert.assertEquals(afterCount, beforeCount + 20, "User was able to add the product more than 20 times");
            } else {
                afterCount = getItemsCountFromCartInCartDetailpage();
                Assert.assertEquals(afterCount, beforeCount + productCount, "User was not able to add the product desired number of times");
                itemAvailable = true;
            }
        }

        return itemAvailable;
    }

    public boolean addBogoProductsOnBogoProductDetailPage(int productCount) throws InterruptedException {
        List<String> productInfoList = new ArrayList<String>();
        int maxScrolls = 10;
        boolean itemAdded = false;
        int counter = 0;
        while (!itemAdded) {
            while (counter < maxScrolls) {
                for (int i = 0; i < gg_deals_bogoPageElement.productCards.size(); i++) {
                    String currentProductInfo = "";
                    if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                        currentProductInfo = gg_deals_bogoPageElement.productCards.get(i).getAttribute("name");
                    } else {
                        currentProductInfo = gg_deals_bogoPageElement.productCards.get(i).getAttribute("content-desc");
                    }

                    if (!productInfoList.contains(currentProductInfo)) {
                        productInfoList.add(currentProductInfo);
                        new CommonActions(driver).new ClickAction().clickElement(gg_deals_bogoPageElement.productCards.get(i));

                        if (!isElementDisplayed(gg_deals_bogoPageElement.outOfStockLabel, 3)) {
                            if (addProductIfAvailableOnBogoDetailPage(productCount)) {
                                productAddedOnBogoDetailsPage = currentProductInfo;
                                itemAdded = true;
                                counter = maxScrolls;
                                driver.navigate().back();
                                break;
                            }
                        }

                        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                            new CommonActions(driver).new ClickAction().clickElement(gg_deals_bogoPageElement.backButton);
                        } else {
                            driver.navigate().back();
                        }
                    }
                }
                if (!itemAdded) {
                    swipeLeft();
                    counter++;
                }
            }
            if (counter >= maxScrolls) {
                break;
            }
        }

        return itemAdded;
    }

    public int getItemsCountFromCartInCartDetailpage() {
        String attributeName = driver.getPlatformName().equalsIgnoreCase("IOS") ? "value" : "text";
        return Integer.valueOf(gg_deals_bogoPageElement.cartInBogoDetailPage.getAttribute(attributeName).replaceAll("[^0-9]", ""));
    }

    public void addProductOnBogoListingPageVerifySameCountOnDetailsPage() throws InterruptedException {
        addMultipleBogoProductCountsToCartOnBogoListingPage(1);
        int currentAddedQtyOnBogoDetailPage;
        int currentAddedQtyOnBogoListingPage = getProductCountByNameOnBogoListingPage(productNameOnBogoListingPage);
        clickOnBOGOProductByNameOnBogoListingPage(productNameOnBogoListingPage);

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            currentAddedQtyOnBogoDetailPage = Integer.valueOf(gg_deals_bogoPageElement.currentAddedQuantity.getAttribute("value").split("in cart")[0].trim());
        } else {
            currentAddedQtyOnBogoDetailPage = Integer.valueOf(gg_deals_bogoPageElement.currentAddedQuantity.getText().split("in cart")[0].trim());
        }
        Assert.assertEquals(currentAddedQtyOnBogoDetailPage, currentAddedQtyOnBogoListingPage, "Count on BOGO landing page and BOGO detail page are not the same!!");
    }

    public int getProductCountByNameOnBogoListingPage(String productNameOnBogoListingPage) {
        int currentAddedQty = 0;
        String buttonXpathiOS = "";
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            buttonXpathiOS = String.format(CTA_BUTTON_DYNAMIC_XPATH_IOS, productNameOnBogoListingPage);
            currentAddedQty = Integer.valueOf(driver.findElement(By.xpath(buttonXpathiOS)).getAttribute("value"));
        } else {
            String qtyValueXpath = String.format(QUANTITY_BUTTON_DYNAMIC_XPATH_ANDROID, productNameOnBogoListingPage) + "/android.widget.TextView";
            currentAddedQty = Integer.valueOf(driver.findElement(By.xpath(qtyValueXpath)).getText());
        }
        return currentAddedQty;
    }

    public void clickOnBOGOProductByNameOnBogoListingPage(String productNameOnBogoListingPage) {
        String productCardXpath = "";
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            productCardXpath = String.format(BOGO_CARD_IOS, productNameOnBogoListingPage);
        } else {
            productCardXpath = String.format(BOGO_CARD_ANDROID, productNameOnBogoListingPage);
        }
        new CommonActions(driver).new ClickAction().clickElement(driver.findElement(By.xpath(productCardXpath)));
    }


    public void expandTheProductCategoryWithDealsHavingDesiredCount(int desiredCountValue, String dealsCategoryMatchOption) throws InterruptedException {
        Thread.sleep(3000);
        // Store category names
        List<String> categNames = new ArrayList<>();
        for (MobileElement indCategoryTitle : gg_deals_bogoPageElement.categoryTiles) {
            categNames.add(indCategoryTitle.getText());
        }
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                for (String categoryName : categNames) {
                    //Expand the category so deals are visible
                    new CommonActions(driver).new ClickAction().clickElement(findElementByLabel(categoryName));
                    Thread.sleep(3000);
                    int dealsCount = 0;
                    dealsCount = getDealsCountDisplayedOnCategoryWhenExpanded(categoryName);
                    //If a desired category is matched break the loop
                    if (dealsCategoryMatchOption.toLowerCase().contains("less")) {
                        if (dealsCount != 0 && dealsCount < desiredCountValue) {
                            isCategoryWithDesireCountFound = true;
                            break;
                        }
                    } else if (dealsCategoryMatchOption.toLowerCase().contains("more")) {
                        if (dealsCount != 0 && dealsCount >= desiredCountValue) {
                            isCategoryWithDesireCountFound = true;
                            break;
                        }
                    }
                    new CommonActions(driver).new ClickAction().clickElement(findElementByLabel(categoryName));
                    isCategoryWithDesireCountFound = false;
                }
                break;
            case "ANDROID":
                for (int cntVal = 0; cntVal < driver.findElements(By.id("tv_bogo_category_name")).size(); cntVal++) {
                    MobileElement indCategoryTitle = (MobileElement) driver.findElements(By.id("tv_bogo_category_name")).get(cntVal);
                    //Expand the category so deals are visible
                    new CommonActions(driver).new ClickAction().clickElement(indCategoryTitle);
                    Thread.sleep(3000);
                    int dealsCount = 0;
                    dealsCount = getDealsCountDisplayedOnCategoryWhenExpanded(indCategoryTitle.getText());
                    //If a desired category is matched break the loop
                    if (dealsCategoryMatchOption.toLowerCase().contains("less")) {
                        if (dealsCount != 0 && dealsCount < desiredCountValue) {
                            isCategoryWithDesireCountFound = true;
                            break;
                        }
                    } else if (dealsCategoryMatchOption.toLowerCase().contains("more")) {
                        if (dealsCount != 0 && dealsCount >= desiredCountValue) {
                            isCategoryWithDesireCountFound = true;
                            break;
                        }
                    }
                    new CommonActions(driver).new ClickAction().clickElement(gg_deals_bogoPageElement.collapseDropDownBogoDealsBtn);
                    isCategoryWithDesireCountFound = false;
                }
                break;
        }

    }

    public List<String> getDealNamesInCarouselView(int dealCnt) throws InterruptedException {
        List<String> dealNames = new ArrayList<String>();
        String lastDealCardName = "";
        DEAL_CARD_LOOP:
        for (int cntVal = 0; cntVal < dealCnt; cntVal++) {
            List<WebElement> dealCardsDisplayed = new ArrayList<WebElement>();
            final String attributeName = driver.getPlatformName().equalsIgnoreCase("ios") ? "text" : "content-desc";
            String prevDealCardName;
            switch (driver.getPlatformName().toUpperCase()) {
                case "IOS":
                    dealCardsDisplayed = driver.findElements(By.xpath("//XCUIElementTypeCell[@name='productCell']/XCUIElementTypeButton"));
                    prevDealCardName = dealCardsDisplayed.get(dealCardsDisplayed.size() - 1).getAttribute(attributeName);
                    break;
                case "ANDROID":
                    dealCardsDisplayed = driver.findElements(By.id("itemParentLayout"));
                    //Handle the case for the last See All card in Android
                    if (dealCardsDisplayed.get(dealCardsDisplayed.size() - 1).getAttribute(attributeName) == null) {
                        break DEAL_CARD_LOOP;
                    }
                    break;
            }
            // Fetch the text of all displayed cards if scroll exists

            if (lastDealCardName.equalsIgnoreCase(dealCardsDisplayed.get(dealCardsDisplayed.size() - 1).getAttribute(attributeName))) {
                break;
            }
            dealCardsDisplayed.forEach(indCard -> dealNames.add(indCard.getAttribute(attributeName)));
            lastDealCardName = dealCardsDisplayed.get(dealCardsDisplayed.size() - 1).getAttribute(attributeName);
            scroll(dealCardsDisplayed.get(dealCardsDisplayed.size() - 1).getLocation().getX(), dealCardsDisplayed.get(dealCardsDisplayed.size() - 1).getLocation().getY(), dealCardsDisplayed.get(0).getLocation().getX(), dealCardsDisplayed.get(0).getLocation().getY());
        }
        return dealNames.stream().distinct().collect(Collectors.toList());
    }

    public int getDealsCountDisplayedOnCategoryWhenExpanded(String categoryName) throws InterruptedException {
        int dealsCount = 0;
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                dealsCount = Integer.parseInt(findElementByLabel(categoryName).getText().replaceAll("[^0-9]", ""));
                break;
            case "ANDROID":
                dealsCount = Integer.parseInt(driver.findElement(By.xpath(String.format("//*[contains(@text,'%s')]//following-sibling::android.widget.TextView", categoryName))).getText().replaceAll("[^0-9]", ""));
                break;
        }
        return dealsCount;
    }

    public void swipeLeftTillSeeAll() {
        if (isCategoryWithDesireCountFound) {
            int counter = 1;
            int counter_max = 60;
            while (counter <= counter_max) {
                new SwipeActions().slideTheCardFromRightToLeft(gg_deals_bogoPageElement.productCards.get(1));
                if (isElementDisplayed(gg_deals_bogoPageElement.seeAlldeals, 1)) {
                    break;
                }
                counter++;
            }
        }
    }

    public boolean areBogoProductsInCarouselView() throws InterruptedException {
        if (!isCategoryWithDesireCountFound) {
            return true;
        } else {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                return hasCarouselView(gg_deals_bogoPageElement.productCards, "label");
            } else {
                return hasCarouselView(gg_deals_bogoPageElement.productCards, "content-desc");
            }
        }
    }


    public void navigateBackFromRelatedProductsPage() {

        new CommonActions(driver).new ClickAction().clickElement(gg_deals_bogoPageElement.backButton);

    }

    // Product must be added and productAddedOnBogoDetailsPage should be populated using addBogoProductsOnBogoProductDetailPage() prior to this
    public void decrementProductCountAndVerifyCountCart() throws InterruptedException {
        int beforeCount = getItemsCountFromCart();
        for (MobileElement product : gg_deals_bogoPageElement.productCards) {
            if (product.getAttribute("name").contentEquals(productAddedOnBogoDetailsPage)) {
                new CommonActions(driver).new ClickAction().clickElement(product);
                new CommonActions(driver).new ClickAction().clickElement(gg_deals_bogoPageElement.decrementQuantity);
                Thread.sleep(3000);
                Assert.assertEquals(getItemsCountFromCartInCartDetailpage(), beforeCount - 1, "Product was not removed from cart");
                break;
            }
        }
        driver.navigate().back();

    }
}












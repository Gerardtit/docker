package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.TapAction;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_ProductDetailsPageElements;
import com.automation.pageElements.GG_ProductsListingPageElements;
import com.automation.rest.cache.CommonCache;
import com.google.common.base.CharMatcher;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GG_ProductDetailsPage extends BasePage {

    private final GG_ProductDetailsPageElements gg_productDetailsPageElements = new GG_ProductDetailsPageElements();
    private final GG_ProductsListingPageElements gg_productsListingPageElements = new GG_ProductsListingPageElements();

    public GG_ProductDetailsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_productDetailsPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_productsListingPageElements);
    }

    public boolean addProductToCartAndRemove() throws InterruptedException {
        if (isElementDisplayed(gg_productsListingPageElements.closeToggleIt, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_productsListingPageElements.closeToggleIt);
        }
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
                        new CommonActions(driver).new ClickAction().clickElement(gg_productsListingPageElements.productCards.get(i));
                        if (addProductIfAvailableAndRemove()) {
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

    public void verifyAddToCartTextInPdp() {
        if (driver.getPlatformName().equalsIgnoreCase("Android")) {
            Assert.assertTrue(gg_productDetailsPageElements.addToCartButton.getAttribute("text").contains("ADD TO CART"));
        } else {
            Assert.assertTrue(gg_productDetailsPageElements.addToCartButton.getAttribute("label").contains("Add to Cart"));
        }
    }

    public boolean addProductIfAvailableAndRemove() throws InterruptedException {
        int beforeCount = getItemsCountFromCartInCartDetailPage();
        int afterCount = 0;
        boolean itemAvailable = false;

        if (isElementDisplayed(gg_productDetailsPageElements.addToCartButton, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_productDetailsPageElements.addToCartButton);
        } else if (isElementDisplayed(gg_productDetailsPageElements.incrementQuantity, 1)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_productDetailsPageElements.incrementQuantity);
        }
        Thread.sleep(3500);
        afterCount = getItemsCountFromCartInCartDetailPage();

        if (afterCount > beforeCount) {
            itemAvailable = true;
            // Removing/decrementing the item added
            if (isElementDisplayed(gg_productDetailsPageElements.decrementQuantity, 3)) {
                new CommonActions(driver).new ClickAction().clickElement(gg_productDetailsPageElements.decrementQuantity);
                Thread.sleep(3000);
            }

            afterCount = getItemsCountFromCartInCartDetailPage();
            Assert.assertEquals(afterCount, beforeCount, "Item count on cart did not reduce after removing the item");
        }

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new CommonActions(driver).new ClickAction().clickElement(gg_productDetailsPageElements.backButton);
        } else {
            driver.navigate().back();
        }
        return itemAvailable;
    }

    public boolean addMultipleProductCountsToCart(int productCount) throws InterruptedException {
        if (isElementDisplayed(gg_productsListingPageElements.closeToggleIt, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_productsListingPageElements.closeToggleIt);
        }
        List<String> productInfoList = new ArrayList<String>();
        int maxScrolls = 10;
        boolean itemAdded = false;
        int counter = 0;
        while (!itemAdded) {
            while (counter < maxScrolls) {
                for (int i = 0; i < gg_productsListingPageElements.productDescription.size(); i++) {
                    String currentProductInfo = "";
                    isElementDisplayed(gg_productsListingPageElements.productDescription.get(i), 5);
                    if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                        currentProductInfo = gg_productsListingPageElements.productDescription.get(i).getAttribute("name");
                    } else {
                        currentProductInfo = gg_productsListingPageElements.productCards.get(i).getAttribute("content-desc");
                    }

                    if (!productInfoList.contains(currentProductInfo)) {
                        productInfoList.add(currentProductInfo);
                        new CommonActions(driver).new ClickAction().clickElement(gg_productsListingPageElements.productDescription.get(i));
                        if (addProductIfAvailable(productCount)) {
                            itemAdded = true;
                            counter = maxScrolls;
                            break;
                        }

                        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                            new CommonActions(driver).new ClickAction().clickElement(gg_productDetailsPageElements.backButton);
                        } else {
                            driver.navigate().back();
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

    public boolean addProductIfAvailable(int productCount) throws InterruptedException {
        int afterCount;
        boolean itemAvailable = true;
        int currentAddedQty = 0;
        if (isElementDisplayed(gg_productDetailsPageElements.outOfStockLabel, 2)) {
            return false;
        }
        if (isElementDisplayed(gg_productDetailsPageElements.incrementQuantity, 2)) {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                if (gg_productDetailsPageElements.currentAddedQuantity.getAttribute("value").contains("max")) {
                    itemAvailable = false;
                } else {
                    if (gg_productDetailsPageElements.currentAddedQuantity.getAttribute("value").contains("in cart")) {
                        currentAddedQty = Integer.valueOf(gg_productDetailsPageElements.currentAddedQuantity.getAttribute("value").split("in cart")[0].trim());
                    }
                }
            } else {
                if (gg_productDetailsPageElements.currentAddedQuantity.getText().contains("max")) {
                    itemAvailable = false;
                } else {
                    if (gg_productDetailsPageElements.currentAddedQuantity.getText().contains("in cart")) {
                        currentAddedQty = Integer.valueOf(gg_productDetailsPageElements.currentAddedQuantity.getText().split("in cart")[0].trim());
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
            boolean clickedOnAdd;
            int beforeCount = getItemsCountFromCartInCartDetailPage();
            int i;
            for (i = 1; i <= productCount; i++) {
                clickedOnAdd = false;
                if (currentAddedQty > 0) {
                    new CommonActions(driver).new ClickAction().clickElement(gg_productDetailsPageElements.incrementQuantity);
                } else {
                    new TapAction(driver).tapCoordinate(gg_productDetailsPageElements.addToCartButton.getCenter().getX(), gg_productDetailsPageElements.addToCartButton.getCenter().getY());
                    Thread.sleep(3500);
                    currentAddedQty = currentAddedQty + 1;
                    clickedOnAdd = true;
                }
                new WaitAction(driver).waitForElementToBeClickable(gg_productDetailsPageElements.incrementQuantity, 5);
                if (!clickedOnAdd) {
                    Thread.sleep(3500);
                }
                Thread.sleep(4000);
            }

            if (productCount > 20 && i > 20) {
                new CommonActions(driver).new ClickAction().clickElement(gg_productDetailsPageElements.incrementQuantity);
                Thread.sleep(3000);

                // Verify that a maximum of 20 times a product can be added
                if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                    Assert.assertEquals(gg_productDetailsPageElements.currentAddedQuantity.getAttribute("value"), "20 max", "User was able to add the product more than 20 times");
                } else {
                    Assert.assertEquals(gg_productDetailsPageElements.currentAddedQuantity.getText(), "20 max", "User was able to add the product more than 20 times");
                }

                afterCount = getItemsCountFromCartInCartDetailPage();
                Assert.assertEquals(afterCount, 20, "User was able to add the product more than 20 times");
            } else {
                afterCount = getItemsCountFromCartInCartDetailPage();
                Assert.assertEquals(afterCount, beforeCount + productCount, "User was not able to add the product desired number of times");
                itemAvailable = true;
            }
        }

        return itemAvailable;
    }

    public int getItemsCountFromCartInCartDetailPage() {
        String attributeName = driver.getPlatformName().equalsIgnoreCase("IOS") ? "value" : "text";
        isElementDisplayed(gg_productDetailsPageElements.cartInProductDetailPage, 5);
        return Integer.valueOf(gg_productDetailsPageElements.cartInProductDetailPage.getAttribute(attributeName).replaceAll("[^0-9]", ""));
    }

    public void goBackToProductListingPage() {
        if (isElementDisplayed(gg_productDetailsPageElements.relatedProductsLabel, 2)) {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                new CommonActions(driver).new ClickAction().clickElement(gg_productDetailsPageElements.backButton);
            } else {
                driver.navigate().back();
            }
        }
    }

    public boolean isProductDetailsPageDisplayed() {
        waitForDisplayed(gg_productDetailsPageElements.relatedProductsLabel,5);
        scrollDownForElement(gg_productDetailsPageElements.relatedProductsLabel, 2);
        return isElementDisplayed(gg_productDetailsPageElements.relatedProductsLabel);
    }

    public void goBackToHomePage() {
        if (isElementDisplayed(gg_productsListingPageElements.filterButton, 3)) {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                new CommonActions(driver).new ClickAction().clickElement(gg_productDetailsPageElements.cancelButton);
            } else {
                driver.navigate().back();
            }
        }
    }

    public void goBackToHomePageFromProductDetailsPage() {
        if (!isElementDisplayed(gg_productsListingPageElements.filterButton, 3)) {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                new CommonActions(driver).new ClickAction().clickElement(gg_productDetailsPageElements.backButton);
                new CommonActions(driver).new ClickAction().clickElement(gg_productDetailsPageElements.cancelButton);
            } else {
                driver.navigate().back();
                new TapAction(driver).tapElement(gg_productDetailsPageElements.cancelButton);
            }

        }
        if (isElementDisplayed(gg_productsListingPageElements.filterButton, 3) && driver.getPlatformName().equalsIgnoreCase("android")) {
            new TapAction(driver).tapElement(gg_productDetailsPageElements.cancelButton);
        }
    }

    public void clickBackButtonOnProductDetailsPage() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new WaitAction(driver).waitForLoadingComplete();
            new CommonActions(driver).new ClickAction().clickElement(gg_productDetailsPageElements.backButton);
        } else {
            new WaitAction(driver).waitForLoadingComplete();
            driver.navigate().back();
        }
    }


    public void addMultipleProductCountsToCart(int productCount, String approxOrStrikethroughType) throws InterruptedException {
        int maxScrolls = 25;
        int counter = 0;
        boolean productFound = false;
        List<MobileElement> desiredElement = null;
        String filterAttribute = driver.getPlatformName().toUpperCase().contains("IOS") ? "label" : "content-desc";

        if (isElementDisplayed(gg_productsListingPageElements.closeToggleIt, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_productsListingPageElements.closeToggleIt);
        }

        PROD_FOUND:
        while (counter < maxScrolls) {
            switch (approxOrStrikethroughType) {
                case "BASIC":
                    desiredElement = gg_productsListingPageElements.productPriceCompleteTxt.stream().filter(indPriceElem -> !indPriceElem.getAttribute(filterAttribute).toLowerCase().contains("original") && !indPriceElem.getAttribute(filterAttribute).toLowerCase().contains("approx")).collect(Collectors.toList());
                    break;
                case "APPROX":
                    desiredElement = gg_productsListingPageElements.productPriceCompleteTxt.stream().filter(indPriceElem -> !indPriceElem.getAttribute(filterAttribute).toLowerCase().contains("original") && indPriceElem.getAttribute(filterAttribute).toLowerCase().contains("approx")).collect(Collectors.toList());
                    break;
                case "STRIKETHROUGH":
                    desiredElement = gg_productsListingPageElements.productPriceCompleteTxt.stream().filter(indPriceElem -> indPriceElem.getAttribute(filterAttribute).toLowerCase().contains("original") && !indPriceElem.getAttribute(filterAttribute).toLowerCase().contains("approx")).collect(Collectors.toList());
                    break;
                case "APPROX AND STRIKETHROUGH":
                    desiredElement = gg_productsListingPageElements.productPriceCompleteTxt.stream().filter(indPriceElem -> indPriceElem.getAttribute(filterAttribute).toLowerCase().contains("original") && indPriceElem.getAttribute(filterAttribute).toLowerCase().contains("approx")).collect(Collectors.toList());
                    break;
            }

            if (!desiredElement.isEmpty()) {
                new CommonActions(driver).new ClickAction().clickElement(desiredElement.get(0));
                productFound = true;
                break PROD_FOUND;
            }
            if (!productFound) {
                scrollDown();
                counter++;
            }
        }

        //Select Add the product
        if (productFound) {
            addProductIfAvailable(productCount);
        } else {
            throw new RuntimeException(approxOrStrikethroughType + " type product was not found");
        }
    }

    public String getProductQuantity() {
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                CommonCache.commonCache.put("PROD_QTY_DETAILS", CharMatcher.inRange('0', '9').retainFrom(gg_productDetailsPageElements.currentAddedQuantity.getAttribute("value")));
                break;
            case "ANDROID":
                CommonCache.commonCache.put("PROD_QTY_DETAILS", CharMatcher.inRange('0', '9').retainFrom(gg_productDetailsPageElements.currentAddedQuantity.getText()));
                break;
        }
        return CommonCache.commonCache.get("PROD_QTY_DETAILS");
    }

    public void decrementProductQuantity(int decrementCount) {
        for (int cntVal = 0; cntVal < decrementCount; cntVal++)
            if (isElementDisplayed(gg_productDetailsPageElements.decrementQuantity, 5)) {
                new CommonActions(driver).new ClickAction().clickElement(gg_productDetailsPageElements.decrementQuantity);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

    public void incrementProductQuantity(int incrementCnt) {
        for (int cntVal = 0; cntVal < incrementCnt; cntVal++)
            if (isElementDisplayed(gg_productDetailsPageElements.incrementQuantity, 5)) {
                new CommonActions(driver).new ClickAction().clickElement(gg_productDetailsPageElements.incrementQuantity);
            }
    }

    public void addDifferentProductsFromSearchResults(int desiredProductCount) {
        if (isElementDisplayed(gg_productsListingPageElements.closeToggleIt, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_productsListingPageElements.closeToggleIt);
        }
        List<String> productInfoList = new ArrayList<String>();
        int maxScrolls = 30;
        int currentProductAddedCount = 0;
        int scrollCounter = 0;
        SCROLL_LOOP:
        while (scrollCounter < maxScrolls) {
            for (int currentProduct = 0; currentProduct < gg_productsListingPageElements.productDescription.size(); currentProduct++) {
                String currentProductInfo = null;
                try {
                    currentProductInfo = driver.getPlatformName().equalsIgnoreCase("IOS") ?
                            gg_productsListingPageElements.productDescription.get(currentProduct).getAttribute("name") :
                            gg_productsListingPageElements.productCards.get(currentProduct).getAttribute("content-desc");
                } catch (Exception e) {
                    // Exception caught, that's ok moving on..
                }

                if (!productInfoList.contains(currentProductInfo)) {
                    productInfoList.add(currentProductInfo);
                    new CommonActions(driver).new ClickAction().clickElement(gg_productsListingPageElements.productDescription.get(currentProduct));
                    new WaitAction(driver).waitForElementToBeClickable(gg_productDetailsPageElements.relatedProductsViewAllLink, 5);
                    clickAddToCartOrIncrement();
                    currentProductAddedCount++;
                    if (currentProductAddedCount >= desiredProductCount) {
                        break SCROLL_LOOP;
                    }

                    if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                        new CommonActions(driver).new ClickAction().clickElement(gg_productDetailsPageElements.backButton);
                    } else {
                        driver.navigate().back();
                    }
                }
            }

            scrollDown();
            scrollCounter++;
        }
    }


    private void clickAddToCartOrIncrement() {
        if (isElementDisplayed(gg_productDetailsPageElements.addToCartButton, 10)) {
            new TapAction(driver).tapCoordinate(gg_productDetailsPageElements.addToCartButton.getCenter().getX(), gg_productDetailsPageElements.addToCartButton.getCenter().getY());
        } else {
            new CommonActions(driver).new ClickAction().clickElement(gg_productDetailsPageElements.incrementQuantity);
        }
    }

    public void clipDealsOnProductDetailsPageIfAvailable() {
        CommonActions.ClickAction clickHelper = new CommonActions(driver).new ClickAction();
        for (MobileElement indOffer : gg_productDetailsPageElements.dealOfferDetails) {
            clickHelper.clickIfEnabled(indOffer);
            if (isElementDisplayed(gg_productDetailsPageElements.clipDealBtnDetails)) {
                clickHelper.clickElement(gg_productDetailsPageElements.clipDealBtnDetails);
            }
            clickHelper.clickElement(gg_productDetailsPageElements.closeBtnDealDetails);
        }
    }

    public void clicksAllDealsProductDetails() {
        isElementDisplayed(gg_productDetailsPageElements.addToCartButton, 5);
        scrollDown();
        CommonActions.ClickAction clickHelper = new CommonActions(driver).new ClickAction();
        if (isElementDisplayed(gg_productDetailsPageElements.firstDealOffer, 3)) {
            for (MobileElement offer : gg_productDetailsPageElements.dealsOffersList) {
                clickHelper.clickElement(offer);
            }
        }
        scrollUp();
    }
}

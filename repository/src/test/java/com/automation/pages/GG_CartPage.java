package com.automation.pages;

import com.automation.helpers.LoaderUtil;
import com.automation.helpers.PageActions;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.TapAction;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_CartPageElements;
import com.automation.rest.cache.CommonCache;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.commons.lang.RandomStringUtils;
import org.awaitility.Awaitility;
import org.openqa.selenium.support.PageFactory;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GG_CartPage extends BasePage {
    private final GG_CartPageElements gg_cartPageElements = new GG_CartPageElements();

    public GG_CartPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_cartPageElements);
    }

    public void clickOnCart() {
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.cartIcon);
        waitForCartToLoad();
    }

    public void clickOnCartWithoutWait() {
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.cartIcon);
    }

    public void closeCartScreen() {
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.closeCartButton);
    }

    public void clickCloseCartBeforePlacingOrder() {
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.closeCartBeforePlaceOrderButton);
    }

    public void closeCartScreenIfDisplayed() {
        if (isElementDisplayed(gg_cartPageElements.closeCartButton, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.closeCartButton);
        }
    }

    public String getHeaderText() {
        return gg_cartPageElements.cartHeaderWithCount.getText();
    }

    public int getProductCountFromHeader() {
        return Integer.valueOf(gg_cartPageElements.cartHeaderWithCount.getText().replaceAll("[^0-9]", ""));
    }

    public void clickOfferComplete() {
        gg_cartPageElements.offerComplete.click();
    }

    public void verifyOfferComplete() {
        new WaitAction(driver).waitForDisplayed(gg_cartPageElements.offerCompleted);
    }

    private Map<String, Boolean> getPresenceOfBasicProductCard() {
        Map<String, Boolean> basicProductCardElemPresence = new HashMap<String, Boolean>();
        new WaitAction(driver).waitForDisplayed(gg_cartPageElements.productPriceCart, 5);
        basicProductCardElemPresence.put("Product Price", isElementDisplayed(gg_cartPageElements.productPriceCart));
        basicProductCardElemPresence.put("Product Title ", isElementDisplayed(gg_cartPageElements.productTitleCart));
        //basicProductCardElemPresence.put("Per Unit Price", isElementDisplayed(gg_cartPageElements.productPerUnitPriceCart));
        basicProductCardElemPresence.put("Product Substitute", isElementDisplayed(gg_cartPageElements.productLinkForSubstitutionCart));
        basicProductCardElemPresence.put("Product Note", isElementDisplayed(gg_cartPageElements.productLinkForNoteCart));
        basicProductCardElemPresence.put("Product Item Count", isElementDisplayed(gg_cartPageElements.productQuantity));
        //isElementDisplayed(gg_cartPageElements.productImageCart)&&
        return basicProductCardElemPresence;
    }

    private Map<String, Boolean> getPresenceOfApproxPrice() {
        Map<String, Boolean> productCardElemPresence = new HashMap<String, Boolean>();
        productCardElemPresence.put("Approx Price", isElementDisplayed(gg_cartPageElements.productApproxPriceCart));
        String attributeVal = driver.getPlatformName().toLowerCase().contains("ios") ? "label" : "text";
        productCardElemPresence.put("Approx Price Text", gg_cartPageElements.productApproxPriceCart.getAttribute(attributeVal).toLowerCase().contains("approx"));
        return productCardElemPresence;
    }

    private Map<String, Boolean> getPresenceOfStrikethroughPrice() {
        Map<String, Boolean> productCardElemPresence = new HashMap<String, Boolean>();
        productCardElemPresence.put("Strikethrough Price", isElementDisplayed(gg_cartPageElements.productPriceStrikethroughCart));
        return productCardElemPresence;
    }

    private Map<String, Boolean> getPresenceOfLongDescriptionProductCard() {
        Map<String, Boolean> productCardElemPresence = new HashMap<String, Boolean>();
        productCardElemPresence.put("Long Description", isElementDisplayed(gg_cartPageElements.productDescriptionLongCart));
        return productCardElemPresence;

    }

    public Map<String, Boolean> getPresenceOfProductCardInCart(String productType) {
        Map<String, Boolean> productCardElemPresence = new HashMap<String, Boolean>();
        switch (productType.toUpperCase()) {
            case "BASIC":
                productCardElemPresence.putAll(getPresenceOfBasicProductCard());
                break;
            case "APPROX":
                productCardElemPresence.putAll(getPresenceOfBasicProductCard());
                productCardElemPresence.putAll(getPresenceOfApproxPrice());
                break;
            case "STRIKETHROUGH":
                productCardElemPresence.putAll(getPresenceOfBasicProductCard());
                productCardElemPresence.putAll(getPresenceOfStrikethroughPrice());
                break;
            case "APPROX AND STRIKETHROUGH":
                productCardElemPresence.putAll(getPresenceOfBasicProductCard());
                productCardElemPresence.putAll(getPresenceOfApproxPrice());
                productCardElemPresence.putAll(getPresenceOfStrikethroughPrice());
                break;
            case "LONG DESCRIPTION":
                productCardElemPresence.putAll(getPresenceOfBasicProductCard());
                productCardElemPresence.putAll(getPresenceOfLongDescriptionProductCard());
                break;
        }
        return productCardElemPresence;
    }

    public List<String> getCategoryTitlesOfProductsInCart() {
        List<String> categoryNames = new ArrayList<String>();
        gg_cartPageElements.productCategoriesCart.forEach(indElem -> categoryNames.add(getText(indElem)));
        return categoryNames;
    }

    public void clickOnCartV2() {
        new WaitAction(driver).waitForDisplayed(gg_cartPageElements.cartIcon, 5);
        new TapAction(driver).tapCoordinate(gg_cartPageElements.cartIcon.getCenter().getX(), gg_cartPageElements.cartIcon.getCenter().getY());
        waitForCartToLoad();
    }

    public void clickOnCheckoutV2() {
        LoaderUtil.waitForCartLoaderToDisappear();
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.cartV2CheckoutCTA);
        LoaderUtil.waitForCartLoaderToDisappear();
    }

    public boolean isCartV2CheckoutDisabled() {
        if (isElementDisplayed(gg_cartPageElements.cartV2CheckoutCTA, 3)) {
            return !gg_cartPageElements.cartV2CheckoutCTA.isEnabled();
        }
        return false;
    }

    public boolean isCartV2TitleDisplayed() {
        return isElementDisplayed(gg_cartPageElements.cartHeaderWithCount);
    }

    public boolean verifySCPOnOffDisplayed() {
        return !isElementDisplayed(gg_cartPageElements.cartV2Element, 5);
    }

    public boolean isChangeSubstitutionButtonDisplayed() {
        return isElementDisplayed(gg_cartPageElements.changeSubstitution);
    }

    public boolean isFirstProductHighlighted() {
        return gg_cartPageElements.firstProductCard.getAttribute("focused").equals("true");
    }

    public boolean isCartV2CloseButtonDisplayed() {
        return isElementDisplayed(gg_cartPageElements.closeCartButton, 5);
    }

    public boolean isCartV2EmptyHeaderDisplayed() {
        return isElementDisplayed(gg_cartPageElements.cartHeaderWithCount);
    }

    public boolean isCartV2HappyShoppingDisplayed() {
        return isElementDisplayed(gg_cartPageElements.cartV2HappyShoppingText, 5);
    }

    public boolean verifySubstitutionCTANotDisplayed() {
        return !isElementDisplayed(gg_cartPageElements.substitutionCTAFirstProduct, 2);
    }

    public boolean isCartV2ShopNowCTADisplayed() {
        return isElementDisplayed(gg_cartPageElements.cartV2ShopNowCTA);
    }

    /* This will be developed in a separate story as per stand- up call
    public boolean isCartV2CheckoutCTADisplayed(){
        return isElementDisplayed(gg_cartPageElements.cartV2CheckoutCTA);
    }*/

    public boolean isCartV2ShopNowCTAEnabled() {
        if (isElementDisplayed(gg_cartPageElements.cartV2ShopNowCTA, 3)) {
            return gg_cartPageElements.cartV2ShopNowCTA.isEnabled();
        }
        return false;
    }
    /* This will be developed in a separate story as per stand- up call
    public boolean isCartV2ThresholdTextDisplayed(){
        return isElementDisplayed(gg_cartPageElements.cartV2ThresholdText);
    }*/

    public String getTextOfCartV2EmptyHeader() {
        return gg_cartPageElements.cartHeaderWithCount.getText();
    }

    public String getTextOfCartV2HappyShopping() {
        return gg_cartPageElements.cartV2HappyShoppingText.getText();
    }

    /* This will be developed in a separate story as per stand- up call
    public String getTextOfCartV2Threshold(){
        return gg_cartPageElements.cartV2ThresholdText.getText();
    }*/

    public void clickOnCartV2ShopNowCTA() {
        if (isElementDisplayed(gg_cartPageElements.cartV2ShopNowCTA, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.cartV2ShopNowCTA);
        }
    }

    public void clickOnBackButtonForDevice() {
        if (driver.getPlatformName().equalsIgnoreCase("ANDROID")) {
            navigateBack();
        } else {
            // This for iOS due it does not have navigate back, TBD
        }
    }

    // Returns name of 1st product or the only product
    public String getProductNameFromCart() {
        return driver.getPlatformName().equalsIgnoreCase("IOS") ? gg_cartPageElements.productTitleCart.getText() : gg_cartPageElements.productTitleCart.getAttribute("content-desc");
    }

    // Returns count of 1st product or the only product
    public Double getProductQuantity() {
        return Double.parseDouble(gg_cartPageElements.productQuantity.getText().replaceAll("[^\\d]", ""));
    }

    // Returns price of 1st product or the only product
    public Double getProductPrice() {
        return driver.getPlatformName().equalsIgnoreCase("IOS")
                ? Double.parseDouble(gg_cartPageElements.productPriceCart.getText().split("otal Price is")[1].split(", ")[0].split("\\$")[1])
                : Double.parseDouble(gg_cartPageElements.productPriceCart.getText().split("\\$")[1].trim());
    }

    public boolean isSubstitutionCTADisplayedForProduct() {
        return isElementDisplayed(gg_cartPageElements.productLinkForSubstitutionCart);
    }

    public boolean isAddNoteCTADisplayedForProduct() {
        return isElementDisplayed(gg_cartPageElements.productLinkForNoteCart);
    }

    public boolean isApproxLabelDisplayedForProduct() {
        return isElementDisplayed(gg_cartPageElements.productApproxPriceCart, 5);
    }

    public boolean isStrikeThroughDisplayedForProduct() {
        return isElementDisplayed(gg_cartPageElements.productPriceStrikethroughCart, 5);
    }

    public Double getStrikeThroughPriceValue() {
        if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
            return Double.parseDouble(gg_cartPageElements.productPriceStrikethroughCart.getText().split("\\$")[2].split(" ")[0]);
        }
        return Double.parseDouble(gg_cartPageElements.productPriceStrikethroughCart.getText().split("\\$")[1]);
    }

    public boolean isAgeRestrictionLabelDisplayed() {
        return isElementDisplayed(gg_cartPageElements.ageRestrictedLabel);
    }


    public int getCountDisplayedOnCartIcon() {
        if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
            int actualCount = Integer.parseInt(gg_cartPageElements.cartIcon.getAttribute("value").split(" ")[0]);
            return actualCount;
        } else {
            return Integer.parseInt(gg_cartPageElements.cartIconCount.getText());
        }
    }

    public boolean isEstSubTotalDisplayed() {
        return isElementDisplayed(gg_cartPageElements.cartV2EstSubtotal);
    }

    public boolean isCartV2EstSubTotalAmountDisplayed() {
        return isElementDisplayed(gg_cartPageElements.cartV2EstSubtotalAmount);
    }

    public String getTextOfEstSubTotal() {
        return gg_cartPageElements.cartV2EstSubtotal.getText();
    }

    public List<String> getTextOfEstSubTotalAmount() {
        ArrayList<String> estTotal;
        if (driver.getPlatformName().equalsIgnoreCase("ANDROID")) {
            String estTotalAll = gg_cartPageElements.cartV2EstSubtotalAmount.getText();
            estTotal = new ArrayList<String>(Arrays.asList(estTotalAll.replaceAll("\\$", "").split(" ")));
            return estTotal;
        } else {
            String estTotalAll = gg_cartPageElements.cartV2EstSubtotalAmount.getAttribute("label");
            //Est total for strikethrough has 2 values
            estTotal = new ArrayList<String>(Arrays.asList(estTotalAll.replaceAll("[^0-9.,]", "").split(",")));
            return estTotal;
        }
    }

    public boolean isCartV2EstSubTotalStrikeThroughAmountDisplayed() {
        if (driver.getPlatformName().equalsIgnoreCase("ANDROID")) {
            return isElementDisplayed(gg_cartPageElements.cartV2EstSubtotalStrikeThroughAmount);
        } else {
            return gg_cartPageElements.cartV2EstSubtotalAmount.getAttribute("label").contains("Original total");
        }

    }

    public String getTextOfEstSubTotalStrikeThroughAmount() {
        if (driver.getPlatformName().equalsIgnoreCase("ANDROID")) {
            return gg_cartPageElements.cartV2EstSubtotalStrikeThroughAmount.getText();
        } else {
            return gg_cartPageElements.cartV2EstSubtotalAmount.getAttribute("label").split(",")[1].trim().split(" ")[2];
        }

    }

    public boolean isCartV2CartSummaryDisplayed() {
        scrollDownForElement(gg_cartPageElements.cartV2CartSummary, 10);
        return isElementDisplayed(gg_cartPageElements.cartV2CartSummary);
    }

    public String getTextOfCartSummary() {
        return gg_cartPageElements.cartV2CartSummary.getText();
    }

    public boolean isCartV2ItemsWithCountDisplayed() {
        scrollDownForElement(gg_cartPageElements.cartV2CartItemsWithCount, 10);
        return isElementDisplayed(gg_cartPageElements.cartV2CartItemsWithCount);
    }

    public boolean isCartV2ItemsPriceDisplayed() {
        scrollDownForElement(gg_cartPageElements.cartV2CartItemsWithCount, 10);
        return isElementDisplayed(gg_cartPageElements.cartV2CartItemsPrice);
    }

    public String getTextOfItemsCount() {
        return gg_cartPageElements.cartV2CartItemsWithCount.getText();
    }

    public List<String> getTextOfItemsPrice() {
        ArrayList<String> estTotal;
        String itemsPrice = gg_cartPageElements.cartV2CartItemsPrice.getText();
        if (driver.getPlatformName().equalsIgnoreCase("ANDROID")) {
            estTotal = new ArrayList<String>(Arrays.asList(itemsPrice.split(" ")));
        } else {
            //Est total for strikethrough has 2 values
            estTotal = new ArrayList<String>(Arrays.asList(itemsPrice.replaceAll("[^0-9.,\\$]", "").split(",")));
        }
        return estTotal;
    }

    public boolean isCartV2EstimatedSavingsDisplayed() {
        return isElementDisplayed(gg_cartPageElements.cartV2EstimatedSavings, 5);
    }

    public boolean isCartV2EstimatedSavingsValueDisplayed() {
        return isElementDisplayed(gg_cartPageElements.cartV2EstimatedSavingsValue);
    }

    public String getTextOfEstimatedSavings() {
        return gg_cartPageElements.cartV2EstimatedSavings.getText();
    }

    public String getTextOfEstimatedSavingsValue() {
        return gg_cartPageElements.cartV2EstimatedSavingsValue.getText();
    }

    public String getEstimatedSavingsValue() {
        scrollDownForElement(gg_cartPageElements.cartV2EstimatedSavingsValue);
        return gg_cartPageElements.cartV2EstimatedSavingsValue.getText().replaceAll("[^0-9.]", "");
    }

    public boolean isCartV2MemberPriceSavingsDisplayed() {
        return isElementDisplayed(gg_cartPageElements.cartV2MemberPriceSavings, 10);
    }

    public boolean isCartV2EmployeeSavingsDisplayed() {
        return isElementDisplayed(gg_cartPageElements.cartV2EmployeeSavings);
    }

    public boolean isCartV2ClubCardSavingsDisplayed() {
        return isElementDisplayed(gg_cartPageElements.cartV2ClubCardSavings);
    }

    public boolean isCartV2MemberPriceSavingsValueDisplayed() {
        return isElementDisplayed(gg_cartPageElements.cartV2MemberPriceSavingsValue);
    }

    public String getTextOfMemberPriceSavings() {
        scrollDownForElement(gg_cartPageElements.cartV2MemberPriceSavings);
        return gg_cartPageElements.cartV2MemberPriceSavings.getText();
    }

    public String getTextOfClubCardSavingsValue() {
        return gg_cartPageElements.cartV2MemberPriceSavingsValue.getText();
    }

    public boolean isCartV2StaticTextEstSubtotalDisplayed() {
        return isElementDisplayed(gg_cartPageElements.cartV2StaticTextEstSubtotal);
    }

    public String getTextOfCartV2StaticTextEstSubtotal() {
        return gg_cartPageElements.cartV2StaticTextEstSubtotal.getText();
    }

    public String getTextOfCartV2DisclaimerText() {
        return gg_cartPageElements.getTextOfCartV2DisclaimerText.getText();
    }

    public int getItemsCountFromSummary() {
        scrollDownForElementWithSmallScroll(gg_cartPageElements.cartV2CartItemsWithCount, 10);
        return Integer.valueOf(gg_cartPageElements.cartV2CartItemsWithCount.getText().replaceAll("[^0-9]", ""));
    }

    public boolean isUnavailableItemDisplayed() {
        String attributeVal = driver.getPlatformName().toLowerCase().contains("ios") ? "label" : "text";
        return isElementDisplayed(gg_cartPageElements.itemsUnavailableWarningMsg, 5) && gg_cartPageElements.itemsUnavailableWarningMsg.getAttribute(attributeVal).contains("unavailable");
    }

    public void clickOnCartV2EstimatedSavingsInfoIcon() {
        scrollDownForElement(gg_cartPageElements.cartV2EstimatedSavingsInfoIcon, 10);
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.cartV2EstimatedSavingsInfoIcon);
    }

    public boolean isCartV2EstimatedSavingsSheetHeaderDisplayed() {
        return isElementDisplayed(gg_cartPageElements.cartV2EstimatedSavingsSheetHeader);
    }

    public boolean isCartV2EstimatedSavingsSheetCloseButtonDisplayed() {
        return isElementDisplayed(gg_cartPageElements.cartV2EstimatedSavingsSheetCloseButton);

    }

    public String getTextOfCartV2EstimatedSavingsSheetHeader() {
        return gg_cartPageElements.cartV2EstimatedSavingsSheetHeader.getText();

    }

    public void clickOnCartV2EstimatedSavingsSheetCloseButton() {
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.cartV2EstimatedSavingsSheetCloseButton);
    }

    public boolean isCartV2EstimatedSavingsSheetStaticTextDisplayed() {
        return isElementDisplayed(gg_cartPageElements.cartV2EstimatedSavingsSheetStaticText);
    }

    public String getTextOfCartV2EstimatedSavingsSheetStaticText() {
        return gg_cartPageElements.cartV2EstimatedSavingsSheetStaticText.getText();
    }

    public void clickOnProductQuantity() {
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.productQuantity);
    }

    public void clickOnQuantityOfDesiredProduct(int productIndex) {
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.productQuantities.get(productIndex - 1));
    }

    public void clickOnNameOfDesiredProduct(int productIndex) {
        if (driver.getPlatformName().equalsIgnoreCase("IOS")) productIndex = productIndex - 1;
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.productNamesList.get(productIndex - 1));
    }

    public HashMap<String, Boolean> getQuantityStepperElementsPresence() {
        HashMap<String, Boolean> stepperElementsMap = new HashMap<>();
        if (gg_cartPageElements.stepperQty.getText().equalsIgnoreCase("1")) {
            if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
                stepperElementsMap.put("QUANTITY_TEXT", isElementDisplayed(gg_cartPageElements.stepperView, 5));
            } else {
                stepperElementsMap.put("REMOVE_BUTTON", gg_cartPageElements.decrementProductQty.getAttribute("content-desc").contains("remove"));
            }
        } else {
            stepperElementsMap.put("DECREMENT_BUTTON", isElementDisplayed(gg_cartPageElements.stepperView, 5));
        }

        stepperElementsMap.put("INCREMENT_BUTTON", isElementDisplayed(gg_cartPageElements.stepperView, 5));
        stepperElementsMap.put("QUANTITY_TEXT", isElementDisplayed(gg_cartPageElements.stepperView, 5));

        return stepperElementsMap;
    }

    public boolean isQuantityStepperDisplayed() {
        return isElementDisplayed(gg_cartPageElements.stepperView, 3);
    }

    public void incrementProductQuantity() {
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                new TapAction(driver).tapCoordinate(gg_cartPageElements.stepperView.getCenter().getX() + gg_cartPageElements.stepperView.getSize().getWidth() / 3, gg_cartPageElements.stepperView.getCenter().getY());
                break;
            case "ANDROID":
                new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.incrementProductQty);
                break;
        }
    }


    public void incrementProductQuantity(int qty) throws InterruptedException {
        tapCoordinate(gg_cartPageElements.stepperQty.getCenter().getX(), gg_cartPageElements.stepperQty.getCenter().getY());

        for (int i = 0; i < qty; i++) {
            switch (driver.getPlatformName().toUpperCase()) {
                case "IOS":
                    waitForDisplayed(gg_cartPageElements.stepperView);
                    tapCoordinate(gg_cartPageElements.stepperView.getCenter().getX() + gg_cartPageElements.stepperView.getSize().getWidth() / 3, gg_cartPageElements.stepperView.getCenter().getY());
                    Thread.sleep(2000);
                    break;
                case "ANDROID":
                    new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.incrementProductQty);
                    break;
            }
        }
    }


    public void decrementProductQuantity() {
        isElementDisplayed(gg_cartPageElements.stepperView, 4);
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                new TapAction(driver).tapCoordinate(gg_cartPageElements.stepperView.getCenter().getX() - gg_cartPageElements.stepperView.getSize().getWidth() / 3, gg_cartPageElements.stepperView.getCenter().getY());
                break;
            case "ANDROID":
                new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.decrementProductQty);

                break;
        }
    }

    public int getProductCountFromStepper() {
        return Integer.parseInt(gg_cartPageElements.stepperQty.getText().replaceAll("[^\\d]", ""));
    }

    public String getTextOfUnavailable() {
        return gg_cartPageElements.unavailableLabel.getText();
    }

    public String getTextOfUnavailableProductHeader() {
        return gg_cartPageElements.unavailableProductHeaderLabel.getText();
    }

    public boolean isViewSimilarCTADisplayed() {
        new WaitAction(driver).waitForElementToBeClickable(gg_cartPageElements.viewSimilarCTA.get(0), 5);
        return isElementDisplayed(gg_cartPageElements.viewSimilarCTA.get(0));
    }

    public boolean verifyOrderMinimumAmountMessage() {
        return isElementDisplayed(gg_cartPageElements.orderMinimumAmountMessage);
    }

    public float getAmountToReachOrderMinimum() {

        if (driver.getPlatformName().toUpperCase().equals("ANDROID")) {
            new WaitAction(driver).waitForDisplayed(gg_cartPageElements.orderMinimumAmountMessage);

            return Float.parseFloat(gg_cartPageElements.orderMinimumAmountMessage.getText().replaceAll("[^0-9.]", ""));
        } else {
            return Float.parseFloat(gg_cartPageElements.orderMinimumAmountMessage.getAttribute("label").split(",")[0].split(" ")[1].replace("$", ""));
        }
    }

    public boolean verifyThresholdMessageIsNotShown() {
        return isElementDisplayed(gg_cartPageElements.orderMinimumAmountMessage);
    }

    public double getEstSubTotalAmount() {
        if (isElementDisplayed(gg_cartPageElements.cartV2HappyShoppingText)) {
            return 0;
        } else {
            double estSubTotalAmount = 0;
            switch (driver.getPlatformName().toUpperCase()) {
                case "ANDROID":
                    estSubTotalAmount = Double.parseDouble(gg_cartPageElements.cartV2EstSubtotalAmount.getAttribute("content-desc").split(",")[0].replaceAll("[^0-9.]", ""));
                    break;
                case "IOS":
                    estSubTotalAmount = Double.parseDouble(gg_cartPageElements.cartV2EstSubtotalAmount.getText().split("\\$")[1].split(",")[0]);
                    break;
            }
            return estSubTotalAmount;
        }
    }

    public void clickOnCartSummary() {
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.cartV2CartSummary);
    }

    public boolean isIncrementButtonEnabled() {
        boolean isIncrementEnabled = false;
        if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
            int prodCntBeforeIncrement = getProductCountFromHeader();
            incrementProductQuantity();
            int prodCntAfterIncrement = getProductCountFromHeader();
            if (prodCntAfterIncrement > prodCntBeforeIncrement) {
                isIncrementEnabled = true;
                decrementProductQuantity();
            }
        } else {
            if (gg_cartPageElements.incrementProductQty.getAttribute("enabled").contains("true")) {
                isIncrementEnabled = true;
            }
        }
        return isIncrementEnabled;
    }

    public void swipeAcrossAProductCardToDeleteItInCart() {
        new PageActions(driver).new SwipeActions().slideAcrossTheCardFromRightToLeft(gg_cartPageElements.productName.get(0));
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.removeBtnCart);
        }
    }

    public boolean checkIfRemoveBtnIsDisplayed() {
        return isElementDisplayed(gg_cartPageElements.removeBtnCart);
    }

    public void clickOnRemoveBtn() {
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.removeBtnCart);
        LoaderUtil.waitForCartLoaderToDisappear();
    }

    public void swipePartiallyAcrossTheFirstProductInCart() {
        new WaitAction(driver).waitForDisplayed(gg_cartPageElements.productName.get(0), 4);
        swipeLeftOnElement(gg_cartPageElements.productName.get(0));
    }

    public String getCartSummaryTotalAmount() {
        return getText(gg_cartPageElements.cartSummaryTotalAmount);
    }

    public String getMinimumCartValueForCheckout() {
        return getText(gg_cartPageElements.minimumOrderAmountForCheckout);
    }

    public boolean isErrorMessageDisplayedOnIncrementInOffline() {
        boolean isDisplayed = false;
        if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
            isDisplayed = isElementDisplayed(gg_cartPageElements.serviceProblemMsg, 5);
        } else {
            isDisplayed = isElementDisplayed(gg_cartPageElements.networkProblemMsg, 5);
        }
        if (isDisplayed) new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.okBtnErrorMsg);
        return isDisplayed;
    }

    public boolean isNetworkErrorDisplayed() {
        boolean isDisplayed = isElementDisplayed(gg_cartPageElements.networkProblemMsg);
        if (isDisplayed) new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.okBtnErrorMsg);
        return isDisplayed;
    }

    private void waitForCartToLoad() {
        for (int i = 0; i < 5; i++) {
            if (isElementDisplayed(gg_cartPageElements.productQuantity, 1) || isElementDisplayed(gg_cartPageElements.cartV2HappyShoppingText, 1)) {
                break;
            }
        }
    }

    public void clickOnAProductInCartPage() {
        new WaitAction(driver).waitForElementToBeClickable(gg_cartPageElements.productName.get(0), 4);
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.productName.stream().filter(indProduct -> isElementDisplayed(indProduct)).findFirst().get());
    }

    public void clickOnEstimatedSubtotalLabel() {
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.cartV2EstSubtotal);
        waitForCartToLoad();
    }

    public void clickOnAProductInCartPageForUnavailableProducts() {
        new WaitAction(driver).waitForElementToBeClickable(gg_cartPageElements.productCardUnavailable.get(0), 4);
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.productCardUnavailable.stream().filter(indProduct -> isElementDisplayed(indProduct)).findFirst().get());
    }

    public void clickOnViewSimilarItemsCTA() {
        new WaitAction(driver).waitForElementToBeClickable(gg_cartPageElements.viewSimilarCTA.get(0), 4);
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.viewSimilarCTA.stream().filter(indProduct -> isElementDisplayed(indProduct)).findFirst().get());
    }

    public boolean getPresenceOfRemoveBtn() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            return isElementDisplayed(gg_cartPageElements.removeBtnCart, 4) && gg_cartPageElements.removeBtnCart.getAttribute("content-desc").contains("Remove");
        }
        return isElementDisplayed(gg_cartPageElements.removeBtnCart, 4) && gg_cartPageElements.removeBtnCart.getAttribute("name").contains("Remove");
    }

    public int getProductCountFromCartForUnavailableItems() {
        new WaitAction(driver).waitForDisplayed(gg_cartPageElements.cartV2Categories.get(0), 5);
        return Integer.parseInt(gg_cartPageElements.cartV2Categories.get(0).getText().replaceAll("[^\\d]", ""));

    }


    public boolean verifyRelatedProductsPageTitleText() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            return gg_cartPageElements.relatedProductsPageTitle.getAttribute("text").equalsIgnoreCase("Related Products");
        } else {
            return gg_cartPageElements.relatedProductsPageTitle.getAttribute("name").equalsIgnoreCase("Related Products");
        }
    }

    public void clickBackBtnInRelatedProductsPage() {
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.backBtnInRelatedProductsPage);
    }

    public String getCartCountInRelatedProductsScreen() {
        String itemsCountInRelatedScreenPage = "";
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                itemsCountInRelatedScreenPage = gg_cartPageElements.cartCountInRelatedProductsScreen.getAttribute("text");
                break;
            case "IOS":
                itemsCountInRelatedScreenPage = gg_cartPageElements.cartCountInRelatedProductsScreen.getAttribute("value").replaceAll("[^0-9]", "");
                break;
        }
        return itemsCountInRelatedScreenPage;
    }

    public boolean verifyViewSimilarCTALocatedInOutOfStockCardText() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            return gg_cartPageElements.outOfStockCard.getAttribute("text").contains("Out of Stock");
        } else {
            return gg_cartPageElements.outOfStockCard.getAttribute("name").contains("Out of stock");
        }
    }

    public boolean verifyViewSimilarCTAIsNotLocatedInStockCardText() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            return gg_cartPageElements.inStockCard.getAttribute("text").contains("Out of Stock");
        } else {
            return gg_cartPageElements.inStockCard.getAttribute("name").contains("Out of stock");
        }
    }

    public void clickSubstitution() {
        isElementDisplayed(gg_cartPageElements.productLinkForSubstitutionCart, 5);
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.productLinkForSubstitutionCart);
        LoaderUtil.waitForSubstitutionsLoaderToDisappear();
        waitForDefaultSubToBeSelected();
    }

    private void waitForDefaultSubToBeSelected() {
        WaitAction.waitForElementToBeEnabled(gg_cartPageElements.confirmSubstitutionButton, 3);
    }

    public void clickOkSetSubstitutionForOtherItems() {
        isElementDisplayed(gg_cartPageElements.buttonOkSetSubstitutionForOtherItems, 5);
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.buttonOkSetSubstitutionForOtherItems);
    }

    public void clickNoSetSubstitutionForOtherItems() {
        isElementDisplayed(gg_cartPageElements.buttonNoSetSubstitutionForOtherItems, 5);
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.buttonNoSetSubstitutionForOtherItems);
    }

    public String getSubstitutionSheetTitleText() {
        return gg_cartPageElements.substitutionTitle.getText();
    }

    public String getSubstitutionSheetQuestionText() {
        return gg_cartPageElements.substitutionQuestion.getText();
    }

    public String getSubstitutionSheetSameBrandText() {
        return gg_cartPageElements.sameBrand.getText();
    }

    public String getSubstitutionSheetSameSizeText() {
        return gg_cartPageElements.sameSize.getText();
    }

    public String getSubstitutionSheetNoSubstitutionsText() {
        return gg_cartPageElements.noSubstitutions.getText();
    }

    public String getSubstitutionSheetSaveText() {
        return gg_cartPageElements.saveSubstitutionsBtn.getText();
    }

    public boolean isSubstitutionSheetCloseBtnIsDisplayed() {
        return isElementDisplayed(gg_cartPageElements.closeSubstitutionsBtn, 5);
    }

    public boolean verifySubstitutionLabelNotVisible() {
        return !isElementDisplayed(gg_cartPageElements.substitutionCTAFirstProduct, 5);
    }

    public boolean verifySetSubstitutionsPopUpDoesNotAppears() {
        return !isElementDisplayed(gg_cartPageElements.buttonNoSetSubstitutionForOtherItems, 3);
    }

    public String getNoSubstitutionCheckboxValue() throws InterruptedException {
        new WaitAction(driver).waitForElementToBeClickable(gg_cartPageElements.noSubstitutionCheckboxBtn, 3);
        // Need to add this wait, because on iOS it takes a second to refresh.
        Thread.sleep(2000);
        String res = "0";
        if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
            if (gg_cartPageElements.noSubstitutionCheckboxBtn.getAttribute("value") != null) {
                res = gg_cartPageElements.noSubstitutionCheckboxBtn.getAttribute("value");
            }
        } else {
            if (gg_cartPageElements.noSubstitutionCheckboxBtn.getAttribute("checked").equals("true")) {
                res = "1";
            }
        }
        return res;
    }

    public boolean isSubstitutionSheetSameBrandChecked() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            return Boolean.parseBoolean(gg_cartPageElements.sameBrand.getAttribute("checked"));
        } else {
            if (gg_cartPageElements.sameBrand.getAttribute("label").contains("Selected")) {
                return true;
            }
        }
        return false;
    }

    public void clickSubstitutionType(String substitutionName) {
        new WaitAction(driver).waitForElementToBeClickable(gg_cartPageElements.saveSubstitutionsBtn, 3);
        switch (substitutionName) {
            case "Same size":
                new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.sameSize);
                break;
            case "Same brand":
                new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.sameBrand);
                break;
            default:
                new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.noSubstitutions);
                break;
        }
    }

    public void clickSaveBtnOnSubstitutionSheet() {
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.saveSubstitutionsBtn);
    }

    public String isSubstitutionTypeChecked(String substitutionName) {
        new WaitAction(driver).waitForElementToBeClickable(gg_cartPageElements.saveSubstitutionsBtn, 3);
        switch (substitutionName) {
            case "Same size":
                if (driver.getPlatformName().equalsIgnoreCase("android")) {
                    return gg_cartPageElements.sameSize.getAttribute("checked");
                } else {
                    if (gg_cartPageElements.sameSize.getAttribute("label").contains("Selected")) {
                        return "true";
                    }
                }
                return "false";
            case "Same brand":
                if (driver.getPlatformName().equalsIgnoreCase("android")) {
                    return gg_cartPageElements.sameBrand.getAttribute("checked");
                } else {
                    if (gg_cartPageElements.sameBrand.getAttribute("label").contains("Selected")) {
                        return "true";
                    }
                }
                return "0";
            default:
                if (driver.getPlatformName().equalsIgnoreCase("android")) {
                    return gg_cartPageElements.noSubstitutions.getAttribute("checked");
                } else {
                    if (gg_cartPageElements.noSubstitutions.getAttribute("label").contains("Selected")) {
                        return "true";
                    }
                }
                return "false";
        }
    }

    public void clickCloseBtnOnSubstitutionSheet() {
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.closeSubstitutionsBtn);
    }

    public boolean isSubstitutionButtonInCardDisplayed() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            return isElementDisplayed(gg_cartPageElements.productLinkForSubstitutionCart, 3);
        }
        isElementDisplayed(gg_cartPageElements.productLinkForSubstitutionCart, 5);
        return gg_cartPageElements.productLinkForSubstitutionCart.getAttribute("visible") == "true";
    }

    public boolean isNoSubstitutionCheckboxIsDisplayed() {
        return isElementDisplayed(gg_cartPageElements.noSubstitutionCheckboxBtn);
    }

    public boolean isProp65WarningDisplayed() {
        return getText(gg_cartPageElements.prop65Warning).contentEquals("Prop 65 Warning");
    }


    public boolean isDeliveryOrPickUpCTADisplayed() {
        return isElementDisplayed(gg_cartPageElements.deliveryOrPickUpBtn, 5);
    }

    public boolean isPayInStoreCTADisplayed() {
        return isElementDisplayed(gg_cartPageElements.payInStoreBtn, 5);
    }

    public boolean isPayInStoreCTAEnabled() {
        return gg_cartPageElements.payInStoreBtn.isEnabled();
    }

    public void clickDeliveryOrPickUpCTA() {
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.deliveryOrPickUpBtn);
    }

    public void clickPayInStoreCTA() {
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.payInStoreBtn);
    }

    public void clickOnProp65WarningLabel() {
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.prop65Warning);
    }

    public Map<String, Object> checkProp65MessageSheet() {
        Map<String, Object> elementsMap = new HashMap<>();
        elementsMap.put("MESSAGE_SHEET_HEADER", isElementDisplayed(gg_cartPageElements.prop65WarningSheetHeader));
        elementsMap.put("MESSAGE_SHEET_MESSAGE_TEXT", getText(gg_cartPageElements.prop65WarningSheetMessage).trim());
        elementsMap.put("MESSAGE_SHEET_CLOSE", isElementDisplayed(gg_cartPageElements.prop65WarningSheetCloseBtn));
        return elementsMap;
    }

    public boolean isProp65WarningSheetDisplayed() {
        return isElementDisplayed(gg_cartPageElements.prop65WarningSheetHeader, 5);
    }

    public void clickCloseProp65MessageSheet() {
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.prop65WarningSheetCloseBtn);
    }

    public String getNoSubstitutionMessageText() {
        return getText(gg_cartPageElements.noSubstitutionCheckboxBtn);
    }

    public void clickNoSubstitutionCheckbox() {
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.noSubstitutionCheckboxBtn);
    }

    public void clickCheckOut() {
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.checkoutButton);
    }

    public int getCountOfAddNoteButtons() {
        return gg_cartPageElements.addNoteBtn.size();
    }

    public void clickOnAddNoteBtn() {
        Awaitility.await().atMost(10, TimeUnit.SECONDS).until(() -> gg_cartPageElements.addNoteBtn.size() != 0);
        gg_cartPageElements.addNoteBtn.get(0).click();
    }

    public boolean getPresenceOfAddNoteTitle() {
        return (isElementDisplayed(gg_cartPageElements.addNoteHeader, 5) && getText(gg_cartPageElements.addNoteHeader).contains("Shopper notes"));
    }

    public boolean getPresenceOfAddNoteCloseBtn() {
        return isElementDisplayed(gg_cartPageElements.addNoteCloseBtn);
    }

    public boolean getPresenceOfAddNoteSaveBtn() {
        return isElementDisplayed(gg_cartPageElements.addNoteSaveBtn);
    }

    public String getPlaceHolderTextForAddNote() {
        return getText(gg_cartPageElements.addNoteTextBox);
    }

    public void clickCloseAddNoteBtn() {
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.addNoteCloseBtn);
    }

    public String getAddNoteText() {
        return getText(gg_cartPageElements.addNoteTextBox);
    }

    public void addNoteText(String noteText) {
        isElementDisplayed(gg_cartPageElements.addNoteTextBox, 5);
        enterTextNoPressEnter(gg_cartPageElements.addNoteTextBox, noteText);
        androidNavigateBack();
    }

    public void clickSaveAddNote() {
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.addNoteSaveBtn);
    }

    public String getAddNoteCharLimitLabel() {
        String attributeVal = driver.getPlatformName().toUpperCase().contains("IOS") ? "label" : "text";
        return gg_cartPageElements.addNoteTextBox.getAttribute(attributeVal);
    }

    public int getMaxLimitForAddNote() {
        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher(getAddNoteCharLimitLabel());
        List<Integer> allNos = new ArrayList<Integer>();
        while (m.find()) {
            int n = Integer.parseInt(m.group());
            allNos.add(n);
        }
        return allNos.get(allNos.size() - 1);
    }

    public void addNoteTextForExceededValue() {
        String randomVal = RandomStringUtils.randomAlphabetic(getMaxLimitForAddNote() + 1);
        CommonCache.commonCache.put("ADD_NOTE_TEXT", randomVal);
        isElementDisplayed(gg_cartPageElements.addNoteTextBox, 5);
        enterTextNoPressEnter(gg_cartPageElements.addNoteTextBox, randomVal);
        androidNavigateBack();
    }

    public void swipePartiallyAcrossTheFirstProductInCartForUnavailableItems() {
        new WaitAction(driver).waitForDisplayed(gg_cartPageElements.productCardUnavailable.get(0), 4);
        new PageActions(driver).new SwipeActions().slidePartiallyAcrossTheCardFromRightToLeft(gg_cartPageElements.productCardUnavailable.get(0));
    }

    public boolean getPresenceOfAddNoteButtons() {
        boolean presenceVal = gg_cartPageElements.addNoteBtn.stream().filter(indElem -> indElem.isDisplayed()).collect(Collectors.toList()).size() != 0 ? true : false;
        return presenceVal;
    }

    public String getWysiQualifyingValue() {
        String wysiQualifyingValue = "";
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                wysiQualifyingValue = gg_cartPageElements.wysiQualifyingValue.getAttribute("text").replaceAll("[^0-9.]", "");
                break;
            case "IOS":
                wysiQualifyingValue = gg_cartPageElements.wysiQualifyingValue.getAttribute("label").split("\\$")[1].split(" ")[0].trim();
                break;
        }
        return wysiQualifyingValue;
    }

    public String getWysiQualifyingValueInEditOrder() {
        String wysiQualifyingValue = "";
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                new WaitAction(driver).waitForDisplayed(gg_cartPageElements.wysiQualifyingValueInEditOrder);
                wysiQualifyingValue = gg_cartPageElements.wysiQualifyingValueInEditOrder.getAttribute("text").replaceAll("[^0-9.]", "").trim();
                break;
            case "IOS":
                new WaitAction(driver).waitForDisplayed(gg_cartPageElements.wysiQualifyingValueInEditOrder);
                wysiQualifyingValue = gg_cartPageElements.wysiQualifyingValueInEditOrder.getAttribute("name").replaceAll("[^0-9.$]", "").split("\\$")[1];
                break;
        }
        return wysiQualifyingValue;
    }

    public String getSalesSavingsValue() {
        String salesSavingsValue = "";
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                scrollDown();
                salesSavingsValue = gg_cartPageElements.savingsList.get(0).getText().replaceAll("[^0-9.]", "");
                break;
            case "IOS":
                salesSavingsValue = gg_cartPageElements.savingsList.get(1).getText().replaceAll("[^0-9.]", "");
                break;
        }
        return salesSavingsValue;
    }

    public String getEmployeesSavingsValue() {
        String employeesSavingsValue = "";
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                scrollDown();
                employeesSavingsValue = gg_cartPageElements.savingsList.get(1).getAttribute("text").replaceAll("[^0-9.]", "");
                break;
            case "IOS":
                employeesSavingsValue = gg_cartPageElements.savingsList.get(2).getText().replaceAll("[^0-9.]", "");
                break;
        }
        return employeesSavingsValue;
    }

    public boolean verifyMemberPriceSavingsText() {
        scrollDownForElement(gg_cartPageElements.cartV2MemberPriceSavingsValue);
        return isElementDisplayed(gg_cartPageElements.cartV2MemberPriceSavings);
    }

    public boolean isCheckoutEnabled() {
        return gg_cartPageElements.checkoutButton.isEnabled();
    }

    public boolean isCheckoutDisplayed() {
        return isElementDisplayed(gg_cartPageElements.checkoutButton);
    }

    public String getCartDisclaimerMsg() {
        scrollDownForElement(gg_cartPageElements.storeDisclaimer, 3);
        if (isElementDisplayed(gg_cartPageElements.storeDisclaimer)) {
            return getText(gg_cartPageElements.storeDisclaimer);
        }
        return "NOT DISPLAYED";
    }

    public boolean isChangeSubstitutionCTADisplayedForProduct() {
        new WaitAction(driver).waitForLoadingComplete();
        String attributeVal = driver.getPlatformName().toLowerCase().contains("ios") ? "label" : "text";
        if (isElementDisplayed(gg_cartPageElements.productLinkForChangeSubstitutionCart, 3)) {
            return gg_cartPageElements.productLinkForChangeSubstitutionCart.getAttribute(attributeVal).contains("Edit Substitution");
        }
        return false;
    }


    public boolean verifyTextOfAppliedDeal() {
        scrollDownForElement(gg_cartPageElements.appliedLabelForAppliedDeal);
        return isElementDisplayed(gg_cartPageElements.appliedLabelForAppliedDeal);
    }

    public boolean verifyTextOfClippedDealLabel() {
        scrollDownForElement(gg_cartPageElements.clippedLabelForClippedDeal);
        return isElementDisplayed(gg_cartPageElements.clippedLabelForClippedDeal);
    }

    //gets the names of the products in a list in the cart
    public List<String> getProductsName() {
        List<String> listOfProducts = new ArrayList<String>();
        int productNamesList = gg_cartPageElements.productNamesList.size();
        int counter = gg_cartPageElements.productName.size();
        for (int i = 0; i < productNamesList; i++) {
            switch (driver.getPlatformName().toUpperCase()) {
                case "IOS":
                    listOfProducts.add(gg_cartPageElements.productNamesList.get(productNamesList - counter).getAttribute("label"));
                    break;
                case "ANDROID":
                    listOfProducts.add(gg_cartPageElements.productNamesList.get(productNamesList - counter).getText());
                    break;
            }
            counter--;
        }
        return listOfProducts;
    }

    public boolean isLoaderDisplayedUntilCartLoads() {
        if (isElementDisplayed(gg_cartPageElements.loadingSpinner, 3)) {
            return true;
        } else {
            // If loader is not displayed then product card MUST be displayed
            if (isElementDisplayed(gg_cartPageElements.productQuantity, 1)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void clickChangeSubstitution() {
        new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.changeSubstitution);
    }

    public Set<String> getAllTheProductsInTheCart() {
        Set<String> productNames = new LinkedHashSet<String>();
        //Fetch the names
        for (int cntVal = 0; cntVal < 15; cntVal++) {
            gg_cartPageElements.productNamesList.forEach(indProductName -> productNames.add(getText(indProductName)));
            if (isElementDisplayed(gg_cartPageElements.cartV2CartSummary, 2)) {
                break;
            }
            scrollDownBySmallAmount();
        }
        return productNames;
    }


    public Map<String, String> getSavingsDetails() {
        Map<String, String> savingDetails = new HashMap<String, String>();
        Iterator<MobileElement> savingDetailsLabel = gg_cartPageElements.savingsListLabels.iterator();
        Iterator<MobileElement> savingsDetailValue = gg_cartPageElements.savingsList.iterator();
        while (savingDetailsLabel.hasNext()) {
            MobileElement savingsCategoryName = savingDetailsLabel.next();
            if (isElementDisplayed(savingsCategoryName)) {
                savingDetails.put(getText(savingsCategoryName), getText(savingsDetailValue.next()));
            } else {
                savingsDetailValue.next();
            }
        }
        return savingDetails;
    }

    public void changeQuantity(int quantity) {

        for (int i = 0; i < quantity; i++) {

            if (driver.getPlatformName().equalsIgnoreCase("Android")) {
                new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.incrementProductQty);
            } else {
                tapCoordinate(gg_cartPageElements.stepperView.getCenter().getX() + gg_cartPageElements.stepperView.getSize().getWidth() / 3, gg_cartPageElements.stepperView.getCenter().getY());
            }
        }
    }
}

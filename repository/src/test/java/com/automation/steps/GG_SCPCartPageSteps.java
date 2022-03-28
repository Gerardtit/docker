package com.automation.steps;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_CartPage;
import com.automation.pages.GG_SCPPage;
import com.automation.rest.cache.CommonCache;
import com.automation.rest.cart.CartService;
import com.automation.rest.cart.model.GetCartItemsResponse;
import com.automation.rest.cart.model.Summary;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GG_SCPCartPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    private GG_SCPPage gg_scpPage = new GG_SCPPage(driver);
    private GG_CartPage gg_cartPage = new GG_CartPage(driver);
    private CartService cartService;

    public <T> List<Map<String, Object>> getCartItemsFromApi() throws ClassNotFoundException {
        List<Map<String, Object>> itemsList = null;
        cartService = new CartService(gg_cartPage.getCurrentBanner());
        T t = cartService.getCartItems(ThreadLocalHelper.testCaseData.get().get("USERNAME_CART_API"), ThreadLocalHelper.testCaseData.get().get("PASSWORD_CART_API"), ThreadLocalHelper.testCaseData.get().get("CUSTOMERID_CART_API"), ThreadLocalHelper.testCaseData.get().get("STOREID_CART_API"), "");
        if (Class.forName("java.lang.String").isInstance(t)) {
            Assert.assertTrue(false, "Get cart items api call failed, response: " + t);
        } else {
            GetCartItemsResponse getCartItemsResponse = (GetCartItemsResponse) t;
            itemsList = getCartItemsResponse.getCartItemsList();
            if (itemsList.size() == 0) {
                Assert.assertTrue(false, "Cart is empty!!");
            }
        }
        return itemsList;
    }


    @Then("verify scp {string} price UI and API for first card on cart scp page")
    public <T> void verifyUIAndAPIValuesInCardByType(String type) throws ClassNotFoundException {
        List<Map<String, Object>> itemsList = getCartItemsFromApi();
        Assert.assertTrue(gg_cartPage.isSubstitutionCTADisplayedForProduct(), "Substitution CTA is not displayed!");
        Assert.assertTrue(gg_cartPage.isAddNoteCTADisplayedForProduct(), "Add Note CTA is not displayed!");
        Assert.assertTrue(gg_scpPage.isQuantityStepperDisplayed(), "Add Note CTA is not displayed!");
        double netPromotionValueAPI = Double.parseDouble(String.valueOf(itemsList.get(0).get("netPromotionAmount")));
        double netPromotionValueUI = Double.parseDouble(gg_scpPage.netPromotionPrice());
        Assert.assertEquals(netPromotionValueUI, netPromotionValueAPI, "Net Promotion amount for " + type + " card is incorrect!");
        switch (type.toLowerCase()) {
            case "strikethrough":
                double netStrikethroughValueAPI = Double.parseDouble(String.valueOf(itemsList.get(0).get("basePrice")));
                double netStrikethroughValueUI = Double.parseDouble(gg_scpPage.strikethroughPrice());
                Assert.assertEquals(netStrikethroughValueAPI, netStrikethroughValueUI, "Strikethrough Price for " + type + " card is incorrect!");
                break;
            case "save_x":
            case "personalized":
                double netBaseValueAPI = Double.parseDouble(String.valueOf(itemsList.get(0).get("basePrice")));
                double netBaseValueUI = Double.parseDouble(gg_scpPage.strikethroughPriceWithPer());
                Assert.assertEquals(netBaseValueAPI, netBaseValueUI, "Base Price for " + type + " card is incorrect!");
                double netPromotionPerValueAPI = Double.parseDouble(String.valueOf(itemsList.get(0).get("netPromotionAmountPer")));
                double netPromotionPerValueUI = Double.parseDouble(gg_scpPage.netPromotionPerPrice());
                Assert.assertEquals(netPromotionPerValueAPI, netPromotionPerValueUI, "NetPromotionPer Price for " + type + " card is incorrect!");
                break;
            default:
                break;
        }
    }

    @Then("verify estimate subtotal price UI and API for first card on cart scp page")
    public <T> void verifySubtotalPriceUIAndAPI() throws ClassNotFoundException {
        Summary summary = getCartSummaryFromApi();
        double estimateValueAPI = Double.parseDouble(String.valueOf(summary.getTransactionTotal()));
        double estimateValueUI = Double.parseDouble(gg_scpPage.estSubTotalPriceWithDiscount());
        Assert.assertEquals(estimateValueAPI, estimateValueUI, "Estimate subtotal value is incorrect!");
    }

    @Then("verify UI price on first card is {string} on cart scp page")
    public void verifyUIPriceOnFirstCard(String value) {
        Assert.assertEquals(gg_scpPage.netPromotionPrice(), "0.00", "Value of first card is not :" + value);
    }

    private <T> Summary getCartSummaryFromApi() throws ClassNotFoundException {
        Summary summaryObj = null;
        cartService = new CartService(gg_cartPage.getCurrentBanner());
        T getCartResponse = cartService.getCartItems(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), CommonCache.commonCache.get("CUSTOMERID_CART_API"), ThreadLocalHelper.testCaseData.get().get("STOREID_CART_API"), "");
        if (Class.forName("java.lang.String").isInstance(getCartResponse)) {
            Assert.assertTrue(false, "Get cart items api call failed, response: " + getCartResponse);
        } else {
            GetCartItemsResponse getCartItemsResponse = (GetCartItemsResponse) getCartResponse;
            summaryObj = getCartItemsResponse.getSummary();
        }
        return summaryObj;
    }

    @Then("verify scp {string} UI for first card on cart scp page")
    public void verifyPromotionUI(String status) {
        switch (status.toLowerCase()) {
            case "applied":
                Assert.assertTrue(gg_scpPage.promotionApplied(), "Promotion is not applied!");
                break;
            case "clipped":
                Assert.assertTrue(gg_scpPage.promotionClipped(), "Promotion is not clipped!");
                break;
            default:
                break;
        }
    }

    @Then("{string} product quantity {int} times in quantity stepper on cart scp page")
    public void incrementDecreaseProductQty(String option, int numberOfIncrements) throws InterruptedException {
        gg_scpPage.clickQuantityIcon();
        for (int currentIncrement = 0; currentIncrement < numberOfIncrements; currentIncrement++) {
            Thread.sleep(3000);
            if (option.toLowerCase().equals("increment")) {
                gg_cartPage.incrementProductQuantity();
            } else if (option.toLowerCase().equals("decrement")) {
                gg_cartPage.decrementProductQuantity();
            }
        }
        gg_scpPage.closeStepper();
    }

    @Then("verify large size deals description on product card in cart page")
    public void verifyDealsDescriptionOnProductCardInCartPage() {
        Assert.assertEquals(gg_scpPage.getTheDealDecriptionFromProductCard().split("\\n").length > 1, true, "");
    }

    @And("get details of all product cards in the cart")
    public void getDetailsOfAllProductCardsInTheCart() {
        CommonCache.cartItems.put("Product_Cards_SCP", gg_scpPage.getPresenceOfAllProductCards());
    }

    @Then("verify products cards of {string} products for  Simplified Cart Pricing\\(SCP) elements")
    public void verifyProductsCardsOfRegularProductBOGOProductMultiDealProductSaveTypeDealProductPersonalisedPricingProductWeighedItemProductProductsForSimplifiedCartPricingSCPElements(String scpProductType) {

        List<String> productTypes = scpProductType.contains(",") ?
                new ArrayList<String>(Arrays.asList(scpProductType.split(","))) : new ArrayList<String>(Arrays.asList(scpProductType));
        Map<String, Map> scpProductCards = (Map<String, Map>) CommonCache.cartItems.get("Product_Cards_SCP");
        for (String dataProdKey : productTypes) {
            String prodNameOfTheType = ThreadLocalHelper.testCaseData.get().get(dataProdKey);
            // Add assert
            Map<String, Map> desiredProduct = scpProductCards.entrySet().stream().filter(indProduct -> indProduct.getKey().toLowerCase().replaceAll("\\s", "").contains(prodNameOfTheType.toLowerCase())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            performValidationForSCPElementsOnCartCards(dataProdKey, desiredProduct.entrySet().stream().findFirst().get().getValue());

        }
    }

    private void performValidationForSCPElementsOnCartCards(String cardType, Map<String, Boolean> prodCardElementStatus) {
        SoftAssert prodElementsAssert = new SoftAssert();
        prodElementsAssert.assertEquals(prodCardElementStatus.get("Description"), Boolean.TRUE, "The scp element not as expected for Description ");
        prodElementsAssert.assertEquals(prodCardElementStatus.get("Price"), Boolean.TRUE, "The scp element not as expected for Price ");
        prodElementsAssert.assertEquals(prodCardElementStatus.get("Quantity"), Boolean.TRUE, "The scp element not as expected for Quantity ");

        switch (cardType) {
            case "RegularProduct":
                prodElementsAssert.assertEquals(prodCardElementStatus.get("DealClippedStatus"), Boolean.FALSE, "The scp element not as expected for DealClippedStatus ");
                prodElementsAssert.assertEquals(prodCardElementStatus.get("DealAppliedStatus"), Boolean.FALSE, "The scp element not as expected for DealAppliedStatus ");
                prodElementsAssert.assertEquals(prodCardElementStatus.get("DiscountedPrice"), Boolean.FALSE, "The scp element not as expected for DiscountedPrice ");
                prodElementsAssert.assertEquals(prodCardElementStatus.get("PricePerQuantity"), Boolean.TRUE, "The scp element not as expected for PricePerQuantity ");
                break;
            case "BOGOProduct":
                prodElementsAssert.assertEquals(prodCardElementStatus.get("DealClippedStatus"), Boolean.TRUE, "The scp element not as expected for DealClippedStatus ");
                prodElementsAssert.assertEquals(prodCardElementStatus.get("DealAppliedStatus"), Boolean.FALSE, "The scp element not as expected for DealAppliedStatus ");
                prodElementsAssert.assertEquals(prodCardElementStatus.get("DiscountedPrice"), Boolean.FALSE, "The scp element not as expected for DiscountedPrice ");
                prodElementsAssert.assertEquals(prodCardElementStatus.get("PricePerQuantity"), Boolean.TRUE, "The scp element not as expected for PricePerQuantity ");
                break;
            case "MultiDealProduct":
                prodElementsAssert.assertEquals(prodCardElementStatus.get("DealClippedStatus"), Boolean.TRUE, "The scp element not as expected for DealClippedStatus ");
                prodElementsAssert.assertEquals(prodCardElementStatus.get("DealAppliedStatus"), Boolean.TRUE, "The scp element not as expected for DealAppliedStatus ");
                prodElementsAssert.assertEquals(prodCardElementStatus.get("DiscountedPrice"), Boolean.TRUE, "The scp element not as expected for DiscountedPrice ");
                prodElementsAssert.assertEquals(prodCardElementStatus.get("PricePerQuantity"), Boolean.FALSE, "The scp element not as expected for PricePerQuantity ");
                break;
            case "SaveTypeDealProduct":
                prodElementsAssert.assertEquals(prodCardElementStatus.get("DealClippedStatus"), Boolean.TRUE, "The scp element not as expected for DealClippedStatus ");
                prodElementsAssert.assertEquals(prodCardElementStatus.get("DealAppliedStatus"), Boolean.TRUE, "The scp element not as expected for DealAppliedStatus ");
                prodElementsAssert.assertEquals(prodCardElementStatus.get("DiscountedPrice"), Boolean.TRUE, "The scp element not as expected for DiscountedPrice ");
                prodElementsAssert.assertEquals(prodCardElementStatus.get("PricePerQuantity"), Boolean.TRUE, "The scp element not as expected for PricePerQuantity ");
                break;
            case "PersonalisedPricingProduct":
                // Add here once test data is received
                break;
            case "WeighedItemProduct":
                // Add here once test data is received WeighedItemProduct
                break;

        }
        prodElementsAssert.assertAll();

    }

    @And("user closes quantity stepper in cart screen")
    public void closeQuantityStepper() {
        gg_scpPage.closeStepper();
    }

    @Then("verify total price and individual count price of BOGO product after {string} the count to {int} in cart screen")
    public void verifyTotalPriceForProduct(int finalQtyOfProduct) throws ClassNotFoundException {
        List<Map<String, Object>> itemsList = getCartItemsFromApi();
        double expectedTotalPrice;
        double expectedIndividualCountPrice;
        if (finalQtyOfProduct == 1) {
            expectedTotalPrice = (double) itemsList.get(0).get("price");
        } else {
            if (finalQtyOfProduct % 2 == 0) {
                expectedTotalPrice = (finalQtyOfProduct / 2) * (double) itemsList.get(0).get("price");
            } else {
                expectedTotalPrice = ((finalQtyOfProduct - 1) / 2) * (Double) itemsList.get(0).get("price") + (Double) itemsList.get(0).get("price");
            }
            String stringVal = String.valueOf(expectedTotalPrice / finalQtyOfProduct);
            expectedIndividualCountPrice = Double.parseDouble(String.format("%.2f", stringVal));
            Assert.assertEquals(gg_scpPage.getPriceOfEachCountOfProduct(), expectedIndividualCountPrice, "Expected and actual price of individual count don't match in UI!!");
            Assert.assertEquals((double) itemsList.get(0).get("netPromotionAmountPer"), expectedIndividualCountPrice, "Expected and actual price of individual count don't match in API!!");
        }
        Assert.assertEquals(gg_scpPage.getTotalPriceOfProduct(), expectedTotalPrice, "Expected and actual total price don't match in UI!!");
        Assert.assertEquals((double) itemsList.get(0).get("netPromotionAmount"), expectedTotalPrice, "Expected and actual total price don't match in API!!");
    }

    @And("get and store total price of the product in cart screen")
    public void getAndStoreTotalPriceOfProduct() {
        CommonCache.commonCache.put("TOTAL_PRICE", String.valueOf(gg_scpPage.getTotalPriceOfProduct()));
    }

    @And("get and store price of individual count of the product in cart screen")
    public void getAndStorePriceOfEachCountOfProduct() {
        CommonCache.commonCache.put("INDIVIDUAL_COUNT_PRICE", String.valueOf(gg_scpPage.getPriceOfEachCountOfProduct()));
    }

    @Then("verify BOGO offer is {string} in cart screen")
    public void verifyOfferStatus(String status) {
        switch (status.toUpperCase()) {
            case "CLIPPED":
                Assert.assertTrue(gg_scpPage.isOfferClipped(), "Offer is not clipped!!");
                break;
            case "APPLIED":
                Assert.assertTrue(gg_scpPage.isOfferApplied(), "Offer is not applied!!");
                break;
        }
    }
}


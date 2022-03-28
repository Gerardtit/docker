package com.automation.steps;

import com.automation.helpers.LoaderUtil;
import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.models.HttpResponse;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.CommonUtil;
import com.automation.mobile.util.WaitAction;
import com.automation.pages.*;
import com.automation.rest.cache.CommonCache;
import com.automation.rest.cart.CartService;
import com.automation.rest.cart.model.GetCartItemsResponse;
import com.automation.rest.cart.model.Summary;
import com.google.common.collect.Ordering;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class GG_CartPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();

    private GG_CartPage gg_cartPage = new GG_CartPage(driver);
    private GG_DashboardPage gg_dashboardPage = new GG_DashboardPage(driver);
    private GG_SignInPage gg_signInPage = new GG_SignInPage(driver);

    private CartService cartService;
    private GG_CheckoutPage gg_checkoutPage = new GG_CheckoutPage(driver);

    public String getCurrentBanner() {
        return driver.getCapabilities().getCapability("banner").toString();
    }

    @Then("verify header on cart screen is {string}")
    public void verifyHeader(String expectedHeader) {
        Assert.assertEquals(gg_cartPage.getHeaderText().split("\\(")[0].trim(), expectedHeader, "Header on cart screen is not " + expectedHeader);
    }

    @Then("verify product count is displayed in header on cart screen")
    public void verifyCount() {
        Assert.assertTrue(Pattern.matches("[0-9]+", String.valueOf(gg_cartPage.getProductCountFromHeader())), "Product count in header on cart screen is not displayed");
    }

    @When("close cart screen")
    public void clickClose() {
        gg_cartPage.closeCartScreen();
    }

    @When("close cart before placing an order in cart screen")
    public void clickCloseCartBeforePlacingOrder() {
        gg_cartPage.clickCloseCartBeforePlacingOrder();
    }

    @And("user click offer complete text")
    public void userClickOfferCompleteText() {
        gg_cartPage.clickOfferComplete();
    }

    @Then("user see Offer Completed Text")
    public void userSeeOfferCompletedText() {
        gg_cartPage.verifyOfferComplete();
    }

    @When("close cart screen if displayed")
    public void clickCloseIfDisplayed() {
        gg_cartPage.closeCartScreenIfDisplayed();
    }

    @Then("verify {string} product {string} displayed in cart")
    public void verifyProductDisplayedInCart(String productType, String productPresence) {
        boolean expectedPresence = !productPresence.contains("not");
        gg_cartPage.getPresenceOfProductCardInCart(productType).entrySet().stream().forEach(indEntries -> Assert.assertEquals(Boolean.parseBoolean("" + indEntries.getValue()), expectedPresence, "The product card element is missing for " + indEntries.getKey()));
    }

    @And("verify the categories in cart are sorted alphabetically in {string}")
    public void verifyTheCategoriesInCartAreSortedAlphabeticallyIn(String sortOrder) {
        List<String> actualCategoriesList = gg_cartPage.getCategoryTitlesOfProductsInCart();
        if (sortOrder.contains("descending"))
            Assert.assertTrue(Ordering.natural().reverse().isOrdered(actualCategoriesList), "Categories in cart not sorted");
        else
            Assert.assertTrue(Ordering.natural().isOrdered(actualCategoriesList), "Categories in cart not sorted");
    }

    @And("go to cart screen")
    public void goToCartV2() {
        gg_cartPage.clickOnCartV2();
    }

    @Then("verify cart is empty")
    public void verifyHappyShoppingLabelDisplayed() {
        Assert.assertTrue(gg_cartPage.isCartV2HappyShoppingDisplayed(), "Cart is not empty!!");
    }

    @Then("verify substitution CTA is not displayed on cart page")
    public void verifySubstitutionCTANotDisplayed() {
        Assert.assertTrue(gg_cartPage.verifySubstitutionCTANotDisplayed(), "Substitutions CTA is displayed on cart!!");
    }

    @Then("verify cart screen is in empty state having zero items in it")
    public void verifyCartV2ScreenHasZeroItems() {
        Assert.assertTrue(gg_cartPage.isCartV2CloseButtonDisplayed(), "Cart V2 close button is not displayed");
        Assert.assertTrue(gg_cartPage.isCartV2EmptyHeaderDisplayed(), "Cart V2 Empty Header is not displayed");
        String expectedEmptyCartV2HeaderText = "Cart (0)";
        Assert.assertEquals(gg_cartPage.getTextOfCartV2EmptyHeader(), expectedEmptyCartV2HeaderText, "Empty header text is not displayed as expected");
        Assert.assertTrue(gg_cartPage.isCartV2HappyShoppingDisplayed(), "Happy Shopping is not displayed");
        String expectedCartV2HappyShoppingText = "Happy shopping!";
        Assert.assertEquals(gg_cartPage.getTextOfCartV2HappyShopping(), expectedCartV2HappyShoppingText, "Happy shopping text is not displayed as expected");
        Assert.assertTrue(gg_cartPage.isCartV2ShopNowCTADisplayed(), "Cart V2 Shop Now CTA is not displayed");
        Assert.assertTrue(gg_cartPage.isCartV2ShopNowCTAEnabled(), "Cart V2 Shop Now CTA is not enabled");

        //validation of test case#C71062
        Assert.assertTrue(!gg_cartPage.isEstSubTotalDisplayed(), "Est. subtotal should not be displayed");
        Assert.assertTrue(!gg_cartPage.isCartV2EstSubTotalAmountDisplayed(), "Est. subtotal amount should not be displayed");

        /* This will be developed in in the 2021.37.0 release
        Assert.assertTrue(gg_cartPage.isCartV2CheckoutCTADisplayed(), "Cart V2 Checkout CTA is not displayed");
        Assert.assertTrue(gg_cartPage.isCartV2CheckoutDisabled(), "Cart V2 Checkout CTA is not disabled");
        Assert.assertTrue(gg_cartPage.isCartV2ThresholdTextDisplayed(), "Cart V2 threshold text is not displayed");
        String actualCartV2ThresholdText = gg_cartPage.getTextOfCartV2Threshold();
        String expectedCartV2ThresholdText = "Add [\\$][0-9]+[\\.]*[0-9]* to reach order minimum";
        Assert.assertTrue(actualCartV2ThresholdText.matches(expectedCartV2ThresholdText), "Cart V2 threshold text is not displayed as expected");

         */
    }

    @And("click on Shop Now CTA in cart screen")
    public void clickOnCartV2ShopNowCTA() {
        gg_cartPage.clickOnCartV2ShopNowCTA();
    }

    @When("click on the back button for the device")
    public void clickOnBackButtonForDevice() {
        gg_cartPage.clickOnBackButtonForDevice();
    }

    @And("click on Checkout Button CTA in cart page")
    public void clickOnCheckoutButtonCTA() {
        gg_cartPage.clickOnCheckoutV2();
    }

    @Then("verify Checkout button is enabled in cart page")
    public void verifyCheckoutIsEnabled() {
        Assert.assertFalse(gg_cartPage.isCartV2CheckoutDisabled(), "Cart V2 Checkout CTA is not enabled");
    }

    @Then("verify title is displayed in cart page")
    public void verifyCartTitleIsDisplayed() {
        Assert.assertTrue(gg_cartPage.isCartV2TitleDisplayed(), "Cart V2 Title is not displayed");
    }

    @Then("verify substitution CTA changed to Edit Substitution for first product in cart page")
    public void verifyChangeSubstitutionButtonIsDisplayed() {
        Assert.assertTrue(gg_cartPage.isChangeSubstitutionButtonDisplayed(), "Edit substitution button is not displayed in cart");
    }

    @Then("verify first product is highlighted in cart page")
    public void verifyFirstProductHighlighted() {
        Assert.assertTrue(gg_cartPage.isFirstProductHighlighted(), "First product is highlighted of selecting substitution for the product");
    }

    @Then("verify user is not navigated back to cart page")
    public void verifyUserIsNotNavigatedBackToCart() {
        Assert.assertTrue(!gg_cartPage.isCartV2EmptyHeaderDisplayed(), "User is navigated back to cart page");
    }

    @Then("verify name of the product is displayed as per API response in cart")
    public <T> void verifyProductNameAPI() throws ClassNotFoundException {
        List<Map<String, Object>> itemsList = getCartItemsFromApi();
        String itemNameAPI = (String) itemsList.get(0).get("name");
        String itemNameUI = gg_cartPage.getProductNameFromCart();
        Assert.assertEquals(itemNameUI, itemNameAPI, "Product name in UI and API are different, UI:" + itemNameUI + " API:" + itemNameAPI);
    }

    @Then("verify quantity of the product is displayed as per API response in cart")
    public <T> void verifyQuantityDetailsAPI() throws ClassNotFoundException {
        List<Map<String, Object>> itemsList = getCartItemsFromApi();
        Double itemQtyAPI = (Double) itemsList.get(0).get("qty");
        Double itemQtyUI = gg_cartPage.getProductQuantity();
        Assert.assertEquals(itemQtyUI, itemQtyAPI, "Product quantity in UI and API are different, UI:" + itemQtyUI + " API:" + itemQtyAPI);
    }

    @Then("verify details of the product with {string} price is displayed as per API response in cart")
    public void verifyProductDetailsAPI(String priceType) throws ClassNotFoundException {
        List<Map<String, Object>> itemsList = getCartItemsFromApi();

        verifyStandardFeaturesOnAProductCard(itemsList.get(0));

        //Verify price type with value
        String[] priceTypeArray = priceType.split(",");
        for (int i = 0; i < priceTypeArray.length; i++) {
            switch (priceTypeArray[0]) {
                case "NORMAL":
                case "BASIC":
                    Assert.assertFalse(gg_cartPage.isApproxLabelDisplayedForProduct(), "Approx label is displayed in UI, please ensure product in cart has normal(basic) price");
                    Assert.assertFalse(itemsList.get(0).containsKey("displayEstimateText"), "displayEstimateText is present in API response, please ensure product in cart has normal(basic) price");
                    Assert.assertFalse(gg_cartPage.isStrikeThroughDisplayedForProduct(), "Strike through price is displayed in UI, please ensure product in cart has normal(basic) price");
                    Assert.assertEquals(itemsList.get(0).get("price"), itemsList.get(0).get("basePrice"), "price and basePrice are not same(product has strikethrough price) in API response, please ensure product in cart has normal(basic) price");
                    break;
                case "APPROX":
                    Assert.assertTrue(gg_cartPage.isApproxLabelDisplayedForProduct(), "Approx label is not displayed in UI, please ensure product in cart has approximate price");
                    Assert.assertTrue(itemsList.get(0).containsKey("displayEstimateText"), "displayEstimateText is not present in API response, please ensure product in cart has approximate price");
                    break;
                case "STRIKETHROUGH":
                    Assert.assertTrue(gg_cartPage.isStrikeThroughDisplayedForProduct(), "Strike through price is not displayed in UI, please ensure product in cart has strike through price");
                    Assert.assertEquals(gg_cartPage.getStrikeThroughPriceValue(), itemsList.get(0).get("basePrice"), "Strike through price is not same in UI and API");
                    break;
            }
        }
    }

    @Then("verify standard features on a product card in cart screen")
    public void verifyStandardElementsOnProductCard() throws ClassNotFoundException {
        List<Map<String, Object>> itemsList = getCartItemsFromApi();
        verifyStandardFeaturesOnAProductCard(itemsList.get(0));
    }

    @Then("verify age restricted item in UI and API")
    public void verifyAgeRestrictedItemUIandAPI() throws ClassNotFoundException {
        List<Map<String, Object>> itemsList = getCartItemsFromApi();

        // Verify Age Restricted Item label
        Assert.assertTrue((itemsList.get(0).get("restrictedValue").toString().contains("Unattended")), "restrictedValue key in API response has value other than 'Unattended', ensure the product in cart is an age restricted item");
        Assert.assertTrue(gg_cartPage.isAgeRestrictionLabelDisplayed(), "'Age Restricted Item' label is not displayed on product card");

        verifyStandardFeaturesOnAProductCard(itemsList.get(0));
    }

    @Then("verify prop 65 warning in UI and API")
    public void verifyProp65WarningUIandAPI() throws ClassNotFoundException {
        if (!(ThreadLocalHelper.testCaseData.get().get("ZIPCODE_PROP65").equalsIgnoreCase("NA"))) {
            List<Map<String, Object>> itemsList = getCartItemsFromApi();

            // Verify Prop 65 warning label in UI only when prop65WarningIconRequired is true
            if ((Boolean) itemsList.get(0).get("prop65WarningIconRequired")) {
                Assert.assertTrue(gg_cartPage.isProp65WarningDisplayed(), "'Prop 65 Warning' label is not displayed on product card");
            }
        }
    }

    @Then("verify age restricted and prop 65 warnings on a product card in cart")
    public void verifyAgeRestrictedProp65() {
        if (!(ThreadLocalHelper.testCaseData.get().get("ZIPCODE_PROP65").equalsIgnoreCase("NA"))) {
            Assert.assertTrue(gg_cartPage.isAgeRestrictionLabelDisplayed(), "'Age Restricted Item' label is not displayed on product card");
            Assert.assertTrue(gg_cartPage.isProp65WarningDisplayed(), "'Prop 65 Warning' label is not displayed on product card");
        }
    }

    @Then("verify prop 65 warning on a product card in cart")
    public void verifyProp65() {
        if (!(ThreadLocalHelper.testCaseData.get().get("ZIPCODE_PROP65").equalsIgnoreCase("NA")))
            Assert.assertTrue(gg_cartPage.isProp65WarningDisplayed(), "'Prop 65 Warning' label is not displayed on product card");
    }

    private <T> List<Map<String, Object>> getCartItemsFromApi() throws ClassNotFoundException {
        List<Map<String, Object>> itemsList = null;
        cartService = new CartService(gg_cartPage.getCurrentBanner());
        T t = cartService.getCartItems(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), CommonCache.commonCache.get("CUSTOMERID_CART_API"), ThreadLocalHelper.testCaseData.get().get("STOREID_CART_API"), "");
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

    private void verifyStandardFeaturesOnAProductCard(Map<String, Object> product) {
        // verify product name
        String itemNameAPI = (String) product.get("name");
        String itemNameUI = gg_cartPage.getProductNameFromCart();
        Assert.assertEquals(itemNameUI, itemNameAPI, "Product name in UI and API are different for product, UI:" + itemNameUI + " API:" + itemNameAPI);

        //Verify product quantity
        Double itemQtyAPI = (Double) product.get("qty");
        Double itemQtyUI = gg_cartPage.getProductQuantity();
        Assert.assertEquals(itemQtyUI, itemQtyAPI, "Product quantity in UI and API are different for product, UI:" + itemQtyUI + " API:" + itemQtyAPI);

        //Verify product price
        Double itemPriceAPI = (Double) product.get("netPromotionAmount");
        Double itemPriceUI = gg_cartPage.getProductPrice();
        Assert.assertEquals(itemPriceUI, itemPriceAPI, "Product price in UI and API are different for product, UI:" + itemPriceUI + " API:" + itemPriceAPI);

        // Verify Substitution CTA
        Assert.assertTrue(gg_cartPage.isSubstitutionCTADisplayedForProduct(), "Substitution CTA for product is not displayed");

        // Verify Add Note CTA
        Assert.assertTrue(gg_cartPage.isAddNoteCTADisplayedForProduct(), "Add Note CTA for product is not displayed");
    }

    @Then("verify cart icon shows 0 items")
    public void verifyCartIconShowsZeroItems() {
        Assert.assertEquals(0, gg_cartPage.getCountDisplayedOnCartIcon(), "Items count is not shown 0 when there are no items in the cart");
    }

    @Then("verify estimated subtotal and amount are shown on the cart screen")
    public void verifyEstSubtotalAndAmountAreDisplayed() {
        Assert.assertTrue(gg_cartPage.isEstSubTotalDisplayed(), "Est. subtotal is not displayed");
        Assert.assertTrue(gg_cartPage.isCartV2EstSubTotalAmountDisplayed(), "Est. subtotal amount is not displayed");
        Assert.assertEquals(gg_cartPage.getTextOfEstSubTotal(), "Est. subtotal", "Est. subtotal copy is not displayed as expected");
        Assert.assertTrue(Pattern.matches("[0-9]*.[0-9]*", gg_cartPage.getTextOfEstSubTotalAmount().get(0)), "Est. subtotal amount is not displayed as expected");
        /* This does not appears
        Assert.assertTrue(gg_cartPage.isCartV2EstSubTotalStrikeThroughAmountDisplayed(), "Est. subtotal strike-through amount is not displayed");
        Assert.assertTrue(Pattern.matches("[\\$][0-9]*[\\.]*[0-9]*", gg_cartPage.getTextOfEstSubTotalStrikeThroughAmount()), "Est. subtotal strike-through amount is not displayed as expected");
        */
    }

    @Then("verify the cart summary is displayed on the cart screen")
    public void verifyCartSummaryIsDisplayed() {
        String expectedCartV2HeaderText = "Cart (1)";
        Assert.assertEquals(gg_cartPage.getTextOfCartV2EmptyHeader(), expectedCartV2HeaderText, "Header text is not displayed as expected");
        Assert.assertTrue(gg_cartPage.isCartV2CartSummaryDisplayed(), "Cart Summary is not displayed");
        Assert.assertEquals(gg_cartPage.getTextOfCartSummary(), "Cart summary", "Cart summary text is not displayed as expected");
        Assert.assertTrue(gg_cartPage.isCartV2ItemsWithCountDisplayed(), "Items with count is not displayed in the summary");
        Assert.assertTrue(gg_cartPage.isCartV2ItemsPriceDisplayed(), "Items price is not displayed in the summary");
        Assert.assertEquals(gg_cartPage.getTextOfItemsCount(), "Items (1)", "Items count text is not displayed as expected");
        Assert.assertTrue(Pattern.matches("[\\$][0-9]*[\\.]*[0-9]*", gg_cartPage.getTextOfItemsPrice().get(0)), "Items price is not displayed");
        Assert.assertTrue(gg_cartPage.isCartV2EstimatedSavingsDisplayed(), "Estimated Savings is not displayed");
        Assert.assertTrue(gg_cartPage.isCartV2EstimatedSavingsValueDisplayed(), "Estimated Savings value is not displayed");
        Assert.assertEquals(gg_cartPage.getTextOfEstimatedSavings(), "Estimated savings", "Estimated savings text is not displayed as expected");
        Assert.assertTrue(Pattern.matches("-?[\\$][0-9]*[\\.]*[0-9]*", gg_cartPage.getTextOfEstimatedSavingsValue()), "Estimated savings value is not displayed as expected, shown as " + gg_cartPage.getTextOfEstimatedSavingsValue());
        Assert.assertTrue(gg_cartPage.isCartV2MemberPriceSavingsDisplayed(), "Member Price Savings is not displayed");
        Assert.assertTrue(gg_cartPage.isCartV2MemberPriceSavingsValueDisplayed(), "Member Price Savings value is not displayed");
        Assert.assertEquals(gg_cartPage.getTextOfMemberPriceSavings().toLowerCase(), "member price savings", "Member Price savings text is not displayed as expected");
        Assert.assertTrue(Pattern.matches("-?[\\$][0-9]*[\\.]*[0-9]*", gg_cartPage.getTextOfClubCardSavingsValue()), "Member Price Savings value is not displayed");
        Assert.assertTrue(gg_cartPage.isCartV2StaticTextEstSubtotalDisplayed(), "Static text about Est. subtotal is not displayed");
        String expectedStaticTextEstSubtotal = "The actual amount you will be charged for your order may be different from the Estimated Subtotal above. The Estimated Subtotal does not include the final cost of items sold by weight or taxes/deposits/other fees. These adjustments will appear on your final receipt at delivery/pickup. Review Estimated Subtotal (i) for details.";
        Assert.assertTrue(StringUtils.containsIgnoreCase(gg_cartPage.getTextOfCartV2DisclaimerText(), expectedStaticTextEstSubtotal), "Disclaimer text is not displayed as expected");
    }

    @Then("verify Estimated savings is not displayed on the cart screen")
    public void verifyEstimatedSavingsIsNotDisplayed() {
        Assert.assertTrue(gg_cartPage.isCartV2CartSummaryDisplayed(), "Cart Summary is not displayed");
        Assert.assertTrue(gg_cartPage.isCartV2ItemsWithCountDisplayed(), "Items with count is not displayed in the summary");
        Assert.assertTrue(gg_cartPage.isCartV2ItemsPriceDisplayed(), "Items price is not displayed in the summary");
        Assert.assertTrue(!gg_cartPage.isCartV2EstimatedSavingsDisplayed(), "Estimated Savings should not be displayed");
        Assert.assertTrue(!gg_cartPage.isCartV2EstimatedSavingsValueDisplayed(), "Estimated Savings value should not be displayed");
        Assert.assertTrue(!gg_cartPage.isCartV2MemberPriceSavingsDisplayed(), "Member Price Savings should not be displayed");
        Assert.assertTrue(!gg_cartPage.isCartV2MemberPriceSavingsValueDisplayed(), "Member Price Savings value should not be displayed");
    }

    @Then("verify item count is displayed {int} in the cart screen")
    public void verifyItemCount(int count) {
        Assert.assertTrue(gg_cartPage.isCartV2ItemsWithCountDisplayed(), "Items with count is not displayed in the summary");
        Assert.assertEquals(gg_cartPage.getItemsCountFromSummary(), count, "Items count is not displayed as expected");
    }

    @Then("verify cart shows unavailable item")
    public void verifyUnavailableItemIsDisplayed() {
        Assert.assertTrue(gg_cartPage.isUnavailableItemDisplayed());
    }

    @And("click on info icon at the bottom for Estimated savings under cart summary")
    public void clickOnCartV2EstimatedSavingsInfoIcon() {
        gg_cartPage.clickOnCartV2EstimatedSavingsInfoIcon();
    }

    @Then("verify Estimated savings sheet opens up with static text as per banner theme")
    public void verifyEstimatedSavingsSheet() {
        Assert.assertTrue(gg_cartPage.isCartV2EstimatedSavingsSheetHeaderDisplayed(), "Estimated savings sheet is not opened");
        Assert.assertTrue(gg_cartPage.isCartV2EstimatedSavingsSheetCloseButtonDisplayed(), "Estimated savings sheet close button is not displayed");
        Assert.assertEquals(gg_cartPage.getTextOfCartV2EstimatedSavingsSheetHeader(), "Estimated Savings", "Header of Estimated savings sheet is not displayed as expected");
        Assert.assertTrue(gg_cartPage.isCartV2EstimatedSavingsSheetStaticTextDisplayed(), "Static text on Estimated savings sheet is not displayed");
        String currentBannerName = getCurrentBanner();
        Assert.assertTrue(StringUtils.containsIgnoreCase(gg_cartPage.getTextOfCartV2EstimatedSavingsSheetStaticText(), currentBannerName), "Static text on Estimated savings sheet is not banner specific");
        //Assert.assertTrue(gg_cartPage.getTextOfCartV2EstimatedSavingsSheetStaticText().toLowerCase().contains(currentBannerName.toLowerCase()), "Static text on Estimated savings sheet is not banner specific");
    }

    @And("click on X on the estimated savings sheet")
    public void clickOnCartV2EstimatedSavingsSheetCloseButton() {
        gg_cartPage.clickOnCartV2EstimatedSavingsSheetCloseButton();
    }

    @Then("verify Estimated savings sheet closes and user navigates back to the cart screen and maintains the scroll state")
    public void verifyEstimatedSavingsSheetIsClosed() {
        Assert.assertTrue(!gg_cartPage.isCartV2EstimatedSavingsSheetHeaderDisplayed(), "Estimated savings sheet should not remain opened");
        Assert.assertTrue(gg_cartPage.isCartV2EmptyHeaderDisplayed(), "Cart V2 screen is not displayed");
        Assert.assertTrue(gg_cartPage.isCartV2CartSummaryDisplayed(), "Cart Summary is not displayed");
    }

    @Then("verify out of stock on cart screen")
    public void verifyOutOfStock() {
        Assert.assertTrue(gg_cartPage.isViewSimilarCTADisplayed(), "View Similar CTA is not displayed for Out of Stock Item");
        Assert.assertTrue(Pattern.matches("[1-9]+ item[s]* [waswere]+ unavailable and removed from your cart", gg_cartPage.getTextOfUnavailable()), "Products unavailable message is not displayed as expected");
        Assert.assertEquals(gg_cartPage.getTextOfUnavailableProductHeader(), "Out of stock", "Header of Out of Stock Product is not displayed as expected");
    }

    @Then("verify not available for {string} on cart screen")
    public void verifyProductNotAvailable(String shoppingMode) {
        Assert.assertTrue(gg_cartPage.isViewSimilarCTADisplayed(), "View Similar CTA is not displayed for Out of Stock Item");
        Assert.assertTrue(Pattern.matches("[1-9]+ item[s]* [waswere]+ unavailable and removed from your cart", gg_cartPage.getTextOfUnavailable()), "Products unavailable message is not displayed as expected");
        Assert.assertEquals(gg_cartPage.getTextOfUnavailableProductHeader(), ("Not available for " + shoppingMode), "Header of Not Available for " + shoppingMode + " is not displayed as expected");
    }

    @Then("verify the threshold message is shown")
    public void verifyOrderMinimumAmountMessage() {
        Assert.assertTrue(gg_cartPage.verifyOrderMinimumAmountMessage(), "Minimum Amount Message is not shown");
    }

    @Then("verify if the estimated subtotal in the UI equals the estimated subtotal in the API response")
    public <cart> void verifyEstSubtotalInUIEqualsToAPI() throws ClassNotFoundException {
        cartService = new CartService(gg_cartPage.getCurrentBanner());
        cart cartItems = cartService.getCartItems(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), CommonCache.commonCache.get("CUSTOMERID_CART_API"), ThreadLocalHelper.testCaseData.get().get("STOREID_CART_API"), "");
        if (Class.forName("java.lang.String").isInstance(cartItems)) {
            Assert.assertTrue(false, "Get cart items api call failed, response: " + cartItems);
        } else {
            GetCartItemsResponse getCartItemsResponse = (GetCartItemsResponse) cartItems;
            double totalEstimatedPriceInAPI = getCartItemsResponse.getSummary().getTotalEstimatedPrice();
            double totalEstimatedPriceInUI = Double.parseDouble(gg_cartPage.getTextOfEstSubTotalAmount().get(0));
            if (totalEstimatedPriceInAPI == totalEstimatedPriceInUI) {
                Assert.assertTrue(true, "Estimated Subtotal in UI is not equal to the Estimated Subtotal in the API");
            }
        }
    }

    @And("user clicks on product quantity of product number {int} in cart screen")
    public void clickOnProdQty(int productIndex) {
        gg_cartPage.clickOnQuantityOfDesiredProduct(productIndex);
    }

    @And("user clicks on product name of product number {int} in cart screen")
    public void clickOnProdPrice(int productIndex) {
        gg_cartPage.clickOnNameOfDesiredProduct(productIndex);
    }

    @And("user clicks on product quantity in cart screen to open quantity stepper")
    public void clickOnProdQty() {
        gg_cartPage.clickOnProductQuantity();
    }

    @And("user clicks on increment quantity button in quantity stepper")
    public void clickOnIncrementProdQty() {
        gg_cartPage.incrementProductQuantity();
    }

    @And("user clicks on decrement quantity button in quantity stepper")
    public void clickOnDecrementProdQty() {
        gg_cartPage.decrementProductQuantity();
    }

    @And("user clicks on cart summary label in cart screen")
    public void clickOnCartSummary() {
        gg_cartPage.clickOnCartSummary();
    }

    @Then("verify quantity stepper elements on cart screen")
    public void verifyStepperElements() {
        gg_cartPage.getQuantityStepperElementsPresence().entrySet().stream().forEach(entry -> Assert.assertTrue(entry.getValue(), "Element " + entry.getKey() + "was not found in quantity stepper view"));
    }

    @Then("verify quantity stepper {string} displayed")
    public void verifyQtyStepper(String desiredStatus) {
        if (desiredStatus.contains("not")) {
            Assert.assertFalse(gg_cartPage.isQuantityStepperDisplayed(), "Quantity stepper view is displayed!!");
        } else {
            Assert.assertTrue(gg_cartPage.isQuantityStepperDisplayed(), "Quantity stepper view is not displayed!!");
        }
    }

    @Then("increment product quantity {int} times in quantity stepper and verify cart updates")
    public void incrementProductQtyAndVerifyUpdates(int numberOfIncrements) throws ClassNotFoundException {
        for (int currentIncrement = 0; currentIncrement < numberOfIncrements; currentIncrement++) {
            int beforeIncrementProdCountStepper = 0;
            if (driver.getPlatformName().equalsIgnoreCase("ANDROID")) {
                beforeIncrementProdCountStepper = gg_cartPage.getProductCountFromStepper();
            }

            int beforeIncrementProdCountCartHeader = gg_cartPage.getProductCountFromHeader();
            Double beforeIncrementCartSubTotal = gg_cartPage.getEstSubTotalAmount();
            Summary summaryBeforeIncrementAPI = getCartSummaryFromApi();
            Double beforeIncrementCartSubTotalAPI = summaryBeforeIncrementAPI.getTotalEstimatedPrice();
            int beforeIncrementProdCountAPI = Integer.valueOf(summaryBeforeIncrementAPI.getTotalItemQuantity());

            gg_cartPage.incrementProductQuantity();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Summary summaryAfterIncrementAPI = getCartSummaryFromApi();
            int afterIncrementProdCountAPI = Integer.valueOf(summaryAfterIncrementAPI.getTotalItemQuantity());
            Double afterIncrementCartSubTotalAPI = summaryAfterIncrementAPI.getTotalEstimatedPrice();
            int afterIncrementProdCountCartHeader = gg_cartPage.getProductCountFromHeader();
            Double afterIncrementCartSubTotal = gg_cartPage.getEstSubTotalAmount();
            Assert.assertTrue(afterIncrementCartSubTotalAPI > beforeIncrementCartSubTotalAPI, "totalEstimatedPrice value in API did not increase when user clicked on '+' icon");
            Assert.assertEquals(afterIncrementProdCountAPI, beforeIncrementProdCountAPI + 1, "totalItemQuantity value in API did not increase when user clicked on '+' icon");
            Assert.assertEquals(afterIncrementProdCountCartHeader, beforeIncrementProdCountCartHeader + 1, "Product count in cart header did not increase when user clicked on '+' icon");
            Assert.assertTrue(afterIncrementCartSubTotal > beforeIncrementCartSubTotal, "Estimated sub total did not increase when user clicked on '+' icon");
            if (driver.getPlatformName().equalsIgnoreCase("ANDROID")) {
                int afterIncrementProdCountStepper = gg_cartPage.getProductCountFromStepper();
                Assert.assertEquals(afterIncrementProdCountStepper, beforeIncrementProdCountStepper + 1, "Product count in stepper view did not increase when user clicked on '+' icon");
            }
        }
    }

    @Then("verify from the threshold message in the UI and API response the minimum remaining amount value to order is less than the threshold value")
    public <cart> void verifyInAPIAndUIMinimumAmountToOrder() throws ClassNotFoundException {
        cartService = new CartService(gg_cartPage.getCurrentBanner());
        cart cartItems = cartService.getCartItems(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), CommonCache.commonCache.get("CUSTOMERID_CART_API"), ThreadLocalHelper.testCaseData.get().get("STOREID_CART_API"), "");
        if (Class.forName("java.lang.String").isInstance(cartItems)) {
            Assert.assertTrue(false, "Get cart items api call failed, response: " + cartItems);
        } else {
            GetCartItemsResponse getCartItemsResponse = (GetCartItemsResponse) cartItems;
            int thresholdValue = getCartItemsResponse.getSummary().getMinCartThresholdValue();
            double totalEstimatedPriceInAPI = getCartItemsResponse.getSummary().getTotalEstimatedPrice();
            double diffBetweenThresholdAndEstSubTotalInAPI = thresholdValue - (totalEstimatedPriceInAPI);
            double qualifyingValueAPI = Double.parseDouble(getCartItemsResponse.getSummary().getQualifyingDollarValue());
            double qualifyingValueUI = gg_cartPage.getAmountToReachOrderMinimum();
            if (qualifyingValueAPI == qualifyingValueUI && qualifyingValueAPI == diffBetweenThresholdAndEstSubTotalInAPI) {
                Assert.assertTrue(true, "Estimated Subtotal in UI is not equal to the Estimated Subtotal in the API");
            }
        }
    }

    @Then("verify that the threshold message is not shown")
    public void verifyThresholdMessageIsNotShown() {
        Assert.assertFalse(gg_cartPage.verifyThresholdMessageIsNotShown(), "Minimum Amount Message is not shown");
    }

    @Then("decrement product quantity {int} times in quantity stepper when quantity is {string} 1 and verify cart updates")
    public void decrementProductQtyAndVerifyUpdates(int numberOfDecrements, String equalOrMore) throws ClassNotFoundException {
        for (int currentDecrement = 0; currentDecrement < numberOfDecrements; currentDecrement++) {
            int beforeDecrementProdCountStepper = 0;
            if (driver.getPlatformName().equalsIgnoreCase("ANDROID")) {
                beforeDecrementProdCountStepper = gg_cartPage.getProductCountFromStepper();
            }

            int beforeDecrementProdCountCartHeader = gg_cartPage.getProductCountFromHeader();
            Double beforeDecrementCartSubTotal = gg_cartPage.getEstSubTotalAmount();
            Summary summaryBeforeDecrementAPI = getCartSummaryFromApi();
            Double beforeDecrementCartSubTotalAPI = summaryBeforeDecrementAPI.getTotalEstimatedPrice();
            int beforeDecrementProdCountAPI = Integer.valueOf(summaryBeforeDecrementAPI.getTotalItemQuantity());

            gg_cartPage.decrementProductQuantity();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Summary summaryAfterDecrementAPI = getCartSummaryFromApi();
            int afterDecrementProdCountCartHeader = gg_cartPage.getProductCountFromHeader();
            int afterDecrementProdCountAPI = Integer.valueOf(summaryAfterDecrementAPI.getTotalItemQuantity());
            Double afterDecrementCartSubTotalAPI = summaryAfterDecrementAPI.getTotalEstimatedPrice();
            Double afterDecrementCartSubTotal = gg_cartPage.getEstSubTotalAmount();
            Assert.assertEquals(afterDecrementProdCountAPI, beforeDecrementProdCountAPI - 1, "totalItemQuantity value in API did not decrease when user clicked on '-' icon");
            Assert.assertEquals(afterDecrementProdCountCartHeader, beforeDecrementProdCountCartHeader - 1, "Product count in cart header did not decrease when user clicked on '-' icon");
            Assert.assertTrue(afterDecrementCartSubTotal < beforeDecrementCartSubTotal, "Estimated sub total did not decrease when user clicked on '-' icon");
            Assert.assertTrue(afterDecrementCartSubTotalAPI < beforeDecrementCartSubTotalAPI, "totalEstimatedPrice value in API did not decrease when user clicked on '-' or bin icon");

            if (equalOrMore.contains("equal")) {
                // Verification for when prod qty is equal to 1
                Assert.assertFalse(gg_cartPage.isQuantityStepperDisplayed(), "Quantity stepper is displayed even after user clicks on bin icon!");
            } else {
                if (beforeDecrementProdCountStepper == 1) {
                    // Verification for when initial count in beginning was more than 1 but user tapped on - icon given number of times
                    Assert.assertFalse(gg_cartPage.isQuantityStepperDisplayed(), "Quantity stepper is displayed even after user clicks on bin icon!");
                } else {
                    // Verification for when prod qty is more than 1
                    if (driver.getPlatformName().equalsIgnoreCase("ANDROID")) {
                        int afterDecrementProdCountStepper = gg_cartPage.getProductCountFromStepper();
                        Assert.assertEquals(afterDecrementProdCountStepper, beforeDecrementProdCountStepper - 1, "Product count in stepper view did not decrease when user clicked on '-' icon");
                    }
                }
            }
        }
    }

    @And("user increments product quantity {int} times in quantity stepper")
    public void incrementProductQty(int numberOfIncrements) {
        for (int currentIncrement = 0; currentIncrement < numberOfIncrements; currentIncrement++) {
            gg_cartPage.incrementProductQuantity();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @And("user decrements product quantity {int} times in quantity stepper")
    public void decrementProductQty(int numberOfDecrements) {
        for (int currentDecrement = 0; currentDecrement < numberOfDecrements; currentDecrement++) {
            gg_cartPage.decrementProductQuantity();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Due to limitation in iOS, this method assumes there is only one product is in the cart and its count is the same as count displayed in Header
    @And("user increments the product quantity in quantity stepper on cart screen to maximum allowed value")
    public void incrementToMaxProdQty() throws ClassNotFoundException {
        int maxAllowedProdQty = new Double((Double) getCartItemsFromApi().get(0).get("maxPurchaseQty")).intValue();
        int initialProdQty = gg_cartPage.getProductCountFromHeader(); //Getting count from header here since in iOS there is no locator to identify quantity in stepper
        for (int currentProdQty = initialProdQty; currentProdQty <= maxAllowedProdQty; currentProdQty++) {
            gg_cartPage.incrementProductQuantity();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Then("verify increment button is disabled when product quantity has reached maximum allowed value")
    public void verifyIncrementButtonWhenProdQtyHasReachedMax() {
        Assert.assertFalse(gg_cartPage.isIncrementButtonEnabled(), "Increment button is still enabled in quantity stepper even after quantity of the product has reached its maximum allowed value!!");
    }

    @Then("verify network error popup is displayed in cart screen")
    public void verifyNetworkErrorPopUp() {
        Assert.assertTrue(gg_cartPage.isNetworkErrorDisplayed(), "Network Error pop up is not displayed!!");
    }

    @Then("verify product quantity in stepper view is {int}")
    public void verifyQuantityInStepperView(int expectedQtyInStepper) {
        Assert.assertEquals(gg_cartPage.getProductCountFromStepper(), expectedQtyInStepper, "Product quantity in stepper is displayed incorrectly!!");
    }

    @And("get and store total product count in cart screen")
    public void getAndStoreCartCountInCartScreen() {
        ThreadLocalHelper.testCaseData.get().put("CART_COUNT", String.valueOf(gg_cartPage.getProductCountFromHeader()));
    }

    // make sure to use step "get and store total product count in cart screen" and an action step(increment/decrement) before this
    @Then("verify total product count in cart screen is {string} by {int}")
    public void verifyTotalCountIncreased(String expectedStatus, int difference) {
        if (expectedStatus.contains("increase")) {
            Assert.assertEquals(gg_cartPage.getProductCountFromHeader(), Integer.valueOf(ThreadLocalHelper.testCaseData.get().get("CART_COUNT")) + difference, "Total product count in cart screen did not increase!!");
        } else {
            Assert.assertEquals(gg_cartPage.getProductCountFromHeader(), Integer.valueOf(ThreadLocalHelper.testCaseData.get().get("CART_COUNT")) - difference, "Total product count in cart screen did not decrease!!");
        }
    }

    @And("swipe across a product card to delete it in cart")
    public void swipeAcrossAProductCardToDeleteItInCart() {
        gg_cartPage.swipeAcrossAProductCardToDeleteItInCart();
    }

    @Then("verify option to remove product {string} displayed")
    public void verifyOptionToRemoveProductDisplayed(String displayVal) {
        boolean isDisplayed = !displayVal.contains("not");
        Assert.assertEquals(gg_cartPage.checkIfRemoveBtnIsDisplayed(), isDisplayed, "The visibility of remove is not as expected !!!");
    }

    @And("click on the Remove button")
    public void clickOnTheRemoveButton() {
        gg_cartPage.clickOnRemoveBtn();
    }


    @Then("product must be {string} the cart")
    public void productMustBeFromTheCart(String removedCheckVal) {
        if (removedCheckVal.contains("removed")) {
            Assert.assertEquals(Integer.parseInt(CommonCache.commonCache.get("CART_COUNT")) > gg_cartPage.getProductCountFromHeader(), true, "Cart count not removed as expected");
        } else if (removedCheckVal.contains("added")) {
            Assert.assertEquals(Integer.parseInt(CommonCache.commonCache.get("CART_COUNT")) < gg_cartPage.getProductCountFromHeader(), true, "Cart count not added as expected");
        }
    }

    @And("observe the number of products present in the cart")
    public void observeTheNumberOfProductsPresentInTheCart() {
        CommonCache.commonCache.put("CART_COUNT", "" + gg_cartPage.getProductCountFromHeader());
    }

    @And("swipe partially across a product card in cart")
    public void swipePartiallyAcrossAProductCardInCart() {
        gg_cartPage.swipePartiallyAcrossTheFirstProductInCart();
    }

    @Then("verify cart details are displayed as per the API response for cart with {string} products")
    public void verifyCartSummaryDetails(String productType) {

        cartService = new CartService(gg_cartPage.getCurrentBanner());
        GetCartItemsResponse getCartItemsResponse = cartService.getCartDetails(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), CommonCache.commonCache.get("CUSTOMERID_CART_API"), ThreadLocalHelper.testCaseData.get().get("STOREID_CART_API"), "");
        SoftAssert cartSummaryAssert = new SoftAssert();
        //Cart Summary
        cartSummaryAssert.assertEquals("" + gg_cartPage.getItemsCountFromSummary(), getCartItemsResponse.getSummary().getTotalItemQuantity());
        cartSummaryAssert.assertEquals(gg_cartPage.getCartSummaryTotalAmount().replaceFirst("\\$", ""), "" + new DecimalFormat("0.00").format(getCartItemsResponse.getSummary().getTotalBasePrice()));
        //Delivery Minimum
        cartSummaryAssert.assertEquals(new CommonUtil().getMatchFromStringUsingRegex("[0-9]*\\.[0-9]+", gg_cartPage.getMinimumCartValueForCheckout(), 0), getCartItemsResponse.getSummary().getQualifyingDollarValueWYSIWYG());
        //Estimated Total
        String estTotal = productType.toLowerCase().contains("non") ? gg_cartPage.getTextOfEstSubTotalAmount().get(0).replaceFirst("\\.*\\$", "") : gg_cartPage.getTextOfEstSubTotalAmount().get(0).replaceFirst("\\.*\\$", "");
        cartSummaryAssert.assertEquals(estTotal, "" + new DecimalFormat("0.00").format(getCartItemsResponse.getSummary().getTotalBasePrice()));
        cartSummaryAssert.assertAll();
    }

    @Then("empty the cart using API service")
    public void emptyTheCartUsingAPIService() {
        //Delete Cart
        cartService = new CartService(gg_cartPage.getCurrentBanner());
        GetCartItemsResponse getCartItemsResponse = cartService.getCartDetails(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), CommonCache.commonCache.get("CUSTOMERID_CART_API"), null, "");
        List<String> itemIdValues = new ArrayList<String>();
        if (!getCartItemsResponse.getCartItemsList().isEmpty()) {
            getCartItemsResponse.getCartItemsList().forEach(indItems -> itemIdValues.add(new BigDecimal((Double) indItems.get("itemId")).toPlainString()));
            HttpResponse deleteCartItemsResponse = cartService.deleteAllItemsFromTheCart(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), null, "" + getCartItemsResponse.getCartId(), itemIdValues);
            Assert.assertEquals(deleteCartItemsResponse.getStatusCode(), 200, "Cart Delete Operation Failed");
            //Doing below steps to refresh count on cart icon
            if (gg_cartPage.isCartV2CloseButtonDisplayed()) {
                gg_cartPage.closeCartScreen();
            }
            gg_cartPage.closeCartScreenIfDisplayed();
            gg_dashboardPage.handleTutorial(1);
            gg_cartPage.clickOnCartWithoutWait();
            gg_cartPage.closeCartScreen();
        }
    }

    @Then("verify view similar CTA in cart page")
    public void verifyViewSimilarCTA() {
        Assert.assertTrue(gg_cartPage.isViewSimilarCTADisplayed(), "CTA not displayed");
    }

    @Then("click view similar CTA in cart page")
    public void clickViewSimilarCTA() {
        gg_cartPage.clickOnViewSimilarItemsCTA();
    }

    @Then("verify similar products page")
    public void verifyRelatedProductsPage() {
        gg_cartPage.verifyRelatedProductsPageTitleText();
    }

    @Then("click back button in related products page")
    public void clickBackBtnInRelatedProductsPage() {
        gg_cartPage.clickBackBtnInRelatedProductsPage();
    }

    @Then("verify add button in similar products page adds item to cart page")
    public void verifyAddBtnInSimilarProductsPageAddsItemToCartPage() {
        int itemsCountInRelatedScreenPage = Integer.parseInt(gg_cartPage.getCartCountInRelatedProductsScreen().replaceAll("[^0-9]", ""));
        gg_cartPage.navigateBack();
        int itemsCountInCartPage = gg_cartPage.getProductCountFromHeader();
        if (itemsCountInRelatedScreenPage == itemsCountInCartPage) {
            Assert.assertTrue(true, "Item was not added to the cart page");
        }
    }


    @Then("verify product quantity in cart is displayed same as in product details page")
    public void verifyProductQuantityInCartIsDisplayedSameAsInProductDetailsPage() {
        Assert.assertEquals(CommonCache.commonCache.get("PROD_QTY_CART"), CommonCache.commonCache.get("PROD_QTY_DETAILS"), "Mismacth in displayed ty values");
    }

    @And("view the product quantity on cart page")
    public void viewTheProductQuantityOnCartPage() {
        CommonCache.commonCache.put("PROD_QTY_CART", "" + (int) Math.round(gg_cartPage.getProductQuantity()));
    }

    @And("click on a product in cart screen")
    public void clickOnAProductInCartScreen() {
        gg_cartPage.clickOnAProductInCartPage();
    }

    @And("user exits the quantity stepper")
    public void userExitsTheQuantityStepper() {
        gg_cartPage.clickOnEstimatedSubtotalLabel();
    }

    @And("click on a product in cart screen for unavailable products")
    public void clickOnAProductInCartScreenForUnavailableProducts() {
        gg_cartPage.clickOnAProductInCartPageForUnavailableProducts();
    }

    @And("click on view similar items CTA on cart screen")
    public void clickOnViewSimilarItemsCTAOnCartScreen() {
        gg_cartPage.clickOnViewSimilarItemsCTA();
    }

    @And("verify Related Products screen {string} displayed")
    public void verifyRelatedProductsScreenIsDisplayed(String presenceVal) {
        boolean expectedPresenceFlag = presenceVal.contains("not") ? false : true;
        String pageTitle = new GG_RelatedProductsPage(driver).getPageTitle();
        Assert.assertEquals(pageTitle.contains("Related Products"), expectedPresenceFlag, "The Related Products page presence not as expected " + pageTitle);
    }

    @And("verify remove button {string} displayed in cart page")
    public void verifyRemoveButtonIsDisplayedInCartPage(String presenceVal) {
        boolean expectedPresenceFlag = presenceVal.contains("not") ? false : true;
        Assert.assertEquals(gg_cartPage.getPresenceOfRemoveBtn(), expectedPresenceFlag, "The remove btn presence not as expected");
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {

        }
    }

    @And("observe the number of unavailable products present in the cart")
    public void observeTheNumberOfUnavailableProductsPresentInTheCart() {
        CommonCache.commonCache.put("CART_COUNT_UNAVAILABLE_PRODUCTS", "" + gg_cartPage.getProductCountFromCartForUnavailableItems());
    }

    @Then("product must be {string} the cart for unavailable items")
    public void productMustBeFromTheCartForUnavailableItems(String removedCheckVal) {
        if (removedCheckVal.contains("removed")) {
            Assert.assertEquals(Integer.parseInt(CommonCache.commonCache.get("CART_COUNT_UNAVAILABLE_PRODUCTS")) > gg_cartPage.getProductCountFromCartForUnavailableItems(), true, "Cart count not removed as expected");
        } else if (removedCheckVal.contains("added")) {
            Assert.assertEquals(Integer.parseInt(CommonCache.commonCache.get("CART_COUNT_UNAVAILABLE_PRODUCTS")) < gg_cartPage.getProductCountFromCartForUnavailableItems(), true, "Cart count not added as expected");
        }
    }


    @Then("verify view similar CTA is located in out of stock card")
    public void verifyViewSimilarCTALocatedInOutOfStockCard() {
        Assert.assertTrue(gg_cartPage.verifyViewSimilarCTALocatedInOutOfStockCardText(), "View Similar CTA is not located in Out of Stock Card");
    }

    @Then("verify view similar CTA is not located in the In-Stock Card in cart page")
    public void verifyViewSimilarCTAIsNotLocatedInStockCard() {
        Assert.assertFalse(gg_cartPage.verifyViewSimilarCTAIsNotLocatedInStockCardText(), "View Similar CTA is located in In-Stock Card");
    }

    @And("user clicks on Substitution CTA on first card on cart page")
    public void clickSubstitutionCTAFirstCard() {
        gg_cartPage.clickSubstitution();
    }

    @And("user select {string} on set substitutions for other products on cart page")
    public void selectOptionSetSubstitutionsOtherItems(String option) {
        if (option.toLowerCase().contains("no")) {
            gg_cartPage.clickNoSetSubstitutionForOtherItems();
        } else {
            gg_cartPage.clickOkSetSubstitutionForOtherItems();
        }
    }

    @Then("verify set substitutions for other products does not appears on cart page")
    public void verifySetSubstitutionsPopUpDoesNotAppears() {
        Assert.assertTrue(gg_cartPage.verifySetSubstitutionsPopUpDoesNotAppears(), "Set substitutions for other products appears on cart page!");

    }

    @Then("verify that label substitute is not visible in cart page")
    public void verifySubstitutionLabelNotVisible() {
        Assert.assertTrue(gg_cartPage.verifySubstitutionLabelNotVisible(), "Substitution Label appears on cart screen!");
    }

    @Then("verify substitution sheet on cart page")
    public void verifySubstitutionSheet() {
        Assert.assertTrue(gg_cartPage.isSubstitutionSheetCloseBtnIsDisplayed(), "Substitution Sheet Close Button is not displayed!");
        Assert.assertEquals(gg_cartPage.getSubstitutionSheetSaveText(), "Save", "Substitution Sheet Save Button text is not correct!");
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            Assert.assertEquals(gg_cartPage.getSubstitutionSheetTitleText(), "Substitution preferences", "Substitution Sheet Title text is not correct!");
            Assert.assertEquals(gg_cartPage.getSubstitutionSheetQuestionText(), "What if this item is unavailable?", "Substitution Sheet Question text is not correct!");
        }
        Assert.assertTrue(StringUtils.contains(gg_cartPage.getSubstitutionSheetSameBrandText(), "Same brand, different size"), "Substitution Sheet Same brand text is not correct!");
        Assert.assertTrue(StringUtils.contains(gg_cartPage.getSubstitutionSheetSameSizeText(), "Same size, different brand"), "Substitution Sheet Same size, different brand text is not correct!");
        Assert.assertTrue(StringUtils.contains(gg_cartPage.getSubstitutionSheetNoSubstitutionsText(), "No substitutions"), "Substitution Sheet No substitutions text is not correct!");
        Assert.assertTrue(gg_cartPage.isSubstitutionSheetSameBrandChecked(), "Substitution Sheet Same brand is not checked!");
    }


    @And("user selects {string} in substitutions on cart page")
    public void selectSubstitutionTypeByName(String substitutionName) {
        gg_cartPage.clickSubstitutionType(substitutionName);
        Assert.assertEquals(gg_cartPage.isSubstitutionTypeChecked(substitutionName), "true", "Substitution option: " + substitutionName + " on Sheet is not checked!");
    }

    @And("user saves selection in substitutions on cart page")
    public void clickSaveBtnOnSubstitutionSheet() {
        gg_cartPage.clickSaveBtnOnSubstitutionSheet();
    }

    @Then("verify {string} is saved in substitutions on cart page")
    public void verifySubstitutionTypeByName(String substitutionName) {
        Assert.assertEquals(gg_cartPage.isSubstitutionTypeChecked(substitutionName), "true", "Substitution option: " + substitutionName + " on Sheet is not checked!");
    }

    @And("user clicks close in substitutions on cart page")
    public void clickCloseBtnOnSubstitutionSheet() {
        gg_cartPage.clickCloseBtnOnSubstitutionSheet();
    }

    @Then("verify no substitution options on cart page")
    public void verifyNoSubstitutionOptions() {
        Assert.assertFalse(gg_cartPage.isNoSubstitutionCheckboxIsDisplayed(), "No Substitution checkbox in cart is displayed!");
        Assert.assertFalse(gg_cartPage.isSubstitutionButtonInCardDisplayed(), "Substitution button on product in cart is displayed!");
    }

    @Then("verify global substitution message text on cart page")
    public void verifyGlobalSubstitutionMessageText() {
        Assert.assertEquals(gg_cartPage.getNoSubstitutionMessageText(), "No substitutions on any items", "No substitution on all unavailable items text is incorrect!");
    }

    @And("user clicks no substitution checkbox on cart page")
    public void clickNoSubstitutionCheckbox() {
        gg_cartPage.clickNoSubstitutionCheckbox();
    }

    @Then("verify global substitution is checked on cart page")
    public void verifyGlobalSubstitutionChecked() throws InterruptedException {
        Assert.assertEquals(gg_cartPage.getNoSubstitutionCheckboxValue(), "1", "No substitutions checkbox is checked by default");
    }

    @Then("verify delivery or pickup CTA {string} displayed in cart screen")
    public void verifyDeliveryOrPickUpCTADisplayed(String desiredStatus) {
        if (desiredStatus.contains("not")) {
            Assert.assertEquals(gg_cartPage.isDeliveryOrPickUpCTADisplayed(), false, "'Delivery or Pickup' CTA is displayed!!");
        } else {
            Assert.assertEquals(gg_cartPage.isDeliveryOrPickUpCTADisplayed(), true, "'Delivery or Pickup' CTA is not displayed!!");
        }
    }

    @Then("verify pay in-store CTA {string} displayed in cart screen")
    public void verifyPayInStoreCTADisplayed(String desiredStatus) {
        if (desiredStatus.contains("not")) {
            Assert.assertEquals(gg_cartPage.isPayInStoreCTADisplayed(), false, "'Pay In-Store' CTA is displayed!!");
        } else {
            Assert.assertEquals(gg_cartPage.isPayInStoreCTADisplayed(), true, "'Pay In-Store' CTA is not displayed!!");
        }
    }

    @Then("verify pay in-store CTA is {string} in cart screen")
    public void verifyPayInStoreCTAEnabled(String desiredStatus) {
        if (desiredStatus.toUpperCase().contains("ENABLED")) {
            Assert.assertEquals(gg_cartPage.isPayInStoreCTAEnabled(), true, "'Pay In-Store' CTA is disabled!!");
        } else {
            Assert.assertEquals(gg_cartPage.isPayInStoreCTAEnabled(), false, "'Pay In-Store' CTA is enabled!!");
        }
    }

    @And("user clicks delivery or pickup CTA in cart screen")
    public void clickDeliveryOrPickUpCTA() {
        gg_cartPage.clickDeliveryOrPickUpCTA();
    }

    @And("user clicks pay in-store CTA in cart screen")
    public void clickPayInStoreCTA() {
        gg_cartPage.clickPayInStoreCTA();
    }

    @And("user clicks prop 65 warning label on a product card in cart screen")
    public void clickProp65Label() throws ClassNotFoundException {
        if (!(ThreadLocalHelper.testCaseData.get().get("ZIPCODE_PROP65").equalsIgnoreCase("NA"))) {
            List<Map<String, Object>> itemsList = getCartItemsFromApi();
            // Click Prop 65 warning label only when prop65WarningIconRequired in API is true
            if (itemsList.stream().anyMatch(item -> (Boolean) item.get("prop65WarningIconRequired") == true)) {
                gg_cartPage.clickOnProp65WarningLabel();
            }
        }
    }

    @Then("verify prop 65 message sheet in UI and API in cart screen")
    public void verifyProp65MessageSheetUiAndApi() throws ClassNotFoundException {
        List<Map<String, Object>> itemsList = getCartItemsFromApi();
        if (itemsList.stream().anyMatch(item -> (Boolean) item.get("prop65WarningIconRequired") == true)) {
            if (!(ThreadLocalHelper.testCaseData.get().get("ZIPCODE_PROP65").equalsIgnoreCase("NA"))) {
                Map<String, Object> prop65ElementCheckMap = gg_cartPage.checkProp65MessageSheet();
                Assert.assertTrue((Boolean) prop65ElementCheckMap.get("MESSAGE_SHEET_HEADER"), "Header is not displayed in prop 65 message sheet!!");
                Assert.assertEquals(prop65ElementCheckMap.get("MESSAGE_SHEET_MESSAGE_TEXT"), itemsList.get(0).get("prop65WarningText"), "Prop 65 warning message doesn't match; UI message:" + prop65ElementCheckMap.get("MESSAGE_SHEET_MESSAGE_TEXT") + " API message: " + itemsList.get(0).get("prop65WarningText"));
                Assert.assertTrue((Boolean) prop65ElementCheckMap.get("MESSAGE_SHEET_CLOSE"), "Close button is not displayed in prop 65 message sheet!!");
            }
        }
    }

    @And("user clicks close button in prop 65 message sheet in cart screen")
    public void clickProp65SheetClose() throws ClassNotFoundException {
        List<Map<String, Object>> itemsList = getCartItemsFromApi();
        if (itemsList.stream().anyMatch(item -> (Boolean) item.get("prop65WarningIconRequired") == true)) {
            if (!(ThreadLocalHelper.testCaseData.get().get("ZIPCODE_PROP65").equalsIgnoreCase("NA")))
                gg_cartPage.clickCloseProp65MessageSheet();
        }
    }

    @And("user clicks checkout button in cart screen")
    public void clickCheckout() {
        gg_cartPage.clickCheckOut();
        LoaderUtil.waitForCartLoaderToDisappear();
    }

    @And("click on Add Note button in cart")
    public void clickOnAddNoteButtonInCart() {
        gg_cartPage.clickOnAddNoteBtn();
    }

    @Then("verify Add Note title is displayed in cart")
    public void verifyAddNoteTitleIsDisplayedInCart() {
        Assert.assertTrue(gg_cartPage.getPresenceOfAddNoteTitle(), "Add Note Title not displayed");
    }

    @Then("verify Add Note close btn is displayed in cart")
    public void verifyAddNoteCloseBtnIsDisplayedInCart() {
        Assert.assertTrue(gg_cartPage.getPresenceOfAddNoteCloseBtn(), "Close not displayed");
    }

    @Then("verify Add Note save btn is displayed in cart")
    public void verifyAddNoteSaveBtnIsDisplayedInCart() {
        Assert.assertTrue(gg_cartPage.getPresenceOfAddNoteSaveBtn(), "Save not displayed");
    }

    @Then("verify Add Note placeholder text in cart")
    public void verifyAddNotePlaceholderTextInCart() {
        Assert.assertEquals(gg_cartPage.getPlaceHolderTextForAddNote().contains("Please pick"), true, "Placeholder text not displayed");
    }

    @And("close the Add Note screen on cart page")
    public void closeTheAddNoteScreenOnCartPage() {
        gg_cartPage.clickCloseAddNoteBtn();
    }

    @And("enter {string} in add note textbox")
    public void enterInAddNoteTextbox(String noteText) {
        gg_cartPage.addNoteText(noteText);
    }

    @Then("verify {string} is saved in add note textbox")
    public void verifyIsSavedInAddNoteTextbox(String noteTextVal) {
        String actualTextVal = gg_cartPage.getAddNoteText();
        Assert.assertEquals(actualTextVal.contains(noteTextVal), true, "Note text not saved" + actualTextVal);
    }

    @And("save the Add Note changes in cart screen")
    public void saveTheAddNoteChangesInCartScreen() {
        gg_cartPage.clickSaveAddNote();
    }

    @Then("verify the character limit for Add Note text box")
    public void verifyTheCharacterLimitForAddNoteTextBox() {
        Assert.assertFalse(gg_cartPage.getAddNoteText().contains(CommonCache.commonCache.get("ADD_NOTE_TEXT")), "Length constraint violated actual size ");
    }

    @And("enter Exceeded Character Sequence in add note textbox")
    public void enterExceededCharacterSequenceInAddNoteTextbox() {
        gg_cartPage.addNoteTextForExceededValue();
    }

    @Then("verify Add Note button {string} for all products in cart")
    public void verifyAddNoteButtonIsDisplayedForAllProductsInCart(String presenceFlag) {
        if (presenceFlag.contains("not")) {
            Assert.assertFalse(gg_cartPage.getPresenceOfAddNoteButtons(), "Add note Btn displayed !!");
        } else {
            Assert.assertEquals(gg_cartPage.getCountOfAddNoteButtons(), gg_cartPage.getProductCountFromHeader(), "Add note Btn not displayed for all !!");
        }
    }

    @And("swipe partially across a product card in cart for unavailable item")
    public void swipePartiallyAcrossAProductCardInCartForUnavailableItem() {
        gg_cartPage.swipePartiallyAcrossTheFirstProductInCartForUnavailableItems();
    }

    @Then("remove some items from the cart using API service")
    public void removeRandomItemsFromCart() {
        cartService = new CartService(gg_cartPage.getCurrentBanner());
        GetCartItemsResponse getCartItemsResponse = cartService.getCartDetails(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), CommonCache.commonCache.get("CUSTOMERID_CART_API"), null, "");
        List<String> itemIdValues = new ArrayList<String>();
        if (!getCartItemsResponse.getCartItemsList().isEmpty()) {
            itemIdValues.add(new BigDecimal((Double) getCartItemsResponse.getCartItemsList().stream().findAny().get().get("itemId")).toPlainString());
            HttpResponse deleteCartItemsResponse = cartService.deleteAllItemsFromTheCart(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), null, "" + getCartItemsResponse.getCartId(), itemIdValues);
            Assert.assertEquals(deleteCartItemsResponse.getStatusCode(), 200, "Cart Delete Operation Failed");//(Double)indItems.get("itemId").toPlainString()
        }
    }

    @Then("verify in Cart if the WYSIWYG qualifying threshold value in the UI equals the WYSIWYG qualifying threshold value in the API response")
    public <cart> void verifyWYSIWYGThresholdInUIEqualsToAPIInCart() throws ClassNotFoundException {
        cartService = new CartService(gg_cartPage.getCurrentBanner());
        cart cartItems = cartService.getCartItems(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), CommonCache.commonCache.get("CUSTOMERID_CART_API"), ThreadLocalHelper.testCaseData.get().get("STOREID_CART_API"), "");
        if (Class.forName("java.lang.String").isInstance(cartItems)) {
            Assert.assertTrue(false, "Get cart items api call failed, response: " + cartItems);
        } else {
            GetCartItemsResponse getCartItemsResponse = (GetCartItemsResponse) cartItems;
            double WysiQualifyingValueInAPI = Double.parseDouble(getCartItemsResponse.getSummary().getQualifyingDollarValueWYSIWYG());
            double WysiQualifyingValueInUI = Double.parseDouble(gg_cartPage.getWysiQualifyingValue());
            Assert.assertEquals(WysiQualifyingValueInUI, WysiQualifyingValueInAPI, "WYSIWYG qualifying threshold value in UI and API are different, UI:" + WysiQualifyingValueInUI + " API:" + WysiQualifyingValueInAPI);
        }
    }

    @Then("verify in Cart if the qualifying threshold value in the UI equals the qualifying threshold value in the API response while Wysi is Off")
    public <cart> void verifyThresholdInUIEqualsToAPIInCartWhileWysiIsOff() throws ClassNotFoundException {
        cartService = new CartService(gg_cartPage.getCurrentBanner());
        cart cartItems = cartService.getCartItems(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), CommonCache.commonCache.get("CUSTOMERID_CART_API"), ThreadLocalHelper.testCaseData.get().get("STOREID_CART_API"), "");
        if (Class.forName("java.lang.String").isInstance(cartItems)) {
            Assert.assertTrue(false, "Get cart items api call failed, response: " + cartItems);
        } else {
            GetCartItemsResponse getCartItemsResponse = (GetCartItemsResponse) cartItems;
            double qualifyingValueInAPI = Double.parseDouble(getCartItemsResponse.getSummary().getQualifyingDollarValue());
            double qualifyingValueInUI = Double.parseDouble(Float.toString(gg_cartPage.getAmountToReachOrderMinimum()));
            Assert.assertEquals(qualifyingValueInUI, qualifyingValueInAPI, " qualifying threshold value while wysi is off in UI and API are different, UI:" + qualifyingValueInUI + " API:" + qualifyingValueInAPI);
        }
    }

    @Then("verify prop 65 warning sheet {string} displayed")
    public void verifyProp65SheetPresence(String desiredStatus) throws ClassNotFoundException {
        List<Map<String, Object>> itemsList = getCartItemsFromApi();
        // Verify Prop 65 warning label only when prop65WarningIconRequired in API is true
        if (itemsList.stream().anyMatch(item -> (Boolean) item.get("prop65WarningIconRequired") == true)) {
            if (desiredStatus.contains("not")) {
                Assert.assertFalse(gg_cartPage.isProp65WarningSheetDisplayed(), "Prop 65 warning sheet is displayed!!");
            } else {
                Assert.assertTrue(gg_cartPage.isProp65WarningSheetDisplayed(), "Prop 65 warning sheet is not displayed!!");
            }
        }
    }

    @Then("verify prop 65 warning label is displayed on a product card in non-snap eligible items sheet")
    public void verifyProp65WarningUINonSnap() throws ClassNotFoundException {
        if (Boolean.parseBoolean(ThreadLocalHelper.testCaseData.get().get("SNAP_ENABLED"))) {
            if (!(ThreadLocalHelper.testCaseData.get().get("ZIPCODE_SNAP_PROP65").equalsIgnoreCase("NA"))) {
                List<Map<String, Object>> itemsList = getCartItemsFromApi();

                // Verify Prop 65 warning label only when prop65WarningIconRequired in API is true
                if (itemsList.stream().anyMatch(item -> (Boolean) item.get("prop65WarningIconRequired") == true)) {
                    Assert.assertTrue(gg_cartPage.isProp65WarningDisplayed(), "'Prop 65 Warning' label is not displayed on product card");
                }
            }
        }
    }


    @Then("verify in Cart sales savings in UI equals sales savings in API while WYSIWYG is ON")
    public <cart> void verifySalesSavingsInCartWhileWysIsON() throws ClassNotFoundException {
        cartService = new CartService(gg_cartPage.getCurrentBanner());
        cart cartItems = cartService.getCartItems(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), CommonCache.commonCache.get("CUSTOMERID_CART_API"), ThreadLocalHelper.testCaseData.get().get("STOREID_CART_API"), "");
        if (Class.forName("java.lang.String").isInstance(cartItems)) {
            Assert.assertTrue(false, "Get cart items api call failed, response: " + cartItems);
        } else {
            GetCartItemsResponse getCartItemsResponse = (GetCartItemsResponse) cartItems;
            double salesSavingsInAPI = getCartItemsResponse.getSummary().getCardSavings().get(0).getSavingsAmount();
            double salesSavingsInUI = Double.parseDouble(gg_cartPage.getSalesSavingsValue());
            Assert.assertTrue(gg_cartPage.isCartV2MemberPriceSavingsDisplayed(), "Member Price Savings Label is not displayed");
            Assert.assertEquals(salesSavingsInUI, salesSavingsInAPI, "  sales savings while Wysi is ON in UI and API are different, UI:" + salesSavingsInUI + " API:" + salesSavingsInAPI);
        }
    }

    @Then("verify in Cart employees savings in UI equals employees savings in API while WYSIWYG is ON")
    public <cart> void verifyEmployeesSavingsInCartWhileWysIsON() throws ClassNotFoundException {
        cartService = new CartService(gg_cartPage.getCurrentBanner());
        cart cartItems = cartService.getCartItems(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), CommonCache.commonCache.get("CUSTOMERID_CART_API"), ThreadLocalHelper.testCaseData.get().get("STOREID_CART_API"), "");
        if (Class.forName("java.lang.String").isInstance(cartItems)) {
            Assert.assertTrue(false, "Get cart items api call failed, response: " + cartItems);
        } else {
            GetCartItemsResponse getCartItemsResponse = (GetCartItemsResponse) cartItems;
            double employeesSavingsInAPI = getCartItemsResponse.getSummary().getCardSavings().get(1).getSavingsAmount();
            double employeesSavingsInUI = Double.parseDouble(gg_cartPage.getEmployeesSavingsValue());
            Assert.assertTrue(gg_cartPage.isCartV2EmployeeSavingsDisplayed(), "Employee Savings Label is not displayed");
            Assert.assertEquals(employeesSavingsInUI, employeesSavingsInAPI, "employees savings while wysi is ON in UI and API are different, UI:" + employeesSavingsInUI + " API:" + employeesSavingsInAPI);
        }
    }

    @Then("verify in Edit Cart sales savings in UI equals sales savings in API while WYSIWYG is ON")
    public <cart> void verifySalesSavingsInEditCartWhileWysIsON() throws ClassNotFoundException {
        gg_cartPage.isCartV2MemberPriceSavingsDisplayed();
        cartService = new CartService(gg_cartPage.getCurrentBanner());
        cart cartItems = cartService.getEditCartItems(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), ThreadLocalHelper.testCaseData.get().get("STOREID_CART_API"));
        if (Class.forName("java.lang.String").isInstance(cartItems)) {
            Assert.assertTrue(false, "Get cart items api call failed, response: " + cartItems);
        } else {
            GetCartItemsResponse getCartItemsResponse = (GetCartItemsResponse) cartItems;
            double salesSavingsInAPI = getCartItemsResponse.getWysiwygOrderSummary().getCardSavings().get(0).getSavingsAmount();
            double salesSavingsInUI = Double.parseDouble(gg_cartPage.getSalesSavingsValue());
            Assert.assertTrue(gg_cartPage.isCartV2MemberPriceSavingsDisplayed(), "Member Price Savings Label is not displayed");
            Assert.assertEquals(salesSavingsInUI, salesSavingsInAPI, "sales savings while wysi is ON in UI and API are different, UI:" + salesSavingsInUI + " API:" + salesSavingsInAPI);
        }
    }

    @Then("verify in Edit Cart employees savings in UI equals employees savings in API while WYSIWYG is ON")
    public <cart> void verifyEmployeesSavingsInEditCartWhileWysIsON() throws ClassNotFoundException {
        cartService = new CartService(gg_cartPage.getCurrentBanner());
        cart cartItems = cartService.getEditCartItems(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), ThreadLocalHelper.testCaseData.get().get("STOREID_CART_API"));
        if (Class.forName("java.lang.String").isInstance(cartItems)) {
            Assert.assertTrue(false, "Get cart items api call failed, response: " + cartItems);
        } else {
            GetCartItemsResponse getCartItemsResponse = (GetCartItemsResponse) cartItems;
            double employeesSavingsInAPI = getCartItemsResponse.getWysiwygOrderSummary().getCardSavings().get(1).getSavingsAmount();
            double employeesSavingsInUI = Double.parseDouble(gg_cartPage.getEmployeesSavingsValue());
            Assert.assertTrue(gg_cartPage.isCartV2EmployeeSavingsDisplayed(), "Employee Savings Label is not displayed");
            Assert.assertEquals(employeesSavingsInUI, employeesSavingsInAPI, "employees savings while wysi is ON in UI and API are different, UI:" + employeesSavingsInUI + " API:" + employeesSavingsInAPI);
        }
    }

    @Then("verify in Edit Cart estimated subtotal while Wysiwyg is ON")
    public <cart> void verifyEstimatedSubTotalInEditCart() throws ClassNotFoundException {
        cartService = new CartService(gg_cartPage.getCurrentBanner());
        cart cartItems = cartService.getEditCartItems(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), ThreadLocalHelper.testCaseData.get().get("STOREID_CART_API"));
        if (Class.forName("java.lang.String").isInstance(cartItems)) {
            Assert.assertTrue(false, "Get cart items api call failed, response: " + cartItems);
        } else {
            GetCartItemsResponse getCartItemsResponse = (GetCartItemsResponse) cartItems;
            double estimatedSubtotalInAPI = getCartItemsResponse.getWysiwygOrderSummary().getTotalSnapItemPrice();
            double estimatedSubtotalInUI = gg_cartPage.getEstSubTotalAmount();
            Assert.assertEquals(estimatedSubtotalInUI, estimatedSubtotalInAPI, "estimated subtotal while Wysiwyg is ON in UI and API are different, UI:" + estimatedSubtotalInUI + " API:" + estimatedSubtotalInAPI);
        }
    }

    @Then("verify in Edit Cart if the WYSIWYG qualifying threshold value in the UI equals the WYSIWYG qualifying threshold value in the API response")
    public <cart> void verifyWYSIWYGThresholdInUIEqualsToAPIInEditCart() throws ClassNotFoundException {
        cartService = new CartService(gg_cartPage.getCurrentBanner());
        cart cartItems = cartService.getEditCartItems(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), ThreadLocalHelper.testCaseData.get().get("STOREID_CART_API"));
        if (Class.forName("java.lang.String").isInstance(cartItems)) {
            Assert.assertTrue(false, "Get cart items api call failed, response: " + cartItems);
        } else {
            GetCartItemsResponse getCartItemsResponse = (GetCartItemsResponse) cartItems;
            double WysiQualifyingValueInAPI = Double.parseDouble(getCartItemsResponse.getWysiwygOrderSummary().getQualifyingDollarValue());
            gg_checkoutPage.clickBackBtnInEditCartScreen();
            double WysiQualifyingValueInUI = Double.parseDouble(gg_cartPage.getWysiQualifyingValueInEditOrder());
            Assert.assertEquals(WysiQualifyingValueInUI, WysiQualifyingValueInAPI, "WYSIWYG qualifying threshold value in UI and API are different, UI:" + WysiQualifyingValueInUI + " API:" + WysiQualifyingValueInAPI);
        }
    }

    @Then("verify in Edit Cart if the qualifying threshold value in the UI equals the qualifying threshold value in the API response while Wysi is Off")
    public <cart> void verifyqualifyingThresholdInUIEqualsToAPIWhileWysiIsOffInEditCart() throws ClassNotFoundException {
        cartService = new CartService(gg_cartPage.getCurrentBanner());
        cart cartItems = cartService.getEditCartItems(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), ThreadLocalHelper.testCaseData.get().get("STOREID_CART_API"));
        if (Class.forName("java.lang.String").isInstance(cartItems)) {
            Assert.assertTrue(false, "Get cart items api call failed, response: " + cartItems);
        } else {
            GetCartItemsResponse getCartItemsResponse = (GetCartItemsResponse) cartItems;
            double qualifyingValueInAPI = getCartItemsResponse.getOrderSummary().getQualifyingDollarValue();
            gg_checkoutPage.clickBackBtnInEditCartScreen();
            double qualifyingValueInUI = Double.parseDouble(gg_cartPage.getWysiQualifyingValueInEditOrder());
            Assert.assertEquals(qualifyingValueInUI, qualifyingValueInAPI, "WYSIWYG qualifying threshold value in UI and API are different, UI:" + qualifyingValueInUI + " API:" + qualifyingValueInAPI);
        }
    }

    @Then("verify in Edit Cart estimated club card savings in UI equals estimated club card savings in API while WYSIWYG is OFF")
    public <cart> void verifyEstimatedClubCardSavingsInEditCart() throws ClassNotFoundException {
        cartService = new CartService(gg_cartPage.getCurrentBanner());
        cart cartItems = cartService.getEditCartItems(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), ThreadLocalHelper.testCaseData.get().get("STOREID_CART_API"));
        if (Class.forName("java.lang.String").isInstance(cartItems)) {
            Assert.assertTrue(false, "Get cart items api call failed, response: " + cartItems);
        } else {
            GetCartItemsResponse getCartItemsResponse = (GetCartItemsResponse) cartItems;
            double estimatedClubCardSavingsInAPI = (getCartItemsResponse.getOrderSummary().getEstimatedClubCardSavings());
            double estimatedClubCardSavingsInUI = Double.parseDouble(gg_cartPage.getEstimatedSavingsValue());
            Assert.assertTrue(gg_cartPage.isCartV2ClubCardSavingsDisplayed(), "Estimated Club Card Savings Label is not displayed");
            Assert.assertEquals(estimatedClubCardSavingsInUI, estimatedClubCardSavingsInAPI, "estimated club card savings in UI and API are different, UI:" + estimatedClubCardSavingsInUI + " API:" + estimatedClubCardSavingsInAPI);
        }
    }

    @Then("verify in Edit Cart estimated total while Wysiwyg is Off")
    public <cart> void verifyEstimatedTotalInEditCart() throws ClassNotFoundException {
        cartService = new CartService(gg_cartPage.getCurrentBanner());
        cart cartItems = cartService.getEditCartItems(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), ThreadLocalHelper.testCaseData.get().get("STOREID_CART_API"));
        if (Class.forName("java.lang.String").isInstance(cartItems)) {
            Assert.assertTrue(false, "Get cart items api call failed, response: " + cartItems);
        } else {
            GetCartItemsResponse getCartItemsResponse = (GetCartItemsResponse) cartItems;
            double estimatedTotalInAPI = getCartItemsResponse.getOrderSummary().getTotalEstimatedPrice();
            double estimatedTotalInUI = gg_cartPage.getEstSubTotalAmount();
            Assert.assertEquals(estimatedTotalInUI, estimatedTotalInAPI, "estimated total while Wysiwyg is Off in UI and API are different, UI:" + estimatedTotalInUI + " API:" + estimatedTotalInAPI);
        }
    }

    @Then("verify age restricted warning label is displayed on a product card in cart screen")
    public void verifyAgeRestrictedWarningUINonSnap() {
        Assert.assertTrue(gg_cartPage.isAgeRestrictionLabelDisplayed(), "'Age restricted' label is not displayed on product card");
    }

    @And("user increments product quantity in quantity stepper until checkout button is enabled in cart screen")
    public void incrementProductQtyTillCheckoutIsEnabled() {
        while (!gg_cartPage.isCheckoutEnabled()) {
            try {
                gg_cartPage.incrementProductQuantity();
            } catch (StaleElementReferenceException sre) {
                sre.printStackTrace();
            }
            WaitAction.sleep("BOTH", 4000);
        }
    }

    @Then("verify cart disclaimer message {string} displayed")
    public void verifyCartDisclaimerMessageIsDisplayed(String elemVisibility) {
        boolean shouldBeDisplayed = elemVisibility.contains("not") ? false : true;
        String expCartDiscMsg = null;
        if (shouldBeDisplayed) {
            expCartDiscMsg = driver.getPlatformName().toUpperCase().contains("IOS") ? "Apologies, we are not able to guarantee the prices or availability of the items in your list. Please check in store for current prices and availability." : "Apologies, we're not able to guarantee the prices or availability of the items in your list. Please check in store for current prices and availability.";
        } else {
            expCartDiscMsg = "NOT DISPLAYED";
        }
        Assert.assertEquals(gg_cartPage.getCartDisclaimerMsg(), expCartDiscMsg, "Cart disc msg don't match");
    }

    @Then("verify applied deal label is displayed for a product while WYSIWYG is ON")
    public void verifyAppliedDealLabelForProduct() {
        Assert.assertTrue(gg_cartPage.verifyTextOfAppliedDeal(), "Applied deal label is not displayed");
    }

    @Then("verify clipped deal label is displayed for a product while WYSIWYG is OFF")
    public void verifyClippedDealLabelForProduct() {
        Assert.assertTrue(gg_cartPage.verifyTextOfClippedDealLabel());
    }

    @Then("verify in Cart estimated subtotal while Wysiwyg is ON")
    public <cart> void verifyEstimatedSubTotalInCart() throws ClassNotFoundException {
        cartService = new CartService(gg_cartPage.getCurrentBanner());
        cart cartItems = cartService.getCartItems(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), CommonCache.commonCache.get("CUSTOMERID_CART_API"), ThreadLocalHelper.testCaseData.get().get("STOREID_CART_API"), "");
        if (Class.forName("java.lang.String").isInstance(cartItems)) {
            Assert.assertTrue(false, "Get cart items api call failed, response: " + cartItems);
        } else {
            GetCartItemsResponse getCartItemsResponse = (GetCartItemsResponse) cartItems;
            double estimatedSubtotalInAPI = Double.parseDouble(getCartItemsResponse.getSummary().getTransactionTotal());
            double estimatedSubtotalInUI = gg_cartPage.getEstSubTotalAmount();
            Assert.assertEquals(estimatedSubtotalInUI, estimatedSubtotalInAPI, "estimated subtotal while Wysiwyg is ON in UI and API are different, UI:" + estimatedSubtotalInUI + " API:" + estimatedSubtotalInAPI);
        }
    }

    @Then("verify in Cart estimated total while Wysiwyg is Off")
    public <cart> void verifyEstimatedTotalInCart() throws ClassNotFoundException {
        cartService = new CartService(gg_cartPage.getCurrentBanner());
        cart cartItems = cartService.getCartItems(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), CommonCache.commonCache.get("CUSTOMERID_CART_API"), ThreadLocalHelper.testCaseData.get().get("STOREID_CART_API"), "");
        if (Class.forName("java.lang.String").isInstance(cartItems)) {
            Assert.assertTrue(false, "Get cart items api call failed, response: " + cartItems);
        } else {
            GetCartItemsResponse getCartItemsResponse = (GetCartItemsResponse) cartItems;
            double estimatedTotalInAPI = getCartItemsResponse.getSummary().getTotalEstimatedPrice();
            double estimatedTotalInUI = gg_cartPage.getEstSubTotalAmount();
            Assert.assertEquals(estimatedTotalInUI, estimatedTotalInAPI, "estimated total while Wysiwyg is Off in UI and API are different, UI:" + estimatedTotalInUI + " API:" + estimatedTotalInAPI);
        }
    }

    @Then("verify in Cart estimated club card savings in UI equals estimated club card savings in API while WYSIWYG is OFF")
    public <cart> void verifyEstimatedClubCardSavingsInCart() throws ClassNotFoundException {
        cartService = new CartService(gg_cartPage.getCurrentBanner());
        cart cartItems = cartService.getCartItems(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), CommonCache.commonCache.get("CUSTOMERID_CART_API"), ThreadLocalHelper.testCaseData.get().get("STOREID_CART_API"), "");
        if (Class.forName("java.lang.String").isInstance(cartItems)) {
            Assert.assertTrue(false, "Get cart items api call failed, response: " + cartItems);
        } else {
            GetCartItemsResponse getCartItemsResponse = (GetCartItemsResponse) cartItems;
            double estimatedClubCardSavingsInAPI = Double.parseDouble(getCartItemsResponse.getSummary().getEstimatedClubCardSavings());
            double estimatedClubCardSavingsInUI = Double.parseDouble(gg_cartPage.getEstimatedSavingsValue());
            Assert.assertTrue(gg_cartPage.isCartV2ClubCardSavingsDisplayed(), "Estimated Club Card Savings Label is not displayed");
            Assert.assertEquals(estimatedClubCardSavingsInUI, estimatedClubCardSavingsInAPI, "estimated club card savings while Wysiwyg is Off in UI and API are different, UI:" + estimatedClubCardSavingsInUI + " API:" + estimatedClubCardSavingsInAPI);
        }
    }

    @Then("verify estimated club card savings")
    public void verifyEstimatedMemberPriceSavingsText() {
        Assert.assertTrue(gg_cartPage.isCartV2ClubCardSavingsDisplayed(), "Club card savings is not displayed");
    }

    @Then("empty the cart using API service for signed in user")
    public void emptyTheCartUsingAPIServiceUsingExistingSignIn() {
        //Delete Cart
        cartService = new CartService(gg_cartPage.getCurrentBanner());
        GetCartItemsResponse getCartItemsResponse = cartService.getCartDetails(CommonCache.commonCache.get("USERNAME"), CommonCache.commonCache.get("PASSWORD"), CommonCache.commonCache.get("CUSTOMERID"), null, "");
        List<String> itemIdValues = new ArrayList<String>();
        if (!getCartItemsResponse.getCartItemsList().isEmpty()) {
            getCartItemsResponse.getCartItemsList().forEach(indItems -> itemIdValues.add(new BigDecimal((Double) indItems.get("itemId")).toPlainString()));
            HttpResponse deleteCartItemsResponse = cartService.deleteAllItemsFromTheCart(CommonCache.commonCache.get("USERNAME_CART_API"), CommonCache.commonCache.get("PASSWORD_CART_API"), null, "" + getCartItemsResponse.getCartId(), itemIdValues);
            Assert.assertEquals(deleteCartItemsResponse.getStatusCode(), 200, "Cart Delete Operation Failed");
            //Doing below steps to refresh count on cart icon
            if (gg_cartPage.isCartV2CloseButtonDisplayed()) {
                gg_cartPage.closeCartScreen();
            }
            gg_cartPage.closeCartScreenIfDisplayed();
            gg_dashboardPage.handleTutorial(2);
            gg_cartPage.clickOnCartWithoutWait();
            gg_cartPage.closeCartScreen();
        }
    }

    @Then("^verify checkout button displayed in cart screen")
    public void verifyCheckOutButtonDisplayed() {
        Assert.assertTrue(gg_cartPage.isCheckoutDisplayed(), "Checkout button is not displayed!!");
    }

    @Then("^verify loading indicator is displayed until the cart loads in cart screen")
    public void verifyLoadingIndicatorDisplayed() {
        Assert.assertTrue(gg_cartPage.isLoaderDisplayedUntilCartLoads(), "Loading indicator is not displayed!!");
    }

    @Then("verify substitute link {string} displayed for the product in cart")
    public void verifySubstituteLinkIsDisplayedForTheProductInCart(String subLinkPresence) {
        boolean subLinkPresenceVal = subLinkPresence.contains("not") ? false : true;
        Assert.assertEquals(gg_cartPage.isSubstitutionCTADisplayedForProduct(), subLinkPresenceVal, "Substitution CTA for product is not displayed");
    }

    @Then("verify edit substitute link {string} displayed")
    public void verifyChangeSubstituteLinkIsDisplayed(String subLinkPresence) {
        boolean subLinkPresenceVal = subLinkPresence.contains("not") ? false : true;
        Assert.assertEquals(gg_cartPage.isChangeSubstitutionCTADisplayedForProduct(), subLinkPresenceVal, "Change Substitution CTA for product is not displayed");
    }

    @And("user clicks on edit substitution CTA in cart screen")
    public void clickChangeSubstitution() {
        gg_cartPage.clickChangeSubstitution();
        LoaderUtil.waitForSubstitutionsLoaderToDisappear();
    }

    @And("fetch all the product names displayed in cart")
    public void fetchAllTheProductNamesDisplayedInCart() {
        CommonCache.cartItems.put("cartProducts", gg_cartPage.getAllTheProductsInTheCart());
    }


    @Then("verify the product selected in substitute preferences carousel for the product {string} is same as that in cart api")
    public void verifyTheProductSelectedInSubstitutePreferencesCarouselForTheProductIsSameAsThatInCartApi(String productName) throws ClassNotFoundException {
        String actualPreferencesOnScreen = CommonCache.commonCache.get("SUBSTITUTION_PRODUCT_NAME_PREFERENCES");
        String subNameFromCartApi = getSubNameFromCartApi(productName);
        Assert.assertEquals(actualPreferencesOnScreen, subNameFromCartApi, "The selected substitute preferences products are not same as that in API !!!");
    }

    private String getSubNameFromCartApi(String productName) throws ClassNotFoundException {
        String subNameFromCartApi = null;
        List<Map<String, Object>> itemsList = getCartItemsFromApi();
        subNameFromCartApi = (String) itemsList.stream().filter(indItem -> ("" + indItem.get("name")).toLowerCase().contains(productName.toLowerCase())).findFirst().get().get("substitutionPreferenceV2");
        if (!subNameFromCartApi.contains("Do Not Substitute")) {
            List<Map<String, Object>> desiredSubInfo = (List<Map<String, Object>>) itemsList.stream().filter(indItem -> ("" + indItem.get("name")).toLowerCase().contains(productName.toLowerCase())).findFirst().get().get("substituteItems");
            subNameFromCartApi = "" + desiredSubInfo.get(0).get("name");
        }
        return subNameFromCartApi;
    }

    @Then("verify the product {string} is having a substitute selected using Cart Service")
    public void verifyTheProductInCartHasSubstitutePreferncesSet(String productName) throws ClassNotFoundException {
        String subNameFromCartApi = getSubNameFromCartApi(productName);
        Assert.assertTrue(!subNameFromCartApi.isEmpty(), "The selected substitute preferences products are not set  !!! " + subNameFromCartApi);
    }

    @And("verify the cart summary for {int} items is displayed on the cart screen")
    public void verifyCartSummaryIsDiplayedWithSavingsBreakup(int noOfItems) {
        String expectedCartV2HeaderText = "Cart (" + noOfItems + ")";
        SoftAssert summaryAssert = new SoftAssert();
        //Cart Summary with Items Count
        summaryAssert.assertEquals(gg_cartPage.getTextOfCartV2EmptyHeader(), expectedCartV2HeaderText, "Header text is not displayed as expected");
        summaryAssert.assertTrue(gg_cartPage.isCartV2CartSummaryDisplayed(), "Cart Summary is not displayed");
        summaryAssert.assertEquals(gg_cartPage.getTextOfCartSummary(), "Cart summary", "Cart summary text is not displayed as expected");
        summaryAssert.assertTrue(gg_cartPage.isCartV2ItemsWithCountDisplayed(), "Items with count is not displayed in the summary");
        summaryAssert.assertTrue(gg_cartPage.isCartV2ItemsPriceDisplayed(), "Items price is not displayed in the summary");
        summaryAssert.assertEquals(gg_cartPage.getTextOfItemsCount(), "Items (" + noOfItems + ")", "Items count text is not displayed as expected");
        gg_cartPage.getTextOfItemsPrice().forEach(indVal -> summaryAssert.assertTrue(Pattern.matches("[\\$][0-9]*[\\.]*[0-9]*", indVal), "Items price is not displayed"));

        //Savings Verification for labels and values
        Map<String, String> savingDetails = gg_cartPage.getSavingsDetails();
        List<String> expectedSavingLabels = new ArrayList<>(Arrays.asList("Estimated savings", "Member Price Savings", "Safeway for U savings"));
        summaryAssert.assertTrue(expectedSavingLabels.containsAll(savingDetails.keySet()), "Estimated Savings is not displayed Actual " + savingDetails.keySet());
        savingDetails.forEach((svngLabel, svngVal) -> summaryAssert.assertTrue(Pattern.matches("-?[\\$][0-9]*[\\.]*[0-9]*", svngVal), "Savnings value not present as expected for " + svngLabel));
        //Est Sub Total
        summaryAssert.assertTrue(gg_cartPage.isCartV2StaticTextEstSubtotalDisplayed(), "Static text about Est. subtotal is not displayed");
        String expectedStaticTextEstSubtotal = "The actual amount you will be charged for your order may be different from the Estimated Subtotal above. The Estimated Subtotal does not include the final cost of items sold by weight or taxes/deposits/other fees. These adjustments will appear on your final receipt at delivery/pickup. Review Estimated Subtotal (i) for details.";
        summaryAssert.assertTrue(StringUtils.containsIgnoreCase(gg_cartPage.getTextOfCartV2DisclaimerText(), expectedStaticTextEstSubtotal), "Disclaimer text is not displayed as expected");
        summaryAssert.assertAll();
    }


    @Then("verify product count in cart is {int}")
    public void verifyTotalProdCountInCart(int expectedProdCount) {
        int actualProdCount = gg_cartPage.getProductCountFromHeader();
        Assert.assertEquals(actualProdCount, expectedProdCount, "Actual and expected product count in cart don't match!!");
    }

    @Then("verify cart SCP is {string} in cart page")
    public void verifySCPOnOffDisplayed(String mode) {
        boolean modeSCP = mode.toLowerCase().equals("on");
        Assert.assertEquals(gg_cartPage.verifySCPOnOffDisplayed(), modeSCP, "Error in the SCP mode displayed on Cart!!");
    }

}



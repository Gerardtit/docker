package com.automation.steps;


import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.manager.ConfigFileManager;
import com.automation.pages.BasePage;
import com.automation.pages.GG_CartPage;
import com.automation.pages.GG_CheckoutPage;
import com.automation.pages.GG_DashboardPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GG_CheckOutSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public BasePage basePage = new BasePage(driver);
    public GG_CheckoutPage gg_checkoutPage = new GG_CheckoutPage(driver);
    public GG_DashboardPage dashboardPage = new GG_DashboardPage(driver);
    public GG_CartPage gg_cartPage = new GG_CartPage(driver);
    public GG_SearchSteps gg_searchSteps = new GG_SearchSteps();
    public GG_ProductDetailsPageSteps gg_productDetailsPageSteps = new GG_ProductDetailsPageSteps();

    @Then("^Verify search and cart icons$")
    public void verifySearchCartIconDisplayed() throws IOException {
        dashboardPage.verifySearchAndCartIcons();
    }

    @Then("^verify check out page is displayed$")
    public void verifyCheckOutPageDisplayed() throws IOException {
        Assert.assertTrue(gg_checkoutPage.isCheckOutPageDisplayed(), "Checkout page is not displayed");
    }

    @Then("^add the items if cart is empty$")
    public void clickCartAndAddItems() throws IOException {
        dashboardPage.verifySearchAndCartIcons();
    }

    @Then("^Verify Labels at Checkout page$")
    public void verifyLabelsCheckoutPage() throws IOException {
        gg_checkoutPage.verifyLabels();
    }

    @Then("^enter more than 10 digits in phone number and verify only a maximum of 10 digits can be entered$")
    public void enterPhoneNumber() {
        gg_checkoutPage.enterMoreThan10DigitPhoneNumberAndVerify();
    }

    @Then("^verify error message is displayed while updating username from checkout$")
    public void verifyErrorMessageDisplayed() throws IOException {
        dashboardPage.verifySearchAndCartIcons();
    }

    @Then("^verify cart and search icon are not displayed$")
    public void verifyCartAndSearchIconNotDisplayed() throws IOException {
        Assert.assertFalse(dashboardPage.verifySearchAndCartIconsNotDisplayed());
    }

    public Map<String, String> getBannerPropertiesMap() throws IOException {
        String banner = basePage.getCurrentBanner();
        String env = basePage.getCurrentEnv();
        Map<String, String> bannerProperties = ConfigFileManager.getBannerPropertyMap(banner, env);
        return bannerProperties;
    }

    @And("^verify CheckOut Button is Enabled$")
    public void verifyCheckOutButtonIsEnabled() {
        gg_checkoutPage.isCheckoutEnabled();
    }

    @Then("^Click on checkout button$")
    public void clickCheckoutBtn() {
        gg_checkoutPage.clickOnCheckoutBtn();
    }

    @Then("^verify user navigates to Your order screen$")
    public void navigatesToYourOrderScreen() {
        gg_checkoutPage.verifyYourOrderScreen();
    }


    @Then("^verify new slot selection screen is displayed$")
    public void newCheckoutScreen() {
        gg_checkoutPage.verifyNewSlotSelectionScreen();
    }

    @And("^verify SNAP EBT option is available$")
    public void verifySnapEBTOptionIsAvailable() {
        gg_checkoutPage.isSnapEBTOptionDisplayed();
    }

    @When("^Click On Search Button$")
    public void clickOnSearchButton() {
        gg_checkoutPage.clickOnSearchButton();
    }

    @Then("^search for an SNAP Item$")
    public void searchForAnSNAPItem() throws IOException {
        String productName = ThreadLocalHelper.testCaseData.get().get("SEARCH_SNAP_KEYWORD");
        dashboardPage.searchByProductName(productName);
    }

    @Then("^search for an Non SNAP Item$")
    public void searchForAnNonSNAPItem() throws IOException {
        String item = ThreadLocalHelper.testCaseData.get().get("SEARCH_NON_SNAP_KEYWORD");
        gg_checkoutPage.enterItems(item);
    }

    @When("user clicks view cart when SNAP EBT purchase issue popup is displayed in cart screen")
    public void clickOnViewCartPopUp() {
        if (Boolean.parseBoolean(ThreadLocalHelper.testCaseData.get().get("SNAP_ENABLED")))
            gg_checkoutPage.clickOnViewCartPopUP();
    }

    @And("^Remove All Non SNAP Items$")
    public void removeAllNonSNAPItems() {
        gg_checkoutPage.removeAllNonSNAPItem();
    }

    @And("^click back button to go back to checkout page$")
    public void clickBackToCheckOut() {
        gg_checkoutPage.clickBackButtonToCheckout();
    }

    @Then("^verify snap eligible sub total list$")
    public void verifySnapEligibleSubTotal() {
        Assert.assertTrue(gg_checkoutPage.isSnapEligibleSubTotalDisplayed());
    }

    @And("^verify non eligible sub total list$")
    public void verifyNonSnapEligibleSubTotal() {
        Assert.assertTrue(gg_checkoutPage.isNonSnapEligibleSubTotalDisplayed());
    }

    @And("^verify search button is displayed$")
    public void verifySearchButtonIsDisplayed() {
        Assert.assertTrue(gg_checkoutPage.isSearchButtonDisplayed());
    }

    @And("^verify My Cart is displayed$")
    public void verifyMycartIsDisplayed() {
        Assert.assertTrue(gg_checkoutPage.isMyCartIconDisplayed());
    }

    @And("^click On Confirm CVV$")
    public void clickOnConfirmCVV() {
        gg_checkoutPage.clickConfirmCVV();
    }

    @And("^click On Choose And Confirm date$")
    public void clickOnChooseAndConfirmDate() {
        gg_checkoutPage.clickOnChooseAndTime();
    }

    @Then("^Enter CVV$")
    public void enterCVV() throws IOException {
        String item = ThreadLocalHelper.testCaseData.get().get("CVV");
        gg_checkoutPage.enterCVV(item);
        gg_checkoutPage.clickOnConfirmCVVArrow();
    }

    @And("^verify Estimated total is not displayed$")
    public void verifyEstimatedTotalNotDisplayed() {
        Assert.assertFalse(gg_checkoutPage.isEstimatedTotalDisplayed());
    }

    @And("^verify Promo Codes is not displayed$")
    public void verifyPromoCodesNotDisplayed() {
        Assert.assertFalse(gg_checkoutPage.isPromoCodesDisplayed());
    }

    @And("^verify Global Substitution is not displayed$")
    public void verifyGlobalSubstitutionNotDisplayed() {
        Assert.assertFalse(gg_checkoutPage.isGlobalSubstitutionDisplayed());
    }

    @And("^verify steppers is not displayed$")
    public void verifySteppersNotDisplayed() {
        Assert.assertFalse(gg_checkoutPage.isStepperDisplayed());
    }

    @Then("^verify CVV validation displayed on checkout page$")
    public void verifyCVVValidationDisplayed() throws IOException {
        Assert.assertTrue(gg_checkoutPage.isCVVValidationDisplayed(), "CVV Validation is not displayed on checkout page");
    }

    @And("^verify Place Order Button Is available$")
    public void verifyPlaceOrderButtonIsAvailable() {
        gg_checkoutPage.isPlaceOrderButtonAvailable();
    }

    @And("^click On Done Button$")
    public void clickOnDoneButton() {
        gg_checkoutPage.clickOnDoneButton();
    }

    @And("^click On Back Button to navigate to My Cart Screen$")
    public void clickOnBackButtonToMyCartScreen() {
        gg_checkoutPage.clickOnBackButtonToMyCartScreen();
    }

    @And("^click On View Details Button$")
    public void clickOnViewDetailsButton() {
        gg_checkoutPage.clickOnViewDetailsButton();
    }

    @And("^click On Edit Cart link$")
    public void clickOnEditCartLink() {
        gg_checkoutPage.clickOnEditCartLink();
    }

    @Then("^search To Add an Item$")
    public void searchToAddAnItem() throws IOException {
        String item = ThreadLocalHelper.testCaseData.get().get("SEARCH_KEYWORD");
        gg_checkoutPage.searchToAddItems(item);
    }

    @And("^click On Cancel Button$")
    public void clickOnCancelButton() {
        gg_checkoutPage.clickCancelButton();
    }

    @And("^change to required Delivery time$")
    public void clickOnRequiredDeliveryTime() {
        gg_checkoutPage.clickRequiredDeliveryTime();
    }

    @And("^click On changeTime$")
    public void changeTime() {
        gg_checkoutPage.scrollUpToChangeTime();
    }

    @And("^click On OrderInfoLink$")
    public void clickOrderInfoLink() {
        gg_checkoutPage.clickOnOrderInfoLink();
    }

    @And("^click On cancel order button$")
    public void clickOnCancelOrderButton() {
        gg_checkoutPage.clickOnCancelOrderButton();
    }

    @And("^click On Confirm Changes button$")
    public void clickOnConfirmChangesButton() {
        gg_checkoutPage.clickConfirmChangeButton();
    }

    @Then("^click On Update Order Link$")
    public void clickOnUpdateOrderLink() {
        gg_checkoutPage.clickOnUpdateOrderLink();
    }

    @And("^click On cancel order Pop Upbutton$")
    public void clickOnCancelOrderPopUpButton() {
        gg_checkoutPage.clickOnCancelOrderButtonPopUp();
    }

    @And("^click On Back button to go back to Home Page$")
    public void clickOnBackButton() {
        gg_checkoutPage.clickOnBackToOrderButton();
    }

    @Then("^search To Add an Item in Edit Cart$")
    public void searchProductInEditCart() throws IOException {
        String item = ThreadLocalHelper.testCaseData.get().get("SEARCH_KEYWORD");
        gg_checkoutPage.searchToAddItemsInEditCart(item);
    }

    @Then("^enter \"([^\"]*)\" in the credit card name field")
    public void enterNameInCreditCard(String name) {
        gg_checkoutPage.enterNameInCreditCard(name);
    }

    @Then("^enter \"([^\"]*)\" in the credit card number field")
    public void enterCreditCardNumber(String number) {
        gg_checkoutPage.enterCreditCardNumber(number);
    }

    @Then("^enter \"([^\"]*)\" in the credit card expiration field")
    public void enterCreditCardExpirationDate(String date) {
        gg_checkoutPage.enterCreditCardExpirationDate(date);
    }

    @Then("^enter \"([^\"]*)\" in the credit card billing zipcode field")
    public void enterBillingZipcode(String billing) {
        gg_checkoutPage.enterCreditCardBillingZipCode(billing);
    }

    @Then("^enter \"([^\"]*)\" in the cvv and click continue")
    public void enterCVV(String cvv) {
        gg_checkoutPage.enterCVV(cvv);
    }

    @Then("^click continue to review order")
    public void clickContinueToReviewOrder() {
        gg_checkoutPage.clickContinueToReviewOrder();
    }

    @Then("^click on place order button")
    public void clickPlaceOrderBtn() {
        gg_checkoutPage.clickPlaceOrderBtn();
    }

    @Then("^verify Edit Order Page is shown")
    public void verifyEditOrderPage() {
        gg_checkoutPage.verifyEditOrderPage();
        Assert.assertEquals(gg_checkoutPage.getEditOrderTitleText(), "Edit your order", "Edit order title is incorrect!");
    }

    @Then("^click on edit cart and preferences")
    public void clickEditCartAndPreferences() {
        gg_checkoutPage.clickEditCartAndPreferences();
    }

    @Then("^click on back button in edit cart screen$")
    public void clickBackBtnInEditCartScreen() {
        gg_checkoutPage.clickBackBtnInEditCartScreen();
    }

    @Then("^search for \"([^\"]*)\" in edit cart screen")
    public void searchForAnItemInEditCartScreen(String item) {
        gg_checkoutPage.searchForAnItemInEditCartScreen(item);
    }

    @Then("^click on edit order button in orders page")
    public void clickEditOrderBtnInOrdersPage() {
        gg_checkoutPage.clickEditOrderBtnInOrdersPage();
    }

    @Then("^click on view order button in orders page")
    public void clickViewOrderBtnInOrdersPage() {
        gg_checkoutPage.clickViewOrderBtnInOrdersPage();
    }

    @Then("^verify Past Purchases Button is displayed")
    public void verifyPastPurchasesButtonIsDisplayed() {
        Assert.assertTrue(gg_checkoutPage.verifyPastPurchasesButtonIsDisplayed(), "Shop Past Purchases Button is not displayed");
    }

    @Then("^verify cart is increased after adding a searched item in edit cart screen")
    public void verifyCartIncreasedAfterAddingSearchedItemInEditCartScreen() throws InterruptedException {
        int oldCartCountHeader = Integer.parseInt(gg_checkoutPage.getCartCountInEditCart());
        int oldItemsCount = Integer.parseInt(gg_checkoutPage.getItemsCountInEditCart());
        double oldEstimatedSubTotal = Double.parseDouble(gg_checkoutPage.getEstimatedSubTotalInEditCart());
        searchForAnItemInEditCartScreen("Butter");
        gg_productDetailsPageSteps.addProductsToCart(2);
        gg_checkoutPage.navigateBackToProductListingPageInEditScreen();
        gg_searchSteps.clickCancelSearch();
        gg_checkoutPage.verifyPastPurchasesButtonIsDisplayed();
        int newCartCountHeader = Integer.parseInt(gg_checkoutPage.getCartCountInEditCart());
        int newItemsCount = Integer.parseInt(gg_checkoutPage.getItemsCountInEditCart());
        double newEstimatedSubTotal = Double.parseDouble(gg_checkoutPage.getEstimatedSubTotalInEditCart());
        Assert.assertTrue(oldCartCountHeader < newCartCountHeader && oldItemsCount < newItemsCount && oldEstimatedSubTotal < newEstimatedSubTotal, "Cart was not increased after adding a searched item");
    }

    @Then("^verify cart is increased after adding an item in edit cart screen")
    public void verifyCartIncreasedAfterAddingAnItemInEditCartScreen() throws InterruptedException {
        gg_checkoutPage.waitForLoaderToDisappear();
        int oldCartCountHeader = Integer.parseInt(gg_checkoutPage.getCartCountInEditCart());
        int oldItemsCount = Integer.parseInt(gg_checkoutPage.getItemsCountInEditCart());
        double oldEstimatedSubTotal = Double.parseDouble(gg_checkoutPage.getEstimatedSubTotalInEditCart());
        gg_checkoutPage.addAnItemInEditCart();
        int newCartCountHeader = Integer.parseInt(gg_checkoutPage.getCartCountInEditCart());
        int newItemsCount = Integer.parseInt(gg_checkoutPage.getItemsCountInEditCart());
        double newEstimatedSubTotal = Double.parseDouble(gg_checkoutPage.getEstimatedSubTotalInEditCart());
        Assert.assertTrue(oldCartCountHeader < newCartCountHeader && oldItemsCount < newItemsCount && oldEstimatedSubTotal < newEstimatedSubTotal, "Cart was not increased after adding a searched item");

    }

    @And("User see option to see change the zip code")
    public void userSeeOptionToSeeChangeTheZipCode() {
        gg_checkoutPage.verifyZipcode();
    }

    @When("user click Edit option to change pickup store")
    public void userClickEditOptionToChangePickupStore() {
        gg_checkoutPage.clickEditForStoreChange();
    }

    @And("user see pick up order info page")
    public void userSeePickUpOrderInfoPage() {
        gg_checkoutPage.verifyOrderInfoPage();
    }

    @And("user see map and stores selected")
    public void userSeeMapAndStoresSelected() {
        gg_checkoutPage.verifyMapPage();
    }

    @When("User updates zipcode")
    public void userUpdatesZipcode() {
        gg_checkoutPage.updateZipcode();
    }

    @Then("user is seeing the pop-up")
    public void userIsSeeingThePopUp() {
        gg_checkoutPage.verifyPopup();
    }

    @When("user taps on continue")
    public void userTapsOnContinue() {
        gg_checkoutPage.tapContinue();
    }

    @Then("user is taken to the cart")
    public void userIsTakenToTheCart() {
    }

    @When("user taps on Cancel")
    public void userTapsOnCancel() {
        gg_checkoutPage.tapBack();
    }

    @Then("user see Popup closed")
    public void userSeePopupClosed() {
    }


    @And("user closes slot selection sheet in checkout screen")
    public void closeSlotSelection() {
        gg_checkoutPage.closeSlotSelectionSheet();
    }

    @And("user chooses {string} when confirm changes dialog is displayed in checkout screen")
    public void chooseOptionInConfirmChanges(String desiredChoice) {
        gg_checkoutPage.chooseConfirmChanges(desiredChoice);
    }

    @And("user closes payment sheet in checkout screen")
    public void closePayment() {
        gg_checkoutPage.closePaymentSheet();
    }

    @When("user selects {string} as payment method in checkout screen")
    public void clickOnSNAPEBTOption(String desiredPaymentOption) {
        switch (desiredPaymentOption.toUpperCase()) {
            case "CREDIT CARD":
                // To-Do: add flow to credit card payment here
                break;
            case "SNAP-EBT":
            case "SNAP EBT":
                if (Boolean.parseBoolean(ThreadLocalHelper.testCaseData.get().get("SNAP_ENABLED")))
                    gg_checkoutPage.clickOnSNAPEBT();
                break;
        }
    }

    @And("user closes contact info sheet in checkout screen")
    public void closeContactInfo() {
        gg_checkoutPage.closeContactInfoSheet();
    }

    @Then("verify non-snap eligible items sheet in checkout screen")
    public void verifyNonSNAPEligibleItemsSheet() {
        if (Boolean.parseBoolean(ThreadLocalHelper.testCaseData.get().get("SNAP_ENABLED"))) {
            Map<String, Object> nonSnapElementsMap = gg_checkoutPage.getElementsPresenceOrTextInNonSnapEligibleItemsSheet();
            Assert.assertTrue(((String) nonSnapElementsMap.get("NON_SNAP_ELIGIBLE_SHEET_HEADER_TEXT")).contains("Non-SNAP eligible items ("), "Header is not correct in Non-SNAP eligible items sheet!!");
            if (driver.getPlatformName().equalsIgnoreCase("ANDROID"))
                Assert.assertEquals((String) nonSnapElementsMap.get("NON_SNAP_ELIGIBLE_SHEET_SUB_HEADER_TEXT"), "You can pay for these items at pickup with a debit or credit card, or remove them now.", "Sub header is not correct in Non-SNAP eligible items sheet!!");
            Assert.assertTrue((Boolean) nonSnapElementsMap.get("NON_SNAP_ELIGIBLE_SHEET_REMOVE_ALL"), "'Remove all items' button is not displayed in Non-SNAP eligible items sheet!!");
            Assert.assertTrue((Boolean) nonSnapElementsMap.get("NON_SNAP_ELIGIBLE_SHEET_CLOSE"), "Close icon is not displayed in Non-SNAP eligible items sheet!!");
            Assert.assertTrue((Boolean) nonSnapElementsMap.get("NON_SNAP_ELIGIBLE_SHEET_CATEGORIES"), "Categories are not displayed in Non-SNAP eligible items sheet!!");
            Assert.assertTrue((Boolean) nonSnapElementsMap.get("NON_SNAP_ELIGIBLE_SHEET_PRODUCTS"), "Products are not displayed in Non-SNAP eligible items sheet!!");
        }
    }

    @Then("verify non-snap eligible SCP items sheet in checkout screen")
    public void verifyNonSNAPEligibleSCPItemsSheet() {
        Map<String, Object> nonSnapElementsMap = gg_checkoutPage.getElementsPresenceOrTextInNonSnapEligibleItemsSheet();
        Assert.assertTrue(((String) nonSnapElementsMap.get("NON_SNAP_ELIGIBLE_SHEET_HEADER_TEXT")).contains("Non-SNAP eligible items ("), "Header is not correct in Non-SNAP eligible items sheet!!");
        if (driver.getPlatformName().equalsIgnoreCase("ANDROID"))
            Assert.assertEquals((String) nonSnapElementsMap.get("NON_SNAP_ELIGIBLE_SHEET_SUB_HEADER_TEXT"), "You can pay for these items at pickup with a debit or credit card, or remove them now.", "Sub header is not correct in Non-SNAP eligible items sheet!!");
        Assert.assertTrue((Boolean) nonSnapElementsMap.get("NON_SNAP_ELIGIBLE_SHEET_REMOVE_ALL"), "'Remove all items' button is not displayed in Non-SNAP eligible items sheet!!");
        Assert.assertTrue((Boolean) nonSnapElementsMap.get("NON_SNAP_ELIGIBLE_SHEET_CLOSE"), "Close icon is not displayed in Non-SNAP eligible items sheet!!");
        Assert.assertTrue((Boolean) nonSnapElementsMap.get("NON_SNAP_ELIGIBLE_SHEET_CATEGORIES"), "Categories are not displayed in Non-SNAP eligible items sheet!!");
        Assert.assertTrue((Boolean) nonSnapElementsMap.get("NON_SNAP_ELIGIBLE_SHEET_PRODUCTS"), "Products are not displayed in Non-SNAP eligible items sheet!!");
    }

    @And("user swipes partially across a product card in non-snap eligible items sheet")
    public void swipePartiallyAcrossAProductCardInNonSnapEligible() {
        if (Boolean.parseBoolean(ThreadLocalHelper.testCaseData.get().get("SNAP_ENABLED")))
            gg_checkoutPage.swipePartiallyAcrossTheFirstProductInNonSnapEligibleItemsSheet();
    }

    @Then("verify the categories in non-snap eligible items sheet are sorted alphabetically")
    public void verifyTheCategoriesInCartAreSortedAlphabeticallyIn() {
        if (Boolean.parseBoolean(ThreadLocalHelper.testCaseData.get().get("SNAP_ENABLED"))) {
            List<String> expSortOrder = gg_checkoutPage.getCategoriesFromNonSnapEligibleItemsSheet();
            Assert.assertEquals(gg_checkoutPage.getCategoriesFromNonSnapEligibleItemsSheet().stream().sorted().collect(Collectors.toList()), expSortOrder, "Categories in non-snap eligible sheet are not sorted alphabetically!!");
        }
    }

    @And("get and store items count in non-snap eligible items sheet")
    public void getItemsCountNonSnap() {
        if (Boolean.parseBoolean(ThreadLocalHelper.testCaseData.get().get("SNAP_ENABLED")))
            ThreadLocalHelper.testCaseData.get().put("ITEMS_COUNT_NON_SNAP_ELIGIBLE", String.valueOf(gg_checkoutPage.getItemsCountFromHeaderInNonSnapEligibleItemsSheet()));
    }

    // Make sure to use step 'get and store items count in non-snap eligible items sheet' before this step
    @Then("verify items count in non-snap eligible items sheet is {string} by {int}")
    public void verifyItemIsnList(String increasedDecreased, int changeQty) {
        if (Boolean.parseBoolean(ThreadLocalHelper.testCaseData.get().get("SNAP_ENABLED"))) {
            int previousCount = Integer.valueOf(ThreadLocalHelper.testCaseData.get().get("ITEMS_COUNT_NON_SNAP_ELIGIBLE"));
            switch (increasedDecreased.toUpperCase()) {
                case "INCREASED":
                    Assert.assertEquals(gg_checkoutPage.getItemsCountFromHeaderInNonSnapEligibleItemsSheet(), previousCount + changeQty, "Count of items in non-snap eligible items sheet is not increased");
                    break;
                case "DECREASED":
                    Assert.assertEquals(gg_checkoutPage.getItemsCountFromHeaderInNonSnapEligibleItemsSheet(), previousCount - changeQty, "Count of items in non-snap eligible items sheet is not decreased");
                    break;
            }
        }
    }

    @And("user closes non-snap eligible items sheet in checkout screen")
    public void closeNonSnapEligible() {
        if (Boolean.parseBoolean(ThreadLocalHelper.testCaseData.get().get("SNAP_ENABLED")))
            gg_checkoutPage.closeNonSnapEligibleItemsSheet();
    }

    @And("user clicks back button in checkout screen to go back to cart screen")
    public void clickBackInCheckout() {
        gg_checkoutPage.clickBackButtonInCheckout();
    }

    @And("user clicks remove button on product card in non-snap eligible items sheet")
    public void clickOnTheRemoveButton() {
        if (Boolean.parseBoolean(ThreadLocalHelper.testCaseData.get().get("SNAP_ENABLED")))
            gg_checkoutPage.clickOnRemoveBtn();
    }

    @When("user clicks remove all items button in non-snap eligible items sheet")
    public void clickRemoveAllItemsNonSnapEligible() {
        if (Boolean.parseBoolean(ThreadLocalHelper.testCaseData.get().get("SNAP_ENABLED")))
            gg_checkoutPage.clickRemoveAllItemsNonSnapEligible();
    }

    @Then("verify non-snap eligible items sheet {string} displayed")
    public void verifyNonSnapEligibleSheetPresence(String desiredStatus) {
        if (Boolean.parseBoolean(ThreadLocalHelper.testCaseData.get().get("SNAP_ENABLED"))) {
            if (desiredStatus.contains("not")) {
                Assert.assertFalse(gg_checkoutPage.isRemoveAllItemsButtonDisplayedInNonSnapEligibleSheet(), "Non-SNAP eligible items sheet is displayed!!");
            } else {
                Assert.assertTrue(gg_checkoutPage.isRemoveAllItemsButtonDisplayedInNonSnapEligibleSheet(), "Non-SNAP eligible items sheet is not displayed!!");
            }
        }
    }

    @Then("verify category header in non-snap eligible items sheet is sticky in iOS platform")
    public void verifyCategoryHeaderIsSticky() {
        if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
            if (Boolean.parseBoolean(ThreadLocalHelper.testCaseData.get().get("SNAP_ENABLED"))) {
                Assert.assertTrue(gg_checkoutPage.isCategoryHeaderInNonSnapItemsSheetSticky(), "Category headers in Non-SNAP eligible items sheet is not sticky!!");
            }
        }
    }

    @And("user fills contact information in checkout")
    public void fillContactInformation() {
        gg_checkoutPage.fillContactInformation();
    }

    @And("user clicks on continue CTA on credit card form")
    public void clickContinueCTA() {
        gg_checkoutPage.clickContinueCTA();
    }

    @And("user selects next day in pickup options screen")
    public void selectNextDayPickupOption() throws InterruptedException {
        gg_checkoutPage.selectNextDayPickupOption();
    }

    @And("click on confirm changes in edit order screen")
    public void clickConfirmEditOrder() {
        gg_checkoutPage.clickConfirmEditOrder();
    }

    @And("click on continue shopping in edit cart screen")
    public void clickContinueShoppingAfterEditOrder() {
        gg_checkoutPage.clickContinueShoppingAfterEditOrder();
    }

    @Then("verify order has been saved in edit cart screen")
    public void verifyOrderSaved() {
        Assert.assertEquals(gg_checkoutPage.verifyOrderSaved(), "Your order has been saved!", "Order edit has not been saved after edit!");
    }

    @And("click on edit order link in thank you for your order page")
    public void clickOnEditOrderLinkInThankYouForYourOrderPage() {
        gg_checkoutPage.clickOnEditOrderLink();
    }

    @Then("verify search bar is displayed in edit cart screen")
    public void verifySearchBarDisplayedEditCart() {
        Assert.assertTrue(gg_checkoutPage.verifySearchBarDisplayedEditCart(), "Search for products in edit cart is not displayed");
    }

    @Then("verify confirm changes button is disable in edit order screen")
    public void verifyConfirmChangesButtonDisableEditOrder() {
        Assert.assertTrue(gg_checkoutPage.verifyConfirmChangesButtonDisableEditOrder(), "Confirm changes is enabled with empty cart!");
    }

    @And("click on cancel button in edit order screen")
    public void clickCancelButtonEditOrder() {
        gg_checkoutPage.clickCancelButtonEditOrder();
    }

    @And("click on discard changes in edit order screen")
    public void clickDiscardChangesEditOrder() {
        gg_checkoutPage.clickDiscardChangesEditOrder();
    }

    @And("user completes credit card form in checkout process")
    public void userCompletesCreditCardForm() {
        gg_checkoutPage.userCompletesCreditCardForm();
    }

    @And("user selects available pick-up slot in slot selection screen")
    public void selectAvailablePickUpSlot() {
        gg_checkoutPage.selectAvailablePickUpSlot();
    }


    @And("user selects pick-up slot on {string}th day in slot selection screen")
    public void selectLatestAvailablePickUpSlot(String day) {
        gg_checkoutPage.selectLatestPickupSlot(day);
    }

    @And("user clicks on payment in your order screen")
    public void clickPayment() {
        gg_checkoutPage.clickPayment();
    }

    @And("user clicks on contact info in your order screen")
    public void clickContactInfo() {
        gg_checkoutPage.clickContactInfo();
    }

    @And("user completes confirm CVV if visible in your order screen")
    public void completesConfirmCVVVisible() {
        gg_checkoutPage.completesConfirmCVVVisible();
    }

    @And("user enables order status updates in contact info screen")
    public void enableOrderUpdates() {
        gg_checkoutPage.enableOrderStatusUpdates();
    }

    @And("user changes the pickup store on my order screen")
    public void userChangesThePickupStoreOnMyOrderScreen() {
        gg_checkoutPage.changeThePickupStoreRetainingTheSameZipCode();
    }

    @And("user closes the slot selection contact info and payment info sheets")
    public void userClosesTheSlotSelectionContactInfoAndPaymentInfoSheets() {
        {
            closeSlotSelection();
            chooseOptionInConfirmChanges("YES");
            closeContactInfo();
            closePayment();
        }
    }

    @When("change pref to delivery")
    public void changePrefToDelivery() {
        gg_checkoutPage.changeOrderPref();
    }

    @And("change pref to Pickup")
    public void changePrefToPickup() {
        gg_checkoutPage.changeOrderPref();
    }

    @And("user clicks edit contact info on order screen")
    public void userClicksEditContactButton() {
        gg_checkoutPage.clickEditContactInfo();
    }


    @And("user goes back from cart to checkout screen")
    public void backBtnCartToCheckout() {
        gg_checkoutPage.backBtnCartToCheckout();
    }


    @Then("click on Continue to review order Or Save")
    public void click_on_continue_to_review_order() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        gg_checkoutPage.clickonContinue_to_review_order();
    }


}

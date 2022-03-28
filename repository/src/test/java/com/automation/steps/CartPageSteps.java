package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.util.WaitAction;
import com.automation.pages.CartPage;
import com.automation.pages.GG_CartPage;
import com.automation.pages.NewCheckoutPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CartPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    CartPage cartPage = new CartPage(driver);
    GG_CartPage ggCartpage = new GG_CartPage(driver);
    NewCheckoutPage newCheckoutPage = new NewCheckoutPage(driver);

    @Then("^shopping cart page is displayed$")
    public void shopping_cart_page_is_displayed() {
        cartPage.waitForCartPageDisplayed();
    }

    @And("^user clicks first item on cart page$")
    public void user_click_first_item_on_cart_page() throws Throwable {
        cartPage.clickOnFirstITem();
    }

    @And("^verify preference removed from cart page$")
    public void preference_removed_from_cart_page() {
        //cartPage.waitForCartPageDisplayed();
        //     org.junit.Assert.assertTrue(homePage.verifyPreferenceDisplayed(preference));
        //   Assert.assertTrue(cartPage.verifyInStoreButton(arg1));
        //   Assert.assertTrue(cartPage.isInstoreButtonDisplayed());


    }

    @When("^user empty shopping cart$")
    public void user_empty_shopping_cart() throws Throwable {
        new WaitAction(driver).waitForLoadingComplete();
        cartPage.emptyCart();
    }

    @Then("^shopping cart empty page is displayed$")
    public void shopping_cart_empty_page_is_displayed() throws Throwable {
        cartPage.waitForEmptyCartDisplayed();
    }

    @When("^user click check mark on shopping cart page$")
    public void user_click_check_mark_on_shopping_cart_page() throws Throwable {
        cartPage.closeCartPage();
    }

    @Then("^shopping cart shows (\\d+) as total number$")
    public void shopping_cart_shows_as_total_number(int arg1) throws Throwable {
        Thread.sleep(1000);
        Assert.assertTrue(cartPage.verifyTotalNumber(arg1));
    }

    @When("^user increase the (\\d+)st item quantity by (\\d+) on shopping cart page$")
    public void userIncreaseTheStItemQuantityByOnShoppingCartPage(int item, int quantity) {
        cartPage.increaseItemQuantity(item, quantity);
        new WaitAction(driver).waitForLoadingComplete();
    }

    @And("^user clicks checkout button on cart page$")
    public void userClicksCheckoutButtonOnCartPage() {
        cartPage.clickCheckout();
    }

    @And("^user clicks back button on cart page$")
    public void userClicksBackButtonOnCartPage() {
        cartPage.clickBackCTACheckout();
    }


    @And("^user clicks Enter payment on Your order screen$")
    public void clickEnterPaymentOnYourOrderScreen() throws InterruptedException {
        cartPage.clickEnterPayment();
    }

    @When("^user click remove (\\d+)st on shopping cart page$")
    public void userClickRemoveStOnShoppingCartPage(int arg0) {
        cartPage.removeItem();
    }

    @When("^user click \"([^\"]*)\" button on (\\d+)st item on shopping cart page$")
    public void userClickButtonOnStItemOnShoppingCartPage(String arg0, int arg1) throws Throwable {
        cartPage.clickChangeQuantityButtonOnItem(arg0, arg1);
    }

    @And("^user clicks increase button for (\\d+) times on cart page$")
    public void userClicksIncreaseButtonForTimesOnCartPage(int arg0) {
        cartPage.clickSingleIncreaseMultipleTimes(arg0);
    }

    @And("^verify shopping cart is not empty$")
    public void verifyShoppingCartIsNotEmpty() {
        Assert.assertTrue(cartPage.cartNotEmpty());

    }

    @And("^checkout button is disabled on shopping cart$")
    public void checkoutButtonIsDisabledOnShoppingCart() {
        Assert.assertFalse(cartPage.checkoutButtonEnabled());
    }

    @And("^checkout button is enabled on the shopping cart$")
    public void checkoutButtonIsEnabledOnTheShoppingCart() {
        Assert.assertTrue(cartPage.checkoutButtonEnabled());
    }

    @And("^estimation total information icon is displayed$")
    public void estimationTotalInformationIconIsDisplayed() {
        cartPage.waitForEstimationTotalInformationIconDisplayed();
    }

    @And("^user clicks on estimation total information icon$")
    public void clickEstimationTotalInformationIcon() {
        cartPage.clickEstimationTotalInformationIcon();
    }

    @And("^user clicks on estimated rewards card savings information icon$")
    public void clickEstimatedRewardSavingsInformationIcon() {
        cartPage.clickEstimatedRewardSavingsInformationIcon();
    }

    @Then("^\"Estimated Total\" text is displayed$")
    public void estimationTotalTextisDisplayed() {
        cartPage.waitForEstimationTotalTextisDisplayed();
    }

    @Then("^\"Est. total\" text is displayed$")
    public void estTotalTextisDisplayed() {
        cartPage.waitForEstTotalTextisDisplayed();
    }

    @Then("^\"Estimated Reward Card Savings\" text is displayed$")
    public void estimatedRewardCardSavingsTextisDisplayed() {
        cartPage.waitForEstimatedRewardCardSavingsTextisDisplayed();
    }

    @Then("^\"Estimated Club Card Savings\" text is displayed$")
    public void estimatedClubCardSavingsTextisDisplayed() {
        cartPage.waitForEstimatedClubCardSavingsTextisDisplayed();
    }

    @When("^user clicks navigate back to the cart page$")
    public void userClicksNavigateBackToCartPage() {
        cartPage.navigateBackToCartPage();
    }

    @And("^user change quantity to \"([^\"]*)\" number of items for all item in shopping cart$")
    public void userChangeQuantityToNumberOfItemsForAllItemInShoppingCart(int quantity) throws Throwable {
        // cartPage.changeAllItemQuantity(quantity);
        //   cartPage.increaseAllItemQuantity(quantity);
        // newCheckoutPage.incrementProductQuantityNew(quantity);
        ggCartpage.incrementProductQuantity(quantity);
    }

    @When("^user increase the all item quantity by (\\d+) on shopping cart page$")
    public void userIncreaseTheAllItemQuantityByOnShoppingCartPage(int step) {
        cartPage.increaseAllItemQuantity(step);
    }

    @When("^user decrease the all item quantity by (\\d+) on shopping cart page$")
    public void userDecreaseTheAllItemQuantityByOnShoppingCartPage(int step) {
        cartPage.decreaseAllItemQuantity(step);
    }

    @And("^Estimated Savings information icon is displayed on shopping cart page$")
    public void estimatedSavingsInformationIconIsDisplayedOnShoppingCartPage() {
        cartPage.waitForEstimatedSavingsTotalInformationIconDisplayed();
    }

    @When("^user swipe left to remove all item in shopping cart$")
    public void userSwipeLeftToRemoveAllItemInShoppingCart() {
        cartPage.swipeLeftToRemoveAllItem();
    }

    @When("^user swipe left to remove all items$")
    public void userSwipeLeftToRemoveAllItems() {
        cartPage.swipeLeftToRemoveItems();
    }

    @And("^user click remove icon in shopping cart$")
    public void userclickRemoveItemInShoppingCart() {
        cartPage.clickRemoveIcon();
    }

    @When("^user clicks global substitution checkbox on shopping cart page$")
    public void userClicksGlobalSubstitutionCheckboxOnShoppingCartPage() {
        cartPage.clickGlobalSubstitutionCheckbox();
    }

    @Then("^global substitution checkbox is enabled$")
    public void globalSubstitutionCheckboxIsEnabled() {
        Assert.assertTrue(cartPage.globalSubstitutionCheckboxEnabled());
        //value or enabled or checked
    }

    @Then("^global substitution checkbox is disabled$")
    public void globalSubstitutionCheckboxIsDisabled() {
        Assert.assertFalse(cartPage.globalSubstitutionCheckboxEnabled());
    }

    @And("^All item substitution checkbox is enabled$")
    public void allItemSubstitutionCheckboxIsEnabled() throws InterruptedException {
        Assert.assertTrue(cartPage.checkedNoSubstitutionForAllItems());
    }

    @And("^All item substitution checkbox is disabled$")
    public void allItemSubstitutionCheckboxIsDisabled() throws InterruptedException {
        Assert.assertFalse(cartPage.checkedNoSubstitutionForAllItems());
    }

    @And("^No Substitution text is displayed on the screen$")
    public void noSubstitutionTextIsDisplayedOnTheScreen() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            cartPage.containTextDisplayed("No substitutions");
        } else {
            //cartPage.textDisplayed("No Substitutions");
        }
    }

    @Then("^cart summary is displayed on the shopping cart page$")
    public void cartSummaryIsDisplayedOnTheShoppingCartPage() {
        cartPage.waitForCartSummaryDisplayed();
    }

    @Then("^verify substitutionPreference text is removed$")
    public void substitutionTextisRemovedfromCartPage() {

        cartPage.removedSubstituion();


    }

    @Then("^verify in-store Header on the shopping cart page$")
    public void inStoreHeaderatCartPage() {

        cartPage.verifyinStoreHeader();

    }

    @When("^user remove milk from cart page and back to home page$")
    public void cartMilkRemove() throws InterruptedException {
        cartPage.milkRemove();
    }

    @Then("^verify Done button is displayed in cart page$")
    public void verifyDoneButtonInCartPage() {
        cartPage.verifyDoneButtonInCartPage();
    }

    @When("^verify checkout is not enabled$")
    public void isnotEnabledCheckout() {
        cartPage.CheckoutIsEnable();
    }

    @When("^user incremental first milk to be thirty dollar in cart page$")
    public void cartPageFirstMilkIncremental() throws InterruptedException {
        cartPage.cartPageFirstMilkIncremental();
    }

    @Then("^verify change shopping method is displayed$")
    public void changeShoppingMethodDisplayed() {
        cartPage.changeShoppingMethodDisplayed();
    }

    @Then("^verify pay in store is displayed$")
    public void payInStore() {
        cartPage.payInStore();
    }

    @Then("^verify Pay In-Store is disabled for Empty Shopping cart$")
    public void payInStoreDisabledForEmptyCart() {
        cartPage.payInStoreDisabledForEmptyCart();
    }

    @When("^user tabs on change shopping method$")
    public void clickChangeShoping() {
        cartPage.clickChangeShoppingMethod();
    }

    @When("^user tabs on Pay in store$")
    public void clickPayInstore() {
        cartPage.clickpayInstore();
    }

    @When("^user verify checkout button is enabled$")
    public void verifyCheckoutIsEnabled() {
        cartPage.CheckoutIsEnabled();
    }

    @When("^user verify cart page is displayed$")
    public void cartPageVerification() throws InterruptedException {
        cartPage.myCartVerification();
    }


    @When("^user click on Save change button$")
    public void user_click_on_save_change_button() throws Throwable {
        cartPage.SaveChanges();
    }

    @When("^user click on Cart in Edit Order$")
    public void userClickOnCartInEditOrder() {
        cartPage.clickCartInEditOrder();
    }

    @When("^user click on Cart in Edit Order of cart page$")
    public void user_click_on_cart_in_edit_order_of_cart_page() throws Throwable {
        cartPage.clickCartInEditOrderofCartPage();
    }


    @When("^user click back on cart page$")
    public void userClickBackOnCartPage() {
        cartPage.clickBackInEditOrder();
    }

    @Then("^after clicking back button user see Edit Order page$")
    public void after_clicking_back_button_user_see_edit_order_page() throws Throwable {
        cartPage.VerifyEditOrderPage();
    }


    @And("^note to personal shopper search box should be displayed$")
    public void noteToPersonalShopperSearchBox() {
        cartPage.noteToPersonalShopperSearchBox();
    }

    @When("^enter \"([^\"]*)\" text in search box$")
    public void enterNoteToPersonalShopper(String arg0) {
        cartPage.enterNoteToPersonalShopper(arg0);
    }

    @Then("^verify \"([^\"]*)\" note is added in the Preferences search box$")
    public void verifyNoteToPersonalShopper(String arg0) {
        cartPage.verifyNoteToPersonalShopper(arg0);
    }

    @Then("^verify \"([^\"]*)\" radio button selected$")
    public void verifyRadioButtonSelected(String arg0) {
        cartPage.verifyRadioButtonSelected(arg0);
    }

    @Then("^verify Save button is enabled$")
    public void verifySaveButtonEnabled() {
        cartPage.verifySaveButtonEnabled();
    }

    @Then("^verify Cancel button is enabled$")
    public void verifyCancelButtonEnabled() {
        cartPage.verifyCancelButtonEnabled();
    }

    @And("^user scroll down to cart summary$")
    public void userScrollDownToCartsummary() {
        cartPage.scrollDownToCartSummary();
    }

    @Then("^verify Clipped Deals Banner is not showing on My Cart")

    public void verifyClippedDealBannerVisibility() throws Throwable {


        cartPage.verifyClippedBannerText();

    }

    @Then("^user removes the item from the cart")
    public void userRemoveItemsFromCart() throws InterruptedException {
        cartPage.removeItems();
    }

    @And("^verify Checkout with EBT card text is displayed on the screen$")
    public void checkoutwithEBTTextIsDisplayedOnTheScreen() {
        cartPage.containTextDisplayed("Checkout with EBT card");

    }

    @And("^verify Checkout with EBT card is disabled on shopping cart$")
    public void checkoutEBTButtonIsDisabledOnShoppingCart() {
        Assert.assertFalse(cartPage.checkoutEBTButtonEnabled());
    }

    @When("^user taps on the Checkout with EBT link$")
    public void userClickCheckoutEBTLink() {
        cartPage.clickCheckoutEBTLink();
    }

    @Then("^verify a sheet opens up and close the sheet$")
    public void snapSheetOpensandClose() {
        // cartPage.waitForCartPageDisplayed();
        cartPage.waitForSNAPSheetDisplayed();
    }

    /*  @And("^user removes all the items from shopping cart$")
      public void removeAllItemsfromShoppingCart() throws InterruptedException {
          cartPage.changeAllItemQuantity(quantity);
          cartPage.removeAllItems();
      }*/
    @Then("^user clicks on first cart item$")
    public void clickFirstCartItem() {
        cartPage.clickFirstCartItem();
    }


    @And("^user changes quantity to \"([^\"]*)\" number of items for all item in pdp$")
    public void userChangePDPQuantity(String quantity) throws InterruptedException {
        //  cartPage.changeAllItemQuantity(quantity);
        cartPage.changePDPItemQuantity(quantity);


    }

    @Then("^click on Close button Add Address window$")
    public void click_on_close_button_add_address_window() throws InterruptedException {
        cartPage.closeAddAddressWindow();
    }

    @Then("^Verify Driver Tip Section is displayed on Checkout Landing page$")
    public void verify_driver_tip_section_is_displayed_on_checkout_landing_page() throws Throwable {
        cartPage.DriverTipIsDisplayed();
    }


    @And("^User Click on Change Link near to Driver Tip Section$")
    public void user_click_on_change_link_near_to_driver_tip_section() throws Throwable {
        cartPage.clickonChangeLinkneartoDriverTip();
    }

    @Then("^Verify Add a Custom Tip Window is present$")
    public void verify_add_a_custom_tip_window_is_present() throws Throwable {
        cartPage.VerifyAddCustomTipWindow();
    }

    @When("^User Clicks on Custom Tip Radio Button$")
    public void user_clicks_on_custom_tip_radio_button() throws Throwable {
        cartPage.ClickonCustomTipRadioButton();
    }

    @Then("^Verify Custom Tip Field will be present to enter Tip Amount$")
    public void verify_custom_tip_field_will_be_present_to_enter_tip_amount() throws Throwable {
        cartPage.VerifyCustomTipField();
    }

    @When("^User enter \"([^\"]*)\" more than cart total amount in custom tip field$")
    public void user_enter_something_more_than_cart_total_amount_in_custom_tip_field(String strArg1) throws Throwable {
        cartPage.EnterAmountinCustomTipField(strArg1);
    }


    @Then("^Verify User gets the error Message \"([^\"]*)\"$")
    public void verify_user_gets_the_error_message_something(String strArg1) throws Throwable {
        cartPage.VerifyErrorMessageTipAmount(strArg1);
    }


    @And("^Verify Cart Total is greater than \"([^\"]*)\" dollar$")
    public void verify_cart_total_is_greater_than_something_dollar(String strArg1) throws Throwable {
        cartPage.VerifyCartTotal(strArg1);
    }


    @Then("^Verify User gets the toast Message \"([^\"]*)\"$")
    public void verify_user_gets_the_toast_message_something(String strArg1) throws InterruptedException {
        cartPage.VerifyToastMessage(strArg1);
    }

    @And("^change quantity to \"([^\"]*)\" number of items for all item in cart$")
    public void change_quantity_to_something_number_of_items_for_all_item_in_cart(String strArg1) throws Throwable {
        cartPage.changeAllItemQuantity(strArg1);

    }


    @And("^user changes the quantity to \"([^\"]*)\" for cart item$")
    public void userChangeQuantityForCartItem(int quantity) throws InterruptedException {
        ggCartpage.changeQuantity(quantity);
    }


    @Then("^user decrease the all item quantity on shopping cart page$")
    public void userDecreaseTheAllItemQuantityOnShoppingCartPage() {
        ggCartpage.decrementProductQuantity();

    }

}



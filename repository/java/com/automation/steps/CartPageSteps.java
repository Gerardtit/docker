package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.CartPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;

public class CartPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    CartPage cartPage = new CartPage(driver);

    @Then("^shopping cart page is displayed$")
    public void shopping_cart_page_is_displayed() {
        cartPage.waitForCartPageDisplayed();
    }

    @When("^user empty shopping cart$")
    public void user_empty_shopping_cart() throws Throwable {
        cartPage.waitForLoadingComplete();
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
        cartPage.waitForLoadingComplete();
    }

    @And("^user clicks checkout button on cart page$")
    public void userClicksCheckoutButtonOnCartPage() {
        cartPage.clickCheckout();
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

    @And("^user change quantity to \"([^\"]*)\" number of items for all item in shopping cart$")
    public void userChangeQuantityToNumberOfItemsForAllItemInShoppingCart(String quantity) {
        cartPage.changeAllItemQuantity(quantity);
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
            cartPage.textDisplayed("No Substitutions");
        }
    }

    @Then("^cart summary is displayed on the shopping cart page$")
    public void cartSummaryIsDisplayedOnTheShoppingCartPage() {
        cartPage.waitForCartSummaryDisplayed();
    }
}

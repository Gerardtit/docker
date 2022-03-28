package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_CartPage;
import com.automation.pages.GG_MyCartPage;
import com.automation.pages.GG_ProductsListingPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GG_MyCartSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_MyCartPage myCartPage = new GG_MyCartPage(driver);
    public GG_CartPage gg_cartPage = new GG_CartPage(driver);
    public GG_ProductsListingPage listpage = new GG_ProductsListingPage(driver);
    int itemsCountBeforeAddingProduct;


    public String getCurrentBanner() {
        return driver.getCapabilities().getCapability("banner").toString();
    }

    public String getCurrentEnv() {
        return driver.getCapabilities().getCapability("env").toString();
    }


    @Then("^verify My Cart is Displayed$")

    public void verifyMyCartScreenTitleIsDisplayed() {
        Assert.assertTrue(myCartPage.isMyCartDisplayed());
    }

    @When("^go back to edit order page$")
    public void goBackToEditOrderPage() {
        myCartPage.goBackToEditOrderPage();
    }

    @When("^click on My Cart Icon$")
    public void clickOnNavigationArrow() {
        myCartPage.clickOnMyCart();
    }

    @Then("^click on delivery/pickup button on mycart")
    public void clickOnDeliveryPickUpButton() {
        myCartPage.clickOnDeliveryPickUp();
    }

    @When("^click on Estimated Total info button")
    public void clickOnEstimatedTotal() {
        myCartPage.clickOnEstimatedTotal();
    }

    @And("^clear cart items")
    public void clearCartItems() {
        myCartPage.clearCartItems();
    }

    @And("^clear cartV2 items")
    public void clearCartV2Items() {
        myCartPage.clearCartV2Items();
    }

    @Then("^click on Checkout Button$")
    public void clickOnCheckOutButton() {
        myCartPage.waitForLoaderToDisappear();
        myCartPage.clickOnCheckoutButton();
        myCartPage.waitForLoaderToDisappear();
    }

    @Then("^verify Estimated Total screen text")
    public void verifyEstimatedTotalScreenText() {
        Assert.assertTrue(myCartPage.getTextFromEstimatedTotalScreen().contains("Estimated"));
    }

    @When("^click done on Estimated Total screen")
    public void clickDoneOnEstimatedTotal() {
        myCartPage.clickDoneOnEstimatedTotal();
    }

    @And("^verify My Cart Screen Title is Displayed$")
    public void verifyMyCartIsDisplayed() {
        Assert.assertTrue(myCartPage.isNavigatedToMyCartScreen(), "My cart screen is not displayed");
    }

    @And("^verify count on cart Button$")
    public void verifyCountOnCartButton() {
        Assert.assertTrue(myCartPage.getItemsCountFromCart() >= 0);
    }

    @And("^verify zero count on cart Button$")
    public void verifyZeroCountOnCartButton() {
        Assert.assertTrue(myCartPage.getItemsCountFromCart() == 0, "Cart count is not zero");
    }

    @And("^verify my cart is not displayed$")
    public void verifyMyCartIsNotDisplayed() {
        Assert.assertFalse(myCartPage.verifyMyCartNotDisplayed());
    }


    @And("^get count of items from cart")
    public void getItemCountCartIcon() {
        itemsCountBeforeAddingProduct = myCartPage.getItemsCountFromCart();
    }

    @Then("^verify count of items after adding a product")
    public void verifyItemsCountAfterAdding() {
        Assert.assertTrue(myCartPage.getItemsCountFromCart() > itemsCountBeforeAddingProduct, "Item count in cart is not incremented");
    }

    @Then("^checkout button should be enabled$")
    public void verifyCheckoutEnabled() throws InterruptedException {
        Assert.assertTrue(myCartPage.isCheckoutEnabled(), "Checkout button is disabled");
    }

    @Then("^checkout button should be disabled$")
    public void verifyCheckoutDisabled() throws InterruptedException {
        Assert.assertFalse(myCartPage.isCheckoutEnabled(), "Checkout button is enabled");
    }

    @Then("^verify checkout button displayed")
    public void verifyCheckOutButtonDisplayed() {
        Assert.assertTrue(myCartPage.isCheckOutButtonDisplayed());
    }

    @And("^verify count card is incremented on adding new Item$")
    public void clickOnIncrementButton() {
        Assert.assertTrue(myCartPage.isCartCountIncremented());
    }

    @When("^click offer details on my cart page")
    public void clickOfferDetails() {
        myCartPage.clickOfferDetails();
    }

    @Then("^click on Checkout Button In Edit Cart$")
    public void clickOnCheckOutButtonInEditCart() {
        myCartPage.clickOnCheckoutButtonInEditCart();
    }

    @Then("^item should be added to the cart$")
    public void itemShouldBeAddedToTheCart() {

        int cartCountBeforeOps = (int) (myCartPage.getTestData().get("cartItems"));
        int cartCountAfterOps = myCartPage.getItemsCountFromCartAfterPerformingCartOps();
        Assert.assertEquals(cartCountBeforeOps < cartCountAfterOps, true, "The items are not getting added; Before adding item:" + cartCountBeforeOps + " After adding item:" + cartCountAfterOps);
    }

    @Then("^item should be removed from the cart$")
    public void itemShouldBeRemovedFromTheCart() {
        int cartCountBeforeOps = (int) (myCartPage.getTestData().get("cartItems"));
        int cartCountAfterOps = myCartPage.getItemsCountFromCartAfterPerformingCartOps();
        Assert.assertEquals(cartCountBeforeOps > cartCountAfterOps, true, "The items are not getting removed; Before removing item:" + cartCountBeforeOps + " After removing item:" + cartCountAfterOps);

    }

    @Then("^items in the cart should be unchanged$")
    public void itemsInTheCartShouldBeUnchanged() {
        int cartCountBeforeOps = (int) (myCartPage.getTestData().get("cartItems"));
        int cartCountAfterOps = myCartPage.getItemsCountFromCartAfterPerformingCartOps();
        Assert.assertEquals(cartCountBeforeOps, cartCountAfterOps, "The item count is not maintained Before :" + cartCountBeforeOps + " After :" + cartCountAfterOps);

    }

    @And("click on close button on my cart screen")
    public void clickOnCloseButtonOnMyCartScreen() {
        try {
            myCartPage.clickOnCloseButtonOnMyCartScreen();
        } catch (Exception e) {
            gg_cartPage.closeCartScreen();
        }

    }


    @Then("^verify title of screen is \"([^\"]*)\"$")
    public void verifyTitleOfScreen(String text) {
        myCartPage.verifyTitleOfScreen(text);
    }

    @Then("^verify quantity counter is present in Cart$")
    public void verifyQuantityCounterCartTitle() {
        myCartPage.verifyQuantityCounterCartTitle();
    }

    @And("click on close button on estimated sub total screen")
    public void clickOnCloseButtonOnEstimatedScreen() {
        myCartPage.clickDoneOnEstimatedTotal();

    }

    @And("remove an item from edit cart")
    public void removeItemFromEditCart() {
        myCartPage.removeFirstCard();
    }

}

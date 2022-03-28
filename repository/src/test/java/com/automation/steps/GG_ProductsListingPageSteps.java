package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_MyCartPage;
import com.automation.pages.GG_ProductDetailsPage;
import com.automation.pages.GG_ProductsListingPage;
import com.automation.pages.GG_RefinePage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GG_ProductsListingPageSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_ProductsListingPage gg_productsListingPage = new GG_ProductsListingPage(driver);
    public GG_ProductDetailsPage gg_productDetailsPage = new GG_ProductDetailsPage(driver);
    public GG_RefinePage gg_refinePage = new GG_RefinePage(driver);
    public GG_MyCartPage cartpage = new GG_MyCartPage(driver);

    @When("^filter by reward card specials")
    public void filterByRewardCardSpecials() {
        gg_productsListingPage.filterByRewardCardSpecials();
    }


    @When("^sort by price low to high")
    public void sortByPriceLowToHigh() {
        gg_productsListingPage.sortByPriceLowToHigh();
    }

    @When("^add and remove an item on products listing page and verify count of items after adding a product and removing item")
    public void addAProductToCartAndRemove() throws InterruptedException {
        Assert.assertTrue(gg_productsListingPage.addAProductToCartAndRemove(), "Product was added and removed from cart and count is incorrect");
    }

    @When("^add more than 20 counts of the same item on products listing page and verify that only 20 counts can be added")
    public void verifyMaxQuantity() throws InterruptedException {
        Assert.assertTrue(gg_productsListingPage.addMultipleProductCountsToCart(21), "User was able to add more than 20 counts of the product");
    }

    @When("^Navigate back to browse tab")
    public void navigateBackToBrowseTab() {
        gg_productsListingPage.navigateBackToBrowsetab();
    }

    @When("^user adds the item to cart using the Add Icon on product details page$")
    public void userAddsTheItemToCartUsingTheAddIconOnProductDetailsPage() throws InterruptedException {
        gg_productsListingPage.addProductIfAvailableUsingAddIcon();
    }

    @When("^user removes the item to cart using the '-' icon on product details page$")
    public void userRemovesTheItemToCartUsingTheIconOnProductDetailsPage() throws InterruptedException {
        gg_productsListingPage.removeProductUsingDecrementIcon();
    }

    @When("^user adds the item to cart using the '\\+' icon on product details page$")
    public void userAddsTheItemToCartUsingTheIconOnProductDetailsPage() throws InterruptedException {
        gg_productsListingPage.addProductIfAvailableUsingIncrementIcon();
    }

    @When("^add (\\d+) number of products on product listing page")
    public void addProducts(int productCount) throws InterruptedException {
        Assert.assertTrue(gg_productsListingPage.addMultipleProductCountsToCart(productCount), "There was a problem while adding product to cart");
    }


    @When("^add (\\d+) number of first products on product listing page")
    public void addFirstProducts(int productCount) throws InterruptedException {
        Assert.assertTrue(gg_productsListingPage.addMultipleProductFirstCountsToCart(productCount), "There was a problem while adding product to cart");
    }


    @And("click product card on products listing page")
    public void clickProductCardOnProductsListingPage() {
        gg_productsListingPage.clickProductCardOnProductsListingPage();
    }

    @And("refine the results by {string} the {string}")
    public void refineTheResultsByThe(String checkUncheckOptn, String optionName) {
        gg_refinePage.filterByDesiredOption(optionName, checkUncheckOptn);
    }

    @And("select the refine option for search")
    public void selectTheRefineOptionForSearch() {
        gg_refinePage.clickRefineButton();
    }

    @And("save the filter options in refine")
    public void saveTheFilterOptionsInRefine() {
        gg_refinePage.saveTheRefineFilterOptns();
    }
}

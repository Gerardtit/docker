package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_Deals_BOGOPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GG_Deals_BOGOSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_Deals_BOGOPage gg_deals_bogoPage = new GG_Deals_BOGOPage(driver);

    @And("^verify BOGO categories are displayed$")
    public void verifyBogoCategoryNamesDisplayed() {
        Assert.assertTrue(gg_deals_bogoPage.isBogoCategoryNamesDisplayed(), "BOGO category names are not displayed");
    }

    @And("^verify spinner is displayed on BOGO page until products load$")
    public void verifyLoaderDisplayedUntilProductsLoad() {
        Assert.assertTrue(gg_deals_bogoPage.isLoaderDisplayedUntilProductsLoad(), "Neither spinner was not displayed while product loads nor products were displayed after waiting");
    }

    @When("^swipe left on deal cards until 'See all' is displayed on BOGO page$")
    public void swipeLeftTillSeeAll() {
        gg_deals_bogoPage.swipeLeftTillSeeAll();
    }

    @When("^expand first available category on BOGO page$")
    public void clickOnProductCategoryToExpand() {
        gg_deals_bogoPage.clickOnProductCategory();
    }

    @Then("^verify BOGO products are in carousel view")
    public void verifyProductsCarouselView() throws InterruptedException {
        Assert.assertTrue(gg_deals_bogoPage.areBogoProductsInCarouselView(), "BOGO products are not in carousel view");
    }

    @And("^expand category verify BOGO products displayed$")
    public void expandCategoryAndVerifyBOGOProductsDisplayed() throws InterruptedException {
        Assert.assertTrue(gg_deals_bogoPage.expandCategoryVerifyBOGOProductCardsDisplayed(), "BOGO products are not displayed for any of the categories");
    }

    @And("^verify BOGO products displayed$")
    public void verifyBOGOProductsDisplayed() {
        Assert.assertTrue(gg_deals_bogoPage.isBOGOProductCardDisplayed(), "BOGO products are not displayed for given category");
    }

    @When("^add and remove an item on BOGO listing page and verify count of items after adding a item and removing item")
    public void addAProductToCartAndRemove() throws InterruptedException {
        Assert.assertTrue(gg_deals_bogoPage.addBogoProductToCartOnBogoListingPageAndRemove(), "Product was added and removed from cart and count is incorrect");
    }

    @When("^add more than 20 counts of the same item on BOGO listing page and verify that only 20 counts can be added")
    public void verifyMaxQuantity() throws InterruptedException {
        Assert.assertTrue(gg_deals_bogoPage.addMultipleBogoProductCountsToCartOnBogoListingPage(21), "User was able to add more than 20 counts of the product");
    }

    @When("^add \"([^\"]*)\" number of BOGO products on BOGO listing page and verify count on cart is increased")
    public void addBOGOProducts(int arg) throws InterruptedException {
        Assert.assertTrue(gg_deals_bogoPage.addMultipleBogoProductCountsToCartOnBogoListingPage(arg), "BOGO product was not added");
    }

    @When("^click on a BOGO product$")
    public void clickOnProductCard() {
        gg_deals_bogoPage.clickOnProductCard();
    }

    @Then("^verify BOGO product details page displayed$")
    public void verifyBOGOProductDetailsPageDisplayed() {
        Assert.assertTrue(gg_deals_bogoPage.isBOGOProductDetailsPageDisplayed(), "BOGO product details page is not displayed");
    }

    @When("^click view all related products link on BOGO product details page$")
    public void clickViewAllRelatedProductsLink() {
        gg_deals_bogoPage.clickViewAllRelatedProductsLink();
    }

    @Then("^verify BOGO related products page displayed$")
    public void verifyRelatedProductsPageDisplayed() {
        Assert.assertTrue(gg_deals_bogoPage.isRelatedProductsPageDisplayed(), "BOGO related products page is not displayed");
    }

    @Then("^add product on BOGO landing page and verify the count on BOGO detail page$")
    public void checkProductCountInBOGODealsLandingPageAndDetailsPage() throws InterruptedException {
        gg_deals_bogoPage.addProductOnBogoListingPageVerifySameCountOnDetailsPage();
    }

    @When("^click on 'See all' button under BOGO category$")
    public void clickOnSeeAllDeals() {
        gg_deals_bogoPage.clickOnSeeAllDealsButton();
    }

    @Then("^verify category detail page is displayed$")
    public void verifyCategoryDetailPageIsDisplayed() {
        Assert.assertTrue(gg_deals_bogoPage.isCategoryDetailPageDisplayed(), "Category details page is not displayed");
    }

    @When("^click BOGO offer link on product card$")
    public void clickBogoOfferLink() {
        gg_deals_bogoPage.clickOnBogoOfferLinkOnProductCard();
    }

    @When("^verify offer details page displayed$")
    public void verifyOfferDetailsPageDisplayed() {
        Assert.assertEquals(gg_deals_bogoPage.isOfferDetailsPageDisplayed(), true, "Offer details page is not displayed");
    }

    @When("^user clicks category \"([^\"]*)\" on BOGO page$")
    public void userClicksOnAisleList(String category) throws Throwable {
        gg_deals_bogoPage.clickItemOnAisleList(category);
    }

    @When("^add BOGO product on BOGO product details page and verify the cart count after adding")
    public void addItemInBogoDetailPage() throws InterruptedException {
        Assert.assertTrue(gg_deals_bogoPage.addBogoProductsOnBogoProductDetailPage(1), "Product was not added to cart");
    }

    @And("^expand the product category with deals \"([^\"]*)\" than (\\d+)$")
    public void expandTheProductCategoryWithDealsHavingDesiredCount(String dealsCategoryMatchOptn, int maxDealsCount) throws InterruptedException {
        gg_deals_bogoPage.expandTheProductCategoryWithDealsHavingDesiredCount(maxDealsCount, dealsCategoryMatchOptn);
    }


    @And("^user navigate back from Related Poducts$")
    public void navigateBackFromRelatedProductScreen() {
        gg_deals_bogoPage.navigateBackFromRelatedProductsPage();
    }


    @When("add {int} number of BOGO products on product details page and verify count on cart is increased")
    public void addProductOnBogoDetailPage(int productCount) throws InterruptedException {
        Assert.assertTrue(gg_deals_bogoPage.addBogoProductsOnBogoProductDetailPage(productCount), "Product with desired quantity was not added to cart");
    }

    @When("add more than 20 counts of the same product on BOGO product details page and verify that only 20 counts can be added")
    public void verifyMaxQuantityPDP() throws InterruptedException {
        Assert.assertTrue(gg_deals_bogoPage.addBogoProductsOnBogoProductDetailPage(21), "User was able to add more than 20 counts of same BOGO product");
    }

    @Then("decrement the product count from product details page and verify count on cart is decreased")
    public void removeProductAndVerifyCartCount() throws InterruptedException {
        gg_deals_bogoPage.decrementProductCountAndVerifyCountCart();
    }

    @When("verify user is able to more than 50 counts of BOGO products successfully")
    public void addFiftyOrMoreProductsOnBogoDetailPage() throws InterruptedException {
        Assert.assertTrue(gg_deals_bogoPage.addBogoProductsOnBogoProductDetailPage(20), "BOGO Product with desired quantity was not added to cart");
        Assert.assertTrue(gg_deals_bogoPage.addBogoProductsOnBogoProductDetailPage(20), "BOGO Product with desired quantity was not added to cart");
        Assert.assertTrue(gg_deals_bogoPage.addBogoProductsOnBogoProductDetailPage(20), "BOGO Product with desired quantity was not added to cart");
    }

}

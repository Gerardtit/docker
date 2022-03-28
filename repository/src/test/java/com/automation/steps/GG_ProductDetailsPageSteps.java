package com.automation.steps;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.*;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GG_ProductDetailsPageSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_ProductDetailsPage gg_productDetailsPage = new GG_ProductDetailsPage(driver);
    public GG_DashboardPageSteps dashboardPageSteps = new GG_DashboardPageSteps();
    public GG_BrowseSteps browsePage = new GG_BrowseSteps();

    @When("^add and remove an item on product details page and verify count of items after adding a product and removing item")
    public void addProductToCartAndRemove() throws InterruptedException {
        removeOutOfStockProducts();
        Assert.assertTrue(gg_productDetailsPage.addProductToCartAndRemove(), "Product was added and removed from cart and count is incorrect");
    }

    @When("^add more than 20 counts of the same item on product details page and verify that only 20 counts can be added")
    public void verifyMaxQuantity() throws InterruptedException {
        removeOutOfStockProducts();
        Assert.assertTrue(gg_productDetailsPage.addMultipleProductCountsToCart(21), "User was able to add more than 20 counts of the product");
    }

    @When("^add a product on product details page$")
    public void addProductToCart() throws InterruptedException {
//        removeOutOfStockProducts();
        gg_productDetailsPage.addMultipleProductCountsToCart(1);
//        Assert.assertTrue(gg_productDetailsPage.addMultipleProductCountsToCart(1), "Product was not added to cart");

    }

    @When("add {int} number of products on product details page")
    public void addProductsToCart(int arg) throws InterruptedException {

        GG_RefinePage gg_refinePage = new GG_RefinePage(driver);
        gg_refinePage.clickRefineButton();
        gg_refinePage.filterByDesiredOption("Include Out of Stock", "uncheck");
        gg_refinePage.saveTheRefineFilterOptns();

        Assert.assertTrue(gg_productDetailsPage.addMultipleProductCountsToCart(arg), "Product with desired count was not added to cart");
    }

    @When("^verify product details page is displayed$")
    public void verifyProductDetailsPageDisplayed() throws InterruptedException {
        Assert.assertTrue(gg_productDetailsPage.isProductDetailsPageDisplayed(), "Product details page was not displayed");
    }

    @When("^add products on product details page till cart value is equal to or more than 30 dollars$")
    public void addProductsCartTillCheckoutEnabled() throws InterruptedException {
        GG_MyCartPage gg_myCartPage = new GG_MyCartPage(driver);
        boolean checkOutEnabled = gg_myCartPage.isCheckoutEnabled();
        gg_myCartPage.clickOnCloseButtonOnMyCartScreen();
        if (checkOutEnabled) {
            return;
        } else {
            for (int i = 0; i < 20; i++) {
                gg_productDetailsPage.goBackToProductListingPage();
                Assert.assertTrue(gg_productDetailsPage.addMultipleProductCountsToCart(4), "Product was not added to cart");
                boolean checkOutEnabled1 = gg_myCartPage.isCheckoutEnabled();
                gg_myCartPage.clickOnCloseButtonOnMyCartScreen();
                if (checkOutEnabled1) {
                    break;
                }
            }
        }
    }

    @And("^go back to Home Page$")
    public void goBackToProductListingPage() {
        gg_productDetailsPage.goBackToHomePage();
    }

    @Then("^go back to Home Page from product details page$")
    public void goBackToHomePageFromProductDetailsPage() {
        gg_productDetailsPage.goBackToHomePageFromProductDetailsPage();
    }


    @Then("^user is able to see Add to Cart in PDP$")
    public void userAbleToSeeAddToCartInPdp() {
        gg_productDetailsPage.verifyAddToCartTextInPdp();
    }

    @And("click back button on product details page")
    public void clickBackButtonOnProductDetailsPage() {
        gg_productDetailsPage.clickBackButtonOnProductDetailsPage();

    }

    @And("add a product with {string} on product details page")
    public void addAProductWithOnProductDetailsPage(String productType) throws InterruptedException {
        gg_productDetailsPage.addMultipleProductCountsToCart(1, productType);

    }

    @And("view the product quantity on details page")
    public void viewTheProductQuantityOnDetailsPage() {
        gg_productDetailsPage.getProductQuantity();
    }

    @And("remove {int} number of products from product details page")
    public void removeNumberOfProductsFromProductDetailsPage(int decrementCnt) {
        gg_productDetailsPage.decrementProductQuantity(decrementCnt);
    }

    @When("add {int} number of discounted products on product details page")
    public void addDiscountedProductsToCart(int arg) throws InterruptedException {
        GG_RefinePage gg_refinePage = new GG_RefinePage(driver);
        gg_refinePage.clickRefineButton();
        gg_refinePage.filterByDesiredOption("Include Out of Stock", "uncheck");
        gg_refinePage.filterByDesiredOption("Products with Deals", "check");
        gg_refinePage.saveTheRefineFilterOptns();
        Assert.assertTrue(gg_productDetailsPage.addMultipleProductCountsToCart(arg), "Product with desired count was not added to cart");
    }

    private void removeOutOfStockProducts() {
        GG_RefinePage gg_refinePage = new GG_RefinePage(driver);
        gg_refinePage.clickRefineButton();
        gg_refinePage.filterByDesiredOption("Include Out of Stock", "uncheck");
        gg_refinePage.saveTheRefineFilterOptns();
    }

    @And("user adds {int} different products from search results")
    public void addDifferentProductsFromSearchResults(int desiredCount) {
        gg_productDetailsPage.addDifferentProductsFromSearchResults(desiredCount);
    }

    @And("add multiple products to the cart with names as {string} from product details page using search")
    public void addMultipleProductsToCartFromProductDetailsPageUsingSearch(String listOfProducts) throws InterruptedException {


        for (String prodToAdd : listOfProducts.split(",")) {
            dashboardPageSteps.searchByProductName(prodToAdd);
            browsePage.isProductsListingPageDisplayed();
            addProductsToCart(1);
            goBackToHomePageFromProductDetailsPage();
        }

    }

    // Adds product with age restriction or prop65 warning label by its product id
    @And("add product with label {string} and {string} offer")
    public void addAgeRestrictedOrProp65ProductByProductId(String productType, String withOrWithoutOffer) throws InterruptedException {
        GG_DashboardPage dashboardPage = new GG_DashboardPage(driver);
        GG_BrowsePage browsePage = new GG_BrowsePage(driver);

        switch (productType.toUpperCase()) {
            case "AGE_RESTRICTED":
                if (withOrWithoutOffer.equalsIgnoreCase("WITH")) {
                    dashboardPage.searchByProductName(ThreadLocalHelper.testCaseData.get().get("PRODUCT_ID_AGE_RESTRICTED_OFFER"));
                } else {
                    dashboardPage.searchByProductName(ThreadLocalHelper.testCaseData.get().get("PRODUCT_ID_AGE_RESTRICTED"));
                }
                break;
            case "PROP65_WARNING":
                if (!(ThreadLocalHelper.testCaseData.get().get("ZIPCODE_PROP65").equalsIgnoreCase("NA"))) {
                    if (withOrWithoutOffer.equalsIgnoreCase("WITH")) {
                        dashboardPage.searchByProductName(ThreadLocalHelper.testCaseData.get().get("PRODUCT_ID_PROP65_WARNING_OFFER"));
                    } else {
                        dashboardPage.searchByProductName(ThreadLocalHelper.testCaseData.get().get("PRODUCT_ID_PROP65_WARNING"));
                    }
                }
                break;
            case "AGE_RESTRICTED AND PROP65_WARNING":
                if (!(ThreadLocalHelper.testCaseData.get().get("ZIPCODE_PROP65").equalsIgnoreCase("NA"))) {
                    if (withOrWithoutOffer.equalsIgnoreCase("WITH")) {
                        dashboardPage.searchByProductName(ThreadLocalHelper.testCaseData.get().get("PRODUCT_ID_AGE_RESTRICTED_PROP65_WARNING_OFFER"));
                    } else {
                        dashboardPage.searchByProductName(ThreadLocalHelper.testCaseData.get().get("PRODUCT_ID_AGE_RESTRICTED_PROP65_WARNING"));
                    }
                }
                break;
        }

        Assert.assertTrue(browsePage.isProductsListingPageDisplayed(), "Products listing page is not displayed");
        addProductsToCart(1);
        goBackToHomePageFromProductDetailsPage();
    }


    @And("add multiple products with clipping of deals to the cart with names as {string} from product details page using search and fetching the data from data sheet")
    public void addMultipleProductsToCartFromProductDetailsPageUsingSearchAndFetchingTestData(String listOfProductReferences) throws InterruptedException {
        GG_DashboardPage dashboardPage = new GG_DashboardPage(driver);
        GG_BrowsePage browsePage = new GG_BrowsePage(driver);
        List<String> productTypes = listOfProductReferences.contains(",") ?
                new ArrayList<String>(Arrays.asList(listOfProductReferences.split(","))) : new ArrayList<String>(Arrays.asList(listOfProductReferences));

        for (String dataProdKey : productTypes) {
            String prodToAdd = ThreadLocalHelper.testCaseData.get().get(dataProdKey);
            dashboardPage.searchByProductName(prodToAdd);
            Assert.assertTrue(browsePage.isProductsListingPageDisplayed(), "Products listing page is not displayed");
            addProductsToCart(1);
            gg_productDetailsPage.clipDealsOnProductDetailsPageIfAvailable();
            goBackToHomePageFromProductDetailsPage();
        }
    }

    // This method adds products which have substitutions available using product id
    @And("add {int} number of products having substitutes to cart")
    public void addMultipleProductsHavingSubstitutes(int totalNum) throws InterruptedException {
        for (int productIterator = 1; productIterator <= totalNum; productIterator++) {
            dashboardPageSteps.dashboardPage.enterProductNameAndPressSearchBtn(ThreadLocalHelper.testCaseData.get().get("PRODUCT_" + productIterator + "_WITH_SUB"));
            addProductsToCart(1);
            goBackToHomePageFromProductDetailsPage();
        }
    }

    @And("user clicks all deals in product details page")
    public void clicksAllDealsProductDetails() {
        gg_productDetailsPage.clicksAllDealsProductDetails();
    }
}

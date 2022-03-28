package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_DashboardAEMCampaignPage;
import com.automation.pages.GG_DashboardPersonalisePage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GG_DashboardPersonaliseSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_DashboardPersonalisePage dashboardPersonalisePage = new GG_DashboardPersonalisePage(driver);
    public GG_DashboardAEMCampaignPage dashboardAEMCampaignPage = new GG_DashboardAEMCampaignPage(driver);

    @Then("^verify see all button displayed next to must have grabs$")
    public void verifySeeAllButtonForMustHaveGrabs() {
        Assert.assertTrue(dashboardPersonalisePage.verifySeeAllButtonForMustHaveGrabs());
    }

    @Then("^verify must have grabs label displayed$")
    public void verifyMustHaveGrabsDisplayed() {
        Assert.assertTrue(dashboardPersonalisePage.isMustHaveGrabsDisplayed());
    }

    @Then("^verify buy it again label displayed$")
    public void verifyBuyItAgainDisplayed() {
        Assert.assertTrue(dashboardPersonalisePage.isBuyItAgainDisplayed());
    }

    @Then("^verify see all button displayed next to buy it again$")
    public void verifySeeAllButtonForBuyItGain() {
        Assert.assertTrue(dashboardPersonalisePage.verifySeeAllButtonForBuyItGain());
    }

    @Then("^click see all button displayed next to buy it again$")
    public void clickSeeAllButtonBuyItAgain() {
        dashboardPersonalisePage.clickSeeAllButtonBuyItAgain();
    }

    @Then("^click see all button displayed next to must have grabs$")
    public void clickSeeAllButtonMustHaveGrabs() {
        dashboardPersonalisePage.clickSeeAllButtonMustHaveGrabs();
    }

    @Then("^verify Must Have Grabs Screen page is displayed$")
    public void verifyPopularItemsScreen() {
        Assert.assertTrue(dashboardPersonalisePage.verifyMustHaveGrabsScreen());
    }

    @Then("^verify product cards in personalised section$")
    public void verifyDealCardsInPersonalisedSection() {
        Assert.assertTrue(dashboardPersonalisePage.verifyDealCardsInPersonalisedSection());
    }

    @Then("^verify carousel view in personalised section$")
    public void verifyCarouselViewInPersonalisedSection() throws InterruptedException {
        Assert.assertTrue(dashboardPersonalisePage.hasCarouselViewPersonalizedProducts());
    }

    @And("verify Clip your deals section is displayed")

    public void verifyClipYourFavoritesSectionIsDisplayed() {
        Assert.assertTrue(dashboardPersonalisePage.isClipYourFavoritesDisplayed(), "Clip your deals section is not displayed");
    }

    @And("verify Clip your deals section is not displayed")
    public void verifyClipYourdealsSectionIsNotDisplayed() {
        Assert.assertFalse(dashboardPersonalisePage.isClipYourdealsDisplayed(), "Clip your favorites section is displayed");
    }

    @Then("user clicks back button in must have grabs")
    public void userClicksBackButtonInMustHaveGrabs() {
        dashboardPersonalisePage.clickBackButtonInMustHaveGrabs();
    }

    @Then("click on a product card under Must-have grabs")
    public void clickOnProductCard() {
        dashboardPersonalisePage.clickOnProductCard();
    }

    @Then("^verify count on clip your deals section displayed$")
    public void verifyCountOnClipYourDealsSectionIsDisplayed() {
        Assert.assertTrue(dashboardPersonalisePage.verifyCountDisplayed(), "count on clip your deals section is not displayed");
    }

    @When("^user click see all button displayed next to clip your deals section$")
    public void clickSeeAllButtonClipYourDeals() {
        dashboardPersonalisePage.clickSeeAllClipYourDeals();
    }

    @When("user clicks on specific deal")
    public void userClicksOnSpecificDeal() {
        dashboardPersonalisePage.clickOnSpecificDeal();
    }

    @Then("user validates offer details and eligible products on deal card")
    public void userValidatesOfferDetailsAndEligibleProductsOnDealCard() {
        dashboardPersonalisePage.validateOfferDetailsEligibleProducts();
    }

    @When("user clicks on view list on deal card")
    public void userClicksOnViewListOnDealCard() {
        dashboardPersonalisePage.clickOnViewList();
    }

    @Then("user validates offer details and eligible products on My List")
    public void userValidatesOfferDetailsAndEligibleProductsOnMyList() {
        dashboardPersonalisePage.validateOfferDetailsEligibleProductsMyList();
    }

    @When("user clicks on clip deal")
    public void userClicksOnClipDeal() {
        dashboardPersonalisePage.clickOnClipDeal();
    }

    @Then("user validates clipped item is displayed at list on Mylist")
    public void userValidatesClippedItemIsDisplayedAtListOnMylist() {
        dashboardPersonalisePage.clippedItemAtList();
    }
}

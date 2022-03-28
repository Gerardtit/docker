package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_DashboardPage;
import com.automation.pages.GG_Dashboard_SaveOnOurBrandsPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GG_Dashboard_SaveOnOurBrandsSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_Dashboard_SaveOnOurBrandsPage exclusivePage = new GG_Dashboard_SaveOnOurBrandsPage(driver);

    @Then("^Verify that User is be able to see a Image on Exclusive Store Brands$")
    public void verifyExclusiveBrandImage() {
        Assert.assertTrue(exclusivePage.verifyExclusiveBrandImage(), "Image is not displayed in Exclusive Store Brands module");
    }

    @Then("^Verify that User is be able to see a title on Exclusive Store Brands$")
    public void verifyExclusiveBrandTitle() {
        Assert.assertEquals(exclusivePage.getExclusiveBrandTitleText(), "Save on our brands");
    }

    @When("^click on See All exclusive brands$")
    public void clickSeeAllExclusiveBrands() {
        exclusivePage.clickOnSeeAllExclusiveBrandsModule();
    }

    @Then("^Verify exclusive brand deals details page displayed$")
    public void verifyExclusiveBrandDealsDetailsPageDisplayed() {
        if (exclusivePage.isExclusiveBrandDealsDetailsPageDisplayed()) {
            Assert.assertTrue(exclusivePage.isExclusiveBrandDealsDetailsPageDisplayed(), "Save On our brands deals details page is not displayed");
        } else {
            if (new GG_DashboardPage(driver).isTutorialScreenDisplayed()) {
                new GG_DashboardPage(driver).skipTutorial();
            }
            if (new GG_DashboardPage(driver).isProfileIconDisplayed()) {
                exclusivePage.scrollToExclusiveBrand();
                exclusivePage.clickOnSeeAllExclusiveBrandsModule();
                Assert.assertTrue(exclusivePage.isExclusiveBrandDealsDetailsPageDisplayed(), "Save On our brands deals details page is not displayed");
            } else {
                Assert.assertTrue(false, "Save On our brands deals details page is not displayed");
            }
        }
    }

    @When("click deal from Save on our brands module")
    public void clickOnDealCardOnExclusiveStoreBrandsModule() {
        exclusivePage.clickOnDealCardOnExclusiveStoreBrandsModule();
    }

    @Then("^deal card details page is displayed$")
    public void dealCardDetailsPageIsDisplayed() {
        Assert.assertTrue(exclusivePage.isDealCardDetailsPageDisplayed());
    }

    @When("^scroll down to Save On Our Brands Module$")
    public void scrollDownToSaveOnYourBrandModule() {
        exclusivePage.scrollDownForSaveYourBrandsModule();
    }

    @Then("^verify 'See all' is displayed next to save on our brands module$")
    public void verifySeeAllIsDisplayed() {
        Assert.assertTrue(exclusivePage.isSeeAllButtonDisplayed());
    }

    @Then("^verify 'Save On Our Brands' module is displayed$")
    public void verifySaveOnYourBrandIsDisplayed() {
        Assert.assertTrue(exclusivePage.isSaveOnYourBrandDisplayed());
    }

    @And("^scroll down up to Save On Our Brands module deal card$")
    public void scrollDownUpToExclusiveBrandsModuleDealCard() {
        Assert.assertTrue(exclusivePage.scrollDownUpToExclusiveBrandsModuleDealCard());
    }

    @Then("^verify carousel view in Save On Our Brands section$")
    public void verifyCarouselViewInSaveOnOurBrandsSection() throws InterruptedException {
        Assert.assertTrue(exclusivePage.hasCarouselSaveOnOurBrandsSection(), "Save On Our Brands section Carousel is not displayed");
    }
}
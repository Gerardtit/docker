package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.BasePage;
import com.automation.pages.GG_DashboardWeeklyAdPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GG_DashboardWeeklyAdSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_DashboardWeeklyAdPage dashboardWeeklyAdPage = new GG_DashboardWeeklyAdPage(driver);
    public BasePage basePage = new BasePage(driver);

    @And("^scroll down upto weekly ads section$")
    public void scrollDownUptoWeeklyAdsSection() {
        Assert.assertTrue(dashboardWeeklyAdPage.scrollDownUptoWeeklyAdsSection(), "Weekly ad module not displayed");
    }

    @And("^scroll up to weekly ads section$")
    public void scrollUptoWeeklyAdsSection() {
        Assert.assertTrue(dashboardWeeklyAdPage.scrollUptoWeeklyAdsSection(), "Weekly ad module not displayed");
    }

    @Then("^verify weekly ad banner module$")
    public void verifyWeeklyAdBannerModule() {
        dashboardWeeklyAdPage.verifyWeeklyAdBannerModule();
    }

    @Then("^verify weekly ad banner image$")
    public void verifyWeeklyAdBannerImage() {
        dashboardWeeklyAdPage.verifyWeeklyAdBannerImage();
    }

    @When("^click on weekly ad banner$")
    public void clickOnWeeklyAdBanner() {
        dashboardWeeklyAdPage.clickWeeklyAdBanner();
    }

    @Then("^verify weekly ad iframe title$")
    public void verifyWeeklyAdIframeTitle() throws InterruptedException {
        Assert.assertTrue(dashboardWeeklyAdPage.verifyWeeklyAdIframeTitle());
    }

    @Then("^verify weekly ad iFrame is displayed$")
    public void verifyWeeklyAdDetailsPageDisplayed() throws InterruptedException {
        Assert.assertTrue(dashboardWeeklyAdPage.isWeeklyAdCouponDetailsPageDisplayed());
    }

    @Then("^verify loading spinner is displayed until weekly ads page is fully loaded$")
    public void checkForLoadingSpinner() throws InterruptedException {
        if (dashboardWeeklyAdPage.isLoadingSpinnerDisplayed()) {
            Assert.assertTrue(true, "Loading spinner is displayed");
        } else {
            if (!dashboardWeeklyAdPage.isWeeklyAdCouponDetailsPageDisplayed()) {
                Assert.assertTrue(false, "Loading spinner is not displayed while weekly ads page is being loaded");
            }
        }
    }

    @Then("^verify skinny version of weekly ad banner displayed$")
    public void verifySkinnyVersionOfWeeklyAdBannerIsDisplayed() {
        Assert.assertTrue(dashboardWeeklyAdPage.verifySkinnyVersionOfWeeklyAdBanner(), "skinny version of weekly ad banner is not displayed");

    }

    @Then("^verify normal version of weekly add banner displayed$")
    public void verifyNormalVersionOfWeeklyAdBannerIsDisplayed() {
        Assert.assertTrue(dashboardWeeklyAdPage.verifyNormalVersionOfWeeklyAdBanner(), "verify normal version of weekly add banner is not displayed");
    }

    @When("^tap back button$")
    public void clickBackBtn() {
        dashboardWeeklyAdPage.clickOnBackBtn();
    }

    @When("user click on weekly ad banner image")
    public void userClickOnWeeklyAdBannerImage() {
        dashboardWeeklyAdPage.userClickWeeklyAdBannerImage();
    }

    @Then("verify weekly ad banner image is not visible")
    public void andVerifyWeeklyAdBannerImageIsNotVisible() {
        dashboardWeeklyAdPage.verifyWeeklyAdBannerImageNotVisible();
    }
}

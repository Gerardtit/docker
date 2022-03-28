package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_DashboardAEMCampaignPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class GG_Dashboard_AEMCampaignSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_DashboardAEMCampaignPage dashboardAEMCampaignPage = new GG_DashboardAEMCampaignPage(driver);

    @Then("^verify title of AEM campaign$")
    public void verifyTitleOfAEMCampaign() {
        Assert.assertTrue(dashboardAEMCampaignPage.verifyTitleOfAEMCampaign());
    }

    @Then("^verify deal card on AEM campaign$")
    public void verifyDealCard() {
        Assert.assertTrue(dashboardAEMCampaignPage.verifyDealCard());
    }

    @Then("^verify carousel view$")
    public void verifyCarouselViewIn() throws InterruptedException {
        Assert.assertTrue(dashboardAEMCampaignPage.hasCarouselViewAEMProducts(), "AEM Carousel is not displayed");
    }

    @And("^scroll down upto aem campaign$")
    public void scrollDownUptoAemCampaign() {
        Assert.assertTrue(dashboardAEMCampaignPage.scrollDownAndCheckIfAEMCarouselDisplayed(), "AEM carousel was not found");
    }

    @And("^scroll upto aem campaign$")
    public void scrollUptoAemCampaign() {
        dashboardAEMCampaignPage.scrollUptoAemCampaign();
    }
}

package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_foru_rewardsPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GG_foru_rewardsSteps {


    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_foru_rewardsPage rewardsForuPage = new GG_foru_rewardsPage(driver);
    AppiumDevice device = AppiumDeviceManager.getDevice();

    @When("user clicks on rewards pills at homepage")
    public void userClicksOnRewardsPillsAtHomepage() {
        rewardsForuPage.homepageRewards();
    }

    @Then("validate the {string} chart")
    public void validateTheChart(String arg0) {
        rewardsForuPage.chart();
    }

    @When("user clicks on rewards pills at dealspage")
    public void userClicksOnRewardsPillsAtDealspage() {
        rewardsForuPage.dealsreward();
    }

    @And("user clicks on deals tab")
    public void userClicksOnDealsTab() {
        rewardsForuPage.dealstab();
    }

    @Then("clicks Rewards on member tab")
    public void clicksForUTab() {
        rewardsForuPage.forutab();
    }

    @Then("birthday card is displayed")
    public void bdayCardIsDisplayed() {
        rewardsForuPage.bdaycard();
    }

    @Then("verify Scorecard in Rewards tab for no rewards user")
    public void verifyScorecardInForUTabForNoRewards() {
        rewardsForuPage.verifyRewardsScoreCard();
    }

    @When("click on scorecard POD")
    public void clickOnScorecardPOD() {

        rewardsForuPage.clickOnScoreCardNoRewards();

    }

    @Then("verify how do rewards workd screen for user does not has rewards and points")
    public void verifyHowForUScreen() {
        rewardsForuPage.verifyHowForUScreen();
        rewardsForuPage.verifyHeading();

    }

    @And("verify FAQ and T&C link content")
    public void verifyFAQAndTCLinkContent() {
        rewardsForuPage.verifyTermsAndCondition();
    }

    @Then("verify Scorecard in for u tab for some rewards balance")
    public void verifyScorecardInForUTabForSomeRewardsBalance() {
        rewardsForuPage.verifyRewardsScoreCardWithRewards();
    }

    @When("click on scorecard POD with Rewards")
    public void clickOnScorecardPODWithRewards() {
        rewardsForuPage.clickOnScoreCardWithRewards();
    }

    @Then("verify how do rewards works screen for user has rewards balance")
    public void verifyHowForUScreenForRewardsUser() {
        rewardsForuPage.verifyHowForUScreenWithRewards();
    }

    @Then("verify how do rewards works screen for user has rewards balance expiring eom")
    public void verifyHowDoRewardsWorksScreenForUserHasRewardsBalanceExpiringEom() {
        rewardsForuPage.verifyHowDORewardsWithRewardsexpiringEOM();
    }

    @Then("verify How do Rewards works displayed in Rewards screen")
    public void verifyHowDoRewardsWorksDisplayedInRewardsScreen() {
        rewardsForuPage.verifyHowDoRewardsInRewardsTab();
    }

    @And("click on how do rewards works button")
    public void clickOnHowDoRewardsWorksButton() {
        rewardsForuPage.clickOnHowDoRewardsWorks();
    }

    @Then("click on Rewards on member tab")
    public void clickOnRewardsOnMemberTab() {
        rewardsForuPage.clickOnRewards();
    }

    @Then("verify how do rewards works screen for user has no rewards but some points")
    public void verifyHowDoRewardsWorksScreenForUserHasNoRewardsButPoints() {

        rewardsForuPage.verifyMsgOnHowDoReWardsWorkdScreen();
    }

    @Then("verify Scorecard in Rewards tab for no rewards but some points")
    public void verifyScorecardInRewardsTabForNoRewardsButSomePoints() {
        rewardsForuPage.verifyScrorecardNoRewardsOnlyPoints();
    }
}

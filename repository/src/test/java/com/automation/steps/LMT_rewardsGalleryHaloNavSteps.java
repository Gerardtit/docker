package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_MyRewardsPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;

public class LMT_rewardsGalleryHaloNavSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_MyRewardsPage myRewardsPage = new GG_MyRewardsPage(driver);

    @Then("user gets landed on Rewards gallery")
    public void user_gets_landed_on_rewards_gallery() {
        myRewardsPage.allRewardsGalleryHaloNav();
    }


}

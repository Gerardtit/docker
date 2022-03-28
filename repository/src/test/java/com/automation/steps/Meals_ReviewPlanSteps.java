package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.mealsPages.ReviewPlanPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class Meals_ReviewPlanSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    ReviewPlanPage reviewPlanPage = new ReviewPlanPage(driver);

    @Then("^User clicks review plan")
    public void user_clicks_review_plan() throws Throwable {
        reviewPlanPage.clickReviewYourPlanButton();
        Assert.assertTrue(reviewPlanPage.verifyReviewPlanPageIsDisplayed());
    }

    @Then("^Review your plan is displayed")
    public void review_your_plan_is_displayed() throws Throwable {
        Assert.assertTrue(reviewPlanPage.verifyReviewPlanPageIsDisplayed());
    }
}

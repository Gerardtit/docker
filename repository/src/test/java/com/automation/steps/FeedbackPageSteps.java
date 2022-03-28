package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.FeedbackPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FeedbackPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public FeedbackPage feedbackPage = new FeedbackPage(driver);

    @Then("^feedback page is displayed$")
    public void feedbackPageIsDisplayed() {
        feedbackPage.waitForFeedbackPageDisplayed();
    }

    @When("^user select \"([^\"]*)\" as feedback topic$")
    public void userSelectAsFeedbackTopic(String arg0) throws Throwable {

        feedbackPage.selectTopicFromFeedbackDropdown(arg0);
    }

    @And("^user enters \"([^\"]*)\" in comment box$")
    public void userEntersInCommentBox(String arg0) {
        feedbackPage.enterComments(arg0);
    }

    @And("^user click submit to submit comments$")
    public void userClickSubmitToSubmitComments() {
        feedbackPage.clickSubmitComments();
    }

    @Then("^comment successfully sent id displayed$")
    public void commentSuccessfullySentIdDisplayed() {
        feedbackPage.commentSentDisplayed();
    }


    @When("^user verify \"([^\"]*)\" as feedback topic$")
    public void userVerifyAsFeedbackTopic(String topic) throws Throwable {
        feedbackPage.verifyItemOnDropdown(topic);
    }

    @When("^user click dropdown menu from feedback page$")
    public void userClickDropdownMenuFromFeedbackPage() {
        feedbackPage.clickDropdown();
    }
}

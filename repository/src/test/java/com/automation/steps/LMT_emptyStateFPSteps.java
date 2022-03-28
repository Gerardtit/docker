package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.FivePercentFPPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;

public class LMT_emptyStateFPSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public FivePercentFPPage fivePercentFPPage = new FivePercentFPPage(driver);

    @Then("user sees the empty state message for FP subscribed users")
    public void user_sees_the_empty_state_message_for_fp_subscribed_users() {
        fivePercentFPPage.emptyStateFP();
    }

    @Then("user cannot see the empty state message for FP subscribed users")
    public void user_cannot_see_the_empty_state_message_for_fp_subscribed_users() {
        fivePercentFPPage.noEmptyStateFP();
    }

}

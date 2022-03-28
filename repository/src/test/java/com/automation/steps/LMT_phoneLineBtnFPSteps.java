package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.FivePercentFPPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;

public class LMT_phoneLineBtnFPSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public FivePercentFPPage fivePercentFPPage = new FivePercentFPPage(driver);


    @Then("verify VIP phone line button is displayed")
    public void verify_vip_phone_line_button_is_displayed() {
        fivePercentFPPage.vipPhoneLineFP();
    }
}

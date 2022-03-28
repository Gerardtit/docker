package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.FivePercentFPPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;

public class LMT_CartSearchIconFPSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public FivePercentFPPage fivePercentFPPage = new FivePercentFPPage(driver);


    @Then("user validates the search icon on FP page")
    public void user_validates_the_search_icon_on_fp_page() {
        fivePercentFPPage.searchIconFP();
    }

    @Then("user validates the cart icon on FP page")
    public void user_validates_the_cart_icon_on_fp_page() {
        fivePercentFPPage.cartIconFP();
    }
}

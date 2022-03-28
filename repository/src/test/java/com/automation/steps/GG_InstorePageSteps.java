package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_WelcomePage;
import com.automation.pages.SelectOrderTypePage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.When;

public class GG_InstorePageSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public SelectOrderTypePage selectOrderTypePage = new SelectOrderTypePage(driver);
    public GG_WelcomePage welcomePage = new GG_WelcomePage(driver);


    @When("^user click instore option$")
    public void user_click_instore_option() throws Throwable {
        try {
            selectOrderTypePage.clickInstore();
        } catch (Exception e) {
        }
    }

    @When("^user click maybe later version option$")
    public void user_click_maybeLater_option() throws Throwable {
        try {
            welcomePage.clickMaybeLaterButton();
        } catch (Exception e) {
        }
    }


}

package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.PopUpHandlePage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PopUpHandleSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public PopUpHandlePage popUpHandlePage = new PopUpHandlePage(driver);

    @When("^user click on soft upgrade message$")
    public void user_click_on_soft_upgrade_message() throws Throwable {
        try {
            popUpHandlePage.closeSoftUpgradeMessage();
        } catch (Exception e) {
            System.out.println("came out of try block");
        }
    }

    @When("^user click Dismiss$")
    public void user_click_Dismiss() throws Throwable {
        try {
//            popUpHandlePage.clickAllow();
            popUpHandlePage.clickDismiss();
        } catch (Exception e) {
            System.out.println("came out of try block");
        }
    }

    @When("^click yes if you love Safeway app$")
    public void user_click_yes() throws Throwable {
        try {
//            popUpHandlePage.clickAllow();
            popUpHandlePage.clickYes();
        } catch (Exception e) {
            System.out.println("came out of try block");
        }
    }

    @When("^user click Cancel in Feedback form$")
    public void user_click_Cancel() throws Throwable {
        try {
            popUpHandlePage.clickCancel();
        } catch (Exception e) {
            System.out.println("came out of try block");
        }
    }

    @And("^user click on Delivery Next popup$")
    public void clickNextOnPopUp() {
        popUpHandlePage.clickNextOnPopup();
    }

    @Then("^user should not see allow permission popup$")
    public void userShouldNotSeeAllowPermissionPopup() {
        popUpHandlePage.userShouldNotSeeAllowPermission();
    }

}

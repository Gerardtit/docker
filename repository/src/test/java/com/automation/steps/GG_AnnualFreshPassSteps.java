package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_Annual_FreshPassPage;
import com.automation.pages.GG_handlingLangingPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GG_AnnualFreshPassSteps {

    AppiumDevice device = AppiumDeviceManager.getDevice();
    AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_Annual_FreshPassPage annualFreshPassPage = new GG_Annual_FreshPassPage(driver);
    public GG_handlingLangingPage landingpage = new GG_handlingLangingPage(driver);

    @And("^update or cancel text is displayed$")
    public void updateOrCancelTextIsDisplayed() {
        annualFreshPassPage.subPlantext();
    }

    @Then("^Annual plan is displayed at fresh Pass Page$")
    public void annualPlanIsDisplayedAtFreshPassPage() {
        annualFreshPassPage.plantype();
    }

    @Then("^Year Plan is displayed$")
    public void yearPlanIsDisplayed() {
        annualFreshPassPage.planAmount();

    }

    @And("^Change tab is displayed$")
    public void changeTabIsDisplayed() {
        annualFreshPassPage.changetab();

    }

    @Then("^VIP customer service number is displayed$")
    public void vipCustomerServiceNumberIsDisplayed() {
        annualFreshPassPage.customerservice();

    }

    @Then("^Manage plan text is displayed$")
    public void managePlanTextIsDisplayed() {
        annualFreshPassPage.managePlantext();

    }

    @When("^cancelFreshPass is displayed$")
    public void cancelfreshpassIsDisplayed() {
        annualFreshPassPage.cancelText();
    }
}

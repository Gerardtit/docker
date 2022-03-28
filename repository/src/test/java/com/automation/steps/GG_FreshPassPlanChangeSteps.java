package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_FreshPassChangePlanPage;
import com.automation.pages.GG_handlingLangingPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GG_FreshPassPlanChangeSteps {

    AppiumDevice device = AppiumDeviceManager.getDevice();
    AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_FreshPassChangePlanPage FreshPassPage = new GG_FreshPassChangePlanPage(driver);
    public GG_handlingLangingPage landingpage = new GG_handlingLangingPage(driver);

    @When("^user clicks on selecttab of monthly plan$")
    public void userClicksOnSelecttabOfMonthlyPlan() {
        FreshPassPage.monthlySelect();
    }


    @Then("^user handle landing scenario$")
    public void userHandleLandingScenario() {
        landingpage.ToHomePage();
    }

    @Then("^Freshpass title is displayed$")
    public void freshpassTitleIsDisplayed() {
        FreshPassPage.frshpasstitle();
    }

    @Then("Annual Plan is displayed with yr. plan")
    public void annualPlanIsDisplayedWithYrPlan() {
        FreshPassPage.plantitle();
        FreshPassPage.yrplan();

    }


    @And("^payment method text is displayed$")
    public void paymentMethodTextIsDisplayed() {
        FreshPassPage.paymentdisplay();
    }

    @And("^CheckBox is displayed$")
    public void checkboxIsDisplayed() {
        FreshPassPage.checkboxdisplay();

    }

    @And("^Iagree text is visible$")
    public void iagreeTextIsVisible() {
        FreshPassPage.iagreedisplay();

    }

    @Then("^FAQ text is displayed$")
    public void faqTextIsDisplayed() {
        FreshPassPage.faqtitle();

    }

    @Then("^TNC text is displayed$")
    public void tncTextIsDisplayed() {
        FreshPassPage.TNC();
    }
}

package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_Annual_FreshPassPage;
import com.automation.pages.GG_Verify_FreshPassPage;
import com.automation.pages.GG_freshpass_user_subscriptionPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GG_freshPass_user_subsrciptionSteps {
    AppiumDevice device = AppiumDeviceManager.getDevice();
    AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_Verify_FreshPassPage FreshPassPage = new GG_Verify_FreshPassPage(driver);
    public GG_Annual_FreshPassPage annualFreshPassPage = new GG_Annual_FreshPassPage(driver);
    public GG_freshpass_user_subscriptionPage subscriptionFreshPAss = new GG_freshpass_user_subscriptionPage(driver);


    @When("^confirm tab is selected$")
    public void confirmTabIsSelected() {
        subscriptionFreshPAss.confirmTabselected();
    }

    @Then("^confirmation screen is displayed$")
    public void confirmationScreenIsDisplayed() {
        subscriptionFreshPAss.confirmpage();
    }

    @Then("^validate Current plan is displayed$")
    public void validateCurrentPlanIsDisplayed() {
        subscriptionFreshPAss.currentplan();
        subscriptionFreshPAss.curannualplan();
    }

    @And("^new plan is displayed$")
    public void newPlanIsDisplayed() {
        subscriptionFreshPAss.urnewplan();
        subscriptionFreshPAss.newmonthlyplan();
    }

    @And("^Validate the text on confirmation page$")
    public void validateTheTextOnConfirmationPage() {
        annualFreshPassPage.customerservice();
        FreshPassPage.FAQPagedisplay();
        subscriptionFreshPAss.textvalidation();
    }

    @Then("^Done button is selected$")
    public void doneButtonIsSelected() {
        subscriptionFreshPAss.donebutton();

    }


    @Then("^validate Current plan as monthly is displayed$")
    public void validateCurrentPlanAsMonthlyIsDisplayed() {
        subscriptionFreshPAss.currentplan();
        subscriptionFreshPAss.curmonthlyplan();
    }

    @Then("^user clicks on Annual subscription tab$")
    public void userClicksOnAnnualSubscriptionTab() {
        subscriptionFreshPAss.annualstatus();
    }

    @Then("^user clicks on Monthly subscription tab$")
    public void userClicksOnMonthlySubscriptionTab() {
        subscriptionFreshPAss.monthlystatus();
    }

    @Then("^validate freshpass page elements$")
    public void validateFreshpassPageElements() {

    }

    @Then("^Current plan is displayed$")
    public void currentPlanIsDisplayed() {
        subscriptionFreshPAss.currentplan();
    }

    @And("^user new plan is displayed$")
    public void userNewPlanIsDisplayed() {
        subscriptionFreshPAss.urnewplan();
    }


}

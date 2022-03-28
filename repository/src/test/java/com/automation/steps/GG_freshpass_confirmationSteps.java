package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_Cancellation_freshpassPage;
import com.automation.pages.GG_DashboardPage;
import com.automation.pages.GG_freshpass_confirmationPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GG_freshpass_confirmationSteps {


    public AppiumDevice device = AppiumDeviceManager.getDevice();
    AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_Cancellation_freshpassPage cancellationFreshPassPage = new GG_Cancellation_freshpassPage(driver);

    public GG_freshpass_confirmationPage confirmFreshPass = new GG_freshpass_confirmationPage(driver);
    public GG_DashboardPage dashboardPage = new GG_DashboardPage(driver);

    @When("^user clicks on member tab$")
    public void userClicksOnMemberTab() {
        confirmFreshPass.membertab();

    }


    @Then("user navigates to personal info screen")
    public void personalInfoScreen() {
        confirmFreshPass.clickname();
    }

    @And("user adds DOB")
    public void AddDOB() {
        confirmFreshPass.AddDOB();
    }

    @Then("verify Date of birth is not editable")
    public void verifyDOB() {
        confirmFreshPass.verifyDOB();
    }


    @Then("^click on Address on Account tab")
    public void clickAddress() {
        confirmFreshPass.Address();
    }

    @Then("^click on Add pickup hyperlink")
    public void addPickup() {
        confirmFreshPass.addPickup();
    }

    @And("^enter pickup zipcode")
    public void pickup_zipcode() {
        confirmFreshPass.findpickupstore();
    }

    @Then("^user clicks on freshpass at member tab$")
    public void userClicksOnFreshpassAtMemberTab() {
        confirmFreshPass.freshpassatmemeber();
    }

    @Then("^user clicks on subscription tab$")
    public void userClicksOnSubscriptionTab() throws Exception {
        confirmFreshPass.statustab();
    }

    @When("^user clicks add new card on page$")
    public void userClicksAddNewCardOnPage() {
        confirmFreshPass.newCard();

    }

    @And("^Startsubscription tab is clicked$")
    public void startsubscriptionTabIsClicked() {
        confirmFreshPass.subscription();
    }

    @Then("^validate you are All set text$")
    public void validateYouAreAllSetText() {
        confirmFreshPass.allsettext();
    }

    @Then("^Done tab is selected$")
    public void doneTabIsSelected() {
        confirmFreshPass.donetab();
    }

    @Then("^user clicks notnow text$")
    public void user_clicks_notnow() throws Throwable {
        confirmFreshPass.notnowtext();

    }

    @When("^Trial button is selected$")
    public void trialButtonIsSelected() {
        confirmFreshPass.trialtabselected();
    }


    @Then("^user clicks on shop now$")
    public void userClicksOnShopNow() {
        cancellationFreshPassPage.shopnowClick();
    }
}

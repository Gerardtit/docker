package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.DeeplinksPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeeplinksSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public DeeplinksPage deeplinksPage = new DeeplinksPage(driver);

    @When("^user closes the app$")
    public void closeApp() {

        if (driver.getPlatformName().equalsIgnoreCase("Android")) {

            deeplinksPage.closeApp();
        }
    }

    @When("^user closes the app for ios$")
    public void closeAppForiOS() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            deeplinksPage.closeApp();
        }
    }

    @And("^user change settings$")
    public void user_change_settings() {
        deeplinksPage.changeSettings();
    }

    @And("^user opens browser$")
    public void user_opens_browser() {
        deeplinksPage.openMobileApp();
    }

    @Then("^browser is opened$")
    public void browser_is_opened() {
        //if Notes is opened, only android app open criteria has to be verified

        deeplinksPage.verifyAppOpened();
    }

    @When("^user enters Carrsqc ZTP link in Address bar$")
    public void user_enters_carrs_ztp_link() {
        if (driver.getCapabilities().getCapability("banner").toString().contains("carrs")) {
            deeplinksPage.enterAppsflyerLink("ZTP Add Payment");
        }
    }

    @When("^user enters \"([^\"]*)\" appsflyer link in Address bar$")
    public void user_enters_appsflyer_link_in_address_bar(String link) {

        //to be uncommented if Notes app is opened
//        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
//            deeplinksPage.deleteNote();
//            deeplinksPage.createNewNote();
//        }

        //Chrome app
        deeplinksPage.enterAppsflyerLink(link);
    }

    @Then("^user see \"([^\"]*)\" tab open$")
    public void user_verify_deeplink_tab_opened(String tab) throws Exception {
        deeplinksPage.verifyDeeplinkTabOpened(tab);
    }

    @Then("^user is able to see Carrsqc cash$")
    public void user_sees_carrsqc_cash() throws Exception {
        deeplinksPage.carrsQcCashDisplayed();
    }

    @When("user closes and launch the app")
    public void userClosesAndLaunchTheApp() throws InterruptedException {
        deeplinksPage.closeAndRelaunch();
    }

    @Then("validate user is on Appcenter Screen")
    public void validateUserIsOnAppcenterScreen() {
        deeplinksPage.verifyAppCenterIsOpen();
    }
}

package com.automation.steps;

import com.automation.helpers.AppActions;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_DashboardPage;
import io.cucumber.java.en.When;

import java.io.IOException;

public class AppActionSteps {
    AppActions appActions = new AppActions();

    @When("^kill the application$")
    public void terminateApp() throws IOException {
        appActions.terminateApp();
    }

    @When("^relaunch the application$")
    public void relaunchApp() throws IOException {
        appActions.relaunchApp();
        //new GG_DashboardPage(AppiumDriverManager.getDriver()).clickOnUpdateLaterIfDisplayed();
        new GG_DashboardPage(AppiumDriverManager.getDriver()).clickContinueCache();
        new GG_DashboardPage(AppiumDriverManager.getDriver()).handleLoveAppPopup();
        new GG_DashboardPage(AppiumDriverManager.getDriver()).clickOnCancelButtonFeedbackFormIfDisplayed();
        new GG_DashboardPage(AppiumDriverManager.getDriver()).clickContinueCache();
    }

    @When("^kill and relaunch the application without popup handling$")
    public void terminateAndRelaunchApp() throws IOException {
        appActions.terminateApp();
        appActions.relaunchApp();
    }
}

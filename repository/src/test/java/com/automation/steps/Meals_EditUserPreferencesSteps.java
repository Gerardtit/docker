package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.mealsPages.EditUserPreferencesPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Meals_EditUserPreferencesSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    EditUserPreferencesPage editUserPreferencesPage = new EditUserPreferencesPage(driver);

    @When("^user clicks edit preferences button$$")
    public void user_clicks_edit_preferences_button() {
        editUserPreferencesPage.goToDietPreferences();
    }

    @Then("^Diet preferences screen is displayed$")
    public void diet_preferences_screen_is_displayed() {
        editUserPreferencesPage.dietPreferencesScreenIsDisplayed();
    }

    @When("^User clicks on diet type$")
    public void user_clicks_on_diet_type() {
        editUserPreferencesPage.clickOnDietTypeButton();
    }

    @When("^User clicks on back button on edit preferences screen$")
    public void user_clicks_on_back_button_on_edit_preferences_screen() {
        editUserPreferencesPage.clickBackButton();
    }
}

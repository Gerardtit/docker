package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.mealsPages.MyMealsCookingPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Meals_CookingSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    MyMealsCookingPage myMealsCookingPage = new MyMealsCookingPage(driver);

    @Then("^user clicks on start cooking on meals homepage")
    public void user_clicks_on_start_cooking_on_meals_homepage() throws Throwable {
        myMealsCookingPage.clickStartCookingButton();
    }

    @Then("^cooking mode step 1 is shown$")
    public void cooking_mode_step_1_is_shown() {
        myMealsCookingPage.cookingModeStep1IsDisplayed();
    }

    @Then("^user clicks done button in cooking mode last step$")
    public void user_clicks_done_button_in_cooking_mode_last_step() {
        myMealsCookingPage.clickDoneButtonOnLastStepOfCookingMode();
    }

    @Then("^My meals page should be displayed$")
    public void my_meals_page_should_be_displayed() {
        myMealsCookingPage.verifyMyMealsPageIsDisplayed();
    }

    @When("^user clicks back button on my meals page$")
    public void user_clicks_back_button_on_my_meals_page() {
        myMealsCookingPage.clickBackButton();
    }

    @Then("^user goes to cooked tab$")
    public void user_goes_to_cooked_tab() {
        myMealsCookingPage.clickPlannedTab();
        myMealsCookingPage.clickCookedTab();
    }

    @Then("^verify recipe is shown in cooked tab")
    public void verify_recipe_is_shown_in_cooked_tab() {
        myMealsCookingPage.verifyRecipeShownInCooked();
    }

    @When("^user clicks see all my meals button or show past meals$")
    public void user_clicks_see_all_my_meals_button_or_show_past_meals() {
        myMealsCookingPage.clickSeeAllMyMealsOrShowPastMealsButtonOnMealsHomepage();
    }
}

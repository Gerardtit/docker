package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.mealsPages.EditUserPreferencesPage;
import com.automation.pages.mealsPages.MealsHomePage;
import com.automation.pages.mealsPages.OnBoardingPage;
import com.automation.pages.mealsPages.UMAHomePage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Meals_OnboardingFlowSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    UMAHomePage umaHomePage = new UMAHomePage(driver);
    MealsHomePage mealsHomePage = new MealsHomePage(driver);
    OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
    EditUserPreferencesPage editUserPreferencesPage = new EditUserPreferencesPage(driver);

    @Given("^onboarding flow is displayed$")
    public void onboarding_flow_is_displayed() {
        if (!onBoardingPage.verifyOnboardingPageIsDisplayed()) {
            if (mealsHomePage.verifyMealsHomePageIsDisplayed()) {
                editUserPreferencesPage.resetAdminSettings();
                umaHomePage.navigateToUMAHomepage();
                umaHomePage.clickMealsPlanButtonOnHaloNavCarousel();
                Assert.assertTrue(onBoardingPage.verifyOnboardingPageIsDisplayed());
            }
        } else {
            Assert.assertTrue(onBoardingPage.verifyOnboardingPageIsDisplayed());
        }
    }

    @When("^user clicks skip button$")
    public void user_clicks_skip_button() {
        onBoardingPage.clickSkipButton();
    }

    @Given("^User is on meals onboarding flow page")
    public void user_is_on_meals_onboarding_flow_page() throws Throwable {
        umaHomePage.navigateToUMAHomepage();
        umaHomePage.clickMealsPlanButtonOnHaloNavCarousel();
        if (!onBoardingPage.verifyOnboardingPageIsDisplayed()) {
            if (mealsHomePage.verifyMealsHomePageIsDisplayed()) {
                editUserPreferencesPage.resetAdminSettings();
                umaHomePage.navigateToUMAHomepage();
                umaHomePage.clickMealsPlanButtonOnHaloNavCarousel();
                Assert.assertTrue(onBoardingPage.verifyOnboardingPageIsDisplayed());
            }
        } else {
            Assert.assertTrue(onBoardingPage.verifyOnboardingPageIsDisplayed());
        }
    }

    @Then("onboarding steps are displayed")
    public void onboarding_steps_are_displayed() {
        Assert.assertTrue(onBoardingPage.verifyOnboardingPageIsDisplayed());
    }

    @When("user clicks on pick your diet")
    public void user_clicks_on_pick_your_diet() {
        onBoardingPage.clickPickYourDietButton();
    }

    @Then("pick your diet page is displayed")
    public void pick_your_diet_page_is_displayed() {
        onBoardingPage.verifyPickYourDietPageIsDisplayed();
    }

    @When("^user clicks onboarding page back button$")
    public void user_clicks_onboarding_page_back_button() {
        onBoardingPage.clickBackButton();
    }

    @Then("user clicks on next button")
    public void user_clicks_on_next_button() {
        onBoardingPage.clickNextButton();
    }

    @Then("onboarding allergies or restrictions page is displayed")
    public void onboarding_allergies_or_restrictions_page_is_displayed() {
        onBoardingPage.verifyDietRestrictionsPageIsDisplayed();
    }

    @Given("onboarding dislikes page is displayed")
    public void onboarding_dislikes_page_is_displayed() {
        onBoardingPage.dislikesPageIsDisplayed();
    }

    @Then("servings page is displayed")
    public void servings_page_is_displayed() {
        onBoardingPage.servingsPageIsDisplayed();
    }

    @Then("user clicks on done button")
    public void user_clicks_on_done_button() {
        onBoardingPage.clickDoneButton();
    }

    @Given("^User clicks on meals menu button on uma home page$")
    public void user_clicks_on_meals_menu_button_on_uma_home_page() {
        umaHomePage.clickMealsPlanButtonOnHaloNavCarousel();
    }

    @When("^user resets admin settings for meals$")
    public void user_resets_admin_settings_for_meals() {
        editUserPreferencesPage.resetAdminSettings();
    }
}

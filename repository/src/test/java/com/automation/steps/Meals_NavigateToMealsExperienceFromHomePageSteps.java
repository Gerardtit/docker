package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.StartUpPage;
import com.automation.pages.mealsPages.MealsHomePage;
import com.automation.pages.mealsPages.MealsUtils;
import com.automation.pages.mealsPages.OnBoardingPage;
import com.automation.pages.mealsPages.UMAHomePage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class Meals_NavigateToMealsExperienceFromHomePageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    UMAHomePage umaHomePage = new UMAHomePage(driver);
    MealsHomePage mealsHomePage = new MealsHomePage(driver);
    OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
    MealsUtils mealsUtils = new MealsUtils(driver);

    @Then("^verify meals menu banner is displayed on uma homepage$")
    public void verify_meals_menu_banner_is_displayed_on_uma_homepage() throws InterruptedException, IOException {
        Assert.assertTrue(umaHomePage.verifyMealsMenuBarIsDisplayed());
    }

    @And("scroll down the screen for meals menu banner")
    public void scroll_down_the_screen_for_meals_menu_banner() throws InterruptedException, IOException {
        umaHomePage.locateMealsMenu();
    }

    @Then("^meals menu banner is clickable$")
    public void meals_menu_banner_is_clickable() throws Throwable {
        Assert.assertTrue(umaHomePage.verifyMealsMenuBarIsClickable());
    }

    @When("^User clicks on the homepage meals menu banner$")
    public void user_clicks_on_the_homepage_meals_menu_banner() throws Throwable {
        umaHomePage.clickOnMealsMenuBanner();
    }

    @Then("^verify meals homepage or onboarding flow is displayed$")
    public void verify_meals_homepage_or_onboarding_flow_is_displayed() throws Throwable {
        Assert.assertTrue(mealsHomePage.verifyMealsHomePageIsDisplayed() || onBoardingPage.verifyOnboardingPageIsDisplayed());
    }

    @Then("^uma home page is displayed$")
    public void uma_home_page_is_displayed() {
        umaHomePage.goToHomeTab();
    }

    @Given("^User is on meals homepage or onboarding flow page")
    public void user_is_on_meals_homepage_or_onboarding_flow_page() throws Throwable {
        umaHomePage.navigateToUMAHomepage();
        umaHomePage.clickOnMealsMenuBanner();
        verify_meals_homepage_or_onboarding_flow_is_displayed();
    }

    @When("^User clicks on back button$")
    public void user_clicks_on_back_button() throws Throwable {
        if (mealsUtils.checkMobileElementExist(onBoardingPage.onBoardingFlowTextElement())) {
            onBoardingPage.clickBackButton();
        } else {
            mealsHomePage.clickBackButton();
        }
    }

    @When("^user dismiss popups$")
    public void user_dismiss_popups() {
        try {
            new StartUpPage(driver).clickContinue();
        } catch (Exception e) {

        }
    }

    @Then("^meal Plans option should be shown on carousel list$")
    public void meal_Plans_option_should_be_shown_on_carousel_list() {
        Assert.assertTrue(umaHomePage.mealPlansHaloNavCarouselButtonIsDisplayed());
    }

    @Then("^meal plans button on halo nav carousel is clickable$")
    public void meal_plans_button_on_halo_nav_carousel_is_clickable() {
        Assert.assertTrue(umaHomePage.mealPlansHaloNavCarouselButtonIsClickable());
    }

    @When("^user clicks on meal plans on halo nav carousel$")
    public void user_clicks_on_meal_plans_on_halo_nav_carousel() {
        umaHomePage.clickMealsPlanButtonOnHaloNavCarousel();
    }

}

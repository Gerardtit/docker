package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_SaveCategoryPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GG_CategoryPageSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();

    public GG_SaveCategoryPage categoryPage = new GG_SaveCategoryPage(driver);


    @Then("^Click on back button on Category Screen$")
    public void clickBackBtn() throws Throwable {
        categoryPage.clickBackBtn();
    }

    @Then("^verify user is in category screen")
    public void categoryPageIsDisplayed() throws Throwable {

        categoryPage.getCategoryPageDescription();
    }

    @When("^tap on skip option on category screen$")
    public void tapOnSkipOptionOnCategoryScreen() {
        categoryPage.clickSkip();
    }

    @When("^select category$")
    public void selectCategory() {
        categoryPage.selectFirstCategory();
    }

    @And("^tap on continue button$")
    public void tapOnContinueButton() {
        categoryPage.getContinueButton();
    }

    @When("^user click back button$")
    public void userClickBackButton() {
        categoryPage.clickBackBtn();
    }

    @When("^user click back button in account$")
    public void userClickBackButtonInAcount() {
        categoryPage.clickAcountBackBtn();
    }

    @Then("^continue button not displayed$")
    public void continueButtonNotDisplayed() {
        Assert.assertTrue(categoryPage.checkContinueButtonNotDisplayed());
    }

    @When("^select multiple categories$")
    public void selectMultipleCategories() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            categoryPage.selectMultipleCategory();
        } else {
            categoryPage.selectFirstCategory();
            categoryPage.selectSecondCategory();
        }

    }

    @Then("^continue button displayed$")
    public void continueButtonDisplayed() {
        Assert.assertTrue(categoryPage.checkContinueButtonDisplayed());
    }

}

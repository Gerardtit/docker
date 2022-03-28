package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_AccountProfilePage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class GG_AccountProfilePageSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    private final GG_AccountProfilePage accountProfilePage = new GG_AccountProfilePage(driver);

    @Then("^verify account profile page is displayed$")
    public void verifyHomeScreenIsDisplayed() throws InterruptedException {
        Assert.assertTrue(accountProfilePage.isAccountProfilePageDisplayed());
        Thread.sleep(2000);
    }

    @And("^click back button on My Account page$")
    public void clickBackButtonOnMyAccountPage() {
        accountProfilePage.clickBackButtonOnMyAccountPage();
    }

    @Then("^Verify header title of the page is \"([^\"]*)\"$")
    public void verify_header_title_of_the_page_is_something(String headerTitle) {
        accountProfilePage.verifyHeaderTitleOfPage(headerTitle);
    }
}

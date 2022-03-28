package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.ClubCardDealsPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClubCardDealsPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public AppiumDevice device = AppiumDeviceManager.getDevice();
    ClubCardDealsPage clubCardDealsPage = new ClubCardDealsPage(driver);


    @When("^user tap on filter$")
    public void user_tap_on_filter() throws Throwable {
        clubCardDealsPage.clickFilter();
    }

    @Then("^verify Sort & Filter window is displayed$")
    public void verify_Sort_Filter_window_is_opened() throws Throwable {
        clubCardDealsPage.verifySortFilterPageDisplayed();
    }

    @When("^user clicks Best Match$")
    public void user_clicks_Best_Match() throws Throwable {
        clubCardDealsPage.clickBestMatch();
    }

    @Then("^verify Sort By window is displayed$")
    public void verify_Sort_By_window_is_displayed() throws Throwable {
        clubCardDealsPage.verifySortByPageDisplayed();
    }

    @Then("^user select Club Card Specials from Sort By window$")
    public void user_select_Club_Card_Specials_from_Sort_By_window() throws Throwable {
        clubCardDealsPage.clickClubCardSpecials();
    }

    @Then("^user clicks back button on Sort By window$")
    public void user_clicks_back_button_on_Sort_By_window() throws Throwable {
        clubCardDealsPage.clickBackButton();
    }

    @Then("^user tap on save in Sort & Filter window$")
    public void user_tap_on_save_in_Sort_Filter_window() throws Throwable {
        clubCardDealsPage.clickSave();
    }

    @Then("^user click on the first product$")
    public void user_click_on_the_first_product() throws Throwable {
        clubCardDealsPage.selectProduct();
        clubCardDealsPage.AddProduct();
    }

    @Then("^check by increasing and decreasing the quantity$")
    public void check_by_increasing_and_decreasing_the_quantity() throws Throwable {
        clubCardDealsPage.IncreaseQuantity();
        clubCardDealsPage.DecreaseQuantity();
    }

    @Then("^verify products are added in cartpage$")
    public void verify_products_are_added_in_cartpage() throws Throwable {
        clubCardDealsPage.checkCartItems();
    }
}

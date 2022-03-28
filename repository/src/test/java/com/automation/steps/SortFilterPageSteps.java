package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.SortFilterPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SortFilterPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    SortFilterPage sortFilterPage = new SortFilterPage(driver);

    @Then("^sort and filter search value page is displayed$")
    public void sortAndFilterSearchValuePageIsDisplayed() {
        sortFilterPage.sortAndFilterPageDisplayed();
    }

    @When("^user clicks Sort By option in Sort & Filter page$")
    public void userClicksSortByOptionInSortFilterPage() {
        sortFilterPage.clickSortBy();
    }

    @And("^user clicks on Sort & Filter icon on the page$")
    public void userClicksSortandFilterIcon() {
        sortFilterPage.clickSortandFilterIcon();
    }

    @Then("^Sort & Filter By option window is displayed$")
    public void sortFilterByOptionWindowIsDisplayed() {
        sortFilterPage.waitForSortFilterByWindowDisplayed();
    }

    @When("^user select Best Match from Sort & Filter By window$")
    public void userSelectBestMatchFromSortFilterByWindow() {
        sortFilterPage.selectBestMatch();
    }

    @When("^user select Club Card Specials from Sort & Filter By window$")
    public void userSelectClubCardSpecialsFromSortFilterByWindow() {
        sortFilterPage.selectClubCardSpecial();
    }

    @When("^user select Reward Card Specials from Sort & Filter By window$")
    public void userSelectRewardCardSpecialsFromSortFilterByWindow() {
        sortFilterPage.selectRewardCardSpecial();
    }

    @When("^user select Most Popular from Sort & Filter By window$")
    public void userSelectMostPopularFromSortFilterByWindow() {
        sortFilterPage.selectMostPopular();
    }

    @When("^user select Price Low to High from Sort & Filter By window$")
    public void userSelectPriceLowToHighFromSortFilterByWindow() {
        sortFilterPage.selectPriceLowToHigh();
    }

    @Then("^user select \"([^\"]*)\" from Sort & Filter By window$")
    public void userSelectAlphabeticalFromSortFilterByWindow(String arg0) {
        sortFilterPage.selectAlphabetical(arg0);
    }

    @Then("^\"([^\"]*)\" text is selected as Sort By option$")
    public void textIsSelectedAsSortByOption(String arg0) {
        sortFilterPage.waitForSelectedSortByOptionDisplayed(arg0);
    }

    @When("^user saves or click done from Sort & Filter page$")
    public void userSavesOrClickDoneFromSortFilterPage() {
        sortFilterPage.clickSavePage();
    }
}

package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_MyItemsPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class GG_MyItemsPageSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_MyItemsPage myItemsPage = new GG_MyItemsPage(driver);


    @And("^allow push notification permission at home page$")
    public void allowPushNotificationPermission() throws InterruptedException {
        Thread.sleep(3000);
        myItemsPage.clickAllowNotificationButton();
        /*if(driver.getPlatformName().equalsIgnoreCase("ios")) {
            Thread.sleep(3000);
            myItemsPage.clickAllowNotificationButton();
            //    welcomePage.clickAllowInNotificaitonPopUp();
            Thread.sleep(5000);
        }else{
            Thread.sleep(5000);
            myItemsPage.clickAllowNotificationButton();

        }*/
    }

    @When("^user click my items button on home screen$")
    public void user_click_myitems_tab() throws Throwable {
        try {
            myItemsPage.clickMyItemsButton();
        } catch (Exception e) {
        }
    }

    @Then("^verify that My Last Order Page is displayed$")
    public void myLastOrderPageIsDisplayed() {
        Assert.assertTrue(myItemsPage.isMyLastOrderPageDisplayed(), "My Last Order button is not selected by default");
    }

    @Then("^verify that 'My List' Page is displayed$")
    public void myListPageIsDisplayed() {
        myItemsPage.waitForPageDisplayed();
    }

    @And("^user click on items found from past purchase screen$")
    public void user_click_items_found_from_past_purchase() throws Throwable {
        try {
            myItemsPage.clickMyItemsFoundonPastPurchase();
        } catch (Exception e) {
        }
    }

    @Then("^verify PDP screen is displayed$")
    public void pdp_screen_is_displayed() throws Throwable {
        myItemsPage.waitForPDPScreenDisplayed();
    }

    @Then("^user clicks deals toggle switch on the my items page$")
    public void userClicksDealsToggleSwitchOnTheSearchPage() {
        myItemsPage.clickDealsToggleSwitch();
    }


    @Then("^\"([^\"]*)\" text is displayed on the my items page$")
    public void textIsDisplayedOnTheScreen(String arg0) throws InterruptedException {
        //orderPage.waitForPageDisplayed();
        Thread.sleep(3000);
        //Assert.assertTrue(myItemsPage.isElementDisplayed());
        myItemsPage.waitForItemsFoundDisplayed();
    }


    @And("^verify Clipped deals is selected in my list tab$")
    public void verifyClippedDealsIsSelectedInMyListTab() {
        Assert.assertTrue(myItemsPage.isClippedDealsSectionIsSelected());
    }

    @When("^click on my last order tab$")
    public void clickOnMyLastOrderTab() {
        myItemsPage.clickOnMyLastOrderTab();

    }

//    @When("^User click on See All in Browse Categories on Home Page$")
//    public void clickOnBrowseCategorySeeAll() throws InterruptedException{
//        homePage.clickSeeAllBrowseCategories();
//    }


}


package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_Deals_AllDealsPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GG_Deals_AllDealsPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_Deals_AllDealsPage dealsPage = new GG_Deals_AllDealsPage(driver);

    @Then("^verify deal cards are displayed in All deals screen$")
    public void verifyDealIsDisplayed() {
        Assert.assertTrue(dealsPage.isDealDisplayed(), "Deal Cards are not displayed");
    }

    @Then("^verify that 'Refine' button is displayed$")
    public void verifyRefineButtonDisplayed() {
        Assert.assertTrue(dealsPage.isRefineButtonDisplayed(), "Refine button is not displayed");
    }

    @Then("^verify total deals count is displayed on all deals page$")
    public void verifyTotalDealsCountDisplayed() {
        Assert.assertTrue(dealsPage.isTotalDealsCountDisplayed(), "Total deals count is not displayed");
    }

    @And("click Clip button on deal")
    public void clickOnClipButton() {
        dealsPage.clickClipButton();
    }

    @And("^click on coupon on all coupons page$")
    public void clickOnCoupon() {
        dealsPage.clickOnFirstCoupon();
    }

    @And("clip a deal and verify the deal is clipped")
    public void clipAndVerify() {
        dealsPage.clipAndVerifyAdded();
    }

    @And("user clips {int} number of deals in all deals screen")
    public void clipDesiredNumberOfDeals(int numberOfDealsToBeClipped) {
        dealsPage.clipDesiredNumberOfDeals(numberOfDealsToBeClipped);
    }

    @Then("^verify that Clip button is displayed for a deal card on All coupons page$")
    public void verifyClipButtonDisplayed() {
        Assert.assertTrue(dealsPage.isClipButtonDisplayed(), "No deal present with Clip CTA");
    }

    @Then("^verify All deals tab is displayed$")
    public void verifyAlldealsTabIsDisplayed() {
        Assert.assertTrue(dealsPage.isAllDealsTabDisplayed(), "All deals tab is not displayed");
    }

    @And("^verify Refine drawer screen is displayed$")
    public void verifyRefineDrawerScreenIsDisplayed() {
        Assert.assertTrue(dealsPage.isRefineDrawerScreenDisplayed(), "Refine drawer is not displayed");
    }

    @And("^click on refine button on All deals tab$")
    public void clickOnRefineButtonOnAllCouponTab() {
        dealsPage.clickRefineButtonOnAllCoupon();
    }

    @And("^click on Show Result Button$")
    public void clickShowResultButton() {
        dealsPage.clickShowResultButton();
    }

    @And("^close refine drawer$")
    public void clickRefineDrawerCloseButton() {
        dealsPage.clickRefineDrawerCloseButton();
    }

    @Then("^verify Close Button in Refine Drawer Screen$")
    public void verifyCloseButtonInRefineDrawerScreen() {
        Assert.assertTrue(dealsPage.isCloseRefineDisplayed(), "Close button on refine drawer is not displayed");
    }

    @Then("^verify 'Reset' button is displayed in refine Screen$")
    public void verifyResetButtonInRefineDrawerScreen() {
        Assert.assertTrue(dealsPage.isResetButtonDisplayed(), "Reset button is not displayed on refine drawer");
    }

    @Then("^verify deals are displayed after applying filter$")
    public void verifyDealsDisplayedAfterFilter() {
        // Here verify if deals are displayed after applying filter
        if (!dealsPage.isShowResultButtonDisplayed()) {
            Assert.assertTrue(dealsPage.isDealDisplayed(), "No deals are displayed after applying filter");
        } else {
            // If there are no deals after applying filter then just close the drawer
            dealsPage.clickRefineDrawerCloseButton();
        }
    }

    @Then("^verify 'Show Results' button is displayed$")
    public void verifyShowResultsButtonDisplayed() {
        Assert.assertTrue(dealsPage.isShowResultButtonDisplayed(), "'Show Results' button is not displayed");
    }

    @When("^rest filters on Refine drawer in All deals screen$")
    public void clickOnResetButton() {
        dealsPage.clickOnResetButton();
    }

    @When("^verify count is displayed with Show Result CTA$")
    public void verifyCountIsDisplayedWithShowResultCTA() {
        Assert.assertTrue(dealsPage.isDealsCountDisplayedOnShowResultsCTA(), "Count of deals is not displayed on Show results CTA");
    }

    @When("^select option \"([^\"]*)\" under Sort By$")
    public void selectOptionUnderSortBy(String filterName) {
        dealsPage.selectFilterByText(filterName);
    }

    @When("^select option \"([^\"]*)\" under Coupons Type$")
    public void selectOptionUnderCouponsType(String filterName) {
        dealsPage.selectFilterByText(filterName);
    }

    @Then("^verify option \"([^\"]*)\" is selected$")
    public void verifyFilterSelected(String filterName) {
        Assert.assertTrue(dealsPage.isFilterSelected(filterName), "Option:" + filterName + "is not selectd");
    }

    @When("^verify option \"([^\"]*)\" under Sort By$")
    public void verifyOptionUnderSortBy(String filterName) {
        dealsPage.isFilterDisplayed(filterName);
    }

    @When("^verify option \"([^\"]*)\" under Coupons Type$")
    public void verifyOptionUnderCouponsType(String filterName) {
        dealsPage.isFilterDisplayed(filterName);
    }


    @And("scroll up till top of the All Deals tab")
    public void scrollUpTillTopOfTheAllDealsTab() {
        dealsPage.scrollTillTopOfScreen();
    }


    @Then("verify offer completed message")
    public void verifyOfferCompletedMessage() {
    }

    @And("user click add button to add qualifying Products")
    public void userClickAddButtonToAddQualifyingProducts() {
    }

    @And("click cancel button after deal search")
    public void clickCancelBtnDealSearch() {
        dealsPage.clickCancelBtnDealSearch();
    }

    @Then("^verify filtered deals count is displayed$")
    public void verifyFilteredDealCountIsDisplayed() {
        Assert.assertTrue(dealsPage.isFilteredDealCountDisplayedAfterSearch(), "Count of filtered deals is not displayed after search");
    }

    @Then("verify error message {string} displayed when user tries to clip a deal while being offline")
    public void verifyNoInternetPopUp(String desiredStatus) {
        if (desiredStatus.contains("not")) {
            Assert.assertFalse(dealsPage.isErrorMessageDisplayed(), "Error message is displayed");
        } else {
            Assert.assertTrue(dealsPage.isErrorMessageDisplayed(), "Error message is not displayed");
        }
    }

    @And("click Ok on popup")
    public void clickOk() {
        dealsPage.clickOkPopUp();
    }

    @Then("verify user navigates to Deals Page and all deals view screen")
    public void verifyDealsPageDisplayed() {
        dealsPage.verifyIfDealsPageDisplayed();
        dealsPage.verifyIfAllDealsScreenSelected();
    }

}

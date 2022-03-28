package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.BasePage;
import com.automation.pages.GG_DashboardWeeklyCouponsPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GG_DashboardWeeklyCouponsSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_DashboardWeeklyCouponsPage dashboardWeeklyCouponsPage = new GG_DashboardWeeklyCouponsPage(driver);
    public BasePage basePage = new BasePage(driver);

    @And("^scroll down upto weekly coupons section$")
    public void scrollDownUptoWeeklyCouponsSection() throws InterruptedException {
        Assert.assertTrue(dashboardWeeklyCouponsPage.scrollDownUptoWeeklyCouponsSection(), "Fresh New Coupons(Weekly coupons) module is not displayed");
    }

    @Then("^verify deal cards under weekly ad coupon$")
    public void verifyDealCardsUnderWeeklyAdCoupon() {
        dashboardWeeklyCouponsPage.verifyDealsCards();
    }

    @Then("^verify weekly coupon section title$")
    public void verifyWeeklyCouponSectionTitle() {
        Assert.assertEquals(dashboardWeeklyCouponsPage.getWeeklyCouponSectionTitle(), "Weekly ad coupons");
    }

    @Then("^verify see all option in weekly coupon$")
    public void verifySeeAllOptionInWeeklyCoupon() {
        dashboardWeeklyCouponsPage.verifySeeAll();
    }

    @Then("^verify selected deal card image$")
    public void verifySelectedDealCardImage() {
        dashboardWeeklyCouponsPage.verifySelectedDealImage();
    }

    @Then("^verify selected deal card clip button$")
    public void verifySelectedDealCardClipButton() {
        dashboardWeeklyCouponsPage.verifySelectedDealClipButton();
    }

    @Then("^verify carousel view for deals$")
    public void verifyCarouselViewForDeals() {
        dashboardWeeklyCouponsPage.verifyCarouselView();
    }

    @When("^tap on next deal card and verify if it is the default deal$")
    public void tapOnNextDealCardVerifyDefault() {
        int index = dashboardWeeklyCouponsPage.clickNextDealCard();
        dashboardWeeklyCouponsPage.isDealSelectedFromFreshNewCouponListDefaultDeal(index);
    }

    @Then("^verify deal discount title$")
    public void verifyDealDiscountTitle() {
        Assert.assertTrue(dashboardWeeklyCouponsPage.verifyDealDiscountTitle());
    }

    @Then("^verify deal subject line$")
    public void verifyDealSubjectLine() {
        Assert.assertTrue(dashboardWeeklyCouponsPage.verifyDealSubjectLine());
    }

    @Then("^verify deal description$")
    public void verifyDealDescription() {
        Assert.assertTrue(dashboardWeeklyCouponsPage.verifyDealDescription());
    }

    @Then("^verify deal expiry date$")
    public void verifyDealExpiryDate() {
        Assert.assertTrue(dashboardWeeklyCouponsPage.verifyDealExpiryDate());
    }

    @Then("^verify first deal in list is the default deal card displayed$")
    public void verifyFirstDealInListIsDefault() {
        Assert.assertTrue(dashboardWeeklyCouponsPage.isDealSelectedFromFreshNewCouponListDefaultDeal(0), "First deal from list is not the default deal");
    }

    @Then("^verify that default deal card is bigger than all deals in coupon carousel$")
    public void verifyDefaultDealImageBiggerThanCarouselImage() {
        Assert.assertTrue(dashboardWeeklyCouponsPage.isDefaultDealImageBiggerThanCarouselImage());
    }

    @When("^click on see All Button of Fresh New Coupon module$")
    public void clickSeeAllFreshNewCoupon() {
        dashboardWeeklyCouponsPage.clickSeeAllFreshCouponLink();
    }

    @And("^verify Fresh New coupons Title$")
    public void verifyFreshNewCouponTitle() {
        Assert.assertTrue(dashboardWeeklyCouponsPage.verifyFreshNewCouponTitle());
    }

    @And("^click cross Button of Fresh New Coupon module$")
    public void clickCrossButtonFreshNewCoupon() {
        dashboardWeeklyCouponsPage.clickFreshNewCouponCrossButton();
    }

    @And("^verify Fresh New coupons cross Button$")
    public void verifyFreshNewCouponCrossButton() {
        Assert.assertTrue(dashboardWeeklyCouponsPage.isFreshNewCouponCrossButtonDisplayed());
    }

    @And("^verify Fresh New coupons Deals Count$")
    public void verifyFreshNewCouponDealsCount() {
        Assert.assertTrue(dashboardWeeklyCouponsPage.isFreshNewCouponDealsCountDisplayed());
    }

    @And("verify weekly coupon card components")
    public void verifyWeeklyCouponCardComponent() {
        Assert.assertTrue(dashboardWeeklyCouponsPage.verifyDealSubjectLine(), "Deal name is not displayed on weekly coupon!");
        Assert.assertTrue(dashboardWeeklyCouponsPage.verifyDealDescription(), "Deal description is not displayed on weekly coupon!");
        Assert.assertTrue(dashboardWeeklyCouponsPage.verifyDealExpiryDate(), "Deal expiration date is not displayed on weekly coupon!");
        Assert.assertTrue(dashboardWeeklyCouponsPage.verifySelectedDealClipButton(), "Clip button is not displayed on weekly coupon!");
    }

    @And("click selected coupon in weekly ad coupons on home screen")
    public void clickSelectedCoupon() {
        dashboardWeeklyCouponsPage.clickOnSelectedCoupon();
    }
}

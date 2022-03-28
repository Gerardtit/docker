package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_DashboardWeeklyCouponsElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GG_DashboardWeeklyCouponsPage extends BasePage {

    private final GG_DashboardWeeklyCouponsElements dashboardWeeklyCouponsElements = new GG_DashboardWeeklyCouponsElements();

    public GG_DashboardWeeklyCouponsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dashboardWeeklyCouponsElements);
    }

    public void verifyDealsCards() {
        scrollDownForElement(dashboardWeeklyCouponsElements.dealCard);
    }

    public String getWeeklyCouponSectionTitle() {
        scrollDownForElement(dashboardWeeklyCouponsElements.sectionTitle);
        return dashboardWeeklyCouponsElements.sectionTitle.getText();
    }

    public void verifySeeAll() {
        waitVar.until(ExpectedConditions.visibilityOf(dashboardWeeklyCouponsElements.seeAllFreshNewCoupons));
    }

    public void verifySelectedDealImage() {
        scrollDownForElement(dashboardWeeklyCouponsElements.dealImage);
        waitVar.until(ExpectedConditions.visibilityOf(dashboardWeeklyCouponsElements.dealImage));
    }

    public boolean verifySelectedDealClipButton() {
        scrollDownForElement(dashboardWeeklyCouponsElements.dealClip);
        return isElementDisplayed(dashboardWeeklyCouponsElements.dealClip);
    }

    public void verifyCarouselView() {
        scrollDownForElement(dashboardWeeklyCouponsElements.freshNewCouponCarousel);
    }

    public int clickNextDealCard() {
        int index;
        scrollDownForElement(dashboardWeeklyCouponsElements.freshNewCouponCarousel);
        if (dashboardWeeklyCouponsElements.freshNewCouponsCarouselDealImage.size() > 1) {
            index = dashboardWeeklyCouponsElements.freshNewCouponsCarouselDealImage.size() >= 4 ? 3 : dashboardWeeklyCouponsElements.freshNewCouponsCarouselDealImage.size() - 1;

            new CommonActions(driver).new ClickAction().clickElement(dashboardWeeklyCouponsElements.freshNewCouponsCarouselDealImage.get(index));
        } else {
            index = 0;
            new CommonActions(driver).new ClickAction().clickElement(dashboardWeeklyCouponsElements.freshNewCouponsCarouselDealImage.get(index));

        }

        return index;
    }

    public boolean verifyDealDiscountTitle() {
        return scrollDownForElement(dashboardWeeklyCouponsElements.dealDiscountTitle);
    }

    public boolean verifyDealSubjectLine() {
        return scrollDownForElement(dashboardWeeklyCouponsElements.dealSubjectLine);
    }

    public boolean verifyDealDescription() {
        return scrollDownForElement(dashboardWeeklyCouponsElements.dealDescription);
    }

    public boolean verifyDealExpiryDate() {
        return scrollDownForElement(dashboardWeeklyCouponsElements.dealExpiryDate);
    }

    public boolean isDealSelectedFromFreshNewCouponListDefaultDeal(int index) {
        scrollDownForElement(dashboardWeeklyCouponsElements.sectionTitle);
        scrollDownForElement(dashboardWeeklyCouponsElements.dealSubjectLine);
        boolean isSame = false;

        String dealNameDefault = dashboardWeeklyCouponsElements.dealSubjectLine.getText().trim();
        String dealNameCarousel = "";
        scrollDownForElement(dashboardWeeklyCouponsElements.freshNewCouponsCarouselFirstDealImage);

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            dealNameCarousel = dashboardWeeklyCouponsElements.freshNewCouponsCarouselDealContainer.get(index).getAttribute("name").trim();
            if (dealNameDefault.contains(dealNameCarousel)) {
                isSame = true;
            }
        } else {
            dealNameCarousel = dashboardWeeklyCouponsElements.freshNewCouponsCarouselDealContainer.get(index).getAttribute("content-desc").trim();
            if (dealNameCarousel.contains(dealNameDefault)) {
                isSame = true;
            }
        }
        return isSame;
    }

    public boolean isDefaultDealImageBiggerThanCarouselImage() {
        scrollDownForElement(dashboardWeeklyCouponsElements.dealExpiryDate);
        Dimension defaultDealDimension = dashboardWeeklyCouponsElements.dealCard.getSize();
        int defaultDealDimensionWidth = defaultDealDimension.getWidth();
        int defaultDealDimensionHeight = defaultDealDimension.getHeight();

        scrollDownForElement(dashboardWeeklyCouponsElements.freshNewCouponsCarouselFirstDealImage);
        Dimension carouselDealDimension = dashboardWeeklyCouponsElements.freshNewCouponsCarouselDealImage.get(0).getSize();
        int carouselDealDimensionWidth = carouselDealDimension.getWidth();
        int carouselDealDimensionHeight = carouselDealDimension.getHeight();


        if (defaultDealDimensionWidth > carouselDealDimensionWidth && defaultDealDimensionHeight > carouselDealDimensionHeight) {
            return true;
        } else {
            return false;
        }

    }

    public boolean scrollDownUptoWeeklyCouponsSection() {
        return scrollDownForElement(dashboardWeeklyCouponsElements.sectionTitle);
    }

    public void clickSeeAllFreshCouponLink() {

        new CommonActions(driver).new ClickAction().clickElement(dashboardWeeklyCouponsElements.seeAllFreshNewCoupons);

    }

    public boolean verifyFreshNewCouponTitle() {
        return isElementDisplayed(dashboardWeeklyCouponsElements.freshNewCouponTitle);
    }

    public boolean isFreshNewCouponCrossButtonDisplayed() {
        return isElementDisplayed(dashboardWeeklyCouponsElements.crossButtonFreshNewCoupon);
    }

    public void clickFreshNewCouponCrossButton() {

        new CommonActions(driver).new ClickAction().clickElement(dashboardWeeklyCouponsElements.crossButtonFreshNewCoupon);

    }

    public boolean isFreshNewCouponDealsCountDisplayed() {
        return isElementDisplayed(dashboardWeeklyCouponsElements.dealsCountFreshNewCoupon);
    }

    public void clickOnSelectedCoupon() {

        new CommonActions(driver).new ClickAction().clickElement(dashboardWeeklyCouponsElements.dealImage);

    }
}

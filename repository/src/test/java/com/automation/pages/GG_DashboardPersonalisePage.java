package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_DashboardPersonalisePageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;

public class GG_DashboardPersonalisePage extends BasePage {

    private final GG_DashboardPersonalisePageElements dashboardPersonaliseElements = new GG_DashboardPersonalisePageElements();

    public GG_DashboardPersonalisePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dashboardPersonaliseElements);
    }

    public boolean verifySeeAllButtonForMustHaveGrabs() {
        return isElementDisplayed(dashboardPersonaliseElements.seeAllMustHaveGrabs, 15);
    }

    public boolean isMustHaveGrabsDisplayed() {
        return isElementDisplayed(dashboardPersonaliseElements.mustHaveGrabsLabel, 15);
    }

    public boolean isBuyItAgainDisplayed() {
        return isElementDisplayed(dashboardPersonaliseElements.buyItAgainLabel, 15);
    }

    public boolean verifySeeAllButtonForBuyItGain() {
        return isElementDisplayed(dashboardPersonaliseElements.seeAllBuyItAgain, 15);
    }

    public void clickSeeAllButtonBuyItAgain() {

        isElementDisplayed(dashboardPersonaliseElements.seeAllBuyItAgain, 15);
        new CommonActions(driver).new ClickAction().clickElement(dashboardPersonaliseElements.seeAllBuyItAgain);
    }

    public void clickSeeAllButtonMustHaveGrabs() {
        isElementDisplayed(dashboardPersonaliseElements.seeAllMustHaveGrabs, 15);
        new CommonActions(driver).new ClickAction().clickElement(dashboardPersonaliseElements.seeAllMustHaveGrabs);

    }

    public boolean verifyMustHaveGrabsScreen() {
        return (isElementDisplayed(dashboardPersonaliseElements.getMustHaveGrabsTitle, 15));
    }

    public boolean verifyDealCardsInPersonalisedSection() {
        return isElementDisplayed(dashboardPersonaliseElements.productCard, 15);
    }

    public boolean hasCarouselViewPersonalizedProducts() throws InterruptedException {
        int maxSwipesForCard;
        boolean hasCarouselView = false;

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            maxSwipesForCard = 25;
        } else {
            maxSwipesForCard = 15;
        }

        ArrayList<String> dealDescList = new ArrayList<String>();
        String currentDealDescription = dashboardPersonaliseElements.dealCardContainer.get(0).getText();
        dealDescList.add(currentDealDescription);
        if (dashboardPersonaliseElements.dealCardContainer.size() > 1) {
            int counter = 0;
            boolean moreDealsLeftToSwipe = true;
            while (moreDealsLeftToSwipe) {
                while (counter < maxSwipesForCard) {
                    slideTheDealCardFromRightToLeft(dashboardPersonaliseElements.dealCardContainer.get(1));
                    Thread.sleep(500);
                    currentDealDescription = dashboardPersonaliseElements.dealCardContainer.get(0).getText();
                    if (!dealDescList.contains(currentDealDescription)) {
                        dealDescList.add(currentDealDescription);
                        break;
                    }
                    if (dealDescList.size() >= 3) {
                        counter = maxSwipesForCard;
                        break;
                    }
                    counter++;
                }

                if (counter >= maxSwipesForCard) {
                    for (int k = 0; k < dashboardPersonaliseElements.dealCardContainer.size(); k++) {
                        if (!dealDescList.contains(dashboardPersonaliseElements.dealCardContainer.get(k).getText())) {
                            dealDescList.add(dashboardPersonaliseElements.dealCardContainer.get(k).getText());
                        }
                    }

                    moreDealsLeftToSwipe = false;
                }
            }
        }

        if (dealDescList.size() > 0) {
            hasCarouselView = true;
        }
        return hasCarouselView;
    }

    public void slideTheDealCardFromRightToLeft(MobileElement ele) {
        Point pt = ele.getLocation();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            scroll(100, pt.getY(), 30, pt.getY());
        } else {
            scroll(pt.getX() + 100, pt.getY(), pt.getX() - 50, pt.getY());
        }

    }


    public boolean isClipYourdealsDisplayed() {
        return (isElementDisplayed(dashboardPersonaliseElements.clipYourdealsTitle));
    }

    public boolean isClipYourFavoritesDisplayed() {
        return (isElementDisplayed(dashboardPersonaliseElements.clipYourDealsTitle));

    }

    public void clickBackButtonInMustHaveGrabs() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPersonaliseElements.backBtnMustHaveGrabs);
    }


    public void clickOnProductCard() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPersonaliseElements.productCard);

    }

    public Boolean verifyCountDisplayed() {
        return isCountDisplayed(dashboardPersonaliseElements.clipYourDealsCount);
    }

    public boolean isCountDisplayed(MobileElement element) {

        boolean isCountDisplayed = false;
        String count;
        count = element.getText().replaceAll("[^0-9]", "");
        if (count != null) {
            isCountDisplayed = true;
        }
        return isCountDisplayed;
    }

    public void clickSeeAllClipYourDeals() {
        isElementDisplayed(dashboardPersonaliseElements.seeAllClipYourDeals, 15);
        new CommonActions(driver).new ClickAction().clickElement(dashboardPersonaliseElements.seeAllClipYourDeals);
    }

    public void clickOnSpecificDeal() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPersonaliseElements.specialDeal);
    }

    public void validateOfferDetailsEligibleProducts() {
        Assert.assertTrue(dashboardPersonaliseElements.specialDealOfferDetails.isDisplayed(), "Offer Details are not displayed on Deals details page");
        Assert.assertTrue(dashboardPersonaliseElements.specialDealEligibleProducts.isDisplayed(), "Eligible Products are not displayed on Deals details page");
    }

    public void clickOnClipDeal() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPersonaliseElements.clipDeal);
    }


    public void clickOnViewList() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPersonaliseElements.viewList);

    }

    public void clippedItemAtList() {
        dashboardPersonaliseElements.clippedatlistOnMylist.isDisplayed();
//        dashboardPersonaliseElements.clippedatlistOnMylist.click();
    }

    public void validateOfferDetailsEligibleProductsMyList() {
        new CommonActions(driver).new ClickAction().clickElement(dashboardPersonaliseElements.offerMyList);
        Assert.assertTrue(dashboardPersonaliseElements.specialDealOfferDetails.isDisplayed(), "Offer Details are not displayed on Deals details page");
        Assert.assertTrue(dashboardPersonaliseElements.specialDealEligibleProducts.isDisplayed(), "Eligible Products are not displayed on Deals details page");
    }
}

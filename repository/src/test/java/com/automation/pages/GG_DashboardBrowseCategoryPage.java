package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_DashboardBrowseCategoryPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;

public class GG_DashboardBrowseCategoryPage extends BasePage {

    private final GG_DashboardBrowseCategoryPageElements browseCategoryPageElements = new GG_DashboardBrowseCategoryPageElements();

    public GG_DashboardBrowseCategoryPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), browseCategoryPageElements);
    }

    public void verifyBrowseCategory() {
        Assert.assertTrue(browseCategoryPageElements.browseCategoryCard.size() >= 1);
    }

    public void verifySeeAll() {
        waitVar.until(ExpectedConditions.visibilityOf(browseCategoryPageElements.browseCategorySeeAll));
    }

    public void clickSeeAll() {
        new CommonActions(driver).new ClickAction().clickElement(browseCategoryPageElements.browseCategorySeeAll);
    }

    public String getCategoryName() {
        return browseCategoryPageElements.firstBrowseCategoryCard.getText();
    }

    public void verifyCardImage() {
        waitVar.until(ExpectedConditions.visibilityOf(browseCategoryPageElements.cardImage));
    }

    public void verifyBrowseCategorySectionTitle() {
        waitVar.until(ExpectedConditions.visibilityOf(browseCategoryPageElements.browseCategoriesLabel));
    }

    public WebElement getCardName() {
        return browseCategoryPageElements.cardName;
    }

    public void clickCardName() {

        scrollDownForElement(browseCategoryPageElements.firstBrowseCategoryCard, 2);
        new CommonActions(driver).new ClickAction().clickElement(browseCategoryPageElements.firstBrowseCategoryCard);

    }

    public void clickBackButtonInDetailsPage() {
        new CommonActions(driver).new ClickAction().clickElement(browseCategoryPageElements.backButtonInDetailsPage);
    }

    public void clickBackButtonCheckoutPageInDetailsPage() {
        new CommonActions(driver).new ClickAction().clickElement(browseCategoryPageElements.backButtonheckoutPageInDetailsPage);
    }

    public void verifyRefineButton() {
        waitVar.until(ExpectedConditions.visibilityOf(browseCategoryPageElements.refineButton));
    }

    public void verifyDealCard() {
        waitVar.until(ExpectedConditions.visibilityOf(browseCategoryPageElements.dealCard));
    }

    public boolean scrollDownToBrowseCategory() {
        return scrollDownForElement(browseCategoryPageElements.browseCategoriesLabel);
    }

    public int getCategoriesCountOnBrowsePage() {
        return browseCategoryPageElements.categoryName.size();
    }

    public void slideTheAisleCardFromRightToLeft(MobileElement ele) throws InterruptedException {
        Point pt = ele.getLocation();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            scroll(100, pt.getY(), 30, pt.getY());
        } else {
            scroll(pt.getX() + 100, pt.getY(), pt.getX() - 20, pt.getY());
        }
        Thread.sleep(500);
    }

    public void slideTheAisleCardFromLeftToRight(MobileElement ele) throws InterruptedException {
        Point pt = ele.getLocation();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            scroll(30, pt.getY(), 100, pt.getY());
        } else {
            scroll(pt.getX() - 20, pt.getY(), pt.getX() + 100, pt.getY());
        }
        Thread.sleep(500);
    }

    public boolean hasCarouselViewCategories(String swipeDirection) throws InterruptedException {
        int maxSwipesForCard;
        boolean hasCarouselView = false;
        if (!isElementDisplayed(browseCategoryPageElements.categoryCardsCarousel)) {
            return hasCarouselView;
        }

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            maxSwipesForCard = 25;
        } else {
            maxSwipesForCard = 15;
        }

        ArrayList<String> categoryCardList = new ArrayList<String>();
        String currentCategoryCard = browseCategoryPageElements.browseCategoryCard.get(0).getText();
        categoryCardList.add(currentCategoryCard);
        if (browseCategoryPageElements.browseCategoryCard.size() > 1) {
            int counter = 0;
            boolean moreCardsLeftToSwipe = true;
            while (moreCardsLeftToSwipe) {
                while (counter < maxSwipesForCard) {

                    switch (swipeDirection) {
                        case "LEFT":
                            slideTheAisleCardFromRightToLeft(browseCategoryPageElements.browseCategoryCard.get(1));
                            break;
                        case "RIGHT":
                            slideTheAisleCardFromLeftToRight(browseCategoryPageElements.browseCategoryCard.get(1));
                            break;
                    }

                    currentCategoryCard = browseCategoryPageElements.browseCategoryCard.get(0).getText();

                    if (!categoryCardList.contains(currentCategoryCard)) {
                        categoryCardList.add(currentCategoryCard);
                        break;
                    }
                    if (categoryCardList.size() >= 5) {
                        counter = maxSwipesForCard;
                        break;
                    }
                    counter++;
                }
                if (counter >= maxSwipesForCard) {
                    for (int k = 0; k < browseCategoryPageElements.browseCategoryCard.size(); k++) {
                        if (!categoryCardList.contains(browseCategoryPageElements.browseCategoryCard.get(k).getText())) {
                            categoryCardList.add(browseCategoryPageElements.browseCategoryCard.get(k).getText());
                        }
                    }

                    moreCardsLeftToSwipe = false;
                }
            }
        }

        if (categoryCardList.size() > 0) {
            hasCarouselView = true;
        }
        return hasCarouselView;
    }

    public void verifyCategoryCardsMovementFromLeftToRight() throws InterruptedException {
        Assert.assertTrue(hasCarouselViewCategories("RIGHT"), "Browse category cards are not swiped from right to left");
    }

    public void verifyCategoryCardsMovementFromRightToLeft() throws InterruptedException {
        Assert.assertTrue(hasCarouselViewCategories("LEFT"), "Browse category cards are not swiped from left to right");
    }

    public boolean isBrowseTabNavigated() {
        return isElementDisplayed(browseCategoryPageElements.browseTab);
    }

    public boolean scrollDownToBrowseDeals() {
        return scrollDownForElement(browseCategoryPageElements.browseDealsLabel);
    }

}

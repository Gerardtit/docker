package com.automation.pages.mealsPages;

import com.automation.pageElements.meals.pageElements.ReviewPlanPageElements;
import com.automation.pageElements.meals.pageElements.ShopIngredientsPageElements;
import com.automation.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ReviewPlanPage extends BasePage {

    ReviewPlanPageElements reviewPlanPageElements = new ReviewPlanPageElements();
    ShopIngredientsPageElements shopIngredientsElements = new ShopIngredientsPageElements();
    MealsUtils mealsUtils = new MealsUtils(driver);
    MealsHomePage mealsHomePage = new MealsHomePage(driver);

    public ReviewPlanPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), reviewPlanPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), shopIngredientsElements);
    }

    public void clickReviewYourPlanButton() {
        if (!mealsUtils.checkMobileElementExist(reviewPlanPageElements.reviewPlanButton)) {
            mealsHomePage.restartAppAndGoToMealsHomePage();
            mealsHomePage.clickQuickAddRecentlyCreatedRecipeOne();
        }
        waitForClickableAndClick(reviewPlanPageElements.reviewPlanButton);
    }

    public boolean verifyReviewPlanPageIsDisplayed() {
        try {
            //Todo if not displayed then write steps to display because it can happen when weird state
            //Todo remove in next build
            waitForDisplayed(reviewPlanPageElements.editButton, 10);
            reviewPlanPageElements.reviewYourPlanPageTitle.isDisplayed();
            reviewPlanPageElements.editButton.isDisplayed();
            reviewPlanPageElements.recipeItemAddedInPlan.isDisplayed();
            //Todo locator strategy not working, perhaps remove
            //reviewPlanPageElements.numberOfServingsButtonInPlan.isDisplayed();
            reviewPlanPageElements.shopIngredientsButton.isDisplayed();
            return true;
        } catch (Exception e) {
            if (!mealsUtils.checkMobileElementExist(reviewPlanPageElements.reviewPlanButton)) {
                mealsHomePage.goToMealsHomePage();
                mealsHomePage.clickOnMostPopularRecipeItemOneQuickAdd();
                waitForClickableAndClick(reviewPlanPageElements.reviewPlanButton);
                reviewPlanPageElements.editButton.isDisplayed();
                reviewPlanPageElements.recipeItemAddedInPlan.isDisplayed();
                return true;
            }
            return false;
        }
    }
}

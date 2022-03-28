package com.automation.pages.mealsPages;

import com.automation.pageElements.meals.pageElements.MyMealsCookingPageElements;
import com.automation.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyMealsCookingPage extends BasePage {

    MyMealsCookingPageElements myMealsCookingPageElements = new MyMealsCookingPageElements();
    EditUserPreferencesPage editUserPreferencesPage = new EditUserPreferencesPage(driver);
    MealsHomePage mealsHomePage = new MealsHomePage(driver);
    MealsUtils mealsUtils = new MealsUtils(driver);
    ReviewPlanPage reviewPlanPage = new ReviewPlanPage(driver);
    ShopIngredientsPlanPage shopIngredientsPlanPage = new ShopIngredientsPlanPage(driver);


    public MyMealsCookingPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), myMealsCookingPageElements);
    }

    public void clickStartCookingButton() {
        if (!isElementDisplayed(myMealsCookingPageElements.startCookingButton)) {
            shopRecipeAndBackToMealsHomePage();
        }
        myMealsCookingPageElements.startCookingButton.click();
    }

    public void clickBackButton() {
        myMealsCookingPageElements.backButton.click();
    }

    public void cookingModeStep1IsDisplayed() {
        if (!isElementDisplayed(myMealsCookingPageElements.step1Text)) {
            if (isElementDisplayed(myMealsCookingPageElements.gotItButton)) {
                waitForClickableAndClick(myMealsCookingPageElements.gotItButton);
            }
        }
        Assert.assertTrue(myMealsCookingPageElements.step1Text.isDisplayed());
        Assert.assertTrue(myMealsCookingPageElements.overviewButton.isDisplayed());
        Assert.assertTrue(myMealsCookingPageElements.nextButton.isDisplayed());
    }

    public void clickDoneButtonOnLastStepOfCookingMode() {
        while (mealsUtils.checkMobileElementIsDisplayed(myMealsCookingPageElements.nextButton)) {
            waitForClickableAndClick(myMealsCookingPageElements.nextButton);
            if (mealsUtils.checkMobileElementIsDisplayed(myMealsCookingPageElements.doneButton)) {
                waitForClickableAndClick(myMealsCookingPageElements.doneButton);
            }
        }
    }

    public void verifyMyMealsPageIsDisplayed() {
        Assert.assertTrue(myMealsCookingPageElements.myMealsPageScene.isDisplayed());
        Assert.assertTrue(myMealsCookingPageElements.navBarHeader.getText().contains("meals"));
        Assert.assertTrue(myMealsCookingPageElements.plannedTab.isDisplayed());
        Assert.assertTrue(myMealsCookingPageElements.cookedTab.isDisplayed());
    }

    public void clickPlannedTab() {
        waitForClickableAndClick(myMealsCookingPageElements.plannedTab);
    }

    public void clickCookedTab() {
        waitForClickableAndClick(myMealsCookingPageElements.cookedTab);
    }

    public void verifyRecipeShownInCooked() {
        Assert.assertTrue(myMealsCookingPageElements.cookedMealItemOne.isDisplayed());
    }

    public void clickSeeAllMyMealsOrShowPastMealsButtonOnMealsHomepage() {
        if (mealsUtils.checkMobileElementIsDisplayed(myMealsCookingPageElements.seeAllMyMealsButton)) {
            myMealsCookingPageElements.seeAllMyMealsButton.click();
            return;
        } else if (mealsUtils.checkMobileElementIsDisplayed(myMealsCookingPageElements.showPastMealsButton)) {
            myMealsCookingPageElements.showPastMealsButton.click();
            return;
        } else {
            shopRecipeAndBackToMealsHomePage();
            myMealsCookingPageElements.seeAllMyMealsButton.click();
            return;
        }
    }

    public void shopRecipeAndBackToMealsHomePage() {
        try {
            mealsHomePage.clickOnMostPopularRecipeItemTwoQuickAdd();
        } catch (Exception e) {
            mealsHomePage.clickQuickAddRecentlyCreatedRecipeOne();
        }
        reviewPlanPage.clickReviewYourPlanButton();
        shopIngredientsPlanPage.clickShopIngredientsButton();
        shopIngredientsPlanPage.clickShopForDeliveryOrPickUpButton();
        shopIngredientsPlanPage.clickAddProductsToCart();
        shopIngredientsPlanPage.clickViewMyMeals();
    }
}

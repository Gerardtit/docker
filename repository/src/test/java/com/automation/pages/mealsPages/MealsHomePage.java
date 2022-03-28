package com.automation.pages.mealsPages;

import com.automation.pageElements.meals.pageElements.MealsHomePageElements;
import com.automation.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MealsHomePage extends BasePage {

    //todo: fallback logic handling

    MealsHomePageElements mealsHomePageElements = new MealsHomePageElements();
    MealsUtils mealsUtils = new MealsUtils(driver);
    UMAHomePage umaHomePage = new UMAHomePage(driver);
    OnBoardingPage onBoardingPage = new OnBoardingPage(driver);

    public MealsHomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), mealsHomePageElements);
    }

    public boolean verifyMealsHomePageIsDisplayed() {
        return mealsUtils.checkMobileElementExist(mealsHomePageElements.mealsText);
    }

    public void clickBackButton() {
        waitForClickableAndClick(mealsHomePageElements.mealsHomePageBackButton);
    }

    public void clickOnCuisineType() {
        try {
            waitForClickableAndClick(mealsHomePageElements.cuisineTypeCard);
        } catch (Exception e) {
            goToMealsHomePage();
            waitForClickableAndClick(mealsHomePageElements.cuisineTypeCard);
        }
    }

    public void clickOnThirdCuisineType() {
        waitForClickableAndClick(mealsHomePageElements.thirdCuisineTypeCard);
    }

    public void clickOnSecondCuisineType() {
        try {
            waitForClickableAndClick(mealsHomePageElements.secondCuisineTypeCard);
        } catch (Exception e) {
            restartAppAndGoToMealsHomePage();
            waitForClickableAndClick(mealsHomePageElements.secondCuisineTypeCard);
        }
    }

    public void clickOnMostPopularRecipeItemOneQuickAdd() {
        mealsHomePageElements.quickAddMostPopularRecipeItemOneTile.click();
    }

    public void clickOnMostPopularRecipeItemTwoQuickAdd() {
        mealsHomePageElements.quickAddMostPopularRecipeItemTwoTile.click();
    }

    public void clickQuickAddRecentlyCreatedRecipeOne() {
        //todo if added then remove then add, can happen if data was not reset
        scrollDownForElement(mealsHomePageElements.recentlyCreatedRecipeItemOneTileQuickAdd);
        if (platformName.equalsIgnoreCase("android")) {
            scrollDown(2);
            waitForClickableAndClick(mealsHomePageElements.recentlyCreatedRecipeItemOneTileQuickAdd);
        } else {
            mealsHomePageElements.recentlyCreatedRecipeItemOneTileQuickAdd.click();
        }
    }


    public void clickOnMostPopularRecipeItemOne() {
        MobileElement mostPopularRecipeItemOneTile = mealsHomePageElements.mostPopularRecipeItemOneTile;
        scrollDownForElement(mostPopularRecipeItemOneTile);
        if (platformName.equalsIgnoreCase("android")) {
            scrollDown(2);
            waitForClickableAndClick(mostPopularRecipeItemOneTile);
        } else {
            mostPopularRecipeItemOneTile.click();
        }
    }

    public void clickQuickAddTopRatedRecipeOne() {
        //todo if added then remove then add, can happen if data was not reset
        scrollDownForElement(mealsHomePageElements.topRatedRecipeItemTileOneQuickAdd);
        if (platformName.equalsIgnoreCase("android")) {
            scrollDown(2);
            waitForClickableAndClick(mealsHomePageElements.topRatedRecipeItemTileOneQuickAdd);
        } else {
            mealsHomePageElements.topRatedRecipeItemTileOneQuickAdd.click();
        }
    }

    public boolean verifyFavoriteRecipeIsDisplayed() {
        //todo if not added in favorite then add in favorite first
        if (mealsUtils.checkMobileElementExist(mealsHomePageElements.collectionFavoriteThumbItemOne)) {
            mealsHomePageElements.collectionFavoriteThumbItemOne.isDisplayed();
            mealsHomePageElements.collectionFavorite.isDisplayed();
            return true;
        } else {
            return false;
        }
    }

    public void clickFavoriteRecipeItemOne() {
        //todo if not added in favorite then add in favorite first
        waitForDisplayed(mealsHomePageElements.collectionFavoriteThumbItemOne, 10);
        mealsHomePageElements.collectionFavoriteThumbItemOne.click();
    }

    public void clickBackButtonUntilMealsHomePageIsDisplayed() {
        int i = 0;
        while (!verifyMealsHomePageIsDisplayed()) {
            clickBackButton();
            i = i + 1;
            if (i > 5) {
                goToMealsHomePage();
                break;
            }
        }
    }

    public boolean goToMealsHomePage() {
        boolean verifyMealsHomePageIsDisplayed = verifyMealsHomePageIsDisplayed();
        if (!verifyMealsHomePageIsDisplayed) {
            try {
                if (!umaHomePage.mealPlansHaloNavCarouselButtonIsDisplayed()) {
                    umaHomePage.navigateToUMAHomepage();
                }
                umaHomePage.clickMealsPlanButtonOnHaloNavCarousel();
                if (onBoardingPage.verifyOnboardingPageIsDisplayed()) {
                    onBoardingPage.clickSkipButton();
                }
                verifyMealsHomePageIsDisplayed = verifyMealsHomePageIsDisplayed();
                return verifyMealsHomePageIsDisplayed;
            } catch (Exception e) {
                umaHomePage.navigateToUMAHomepage();
                umaHomePage.clickOnMealsMenuBanner();
                if (onBoardingPage.verifyOnboardingPageIsDisplayed()) {
                    onBoardingPage.clickSkipButton();
                }
                verifyMealsHomePageIsDisplayed = verifyMealsHomePageIsDisplayed();
                return verifyMealsHomePageIsDisplayed;
            }
        } else {
            System.out.println("on meals home page");
            return verifyMealsHomePageIsDisplayed;
        }
    }

    public void restartAppAndGoToMealsHomePage() {
        try {
            umaHomePage.navigateToUMAHomepage();
            umaHomePage.clickMealsPlanButtonOnHaloNavCarousel();
            if (onBoardingPage.verifyOnboardingPageIsDisplayed()) {
                onBoardingPage.clickSkipButton();
            }
            verifyMealsHomePageIsDisplayed();
        } catch (Exception e) {
            umaHomePage.navigateToUMAHomepage();
            umaHomePage.clickOnMealsMenuBanner();
            if (onBoardingPage.verifyOnboardingPageIsDisplayed()) {
                onBoardingPage.clickSkipButton();
            }
            verifyMealsHomePageIsDisplayed();
        }
    }

    public void verifySearchIsDisplayed() {
        isElementDisplayed(mealsHomePageElements.searchIcon, 10);
        Assert.assertTrue(mealsHomePageElements.searchIcon.isDisplayed());
    }

    public void verifyMealsTextIsDisplayed() {
        Assert.assertTrue(mealsHomePageElements.mealsText.isDisplayed());
    }

    public void editPreferencesIsDisplayed() {
        isElementDisplayed(mealsHomePageElements.editPreferencesButton, 10);
        Assert.assertTrue(mealsHomePageElements.editPreferencesButton.isDisplayed());
    }

    public void mostPopularRecipeIsDisplayed() {
        scrollTop();
        scrollDownForElement(mealsHomePageElements.mostPopularText);
        Assert.assertTrue(mealsHomePageElements.mostPopularText.isDisplayed());
    }

    public void topRatedRecipeIsDisplayed() {
        scrollTop();
        scrollDownForElement(mealsHomePageElements.topRatedText);
        Assert.assertTrue(mealsHomePageElements.topRatedText.isDisplayed());
    }

    public void vegetarianRecipeIsDisplayed() {
        scrollTop();
        scrollDownForElement(mealsHomePageElements.vegetarianText);
        Assert.assertTrue(mealsHomePageElements.vegetarianText.isDisplayed());
    }

    public void cuisineTypeCardIsDisplayed() {
        waitForDisplayed(mealsHomePageElements.cuisineTypeCard, 10);
        Assert.assertTrue(mealsHomePageElements.cuisineTypeCard.isDisplayed());
        Assert.assertTrue(mealsHomePageElements.secondCuisineTypeCard.isDisplayed());
    }
}

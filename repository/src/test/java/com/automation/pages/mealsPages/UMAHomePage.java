package com.automation.pages.mealsPages;

import com.automation.helpers.AppActions;
import com.automation.pageElements.GG_DashboardPageElements;
import com.automation.pageElements.meals.pageElements.UMAHomePageElements;
import com.automation.pages.BasePage;
import com.automation.pages.GG_DashboardPage;
import com.automation.pages.StartUpPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class UMAHomePage extends BasePage {

    private GG_DashboardPageElements dashboardPageElements = new GG_DashboardPageElements();
    private final UMAHomePageElements umaHomePageElements = new UMAHomePageElements();
    GG_DashboardPage dashboardPage = new GG_DashboardPage(driver);
    StartUpPage startUpPage = new StartUpPage(driver);

    public UMAHomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dashboardPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), umaHomePageElements);
    }

    public void clickOnMealsMenuBanner() {
        try {
            locateMealsMenu();
            waitForClickableAndClick(umaHomePageElements.mealsHomeBanner);
        } catch (Exception e) {
            navigateToUMAHomepage();
            locateMealsMenu();
            waitForClickableAndClick(umaHomePageElements.mealsHomeBanner);
        }
    }

    public boolean verifyMealsMenuBarIsClickable() {
        ExpectedConditions.elementToBeClickable(umaHomePageElements.mealsHomeBanner);
        return umaHomePageElements.mealsHomeBanner.isEnabled();
    }

    public boolean verifyMealsMenuBarIsDisplayed() {
        boolean result;
        try {
            waitForDisplayed(umaHomePageElements.mealsHomeBanner, 10);
            result = umaHomePageElements.mealsHomeBanner.isDisplayed();
            return result;
        } catch (Exception e) {
            return false;
        }
    }

    public void locateMealsMenu() {
        try {
            scrollDownForElement(umaHomePageElements.mealsHomeBanner);
            umaHomePageElements.mealsHomeBanner.isDisplayed();
        } catch (Exception e) {
            navigateToUMAHomepage();
            scrollDownForElement(umaHomePageElements.mealsHomeBanner);
            umaHomePageElements.mealsHomeBanner.isDisplayed();
        }
    }

    //todo create method for waitingUntilLaunch complete so that android app does not show not responding pop-up
    public void navigateToUMAHomepage() {
        try {
            AppActions appActions = new AppActions();
            appActions.terminateApp();
            appActions.relaunchApp();
            Thread.sleep(5000);
            if (platformName.equalsIgnoreCase("android")) {
                try {
                    if (dashboardPage.waitForCacheContinue(20)) {
                        dashboardPage.clickContinueCache();
                    } else {
                        Thread.sleep(7500);
                    }
                    startUpPage.clickContinue();
                } catch (Exception e) {

                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void goToHomeTab() {
        if (!isElementDisplayed(dashboardPageElements.homeTab)) {
            navigateToUMAHomepage();
            //todo remove the if condition and apply to both platforms if there are any failures related to this step
            if (platformName.equalsIgnoreCase("android")) {
                try {
                    dashboardPage.clickHomeTab();
                    dashboardPage.handlePopUpsAndTutorialOnDashboard();
                    startUpPage.clickContinue();
                } catch (Exception e) {

                }
            }
        } else {
            scrollUpForElement(umaHomePageElements.mealPlansCarouselButton);
        }
    }

    public boolean mealPlansHaloNavCarouselButtonIsDisplayed() {
        boolean result;
        try {
            waitForDisplayed(umaHomePageElements.mealPlansCarouselButton, 10);
            result = umaHomePageElements.mealPlansCarouselButton.isDisplayed();
            return result;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean mealPlansHaloNavCarouselButtonIsClickable() {
        boolean result;
        try {
            result = umaHomePageElements.mealPlansCarouselButton.isEnabled();
            return result;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickMealsPlanButtonOnHaloNavCarousel() {
        waitForClickableAndClick(umaHomePageElements.mealPlansCarouselButton);
    }
}

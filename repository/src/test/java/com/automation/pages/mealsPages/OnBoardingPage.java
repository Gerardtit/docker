package com.automation.pages.mealsPages;

import com.automation.pageElements.meals.pageElements.OnBoardingFlowElements;
import com.automation.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingPage extends BasePage {

    private final OnBoardingFlowElements onBoardingFlowElements = new OnBoardingFlowElements();
    private final MealsUtils mealsUtils = new MealsUtils(driver);

    public OnBoardingPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), onBoardingFlowElements);
    }

    public void clickSkipButton() {
        waitForClickableAndClick(onBoardingFlowElements.skipButton);
    }

    public void clickPickYourDietButton() {
        if (!platformName.equalsIgnoreCase("android")) {
            Assert.assertTrue(onBoardingFlowElements.pickYourDietButton.getText().contains("Pick your diet"), "scenarios might fail with this step, if false positive failure, then create ticket to separate method for a different scenario.  "
                    + onBoardingFlowElements.pickYourDietButton.getText());
        }
        waitForClickableAndClick(onBoardingFlowElements.pickYourDietButton);
    }

    public boolean onboardingWelcomeScene() {
        waitForLoadingComplete();
        Boolean result = false;
        try {
            if (mealsUtils.checkMobileElementExist(onBoardingFlowElements.onboardingWelcomeScene)) {
                result = true;
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    public MobileElement onBoardingFlowTextElement() {
        return onBoardingFlowElements.onboardingWelcomeScene;
    }

    public void clickBackButton() {
        onBoardingFlowElements.onboardingBackButton.click();
    }

    public boolean verifyOnboardingPageIsDisplayed() {
        List result = new ArrayList();
        if (onboardingWelcomeScene()) {
            result.add(onBoardingFlowElements.onboardingWelcomeScene.isDisplayed());
            result.add(onBoardingFlowElements.pickYourDietButton.isDisplayed());
            result.add(onBoardingFlowElements.skipButton.isDisplayed());
        }
        return !result.contains(false) && !result.isEmpty();
    }

    public void verifyPickYourDietPageIsDisplayed() {
        Assert.assertTrue(onBoardingFlowElements.onboardingPickYourDietScene.isDisplayed());
        mealsUtils.checkMobileElementExist(onBoardingFlowElements.pickYourDietTextVerificationStep2Page);
        Assert.assertTrue(onBoardingFlowElements.pickYourDietTextVerificationStep2Page.getText()
                .contains("Pick your diet"));
        Assert.assertTrue(onBoardingFlowElements.learnAboutDietsButton.isDisplayed()
                && onBoardingFlowElements.learnAboutDietsButton.isEnabled());
    }

    public void clickNextButton() {
        waitForDisplayed(onBoardingFlowElements.onboardingNextButton);
        waitForClickableAndClick(onBoardingFlowElements.onboardingNextButton);
    }

    public void verifyDietRestrictionsPageIsDisplayed() {
        Assert.assertTrue(onBoardingFlowElements.onboardingRestrictionsScene.isDisplayed());
        Assert.assertTrue(onBoardingFlowElements.anyAllergiesOrRestrictionsTextStep3Page
                .getText().contains("restrictions"));
    }

    public void dislikesPageIsDisplayed() {
        Assert.assertTrue(onBoardingFlowElements.onboardingDislikesScene.isDisplayed());
        Assert.assertTrue(onBoardingFlowElements.howAboutDislikesTextStep4Page.getText().contains("dislikes"));
        Assert.assertTrue(onBoardingFlowElements.seeAllButtonStep4Page.isDisplayed());
    }

    public void servingsPageIsDisplayed() {
        Assert.assertTrue(onBoardingFlowElements.onboardingServingsScene.isDisplayed());
        Assert.assertTrue(onBoardingFlowElements.totalServingsPerMealTextStep5Page.getText().contains("servings"));
        Assert.assertTrue(onBoardingFlowElements.doneButtonStep5Page.isDisplayed());
        Assert.assertTrue(onBoardingFlowElements.onboardingBackButton.isDisplayed());
        Assert.assertTrue(onBoardingFlowElements.selectTotalServingsPerMeal4ServingsButtonStep5Page.isDisplayed());
        Assert.assertTrue(onBoardingFlowElements.selectTotalServingsPerMeal6ServingsButtonStep5Page.isDisplayed());
        Assert.assertTrue(onBoardingFlowElements.selectTotalServingsPerMeal2ServingsButtonStep5Page.isDisplayed());
    }

    public void clickDoneButton() {
        onBoardingFlowElements.doneButtonStep5Page.click();
    }
}

package com.automation.pages.mealsPages;

import com.automation.pageElements.meals.pageElements.EditPreferencesPageElements;
import com.automation.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class EditUserPreferencesPage extends BasePage {

    EditPreferencesPageElements editPreferencesPageElements = new EditPreferencesPageElements();

    public EditUserPreferencesPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), editPreferencesPageElements);
    }

    private void goToAdminSettings() {
        waitForDisplayed(editPreferencesPageElements.editPreferenceButton, 10);
        MobileElement longpress = editPreferencesPageElements.editPreferenceButton;
        LongPressOptions longPressOptions = new LongPressOptions();
        longPressOptions.withDuration(Duration.ofSeconds(3)).withElement(ElementOption.element(longpress));
        TouchAction action = new TouchAction(driver);
        action.longPress(longPressOptions).release().perform();
    }

    public void resetAdminSettings() {
        goToAdminSettings();
        scrollDownForElement(editPreferencesPageElements.resetUserData);
        editPreferencesPageElements.resetUserData.click();
        waitForClickableAndClick(editPreferencesPageElements.confirmResetPopUp);
        waitForDisplayed(editPreferencesPageElements.resetSuccessFulText);
    }

    public void goToDietPreferences() {
        editPreferencesPageElements.editPreferenceButton.click();
    }

    public void dietPreferencesScreenIsDisplayed() {
        Assert.assertTrue(editPreferencesPageElements.preferencesScene.isDisplayed());
        Assert.assertTrue(editPreferencesPageElements.pageTitle.getText().contains("Diet preferences"));
        Assert.assertTrue(editPreferencesPageElements.dietText.isDisplayed());
        //todo - request selectors for following and then uncomment
        Assert.assertTrue(editPreferencesPageElements.restrictionsText.isDisplayed());
        Assert.assertTrue(editPreferencesPageElements.ingredientsYouDislikeText.isDisplayed());
        Assert.assertTrue(editPreferencesPageElements.servingSizeText.isDisplayed());
        Assert.assertTrue(editPreferencesPageElements.dietTypeSelectorButton.isDisplayed());
        Assert.assertTrue(editPreferencesPageElements.restrictionsAddButton.isDisplayed());
        Assert.assertTrue(editPreferencesPageElements.ingredientsYouDislikeButton.isDisplayed());
        Assert.assertTrue(editPreferencesPageElements.servingSizeSelectorButton.isDisplayed());
    }

    public void clickOnDietTypeButton() {
        waitForClickableAndClick(editPreferencesPageElements.dietTypeSelectorButton);
    }

    public void clickBackButton() {
        try {
            waitForDisplayed(editPreferencesPageElements.backButtonEditPreferences, 5);
            waitForClickableAndClick(editPreferencesPageElements.backButtonEditPreferences);
        } catch (Exception e) {
            int attempts = 0;
            while (attempts < 2) {
                try {
                    waitForClickableAndClick(editPreferencesPageElements.backButtonEditPreferences);
                    break;
                } catch (StaleElementReferenceException f) {

                }
                attempts++;
            }
        }
    }
}

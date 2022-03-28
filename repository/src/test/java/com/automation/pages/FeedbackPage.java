package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.FeedbackPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class FeedbackPage extends BasePage {
    public FeedbackPageElements pageElements = new FeedbackPageElements();

    public FeedbackPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
    }

    public void waitForFeedbackPageDisplayed() {
        new WaitAction(driver).waitForDisplayed(pageElements.feedbackTitle);
    }

    public void selectTopicFromFeedbackDropdown(String arg0) throws InterruptedException {
        pageElements.selectTopicDropDown.click();

        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new CommonActions(driver).new ClickAction().clickTextOnScreen(arg0);
        } else if (driver.getPlatformName().equalsIgnoreCase("ios")) {

            pageElements.iosTopicPickerWheel.sendKeys(arg0);
            pageElements.iosDoneButton.click();
        }
        Thread.sleep(1000);
    }

    public void clickDropdown() {
        pageElements.selectTopicDropDown.click();
    }

    public boolean verifyItemOnDropdown(String topic) throws InterruptedException {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            pageElements.iosTopicPickerWheel.sendKeys(topic);
        }
        Thread.sleep(2000);
        return textDisplayed(topic);
    }

    public void enterComments(String arg0) {
        enterKey(pageElements.enterCommentsEditText, arg0);
    }

    public void clickSubmitComments() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.submitButton);
    }

    public void commentSentDisplayed() {
        new WaitAction(driver).waitForDisplayed(pageElements.sucessfullySentMsg);
    }
}

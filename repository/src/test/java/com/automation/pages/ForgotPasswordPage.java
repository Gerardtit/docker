package com.automation.pages;

import com.automation.pageElements.ForgotPasswordPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ForgotPasswordPage extends BasePage {
    private final ForgotPasswordPageElements forgotPasswordPageElements = new ForgotPasswordPageElements();

    public ForgotPasswordPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), forgotPasswordPageElements);
    }

    public void waitForForgotPasswordPageDisplayed() {
        waitVar.until(ExpectedConditions.visibilityOf(forgotPasswordPageElements.forgotPasswordTitle));
    }

    public void enterEmail(String arg0) {
        enterKey(forgotPasswordPageElements.emailAddressEditText, arg0);
    }

    public void clickNextButton() {
        forgotPasswordPageElements.nextButton.click();
    }

    public void waitForPasswordResetDisplayed() {
        waitVar.until(ExpectedConditions.textToBePresentInElement(
                forgotPasswordPageElements.resetPasswordEmailSentText, "Password Reset"));
    }
}

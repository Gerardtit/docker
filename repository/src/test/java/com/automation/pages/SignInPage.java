package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.SignInPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SignInPage extends BasePage {
    private final SignInPageElements signInPageElements = new SignInPageElements();

    public SignInPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), signInPageElements);
    }

    public void enterUsername(String username) {
        enterKey(signInPageElements.emailEditText, username);
    }

    public void enterPassword(String password) {
        enterKey(signInPageElements.passwordEditText, password);
    }

    public void clickSignIn() {
        signInPageElements.signInBtn.click();
    }

    public void clickCreateAccountButton() {
        signInPageElements.createAccountButton.click();
    }

    public void waitForSignInPageDisplayed() {
        waitVar.until(ExpectedConditions.visibilityOf(signInPageElements.signInTitle));
    }

    public void clickForgotPasswordLink() {
        signInPageElements.forgotPasswordLink.click();
    }

    public void clickCancelButton() {
        new CommonActions(driver).new ClickAction().clickElement(signInPageElements.cancelButton);

    }

    public void waitForInvalidPasswordError() {
        new WaitAction(driver).waitForDisplayed(signInPageElements.invalidAccountErrorMessage);
    }

    public void verifyNoRecordError() {
        new WaitAction(driver).waitForDisplayed(signInPageElements.noAccountRecordError);
    }

    public boolean forgotPasswordNextButtonEnabled() {
        new WaitAction(driver).waitForDisplayed(signInPageElements.forgotPasswordNextButton);
        return signInPageElements.forgotPasswordNextButton.isEnabled();
    }

    public void validatesSignInContinueScreen() {
        Assert.assertTrue(signInPageElements.signInforFullExperienceLbl.isDisplayed());
        Assert.assertTrue(signInPageElements.signInBtn.isDisplayed());
        Assert.assertTrue(signInPageElements.backBtnSignInScreen.isDisplayed());
    }


    public void clickProduct() {
        new CommonActions(driver).new ClickAction().clickElement(signInPageElements.clickproduct);
        waitForDisplayed(signInPageElements.clickAddToCart);
        new CommonActions(driver).new ClickAction().clickElement(signInPageElements.clickAddToCart);
//  new CommonActions(driver).new ClickAction().clickElement(signInPageElements.backBtnSignInScreen);
    }

    public void clickOnReserveaTime() {
        new CommonActions(driver).new ClickAction().clickElement(signInPageElements.reserveaTimeBtn);
    }

    public void clickOnHamburgerMenu() {
        new CommonActions(driver).new ClickAction().clickElement(signInPageElements.hamburgerMenuBtn);
    }

    public void clickOnSignInHamburgerMenu() {
        new CommonActions(driver).new ClickAction().clickElement(signInPageElements.signInHamburgerMenu);
    }
}

package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.ChooseAccountPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ChooseAccountPage extends BasePage {
    public ChooseAccountPageElements pageElements = new ChooseAccountPageElements();

    public ChooseAccountPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
    }

    public void waitForChooseAccountPageDisplayed() {
        new WaitAction(driver).waitForDisplayed(pageElements.chooseAccountTitle);
    }

    public void clickContinueAsGuest() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.continueAsGuestButton);
    }
}

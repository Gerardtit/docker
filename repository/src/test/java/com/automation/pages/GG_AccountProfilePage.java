package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_AccountProfilePageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GG_AccountProfilePage extends BasePage {

    private final GG_AccountProfilePageElements accountProfilePageElements = new GG_AccountProfilePageElements();

    public GG_AccountProfilePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), accountProfilePageElements);
    }

    public boolean isAccountProfilePageDisplayed() {
        return isElementDisplayed(accountProfilePageElements.accountHeaderTitle) && accountProfilePageElements.accountHeaderTitle.getText().equals("Account");
    }


    public void clickSignOut() {
        new CommonActions(driver).new ClickAction().clickElement(accountProfilePageElements.signOutButton);
        new CommonActions(driver).new ClickAction().clickElement(accountProfilePageElements.confirmSignOutOkButton);

    }

    public void clickBackButtonOnMyAccountPage() {
        new WaitAction(driver).waitForDisplayed(accountProfilePageElements.backButton);
        new CommonActions(driver).new ClickAction().clickElement(accountProfilePageElements.backButton);
    }

    public Boolean verifyHeaderTitleOfPage(String headerTitle) {
        return isElementDisplayed(accountProfilePageElements.accountHeaderTitle) && accountProfilePageElements.accountHeaderTitle.getText().equals(headerTitle);
    }
}


package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_SettingsPageElements;
import com.automation.pageElements.MenuPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MenuPage extends BasePage {
    private final MenuPageElements menuPageElements = new MenuPageElements();
    private GG_SettingsPageElements settingpageelements = new GG_SettingsPageElements();


    public MenuPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), menuPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), settingpageelements);
    }


    public void waitForMenuPageDisplayed() {
        waitVar.until(ExpectedConditions.visibilityOf(menuPageElements.titleMore));
    }

    public void waitForTransferRefillTitleDisplayed() {
        waitVar.until(ExpectedConditions.visibilityOf(menuPageElements.title_TranferRefill));
    }

    public void clickSignOutButton() {
        menuPageElements.signOutButton.click();
    }

    public void waitForConfirmSignOutDisplayed() {
        waitVar.until(ExpectedConditions.visibilityOf(menuPageElements.confirmSignOutMessage));
    }

    public void clickSignOutConfirmButton() {
        menuPageElements.confirmSignOutButton.click();
    }


    public void clickAccount() {
        new CommonActions(driver).new ClickAction().clickElement(menuPageElements.accountButton);
    }

    public void clickFeedback() {
        new CommonActions(driver).new ClickAction().clickElement(menuPageElements.feedbackButton);
    }

    public void clickOrder() {
        new CommonActions(driver).new ClickAction().clickElement(menuPageElements.ordersButton);
    }

    public void navigateFromSubLevel() {

        new CommonActions(driver).new ClickAction().clickElement(menuPageElements.topLeftArrowBack);

    }

    public void clickHelpFAQ() {
        new CommonActions(driver).new ClickAction().clickElement(menuPageElements.helpFAQbutton);
    }

    public void waitForHelpFAQDisplayed() {
        new WaitAction(driver).waitForDisplayed(menuPageElements.helpWindowTitle);
    }

    public void clickContactUs() {
        new CommonActions(driver).new ClickAction().clickElement(menuPageElements.contactUsButton);
    }

    public void clickChat() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new CommonActions(driver).new ClickAction().clickElement(menuPageElements.chatButton);
        } else {
            if (isElementDisplayed(menuPageElements.contactUsButton)) {
                clickContactUs();
            }
            new CommonActions(driver).new ClickAction().clickElement(menuPageElements.chatButton);
        }

    }

    public void clickDeliveryPickUp() {
        new CommonActions(driver).new ClickAction().clickElement(menuPageElements.deliveryPickupQuestion);
    }

    public void clickTermsPolicy() {
        new CommonActions(driver).new ClickAction().clickElement(menuPageElements.termsPoliciesButton);
    }

    public void clickNeedHelpChatbot() throws InterruptedException {
        Thread.sleep(3000);
        scrollDownForElement(menuPageElements.needHelpInMenu);
        new CommonActions(driver).new ClickAction().clickElement(menuPageElements.needHelpInMenu);
    }

    public void clickNeedHelpChatbotAccount() throws InterruptedException {
        Thread.sleep(3000);
        scrollDownForElement(menuPageElements.needHelpInMenuAccount);
        new CommonActions(driver).new ClickAction().clickElement(menuPageElements.needHelpInMenuAccount);
    }

    public void verifyVersionDisplayed() {
        new WaitAction(driver).waitForDisplayed(menuPageElements.versionText);
    }

    public void clickAccountTab() {
        new CommonActions(driver).new ClickAction().clickElement(settingpageelements.accountbtn);
    }

}


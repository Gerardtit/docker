package com.automation.pages;

import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_chatsessionElements;
import com.automation.pageElements.HomePageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GG_ChatsessionPage extends BasePage {
    public HomePageElements homePageElements = new HomePageElements();
    private final GG_chatsessionElements chatsessionElements = new GG_chatsessionElements();

    public GG_ChatsessionPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), chatsessionElements);

        PageFactory.initElements(new AppiumFieldDecorator(driver), homePageElements);
    }

    public void edittime() {
        new WaitAction(driver).waitForDisplayed(chatsessionElements.editdatentime);
        chatsessionElements.editdatentime.isDisplayed();
        new WaitAction(driver).waitForElementToBeClickable(chatsessionElements.editdatentime, 3);
        chatsessionElements.editdatentime.click();
    }

    public void confirmtab() {
        chatsessionElements.confirmchanges.isDisplayed();
        chatsessionElements.confirmchanges.click();
    }

    public void editbox() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            scrollDownForElement(chatsessionElements.editbox);
            chatsessionElements.editbox.click();
        }
    }

    public void textyped(String text) {
        enterKey(chatsessionElements.editbox, text);

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new WaitAction(driver).waitForTextPresentInElement(chatsessionElements.editbox, text);
            new WaitAction(driver).waitForLoadingComplete();
        }
        new WaitAction(driver).waitForClickableAndClick(chatsessionElements.enterbutton);


    }

    public void seeresult() {
        chatsessionElements.seeresult.isDisplayed();
    }

    public void viewProduct() {
        new WaitAction(driver).waitForDisplayed(chatsessionElements.viewProduct);
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            try {

                new WaitAction(driver).waitForDisplayed(chatsessionElements.viewProduct);
                chatsessionElements.viewProduct.isDisplayed();

            } catch (Exception e) {
            }
            chatsessionElements.viewProduct.isDisplayed();
        }
    }

    public void resultclicked() {
        new WaitAction(driver).waitForLoadingComplete();
        new WaitAction(driver).waitForClickableAndClick(chatsessionElements.seeresult);

    }

    public void viewclicked() {
        new WaitAction(driver).waitForLoadingComplete();
        new WaitAction(driver).waitForLoadingComplete();
        new WaitAction(driver).waitForClickableAndClick(chatsessionElements.viewProduct);
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void zipcodeentered(String arg0) {
        enterKey(chatsessionElements.editbox, arg0);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new WaitAction(driver).waitForTextPresentInElement(chatsessionElements.editbox, arg0);
            new WaitAction(driver).waitForLoadingComplete();
        }
        new WaitAction(driver).waitForClickableAndClick(chatsessionElements.enterbutton);

    }
}


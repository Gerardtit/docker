package com.automation.pages;

import com.automation.pageElements.GG_StartUpPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains methods that will act on start up page
 */
public class GG_StartUpPage extends BasePage {
    private final GG_StartUpPageElements startUpPageElements = new GG_StartUpPageElements();

    public GG_StartUpPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), startUpPageElements);
    }

    public void clickOnSignInHereButton() {
        startUpPageElements.signInHereButton.click();
    }
}

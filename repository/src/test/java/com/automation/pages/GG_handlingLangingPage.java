package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_Verify_FreshpassElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GG_handlingLangingPage extends BasePage {
    public GG_Verify_FreshpassElements freshpassElements = new GG_Verify_FreshpassElements();

    public GG_handlingLangingPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), freshpassElements);
    }

    public void ToHomePage() {
        new WaitAction(driver).waitForLoadingComplete();
        if (isElementDisplayed(freshpassElements.ClickCacheText, 3)) {
            freshpassElements.ClickCacheText.click();
        }
        new WaitAction(driver).waitForLoadingComplete();
        if (isElementDisplayed(freshpassElements.ClickNextButton, 3)) {
            for (int i = 1; i <= 2; i++) {
                new CommonActions(driver).new ClickAction().clickElement(freshpassElements.ClickNextButton);
            }

            if (isElementDisplayed(freshpassElements.ClickNextButton, 3)) {
                new CommonActions(driver).new ClickAction().clickElement(freshpassElements.ClickNextButton);
                if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                    new WaitAction(driver).waitForDisplayed(freshpassElements.allowElement);
                    freshpassElements.allowElement.click();
                }
            } else {
                new WaitAction(driver).waitForLoadingComplete();
                new WaitAction(driver).waitForDisplayed(freshpassElements.homeicon);
                new WaitAction(driver).waitForClickableAndClick(freshpassElements.homeicon);
                new WaitAction(driver).waitForLoadingComplete();

                if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                    new WaitAction(driver).waitForDisplayed(freshpassElements.allowElement);
                    freshpassElements.allowElement.click();
                }
                new WaitAction(driver).waitForLoadingComplete();
                if (isElementDisplayed(freshpassElements.ClickNextButton, 3)) {
                    new CommonActions(driver).new ClickAction().clickElement(freshpassElements.ClickNextButton);
                }
            }
        }
    }
}
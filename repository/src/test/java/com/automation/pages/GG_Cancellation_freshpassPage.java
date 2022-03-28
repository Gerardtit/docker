package com.automation.pages;

import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_Cancellation_FreshpassElements;
import com.automation.pageElements.GG_Verify_FreshpassElements;
import com.automation.pageElements.GG_user_subscriptionElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class GG_Cancellation_freshpassPage extends BasePage {
    public GG_Cancellation_FreshpassElements cancellationElements = new GG_Cancellation_FreshpassElements();
    public GG_Verify_FreshpassElements freshpassElements = new GG_Verify_FreshpassElements();
    public GG_user_subscriptionElements subscriptionElements = new GG_user_subscriptionElements();

    public GG_Cancellation_freshpassPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cancellationElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), freshpassElements);

    }


    public void cancelreason() {
        cancellationElements.canceloption1.click();
    }

    public void yestext() {
        cancellationElements.yescancel.click();
    }

    public void freetrialtext() {
        new WaitAction(driver).waitForDisplayed(cancellationElements.freetrialtext);
        cancellationElements.freetrialtext.isDisplayed();
    }

    public void endnoticetext() {
        cancellationElements.endnotice.isDisplayed();
    }


    public void shopnow() {
        cancellationElements.shopnowtext.isDisplayed();
    }

    public void shopnowClick() {
        cancellationElements.shopnowtext.click();
    }


}


















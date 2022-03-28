package com.automation.pages;


import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_suspendedFp_accountElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GG_suspendedFP_AccountPage extends BasePage {
    public GG_suspendedFp_accountElements suspendedfpElements = new GG_suspendedFp_accountElements();


    public GG_suspendedFP_AccountPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), suspendedfpElements);


    }

    public void supendedtext() {
        suspendedfpElements.suspendedtext.isDisplayed();
    }

    public void cardexpiredText() {
        scrollDownForElement(suspendedfpElements.cardExpiredText);
        suspendedfpElements.cardExpiredText.isDisplayed();
    }

    public void suspendedatmembertab() {
        suspendedfpElements.suspendedatmembertab.isDisplayed();
    }

    public void clickExpired() {
        scrollDownForElement(suspendedfpElements.cardExpiredText);
        new WaitAction(driver).waitForDisplayed(suspendedfpElements.cardExpiredText);
        new WaitAction(driver).waitForClickableAndClick(suspendedfpElements.cardExpiredText);
//        suspendedFP_accountElements.cardExpiredText.click();
    }

    public void backicon() {
        suspendedfpElements.backicon.click();

    }

    public void clicksunsubscribed() {
        new WaitAction(driver).waitForDisplayed(suspendedfpElements.unsubscribetab);
        suspendedfpElements.unsubscribetab.click();
    }


}


package com.automation.pages;

import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_Cancellation_FreshpassElements;
import com.automation.pageElements.GG_Verify_FreshpassElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GG_freshpass_confirmationPage extends BasePage {
    public GG_Cancellation_FreshpassElements cancellationElements = new GG_Cancellation_FreshpassElements();
    public GG_Verify_FreshpassElements freshpassElements = new GG_Verify_FreshpassElements();

    public GG_freshpass_confirmationPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cancellationElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), freshpassElements);

    }

    public void trialtabselected() {
        waitForLoadingComplete();
        cancellationElements.subscribebutton.click();

    }

    public void membertab() {
        cancellationElements.membertab.click();
    }

    public void clickname() {
        cancellationElements.profileName.click();
    }

    public void AddDOB() {
        cancellationElements.dob.click();
        waitForLoadingComplete();
        enterKey(cancellationElements.MMDD, "0313");
        waitForLoadingComplete();
        cancellationElements.confirm.click();

    }

    public void verifyDOB() {
        cancellationElements.dob.click();
        Assert.assertTrue(cancellationElements.dob.isDisplayed());
    }

    public void freshpassatmemeber() {
        waitForLoadingComplete();
        cancellationElements.freshpassMembertab.click();
    }

    public void Address() {
        waitForLoadingComplete();
        freshpassElements.Account.click();
    }

    public void addPickup() {
        waitForLoadingComplete();
        freshpassElements.addbtn.click();
    }

    public void findpickupstore() {
        waitForLoadingComplete();
        freshpassElements.searchpickupstore.click();
        enterKey(freshpassElements.searchpickupstore, "94566");

    }

    public void statustab() throws Exception {
        scrollUp();

        new WaitAction(driver).waitForDisplayed(cancellationElements.NewUser);
        new WaitAction(driver).waitForClickableAndClick(cancellationElements.NewUser);
//        cancellationElements.NewUser.click();

    }

    public void allsettext() {
        new WaitAction(driver).waitForLoadingComplete();
        cancellationElements.allSetText.isDisplayed();
        cancellationElements.allSetsubText.isDisplayed();
    }

    public void donetab() {
        scrollDown();
        if (isElementDisplayed(cancellationElements.DonePlansubcribe)) {
//        scrollDownForElement(cancellationElements.DonePlansubcribe);
            cancellationElements.DonePlansubcribe.click();
        }
    }

    public void subscription() {
        scrollDownForElement(cancellationElements.subscribetab);
        cancellationElements.subscribetab.click();
    }

    public void newCard() {
        freshpassElements.AddnewCard.click();
    }

    public void notnowtext() {

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {

            scrollDownForElement(cancellationElements.notnowtext);
            cancellationElements.notnowtext.click();
        }
        new WaitAction(driver).waitForLoadingComplete();

        if (isElementDisplayed(freshpassElements.ClickCacheText, 3)) {
            freshpassElements.ClickCacheText.click();
        }

    }
}
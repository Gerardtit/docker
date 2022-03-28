package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.Temp_signInPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Temp_signInPage extends BasePage {
    public Temp_signInPageElements pageElements = new Temp_signInPageElements();

    public Temp_signInPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
    }


    public void clickMaybeLater() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.clickMaybeLater);
    }

    public void ClickNextButton() {
        new WaitAction(driver).waitForLoadingComplete();
        for (int i = 1; i <= 3; i++) {
            new CommonActions(driver).new ClickAction().clickElement(pageElements.ClickNextButton);
        }
    }

    public void clickNextPopup() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.pickUpNextButton);
        new CommonActions(driver).new ClickAction().clickElement(pageElements.dealsNextButton);
        new CommonActions(driver).new ClickAction().clickElement(pageElements.walletButton);

    }

    public void ClickCacheText() {
        new WaitAction(driver).waitForDisplayed(pageElements.ClickCacheText);
        pageElements.ClickCacheText.click();
    }


    public void ClickDismiss() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.clickDismiss);

    }

    public void ClickShoppingMode() {
        new WaitAction(driver).waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(pageElements.clickShoppingMode);
    }


    public void clickStartShopping() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.startShopping);
    }

    public void waitForHomePageDisplayed() {
        new WaitAction(driver).waitForLoadingComplete();

        waitVar.until(ExpectedConditions.visibilityOf(pageElements.menuButton));
        Assert.assertTrue(pageElements.menuButton.isDisplayed());
    }

    public void waitForZipCodePageDisplayed() {
        new WaitAction(driver).waitForLoadingComplete();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (isElementDisplayed(pageElements.Allow, 10))
                new CommonActions(driver).new ClickAction().clickElement(pageElements.Allow);
        }
        waitVar.until(ExpectedConditions.elementToBeClickable(pageElements.zipCodeEditText));
    }

    public void enterZipCode(String zipcode) throws InterruptedException {
        Thread.sleep(2000);
//        pageElements.ZipodeEditText.clear();
//        deleteCurrentTextInEditText(pageElements.ZipodeEditText);
        enterKey(pageElements.ZipodeEditText, zipcode);
    }

    public void clickSearchButton() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.searchZipCodeButton);
    }

    public void selectInStoreDeliveryOpion() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (pageElements.InStoreSelected.getText().contains("Selected")) {
                System.out.println(pageElements.InStoreSelected.getText());
            } else {
                new CommonActions(driver).new ClickAction().clickElement(pageElements.InStore);
            }
        }
        new CommonActions(driver).new ClickAction().clickElement(pageElements.InStore);

    }

    public void selectInstoreTomThumb() {
        scrollDownForElement(pageElements.InstoreTomthumb);
        new WaitAction(driver).waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(pageElements.InstoreTomthumb);
    }
}

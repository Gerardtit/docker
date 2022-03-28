package com.automation.pages;


import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_DashboardPageElements;
import com.automation.pageElements.ZipCodePageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ZipCodePage extends BasePage {
    public ZipCodePageElements zipCodePageElements = new ZipCodePageElements();
    public GG_DashboardPageElements dashboardPageElements = new GG_DashboardPageElements();

    public ZipCodePage(AppiumDriver driver) {

        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), zipCodePageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dashboardPageElements);
    }

    public void waitForZipCodePageDisplayed() {

        new WaitAction(driver).waitForLoadingComplete();

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {

            if (isElementDisplayed(zipCodePageElements.AllowNotification, 10))

                new CommonActions(driver).new ClickAction().clickElement(zipCodePageElements.AllowNotification);


            if (isElementDisplayed(zipCodePageElements.Allow, 10))
                new CommonActions(driver).new ClickAction().clickElement(zipCodePageElements.Allow);
        }

        waitVar.until(ExpectedConditions.elementToBeClickable(zipCodePageElements.zipCodeEditText));

        new WaitAction(driver).waitForLoadingComplete();


    }

    public void clickSignInButton() {
        zipCodePageElements.signInHereButton.click();
    }

    public void enterZipCode(String zipCode) {
//        zipCodePageElements.zipCodeEditText.clear();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            deleteCurrentTextInEditText(zipCodePageElements.zipCodeEditText);
        } else {
            zipCodePageElements.zipCodeEditText.clear();
        }
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            enterKey(zipCodePageElements.zipCodeEditText, zipCode);
            new CommonActions(driver).new ClickAction().clickElement(zipCodePageElements.registerZipCodeNext);
        } else if (driver.getPlatformName().equalsIgnoreCase("ios"))

            enterKey(zipCodePageElements.zipCodeEditText, zipCode);
    }

    public void enterMFAZipCode(String zipCode) {
        zipCodePageElements.zipCodeEditText.clear();
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            enterKey(zipCodePageElements.zipCodeEditText, zipCode);
            new CommonActions(driver).new ClickAction().clickElement(zipCodePageElements.registerZipCodeNext);
        } else if (driver.getPlatformName().equalsIgnoreCase("ios"))
            enterKey(zipCodePageElements.zipCodeEditText, zipCode);
    }

   /* public void enterZipCode(String zipCode){
     //   zipCodePageElements.zipCodeEditText.clear();
        if(driver.getPlatformName().equalsIgnoreCase("android"))
            enterFromKeyboard(zipCodePageElements.zipCodeEditText, "76109");
        else if(driver.getPlatformName().equalsIgnoreCase("ios"))
            for (int i = 0; i < 5; i++){
                enterKey(zipCodePageElements.zipCodeEditText, "\b");

            }
        enterKey(zipCodePageElements.zipCodeEditText, "76109");
        new WaitAction(driver).waitForLoadingComplete();
      //  Thread.sleep(2000);
    }*/

    public void enterinStoreZipCode(String zipCode) {
        //   zipCodePageElements.zipCodeEditText.clear();
        if (driver.getPlatformName().equalsIgnoreCase("android"))
            enterFromKeyboard(zipCodePageElements.zipCodeEditText, zipCode);
        else if (driver.getPlatformName().equalsIgnoreCase("ios"))
            for (int i = 0; i < 5; i++) {
                enterKey(zipCodePageElements.zipCodeEditText, "\b");

            }
        new WaitAction(driver).waitForLoadingComplete();
        enterKey(zipCodePageElements.zipCodeEditText, zipCode);
        new WaitAction(driver).waitForLoadingComplete();
        //  Thread.sleep(2000);
    }

    public void enterVonsStoreZipCode(String zipCode) {
        //   zipCodePageElements.zipCodeEditText.clear();
        if (driver.getPlatformName().equalsIgnoreCase("android"))
            enterFromKeyboard(zipCodePageElements.slotsearchZip, zipCode);
        else if (driver.getPlatformName().equalsIgnoreCase("ios"))
            for (int i = 0; i < 5; i++) {
                enterKey(zipCodePageElements.slotsearchZip, "\b");

            }
        waitForLoadingComplete();
        enterKey(zipCodePageElements.slotsearchZip, zipCode);
        waitForLoadingComplete();
        //  Thread.sleep(2000);
    }

   /* public void enterZipCode(String zipCode){
     //   zipCodePageElements.zipCodeEditText.clear();
        if(driver.getPlatformName().equalsIgnoreCase("android"))
            enterFromKeyboard(zipCodePageElements.zipCodeEditText, "76109");
        else if(driver.getPlatformName().equalsIgnoreCase("ios"))
            for (int i = 0; i < 5; i++){
                enterKey(zipCodePageElements.zipCodeEditText, "\b");

            }
        enterKey(zipCodePageElements.zipCodeEditText, "76109");
        new WaitAction(driver).waitForLoadingComplete();
      //  Thread.sleep(2000);
    }*/

/*
    public void enterinStoreZipCode(String zipCode){
        //   zipCodePageElements.zipCodeEditText.clear();
        if(driver.getPlatformName().equalsIgnoreCase("android"))
            enterFromKeyboard(zipCodePageElements.zipCodeEditText, zipCode);
        else if(driver.getPlatformName().equalsIgnoreCase("ios"))
            for (int i = 0; i < 5; i++){
                enterKey(zipCodePageElements.zipCodeEditText, "\b");

            }
        new WaitAction(driver).waitForLoadingComplete();
        enterKey(zipCodePageElements.zipCodeEditText, zipCode);
        new WaitAction(driver).waitForLoadingComplete();
        //  Thread.sleep(2000);
    }
*/

    public void clickNextButton() {
        zipCodePageElements.enterButton.click();
    }

    public void clickUseMyLocation() {
        new CommonActions(driver).new ClickAction().clickElement(zipCodePageElements.useMyLocationButton);
        hideKeyBoard();
    }

    public void waitForNonServiceZipCodePageDisplayed() {
        new WaitAction(driver).waitForDisplayed(zipCodePageElements.notAreaTitle);
    }

    public void enterEmail(String email) {
        enterKey(zipCodePageElements.invalidZipEmailTextEdit, email);
    }

    public void emailTextNextButton() {
        new CommonActions(driver).new ClickAction().clickElement(zipCodePageElements.invalidZipNextButton);
    }

    public void waitForNonServiceConfirmationPage() {
        new WaitAction(driver).waitForDisplayed(zipCodePageElements.thankYouText);
    }

    public void clickNextAfterRegistration() {
        new WaitAction(driver).waitForLoadingComplete();
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new CommonActions(driver).new ClickAction().clickElement(zipCodePageElements.registerZipCodeNext);
        }

        new WaitAction(driver).waitForLoadingComplete();
        //   new WaitAction(driver).waitForLoadingComplete();
        //   Thread.sleep(1000);
    }


    public void KioskTextIsDisplayed() {
        try {


            Assert.assertTrue(zipCodePageElements.kioskText.isDisplayed());
        } catch (Exception ex) {

        }
    }

    public void LockerTextIsDisplayed() {
        try {


            Assert.assertTrue(zipCodePageElements.lockerText.isDisplayed());
        } catch (Exception ex) {

        }
    }

    public void CounterTextIsDisplayed() {
        try {


            Assert.assertTrue(zipCodePageElements.counterText.isDisplayed());
        } catch (Exception ex) {

        }
    }

    public void zipCodeEditIsDisplayed() {
        try {


            Assert.assertTrue(zipCodePageElements.zipCodeEditButton.isDisplayed());
        } catch (Exception ex) {

        }
    }

    public void clicktoUpdateZipcode() {
        zipCodePageElements.clicktoupdatezipcode.click();
    }

    public void clickOnZipCodeRightArrowButton() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new WaitAction(driver).waitForLoadingComplete();
            driver.findElement(By.name("whiteRightArrow")).click();
        } else {
            new WaitAction(driver).waitForLoadingComplete();
//            new CommonActions(driver).new ClickAction().clickElement(zipCodePageElements.rightArrowZipCodePage);
            new CommonActions(driver).new ClickAction().clickElement(driver.findElement(By.xpath("//*[@resource-id=\"com.safeway.client.android.tomthumb.debug:id/btn_next\"]")));
        }
    }


    public void clickZipCodeRightArrow() {
        try {


            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                new WaitAction(driver).waitForLoadingComplete();
                new CommonActions(driver).new ClickAction().clickElement(driver.findElement(By.name("whiteRightArrow")));
            } else {
                new WaitAction(driver).waitForLoadingComplete();
//            new CommonActions(driver).new ClickAction().clickElement(homePageElements.whiteRightArrow);
                new CommonActions(driver).new ClickAction().clickElement(driver.findElement(By.xpath("//*[@resource-id=\"com.safeway.client.android.tomthumb.debug:id/btn_next\"]")));
            }
        } catch (Exception ex) {

        }


    }

    public boolean isZipcodePageDisplayed() {
        waitForLoadingComplete();

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {

            if (isElementDisplayed(zipCodePageElements.AllowNotification, 10))

                new CommonActions(driver).new ClickAction().clickElement(zipCodePageElements.AllowNotification);


            if (isElementDisplayed(zipCodePageElements.Allow, 10))
                new CommonActions(driver).new ClickAction().clickElement(zipCodePageElements.Allow);
        }
        return isElementDisplayed(zipCodePageElements.zipCodeEditText);
    }
}

package com.automation.pages;

import com.automation.mobile.manager.ConfigFileManager;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.TapAction;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.AddOffBannerAddress_AccountPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.Map;


public class AddOffBannerAddress_AccountPage extends BasePage {
    public AddOffBannerAddress_AccountPageElements pageElements = new AddOffBannerAddress_AccountPageElements();

    public AddOffBannerAddress_AccountPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
    }

    public void selectShoppingMode() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.clickShoppingMode);
    }


    public void enterAccountPageZip(String zipcode) {
        enterKey(pageElements.enterZipcode, zipcode);

    }

    public void clickContinueZipcodeChage() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.clickContinue);

    }

    public void enterAccountPageZipcode(String zipcode1) throws IOException {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            String banner = getCurrentBanner();
            String env = getCurrentEnv();
            Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);
            this.enterAccountPageZip(bannerProperty.get("ACCOUNT_ZIPCODE"));
            System.out.println("Entered Zipcode....");

            new TapAction(driver).tapCoordinate(1304, 2901);
            new WaitAction(driver).waitForLoadingComplete();

            System.out.println("Clicking..");
        } else if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            String banner = getCurrentBanner();
            String env = getCurrentEnv();
            Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);
            this.enterAccountPageZip(bannerProperty.get("ACCOUNT_ZIPCODE"));
            System.out.println("Entered Zipcode....");
            new CommonActions(driver).new ClickAction().clickElement(pageElements.ConfirmZipcode);
            new WaitAction(driver).waitForLoadingComplete();
        }
    }


    public boolean verifyZipcodeValidated() {
        new WaitAction(driver).waitForLoadingComplete();
        return isElementDisplayed(pageElements.verifyZipcodeValidation, 50);

    }

    public void enterAccountAddressLine(String address) {
        enterKey(pageElements.enterAddressLine, address);

    }

    public void accountPage_AddressLine(String address) throws IOException {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            String banner = getCurrentBanner();
            String env = getCurrentEnv();
            Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);

            new TapAction(driver).tapCoordinate(119, 1247);

            System.out.println("Clicking..");
            Actions action = new Actions(driver);
            action.sendKeys(bannerProperty.get("ACCOUNT_ADDRESSLINE")).perform();
            new WaitAction(driver).waitForLoadingComplete();
            driver.hideKeyboard();

        } else if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new WaitAction(driver).waitForLoadingComplete();

            String banner = getCurrentBanner();
            String env = getCurrentEnv();
            Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);
            this.enterAccountAddressLine(bannerProperty.get("ACCOUNT_ADDRESSLINE"));
//            tapCoordinate(301,613);
            System.out.println("Clicking111..");
//            Actions action = new Actions(driver);
//            action.sendKeys(bannerProperty.get("ADDRESSLINE")).perform();
            new WaitAction(driver).waitForLoadingComplete();
            driver.hideKeyboard();
        }

    }


    public void enter_zipcode(String number) {
        pageElements.enterZipcode.clear();
        new CommonActions(driver).new ClickAction().clickElement(pageElements.enterZipcode);
        pageElements.enterZipcode.sendKeys(number);
        driver.hideKeyboard();
    }


    public void ConfirmZipCode() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.ConfirmZipCode);
    }

    public void clickStartshopping() {
        new WaitAction(driver).waitForClickableAndClick(pageElements.clickStartshopping);

    }

    public boolean startshoppingButtonEnabled() {
        new WaitAction(driver).waitForDisplayed(pageElements.clickStartshopping);
        return pageElements.clickStartshopping.isEnabled();
    }

    public void clickMenuIcon() {
        pageElements.clickMenuButton.click();
    }


    public void ClickAccount() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.ClickAccount);
    }

    public void waitForAccountPageDisplayed() {

        new WaitAction(driver).waitForLoadingComplete();
        waitVar.until(ExpectedConditions.visibilityOf(pageElements.myAccountPageTitle));

        Assert.assertEquals(pageElements.myAccountPageTitle.getText(), "Account");
    }

    public void clickEditAddress() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.ClickEditAddress);
    }

}

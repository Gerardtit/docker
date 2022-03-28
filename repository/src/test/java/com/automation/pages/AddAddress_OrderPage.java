package com.automation.pages;

import com.automation.mobile.manager.ConfigFileManager;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.TapAction;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.AddAddress_OrderPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.Map;

public class AddAddress_OrderPage extends BasePage {

    public AddAddress_OrderPageElements pageElements = new AddAddress_OrderPageElements();
    SelectOrderTypePage selectOrderTypePage = new SelectOrderTypePage(driver);

    public AddAddress_OrderPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
    }

    public void ClickStartButton() {
        if (pageElements.ClickStartButton.isDisplayed())
            new CommonActions(driver).new ClickAction().clickElement(pageElements.ClickStartButton);
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

    public void clickDismiss() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.dismiss);
    }

    public void ClickCacheText() {
        new WaitAction(driver).waitForLoadingComplete();
        new WaitAction(driver).waitForDisplayed(pageElements.ClickCacheText);
        pageElements.ClickCacheText.click();
    }

    public void ClickShoppingMode() {
        new WaitAction(driver).waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(pageElements.clickShoppingMode);
    }


    public void waitForHomePageDisplayed() {
        new WaitAction(driver).waitForLoadingComplete();

        waitVar.until(ExpectedConditions.visibilityOf(pageElements.menuButton));
//        Assert.assertTrue(pageElements.menuButton.isDisplayed());
    }

    public void clickDelivery() {
        pageElements.deliverToZipButton.click();
    }

    public void clickStartShoppingButton() throws InterruptedException {
        new WaitAction(driver).waitForClickableAndClick(pageElements.startShoppingButton);
//        if (driver.getPlatformName().equalsIgnoreCase("ios"))
//            waitforUMAhomeScreen(selectOrderTypePageElements.loadingOrderType);
    }

    public void clickStartShopping() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.startShopping);

    }

    public void clickShoppingCartButton() throws InterruptedException {
        Thread.sleep(1000);
        new WaitAction(driver).waitForClickableAndClick(pageElements.clickShoppingCart);
    }

    public void waitForCartPageDisplayed() {
        new WaitAction(driver).waitForLoadingComplete();
        waitVar.until(ExpectedConditions.visibilityOf(pageElements.myCartTitle));
    }

    public void clickCheckout() {
//        new CommonActions(driver).new ClickAction().clickElement(pageElements.checkoutButton);
        new WaitAction(driver).waitForClickableAndClick(pageElements.checkoutButton);
    }

    public void waitForCheckoutPageDisplayed() {
//        Assert.assertTrue(pageElements.verifyCheckoutPage.isDisplayed());
        new WaitAction(driver).waitForDisplayed(pageElements.verifyCheckoutPage);
    }

    public void clickAddDeliveryAddressButton() {
        new WaitAction(driver).waitForClickableAndClick(pageElements.clickAddDeliveryAddressButton);
    }

    public void enterZipcode(String zipcode) {
        enterKey(pageElements.enterZipcode, zipcode);
    }

    public void enterAddressPageZipcode(String zipcode) throws IOException {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            String banner = getCurrentBanner();
            String env = getCurrentEnv();
            Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);
            this.enterZipcode(bannerProperty.get("ORDER_ZIPCODE"));
            System.out.println("Entered Zipcode....");

            new TapAction(driver).tapCoordinate(1304, 2901);
            new WaitAction(driver).waitForLoadingComplete();

            System.out.println("Clicking..");
        } else if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            String banner = getCurrentBanner();
            String env = getCurrentEnv();
            Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);
            this.enterZipcode(bannerProperty.get("ORDER_ZIPCODE"));
            System.out.println("Entered Zipcode....");
            new CommonActions(driver).new ClickAction().clickElement(pageElements.ConfirmZipcode);
            new WaitAction(driver).waitForLoadingComplete();
        }
    }

    public void enterAccountPageZip(String zipcode) {
        enterKey(pageElements.enterZipcode, zipcode);

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

    public void enterAddressLine(String address) {
        enterKey(pageElements.enterAddressLine, address);

    }

    public void enter_AddressLine(String address) throws IOException {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            String banner = getCurrentBanner();
            String env = getCurrentEnv();
            Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);

            new TapAction(driver).tapCoordinate(119, 1247);

            Actions action = new Actions(driver);
            action.sendKeys(bannerProperty.get("ORDER_ADDRESSLINE")).perform();
            new WaitAction(driver).waitForLoadingComplete();
            driver.hideKeyboard();

        } else if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new WaitAction(driver).waitForLoadingComplete();

            String banner = getCurrentBanner();
            String env = getCurrentEnv();
            Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);
            this.enterAddressLine(bannerProperty.get("ORDER_ADDRESSLINE"));
            new WaitAction(driver).waitForLoadingComplete();
            driver.hideKeyboard();
        }

    }

    public void enterAccountAddressLine(String address) {
        enterKey(pageElements.enterAddressLine, address);

    }

    public void clickResidentialtab() {
        scrollDownForElement(pageElements.clickOnResidentialTab);
        new WaitAction(driver).waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(pageElements.clickOnResidentialTab);
    }

    public boolean VerifySaveButtonEnabled() {
        scrollDownForElement(pageElements.clickSave);
        new WaitAction(driver).waitForDisplayed(pageElements.clickSave);
        return pageElements.clickSave.isEnabled();

    }

    public void clickSave() {
        new WaitAction(driver).waitForClickableAndClick(pageElements.clickSave);
    }

    public void clickContinueZipcodeChage() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.clickContinue);
    }

    public void viewCartUpdate() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.viewCartUpdate);

    }
}


//    public void clickOrderInfo() {
//        new CommonActions(driver).new ClickAction().clickElement(pageElements.clickOrderInfo);
//    }
//
//    public void clickOnEdit() {
//        new CommonActions(driver).new ClickAction().clickElement(pageElements.clickOnEdit);
//    }


//    public void clickContinueButton()  {
//        if(DesiredCapabilityBuilder.getDesiredCapability().getCapability(MobileCapabilityType.PLATFORM_NAME)
//                .toString().equalsIgnoreCase("android")) {
//            pageElements.continueButton.click();
//        }
//    }


//    public Boolean checkTotalAmount(String amount){
//        String MinimumAmount = pageElements.checkTotalAmount.getText();
//        if (Integer.parseInt(MinimumAmount) >= Integer.parseInt(amount)) {
//            return true;
//        } else return false;
//    }

//    public void clickCheckout(){
//        Assert.assertTrue(pageElements.CheckoutButton.isDisplayed());
//        new CommonActions(driver).new ClickAction().clickElement(pageElements.CheckoutButton);
//    }
//
//    public void waitForCheckoutPageDisplayed() {
//        new WaitAction(driver).waitForLoadingComplete();
//        waitVar.until(ExpectedConditions.visibilityOf(pageElements.CheckoutPage));
//        Assert.assertTrue(pageElements.CheckoutPage.isDisplayed());
//    }
//    public void enterZipCode(){
//        new CommonActions(driver).new ClickAction().clickElement(pageElements.enterZipcode);
//        new CommonActions(driver).new ClickAction().clickElement(pageElements.ConfirmZipcode);
//        new WaitAction(driver).waitForLoadingComplete();
//        driver.hideKeyboard();
//    }

//         String banner = getCurrentBanner();
//        String env = getCurrentEnv();
//        Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);
//        pageElements.enterZipcode.(bannerProperty.get("ZIPCODE"));
//        new WaitAction(driver).waitForLoadingComplete();
//            if(driver.getPlatformName().equalsIgnoreCase("android"))
////                enterFromKeyboard(pageElements.enterZipcode, zipCode);
//                pageElements.enterZipcode.(bannerProperty.get("ZIPCODE"));
//            else if(driver.getPlatformName().equalsIgnoreCase("ios"))
//                enterKey(pageElements.enterZipcode, zipCode);







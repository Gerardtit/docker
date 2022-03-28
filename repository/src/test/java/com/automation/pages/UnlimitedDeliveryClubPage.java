package com.automation.pages;

import com.automation.mobile.manager.ConfigFileManager;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.UnlimitedDeliveryClubPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.Map;

public class UnlimitedDeliveryClubPage extends BasePage {
    public UnlimitedDeliveryClubPageElements udc_landingPageElements = new UnlimitedDeliveryClubPageElements();

    public UnlimitedDeliveryClubPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), udc_landingPageElements);
    }


    public void click_UDC() {
        new WaitAction(driver).waitForDisplayed(udc_landingPageElements.clickUDC);
        new CommonActions(driver).new ClickAction().clickElement(udc_landingPageElements.clickUDC);
    }

    public void clickAnnualPlan() {
        Assert.assertTrue(udc_landingPageElements.clickAnnualPlan.isDisplayed());
        new CommonActions(driver).new ClickAction().clickElement(udc_landingPageElements.clickAnnualPlan);
    }
//    public void clickBackButton(){
//        new WaitAction(driver).waitForLoadingComplete();
//        new CommonActions(driver).new ClickAction().clickElement(udc_landingPageElements.clickBackButton);
//    }


    public boolean waitForPageDisplayed(String title) {
        new WaitAction(driver).waitForDisplayed(udc_landingPageElements.pageTitle);
        return udc_landingPageElements.pageTitle.getText().equalsIgnoreCase(title);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void clickMonthlyPlan() {
        Assert.assertTrue(udc_landingPageElements.clickMonthlyPlan.isDisplayed());
        new CommonActions(driver).new ClickAction().clickElement(udc_landingPageElements.clickMonthlyPlan);
    }

    public void clickFAQ() {
        scrollDownForElement(udc_landingPageElements.clickFAQ);
        new CommonActions(driver).new ClickAction().clickElement(udc_landingPageElements.clickFAQ);
        new WaitAction(driver).waitForDisplayed(udc_landingPageElements.clickFAQ);
        Assert.assertTrue(udc_landingPageElements.clickFAQ.isDisplayed());
    }

    public void clickTermsAndConditions() {
        scrollDownForElement(udc_landingPageElements.clickTermsAndConditions);
        new CommonActions(driver).new ClickAction().clickElement(udc_landingPageElements.clickTermsAndConditions);
        new WaitAction(driver).waitForDisplayed(udc_landingPageElements.clickTermsAndConditions);
        Assert.assertTrue(udc_landingPageElements.clickTermsAndConditions.isDisplayed());

    }


    public void clickOnPayment() throws InterruptedException {
        new WaitAction(driver).waitForClickableAndClick(udc_landingPageElements.clickPayment);
        if (isElementDisplayed(udc_landingPageElements.changeCreditCard)) {
            Thread.sleep(3000);
            new WaitAction(driver).waitForClickableAndClick(udc_landingPageElements.changeCreditCard);
            new WaitAction(driver).waitForLoadingComplete();
            Thread.sleep(3000);
        }
    }


    public void enterCardName(String name) {
        new WaitAction(driver).waitForLoadingComplete();
        enterKey(udc_landingPageElements.enterName, name);

    }

    public void enter_CardName(String name) throws IOException {

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new WaitAction(driver).waitForLoadingComplete();

            String banner = getCurrentBanner();
            String env = getCurrentEnv();
            Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);
            this.enterCardName(bannerProperty.get("CardName"));
            new WaitAction(driver).waitForLoadingComplete();
            driver.hideKeyboard();

        } else if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new WaitAction(driver).waitForLoadingComplete();

            String banner = getCurrentBanner();
            String env = getCurrentEnv();
            Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);
            this.enterCardName(bannerProperty.get("CardName"));
            new WaitAction(driver).waitForLoadingComplete();
            driver.hideKeyboard();
        }

    }

    public void enterCardNumber(String CardNumber) {
        enterKey(udc_landingPageElements.enterCardNumber, CardNumber);

    }

    public void enter_CardNumber(String CardNumber) throws IOException {

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new WaitAction(driver).waitForLoadingComplete();

            String banner = getCurrentBanner();
            String env = getCurrentEnv();
            Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);
            this.enterCardNumber(bannerProperty.get("CardNumber"));
            new WaitAction(driver).waitForLoadingComplete();
            driver.hideKeyboard();

        } else if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new WaitAction(driver).waitForLoadingComplete();

            String banner = getCurrentBanner();
            String env = getCurrentEnv();
            Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);
            this.enterCardNumber(bannerProperty.get("CardNumber"));
            new WaitAction(driver).waitForLoadingComplete();
            driver.hideKeyboard();
        }

    }

    public void enterMonthYear(String MonthAndYear) {
        enterKey(udc_landingPageElements.enterExpirationMonthYear, MonthAndYear);

    }

    public void enter_MonthYear(String MonthAndYear) throws IOException {

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new WaitAction(driver).waitForLoadingComplete();

            String banner = getCurrentBanner();
            String env = getCurrentEnv();
            Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);
            this.enterMonthYear(bannerProperty.get("ExpirationMonthYear"));
            new WaitAction(driver).waitForLoadingComplete();
            driver.hideKeyboard();

        } else if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new WaitAction(driver).waitForLoadingComplete();

            String banner = getCurrentBanner();
            String env = getCurrentEnv();
            Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);
            this.enterMonthYear(bannerProperty.get("ExpirationMonthYear"));
            new WaitAction(driver).waitForLoadingComplete();
            driver.hideKeyboard();
        }

    }

    public void enterBillingZipcode(String zipcode) {
        enterKey(udc_landingPageElements.enterZipcode, zipcode);
        driver.hideKeyboard();
        new WaitAction(driver).waitForLoadingComplete();

    }

    public void enter_BillingZipcode(String zipcode) throws IOException {

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new WaitAction(driver).waitForLoadingComplete();
            String banner = getCurrentBanner();
            String env = getCurrentEnv();
            Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);
            this.enterBillingZipcode(bannerProperty.get("Billing_Zipcode"));
            new WaitAction(driver).waitForLoadingComplete();
            driver.hideKeyboard();

        } else if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new WaitAction(driver).waitForLoadingComplete();
            String banner = getCurrentBanner();
            String env = getCurrentEnv();
            Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);
            this.enterBillingZipcode(bannerProperty.get("Billing_Zipcode"));
            new WaitAction(driver).waitForLoadingComplete();
            driver.hideKeyboard();
        }

    }


    public void clickContinue() {
        new WaitAction(driver).waitForClickableAndClick(udc_landingPageElements.clickContinue);
        new WaitAction(driver).waitForLoadingComplete();
    }


    public void enterCVVnumber(String number) throws InterruptedException {
        Thread.sleep(2000);
        enterKey(udc_landingPageElements.enterCVV, number);
//        if (isElementDisplayed(udc_landingPageElements.enterCVV, 30)) {
//            new WaitAction(driver).waitForDisplayed(udc_landingPageElements.enterCVV);
//            Thread.sleep(3000);
//        }
//        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@resource-id,\"edit_text_layout\")]"))).sendKeys("123");


    }


    public void enter_CVVnumber(String number) throws IOException, InterruptedException {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new WaitAction(driver).waitForLoadingComplete();
            String banner = getCurrentBanner();
            String env = getCurrentEnv();
            Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);
//            Thread.sleep(3000);
            new WaitAction(driver).waitForLoadingComplete();
            this.enterCVVnumber(bannerProperty.get("CVV_Number"));
            driver.hideKeyboard();
        } else if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new WaitAction(driver).waitForLoadingComplete();
            String banner = getCurrentBanner();
            String env = getCurrentEnv();
            Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);
            this.enterCVVnumber(bannerProperty.get("CVV_Number"));
            new WaitAction(driver).waitForLoadingComplete();
            driver.hideKeyboard();
        }

    }

    public void confirmCVV() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new WaitAction(driver).waitForLoadingComplete();
            new CommonActions(driver).new ClickAction().clickElement(udc_landingPageElements.confirmCVV);
        }
    }


    public void clickAgree() {
        new WaitAction(driver).waitForDisplayed(udc_landingPageElements.clickCheckbox);
        new CommonActions(driver).new ClickAction().clickElement(udc_landingPageElements.clickCheckbox);

    }

    public void clickSave() {
        if (platformName.equalsIgnoreCase("ios")) {
            new WaitAction(driver).waitForClickableAndClick(udc_landingPageElements.startSubscription);
            new WaitAction(driver).waitForLoadingComplete();
        } else {
            new WaitAction(driver).waitForClickableAndClick(udc_landingPageElements.clickSave);
            new WaitAction(driver).waitForLoadingComplete();
        }
    }

    public boolean isConfirmationPageDisplayed() {
        return isElementDisplayed(udc_landingPageElements.subscriptionPage, 50);
    }

    public boolean isCurrentSubscriptionDisplayed() {
        return isElementDisplayed(udc_landingPageElements.currentSubscriptionDisplayed, 50);
    }

    public boolean isCurrentPaymentDisplayed() {
        return isElementDisplayed(udc_landingPageElements.currentPaymentDisplayed, 50);
    }


    public void clickChangePlan() {
        new CommonActions(driver).new ClickAction().clickElement(udc_landingPageElements.clickChangePlan);
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void clickUpdatePayment() {
        new CommonActions(driver).new ClickAction().clickElement(udc_landingPageElements.clickUpdatePayment);
        new WaitAction(driver).waitForLoadingComplete();

    }

    public boolean isSwitchToMonthlyPlanDisplayed() {
        if (platformName.equalsIgnoreCase("android")) {
            return isElementDisplayed(udc_landingPageElements.clickSave, 50);
        } else {
            return isElementDisplayed(udc_landingPageElements.switchToMonthlyPlan, 50);
        }
    }

    public boolean isSwitchToAnnualPlanDisplayed() {
        if (platformName.equalsIgnoreCase("android")) {
            return isElementDisplayed(udc_landingPageElements.clickSave, 50);
        } else {
            return isElementDisplayed(udc_landingPageElements.switchToAnnualPlan, 50);
        }
    }

    public boolean isUpdatePaymentDisplayed() {
        if (platformName.equalsIgnoreCase("android")) {
            return isElementDisplayed(udc_landingPageElements.clickSave, 50);
        } else {
            return isElementDisplayed(udc_landingPageElements.updatePayment, 50);
        }
    }


    public void cancelSubscription() {
        new CommonActions(driver).new ClickAction().clickElement(udc_landingPageElements.cancelSubscription);
    }

    public void clickFirstCancelReason() {
        new WaitAction(driver).waitForDisplayed(udc_landingPageElements.cancellingReason);
        new CommonActions(driver).new ClickAction().clickElement(udc_landingPageElements.cancellingReason);
    }

    public void clickConfirmCancel() {
        new WaitAction(driver).waitForClickableAndClick(udc_landingPageElements.confirmCancellation);
        new WaitAction(driver).waitForLoadingComplete();

    }

    public boolean isSubscriptionPlanDisplayed() {
        return isElementDisplayed(udc_landingPageElements.subscriptionPlan, 50);
    }


    public void clickClose() {
        new CommonActions(driver).new ClickAction().clickElement(udc_landingPageElements.clickClose);

    }
}

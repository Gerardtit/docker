package com.automation.pages;


import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.entities.BannerConfType;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.HomePageElements;
import com.automation.pageElements.SelectOrderTypePageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;

public class SelectOrderTypePage extends BasePage {
    AppiumDevice device = AppiumDeviceManager.getDevice();
    private SelectOrderTypePageElements selectOrderTypePageElements = new SelectOrderTypePageElements();

    GG_OtpPasswordPage otpPasswordPage = new GG_OtpPasswordPage(driver);
    public HomePageElements homePageElements = new HomePageElements();


    public SelectOrderTypePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), selectOrderTypePageElements);
    }

    public void waitForSelectOrderTypePageDisplayed() {
        try {
            waitVar.until(ExpectedConditions.visibilityOf(selectOrderTypePageElements.title));
        } catch (Exception e) {
            waitVar.until(ExpectedConditions.visibilityOf(selectOrderTypePageElements.title2));

        }

    }


    public void clickDelivery() {

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
//            waitForLoadingComplete();
//            waitForDisplayed(selectOrderTypePageElements.deliverToZipButton, 10);
//            selectOrderTypePageElements.deliverToZipButton.click();
            waitForLoadingComplete();
            if (isElementDisplayed(selectOrderTypePageElements.startShoppingButton, 1)) {
                selectOrderTypePageElements.deliverToZipButton.click();
                waitForLoadingComplete();
            }
        } else {
            waitForLoadingComplete();
            waitForDisplayed(selectOrderTypePageElements.deliverToZipButton, 10);
            selectOrderTypePageElements.deliverToZipButton.click();
            waitForLoadingComplete();
            if (!isElementDisplayed(selectOrderTypePageElements.startShoppingButton, 1)) {
                selectOrderTypePageElements.deliverToZipButton.click();
                waitForLoadingComplete();
            }

        }
    }

    public void clickInstore() {

        new WaitAction(driver).waitForLoadingComplete();
        selectOrderTypePageElements.instoreZipButton.click();
        new WaitAction(driver).waitForLoadingComplete();
        if (!isElementDisplayed(selectOrderTypePageElements.startShoppingButton, 1)) {
            selectOrderTypePageElements.instoreZipButton.click();
            new WaitAction(driver).waitForLoadingComplete();

        }
    }

    public void VerifyStartShoppingButton() {
        waitVar.until(ExpectedConditions.visibilityOf(selectOrderTypePageElements.startShoppingButton));
    }

    public void clickStartShoppingButton() {
        new WaitAction(driver).waitForClickableAndClick(selectOrderTypePageElements.startShoppingButton);
    }

  /*  public void clickStartShoppingButton() throws InterruptedException {
        new WaitAction(driver).waitForClickableAndClick(selectOrderTypePageElements.startShoppingButton);
        if (driver.getPlatformName().equalsIgnoreCase("ios"))
            waitforUMAhomeScreen(selectOrderTypePageElements.loadingOrderType);
    }*/

    public void startShoppingButtonEnabled() {
        //  new WaitAction(driver).waitForClickableAndClick(selectOrderTypePageElements.startShoppingButton);
        isElementDisplayed(selectOrderTypePageElements.startShoppingButton);
    }

    /*  public void clickStartShoppingButton() throws InterruptedException {
          new WaitAction(driver).waitForClickableAndClick(selectOrderTypePageElements.startShoppingButton);
          if (driver.getPlatformName().equalsIgnoreCase("ios"))
              waitforUMAhomeScreen(selectOrderTypePageElements.loadingOrderType);
      }
  */
 /*   public void startShoppingButtonEnabled(){
      //  new WaitAction(driver).waitForClickableAndClick(selectOrderTypePageElements.startShoppingButton);
        isElementDisplayed(selectOrderTypePageElements.startShoppingButton);
    }
*/
    public void waitForDownloadDifferentBannerDisplayed() {
        new WaitAction(driver).waitForDisplayed(selectOrderTypePageElements.downLoadDifferentAppTitle);
    }

    public void waitForNotification() {
        new WaitAction(driver).waitForDisplayed(selectOrderTypePageElements.notificationText);
    }

    public void clickNotAllowNotification() {
        new CommonActions(driver).new ClickAction().clickElement(selectOrderTypePageElements.dontAllowNotificationButton);
    }

    public void clickPickUp() {
        new WaitAction(driver).waitForLoadingComplete();
        selectOrderTypePageElements.pickUpButton.click();
        new WaitAction(driver).waitForLoadingComplete();
        if (!isElementDisplayed(selectOrderTypePageElements.searchZipCodeButton, 1)) {
            selectOrderTypePageElements.pickUpButton.click();
            new WaitAction(driver).waitForLoadingComplete();
        }
    }

    public void enterZipCode(String zipcode) {
        enterKey(selectOrderTypePageElements.pickUpZipodeEditText, zipcode);
    }

    public void clickSearchButton() {
        new CommonActions(driver).new ClickAction().clickElement(selectOrderTypePageElements.searchZipCodeButton);
    }

    public void waitForDUGListDisplayed() {
        new WaitAction(driver).waitForDisplayed(selectOrderTypePageElements.dugStoreText);
    }

    public void selectAnyStore() {
        if (getPlatformName().equalsIgnoreCase("ios")) {
            if (getCurrentBanner().equalsIgnoreCase("tomthumb")) {
                if ((!getCurrentBanner().equalsIgnoreCase("tomthumb")) && selectOrderTypePageElements.dugStoreBanner.getAttribute("label").contains(getCurrentBanner())) {
                    scrollDown();
                    new CommonActions(driver).new ClickAction().clickElement(selectOrderTypePageElements.dugStoreText);
                } else if ((getCurrentBanner().equalsIgnoreCase("tomthumb")) && selectOrderTypePageElements.dugStoreBanner.getAttribute("label").contains("Tom")) {
                    scrollDown();
                    new CommonActions(driver).new ClickAction().clickElement(selectOrderTypePageElements.dugStoreText);
                } else {
                    scrollDown();
                    new CommonActions(driver).new ClickAction().clickElement((WebElement) driver.findElements(By.xpath("//*[contains(@label,\"mi.\")]")).get(1));
                }
            }
        } else {
            if ((!getCurrentBanner().equalsIgnoreCase("tomthumb")) && selectOrderTypePageElements.dugStoreBanner.getAttribute("content-desc").contains(getCurrentBanner()))
                new CommonActions(driver).new ClickAction().clickElement(selectOrderTypePageElements.dugStoreText);
            else if ((getCurrentBanner().equalsIgnoreCase("tomthumb")) && selectOrderTypePageElements.dugStoreBanner.getAttribute("content-desc").contains("Tom"))
                new CommonActions(driver).new ClickAction().clickElement(selectOrderTypePageElements.dugStoreText);
            else {
                scrollDown();
                new CommonActions(driver).new ClickAction().clickElement((WebElement) driver.findElements(By.xpath("//*[contains(@content-desc,\"Radio Button  with\")]")).get(0));
            }
        }
    }

    public void selectStore() {
        String store = ThreadLocalHelper.testCaseData.get().get("INSTORE_STORE");
        AppiumDevice device = AppiumDeviceManager.getDevice();
        if (device.getPlatform().equalsIgnoreCase("ios")) {
//            scrollDownForElement(gg_shoppingModePageElements.firstStoreCard);
            boolean storeFound = false;
            int maxScrolls = 10;
            int counter = 0;
            while (!storeFound) {
                while (counter < maxScrolls) {
                    for (int i = 0; i < selectOrderTypePageElements.allStoreCardsList.size(); i++) {
                        String add = selectOrderTypePageElements.allStoreCardsList.get(i).getText();
                        if (add.contains(store)) {
                            new CommonActions(driver).new ClickAction().clickElement(selectOrderTypePageElements.allStoreCardsList.get(i));
                            if (!selectOrderTypePageElements.startShoppingButton.isEnabled()) {
                                new CommonActions(driver).new ClickAction().clickElement(selectOrderTypePageElements.allStoreCardsList.get(i));
                            }

                            counter = maxScrolls;
                            storeFound = true;
                            break;
                        }
                    }
                    if (!storeFound) {
                        scrollDown();
                        counter++;
                    }
                }
                if (counter >= maxScrolls) {
                    break;
                }
            }
        } else {
            for (int i = 0; i < 10; i++) {
                ArrayList<MobileElement> elementList = (ArrayList<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
                for (MobileElement element : elementList) {
                    if (element.getText().contains(store)) {
                        new CommonActions(driver).new ClickAction().clickElement(element);
                        return;
                    }
                }
                scrollDown();
            }
        }
    }

    public void waitForZipcodeFieldDisplayed() {
        new WaitAction(driver).waitForDisplayed(selectOrderTypePageElements.pickUpZipodeEditText);
    }


    public void selectInStoreDeliveryOpion() {
        new CommonActions(driver).new ClickAction().clickElement(selectOrderTypePageElements.InStore);
    }

    public void clickOnStartShopping() throws InterruptedException {
        try {


            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                Thread.sleep(50000);

                new CommonActions(driver).new ClickAction().clickElement(driver.findElement(By.name("Start shopping")));

            } else {
                Thread.sleep(4000);

                new CommonActions(driver).new ClickAction().clickElement(homePageElements.startShoppingButton);


            }
        } catch (Exception ex) {

        }
    }

    public void validateFirstStore() throws InterruptedException {
        //  waitForDUGListDisplayed();
        Thread.sleep(9000);


        if (driver.getPlatformName().equalsIgnoreCase("Android")) {

            String value = selectOrderTypePageElements.storeListRadioBtn.get(0).getAttribute("checked");
            Assert.assertTrue(value.equalsIgnoreCase("true"));
        } else {

            waitForDisplayed(selectOrderTypePageElements.storeListRadioBtn.get(0), 10);

            selectOrderTypePageElements.storeListRadioBtn.get(0).isDisplayed();

        }

        //*[@content-desc="Radio Button Selected with Store Address 1.94miles awaysafeway6790 Bernal Ave Pleasanton, CA 94566Locker Pickup"]//*[@resource-id="com.safeway.client.android.safeway.debug:id/btn_select"]
    }

    public void clickDublinradio() {
        try {
            scrollDown(2);
            new CommonActions(driver).new ClickAction().clickElement(homePageElements.dublinbttn);
        } catch (Exception e) {
            scrollDown(1);
            new CommonActions(driver).new ClickAction().clickElement(homePageElements.dublinbttn);
        }
    }

    public void selectSecondStore() {
        scrollDown();
        waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(selectOrderTypePageElements.secondDUGStore);
        //  waitForLoadingComplete();
    }


    public void enterZipcode(String zipcode) {
        enterKey(selectOrderTypePageElements.searchZipcodeField, zipcode);
    }

    public void verifyInlineZipcodeErrorMsg() {
        if (!isElementVisible(selectOrderTypePageElements.inlineZipcodeErrMsg)) {
            hideKeyBoard();
            new CommonActions(driver).new ClickAction().clickElement(selectOrderTypePageElements.searchZipCodeButton);
        }
        Assert.assertTrue(isElementDisplayed(selectOrderTypePageElements.inlineZipcodeErrMsg.get(0), 20), "Inline error message is not displayed for Non Serviceable Zipcode");
    }


    public void verifyDeliveryFulfilmentOption(String zipcode) {
        String regex = "\\d+";
        String actualZipcode = "";
        if (zipcode.equalsIgnoreCase("zipcode_diff")) {
            actualZipcode = device.getConfigureData(BannerConfType.BANNER_ZIPCODE_DIFF);
        } else if (zipcode.matches(regex)) {
            actualZipcode = zipcode;
        } else if (zipcode.equalsIgnoreCase("instore")) {
            actualZipcode = device.getConfigureData(BannerConfType.BANNER_INSTOREZIPCODE);
        } else {
            actualZipcode = device.getZipCode(zipcode);
        }
        Assert.assertTrue(getText(selectOrderTypePageElements.deliveryFulfilmentOption).equals("Delivery to " + actualZipcode), "Delivery to zipcode text is not appeared or validated successfully");
    }

    public void verifyIfUserIsOnSameBannerAndValidateText() {
        String logo;
        scrollUp();
        if (driver.getPlatformName().equalsIgnoreCase("Android")) {
            logo = getAttribute(selectOrderTypePageElements.bannerLogo, "content-desc");
        } else {
            logo = getAttribute(selectOrderTypePageElements.bannerLogo, "label");
        }
        scrollDown();
        String bannerText = null;
        if (driver.getPlatformName().equalsIgnoreCase("Android")) {
            for (int i = 0; i < selectOrderTypePageElements.bannerText.size(); i++) {
                if (selectOrderTypePageElements.bannerText.get(i).getAttribute("content-desc").equalsIgnoreCase(logo)) {
                    bannerText = selectOrderTypePageElements.bannerText.get(i).getAttribute("content-desc");
                    Assert.assertTrue(selectOrderTypePageElements.textUnderBanner.get(i).getText().equals("Shop for delivery at " + logo + "."));
                    break;
                }
            }
            if (bannerText == null) {
                for (int i = 0; i < selectOrderTypePageElements.textUnderBanner.size(); i++) {
                    Assert.assertTrue(selectOrderTypePageElements.textUnderBanner.get(i).getText().equals("You’ll be redirected to the " + selectOrderTypePageElements.bannerText.get(i).getAttribute("content-desc").substring(0, 1).toUpperCase() + selectOrderTypePageElements.bannerText.get(i).getAttribute("content-desc").substring(1) + " App."));
                }
            }
        } else {
            for (int i = 0; i < selectOrderTypePageElements.bannerText.size(); i++) {
                if (selectOrderTypePageElements.bannerText.get(i).getText().contains("Shop for delivery at")) {
                    String[] arrStr = selectOrderTypePageElements.bannerText.get(i).getText().split(".");
                    bannerText = arrStr[0];
                    Assert.assertTrue(arrStr[1].equals("Shop for delivery at " + logo + "."));
                    break;
                }
            }
            if (bannerText == null) {
                for (int i = 0; i < selectOrderTypePageElements.bannerText.size(); i++) {
                    Assert.assertTrue(selectOrderTypePageElements.bannerText.get(i).getText().contains("You’ll be redirected to the "));
                }
            }

        }

    }

    public void verifyUserNaviagtesToPuntingOrHomePage() throws IOException, InterruptedException {
        String bannerText = null;
        for (int i = 0; i < selectOrderTypePageElements.textUnderBanner.size(); i++) {
            if (selectOrderTypePageElements.textUnderBanner.get(i).getText().contains("Shop for delivery at")) {
                bannerText = selectOrderTypePageElements.textUnderBanner.get(i).getText();
                clickStartShoppingButton();
                otpPasswordPage.verifyUserLoggedInToApp();
                break;
            }
        }
        if (bannerText == null) {
            clickStartShoppingButton();
            Assert.assertTrue((isElementVisible(selectOrderTypePageElements.openAppTitle) && isElementVisible(selectOrderTypePageElements.openAppCTA)) || (isElementVisible(selectOrderTypePageElements.downloadAppTitle) && isElementVisible(selectOrderTypePageElements.downloadAppCTA)), "open App or download App CTA is not visible");
            new CommonActions(driver).new ClickAction().clickElement(selectOrderTypePageElements.backButton);
        }

    }

    public boolean isSelectOrderPageDisplayed() {
        return isElementDisplayed(selectOrderTypePageElements.title);
    }


}
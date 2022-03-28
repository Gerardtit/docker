package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.Deeplinks;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class DeeplinksPage extends BasePage {
    DeeplinksElements deeplinksElements = new DeeplinksElements();
    DealsPageElements dealsPageElements = new DealsPageElements();
    WeeklyAdPageElements weeklyAdPageElements = new WeeklyAdPageElements();
    GG_MyRewardsPageElements gg_myRewardsPageElements = new GG_MyRewardsPageElements();
    ZtpPageElements ztpPageElements = new ZtpPageElements();
    VaccineSchedulerElements vaccineSchedulerElements = new VaccineSchedulerElements();
    PopUpHandleElements popUpHandleElements = new PopUpHandleElements();
    CartPageElements cartPageElements = new CartPageElements();
    GG_Verify_FreshpassElements gg_verify_freshpassElements = new GG_Verify_FreshpassElements();
    AEMZonesPageElements aemZonesPageElements = new AEMZonesPageElements();
    Actions action = new Actions(driver);

    public DeeplinksPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), deeplinksElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dealsPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), weeklyAdPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_myRewardsPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), ztpPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), vaccineSchedulerElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), popUpHandleElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cartPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_verify_freshpassElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), aemZonesPageElements);
    }

    public void openMobileApp() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new CommonActions(driver).new ClickAction().clickElement(deeplinksElements.urlBar);
            new WaitAction(driver).waitForLoadingComplete();
        } else {
            HashMap<String, Object> args = new HashMap<>();

            //code for Notes
//            args.put("bundleId", "com.apple.mobilenotes");
//            driver.executeScript("mobile: launchApp", args);
            ;

            //code for Chrome
//            Map<String, Object> args = new HashMap<>();
            //args.put("bundleId", "com.apple.mobilesafari");
//            driver.executeScript("mobile: launchApp", args);
            args.put("bundleId", "com.google.chrome.ios");
            driver.executeScript("mobile: launchApp", args);
            iOSDeeplinkBrowser();
            new CommonActions(driver).new ClickAction().clickElement(deeplinksElements.urlBar);

        }
    }

    public void iOSDeeplinkBrowser() {
        new CommonActions(driver).new ClickAction().clickElement(deeplinksElements.showTabs);
        new CommonActions(driver).new ClickAction().clickElement(deeplinksElements.closeAllTabs);
        new CommonActions(driver).new ClickAction().clickElement(deeplinksElements.createNewTab);
    }

    public void verifyAppOpened() {
        Assert.assertTrue(deeplinksElements.urlBarAddress.isDisplayed());
    }

    public void enterAppsflyerLink(String link) {
        String banner = getCurrentBanner();
        switch (link) {
            case "J4U":
                enterLink(Deeplinks.J4UPageDeepLinkQA2, banner);
                break;
            case "Weekly Ad":
                enterLink(Deeplinks.WeeklyAdPageDeepLinkQA2, banner);
                break;
            case "Rewards":
                enterLink(Deeplinks.RewardsPageDeepLinkQA2, banner);
                break;
            case "ZTP Add Payment":
                enterLink(Deeplinks.ztpPageDeepLinkQA2, banner);
                break;
            case "Vaccine Scheduler":
                enterLink(Deeplinks.vaccineSchedulerPageDeepLinkQA2, banner);
                break;
            case "Offer CC":
                enterLink(Deeplinks.offerCCDeepLinkQA2, banner);
                break;
            case "Offer PD":
                enterLink(Deeplinks.offerPDDeepLinkQA2, banner);
                break;
            case "Offer Invalid":
                enterLink(Deeplinks.offerInvalidDeepLinkQA2, banner);
                break;
            case "Home":
                enterLink(Deeplinks.HomePageDeepLinkQA2, banner);
                break;
            case "Prescription Transfer":
                enterLink(Deeplinks.PrescriptionTransferDeepLinkQA2, banner);
                break;
            case "All Rewards":
                enterLink(Deeplinks.AllRewardsDeepLinkQA2, banner);
                break;
            case "Cart":
                enterLink(Deeplinks.CartDeepLinkQA2, banner);
                break;
            case "Freshpass":
                enterLink(Deeplinks.FreshPassDeepLinkQA2, banner);
                break;
            case "Meals":
                enterLink(Deeplinks.MealsDeepLinkQA2, banner);
                break;
        }
    }

    private void enterLink(Map<String, String> pageMap, String banner) {

        //code for Notes
//        if (driver.getPlatformName().equalsIgnoreCase("android")) {
//            enterKey(deeplinksElements.urlBarAddress, pageMap.get(banner));
//        } else {
//            enterKey(deeplinksElements.iOSEnterNote, pageMap.get(banner));
//            new CommonActions(driver).new ClickAction().clickElement(deeplinksElements.Done);
//            new CommonActions(driver).new ClickAction().clickElement(deeplinksElements.urlInNotes);
//        }

        //code for Chrome
        enterKey(deeplinksElements.urlBarAddress, pageMap.get(banner));
    }

    public void deleteNote() {
        try {
            if (deeplinksElements.iOSNotesBack.isDisplayed()) {
//              do {
//                  new CommonActions(driver).new ClickAction().clickElement(deeplinksElements.iOSDeleteNote);
//              } while (deeplinksElements.iOSNotesBack.isDisplayed());
                new CommonActions(driver).new ClickAction().clickElement(deeplinksElements.iOSNotesBack);
            }
        } catch (Exception e) {
            return;
        }
    }

    public void createNewNote() {
        new CommonActions(driver).new ClickAction().clickElement(deeplinksElements.iOSNewNote);
    }

    public void verifyDeeplinkTabOpened(String tab) throws Exception {

        if (driver.getPlatformName().equalsIgnoreCase("android")) {

            if (deeplinksElements.openWithBanner.isDisplayed()) {
                new CommonActions(driver).new ClickAction().clickElement(deeplinksElements.openWithBanner);
                try {
                    if (popUpHandleElements.openWithAppAlwaysButton.isDisplayed()) {
                        new CommonActions(driver).new ClickAction().clickElement(popUpHandleElements.openWithAppAlwaysButton);

                    }
                } catch (Exception e) {
                    System.out.println("Open with Always/Just not not present");
                }
                Thread.sleep(5000);
                try {
                    if (popUpHandleElements.Continue.isDisplayed()) {
                        new CommonActions(driver).new ClickAction().clickElement(popUpHandleElements.Continue);

                    }
                } catch (Exception e) {
                    System.out.println("Continue Popup is not present");
                }
            }
        }
        Thread.sleep(7000);
        String banner = getCurrentBanner();
        switch (tab) {
            case "Deals":
                Assert.assertTrue(dealsPageElements.dealPageTitle.isDisplayed());
                break;
            case "Weekly Ad":
                Assert.assertTrue(weeklyAdPageElements.weeklyAdTitle.isDisplayed());
                break;
            case "Rewards":
                Assert.assertTrue(gg_myRewardsPageElements.rewardsButton.isDisplayed());
                break;
            case "ZTP Add Payment":
                Assert.assertTrue(ztpPageElements.paymentsTitle.isDisplayed());
                break;
            case "Vaccine Scheduler":
                Assert.assertTrue(vaccineSchedulerElements.vaccineSchedulerTitle.isDisplayed());
                break;
            case "Offer CC":
                Thread.sleep(9000);
                Assert.assertTrue(deeplinksElements.dealDetailPageTitle.isDisplayed());
                break;
            case "Offer PD":
                Assert.assertTrue(deeplinksElements.dealDetailPageTitle.isDisplayed());
                break;
            case "Offer Invalid":
                Thread.sleep(2000);
                Assert.assertTrue(deeplinksElements.closePopUp.isDisplayed());
                break;
            case "Home":
                Assert.assertTrue(deeplinksElements.menuButton.isDisplayed());
                break;
            case "Prescription Transfer":
                Thread.sleep(6000);
                Assert.assertTrue(deeplinksElements.PrescriptionTransferHeader.isDisplayed());
                break;
            case "All Rewards":
                Thread.sleep(6000);
                Assert.assertTrue(deeplinksElements.allRewardsHeader.isDisplayed());
                break;
            case "Cart":
                Assert.assertTrue(cartPageElements.myCartTitle.isDisplayed());
                break;
            case "Freshpass":
                Assert.assertTrue(gg_verify_freshpassElements.FreshPassAtTitle.isDisplayed());
                break;
            case "Meals":
                Assert.assertTrue(aemZonesPageElements.MealsMadeEasyTitle.isDisplayed());
                break;
        }
    }

    public void carrsQcCashDisplayed() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            Assert.assertTrue(deeplinksElements.carrsCash.getText().equalsIgnoreCase("Carrsqc Cash"));
        } else {
            Assert.assertTrue(deeplinksElements.carrsCash.getText().equalsIgnoreCase("Carrs Cash"));
        }
    }

    public void changeSettings() {
        HashMap<String, Object> args = new HashMap<>();
        args.put("bundleId", "com.apple.Preferences");
        driver.executeScript("mobile: launchApp", args);

        scrollDownForElement(deeplinksElements.tomThumbSetting);
        new CommonActions(driver).new ClickAction().clickElement(deeplinksElements.tomThumbSetting);
        new CommonActions(driver).new ClickAction().clickElement(deeplinksElements.locationAskSetting);
        new CommonActions(driver).new ClickAction().clickElement(deeplinksElements.locationToAlways);
    }

    public void verifyAppCenterIsOpen() {
        Assert.assertTrue(deeplinksElements.appCenter.isDisplayed());
    }
}

package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_SettingsPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class GG_SettingsPage extends BasePage {
    private final GG_SettingsPageElements settingsPageElements = new GG_SettingsPageElements();
    private String appVersion = null;

    public GG_SettingsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), settingsPageElements);
    }

    public boolean verifySettingsIconIsDisplayed() {
        return isElementDisplayed(settingsPageElements.profileIcon);
    }

    public void clickOnSettingsIcon() throws InterruptedException {
        new CommonActions(driver).new ClickAction().clickElement(settingsPageElements.profileIcon);
        Thread.sleep(2000);
    }

    public boolean verifySignOutModuleIsDisplayed() {
        return isElementDisplayed(settingsPageElements.signOutbtn);
    }

    public void clickOnSignOutButton() throws InterruptedException {
        new CommonActions(driver).new ClickAction().clickElement(settingsPageElements.signOutbtn);
        Thread.sleep(2000);
    }

    public boolean verifyOrderModuleIsDisplayed() {
        return isElementDisplayed(settingsPageElements.orderModulebtn);
    }


    public void clickOnOrderbutton() throws InterruptedException {
        new CommonActions(driver).new ClickAction().clickElement(settingsPageElements.orderModulebtn);
        Thread.sleep(2000);
    }

    public boolean verifyUnlimitedDeliveryClubIsDisplayed() {
        return isElementDisplayed(settingsPageElements.unlimitedDeliveryClubbtn);
    }

    public void clickOnUnlimitedDeliveryClubButton() throws InterruptedException {
        new CommonActions(driver).new ClickAction().clickElement(settingsPageElements.unlimitedDeliveryClubbtn);
        Thread.sleep(2000);
    }

    public boolean unlimitedDeliveryClubPageIsDisplayed() {
        return isElementDisplayed(settingsPageElements.unlimitedDeliveryClubTitle);
    }


    public boolean verifyVaccineSchedulerIsDisplayed() {
        return isElementDisplayed(settingsPageElements.vaccineSchedulerbtn);
    }

    public void clickOnVaccineSchedulerButton() {
        new CommonActions(driver).new ClickAction().clickElement(settingsPageElements.vaccineSchedulerbtn);
    }

    public boolean verifyVaccineSchedulerPageIsDisplayed() {
        return isElementDisplayed(settingsPageElements.vaccineSchedulerTitle);
    }


    public boolean AccountModuleIsDisplayed() {
        return isElementDisplayed(settingsPageElements.accountbtn);
    }

    public void clickOnAccountButton() {
        new CommonActions(driver).new ClickAction().clickElement(settingsPageElements.accountbtn);
    }

    public boolean accountPageIsDisplayed() {
        return isElementDisplayed(settingsPageElements.accountTitle);
    }

    public boolean ScanSettingIsDisplayed() {
        return isElementDisplayed(settingsPageElements.scanSettingbtn);
    }

    public void clickOnScanSettingButton() {
        new CommonActions(driver).new ClickAction().clickElement(settingsPageElements.scanSettingbtn);
    }

    public boolean ScanSettingPageIsDisplayed() {
        return isElementDisplayed(settingsPageElements.scanSettingTitle);
    }

    public boolean HelpFAQIsDisplayed() {
        return isElementDisplayed(settingsPageElements.helpFAQbtn);
    }

    public void clickOnHelpFAQButton() {
        new CommonActions(driver).new ClickAction().clickElement(settingsPageElements.helpFAQbtn);
    }

    public boolean helpFAQPageIsDisplayed() {
        waitForLoaderToDisappear();
        return isElementDisplayed(settingsPageElements.helpFAQTitle);
    }

    public void clickBackButton() {
        new CommonActions(driver).new ClickAction().clickElement(settingsPageElements.backButtonToSettings);
    }

    public void clickNavigateButton() {
        new CommonActions(driver).new ClickAction().clickElement(settingsPageElements.navigateButtonToSettings);
    }

    public void waitForLoaderToDisappear() {
        new WaitAction(driver).waitForElementToDisappear(settingsPageElements.loadingSpinner, 60);
    }

    public boolean feedbackModuleIsDisplayed() {
        return isElementDisplayed(settingsPageElements.feedbackBtn);
    }

    public void clickOnFeedbackButton() {
        new CommonActions(driver).new ClickAction().clickElement(settingsPageElements.feedbackBtn);
    }

    public boolean feedbackPageIsDisplayed() {
        return isElementDisplayed(settingsPageElements.feedbackTitle);
    }

    public boolean contactUsModuleIsDisplayed() {
        return isElementDisplayed(settingsPageElements.contactUsBtn);
    }


    public boolean contactUsPageIsDisplayed() {
        return isElementDisplayed(settingsPageElements.contactUsTitle);
    }

    public boolean TermsPoliciesModuleIsDisplayed() {
        if (!isElementVisible(settingsPageElements.termsandPoliciesButton)) {
            scrollDownForElement(settingsPageElements.termsandPoliciesBtn);
        }
        return isElementDisplayed(settingsPageElements.termsandPoliciesBtn);
    }

    public void clickOnTermsPoliciesButton() {
        new CommonActions(driver).new ClickAction().clickElement(settingsPageElements.termsandPoliciesBtn);
    }

    public boolean TermsPoliciesPageIsDisplayed() {
        waitForLoaderToDisappear();
        return isElementDisplayed(settingsPageElements.termsandPoliciesTitle);
    }

    public void clickOntermsAndPolicies() {
        new CommonActions(driver).new ClickAction().clickElement(settingsPageElements.termsandPoliciesBtn);
    }


    public void clickOnContactUsModule() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            scrollDown(1);
        }
        new CommonActions(driver).new ClickAction().clickElement(settingsPageElements.contactUsBtn);
    }

    public boolean ThirdPartyAndOpenSourceModuleIsDisplayed() {
        scrollDownForElement(settingsPageElements.thirdPartyandOpenSourceBtn);
        return isElementDisplayed(settingsPageElements.thirdPartyandOpenSourceBtn);
    }

    public void clickOnThirdPartyAndOpenSourceButton() {
        new CommonActions(driver).new ClickAction().clickElement(settingsPageElements.thirdPartyandOpenSourceBtn);
    }

    public boolean ThirdPartyAndOpenSourcePageIsDisplayed() {
        return isElementDisplayed(settingsPageElements.thirdPartyandOpenSourceTitle);
    }

    public boolean ProductRecallModuleIsDisplayed() {
        scrollDownForElement(settingsPageElements.productRecallBtn);
        return isElementDisplayed(settingsPageElements.productRecallBtn);
    }

    public void clickOnProductRecallButton() {
        new CommonActions(driver).new ClickAction().clickElement(settingsPageElements.productRecallBtn);
    }

    public boolean ProductRecallPageIsDisplayed() {
        return isElementDisplayed(settingsPageElements.productRecallTitle);
    }

    public boolean ChatBotModuleIsDisplayed() {
        scrollDownForElement(settingsPageElements.needHelpBtn);
        return isElementDisplayed(settingsPageElements.needHelpBtn);
    }

    public void clickOnChatBotModule() {
        new CommonActions(driver).new ClickAction().clickElement(settingsPageElements.needHelpBtn);
    }

    public boolean chatScreenIsDisplayed() {
        new WaitAction(driver).waitForDisplayed(settingsPageElements.needHelpTitle);
        return isElementDisplayed(settingsPageElements.needHelpTitle);
    }

    public void selectChatOptionOnContactUsPage() {
        new CommonActions(driver).new ClickAction().clickElement(settingsPageElements.chatOptionContactUs);
    }

    public boolean verifyAddOffersAutomaticallyOptionTitle() {
        return isElementDisplayed(settingsPageElements.addOfferAutomaticallyTitle);

    }

    public boolean verifyAddOffersAutomaticallyOptionDesc() {
        return isElementDisplayed(settingsPageElements.addOfferAutomaticallyDesc);
    }

    public boolean verifyAddOffersAutomaticallyOptionToggle() {
        return isElementDisplayed(settingsPageElements.addOfferAutomaticallyTogglebtn);
    }

    public void clickDeveloperSettings() {
        scrollDownForElement(settingsPageElements.developerSettings, 3);
        new CommonActions(driver).new ClickAction().clickElement(settingsPageElements.developerSettings);
    }

    public void enableFeatureFlagFromDeveloperSettings(String flagName) throws InterruptedException {
        String flagStatus;
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                scrollDownForElement(String.format("//XCUIElementTypeSwitch[contains(@name,'%s')]", flagName));
                flagStatus = driver.findElement(By.xpath(String.format("//XCUIElementTypeSwitch[contains(@name,'%s')]", flagName))).getAttribute("value");
                if (flagStatus.contains("0")) {
                    driver.findElement(By.xpath(String.format("//XCUIElementTypeSwitch[contains(@name,'%s')]", flagName))).click();
                    settingsPageElements.saveDeveloperSettingBtn.click();
                    Thread.sleep(2000);
                }
                break;
            case "ANDROID":
                scrollDownForElement(String.format("//*[@text='%s']", flagName));
                flagStatus = driver.findElement(By.xpath(String.format("//*[contains(@resource-id,'textView2') and @text='%s']//following-sibling::android.widget.Switch", flagName))).getText();
                if (flagStatus.contains("Off")) {
                    driver.findElement(By.xpath(String.format("//*[contains(@resource-id,'textView2') and @text='%s']//following-sibling::android.widget.Switch", flagName))).click();
                    settingsPageElements.saveDeveloperSettingBtn.click();
                    Thread.sleep(2000);
                }
                break;
        }
    }

    public void disableFeatureFlagFromDeveloperSettings(String flagName) throws InterruptedException {
        String flagStatus;
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                scrollDownForElement(String.format("//XCUIElementTypeSwitch[contains(@name,'%s')]", flagName));
                flagStatus = driver.findElement(By.xpath(String.format("//XCUIElementTypeSwitch[contains(@name,'%s')]", flagName))).getAttribute("value");
                if (flagStatus.contains("1")) {
                    driver.findElement(By.xpath(String.format("//XCUIElementTypeSwitch[contains(@name,'%s')]", flagName))).click();
                    settingsPageElements.saveDeveloperSettingBtn.click();
                    Thread.sleep(2000);
                }
                break;
            case "ANDROID":
                scrollDownForElement(String.format("//*[@text='%s']", flagName));
                flagStatus = driver.findElement(By.xpath(String.format("//*[contains(@resource-id,'textView2') and @text='%s']//following-sibling::android.widget.Switch", flagName))).getText();
                if (flagStatus.contains("On")) {
                    driver.findElement(By.xpath(String.format("//*[contains(@resource-id,'textView2') and @text='%s']//following-sibling::android.widget.Switch", flagName))).click();
                    settingsPageElements.saveDeveloperSettingBtn.click();
                    Thread.sleep(2000);
                }
                break;
        }
    }

    public void clickCloseButtonOnSettingPage() {

        scrollUpForElement(settingsPageElements.closeButtonOfSetting, 3);
        new CommonActions(driver).new ClickAction().clickElement(settingsPageElements.closeButtonOfSetting);

    }

    public String getAppDetails() {
        scrollDownForElement(settingsPageElements.appInfo, 3);
        return settingsPageElements.appInfo.getText();
    }

    public String getAppVersion() throws InterruptedException {
        if (appVersion == null) {
            clickOnSettingsIcon();
            appVersion = getAppDetails().split("Version")[1].split("\\(")[0].trim();
        }
        return appVersion;
    }
}
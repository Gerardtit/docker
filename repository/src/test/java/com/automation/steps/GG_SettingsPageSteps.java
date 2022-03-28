package com.automation.steps;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.BasePage;
import com.automation.pages.GG_DashboardPage;
import com.automation.pages.GG_SettingsPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GG_SettingsPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_SettingsPage settingsPage = new GG_SettingsPage(driver);
    public BasePage basePage = new BasePage(driver);

    public String getCurrentBanner() {
        return driver.getCapabilities().getCapability("banner").toString();
    }

    public String getCurrentEnv() {
        return driver.getCapabilities().getCapability("env").toString();
    }

    @And("^verify settings icon is displayed$")
    public void verifySettingsIconIsDisplayed() {
        Assert.assertTrue(settingsPage.verifySettingsIconIsDisplayed());
    }

    @Then("^click on settings icon$")
    public void clickOnSettingsIcon() throws InterruptedException {
        settingsPage.clickOnSettingsIcon();
    }

    @And("^verify Sign out module is displayed$")
    public void verifySignOutModuleIsDisplayed() {
        Assert.assertTrue(settingsPage.verifySignOutModuleIsDisplayed());
    }

    @And("^verify settings page is displayed$")
    public void verifySettingPageDisplayed() {
        Assert.assertTrue(settingsPage.verifySignOutModuleIsDisplayed());
    }

    @Then("^click on Sign out button$")
    public void clickOnSignOutButton() throws InterruptedException {
        settingsPage.clickOnSignOutButton();
    }

    @And("^verify Order module is displayed$")
    public void verifyOrderModuleIsDisplayed() {
        Assert.assertTrue(settingsPage.verifyOrderModuleIsDisplayed());
    }

    @And("^click on terms & policies")
    public void clickOnTermsAndPolicies() {
        settingsPage.clickOntermsAndPolicies();
    }

    @When("^click on Order button$")
    public void clickOnOrderModule() throws InterruptedException {
        settingsPage.clickOnOrderbutton();
    }

    @And("^verify Unlimited Delivery Club is displayed$")
    public void verifyUnlimitedDeliveryClubIsDisplayed() {
        Assert.assertTrue(settingsPage.verifyUnlimitedDeliveryClubIsDisplayed());
    }

    @When("^click on Unlimited Delivery Club button$")
    public void clickOnUnlimitedDeliveryClubButton() throws InterruptedException {
        settingsPage.clickOnUnlimitedDeliveryClubButton();
    }

    @Then("^Unlimited Delivery Club page is displayed$")
    public void unlimitedDeliveryClubPageIsDisplayed() {
        Assert.assertTrue(settingsPage.unlimitedDeliveryClubPageIsDisplayed());
    }

    @And("^verify Vaccine Scheduler is displayed$")
    public void verifyVaccineSchedulerIsDisplayed() {
        Assert.assertTrue(settingsPage.verifyVaccineSchedulerIsDisplayed());
    }

    @When("^click on Vaccine Scheduler button$")
    public void clickOnVaccineSchedulerButton() {
        settingsPage.clickOnVaccineSchedulerButton();
    }

    @Then("^Vaccine Scheduler page is displayed$")
    public void vaccineSchedulerPageIsDisplayed() {
        Assert.assertTrue(settingsPage.verifyVaccineSchedulerPageIsDisplayed());
    }

    @And("^verify Account module is displayed$")
    public void verifyAccountModuleIsDisplayed() {
        Assert.assertTrue(settingsPage.AccountModuleIsDisplayed());
    }

    @When("^click on Account button$")
    public void clickOnAccountButton() {
        settingsPage.clickOnAccountButton();
    }

    @Then("^Account page is displayed$")
    public void accountPageIsDisplayed() {
        Assert.assertTrue(settingsPage.accountPageIsDisplayed());
    }

    @And("^verify Scan setting is displayed$")
    public void verifyScanSettingIsDisplayed() {
        Assert.assertTrue(settingsPage.ScanSettingIsDisplayed());
    }

    @Then("^click on Scan setting button$")
    public void clickOnScanSettingButton() {
        settingsPage.clickOnScanSettingButton();
    }

    @And("^Scan setting page is displayed$")
    public void scanSettingPageIsDisplayed() {
        Assert.assertTrue(settingsPage.ScanSettingPageIsDisplayed());
    }

    @And("^verify Help/FAQ is displayed$")
    public void verifyHelpFAQIsDisplayed() {
        Assert.assertTrue(settingsPage.HelpFAQIsDisplayed());
    }

    @Then("^click on Help/FAQ button$")
    public void clickOnHelpFAQButton() {
        settingsPage.clickOnHelpFAQButton();
    }

    @And("^Help/FAQ page is displayed$")
    public void helpFAQPageIsDisplayed() {
        Assert.assertTrue(settingsPage.helpFAQPageIsDisplayed());
    }

    @Then("^navigate back to Settings screen$")
    public void navigateBackToSettingsScreen() {
        settingsPage.clickBackButton();
    }

    @Then("^click back button to navigate Settings screen$")
    public void clickNavigateBackToSettingsScreen() {
        settingsPage.clickNavigateButton();
    }

    @And("^verify Feedback module is displayed$")
    public void verifyFeedbackModuleIsDisplayed() {
        Assert.assertTrue(settingsPage.feedbackModuleIsDisplayed());
    }

    @Then("^click on Feedback button$")
    public void clickOnFeedbackButton() {
        settingsPage.clickOnFeedbackButton();
    }

    @And("^Feedback page is displayed$")
    public void feedbackPageIsDisplayed() {
        Assert.assertTrue(settingsPage.feedbackPageIsDisplayed());
    }

    @And("^verify Contact us module is displayed$")
    public void verifyContactUsModuleIsDisplayed() {
        Assert.assertTrue(settingsPage.contactUsModuleIsDisplayed());
    }

    @Then("^click on Contact us module$")
    public void clickOnContactUsModule() {
        settingsPage.clickOnContactUsModule();
    }

    @And("^Contact us page is displayed$")
    public void contactUsPageIsDisplayed() {
        Assert.assertTrue(settingsPage.contactUsPageIsDisplayed());
    }

    @And("^verify terms & policies module is displayed$")
    public void verifyEcomTermsPoliciesModuleIsDisplayed() {
        Assert.assertTrue(settingsPage.TermsPoliciesModuleIsDisplayed());
    }

    @Then("^click on terms & policies button$")
    public void clickOnTermsPoliciesButton() {
        settingsPage.clickOnTermsPoliciesButton();
    }

    @And("^terms & policies page is displayed$")
    public void termsPoliciesPageIsDisplayed() {
        Assert.assertTrue(settingsPage.TermsPoliciesPageIsDisplayed());
    }

    @And("^verify third party and open source module is displayed$")
    public void verifyThirdPartyAndOpenSourceModuleIsDisplayed() {
        Assert.assertTrue(settingsPage.ThirdPartyAndOpenSourceModuleIsDisplayed());
    }

    @Then("^click on third party and open source button$")
    public void clickOnThirdPartyAndOpenSourceButton() {
        settingsPage.clickOnThirdPartyAndOpenSourceButton();
    }

    @And("^third party and open source page is displayed$")
    public void thirdPartyAndOpenSourcePageIsDisplayed() {
        Assert.assertTrue(settingsPage.ThirdPartyAndOpenSourcePageIsDisplayed());
    }

    @And("^verify product recall module is displayed$")
    public void verifyProductRecallModuleIsDisplayed() {
        Assert.assertTrue(settingsPage.ProductRecallModuleIsDisplayed());
    }

    @Then("^click on product recall button$")
    public void clickOnProductRecallButton() {
        settingsPage.clickOnProductRecallButton();
    }

    @And("^product recall page is displayed$")
    public void productRecallPageIsDisplayed() {
        Assert.assertTrue(settingsPage.ProductRecallPageIsDisplayed());
    }

    @And("^verify chat bot module is displayed$")
    public void verifyChatBotModuleIsDisplayed() {
        Assert.assertTrue(settingsPage.ChatBotModuleIsDisplayed());
    }

    @Then("^click on chat bot module$")
    public void clickOnChatBotModule() {
        settingsPage.clickOnChatBotModule();
    }

    @And("^verify chat screen is displayed$")
    public void verifyChatScreenIsDisplayed() {
        Assert.assertTrue(settingsPage.chatScreenIsDisplayed());
    }

    @And("^select chat option on contact us page$")
    public void selectChatOptionOnContactUsPage() {
        settingsPage.selectChatOptionOnContactUsPage();
    }

    @Then("^verify Add Offers Automatically option$")
    public void verifyAddOffersAutomaticallyoption() {
        Assert.assertTrue(settingsPage.verifyAddOffersAutomaticallyOptionTitle());
        Assert.assertTrue(settingsPage.verifyAddOffersAutomaticallyOptionDesc());
        Assert.assertTrue(settingsPage.verifyAddOffersAutomaticallyOptionToggle());
    }

    @When("^turn \"([^\"]*)\" newCheckout feature$")

    public void turnnewCheckoutFlagOn(String desiredStatus) throws InterruptedException {
        //   settingsPage.turnnewCheckoutFlagOn();
        settingsPage.enableFeatureFlagFromDeveloperSettings("NEW_CHECKOUT");
    }

    @And("^scroll down and click on developer settings$")
    public void clickOnDeveloperSettings() {
        settingsPage.clickDeveloperSettings();
    }

    @And("^turn \"([^\"]*)\" snapV2 feature$")
    public void turnSNAPOff(String desiredStatus) throws InterruptedException {
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                if (desiredStatus.equalsIgnoreCase("ON")) {
                    settingsPage.enableFeatureFlagFromDeveloperSettings("snapV2");
                } else {
                    settingsPage.disableFeatureFlagFromDeveloperSettings("snapV2");
                }
                driver.navigate().back();
                break;
            case "ANDROID":
                if (desiredStatus.equalsIgnoreCase("ON")) {
                    settingsPage.enableFeatureFlagFromDeveloperSettings("SNAP_V2");
                } else {
                    settingsPage.disableFeatureFlagFromDeveloperSettings("SNAP_V2");
                }
                break;
        }


    }

    @And("^turn \"([^\"]*)\" newcart feature$")
    public void turnNewCartOff(String desiredStatus) throws InterruptedException {
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                if (desiredStatus.equalsIgnoreCase("ON")) {
                    settingsPage.enableFeatureFlagFromDeveloperSettings("CART_V2");
                } else {
                    settingsPage.disableFeatureFlagFromDeveloperSettings("CART_V2");
                }
                break;
            case "ANDROID":
                if (desiredStatus.equalsIgnoreCase("ON")) {
                    settingsPage.enableFeatureFlagFromDeveloperSettings("CART_V2");
                } else {
                    settingsPage.disableFeatureFlagFromDeveloperSettings("CART_V2");
                }
                break;
        }
    }

    @And("^turn \"([^\"]*)\" defaultLandingToHome feature$")
    public void turnDefaultLandingHomeOn(String desiredStatus) throws InterruptedException {
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                if (desiredStatus.equalsIgnoreCase("ON")) {
                    settingsPage.enableFeatureFlagFromDeveloperSettings("defaultLandingToHome");
                } else {
                    settingsPage.disableFeatureFlagFromDeveloperSettings("defaultLandingToHome");
                }
                break;
            case "ANDROID":
                if (desiredStatus.equalsIgnoreCase("ON")) {
                    settingsPage.enableFeatureFlagFromDeveloperSettings("DEFAULT_LANDING_TO_HOME");
                } else {
                    settingsPage.disableFeatureFlagFromDeveloperSettings("DEFAULT_LANDING_TO_HOME");
                }
                break;
        }
    }

    @And("^turn \"([^\"]*)\" newaccount feature$")
    public void turnnewAccountfeatureOn(String desiredStatus) throws InterruptedException {
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                if (desiredStatus.equalsIgnoreCase("ON")) {
                    settingsPage.enableFeatureFlagFromDeveloperSettings("isMyAccountFeatureEnabled");
                } else {
                    settingsPage.disableFeatureFlagFromDeveloperSettings("isMyAccountFeatureEnabled");
                }
                break;
            case "ANDROID":
                if (desiredStatus.equalsIgnoreCase("ON")) {
                    settingsPage.enableFeatureFlagFromDeveloperSettings("MY_ACCOUNT_FEATURE_ENABLED");
                } else {
                    settingsPage.disableFeatureFlagFromDeveloperSettings("MY_ACCOUNT_FEATURE_ENABLED");
                }
                break;
        }
    }

    @And("turn {string} MyList feature")
    public void turnOnOffMyList(String desiredStatus) throws InterruptedException {
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                if (desiredStatus.equalsIgnoreCase("ON")) {
                    settingsPage.enableFeatureFlagFromDeveloperSettings("myList");
                } else {
                    settingsPage.disableFeatureFlagFromDeveloperSettings("myList");
                }
                break;
            case "ANDROID":
                if (desiredStatus.equalsIgnoreCase("ON")) {
                    settingsPage.enableFeatureFlagFromDeveloperSettings("MY_LIST");
                } else {
                    settingsPage.disableFeatureFlagFromDeveloperSettings("MY_LIST");
                }
                break;
        }
    }

    @And("^turn \"([^\"]*)\" aemSimpleCarousel feature$")
    public void turnAemSimpleCarouselOn(String desiredStatus) throws InterruptedException {
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                if (desiredStatus.equalsIgnoreCase("ON")) {
                    settingsPage.enableFeatureFlagFromDeveloperSettings("aemSimpleCarousel");
                } else {
                    settingsPage.disableFeatureFlagFromDeveloperSettings("aemSimpleCarousel");
                }
                break;
            case "ANDROID":
                if (desiredStatus.equalsIgnoreCase("ON")) {
                    settingsPage.enableFeatureFlagFromDeveloperSettings("AEM_SIMPLE_CAROUSEL");
                } else {
                    settingsPage.disableFeatureFlagFromDeveloperSettings("AEM_SIMPLE_CAROUSEL");
                }
                break;
        }
    }


    /*@And("^turn \"([^\"]*)\" aemLargeBanner feature$")
    public void turnAemLargeBannerOn(String desiredStatus) throws InterruptedException {
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                if (desiredStatus.equalsIgnoreCase("ON")) {
                    settingsPage.enableFeatureFlagFromDeveloperSettings("aemLargeBanner");
                } else {
                    settingsPage.disableFeatureFlagFromDeveloperSettings("aemLargeBanner");
                }
                break;
            case "ANDROID":
                if (desiredStatus.equalsIgnoreCase("ON")) {
                    settingsPage.enableFeatureFlagFromDeveloperSettings("AEM_LARGE_BANNER");
                } else {
                    settingsPage.disableFeatureFlagFromDeveloperSettings("AEM_LARGE_BANNER");
                }
                break;
        }
    }*/


    @And("^turn \"([^\"]*)\" multiCtaCarousel feature$")
    public void turnMultiCtaCarouselOn(String desiredStatus) throws InterruptedException {
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                if (desiredStatus.equalsIgnoreCase("ON")) {
                    settingsPage.enableFeatureFlagFromDeveloperSettings("multiCtaCarousals");
                } else {
                    settingsPage.disableFeatureFlagFromDeveloperSettings("multiCtaCarousals");
                }
                break;
            case "ANDROID":
                if (desiredStatus.equalsIgnoreCase("ON")) {
                    settingsPage.enableFeatureFlagFromDeveloperSettings("MULTI_CTA_CAROUSALS");
                } else {
                    settingsPage.disableFeatureFlagFromDeveloperSettings("MULTI_CTA_CAROUSALS");
                }
                break;
        }
    }


    @And("^turn \"([^\"]*)\" aemLargeBanner feature$")
    public void turnAemLargeBannerOn(String desiredStatus) throws InterruptedException {
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                if (desiredStatus.equalsIgnoreCase("ON")) {
                    settingsPage.enableFeatureFlagFromDeveloperSettings("aemLargeBanner");
                } else {
                    settingsPage.disableFeatureFlagFromDeveloperSettings("aemLargeBanner");
                }
                break;
            case "ANDROID":
                if (desiredStatus.equalsIgnoreCase("ON")) {
                    settingsPage.enableFeatureFlagFromDeveloperSettings("AEM_LARGE_BANNER");
                } else {
                    settingsPage.disableFeatureFlagFromDeveloperSettings("AEM_LARGE_BANNER");
                }
                break;
        }
    }

    @And("^turn \"([^\"]*)\" aemLargeCarousel feature$")
    public void turnAemLargeCarouselOn(String desiredStatus) throws InterruptedException {
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                if (desiredStatus.equalsIgnoreCase("ON")) {
                    settingsPage.enableFeatureFlagFromDeveloperSettings("aemLargeCarousel");
                } else {
                    settingsPage.disableFeatureFlagFromDeveloperSettings("aemLargeCarousel");
                }
                break;
            case "ANDROID":
                if (desiredStatus.equalsIgnoreCase("ON")) {
                    settingsPage.enableFeatureFlagFromDeveloperSettings("AEM_LARGE_CAROUSEL");
                } else {
                    settingsPage.disableFeatureFlagFromDeveloperSettings("AEM_LARGE_CAROUSEL");
                }
                break;
        }
    }


    @And("^click close button on setting page$")
    public void clickOnCloseButton() {
        settingsPage.clickCloseButtonOnSettingPage();
    }

    @And("get and store app version from settings page")
    public void getAndStoreAppVersion() throws InterruptedException {
        if (ThreadLocalHelper.testCaseData.get().get("APP_VERSION") == null) {
            GG_DashboardPage gg_dashboardPage = new GG_DashboardPage(driver);
            gg_dashboardPage.goToHomeTabWithTutorialHandling();
            gg_dashboardPage.scrollUpToProfileIconHomePage();
            clickOnSettingsIcon();
            String appVersion = settingsPage.getAppDetails().split("Version")[1].split("\\(")[0].trim();
            ThreadLocalHelper.testCaseData.get().put("APP_VERSION", appVersion);
            settingsPage.clickCloseButtonOnSettingPage();
        }
    }

    @And("^turn \"([^\"]*)\" removeWeeklyAdBanner feature$")
    public void turnRemoveWeeklyAdBannerOn(String desiredStatus) throws InterruptedException {
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                if (desiredStatus.equalsIgnoreCase("ON")) {
                    settingsPage.enableFeatureFlagFromDeveloperSettings("removeWeeklyAdBanner");
                } else {
                    settingsPage.disableFeatureFlagFromDeveloperSettings("removeWeeklyAdBanner");
                }
                break;
            case "ANDROID":
                if (desiredStatus.equalsIgnoreCase("ON")) {
                    settingsPage.enableFeatureFlagFromDeveloperSettings("REMOVE_WEEKLY_AD_BANNER");
                } else {
                    settingsPage.disableFeatureFlagFromDeveloperSettings("REMOVE_WEEKLY_AD_BANNER");
                }
                break;
        }
    }
}

package com.automation.pages;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_MyRewardsElements;
import com.automation.pageElements.HomePageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.regex.Pattern;

public class GG_foru_rewardsPage extends BasePage {
    public HomePageElements homePageElements = new HomePageElements();
    private final GG_MyRewardsElements rewadsforuElements = new GG_MyRewardsElements();
    private final AppiumDevice device = AppiumDeviceManager.getDevice();

    public GG_foru_rewardsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), rewadsforuElements);

        PageFactory.initElements(new AppiumFieldDecorator(driver), homePageElements);
    }

    public void dealsreward() {
        rewadsforuElements.rewarddeals.click();
    }

    public void homepageRewards() {

        new WaitAction(driver).waitForLoadingComplete();
        new WaitAction(driver).waitForDisplayed(rewadsforuElements.rewardhome);
        rewadsforuElements.rewardhome.click();
    }

    public void dealstab() {
        homePageElements.dealsTab.click();
    }

    public void chart() {
        scrollDownForElement(rewadsforuElements.pdeals);
        rewadsforuElements.bdaytreat.isDisplayed();
        rewadsforuElements.freeitem.isDisplayed();
        rewadsforuElements.welcomeoffer.isDisplayed();
        rewadsforuElements.pdeals.isDisplayed();
        scrollDownForElement(rewadsforuElements.hrdelivery);
        rewadsforuElements.redeemrewards.isDisplayed();
        rewadsforuElements.unlimitedfree.isDisplayed();
        rewadsforuElements.starbuckPerk.isDisplayed();
        rewadsforuElements.hrdelivery.isDisplayed();
        scrollUpForElement(rewadsforuElements.organic);
        rewadsforuElements.organic.isDisplayed();
        rewadsforuElements.rewardsnoexpire.isDisplayed();
        scrollDownForElement(rewadsforuElements.learntab);
        rewadsforuElements.vipcare.isDisplayed();
        rewadsforuElements.experienceculi.isDisplayed();
        rewadsforuElements.learntab.isDisplayed();
    }

    public void forutab() {
        rewadsforuElements.forUtitle.click();
    }

    public void bdaycard() {
        scrollDownForElement(rewadsforuElements.comingsoon);
        rewadsforuElements.comingsoon.isDisplayed();
        scrollDownForElement(rewadsforuElements.comingsoonbdaytext);
        rewadsforuElements.comingsoonbdaytext.isDisplayed();
    }

    public void verifyRewardsScoreCard() {

        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            // String text = rewadsforuElements.scorecardNoRewards.getText();
            //Assert.assertTrue(Pattern.matches("Explore rewards button. 0 out of 100 points to your next reward",text), "Points are not displaying");
            Assert.assertTrue(isElementDisplayed(rewadsforuElements.exploreRewards), "Explore Rewards text is not displaying");
            Assert.assertTrue(isElementDisplayed(rewadsforuElements.scorecardNoRewards), "arrow is not displaying");

            Assert.assertTrue(Pattern.matches("0/100 pts", rewadsforuElements.pointsScoreCard.getText().trim()), "Points are not displaying in the form of x/100 pts");

        } else {
            String text = rewadsforuElements.scorecardNoRewards.getAttribute("label");
            Assert.assertTrue(Pattern.matches("Explore rewards button. 0 out of 100 points to your next reward", text), "Points are not displaying");
            Assert.assertTrue(isElementDisplayed(rewadsforuElements.exploreRewards), "Explore Rewards text is not displaying");
            Assert.assertTrue(Pattern.matches("0/100 pts", rewadsforuElements.pointsScoreCard.getAttribute("label").trim()), "Points are not displaying in the form of x/100 pts");
        }

    }

    public void clickOnScoreCardNoRewards() {
        //rewadsforuElements.scorecardNoRewards.click();
        waitVar.until(ExpectedConditions.visibilityOf(rewadsforuElements.scorecardNoRewards));
        new CommonActions(driver).new ClickAction().clickElement(rewadsforuElements.scorecardNoRewards);
    }

    public void verifyHowForUScreen() {
        waitVar.until(ExpectedConditions.visibilityOf(rewadsforuElements.howForUScoreCardNoRewards));
        //String s= rewadsforuElements.howForUScoreCardNoRewards.getText();

        if (driver.getPlatformName().equalsIgnoreCase("ios"))
            Assert.assertTrue(rewadsforuElements.howForUScoreCardNoRewards.getText().contains("You have 0 / 100 Points. Start spending to earn points"), "you have 0/100 points message is not diusplayed");

        else {
            Assert.assertTrue(rewadsforuElements.howForUScoreCardNoRewards.getText().contains("Start spending to earn points"), "start spending some points message is not displayed");
            Assert.assertTrue(rewadsforuElements.howForUScoreCardNoRewards.getText().contains("You have 0 / 100 Points"), "you have 0/100 points message is not displayed");

        }
        scrollUpForElement(rewadsforuElements.earningPointsText);
        rewadsforuElements.earningPointsText.isDisplayed();
        rewadsforuElements.earnPointForeveryDol.isDisplayed();
        scrollDownForElement(rewadsforuElements.foruPerks);
        rewadsforuElements.foruPerks.isDisplayed();
        scrollDown();
        rewadsforuElements.faqInHowForUScreen.isDisplayed();
        rewadsforuElements.termsAndConditionHowFU.isDisplayed();

    }

    public void verifyHeading() {

        String banner = device.getBanner();
        if (banner.equalsIgnoreCase("tomthumb"))
            rewadsforuElements.howForUscreenHeading.getText().contains("Tom Thumb for U");
        else if (banner.equalsIgnoreCase("safeway"))
            rewadsforuElements.howForUscreenHeading.getText().contains("Safeway for U");
        else if (banner.equalsIgnoreCase("albertsons"))
            rewadsforuElements.howForUscreenHeading.getText().contains("Albertsons for U");
        else if (banner.equalsIgnoreCase("Randalls"))
            rewadsforuElements.howForUscreenHeading.getText().contains("Randalls for U");
        else if (banner.equalsIgnoreCase("pavillions"))
            rewadsforuElements.howForUscreenHeading.getText().contains("Pavillions for U");
        else if (banner.equalsIgnoreCase("acme"))
            rewadsforuElements.howForUscreenHeading.getText().contains("ACME for U");
        else if (banner.equalsIgnoreCase("starmarket"))
            rewadsforuElements.howForUscreenHeading.getText().contains("Star Market for U");
        else if (banner.equalsIgnoreCase("carrs"))
            rewadsforuElements.howForUscreenHeading.getText().contains("Carrs for U");
        else if (banner.equalsIgnoreCase("Vons"))
            rewadsforuElements.howForUscreenHeading.getText().contains("Vons for U");
        else if (banner.equalsIgnoreCase("jewelosco"))
            rewadsforuElements.howForUscreenHeading.getText().contains("Jewel-Osco for U");


    }

    public void verifyTermsAndCondition() {
        scrollDown();
        // System.out.println("timezone"+TimeZone.getDefault());
        rewadsforuElements.faqInHowForUScreen.click();
        waitVar.until(ExpectedConditions.visibilityOf(rewadsforuElements.faqText));
        rewadsforuElements.faqText.isDisplayed();
        if (driver.getPlatformName().equalsIgnoreCase("android"))
            androidNavigateBack();
        else
            rewadsforuElements.doneButton.click();

        scrollDown();
        if (isElementDisplayed(rewadsforuElements.cookieClose))
            rewadsforuElements.cookieClose.click();

        rewadsforuElements.termsAndConditionHowFU.click();
        rewadsforuElements.TandCText.isDisplayed();
        if (driver.getPlatformName().equalsIgnoreCase("android"))
            androidNavigateBack();
        else
            rewadsforuElements.doneButton.click();

    }

    public void verifyRewardsScoreCardWithRewards() {
        rewadsforuElements.scorecardwithRewards.isDisplayed();
        Assert.assertTrue(rewadsforuElements.scorecardwithRewards.getText().contains("Rewards"), "reward balance is not displyed");
        Assert.assertTrue(isElementDisplayed(rewadsforuElements.RedeemLink), "Redeem link is not available");
    }

    public void clickOnScoreCardWithRewards() {
        rewadsforuElements.scorecardwithRewards.click();
    }

    public void verifyHowForUScreenWithRewards() {

        waitVar.until(ExpectedConditions.visibilityOf(rewadsforuElements.howforUWithRewards));
        rewadsforuElements.howforUWithRewards.isDisplayed();
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            Assert.assertTrue(rewadsforuElements.howforUWithRewards.getText().contains("You have 0 / 100 Points"), "rewards message is not displayed");
            Assert.assertTrue(rewadsforuElements.howforUWithRewards.getText().contains("Keep it up! You have "), "rewards message is not displayed");
            Assert.assertTrue(rewadsforuElements.howforUWithRewards.getText().contains("expiring at the end of the month"), "rewards message is not displayed");
            Assert.assertTrue(rewadsforuElements.howforUWithRewards.getText().contains("(as of "), "rewards timestamp is not displayed");
        } else {
            Assert.assertTrue(rewadsforuElements.howforUWithRewards.getAttribute("label").contains("You have 0 / 100 Points. Keep it up! You have "), "rewards message is not displayed");
            Assert.assertTrue(rewadsforuElements.howforUWithRewards.getAttribute("label").contains("and 0 expiring at the end of the month. (as of "), "rewards message is not displayed");

        }

        rewadsforuElements.earningPointsText.isDisplayed();
        rewadsforuElements.earnPointForeveryDol.isDisplayed();
        scrollDownForElement(rewadsforuElements.foruPerks);
        rewadsforuElements.foruPerks.isDisplayed();
        scrollDown();
        rewadsforuElements.faqInHowForUScreen.isDisplayed();
        rewadsforuElements.termsAndConditionHowFU.isDisplayed();
    }

    public void verifyHowDORewardsWithRewardsexpiringEOM() {

        waitVar.until(ExpectedConditions.visibilityOf(rewadsforuElements.howforUWithRewards));
        String rewardsBalanceText = "";

        rewadsforuElements.howforUWithRewards.isDisplayed();
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            Assert.assertTrue(rewadsforuElements.howforUWithRewards.getText().contains("You have 0 / 100 Points"), "rewards message is not displayed");
            Assert.assertTrue(rewadsforuElements.howforUWithRewards.getText().contains("Keep it up! You have "), "rewards message is not displayed");
            String rewardsText[] = rewadsforuElements.howforUWithRewards.getText().split("and");
            // rewardsBalanceText = CharMatcher.inRange('0', '9').retainFrom(rewardsText[1].substring(0,5));
            //int rewardsBalanceValue = Integer.parseInt(rewardsBalanceText.trim());
            Assert.assertTrue(Pattern.matches("and [1-9][0-9]+ expiring at the end of the month", "and " + rewardsText[1].split("\\.")[0].trim()), "Rewards balance is expioring is not displayed when user has rewards");
            Assert.assertTrue(rewadsforuElements.howforUWithRewards.getText().contains("(as of "), "rewards timestamp is not displayed");
        } else {

            String rewardsText[] = rewadsforuElements.howforUWithRewards.getAttribute("label").split("and");
            // rewardsBalanceText = CharMatcher.inRange('0', '9').retainFrom(rewardsText[1].substring(0,5));
            // int rewardsBalanceValue = Integer.parseInt(rewardsBalanceText.trim());
            Assert.assertTrue(rewadsforuElements.howforUWithRewards.getAttribute("label").contains("You have 0 / 100 Points"), "rewards message is not displayed");
            Assert.assertTrue(rewadsforuElements.howforUWithRewards.getAttribute("label").contains("Keep it up! You have"), "rewards message is not displayed");
            Assert.assertTrue(Pattern.matches("and [1-9][0-9]+ expiring at the end of the month", "and " + rewardsText[1].split("\\.")[0].trim()), "Rewards balance is expioring is not displayed when user has rewards");
            //Assert.assertTrue(rewadsforuElements.howforUWithRewards.getAttribute("label").contains("and "+rewardsBalanceValue+" expiring at the end of the month. (as of "), "rewards message is not displayed");
            Assert.assertTrue(rewadsforuElements.howforUWithRewards.getAttribute("label").contains("(as of "), "date and time is not displayed");

        }

    }

    public void verifyHowDoRewardsInRewardsTab() {
        scrollDownForElement(rewadsforuElements.howDoRewardsWorks);
        Assert.assertTrue(isElementDisplayed(rewadsforuElements.howDoRewardsWorks), "How do Rewards works is not displayed in Rewards tab");

    }

    public void clickOnHowDoRewardsWorks() {
        scrollDownForElement(rewadsforuElements.howDoRewardsWorks);
        rewadsforuElements.howDoRewardsWorks.click();
    }

    public void clickOnRewards() {

        rewadsforuElements.rewards.click();
    }

    public void verifyMsgOnHowDoReWardsWorkdScreen() {

        waitVar.until(ExpectedConditions.visibilityOf(rewadsforuElements.howforUWithRewards));
        rewadsforuElements.howforUWithRewards.isDisplayed();
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            Assert.assertTrue(Pattern.matches("You have [1-9][0-9]+ / 100 Points", rewadsforuElements.howforUWithRewards.getText().split("Points")[0].trim() + " Points"), "No points available for this usrer");
            // Assert.assertTrue(rewadsforuElements.howforUWithRewards.getText().contains("You have "+arg0+" / 100 Points"), "rewards message is not displayed");
            Assert.assertFalse(rewadsforuElements.howforUWithRewards.getText().contains("Keep it up! You have "), "Keep it up line is displayed");
            Assert.assertTrue(rewadsforuElements.howforUWithRewards.getText().contains("(as of "), "rewards timestamp is not displayed");
        } else {
            Assert.assertTrue(Pattern.matches("You have [1-9][0-9]+ / 100 Points", rewadsforuElements.howforUWithRewards.getAttribute("label").split("Points")[0].trim() + " Points"), "No points available for this usrer");
            // Assert.assertTrue(rewadsforuElements.howforUWithRewards.getAttribute("label").contains("You have "+arg0+" / 100 Points"), "rewards message is not displayed");
            Assert.assertFalse(rewadsforuElements.howforUWithRewards.getAttribute("label").contains("Keep it up! You have "), "Keep it up line is displayed");
            Assert.assertTrue(rewadsforuElements.howforUWithRewards.getAttribute("label").contains("(as of "), "rewards timestamp is not displayed");

        }
    }

    public void verifyScrorecardNoRewardsOnlyPoints() {

        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            // String text = rewadsforuElements.scorecardNoRewards.getText();
            //  Assert.assertTrue(Pattern.matches("Explore rewards button. [1-9][0-9]+ out of 100 points to your next reward",text), "Points are not displaying");
            Assert.assertTrue(isElementDisplayed(rewadsforuElements.exploreRewards), "Explore Rewards text is not displaying");
            Assert.assertTrue(isElementDisplayed(rewadsforuElements.scorecardNoRewards), "arropw button is not displaying");
            Assert.assertTrue(Pattern.matches("[1-9][0-9]+/100 pts", rewadsforuElements.pointsScoreCard.getText().trim()), "Points are not displaying in the form of x/100 pts");

        } else {
            String text = rewadsforuElements.scorecardNoRewards.getAttribute("label");
            Assert.assertTrue(Pattern.matches("Explore rewards button. [1-9][0-9]+ out of 100 points to your next reward", text), "Points are not displaying");
            Assert.assertTrue(isElementDisplayed(rewadsforuElements.exploreRewards), "Explore Rewards text is not displaying");
            Assert.assertTrue(Pattern.matches("[1-9][0-9]+/100 pts", rewadsforuElements.pointsScoreCard.getAttribute("label").trim()), "Points are not displaying in the form of x/100 pts");
        }

    }
}

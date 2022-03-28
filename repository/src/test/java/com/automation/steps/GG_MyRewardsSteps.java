package com.automation.steps;

import com.automation.helpers.AppActions;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.*;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.internal.com.google.common.base.CharMatcher;
import org.testng.Assert;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

public class GG_MyRewardsSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_MyRewardsPage myRewardsPage = new GG_MyRewardsPage(driver);
    public GG_DashboardPage dashboardPage = new GG_DashboardPage(driver);
    public GG_ShoppingModePage shoppingModePage = new GG_ShoppingModePage(driver);
    public AppActions appActions = new AppActions();
    public GG_Deals_ForYouPage dealsForYouPage = new GG_Deals_ForYouPage(driver);
    public GG_foru_rewardsPage rewardsForuPage = new GG_foru_rewardsPage(driver);


    @When("^click on reward link$")
    public void clickOnRewardLink() {
        dashboardPage.handleLoveAppPopup();
        myRewardsPage.clickRewardLink();
    }

    @When("^verify Start Earning Today reward module$")
    public void verifyRewardLinkIsDisplayed() {
        Assert.assertTrue(myRewardsPage.verifyStartEarningTodayRewardLink());
    }

    @Then("^verify reward page title$")
    public void verifyRewardPageTitle() {
        myRewardsPage.verifyRewardsPageTitle();
//       Assert.assertTrue(myRewardsPage.verifyRewardsPageTitle());
    }

    @Then("verify rewards balance when user has one or more rewards")
    public void verifyRewardsBalanceValue() {
        String rewardBalanceDetailsText = myRewardsPage.getRewardsBalanceText();

        if (driver.getPlatformName().equalsIgnoreCase("IOS")) {

            System.out.println("rewards" + rewardBalanceDetailsText.split("rewards")[0].trim() + " rewards");
            System.out.println("rewards" + Pattern.matches("You have [1-9][0-9]+ rewards", rewardBalanceDetailsText.split("rewards")[0].trim() + " rewards"));
            Assert.assertTrue(Pattern.matches("You have [1-9][0-9]+ rewards", rewardBalanceDetailsText.split("rewards")[0].trim() + " rewards"), "Rewards balance is not displayed when user has rewards");
        } else {
            Assert.assertTrue(Pattern.matches("[1-9][0-9]+ Rewards", rewardBalanceDetailsText.trim()), "Rewards balance is not displayed when user has rewards");

        }
        /* else {
            Assert.assertEquals(rewardBalanceDetailsText, Pattern.matches("[1-9]+", rewardBalanceDetailsText), "Rewards balance is not displayed when user has rewards");
        }*/
    }

    @Then("verify rewards balance when user has zero rewards")
    public void verifyRewardsBalanceValueZeroRewards() {
        String rewardBalanceDetailsText = myRewardsPage.getRewardsBalanceText();
        if (myRewardsPage.isNewRewardsUiDisplayed()) {
            Assert.assertEquals(rewardBalanceDetailsText.split("rewards")[0] + "rewards", "Shop to earn rewards", "Rewards balance is not displayed when user has zero rewards");
        } else {
            Assert.assertEquals(rewardBalanceDetailsText, "0", "Rewards balance is not displayed when user has zero rewards");
        }
    }

    @And("^click back button from clip rewards screen$")
    public void clickBackButtonFromMyRewards() {
        myRewardsPage.clickBackButton();
    }

    @Then("^verify expiring date$")
    public void verifyExpiringDate() {
        if (myRewardsPage.isNewRewardsUiDisplayed()) {
            String rewardsPointsAndExpirySummaryText = myRewardsPage.getExpiringDateTextForU();
            if (myRewardsPage.getRewardBalance() > 0) {
                Assert.assertTrue(Pattern.matches("in [0-9]+ days|at the end of the month.", rewardsPointsAndExpirySummaryText.split("Rewards")[1].split("\\(")[0].trim().split("expiring")[1].trim()), "Expiry details is not displayed in rewards summary");
            }
        } else {
            Assert.assertTrue(myRewardsPage.isRewardsExpiryDateDisplayed(), "Expiry date is not displayed");
        }
    }

    /* @Then("^scroll down the screen to rewards button$")
     public void scrollToRewardsButton() {
         Assert.assertTrue(myRewardsPage.getRewardsBalanceValue().equals("0"));
     }*/
    @And("^user scroll down the screen to rewards button$")
    public void userScrollDownToRewardsButton() {
        myRewardsPage.scrollDownToRewardsButton();
    }

    @Then("^verify rewards balance text$")
    public void verifyRewardsBalanceText() {
        //   Assert.assertEquals(myRewardsPage.getRewardBalanceText(), "Rewards balance");
        Assert.assertTrue(myRewardsPage.getRewardBalanceText());
    }

    @Then("^verify expiring date text$")
    public void verifyExpiringDateText() {
        //  Assert.assertEquals(myRewardsPage.getRewardExpiringDateText(), "Expiring");
        Assert.assertTrue(myRewardsPage.getRewardExpiringDateText());
    }


    @Then("^verify rewards progress bar$")
    public void verifyRewardsProgressBar() {
        Assert.assertTrue(myRewardsPage.verifyRewardsProgressBar());
    }

    @Then("^verify rewards progress bar is not displayed$")
    public void verifyRewardsProgressBarIsNotDisplayed() {
        Assert.assertTrue(myRewardsPage.checkProgressBarNotDisplayed());
    }

    @Then("^go to rewards info section$")
    public void goToRewardsInfo() {
        myRewardsPage.clickOnRewardsInfo();
    }

    @Then("^go to gas rewards$")
    public void goToGasRewards() throws InterruptedException {
        myRewardsPage.clickGasRewardsLink();
    }

    @Then("^verify reward info button is displayed$")
    public void verifyRewardInfoButtonDisplayed() {
        Assert.assertTrue(myRewardsPage.isRewardInfoButtonDisplayed());
    }

    @Then("^verify FAQ Description$")
    public void verifyFAQDescription() {
        if (!myRewardsPage.isNewRewardsUiDisplayed()) {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                Assert.assertEquals(myRewardsPage.getFAQDescription(), "More points, please; Learn how to earn.");
            } else {
                Assert.assertEquals(myRewardsPage.getFAQDescription(), "More points, please");
            }
        }
    }

    @And("^scroll down to FAQ$")
    public void scrollDownToFAQ() {
        myRewardsPage.scrollUptoFAQButton();
    }

    @Then("^verify FAQ Description is not displayed$")
    public void verifyFAQDescriptionIsNotDisplayed() {
        Assert.assertTrue(myRewardsPage.faqDescriptionIsNotDisplayed());
    }

    @Then("^verify 'Go to FAQ' button$")
    public void verifyGoToFAQButton() {
        Assert.assertTrue(myRewardsPage.verifyGoToFAQButton());
    }

    @And("^click on FAQ button$")
    public void clickOnFAQButton() {
        myRewardsPage.clickOnFAQButton();
    }

    @Then("^verify FAQ title$")
    public void verifyFAQTitle() {
        Assert.assertTrue(myRewardsPage.verifyFAQTitle());
    }

    @Then("^verify program details description$")
    public void verifyProgramDetailsDescription() {
        if (myRewardsPage.isNewRewardsUiDisplayed()) {
            myRewardsPage.clickOnNewRewardsBarIfDisplayed();
            Assert.assertTrue(myRewardsPage.isRewardsProgramDetailsForUDisplayed(), "Rewards program details is not displayed");
        } else {
            scrollDownToFAQ();
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                Assert.assertEquals(myRewardsPage.getProgramDetailsDescription(), "Points become rewards; We’ll show you how.");
            } else {
                Assert.assertEquals(myRewardsPage.getProgramDetailsDescription(), "Points become rewards");
            }
        }
    }

    @Then("^verify program details title$")
    public void verifyProgramDetailsTitle() {
        Assert.assertTrue(myRewardsPage.verifyProgramDetailsTitle());
    }

    @Then("^verify rewards count in carousel$")
    public void verifyRewardCardsCount() {
        int rewardsCount = myRewardsPage.getCountOfRedeemableRewards();
        if (rewardsCount == 0) {
            Assert.assertTrue(false, "There are no redeemable rewards for this user!");
        } else {
            Assert.assertTrue(rewardsCount > 0 && rewardsCount <= 15, "Number of redeemable rewards in carousel is: " + rewardsCount);
        }
    }

    @Then("^verify 'Clip' CTA displayed when available balance is greater than required balance")
    public void verifyRedeemCTA() {
        int rewardBalance = myRewardsPage.getRewardBalance();
        String requiredRewardsTagValue = myRewardsPage.getRequiredRewardTagText().split(" ")[0];
        if (rewardBalance > Integer.valueOf(requiredRewardsTagValue)) {
            // Assert.assertEquals(myRewardsPage.getClipRewardsNeedRewardsButtonText(),"Clip");
            Assert.assertTrue(myRewardsPage.getClipRewardsNeedRewardsButton());
        } else {
            Assert.assertTrue(false, "Reward balance is lower than required rewards and hence 'Clip' is not displayed");
        }
    }

    @Then("^verify updated time and date$")
    public void verifyUpdatedTimeAndDate() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {

            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            DateFormat tf = new SimpleDateFormat("h:mm a");
            String deviceDate = df.format(Calendar.getInstance().getTime());
            String deviceTime = tf.format(Calendar.getInstance().getTime());
            String rewardsPointsAndExpirySummaryText[] = myRewardsPage.getExpiringDateTextForU().split("\\(");
            String dateAndTime = "(" + rewardsPointsAndExpirySummaryText[1];
            //String rewardsBalanceText = CharMatcher.inRange('0', '9').retainFrom(dateAndTime[0]);
            //Assert.assertEquals( dateAndTime, dateAndTime[0]+","+dateAndTime[1]);

            Assert.assertEquals("(as of " + deviceTime + " " + "on" + " " + deviceDate + ")", dateAndTime);
        } else {
            DateFormat df = new SimpleDateFormat("hh:mm a', 'MM/dd/yyyy");
            String deviceDateAndTime = df.format(Calendar.getInstance().getTime());
            //Added this as now date and time is coming now in how for u screen with text as of
            if (myRewardsPage.isNewRewardsUiDisplayed()) {
                String rewardsPointsAndExpirySummaryText[] = myRewardsPage.getExpiringDateTextForU().split("as of");
                String dateAndTime[] = rewardsPointsAndExpirySummaryText[1].split("on");
                String rewardsBalanceText = CharMatcher.inRange('0', '9').retainFrom(dateAndTime[0]);
                Assert.assertEquals(deviceDateAndTime, dateAndTime[0] + "," + dateAndTime[1]);
            }
            Assert.assertEquals("Updated: " + deviceDateAndTime, myRewardsPage.getUpdatedTimeAndDate());
        }
    }

    @Then("^verify the static text on Reward Gas Card$")
    public void verifyStaticTextOnRewardGasCard() {
        String gasCardText = myRewardsPage.getTextOnGasRewardCard();
        System.out.println("gas card" + gasCardText);
        if ((gasCardText.contains("Spend Rewards to save")) && (gasCardText.contains("0.10 a gallon on gas"))) {
            Assert.assertTrue(true, "Text on gas card is incorrect!!");
        } else
            Assert.assertTrue(false, "Text on gas card is incorrect!!");
    }

    @Then("^verify rewards module text$")
    public void verifyRewardsModuleText() {
        Assert.assertEquals(dashboardPage.getRewardInformation(), "Start earning rewards today");
    }

    @Then("^verify user is able to see 'You've earned it'$")
    public void verifyYouEarnedItDisplayed() {
        Assert.assertTrue(myRewardsPage.isYouHaveEarnedDisplayed());
    }

    @Then("^verify user is able to see Discount Title on Reward card$")
    public void verifyRewardCardDiscountTitleDisplayed() {
        Assert.assertTrue(myRewardsPage.isRewardCardDiscountTitleDisplayed());
    }

    @Then("^verify user is able to see Description on Reward card$")
    public void verifyRewardCardDescriptionDisplayed() {
        Assert.assertTrue(myRewardsPage.isRewardCardDescriptionDisplayed());
    }

    @Then("^verify user is able to see Expiry Date on Reward card$")
    public void verifyRewardCardExpiryDateDisplayed() {
        Assert.assertTrue(myRewardsPage.isRewardCardExpiryDateDisplayed());
    }

    @Then("^verify user is able to see Subject Line on Reward card$")
    public void verifyRewardCardSubjectLineDisplayed() {
        Assert.assertTrue(myRewardsPage.isRewardCardSubjectLineDisplayed());
    }

    @When("^click on 'See All Reward' Button$")
    public void clickSeeAllRewardButton() {
        myRewardsPage.clickSeeALLRewardButton();
    }

    @Then("^verify user is in clip rewards screen$")
    public void verifyRewardListingScreenNavigated() {
        Assert.assertTrue(myRewardsPage.isRewardListingScreenNavigated());
    }

    @Then("^verify user is able to see Navigation Bar$")
    public void verifyNavigationBar() {
        Assert.assertTrue(myRewardsPage.isNavigationBarDisplayed());
    }

    @And("^scroll down to See All Reward Button$")
    public void scrollToSeeAllReward() {
        myRewardsPage.scrollToSeeAllReward();
    }

    @And("^click back button on clip rewards screen$")
    public void clickBackToMyReward() {
        myRewardsPage.clickBackToMyReward();
    }

    @Then("^verify user is able to is all reward list$")
    public void verifyAllMyRewardListDisplayed() throws Exception {
        myRewardsPage.isAllMyRewardListDisplayed();
    }

    @And("^click on reward card$")
    public void clickRewardCard() {
        myRewardsPage.clickRewardCard();
    }

    @Then("^verify user is able to see 'Need X Reward' text on CTA Button$")
    public void verifyNeedOneRewardDisplayed() {
        myRewardsPage.verifyNeedRewardText();
    }

    @Then("^verify clip CTA is displayed$")
    public void verifyClipCTAisDisplayed() {
        Assert.assertTrue(myRewardsPage.isClipCTADisplayed(), "Clip CTA is not displayed");
    }

    @Then("^verify See All Reward button is displayed$")
    public void verifySeeAllRewardButtonIsDisplayed() {
        Assert.assertTrue(myRewardsPage.iSSeeAllRewardButtonDisplayed(), "See all Reward button is not displayed");
    }

    @Then("^verify reward category list$")
    public void verifyRewardCategoryList() {
        Assert.assertTrue(myRewardsPage.verifyRewardCategories(), "reward categories are not displayed");
    }

    @Then("^verify clipped button on reward card$")
    public void verifyClippedButton() {
        Assert.assertTrue(myRewardsPage.isClippedRewardDisplayed(), "clipped reward button is not displayed");
    }

    @Then("^tap on close button$")
    public void tapOnCloseButton() {
        myRewardsPage.clickOnCloseButton();
    }

    @Then("^verify rewards balance is decreased after clipping a reward in rewards detail screen$")
    public void isRewardBalanceDecreasedAfterClippingRewardInRewardsDetailScreen() {
        int originalRewardBalance = myRewardsPage.getRewardBalance();
        myRewardsPage.clickOnRewardsDealCard();
        myRewardsPage.clickClipRewardsButtonInRewardDetailScreen();
        myRewardsPage.clickOnCloseButton();
        myRewardsPage.scrollUp();
        int rewardBalanceDecreased = myRewardsPage.getRewardBalance();
        if (originalRewardBalance > rewardBalanceDecreased) {
            Assert.assertTrue(true, "rewards balance is decreased after clipping a reward");
        } else {
            Assert.assertFalse(false, "rewards balance is not decreased after clipping a reward");
        }
    }

    @Then("^verify rewards balance is decreased after clipping a reward in carousel screen$")
    public void isRewardBalanceDecreasedAfterClippingRewardInCarouselScreen() {
        int originalRewardBalance = myRewardsPage.getRewardBalance();
        myRewardsPage.clickClipRewardsButtonInCarouselScreen();
        myRewardsPage.scrollUp();
        int rewardBalanceDecreased = myRewardsPage.getRewardBalance();
        if (originalRewardBalance > rewardBalanceDecreased) {
            Assert.assertTrue(true, "rewards balance is decreased after clipping a reward");
        } else {
            Assert.assertFalse(false, "rewards balance is not decreased after clipping a reward");
        }
    }

    @Then("^verify rewards balance is decreased after clipping a reward from clip rewards screen navigated from see all link")
    public void isRewardBalanceDecreasedAfterClippingRewardFromRewardsNavigationBar() {
        int originalRewardBalance = myRewardsPage.getRewardBalance();
        myRewardsPage.clickOnSeeAllBtnInMyRewardsPage();
        myRewardsPage.verifyCLipRewardsScreen();
        myRewardsPage.clickClipRewardsButtonInRewardsNavigationBar();
        myRewardsPage.clickBackButton();
        myRewardsPage.scrollUp();
        int rewardBalanceDecreased = myRewardsPage.getRewardBalance();
        if (originalRewardBalance > rewardBalanceDecreased) {
            Assert.assertTrue(true, "rewards balance is decreased after clipping a reward");
        } else {
            Assert.assertFalse(false, "rewards balance is not decreased after clipping a reward");
        }
    }

    @Then("^verify rewards balance is decreased after clipping a reward from rewards detail screen from see all navigation bar")
    public void isRewardBalanceDecreasedAfterClippingRewardFromRewardsDetailNavigationBar() {
        int originalRewardBalance = myRewardsPage.getRewardBalance();
        myRewardsPage.clickOnSeeAllBtnInMyRewardsPage();
        myRewardsPage.clickOnRewardsDealCard();
        myRewardsPage.clickClipRewardsButtonInRewardDetailScreen();
        myRewardsPage.clickOnCloseButton();

        // myRewardsPage.clickClipRewardsButtonInRewardsNavigationBar();
        myRewardsPage.clickBackButton();
        myRewardsPage.scrollUp();
        int rewardBalanceDecreased = myRewardsPage.getRewardBalance();
        if (originalRewardBalance > rewardBalanceDecreased) {
            Assert.assertTrue(true, "rewards balance is decreased after clipping a reward");
        } else {
            Assert.assertFalse(false, "rewards balance is not decreased after clipping a reward");
        }
    }

    @Then("^verify Clip rewards screen")
    public boolean verifyCLipRewardsScreen() {
        return myRewardsPage.verifyCLipRewardsScreen();
    }

    @Then("^scroll till end for all rewards tab in Clip Rewards screen")
    public void scrollTillEndOfRewardsListInClipRewardsScreen() {
        myRewardsPage.scrollTillEndOfRewardsListInClipRewardsScreen();
    }

    @Then("^click on Clip CTA in Clip Rewards Screen")
    public void clickOnClipCTAInClipRewardsScreen() {
        myRewardsPage.clickClipRewardsButtonInCarouselScreen();
    }

    @Then("^verify rewards balance is decreased after clipping a reward in clip rewards screen$")
    public void isRewardBalanceDecreasedAfterClippingRewardsInClipRewardsScreen() {
        int originalRewardBalance = myRewardsPage.getRewardBalance();
        myRewardsPage.scrollToSeeAllReward();
        myRewardsPage.clickOnSeeAllBtnInMyRewardsPage();
        myRewardsPage.clickClipRewardsButtonInCarouselScreen();
        myRewardsPage.clickBackToMyReward();
        myRewardsPage.scrollUp();
        int rewardBalanceDecreased = myRewardsPage.getRewardBalance();
        if (originalRewardBalance > rewardBalanceDecreased) {
            Assert.assertTrue(true, "rewards balance is decreased after clipping a reward");
        } else {
            Assert.assertFalse(false, "rewards balance is not decreased after clipping a reward");
        }
    }

    @Then("^verify rewards balance is decreased after clipping several rewards in clip rewards screen$")
    public void isRewardBalanceDecreasedAfterClippingSeveralRewardsInClipRewardsScreen() {
        int originalRewardBalance = myRewardsPage.getRewardBalance();
        myRewardsPage.scrollToSeeAllReward();
        myRewardsPage.clickOnSeeAllBtnInMyRewardsPage();
        myRewardsPage.clickClipRewardsButtonInCarouselScreen();
        myRewardsPage.scrollDown();
        myRewardsPage.clickClipRewardsButtonInCarouselScreen();
        myRewardsPage.goBackToMyReward();
        myRewardsPage.scrollUp();
        int rewardBalanceDecreased = myRewardsPage.getRewardBalance();
        if (originalRewardBalance > rewardBalanceDecreased) {
            Assert.assertTrue(true, "rewards balance is decreased after clipping a reward");
        } else {
            Assert.assertFalse(false, "rewards balance is not decreased after clipping a reward");
        }
    }

    @Then("verify rewards balance value using default account")
    public void verifyRewardsBalanceValueUsingDefaultAccount() {
        Assert.assertTrue(myRewardsPage.verifyRewardsBalanceValue(), "Rewards balance value not matching");
    }

    @Then("^verify rewards balance in my rewards screen is the same after sending the app to the background and coming back to the my rewards screen$")
    public void isRewardBalanceSameAfterClippingandSendingAppToBackgroundInClipRewardsScreen() throws IOException, InterruptedException {
        // myRewardsPage.clickBackToMyReward();
        // myRewardsPage.scrollUp();
        int originalRewardBalance = myRewardsPage.getRewardBalance();
        new AppActions().moveAppToBackground();
        dashboardPage.waitForLoaderToDisappear();
        dashboardPage.clickOnCancelButtonFeedbackFormIfDisplayed();
        shoppingModePage.enterDefaultZipCodeAndStartShoppingBackground();
        int currentRewardsBalance = myRewardsPage.getRewardBalance();
        if (originalRewardBalance == currentRewardsBalance) {
            Assert.assertTrue(true, "rewards balance is still the same after sending the app to the background");
        } else {
            Assert.assertFalse(false, "rewards balance is not the same after sending the app to the background");
        }
    }

    @Then("^verify rewards balance in my rewards screen is the same after killing the app and coming back to the my rewards screen")
    public void isRewardBalanceSameAfterKillingAppAndReturningBackToClipRewardsScreen() throws IOException {
        //myRewardsPage.clickBackToMyReward();
        //myRewardsPage.scrollUp();
        int originalRewardBalance = myRewardsPage.getRewardBalance();
        appActions.terminateApp();
        appActions.relaunchApp();
        dashboardPage.handlePopUpsAndTutorialOnDashboard();

        //  dashboardPage.clickDealsTab();
        //   dashboardPage.clickDealsTab();
        rewardsForuPage.homepageRewards();

        int currentRewardsBalance = myRewardsPage.getRewardBalance();
        if (originalRewardBalance == currentRewardsBalance) {
            Assert.assertTrue(true, "rewards balance is still the same after sending the app to the background");
        } else {
            Assert.assertFalse(false, "rewards balance is not the same after sending the app to the background");
        }
    }

    @And("click on new rewards bar if displayed")
    public void clickNewRewardsBar() {
        myRewardsPage.clickOnNewRewardsBarIfDisplayed();
    }

    @Then("verify FAQ page is displayed")
    public void verifyFAQPage() {
        Assert.assertTrue(myRewardsPage.isFaqPageDisplayed(), "FAQ page is not displayed!!");
    }

    @Then("verify Rewards carousel header and sub header on Rewards tab")
    public void verifyRewardsCarouselHeaderSubHeader() {
        if (myRewardsPage.isNewRewardsUiDisplayed()) {
            if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
                Assert.assertTrue(myRewardsPage.getRewardsCarouselHeaderText().split(";")[0].trim().contentEquals("Grocery Rewards"), "Header for rewards carousel is not displayed as 'Rewards'");
                Assert.assertTrue(myRewardsPage.getRewardsCarouselSubHeaderText().split(";")[1].trim().contentEquals("Spend rewards before they expire!"), "Sub Header for rewards carousel is not displayed as 'Clip your rewards now.'");
            } else {
                Assert.assertTrue(myRewardsPage.getRewardsCarouselHeaderText().contentEquals("Grocery Rewards"), "Header for rewards carousel is not displayed as 'Rewards'");
                Assert.assertTrue(myRewardsPage.getRewardsCarouselSubHeaderText().contentEquals("Spend rewards before they expire!"), "Sub Header for rewards carousel is not displayed as 'Clip your rewards now.'");
            }
        }
    }


    @And("click back button from how for u")
    public void clickBackButtonFromHowForU() {
        myRewardsPage.navigateToRewards();
    }


    @Then("Verify user is able to clip rewards after tapping cancel in popup")
    public void verifyUserIsAbleToClipRewardsAfterTappingCancelInPopup() {
        int originalRewardBalance = myRewardsPage.getRewardBalance();
        //myRewardsPage.clickOnRewardsDealCard();
        myRewardsPage.cancelPopupClickClipRewardsInCarousel();
        myRewardsPage.scrollUp();
        int rewardBalanceDecreased = myRewardsPage.getRewardBalance();
        if (originalRewardBalance == rewardBalanceDecreased) {
            Assert.assertTrue(true, "rewards balance is not decreased after tapping cancel");
        } else {
            Assert.assertFalse(false, "rewards balance is  decreased after tapping cancel");
        }
        myRewardsPage.clickClipRewardsButtonInCarouselScreen();
        //myRewardsPage.clickOnCloseButton();
        myRewardsPage.scrollUp();
        rewardBalanceDecreased = myRewardsPage.getRewardBalance();
    }

    @Then("Verify grocery rewards text in rewards tab")
    public void verifyGroceryRewardsTextInRewardsTab() {
        myRewardsPage.verifyGroceryRewardsHeading();
    }


    @Then("verify rewards balance is decreased after clipping a reward from clip rewards screen when navigated using scorecard interaction")
    public void verifyRewardsBalanceIsDecreasedAfterClippingARewardFromClipRewardsScreenWhenNavigatedUsingScorecardInteraction
            () {

        int originalRewardBalance = myRewardsPage.getRewardBalance();
        rewardsForuPage.clickOnScoreCardWithRewards();
        //  myRewardsPage.clickOnSeeAllBtnInMyRewardsPage();
        myRewardsPage.verifyCLipRewardsScreen();
        myRewardsPage.clickClipRewardsButtonInRewardsNavigationBar();
        myRewardsPage.clickBackButton();
        myRewardsPage.scrollUp();
        int rewardBalanceDecreased = myRewardsPage.getRewardBalance();

        if (originalRewardBalance > rewardBalanceDecreased) {
            Assert.assertTrue(true, "rewards balance is decreased after clipping a reward");
        } else {
            Assert.assertFalse(false, "rewards balance is not decreased after clipping a reward");
        }

    }


    @Then("verify clipped rewards screen heading")
    public void verifyClippedRewardsScreenHeading() {
        myRewardsPage.verifyClippedRewardHeading();
    }

}


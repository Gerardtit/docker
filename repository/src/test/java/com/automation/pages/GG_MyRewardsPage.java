package com.automation.pages;


import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.TapAction;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_MyRewardsPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.messages.internal.com.google.common.base.CharMatcher;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class GG_MyRewardsPage extends BasePage {
    private final GG_MyRewardsPageElements myRewardsPageElements = new GG_MyRewardsPageElements();

    public GG_MyRewardsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), myRewardsPageElements);
    }

    public void clickRewardLink() {
        if (isElementDisplayed(myRewardsPageElements.rewardLink, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.rewardLink);
        } else {
            new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.myRewardsLink);
        }
        waitForLoaderToDisappear();
        if (isElementDisplayed(myRewardsPageElements.dismissCTA, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.dismissCTA);
        }
    }


    public void scrollDownToRewardsButton() {
        // scrollDownForElement(pageElements.estimateTotalText);
        scrollDownForElement(myRewardsPageElements.rewardsButton);
    }

    public boolean verifyStartEarningTodayRewardLink() {
        return isElementDisplayed(myRewardsPageElements.rewardLink);

    }


    public boolean verifyRewardsPageTitle() {
        scrollUpForElement(myRewardsPageElements.rewardTitle);
        return isNewRewardsUiDisplayed() || isElementDisplayed(myRewardsPageElements.rewardTitle, 5);

    }


    public String getRewardsBalanceText() {
        if (isElementDisplayed(myRewardsPageElements.rewardBalance, 2)) {
            return myRewardsPageElements.rewardBalance.getText();
        } else {
            return driver.getPlatformName().equalsIgnoreCase("IOS") ? myRewardsPageElements.rewardsBar.getText() : myRewardsPageElements.rewardsBar.getAttribute("content-desc");
        }
    }

    public void clickBackButton() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            driver.navigate().back();
        } else {
            new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.backButton);
        }
    }

    public void navigateToRewards() {

        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            driver.navigate().back();
        } else {
            new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.back);
        }
    }

    public boolean verifyRewardsBalanceZero() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            return myRewardsPageElements.rewardBalanceZero.getAttribute("label").equals("Rewards balance 0 points");
        } else {
            return myRewardsPageElements.rewardBalanceZero.getAttribute("text").equals("0");
        }
    }

    public String getExpiringDateTextForU() {
        scrollUp();
        clickOnNewRewardsBarIfDisplayed();
        String rewardsSummary = myRewardsPageElements.rewardPointsSummary.getText();
        driver.navigate().back();
        return rewardsSummary;
    }

    public boolean isRewardsExpiryDateDisplayed() {
        return isElementDisplayed(myRewardsPageElements.expiringDate);
    }


    public boolean getRewardBalanceText() {
        //  return myRewardsPageElements.rewardBalanceText.getText().substring(0,15);

        return myRewardsPageElements.rewardBalanceText.getText().contains("Rewards balance");
    }

    public String getExpiringDateText() {

        return myRewardsPageElements.ExpiringDateText.getText().substring(9, 17);

    }

    public boolean getRewardExpiringDateText() {

        return myRewardsPageElements.ExpiringDateText.getText().contains("Expiring");


    }

    public void clickGasRewardsLink() {
        scrollDownForElement(myRewardsPageElements.gasRewardsLink);
        new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.gasRewardsLink);
        waitForLoaderToDisappear();
    }


    public boolean verifyRewardsProgressBar() {
        return isElementDisplayed(myRewardsPageElements.rewardsProgressBar, 3) || isElementDisplayed(myRewardsPageElements.rewardsBar, 1);
    }

    public boolean checkProgressBarNotDisplayed() {
        return myRewardsPageElements.rewardsProgressBarList.size() == 0;
    }

    public void clickOnRewardsInfo() {
        if (isElementDisplayed(myRewardsPageElements.rewardInfo, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.rewardInfo);
            waitForLoaderToDisappear();
        }
    }


    public void clickOnGasRewardsLink() {
        scrollDownForElement(myRewardsPageElements.gasRewardsLink);
        new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.gasRewardsLink);

    }


    public boolean isGasRewardCardDisplayed() {
        scrollDownForElement(myRewardsPageElements.gasRewardsLink);
        return isElementDisplayed(myRewardsPageElements.gasRewardsLink);
    }


    public boolean isRewardInfoButtonDisplayed() {
        return !isElementDisplayed(myRewardsPageElements.rewardTitle) || isElementDisplayed(myRewardsPageElements.rewardInfo);
    }

    public void waitForLoaderToDisappear() {
        for (int i = 0; i < 60; i++) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 1);
                wait.until(ExpectedConditions.visibilityOf(myRewardsPageElements.loadingSpinner));
                if (driver.getPlatformName().equalsIgnoreCase("android")) {
                    if (!myRewardsPageElements.loadingSpinner.getText().isEmpty()) {
                        break;
                    }
                }
            } catch (TimeoutException | StaleElementReferenceException | NoSuchElementException e) {
                return;
            }
        }
    }

    public String getFAQDescription() {
        return myRewardsPageElements.faqDescription.getText();
    }

    public void scrollUptoFAQButton() {
        scrollDownForElement(myRewardsPageElements.faqButton);
    }

    public boolean faqDescriptionIsNotDisplayed() {
        return myRewardsPageElements.faqDescriptionList.size() == 0;
    }

    public boolean verifyGoToFAQButton() {
        return isElementDisplayed(myRewardsPageElements.faqButton);
    }

    public void clickOnFAQButton() {
        new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.faqButton);
    }

    public boolean verifyFAQTitle() {
        return isElementDisplayed(myRewardsPageElements.faqPageTitle);
    }

    public String getProgramDetailsDescription() {
        return myRewardsPageElements.programDetailsDescription.getText();
    }

    public boolean isProgramDetailsDescriptionDisplayed() {
        return isElementDisplayed(myRewardsPageElements.programDetailsDescription, 2);
    }

    public boolean verifyProgramDetailsTitle() {
        boolean isDisplayed = false;
        waitForLoaderToDisappear();
        if (isElementDisplayed(myRewardsPageElements.programDetailsForU, 3)) {
            isDisplayed = true;
            driver.navigate().back();
        } else if (isElementDisplayed(myRewardsPageElements.programDetailsPageTitle, 1)) {
            isDisplayed = true;
        }
        return isDisplayed;
    }

    public int getCountOfRedeemableRewards() {
        scrollDownForElement(myRewardsPageElements.rewardExpiryDate);
        int maxSwipesForCard = 8;
        if (myRewardsPageElements.rewardName.size() == 0) {
            return 0;
        }
        ArrayList<String> rewardNameList = new ArrayList<String>();
        ArrayList<String> rewardDescList = new ArrayList<String>();
        String currentRewardName1 = myRewardsPageElements.rewardName.get(0).getText();
        String currentRewardDescription1 = myRewardsPageElements.rewardDescription.get(0).getText();
        rewardNameList.add(currentRewardName1);
        rewardDescList.add(currentRewardDescription1);

        boolean moreRewardsLeftToSwipe = true;
        while (moreRewardsLeftToSwipe) {
            int counter = 0;
            while (counter < maxSwipesForCard) {
                slideTheRewardCardFromRightToLeft(myRewardsPageElements.rewardName.get(1));
                currentRewardName1 = myRewardsPageElements.rewardName.get(0).getText();
                currentRewardDescription1 = myRewardsPageElements.rewardDescription.get(0).getText();
                if (!rewardNameList.contains(currentRewardName1) && !rewardDescList.contains(currentRewardDescription1)) {
                    rewardNameList.add(currentRewardName1);
                    rewardDescList.add(currentRewardDescription1);
                    break;
                }

                counter++;
            }

            if (counter >= maxSwipesForCard) {
                for (int k = 1; k < myRewardsPageElements.rewardName.size(); k++) {
                    rewardNameList.add(myRewardsPageElements.rewardName.get(k).getText());
                    rewardDescList.add(myRewardsPageElements.rewardDescription.get(k).getText());
                }

                moreRewardsLeftToSwipe = false;
            }

        }

        return rewardNameList.size();
    }

    public void slideTheRewardCardFromRightToLeft(MobileElement ele) {
        Point pt = ele.getLocation();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            scroll(200, pt.getY(), 50, pt.getY());
        } else {
            scroll(pt.getX() + 100, pt.getY(), pt.getX() - 100, pt.getY());
        }
    }


    public boolean isRewardsCountOnRedeemableRewardCardSortedAscending() throws InterruptedException {
        Thread.sleep(1000);
        if (myRewardsPageElements.rewardDescription.size() == 0) {
            return false;
        }
        ArrayList<Integer> rewardCountList = new ArrayList<Integer>();
        ArrayList<String> rewardDescList = new ArrayList<String>();
        String currentRewardDescription = myRewardsPageElements.rewardDescription.get(0).getText();
        String currentRewardsCountOnRewardCard = myRewardsPageElements.rewardCountTag.get(0).getText();
        rewardDescList.add(currentRewardDescription);
        rewardCountList.add(Integer.valueOf(currentRewardsCountOnRewardCard.split(" ")[0]));

        boolean moreRewardsLeftToSwipe = true;
        while (moreRewardsLeftToSwipe) {
            int counter = 0;
            while (counter < 8) {
                slideTheRewardCardFromRightToLeft(myRewardsPageElements.rewardName.get(1));
                currentRewardDescription = myRewardsPageElements.rewardDescription.get(0).getText();
                currentRewardsCountOnRewardCard = myRewardsPageElements.rewardCountTag.get(0).getText();
                if (!rewardDescList.contains(currentRewardDescription)) {
                    rewardDescList.add(currentRewardDescription);
                    rewardCountList.add(Integer.valueOf(currentRewardsCountOnRewardCard.split(" ")[0]));
                    break;
                }

                counter++;
            }

            if (counter >= 8) {
                for (int k = 0; k < myRewardsPageElements.rewardCountTag.size(); k++) {
                    rewardDescList.add(myRewardsPageElements.rewardDescription.get(k).getText());
                    rewardCountList.add(Integer.valueOf(myRewardsPageElements.rewardCountTag.get(k).getText().split(" ")[0]));
                }

                moreRewardsLeftToSwipe = false;
            }

        }

        // verify that a maximum of 15 reward cards are displayed in carousel
        Assert.assertTrue(rewardCountList.size() > 0 && rewardCountList.size() <= 15);

        // Verify sorting
        boolean isSortedAscending = true;
        for (int i = 0; i < rewardCountList.size(); i++) {
            if (i == rewardCountList.size() - 1) {
                break;
            }
            if (rewardCountList.get(i) > rewardCountList.get(1 + i)) {
                isSortedAscending = false;
            }
        }

        return isSortedAscending;
    }

    public boolean isRewardsCarouselDisplayed() {
        scrollDownForElement(myRewardsPageElements.rewardExpiryDate);
        boolean carouselDisplayed = false;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (getCountOfRedeemableRewards() >= 1) {
                carouselDisplayed = true;
            }
        } else {
            if (isElementDisplayed(myRewardsPageElements.rewardCardCarousel)) {
                carouselDisplayed = true;
            }
        }
        return carouselDisplayed;
    }


    public int getRequiredRewardCountTagSize() {
        scrollDownForElement(myRewardsPageElements.firstRewardDescription);
        return myRewardsPageElements.rewardCountTag.size();
    }


    public String getRequiredRewardTagText() {
        scrollDownForElement(myRewardsPageElements.firstRewardDescription);
        return myRewardsPageElements.rewardCountTag.get(0).getText();
    }

    public boolean getClipRewardsNeedRewardsButton() {
        Boolean check = false;
        scrollDownForElement(myRewardsPageElements.clipRewardsNeedRewardsButton);

        if ((myRewardsPageElements.clipRewardsNeedRewardsButton).isDisplayed())
            check = true;
        return check;
    }

    public int getRewardBalance() {

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {

            String rewardsBalanceText = "";
            waitVar.until(ExpectedConditions.visibilityOf(myRewardsPageElements.rewardBalanceZero));

            String rewardsText[] = myRewardsPageElements.rewardBalanceZero.getAttribute("label").split("\\.");
            System.out.println("reward balance " + rewardsText[0]);
            if (rewardsText[0].equalsIgnoreCase("Shop to earn rewards"))
                rewardsBalanceText = "0";
            else {
                rewardsBalanceText = CharMatcher.inRange('0', '9').retainFrom(rewardsText[0]);
            }


            int rewardsBalanceValue = Integer.parseInt(rewardsBalanceText);
            return rewardsBalanceValue;
        } else {
            //This line is added since line no 386 throwing the exception as 0 rewards doesn't contains any number. It is a text shop to earn
            String rewardBalance = "";
            if (myRewardsPageElements.rewardBalance.getText().equalsIgnoreCase("Shop to earn rewards"))
                rewardBalance = "0";
            else
                rewardBalance = CharMatcher.inRange('0', '9').retainFrom(myRewardsPageElements.rewardBalance.getText());

            int rewardsBalanceValue = Integer.parseInt(rewardBalance);
            return rewardsBalanceValue;
        }
    }

    public String getUpdatedTimeAndDate() {
        return myRewardsPageElements.updatedTime.getText();
    }

    public String getTextOnGasRewardCard() {
        scrollDownForElement(myRewardsPageElements.gasRewardsLink);
        return myRewardsPageElements.gasRewardsLink.getText();
    }

    public boolean isYouHaveEarnedDisplayed() {
        return isElementDisplayed(myRewardsPageElements.youHaveEarned);
    }

    public boolean isRewardCardDiscountTitleDisplayed() {
        return scrollDownForElement(myRewardsPageElements.rewardCardDiscountTitle);
    }

    public boolean isRewardCardDescriptionDisplayed() {
        return scrollDownForElement(myRewardsPageElements.rewardCardDescription);
    }

    public boolean isRewardCardExpiryDateDisplayed() {
        return scrollDownForElement(myRewardsPageElements.rewardCardExpiryDate);
    }

    public boolean isRewardCardSubjectLineDisplayed() {
        return scrollDownForElement(myRewardsPageElements.rewardCardSubjectLine);

    }

    public void clickSeeALLRewardButton() {
        new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.seeAllRewardButton);
        waitForLoaderToDisappear();
    }

    public boolean isRewardListingScreenNavigated() {
        return isElementDisplayed(myRewardsPageElements.title);
    }

    public boolean isNavigationBarDisplayed() {
        return isElementDisplayed(myRewardsPageElements.navigationBar);

    }

    public void scrollToSeeAllReward() {
        scrollDownForElement(myRewardsPageElements.seeAllRewardButton);
    }

    public void clickBackToMyReward() {
       /* if (driver.getPlatformName().equalsIgnoreCase("android")) {
            driver.navigate().back();
        } else {

            new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.backToMyReward);
        }

       */
        new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.backToMyReward);
        //}

    }

    public void goBackToMyReward() {
        new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.backToMyReward);
        if (isElementDisplayed(myRewardsPageElements.rewardsButton))
            new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.rewardsButton);


    }

    public void isAllMyRewardListDisplayed() throws IndexOutOfBoundsException {
        swipeLeftOnElement(myRewardsPageElements.rewardList.get(0));
    }

    public void clickRewardCard() {
        scrollDownForElement(myRewardsPageElements.rewardCardDescription);
        new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.rewardCardDescription);
    }

    public void verifyNeedRewardText() {
        String btnText = "";
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            btnText = myRewardsPageElements.rewardCardClipButtonClipRewards.getAttribute("label");
        } else {
            btnText = myRewardsPageElements.clipNeedRewardsButtonRewardDetails.getText();
        }
        org.junit.Assert.assertTrue(btnText.contains("Needs ") && btnText.contains("Reward"));

    }

    public boolean isClipCTADisplayed() {
        boolean isDisplayed = false;
        scrollDownForElement(myRewardsPageElements.rewardCardClipButtonClipRewards);
        if (isElementDisplayed(myRewardsPageElements.rewardCardClipButtonClipRewards)) {
            new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.rewardCardDescription);
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                if (myRewardsPageElements.clipNeedRewardsButtonRewardDetails.getAttribute("label").contains("Clip")) {
                    isDisplayed = true;
                }
            } else {
                if (myRewardsPageElements.clipNeedRewardsButtonRewardDetails.getText().contains("Clip")) {
                    isDisplayed = true;
                }

            }
        }
        clickBackToMyReward();
        return isDisplayed;
    }


    public boolean isclipYourRewardSubTitleDisplayed() {
        boolean isclipYourRewardSubTitleDisplayed = false;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (myRewardsPageElements.clipYourRewardsSubTitle.getAttribute("label").contains("Clip your rewards now.")) {
                isclipYourRewardSubTitleDisplayed = true;
            }
        } else {
            if (isElementDisplayed(myRewardsPageElements.clipYourRewardsSubTitle)) {
                isclipYourRewardSubTitleDisplayed = true;
            }

        }
        return isclipYourRewardSubTitleDisplayed;
    }


    public void verifyStaticTextOnGasRewardCard() {
        scrollDownForElement(myRewardsPageElements.gasRewardsLink);
        Assert.assertTrue(myRewardsPageElements.gasRewardsLink.getText().equalsIgnoreCase("Use your Points to Save with Gas Rewards"));
    }

    public boolean iSSeeAllRewardButtonDisplayed() {
        return isElementDisplayed(myRewardsPageElements.seeAllRewardButton);

    }

    public boolean verifyRewardCategories() {
        boolean isRewardCategoriesListed = false;
        String categories = myRewardsPageElements.rewardCategory.getText();
        if (categories != null) {
            isRewardCategoriesListed = true;
        }
        return isRewardCategoriesListed;
    }


    public boolean isYouHaveXRewardsToClipDisplayed() {
        return myRewardsPageElements.rewardLink.getText().contains("You have") && myRewardsPageElements.rewardLink.getText().contains("reward(s) to clip");

    }

    public boolean verifyFourRewards() {
        return isElementDisplayed(myRewardsPageElements.fourRewardsCategory);
    }

    public boolean isClippedRewardDisplayed() {
        if (!scrollDownForElement(myRewardsPageElements.clippedBtn)) {
            new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.rewardCardClipButtonClipRewards);
        }
        return isElementDisplayed(myRewardsPageElements.clippedBtn);

    }

    public void clickOnCloseButton() {
        if (isElementDisplayed(myRewardsPageElements.drawerCloseButton))
            new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.drawerCloseButton);
    }


    public void clickClipRewardsButtonInCarouselScreen() {
        scrollDownForElement(myRewardsPageElements.clipRewardsNeedRewardsButton);

        new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.clipRewardsNeedRewardsButton);


        handelRewardsConfirmationPopUp();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Assert.assertTrue(myRewardsPageElements.clippedRwardsButton.getAttribute("label").contains("clipped"), "Reward was not clipped");
        } else {
            Assert.assertTrue(myRewardsPageElements.clippedRwardsButton.getAttribute("text").equalsIgnoreCase("CLIPPED"), "Reward was not clipped");
        }
    }

    public void cancelPopupClickClipRewardsInCarousel() {
        scrollDownForElement(myRewardsPageElements.clipRewardsNeedRewardsButton);
        new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.clipRewardsNeedRewardsButton);
        cancelRewardsConfirmationPopUp();

    }

    public void clickOnRewardsDealCard() {
        scrollDownForElement(myRewardsPageElements.rewardsImage);
        new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.rewardsImage);
    }

    public void clickClipRewardsButtonInRewardDetailScreen() {
        String iOSClippedText = "clipped";
        String androidClippedText = StringUtils.capitalize(iOSClippedText);

        new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.clipNeedRewardsButtonRewardDetails);


        handelRewardsConfirmationPopUp();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new WaitAction(driver).waitForTextPresentInElement(myRewardsPageElements.clippedBtnInMyRewardsDetailScreen, iOSClippedText);
            Assert.assertTrue(myRewardsPageElements.clippedBtnInMyRewardsDetailScreen.getAttribute("label").contains("clipped"));
        } else {
            new WaitAction(driver).waitForTextPresentInElement(myRewardsPageElements.clipNeedRewardsButtonRewardDetails, androidClippedText);
            Assert.assertTrue(myRewardsPageElements.clipNeedRewardsButtonRewardDetails.getAttribute("text").equalsIgnoreCase("Clipped"));
        }
    }

    // Rewards balance won't be change until clip the new deal. We haven't used the account (USERNAME_REWARDS_DEFAULT) for such actions so the rewards balance will be same.
    public boolean verifyRewardsBalanceValue() {
        String rewardBalance = myRewardsPageElements.rewardBalance.getText().replaceAll("[^0-9]", "");
        return rewardBalance.equalsIgnoreCase("500");
    }

    public void clickOnSeeAllBtnInMyRewardsPage() {
        scrollDownForElement(myRewardsPageElements.seeAllRewardButton);
        new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.seeAllRewardButton);
    }

    public void clickClipRewardsButtonInRewardsNavigationBar() {
        String iOSClippedText = "clipped";
        String androidClippedText = StringUtils.capitalize(iOSClippedText);

        new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.clipRewardsNeedRewardsButton);

        handelRewardsConfirmationPopUp();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new WaitAction(driver).waitForTextPresentInElement(myRewardsPageElements.clippedBtnInCarouselInMyRewardsScreen, iOSClippedText);
            Assert.assertTrue(myRewardsPageElements.clippedBtnInCarouselInMyRewardsScreen.getAttribute("label").contains("clipped"));
        } else {
            new WaitAction(driver).waitForTextPresentInElement(myRewardsPageElements.clippedRwardsButton, androidClippedText);
            Assert.assertTrue(myRewardsPageElements.clippedRwardsButton.getAttribute("text").equalsIgnoreCase("Clipped"));
        }
    }

    public boolean verifyCLipRewardsScreen() {
        waitVar.until(ExpectedConditions.visibilityOf(myRewardsPageElements.clipRewardsScreenTitle));
        return isElementDisplayed(myRewardsPageElements.clipRewardsScreenTitle);
    }

    public void scrollTillEndOfRewardsListInClipRewardsScreen() {
        int clipRewardList = myRewardsPageElements.rewardTypes.size();
        for (int i = 0; i < clipRewardList; i++) {
            MobileElement rewardCategory = myRewardsPageElements.rewardTypes.get(i);
            new CommonActions(driver).new ClickAction().clickElement(rewardCategory);
            myRewardsPageElements.firstRewardDescription.isDisplayed();
        }
    }


    public void handelRewardsConfirmationPopUp() {


        if (isElementDisplayed(myRewardsPageElements.rewardsPopUp))
            new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.rewardsPopUpContinue);

    }

    public void cancelRewardsConfirmationPopUp() {

        if (isElementDisplayed(myRewardsPageElements.rewardsPopUp))
            new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.rewardsPopUpCancel);


    }


    public void clickOnNewRewardsBarIfDisplayed() {
        if (isElementDisplayed(myRewardsPageElements.rewardsBar, 2)) {
            new TapAction(driver).tapCoordinate(myRewardsPageElements.rewardsBar.getCenter().getX(), myRewardsPageElements.rewardsBar.getCenter().getY());
            waitForLoaderToDisappear();
        }
    }

    public void closeDownloadDialog() {
        if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
            if (isElementDisplayed(myRewardsPageElements.closeButton, 2)) {
                myRewardsPageElements.closeButton.click();
            }
        }
    }

    public void closeCookieNotice() {
        if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
            if (isElementDisplayed(myRewardsPageElements.closeButton, 2)) {
                myRewardsPageElements.closeButton.click();
            }
        }
    }

    public boolean isFaqPageDisplayed() {
        boolean isDisplayed = isElementDisplayed(myRewardsPageElements.faqPage, 5) || isElementDisplayed(myRewardsPageElements.faqPageTitle, 1);
        if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
            if (isElementDisplayed(myRewardsPageElements.doneButton, 2)) {
                new CommonActions(driver).new ClickAction().clickElement(myRewardsPageElements.doneButton);
            }
        }
        return isDisplayed;
    }

    public boolean isRewardsProgramDetailsForUDisplayed() {
        boolean isDisplayed = isElementDisplayed(myRewardsPageElements.programDetailsForU, 3);
        driver.navigate().back();
        return isDisplayed;
    }

    public boolean isNewRewardsUiDisplayed() {
        return isElementDisplayed(myRewardsPageElements.rewardsBar, 5);
    }

    public String getRewardsCarouselHeaderText() {
        return myRewardsPageElements.rewardsForUCarouselHeader.getText();
    }

    public String getRewardsCarouselSubHeaderText() {
        return myRewardsPageElements.rewardsForUCarouselSubHeader.getText();
    }


    public void allRewardsGalleryHaloNav() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(isElementDisplayed(myRewardsPageElements.rewardsGalleryHeader, 8));
    }


    public void verifyGroceryRewardsHeading() {
        Assert.assertTrue(isElementDisplayed(myRewardsPageElements.rewardsGalleryHeader, 8));
    }

    public void verifyClippedRewardHeading() {

        String totalClipped = "";
        if (driver.getPlatformName().equalsIgnoreCase("ios"))
            totalClipped = myRewardsPageElements.totalClippedReward.getAttribute("label").trim();
        else
            totalClipped = myRewardsPageElements.totalClippedReward.getText().trim();

        System.out.println(totalClipped);
        Assert.assertTrue(isElementDisplayed(myRewardsPageElements.clippedRewardsScreenHeading), "clipped rewards screen is not displayed");
        Assert.assertTrue(Pattern.matches("Total clipped: [1-9][0-9]+ reward", totalClipped.split("reward")[0].trim() + " reward"), "clipped rewards count is not displayed");
    }
}

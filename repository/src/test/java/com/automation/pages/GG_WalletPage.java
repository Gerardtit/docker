package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_DashboardPageElements;
import com.automation.pageElements.GG_WalletPageElements;
import com.google.common.base.CharMatcher;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.*;
import java.util.regex.Pattern;

public class GG_WalletPage extends BasePage {
    public final String REGEX_CATEGORY_NAME_COUNT = ".*[1-9]+[0-9]*[\\s]deal";
    private final String MONOPOLY_KEYWORD = "MONOPOLY";
    public GG_DashboardPage dashboardPage = new GG_DashboardPage(driver);
    public GG_Deals_AllDealsPage dealsPage = new GG_Deals_AllDealsPage(driver);
    public GG_MyRewardsPage myRewardsPage = new GG_MyRewardsPage(driver);
    private final GG_WalletPageElements walletPageElements = new GG_WalletPageElements();
    private final GG_DashboardPageElements dashboardPageElements = new GG_DashboardPageElements();

    public GG_WalletPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), walletPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dashboardPageElements);
    }

    public void clickMemberTab() {
        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.memberTab);
        new WaitAction(driver).waitForLoaderToDisappear();
    }

    public void goToWalletTab() {
        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.memberTab);
        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.walletTab);
        new WaitAction(driver).waitForLoaderToDisappear();
        try {
            // Adding hard wait here since page takes couple of seconds to update
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scrollUp();
    }

    public void verifyWalletHeader() {
        if (isElementDisplayed(walletPageElements.dismissCTA, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(walletPageElements.dismissCTA);
            new WaitAction(driver).waitForLoaderToDisappear();
        }
        dashboardPage.clickOnCancelButtonFeedbackFormIfDisplayed();
        isElementDisplayed(walletPageElements.walletHeader, 2);
    }

    public void verifyWalletTittle() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new WaitAction(driver).waitForLoadingComplete();
            waitVar.until(ExpectedConditions.visibilityOf(walletPageElements.walletTittle));
        }
    }

    public void verifyviewProducts() {

        waitVar.until(ExpectedConditions.visibilityOf(walletPageElements.viewProducts));
    }


    public boolean verifySetupContactlessPayBannerIsNotDisplayed() {
        return walletPageElements.contactlessPaybanner.size() == 0;

    }


    public String getTitleOfLoyaltyCard() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            return walletPageElements.loyaltyCardTitle.getAttribute("label");
        } else {
            return walletPageElements.loyaltyCardTitle.getAttribute("content-desc");
        }
    }

    public boolean verifyQRCodeOfLoyaltyCard() {
        return isElementDisplayed(walletPageElements.loyaltyCardQRCode);
    }

    public void verifyLoyaltyCardInformationText() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Assert.assertTrue(walletPageElements.loyaltyCardInfoText.getAttribute("label").contains("Scan to get your savings applied."));
        } else {
            Assert.assertTrue(walletPageElements.loyaltyCardInfoText.getAttribute("text").equalsIgnoreCase("Scan to get your savings applied."));
        }
    }

    public boolean verifyViewProductsButtonInClippedDealsScreen() {
        return isElementDisplayed(walletPageElements.viewProductBtn);
    }

    public boolean verifySetupContactlessPayBanner() {
        return isElementDisplayed(walletPageElements.setupContactlessPayBannerWallet);
    }

    public void scrollDownContactlessPayWalletScreen() {
        scrollDownForElement(walletPageElements.setupContactlessPayBannerWallet);
        scrollDownBySmallAmount();
        scrollDownBySmallAmount();
    }

    public void clickOnSetupContactlessPayBanner() throws InterruptedException {
        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.setupContactlessPayBannerWallet);
        Thread.sleep(2000);
    }

    public boolean verifyClippedRewardsTitle() {
        return isElementDisplayed(walletPageElements.clippedRewardsTitle);
    }

    public void clickOnClippedRewardsTile() throws InterruptedException {
        new WebDriverWait(driver, 3);
        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.clippedRewardsTile);
        Thread.sleep(2000);
    }

    public boolean isClippedRewardsScreenIsDisplayed() {
        return isElementDisplayed(walletPageElements.clippedRewards);
    }


    public boolean verifyClippedButtonInClippedRewardsScreen() {
        scrollDownForElement(walletPageElements.clippedBtn);
        return isElementDisplayed(walletPageElements.clippedBtn);
    }

    public boolean verifyEnjoyByDateIsDisplayedInTheClippedCard() {
        return isElementDisplayed(walletPageElements.enjoyByDate);
    }

    public void clickBackToWallet() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            driver.navigate().back();
        } else {
            new CommonActions(driver).new ClickAction().clickElement(walletPageElements.backToWallet);
        }
    }

    public void clickOnClippedDealsTile() throws InterruptedException {

        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.clippedDealsTile);

        Thread.sleep(2000);
    }

    public boolean isClippedDealsScreenIsDisplayed() {
        return isElementDisplayed(walletPageElements.clippedDeals);
    }

    public boolean verifyClippedDealsTitle() {
        return isElementDisplayed(walletPageElements.clippedDealsTitle);
    }

    public int getClippedDealscount() {
        int dealCount;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            dealCount = Integer.parseInt(walletPageElements.clippedDealsCount.getText());
        } else {
            dealCount = Integer.parseInt(walletPageElements.clippedDealsCount.getText().split("Clipped deals")[0].trim());
        }
        return dealCount;
    }

    public boolean verifyEligibleProductsButtonInClippedDealsScreen() {
        return isElementDisplayed(walletPageElements.eligibleProductBtn);
    }

    public boolean verifyEligibleProductsText() {
        return isElementDisplayed(walletPageElements.eligibleProducttxt);
    }

    public boolean verifyCountOnClippedAndWalletScreenAreSame() {
        boolean isCountOnClippedAndWalletScreenAreSame = false;
        int countOnWalletScreen;
        int countOnClippedDealsScreen = 0;
        countOnWalletScreen = getCountOfClippedDeals();
        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.clippedDealsCount);
        //New Changes as now the navigation is to list
        new GG_MylistPage(driver).goToClippedDealsTab();
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                countOnClippedDealsScreen = Integer.parseInt(walletPageElements.countClippedDealsPage.getAttribute("text").split(" deal")[0].trim());
                break;
            case "IOS":
                countOnClippedDealsScreen = Integer.parseInt(walletPageElements.countClippedDealsPage.getText().split(" deals")[0].trim());
                break;
        }
        if (countOnWalletScreen == countOnClippedDealsScreen) {
            isCountOnClippedAndWalletScreenAreSame = true;
        }
        return isCountOnClippedAndWalletScreenAreSame;
    }

    public boolean verifyCountOnClippedAndWalletRewardScreenAreSame() {
        boolean isCountOnClippedAndWalletScreenAreSame = false;
        int countOnWalletScreen;
        int countOnClippedRewardsScreen;

        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            countOnWalletScreen = getCountOfClippedRewards();
            new CommonActions(driver).new ClickAction().clickElement(walletPageElements.clippedRewardsTile);
            countOnClippedRewardsScreen = Integer.parseInt(walletPageElements.countOfClippedRewards.getAttribute("text").split("Total clipped: ")[1].split(" reward\\(s\\)")[0]);

        } else {
            countOnWalletScreen = getCountOfClippedRewards();
            new CommonActions(driver).new ClickAction().clickElement(walletPageElements.clippedRewardsTile);
            countOnClippedRewardsScreen = Integer.parseInt(walletPageElements.countOfClippedRewards.getAttribute("label").split("Total clipped:")[1].split("reward\\(s\\)")[0].trim());
        }
        if (countOnWalletScreen == countOnClippedRewardsScreen) {
            isCountOnClippedAndWalletScreenAreSame = true;
        }
        return isCountOnClippedAndWalletScreenAreSame;
    }

    public int getCountOfClippedRewards() {
        int rewardsCnt = 0;
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String rewardsCountText = driver.getPlatformName().equalsIgnoreCase("IOS") ? walletPageElements.clippedRewardsCount.getAttribute("label") : walletPageElements.clippedRewardsCount.getText();
        if (!rewardsCountText.contains("See your rewards")) {
            rewardsCnt = Integer.parseInt(rewardsCountText.replaceAll("[^\\d]", ""));
        }
        return rewardsCnt;
    }

    public int getCountOfClippedDeals() {
        int dealsCnt = 0;
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String dealsCountText = driver.getPlatformName().equalsIgnoreCase("IOS") ? walletPageElements.clippedDealsCount.getAttribute("label") : walletPageElements.clippedDealsCount.getText();
        if (!dealsCountText.contains("See your clipped deals")) {
            dealsCnt = Integer.parseInt(dealsCountText.replaceAll("[^\\d]", ""));
        }
        return dealsCnt;
    }

    public boolean verifyTitleOfPayCard() {
        return isElementDisplayed(walletPageElements.payCardTitle);
    }

    public void clickOnEligibleProductButton() {
        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.eligibleProductBtn);
    }

    public void clickXButtonInContactLessBanner() {
        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.xButtonInSetUpContactLess);
        if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
            if (isElementDisplayed(walletPageElements.xButtonInSetUpContactLess, 2)) {

                new CommonActions(driver).new ClickAction().clickElement(walletPageElements.xButtonInSetUpContactLess);

            }
        }
    }

    public void handleContactLessPaySetUpTutorial() {
        for (int i = 0; i < 2; i++) {
            if (isElementDisplayed(walletPageElements.nextButtonSetUpContactlessPay, 2)) {
                new CommonActions(driver).new ClickAction().clickElement(walletPageElements.nextButtonSetUpContactlessPay);
            }
        }
        if (isElementDisplayed(walletPageElements.getStartedSetUpContactlessPay, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(walletPageElements.getStartedSetUpContactlessPay);
        }

        // Handle location permission pop up
        if (isElementDisplayed(walletPageElements.allowLocationWhileUsingApp, 5)) {
            new CommonActions(driver).new ClickAction().clickElement(walletPageElements.allowLocationWhileUsingApp);
        }
    }

    public void scrollDownWalletScreen() {
        scrollDown();
    }

    public boolean isClippedMonopolyDealCardDisplayed() {
        return isElementDisplayed(walletPageElements.monopolyDealCard);
    }


    public boolean isTermsAndConditionDisplayed() {
        return isElementDisplayed(walletPageElements.offerTermsAndConditionCTA);
    }

    public int getItemsCountFromCart() {
        int itemsCount;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            itemsCount = Integer.parseInt(walletPageElements.myCartCount.getAttribute("text").trim());
        } else {
            itemsCount = Integer.parseInt(walletPageElements.myCartCount.getText().split(" item")[0].trim());
        }
        return itemsCount;
    }

    public Set<String> getTheCategoriesOfClippedDeals() {
        Set<String> dealCategories = new LinkedHashSet<String>();
        for (int cntVal = 0; cntVal < 3; cntVal++) {
            //Fetching category text also gets count of deals info formatting with split
            switch (driver.getPlatformName().toUpperCase()) {
                case "IOS":
                    walletPageElements.clippedDealsCategories.forEach(indCategoryName -> dealCategories.add(getText(indCategoryName).split("[0-9]")[0].trim()));
                    break;
                case "ANDROID":
                    walletPageElements.clippedDealsCategories.forEach(indCategoryName -> dealCategories.add(getText(indCategoryName)));
                    break;
            }
            scrollDown();
            // Scroll till all categories are fetched
        }
        return dealCategories;
    }

    public void expandDesiredCategoryInClippedDeals(String categoryName) {
        MobileElement desiredElement;
        elementfound:
        for (int cntVal = 0; cntVal < 5; cntVal++) {
            //Fetching category text also gets deals info formatting with split
            for (MobileElement indCategory : walletPageElements.clippedDealsCategories) {
                switch (driver.getPlatformName().toUpperCase()) {
                    case "IOS":
                        if (getText(indCategory).split("[0-9]")[0].trim().contains(categoryName)) {
                            new CommonActions(driver).new ClickAction().clickElement(indCategory);
                            break elementfound;
                        }
                        break;
                    case "ANDROID":
                        if (getText(indCategory).trim().contains(categoryName)) {
                            new CommonActions(driver).new ClickAction().clickElement(indCategory);
                            break elementfound;
                        }
                        break;
                }
            }
            scrollDown();
        }
    }

    public List<String> getDealNamesDisplayedInClippedDeals() {
        List<String> labelNames = new ArrayList<String>();
        for (int cntVal = 0; cntVal < 5; cntVal++) {
            swipeLeftOnElement(walletPageElements.clippedDealsNameLabelCard.get(0));
            labelNames.add(getText(walletPageElements.clippedDealsNameLabelCard.get(0)));
        }
        return labelNames;
    }

    public void clickOnFirstDealsCardInExpandedView() {
        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.clippedDealsNameLabelCard.get(0));
    }

    public void clickFirstCategoryOnClippedDealsScreen() {
        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.clippedDealsCategories.get(0));
    }

    public boolean isCategoryExpandedOnClippedDealsScreen() {
        return isElementDisplayed(walletPageElements.clippedDealName, 5);
    }

    public boolean isClippedDealsCountDisplayedOnClippedDealsScreen() {
        // Checking if count is displayed by checking for text to contain 'deal'
        return walletPageElements.countClippedDealsPage.getText().contains("deal");
    }


    public boolean isCategoryNameAndCountDisplayedForCategoryOnClippedDealsScreen() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            String categoryNameCountText = walletPageElements.clippedDealsCategories.get(0).getText();
            return Pattern.matches(REGEX_CATEGORY_NAME_COUNT, categoryNameCountText);
        } else {
            return walletPageElements.clippedDealsCategoryName.size() > 0 && walletPageElements.clippedDealsCategoryCount.size() > 0;
        }
    }

    public boolean isDealTitleInClippedDealsSectionDisplayed() {
        return isElementDisplayed(walletPageElements.dealTitle);
    }

    public boolean isDealDescriptionInClippedDealsSectionDisplayed() {
        return isElementDisplayed(walletPageElements.dealDescription);
    }

    public boolean isDealExpiryDateInClippedDealSectionDisplayed() {
        return isElementDisplayed(walletPageElements.dealExpiry);
    }

    public boolean isStartEarningRewardsTodayDisplayed() {
        return isElementDisplayed(walletPageElements.zeroClippedRewards);
    }

    public boolean isSeeAllCTAIsDisplayedInDeals() {
        return isElementDisplayed(walletPageElements.seeAllCTADeals);
    }

    public void clickOnSeeAllButtonInDealsSection() {
        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.seeAllCTADeals);
    }

    public boolean isSeeAllCTAIsDisplayedInRewards() {
        return isElementDisplayed(walletPageElements.seeAllCTARewards);
    }

    public void clickOnSeeAllButtonInRewardsSection() {
        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.seeAllCTARewards);
    }

    public boolean isClippedZeroDealsTextIsDisplayed() {
        return isElementDisplayed(walletPageElements.zeroClippedDeals);
    }

    public String isStartEarningRewardsTodayTextIsDisplayed() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            return walletPageElements.zeroClippedRewards.getText();
        } else {
            return walletPageElements.zeroClippedRewards.getText();
        }

    }

    public void clickOnShowRewardsButton() {

        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.showRewardsButton);

    }

    public int getcountClippedRewards() {
        return Integer.valueOf(walletPageElements.clippedRewardsCount.getText());

    }


    public boolean isDealCardInClippedDealsCategoriesDetailPageDisplayed() {
        return isElementDisplayed(walletPageElements.dealCardInClippedDealsCategoriesDetailPage);
    }

    public boolean isDealCountInClippedDealsCategoriesDetailPageDisplayed() {
        return isElementDisplayed(walletPageElements.clippedDealsCountInClippedDealsCategoriesDetailPage);
    }

    public boolean isDealCategoryTitleInClippedDealsCategoriesDetailPageDisplayed() {
        return isElementDisplayed(walletPageElements.dealCategoryTitleInClippedDealsCategoriesDetailPage);
    }

    public void clickBackButtonOnClippedDealsCategoriesDetailPage() {
        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.backButtonOnClippedDealsCategoriesDetailPage);
    }

    public boolean verifyClippedDealsandClippedRewardsSectionAtTop() {
        int dealsTileLocation = walletPageElements.clippedDealsTile.getLocation().getY();
        int rewardsTileLocation = walletPageElements.clippedRewardsTile.getLocation().getY();
        int loyaltyCardLocation = walletPageElements.loyaltyCardTitle.getLocation().getY();
        int walletHeaderLocation = walletPageElements.walletHeader.getLocation().getY();

        return (dealsTileLocation > walletHeaderLocation) && (rewardsTileLocation < loyaltyCardLocation);
    }

    public boolean findMonopolyDealWithSpecifiedUse(String useAvailable) {
        int maxScrollDownsForDesiredDeal = 8;
        boolean isMonopolyDealFound = false;
        Set<String> dealNames = new TreeSet<>();
        scrollLoop:
        for (int i = 0; i < maxScrollDownsForDesiredDeal; i++) {
            for (MobileElement deal : walletPageElements.clippedDealNameList) {
                if (!dealNames.contains(deal.getText())) {
                    new CommonActions(driver).new ClickAction().clickElement(deal);
                    new WaitAction(driver).waitForDisplayed(walletPageElements.offerTermsAndConditionCTA, 2);
                    new CommonActions(driver).new ClickAction().clickElement(walletPageElements.offerTermsAndConditionCTA);
                    if (walletPageElements.offerTypeDetailsDisclaimer.getText().contains(useAvailable)) {
                        isMonopolyDealFound = true;
                        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.offerTermsAndConditionCTA);
                        break scrollLoop;
                    } else {
                        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.closeDealDetailsPage);
                    }
                }
            }
            scrollDown();
        }

        return isMonopolyDealFound;
    }

    public void seeInWallet() {
        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.seeInWalletBtn);
    }

    public void verifySeeInWallet() {
        new WaitAction(driver).waitForDisplayed(walletPageElements.seeInWalletBtn);
    }

    public void clickOnMyListIcon() {
        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.myListIcon);
    }

    public boolean isMyListPageIsDisplayed() {
        return isElementDisplayed(walletPageElements.myListPage);
    }

    public void closeDealDetails() {

        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.closeDealDetailsPage);

    }

    public boolean isMonopolyDealDisplayed() {
        int maxScrollDownsForDesiredDeal = 8;
        boolean isMonopolyDealFound = false;
        Set<String> dealNames = new TreeSet<>();
        scrollLoop:
        for (int i = 0; i < maxScrollDownsForDesiredDeal; i++) {
            for (MobileElement deal : walletPageElements.clippedDealNameList) {
                if (!dealNames.contains(deal.getText())) {
                    new CommonActions(driver).new ClickAction().clickElement(deal);
                    new WaitAction(driver).waitForDisplayed(walletPageElements.offerTermsAndConditionCTA, 2);
                    new CommonActions(driver).new ClickAction().clickElement(walletPageElements.offerTermsAndConditionCTA);
                    if (walletPageElements.offerTypeDetailsDisclaimer.getText().contains(MONOPOLY_KEYWORD)) {
                        isMonopolyDealFound = true;
                        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.offerTermsAndConditionCTA);
                        break scrollLoop;
                    } else {
                        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.closeDealDetailsPage);
                    }
                }
            }
            scrollDown();
        }

        return isMonopolyDealFound;
    }

    public void dismissWalletNotification() {
        if (isElementDisplayed(walletPageElements.dismissCTA, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(walletPageElements.dismissCTA);
            new WaitAction(driver).waitForLoaderToDisappear();
        }
    }

    public String isSeeYourRewardsAndPointsIsDisplayed() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            return walletPageElements.zeroClippedRewards.getText().split("; Show rewards")[0].trim();
        } else {
            return walletPageElements.zeroClippedRewards.getText();
        }
    }

    public String isSeeYourClippedDealsIsDisplayed() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            return walletPageElements.clippedDealsCount.getText().split("; See all")[0].trim();
        } else {
            return walletPageElements.clippedDealsCount.getText();
        }
    }

    public void clickOnExploreDealsButton() {
        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.exploreDealsbtn);
    }

    public String isBuyItAgainIsEmpty() {
        String contactLessTitleDescription = (walletPageElements.buyItAgainIsEmptyTxt).getText();
        return contactLessTitleDescription;
    }

    public boolean isExploreDealsButtonDisplayed() {
        new WaitAction(driver).waitForLoaderToDisappear();
        return isElementDisplayed(walletPageElements.exploreDealsbtn);
    }

    public int getDealsCountFromClippedDealsPage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
            // Do nothing
        }
        return Integer.valueOf(walletPageElements.countClippedDealsPage.getText().replaceAll("[^0-9]", ""));
    }

    public int getClippedRewardsValue() {


        int clippedRewardsValue = 0;
        try {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                String rewardsBalanceText = CharMatcher.inRange('0', '9').retainFrom(walletPageElements.clippedRewardsCount.getAttribute("label"));
                clippedRewardsValue = Integer.parseInt(rewardsBalanceText);
            } else {
                String rewardsBalanceText = CharMatcher.inRange('0', '9').retainFrom(walletPageElements.clippedRewardsCount.getAttribute("text"));
                clippedRewardsValue = Integer.parseInt(rewardsBalanceText);
            }
        } catch (NumberFormatException nfe) {
            clippedRewardsValue = 0;


        }
        return clippedRewardsValue;
    }

    public String getSetupContactlessPayTitleDescription() {
        String contactLessTitleDescription;
        if (driver.getPlatformName().equalsIgnoreCase("Android")) {
            contactLessTitleDescription = (walletPageElements.setupContactlessPayBannerWallet).getAttribute("content-desc");
        } else {
            contactLessTitleDescription = (walletPageElements.setupContactlessPayBannerWallet).getText();
        }
        return contactLessTitleDescription;
    }


    public boolean isUserOnWalletScreen() {
        return isElementDisplayed(walletPageElements.loyaltyCardQRCode);
    }

    public void clickSeeYourClippedDeals() {
    }

    public String getSetupContactlessPayTitleDescriptioninAccount() {
        String contactLessTitleDescription;
        if (driver.getPlatformName().equalsIgnoreCase("Android")) {
            contactLessTitleDescription = (walletPageElements.setupContactlessPayBannerAccount).getAttribute("content-desc");
        } else {
            contactLessTitleDescription = (walletPageElements.setupContactlessPayBannerAccount).getText();
        }
        return contactLessTitleDescription;
    }

    public void clickOnClippedDeal() {
        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.clippedDealsCategoryName.get(0));
    }

    public void clickOnOffersDetailsLink() throws InterruptedException {
        Thread.sleep(8000);
        new CommonActions(driver).new ClickAction().clickElement(walletPageElements.offerDetailsLabel);
    }


}






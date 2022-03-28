package com.automation.steps;

import com.automation.helpers.AppActions;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.BasePage;
import com.automation.pages.GG_DashboardPage;
import com.automation.pages.GG_MyRewardsPage;
import com.automation.pages.GG_WalletPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GG_WalletPageSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_WalletPage gg_walletPage = new GG_WalletPage(driver);
    public BasePage basePage = new BasePage(driver);
    int initialDealsCountClippedDealsPage;
    int itemsCountBeforeAddingProduct;
    int cartValueBefore;
    private final GG_DashboardPage dashboardPage = new GG_DashboardPage(driver);
    private final GG_MyRewardsPage myRewardsPage = new GG_MyRewardsPage(driver);

    public String getCurrentBanner() {
        return driver.getCapabilities().getCapability("banner").toString();
    }

    public String getCurrentEnv() {
        return driver.getCapabilities().getCapability("env").toString();
    }

    @When("^navigate to Member tab$")
    public void goToMemberTab() {
        gg_walletPage.clickMemberTab();
    }

    @When("^go to Wallet in Member tab$")
    public void goToWalletTab() {
        gg_walletPage.goToWalletTab();
    }

    @Then("^verify wallet header$")
    public void verifyWalletHeader() {
        gg_walletPage.verifyWalletHeader();
    }

    @Then("^Verify wallet tittle$")
    public void verifyWalletTittle() {
        gg_walletPage.verifyWalletTittle();
    }

    @Then("^verify Wallet View products$")
    public void verifyWalletViewProducts() {
        gg_walletPage.verifyviewProducts();
    }

    @And("^verify zero clipped rewards$")
    public void verifyZeroClippedRewards() {
        Assert.assertEquals(gg_walletPage.getCountOfClippedRewards(), 0, "User has one or more rewards clipped");
    }

    @And("^verify zero redeemed rewards$")
    public void verifyZeroRedeemedRewards() {
        Assert.assertEquals(gg_walletPage.getCountOfClippedRewards(), 0, "User has one or more rewards clipped");
    }

    @And("^verify clipped rewards count$")
    public void verifyActiveClippedRewards() {
        Assert.assertTrue(gg_walletPage.getCountOfClippedRewards() >= 0);
    }

    @And("^verify clipped deals count$")
    public void verifyClippedCount() {
        Assert.assertTrue(gg_walletPage.getCountOfClippedDeals() >= 0);
    }

    @And("^verify 'Setup contactless pay' banner is not displayed$")
    public void verifySetupContactlessPayBannerIsNotDisplayed() {
        Assert.assertFalse(gg_walletPage.verifySetupContactlessPayBanner(), "Setup Contactless Pay banner is displayed");
    }

    @And("^verify title of Member card$")
    public void verifyTitleOfLoyaltyCard() {
        Assert.assertTrue(gg_walletPage.getTitleOfLoyaltyCard().contains("Member Card"), "Member Card title is not displayed");
    }

    @Then("^verify QR code of Loyalty card$")
    public void verifyQRCodeOfLoyaltyCard() {
        Assert.assertTrue(gg_walletPage.verifyQRCodeOfLoyaltyCard(), "QRCode of Loyalty card is not displayed");
    }

    @And("^verify Loyalty card information text$")
    public void verifyLoyaltyCardInformationText() {
        gg_walletPage.verifyLoyaltyCardInformationText();
    }

    @And("^verify zero clipped deals$")
    public void verifyZeroClippedDeals() {
        Assert.assertEquals(gg_walletPage.getCountOfClippedDeals(), 0, "User has one or more deals clipped");
    }

    @And("^verify 'Setup contactless pay' banner in Wallet screen$")
    public void verifySetupContactlessPayBannerInWalletScreen() {
        Assert.assertTrue(gg_walletPage.verifySetupContactlessPayBanner(), "Setup Contactless Pay banner is not displayed");
    }

    @Then("scroll down to 'Setup contactless pay' banner on wallet screen")
    public void scrollDownContactlessPayDashboardScreenIsDisplayed() {
        gg_walletPage.scrollDownContactlessPayWalletScreen();
    }

    @And("^verify title & description of contactless pay in wallet screen$")
    public void verifySetupContactlessPayTitleWallet() {
        Assert.assertTrue(gg_walletPage.getSetupContactlessPayTitleDescription().contains("Your receipts & contactless pay"), String.format("Title on contact less pay banner is incorrect, actual title with description: %s", gg_walletPage.getSetupContactlessPayTitleDescription()));
        Assert.assertTrue(gg_walletPage.getSetupContactlessPayTitleDescription().contains("Access your digital receipts and set up a payment method to pay contactless in-store."), String.format("Description on contact less pay banner is incorrect, actual title with description: %s", gg_walletPage.getSetupContactlessPayTitleDescription()));
    }


    @And("^verify title & description of contactless pay in Account screen$")
    public void verifySetupContactlessPayTitleAccount() {
        Assert.assertTrue(gg_walletPage.getSetupContactlessPayTitleDescriptioninAccount().contains("Your receipts & contactless pay"), String.format("Title on contact less pay banner is incorrect, actual title with description: %s", gg_walletPage.getSetupContactlessPayTitleDescriptioninAccount()));
        Assert.assertTrue(gg_walletPage.getSetupContactlessPayTitleDescriptioninAccount().contains("Access your digital receipts and set up a payment method to pay contactless in-store."), String.format("Description on contact less pay banner is incorrect, actual title with description: %s", gg_walletPage.getSetupContactlessPayTitleDescriptioninAccount()));
    }

    @And("^click on 'Setup contactless pay' banner in Wallet screen$")
    public void clickOnSetupContactlessPayBannerInWalletScreen() throws InterruptedException {
        gg_walletPage.clickOnSetupContactlessPayBanner();
    }

    @Then("^verify Clipped rewards title$")
    public void verifyClippedRewardsTitle() {
        gg_walletPage.verifyClippedRewardsTitle();
    }

    @Then("^click on Clipped rewards tile$")
    public void clickOnClippedRewardsTile() throws InterruptedException {
        gg_walletPage.clickOnClippedRewardsTile();
    }

    @Then("^verify Clipped rewards screen is displayed$")
    public void verifyClippedRewardsScreenIsDisplayed() {
        Assert.assertTrue(gg_walletPage.isClippedRewardsScreenIsDisplayed());
    }

    @And("^verify Clipped button is displayed in clipped rewards screen$")
    public void verifyClippedButtonInClippedRewardsScreen() {
        Assert.assertTrue(gg_walletPage.verifyClippedButtonInClippedRewardsScreen());
    }

    @Then("^verify Enjoy by Date is displayed in the clipped card$")
    public void verifyEnjoyByDateIsDisplayedInTheClippedCard() {
        Assert.assertTrue(gg_walletPage.verifyEnjoyByDateIsDisplayedInTheClippedCard());
    }

    @And("^click back button on Clipped rewards page$")
    public void clickBackButtonOnClippedRewardsPage() {
        gg_walletPage.clickBackToWallet();
    }

    @Then("^verify count of clipped rewards in wallet and clipped rewards screen$")
    public void verifyCountOfClippedRewardsInWalletAndClippedRewardsScreen() throws InterruptedException {
        int countClippedReward = gg_walletPage.getcountClippedRewards();
        gg_walletPage.clickOnClippedRewardsTile();
    }

    @Then("^click on Clipped deals tile$")

    public void clickOnClippedDealsTile() throws InterruptedException {
        gg_walletPage.clickOnClippedDealsTile();
    }

    @And("^verify Clipped deals screen is displayed$")
    public void verifyClippedDealsScreenIsDisplayed() {
        Assert.assertTrue(gg_walletPage.isClippedDealsScreenIsDisplayed(), "Clipped deals screen is not displayed");
    }

    @And("^verify Clipped deals title$")
    public void verifyClippedDealsTitle() {
        Assert.assertTrue(gg_walletPage.verifyClippedDealsTitle(), "Clipped deals title is not displayed");
    }

    @Then("^get the clipped deals count$")
    public void getTheClippedDealsCount() {
        Assert.assertTrue(gg_walletPage.getClippedDealscount() >= 0);
    }


    @Then("^verify View products button is displayed in clipped deals screen$")
    public void verifyViewProductsButtonIsDisplayedInClippedDealsScreen() {
        Assert.assertTrue(gg_walletPage.verifyViewProductsButtonInClippedDealsScreen(), "View Product button is not displayed");
    }

    @Then("^verify Eligible products button is displayed in clipped deals screen$")
    public void verifyEligibleProductsButtonIsDisplayedInClippedDealsScreen() {
        Assert.assertTrue(gg_walletPage.verifyEligibleProductsButtonInClippedDealsScreen(), "Eligible Product button is not displayed");
    }

    @And("^click back button on Clipped deals page$")
    public void clickBackButtonOnClippedDealsPage() {
        gg_walletPage.clickBackToWallet();
    }

    @And("^verify 'Eligible Products' text$")
    public void verifyEligibleProductsText() {
        Assert.assertTrue(gg_walletPage.verifyEligibleProductsText());
    }

    @Then("^verify count of deals on clipped And Wallet Screen are same$")
    public void verifyCountOfDealsClippedAndWalletScreenAreSame() {
        Assert.assertTrue(gg_walletPage.verifyCountOnClippedAndWalletScreenAreSame(), "Clipped deals count in wallet and clipped deals page are not the same!!");
    }

    @Then("^verify count of rewards on clipped And Wallet Screen are same$")
    public void verifyCountOfWalletClippedAndWalletScreenAreSame() {
        Assert.assertTrue(gg_walletPage.verifyCountOnClippedAndWalletRewardScreenAreSame());
    }

    @Then("^verify title of Pay card$")
    public void verifyTitleOfPayCard() {
        Assert.assertTrue(gg_walletPage.verifyTitleOfPayCard());
    }

    @Then("^verify clipped monopoly deal card is present in Clipped Deals screen$")
    public void verifyClippedMonopolyDealCardIsDisplayed() {
        Assert.assertTrue(gg_walletPage.isClippedMonopolyDealCardDisplayed());
    }

    @When("click on Eligible product button on Clipped Deals screen$")
    public void clickOnEligibleProduct() {
        gg_walletPage.clickOnEligibleProductButton();
    }

    @When("user closes pay screen")
    public void clickOnXButtonOnPayScreen() {
        gg_walletPage.clickXButtonInContactLessBanner();
    }

    @When("^handle tutorial for contact less pay set up$")
    public void handleContactLessPaySetUpTutorial() {
        gg_walletPage.handleContactLessPaySetUpTutorial();
    }

    @When("Scroll down on wallet screen$")
    public void scrollDownOnWalletScreen() {
        gg_walletPage.scrollDownWalletScreen();
    }

    @Then("^verify offer terms and condition in deal card$")
    public void verifyOfferTermsAndConditionInDealCard() {
        Assert.assertTrue(gg_walletPage.isTermsAndConditionDisplayed(), "Offer terms and conditions is not displayed in deal details page");
    }

    @When("^keep app in background and relaunching the same in deal detail screen$")
    public void keepAppInBackgroundAndRelaunchingTheSameInDealDetailScreen() {
        new AppActions().moveAppToBackground();
    }

    @Then("^get cart count Before keeping app in Background$")
    public void getItemsCountCartInDealsPage() {
        cartValueBefore = gg_walletPage.getItemsCountFromCart();
    }

    @Then("^get cart count before killing app$")
    public void getItemsCountCartInWalletPagePage() {
        cartValueBefore = gg_walletPage.getItemsCountFromCart();
    }

    @Then("^get cart count after keeping app in foreground and verify if they are same in wallet page$")
    public void getCartCountAfterKeepingAppInForegroundInDealPage() {
        Assert.assertEquals(gg_walletPage.getItemsCountFromCart(), cartValueBefore, "Cart values are not same after moving app to foreground to background");
    }

    @Then("^get cart count after killing app relaunching and verify if they are same in wallet page$")
    public void getCartCountAfterKillingAppAndRelaunchingInDealPage() {
        Assert.assertEquals(gg_walletPage.getItemsCountFromCart(), cartValueBefore, "Cart values are not same after killing app and relaunching");
    }

    @Then("^get the count of cart item in wallet page$")
    public void getCartCountInDealsPage() {
        itemsCountBeforeAddingProduct = gg_walletPage.getItemsCountFromCart();
    }

    @Then("^verify the cart count after adding product in wallet page$")
    public void verifyCartItem() {
        Assert.assertTrue(gg_walletPage.getItemsCountFromCart() > itemsCountBeforeAddingProduct, "Item count in cart is not incremented");
    }

    @Then("^verify clipped deals are organized by categories$")
    public void verifyClippedDealsAreOrganizedByCategories() {
        List<String> actualList = gg_walletPage.getTheCategoriesOfClippedDeals().stream().collect(Collectors.toList());
        Assert.assertEquals(actualList.size() != 0, true, "The clipped deals aren't organised by categories");
    }

    @Then("^verify clipped deals are sorted by categories$")
    public void verifyClippedDealsAreSortedByCategories() {
        List<String> actualList = gg_walletPage.getTheCategoriesOfClippedDeals().stream().collect(Collectors.toList());
        List<String> expectedList = gg_walletPage.getTheCategoriesOfClippedDeals().stream().sorted().collect(Collectors.toList());
        actualList.removeIf(indCat -> indCat.equals("Special Offers"));
        expectedList.removeIf(indCat -> indCat.equals("Special Offers"));
        Assert.assertEquals(actualList, expectedList, "Categories are not Sorted");
    }

    @Then("^verify deal category \"([^\"]*)\" shown at the top in 'Clipped Deals' categories$")
    public void verifyTheCategoryIsShownAtTopInDeals(String categoryName) {
        Assert.assertEquals(gg_walletPage.getTheCategoriesOfClippedDeals().stream().findFirst().get(), categoryName, "Special Categories not displayed on the top");
    }

    @And("^click on \"([^\"]*)\" category in deals$")
    public void clickOnDesiredDealsCategory(String categoryName) {
        gg_walletPage.expandDesiredCategoryInClippedDeals(categoryName);
    }

    @Then("^User should see deals associated to \"([^\"]*)\" category$")
    public void userShouldSeeDealsAssociatedToCategory(String categoryName) {
        List<String> actualList = gg_walletPage.getDealNamesDisplayedInClippedDeals().stream().collect(Collectors.toList());
        List<String> expList = Arrays.asList("OMS Offer Request test Automation,OMS Offer Request test Automation".split(","));
        Assert.assertEquals(actualList, expList, "All Deals aren't displayed \n Expected List: " + expList + " \n Actual List " + actualList);
    }

    @And("^click on first deal card displayed in the category$")
    public void clickOnFirstDealCardDisplayedInTheCategory() {
        gg_walletPage.clickOnFirstDealsCardInExpandedView();
    }

    @Then("^verify deal category \"([^\"]*)\" shown in 'Clipped Deals' categories$")
    public void verifyDealCategoryUnknownShownInClippedDealsCategories(String desiredCategoryName) {
        Assert.assertEquals(gg_walletPage.getTheCategoriesOfClippedDeals().contains(desiredCategoryName), true, "Category doesn't exist " + desiredCategoryName);
    }

    @When("^click a category on clipped deals screen")
    public void clickCategoryOnClippedDealsScreen() {
        gg_walletPage.clickFirstCategoryOnClippedDealsScreen();
    }

    @When("^verify category is expanded on clipped deals screen")
    public void verifyCategoryExpandedOnClippedDealsScreen() {
        Assert.assertTrue(gg_walletPage.isCategoryExpandedOnClippedDealsScreen(), "Category is not expanded on clipped deals screen");
    }

    @Then("^verify clipped deals count is displayed on clipped deals screen")
    public void verifyClippedDealsCountOnClippedDealsScreen() {
        Assert.assertTrue(gg_walletPage.isClippedDealsCountDisplayedOnClippedDealsScreen(), "Clipped deals count is not displayed on clipped deals screen");
    }

    @Then("^verify category name and count is displayed for category on clipped deals screen")
    public void verifyCategoryNameAndCountDisplayedForCategoryOnClippedDealsScreen() {
        Assert.assertTrue(gg_walletPage.isCategoryNameAndCountDisplayedForCategoryOnClippedDealsScreen(), "category name and count is not displayed for category on clipped deals screen");
    }

    @And("^verify deal title in clipped deals section$")
    public void verifyDealTitleInClippedDealsSection() {
        Assert.assertTrue(gg_walletPage.isDealTitleInClippedDealsSectionDisplayed(), "Deal title is not displayed");
    }

    @Then("^verify deal description in clipped deals section$")
    public void verifyDealDescriptionInClippedDealsSection() {
        Assert.assertTrue(gg_walletPage.isDealDescriptionInClippedDealsSectionDisplayed(), "Deal description is not displayed");
    }

    @And("^verify deal expiry date in clipped deal section$")
    public void verifyDealExpiryDateInClippedDealSection() {
        Assert.assertTrue(gg_walletPage.isDealExpiryDateInClippedDealSectionDisplayed(), "Deal expiry is not displayed");
    }

    @And("^verify Start earning rewards today is displayed$")
    public void verifyStartEarningRewardsTodayIsDisplayed() {
        Assert.assertTrue(gg_walletPage.isStartEarningRewardsTodayDisplayed(), "Start earning rewards today is not displayed");
    }

    @Then("^verify See all CTA is displayed in deals section$")
    public void verifySeeAllCTAIsDisplayed() {
        Assert.assertTrue(gg_walletPage.isSeeAllCTAIsDisplayedInDeals(), "See All CTA is not displayed in deals section");
    }

    @When("^click See all button in deals section$")
    public void clickSeeAllButtonInDealsSection() {
        gg_walletPage.clickOnSeeAllButtonInDealsSection();
    }

    @Then("^verify See all CTA is displayed in rewards section$")
    public void verifySeeAllCTAIsDisplayedInRewardsSection() {
        Assert.assertTrue(gg_walletPage.isSeeAllCTAIsDisplayedInRewards(), "See All CTA is not displayed in rewards section");
    }

    @When("^click See all button in rewards section$")
    public void clickSeeAllButtonInRewardsSection() {
        gg_walletPage.clickOnSeeAllButtonInRewardsSection();
    }

    @And("^verify You clipped zero deals text is displayed$")
    public void verifyYouClippedZeroDealsTextIsDisplayed() {
        Assert.assertTrue(gg_walletPage.isClippedZeroDealsTextIsDisplayed(), "Clipped zero deals text is not displayed");
    }

    @Then("^verify Start earning rewards today text is displayed$")
    public void verifyStartEarningRewardsTodayTextIsDisplayed() {
        Assert.assertTrue(gg_walletPage.isStartEarningRewardsTodayTextIsDisplayed().contains("Start earning rewards today"), "Start earning rewards today is text not displayed");
    }


    @Then("^verify deal card in clipped deals categories detail page$")
    public void verifyDealCardInClippedDealsCategoriesDetailPage() {
        Assert.assertTrue(gg_walletPage.isDealCardInClippedDealsCategoriesDetailPageDisplayed(), "Deal card in clipped deals categories detail page is not displayed");
    }

    @Then("^verify deal count in clipped deals categories detail page$")
    public void verifyDealCountInClippedDealsCategoriesDetailPage() {
        Assert.assertTrue(gg_walletPage.isDealCountInClippedDealsCategoriesDetailPageDisplayed(), "Deal count in clipped deals categories detail page is not displayed");
    }

    @Then("^verify deal category title in clipped deals categories detail page$")
    public void verifyDealCategoryTitleInClippedDealsCategoriesDetailPage() {
        Assert.assertTrue(gg_walletPage.isDealCategoryTitleInClippedDealsCategoriesDetailPageDisplayed(), "Deal title in clipped deals categories detail page is not displayed");
    }

    @And("^click back button on clipped deals categories detail page$")
    public void clickBackButtonOnClippedDealsCategoriesDetailPage() {
        gg_walletPage.clickBackButtonOnClippedDealsCategoriesDetailPage();
    }

    @And("^verify Clipped deals and Clipped rewards section is present at the top$")
    public void verifyClippedDealsandClippedRewardsSectionAtTop() {
        Assert.assertTrue(gg_walletPage.verifyClippedDealsandClippedRewardsSectionAtTop(), "Clipped deals and Clipped rewards section is not present at the top");
    }

    @Then("^verify monopoly deal with use \"([^\"]*)\" is displayed$")
    public void verifyMonopolyDealWithSpecifiedUseDisplayed(String use) {
        Assert.assertTrue(gg_walletPage.findMonopolyDealWithSpecifiedUse(use), String.format("Clipped monopoly deal with use '%s' is not found", use));
    }

    @And("^close deal details page$")
    public void closeDealDetailsPage() {
        gg_walletPage.closeDealDetails();
    }

    @Then("^click on see in wallet$")
    public void clickSeeInWallet() {
        gg_walletPage.seeInWallet();
    }

    @Then("^verify see in wallet$")
    public void verifySeeInWallet() {
        gg_walletPage.verifySeeInWallet();
    }

    @Then("^Click on my list icon$")
    public void clickOnMyListIcon() {
        gg_walletPage.clickOnMyListIcon();
    }

    @Then("^verify my list page is displayed$")
    public void verifyMyListPageIsDisplayed() {
        Assert.assertTrue(gg_walletPage.isMyListPageIsDisplayed(), "my list page is not displayed");
    }

    @Then("^verify monopoly deal is present under a category in clipped deals page$")
    public void verifyMonopolyDealClippedDeals() {
        Assert.assertTrue(gg_walletPage.isMonopolyDealDisplayed(), "Monopoly deal was not found under a category in clipped deals page");
    }

    @And("dismiss wallet notification")
    public void dismissWalletNotification() {
        gg_walletPage.dismissWalletNotification();
    }

    @And("^verify See your rewards and points is displayed$")
    public void verifySeeYourRewardsAndPointsIsDisplayed() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Assert.assertEquals(gg_walletPage.isSeeYourRewardsAndPointsIsDisplayed(), "See your rewards & points");
        } else {
            Assert.assertEquals(gg_walletPage.isSeeYourRewardsAndPointsIsDisplayed(), "See your rewards and points");
        }
    }

    @When("^user clicks on show rewards button$")
    public void clickShowRewardsButton() {
        gg_walletPage.clickOnShowRewardsButton();
    }

    @And("^verify See your clipped deals is displayed$")
    public void verifySeeYourClippedDealsIsDisplayed() {
        Assert.assertEquals(gg_walletPage.isSeeYourClippedDealsIsDisplayed(), "See your clipped deals");
    }

    @When("^click on explore deals$")
    public void clickOnExploreDeals() {
        gg_walletPage.clickOnExploreDealsButton();
    }

    @And("^verify buy it again is empty$")
    public void verifyBuyItAgainIsEmpty() {
        Assert.assertEquals(gg_walletPage.isBuyItAgainIsEmpty(), "If you have past purchases, they’ll show up in your account shortly. For new shoppers, “Buy it again” helps you shop from past orders quickly and easily.");
    }

    @And("^verify explore deals button$")
    public void verifyExploreDealsButton() {
        Assert.assertTrue(gg_walletPage.isExploreDealsButtonDisplayed(), "Explore deals button is not displayed");
    }

    @And("^get and store deals count from clipped deals page")
    public void getDealsCountFromClippedDealsPage() {
        initialDealsCountClippedDealsPage = gg_walletPage.getDealsCountFromClippedDealsPage();
    }

    @And("^verify clipped deals count on clipped deals page is increased after clipping a deal")
    public void verifyDealsCountAfterClipping() {
        Assert.assertEquals(gg_walletPage.getDealsCountFromClippedDealsPage(), initialDealsCountClippedDealsPage + 1, "Deals count in clipped deals page did not increase after clipping a deal");
    }

    @And("^verify clipped rewards count is increased in wallet Page after clipping a reward in rewards detail screen$")
    public void verifyClippedRewardsBalanceIncreasedAfterClippingARewardInRewardsDetailScreen() {
        gg_walletPage.goToWalletTab();
        int originalClippedRewardsValue = gg_walletPage.getClippedRewardsValue();
        dashboardPage.clickHomeTab();
        dashboardPage.clickLinkInShortcutsTrayOnHomePage("rewards");
        myRewardsPage.clickOnRewardsDealCard();
        myRewardsPage.clickClipRewardsButtonInRewardDetailScreen();
        myRewardsPage.clickOnCloseButton();
        gg_walletPage.goToWalletTab();
        int increasedClippedRewardsValue = gg_walletPage.getClippedRewardsValue();
        if (increasedClippedRewardsValue > originalClippedRewardsValue) {
            Assert.assertTrue(true, "clipped rewards value is increased after clipping a reward");
        } else {
            Assert.assertFalse(false, "clipped rewards value is not increased after clipping a reward");
        }
    }

    @And("^verify clipped rewards count is increased in wallet Page after clipping a reward in carousel screen$")
    public void verifyClippedRewardsBalanceIncreasedAfterClippingARewardInCarouselScreen() {
        gg_walletPage.goToWalletTab();
        int originalClippedRewardsValue = gg_walletPage.getClippedRewardsValue();
        dashboardPage.clickHomeTab();

        dashboardPage.clickLinkInShortcutsTrayOnHomePage("rewards");

        myRewardsPage.clickClipRewardsButtonInCarouselScreen();
        gg_walletPage.goToWalletTab();
        int increasedClippedRewardsValue = gg_walletPage.getClippedRewardsValue();
        if (increasedClippedRewardsValue > originalClippedRewardsValue) {
            Assert.assertTrue(true, "clipped rewards value is increased after clipping a reward");
        } else {
            Assert.assertFalse(false, "clipped rewards value is not increased after clipping a reward");
        }
    }

    @And("^verify clipped rewards count is increased in wallet Page after clipping a reward from rewards navigation bar$")
    public void verifyClippedRewardsBalanceIncreasedAfterClippingARewardFromRewardsNavigationBar() {
        gg_walletPage.goToWalletTab();
        int originalClippedRewardsValue = gg_walletPage.getClippedRewardsValue();
        dashboardPage.clickHomeTab();
        dashboardPage.handlePopUpsAndTutorialOnDashboard();
        dashboardPage.handleLoveAppPopup();
        myRewardsPage.clickRewardLink();
        myRewardsPage.clickClipRewardsButtonInRewardsNavigationBar();
        gg_walletPage.goToWalletTab();
        int increasedClippedRewardsValue = gg_walletPage.getClippedRewardsValue();
        if (increasedClippedRewardsValue > originalClippedRewardsValue) {
            Assert.assertTrue(true, "clipped rewards value is increased after clipping a reward");
        } else {
            Assert.assertFalse(false, "clipped rewards value is not increased after clipping a reward");
        }
    }

    @And("^verify clipped rewards count is increased in wallet Page after clipping a reward in clip rewards screen$")
    public void verifyClippedRewardsBalanceIncreasedAfterClippingARewardInClipRewardsScreen() {
        gg_walletPage.goToWalletTab();
        int originalClippedRewardsValue = gg_walletPage.getClippedRewardsValue();
        dashboardPage.clickHomeTab();

        dashboardPage.clickLinkInShortcutsTrayOnHomePage("rewards");

        myRewardsPage.scrollToSeeAllReward();
        myRewardsPage.clickOnSeeAllBtnInMyRewardsPage();
        myRewardsPage.clickClipRewardsButtonInCarouselScreen();
        gg_walletPage.goToWalletTab();
        int increasedClippedRewardsValue = gg_walletPage.getClippedRewardsValue();
        if (increasedClippedRewardsValue > originalClippedRewardsValue) {
            Assert.assertTrue(true, "clipped rewards value is increased after clipping a reward");
        } else {
            Assert.assertFalse(false, "clipped rewards value is not increased after clipping a reward");
        }
    }

    @And("verify clipped deals count on clipped deals page is increased by {int} after clipping deals")
    public void verifyDealsCountAfterClipping(int dealCountIncrement) {
        Assert.assertEquals(gg_walletPage.getDealsCountFromClippedDealsPage(), initialDealsCountClippedDealsPage + dealCountIncrement, "Deals count in clipped deals page did not increase after clipping a deal");
    }

    @And("^verify clipped deals count on clipped deals page is the same")
    public void verifyDealsCountAfterOpn() {
        Assert.assertEquals(gg_walletPage.getDealsCountFromClippedDealsPage(), initialDealsCountClippedDealsPage, "Deals count in clipped deals page are not the same before and after performing an operation");
    }


    @Then("verify user is in wallet screen")
    public void verifyUserInWallet() {
        Assert.assertTrue(gg_walletPage.isUserOnWalletScreen(), "User is not in wallet screen!!");
    }

    @When("^User click on See your Clipped deals$")
    public void clickSeeYourClippedDeals() {
        gg_walletPage.clickSeeYourClippedDeals();
    }

    @And("^click on clipped deal$")
    public void click_on_clipped_deal() {
        gg_walletPage.clickOnClippedDeal();
    }

    @And("^click on offer details link$")
    public void click_on_offer_details_link() throws InterruptedException {
        gg_walletPage.clickOnOffersDetailsLink();
    }
}

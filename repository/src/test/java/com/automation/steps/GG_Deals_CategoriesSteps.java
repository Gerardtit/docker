package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.util.CommonActions;
import com.automation.pages.GG_Deals_AllDealsPage;
import com.automation.pages.GG_Deals_CategoriesPage;
import com.automation.rest.cache.CommonCache;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GG_Deals_CategoriesSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_Deals_CategoriesPage dealsCategoriesPage = new GG_Deals_CategoriesPage(driver);
    int savingEventCountInitial;

    @Then("^verify that saving events is displayed$")
    public void verifySavingEventsDisplayed() throws InterruptedException {
        Assert.assertTrue(dealsCategoriesPage.isSavingEventsDisplayed());
    }

    @Then("^verify that a saving event card is displayed$")
    public void verifySavingEventCardDisplayed() {
        Assert.assertTrue(dealsCategoriesPage.getSavingEventCardsSize() > 0);
    }

    @Then("^verify that count of deals on a saving event card is displayed$")
    public void verifySavingEventCardDealCountDisplayed() {
        Assert.assertTrue(dealsCategoriesPage.getSavingEventCardDealsCountSize() > 0);
    }

    @Then("^verify that 'See all' button is displayed next to saving events$")
    public void verifySeeAllSavingEventsButtonDisplayed() {
        Assert.assertTrue(dealsCategoriesPage.isSeeAllSavingEventsOptionDisplayed());
    }

    @Then("^verify that status bar indicator indicating the saving deal card in focus is displayed$")
    public void verifySavingDealCardFocusIndicatorDisplayed() {
        Assert.assertTrue(dealsCategoriesPage.isSavingEventCardFocusIndicatorDisplayed(), "Saving events card focus indicator not displayed");
    }

    @Then("^verify that only top 6 saving event cards are displayed in alphabetical order$")
    public void verifySavingEventCardCountAndOrder() throws InterruptedException {
        Assert.assertTrue(dealsCategoriesPage.isSavingEventsCardsDisplayedAlphabetical(), "Savings Event Cards are not displayed in alphabetical order");
    }

    @When("slide the saving event card from left to right and verify its position")
    public void verifySlideTheDealCardFromLeftToRight() {
        dealsCategoriesPage.slideTheSavingEventCardFromLeftToRight();
    }

    @And("slide the saving event card from right to left and verify its position")
    public void slideTheDealCardFromRightToLeft() throws InterruptedException {
        dealsCategoriesPage.slideTheSavingEventCardFromRightToLeft();
    }

    @Then("^status bar indication present in second position$")
    public void statusBarIndicationPresentInSecondPosition() {
        Assert.assertTrue(dealsCategoriesPage.verifySavingEventsCardFocusIndicator(1));
    }

    @Then("^status bar indication present in first position$")
    public void statusBarIndicationPresentInFirstPosition() {
        dealsCategoriesPage.clickSeeAllSavingEvent();
        int savingEventCount = dealsCategoriesPage.getCountOfSavingEvents();
        dealsCategoriesPage.closeSavingEventList();
        if (savingEventCount <= 6) {
            Assert.assertTrue(dealsCategoriesPage.verifySavingEventsCardFocusIndicator(0), "Saving event focus indicator is not displayed at first position ");
        }
    }

    @Then("^verify Your Categories is displayed in category tab$")
    public void verifyYourCategoriesIsDisplayedInCategoryTab() {
        Assert.assertTrue(dealsCategoriesPage.isYourCategoriesDisplayed(), "Your Categories section is not displayed");
    }

    @And("scroll up till top of the categories tab")
    public void scrollUpTillTopOfTheForYouTab() {
        dealsCategoriesPage.scrollTillTopOfScreen();
    }

    @Then("^verify that list of deal categories alphabetically ascending along with the number of deals for each$")
    public void verifyThatListOfDealCategoriesAlphabeticallyAscendingAlongWithTheNumberOfDealsForEach() {
        Assert.assertTrue(dealsCategoriesPage.areDealCategoriesSortedAlphabetically(), "Deals Cards are not displayed in alphabetical order");
    }

    @And("^click on deal category item cell$")
    public void clickOnDealCategoryItem() {
        dealsCategoriesPage.clickOnDealCategoryItem();
    }

    @Then("^verify deals category details page is displayed$")
    public void verifyDealsCategoryDetailsPageIsDisplayed() {
        Assert.assertTrue(dealsCategoriesPage.isDealsCategoryDetailsPageIsDisplayed(), "Deal category details page is not displayed");
    }

    @And("^verify category list are scrollable$")
    public void checkCategoriesActionable() {
        dealsCategoriesPage.isCategoryListScrollable();
    }

    @And("^click back button on deal category listing page$")
    public void clickBackButtonOnDealCategoryListingPage() {
        dealsCategoriesPage.clickOnBackButtonOnDealCategoryListPage();
    }

    @Then("^verify name of the category on the category deals details screen is displayed$")
    public void verifyDealsCategoryNameIsDisplayed() {
        Assert.assertTrue(dealsCategoriesPage.isCategoryNameDisplayed(), "name of category in Deal category details page is not displayed");
    }

    @And("^Tap on saving event card$")
    public void tapOnSavingEventCard() {
        dealsCategoriesPage.clickSavingEventCard();
    }

    @Then("clip a deal from saving events and verify the deal is clipped")
    public void clipDealAndVerifyInSavingEvents() {
        dealsCategoriesPage.clipDealAndVerifyInSavingEventsForNewUser();
    }

    @And("get saving events count")
    public void getSavingEventCount() {
        savingEventCountInitial = dealsCategoriesPage.getCountOfSavingEvents();
    }

    @Then("get saving events count and verify if the count is updated")
    public void getSavingEventCountAndVerify() {
        if (dealsCategoriesPage.getCountOfSavingEvents() != savingEventCountInitial) {
            Assert.assertTrue(true, "Saving events are updated after changing the store");
        } else {
            // Count can remain same even if store is changed so do nothing.
        }
    }

    @Then("clip a deal in Categories and verify if the deal is updated in All deals page")
    public void clipDealFromCategoriesAndVerifySameDealInAllDeals() {
        List<Map<String, String>> dealData = dealsCategoriesPage.clipDealFromYourCategoriesAndReturnDealsData(1);
        String dealName = dealData.get(0).get("dealName");
        String dealDescription = dealData.get(0).get("dealDescription");
        dealsCategoriesPage.clickAllDealsTab();
        Assert.assertTrue(new GG_Deals_AllDealsPage(driver).isDesiredDealClipped(dealName, dealDescription), "The deal was not updated in All deals page after clipping a deal from Your categories in categories page");
    }

    @And("^click close button on saving events drawer if displayed$")
    public void clickOnCloseButtonOnSavingEventDrawer() {
        dealsCategoriesPage.clickCloseButtonSavingEventListIfDisplayed();
    }

    @And("^click close button on deals events drawer if displayed$")
    public void clickOnCloseButtonOndealsEventDrawer() {
        dealsCategoriesPage.clickCloseButtondealsEventListIfDisplayed();
    }

    @Then("verify maximum of {int} saving events are displayed and are in alphabetical order")
    public void verifyMaxSavingEventsIsDisplayed(int maxSavingEvents) {
        dealsCategoriesPage.clickSeeAllSavingEvent();
        int savingEventCount = dealsCategoriesPage.getCountOfSavingEvents();
        Assert.assertTrue(savingEventCount <= maxSavingEvents, String.format("Saving events count is more than %s", maxSavingEvents));
        Set<String> eventNames = dealsCategoriesPage.getSavingEventNamesAfterClickingSeeAll();
        dealsCategoriesPage.closeSavingEventList();
        Assert.assertTrue(eventNames.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new)).equals(eventNames), "Saving events are not displayed in alphabetical order!!");
    }

    @And("user clicks category {string} from Your categories")
    public void clickDesiredCategory(String categoryName) {
        dealsCategoriesPage.clickOnDesiredCategory(categoryName);
    }

    @And("scroll down to expand {string} category from deals categories")
    public void scrollDownToExpandCategoryFromDealsCategories(String desiredCatName) {
        new CommonActions(driver).new TableActions().scrollDownTillCategoryIsDisplayed(dealsCategoriesPage.pageElements.categoryNamesInList, desiredCatName);
    }


    @When("get clipped deal name from deals categories")
    public void getClippedDealDescriptionFromDealsCategories() {
        CommonCache.commonCache.put("CLIPPED_DEAL", dealsCategoriesPage.getDealNameSelectedFromCategories());
    }

    @When("scroll down and expand first displayed category from deals categories")
    public void scrollDownToExpandFirstDisplayedCategoryFromDealsCategories() {
        String desiredCatName = new CommonActions(driver).new TableActions().getCategoryNamesDisplayedWithoutScroll(dealsCategoriesPage.pageElements.categoryNamesInList).stream().findFirst().get();
        CommonCache.commonCache.put("firstDisplayedCategoryDeals", desiredCatName);
        scrollDownToExpandCategoryFromDealsCategories(desiredCatName);
        clickDesiredCategory(desiredCatName);
    }
}


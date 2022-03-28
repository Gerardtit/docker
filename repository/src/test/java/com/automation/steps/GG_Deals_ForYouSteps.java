package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_DashboardPage;
import com.automation.pages.GG_Deals_ForYouPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GG_Deals_ForYouSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_Deals_ForYouPage dealsForYouPage = new GG_Deals_ForYouPage(driver);
    public GG_DashboardPage dashaboardPage = new GG_DashboardPage(driver);

    @And("^click on for you tab$")
    public void clickOnForYouTab() {
        dealsForYouPage.clickOnForYouTab();
    }

    @Then("^verify that weekly ad banner is displayed$")
    public void verifyDealIsDisplayed() {
        Assert.assertTrue(dealsForYouPage.isWeeklyAdBannerDisplayed(), "weekly ad banner is displayed");
    }

    @Then("^verify Save on your favorites title is displayed$")
    public void verifySaveOnYourFavoritesTitleIsDisplayed() {
        Assert.assertTrue(dealsForYouPage.isFavouriteDealSectiondisplayed(), "save on your favorites title is displayed");
    }

    @And("verify eligible products are displayed in offer details page")
    public void verifyQualifyingProductsIsDisplayed() {
        Assert.assertTrue(dealsForYouPage.QualifyingProductsIsDisplayed(), "qualifying products is not displayed");
    }

    @And("^verify qualifying Products is displayed on 'Promo deals'$")
    public void verifyQualifyingProductsIsDisplayedPromoDeals() {
        Assert.assertTrue(dealsForYouPage.QualifyingProductsIsDisplayedPromoDeals(), "qualifying products is not displayed on promo deals");
    }

    @Then("^verify default deal card has big image$")
    public void verifyDefaultDealCardHasBigImage() {
        Assert.assertTrue(dealsForYouPage.isDefaultDealImageBiggerThanCarouselImage(), "Default deal card does not have bigger image");
    }

    @Then("^verify that 'Fresh new coupons' is displayed$")
    public void verifyFreshNewCouponsDisplayed() {
        Assert.assertTrue(dealsForYouPage.scrollToFreshNewCoupons(), "Fresh new coupons is not displayed");
    }

    @Then("^verify that 'See all' button is displayed next to 'Fresh new coupons'$")
    public void verifyFreshNewCouponsSeeAllDisplayed() {
        Assert.assertTrue(dealsForYouPage.verifyFreshNewCouponsSeeAllButtonDisplayed(), "see all button is not displayed");
    }

    @Then("^verify that Clip button is displayed for default deal card in fresh new coupons$")
    public void verifyClipButtonDisplayedForFreshNewCouponsDefaultDeals() {
        Assert.assertTrue(dealsForYouPage.isClipButtonDisplayedForFreshNewCouponsDefaultDeals(), "Clip button is not displayed for default deal card in fresh new coupons");
    }

    @Then("^verify that coupon carousel is displayed$")
    public void verifyCouponsCarouselDisplayed() {
        Assert.assertTrue(dealsForYouPage.verifyCouponCarouselDisplayed(), "there is no coupon carousel");
    }

    @Then("^verify that deal discount amount is displayed$")
    public void verifyDealDiscountTitleDisplayed() {
        Assert.assertTrue(dealsForYouPage.verifyDealDiscountTitleDisplayed(), "deal discount amount is not displayed");
    }

    @Then("^verify that deal subject line is displayed$")
    public void verifyDealSubjectDisplayed() {
        Assert.assertTrue(dealsForYouPage.verifyDealSubjectLineDisplayed(), "deal subject line is not displayed");
    }

    @Then("^verify that deal description is displayed$")
    public void verifyDealDescriptionDisplayed() {
        Assert.assertTrue(dealsForYouPage.verifyDealDescriptionDisplayed(), "deal description is not displayed");
    }

    @Then("^verify that deal expiry is displayed$")
    public void verifyDealExpiryDisplayed() {
        Assert.assertTrue(dealsForYouPage.verifyDealExpiryDisplayed(), "deal expiry is not displayed");
    }

    @Then("^verify that default deal card is bigger than deals in coupon carousel$")
    public void verifyDefaultDealImageBiggerThanCarouselImage() {
        Assert.assertTrue(dealsForYouPage.isDefaultDealImageBiggerThanCarouselImage(), "Default deal card is not bigger than deal card in carousel");
    }

    @Then("^verify that first deal in list is the default deal card displayed$")
    public void verifyFirstDealInListIsDefault() {
        Assert.assertTrue(dealsForYouPage.isDealSelectedFromListDefaultDeal(0), "First deal from list is not the default deal");
    }

    @Then("^tap on a deal from list and verify that the tapped deal is displayed as default deal$")
    public void tapOnDealFromList() {
        dealsForYouPage.chooseDeal();
    }

    @And("^click on weekly ad banner in deals$")
    public void clickOnWeeklyAdBannerInDeals() {
        dealsForYouPage.clickWeeklyAdBanner();
    }

    @And("^click see all on fresh new coupons under deals$")
    public void clickSeeAllOnFreshNewCouponsUnderDeals() {
        dealsForYouPage.clickSeeAllOnFreshNewCouponsUnderDeals();
    }

    @Then("^verify fresh new coupons drawer opened$")
    public void freshNewCouponsDrawerOpened() {
        Assert.assertTrue(dealsForYouPage.freshNewCouponsDrawerOpened(), "fresh new coupons drawer is not opened");
    }

    @Then("^verify count of deals on fresh new coupons drawer$")
    public void verifyCountOfDealsOnFreshNewCouponsDrawer() {
        Assert.assertTrue(dealsForYouPage.verifyCountOfDealsOnFreshNewCouponsDrawer(), "count of deals on fresh new coupon is not displayed");
    }

    @Then("^verify deal banner on fresh new coupons drawer$")
    public void verifyDealBannerOnFreshNewCouponsDrawer() {
//        Assert.assertTrue(dealsPage.verifyDealImageOnFreshNewCouponsDrawer());
        Assert.assertTrue(dealsForYouPage.verifyDealDescription(), "deal description not displayed");
        Assert.assertTrue(dealsForYouPage.verifyDealExpiry(), "deal expiry date is not displayed");
        Assert.assertTrue(dealsForYouPage.verifyDealNameOnFreshNewCouponBanner(), "deal name is not displayed");
        Assert.assertTrue(dealsForYouPage.verifyDealPrice(), "deal price is not displayed");
    }

    @Then("^verify clip state on the deal card in fresh new coupons section$")
    public void verifyClipStateOnTheDealCardInFreshCouponsSection() {
        Assert.assertTrue(dealsForYouPage.verifyClipStateOnTheDealCardInFreshCouponsSection(), "clip state on deal card is not displayed");
    }

    @Then("^verify view products state on the deal card$")
    public void verifyViewProductsStateOnTheDealCard() {
        Assert.assertTrue(dealsForYouPage.verifyViewProductsStateOnTheDealCard(), "view products state is not displayed");
    }

    @And("^click cross button on drawer$")
    public void clickCrossButtonOnDrawer() {
        dealsForYouPage.clickCrossButtonOnDrawer();
    }

    @And("^click cross button on drawer of weekly Add app iframe$")
    public void clickCrossButtonOnWeeklyAddAPPIframe() {
        dealsForYouPage.clickBackButtonOnWeeklyAddAppIFrame();
    }

    @Then("^verify saving Event Label is displayed$")
    public void verifySavingEventLabel() {
        if (dealsForYouPage.isSavingEventLabelDisplayed()) {
            Assert.assertTrue(true);
        } else {
            if (new GG_DashboardPage(driver).isTutorialScreenDisplayed()) {
                if (new GG_DashboardPage(driver).isProfileIconDisplayed()) {
                    dealsForYouPage.scrollDownToSavingEvent();
                    Assert.assertTrue(dealsForYouPage.isSavingEventLabelDisplayed(), "Saving events carousel is not displayed");
                }
            } else {
                Assert.assertTrue(false, "Save On our brands deals details page is not displayed");
            }
        }
    }

    @When("^click on see All link of saving event$")
    public void clickSeeAllLSavingEvent() {
        dealsForYouPage.clickSeeAllSavingEvent();
    }

    @When("^scroll Down to Saving Event$")
    public void scrollDownToSavingEvent() {
        dealsForYouPage.scrollDownToSavingEvent();
    }

    @When("^click on saving event Category Title$")
    public void clickSavingEventCategoryTitle() {
        dealsForYouPage.clickSavingEventCategoryTitle();
    }

    @And("^verify saving Event Detail Page is displayed$")
    public void verifySavingEventPageIsDisplayed() {
        Assert.assertTrue(dealsForYouPage.isSavingEventPageIsDisplayed(), "saving event detail page is not displayed");
    }

    @And("^click on deal card$")
    public void verifyClickOnDealCard() {
        dealsForYouPage.clickOnDealCardImg();
    }

    @And("^click on deal card on 'Promo deals'$")
    public void verifyClickOnDealCardOnPromoDeal() {
        dealsForYouPage.clickOnDealCardImgOnPromoDeal();
    }

    @Then("^scroll down to 'View Product'$")
    public void scrollDownToViewProduct() {
        Assert.assertTrue(dealsForYouPage.verifyscrollDownToViewProductAndClipADealIfNotPresent(), "The View Products is not found!!!");
    }

    @Then("^verify save your favorites module drawer$")
    public void verifySaveYourFavoritesModuleDrawer() {
        Assert.assertTrue(dealsForYouPage.verifySaveYourFavoritesModuleDrawer(), "save on your favorite module is not displayed");
    }

    @And("^click close icon on save your favorites module drawer$")
    public void clickCloseIconOnSaveYourFavoritesModuleDrawer() {
        dealsForYouPage.clickCloseIconOnSaveYourFavoritesModuleDrawer();
    }

    @Then("^verify see all is displayed on save on your favorites module$")
    public void verifySeeAllIsDisplayedOnSaveOnYourFavoritesModule() {
        Assert.assertTrue(dealsForYouPage.verifySeeAllIsDisplayedOnSaveOnYourFavoritesModule(), "see all is not displayed");
    }

    @And("^click see all button on save your favourties module$")
    public void clickSeeAllOnSaveYourFavoritesModule() {
        dealsForYouPage.clickSeeAllOnSaveOnYourBrands();
    }

    @Then("^verify deal card components$")
    public void verifyDealCardComponents() {
        Assert.assertTrue(dashaboardPage.verifyDealCardDescription(), "deal card description is not displayed");
        Assert.assertTrue(dashaboardPage.verifyDealCardName(), "deal card name is not displayed");
        Assert.assertTrue(dashaboardPage.verifyDealCardExpiry(), "deal card expiry date is not displayed");
        Assert.assertTrue(dashaboardPage.verifyDealCardPrice(), "deal card price is not displayed");
    }

    @Then("^verify carousel view on 'save on your favorites' is displayed$")
    public void verifyCarouselViewForSaveONYOURFAVORITES() {
        dealsForYouPage.verifyCarouselViewSAVEONYOURFAV();
    }

    @And("^scroll Down to fresh new coupon section in deals$")
    public void scrollDownToFreshNewCouponSectionInDeals() {
        dealsForYouPage.scrollDownToFreshNewCouponSectionInDeals();
    }

    @And("^scroll Down to weekly ad banner section in deals$")
    public void scrollDownToWeeklyAdBannerSectionInDeals() {
        dealsForYouPage.scrollDownToWeeklyAdBannerSectionInDeals();
    }

    @Then("^category card details page is displayed$")
    public void categoryCardDetailsPageIsDisplayed() {
        Assert.assertTrue(dealsForYouPage.isCategoryCardDetailsPageDisplayed(), "category card detail page is not displayed");
    }

    @Then("^verify category card name in Category deals details page$")
    public void verifyCategoryCardNameInCategoryDealsDetailsPage() {
        Assert.assertTrue(dealsForYouPage.verifyCategoryCardNameInCategoryDealsDetailsPage(), "category card name is not displayed");
    }

    @Then("^verify count of offers on the Category deals details screen$")
    public void verifyCountOfOffersOnTheCategoryDealsDetailsScreen() {
        Assert.assertTrue(dealsForYouPage.verifyCountOfOffersOnTheCategoryDealsDetailsScreen(), "count of offers on the category is not displayed");
    }

    @And("^click back button on Category deals details screen$")
    public void clickBackButtonOnCategoryDealsDetailsScreen() {
        dealsForYouPage.clickBackButtonOnCategoryDealsDetailsScreen();
    }

    @And("^verify refine button is not present$")
    public void verifyRefineButtonIsNotDisplayed() {
        Assert.assertFalse(dealsForYouPage.isRefineDisplayed(), "refine button is present");
    }

    @And("^verify saving Event Title is displayed$")
    public void verifySavingEventTitleDisplayedInDrawer() {
        dealsForYouPage.isSavingEventDrawerScreenIsDisplayed();
    }

    @And("^click on Close button on Saving Event Detail Page$")
    public void clickOnCloseButtonOnSavingEventDetailPage() {
        dealsForYouPage.clickOnCloseButtonOfSavingEventDetailPage();
    }

    @And("^click close button on saving events drawer$")
    public void clickOnCloseButtonOnSavingEventDrawer() {
        dealsForYouPage.clickOnCloseButton();
    }

    @Then("^verify cross button is displayed in special event screen$")
    public void verifyCrossButtonIsDisplayedOnSpecialEventScreen() {
        Assert.assertTrue(dealsForYouPage.isCrossButtonDisplayed(), "cross button is not displayed");
    }

    @Then("^verify close button is displayed special in event screen$")
    public void verifyCloseButtonIsDisplayedOnSpecialEventScreen() {
        Assert.assertTrue(dealsForYouPage.isCloseButtonDisplayed(), "close button is not displayed");
    }

    @Then("^verify total count is displayed special event screen$")
    public void verifyTotalIsDisplayedOnSpecialEventScreen() {
        Assert.assertTrue(dealsForYouPage.isTotalCountIsDisplayed(), "total count is not displayed");
    }

    @Then("^verify listing of saving event on small card$")
    public void verifyListinfOfSavingEvent() {
        Assert.assertTrue(dealsForYouPage.isSavingEventListingDisplayed(), "listing of saving event on small card is not displayed");
    }

    @When("^user clicks category \"([^\"]*)\" under Categories in deals tab$")
    public void userClicksOnAisleList(String categoryName) throws Throwable {
        dealsForYouPage.clickOnCategoryByName(categoryName);
    }

    @Then("^verify offer type, details and disclaimer is displayed on offer details page$")
    public void verifyOfferTypeDetailsDisclaimerDisplayed() {
        dealsForYouPage.verifyOfferTypeDetailsDisclaimerDisplayed();
    }

    @And("^click on clip deal if present$")
    public void clickClipDeal() {
        dealsForYouPage.clickClipDeal();
    }

    @And("^click on eligible products CTA on deal card$")
    public void clickEligibleProducts() {
        dealsForYouPage.clickEligibleProducts();
    }

    @And("^click on offer terms and conditions$")
    public void clickOfferTermsConditions() {
        dealsForYouPage.clickOfferTermsConditions();
    }

    @And("^verify Deals By Category Navigation card is Displayed$")
    public void verifyDealsByCategoryDisplayed() {
        Assert.assertTrue(dealsForYouPage.isDealsByCategoryNavigationCardDisplayed(), "deals by category navigation card is not displayed");
    }

    @And("^verify All Deals Navigation card is Displayed$")
    public void allDealsCardDisplayed() {
        Assert.assertTrue(dealsForYouPage.isAllDealsNavigationCardDisplayed(), "all deals navigation card is not displayed");
    }

    @And("^click on Deals By Category navigation Card$")
    public void clickOnDealsByCategoryNavigationCard() {
        dealsForYouPage.clickOnDealsByCategoryNavigationCard();
    }

    @And("^click on All Deals navigation Card$")
    public void clickOnAllDealsNavigationCard() {
        dealsForYouPage.clickOnAllDealsNavigationCard();
    }

    @And("^scroll down to item you may like module$")
    public void scrollDownToItemYouMayLikeModule() {
        dealsForYouPage.scrollDownToItemYouMayLikeModule();
    }

    @And("^scroll down to item you may buy module$")
    public void scrollDownToItemYouMayBuyModule() {
        dealsForYouPage.scrollDownToItemYouMayBuyModule();
    }

    @Then("^verify 'Items you may like' module is displayed$")
    public void verifyItemsYouMayLikeModuleDisplayed() {
        Assert.assertTrue(dealsForYouPage.isItemsYouMayLikeModuleDisplayed(), "Items you may like module is not displayed");
    }

    @And("^verify Bigger Deal card has No clipped label$")
    public void verifyDefaultDealCardHasNoClippedLabel() {
        Assert.assertTrue(dealsForYouPage.verifyDefaultDealCardHasNoClippedLabel(), "no clipped label is not displayed");
    }

    @And("^verify see all link beside item You May Like is displayed$")
    public void verifySeeAllLinkBesideItemYouMayLikeIsDisplayed() {
        Assert.assertTrue(dealsForYouPage.isSeeAllBesideItemYouMayLikeModuleDisplayed(), "see all link is not displayed");
    }

    @Then("^verify carousel view in Item You May Like Module$")
    public void verifyCarouselViewInPersonalisedSection() throws InterruptedException {
        Assert.assertTrue(dealsForYouPage.hasCarouselViewInItemYouMayLikeModule(), "carousel view is not present");
    }

    @Then("^scroll through the carousel view and click on see all if deal card count is more than 10$")
    public void clickOnSeeAllLinkIfCardsMoreThenTen() {
        dealsForYouPage.clickOnSeeAllLinkIfCardsMoreThenTen();
    }

    @Then("^verify Deal Listing Page is displayed$")
    public void verifyDealListingPageDisplayed() {
        Assert.assertTrue(dealsForYouPage.isDealListingPageDisplayed(), "deal listing page is not displayed");
    }

    @Then("^click on close button on deal listing page$")
    public void ClickOnCloseButtonOnDealListingPage() {
        dealsForYouPage.clickOnCloseButtonOfdealListingPage();
    }

    @Then("^verify Associate offer module is displayed$")
    public void verifyAssociateOfferModuleIsDisplayed() {
        Assert.assertTrue(dealsForYouPage.isAssociateOfferModuleIsDisplayed(), "Associate offer module is not displayed");
    }

    @And("^verify see all link beside Associate offer module is displayed$")
    public void verifySeeAllLinkBesideAssociateOfferModuleIsDisplayed() {
        Assert.assertTrue(dealsForYouPage.isSeeAllLinkBesideAssociateOfferModuleIsDisplayed(), "see all link is not displayed");
    }

    @When("^click see all link beside Associate offer module$")
    public void clickSeeAllLinkBesideAssociateOfferModule() {
        dealsForYouPage.clickOnSeeAllLinkBesideAssociateOfferModule();
    }

    @And("^click see all link beside item you may like module$")
    public void clickSeeAllLinkBesideItemYouMayLikeModule() {
        dealsForYouPage.clickOnSeeAllLinkBesideItemYouMayLikeModule();
    }

    @And("click see all link beside item you may buy module")
    public void clickSeeAllLinkBesideItemYouMayBuyModule() {
        dealsForYouPage.clickOnSeeAllLinkBesideItemYouBuyLikeModule();
    }

    @Then("^get saving event before store is updated$")
    public void getsavingEventBeforeStoreUpdate() {
        dealsForYouPage.getSavingEventBeforeChangingStore();
    }

    @Then("^verify saving events are updated after store is changed$")
    public void verifySavingEventsAreUpdated() {
        Assert.assertTrue(dealsForYouPage.verifySavingEventsUpdatedAfterStoreChange(), "saving events are not updated");
    }

    @Then("^get card name before categories is not changed$")
    public void getCardNameBeforeCategoryChange() {
        dealsForYouPage.getCardNameBeforeCategoryChange();
    }

    @Then("^verify deal card are updated after store is changed$")
    public void verifyCardNameAreUpdated() {
        Assert.assertTrue(dealsForYouPage.verifyCardsUpdatedAfterCategoryChange(), "deal are not updated");
    }

    @Then("^verify Eligible products button is displayed on deals page$")
    public void verifyEligibleProductsButtonIsDisplayedOnDealsScreen() {
        Assert.assertTrue(dealsForYouPage.verifyEligibleProductsButtonOnDealsScreen(), "Eligible Product button is not displayed");
    }

    @When("^user click on Eligible products button is displayed on deals page$")
    public void clickOnEligibleProducts_DealsPage() {
        dealsForYouPage.clickOnEligibleProductsButtonOnDealsScreen();
    }

    @When("^click on clip cta button on deals page$")
    public void clickOnClipCTA_DealsPage() {
        dealsForYouPage.clickOnClipCTADealsPage();
    }

    @Then("^click on clip cta button$")
    public void clickOnClipCTA() {
        dealsForYouPage.clickOnClipCTA();
    }

    @Then("^verify clip cta on deal card$")
    public void verifyClipCtaOnDealCard() {
        Assert.assertTrue(dealsForYouPage.isClipCTAOnDealCardIsDisplayed(), "clip cta is not displayed");
    }

    @And("^search for product \"([^\"]*)\" on deals page$")
    public void searchByProductName(String productName) {
        dealsForYouPage.searchByProductName(productName);
    }

    @Then("^swipe left on deal cards in Items You May Like Module until 'See all' CTA is displayed in the End of carousel$")
    public void swipeLeftToSeeAllCTA() {
        dealsForYouPage.swipeLeftToSeeAllCTA();
    }

    @Then("^verify 'See all' CTA is displayed in the End of carousel$")
    public void verifySeeAllCTAOnEndofCarousel() {
        Assert.assertTrue(dealsForYouPage.isSeeAllCTAOnEndofCarousel(), "see all cta is not displayed");
    }

    @And("scroll up till top of the ForYou tab")
    public void scrollUpTillTopOfTheForYouTab() {
        dealsForYouPage.scrollTillTopOfScreen();
    }

    @And("click on {string} link in carousel on For you page")
    public void clickDesiredLinkCarousel(String linkText) {
        dealsForYouPage.clickOnDesiredLinkFromCarousel(linkText);
    }

    @And("verify {string} link is displayed in carousel on For you page")
    public void verifyDesiredLinkFromCarousel(String linkText) {
        dealsForYouPage.verifyDesiredLinkFromCarousel(linkText);
    }

    @When("scroll down to item you may like module deal card")
    public void scrollDownToItemYouMayLikeModuleDealCard() {
        dealsForYouPage.scrollDownToItemYouMayLikeModuleDealCard();
    }

    @When("scroll down to item you may buy module deal card")
    public void scrollDownToItemYouMayBuyModuleDealCard() {
        dealsForYouPage.scrollDownToItemYouMayBuyModuleDealCard();
    }

    @And("scroll down to Associate offer module deal card")
    public void scrollDownToAssociateOfferModuleDealCard() {
        dealsForYouPage.scrollDownToAssociateOfferModuleDealCard();
    }


    @And("^click on \"([^\"]*)\" on For you page$")
    public void clickMyRewards(String rewardsLink) {
        dealsForYouPage.clickOnMyRewards(rewardsLink);
    }


    @And("clip a deal on For you page if clipped deals count is zero")
    public void clipADealOnForYouPageIfClippedDealsCountIsZero() {
        dealsForYouPage.clipADealOnForYouPageIfClippedDealsCountIsZero();
    }

    @And("clip {int} deals from items you may like")
    public void clipDealsFromItemYouMayLike(int dealCount) {
        dealsForYouPage.clipDealsFromItemsYouMayLike(dealCount);
    }

    @And("clip a deal if not already clipped")
    public void checkClippedAndClipDeal() {
        dealsForYouPage.clipDealIfNotClipped();
    }

    @And("click Got it on welcome card on For you page")
    public void clickGotItOnWelcomeCardIfDisplayed() {
        dealsForYouPage.clickGotItOnWelcomeCardIfDisplayed();

    }


    @And("^click on My Rewards on Deals page$")
    public void clickMyRewardsLink() {
        dealsForYouPage.clickOnMyRewardsLink();
    }

    @And("^click on Clipped deals on Deals page$")
    public void clickClippedDeals() {
        dealsForYouPage.clickOnClippedDeals();
    }

    @And("^click on Weekly Ads on Deals page$")
    public void clickWeeklyAdsLink() {
        dealsForYouPage.clickOnWeeklyAdLink();
    }

    @And("^click back button on Weekly Ads page$")
    public void clickBackButtonOnWeeklyAdsPage() {
        dealsForYouPage.clickBackButtonOnWeeklyAdsPage();
    }

    @Then("verify deal detail page is displayed")
    public void verifyDealsDetailPageIsDisplayed() {
        Assert.assertTrue(dealsForYouPage.isDealDetailPageIsDisplayed(), "Offer details page is not displayed!!");
    }


    @And("click on clip deal in deals details page")
    public void clickOnClipDealInDealsDetailsPage() {
        dealsForYouPage.clickOnClipDealInDealsDetailsPage();
    }


    @And("user clicks on a deal with eligible products in items you may like page")
    public void clickDealWithEligibleProducts() throws InterruptedException {
        dealsForYouPage.clickDealWithEligibleProducts();
    }

    @When("Click or tap on How do rewards work button")
    public void clickOrTapOnHowDoRewardsWorkButton() {
        dealsForYouPage.clickOnTapOnHowDoRewardsWorkButton();
    }

    @Then("Verify it lands on a page where it shows about your rewards and Earning Points")
    public void verifyItLandsOnAPageWhereItShowsAboutYourRewardsAndEarningPoints() throws InterruptedException {
        Assert.assertTrue(dealsForYouPage.isEarnPointsIsDisplayed(), "earn Points page is not displayed!!");

    }
}


package com.automation.pages;

import com.automation.helpers.PageActions;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.TapAction;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_DashboardPageElements;
import com.automation.pageElements.GG_Deals_ForYouPageElements;
import com.automation.pageElements.GG_MyRewardsPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class GG_Deals_ForYouPage extends PageActions {
    public GG_Deals_ForYouPageElements dealsForYouPageElements = new GG_Deals_ForYouPageElements();
    public GG_DashboardPageElements dashboardPageElements = new GG_DashboardPageElements();
    private final GG_MyRewardsPageElements myRewardsPageElements = new GG_MyRewardsPageElements();


    public GG_Deals_ForYouPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dealsForYouPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dashboardPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), myRewardsPageElements);
    }

    public boolean isWeeklyAdBannerDisplayed() {
        return scrollDownForElement(dealsForYouPageElements.weeklyAdBanner);
    }

    public void waitForLoaderToDisappear() {
        new WaitAction(driver).waitForElementToDisappear(dealsForYouPageElements.loadingSpinner, 60);
    }

    public boolean isFavouriteDealSectiondisplayed() {
        scrollDownForElement(dealsForYouPageElements.saveOnYourFavoriteTitle);
        return isElementDisplayed(dealsForYouPageElements.saveOnYourFavoriteTitle);
    }

    public boolean QualifyingProductsIsDisplayed() {
        return isElementDisplayed(dealsForYouPageElements.QualifyingProducts);
    }

    public boolean QualifyingProductsIsDisplayedPromoDeals() {
        return scrollDownForElement(dealsForYouPageElements.QualifyingProductsPromoDeals);
    }

    public boolean scrollToFreshNewCoupons() {
        return scrollDownForElement(dealsForYouPageElements.freshNewCouponsLabel);
    }

    public boolean verifyFreshNewCouponsSeeAllButtonDisplayed() {
        scrollToFreshNewCoupons();
        return scrollDownForElement(dealsForYouPageElements.seeAllFreshNewCouponsButton);
    }

    public boolean isClipButtonDisplayedForFreshNewCouponsDefaultDeals() {
        return scrollDownForElement(dealsForYouPageElements.clipButtonDefaultDealFreshNewCoupon);
    }

    public boolean verifyCouponCarouselDisplayed() {
        return scrollDownForElement(dealsForYouPageElements.couponCarousel);
    }

    public boolean verifyDealDiscountTitleDisplayed() {
        scrollDownForElement(dealsForYouPageElements.dealPriceONFreshNewCoupon);
        return !dealsForYouPageElements.dealPriceONFreshNewCoupon.getText().isEmpty();
    }

    public boolean verifyDealSubjectLineDisplayed() {
        scrollDownForElement(dealsForYouPageElements.dealNameONFreshNewCoupon);
        return !dealsForYouPageElements.dealNameONFreshNewCoupon.getText().isEmpty();
    }

    public boolean verifyDealDescriptionDisplayed() {
        scrollDownForElement(dealsForYouPageElements.dealDescriptionONFreshNewCoupon);
        return !dealsForYouPageElements.dealDescriptionONFreshNewCoupon.getText().isEmpty();
    }

    public boolean verifyDealExpiryDisplayed() {
        scrollDownForElement(dealsForYouPageElements.dealExpiryONFreshNewCoupon);
        return !dealsForYouPageElements.dealExpiryONFreshNewCoupon.getText().isEmpty();

    }

    public boolean isDefaultDealImageBiggerThanCarouselImage() {
        scrollDownForElement(dealsForYouPageElements.freshNewCouponsLabel);
        scrollDownForElement(dealsForYouPageElements.freshNewCouponsDefaultDealImage);
        Dimension defaultDealDimension = dealsForYouPageElements.freshNewCouponsDefaultDealImage.getSize();
        int defaultDealDimensionWidth = defaultDealDimension.getWidth();
        int defaultDealDimensionHeight = defaultDealDimension.getHeight();

        scrollDownForElement(dealsForYouPageElements.freshNewCouponsCarouselFirstDeal);
        scrollDownBySmallAmount();
        Dimension carouselDealDimension = dealsForYouPageElements.freshNewCouponsCarouselDealImage.get(0).getSize();
        int carouselDealDimensionWidth = carouselDealDimension.getWidth();
        int carouselDealDimensionHeight = carouselDealDimension.getHeight();

        return defaultDealDimensionWidth > carouselDealDimensionWidth && defaultDealDimensionHeight > carouselDealDimensionHeight;
    }

    public void chooseDeal() {
        scrollDownForElement(dealsForYouPageElements.freshNewCouponsCarouselFirstDeal);
        int firstDeal = 0;
        int lastDeal = dealsForYouPageElements.freshNewCouponsCarouselDealContainer.size() >= 4 ? 3 : dealsForYouPageElements.freshNewCouponsCarouselDealContainer.size() - 1;
        Random rand = new Random();
        int choosedDealIndex = rand.nextInt((lastDeal - firstDeal) + 1) + firstDeal;
        tapOnDealFromList(choosedDealIndex);
        isDealSelectedFromListDefaultDeal(choosedDealIndex);
    }

    public void tapOnDealFromList(int choosedDealIndex) {
        if (dealsForYouPageElements.freshNewCouponsCarouselDealContainer.size() > 1) {
            new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.freshNewCouponsCarouselDealContainer.get(choosedDealIndex));
        } else {
            new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.freshNewCouponsCarouselDealContainer.get(0));
        }
    }

    public boolean isDealSelectedFromListDefaultDeal(int choosedDealIndex) {
        scrollDownForElement(dealsForYouPageElements.freshNewCouponsLabel);
        if (dealsForYouPageElements.freshNewCouponsCarouselDealContainer.size() == 1) {
            choosedDealIndex = 0;
        }
        scrollDownForElement(dealsForYouPageElements.dealNameONFreshNewCoupon);
        boolean isSame = false;
        String dealNameDefault = dealsForYouPageElements.dealNameONFreshNewCoupon.getText().trim();
        String dealNameCarousel = "";
        scrollDownForElement(dealsForYouPageElements.freshNewCouponsCarouselFirstDeal);

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            dealNameCarousel = dealsForYouPageElements.freshNewCouponsCarouselDealContainer.get(choosedDealIndex).getAttribute("name").trim();
            String regex = "[1-9]+ of [1-9]+ in the list";
            dealNameCarousel = dealNameCarousel.split("Showing coupon for ")[1].split(regex)[0].trim();
            if (dealNameDefault.contains(dealNameCarousel)) {
                isSame = true;
            }
        } else {
            dealNameCarousel = dealsForYouPageElements.freshNewCouponsCarouselDealContainer.get(choosedDealIndex).getAttribute("content-desc").trim();
            if (dealNameCarousel.contains(dealNameDefault)) {
                isSame = true;
            }
        }

        return isSame;
    }

    public void clickWeeklyAdBanner() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.weeklyAdBanner);
    }

    public void clickSeeAllOnFreshNewCouponsUnderDeals() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.seeAllFreshNewCouponsButton);
    }

    public boolean freshNewCouponsDrawerOpened() {
        return isElementDisplayed(dealsForYouPageElements.dealCountInFreshNewCouponsDrawer);
    }

    public boolean verifyCountOfDealsOnFreshNewCouponsDrawer() {
        return isElementDisplayed(dealsForYouPageElements.dealCountInFreshNewCouponsDrawer);
    }

    public boolean verifyClipStateOnTheDealCardInFreshCouponsSection() {
        return isElementDisplayed(dealsForYouPageElements.clipStateOnFreshNewCouponsDrawerDealCard);
    }

    public boolean verifyViewProductsStateOnTheDealCard() {
        return scrollDownForElement(dealsForYouPageElements.eligibleProductsButton);
    }

    public void clickCrossButtonOnDrawer() {
        if (isElementDisplayed(dealsForYouPageElements.crossButtonOnDrawer, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.crossButtonOnDrawer);
        }
    }

    public boolean verifyDealDescription() {
        scrollDownForElement(dealsForYouPageElements.dealExpiry);
        return isElementDisplayed(dealsForYouPageElements.dealDescription);
    }

    public boolean verifyDealExpiry() {
        return isElementDisplayed(dealsForYouPageElements.dealExpiry);
    }

    public boolean verifyDealName() {
        return isElementDisplayed(dealsForYouPageElements.dealName);
    }

    public boolean verifyDealNameOnFreshNewCouponBanner() {
        return isElementDisplayed(dealsForYouPageElements.dealNameOnFreshNewCouponBanner);
    }

    public boolean verifyNameOnDealCard() {
        return isElementDisplayed(dealsForYouPageElements.couponNameOnCouponCard);
    }

    public boolean verifyDealPrice() {
        return isElementDisplayed(dealsForYouPageElements.dealPrice);
    }

    public void clickBackButtonOnWeeklyAddAppIFrame() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.backButtonOnWeeklyAddAppIFrame);
    }

    public boolean isSavingEventLabelDisplayed() {
        return isElementDisplayed(dealsForYouPageElements.savingEventCardLabel);
    }

    public void clickOnSavingEvent() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.savingEventCardDealCount);
    }

    public void scrollDownToSavingEvent() {
        scrollDownForElement(dealsForYouPageElements.savingEventCardLabel);
    }

    public void clickSeeAllSavingEvent() {

        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.seeAllSavingEvent);
    }

    public void isSavingEventDrawerScreenIsDisplayed() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Assert.assertTrue(dealsForYouPageElements.savingEventDrawerTitle.getAttribute("value").equalsIgnoreCase("Saving events"));
        } else {
            Assert.assertTrue(dealsForYouPageElements.savingEventDrawerTitle.getAttribute("text").equalsIgnoreCase("Saving events"));
        }
    }

    public void clickSavingEventCategoryTitle() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.savingEventCategoryTitle);
    }

    public boolean isSavingEventPageIsDisplayed() {
        return isElementDisplayed(dealsForYouPageElements.savingEventPageTitle);
    }

    public void clickOnDealCardImg() {
        scrollDownForElement(dealsForYouPageElements.dealName, 5);
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.dealName);
    }

    public void clickOnDealCardImgOnPromoDeal() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.PromoDealDealCard);

    }

    public boolean verifyscrollDownToViewProductAndClipADealIfNotPresent() {
        if (!scrollDownForElement(dealsForYouPageElements.eligibleProductsButton)) {
            clickClipDeal();
        }
        return isElementDisplayed(dealsForYouPageElements.eligibleProductsButton);
    }

    public boolean verifySaveYourFavoritesModuleDrawer() {
        return isElementDisplayed(dealsForYouPageElements.saveYourFavourtiesDrawerTitle);
    }

    public void clickCloseIconOnSaveYourFavoritesModuleDrawer() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.closeIconOnSaveYourFavoritesModuleDrawer);
    }

    public boolean verifySeeAllIsDisplayedOnSaveOnYourFavoritesModule() {
        return isElementDisplayed(dealsForYouPageElements.seeAllButtonOnSaveYourFavourtiesModule);
    }

    public void clickSeeAllOnSaveOnYourBrands() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.seeAllButtonOnSaveYourFavourtiesModule);
    }

    public void scrollDownToFreshNewCouponSectionInDeals() {
        scrollDownForElement(dealsForYouPageElements.freshNewCouponsCarouselFirstDeal);
    }

    public void verifyCarouselViewSAVEONYOURFAV() {
        scrollDownForElement(dealsForYouPageElements.CarouselViewSAVEONYOURFAV);
    }

    public void scrollDownToWeeklyAdBannerSectionInDeals() {
        scrollDownForElement(dealsForYouPageElements.weeklyAdBanner);
    }

    public boolean toggleIt() {
        return isElementDisplayed(dealsForYouPageElements.toggleItWindow);
    }

    public boolean isCategoryCardDetailsPageDisplayed() {
        return isElementDisplayed(dealsForYouPageElements.titleInCategoryDealsDetailsPage);
    }

    public boolean verifyCategoryCardNameInCategoryDealsDetailsPage() {
        return isElementDisplayed(dealsForYouPageElements.cardNameInCategoryDealsDetailsPage);
    }

    public boolean verifyCountOfOffersOnTheCategoryDealsDetailsScreen() {
        return isElementDisplayed(dealsForYouPageElements.offerCountInCategoryDealsDetailsPage);
    }

    public void clickBackButtonOnCategoryDealsDetailsScreen() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.backButtonOnCategoryDealsDetailsScreen);
    }

    public boolean isRefineDisplayed() {
        return isElementDisplayed(dealsForYouPageElements.refineButton);
    }

    public void clickOnCloseButton() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.closeButton);
    }

    public boolean isCrossButtonDisplayed() {
        return isElementDisplayed(dealsForYouPageElements.crossButton);
    }

    public boolean isCloseButtonDisplayed() {
        return isElementDisplayed(dealsForYouPageElements.closeButton);
    }

    public void clickOnCloseButtonOfSavingEventDetailPage() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.closeButtonOnSavingEventDetailPage);
    }

    public boolean isTotalCountIsDisplayed() {
        return isElementDisplayed(dealsForYouPageElements.totalCountOnSavingEventDrawer);
    }

    public boolean isSavingEventListingDisplayed() {
        return isElementDisplayed(dealsForYouPageElements.savingEventCategoryTitle);
    }

    public void slideTheDealCardFromRightToLeft(MobileElement ele) {
        Point pt = ele.getLocation();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            scroll(100, pt.getY(), 30, pt.getY());
        } else {
            scroll(pt.getX() + 100, pt.getY(), pt.getX() - 100, pt.getY());
        }
    }

    public void clickOnCategoryByName(String categoryName) {
        scrollDownForElement(dealsForYouPageElements.categoryName);
        new TapAction(driver).tapElementCoordinate(findElementByLabel(categoryName));
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void clickClipDeal() {
        if (isElementDisplayed(dealsForYouPageElements.clipDeal, 5)) {
            new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.clipDeal);
        }
    }

    public void clickEligibleProducts() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.eligibleProductsButton);
    }

    public void clickOfferTermsConditions() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.offerTermsConditions);
    }

    public void verifyOfferTypeDetailsDisclaimerDisplayed() {
        Assert.assertTrue(dealsForYouPageElements.offerTermsConditionsText.getText().contains("Offer Type"), "Offer Type is not displayed on offer details page");
        Assert.assertTrue(dealsForYouPageElements.offerTermsConditionsText.getText().contains("Offer Details"), "Offer Details is not displayed on offer details page");
        Assert.assertTrue(dealsForYouPageElements.offerTermsConditionsText.getText().contains("Disclaimer"), "Disclaimer is not displayed on offer details page");
    }

    public boolean isDealsByCategoryNavigationCardDisplayed() {
        scrollDownForElement(dealsForYouPageElements.dealsByCategoryNavigationCard);
        return isElementDisplayed(dealsForYouPageElements.dealsByCategoryNavigationCard);
    }

    public boolean isAllDealsNavigationCardDisplayed() {
        if (!isElementDisplayed(dealsForYouPageElements.allDealsNavigationCard)) {
            scrollDownForElement(dealsForYouPageElements.allDealsNavigationCard);
        }
        return isElementDisplayed(dealsForYouPageElements.allDealsNavigationCard);
    }

    public void clickOnDealsByCategoryNavigationCard() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.dealsByCategoryNavigationCard);
    }

    public void clickOnAllDealsNavigationCard() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.allDealsNavigationCard);
    }

    public boolean isDealsCategoryListPageDisplayed() {
        return isElementDisplayed(dealsForYouPageElements.dealsCategoryPage);
    }

    public void scrollDownToItemYouMayLikeModule() {
        scrollDownForElement(dealsForYouPageElements.itemsYouMayLikeTitle);
    }

    public boolean isItemsYouMayLikeModuleDisplayed() {
        scrollDownForElement(dealsForYouPageElements.itemsYouMayLikeTitle);
        return isElementDisplayed(dealsForYouPageElements.itemsYouMayLikeTitle);
    }

    public boolean verifyDefaultDealCardHasNoClippedLabel() {
        boolean isDefaultDealCardHasNoClippedLabel = false;
        if (isDefaultDealImageBiggerThanCarouselImage()) {
            if (!isElementDisplayed(dealsForYouPageElements.clippedlabel)) {
                isDefaultDealCardHasNoClippedLabel = true;
            }
        }
        return isDefaultDealCardHasNoClippedLabel;
    }

    public boolean isSeeAllBesideItemYouMayLikeModuleDisplayed() {
        return isElementDisplayed(dealsForYouPageElements.seeAllLinkBesideItemYouMayLikeModule);
    }

    public void clickOnSeeAllLinkIfCardsMoreThenTen() {
        swipeLeftToSeeAllCTA();
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.seeAllButtonInDealCard);
    }

    public boolean hasCarouselViewInItemYouMayLikeModule() throws InterruptedException {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            return hasCarouselView(dealsForYouPageElements.dealCardContainer, "label");
        } else {
            scrollDownForElement(dealsForYouPageElements.expiryDateOfItemYouMayLikeModule);
            return hasCarouselView(dealsForYouPageElements.dealCardContainer, "text");
        }
    }

    public boolean isDealListingPageDisplayed() {
        return isElementDisplayed(dealsForYouPageElements.dealListingPage);
    }

    public void clickOnCloseButtonOfdealListingPage() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.closeButtonOnDealListingScreen);
    }

    public String getSavingEventBeforeChangingStore() {
        String savingEventLabel = dealsForYouPageElements.savingEventCardLabel.getText();
        return savingEventLabel;
    }

    public boolean verifySavingEventsUpdatedAfterStoreChange() {
        boolean isUpdated = false;
        String savingEventLabel = dealsForYouPageElements.savingEventCardLabel.getText();
        if (getSavingEventBeforeChangingStore() != savingEventLabel) {
            isUpdated = true;
        }
        return isUpdated;
    }

    public String getCardNameBeforeCategoryChange() {
        String cardName = dealsForYouPageElements.cardNameInCategoryDealsDetailsPage.getText();
        return cardName;
    }

    public void clickOnEligibleProductsButtonOnDealsScreen() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.eligibleProductBtn);
    }

    public boolean verifyEligibleProductsButtonOnDealsScreen() {
        return isElementDisplayed(dealsForYouPageElements.eligibleProductBtn);
    }

    public boolean verifyCardsUpdatedAfterCategoryChange() {
        boolean isUpdated = false;
        String cardLabelText = dealsForYouPageElements.cardNameInCategoryDealsDetailsPage.getText();
        if (getCardNameBeforeCategoryChange() != cardLabelText) {
            isUpdated = true;
        }
        return isUpdated;
    }

    public void clickOnClipCTADealsPage() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.clipButton);

    }

    public void clickOnClipCTA() {
        if (!scrollDownForElement(dealsForYouPageElements.eligibleProductBtn)) {
            new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.clipButton);
        }
    }

    public boolean isClipCTAOnDealCardIsDisplayed() {
        scrollDownForElement(dealsForYouPageElements.clipButton);
        return isElementDisplayed(dealsForYouPageElements.clipButton);
    }


    public boolean isAssociateOfferModuleIsDisplayed() {
        scrollDownForElement(dealsForYouPageElements.associateOfferModuleTitle);
        return isElementDisplayed(dealsForYouPageElements.associateOfferModuleTitle);
    }

    public void searchByProductName(String productName) {
        clickSearchIconDealsPage();
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":

                new WaitAction(driver).waitForDisplayed(dashboardPageElements.searchKeywordFromResult.get(0), 2);
                new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.searchKeywordFromResult.get(0));
                break;
            case "IOS":
                enterKey(dashboardPageElements.detailSearchField, productName);
                break;
        }
    }

    public void clickSearchIconDealsPage() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.searchIcon);

    }

    public boolean isSeeAllLinkBesideAssociateOfferModuleIsDisplayed() {
        return isElementDisplayed(dealsForYouPageElements.seeAllLinkBesideAssociateOfferModule);
    }

    public void clickOnSeeAllLinkBesideAssociateOfferModule() {
        scrollDownForElement(dealsForYouPageElements.seeAllLinkBesideAssociateOfferModule);
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.seeAllLinkBesideAssociateOfferModule);
    }

    public void clickOnSeeAllLinkBesideItemYouMayLikeModule() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.seeAllLinkBesideItemYouMayLikeModule);
    }

    public void clickOnSeeAllLinkBesideItemYouBuyLikeModule() {
        scrollDownForElement(dealsForYouPageElements.seeAllLinkBesideItemYouMayBuyModule);
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.seeAllLinkBesideItemYouMayBuyModule);
    }

    public void swipeLeftToSeeAllCTA() {
        scrollDownBySmallAmount();
        scrollDownForElement(dealsForYouPageElements.expiryDateOfItemYouMayLikeModule);
        scrollDownBySmallAmount();
        swipeLeftUntilSeeAllBtnIsFound();
    }

    public boolean isSeeAllCTAOnEndofCarousel() {
        return scrollDownForElement(dealsForYouPageElements.seeAllButtonInDealCard, 2);
    }

    public void scrollTillTopOfScreen() {
        scrollUp();
    }

    public void clickOnMyRewards(String rewardsLink) {
        dealsForYouPageElements.myRewardsLink.click();
        waitForLoaderToDisappear();
    }

    public void clickOnDesiredLinkFromCarousel(String linkText) {
        switch (linkText.toUpperCase()) {
            case "MY REWARDS":
                new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.myRewardsLink);
                scrollUp();
                break;
            case "CLIPPED DEALS":
                dealsForYouPageElements.clippedDealsLink.click();
                break;
            case "WEEKLY AD":
                dealsForYouPageElements.weeklyAdLink.click();
                break;
        }

        waitForLoaderToDisappear();
        if (isElementDisplayed(dashboardPageElements.feedBackForm, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.closeFeedback);
        }
    }

    public boolean verifyDesiredLinkFromCarousel(String linkText) {
        boolean isFound = false;
        switch (linkText.toUpperCase()) {
            case "MY REWARDS":
                isFound = isElementDisplayed(dealsForYouPageElements.myRewardsLink);
                break;
            case "CLIPPED DEALS":
                isFound = isElementDisplayed(dealsForYouPageElements.clippedDealsLink);
                break;
            case "WEEKLY AD":
                isFound = isElementDisplayed(dealsForYouPageElements.weeklyAdLink);
                break;
        }

        return isFound;
    }

    public void swipeLeftUntilSeeAllBtnIsFound() {
        int counter = 0;
        int counterMax = 40;
        while (counter < counterMax) {
            if (isElementDisplayed(dealsForYouPageElements.seeAllButtonInDealCard, 2)) {
                break;
            } else {
                swipeLeft();
                counter++;
            }
        }
    }

    public void scrollDownToItemYouMayLikeModuleDealCard() {
        scrollDownToItemYouMayLikeModule();
        scrollDownForElement(dealsForYouPageElements.dealCTAButton);
    }

    public void scrollDownToItemYouMayBuyModuleDealCard() {
        scrollDownToItemYouMayBuyModule();
        scrollDownForElement(dealsForYouPageElements.dealCTAButton);
    }

    public void scrollDownToItemYouMayBuyModule() {
    }

    public void scrollDownToAssociateOfferModuleDealCard() {
        scrollDownForElement(dealsForYouPageElements.dealCTAButton);
    }

    public void clickOnForYouTab() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.forYouTab);
    }


    public void clipADealOnForYouPageIfClippedDealsCountIsZero() {
        new GG_DashboardPage(driver).clickMyListTab();
        new GG_MylistPage(driver).goToClippedDealsTab();
        if (isElementDisplayed(dealsForYouPageElements.exploreDealsbtn, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.dealsTab);
            new GG_DealsPage(driver).goToForYouTab();
            scrollDownToItemYouMayLikeModule();
            scrollDownBySmallAmount();
            scrollDownForElement(dealsForYouPageElements.clipButton);
            new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.clipButton);

        } else {
            new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.dealsTab);
            new GG_DealsPage(driver).goToForYouTab();
        }
    }

    public void clipDealsFromItemsYouMayLike(int dealsCount) {
        scrollDownToItemYouMayLikeModule();
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.seeAllLinkBesideItemYouMayLikeModule);
        for (int i = 1; i <= dealsCount; i++) {
            scrollDownForElement(dealsForYouPageElements.clipButton);
            new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.clipButton);
        }
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.closeIconOnSaveYourFavoritesModuleDrawer);
    }

    public void clickMyRewardsBtn() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.myRewardsLink);
    }

    public void clipDealIfNotClipped() {
        if (!isElementDisplayed(dealsForYouPageElements.eligibleProductsButton, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.clipDeal);

        }
    }

    public void clickGotItOnWelcomeCardIfDisplayed() {
        if (isElementDisplayed(dealsForYouPageElements.gotItFirstDibsDeal, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.gotItFirstDibsDeal);
        }
    }


    public void clickOnMyRewardsLink() {

        dealsForYouPageElements.myRewardsLink.click();
        waitForLoaderToDisappear();
    }


    public void clickOnClippedDeals() {
        dealsForYouPageElements.clippedDealsLink.click();
        waitForLoaderToDisappear();
    }

    public void clickOnWeeklyAdLink() {
        dealsForYouPageElements.weeklyAdLink.click();
        waitForLoaderToDisappear();
    }

    public void clickBackButtonOnWeeklyAdsPage() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.backButtonOnWeeklyAdsPage);
    }

    public boolean isDealDetailPageIsDisplayed() {
        return isElementDisplayed(dealsForYouPageElements.offerTermsConditions);
    }


    public void clickOnClipDealInDealsDetailsPage() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.clipDealBtnDealsDetails);
    }

    public void clickDealWithEligibleProducts() throws InterruptedException {
        ELIGIBLE_PRODUCTS:
        for (int scrollCounter = 0; scrollCounter < 30; scrollCounter++) {
            List<MobileElement> dealList = dealsForYouPageElements.dealNameList;
            for (MobileElement ele : dealList) {
                try {
                    new TapAction(driver).tapCoordinate(ele.getCenter().getX(), ele.getCenter().getY());
                    if (isElementDisplayed(dealsForYouPageElements.QualifyingProducts, 1)) {
                        break ELIGIBLE_PRODUCTS;
                    }
                    if (isElementDisplayed(dealsForYouPageElements.closeOfferDetailsPage, 1)) {
                        new CommonActions(driver).new ClickAction().clickElement(dealsForYouPageElements.closeOfferDetailsPage);
                    }
                } catch (StaleElementReferenceException se) {
                    // Element not present in DOM anymore, moving on..
                }
            }
            scrollDown();
        }
    }

    public boolean isEarnPointsIsDisplayed() throws InterruptedException {
        waitForLoaderToDisappear();
        waitForLoadingComplete();
        Thread.sleep(5000);

        String Expected = "Earning points";
        String actual = dealsForYouPageElements.earningPoints.getText();
        System.out.println("==============" + actual + "==================");

        return isElementDisplayed(dealsForYouPageElements.earningPoints);
    }

    public void clickOnTapOnHowDoRewardsWorkButton() {
        scrollDownForElement(myRewardsPageElements.gasRewardsLink);
        dealsForYouPageElements.howDoRewardsWork.click();
        waitForLoaderToDisappear();
    }


}


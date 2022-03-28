package com.automation.steps;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.models.ApiResponse;
import com.automation.pages.GG_APIValidationPage;
import com.automation.pages.GG_MylistPage;
import com.automation.pages.GG_ShoppingModePage;
import com.automation.rest.auth.AccessToken;
import com.automation.rest.cache.CommonCache;
import com.automation.rest.lists.ListsService;
import com.automation.rest.miscs.MiscsService;
import com.automation.rest.offers.OffersService;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GG_APIValidationSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_APIValidationPage apiValidationPage = new GG_APIValidationPage(driver);
    public GG_MylistPage GGMylistPage = new GG_MylistPage(driver);
    Map<String, String> bannerProperties;

    @Then("^get user token$")
    public void getAccessToken() throws IOException {
        String userName = CommonCache.commonCache.get("USERNAME_CART_API");
        String password = CommonCache.commonCache.get("PASSWORD_CART_API");
        AccessToken accessToken = new AccessToken(userName, password);
        accessToken.getAccessToken();
/*        LoginService service = new LoginService(driver);
        service.getAccessToken();*/
//      UCAService ucaService = new UCAService(driver);
//      ucaService.getUCAProfile();
    }

    @Then("^get all offers$")
    public void getOffers() throws IOException {
        OffersService service = new OffersService(driver);
        String storeID = ThreadLocalHelper.testCaseData.get().get("STORE_ID_FETCHED");
        service.getAllOffers(storeID);
    }

    @Then("^verify deal card details are same in API & App$")
    public void verifyDealCardDetailsAreSameInAPIApp() {
        String[] dealCardDetailsFromApp = apiValidationPage.getDealCardDetailsFromApp();
        List<ApiResponse.AllOffers.Offer> allOffersAPI = (List<ApiResponse.AllOffers.Offer>) CommonCache.allDealsInAPI.get("allDeals");
        ApiResponse.AllOffers.Offer desiredOffer = apiValidationPage.getOfferDetails(allOffersAPI, dealCardDetailsFromApp[0], dealCardDetailsFromApp[1]);
        Assert.assertEquals(dealCardDetailsFromApp[1], desiredOffer.offerPrice, "The offer price is mismatched");
        Assert.assertEquals(dealCardDetailsFromApp[2], desiredOffer.brand, "The brand value doesn't match");
        Assert.assertEquals(dealCardDetailsFromApp[3].contains(desiredOffer.endDate), true, "Mismatch in expiry date");
    }

    @Then("^verify count of saving events are same in API & App$")
    public void verifyCountOfSavingEventsAreSameInAPIApp() throws InterruptedException {
        String savingEventsCountFromAPP = apiValidationPage.getSavingEventsCountFromAPP();
        String savingEventsCountFromAPI = apiValidationPage.getSavingEventsCountFromAPI();
        Assert.assertEquals(savingEventsCountFromAPP, savingEventsCountFromAPI);
    }

    @Then("^verify count of deals applicable for each saving events are same in API & App$")
    public void verifyCountOfDealsApplicableForEachSavingEventsAreSameInAPIApp() {
        String savingEventDealCountFromApp = apiValidationPage.getCountOfDealsApplicableForFirstSavingEventFromApp();
        String savingEventDealCountFromAPI = apiValidationPage.getCountOfDealsApplicableForFirstSavingEventFromAPI();
        Assert.assertEquals(savingEventDealCountFromApp, savingEventDealCountFromAPI);
    }

    @Then("^verify deals are ordered based on purchase ranking in Save on our brands section$")
    public void verifyDealsAreOrderedBasedOnPurchaseRankingInSaveOnOurBrandsSection() {
        Assert.assertEquals(apiValidationPage.getDealCardDetailsBasedOnPurchaseRankFromAPI("SAVEONOURBRANDS"), apiValidationPage.getDealCardDescriptionFromApp());
    }

    @Then("^verify deals are ordered based on purchase ranking in All Deals Section$")
    public void verifyDealsAreOrderedBasedOnPurchaseRankingInAllDealsSection() {
        Assert.assertEquals(apiValidationPage.getDealCardDetailsBasedOnPurchaseRankFromAPI("ALLDEALS"), apiValidationPage.getDealCardDescriptionFromApp());
    }

    @Then("^verify deals are ordered based on purchase ranking in category details page$")
    public void verifyDealsAreOrderedBasedOnPurchaseRankingInCategoryDetailsPage() {
        Assert.assertEquals(apiValidationPage.getDealCardDetailsBasedOnPurchaseRankFromAPI("CATEGORY"), apiValidationPage.getDealCardDescriptionFromApp());
    }

    @Then("^verify deals are ordered based on purchase ranking in Associate offer module$")
    public void verifyDealsAreOrderedBasedOnPurchaseRankingInAssociateOfferModule() {
        Assert.assertEquals(apiValidationPage.getDealCardDetailsBasedOnPurchaseRankFromAPI("ASSOCIATEOFFERS"), apiValidationPage.getDealCardDescriptionFromApp());
    }

    @Then("^verify deals are ordered based on purchase ranking in item you may like module$")
    public void verifyDealsAreOrderedBasedOnPurchaseRankingInItemYouMayLikeModule() {
        Assert.assertEquals(apiValidationPage.getDealCardDetailsBasedOnPurchaseRankFromAPI("ITEMSYOUMAYLIKE"), apiValidationPage.getDealCardDescriptionFromApp());
    }

    @Then("^verify deals are ordered based on purchase ranking in item you may buy module$")
    public void verifyDealsAreOrderedBasedOnPurchaseRankingInItemYouMayBuyModule() {
        Assert.assertEquals(apiValidationPage.getDealCardDetailsBasedOnPurchaseRankFromAPI("ITEMSYOUMAYBUY"), apiValidationPage.getDealCardDescriptionFromApp());
    }

    @Then("^verify saving event card are ordered based on purchase ranking in saving events section$")
    public void verifySavingEventCardAreOrderedBasedOnPurchaseRankingInSavingEventsSection() {
        Assert.assertEquals(apiValidationPage.getSavingEventCardSortingFromAPI(), apiValidationPage.getSavingEventDescriptionFromApp());
    }

    @Then("^verify deals are ordered based on purchase ranking in saving events module$")
    public void verifyDealsAreOrderedBasedOnPurchaseRankingInSavingEventsModule() {
        Assert.assertEquals(apiValidationPage.getSavingEventCardDealsSortingFromAPI(), apiValidationPage.getDealCardDescriptionFromApp());
    }

    @And("^get the store id for delivery$")
    public void getTheStoreIdForDelivery() throws IOException {
        OffersService service = new OffersService(GGMylistPage.getCurrentBanner());
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIP_DELIVERY_API");
        String deliveryMode = ThreadLocalHelper.testCaseData.get().get("DELIVERY_PREF_API");
        String bannerName = ThreadLocalHelper.testCaseData.get().get("BANNER_API");

        String userName = CommonCache.commonCache.get("USERNAME_CART_API");
        String password = CommonCache.commonCache.get("PASSWORD_CART_API");
        ThreadLocalHelper.testCaseData.get().put("STORE_ID_FETCHED", service.getStoreDetails(userName, password, deliveryMode, zipCode, bannerName).storeId);

    }

    @And("^get the store id for pickup$")
    public void getTheStoreIdForPickup() throws IOException {
        OffersService service = new OffersService(driver);
        String zipCode = ThreadLocalHelper.testCaseData.get().get("ZIP_PICKUP_API");
        String deliveryMode = ThreadLocalHelper.testCaseData.get().get("PICKUP_PREF_API");
        String bannerName = ThreadLocalHelper.testCaseData.get().get("BANNER_API");
        ThreadLocalHelper.testCaseData.get().put("STORE_ID_FETCHED", service.getStoreDetails(deliveryMode, zipCode, bannerName).storeId);
        ThreadLocalHelper.testCaseData.get().put("STORE_ADDRESS_FETCHED", service.getStoreDetails(deliveryMode, zipCode, bannerName).address.line1);
    }

    @And("^select the store for testing \"([^\"]*)\" module$")
    public void selectTheStoreForTestingModule(String desiredModuleName) throws InterruptedException {
        GG_ShoppingModePage gg_shoppingModePage = new GG_ShoppingModePage(driver);
        String zipCode;
        switch (desiredModuleName.toUpperCase()) {
            case "API_PICKUP":
                zipCode = ThreadLocalHelper.testCaseData.get().get("ZIP_PICKUP_API");
                String storeName = ThreadLocalHelper.testCaseData.get().get("STORE_ADDRESS_FETCHED");
                gg_shoppingModePage.changePickupStore(zipCode, storeName);
                break;
            case "API_DELIVERY":
                zipCode = ThreadLocalHelper.testCaseData.get().get("ZIP_DELIVERY_API");
                gg_shoppingModePage.changeDeliveryZipCode(zipCode);
                break;
        }
    }

    @And("get MyList items")
    public void getMyListItems() {
        ListsService listService = new ListsService(driver);
        String storeID = ThreadLocalHelper.testCaseData.get().get("STORE_ID_FETCHED");
        listService.getMyList(storeID);
    }

    @And("trigger feature flag API")
    public void triggerFeatureFlagAPI() {
        MiscsService miscService = new MiscsService(driver);
        String storeID = ThreadLocalHelper.testCaseData.get().get("STORE_ID_FETCHED");
        String bannerName = ThreadLocalHelper.testCaseData.get().get("BANNER_API");
        String platformName;
        if (driver.getPlatformName().equalsIgnoreCase("iOS")) {
            platformName = "iPhone";
        } else {
            platformName = "android";
        }
        miscService.getNimbusFeatureAPI(storeID, platformName, bannerName);
    }

    @Then("verify 'Store Aisle' tab when feature flag 'sa' returns true")
    public void verifyStoreAisleTabWhenFeatureFlagSaReturnsTrue() {
        Assert.assertEquals(GGMylistPage.isStoreAisleTabDisplayed(), apiValidationPage.getStoreAisleFeatureFlagStatus());
    }
}

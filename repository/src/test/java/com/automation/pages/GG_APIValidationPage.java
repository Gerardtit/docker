package com.automation.pages;

import com.automation.mobile.models.ApiResponse;
import com.automation.pageElements.GG_DashboardPageElements;
import com.automation.pageElements.GG_Deals_ForYouPageElements;
import com.automation.rest.cache.CommonCache;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

public class GG_APIValidationPage extends BasePage {

    private final GG_DashboardPageElements dashboardPageElements = new GG_DashboardPageElements();
    private final GG_Deals_ForYouPageElements dealsForYouPageElements = new GG_Deals_ForYouPageElements();


    public GG_APIValidationPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dashboardPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dealsForYouPageElements);
    }

    public String[] getDealCardDetailsFromApp() {
        return new String[]{dashboardPageElements.dealDescription.getText(), dashboardPageElements.dealPrice.getText(), dashboardPageElements.dealName.getText(), dashboardPageElements.dealExpiry.getText()};
    }

    public String[] getDealCardDescriptionFromApp() {
        int size = dashboardPageElements.dealDescriptionList.size();
        if (size >= 2) {
            return new String[]{dashboardPageElements.dealDescriptionList.get(0).getText(), dashboardPageElements.dealDescriptionList.get(1).getText()};
        } else {
            return new String[]{dashboardPageElements.dealDescriptionList.get(0).getText()};
        }
    }

    public String[] getDealCardDetailsFromAPI() {
        int numberOfOffers = CommonCache.offerCache.get("ecommOffer").length();
        String dealDescriptionInAPI = "";
        String dealPriceInAPI = "";
        String dealNameInAPI = "";
        String dealExpiryDateConverted = "";

        for (int i = 1; i < numberOfOffers; i++) {
            String event = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getJSONObject("hierarchies").getJSONArray("events").toString();
            if (event.equalsIgnoreCase("[\"Exclusive Brands\"]")) {
                dealDescriptionInAPI = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getString("description");
                dealPriceInAPI = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getString("offerPrice");
                dealNameInAPI = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getString("brand");
                Long dealExpiryDateInAPI = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getLong("endDate");
                Timestamp ts = new Timestamp(dealExpiryDateInAPI);
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                dealExpiryDateConverted = "Expires " + dateFormat.format(ts);
                break;
            }
        }
        return new String[]{dealDescriptionInAPI, dealPriceInAPI, dealNameInAPI, dealExpiryDateConverted};
    }

    public String getSavingEventsCountFromAPI() {
        int numberOfOffers = CommonCache.offerCache.get("ecommOffer").length();
        HashSet<String> numberOfEvents = new HashSet();
        for (int i = 1; i < numberOfOffers; i++) {
            String event = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getJSONObject("hierarchies").getJSONArray("events").toString();
            if ((!event.equalsIgnoreCase("[]"))) {
                if (!event.equalsIgnoreCase("[\"Exclusive Brands\"]")) {
                    if (!event.equalsIgnoreCase("[\"Weekly Ad Coupons\"]")) {
                        String eventName = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getJSONObject("hierarchies").getJSONArray("events").toString();
                        numberOfEvents.add(eventName);
                    }
                }
            }
        }
        return Integer.toString(numberOfEvents.size());
    }

    public String getSavingEventsCountFromAPP() {
        Character savingEventCount = dealsForYouPageElements.totalCountOnSavingEventDrawer.getText().charAt(0);
        return savingEventCount.toString();
    }

    public String getCountOfDealsApplicableForFirstSavingEventFromAPI() {
        int numberOfOffers = CommonCache.offerCache.get("ecommOffer").length();
        TreeMap<String, Integer> eventDealCount = new TreeMap<>();
        for (int i = 1; i < numberOfOffers; i++) {
            String event = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getJSONObject("hierarchies").getJSONArray("events").toString();
            if ((!event.equalsIgnoreCase("[]"))) {
                if (!event.equalsIgnoreCase("[\"Exclusive Brands\"]")) {
                    if (!event.equalsIgnoreCase("[\"Weekly Ad Coupons\"]")) {
                        String eventName = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getJSONObject("hierarchies").getJSONArray("events").toString();
                        if (eventDealCount.containsKey(eventName)) {
                            eventDealCount.put(eventName, eventDealCount.get(eventName) + 1);
                        } else {
                            eventDealCount.put(eventName, 1);
                        }
                    }
                }
            }
        }
        return Integer.toString((Integer) eventDealCount.values().toArray()[0]);
    }

    public String getCountOfDealsApplicableForFirstSavingEventFromApp() {
        Character savingEventDealsCount = dealsForYouPageElements.dealCountOnSavingEventDrawer.getText().charAt(0);
        return savingEventDealsCount.toString();
    }

    public String[] getSavingEventDescriptionFromApp() {
        if (dealsForYouPageElements.savingEventCategoryTitleList.size() >= 2) {
            return new String[]{dealsForYouPageElements.savingEventCategoryTitleList.get(0).getText(), dealsForYouPageElements.savingEventCategoryTitleList.get(1).getText()};
        } else {
            return new String[]{dealsForYouPageElements.savingEventCategoryTitleList.get(0).getText()};
        }
    }

    public String[] getDealCardDetailsBasedOnPurchaseRankFromAPI(String sectionName) {
        int numberOfOffers = CommonCache.offerCache.get("ecommOffer").length();
        String dealDescriptionInAPI = "";
        String dealPurchaseRankInAPI = "";
        TreeMap<String, String> dealCard = new TreeMap<>();

        switch (sectionName) {
            case "CATEGORY":
                for (int i = 1; i < numberOfOffers; i++) {
                    String category = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getString("category");
                    if (category.equalsIgnoreCase("Baby Care")) {
                        dealDescriptionInAPI = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getString("description");
                        dealPurchaseRankInAPI = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getString("purchaseRank");
                        dealCard.put(dealPurchaseRankInAPI, dealDescriptionInAPI);
                    }
                }
                break;
            case "ITEMSYOUMAYBUY":
                for (int i = 1; i < numberOfOffers; i++) {
                    String category = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getString("purchaseInd");
                    if (category.equalsIgnoreCase("B")) {
                        dealDescriptionInAPI = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getString("description");
                        dealPurchaseRankInAPI = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getString("purchaseRank");
                        dealCard.put(dealPurchaseRankInAPI, dealDescriptionInAPI);
                    }
                }
                break;
            case "ITEMSYOUMAYLIKE":
                for (int i = 1; i < numberOfOffers; i++) {
                    String category = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getString("purchaseInd");
                    if (!category.equalsIgnoreCase("B")) {
                        dealDescriptionInAPI = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getString("description");
                        dealPurchaseRankInAPI = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getString("purchaseRank");
                        dealCard.put(dealPurchaseRankInAPI, dealDescriptionInAPI);
                    }
                }
                break;
            case "ASSOCIATEOFFERS":
                for (int i = 1; i < numberOfOffers; i++) {
                    String event = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getJSONObject("hierarchies").getJSONArray("events").toString();
                    if (event.equalsIgnoreCase("[\"Associate offers\"]")) {
                        dealDescriptionInAPI = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getString("description");
                        dealPurchaseRankInAPI = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getString("purchaseRank");
                        dealCard.put(dealPurchaseRankInAPI, dealDescriptionInAPI);
                    }
                }
                break;
            case "SAVEONOURBRANDS":
                for (int i = 1; i < numberOfOffers; i++) {
                    String event = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getJSONObject("hierarchies").getJSONArray("events").toString();
                    if (event.equalsIgnoreCase("[\"Exclusive Brands\"]")) {
                        dealDescriptionInAPI = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getString("description");
                        dealPurchaseRankInAPI = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getString("purchaseRank");
                        dealCard.put(dealPurchaseRankInAPI, dealDescriptionInAPI);
                    }
                }
                break;
            case "ALLDEALS":
                for (int i = 1; i < numberOfOffers; i++) {
                    String clipStatus = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getString("status");
                    if (clipStatus.equalsIgnoreCase("U")) {
                        dealDescriptionInAPI = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getString("description");
                        dealPurchaseRankInAPI = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getString("purchaseRank");
                        dealCard.put(dealPurchaseRankInAPI, dealDescriptionInAPI);
                    }
                }
                break;
        }
        String[] dealDescription = dealCard.values().toArray(new String[0]);
        int i = dealDescription.length;
        if (i >= 2) {
            return new String[]{dealDescription[0], dealDescription[1]};
        } else {
            return new String[]{dealDescription[0]};
        }
    }

    public ApiResponse.AllOffers.Offer getOfferDetails(List<ApiResponse.AllOffers.Offer> allOffersAPI, String offerDescription, String offerPrice) {
        ApiResponse.AllOffers.Offer desiredOffer = null;
        //Filter the date based on description and offer price
        for (ApiResponse.AllOffers.Offer indOffer : allOffersAPI) {
            String expiryDateFromAPI = null;
            expiryDateFromAPI = "" + new SimpleDateFormat("MM/dd/yyyy").format(new Date(Long.parseLong(indOffer.endDate)));
            if (indOffer.description.equals(offerDescription) && indOffer.offerPrice.equals(offerPrice)) {
                desiredOffer = indOffer;
                desiredOffer.endDate = expiryDateFromAPI;
                break;
            }
        }
        return desiredOffer;
    }


    public String[] getSavingEventCardSortingFromAPI() {
        int numberOfOffers = CommonCache.offerCache.get("ecommOffer").length();
        TreeSet<String> sortedSavingEventInAPI = new TreeSet<>();
        for (int i = 1; i < numberOfOffers; i++) {
            String event = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getJSONObject("hierarchies").getJSONArray("events").toString();
            if (!event.equalsIgnoreCase("[]")) {
                if (!event.equalsIgnoreCase("[\"Exclusive Brands\"]")) {
                    String savingEventBeforeFilterInAPI = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getJSONObject("hierarchies").getJSONArray("events").toString();
                    String savingEventInAPI = savingEventBeforeFilterInAPI.replaceAll("\"", "").replaceAll("\\[", "").replaceAll("\\]", "");
                    sortedSavingEventInAPI.add(savingEventInAPI);
                }
            }
        }
        int i = sortedSavingEventInAPI.size();
        if (i >= 2) {
            return new String[]{(String) sortedSavingEventInAPI.toArray()[0], (String) sortedSavingEventInAPI.toArray()[1]};
        } else {
            return new String[]{(String) sortedSavingEventInAPI.toArray()[0]};
        }
    }

    public String[] getSavingEventCardDealsSortingFromAPI() {
        int numberOfOffers = CommonCache.offerCache.get("ecommOffer").length();
        String dealDescriptionInAPI = "";
        String dealPurchaseRankInAPI = "";
        TreeMap<String, String> dealCard = new TreeMap<>();
        String firstSavingEvent = getSavingEventCardSortingFromAPI()[0];
        for (int i = 1; i < numberOfOffers; i++) {
            String event = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getJSONObject("hierarchies").getJSONArray("events").toString();
            String eventNameAfterFilter = event.replaceAll("\"", "").replaceAll("\\[", "").replaceAll("\\]", "");
            if (eventNameAfterFilter.equalsIgnoreCase(firstSavingEvent)) {
                dealDescriptionInAPI = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getString("description");
                dealPurchaseRankInAPI = CommonCache.offerCache.get("ecommOffer").getJSONObject(i).getString("purchaseRank");
                dealCard.put(dealPurchaseRankInAPI, dealDescriptionInAPI);
            }
        }
        String[] dealDescription = dealCard.values().toArray(new String[0]);
        int i = dealDescription.length;
        if (i >= 2) {
            return new String[]{dealDescription[0], dealDescription[1]};
        } else {
            return new String[]{dealDescription[0]};
        }
    }

    public String getStoreAisleFeatureFlagStatus() {
        String status = CommonCache.miscCache.get("featureFlag").getJSONObject("features").getString("sa");
        return status;
    }
}

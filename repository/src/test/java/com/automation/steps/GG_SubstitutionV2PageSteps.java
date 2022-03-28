package com.automation.steps;

import com.automation.helpers.LoaderUtil;
import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_CartPage;
import com.automation.pages.GG_DashboardPage;
import com.automation.pages.GG_SubstitutionV2Page;
import com.automation.rest.cache.CommonCache;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class GG_SubstitutionV2PageSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_SubstitutionV2Page gg_substitutionV2Page = new GG_SubstitutionV2Page(driver);
    public GG_CartPage gg_cartPage = new GG_CartPage(driver);
    public GG_DashboardPage dashboardPage = new GG_DashboardPage(driver);

    @Then("verify substitutions buttons in search substitution page")
    public void verifySubstitutionsButtons() {
        Assert.assertTrue(gg_substitutionV2Page.verifySubstitutionsButtons(), "Confirm substitution and Do not substitute does not appears");
    }

    @Then("validate 1 equals 1")
    public void verifyDummy() {
        Assert.assertTrue(true, "Dummy condition");
    }

    @Then("verify substitution preferences sheet in cart screen")
    public void verifyNonSNAPEligibleItemsSheet() {
        Map<String, Object> subPreferencesElementsMap = gg_substitutionV2Page.getElementsPresenceOrTextInNonSnapEligibleItemsSheet();
        Assert.assertTrue(((String) subPreferencesElementsMap.get("SUB_PREFERENCES_SHEET_HEADER_TEXT")).contentEquals("Substitution preferences"), "Title is not correct in Substitution preferences sheet!!");
        Assert.assertEquals((String) subPreferencesElementsMap.get("SUB_PREFERENCES_SHEET_SUB_HEADER_TEXT"), "If this item goes out of stock, we’ll substitute it with your selection.", "Sub title is not correct in Substitution preferences sheet!!");
        Assert.assertTrue((Boolean) subPreferencesElementsMap.get("SUB_PREFERENCES_SHEET_DONT_SUBSTITUTE"), "'Don't substitute' button is not displayed in Substitution preferences sheet!!");
        Assert.assertTrue((Boolean) subPreferencesElementsMap.get("SUB_PREFERENCES_SHEET_CLOSE"), "Close icon is not displayed in Substitution preferences sheet!!");
        Assert.assertTrue((Boolean) subPreferencesElementsMap.get("SUB_PREFERENCES_SHEET_OTHER_OPTIONS"), "'Other Options' button' is not displayed in Substitution preferences sheet!!");
        Assert.assertTrue((Boolean) subPreferencesElementsMap.get("SUB_PREFERENCES_SHEET_CONFIRM_SUBSTITUTION"), "'Confirm Substitution' button is not displayed in Substitution preferences sheet!!");
        Assert.assertTrue((Boolean) subPreferencesElementsMap.get("SUB_PREFERENCES_SHEET_SET_SUBSTITUTION_FOR_ALL"), "'Set substitutions for all' button is not displayed in Substitution preferences sheet!!");
    }

    @And("user clicks on other options CTA in substitution page")
    public void userClicksOtherOptionsCTA() {
        gg_substitutionV2Page.userClicksOtherOptionsCTA();
        LoaderUtil.waitForSubstitutionsLoaderToDisappear();
    }

    @And("user clicks on close in search substitution page")
    public void clicksCloseSearchSubstitutions() {
        gg_substitutionV2Page.clicksCloseSearchSubstitutions();
    }

    @And("user clicks on close in substitution page")
    public void clicksCloseSubstitutions() {
        gg_substitutionV2Page.clicksCloseSubstitutions();
    }

    @And("user selects first substitution option in search substitution page")
    public void selectFirstSubstitutionProductOption() {
        gg_substitutionV2Page.selectFirstSubstitutionProductOption();
        CommonCache.commonCache.put("SUBSTITUTION_PRODUCT_NAME", gg_substitutionV2Page.getTheSelectedProductFromSearchSubsPreference().substring(0, 20));
    }

    @And("user clicks on confirm substitution in substitution page")
    public void clickConfirmSubstitutions() {
        gg_substitutionV2Page.clickConfirmSubstitutions();
    }

    @And("user clicks on confirm substitutions in all substitutions preferences page")
    public void clickConfirmSubstitutionsAllSubPrefs() {
        gg_substitutionV2Page.clickConfirmSubstitutionsAllSubPrefs();
    }

    @And("user clicks on confirm substitution in search substitution page")
    public void clickConfirmSearchSubstitutions() {
        gg_substitutionV2Page.clickConfirmSearchSubstitutions();
    }

    @And("select option {string} in search substitution page")
    public void selectOptionByNumberSearchSubstitutions(String option) {
        gg_substitutionV2Page.selectOptionByNumberSearchSubstitutions(option);
    }

    @And("click on substitution button")
    public void clickOnSubstututionButton() {
        gg_substitutionV2Page.clickOnSubstututionButton();
        LoaderUtil.waitForSubstitutionsLoaderToDisappear();
    }

    @Then("verify Substitution Preferences title is displayed")
    public void verifySubstitutionPreferencesTitle() {
        Assert.assertTrue(gg_substitutionV2Page.getTextOfSubstitutionPreferencesTitle().equals("Substitution preferences"), "Substitution Preferences title is not displayed");
    }

    @Then("verify product has substitutions in substitution page")
    public void verifyCarouselListDisplayed() throws InterruptedException {
        Assert.assertTrue(gg_substitutionV2Page.verifyCarouselListDisplayed(), "Carousel list products in substitution preferences is not displayed");
    }

    @Then("verify if the product name in substitution preferences are equal to the one chosen in the cart screen")
    public void verifyProductInSubstitutionPreferencesEqualToProductInCartScreen() {
        String productNameInSubsPref = gg_substitutionV2Page.getNamesOfProductInSubstitutionPreferences().get(0);
        gg_substitutionV2Page.closeSubstitutionPreferncesSearchScreen();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            gg_substitutionV2Page.closeSubstitutionPreferenceSheet();
        }
        String productNameInCart = gg_cartPage.getProductsName().get(0);
        Assert.assertTrue(productNameInSubsPref.contains(productNameInCart), "product name and image in substitution preferences are not equal to the one chosen in the Cart Screen ");
    }

    @Then("verify if several products names in substitution preferences are equal to the one chosen in the cart screen")
    public void verifyProductsInSubstitutionPreferencesEqualToProductsInCartScreen() {
        String eggsProductNameInSubsPref = gg_substitutionV2Page.getNamesOfProductInSubstitutionPreferences().get(0);
        String milkProductNameInSubsPref = gg_substitutionV2Page.getNamesOfProductInSubstitutionPreferences().get(1);
        gg_substitutionV2Page.closeSubstitutionPreferncesSearchScreen();
        gg_substitutionV2Page.closeSubstitutionPreferenceSheet();
        String eggsProductNameInCart = gg_cartPage.getProductsName().get(0);
        String milkProductNameInCart = gg_cartPage.getProductsName().get(1);
        Assert.assertTrue(eggsProductNameInSubsPref.contains(eggsProductNameInCart) && milkProductNameInSubsPref.contains(milkProductNameInCart), "product name and image in substitution preferences are not equal to the one chosen in the Cart Screen ");
    }

    @Then("click on other options")
    public void clickOnOtherOptions() {
        gg_substitutionV2Page.clickOnOtherOptions();
        LoaderUtil.waitForSubstitutionsLoaderToDisappear();
    }

    @And("user clicks set substitutions for all in substitution page")
    public void clickSetSubstitutionsForAll() {
        gg_substitutionV2Page.clickSetSubstitutionsForAll();
    }

    @And("user clicks on do not substitute for all in all substitutions preferences page")
    public void clickDoNotSubstituteForAll() {
        gg_substitutionV2Page.clickDoNotSubstituteForAll();
    }

    @Then("verify product name of selected substitution product in substitution page")
    public void verifyProductNameSelectedProduct() {
        Assert.assertEquals(gg_substitutionV2Page.getSelectedProductText(), ThreadLocalHelper.testCaseData.get().get("SUBSTITUTION_PRODUCT_NAME"), "Selected product does not match the previously selected one!");
    }

    @Then("verify substitute selected in search screen without confirmation in All substitutions preferences screen is not selected")
    public void verifySubNotSelected() {
        Assert.assertNotEquals(gg_substitutionV2Page.getSelectedProductText(), ThreadLocalHelper.testCaseData.get().get("SUBSTITUTION_PRODUCT_NAME"), "Substitute was selected even though substitutions were not confirmed in All Sub Preferences scrren!");
    }

    @Then("verify do not substitute checkbox is checked for all products in each product")
    public void verifyDoNotSubstituteCheckedForAllProducts() {
        Assert.assertTrue(gg_substitutionV2Page.allDoNotSubstituteCheckboxChecked(), "All do not substitutions checkboxes are not checked!");
    }

    @Then("verify loading spinner is displayed loading carousel substitution page")
    public void verifyLoadingSpinnerDisplayed() {
        Assert.assertTrue(gg_substitutionV2Page.verifyLoadingSpinnerDisplayed(), "Spinner does not appear leaving substitutions page!");
    }

    @Then("select Dont Substitute on substitution preferences and confirms substitution")
    public void selectDontSubstituteOnSubstitutionPreferncesAndConfirmsSubsitution() {
        gg_substitutionV2Page.selectDontSubstituteInPreferences();
        gg_substitutionV2Page.clickConfirmSubstitutionBtn();
    }

    @And("user selects a product from substitution carousel in substitution preferences sheet")
    public void selectProductFromSubCarousel() {
        gg_substitutionV2Page.selectProductFromSubstitutionCarousel();
        CommonCache.commonCache.put("SUBSTITUTION_PRODUCT_NAME_PREFERENCES", gg_substitutionV2Page.getSelectedProductDescriptionFromCarousel());
    }

    @And("user clicks on don't substitute radio button in substitution preferences sheet")
    public void clickDontSubstitute() {
        gg_substitutionV2Page.clickDontSubstitute();
        CommonCache.commonCache.put("SUBSTITUTION_PRODUCT_NAME_PREFERENCES", "Do Not Substitute");
    }

    @Then("verify user is displayed with previously selected substitution preference")
    public void verifyUserSeesPreviousSelectedPreference() {
        String prodNameInPrefScreenInitial = CommonCache.commonCache.get("SUBSTITUTION_PRODUCT_NAME_PREFERENCES");
        String proNameOnPrefScreen = gg_substitutionV2Page.getCurrentDisplayedProductDescription();
        //Using the below append with or as sometimes the list index gets appended in description
        Assert.assertEquals(prodNameInPrefScreenInitial.contains(proNameOnPrefScreen) || proNameOnPrefScreen.contains(prodNameInPrefScreenInitial), true, "Previously selected substitution preference is not displayed in substitution preferences sheet!! " + prodNameInPrefScreenInitial + " Actual " + proNameOnPrefScreen);

    }

    @Then("verify user is displayed with previously selected substitution preference in all substitutions preferences screen")
    public void verifyUserSeesPreviousSelectedPreferenceAllSubsPref() {
        String prodNameInPrefScreenInitial = CommonCache.commonCache.get("SUBSTITUTION_PRODUCT_NAME_PREFERENCES");
        String proNameOnPrefScreen = gg_substitutionV2Page.getCurrentDisplayedProductDescriptionAllSubsPrefs();
        //Using the below append with or as sometimes the list index gets appended in description
        Assert.assertEquals(prodNameInPrefScreenInitial.contains(proNameOnPrefScreen) || proNameOnPrefScreen.contains(prodNameInPrefScreenInitial), true, "Previously selected substitution preference is not displayed in substitution preferences sheet!! " + prodNameInPrefScreenInitial + " Actual " + proNameOnPrefScreen);

    }

    @And("user closes substitution preferences sheet")
    public void closeSubPrefSheet() {
        gg_substitutionV2Page.closeSubstitutionPreferenceSheet();
    }

    @And("user closes substitution preferences search screen")
    public void closeSubstitutionPreferncesSearchScreen() {
        gg_substitutionV2Page.closeSubstitutionPreferncesSearchScreen();
    }

    @Then("verify confirm substitution button is {string}")
    public void verifyConfirmSubBtnEnabledOrDisabled(String desiredState) {
        if (desiredState.equalsIgnoreCase("ENABLED")) {
            Assert.assertTrue(gg_substitutionV2Page.isConfirmSubstitutionButtonEnabled(), "Confirm substitution button is disabled!!");
        } else {
            Assert.assertFalse(gg_substitutionV2Page.isConfirmSubstitutionButtonEnabled(), "Confirm substitution button is enabled!!");
        }
    }

    @Then("verify search icon and message is displayed when there are no substitutions available")
    public void verifyEmptyIconMessage() {
        // Below validation is applicable for android only since the image is disabled in iOS
        if (driver.getPlatformName().equalsIgnoreCase("ANDROID")) {
            Assert.assertTrue(gg_substitutionV2Page.isEmptyIconDisplayedWhenNoSubAvailable(), "Search icon is not displayed when there are no substitutions available");
        }
        Assert.assertEquals(gg_substitutionV2Page.getMessageWhenNoSubAvailable().replace("\n", " "), "This item has no substitutions at this time. Do you want to search for alternatives?", "Incorrect message is displayed when there are no substitutions available");
    }

    @Then("verify user is displayed with previously selected search preference")
    public void verifyUserSeesPreviousSelectedSearchPreference() {
        String prodNameInPrefSearchScreen = CommonCache.commonCache.get("SUBSTITUTION_PRODUCT_NAME");
        String proNameOnPrefScreen = gg_substitutionV2Page.getCurrentDisplayedProductDescription();
        if (proNameOnPrefScreen.contains("..")) {
            //Handling truncated description
            Assert.assertEquals(proNameOnPrefScreen.split("-")[0].contains(prodNameInPrefSearchScreen), true, "Previously selected substitution preference is not displayed in search preferences !! Actual " + prodNameInPrefSearchScreen + " Expected " + proNameOnPrefScreen);
        } else {
            Assert.assertEquals(proNameOnPrefScreen.contains(prodNameInPrefSearchScreen), true, "Previously selected substitution preference is not displayed in search preferences !! Actual " + prodNameInPrefSearchScreen + " Expected " + proNameOnPrefScreen);
        }
    }

    @Then("verify user is displayed with previously selected search preference on search list")
    public void verifyUserSeesPreviousSelectedSearchPreferenceOnSearchPreferences() {
        String prodNameInPrefSearchScreen = CommonCache.commonCache.get("SUBSTITUTION_PRODUCT_NAME");
        String proNameOnPrefScreen = gg_substitutionV2Page.labelFirstSubstitutionProductOption();
        if (proNameOnPrefScreen.contains("..")) {
            //Handling truncated description
            Assert.assertEquals(proNameOnPrefScreen.split("-")[0].contains(prodNameInPrefSearchScreen), true, "Previously selected substitution preference is not displayed in search preferences !! " + prodNameInPrefSearchScreen + " Actual " + proNameOnPrefScreen);
        } else {
            Assert.assertEquals(proNameOnPrefScreen.contains(prodNameInPrefSearchScreen), true, "Previously selected substitution preference is not displayed in search preferences sheet!!");
        }
    }

    @And("search for the product {string} on search preferences page")
    public void searchForTheProductMilkOnSearchPreferencesPage(String subProdName) {
        gg_substitutionV2Page.searchForSubstitutesOnPreferences(subProdName);
    }

    @Then("verify the search bar of search for substitutes is displayed")
    public void verifySearchBarOfSearchForSubstitutesIsDisplayed() {
        Assert.assertTrue(gg_substitutionV2Page.isSearchBarOfSearchForSubstitutesIsDisplayed(), "Search bar is not displayed");
    }

    @Then("verify product {string} is selected in search substitution page")
    public void verifyProductIsSelectedSearchSubstitution(String option) {
        Assert.assertTrue(gg_substitutionV2Page.verifyProductIsSelectedSearchSubstitution(option), "Product is not selected in substitutions search preferences");
    }

    @And("search product {string} in the substitution search page in substitution preferences")
    public void searchForProductInSubsSearchPage(String productName) {
        dashboardPage.searchByProductName(productName);
    }

    @And("verify an item has no alternatives is displayed")
    public void verifyItemHasNoAlternativesIsDisplayed() {
        Assert.assertTrue(gg_substitutionV2Page.isHasNoALternativesDisplayed(), "Search bar is not displayed");
    }

    @Then("verify search icon and message is displayed when there are no substitutions available in search substitution page")
    public void verifyEmptyIconSearchMessage() {
        // Below validation is applicable for android only since the image is disabled in iOS
        if (driver.getPlatformName().equalsIgnoreCase("ANDROID")) {
            Assert.assertTrue(gg_substitutionV2Page.isEmptyIconDisplayedWhenNoSubAvailableSearch(), "Search icon is not displayed when there are no substitutions available in search substitution page");
        }
        Assert.assertEquals(gg_substitutionV2Page.getMessageWhenNoSubAvailableSearch().replace("\n", " "), "This item has no substitutions at this time. Do you want to search for alternatives?", "Incorrect message is displayed when there are no substitutions available");
    }

    @Then("verify no results for {string} were found message in search substitution page")
    public void verifyNoResultsWereFoundMessage(String searchText) {
        Assert.assertEquals(gg_substitutionV2Page.getMessageWhenNoResultSub().replace("\n", " "), "Sorry, no results were found for \"" + searchText + "\"", "Incorrect message is displayed when there are no search substitutions available");
        Assert.assertEquals(gg_substitutionV2Page.getTypoMessageWhenNoResultSub().replace("\n", " "), "Check for typos or try using more general keywords.", "Incorrect check typo message is displayed when there are no search substitutions available");
    }

    @And("user search product {string} in search substitution page")
    public void searchByProductNameSubstitutions(String productName) {
        gg_substitutionV2Page.searchByProductName(productName);
    }

    @And("user selects option {string} search list results in search substitution page")
    public void selectOptionInSearchList(String option) {
        gg_substitutionV2Page.selectOptionInSearchList(option);
    }

    @And("save carousel list in substitution page")
    public void saveCarouselListProducts() {
        gg_substitutionV2Page.saveCarouselListProducts();
    }

    @Then("verify if product list in carousel substitution preferences equal to list in search substitution")
    public void verifyProductListFromCarouselToSearchList() {
        Assert.assertTrue(gg_substitutionV2Page.verifyProductListFromCarouselToSearchList(), "List in search substitutions does not match the one from carousel!");
    }

    @Then("verify carousel list in edit cart is the same from cart")
    public void verifyCarouselListEditCart() {
        Assert.assertTrue(gg_substitutionV2Page.verifyCarouselListEditCart(), "List in search substitutions does not match the one from carousel in edit cart after placing an order!");
    }

    @And("click on search bar in search substitution page")
    public void clickSearchBar() {
        gg_substitutionV2Page.clickSearchBar();
    }

    @And("user search for product {string} without enter in search substitution page")
    public void searchProductWithoutEnter(String searchText) throws InterruptedException {
        gg_substitutionV2Page.searchProductWithoutEnter(searchText);
    }

    @And("user clicks cancel search in search substitution")
    public void clickCancelSearch() {
        gg_substitutionV2Page.clickCancelSearch();
    }

    @Then("verify autocomplete options appears in search substitution page")
    public void verifyAutocompleteOptionsAppears() {
        Assert.assertTrue(gg_substitutionV2Page.verifyAutocompleteOptionsAppears(), "List of autocomplete products does not appears after clicking on search bar in search substitutions !");
    }

    @Then("verify search list with {string} appears with categories in search substitution page")
    public void verifySearchListWithCategories(String searchText) {
        Assert.assertTrue(gg_substitutionV2Page.verifySearchListWithCategories(searchText), "List of search product is not correct in search substitutions !");
    }

    @Then("verify set substitutions for all CTA {string} displayed in substitution preferences sheet")
    public void verifySetSubsForAllBtn(String desiredState) {
        if (desiredState.contains("not")) {
            Assert.assertFalse(gg_substitutionV2Page.isSetSubsForAllCTADisplayed(), "'Set substitutions for all' CTA is displayed in substitution preferences sheet!");
        } else {
            Assert.assertTrue(gg_substitutionV2Page.isSetSubsForAllCTADisplayed(), "'Set substitutions for all' CTA is not displayed in substitution preferences sheet!");
        }
    }

    @Then("verify 'Confirm' CTA is displayed")
    public void verifyConfirmSubCTAText() {
        Assert.assertEquals(gg_substitutionV2Page.getConfirmSubCTAText(), "Confirm", "'Confirm' CTA is not displayed!");
    }

    @And("user clicks Substitution For All on substitution preferences page")
    public void userClicksSubstitutionForAllOnSubstitutionPreferencesPage() {
        gg_substitutionV2Page.userClickSetSubForAll();
        LoaderUtil.waitForSubstitutionsLoaderToDisappear();
    }

    @And("fetch all the product names from substitution preferences sheet")
    public void fetchAllTheProductNamesFromSubstitutionPreferencesSheet() {
        LoaderUtil.waitForSubstitutionsLoaderToDisappear();
        int productThresholdCnt = 5;
        if (CommonCache.cartItems.containsKey("cartProducts")) {
            productThresholdCnt = ((Set<String>) CommonCache.cartItems.get("cartProducts")).size();
        }
        CommonCache.cartItems.put("subsAllProductList", gg_substitutionV2Page.getProductNamesInAllSubPreferencesScreen(productThresholdCnt));
    }

    @Then("verify the products in cart is same as that in substitution for all preferences screen")
    public void verifyTheProductsInCartIsSameAsThatInSubstitutionForAllPreferencesScreen() {
        List<String> productNamesCart = new ArrayList((Set<String>) CommonCache.cartItems.get("cartProducts"));
        List<String> productNamesSubsAll = new ArrayList((Set<String>) CommonCache.cartItems.get("subsAllProductList"));
        SoftAssert productVerificationCart = new SoftAssert();
        productVerificationCart.assertTrue(productNamesSubsAll.containsAll(productNamesCart.stream().filter(indProductNames -> !indProductNames.contains("..")).collect(Collectors.toList())), "Check the contents ignoring the truncated items failed Actual " + productNamesCart + " Exp " + productNamesSubsAll);
        for (int cntVal = 0; cntVal < productNamesCart.size(); cntVal++) {
            productVerificationCart.assertEquals(productNamesCart.get(cntVal).split("\\s")[0], productNamesSubsAll.get(cntVal).split("\\s")[0], "Cart ordering is not same as the subs pref ordering");
        }
        productVerificationCart.assertAll();
    }

    @And("user clicks on close in search all substitution preferences page")
    public void clicksCloseAllSubstitutionsPref() {
        gg_substitutionV2Page.clicksCloseAllSubstitutionsPrefernces();

    }

    @Then("verify All substitutions preferences screen is displayed")
    public void verifyAllSubPrefsScreen() {
        Assert.assertTrue(gg_substitutionV2Page.isAllSubsPreferencesScreenDisplayed(), "All substitutions preferences screen is not displayed!!");
    }

    @And("user closes All substitutions preferences screen")
    public void closeAllSubPrefsScreen() {
        gg_substitutionV2Page.closeAllSubPrefsScreen();
    }

    @Then("verify Confirm substitutions CTA is displayed on All substitutions preferences screen")
    public void verifyConfirmSubsCTAOnAllSubPrefsScreen() {
        Assert.assertTrue(gg_substitutionV2Page.isConfirmSubsForAllCTADisplayed(), "Confirm substitutions CTA is not displayed on All substitutions preferences screen!!");
    }

    @Then("verify Don't substitute for all CTA is displayed on All substitutions preferences screen")
    public void verifyDontSubForAllCTAOnAllSubPrefsScreen() {
        Assert.assertTrue(gg_substitutionV2Page.isDontSubstituteForAllCTADisplayed(), "Don't substitute for all CTA is not displayed on All substitutions preferences screen");
    }

    @And("user selects first product from substitution carousel in substitution preferences sheet")
    public void selectFirstProductFromSubCarousel() {
        gg_substitutionV2Page.selectFirstProductFromSubstitutionCarousel();
        CommonCache.commonCache.put("SUBSTITUTION_PRODUCT_NAME_PREFERENCES", gg_substitutionV2Page.getFirstProductDescriptionFromCarouselInSubPreferences());
    }


    @And("user clicks and confirms don't substitute for first product in all substitutions preferences screen")
    public void clickDontSubstituteForFirstProductInAllSubPref() {
        gg_substitutionV2Page.clickDoNotSubstituteForFirstProductAllPreferences();
    }

    @Then("verify don't substitute radio button is set to {string} for product {int} in all substitutions preferences screen")
    public void verifyDontSubRadioBtnStatusAllSubPref(String desiredStatus, int desiredProduct) {
        if (desiredStatus.equalsIgnoreCase("ON")) {
            switch (driver.getPlatformName().toUpperCase()) {
                case "IOS":
                    Assert.assertTrue(gg_substitutionV2Page.getDontSubstituteRadioBtnStatusDesiredProductAllSubPref(desiredProduct - 1).contentEquals("XCUIElementTypeOther"), "Don't substitute radio button is set to OFF for first product in all substitutions preferences screen");
                    break;
                case "ANDROID":
                    Assert.assertTrue(gg_substitutionV2Page.getDontSubstituteRadioBtnStatusDesiredProductAllSubPref(desiredProduct - 1).contentEquals("true"), "Don't substitute radio button is set to OFF for first product in all substitutions preferences screen");
                    break;
            }
        } else {
            switch (driver.getPlatformName().toUpperCase()) {
                case "IOS":
                    Assert.assertTrue(gg_substitutionV2Page.getDontSubstituteRadioBtnStatusDesiredProductAllSubPref(desiredProduct - 1).contentEquals("XCUIElementTypeButton"), "Don't substitute radio button is set to ON for first product in all substitutions preferences screen");
                    break;
                case "ANDROID":
                    Assert.assertTrue(gg_substitutionV2Page.getDontSubstituteRadioBtnStatusDesiredProductAllSubPref(desiredProduct - 1).contentEquals("false"), "Don't substitute radio button is set to ON for first product in all substitutions preferences screen");
                    break;
            }
        }
    }

    @And("user clicks other options for first product in all substitutions preferences screen")
    public void userClicksOtherOptionsAllSubPrefs() {
        gg_substitutionV2Page.userClicksOtherOptionsCTA();
    }


    @And("user views the default selected item in substitute preferences carousel")
    public void userViewsTheDefaultSelectedItemInSubstitutePreferencesCarousel() {
        CommonCache.commonCache.put("SUBSTITUTION_PRODUCT_NAME_PREFERENCES", gg_substitutionV2Page.getFirstProductDescriptionFromCarouselInSubPreferences());
    }

    @And("user views the default selected item in search substitution page")
    public void userViewsTheDefaultSelectedItemInSubstituteSearchScreen() {
        CommonCache.commonCache.put("SUBSTITUTION_PRODUCT_NAME_SELECTED", gg_substitutionV2Page.getTheSelectedProductFromSearchSubsList());
    }

    @And("user searches for product {string} in search subs page and selects the first option from the list")
    public void userSearchesForProductInSearchSubsPageAndSelectsTheFirstOptionFromTheList(String searchProdName) {
        gg_substitutionV2Page.searchByProductName(searchProdName);
        gg_substitutionV2Page.selectOptionInSearchList("0");
        gg_substitutionV2Page.selectOptionByNumberSearchSubstitutions("0");
        Assert.assertTrue(gg_substitutionV2Page.verifyProductIsSelectedSearchSubstitution("0"), "Product is not selected in substitutions search preferences");
    }

    @Then("verify the product selected in search substitution screen is same as that chosen by the user during select option")
    public void verifyTheProductSelectedInSearchSubstitutionScreenIsSameAsThatChosenByTheUserDuringSelectOption() {
        String prodNameWhilePerformingSelectOptn = CommonCache.commonCache.get("SUBSTITUTION_PRODUCT_NAME");
        String prodNameWithSelectedTag = CommonCache.commonCache.get("SUBSTITUTION_PRODUCT_NAME_SELECTED");
        Assert.assertTrue(prodNameWithSelectedTag.contains(prodNameWhilePerformingSelectOptn), "The select option didn't work as expected Actual " + prodNameWhilePerformingSelectOptn + " Expected " + prodNameWithSelectedTag);
    }

    @And("wait for any of the substitution preferences to be auto selected")
    public void waitForAnyOfThePreferencesToBeAutoSelected() {
        gg_substitutionV2Page.waitForConfirmSubstitutionToBeDisplayedOnSubPrefs();
    }

    @Then("verify animation for substitution preferences {string} displayed")
    public void verifyAnimationForSubstitutionPreferencesIsDisplayed(String elemPresence) {
        boolean expPresence = elemPresence.contains("not") ? false : true;
        Assert.assertEquals(gg_substitutionV2Page.isAnimationDisplayedForSubsPreferences(), expPresence, "Subs Animation on preferences not displayed");
    }

    @Then("verify animation for set substitution for all {string} displayed")
    public void verifyAnimationForSetSubstitutionForAllIsDisplayed(String elemPresence) {
        boolean expPresence = elemPresence.contains("not") ? false : true;
        Assert.assertEquals(gg_substitutionV2Page.isAnimationDisplayedForSetSubsForAllPreferences(), expPresence, "Subs Animation on preferences not displayed");
    }

    @Then("verify only one substitute is selected in substitutions carousel in All substitutions preferences screen")
    public void verifyOnlyFirstSubSelected() {
        if (driver.getPlatformName().equalsIgnoreCase("ANDROID")) {
            gg_substitutionV2Page.scrollRightOnSubsCarousel();
            Assert.assertFalse(gg_substitutionV2Page.isLastSubstituteSelected(), "More than one substitute is selected in carousel in All substitutions preferences screen!!");
        }
    }

}

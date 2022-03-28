package com.automation.pages;

import com.automation.helpers.PageActions;
import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.TapAction;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_CartPageElements;
import com.automation.pageElements.GG_SubstitutionV2PageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class GG_SubstitutionV2Page extends BasePage {

    private GG_SubstitutionV2PageElements gg_substitutionV2PageElements = new GG_SubstitutionV2PageElements();
    private GG_CartPageElements gg_cartPageElements = new GG_CartPageElements();

    public GG_SubstitutionV2Page(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_substitutionV2PageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_cartPageElements);
    }

    public boolean verifySubstitutionsButtons() {
        if (isElementDisplayed(gg_substitutionV2PageElements.confirmSearchSubstitutionButton) && isElementDisplayed(gg_substitutionV2PageElements.confirmDoNotSubstituteButton)) {
            return true;
        }
        return false;
    }

    public boolean verifyCarouselListDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        return isElementDisplayed(gg_substitutionV2PageElements.substituteCardsSubstitutionCarousel.get(0), 5);
    }

    public void clickOnSubstututionButton() {
        isElementDisplayed(gg_substitutionV2PageElements.substututionButton.get(0), 7);
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.substututionButton.get(0));
    }

    //gets the names of the products in a list in the substitution preferences
    public List<String> getNamesOfProductInSubstitutionPreferences() {
        List<String> listOfProducts = new ArrayList<String>();
        int productNamesList = gg_substitutionV2PageElements.productName.size();
        int counter = gg_substitutionV2PageElements.productName.size();
        String element = "";
        for (int i = 0; i < productNamesList; i++) {
            switch (driver.getPlatformName().toUpperCase()) {
                case "ANDROID":
                    element = gg_substitutionV2PageElements.productName.get(productNamesList - counter).getAttribute("text");
                    break;
                case "IOS":
                    element = gg_substitutionV2PageElements.productName.get(productNamesList - counter).getText();
                    break;
            }
            listOfProducts.add(element);
            counter--;
        }
        return listOfProducts;
    }

    public String getTextOfSubstitutionPreferencesTitle() {
        new WaitAction(driver).waitForDisplayed(gg_substitutionV2PageElements.substitutionPreferencesTitle);
        String substitutionPreferencesTitle = "";
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                substitutionPreferencesTitle = gg_substitutionV2PageElements.substitutionPreferencesTitle.getText();
                break;
            case "ANDROID":
                substitutionPreferencesTitle = gg_substitutionV2PageElements.substitutionPreferencesTitle.getAttribute("text");
                break;
        }
        return substitutionPreferencesTitle;
    }

    public void clickOnOtherOptions() {
        new WaitAction(driver).waitForDisplayed(gg_substitutionV2PageElements.substitutionPreferencesOtherOptions);
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.substitutionPreferencesOtherOptions);
    }

    public void clickSetSubstitutionForAllBtn() {
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.substitutionPreferencesOtherOptions);
    }

    public void closeSubstitutionPreferncesSearchScreen() {
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.substitutionPreferencesClose);
    }

    public Map<String, Object> getElementsPresenceOrTextInNonSnapEligibleItemsSheet() {
        Map<String, Object> elementsMap = new HashMap<>();
        elementsMap.put("SUB_PREFERENCES_SHEET_HEADER_TEXT", getText(gg_substitutionV2PageElements.substitutionPreferencesTitle).trim());
        elementsMap.put("SUB_PREFERENCES_SHEET_SUB_HEADER_TEXT", getText(gg_substitutionV2PageElements.substitutionPreferencesSubTitle).trim());
        elementsMap.put("SUB_PREFERENCES_SHEET_DONT_SUBSTITUTE", isElementDisplayed(gg_substitutionV2PageElements.substitutionPreferencesDontSubstitute));
        elementsMap.put("SUB_PREFERENCES_SHEET_CLOSE", isElementDisplayed(gg_substitutionV2PageElements.substitutionPreferencesClose));
        elementsMap.put("SUB_PREFERENCES_SHEET_OTHER_OPTIONS", isElementDisplayed(gg_substitutionV2PageElements.substitutionPreferencesOtherOptions));
        elementsMap.put("SUB_PREFERENCES_SHEET_CONFIRM_SUBSTITUTION", isElementDisplayed(gg_substitutionV2PageElements.confirmSubstitutionButton));
        elementsMap.put("SUB_PREFERENCES_SHEET_SET_SUBSTITUTION_FOR_ALL", isElementDisplayed(gg_substitutionV2PageElements.substitutionPreferencesSetSubForAll));
        return elementsMap;
    }

    public void selectProductFromSubstitutionCarousel() {
        new WaitAction(driver).waitForDisplayed(gg_substitutionV2PageElements.firstSubstituteCardSubstitutionCarousel, 10);
        if (gg_substitutionV2PageElements.substituteCardsSubstitutionCarousel.size() > 1) {
            new PageActions(driver).new SwipeActions().slideTheCardFromRightToLeft(gg_substitutionV2PageElements.substituteCardsSubstitutionCarousel.get(0));
        }
        clickOnLastDisplayedSelectCTAFromSubstitutionPreferencesCarousel();
    }

    public void clickOnLastDisplayedSelectCTAFromSubstitutionPreferencesCarousel() {
        if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
            // Due to lack of locator availability in iOS, clicking on Select CTA is done through coordinates
            int productsSize = gg_substitutionV2PageElements.substituteCardsSubstitutionCarousel.size();
            MobileElement desiredProduct = gg_substitutionV2PageElements.substituteCardsSubstitutionCarousel.get(productsSize - 1);
            new TapAction(driver).tapCoordinate(desiredProduct.getLocation().getX() + (desiredProduct.getSize().getWidth() * 80) / 100, desiredProduct.getLocation().getY() + (desiredProduct.getSize().getHeight() * 20) / 100);
        } else {
            int selectCTASize = gg_substitutionV2PageElements.productCardsSelectCTASubstitutionCarousel.size();
            gg_substitutionV2PageElements.productCardsSelectCTASubstitutionCarousel.get(selectCTASize - 1).click();
        }
    }

    public void userClicksOtherOptionsCTA() {
        new WaitAction(driver).waitForElementToBeClickable(gg_substitutionV2PageElements.substitutionPreferencesOtherOptions, 10);
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.substitutionPreferencesOtherOptions);
    }

    public void clicksCloseSearchSubstitutions() {
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.closeSearchButton);
    }

    public void clicksCloseSubstitutions() {
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.substitutionPreferencesClose);
    }

    public void selectFirstSubstitutionProductOption() {
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.selectCTAListSearchSubPrefs.get(0));
    }

    public String labelFirstSubstitutionProductOption() {
        String attributeVal = null;
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                attributeVal = "label";
                break;
            case "ANDROID":
                attributeVal = "text";
                break;
        }
        return gg_substitutionV2PageElements.productSubstituteNamesInSearchPrefernces.get(0).getAttribute(attributeVal);
    }


    public void clickConfirmSubstitutions() {
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.confirmSubstitutionButton);
    }

    public void clickConfirmSubstitutionsAllSubPrefs() {
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.confirmSubstitutionAllSubsPrefs);
    }

    public void clickConfirmSearchSubstitutions() {
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.confirmSearchSubstitutionButton);
    }

    public void clickSetSubstitutionsForAll() {
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.substitutionPreferencesSetSubForAll);
    }

    public void clickDoNotSubstituteForAll() {
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.dontSubstituteForAll);
    }

    public String getSelectedProductText() {
        isElementDisplayed(gg_substitutionV2PageElements.selectedProductLabel, 2);
        if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
            return gg_substitutionV2PageElements.selectedProductLabel.getAttribute("label").split("Selected")[1].trim().substring(0, 20);
        }
        return gg_substitutionV2PageElements.selectedProductLabel.getText().substring(0, 20);
    }

    public boolean verifyLoadingSpinnerDisplayed() {
        return isElementDisplayed(gg_substitutionV2PageElements.spinner);
    }

    public boolean allDoNotSubstituteCheckboxChecked() {
        isElementDisplayed(gg_cartPageElements.changeSubstitution, 10);
        for (int i = 0; i < gg_cartPageElements.changeSubstitutionList.size(); i++) {
            new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.changeSubstitutionList.get(i));
            if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
                isElementDisplayed(gg_substitutionV2PageElements.searchIconSubstitution,5);
                if (!gg_substitutionV2PageElements.dontSubstituteAllSubPreferences.isSelected()) {
                    return false;
                }
            } else {
                if (gg_substitutionV2PageElements.dontSubstituteAllSubPreferences.getAttribute("checked").equals("false")) {
                    return false;
                }
            }
            new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.closeSubstitutionsBtn);
        }
        return true;
    }

    public void selectDontSubstituteInPreferences() {
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.substitutionPreferencesDontSubstitute);
    }

    public void clickConfirmSubstitutionBtn() {
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.confirmSubstitutionButton);
    }

    public void clickDontSubstitute() {
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.substitutionPreferencesDontSubstitute);
    }

    public String getCurrentDisplayedProductDescription() {
        new WaitAction(driver).waitForDisplayed(gg_substitutionV2PageElements.firstSubstituteCardSubstitutionCarousel, 10);
        return gg_substitutionV2PageElements.productDescriptionSubstitutionCarousel.stream().filter(desc -> desc.getLocation().getX() > 0).findFirst().get().getText();
    }

    public String getCurrentDisplayedProductDescriptionAllSubsPrefs() {
        new WaitAction(driver).waitForDisplayed(gg_substitutionV2PageElements.firstProductCardSubstitutionCarouselAllSubsPrefs, 10);
        return gg_substitutionV2PageElements.productDescriptionSubstitutionCarousel.stream().filter(desc -> desc.getLocation().getX() > 0).findFirst().get().getText();
    }

    public void closeSubstitutionPreferenceSheet() {
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.substitutionPreferencesClose);
    }

    public boolean isConfirmSubstitutionButtonEnabled() {
        return gg_substitutionV2PageElements.confirmSubstitutionButton.isEnabled();
    }

    public boolean isSetSubsForAllCTADisplayed() {
        return isElementDisplayed(gg_substitutionV2PageElements.substitutionPreferencesSetSubForAll, 3);
    }

    public boolean isEmptyIconDisplayedWhenNoSubAvailable() {
        return isElementDisplayed(gg_substitutionV2PageElements.emptySubstitutionsIcon, 5);
    }

    public boolean isEmptyIconDisplayedWhenNoSubAvailableSearch() {
        return isElementDisplayed(gg_substitutionV2PageElements.emptySubstitutionsSearchIcon, 5);
    }

    public String getMessageWhenNoSubAvailable() {
        return gg_substitutionV2PageElements.emptySubstitutionsMessage.getText();
    }

    public void searchForSubstitutesOnPreferences(String productName) {
        if (isElementDisplayed(gg_substitutionV2PageElements.searchTextInputInPreferences, 10)) {
            new TapAction(driver).tapCoordinate(gg_substitutionV2PageElements.searchTextInputInPreferences.getCenter().getX(), gg_substitutionV2PageElements.searchTextInputInPreferences.getCenter().getY());
            switch (driver.getPlatformName().toUpperCase()) {
                case "ANDROID":
                    enterTextNoPressEnter(gg_substitutionV2PageElements.searchTextInputInPreferences, productName);
                    if (isElementDisplayed(gg_substitutionV2PageElements.searchKeywordFromResult.get(0), 10)) {
                        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.searchKeywordFromResult.get(0));
                    } else {
                        throw new RuntimeException("Search results were not displayed for search key: " + productName);
                    }
                    break;
                case "IOS":
                    enterKey(gg_substitutionV2PageElements.searchTextInputInPreferences, productName);
                    break;
            }
        } else {
            throw new RuntimeException("Search bar is not displayed on home page!!");
        }
    }

    public String getMessageWhenNoSubAvailableSearch() {
        return gg_substitutionV2PageElements.emptySearchSubstitutionsMessage.getText();
    }

    public String getMessageWhenNoResultSub() {
        if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
            return gg_substitutionV2PageElements.noResultSearchSubstitutionsMessage.getAttribute("label");
        }
        return gg_substitutionV2PageElements.noResultSearchSubstitutionsMessage.getText();
    }

    public String getTypoMessageWhenNoResultSub() {
        if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
            return gg_substitutionV2PageElements.checkTypoSearchSubstitutionsMessage.getAttribute("label");
        }
        return gg_substitutionV2PageElements.checkTypoSearchSubstitutionsMessage.getText();
    }

    public void searchByProductName(String productName) {
        if (isElementDisplayed(gg_substitutionV2PageElements.searchTextField, 10)) {
            new TapAction(driver).tapCoordinate(gg_substitutionV2PageElements.searchTextField.getCenter().getX(), gg_substitutionV2PageElements.searchTextField.getCenter().getY());
            if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
                enterKey(gg_substitutionV2PageElements.searchTextField, productName);
            } else {
                enterTextNoPressEnter(gg_substitutionV2PageElements.searchTextField, productName);
            }
        } else {
            throw new RuntimeException("Search bar is not displayed substitution search page!!");
        }
    }

    public void selectOptionInSearchList(String option) {
        if (isElementDisplayed(gg_substitutionV2PageElements.firstSearchResultList, 20)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.listSearchedProductsButton.get(Integer.parseInt(option)));
        }
    }

    public void searchProductWithoutEnter(String productName) throws InterruptedException {
        enterTextNoPressEnter(gg_substitutionV2PageElements.searchTextField, productName);
        Thread.sleep(1500);
    }

    public void clickCancelSearch() {
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.cancelSearchButton);
    }

    public boolean isSearchBarOfSearchForSubstitutesIsDisplayed() {
        return isElementDisplayed(gg_substitutionV2PageElements.searchBarOfSearchForSubstitutes, 5);
    }

    public boolean verifyProductIsSelectedSearchSubstitution(String option) {
        if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
            return gg_substitutionV2PageElements.selectCTAListSearchSubPrefs.get(Integer.parseInt(option)).getAttribute("label").contains("Selected.");
        }
        return gg_substitutionV2PageElements.selectCTAListSearchSubPrefs.get(Integer.parseInt(option)).getText().equals("Selected");
    }

    public void closeSubstitutionPreferenceSearchScreen() {
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.substitutionPreferencesClose);
    }

    public boolean isHasNoALternativesDisplayed() {
        return isElementDisplayed(gg_substitutionV2PageElements.hasNoAlternativesMessage);
    }

    public void saveCarouselListProducts() {
        int size = gg_substitutionV2PageElements.descriptionSubstitutionCarouselCard.size();
        String description = "";
        for (int i = 0; i < size; i++) {
            if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
                String[] descriptionList = gg_substitutionV2PageElements.descriptionSubstitutionCarouselCard.get(i).getText().split(",");
                description = description.concat(descriptionList[0].substring(0, 20));
            } else {
                description = description.concat(gg_substitutionV2PageElements.descriptionSubstitutionCarouselCard.get(i).getAttribute("content-desc").substring(0, 20));
            }
        }
        ThreadLocalHelper.testCaseData.get().put("LIST_CAROUSEL_PRODUCT_DESCRIPTION", description);
    }

    public boolean verifyCarouselListEditCart() {
        isElementDisplayed(gg_substitutionV2PageElements.labelFirstSubstitutionProductOption, 5);
        int size = gg_substitutionV2PageElements.descriptionSubstitutionCarouselCard.size();
        String searchListProducts = "";
        for (int i = 0; i < size; i++) {
            if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
                String[] descriptionList = gg_substitutionV2PageElements.descriptionSubstitutionCarouselCard.get(i).getText().split(",");
                searchListProducts = searchListProducts.concat(descriptionList[0].substring(0, 20));
            } else {
                searchListProducts = searchListProducts.concat(gg_substitutionV2PageElements.descriptionSubstitutionCarouselCard.get(i).getAttribute("content-desc").substring(0, 20));
            }
        }
        return searchListProducts.contains(ThreadLocalHelper.testCaseData.get().get("LIST_CAROUSEL_PRODUCT_DESCRIPTION"));
    }

    public boolean verifyProductListFromCarouselToSearchList() {
        int size = gg_substitutionV2PageElements.productDescriptionSubstitutionSearch.size();
        String searchListProducts = "";
        for (int i = 0; i < size; i++) {
            if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
                String[] descriptionList = gg_substitutionV2PageElements.descriptionSubstitutionCarouselCard.get(i).getText().split(",");
                searchListProducts = searchListProducts.concat(descriptionList[0].substring(0, 20));
            } else {
                searchListProducts = searchListProducts.concat(gg_substitutionV2PageElements.productDescriptionSubstitutionSearch.get(i).getAttribute("text").substring(0, 20));
            }
        }
        return searchListProducts.contains(ThreadLocalHelper.testCaseData.get().get("LIST_CAROUSEL_PRODUCT_DESCRIPTION"));
    }

    public void clickSearchBar() {
        if (isElementDisplayed(gg_substitutionV2PageElements.searchTextField, 10)) {
            new TapAction(driver).tapCoordinate(gg_substitutionV2PageElements.searchTextField.getCenter().getX(), gg_substitutionV2PageElements.searchTextField.getCenter().getY());
        }
    }

    public boolean verifyAutocompleteOptionsAppears() {
        return gg_substitutionV2PageElements.listAutocompleteProducts.size() > 3;
    }

    public void selectOptionByNumberSearchSubstitutions(String option) {
        new WaitAction(driver).waitForDisplayed(gg_substitutionV2PageElements.selectCTASearchSubPrefs, 20);
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.selectCTAListSearchSubPrefs.get(Integer.parseInt(option)));
        ThreadLocalHelper.testCaseData.get().put("SUBSTITUTION_PRODUCT_NAME",
                gg_substitutionV2PageElements.productDescriptionSubstitutionSearch.get(Integer.parseInt(option)).getText().substring(0, 20));
    }

    public boolean verifySearchListWithCategories(String searchText) {
        if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
            return gg_substitutionV2PageElements.listSearchedProducts.get(0).getAttribute("label").equals(searchText) &&
                    gg_substitutionV2PageElements.listSearchedProducts.get(1).getAttribute("label").equals(searchText + " in Fruits & Vegetables") &&
                    gg_substitutionV2PageElements.listSearchedProducts.get(2).getAttribute("label").equals(searchText + " in Frozen Foods") &&
                    gg_substitutionV2PageElements.listSearchedProducts.get(3).getAttribute("label").equals(searchText + " in Bread & Bakery");
        }
        return gg_substitutionV2PageElements.listSearchedProducts.get(0).getText().equals(searchText) &&
                gg_substitutionV2PageElements.listSearchedProducts.get(1).getText().equals(searchText + " in Fruits & Vegetables") &&
                gg_substitutionV2PageElements.listSearchedProducts.get(2).getText().equals(searchText + " in Frozen Foods") &&
                gg_substitutionV2PageElements.listSearchedProducts.get(3).getText().equals(searchText + " in Bread & Bakery");
    }

    public String getConfirmSubCTAText() {
        return gg_substitutionV2PageElements.confirmSubstitutionButton.getText().trim();
    }

    public String getSelectedProductDescriptionFromCarousel() {
        int productDescSize = gg_substitutionV2PageElements.productDescriptionSubstitutionCarousel.size();
        return driver.getPlatformName().equalsIgnoreCase("ANDROID") ? gg_substitutionV2PageElements.productDescriptionSubstitutionCarousel.get(productDescSize - 1).getText() : gg_substitutionV2PageElements.productDescriptionSubstitutionCarousel.get(productDescSize - 1).getText().split(",\\(")[0];
    }

    public void userClickSetSubForAll() {
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.substitutionPreferencesSetSubForAll);
    }

    public Set<String> getProductNamesInAllSubPreferencesScreen(int productCntThreshold) {
        new WaitAction(driver).waitForDisplayed(gg_substitutionV2PageElements.productNameAllSubstitutionPreferences.get(0), 5);
        Set<String> productNames = new LinkedHashSet<String>();
        for (int cntVal = 0; cntVal < 25; cntVal++) {
            gg_substitutionV2PageElements.productNameAllSubstitutionPreferences.forEach(indProductName -> productNames.add(getText(indProductName)));
            if (productNames.size() >= productCntThreshold) {
                break;
            }
            scrollDownBySmallAmount();
        }
        return productNames;
    }

    public void clicksCloseAllSubstitutionsPrefernces() {
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.allSubsPreferncesCloseBtn);
    }

    public boolean isAllSubsPreferencesScreenDisplayed() {
        return isElementDisplayed(gg_substitutionV2PageElements.allSubstitutionsPreferencesScreenTitle, 5);
    }

    public void closeAllSubPrefsScreen() {
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.allSubstitutionsPreferencesClose);
    }

    public boolean isConfirmSubsForAllCTADisplayed() {
        return isElementDisplayed(gg_substitutionV2PageElements.confirmSubsForAll, 5);
    }

    public boolean isDontSubstituteForAllCTADisplayed() {
        return isElementDisplayed(gg_substitutionV2PageElements.dontSubstituteForAll, 5);
    }


    public String getFirstProductDescriptionFromCarouselInSubPreferences() {
        return driver.getPlatformName().equalsIgnoreCase("ANDROID") ? gg_substitutionV2PageElements.productDescriptionSubstitutionCarousel.get(0).getText() : gg_substitutionV2PageElements.productDescriptionSubstitutionCarousel.get(0).getText().split(",\\(")[0];
    }

    public void selectFirstProductFromSubstitutionCarousel() {
        new WaitAction(driver).waitForDisplayed(gg_substitutionV2PageElements.firstSubstituteCardSubstitutionCarousel, 10);
        clickOnFirstDisplayedSelectCTAFromSubstitutionPreferencesCarousel();
    }

    public void clickOnFirstDisplayedSelectCTAFromSubstitutionPreferencesCarousel() {
        if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
            MobileElement desiredProduct = gg_substitutionV2PageElements.substituteCardsSubstitutionCarousel.get(0);
            new TapAction(driver).tapCoordinate(desiredProduct.getLocation().getX() + (desiredProduct.getSize().getWidth() * 80) / 100, desiredProduct.getLocation().getY() + (desiredProduct.getSize().getHeight() * 20) / 100);
        } else {
            gg_substitutionV2PageElements.productCardsSelectCTASubstitutionCarousel.get(0).click();
        }
    }

    public void clickDoNotSubstituteForFirstProductAllPreferences() {
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.dontSubstituteAllSubPreferences);
        new CommonActions(driver).new ClickAction().clickElement(gg_substitutionV2PageElements.confirmSubsForAll);
    }

    public String getDontSubstituteRadioBtnStatusDesiredProductAllSubPref(int index) {
        scrollDown();
        return driver.getPlatformName().equalsIgnoreCase("ANDROID") ? gg_substitutionV2PageElements.dontSubstituteAllSubPreferencesList.get(index).getAttribute("checked") : gg_substitutionV2PageElements.dontSubstituteAllSubPreferencesList.get(index).getAttribute("type");
    }

    public String getTheSelectedProductFromSearchSubsList() {
        String attributeVal = driver.getPlatformName().equalsIgnoreCase("IOS") ? "label" : "text";
        Iterator<MobileElement> selectBtnItr = gg_substitutionV2PageElements.selectBtnOptnsInSearchSubs.iterator();
        Iterator<MobileElement> productNameItr = gg_substitutionV2PageElements.productSubstituteNamesInSearchPrefernces.iterator();
        while (selectBtnItr.hasNext() && productNameItr.hasNext()) {
            if (selectBtnItr.next().getText().equalsIgnoreCase("Selected")) {
                return productNameItr.next().getAttribute(attributeVal);
            }
            productNameItr.next();
        }
        return "Select failed!!";
    }

    public void waitForConfirmSubstitutionToBeDisplayedOnSubPrefs() {
        new WaitAction(driver).waitForElementToBeClickable(gg_substitutionV2PageElements.confirmSubstitutionButton, 10);
    }

    public String getTheSelectedProductFromSearchSubsPreference() {
        String attributeVal = driver.getPlatformName().equalsIgnoreCase("IOS") ? "label" : "text";
        return gg_substitutionV2PageElements.subsSearchPreferenceSelected.getAttribute(attributeVal);
    }

    public boolean isAnimationDisplayedForSubsPreferences() {
        return isElementDisplayed(gg_substitutionV2PageElements.subPrefsAnimation, 5);
    }

    public boolean isAnimationDisplayedForSetSubsForAllPreferences() {
        return isElementDisplayed(gg_substitutionV2PageElements.subPrefsSetAubForAllAnimation, 5);
    }

    public void scrollRightOnSubsCarousel() {
        new WaitAction(driver).waitForDisplayed(gg_substitutionV2PageElements.firstProductCardSubstitutionCarouselAllSubsPrefs, 10);
        new PageActions(driver).new SwipeActions().slideTheCardFromRightToLeft(gg_substitutionV2PageElements.substituteCardSubstitutionCarouselAllSubsPrefs.get(0));
    }

    public boolean isLastSubstituteSelected() {
        return gg_substitutionV2PageElements.productCardsSelectCTASubstitutionCarousel.get(gg_substitutionV2PageElements.productCardsSelectCTASubstitutionCarousel.size() - 1).getText().contentEquals("Selected");
    }
}

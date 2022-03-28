package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_SubstitutionV2PageElements {

    @AndroidFindBy(id = "ctaConfirm")
    @iOSXCUITFindBy(accessibility = "btnConfirmSubstitutionButton")
    public MobileElement confirmSubstitutionButton;

    @AndroidFindBy(id = "iv_empty_icon")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'imgvImageView'")
    public MobileElement searchIconSubstitution;

    @AndroidFindBy(id = "ctaConfirm")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Confirm'")
    public MobileElement confirmSearchSubstitutionButton;

    @AndroidFindBy(id = "ctaConfirm")
    @iOSXCUITFindBy(accessibility = "btnConfirmSubstitutionButton")
    public MobileElement confirmSubstitutionAllSubsPrefs;

    @AndroidFindBy(id = "tvDontSubstitute")
    @iOSXCUITFindBy(accessibility = "Don’t substitute")
    public MobileElement confirmDoNotSubstituteButton;

    @AndroidFindBy(id = "tv_substitution_header_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='lblProductTitleLabel']")
    public List<MobileElement> productName;

    @AndroidFindBy(id = "tv_substitution")
    @iOSXCUITFindBy(accessibility = "btnSubstitution")
    public List<MobileElement> substututionButton;

    @AndroidFindBy(id = "ctaClose")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Substitution preferences close'")
    public MobileElement substitutionPreferencesClose;

    @AndroidFindBy(xpath = "//*[contains(@text,'Substitution preferences')]")
    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Substitution preferences' AND type == 'XCUIElementTypeStaticText'")
    public MobileElement substitutionPreferencesTitle;

    @AndroidFindBy(id = "tvDescription")
    @iOSXCUITFindBy(id = "lblSubtitleLabel")
    public MobileElement substitutionPreferencesSubTitle;

    @AndroidFindBy(id = "rb_dont_substitute")
    @iOSXCUITFindBy(id = "lblDontSubstituteButton")
    public MobileElement substitutionPreferencesDontSubstitute;

    @AndroidFindBy(id = "tv_substitution_for_all")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Set substitutions for all' AND type == 'XCUIElementTypeButton'")
    public MobileElement substitutionPreferencesSetSubForAll;

    @AndroidFindBy(id = "tv_find_substitution")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Other options' AND type == 'XCUIElementTypeButton'")
    public MobileElement substitutionPreferencesOtherOptions;

    @AndroidFindBy(id = "clSubstitutionCard")
    @iOSXCUITFindBy(xpath = "//*[@name='lblSubtitleLabel']//parent::XCUIElementTypeOther//XCUIElementTypeCollectionView/XCUIElementTypeCell")
    public List<MobileElement> substituteCardsSubstitutionCarousel;

    @AndroidFindBy(id = "clSubstitutionCard")
    @iOSXCUITFindBy(xpath = "//*[@name='lblSubtitleLabel']//parent::XCUIElementTypeOther//XCUIElementTypeCollectionView/XCUIElementTypeCell")
    public MobileElement firstSubstituteCardSubstitutionCarousel;

    @AndroidFindBy(id = "clSubstitutionCard")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeCell)[2]")
    public MobileElement firstProductCardSubstitutionCarouselAllSubsPrefs;

    @AndroidFindBy(id = "clSubstitutionCard")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeCell")
    public List<MobileElement> substituteCardSubstitutionCarouselAllSubsPrefs;

    @AndroidFindBy(id = "substitution_selected")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'btnSelectButton'")
    public List<MobileElement> productCardsSelectCTASubstitutionCarousel;

    @AndroidFindBy(id = "tv_substitution_description")
    @iOSXCUITFindBy(iOSNsPredicate = "name contains 'out of ('")
    public List<MobileElement> productDescriptionSubstitutionCarousel;

    @AndroidFindBy(id = "ctaClose")
    @iOSXCUITFindBy(iOSNsPredicate = "label contains 'Substitution preferences close'")
    public MobileElement closeSearchButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'clSubstitutionCard')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,' out of ')]")
    public List<MobileElement> descriptionSubstitutionCarouselCard;

    @AndroidFindBy(id = "tv_substitution_description")
    @iOSXCUITFindBy(iOSNsPredicate = "name contains 'out of'")
    public List<MobileElement> productSubstituteNamesInSearchPrefernces;

    @AndroidFindBy(id = "tv_substitution_description")
    @iOSXCUITFindBy(id = "TBD")
    public MobileElement labelFirstSubstitutionProductOption;

    @AndroidFindBy(id = "tv_substitution_description")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,' out of ')]")
    public MobileElement selectedProductLabel;

    @AndroidFindBy(id = "progress_indicator")
    @iOSXCUITFindBy(id = "TBD")
    public MobileElement spinner;

    @AndroidFindBy(id = "btn_confirm_substitutiom")
    @iOSXCUITFindBy(accessibility = "Confirm")
    public MobileElement confirmSubstituteBtn;

    @AndroidFindBy(id = "tv_empty_message")
    @iOSXCUITFindBy(id = "lblDescriptionLabel")
    public MobileElement emptySubstitutionsMessage;

    @AndroidFindBy(id = "tvEmptyResult")
    @iOSXCUITFindBy(id = "lblDescriptionLabel")
    public MobileElement emptySearchSubstitutionsMessage;

    @AndroidFindBy(id = "etItemSearch")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS[c] 'Search' and visible == 1")
    public MobileElement searchTextField;

    @AndroidFindBy(id = "tvNoResult")
    @iOSXCUITFindBy(accessibility = "lblDescriptionTitleLabel")
    public MobileElement noResultSearchSubstitutionsMessage;

    @AndroidFindBy(id = "tvEmptyResult")
    @iOSXCUITFindBy(accessibility = "lblDescriptionLabel")
    public MobileElement checkTypoSearchSubstitutionsMessage;

    @AndroidFindBy(id = "iv_empty_icon")
    public MobileElement emptySubstitutionsIcon;

    @AndroidFindBy(id = "etItemSearch")
    @iOSXCUITFindBy(accessibility = "Search for substitutes")
    public MobileElement searchTextInputInPreferences;

    @AndroidFindBy(id = "tv_item")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell")
    public List<MobileElement> searchKeywordFromResult;

    @AndroidFindBy(id = "ivEmptyResult")
    public MobileElement emptySubstitutionsSearchIcon;

    @AndroidFindBy(id = "etItemSearch")
    @iOSXCUITFindBy(iOSNsPredicate = "label contains 'Search' and visible == 1")
    public MobileElement searchBarOfSearchForSubstitutes;

    @AndroidFindBy(id = "tvCancelSearch")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Cancel' AND name == 'Cancel' AND value == 'Cancel'")
    public MobileElement cancelSearchButton;

    @AndroidFindBy(id = "tv_empty_message")
    public MobileElement hasNoAlternativesMessage;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tv_substitution_description')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[contains(@name,' out of ')]")
    public List<MobileElement> productDescriptionSubstitutionSearch;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tv_item')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='lblAutocompleteItem' and @visible='true']")
    public List<MobileElement> listAutocompleteProducts;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'tv_item')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='lblAutocompleteItem']/XCUIElementTypeButton")
    public List<MobileElement> listSearchedProducts;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'rvSearchSuggestions')]/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='lblAutocompleteItem']/XCUIElementTypeButton")
    public List<MobileElement> listSearchedProductsButton;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'rvSearchSuggestions')]/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name='lblAutocompleteItem']/XCUIElementTypeButton")
    public MobileElement firstSearchResultList;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'substitution_selected')]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'btnSelectButton'")
    public List<MobileElement> selectCTAListSearchSubPrefs;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,'substitution_selected')]")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'btnSelectButton'")
    public MobileElement selectCTASearchSubPrefs;

    @AndroidFindBy(id = "tv_substitution_header_title")
    @iOSXCUITFindBy(iOSNsPredicate = "name contains 'lblProductTitleLabel' and visible ==1")
    public List<MobileElement> productNameAllSubstitutionPreferences;

    @AndroidFindBy(id = "ctaClose")
    @iOSXCUITFindBy(iOSNsPredicate = "name contains 'btnTopNavBarRight' and visible == 1")
    public MobileElement allSubsPreferncesCloseBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"All substitutions preferences\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'All substitutions preferences' and visible == 1")
    public MobileElement allSubstitutionsPreferencesScreenTitle;

    @AndroidFindBy(id = "ctaClose")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'All substitutions preferences close'")
    public MobileElement allSubstitutionsPreferencesClose;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Confirm substitutions\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Confirm substitutions' and visible == 1")
    public MobileElement confirmSubsForAll;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Don’t substitute for all\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Don’t substitute for all' and visible == 1")
    public MobileElement dontSubstituteForAll;


    @AndroidFindBy(id = "rb_dont_substitute")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Substitute Radio button'")
    public MobileElement dontSubstituteAllSubPreferences;

    @AndroidFindBy(id = "rb_dont_substitute")
    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS 'Substitute Radio button'")
    public List<MobileElement> dontSubstituteAllSubPreferencesList;


    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Don’t substitute for all\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label contains 'Select' and type == 'XCUIElementTypeStaticText'")
    public List<MobileElement> selectBtnOptnsInSearchSubs;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Selected']/..//android.widget.TextView[contains(@resource-id,'tv_substitution_description')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Selected']/../../../..//XCUIElementTypeOther[contains(@name,'out of')]")
    public MobileElement subsSearchPreferenceSelected;

    @AndroidFindBy(xpath = "PENDING")
    @iOSXCUITFindBy(xpath = "PENDING")
    public MobileElement subPrefsAnimation;

    @AndroidFindBy(xpath = "PENDING")
    @iOSXCUITFindBy(xpath = "PENDING")
    public MobileElement subPrefsSetAubForAllAnimation;
}

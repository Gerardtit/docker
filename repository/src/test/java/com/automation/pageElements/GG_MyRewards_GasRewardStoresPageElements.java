package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * This class contains elements that belong to gas reward store lists
 */
public class GG_MyRewards_GasRewardStoresPageElements {

    @AndroidFindBy(id = "//android.widget.ImageView[@content-desc=\"back\"]")
//    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name == 'btnMapButton'")
    public MobileElement navigationArrow;

    @AndroidFindBy(className = "android.widget.ProgressBar")
    @iOSXCUITFindBy(iOSNsPredicate = "type=\"XCUIElementTypeStaticText\" value=\"Loading\"")
    public MobileElement loadingSpinner;

    @AndroidFindBy(xpath = "//*[@text='Tell Us How We Did']")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public MobileElement feedBackForm;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Close\"]")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public MobileElement closeFeedbackForm;

    @AndroidFindBy(xpath = "//*[@text='Allow' or @text='ALLOW' or @text='Allow all the time' or @text='While using the app']")
    @iOSXCUITFindBy(accessibility = "Allow While Using App")
    public MobileElement allowCurrentLocationPermission;

    @AndroidFindBy(xpath = "//*[contains(@text,'LATER')]")
    @iOSXCUITFindBy(accessibility = "Maybe Later")
    public MobileElement updateLater;

    @AndroidFindBy(accessibility = "my location")
    @iOSXCUITFindBy(accessibility = "btnMapLocateMeButton")
    public MobileElement currentLocationButton;

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'Driving mode')]")
    public MobileElement startButtonGoogleMaps;

    @AndroidFindBy(xpath = "//*[@text='SKIP']")
    public MobileElement skipButtonGoogleMaps;

    @iOSXCUITFindBy(id = "Use Maps")
    public MobileElement mapOption;

    @AndroidFindBy(id = "tv_station_list_brand_name")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblBannerName' AND visible == true")
    public List<MobileElement> storeName;

    @AndroidFindBy(id = "iv_station_list_logo")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeImage' AND name == 'imgvGasIcon'")
    public List<MobileElement> storeLogo;

    @AndroidFindBy(id = "tv_station_list_store_distance")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblDistance'")
    public List<MobileElement> storeDistance;

    @AndroidFindBy(id = "tv_station_list_store_state")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblStoreStatus'")
    public List<MobileElement> storeStatus;

    @AndroidFindBy(id = "tv_station_list_store_address")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='lblAddress'])")
    public List<MobileElement> storeAddress;

    @AndroidFindBy(id = "search_src_text")
    @iOSXCUITFindBy(id = "txtFieldMapSearchField")
    public MobileElement zipCodeCitySearchTextField;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Google Map\"]/android.view.View")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeOther' AND label BEGINSWITH 'Map pin'")
    public List<MobileElement> storeMarkersOnMap;

    @iOSXCUITFindBy(accessibility = "Ok")
    public MobileElement noGasStationsFoundPopUpOkBtn;

    @AndroidFindBy(xpath = "//android.widget.Toast[@text=\"Invalid Address\"]")
    @iOSXCUITFindBy(accessibility = "No gas stations found within 20 miles of the location. Please use a different location")
    public MobileElement invalidSearchErrorMessage;

    @AndroidFindBy(id = "search_close_btn")
    @iOSXCUITFindBy(accessibility = "Clear text")
    public MobileElement clearAddressIcon;

    @AndroidFindBy(accessibility = "back")
//    TechDebt Locator below
//    @iOSXCUITFindBy(accessibility = "btnTopNavBarWithHintLeft")
//    UMA Master Locator below
    @iOSXCUITFindBy(accessibility = "btnTopNavBarLeft")
    public MobileElement backButton;

    @AndroidFindBy(id = "bottom_sheet_head_view")
    @iOSXCUITFindBy(iOSNsPredicate = "type = 'XCUIElementTypeStaticText' AND label = '1 Reward = 10¢ off / gal'")
    public MobileElement bottomDrawerButton;

    //    TechDebt Locator below
//    @iOSXCUITFindBy(accessibility = "lblTopNavBarWithHintTitle")
//    UMA Master Locator below
    @iOSXCUITFindBy(accessibility = "lblTopNavBarTitle")
    public MobileElement headerGasStore;

    //    TechDebt Locator below
//    @iOSXCUITFindBy(accessibility = "lblTopNavBarWithHintHint")
//    UMA Master Locator below
    @iOSXCUITFindBy(accessibility = "lblRewardsCurrentBalance")
    public MobileElement currentBalance;


    @AndroidFindBy(accessibility = "refine station selection")
    @iOSXCUITFindBy(xpath = "//*[@name=\"Refine\"]")
    public MobileElement refineButton;

    @AndroidFindBy(accessibility = "close")
    @iOSXCUITFindBy(accessibility = "btnRefineTableHeaderViewClose")
    public MobileElement refineCloseButton;

    @AndroidFindBy(id = "brand_stations")
    @iOSXCUITFindBy(iOSNsPredicate = "label ENDSWITH 'Fuel stations only'")
    public MobileElement bannerSpecificFuelStations;

    @AndroidFindBy(id = "all_stations")
    @iOSXCUITFindBy(accessibility = "All participating stations")
    public MobileElement allParticipatingFuelStations;

    @AndroidFindBy(id = "tv_title")
    @iOSXCUITFindBy(id = "lblRefineTableHeaderViewTitle")
    public MobileElement refineHeader;

    @AndroidFindBy(id = "btn_show_result")
    @iOSXCUITFindBy(id = "btnRefineShowResults")
    public MobileElement showResultButton;

    @AndroidFindBy(accessibility = "Reset button")
    @iOSXCUITFindBy(accessibility = "btnRefineReset")
    public MobileElement resetButton;

    @AndroidFindBy(id = "tv_refine_selection")
    @iOSXCUITFindBy(accessibility = "Refine")
    public MobileElement refine;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Navigate up\"]/android.widget.ImageView\n")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public WebElement mapOptionCancel;


}


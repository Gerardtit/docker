package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.CacheLookup;

import java.util.List;

public class GG_SelectStoreElements {

    @AndroidFindBy(accessibility = "Google Map")
    @iOSXCUITFindBy(accessibility = "viewStoreMapView")
    @CacheLookup
    public MobileElement mapView;

    @AndroidFindBy(id = "rv_store_list_bottom_sheet")
    @CacheLookup
    @iOSXCUITFindBy(accessibility = "viewStoreListView")
    public MobileElement storeListsView;

    @AndroidFindBy(id = "my_location_button")
    @iOSXCUITFindBy(accessibility = "btnMapLocateMeButton")
    public MobileElement myLocationBtn;

    @AndroidFindBy(id = "bottom_sheet_head")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"viewStoreListView\"]/XCUIElementTypeOther/XCUIElementTypeOther")
    @CacheLookup
    public MobileElement bottomDrawerButton;

    @AndroidFindBy(id = "search_src_text")
    @iOSXCUITFindBy(accessibility = "txtFieldMapSearchField")
    public MobileElement searchLocationTextFieldInMap;

    @AndroidFindBy(id = "et_zip_city")
    @iOSXCUITFindBy(accessibility = "textField-Optional(\"Enter your ZIP or City\")")
    public MobileElement searchLocationTextFieldInShareLocation;

    @AndroidFindBy(id = "btn_select_store")
    @iOSXCUITFindBy(accessibility = "Choose this store")
    public MobileElement selectStoreButton;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Albertsons. \"])[1]")
    @iOSXCUITFindBy(accessibility = "Custom_Annotation_View")
    public MobileElement storeLocationIcon;

    @AndroidFindBy(id = "tv_store_list_store_address")
    @iOSXCUITFindBy(accessibility = "lblStoreCardAddress-00")
    public MobileElement selectStoreCard;

    @AndroidFindBy(id = "tv_store_list_store_address")
    @iOSXCUITFindBy(accessibility = "lblStoreCardAddress-01")
    public List<MobileElement> selectOtherStoreCard;

    @AndroidFindBy(id = "store selected")
    @iOSXCUITFindBy(accessibility = "viewStoreCardSelected-00")
    public MobileElement storeSelectedButton;

    @AndroidFindBy(id = "PENDING")
    @iOSXCUITFindBy(accessibility = "Loading")
    public MobileElement loader;

    @AndroidFindBy(id = "store_list_container")
    @iOSXCUITFindBy(accessibility = "PENDING")
    public List<MobileElement> allStoreCards;

    @AndroidFindBy(id = "tv_dashboard_store_name")
    @iOSXCUITFindBy(accessibility = "btnStorePickerTitle")
    public MobileElement storeAddress;

    @AndroidFindBy(accessibility = "store brand logo")
    @iOSXCUITFindBy(accessibility = "PENDING")
    public MobileElement storeLogo;


}


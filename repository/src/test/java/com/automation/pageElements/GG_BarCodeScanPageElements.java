package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GG_BarCodeScanPageElements {

    @AndroidFindBy(accessibility = "Scan Setting Button")
    @iOSXCUITFindBy(accessibility = "Scan setting")
    public MobileElement scanSetting;

    @AndroidFindBy(id = "btn_setting_switch")
    @iOSXCUITFindBy(accessibility = "lblAddOffersTitle")
    public MobileElement toggleTitle;

    @AndroidFindBy(xpath = "//android.widget.Switch[@text='OFF']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeSwitch' AND name == 'btnAddOffersSwitch' and value =='0'")
    public MobileElement toggleOFFState;

    @AndroidFindBy(xpath = "//android.widget.Switch[@text='ON']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeSwitch' AND name == 'btnAddOffersSwitch' and value =='1'")
    public MobileElement toggleONState;

    @AndroidFindBy(accessibility = "scan barcode")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Scan barcode' AND name == 'btnSearchBarViewScan'")
    public MobileElement barcodeScanOptionOnSearch;

    @AndroidFindBy(xpath = "//*[@text='Allow' or @text='ALLOW' or contains(@text,'While using the app')]")
    @iOSXCUITFindBy(accessibility = "OK")
    public MobileElement cameraPermissionAllow;

    @AndroidFindBy(id = "global_scan_title_tv")
    @iOSXCUITFindBy(accessibility = "lblTopNavBarTitle")
    public MobileElement scanSection;

    @AndroidFindBy(accessibility = "Close")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Close'")
    public MobileElement closeIcon;

    @AndroidFindBy(id = "global_scan_dialog_cta")
    @iOSXCUITFindBy(accessibility = "Get started")
    public MobileElement getStarted;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Close\"]")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public MobileElement closeFeedbackForm;

    @AndroidFindBy(xpath = "//*[@text='Tell Us How We Did']")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public MobileElement feedBackForm;

    @AndroidFindBy(id = "btnLight")
//    TechDebt Locator below
//    @iOSXCUITFindBy(id = "btnTopNavBarWithHintRight")
//    UMA Master Locator below
    @iOSXCUITFindBy(id = "btnTopNavBarRight")
    public MobileElement flash;

    @AndroidFindBy(id = "btnLight")
    @iOSXCUITFindBy(xpath = "//*[@label='Flash is on']")
    public MobileElement flashStatusON;

    @AndroidFindBy(accessibility = "Flash")
//    TechDebt Locator below
//    @iOSXCUITFindBy(xpath = "//*[@name='btnTopNavBarWithHintRight']")
//    UMA Master Locator below
    @iOSXCUITFindBy(xpath = "//*[@name='btnTopNavBarRight']")
    public MobileElement flashStatusOFF;

    @AndroidFindBy(id = "tab_layout")
    @iOSXCUITFindBy(accessibility = "lblToggleViewFirst")
    public MobileElement toggleButton;

    @AndroidFindBy(accessibility = "Deals")
    @iOSXCUITFindBy(id = "lblToggleViewFirst")
    public MobileElement dealsOption;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"editSearch\")]|//*[contains(@resource-id,\"imageBack\")]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Search for Products\"]")
    public MobileElement verifyTextView;

    @AndroidFindBy(xpath = "//*[contains(@resource-id,\"imageCancel\")]")
    @iOSXCUITFindBy(xpath = "//*[@label=\"Clear text\"]|//XCUIElementTypeButton[@label=\"Cancel\"]")
    public MobileElement cancelButton;

    @AndroidFindBy(accessibility = "Products")
    @iOSXCUITFindBy(id = "lblToggleViewSecond")
    public MobileElement productOption;

    @AndroidFindBy(id = "global_scan_title_tv")
    @iOSXCUITFindBy(accessibility = "lblTopNavBarTitle")
    public MobileElement scanToShopTitle;

    @AndroidFindBy(id = "bottom_sheet_head")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Scan it straight'")
    public MobileElement scanToShopDrawer;

    @AndroidFindBy(id = "tv_scan_hint_text")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Scan it straight'")
    public MobileElement scanToShopText;

    @AndroidFindBy(id = "global_scan_dialog_title_tv")
    @iOSXCUITFindBy(accessibility = "lblScanTutorialTitle")
    public MobileElement scanandSaveTitle;

    @AndroidFindBy(id = "global_scan_dialog_subhead_tv")
    @iOSXCUITFindBy(accessibility = "lblScanTutorialSubTitle")
    public MobileElement scanandSaveSubtitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Scan it to clip the coupon and save to Wallet.']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'Scan it to clip the coupon and save to Wallet.'")
    public MobileElement scanToClipDrawer;

    @AndroidFindBy(id = "camera_denied_dialog")
    @iOSXCUITFindBy(accessibility = "lblDeniedPermissionsTitle")
    public MobileElement cameraPleasePopUp;

    @AndroidFindBy(id = "open_settings_button")
    @iOSXCUITFindBy(accessibility = "btnOpenSettings")
    public MobileElement openSettingCTA;

    @AndroidFindBy(xpath = "//*[@text='Deny' or @text='DENY']")
    @iOSXCUITFindBy(accessibility = "Don’t Allow")
    public MobileElement permissionDenyButton;

    @AndroidFindBy(id = "com.android.settings:id/entity_header_title")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Settings')]")
    public MobileElement cameraSettingPageTitle;

    @AndroidFindBy(accessibility = "Close")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public MobileElement cancelButtonOnFeedBackFormOnBarcodeScanScreen;

    @AndroidFindBy(xpath = "//*[contains(@text,'LATER')]")
    @iOSXCUITFindBy(accessibility = "Maybe Later")
    public MobileElement updateLaterOnBarCodeScanScreen;
}

package com.automation.pageElements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.List;

public class GG_ShoppingModePageElements {

    @AndroidFindBy(id = "type_pickup_card")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Pickup']")
    public MobileElement pickUpShoppingMode;

    @AndroidFindBy(id = "type_delivery_card")
    //@iOSXCUITFindBy(xpath="//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]")
    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'Delivery'")

    public MobileElement deliveryShoppingMode;

    @AndroidFindBy(id = "type_instore_card")
    @iOSXCUITFindBy(id = "Shop in-store or make your list")
    public MobileElement inStoreShoppingMode;

    @AndroidFindBy(className = "android.widget.ProgressBar")
    @iOSXCUITFindBy(iOSNsPredicate = "type=\"XCUIElementTypeStaticText\" value=\"Loading\"")
    public MobileElement loadingSpinner;

    @AndroidFindBy(id = "start_shopping")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Start shopping' AND type == 'XCUIElementTypeButton'")
    public MobileElement startShoppingButton;

    @AndroidFindBy(id = "edit_text")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Zip Code\"]")
    public MobileElement zipCodeTextField;

    @AndroidFindBy(id = "btn_next")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'whiteRightArrow' OR label == 'Submit'")
    public MobileElement zipCodeRightArrow;

    @iOSXCUITFindBy(xpath = "//*[@name=\"Allow notifications\"]")
    public MobileElement AllowNotification;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Allow'")
    // @AndroidFindBy(id = "iv_user_avatar")
    public MobileElement Allow;

    @AndroidFindBy(id = "address")
    @iOSXCUITFindBy(iOSNsPredicate = "name=='lblStoreAddress' AND visible==1")
    public MobileElement firstStoreCard;

    @AndroidFindBy(id = "address")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'lblStoreAddress' and visible==1")
    public List<MobileElement> allStoreCardsList;

    @AndroidFindBy(accessibility = "Search for zipcode")
    @iOSXCUITFindBy(id = "Search for Pickup store")
    public MobileElement searchForZipCode;

    @AndroidFindBy(xpath = "//*[contains(@text,'Pickup')]")
    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'Pickup'")
    public MobileElement pickUpShoppingModeInDashboard;

    @AndroidFindBy(xpath = "//*[contains(@text,'Delivery')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Delivery address \"]")
//    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Delivery address')]")
    public MobileElement deliveryShoppingModeInDashboard;

    @AndroidFindBy(id = "btn_reserve_time")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Reserve a time'")
    public MobileElement reserveATime;

    @AndroidFindBy(id = "btn_reserve_time")
    @iOSXCUITFindBy(iOSNsPredicate = "label ENDSWITH 'PM' OR 'AM'")
    public MobileElement reserveATime2;

    @AndroidFindBy(id = "dateTimeTv")
    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Reserve a Time\" AND type == \"XCUIElementTypeNavigationBar\" AND visible==1")
    public MobileElement reserveATimePage;

    @AndroidFindBy(id = "btn_reserve_time")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Reserve a time'")
    public List<MobileElement> reserveATimeList;

    @AndroidFindBy(accessibility = "Navigate up")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public MobileElement backButtonOnReserveATimePage;

    @AndroidFindBy(xpath = "//*[contains(@text,'Would you like to reserve a pick up time?')]")
    @iOSXCUITFindBy(accessibility = "Would you like to reserve a pick-up time?")
    public MobileElement windowPopUpReserveATimePage;

    @AndroidFindBy(id = "android:id/button2")
    @iOSXCUITFindBy(id = "No")
    public MobileElement NowindowPopUpReserveATimePage;

    @AndroidFindBy(xpath = "//*[contains(@text,'In-store')]")
    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH 'In-store'")
    public MobileElement instoreShoppingModeInDashboard;

    @AndroidFindBy(id = "tv_shopping_address")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Delivery address') or contains(@name,'Pickup address') or contains(@name,'In-')]")
    public MobileElement shoppingAddressInDashboard;

    @AndroidFindBy(id = "btn_use_loc")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Use my location' AND visible==1")
    public MobileElement useMyLocation;

    @AndroidFindBy(id = "btn_use_loc")
    @iOSXCUITFindBy(id = "Zip Code")
    public MobileElement zipCodePageTitle;

    @AndroidFindBy(id = "how_do_want_text")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]")
    public MobileElement howDoYouWantYourGroceriesTitle;

    @AndroidFindBy(id = "PENDING")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back\"]")
    public MobileElement shoppingPageBackButton;

    @AndroidFindBy(id = "edit_text")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Zip Code\"]")
    public MobileElement shoppingPageZipCodeTextField;

    @AndroidFindBy(id = "closeImg")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public MobileElement shoppingModeCancelButton;

    @AndroidFindBy(id = "distance")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name == 'lblDistance'")
    public List<MobileElement> storeDistance;

    @AndroidFindBy(id = "iv_instore_selected")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'in-store')]//parent:: XCUIElementTypeCell")
    public MobileElement inStoreSelected;

    @AndroidFindBy(id = "iv_delivery_selected")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Delivery to')]//parent:: XCUIElementTypeCell")
    public MobileElement deliverySelected;

    @AndroidFindBy(id = "fulfilled_banner")
    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH \"Fulfilled By\"")
    public MobileElement fulfilledByLabel;

    @AndroidFindBy(id = "buttonShop")
    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Download App\" AND type == \"XCUIElementTypeButton\"")
    public MobileElement downloadAppButton;

    @AndroidFindBy(id = "buttonShop")
    @iOSXCUITFindBy(iOSNsPredicate = "type=='XCUIElementTypeButton' AND name BEGINSWITH 'Open' AND name ENDSWITH 'App'")
    public MobileElement openAppButton;

    @AndroidFindBy(id = "picker_note_please")
    @iOSXCUITFindBy(accessibility = "*Please Note: Any Drive Up & Go™ orders not claimed by 8 PM on the day of scheduled pick up will be canceled.")
    public MobileElement pleaseNoteText;

    @AndroidFindBy(id = "dateTimeTv")
    @iOSXCUITFindBy(xpath = "//*[contains(@label=\"*Please Note:\")]")
    @iOSXCUITFindBy(accessibility = "Choose a date & time")
    public MobileElement chooseDateAndTimeLabel;

    @AndroidFindBy(id = "orderTypeAddressTv")
    @iOSXCUITFindBy(accessibility = "Store Address:")
    public MobileElement storeAddress;

    @AndroidFindBy(id = "dug_earliest_delivery_note")
    @iOSXCUITFindBy(iOSNsPredicate = "label BEGINSWITH 'Earliest Available Pickup Times'")
    public MobileElement earliestAvailablePickUpTimesLabel;

    @AndroidFindBy(id = "deliveryWindowBtnLayout")
    @iOSXCUITFindBy(iOSNsPredicate = "PENDING")
    public MobileElement orderDeliveryWindow;

    @AndroidFindBy(id = "datePicker")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypePickerWheel[1]")
    public MobileElement orderDatePicker;

    @AndroidFindBy(id = "timeTv")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypePickerWheel[2]")
    public MobileElement orderTimePicker;

    @AndroidFindBy(id = "btn_save")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND label == 'Save'")
    public MobileElement orderDeliverySaveButton;

    @AndroidFindBy(id = "btn_select")
    @iOSXCUITFindBy(iOSNsPredicate = "PENDING")
    public List<MobileElement> selectedCard;

    @iOSXCUITFindBy(id = "Dismiss")
    public MobileElement dismissCTA;

    @AndroidFindBy(id = "iv_pickup_selected")
    @iOSXCUITFindBy(xpath = "//*[@name='Pickup']//parent:: XCUIElementTypeCell")
    public MobileElement pickupSelected;

    @AndroidFindBy(id = "happy_carts_txt")
    @iOSXCUITFindBy(accessibility = "Full carts & happy hearts")
    public MobileElement fullCartsHappyHeartsMessage;

    @AndroidFindBy(accessibility = "Back")
    @iOSXCUITFindBy(accessibility = "Cancel")
    public MobileElement closeButtonZipCodePage;

    @iOSXCUITFindBy(xpath = "//*[@label=\"Store Address:\"]")
    public MobileElement storeCard;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTextField[@name=\"Zip Code\"])[1]")
    public MobileElement zipCodeTextFieldSearch;


    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Search for Delivery store\"])[1]")
    public MobileElement SearchforDeliverystore;

    @iOSXCUITFindBy(xpath = "//*[contains(@label,\"Delivery is available from the following stores:\") and @visible='true']")
    @AndroidFindBy(accessibility = "Delivery is available from the following stores:")
    public MobileElement deliveryAvailableFromStores;

    @iOSXCUITFindBy(xpath = " //*[@name=\"viewStoreCard\"]")
    @AndroidFindBy(id = "storeItemLayout")
    public List<MobileElement> deliveryStoresList;

}
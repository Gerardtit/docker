package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pageElements.GG_CartPageElements;
import com.automation.pageElements.HomePageElements;
import com.automation.pages.CheckoutPage;
import com.automation.pages.GG_CartPage;
import com.automation.pages.HomePage;
import com.automation.pages.NewCheckoutPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewCheckoutSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public HomePage homePage = new HomePage(driver);
    public HomePageElements homePageElements = new HomePageElements();
    NewCheckoutPage newCheckoutPage = new NewCheckoutPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    GG_CartPage ggCartpage = new GG_CartPage(driver);
    private final GG_CartPageElements gg_cartPageElements = new GG_CartPageElements();


    @Then("^user lands on slot selection page for pickup$")
    public void user_lands_on_slot_selection_page_for_pickup() throws Throwable {
        newCheckoutPage.pickupIsSelected();
    }

    @Then("^user lands on slot selection page for delivery$")
    public void user_lands_on_slot_selection_page_for_delivery() throws Throwable {
        newCheckoutPage.deliveryIsSelected();
    }


    @And("^user clicks on Edit button on slot selection page for pickup$")
    public void user_clicks_on_edit_button_on_slot_selection_page_for_pickup() throws Throwable {
        newCheckoutPage.clickEditBtn();
    }

    @Then("^user lands on select pickup store page$")
    public void user_lands_on_select_pickup_store_page() throws Throwable {
        newCheckoutPage.selectPickupStoreDisplayed();
    }

    @And("^user verify \"([^\"]*)\" will be pre filled if previously provided$")
    public void user_verify_something_will_be_pre_filled_if_previously_provided(String zipcode) throws Throwable {
        newCheckoutPage.zipPreFilled(zipcode);
    }

    @Then("^User taps on the search entry field$")
    public void user_taps_on_the_search_entry_field() throws Throwable {
        newCheckoutPage.tapEnterZipCodeSearchfield();
    }

    @Then("^user verify numeric keyboard is displayed$")
    public void user_verify_numeric_keyboard_is_displayed() throws Throwable {
        newCheckoutPage.verifyNumericKeyboard();
    }

    @And("^User enters the 5 digit Zip code$")
    public void user_enters_the_5_digit_zip_code() throws Throwable {
        newCheckoutPage.enterZip();
    }

    @Then("^user verify keyboard slides down$")
    public void user_verify_keyboard_slides_down() throws Throwable {
        newCheckoutPage.keyboardSlidesDown();
    }

    @Then("^user verify search gets auto triggered after 5 digits have been entered$")
    public void user_verify_search_gets_auto_triggered_after_5_digits_have_been_entered() throws Throwable {
        newCheckoutPage.searchAutoTrigger();
    }

    @And("^user verify search results are scrollable$")
    public void user_verify_search_results_are_scrollable() throws Throwable {
        newCheckoutPage.scrollableSearchResults();
    }

    @Then("^user verify only DUG and WUG stores are shown in the search results$")
    public void user_verify_only_dug_and_wug_stores_are_shown_in_the_search_results() throws Throwable {
        newCheckoutPage.verifyDUGWUG();
    }

    @And("^user verify the last store is within 50 miles radius$")
    public void user_verify_the_last_store_is_within_50_miles_radius() throws Throwable {
        newCheckoutPage.verify50MilesRadius();
    }

    @And("^user pull up the sheet to view store list$")
    public void user_pulls_up_the_sheet_to_view_store_list() throws Throwable {
        newCheckoutPage.pullUpSheetToViewStoreList();
    }

    @When("^user pulls up the sheet it goes full screen$")
    public void user_pulls_up_the_sheet_it_goes_full_screen() throws Throwable {
        newCheckoutPage.pullUpSheet();
    }

    @And("^Store pin is not visible to the user$")
    public void store_pin_is_not_visible_to_the_user() throws Throwable {
        newCheckoutPage.storePinInVisible();
    }

    @Then("^user verify mid point is the default for select pickup store$")
    public void user_verify_mid_point_is_the_default_for_select_pickup_store() throws Throwable {
        newCheckoutPage.defaultMidPoint();
    }

    @And("^Store pin is visible to the user$")
    public void store_pin_is_visible_to_the_user() throws Throwable {
        newCheckoutPage.storePinVisible();
    }

    @Then("^user pulls down the sheet further it goes to minimum point$")
    public void user_pulls_down_the_sheet_further_it_goes_to_minimum_point() throws Throwable {
        newCheckoutPage.pullDownFurther();
    }

    @And("^user pulls down the sheet$")
    public void user_pulls_down_the_sheet() throws Throwable {
        newCheckoutPage.pullDownSheet();
    }


    @And("^user verify the map is zoomed in$")
    public void user_verify_the_map_is_zoomed_in() throws Throwable {
        newCheckoutPage.mapZoomed();
    }


    @Then("^user verify enter card details page is displayed$")
    public void user_verify_enter_card_details_page_is_displayed() throws Throwable {
        newCheckoutPage.enterCardPage();
    }

    @Then("^user clicks on Done button of the keypad so that continue button is displayed to click$")
    public void user_clicks_on_done_button_of_the_keypad_so_that_continue_button_is_displayed_to_click() throws
            Throwable {
        newCheckoutPage.clickDone();
    }

    @Then("^user clicks on continue button on credit card form$")
    public void user_clicks_on_continue_button_on_credit_card_form() throws Throwable {
        newCheckoutPage.clickContinue();
    }

    @And("^verify the cursor is already on the street field$")
    public void user_verify_cursor_is_active_in_address_field() throws Throwable {
        driver.switchTo().activeElement();
        newCheckoutPage.addressScreen();
    }

    @Then("^place order button is displayed$")
    public void place_order_is_displayed() throws Throwable {
        newCheckoutPage.placeOrderisDisplayed();
    }

    @Then("^verify State field will not be editable$")
    public void user_verify_state_field_is_not_editable() throws Throwable {
        newCheckoutPage.verifyStateFieldIsNotEditable();
    }

    @Then("^verify 2nd line for street is optional$")
    public void user_verify_2nd_line_street_is_optional() throws Throwable {
        newCheckoutPage.verify2ndLineisOptional();
    }

    @Then("^user verify Zip code ,City, and State are pre-filled$")
    public void user_verify_prefilled_textfields() throws Throwable {
        newCheckoutPage.verifyPrefilledTextFields();
    }

    @And("^user add payment details$")
    public void user_add_payment_details() throws Throwable {
        newCheckoutPage.paymentDetails();
    }

    @And("^user clicks on Continue to payment CTA at the slot selection screen$")
    public void user_clicks_continue_slot_selection_screen() throws Throwable {
        newCheckoutPage.clickContinueOnSlotSelection();
    }

    @When("^user clicks on search field$")
    public void user_clicks_on_search_field() throws Throwable {
        newCheckoutPage.clickOnSearchField();
    }


    @And("^user verify On CVV screen,clicking on done dismiss keyboard$")
    public void user_verify_on_cvv_screenclicking_on_done_dismiss_keyboard() throws Throwable {
        newCheckoutPage.keyboardDismissed();
    }

    @And("^User verify CTA on CVV screen will be active after user has entered 3 digits$")
    public void user_verify_cta_on_cvv_screen_will_be_active_after_user_has_entered_3_digits() throws Throwable {
        newCheckoutPage.continueToReviewOrder();
    }

    @Then("^new user verify continue to contact info button takes users to contact info page$")
    public void new_user_verify_continue_to_contact_info_button_takes_users_to_contact_info_page() throws Throwable {
        //newCheckoutPage.navigateToContactInfo();
        newCheckoutPage.continueToContactInfo();
    }

    @Then("^user close the contact info page$")
    public void user_close_the_contact_info_page() throws Throwable {
        //   newCheckoutPage.clickCloseBtn();
        newCheckoutPage.clickCloseCTA();

    }

    @Then("^user close the contact info page for promocode$")
    public void user_close_the_contact_info_page_for_promocode() throws Throwable {


        newCheckoutPage.clickCloseBttn();

    }

    @And("^user taps on the payment card on the summary page$")
    public void user_taps_on_the_payment_card_on_the_summary_page() throws Throwable {
        newCheckoutPage.tapOnPaymentCard();
    }

    @Then("^user clicks on Edit button on CVV screen$")
    public void user_clicks_on_edit_button_on_cvv_screen() throws Throwable {
        newCheckoutPage.clickEditOnCvvScreen();
    }

    @Then("^new user verify continue to slot selection button takes users to slot selection page$")
    public void new_user_verify_continue_to_slot_selection_button_takes_users_to_slot_selection_page() throws
            Throwable {
        newCheckoutPage.navigateToSlotSelection();
    }

    @When("^user taps on 'edit' button on the slot selection screen$")
    public void user_taps_on_edit_button_on_the_slot_selection_screen() throws Throwable {
        newCheckoutPage.clickEditBtn();
    }

    @Then("^Saved Addresses page opens$")
    public void saved_addresses_page_opens() throws Throwable {
        newCheckoutPage.saveAddressPagedisplay();
    }

    @Then("^user verify already entered address for the current session will be selected by default$")
    public void user_verify_already_entered_address_for_the_current_session_will_be_selected_by_default() throws Throwable {
        newCheckoutPage.defaultAddressSelected();
    }

    @And("Custom tipping window is displayed")
    public void customTippingWindowIsDisplayed() {
        newCheckoutPage.custometipping();

    }

    @And("^User taps on the chevron icon$")
    public void user_taps_on_the_chevron_icon() throws Throwable {
        newCheckoutPage.clickEditAddress();
    }

    @Then("^user enters edit address screen$")
    public void user_enters_edit_address_screen() throws Throwable {
        newCheckoutPage.editAddressPagedisplayed();
    }

    @Then("^user verify selected address detail prefilled$")
    public void user_verify_selected_address_detail_prefilled() throws Throwable {
        newCheckoutPage.verifyAddress();
    }

    @And("^user clicks on back button$")
    public void user_clicks_on_back_button() throws Throwable {
        newCheckoutPage.clickEditAddBackBtn();
    }

    @And("^User can tap on plus icon to enter new address entry form$")
    public void user_can_tap_on_plus_icon_to_enter_new_address_entry_form() throws Throwable {
        newCheckoutPage.tapPlusIcon();
    }

    @Then("^user verify 'Save' CTA takes users to address list screen$")
    public void user_verify_save_cta_takes_users_to_address_list_screen() throws Throwable {
        newCheckoutPage.saveAddressPagedisplay();
    }

    @And("^user verify same address is displayed on slot selection screen that was previously selected$")
    public void user_verify_same_address_is_displayed_on_slot_selection_screen_that_was_previously_selected() throws Throwable {
        newCheckoutPage.verfifyAddressOnSlotScreen();
    }

    @And("^user verify 'Use this address' CTA takes users to slot selection screen$")
    public void user_verify_use_this_address_cta_takes_users_to_slot_selection_screen() throws Throwable {
        newCheckoutPage.tapsUseThisAddress();
    }

    @Then("^user verify plus icon to add address disappears after 13 addresses have been added$")
    public void user_verify_plus_icon_to_add_address_disappears_after_13_addresses_have_been_added() throws Throwable {
        newCheckoutPage.plusIconDissapears();
    }
   /* @When("^user enters more \"([^\"]*)\" details$")
    public void user_enters_more_something_details(String strArg1) throws Throwable {
        newCheckoutPage.enterNewAddressDetails(newCheckoutPage.getAddress(strArg1));
    }*/

    @Then("^user clicks on slot selection card on order summary page$")
    public void user_clicks_on_slot_selection_card_on_order_summary_page() throws Throwable {
        newCheckoutPage.tapSlotSelctionCard();
    }

    @And("^User is able to see age restricted message$")
    public void user_is_able_to_see_age_restricted_message() throws Throwable {
        newCheckoutPage.verifyAgeRestrictedMsg();
    }

    @And("^user clicks on continue to payment method button$")
    public void user_clicks_on_continue_to_payment_method_button() throws Throwable {
        newCheckoutPage.clickPaymentMethod();
    }

    @And("^user clicks on close button$")
    public void user_clicks_on_close_button() throws Throwable {
        newCheckoutPage.exitslotselectionscreen();
    }

    //verify pop-up appears informing about changes
    @Then("^verify pop-up appears informing about changes$")
    public void verify_yes_or_no_popup() throws Throwable {
        newCheckoutPage.verifypopup();
        // newCheckoutPage.placeOrderisDisplayed();
    }

    @Then("^verify Reserve Time popup window is displayed$")
    public void verify_reserve_time_is_displayed() throws Throwable {
        newCheckoutPage.reservetimeWindowisDisplayed();
        // newCheckoutPage.placeOrderisDisplayed();
    }

    @Then("^verify Add Promo code is displayed$")
    public void verify_add_promo_code_is_displayed() throws Throwable {
        newCheckoutPage.addPromocodeisDisplayed();
        // newCheckoutPage.placeOrderisDisplayed();
    }

    @When("^user clicks on Add promo code on checkout page$")
    public void user_clicks_on_add_promo_code() throws Throwable {
        newCheckoutPage.clickAddPromoCode();
    }

    @When("^user Add promo code on checkout page$")
    public void user_enter_add_promo_code() throws Throwable {
        newCheckoutPage.enterAddPromoCode();
    }

    @When("^user enters promocode \"FREEDELIVERY\" and click next on checkout page$")
    public void userEntersPromoCodeAndClickNextOnCheckoutPage(String arg0) throws Throwable {
        newCheckoutPage.addPromoCode(arg0);


    }


    @And("^user verify upon landing on CVV screen, cursor will be active in CVV entry field$")
    public void user_verify_upon_landing_on_cvv_screen_cursor_will_be_active_in_cvv_entry_field() throws Throwable {
        driver.switchTo().activeElement();
        newCheckoutPage.cvvScreen();
    }

    @Then("^user enters contact information$")
    public void user_entersContactInformation() throws Throwable {
        newCheckoutPage.enterContactInformation();
    }

    @Then("^User toggle for delivery in the slot selection screen$")
    public void user_toggle_for_delivery_in_the_slot_selection_screen() throws Throwable {
        newCheckoutPage.toggleToDelivery();
    }

    @Then("^user clears the text from search bar$")
    public void user_clears_the_text_from_search_bar() throws Throwable {
        //homePage.clickSearchBar();
        //homePageElements.clickSearch.clear();
        newCheckoutPage.clearSearchtext();
    }

    @And("^User lands Checkout summary page$")
    public void user_lands_checkout_summary_page() throws Throwable {
        newCheckoutPage.navigateToCheckout();
    }

    @Then("^user verify continue to Review Order button takes users to Checkout summary page$")
    public void user_verify_continue_to_review_order_button_takes_users_to_checkout_summary_page() throws Throwable {
        newCheckoutPage.navigateToCheckout();
    }

    @Then("^user close the slot selection page$")
    public void user_close_the_slot_selection_page() throws Throwable {
        newCheckoutPage.clickCloseBttn();
    }

    @Then("user see message Text me my order status on screen")
    public void userSeeMessageTextMeMyOrderStatusOnScreen() {
        newCheckoutPage.verifyTextOrderStatusMessage();
    }

    @When("user update toggle for SMS in contact info")
    public void userUpdateToggleForSMSInContactInfo() {
        newCheckoutPage.updateContactToggle();

    }

    @Then("user see warning message Turn on order status text messages")
    public void userSeeWarningMessageTurnOnOrderStatusTextMessages() {
        newCheckoutPage.verifyWarningTextOrderStatus();
    }


    @And("user clicks save button")
    public void user_clicks_save_button() {
        newCheckoutPage.clickSaveButton();
    }


    @And("^user verify card logo and last 4 digits displays as \"([^\"]*)\"$")
    public void user_verify_card_details(String cardLastDigits) throws Throwable {
        newCheckoutPage.cardLogoDisplayed();
        newCheckoutPage.validateCardNumber(cardLastDigits);
    }

    @When("^user clicks payment tile on summary page$")
    public void user_clicks_payment_tile_on_summary_page() throws Throwable {
        newCheckoutPage.clickPaymentTile();

    }

    @And("^user clicks on Cart card on checkout page$")
    public void user_clicks_on_cart_card_on_checkout_page() throws Throwable {
        newCheckoutPage.clickOnCartCard();
    }

    @Then("^User verify that the cart value is less than 30 dollars$")
    public void user_verify_that_the_cart_value_is_less_than_30_dollars() throws Throwable {
        newCheckoutPage.verifyCartValueLessThan30$();
    }

    @And("^user clicks back button to close the cart and land on checkout$")
    public void user_clicks_back_button_to_close_the_cart_and_land_on_checkout() throws Throwable {
        newCheckoutPage.clickBackBtnToCloseCart();
    }

    @And("^user is able to see the alert message as cart size goes less than 30 dollars$")
    public void user_is_able_to_see_the_alert_message_as_cart_size_goes_less_than_30_dollars() throws Throwable {
        newCheckoutPage.verifyCartDeficitAlertMsg();
    }


    @And("^user change quantity to \"([^\"]*)\" for all item in shopping cart$")
    public void user_change_quantity_to_something_for_all_item_in_shopping_cart(String strArg1) throws Throwable {
        //newCheckoutPage.reduceItemsinCart(strArg1);
        ggCartpage.decrementProductQuantity();
        //newCheckoutPage.reduceItemsinCart(strArg1);

    }

    @And("user validates copy tipping")
    public void userValidatesCopyTipping() {
        newCheckoutPage.copytipping();
    }

    @And("user validates change at driver tipping and click change")
    public void userValidatesChangeAtDriverTipping() {
        newCheckoutPage.tippingchangeclickable();
        newCheckoutPage.custometipping();
    }

    @And("user validates driver tipping text")
    public void userValidatesDriverTippingText() {
        newCheckoutPage.tippingtext();
    }


    @When("user clicks on slotselction screen")
    public void userClicksOnSlotselctionScreen() {
        newCheckoutPage.clickslot();
    }


    @And("^user clicks on items count icon displaying plus minus$")
    public void user_clicks_on_items_count_icon_displaying_plus_minus() throws Throwable {
        newCheckoutPage.clickItemsCount();
    }


    @Then("user is able to save tipping")
    public void userIsAbleToSaveCustomTipping() {
        newCheckoutPage.custometipping();
        newCheckoutPage.customtipApply();
    }

    @Then("Validate save tab is enabled")
    public void validateSaveTabIsEnabled() {
        newCheckoutPage.savetipping();
    }


    @And("user validates the percentageof tipping")
    public void userValidatesThePercentageofTipping() {
        newCheckoutPage.tippercent();
    }


    @And("validates that user can select any tipping percentage")
    public void validatesThatUserCanSelectAnyTippingPercentage() {
        newCheckoutPage.firsttip();
        newCheckoutPage.secondtip();
        newCheckoutPage.thirdtip();
    }

    @Then("user is able to save zero tipping")
    public void userIsAbleToSavezeroTipping() {
        newCheckoutPage.custometipping();
        newCheckoutPage.customtipZero();
    }

    @Then("^user verify thumbnails of 4 items is shown$")
    public void user_verify_thumbnails_of_4_items_is_shown() throws Throwable {
        newCheckoutPage.verifyProductIconsOnCartsCard();
    }

    @And("^If there are more than 4 items, plus X will be shown$")
    public void if_there_are_more_than_4_items_plus_x_will_be_shown() throws Throwable {
        newCheckoutPage.verifyFourPlusXItemsOnCartsCard();
    }

    @And("^total number of items will be shown$")
    public void total_number_of_items_will_be_shown() throws Throwable {
        newCheckoutPage.verifyitemsCountOnCartsCard();
    }

    @And("^the entire feild will be tappable, not just the chevron$")
    public void the_entire_feild_will_be_tappable_not_just_the_chevron() throws Throwable {
        newCheckoutPage.verifyCompleteCartscardIsTappable();
    }

    @And("user taps on custom tip and Enters more than 100 dollars")
    public void updateCustomTipAndValidateErrorMessage() {
        newCheckoutPage.updateCustomTipAndVerify();
    }


    @And("^user verify driver tipping option is not displayed")
    public void user_verify_driver_tipping_option_not_displaying() throws Throwable {
        newCheckoutPage.verifyDriverTippingOptionNotDisplayed();
    }

    @And("user verify driver tipping option is displayed")
    public void userVerifyDriverTippingOptionIsDisplayed() {
        newCheckoutPage.verifyDriverTippingOptionDisplayed();
    }

    @When("user update tip to {int}%")
    public void userUpdateTipTo(int arg0) {
        newCheckoutPage.updateTip();
    }

    @Then("user validates driver tip is not added to order")
    public void userValidatesDriverTipIsNotAddedToOrder() {
        newCheckoutPage.tipnotdiplayed();
    }

    @Then("user validates driver tip is not added in order confirmation page")
    public void userValidatesDriverTipIsNotAddedInOrderConfirmationPage() {
        newCheckoutPage.Notipatordercofirmation();
    }

    @Then("user verifies driver tip on order confirmation")
    public void userVerifiesDriverTipOnOrderConfirmation() {
        newCheckoutPage.giventipatOrdersummery();
    }

    @Then("user clicks edit button on order confirmation page")
    public void userClicksEditButtonOnOrderConfirmationPage() {
        newCheckoutPage.editatordersummery();

    }

    @And("user verifies driver tip  in edit order")
    public void userVerifiesDriverTipInEditOrder() {
        newCheckoutPage.tipatEditpage();
    }


    @And("user validates driver tip at edit page")
    public void userValidatesDriverTipAteditPage() {
        newCheckoutPage.tipafterchange();
    }


    @And("user validates driver tip at Order summery page")
    public void userValidatesDriverTipAtOrderSummeryPage() {
        newCheckoutPage.validatetipatOrdersummery();
    }

    @Then("user clicks confirm changes at edit page")
    public void userClicksConfirmChangesAtEditPage() {
        newCheckoutPage.clickconfirm();
    }

    @Then("user selects desired tip percentage in driver tip and  click save")
    public void userSelectsInDriverTipAndClickSave() {
        newCheckoutPage.selectDesiredtip();
    }

    @And("^user note the order number$")
    public void user_note_the_order_number() throws Throwable {
        newCheckoutPage.userNotesOrderNumber();
    }

    @Then("^user clicks on orders button$")
    public void user_clicks_on_orders_button() throws Throwable {
        newCheckoutPage.clickOnOrderBtn();
    }

    @Then("^user lands on order history page$")
    public void user_lands_on_order_history_page() throws Throwable {
        newCheckoutPage.veriyOrderHistoryPage();
    }

    @Then("^user verify Map displayed for Delivery Order in the Order History screen$")
    public void user_verify_map_displayed_for_delivery_order_in_the_order_history_screen() throws Throwable {
        newCheckoutPage.verfiyMapOnOrderHistoryPage();
    }

    @And("^user verify the order number$")
    public void user_verify_the_order_number() throws Throwable {
        newCheckoutPage.verifyOrderNumber();
    }


    @Then("^user clicks on track order to go to order details page$")
    public void user_clicks_on_track_order_to_go_to_order_details_page() throws Throwable {
        newCheckoutPage.clickTrackOrder();
    }

    @Then("^user clicks on cancel order$")
    public void user_clicks_on_cancel_order() throws Throwable {
        newCheckoutPage.clickCancelOrder();
    }

    @Then("^user verify the cancel order popup appears$")
    public void user_verify_the_cancel_order_popup_appears() throws Throwable {
        newCheckoutPage.verifyCancelOrderPopUp();
    }

    @Then("^Verify the copy in the pop up \"([^\"]*)\"$")
    public void verify_the_copy_in_the_pop_up_something(String strArg1) throws Throwable {
        newCheckoutPage.verifyCancelOrderCopy(strArg1);
    }

    @And("^Verify the Pop up tittle be \"([^\"]*)\"$")
    public void verify_the_pop_up_tittle_be_something(String strArg1) throws Throwable {
        newCheckoutPage.verifyCancelOrderTitle(strArg1);
    }

    @And("^user scroll down for track order link$")
    public void user_scroll_down_for_track_order_link() throws Throwable {
        newCheckoutPage.scrollDownToFind();
    }

    @And("^user scroll down for cancel order link$")
    public void user_scroll_down_for_cancel_order_link() throws Throwable {
        newCheckoutPage.scrollDownToFindCO();

    }


}





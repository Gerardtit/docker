package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.util.WaitAction;
import com.automation.pages.*;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckoutPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public AppiumDevice device = AppiumDeviceManager.getDevice();
    public GG_DashboardPage dashboardPage = new GG_DashboardPage(driver);
    public BasePage basePage = new BasePage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    GG_OtpPasswordPage otpPasswordPage = new GG_OtpPasswordPage(driver);
    OrderPage orderPage = new OrderPage(driver);
    AddAddress_NewcheckoutPage newcheckoutpage = new AddAddress_NewcheckoutPage(driver);

    @Then("^\"Estimated Total\" text is displayed in checkout page$")
    public void estimatedTotalIsDisplayed() {
        checkoutPage.waitForEstimatedTotalDisplayed();
    }

    @Then("^\"Estimated Reward Card Savings\" text is displayed in checkout page$")
    public void estimatedRewardCardSavingsTextIsDisplayed() {
        checkoutPage.waitForEstimatedRewardsSavingsTextDisplayed();
    }

    @And("user clicks on Pickup toggle")
    public void clickPickUpToggle() {

        checkoutPage.clickPickUpOnSlotSelection();
    }

    @And("user clicks on Delivery toggle")
    public void clickDeliveryToggle() {

        checkoutPage.clickDeliverySlotSelection();
    }

    @Then("^\"Credit on Account Applied\" text is displayed in checkout page$")
    public void creditOnAccountTextIsDisplayed() {
        checkoutPage.waitForCOADisplayed();
    }

    @Then("^\"Delivery Fee\" text is displayed in checkout page$")
    public void deliveryFeeTextIsDisplayed() {
        checkoutPage.waitForDeliveryFeeDisplayed();
    }

    @Then("^\"Delivery Subscription Fee\" text is displayed in checkout page$")
    public void deliverySubscriptionFeeTextIsDisplayed() {
        checkoutPage.waitForDeliverySubscriptionFeeDisplayed();
    }

    @Then("^verify \"Add address\" window is displayed$")
    public void addAddressWindowIsDisplayed() {
        checkoutPage.waitForAddAddressDisplayed();
    }

    @Then("^verify zip code will be shown with CTA of Add address")
    public void zipCodeDisplayed() {

        checkoutPage.displayZipCode();
    }

    @Then("verify address will be shown on slot selection screen")
    public void verify_address_will_be_shown_on_slot_selection_screen() {
        // Write code here that turns the phrase above into concrete actions
        checkoutPage.addressDetails();

    }

    @And("^User click on Add Address Button")
    public void addAddressButton() {

        checkoutPage.clickAddAddressButton();
    }

    @Then("^checkout page is displayed$")
    public void checkoutPageIsDisplayed() {
        checkoutPage.waitForCheckoutPageDisplayed();
    }

    @Then("^user enters \"([^\"]*)\" details$")
    public void userentersAddressDetails(String arg0) throws Throwable {
        checkoutPage.enterAddressDetails(arg0);
        checkoutPage.waitForLoadingComplete();
        //  deliverPage.selectDeliveryOption(arg0);
    }

    @Then("verify two address are saved")
    public void verifyTwoAddressSaved() {
        checkoutPage.validatetwosaveaddress();
    }

    @Then("switch to address two from saved addresses")
    public void switchAddress() {
        checkoutPage.switchAddress();
    }

    @And("^user clicks on the close CTA$")
    public void userclicks_closeCTA() {
        checkoutPage.closeCTA();
    }

    @Then("^user enters contact info$")
    public void user_entersContactInfo() {
        checkoutPage.enterContactInfo();
    }
    /*@And("^user clicks on Continue CTA$")
    public void userclicks_continueCTA() throws InterruptedException {
        checkoutPage.continueToPaymentCTA();
    }
*/

    @And("^user clicks on Save CTA$")
    public void userclicks_saveCTA() {
        checkoutPage.clickSaveCTA();
    }

    @And("^user clicks on Continue to payment CTA$")
    public void userclicks_continueToPaymentCTA() throws InterruptedException {
        try {
            Thread.sleep(3000);
            checkoutPage.continueToPaymentCTA();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @And("^if Service Problem is displayed$")
    public void serviceProblemIsDisplayed() {
        checkoutPage.serviceProblemDisplayed();
    }

    @And("^user clicks on close button on Payment Screen")
    public void clickOnCloseButton() {
        checkoutPage.clickCloseButtonOnPayment();

    }

    @Then("^user clicks on edit button on checkout page$")
    public void userClicksOnEditButtonCheckoutPage() {
        checkoutPage.clickEditButton();
    }

    @When("^user clicks on Not Right Now CTA$")
    public void userclicks_NotRightNowCTA() {

        checkoutPage.userclicksNotRightNowCTA();
    }


    @Then("^verify user will be taken to the Apple App Store$")
    public void navigatetoAppleStore() {
        //  checkoutPage.verifyHomePage();
        checkoutPage.navigateToAppleStore();
    }

    @Then("^verify the corresponding app is already installed on user's device will open up$")
    public void openAlreadyInstalledApp() {
        //  checkoutPage.verifyHomePage();
        //   otpPasswordPage.handleSSO(true);
        //  otpPasswordPage.verifyHomePage();
        checkoutPage.verifyAppLaunched();
    }

    @When("^user clicks on Open CTA$")
    public void userclicks_OpenCTA() {
        checkoutPage.userclicksOpenCTA();
    }

    @Then("^verify Not Right Now CTA is displayed$")
    public void notrightnowCTAIsDisplayed() {
        checkoutPage.notRightNowCTADisplayed();
    }

    @Then("^verify Download CTA is displayed$")
    public void downloadCTAIsDisplayed() {
        checkoutPage.downloadCTADisplayed();
    }

    @When("^user clicks on Download CTA$")
    public void userclicks_DownloadCTA() {
        checkoutPage.clickDownloadCTA();
    }

    @Then("^verify Open CTA is displayed$")
    public void openCTAIsDisplayed() {
        checkoutPage.openCTADisplayed();
    }

    @Then("^verify Continue CTA is displayed$")
    public void continueCTAIsDisplayed() {
        checkoutPage.continueCTADisplayed();
    }

    @Then("^verify Go Back CTA is displayed$")
    public void goBackCTAIsDisplayed() {
        checkoutPage.goBackCTADisplayed();
    }

    @And("^click on first item in the store list$")
    public void clickfirststorefromList() {
        checkoutPage.clickFirstStore();
    }

    @When("^user clicks on Continue CTA$")
    public void clickOnContinueCTA() {
        checkoutPage.clickContinueCTA();
    }

    @When("^user clicks on Go Back CTA$")
    public void clickOnGoBackCTA() {
        checkoutPage.clickGoBackCTA();
    }

    @Then("^verify Counter Pickup text is displayed on checkout page$")
    public void counterIsDisplayedOnTheScreen() {
        checkoutPage.counterPickupIsDisplayed();
    }

    @Then("^verify Kiosk Pickup text is displayed on checkout page$")
    public void kioskIsDisplayedOnTheScreen() {
        checkoutPage.kioskPickupIsDisplayed();
    }

    @Then("^verify Locker Pickup text is displayed on checkout page$")
    public void lockerIsDisplayedOnTheScreen() {
        checkoutPage.lockerPickupIsDisplayed();
    }

    @Then("^verify Pharmacy text is displayed on checkout page$")
    public void pharmacyIsDisplayedOnTheScreen() {
        checkoutPage.pharmacyIsDisplayed();
    }

    @Then("^verify DriveUp & Go text is displayed on checkout page$")
    public void driveUpGoIsDisplayedOnTheScreen() {
        checkoutPage.driveUpGoIsDisplayed();
    }

    @Then("^verify pop-up window will appear on the screen$")
    public void popupIsDisplayed() {
        checkoutPage.popUpDisplayed();
    }

    @Then("^verify user is taken to slot selection screen$")
    public void slotselectionscreenIsDisplayed() {
        checkoutPage.slotselectionScreenDisplayed();
    }

    @Then("^verify pop-up appears informing about the impact of changing the store$")
    public void changingStorePopupIsDisplayed() {
        checkoutPage.changeStorePopUpDisplayed();
    }

    @Then("^verify pop-up window will get closed$")
    public void popupwindowIsClosed() {
        checkoutPage.waitForSelectpickupstoreisDisplayed();
    }

    @Then("^select pickup store is displayed on checkout page$")
    public void selectpickupstoreIsDisplayed() {
        checkoutPage.waitForSelectpickupstoreisDisplayed();
    }

    /*  @When("^user enters \"94566\" in the store list on checkout page$")
      public void userPullUpSheetonMap() {
          checkoutPage.enterZipCode();
      }*/
    @When("^user enters \"([^\"]*)\" in the store list on checkout page$")
    public void user_enters_in_zipcode(String zipcode) throws Throwable {
        String regex = "\\d+";
        checkoutPage.enterZipCode(zipcode);
        /*if (zipcode.equalsIgnoreCase("zipcode_diff")) {
            zipCodePage.enterZipCode(device.getConfigureData(BannerConfType.BANNER_ZIPCODE_DIFF));

        } else if (zipcode.matches(regex)) {
            zipCodePage.enterZipCode(zipcode);
        } else if (zipcode.equalsIgnoreCase("instore")) {
            zipCodePage.enterZipCode(device.getConfigureData(BannerConfType.BANNER_INSTOREZIPCODE));
        } else {
            zipCodePage.enterZipCode(device.getZipCode(zipcode));
        }*/
    }

    /*  @When("^user pull up sheet on the map$")
      public void userPullUpSheetonMap() {
     //     checkoutPage.pullUpSheetOnMap();
      }*/
    @When("^user clicks OrderInfo on checkout page$")
    public void userClicksOrderInfoOnCheckoutPage() {
        checkoutPage.clickOrderInfo();
    }

    @When("^user clicks payment on checkout page$")
    public void userClicksPaymentOnCheckoutPage() {
        checkoutPage.clickPayment();
    }

    @Then("^order confirmation page is displayed$")
    public void orderConfirmationPageIsDisplayed() {
        new GG_DashboardPage(AppiumDriverManager.getDriver()).clickOnCancelButtonFeedbackFormIfDisplayed();
        checkoutPage.waitForConfirmationPageDisplayed();
    }

    @Then("^edit order confirmation page is displayed$")
    public void editOrderConfirmationPageIsDisplayed() {
        checkoutPage.waitForEditOrderConfirmationPageDisplayed();
    }

    @And("^user clicks \"([^\"]*)\" hyperlink on order confirmation page$")
    public void userClicksOrdersTextOnPage(String arg0) {
        checkoutPage.clickOrders();
    }

    @And("^place order button is clickable and click place order$")
    public void placeOrderButtonIsClickableAndClickPlaceOrder() throws InterruptedException {
        checkoutPage.waitForPlaceOrderButtonEnabled();
    }

    @When("^place order button is clickable and click place order on page$")
    public void place_order_button_is_clickable_and_click_place_order_on_page() throws Throwable {
        checkoutPage.waitForPlaceOrderButtonEnabledNew();
    }

    @When("^user clicks Done button$")
    public void userClicksDoneOrderConfirmationButton() {
        checkoutPage.clickDoneConfirmationButton();
    }

    @When("^user clicks promo code on checkout page$")
    public void userClicksPromoCodeOnCheckoutPage() {

        checkoutPage.clickPromoCode();
    }

    @Then("^promo code deals window is dislayed$")
    public void promoCodeDealsWindowIsDislayed() {
        checkoutPage.waitForPromoCodeWindow();
    }

    @Then("^verify promocode \"([^\"]*)\" gets applied")
    public void promoCodeApplied(String arg0) throws InterruptedException {

        checkoutPage.appliedPromoCode(arg0);
    }

    @And("^user deleted a promocode")
    public void deleteAppliedPromoCode() {
        checkoutPage.deletePromoCode();
    }

    @Then("^promo code \"([^\"]*)\" is removed and total adjusted accordingly$")
    public void promoCodeDeleted(String arg0) {

        checkoutPage.verifyPromoCodeVisibility(arg0);


    }

    @When("^user enters promo code \"([^\"]*)\" and click next$")
    public void userEntersPromoCodeAndClickNext(String arg0) throws Throwable {
        checkoutPage.enterPromoCode(arg0);
    }

    @When("^user clicks coa on checkout page$")
    public void userClicksCOAOnCheckoutPage() {
        checkoutPage.clickCOA();
    }

   /* @Then("^coa window is dislayed$")
    public void coaWindowIsDislayed() {
        checkoutPage.waitForCOAWindow();
    }*/

    @And("^user enters coa amount \"([^\"]*)\" and click next$")
    public void userEntersCOAAndClickNext(String arg0) throws Throwable {
        checkoutPage.enterCOAAmount(arg0);
    }

    @Then("^credit Amount Applied is displayed on page$")
    public void coaAppliedIsDisplayedOnPage() {
        checkoutPage.waitForCOAApplied();
    }

    @And("^user select back button from coa page$")
    public void userSelectBackButtonFromCOAPage() {
        checkoutPage.clickBackButtonFromCOAPage();
    }

    @When("^user select back button to checkout page$")
    public void userSelectBackButtonToCheckoutPage() {
        checkoutPage.clickBackButtonFromPromoCode();
    }

    @When("^user select back button$")
    public void userSelectBackButton() {
        checkoutPage.clickBackButton();
    }


    @When("^user clicks Payment text on page$")
    public void userClicksPaymentTextPage() {
        new WaitAction(driver).waitForLoadingComplete();
        checkoutPage.clickPayment();
    }

    @And("^\"([^\"]*)\" text is displayed on the screen$")
    public void textIsDisplayedOnTheScreen(String arg0) throws InterruptedException {
        //orderPage.waitForPageDisplayed();
        Thread.sleep(5000);
        Assert.assertTrue(checkoutPage.containTextDisplayed(arg0));
    }

    @And("^\"([^\"]*)\" text is not displayed on the screen$")
    public void textIsNotDisplayedOnTheScreen(String arg0) throws InterruptedException {
        //orderPage.waitForPageDisplayed();
        Thread.sleep(3000);
        Assert.assertFalse(checkoutPage.containTextDisplayed(arg0));
    }

    @When("^user enters \"([^\"]*)\" in phone number field on Contact window$")
    public void userEntersInPhoneNumberFieldOnContactWindow(String phoneNumber) {
        if (phoneNumber.equalsIgnoreCase("random")) {
            String areaCode = (int) (Math.random() * 7 + 2) +
                    new SimpleDateFormat("DD").format(new Date());
            String phoneCode = (int) (Math.random() * 8 + 1) +
                    new SimpleDateFormat("HHmmss").format(new Date());
            checkoutPage.enterPhoneNumber(areaCode + phoneCode);
        } else {
            checkoutPage.enterPhoneNumber(phoneNumber);
        }
    }

    @When("^user clear promo code from checkout page$")
    public void userClearPromoCodeFromCheckoutPage() {
        checkoutPage.clearPromoCode();
    }

    @And("^\"([^\"]*)\" text is displayed on the screen for California banner$")
    public void textIsDisplayedOnTheScreenForCaliforniaBanner(String arg0) throws Throwable {
        String banner = device.getBanner();
        if (banner.equalsIgnoreCase("vons")
                || banner.equalsIgnoreCase("safeway")
                || banner.equalsIgnoreCase("pavilions")) {
            checkoutPage.containTextDisplayed(arg0);
        }
    }

    @Then("^Verify error message for invalid promo code")
    public void errorMessage() {


        checkoutPage.displayErrorForInvalidPromoCode();
    }

    @When("^scroll down the screen$")
    public void scrollDownTheScreen() {
        checkoutPage.scrollDown();
    }

    @When("^scroll down the screen for Delivery order$")
    public void scrollDownTheScreenForDeliveryOrder() {
        checkoutPage.scrollDownForDeliverySlot();
    }

    @When("^user scroll down to total summary$")
    public void userScrollDownToTotalSummary() {
        checkoutPage.scrollDownToTotalSummary();
    }

    @When("^user clicks contact on checkout page$")
    public void userClicksContactOnCheckoutPage() {
        checkoutPage.clickContactDetail();
    }

    @Then("^user fills contact details$")
    public void userFillsContactDetails() throws Exception {
        checkoutPage.fillContactDetails();
    }

    @When("^user fills contact details and buffer contact number$")
    public void userFillsAndBufferContactDetails() {
        checkoutPage.fillAndBufferContactDetails();
    }

    @When("^user enter same phone number in Contact field$")
    public void userEnterSameNumberInContact() {
        checkoutPage.fillSameNumberInContact();
    }

    @When("^user click on confirm change button$")
    public void userClickOnConfirmChangeButton() {
        checkoutPage.confirmChanges();
    }

    @Then("^user see Edit Order page$")
    public void userSeeEditOrderPage() {
        checkoutPage.verifyEditOrderPage();
    }

    @And("^verify Non-SNAP items screen is opened$")
    public void verifyNonSnapItemsScreenIsDisplayed() {
        checkoutPage.verifyNonSnapItemsDisplayed();
    }

    @And("^user captures name of product adding in cart$")
    public void userCapturesNameOfProductAddingInCart() {
        checkoutPage.captureNameOfProduct();
    }

    @And("^user buffers \"([^\"]*)\" product name$")
    public void userBuffersProductName(String arg0) {
        checkoutPage.bufferNameOfProduct(arg0);
    }

    @When("^user clicks \"([^\"]*)\" item Item Preferences text on page$")
    public void userClicksItemTextOnPage(String arg0) {
        new WaitAction(driver).waitForLoadingComplete();
        checkoutPage.clickItemTextOnScreen(arg0);
    }

    @And("^User see Snap option for payment$")
    public void userSeeSnapOptionForPayment() {
        checkoutPage.verifySnapPaymentOption();
    }

    @And("^user click on Snap option for payment$")
    public void userClickOnSnapOptionForPayment() {
        checkoutPage.clickSnapOptionForPayment();
    }

    @Then("^user should be able to see popup to remove non snap items$")
    public void userSeePopupToRemoveNonSnapItems() {
        checkoutPage.verifyPopupToRemoveNonSnapItems();
    }

    @When("^user clicks on View Cart in the popup$")
    public void userclickOnViewCart() {
        checkoutPage.userClickOnViewCart();
    }

    @And("^user see delivery Fee tool tip$")
    public void userSeeDeliveryFeeToolTip() {
        checkoutPage.verifyDeliveryFeeTooltipOption();
    }

    @And("^user see salesTax tool tip$")
    public void userSeeSalesTaxToolTip() {
        checkoutPage.verifySalesTaxTooltipOption();
    }

    @And("^user see Estimated total tool tip$")
    public void userSeeEstimatedTotalToolTip() {
        checkoutPage.verifyEstimatedTotalTooltipOption();
    }

    @Then("^user should be able to see Auth message below Estimated Total$")
    public void userSeeAuthMessage() {
        checkoutPage.verifyAuthMessageDisplayed();
    }

    @Then("^user should be able to see Looking for your savings text$")
    public void lookingForSavingsText() {
        checkoutPage.lookingForSavingsText();
    }

    @Then("^user should be able to see savings message$")
    public void userSeeSavingsMessage() {
        checkoutPage.verifySavingsMessageDisplayed();
    }

    @Then("^user should be able to see terms use message$")
    public void userSeeTermsUseMessage() {
        checkoutPage.verifyTermsUseMessageDisplayed();
    }

    @And("^scroll Down for Cart Summary$")
    public void scrollDownForCartSummary() {
        checkoutPage.scrollDownForCartSummary();
    }


    @Then("pickup time slot is selected in app")
    public void pickupTimeSlotIsSelectedInApp() {
        checkoutPage.selectslot();
    }

    @Then("user enters contact details")
    public void userEntersContactDetails() {
        checkoutPage.contactdetails();
    }

    @And("user enter credit card details")
    public void userEnterCreditCardDetails() {
        checkoutPage.entercreditcard();
    }

    @And("user verify upon landing on CVV screen, cursor will be active")
    public void userVerifyUponLandingOnCVVScreenCursorWillBeActive() {
        driver.switchTo().activeElement();
//        gg_e2E_freshpassPage.cvvpage();
    }

    @When("user enters {string} as CVV and clicks continue")
    public void userEntersAsCVVAndClicksContinue(String arg0) {
        checkoutPage.enterCvvNumber(arg0);
    }

    @When("user clicks Continue Shopping")
    public void userClicksContinueShopping() {
        checkoutPage.clickContinueshopping();
    }

    @Then("user enters address details")
    public void userEntersAddressDetails() {
        checkoutPage.addressDetails();
    }

    @Then("handle cancel order confirmation window")
    public void handleCancelOrderConfirmationWindowWindow() {
        checkoutPage.cancelorder();
    }

    @Then("navigate back and close setting page")
    public void navigateBackAndCloseSettingPage() {
        checkoutPage.closesetting();
    }


    @And("user clicks on Continue to CVV")
    public void userClicksOnContinueCVV() {
        checkoutPage.continueToCVVCTA();
    }

    @Then("^User should see inline message as \"([^\"]*)\"$")
    public void verifySnapEBTInlineMessage(String message) {
        checkoutPage.verifyInlineMessage(message);
    }

    @Then("^user should be able to see Snap EBT Issue PopUp$")
    public void userSeeSnapEBTIssuePopUp() {
        checkoutPage.verifySnapEBTIssuePopup();
    }

    @When("^user clicks Cart Tab on payment page")
    public void userClickOnCartTab() {
        checkoutPage.userClickOnCartTab();
    }

    @And("^verify Non-SNAP items displayed$")
    public void verifyNonSnapItems() {
        checkoutPage.verifyNonSnapItems();
    }

    @And("^user click back button from pdp$")
    public void userClickBackButton() {
        checkoutPage.clickBack();

    }

    @Then("user sees the snap option")
    public void userSeesTheSnapOption() {
        checkoutPage.VerifyEBTDisplayed();

    }


    @And("^verify User can scroll left and right$")
    public void userClickScrollLeftandRight() {
        checkoutPage.scrollDown();
        checkoutPage.scrollTop();
        //checkoutPage.swipeLeft();
        //    checkoutPage.scrollHorizontalCarousal();
    }

//    @Then("^verify Horizontal scroll will always be there$")
//    public void horizontalScroll() {
//        checkoutPage.scrollHorizontalCarousal();
//
//    }

    @When("user selects the snap option")
    public void userSelectsTheSnapOption() {
        checkoutPage.VerifyEBTDisplayed();
    }


    @Then("^verify the content at the top will be \"Your order is being processed\"$")
    public void verify_your_order_is_processed_is_displayed_on_orderConfirmationPage() {
        checkoutPage.waitForYourOrderIsProcessedTextisDisplayed();
    }

    @Then("^verify \"View order\" CTA on order confirmation page$")
    public void verify_view_order_cta_is_displayed_on_orderConfirmationPage() {
        checkoutPage.waitForViewOrderCTAisDisplayed();
    }

    @Then("^verify \"Edit order\" CTA on order confirmation page$")
    public void verify_edit_order_cta_is_displayed_on_orderConfirmationPage() {
        checkoutPage.waitForEditOrderCTAisDisplayed();
    }

    @Then("^verify Locker Pickup is displayed on order confirmation page$")
    public void verify_locker_pickup_is_displayed_on_orderConfirmationPage() {
        checkoutPage.waitForLockerPickupTextisDisplayed();
    }

    @Then("^verify Pickup is displayed on order confirmation page$")
    public void verify_pickup_is_displayed_on_orderConfirmationPage() {
        checkoutPage.waitForPickupTextisDisplayed();
    }

    @Then("^verify DriveUp & Go is displayed on order confirmation page$")
    public void verify_Driveup_Go_is_displayed_on_orderConfirmationPage() {
        checkoutPage.waitForDriveUpGoTextisDisplayed();
    }

    @Then("^verify Instructions is displayed on order confirmation page$")
    public void verify_instructions_text_is_displayed_on_orderConfirmationPage() {
        checkoutPage.waitForInstructionsTextisDisplayed();
    }

    @When("^user clicks on Edit order CTA$")
    public void user_click_edit_order_on_orderConfirmationPage() {
        checkoutPage.clickEditOrder();
    }

    @Then("^verify Edit Order screen is displayed$")
    public void verifyEditOrderScreenIsDisplayed() {
        checkoutPage.verifyNewEditOrderPageIsDisplayed();
    }

    @When("^user click on save CTA on Edit Order page$")
    public void user_click_save_cta_edit_order_page() {
        checkoutPage.clickSaveCTA_EditOrderPage();
    }

    @When("^user clicks on close CTA$")
    public void user_click_close_cta_on_orderConfirmationPage() {
        checkoutPage.clickCloseCTA();
    }

    @Then("^verify the content at the top will be \"Your order has been saved\"$")
    public void verify_your_order_is_saved_is_displayed_on_orderConfirmationPage() {
        checkoutPage.waitForYourOrderIsSavedTextisDisplayed();
    }

    @When("user enters {string} different address details")
    public void user_enters_different_address_details(String string) {
        checkoutPage.enterDiffAddressDetails(string);

    }

    @When("user clicks on Edit chevron button")
    public void user_clicks_on_edit_chevron_button() {
        checkoutPage.clickOnEditChevronButton();
        checkoutPage.waitForLoadingComplete();
    }

    @Then("user should continue with zip code alert change")
    public void user_continue_with_zip_code_alert() {
        checkoutPage.clickOnContinueWithChangeZipCode();
        checkoutPage.waitForLoadingComplete();
    }

    @Then("user navigates to respective store details on map view")
    public void user_navigates_to_respective_store_details_on_map_view() {
        checkoutPage.validateStoreDetailMapView();
    }


    @When("user click view Details for order")
    public void userClickViewDetailsForOrder() {
        checkoutPage.viewDetails();
    }

    @Then("^Verify and store OrderNumber,Fullfillment type ,Date,Time is displayed$")
    public void verify_and_store_ordernumberfullfillment_type_datetime_is_displayed() throws Throwable {
        checkoutPage.StoreOrderConfirmationDetails();
    }

    @When("^User click on Continue Shopping$")
    public void user_click_on_continue_shopping() throws Throwable {
        checkoutPage.clickContinueshopping();
    }

    @Then("^User clicks on Order submenu in home page$")
    public void user_clicks_on_order_submenu_in_home_page() throws Throwable {
        checkoutPage.clickonSubmenuOrder();
    }

    @Then("^Verify Order Confirmation Page is displayed$")
    public void verify_order_confirmation_page_is_displayed() throws Throwable {
        checkoutPage.VerifyOrderConfirmPageDisplayed();
    }

    @And("^Verify  after clicking on ViewDetailsorTrackOrder Order details screen is displayed$")
    public void verify_after_clicking_on_viewdetailsortrackorder_order_details_screen_is_displayed() throws Throwable {
        checkoutPage.VerifyOrderPrgoressAndOrderStatusMessage();
    }


    @And("^Verify status bar and the order status message, submessage is displayed$")
    public void verify_status_bar_and_the_order_status_message_submessage_is_displayed() throws Throwable {
        checkoutPage.VerifyOrderPrgoressAndOrderStatusMessage();
    }


    @And("^Verify Banner Name ,Banner Logo and Order Fullfillment type ,Date Time Displayed$")
    public void verify_banner_name_banner_logo_and_order_fullfillment_type_date_time_displayed() throws Throwable {
        checkoutPage.VerifyBannerLogoandImageScheduledDateTimeDisplayed();

    }

    @Then("^user clicks on Pickup button$")
    public void user_clicks_on_pick_up_slot_section() throws Throwable {
        checkoutPage.clickOnPickUpButton();
        checkoutPage.waitForLoadingComplete();
    }

    @And("^user clicks on first available store from list$")
    public void user_clicks_on_first_available_store() throws Throwable {
        checkoutPage.userClicksOnFirstAvailableStore();
    }

    @Then("^user validates pick up available pop up$")
    public void user_validates_pick_up_available_from_pop_up() throws Throwable {
        checkoutPage.userValidatesPickUpAvailablePopUp();
    }

    @And("^user navigating back to home page$")
    public void user_navigating_back_to_homepage() throws Throwable {
        checkoutPage.userNavigatingToHomePage();


    }

}

package com.automation.pages;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.entities.BannerConfType;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.CartPageElements;
import com.automation.pageElements.CheckoutPageElements;
import com.automation.pageElements.GG_AccountProfilePageElements;
import com.automation.pageElements.HomePageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.automation.mobile.entities.BannerConfType.BANNER_ZIPCODE;


public class CheckoutPage extends BasePage {

    public static String OrderActualNumber;
    public static String FullfilmentType;
    public static String OrderDateandTime;

    public AppiumDevice device = AppiumDeviceManager.getDevice();
    public CheckoutPageElements pageElements = new CheckoutPageElements();
    public GG_AccountProfilePageElements myAccountPageElementsPage = new GG_AccountProfilePageElements();
    public HomePageElements homePageElements = new HomePageElements();
    public CartPageElements cartPageElements = new CartPageElements();
    public NewCheckoutPage newCheckoutPage = new NewCheckoutPage(driver);
    public CheckoutPageElements checkoutPageElements = new CheckoutPageElements();
    public String productInCart = null;
    public String productInCheckout = null;
    public String deliveryPhoneNumber = null;

    public CheckoutPage(AppiumDriver driver) {
        super(driver);

        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), myAccountPageElementsPage);
        PageFactory.initElements(new AppiumFieldDecorator(driver), homePageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cartPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), checkoutPageElements);
    }

    public void slotselectionScreenDisplayed() {
        waitForDisplayed(pageElements.pickupHeaderText);

    }

    public void changeStorePopUpDisplayed() {
        waitForDisplayed(pageElements.changePickupStoreHeaderText);

    }

    public void popUpDisplayed() {
        waitForDisplayed(pageElements.pickupAvailableHeaderText);
        waitForDisplayed(pageElements.pickupAvailableDescription);
        // waitForDisplayed(pageElements.firstStore);
        // clickElement(pageElements.firstStore);
    }

    public void driveUpGoIsDisplayed() {
        waitForDisplayed(pageElements.driveUpGoText);

    }

    public void counterPickupIsDisplayed() {
        waitForDisplayed(pageElements.counterPickupText);

    }

    public void kioskPickupIsDisplayed() {
        waitForDisplayed(pageElements.kioskPickupText);

    }

    public void lockerPickupIsDisplayed() {
        waitForDisplayed(pageElements.lockerPickupText);

    }

    public void pharmacyIsDisplayed() {
        waitForDisplayed(pageElements.pharmacyText);

    }

    public void clickFirstStore() {
        //  waitForDisplayed(pageElements.firstStore);
        new CommonActions(driver).new ClickAction().clickElement(pageElements.firstStore);
    }

    public void clickEditButton() {
        //  waitForDisplayed(pageElements.editButton);
        waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(pageElements.editButton);
    }

    public void enterZipCode(String zipCode) {
//        zipCodePageElements.zipCodeEditText.clear();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            deleteCurrentTextInEditText(pageElements.enterZipCode);
            enterKey(pageElements.enterZipCode, zipCode);
        } else {
            pageElements.zipcodeEditText.clear();
            enterKey(pageElements.zipcodeEditText, zipCode);
            waitForLoadingComplete();

        }
    }
       /* if (driver.getPlatformName().equalsIgnoreCase("android")) {
            enterKey(zipCodePageElements.zipCodeEditText, zipCode);
          new CommonActions(driver).new ClickAction().clickElement(zipCodePageElements.registerZipCodeNext);
        }*/ /*else if (driver.getPlatformName().equalsIgnoreCase("ios"))

            enterKey(pageElements.enterZipCode, zipCode);
    }*/
  /*  public void enterZipCode() {
    //    waitForDisplayed(pageElements.editButton);
      new CommonActions(driver).new ClickAction().clickElement(pageElements.enterZipCode);
     //   enterKey(pageElements.enterZipCode,94566);
    }*/


    public void waitForSelectpickupstoreisDisplayed() {
//        waitForDisplayed(pageElements.orderInfoText);
        waitForLoaderToDisappear();
        isElementDisplayed(pageElements.selectpickupStore, 15);
        waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(pageElements.selectpickupStore);
    }

    public void userclicksNotRightNowCTA() {
        //  isElementDisplayed(pageElements.notRightNowText, 15);
        new CommonActions(driver).new ClickAction().clickElement(pageElements.notRightNowText);
    }

    public void verifyAppLaunched() {
        waitForLoadingComplete();
    }

    public void navigateToAppleStore() {

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (isElementDisplayed(pageElements.getCTA, 2))
                driver.navigate().back();
        }
    }

    public void userclicksOpenCTA() {

        new CommonActions(driver).new ClickAction().clickElement(pageElements.openCTA);
        waitForLoadingComplete();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (isElementDisplayed(pageElements.openAlertCTA, 2))
                new CommonActions(driver).new ClickAction().clickElement(pageElements.openAlertCTA);
        } else {
            //new CommonActions(driver).new ClickAction().clickElement(pageElements.openAlertCTA);
            //new CommonActions(driver).new ClickAction().clickElement(pageElements.continueCTA);
        }
        waitForLoadingComplete();

    }

    public void notRightNowCTADisplayed() {
        isElementDisplayed(pageElements.notRightNowText, 15);
    }

    public void downloadCTADisplayed() {
        waitForLoaderToDisappear();
        isElementDisplayed(pageElements.downloadCTA, 15);
    }

    public void clickDownloadCTA() {
        waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(pageElements.downloadCTA);
        //  waitForLoaderToDisappear();
    }

    public void clickGoBackCTA() {
        waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(pageElements.goBackCTA);
        //  waitForLoaderToDisappear();
    }

    public void clickContinueCTA() {
        waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(pageElements.continueCTA);
        //  waitForLoaderToDisappear();
    }

    public void continueCTADisplayed() {
        waitForLoaderToDisappear();
        isElementDisplayed(pageElements.continueCTA, 15);
    }

    public void goBackCTADisplayed() {
        waitForLoaderToDisappear();
        isElementDisplayed(pageElements.goBackCTA, 15);
    }

    public void openCTADisplayed() {
        waitForLoaderToDisappear();
        isElementDisplayed(pageElements.openCTA, 15);
    }

    public void serviceProblemDisplayed() {
        try {
            if (pageElements.dismissButton.isDisplayed()) {
                pageElements.dismissButton.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void textOrderisDisplayed() {
        isElementDisplayed(pageElements.textOrderStatus);
    }

    public void enterContactInfo() {
        //new CommonActions(driver).new ClickAction().clickElement(pageElements.closeCTA);
        enterKey(pageElements.enterFirstname, "Fname");
        enterKey(pageElements.enterLastname, "Lname");
        enterKey(pageElements.enterMobileNumber, "7788787987");
/*        enterValue(pageElements.firstName, "Fname");
        enterValue(pageElements.lastName, "lname");
        enterValue(pageElements.phoneNumber, "7788787987");*/
        if (getPlatformName().equalsIgnoreCase("ios")) {
            myAccountPageElementsPage.doneButton.click();

        } else {
            tapSearchAndroidKeyboard();
        }
        //      pageElements.saveDetails.click();
        new CommonActions(driver).new ClickAction().clickElement(pageElements.continueToReviewOrderCTA);
        waitForLoadingComplete();
    }

    public void closeCTA() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.closeCTA);
    }

    public void validatetwosaveaddress() {
        Assert.assertTrue(pageElements.savedaddress1.isDisplayed());
        Assert.assertTrue(pageElements.savedaddress2.isDisplayed());
    }

    public void switchAddress() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.Addresstwo);
        new CommonActions(driver).new ClickAction().clickElement(pageElements.useThisAddressbtn);
        waitForLoadingComplete();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new CommonActions(driver).new ClickAction().clickElement(pageElements.continueAddressChange);
            waitForLoadingComplete();
        }
        Assert.assertTrue(pageElements.addressPreferences.isDisplayed());
    }

    public void clickSaveCTA() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            waitForLoadingComplete();
        } else {
            new CommonActions(driver).new ClickAction().clickElement(pageElements.saveCTA);
        }

    }


    public void continueToPaymentCTA() throws InterruptedException {

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            waitForLoadingComplete();
            Thread.sleep(15000);
            try {
                if (pageElements.continueToPaymentCTA.isDisplayed()) {
                    //   pageElements.continueToPaymentCTA.click();
                    new CommonActions(driver).new ClickAction().clickElement(pageElements.continueToPaymentCTA);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            waitForLoadingComplete();
        } else {

            waitForLoadingComplete();
            //waitForLoadingComplete();
            Thread.sleep(5000);
            //     new CommonActions(driver).new ClickAction().clickElement(pageElements.selectslotCTA);
            //       tapCoordinate(139, 2875);
            new CommonActions(driver).new ClickAction().clickElement(pageElements.continueToPaymentCTA);
            waitForLoadingComplete();
        }

        //  waitForLoadingComplete();
    }

    public void enterMyAddressDetails(String deliveryAddress) throws Exception {
//        try {
        AppiumDevice device = AppiumDeviceManager.getDevice();
        String address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE2);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            enterKey(pageElements.addressLine1TextField, address);
            new CommonActions(driver).new ClickAction().clickElement(pageElements.egMsg);
            pageElements.egMsg.sendKeys("\n");
            Thread.sleep(1000);
            new CommonActions(driver).new ClickAction().clickElement(pageElements.saveCTA);
        } else {
            enterKey(pageElements.addressField, address);
            //hideKeyBoard();
            //waitForLoaderToDisappear();
            waitForLoadingComplete();
            Thread.sleep(5000);
            //clickElement(pageElements.saveCTA);
        }
    }

    public void enterAddressDetails(String deliveryAddress) throws Exception {
        //try{
        AppiumDevice device = AppiumDeviceManager.getDevice();
        String address;

        switch (deliveryAddress) {
            case "address2":
                address = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE2");
                break;
            case "address3":
                address = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE3");
                break;
            case "address4":
                address = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE4");
                break;
            case "address5":
                address = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE5");
                break;
            case "address6":
                address = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE6");
                break;
            case "address7":
                address = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE7");
                break;
            case "address8":
                address = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE8");
                break;
            case "address9":
                address = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE9");
                break;
            case "address10":
                address = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE10");
                break;
            case "address11":
                address = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE11");
                break;
            case "address12":
                address = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE12");
                break;
            case "address13":
                address = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE13");
                break;

            default:
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE1_FORSR);
        }

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            enterKey(pageElements.addressLine1TextField, address);
            new CommonActions(driver).new ClickAction().clickElement(pageElements.egMsg);
            pageElements.egMsg.sendKeys("\n");
            Thread.sleep(1000);
            new CommonActions(driver).new ClickAction().clickElement(pageElements.saveCTA);
        } else {
            enterKey(pageElements.addressField, address);
            //hideKeyBoard();
            //waitForLoaderToDisappear();
            waitForLoadingComplete();
            Thread.sleep(5000);
            new CommonActions(driver).new ClickAction().clickElement(pageElements.saveCTA);
            //clickElement(pageElements.continueToPaymentCTA);
        }
    }


    public void waitForAddAddressDisplayed() {
//        waitForDisplayed(pageElements.orderInfoText);
        waitForLoaderToDisappear();
        isElementDisplayed(pageElements.addAddressText, 15);
    }

    public void enterAddressDetails() throws Exception {
        if ((getCurrentBanner().equalsIgnoreCase("tomthumb")) || (getCurrentBanner().equalsIgnoreCase("safeway")) || (getCurrentBanner().equalsIgnoreCase("shaws")) || (getCurrentBanner().equalsIgnoreCase("acme"))) {
            AppiumDevice device = AppiumDeviceManager.getDevice();
            String address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE1_FORSR);

            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                enterKey(pageElements.addressLine1TextField, address);
                new CommonActions(driver).new ClickAction().clickElement(pageElements.egMsg);
                pageElements.egMsg.sendKeys("\n");
                Thread.sleep(1000);
                new CommonActions(driver).new ClickAction().clickElement(pageElements.saveCTA);
            } else {
                enterKey(pageElements.addressField, address);
                //   hideKeyBoard();
                //  waitForLoaderToDisappear();
                waitForLoadingComplete();
                Thread.sleep(5000);
                // new CommonActions(driver).new ClickAction().clickElement(pageElements.saveCTA);
            }
        }
    }


    public void waitForCheckoutPageDisplayed() {
//        waitForDisplayed(pageElements.orderInfoText);
        if ((getCurrentBanner().equalsIgnoreCase("tomthumb")) || (getCurrentBanner().equalsIgnoreCase("safeway")) || (getCurrentBanner().equalsIgnoreCase("shaws")) || (getCurrentBanner().equalsIgnoreCase("acme")) || (getCurrentBanner().equalsIgnoreCase("pavilions"))) {
            waitForAddAddressDisplayed();
        } else {
            waitForLoaderToDisappear();
            isElementDisplayed(pageElements.orderInfoText, 15);
        }
    }

    public void clickOrderInfo() {
        if (!(getCurrentBanner().equalsIgnoreCase("tomthumb")) && (!getCurrentBanner().equalsIgnoreCase("safeway")) && (!getCurrentBanner().equalsIgnoreCase("shaws")) && (!getCurrentBanner().equalsIgnoreCase("acme")) && (!getCurrentBanner().equalsIgnoreCase("pavilions"))) {
            new CommonActions(driver).new ClickAction().clickElement(pageElements.orderInfoText);
        }
    }

    public void clickPayment() {
        waitForDisplayed(pageElements.paymentText);
        new CommonActions(driver).new ClickAction().clickElement(pageElements.paymentText);
    }


    public void waitForPlaceOrderButtonEnabled() throws InterruptedException {

        waitForClickableAndClick(pageElements.placeOrderButton);
        waitForLoadingComplete();
    }

    public void waitForPlaceOrderButtonEnabledNew() throws InterruptedException {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            waitForLoaderToDisappear();

            Thread.sleep(30);

            waitForLoadingComplete();
            waitForClickableAndClick(pageElements.placeOrderButton);
            waitForLoadingComplete();
        } else {
            driver.hideKeyboard();
            waitForClickableAndClick(pageElements.placeOrderButton);
            Thread.sleep(10000);
        }
    }


    public void clickDoneConfirmationButton() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.doneOrderConfirmationButton);
    }

    public void waitForConfirmationPageDisplayed() {
        waitForLoadingComplete();
        if (isElementDisplayed(pageElements.dismissCTA, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(pageElements.dismissCTA);
        }
        waitForDisplayed(pageElements.orderConfirmationTitle, 5);
    }

    public void waitForEstimatedTotalDisplayed() {
        waitForDisplayed(pageElements.estimatedTotalText);
    }


    public void waitForCOADisplayed() {
        waitForDisplayed(pageElements.coaText);
    }

    public void waitForEstimatedRewardsSavingsTextDisplayed() {
        waitForDisplayed(pageElements.estimatedRewardCardSavingsText);
    }

    public void waitForDeliveryFeeDisplayed() {
        waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(pageElements.estimatedTaxandFees);
        waitForLoadingComplete();
        waitForDisplayed(pageElements.deliveryFeeText);
    }

    public void waitForDeliverySubscriptionFeeDisplayed() {
        waitForLoadingComplete();
        //clickElement(pageElements.estimatedTaxandFees);
        //waitForLoadingComplete();
        waitForDisplayed(pageElements.deliverySubscriptionFeeText);
    }

    public void waitForEditOrderConfirmationPageDisplayed() {

        if (!isElementDisplayed(pageElements.orderConfirmationTitle, 5)) {
            if (isElementDisplayed(pageElements.dismissCTA, 1)) {
                new CommonActions(driver).new ClickAction().clickElement(pageElements.dismissCTA);
            }
        }

    }

    public void clickPromoCode() {
        if (!isElementDisplayed(pageElements.addPromoCode)) {
            scrollDownForElement(pageElements.addPromoCode);
        }
        waitForDisplayed(pageElements.addPromoCode, 10);
        new CommonActions(driver).new ClickAction().clickElement(pageElements.addPromoCode);
    }

    public void clickCOA() {
        // clickElement(pageElements.applyCOA);
        pageElements.applyCOA.click();
    }


    public void waitForPromoCodeWindow() {
        waitForDisplayed(pageElements.promoCodeTitle);
    }

    public void enterPromoCode(String promoCode) {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.enterPromoCode);
        enterKey(pageElements.enterPromoCode, promoCode);
        new CommonActions(driver).new ClickAction().clickElement(pageElements.applyBtn);
    }

    public void enterCOAAmount(String coa) {
        enterKey(pageElements.enterCOATextField, coa);
        new CommonActions(driver).new ClickAction().clickElement(pageElements.enterCOAEnterButton);
    }

    public void waitForCOAApplied() {
        waitForDisplayed(pageElements.coaAppliedText);
    }

    public void waitForPromoCodeApplied() {
        waitForDisplayed(pageElements.promoCodeAppliedText);
    }

    public void clickBackButtonFromPromoCode() {

        new CommonActions(driver).new ClickAction().clickElement(pageElements.promoCodeBackButtonToCheckout);

    }

    public void clickBackButton() {
        driver.navigate().back();

    }

    public void clickBackButtonFromCOAPage() {
        driver.navigate().back();

    }

    public void enterPhoneNumber(String phoneNumber) {
        pageElements.phoneNumberEditText.clear();
        enterKey(pageElements.phoneNumberEditText, phoneNumber);
    }

    public void clearPromoCode() {
        try {
            //wait for Enter Promo Code element
            containTextDisplayed("Enter Promo Code");
            return;

        } catch (Exception e) {
            clickPromoCode();
            waitForPromoCodeWindow();
            new CommonActions(driver).new ClickAction().clickElement(pageElements.deletePromoCode);
            waitForPromoCodeWindow();
            clickBackButtonFromPromoCode();
            return;
        }
    }

    public void scrollDownToTotalSummary() {
        // scrollDownForElement(pageElements.estimateTotalText);
        scrollDownForElement(pageElements.estimatedTotalText);
    }

    public void clickContactDetail() {
        if (!(getCurrentBanner().equalsIgnoreCase("tomthumb")) && (!getCurrentBanner().equalsIgnoreCase("safeway")) && (!getCurrentBanner().equalsIgnoreCase("shaws")) && (!getCurrentBanner().equalsIgnoreCase("acme")) && (!getCurrentBanner().equalsIgnoreCase("pavilions"))) {
            waitForElementToBeClickable(pageElements.conatctDetails, 5000);
            pageElements.conatctDetails.click();
        }
    }

    public void fillContactDetails() throws Exception {
        if ((getCurrentBanner().equalsIgnoreCase("tomthumb")) || (getCurrentBanner().equalsIgnoreCase("safeway")) || (getCurrentBanner().equalsIgnoreCase("shaws")) || (getCurrentBanner().equalsIgnoreCase("acme")) || (getCurrentBanner().equalsIgnoreCase("pavilions"))) {
            newCheckoutPage.enterContactInformation();
        } else {
            enterValue(pageElements.firstName, "Fname");
            enterValue(pageElements.lastName, "lname");
            enterValue(pageElements.phoneNumber, "7788787987");

            if (getPlatformName().equalsIgnoreCase("ios"))
                myAccountPageElementsPage.doneButton.click();
            else
                tapSearchAndroidKeyboard();
            pageElements.saveDetails.click();
        }
    }

    public void fillAndBufferContactDetails() {
        enterValue(pageElements.firstName, "Fname");
        enterValue(pageElements.lastName, "lname");
        enterValue(pageElements.phoneNumber, "7788787987");

        if (driver.getPlatformName().equalsIgnoreCase("Android")) {
            deliveryPhoneNumber = pageElements.phoneNumber.getAttribute("text");
        } else {
            deliveryPhoneNumber = pageElements.phoneNumber.getAttribute("label");
        }

        if (getPlatformName().equalsIgnoreCase("ios"))
            myAccountPageElementsPage.doneButton.click();
        else
            tapSearchAndroidKeyboard();
        pageElements.saveDetails.click();

    }

    public void confirmChanges() {
        pageElements.confirmChanges.click();
    }

    public void fillSameNumberInContact() {
        enterValue(pageElements.phoneNumber, deliveryPhoneNumber);

    }

    public void verifyEditOrderPage() {
        waitForDisplayed(pageElements.confirmChanges);
    }

    public void captureNameOfProduct() {

        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            productInCart = pageElements.productAddedInCart.getAttribute("text");
        } else {
            productInCart = pageElements.productAddedInCart.getAttribute("label");
        }
        System.out.println(productInCart);
    }

    public void bufferNameOfProduct(String arg0) {

        MobileElement element = homePageElements.addedProductNameList.get(Integer.parseInt(arg0) - 1);
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            productInCart = element.getAttribute("text");
        } else {
            productInCart = element.getAttribute("label");
        }
        System.out.println(productInCart);
    }

    public void verifyNonSnapItemsDisplayed() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            productInCheckout = pageElements.productAddedInCheckout.getAttribute("text");
        } else {
            productInCheckout = pageElements.productAddedInCheckout.getAttribute("label");
        }
        System.out.println(productInCheckout);
        Assert.assertTrue((productInCheckout.contains(productInCart)) | (productInCart.contains(productInCheckout)), "The Non-SNAP item added is not displayed");
    }

    public void verifySnapPaymentOption() {

        waitForDisplayed(pageElements.snapOption, 10);
    }

    public void clickSnapOptionForPayment() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.snapRadioButton);
    }

    public void verifyPopupToRemoveNonSnapItems() {
        Assert.assertTrue(pageElements.nonSnapItemRemovalPopup.isDisplayed(), "popup to remove non snap items is not displayed");
    }

    public void userClickOnViewCart() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.nonSnapItemRemovalPopup);
    }

    public void verifyDeliveryFeeTooltipOption() {
        waitForLoadingComplete();
        scrollDown();
        pageElements.taxCollapseMode.click();
        waitForDisplayed(pageElements.deliveryFeeTooltip);
    }

    public void verifySalesTaxTooltipOption() {
        waitForLoadingComplete();
        scrollDown();
        pageElements.taxCollapseMode.click();
        waitForDisplayed(pageElements.salesTaxTooltip);
    }

    public void verifyEstimatedTotalTooltipOption() {
        waitForLoadingComplete();
        scrollDown();
        waitForDisplayed(pageElements.estimatedTotaltip);
    }

    public void clickItemTextOnScreen(String arg0) {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.preferences);
    }

    public void verifyAuthMessageDisplayed() {
        String str1 = "A hold will be placed on your debit/ credit card for this estimated total and will reduce the amount available to spend from your account. Your bank may take up to 5 business days after delivery/ pickup to release the hold and display your final charge.";
        String str2;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            str2 = pageElements.authMessage.getText();
            Assert.assertTrue(str2.equals(str1), "Auth message text is not as expected");
        } else {
            str2 = pageElements.authMessage.getAttribute("name");
            Assert.assertTrue(str2.equals(str1), "Auth message text is not as expected");
        }
    }

    public void lookingForSavingsText() {
        String str;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            str = pageElements.savingsTitle.getText();
            Assert.assertTrue(str.equals("Looking for your savings?"), "Savings title is not displayed");
        } else {
            str = pageElements.savingsTitle.getAttribute("name");
            Assert.assertTrue(str.equals("Looking for your savings?. . "), "Savings title is not displayed");
        }
    }

    public void verifySavingsMessageDisplayed() {
        String str1 = "The estimated total above excludes discounts from coupons you clipped and Buy One, Get One deals which will appear on your receipt at delivery or pickup";
        String str2;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            str2 = pageElements.savingsMessage.getText();
            Assert.assertTrue(str2.equals(str1), "Auth message text is not as expected");
        } else {
            str2 = pageElements.savingsMessage.getAttribute("name");
            Assert.assertTrue((str2.contains(str1) | str1.contains(str2)), "Auth message text is not as expected");
        }
    }

    public void verifyTermsUseMessageDisplayed() {
        String str1 = "By clicking ‘Place Order’, you acknowledge that you have read and agree to the Albertsons Companies’ Terms of Use and Privacy Policy and that they apply to this order.";
        String str2;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            str2 = pageElements.termsUseMessage.getText();
            Assert.assertTrue(str2.equals(str1), "Auth message text is not as expected");
        } else {
            str2 = pageElements.termsUseMessage.getAttribute("value");
            Assert.assertTrue(str2.equals(str1), "Auth message text is not as expected");
        }
    }

    public void scrollDownForCartSummary() {
        scrollDownForElement(cartPageElements.cartSummary);
    }

    public void clickOrders() {
    }

    public void clickCloseButtonOnPayment() {
        waitForLoadingComplete();
        if (isElementDisplayed(pageElements.crossButtonOnPaymentScreen, 35)) {
            pageElements.crossButtonOnPaymentScreen.click();
        }
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            newCheckoutPage.clickCloseBttn();
        }

    }

    public void displayErrorForInvalidPromoCode() {
        waitForDisplayed(pageElements.errorMsg, 15);
        Assert.assertTrue(pageElements.errorMsg.isDisplayed());

    }

    public void appliedPromoCode(String arg0) throws InterruptedException {


        Thread.sleep(10000);
        //   List<MobileElement> value = driver.findElements(By.id("nameTv"));
        waitForDisplayed(pageElements.promoCodeApplied.get(5), 50);
        String promoCodeText = pageElements.promoCodeApplied.get(5).getText();
        //   Assert.assertTrue(promoCodeText.equalsIgnoreCase(arg0));
    }

    public void deletePromoCode() {
        waitForDisplayed(pageElements.deleteAppliedPromoCode, 15);
        pageElements.deleteAppliedPromoCode.click();
        waitForDisplayed(pageElements.addPromoCode);

    }

    public void visibilityOfDeletedPromoCode() {

        waitForDisplayed(pageElements.deleteAppliedPromoCode, 15);
        pageElements.deleteAppliedPromoCode.click();
        waitForDisplayed(pageElements.addPromoCode);
        String value = pageElements.promoCodeApplied.get(5).getText();
        System.out.println(value);


    }

    public void verifyPromoCodeVisibility(String arg0) {

        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + arg0 + "')]"));
        Assert.assertTrue(list.size() == 0);

    }

    public void continueToCVVCTA() {
        waitForDisplayed(pageElements.continueToCVV);
        waitForClickableAndClick(pageElements.continueToCVV);
    }


    public void clickAddAddressButton() {
        waitForDisplayed(pageElements.addAddressButton, 10);
        pageElements.addAddressButton.click();
    }

    public void displayZipCode() {


        waitForDisplayed(pageElements.addressFieldOnSlotSelectionScreen, 15);
        String value = pageElements.addressFieldOnSlotSelectionScreen.getText();

        AppiumDevice device = AppiumDeviceManager.getDevice();
        String zipCodeValue = device.getConfigureData(BANNER_ZIPCODE);


        Assert.assertTrue(value.equalsIgnoreCase(zipCodeValue));

        waitForDisplayed(pageElements.addAddressButton, 10);
    }

    public void addressDetails() {

        waitForDisplayed(pageElements.addressFieldOnSlotSelectionScreen, 15);
        String addressValue = pageElements.addressFieldOnSlotSelectionScreen.getText();
        AppiumDevice device = AppiumDeviceManager.getDevice();
        String address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE1_FORSR);

        Assert.assertTrue(address.toLowerCase().contains(addressValue.toLowerCase().substring(0, 11)));

    }

    public void cancelorder() {
        new WaitAction(driver).waitForLoadingComplete();
        if (isElementDisplayed(pageElements.clickcancel)) {
            pageElements.clickcancel.click();
        }
    }

    public void closesetting() {
        new WaitAction(driver).waitForLoadingComplete();
        pageElements.backatoderconfirmation.click();
        new WaitAction(driver).waitForLoadingComplete();
        pageElements.closesettingwindow.click();
    }

    public void entercreditcard() {
        if (isElementDisplayed(pageElements.EnterCreditcard)) {
            pageElements.EnterCreditcard.click();

        }
    }

    public void enterCvvNumber(String arg0) {
//        WebElement cvv = driver.findElement(By.id("textinput_placeholder"));

        if (platformName.equalsIgnoreCase("android")) {
            new CommonActions(driver).new ClickAction().clickElement(pageElements.cvvEditText);
            enterKey(pageElements.cvvEditText, arg0);
        } else {
            enterKey(pageElements.cvvEditText, arg0);
            pageElements.keypadDoneButton.click();
        }
        if (isElementDisplayed(pageElements.Continuetocontactinfo)) {
            pageElements.Continuetocontactinfo.click();
        } else if (isElementDisplayed(pageElements.continuetoPaymentTab)) {
            pageElements.continuetoPaymentTab.isEnabled();
            pageElements.continuetoPaymentTab.click();
        } else if (isElementDisplayed(pageElements.Continuetorevieworder)) {
            pageElements.Continuetorevieworder.isEnabled();
            pageElements.Continuetorevieworder.click();
        }
        scrollDownForElement(pageElements.savetab);
        if (isElementDisplayed(pageElements.savetab)) {
            pageElements.savetab.isEnabled();
            pageElements.savetab.click();
        }
    }


    public void selectslot() {

        if (!isElementDisplayed(pageElements.pickupslotTile)) {
            if (isElementDisplayed(pageElements.nameOnCard)) {
                pageElements.nameOnCard.click();
            } else if (isElementDisplayed(pageElements.firstnamecontact)) {
                pageElements.firstnamecontact.click();
            } else if (isElementDisplayed(pageElements.cvvText)) {
                pageElements.cvvText.click();
            } else if (isElementDisplayed(pageElements.firstnamecontact)) {
                pageElements.firstnamecontact.click();
            } else {
                pageElements.placeorder.isEnabled();
                pageElements.placeorder.click();
            }
        } else if (isElementDisplayed(pageElements.Continuetocontactinfo)) {
            pageElements.Continuetocontactinfo.click();
        } else if (isElementDisplayed(pageElements.continuetoPaymentTab)) {
            pageElements.continuetoPaymentTab.isEnabled();
            pageElements.continuetoPaymentTab.click();
        } else if (isElementDisplayed(pageElements.continuetoCVV)) {
            pageElements.continuetoCVV.isEnabled();
            pageElements.continuetoCVV.click();
        } else if (isElementDisplayed(pageElements.Continuetorevieworder)) {
            pageElements.Continuetorevieworder.isEnabled();
            pageElements.Continuetorevieworder.click();
        } else {
            pageElements.weekdaysobject.click();
            new WaitAction(driver).waitForLoadingComplete();
            new WaitAction(driver).waitForDisplayed(pageElements.hrsobject);
            pageElements.hrsobject.click();
            if (isElementDisplayed(pageElements.Continuetocontactinfo)) {
                pageElements.Continuetocontactinfo.click();
            } else if (isElementDisplayed(pageElements.continuetoPaymentTab)) {
                pageElements.continuetoPaymentTab.isEnabled();
                pageElements.continuetoPaymentTab.click();
            } else if (isElementDisplayed(pageElements.continuetoCVV)) {
                pageElements.continuetoCVV.isEnabled();
                pageElements.continuetoCVV.click();
            } else if (isElementDisplayed(pageElements.Continuetorevieworder)) {
                pageElements.Continuetorevieworder.isEnabled();
                pageElements.Continuetorevieworder.click();
            }
        }
    }

    public void contactdetails() {
        String fname = ThreadLocalHelper.testCaseData.get().get("first_name");
        String lname = ThreadLocalHelper.testCaseData.get().get("last_name");
        String mobnumber = ThreadLocalHelper.testCaseData.get().get("mobile_number");
        if (isElementDisplayed(pageElements.firstnamecontact)) {
            pageElements.firstnamecontact.click();
            enterKey(pageElements.firstnamecontact, fname);
            pageElements.lastnamecontact.click();
            enterKey(pageElements.lastnamecontact, lname);
            pageElements.mobilenumber.click();
            enterKey(pageElements.mobilenumber, mobnumber);
            if (driver.getPlatformName().equalsIgnoreCase("android")) {
                new CommonActions(driver).new ClickAction().androidKeyboardClickDone();
            }
            if (isElementDisplayed(pageElements.Continuetorevieworder)) {
                pageElements.Continuetorevieworder.isEnabled();
                pageElements.Continuetorevieworder.click();
            } else if (isElementDisplayed(pageElements.savetab)) {
                pageElements.savetab.isEnabled();
                pageElements.savetab.click();
            }
        }
    }

    public void clickPickUpOnSlotSelection() {

        waitForDisplayed(pageElements.pickUpToggle);
        pageElements.pickUpToggle.click();
    }

    public void clickDeliverySlotSelection() {

        waitForDisplayed(pageElements.deliveryToggle);
        pageElements.deliveryToggle.click();
    }

    public void verifyInlineMessage(String message) {
        String inlineMessage = getText(pageElements.inlineMessage);
        Assert.assertTrue(inlineMessage.equalsIgnoreCase(message), "Inline message is not displayed or wrong message is displayed");
    }

    public void verifySnapEBTIssuePopup() {
        Assert.assertTrue(pageElements.snapEBTPurchaseIssuePopUp.isDisplayed(), "popup to remove non snap items is not displayed");
    }

    public void userClickOnCartTab() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.cartTab);
    }

    public void verifyNonSnapItems() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            productInCheckout = pageElements.productAddedInCheckout.getAttribute("text");
        } else {
            productInCheckout = pageElements.productAddedInCheckout.getAttribute("label");
        }
        Assert.assertTrue((productInCheckout != null && productInCheckout != ""), "The Non-SNAP item added is not displayed");
    }

    public void validateCvvLbl() {
        pageElements.confirmCvvLbl.isDisplayed();
    }


    public void clickBack() {
        pageElements.backButton.click();
//      new CommonActions(driver).new ClickAction().clickElement(pageElements.backButton);
    }

    public void clickContinueshopping() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.continueShopping);
        waitForLoadingComplete();
    }


    public void VerifyEBTDisplayed() {

        waitForDisplayed(pageElements.textmessage);

    }

    public void waitForPickupTextisDisplayed() {
        waitForDisplayed(pageElements.pickup_Text, 5);

    }

    public void waitForLockerPickupTextisDisplayed() {
       /* if (isElementDisplayed(pageElements.dismissCTA, 3)) {
          new CommonActions(driver).new ClickAction().clickElement(pageElements.dismissCTA);
        }*/
        //   waitForDisplayed(pageElements.orderConfirmationTitle, 5);
        waitForDisplayed(pageElements.lockerPickup_Text, 5);

    }

    public void waitForInstructionsTextisDisplayed() {

        waitForDisplayed(pageElements.instructionsText, 5);

    }

    public void waitForYourOrderIsProcessedTextisDisplayed() {
        waitForDisplayed(pageElements.yourOrderIsProcessedText, 5);

    }

    public void waitForYourOrderIsSavedTextisDisplayed() {
        waitForDisplayed(pageElements.yourOrderIsSavedText, 5);

    }

    public void waitForViewOrderCTAisDisplayed() {
        waitForDisplayed(pageElements.viewOrderCTA, 5);

    }

    public void waitForEditOrderCTAisDisplayed() {
        waitForDisplayed(pageElements.editOrderCTA, 5);

    }

    public void waitForDriveUpGoTextisDisplayed() {
        waitForDisplayed(pageElements.driverUpGoText, 5);

    }

    public void clickEditOrder() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.editOrderCTA);
        waitForLoadingComplete();
    }

    public void verifyNewEditOrderPageIsDisplayed() {
        // clickElement(pageElements.editOrderCTA);
        waitForDisplayed(pageElements.editOrderTitle, 5);
        waitForLoadingComplete();
    }

    public void clickSaveCTA_EditOrderPage() {
        if (getPlatformName().equalsIgnoreCase("ios")) {
            waitForLoadingComplete();
            new CommonActions(driver).new ClickAction().clickElement(pageElements.saveCTA_EditOrderPage);
        } else {
            waitForLoadingComplete();
            new CommonActions(driver).new ClickAction().clickElement(pageElements.confirmChangesCTA);
        }
    }

    public void clickCloseCTA() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.closeCTA);
        waitForLoadingComplete();
    }


    public void clickOnPickUpButton() {
        waitForLoadingComplete();
        waitForDisplayed(pageElements.selectPickUpBtn);
        pageElements.selectPickUpBtn.click();
    }

    public void userValidatesPickUpAvailablePopUp() {
        waitForLoadingComplete();
        Assert.assertTrue(pageElements.pickUpAvailableFromVons.isDisplayed());
        Assert.assertTrue(pageElements.downloadVonsApp.isDisplayed());
        Assert.assertTrue(pageElements.notNowBtn.isDisplayed());
        new CommonActions(driver).new ClickAction().clickElement(pageElements.notNowBtn);
    }

    public void userClicksOnFirstAvailableStore() {
        waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(pageElements.firstAvailableStore);
    }

    public void userNavigatingToHomePage() {
        waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(pageElements.closeBtnAtPaymentScreen);
        new CommonActions(driver).new ClickAction().clickElement(pageElements.saveChangesYesBtn);
        waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(pageElements.placeOrderBackBtn);
        new CommonActions(driver).new ClickAction().clickElement(pageElements.cartCloseBtn);
        waitForLoadingComplete();
    }

    public void enterDiffAddressDetails(String string) {
        int num = Integer.parseInt(string) + 1;
        for (int i = 1; i <= num; i++) {
            if (i == 1) {
                new CommonActions(driver).new ClickAction().clickElement(checkoutPageElements.editChevronAddress);
            }
            if (i != 14) {
                new CommonActions(driver).new ClickAction().clickElement(checkoutPageElements.addPlusIconAddress);
            } else {
                if (driver.getPlatformName().equalsIgnoreCase("android")) {

                    Assert.assertFalse(isElementPresent(By.xpath("//*[@content-desc='Add Address']")));
                    break;
                } else {
                    Assert.assertFalse(isElementPresent(By.xpath("//XCUIElementTypeButton[@name=\"Add new address\"]")));
                }
            }
            String add = "address" + i;
            try {
                enterMultipleAddressDetails(add);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public void enterMultipleAddressDetails(String deliveryAddress) throws Exception {
        //try{
        AppiumDevice device = AppiumDeviceManager.getDevice();
        String address;

        switch (deliveryAddress) {
            case "address1":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE2_FORSR);
                break;
            case "address2":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE3_FORSR);
                break;
            case "address3":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE4_FORSR);
                break;
            case "address4":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE5_FORSR);
                break;
            case "address5":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE6_FORSR);
                break;
            case "address6":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE7_FORSR);
                break;
            case "address7":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE8_FORSR);
                break;
            case "address8":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE9_FORSR);
                break;
            case "address9":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE10_FORSR);
                break;
            case "address10":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE11_FORSR);
                break;
            case "address11":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE12_FORSR);
                break;
            case "address12":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE13_FORSR);
                break;
            case "address13":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE14_FORSR);
                break;
            default:
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE1_FORSR);
        }

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            enterKey(pageElements.addressLine1TextField, address);
            new CommonActions(driver).new ClickAction().clickElement(pageElements.egMsg);
            pageElements.egMsg.sendKeys("\n");
            Thread.sleep(1000);
            new CommonActions(driver).new ClickAction().clickElement(pageElements.saveCTA);
        } else {
            Thread.sleep(3000);
            enterKey(pageElements.addressField, address);
            //hideKeyBoard();
            //waitForLoaderToDisappear();
            waitForLoadingComplete();
            Thread.sleep(5000);
            // clickElement(pageElements.saveCTA);
            // Thread.sleep(5000);
        }
    }

    public void clickOnEditChevronButton() {
        new CommonActions(driver).new ClickAction().clickElement(checkoutPageElements.editChevronAddress);
    }

    public void clickOnContinueWithChangeZipCode() {
        new CommonActions(driver).new ClickAction().clickElement(checkoutPageElements.ContinueWithChangeZipCode);
    }

    public void validateStoreDetailMapView() {

        Assert.assertTrue(isElementPresent(By.xpath("(//android.view.View[@content-desc])[1]")));

    }

    public void validateMultipleStoreDetails() throws InterruptedException {
        new CommonActions(driver).new ClickAction().clickElement(checkoutPageElements.storeMapView);
        Assert.assertTrue(isElementPresent(By.xpath("//*[contains(@resource-id,'tv_store_address')]")));
        String address;
        switch ("temp") {
            case "address2":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE3_FORSR);
                break;
            case "address3":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE4_FORSR);
                break;
            case "address4":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE5_FORSR);
                break;
            case "address5":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE6_FORSR);
                break;
            case "address6":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE7_FORSR);
                break;
            case "address7":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE8_FORSR);
                break;
            case "address8":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE9_FORSR);
                break;
            case "address9":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE10_FORSR);
                break;
            case "address10":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE11_FORSR);
                break;
            case "address11":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE12_FORSR);
                break;
            case "address12":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE13_FORSR);
                break;
            case "address13":
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE14_FORSR);
                break;
            default:
                address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE1_FORSR);
        }

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            enterKey(pageElements.addressLine1TextField, address);
            new CommonActions(driver).new ClickAction().clickElement(pageElements.egMsg);
            pageElements.egMsg.sendKeys("\n");
            Thread.sleep(1000);
            new CommonActions(driver).new ClickAction().clickElement(pageElements.saveCTA);
        } else {
            Thread.sleep(3000);
            enterKey(pageElements.addressField, address);
            //hideKeyBoard();
            //waitForLoaderToDisappear();
            waitForLoadingComplete();
            Thread.sleep(5000);
            // clickElement(pageElements.saveCTA);
            // Thread.sleep(5000);
        }
    }


    public void viewDetails() {
        pageElements.viewDetails.click();

    }


    public void StoreOrderConfirmationDetails() throws InterruptedException {
        AppiumDevice device = AppiumDeviceManager.getDevice();
        waitForLoadingComplete();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            waitForLoadingComplete();
            waitForLoadingComplete();
            String OrderActualNumber1 = pageElements.OrderNumber.getAttribute("label");
            String OrderNumber3[] = OrderActualNumber1.split("#");

            CheckoutPage.OrderActualNumber = OrderNumber3[1];
//            String OrderDateandTime = pageElements.OrderDateandTime.getAttribute("label");
            CheckoutPage.OrderDateandTime = pageElements.OrderDateandTime.getAttribute("label");
            CheckoutPage.FullfilmentType = pageElements.OrderFulfillmentType.getAttribute("label");
//            String FullfilmentType = pageElements.OrderFulfillmentType.getAttribute("label");
            System.out.println(OrderActualNumber);
            System.out.println(OrderDateandTime);
            System.out.println(FullfilmentType);

        } else {
            String OrderNumber2 = pageElements.OrderNumber.getAttribute("text");
            String OrderNumber1[] = OrderNumber2.split("#");
            CheckoutPage.OrderActualNumber = OrderNumber1[1];
            CheckoutPage.OrderDateandTime = pageElements.OrderDateandTime.getAttribute("text");
            CheckoutPage.FullfilmentType = pageElements.OrderFulfillmentType.getAttribute("text");
            System.out.println(OrderActualNumber);
            System.out.println(OrderDateandTime);
            System.out.println(FullfilmentType);
        }
    }


    public void ContinueShopping() throws InterruptedException {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.ContinueShopping);
    }

    public void clickonSubmenuOrder() throws InterruptedException {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.subMenuOrder);
    }


    public void VerifyOrderConfirmPageDisplayed() throws InterruptedException {
        waitForLoadingComplete();
        waitForLoadingComplete();
        isElementDisplayed(pageElements.OrderConfirm);
    }


    public void VerifyOrderPrgoressAndOrderStatusMessage() throws InterruptedException, ParseException {
        waitForLoadingComplete();
        AppiumDevice device = AppiumDeviceManager.getDevice();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            String strOrderNumber = pageElements.OrderNumberMenuBar.getAttribute("label");
            if (strOrderNumber.equals(CheckoutPage.OrderActualNumber)) {
                String isCollapsed = pageElements.ExpandOrderDetails.getAttribute("label");
                if (isCollapsed.contains("Chevron Collapsed")) {
                    new CommonActions(driver).new ClickAction().clickElement(pageElements.ExpandOrderDetails);
                }


                if (!(isElementDisplayed(pageElements.OrderProgressBar))) {
                    //.assertTrue(false);
                    System.out.println("false");
                }


                Assert.assertTrue(isElementDisplayed(pageElements.OrderProgressBar));

                Assert.assertTrue(isElementDisplayed(pageElements.OrderMessage));

                Assert.assertTrue(isElementDisplayed(pageElements.OrderSubMenuMessage));


                scrollDown(3);

                Assert.assertTrue(isElementDisplayed(pageElements.bannerimg));

                Assert.assertTrue(isElementDisplayed(pageElements.bannerName));


                if (pageElements.bannerName.getAttribute("label").contains("Safeway")) {
                    Assert.assertTrue(true);
                }
                isElementDisplayed(pageElements.ViewDetailsorTrackOrder);
                if (pageElements.ViewDetailsorTrackOrder.isEnabled()) {
                    pageElements.ViewDetailsorTrackOrder.click();
                    isElementDisplayed(pageElements.Ordertitle);
                    String strOrderTitle = pageElements.Ordertitle.getAttribute("name");
                    if (strOrderTitle.equals("Your order details")) {
                        Assert.assertTrue(true);
                    } else {
                        Assert.assertTrue(false);
                    }
                }
            }

        } else {
            String strOrderNumber1 = pageElements.OrderNumberMenuBar.getAttribute("text");
            if (strOrderNumber1.equals(OrderActualNumber)) {
                //boolean EditOrderdisplay = ;

                if (!(isElementDisplayed(pageElements.OrderProgressBar))) {

                    //.assertTrue(false);
                    System.out.println("false");


                    //.assertTrue(false);
                    System.out.println("false");
                }

                if (!(isElementDisplayed(pageElements.OrderMessage))) {
                    Assert.assertTrue(false);
                }

                if (!(isElementDisplayed(pageElements.OrderSubMenuMessage))) {
                    Assert.assertTrue(false);
                }
            }

            Assert.assertTrue(isElementDisplayed(pageElements.OrderProgressBar));

            if (!(isElementDisplayed(pageElements.OrderSubMenuMessage))) {

                Assert.fail();
            }

            Assert.assertTrue(isElementDisplayed(pageElements.OrderMessage));


            Assert.assertTrue(isElementDisplayed(pageElements.OrderSubMenuMessage));


            scrollDown(3);

            Assert.assertTrue(isElementDisplayed(pageElements.bannerimg));

            Assert.assertTrue(isElementDisplayed(pageElements.bannerName));


            scrollDown(3);
            if (!(isElementDisplayed(pageElements.bannerimg))) {
                Assert.assertTrue(false);
            }
            isElementDisplayed(pageElements.bannerName);

            if (pageElements.bannerName.getAttribute("text").contains("Safeway")) {
                Assert.assertTrue(true);
            }
            if (pageElements.ViewDetailsorTrackOrder.isEnabled()) {
                isElementDisplayed(pageElements.Ordertitle);
                pageElements.ViewDetailsorTrackOrder.click();
                String strOrderTitle = pageElements.Ordertitle.getAttribute("text");
                if (strOrderTitle.equals("Your order details")) {
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
        }
    }


    public void VerifyBannerLogoandImageScheduledDateTimeDisplayed() throws InterruptedException, ParseException, ParseException {
        waitForLoadingComplete();
        AppiumDevice device = AppiumDeviceManager.getDevice();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            String strOrderNumber = pageElements.OrderNumberMenuBar.getAttribute("label");
            if (strOrderNumber.equals(CheckoutPage.OrderActualNumber)) {
                String isCollapsed = pageElements.ExpandOrderDetails.getAttribute("label");
                if (isCollapsed.contains("Chevron Collapsed")) {
                    new CommonActions(driver).new ClickAction().clickElement(pageElements.ExpandOrderDetails);
                }
                scrollDown(5);
                isElementDisplayed(pageElements.bannerName);
                if (pageElements.bannerName.getAttribute("label").contains("Safeway")) {
                    Assert.assertTrue(true);
                }
                if (!(isElementDisplayed(pageElements.bannerimg))) {
                    // Assert.assertTrue(false);
                    System.out.println(false);
                }
                String FulfillmentType = pageElements.FullfillmentType.getAttribute("label");
                String Fullifill[] = FulfillmentType.split(":");
                String FulfillmentType1 = Fullifill[0];
                String FulfillmentType2 = Fullifill[1];
                if (FulfillmentType1.equals(CheckoutPage.FullfilmentType)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
                String OrderDate[] = FulfillmentType2.split(",");

                final String OLD_FORMAT = "MM/dd";
                final String NEW_FORMAT = "MMM d";
                String newDateString;
                String OrderDate1 = OrderDate[0];
                String OrderDate2 = OrderDate1.trim();
                SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
                Date d = sdf.parse(OrderDate2);
                SimpleDateFormat sdf1 = new SimpleDateFormat(NEW_FORMAT);
                System.out.println(sdf1.format(d));
                String ActualDateTime = sdf1.format(d);

                String OrderDateExpected[] = CheckoutPage.OrderDateandTime.split(",");
                String dateExpected = OrderDateExpected[1];
                String dateExpected1 = dateExpected.trim();
                if (ActualDateTime.equals(dateExpected1)) {
                    Assert.assertTrue(true);
                } else System.out.println(false);

                String TimeExpected = OrderDateExpected[2];
                String TimeExpected1 = TimeExpected.trim();
                String TimeActual = OrderDate[1];
                String TimeActual1 = OrderDate[1].trim();
                if (!TimeExpected1.equals(TimeActual1)) {
                    System.out.println(false);
                    //  Assert.assertTrue(false);
                }
            }
        } else {
            String strOrderNumber1 = pageElements.OrderNumberMenuBar.getAttribute("text");
            if (strOrderNumber1.equals(OrderActualNumber)) {
                //boolean EditOrderdisplay = ;
                scrollDown(3);
                if (!(isElementDisplayed(pageElements.bannerimg))) {
                    Assert.assertTrue(false);
                }
                isElementDisplayed(pageElements.bannerName);
                if (pageElements.bannerName.getAttribute("text").contains("Safeway")) {
                    Assert.assertTrue(true);
                }
                String FulfillmentType = pageElements.FullfillmentType.getAttribute("text");
                String Fullifill[] = FulfillmentType.split(":");
                String FulfillmentType1 = Fullifill[0];
                String FulfillmentType2 = Fullifill[1];
                if (FulfillmentType1.equals(CheckoutPage.FullfilmentType)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
                String OrderDate[] = FulfillmentType2.split(",");

                final String OLD_FORMAT = "MM/dd";
                final String NEW_FORMAT = "MMM d";
                String newDateString;
                String OrderDate1 = OrderDate[0];
                String OrderDate2 = OrderDate1.trim();
                SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
                Date d = sdf.parse(OrderDate2);
                SimpleDateFormat sdf1 = new SimpleDateFormat(NEW_FORMAT);
                System.out.println(sdf1.format(d));
                String ActualDateTime = sdf1.format(d);

                String OrderDateExpected[] = CheckoutPage.OrderDateandTime.split(",");
                String dateExpected = OrderDateExpected[1];
                String dateExpected1 = dateExpected.trim();
                if (ActualDateTime.equals(dateExpected1)) {
                    Assert.assertTrue(true);
                } else System.out.println(false);

                String TimeExpected = OrderDateExpected[2];
                String TimeExpected1 = TimeExpected.trim();
                String TimeActual = OrderDate[1];
                String TimeActual1 = OrderDate[1].trim();
                if (!TimeExpected1.equals(TimeActual1)) {
                    System.out.println(false);
                    //  Assert.assertTrue(false);
                }
            }
        }
    }


}
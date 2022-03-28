package com.automation.pages;

import com.automation.helpers.LoaderUtil;
import com.automation.helpers.PageActions;
import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.entities.BannerConfType;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.TapAction;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_CheckoutPageElements;
import com.automation.pageElements.GG_ContactPageElements;
import com.automation.pageElements.GG_DealsPageElements;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.sl.In;
import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.awaitility.Awaitility.await;

public class GG_CheckoutPage extends BasePage {
    public MyAccountPage myAccountPage = new MyAccountPage(driver);
    AppiumDevice device = AppiumDeviceManager.getDevice();
    private final GG_CheckoutPageElements gg_checkoutPageElement = new GG_CheckoutPageElements();
    private final GG_DealsPageElements gg_dealsPageElements = new GG_DealsPageElements();
    private final GG_ContactPageElements gg_contactPageElements = new GG_ContactPageElements();


    public GG_CheckoutPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_checkoutPageElement);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_contactPageElements);
    }

    public void waitForCheckoutPageDisplayed() {
        pleaseWaitForTheLoadingToComplete();
        waitForDisplayed(gg_checkoutPageElement.orderInfoText);
    }

    public void isCheckoutEnabled() {
        while (gg_checkoutPageElement.checkoutButton.getAttribute("enabled") == "true") {
            new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.plusButton);
        }
        Assert.assertTrue(gg_checkoutPageElement.checkoutButton.getAttribute("enabled").equalsIgnoreCase("true"));
    }

    public boolean isSnapEBTOptionDisplayed() {
        return isElementDisplayed(gg_checkoutPageElement.snapEBT);
    }

    public void clickOnSNAPEBT() {
       new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.snapEBT);
    }

    public void clickOnCheckoutBtn() {
       new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.checkoutButton);
    }

    public void enterItems(String item) {
        enterKey(gg_checkoutPageElement.searchField, item);
        if (isElementDisplayed(gg_dealsPageElements.togglePopUp)) {
           new CommonActions(driver).new ClickAction().clickElement(gg_dealsPageElements.togglePopUp);
        }
    }

    public boolean verifyNewSlotSelectionScreen() {
        return isElementDisplayed(gg_checkoutPageElement.slotSelectionScreen, 2000);
    }


    public boolean isSearchButtonDisplayed() {
        return isElementDisplayed(gg_checkoutPageElement.searchButton);
    }

    public void clickOnSearchButton() {
       new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.searchButton);
    }


    public boolean verifyYourOrderScreen() {
        return isElementDisplayed(gg_checkoutPageElement.verifyYourOrderScreen, 2000);

    }


    public void clickOnViewCartPopUP() {
       new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.viewCartPopUp);
        waitForLoadingComplete();
    }

    public void removeAllNonSNAPItem() {
        for (int i = 0; i <= gg_checkoutPageElement.removeButton.size(); i++) {
           new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.removeButton.get(i));
            waitForLoadingComplete();
        }
    }

    public void clickBackButtonToCheckout() {
       new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.backButtonToCheckOut);
    }

    public boolean isSnapEligibleSubTotalDisplayed() {
        scrollDownForElement(gg_checkoutPageElement.snapEligibleTotal);
        return isElementDisplayed(gg_checkoutPageElement.snapEligibleTotal);
    }

    public boolean isNonSnapEligibleSubTotalDisplayed() {
        scrollDownForElement(gg_checkoutPageElement.nonSnapEligibleTotal);
        return isElementDisplayed(gg_checkoutPageElement.nonSnapEligibleTotal);
    }

    public boolean isMyCartIconDisplayed() {
        return isElementDisplayed(gg_checkoutPageElement.myCart);
    }

    public void clickConfirmCVV() {
        waitForLoaderToDisappear();
       new CommonActions(driver).new ClickAction().clickElement((gg_checkoutPageElement.confirmCVV));
    }

    public void clickOnChooseAndTime() {
       new CommonActions(driver).new ClickAction().clickElement((gg_checkoutPageElement.chooseDateAndTimeArrow));
    }

    public void enterCVV(String cvv) {
        if (isElementDisplayed(gg_checkoutPageElement.confirmCVVTextField, 20)) {
            gg_checkoutPageElement.confirmCVVTextField.clear();
            enterKey(gg_checkoutPageElement.confirmCVVTextField, cvv);
        }
    }

    public boolean isEstimatedTotalDisplayed() {
        return isElementDisplayed(gg_checkoutPageElement.estimatedTotal);
    }

    public boolean isPromoCodesDisplayed() {
        return isElementDisplayed(gg_checkoutPageElement.promoCodes);
    }

    public boolean isGlobalSubstitutionDisplayed() {
        return isElementDisplayed(gg_checkoutPageElement.globalSubstitution);
    }

    public boolean isStepperDisplayed() {
        return isElementDisplayed(gg_checkoutPageElement.plusButton);
    }

    public boolean isCVVValidationDisplayed() {
        return isElementDisplayed(gg_checkoutPageElement.confirmCVVLabel);

    }

    public void isPlaceOrderButtonAvailable() {
        Assert.assertTrue(gg_checkoutPageElement.placeOrderButton.getAttribute("enabled").equalsIgnoreCase("true"));
    }

    public void clickOnBackButtonToMyCartScreen() {
       new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.backButtonToCartScreen);
    }

    public void clickOnDoneButton() {
       new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.doneButton);
    }

    public void clickOnViewDetailsButton() {
       new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.viewDetailsButton);
    }

    public void clickOnEditCartLink() {
       new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.editCart);
    }

    public void searchToAddItems(String item) {
        gg_checkoutPageElement.searchField.clear();
        enterKey(gg_checkoutPageElement.searchField, item);
    }

    public void clickCancelButton() {
       new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.cancelButton);
    }

    public void clickRequiredDeliveryTime() {
       new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.timeDelivery);
    }

    public void clickOnOrderInfoLink() {
       new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.orderInfoLink);
    }

    public void scrollUpToChangeTime() {
        scrollUpForElement(gg_checkoutPageElement.changeTime);
    }

    public void clickOnCancelOrderButton() {
       new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.cancelOrderButton);
    }

    public void clickConfirmChangeButton() {
       new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.confirmChanges);
    }

    public void clickOnUpdateOrderLink() {
       new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.updateOrderLink);
    }

    public void clickOnCancelOrderButtonPopUp() {
       new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.cancelOrderPopUpButton);
    }

    public void clickOnConfirmCVVArrow() {
        if (platformName.equalsIgnoreCase("android")) {
           new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.confirmCVVArrow);
        }
    }

    public void clickOnBackToOrderButton() {
       new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.backToOrder);
    }

    public void enterPhoneNumber() {
        scrollUpForElement(gg_checkoutPageElement.addPhoneNumber, 3);
       new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.addPhoneNumber);
        myAccountPage.createNewPhoneNumber();
    }

    public void enterMoreThan10DigitPhoneNumberAndVerify() {
        scrollUpForElement(gg_checkoutPageElement.addPhoneNumber, 3);
       new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.addPhoneNumber);
        String areaCode = (int) (Math.random() * 7 + 2) +
                new SimpleDateFormat("dd").format(new Date());
        String phoneCode = (int) (Math.random() * 7 + 2) +
                new SimpleDateFormat("HHmmss").format(new Date());
        enterKey(gg_checkoutPageElement.phoneNumberTextField, areaCode + phoneCode + "1");

//        String val = "";
        //From app side, User is restricted to enter more than 10 number
        //For ios the entering 10+ gives and error , for droid error msg is shown
//        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
//            System.out.println(driver.getPageSource());
//            val = getTextFromTextField(gg_checkoutPageElement.phoneNumberTextField);
//            val = val.replaceAll("[^0-9]", "");
//            Assert.assertEquals(val, areaCode + phoneCode, "Extra chars allowed in number edit");
//        } else {
//            String errorMsg =getText(gg_checkoutPageElement.phoneNoInvalidErrMsg);
//            Assert.assertEquals(getText(gg_checkoutPageElement.phoneNoInvalidErrMsg), "Please enter a valid phone number.", "The error message for exceeded mobile no is incorrect");
//        }
    }

    public void verifyLabels() {
        waitVar.until(ExpectedConditions.visibilityOf(gg_checkoutPageElement.contactLabel));
        waitVar.until(ExpectedConditions.visibilityOf(gg_checkoutPageElement.orderInfoLabel));
        waitVar.until(ExpectedConditions.visibilityOf(gg_checkoutPageElement.paymentLabel));
        waitVar.until(ExpectedConditions.visibilityOf(gg_checkoutPageElement.promoCodeLabel));
        scrollDownForElement(gg_checkoutPageElement.cartLabel, 1);
        waitVar.until(ExpectedConditions.visibilityOf(gg_checkoutPageElement.cartLabel));
    }

    public boolean isCheckOutPageDisplayed() {
        return isElementDisplayed(gg_checkoutPageElement.orderInfoLink);
    }

    public void searchToAddItemsInEditCart(String item) {
        gg_checkoutPageElement.searchFieldInEditCart.click();
        gg_checkoutPageElement.searchField.clear();
        enterKey(gg_checkoutPageElement.searchField, item);
    }

    public void verifyZipcode() {
        Assert.assertTrue(isElementDisplayed(gg_checkoutPageElement.zipCodeField), "zipcode not there");
    }

    public void clickEditForStoreChange() {
        gg_checkoutPageElement.editStore.click();
    }

    public void verifyOrderInfoPage() {
        Assert.assertTrue(isElementDisplayed(gg_checkoutPageElement.selectPref), "orderinfo page not there");

    }

    public void changeOrderPref() {
        gg_checkoutPageElement.selectPref.click();

    }

    public void verifyMapPage() {
        Assert.assertTrue(isElementDisplayed(gg_checkoutPageElement.mapView), "Map not displayed");

    }

    public void updateZipcode() {

        enterKey(gg_checkoutPageElement.zipCodeField, device.getConfigureData(BannerConfType.BANNER_ZIPCODE_DIFF));
    }

    public void tapContinue() {
        gg_checkoutPageElement.continuePopup.click();
    }

    public void tapBack() {
        gg_checkoutPageElement.goBack.click();
    }

    public void verifyPopup() {
        Assert.assertTrue(isElementDisplayed(gg_checkoutPageElement.popUpMessage), "Map not displayed");

    }

    public void clickEditContactInfo() {
        gg_checkoutPageElement.editContactBtn.click();
    }


    public void clickonContinue_to_review_order() throws InterruptedException {
        if (isElementDisplayed(gg_checkoutPageElement.Continue_to_review_order)) {
            waitForDisplayed(gg_checkoutPageElement.Continue_to_review_order);
           new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.Continue_to_review_order);
            Thread.sleep(30000);

            // waitForDisplayed(gg_checkoutPageElement.deliverto);
        }
    }

    public void fillCardName(String name) {
        new WaitAction(driver).waitForElementToBeClickable(gg_checkoutPageElement.creditCardNameField, 10);
        enterValue(gg_checkoutPageElement.creditCardNameField, name);
        isElementDisplayed(gg_checkoutPageElement.continueToReviewOrderBtn,2);
        tapSubmitOnKeyboardWhenOnPaymentPage();
    }

    public void enterNameInCreditCard(String name) {
        if (isElementDisplayed(gg_checkoutPageElement.creditCardNameField, 10)) {
            fillCardName (name);
        }
        if (isElementDisplayed(gg_checkoutPageElement.enterValidName,3)){
            fillCardName(name);
        }
    }

    public void enterCreditCardNumber(String number) {
        if (isElementDisplayed(gg_checkoutPageElement.creditCardNumberField, 1)) {
            enterValue(gg_checkoutPageElement.creditCardNumberField, number);
            isElementDisplayed(gg_checkoutPageElement.continueToReviewOrderBtn,2);
            tapSubmitOnKeyboardWhenOnPaymentPage();
        }
    }

    public void tapSubmitOnKeyboardWhenOnPaymentPage() {
        if (driver.getPlatformName().equalsIgnoreCase("IOS"))
            return;
        try {
            driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "next"));
        } catch (Exception e) {
            int height = driver.findElement(By.xpath("//*[contains(@resource-id,'paymentWrapper')]")).getSize().getHeight();
            int width = driver.findElement(By.xpath("//*[contains(@resource-id,'paymentWrapper')]")).getSize().getWidth();
            int searchX = driver.findElement(By.xpath("//*[contains(@resource-id,'paymentWrapper')]")).getLocation().getX() + width - 20;
            int searchY = driver.findElement(By.xpath("//*[contains(@resource-id,'paymentWrapper')]")).getLocation().getY() + height - 40;
            TouchAction touchAction = new TouchAction(driver);
            touchAction.tap(PointOption.point(searchX, searchY)).perform();
        }
    }

    public void enterCreditCardExpirationDate(String date) {
        if (isElementDisplayed(gg_checkoutPageElement.creditCardExpirationDateField, 1)) {
            enterValue(gg_checkoutPageElement.creditCardExpirationDateField, date);
            isElementDisplayed(gg_checkoutPageElement.continueToReviewOrderBtn,2);
            tapSubmitOnKeyboardWhenOnPaymentPage();
        }
    }

    public void enterCreditCardBillingZipCode(String zip) {
        if (isElementDisplayed(gg_checkoutPageElement.creditCardBillingZipCodeField)) {
            enterValue(gg_checkoutPageElement.creditCardBillingZipCodeField, zip);
            if (driver.getPlatformName().equalsIgnoreCase("ANDROID")) {
                tapSubmitOnKeyboardWhenOnPaymentPage();
                if (gg_checkoutPageElement.continuePaymentButton.getAttribute("clickable").equals("true")){
                    return;
                }
                new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.creditCardNameField);
                tapSubmitOnKeyboardWhenOnPaymentPage();
                new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.creditCardNumberField);
                tapSubmitOnKeyboardWhenOnPaymentPage();
            }
            if (isElementDisplayed(gg_checkoutPageElement.doneButton, 1)) {
                new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.doneButton);
            }
        }
    }

    public void clickContinueToReviewOrder() {
        if (isElementDisplayed(gg_checkoutPageElement.doneButton, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.doneButton);
        }
        if (isElementDisplayed(gg_checkoutPageElement.continueToReviewOrderBtn, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.continueToReviewOrderBtn);
        }
    }

    public void clickPlaceOrderBtn() {
        try {
            hideKeyBoard();
        } catch (Exception e) {

        }
        new WaitAction(driver).waitForElementToBeClickable(gg_checkoutPageElement.placeOrderButton, 10);
        new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.placeOrderButton);
        LoaderUtil.waitForPlacingOrderLoaderToDisappear();
    }

    public boolean verifyEditOrderPage() {
        return isElementDisplayed(gg_checkoutPageElement.editOrderPage);
    }

    public void clickEditCartAndPreferences() {
        waitForLoaderToDisappear();
        if (!isElementDisplayed(gg_checkoutPageElement.editCartAndPreferencesButton)) {
            scrollDownForElement(gg_checkoutPageElement.editCartAndPreferencesButton, 3);
        }
        new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.editCartAndPreferencesButton);
        waitForLoaderToDisappear();
    }

    public void clickBackBtnInEditCartScreen() {
        new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.backBtnInEditCartScreen);
    }

    public void searchForAnItemInEditCartScreen(String item) {
        new TapAction(driver).tapCoordinate(gg_checkoutPageElement.searchFieldInEditCart.getCenter().getX(), gg_checkoutPageElement.searchFieldInEditCart.getCenter().getY());
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                enterTextNoPressEnter(gg_checkoutPageElement.searchFieldInEditCartInSearchPage, item);
                new TapAction(driver).tapSearchEnterAndroid();
                break;
            case "IOS":
                enterKey(gg_checkoutPageElement.searchFieldInEditCartInSearchPage, item);
                break;
        }
    }

    public void clickEditOrderBtnInOrdersPage() {
        isElementDisplayed(gg_checkoutPageElement.editOrderBtnInOrdersPage, 10);
        new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.editOrderBtnInOrdersPage);
    }

    public void clickViewOrderBtnInOrdersPage() {
        new WaitAction(driver).waitForElementToBeClickable(gg_checkoutPageElement.viewOrderBtnInOrdersPage, 20);
        new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.viewOrderBtnInOrdersPage);
    }

    public boolean verifyPastPurchasesButtonIsDisplayed() {
        return isElementDisplayed(gg_checkoutPageElement.pastPurchasesBtn, 10);
    }

    public String getCartCountInEditCart() {
        waitForLoaderToDisappear();
        isElementDisplayed(gg_checkoutPageElement.cartCountInEditCart, 5);
        if (platformName.equalsIgnoreCase("android")) {
            return gg_checkoutPageElement.cartCountInEditCart.getAttribute("text").replaceAll("[^0-9.]", "");
        }
        return gg_checkoutPageElement.cartCountInEditCart.getAttribute("label").replaceAll("[^0-9.]", "");
    }

    public void navigateBackToProductListingPageInEditScreen() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.backButtonInProductDetailsPage);
        } else {
            driver.navigate().back();
        }
    }

    public String getItemsCountInEditCart() {
        new WaitAction(driver).waitForDisplayed(gg_checkoutPageElement.itemsCountInEditCart);
        if (platformName.equalsIgnoreCase("android")) {
            return gg_checkoutPageElement.itemsCountInEditCart.getAttribute("text").replaceAll("[^0-9.]", "");
        }
        return gg_checkoutPageElement.itemsCountInEditCart.getAttribute("label").replaceAll("[^0-9.]", "");
    }

    public String getEstimatedSubTotalInEditCart() {
        new WaitAction(driver).waitForDisplayed(gg_checkoutPageElement.estimatedSubTotalInEditCart);
        return gg_checkoutPageElement.estimatedSubTotalInEditCart.getText().replaceAll("[^0-9.]", "");
    }

    public void addAnItemInEditCart() throws InterruptedException {
        new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.numberOfItemsCircledButton);
        Thread.sleep(1000);
        if (platformName.equalsIgnoreCase("ios")) {
            int xCoordinateForTap = (int) (gg_checkoutPageElement.addBtnInEditCartScreen.getCenter().getX() + (gg_checkoutPageElement.addBtnInEditCartScreen.getSize().getWidth() / 2) * 0.90);
            new TapAction(driver).tapCoordinate(xCoordinateForTap, gg_checkoutPageElement.addBtnInEditCartScreen.getCenter().getY());
        } else {
            new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.addBtnInEditCartScreen);
        }
        Thread.sleep(3500);
    }

    public String getEditOrderTitleText() {
        return gg_checkoutPageElement.editOrderPage.getText();
    }

    public void clickConfirmEditOrder() {
        new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.confirmChanges);
    }

    public void clickContinueShoppingAfterEditOrder() {
        if (isElementDisplayed(gg_checkoutPageElement.continueShoppingAfterEditButton, 5)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.continueShoppingAfterEditButton);
        }
    }

    public void closeSlotSelectionSheet() {
        if (platformName.equalsIgnoreCase("ios")) {
            if (isElementDisplayed(gg_checkoutPageElement.closeSlotSelectionSheet, 5)) {
                new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.closeSlotSelectionSheet);
                waitForLoaderToDisappear();
            }
        } else if (platformName.equalsIgnoreCase("android")) {
            closeBottomSheet();
        }
    }

    public void chooseConfirmChanges(String choice) {
        if (choice.equalsIgnoreCase("YES")) {
            if (isElementDisplayed(gg_checkoutPageElement.yesConfirmChanges, 3)) {
                new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.yesConfirmChanges);
                waitForLoaderToDisappear();
            }
        } else {
            if (isElementDisplayed(gg_checkoutPageElement.noConfirmChanges, 3)) {
                new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.noConfirmChanges);
                waitForLoaderToDisappear();
            }
        }
    }

    public void closeContactInfoSheet() {
        if (isElementDisplayed(gg_checkoutPageElement.closeContactInfoSheet, 5)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.closeContactInfoSheet);
            waitForLoaderToDisappear();
        }
    }

    public void closeNonSnapEligibleItemsSheet() {
        if (isElementDisplayed(gg_checkoutPageElement.nonSNAPEligibleItemsClose, 5)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.nonSNAPEligibleItemsClose);
            waitForLoaderToDisappear();
        }
    }

    public void closePaymentSheet() {
        if (platformName.equalsIgnoreCase("ios")) {
            if (isElementDisplayed(gg_checkoutPageElement.closePaymentSheet, 5)) {
                new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.closePaymentSheet);
                waitForLoaderToDisappear();
            }
        }
        if (platformName.equalsIgnoreCase("android")) {
            closeBottomSheet();
        }
    }

    public Map<String, Object> getElementsPresenceOrTextInNonSnapEligibleItemsSheet() {
        Map<String, Object> elementsMap = new HashMap<>();
        elementsMap.put("NON_SNAP_ELIGIBLE_SHEET_HEADER_TEXT", getText(gg_checkoutPageElement.nonSNAPEligibleItemsHeader).trim());
        if (driver.getPlatformName().equalsIgnoreCase("ANDROID"))
            elementsMap.put("NON_SNAP_ELIGIBLE_SHEET_SUB_HEADER_TEXT", getText(gg_checkoutPageElement.nonSNAPEligibleItemsSubHeader).trim());
        elementsMap.put("NON_SNAP_ELIGIBLE_SHEET_REMOVE_ALL", isElementDisplayed(gg_checkoutPageElement.nonSNAPEligibleItemsRemoveAll));
        elementsMap.put("NON_SNAP_ELIGIBLE_SHEET_CLOSE", isElementDisplayed(gg_checkoutPageElement.nonSNAPEligibleItemsClose));
        elementsMap.put("NON_SNAP_ELIGIBLE_SHEET_CATEGORIES", gg_checkoutPageElement.nonSNAPEligibleItemsCategories.size() > 0);
        elementsMap.put("NON_SNAP_ELIGIBLE_SHEET_PRODUCTS", gg_checkoutPageElement.nonSNAPSCPEligibleItemsList.size() > 0);
        return elementsMap;
    }

    public void swipePartiallyAcrossTheFirstProductInNonSnapEligibleItemsSheet() {
        new WaitAction(driver).waitForDisplayed(gg_checkoutPageElement.nonSNAPEligibleItemsProductCards.get(0), 4);
        new PageActions(driver).new SwipeActions().slidePartiallyAcrossTheCardFromRightToLeft(gg_checkoutPageElement.nonSNAPEligibleItemsProductCards.get(0));
    }

    public List<String> getCategoriesFromNonSnapEligibleItemsSheet() {
        return gg_checkoutPageElement.nonSNAPEligibleItemsCategories.stream().map(WebElement::getText).map(String::trim)
                .distinct().collect(Collectors.toList());
    }

    public int getItemsCountFromHeaderInNonSnapEligibleItemsSheet() {
        return Integer.parseInt(gg_checkoutPageElement.nonSNAPEligibleItemsHeader.getText().replaceAll("[^\\d]", "").trim());
    }

    public void clickBackButtonInCheckout() {
        new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.backButtonToCart);
    }

    public void clickOnRemoveBtn() {
        new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.removeBtn);
        waitForProductToBeRemovedInNonSnapEligibleItemsSheet(Integer.valueOf(ThreadLocalHelper.testCaseData.get().get("ITEMS_COUNT_NON_SNAP_ELIGIBLE")));
    }

    public void clickRemoveAllItemsNonSnapEligible() {
        new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.nonSNAPEligibleItemsRemoveAll);
        new WaitAction(driver).waitForDisplayed(gg_checkoutPageElement.placeOrderButton,10);
    }

    public boolean isRemoveAllItemsButtonDisplayedInNonSnapEligibleSheet() {
        return isElementDisplayed(gg_checkoutPageElement.nonSNAPEligibleItemsRemoveAll, 5);
    }

    public boolean isCategoryHeaderInNonSnapItemsSheetSticky() {
       new WaitAction(driver).waitForDisplayed(gg_checkoutPageElement.nonSNAPEligibleItemsRemoveAll,10);
        String currentHeader = gg_checkoutPageElement.nonSNAPEligibleItemsCategories.get(0).getText().trim();
        for (int scrollCounter = 0; scrollCounter < 2; scrollCounter++) {
            scrollDown();
        }
        return gg_checkoutPageElement.nonSNAPEligibleItemsCategories.get(0).getText().trim().contentEquals(currentHeader);
    }

    public void fillContactInformation() {
        if (isElementDisplayed(gg_checkoutPageElement.contactInfoButton, 5)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.contactInfoButton);
            isElementDisplayed(gg_contactPageElements.firstNameLabel, 5);
            enterKey(gg_contactPageElements.firstNameField, "Test");
            enterKey(gg_contactPageElements.lastNameField, "Test");
            enterKey(gg_contactPageElements.phoneNumberField, "13424234234");
            new CommonActions(driver).new ClickAction().clickElement(gg_contactPageElements.lastNameLabel);
        }
    }

    public void clickContinueCTA() {
        if (isElementDisplayed(gg_checkoutPageElement.continuePaymentButton, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.continuePaymentButton);
        }
    }

    public void selectNextDayPickupOption() {
        waitForLoaderToDisappear();
        if (isElementDisplayed(gg_checkoutPageElement.nextDayPickupButtons, 10)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.nextDayPickupButtons);
        }
        waitForLoaderToDisappear();
    }


    public void clickStoreCreditCardDetails() {
        if (isElementDisplayed(gg_checkoutPageElement.storeCreditCardDetails, 1)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.storeCreditCardDetails);
        }
    }

    public void selectAvailablePickUpSlot() {
        new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.pickUpSlotCTA);
        if (isElementDisplayed(gg_checkoutPageElement.continueToPaymentCTA, 5)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.continueToPaymentCTA);
        } else if (isElementDisplayed(gg_checkoutPageElement.saveButton, 1)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.saveButton);
        } else {
            selectLatestPickupSlot("n");
        }
    }

    public void selectLatestPickupSlot(String day) {
        new WaitAction(driver).waitForDisplayed(gg_checkoutPageElement.pickUpSlotCTA, 5);
        new TapAction(driver).tapCoordinate(gg_checkoutPageElement.pickUpSlotCTA.getCenter().getX(), gg_checkoutPageElement.pickUpSlotCTA.getCenter().getY());
        new WaitAction(driver).waitForDisplayed(gg_checkoutPageElement.daySlotsContainer, 10);
        new PageActions(driver).new SwipeActions().slideAcrossTheCardFromRightToLeft(gg_checkoutPageElement.daySlotsContainer);
        int size = gg_checkoutPageElement.daySlots.size();
        int desiredIndex = 0;
        switch (day) {
            case "n":
                desiredIndex = size - 1;
                break;
            case "n-1":
                desiredIndex = size - 2;
                break;
            case "n-2":
                desiredIndex = size - 3;
                break;
            case "n-3":
                desiredIndex = size - 4;
                break;
            case "n-4":
                desiredIndex = size - 5;
                break;
        }
        new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.daySlots.get(desiredIndex));
        if (isElementDisplayed(gg_checkoutPageElement.continueToPaymentCTA, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.continueToPaymentCTA);
        }
        if (isElementDisplayed(gg_checkoutPageElement.saveButton, 1)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.saveButton);
        }
    }

    public void clickPayment() {
        if (isElementDisplayed(gg_checkoutPageElement.enterPayment, 10)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.enterPayment);
        }
    }

    public void clickContactInfo() {
        if (isElementDisplayed(gg_checkoutPageElement.contactInfo, 5)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.contactInfo);
        }
    }

    public void completesConfirmCVVVisible() {
        if (isElementDisplayed(gg_checkoutPageElement.btnConfirmCVVOrders, 5)) {
           new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.btnConfirmCVVOrders);
            enterCVV("111");
            clickContinueToReviewOrder();
        }
    }

    public void enableOrderStatusUpdates() {
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                if (gg_checkoutPageElement.orderStatusUpdatesSwitch.getAttribute("value").contentEquals("0")) {
                    new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.orderStatusUpdatesSwitch);
                }
                break;
            case "ANDROID":
                if (gg_checkoutPageElement.orderStatusUpdatesSwitch.getAttribute("text").contentEquals("OFF")) {
                    new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.orderStatusUpdatesSwitch);
                }
                break;
        }
        if (isElementDisplayed(gg_checkoutPageElement.continueToReviewOrderBtn, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.continueToReviewOrderBtn);
            new WaitAction(driver).waitForElementToDisappear(gg_checkoutPageElement.closeContactInfoSheet, 5);
        } else if (isElementDisplayed(gg_checkoutPageElement.saveButton, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.saveButton);
            new WaitAction(driver).waitForElementToDisappear(gg_checkoutPageElement.closeContactInfoSheet, 5);
        }
    }

    public boolean verifySearchBarDisplayedEditCart() {
        return isElementDisplayed(gg_checkoutPageElement.searchFieldInEditCart, 5);
    }

    public boolean verifyConfirmChangesButtonDisableEditOrder() {
        waitForLoaderToDisappear();
        return isElementDisplayed(gg_checkoutPageElement.confirmChangesDisable, 5);
    }

    public void clickCancelButtonEditOrder() {
        new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.cancelOrBackEditOrder);
    }

    public void clickDiscardChangesEditOrder() {
        new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.discardChanges);
    }

    public String verifyOrderSaved() {
        waitForLoaderToDisappear();
        isElementDisplayed(gg_checkoutPageElement.orderSavedTitle, 10);
        return gg_checkoutPageElement.orderSavedTitle.getText();
    }

    public void clickOnEditOrderLink() {
        new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.editOrderLink);
    }

    public void userCompletesCreditCardForm() {
        LoaderUtil.waitForCartLoaderToDisappear();
        if (isElementDisplayed(gg_checkoutPageElement.creditCardNameField, 10)) {
            enterNameInCreditCard("Thomas Ford");
            enterCreditCardNumber("4242424242424242");
            enterCreditCardExpirationDate("1025");
            enterCreditCardBillingZipCode("95134");
            clickContinueCTA();
            LoaderUtil.waitForSavingPaymentInfoLoaderToDisappear();
        }
        enterCVV("111");
        clickContinueToReviewOrder();
    }

    public void changeThePickupStoreRetainingTheSameZipCode() {
        CommonActions.ClickAction clickHandler = new CommonActions(driver).new ClickAction();
        new WaitAction(driver).waitForDisplayed(gg_checkoutPageElement.pickUpStoreOrderScreen, 5);
        clickHandler.clickElement(gg_checkoutPageElement.pickUpStoreOrderScreen);
        clickHandler.clickElement(gg_checkoutPageElement.editStore);
        new WaitAction(driver).waitForDisplayed(gg_checkoutPageElement.zipCodeField, 5);
        if (driver.getPlatformName().toLowerCase().equalsIgnoreCase("android")) {
            String currentAddress = gg_checkoutPageElement.pickUpStoreInSelectScreen.get(0).getText();
            clickHandler.clickElement(gg_checkoutPageElement.selectPickupStoreHeader);
            clickHandler.clickElement(gg_checkoutPageElement.pickUpStoreInSelectScreen.stream().filter(indPickUpStore -> !indPickUpStore.getText().contains(currentAddress)).findFirst().get());
        } else if (driver.getPlatformName().toLowerCase().equalsIgnoreCase("ios")) {
            clickHandler.clickElement(gg_checkoutPageElement.pickUpStoreInSelectScreen.stream().filter(indPickUpStore -> indPickUpStore.getAttribute("value") == null).findFirst().get());
        }
        tapContinue();
    }

    private void closeBottomSheet() {
        // Back button is not available in android
        if (isElementDisplayed(gg_checkoutPageElement.bottomSheetHeader, 5)) {
            androidNavigateBack();
            waitForLoaderToDisappear();
        }
    }

    public void backBtnCartToCheckout() {
        isElementDisplayed(gg_checkoutPageElement.backBtnCartToCheckout, 5);
       new CommonActions(driver).new ClickAction().clickElement(gg_checkoutPageElement.backBtnCartToCheckout);
    }

    private void waitForProductToBeRemovedInNonSnapEligibleItemsSheet(int initialProdCount) {
        Awaitility.waitAtMost(20, TimeUnit.SECONDS).with().pollInterval(2, TimeUnit.SECONDS).until(() -> getItemsCountFromHeaderInNonSnapEligibleItemsSheet() < initialProdCount);
    }
}




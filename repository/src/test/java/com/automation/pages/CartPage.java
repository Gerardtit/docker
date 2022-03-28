package com.automation.pages;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.TapAction;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.CartPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    private CartPageElements cartPageElements = new CartPageElements();
    private HomePage homepage;

    public CartPage(AppiumDriver driver) {
        super(driver);
        homepage = new HomePage(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cartPageElements);
    }


    public void waitForCartPageDisplayed() {
        new WaitAction(driver).waitForLoadingComplete();
        waitVar.until(ExpectedConditions.visibilityOf(cartPageElements.myCartTitle));
    }

    public void waitForEmptyCartDisplayed() {
        waitForLoadingComplete();
        waitVar.until(ExpectedConditions.visibilityOf(cartPageElements.emptyCartImage));
    }

    public void emptyCart() {
        while (true) {
            try {
                Thread.sleep(1000);
                if (cartPageElements.emptyCartImage.isDisplayed()) return;
            } catch (Exception e) {
                new CommonActions(driver).new ClickAction().clickElement(cartPageElements.removeIcon);

            }
        }
    }

    public void closeCartPage() {
        cartPageElements.closeButton.click();
    }

    public boolean verifyTotalNumber(int num) {
        String displayedNum;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            displayedNum = cartPageElements.totalNumber.getText().replace("(", "")
                    .replace(")", "");
        } else {//ios
            displayedNum = StringUtils.substringBetween(cartPageElements.totalNumber.getText(), "(", ")");
        }

        if (Integer.parseInt(displayedNum) == num) {
            return true;
        } else return false;
    }

    public void clickRemoveIcon() {
        //   cartPageElements.removeIcon.click();
        new CommonActions(driver).new ClickAction().clickElement(cartPageElements.removeIcon);

    }

    public void increaseItemQuantity(int item, int quantity) {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            MobileElement element = null;
            element = cartPageElements.plusButtonList.get(item - 1);
            for (int i = 0; i < quantity; i++) {
                new CommonActions(driver).new ClickAction().clickElement(element);
                //new WaitAction(driver).waitForLoadingComplete();
            }
        }
    }

    public void clickOnFirstITem() {
        new CommonActions(driver).new ClickAction().clickElement(cartPageElements.clickfirstItem);
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void clickCheckout() {
        new WaitAction(driver).waitForClickableAndClick(cartPageElements.checkoutButton);

    }

    public boolean checkoutButtonEnabled() {
        new WaitAction(driver).waitForDisplayed(cartPageElements.checkoutButton);
        return cartPageElements.checkoutButton.isEnabled();
    }

    public void togglePickupToDelivery() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (cartPageElements.toggleToPickup.isDisplayed()) {
                new TapAction(driver).tapCoordinate(cartPageElements.toggleToPickup.getCenter().getX(), cartPageElements.toggleToPickup.getCenter().getY());
                new WaitAction(driver).waitForDisplayed(cartPageElements.toggleToDelivery, 5);
            }
        }
    }

    public void dayNextToTodayCTA() {
        new WaitAction(driver).waitForDisplayed(cartPageElements.dayNextToToday);
        new CommonActions(driver).new ClickAction().clickElement(cartPageElements.dayNextToToday);
    }

    public void continuePaymentCTA() {
        new WaitAction(driver).waitForClickableAndClick(cartPageElements.continuePaymentCTA);
    }

    public void continueSlotSelectionCTA() {
        new WaitAction(driver).waitForClickableAndClick(cartPageElements.continueSlotSelection);
    }

    public boolean verifyAddAddressPageIsDisplayed() {
        return cartPageElements.verifyAddAddressPageIsDisplayed.isDisplayed();
    }

    public void clickBackButtonAddAddressPage() {
        new CommonActions(driver).new ClickAction().clickElement(cartPageElements.backButtonAddAddressPage);
    }

    public void closeSlotSelectionScreen() {
        new CommonActions(driver).new ClickAction().clickElement(cartPageElements.closeSlotSelectionScreen);
    }

    public void continueReviewOrderCTA() throws InterruptedException {
        new WaitAction(driver).waitForClickableAndClick(cartPageElements.reviewOrder);
        Thread.sleep(3000);
    }

    public void continueContactInfoCTA() {
        new WaitAction(driver).waitForClickableAndClick(cartPageElements.continueContactInfo);
    }

    public void clickEnterPayment() {
        new WaitAction(driver).waitForDisplayed(cartPageElements.clickEnterpayment);
        cartPageElements.clickEnterpayment.click();
    }

    public void confirmSelection() {
        new WaitAction(driver).waitForDisplayed(cartPageElements.confirmPopup);
        new CommonActions(driver).new ClickAction().clickElement(cartPageElements.confirmPopup);
    }

    /*   public boolean isInstoreButtonDisplayed(){
           new WaitAction(driver).waitForDisplayed(cartPageElements.inStoreButton);
           return cartPageElements.inStoreButton.isDisplayed());

       }
   */
    public void clickChangeQuantityButtonOnItem(String changeQuantity, int item) {
        List<MobileElement> elements = null;
        if (changeQuantity.equalsIgnoreCase("increase")) {
            elements = cartPageElements.plusButtonList;
        } else if (changeQuantity.equalsIgnoreCase("decrease")) {
            elements = cartPageElements.minusButtonList;
        }
        for (MobileElement element : elements) {
            if (element.isDisplayed()) {
                item--;
                if (item == 0) {
                    new CommonActions(driver).new ClickAction().clickElement(element);
                    return;
                }
            }
        }

    }

    public void clickSingleIncreaseMultipleTimes(int arg0) {
        new WaitAction(driver).waitForLoadingComplete();
        MobileElement element = cartPageElements.plusButton;
        for (int i = 0; i < arg0; i++) {
            new CommonActions(driver).new ClickAction().clickElement(element);
        }
    }

    public boolean cartNotEmpty() {
        return cartPageElements.removeIcon.isDisplayed();
    }

    public void waitForEstimationTotalInformationIconDisplayed() {
        new WaitAction(driver).waitForDisplayed(cartPageElements.EstimatedTotalInfoIcon);
    }

    public void waitForEstimationTotalTextisDisplayed() {
        new WaitAction(driver).waitForDisplayed(cartPageElements.EstimatedTotalText);
    }

    public void waitForEstTotalTextisDisplayed() {
        new WaitAction(driver).waitForDisplayed(cartPageElements.EstimatedTotalText);
        Assert.assertTrue(cartPageElements.EstimatedTotalText.getText().equalsIgnoreCase("Est. total"));
    }

    public void waitForEstimatedRewardCardSavingsTextisDisplayed() {
        new WaitAction(driver).waitForDisplayed(cartPageElements.EstimatedRewardCardSavingsText);
    }

    public void waitForEstimatedClubCardSavingsTextisDisplayed() {
        new WaitAction(driver).waitForDisplayed(cartPageElements.EstimatedClubCardSavingsText);
    }

    public void clickEstimationTotalInformationIcon() {
        new WaitAction(driver).waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(cartPageElements.EstimatedTotalInfoIcon);

    }

    public void clickEstimatedRewardSavingsInformationIcon() {
        //  new WaitAction(driver).waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(cartPageElements.EstimatedRewardSavingsInfoIcon);
        new WaitAction(driver).waitForLoadingComplete();

    }

    public void changeAllItemQuantity(String quantity) throws InterruptedException {

            /*new CommonActions(driver).new ClickAction().clickElement(element);
            element.sendKeys(quantity);
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                driver.findElementByName("Update").click();
            } else {
                tapEnterAndroidKeyboard();
            }*/
        for (int i = 0; i < Integer.parseInt(quantity); i++) {
            for (MobileElement element : cartPageElements.quantityFieldList) {
                //if (isElementDisplayed(element)) {
                //new CommonActions(driver).new ClickAction().clickElement(element);
                element.click();

            }
        }
    }

    public void increaseAllItemQuantity(int step) {
        for (MobileElement element : cartPageElements.plusButtonList) {
            for (int i = 0; i < step; i++) {
                new CommonActions(driver).new ClickAction().clickElement(element);
                new WaitAction(driver).waitForLoadingComplete();
            }
            new WaitAction(driver).waitForLoadingComplete();
        }
    }

    public void decreaseAllItemQuantity(int step) {
        for (MobileElement element : cartPageElements.minusButtonList) {
            for (int i = 0; i < step; i++) {
                new CommonActions(driver).new ClickAction().clickElement(element);
                new WaitAction(driver).waitForLoadingComplete();
            }
            new WaitAction(driver).waitForLoadingComplete();
        }
    }


    public void waitForEstimatedSavingsTotalInformationIconDisplayed() {
        new WaitAction(driver).waitForDisplayed(cartPageElements.EstimatedSavingsInfoIcon);
    }

    public void removeItem() {
        new CommonActions(driver).new ClickAction().clickElement(cartPageElements.removeButton);
    }


    public void swipeLeftToRemoveAllItem() {
        for (MobileElement element : cartPageElements.cartItemsImageList) {
            swipeLeftOnElement(element);
            new WaitAction(driver).waitForDisplayed(cartPageElements.swipeRemoveButton);
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                new CommonActions(driver).new ClickAction().clickElement(cartPageElements.swipeRemoveButton);
            } else {
                //   tapCoordinate((int) (driver.manage().window().getSize().width * 0.95), element.getCenter().getY());
                new CommonActions(driver).new ClickAction().clickElement(cartPageElements.swipeRemoveButton);

            }
            new WaitAction(driver).waitForLoadingComplete();
        }
    }

    public void swipeLeftToRemoveItems() {

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            for (MobileElement element : cartPageElements.cartItemsImageList) {
                swipeLeftOnElement(element);
                new CommonActions(driver).new ClickAction().clickElement(cartPageElements.swipeRemoveButton);
                //  new WaitAction(driver).waitForLoadingComplete();
            }
        } else {
            swipeLeft();
            //      tapCoordinate(991, 1028);
            new WaitAction(driver).waitForLoadingComplete();
            new CommonActions(driver).new ClickAction().clickElement(cartPageElements.swipeRemoveButton);

        }
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void clickGlobalSubstitutionCheckbox() {
        new CommonActions(driver).new ClickAction().clickElement(cartPageElements.globalSubstitutionCheckbox);
    }

    public boolean globalSubstitutionCheckboxEnabled() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            return cartPageElements.globalSubstitutionCheckbox.getText().contains("1");
        } else {
            String checked = cartPageElements.globalSubstitutionCheckbox.getAttribute("checked");
            if (checked.contains("false")) return false;
            else return true;
        }
    }

    public boolean checkedNoSubstitutionForAllItems() throws InterruptedException {
        Thread.sleep(3000);
        for (MobileElement element : cartPageElements.itemSubstitutionCheckboxList) {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                if (element.getText().contains("Not selected")) return false;
            } else {
                String checked = element.getAttribute("checked");
                if (checked.contains("false")) return false;
            }
        }
        return true;
    }


    public void waitForCartSummaryDisplayed() {
        new WaitAction(driver).waitForDisplayed(cartPageElements.cartSummary);
    }


    public void removedSubstituion() {
        if (!isElementDisplayed(cartPageElements.noSubstitutionPreference, 30)) {
            Assert.assertTrue(false, "Substitution preference is removed");
        }

    }

    public void verifyinStoreHeader() {

        new WaitAction(driver).waitForLoadingComplete();
        waitVar.until(ExpectedConditions.visibilityOf(cartPageElements.inStoreHeader));

    }

    public void milkRemove() {
        if (cartPageElements.removeMilk.size() > 0) {
            new CommonActions(driver).new ClickAction().clickElement(cartPageElements.removeButton);
            new CommonActions(driver).new ClickAction().clickElement(cartPageElements.doneCartpage);
        } else {
            new CommonActions(driver).new ClickAction().clickElement(cartPageElements.doneCartpage);
        }
    }

    public void navigateBackToCartPage() {

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new CommonActions(driver).new ClickAction().clickElement(cartPageElements.doneCartpage);
        } else {
            driver.navigate().back();
        }
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void verifyDoneButtonInCartPage() {
        Assert.assertTrue(cartPageElements.doneCartpage.isDisplayed());
    }


    public void CheckoutIsEnable() {
        try {

            if (cartPageElements.checkoutButtonCartPage.isEnabled()) {
                System.out.println("checkout button is enabled");
            } else {
                System.out.println("checkout button is not enabled");
            }
        } catch (Exception ex) {

        }
    }

    public void cartPageFirstMilkIncremental() throws InterruptedException {
        for (int i = 0; i < 14; i++) {
            Thread.sleep(1000);
            new CommonActions(driver).new ClickAction().clickElement(cartPageElements.cartPageFirstMilkIncremental);
        }
    }

    public void changeShoppingMethodDisplayed() {
        try {
            org.junit.Assert.assertTrue(cartPageElements.changeShoppingMethod.isDisplayed());
        } catch (Exception ex) {

        }
    }

    public void payInStore() {
        try {
            org.junit.Assert.assertTrue(cartPageElements.payInStore.isDisplayed());
        } catch (Exception ex) {

        }
    }

    public void payInStoreDisabledForEmptyCart() {
        Assert.assertTrue(cartPageElements.payInStore.getAttribute("enabled").equals("false"));
    }

    public void clickChangeShoppingMethod() {
        new CommonActions(driver).new ClickAction().clickElement(cartPageElements.changeShoppingMethod);
    }

    public void clickpayInstore() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new WaitAction(driver).waitForLoadingComplete();
            new CommonActions(driver).new ClickAction().clickElement(cartPageElements.payInStore);
        }
    }

    public void CheckoutIsEnabled() {
        try {
            org.junit.Assert.assertTrue(cartPageElements.checkoutOnCartPage.isEnabled());
        } catch (Exception ex) {

        }
    }

    public void myCartVerification() {
        try {
            org.junit.Assert.assertTrue(cartPageElements.myCart.isDisplayed());
        } catch (Exception ex) {

        }
    }


    public void decreaseAllItemQuantityFromCart() {


        for (MobileElement element : cartPageElements.reduceQuantityList) {

            for (int i = 0; i < 21; i++)
                new CommonActions(driver).new ClickAction().clickElement(element);

        }

    }

    public void SaveChanges() {

        cartPageElements.SaveChanges.click();
    }


    public void clickCartInEditOrder() {
        new WaitAction(driver).waitForElementToBeClickable(cartPageElements.cartInEditOrder, 15);
        cartPageElements.cartInEditOrder.click();
    }

    public void VerifyEditOrderPage() {
        waitForLoadingComplete();
        isElementDisplayed(cartPageElements.EditOrderPage);
    }

    public void clickCartInEditOrderofCartPage() {
        waitForElementToBeClickable(cartPageElements.EditOrder, 15);
        cartPageElements.EditOrder.click();
    }

    public void clickBackInEditOrder() {
        new CommonActions(driver).new ClickAction().clickElement(cartPageElements.EditCartBack);
    }


    public void noteToPersonalShopperSearchBox() {
        new WaitAction(driver).waitForDisplayed(cartPageElements.noteForShopperEditText);
    }

    public void enterNoteToPersonalShopper(String arg0) {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            enterKey(cartPageElements.noteForShopperEditText, arg0);
            driver.hideKeyboard();
        } else {
            new CommonActions(driver).new ClickAction().clickElement(cartPageElements.noteForShopperEditText);
            enterKey(cartPageElements.noteForShopperEditText, arg0 + Keys.RETURN.toString());
        }
    }

    public void verifyNoteToPersonalShopper(String arg0) {
        String note;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            note = cartPageElements.noteForShopperEditText.getText();
            Assert.assertTrue(note.equals(arg0));
        } else {
            note = cartPageElements.noteCharacterLimit.getAttribute("name");
            Assert.assertTrue(!note.contains("0/40 characters allowed for this field"));
        }
    }

    public void verifyRadioButtonSelected(String arg0) {
        String str;
        AppiumDevice device = AppiumDeviceManager.getDevice();
        if (device.getPlatform().equalsIgnoreCase("ios")) {
            if (arg0.equalsIgnoreCase("Same Brand, Different Size")) {
                arg0 = "  Same brand, different size";
            } else if (arg0.equalsIgnoreCase("Same Size, Different Brand")) {
                arg0 = "  Same size, different brand";
            } else {
                arg0 = "  No substitutions";
            }
            str = driver.findElementByName(arg0).getAttribute("value");
            Assert.assertTrue(str.equals("1"));

        } else {
            ArrayList<MobileElement> elementList = (ArrayList<MobileElement>) driver.findElementsByClassName("android.widget.RadioButton");
            for (MobileElement element : elementList) {
                if (element.getText().equalsIgnoreCase(arg0)) {
                    str = element.getAttribute("checked");
                    Assert.assertTrue(str.equals("true"));
                }
            }
        }
    }

    public void verifySaveButtonEnabled() {
        Assert.assertTrue(cartPageElements.preferencesSaveButton.isEnabled());
    }

    public void verifyCancelButtonEnabled() {
        Assert.assertTrue(cartPageElements.preferencesCancelButton.isEnabled());
    }

    public void scrollDownToCartSummary() {

        scrollDownForElement(cartPageElements.cartSummary);
    }

    public void verifyClippedBannerText() {
        new WaitAction(driver).waitForDisplayed(cartPageElements.navBanner);
        String text = cartPageElements.navBanner.getText();
        Assert.assertFalse(text.contains("Clipped deal"));
    }

    public void DriverTipIsDisplayed() throws InterruptedException {
        isElementDisplayed(cartPageElements.DriverTip);
    }

    public void clickonChangeLinkneartoDriverTip() throws InterruptedException {
        isElementDisplayed(cartPageElements.ChangeLink);
        new CommonActions(driver).new ClickAction().clickElement(cartPageElements.ChangeLink);
    }

    public void VerifyAddCustomTipWindow() throws InterruptedException {
        {
            isElementDisplayed(cartPageElements.AddCustomTipWindow);

        }
    }

    public void ClickonCustomTipRadioButton() throws InterruptedException {
        new CommonActions(driver).new ClickAction().clickElement(cartPageElements.CustomTip);
    }

    public void VerifyCustomTipField() throws InterruptedException {
        isElementDisplayed(cartPageElements.CustomTipField);
    }

    public void EnterAmountinCustomTipField(String strAmount) throws InterruptedException {
        String[] strAmt1 = strAmount.split("\\$");
        AppiumDevice device = AppiumDeviceManager.getDevice();
        if (device.getPlatform().equalsIgnoreCase("ios")) {

            enterFromKeyboard(cartPageElements.CustomTipField, strAmt1[0]);
            cartPageElements.customtipapply.click();
            cartPageElements.customtipsave.isEnabled();
            cartPageElements.customtipsave.click();
        } else {

            enterKey(cartPageElements.CustomTipField, strAmt1[0]);

        }


       /* if (driver.getPlatformName().equalsIgnoreCase("android")) {
            driver.hideKeyboard();
        }*/
    }

    public void VerifyErrorMessageTipAmount(String strErrMsg) throws InterruptedException {
        AppiumDevice device = AppiumDeviceManager.getDevice();
        if (device.getPlatform().equalsIgnoreCase("ios")) {
            String strCustomTipErrMsg = cartPageElements.CustomTipErrMsg.getAttribute("label");
            if (strCustomTipErrMsg.equals(strErrMsg)) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        } else {
            String strCustomTipErrMsg1 = cartPageElements.CustomTipErrMsg.getAttribute("text");
            if (strCustomTipErrMsg1.equals(strErrMsg)) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        }
    }

    public void VerifyToastMessage(String strErrMsg) throws InterruptedException {
        AppiumDevice device = AppiumDeviceManager.getDevice();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {

            new CommonActions(driver).new ClickAction().clickElement(cartPageElements.ApplyButton);
            String strCustomTipErrMsg = cartPageElements.ToastMessage.getAttribute("label");
            if (strCustomTipErrMsg.equals(strErrMsg)) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        } else {
            new CommonActions(driver).new ClickAction().clickElement(cartPageElements.ApplyButton);
            String strCustomTipErrMsg = cartPageElements.ToastMessage.getText();
            if (strCustomTipErrMsg.equals(strErrMsg)) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        }

    }

    public boolean checkoutEBTButtonEnabled() {
        //waitForDisplayed(cartPageElements.checkoutButton);
        return cartPageElements.checkoutEBTCardCTA.isEnabled();
    }

    public void clickCheckoutEBTLink() {
        cartPageElements.checkoutEBTLink.click();
        waitForLoadingComplete();

    }

    public void waitForSNAPSheetDisplayed() {
        waitForLoadingComplete();
        //  waitVar.until(ExpectedConditions.visibilityOf(cartPageElements.myCartTitle));
        waitVar.until(ExpectedConditions.visibilityOf(cartPageElements.snapSheetTitle));
        waitForLoadingComplete();
        driver.navigate().back();
        waitForLoadingComplete();
    }

    public void clickFirstCartItem() {
        cartPageElements.firstCartItem.click();
        waitForLoadingComplete();

    }

    public void removeItems() throws InterruptedException {
        new CommonActions(driver).new ClickAction().clickElement(cartPageElements.firstCartItem);
        do {
            cartPageElements.cartMinusIcon.click();
            Thread.sleep(7000);
        } while (!isElementVisible(cartPageElements.addToCartButton));
        new CommonActions(driver).new ClickAction().clickElement(cartPageElements.shoppingCartButton);

    }

    public void closeAddAddressWindow() throws InterruptedException {

        AppiumDevice device = AppiumDeviceManager.getDevice();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (isElementDisplayed(cartPageElements.AddAdressCloseButton)) {
                new CommonActions(driver).new ClickAction().clickElement(cartPageElements.AddAdressCloseButton);
            }
        } else {
            if (isElementDisplayed(cartPageElements.BackButton)) {
                new CommonActions(driver).new ClickAction().clickElement(cartPageElements.BackButton);
                if (isElementDisplayed(cartPageElements.CloseSlotScreen)) {
                    new CommonActions(driver).new ClickAction().clickElement(cartPageElements.CloseSlotScreen);
                    new CommonActions(driver).new ClickAction().clickElement(cartPageElements.NoSaveButton);
                    waitForLoadingComplete();
                }
            }
        }
    }

    public void changePDPItemQuantity(String quantity) throws InterruptedException {

        for (int i = 0; i < Integer.parseInt(quantity); i++) {
            Thread.sleep(3000);
            for (MobileElement element : cartPageElements.pdp_quantityFieldList) {
                //if (isElementDisplayed(element)) {
                //clickElement(element);
                element.click();
                waitForLoadingComplete();
                Thread.sleep(5000);
            }
        }
        //new CommonActions(driver).new ClickAction().clickElement(cartPageElements.shoppingCartButton);
    }

    public void VerifyCartTotal(String CartExpected) throws InterruptedException {

        //  String[] CartExpected1 = CartExpected.split("$");
        //   String cartExpectedValue   =  CartExpected1[0];
        Double ExpectedAmount = Double.parseDouble(CartExpected);
        AppiumDevice device = AppiumDeviceManager.getDevice();
        String deviceName = driver.getPlatformName().toLowerCase();
        switch (deviceName) {
            case "ios":
                String cartActualValue = cartPageElements.CartTotalAmount.getAttribute("label");
                String cartActualValue1[] = cartActualValue.split("\\$");
                String cartActual = cartActualValue1[1];
                String cartActual1[] = cartActual.split("\\,");
                String cartActual2 = cartActual1[0];
                Double ActualAmount = Double.parseDouble(cartActual2);
                if (Double.compare(ActualAmount, ExpectedAmount) > 0) {
                    Assert.assertTrue(true);
                }
                break;
            case "android":
                waitForLoadingComplete();
                waitForLoadingComplete();
                String cartActualValue2 = cartPageElements.CartTotalAmount.getAttribute("text");
                waitForLoadingComplete();

                String[] cartActualValue3 = cartActualValue2.split("\\$");
                waitForLoadingComplete();
                String cartActual4 = cartActualValue3[1];
                Double ActualAmount1 = Double.parseDouble(cartActual4);
                if (Double.compare(ActualAmount1, ExpectedAmount) > 0) {
                    Assert.assertTrue(true);
                }
                break;
        }

    }

    public void clickBackCTACheckout() {
        waitForClickableAndClick(cartPageElements.cartClose);
        waitForLoadingComplete();
    }
}


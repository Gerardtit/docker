package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.TapAction;
import com.automation.pageElements.GG_OrderInfoPageElements;
import com.automation.pageElements.ViewOrderDetailPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class GG_OrderInfoPage extends BasePage {
    public ViewOrderDetailPageElements viewdetail = new ViewOrderDetailPageElements();

    private final GG_OrderInfoPageElements orderInfoPageElements = new GG_OrderInfoPageElements();
    public CheckoutPage checkoutpage = new CheckoutPage(driver);

    public GG_OrderInfoPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), orderInfoPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), viewdetail);

    }

    public boolean isDeliveryAddressDisplayed() {
        return isElementDisplayed(orderInfoPageElements.deliveryAddress);
    }

    public boolean isStoreAddressDisplayed() {
        return isElementDisplayed(orderInfoPageElements.storeAddress);
    }

    public boolean isTimeSlotLabelDisplayed() {
        return isElementDisplayed(orderInfoPageElements.chooseDateTimeLabel);
    }

    public boolean areAllDeliveryWindowOptionsDisplayed() {
        return isElementDisplayed(orderInfoPageElements.oneHourDeliveryButton) && isElementDisplayed(orderInfoPageElements.twoHourDeliveryButton) && isElementDisplayed(orderInfoPageElements.fourHourDeliveryButton);
    }

    public boolean isDeliveryWindowInfoIconDisplayed() {
        return isElementDisplayed(orderInfoPageElements.deliveryWindowInfo);
    }

    public boolean isSaveButtonEnabled() {
        return orderInfoPageElements.saveButton.isEnabled();
    }

    public boolean isNoSlotsOnPickerWheelDisplayed() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            return isElementDisplayed(orderInfoPageElements.noSlotsAvailableWheel, 5);
        } else {
            return !isElementDisplayed(orderInfoPageElements.timeOnTimePicker, 5);
        }
    }

    public void clickEditDeliveryAddress() {
        new CommonActions(driver).new ClickAction().clickElement(orderInfoPageElements.editDeliveryAddressButton);
    }

    public void scrollDownToBottom() {
        scrollDownForElement(orderInfoPageElements.requiredFieldsWarning);
    }

    public void enterDeliveryInstructions(String instructions) {
        scrollDownForElement(orderInfoPageElements.deliveryInstructionsEditBox);
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            enterTextNoPressEnter(orderInfoPageElements.deliveryInstructionsEditBox, instructions);
            new TapAction(driver).tapSearchEnterAndroid();
        } else {
            enterKey(orderInfoPageElements.deliveryInstructionsEditBox, instructions);
        }
    }

    public boolean isEnterValidInstructionsWarningDisplayed() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            driver.hideKeyboard();
        }
        scrollDownToBottom();
        return isElementDisplayed(orderInfoPageElements.enterValidInstructionsWarning);
    }

    public void enterAddressLine1(String addressLine1) throws IOException {
        enterKey(orderInfoPageElements.addressLine1TextField, addressLine1);
    }

    public void enterAddressLine2(String addressLine2) throws IOException {
        scrollDownForElement(orderInfoPageElements.addressLineCityTextHeader);
        enterKey(orderInfoPageElements.addressLine2TextField, addressLine2);
    }

    public boolean isOrderInfoPageDisplayed() {
        if (isElementDisplayed(orderInfoPageElements.serverErrorMessage)) {
            new CommonActions(driver).new ClickAction().clickElement(orderInfoPageElements.serverErrorDismissButton);
        }
        return isElementDisplayed(orderInfoPageElements.orderInfoPageHeader);
    }

    public void clickSaveButton() {
        new CommonActions(driver).new ClickAction().clickElement(orderInfoPageElements.saveButton);
    }

    public void clickBackButton() {
        new CommonActions(driver).new ClickAction().clickElement(orderInfoPageElements.backButtonToCheckOut);
    }

    public void clickOnCancelButton() {
        new CommonActions(driver).new ClickAction().clickElement(orderInfoPageElements.cancelButtonOnOrderInfoPage);
    }

    public void handleAlertPopUp() {

        if (isElementDisplayed(orderInfoPageElements.selectDeliveryPopUp)) {
            new CommonActions(driver).new ClickAction().clickElement(orderInfoPageElements.denyButton);

        }
    }


    public void orderdate() {
        scrollDownForElement(viewdetail.orderTotalCost);
        Assert.assertTrue(viewdetail.orderDate.isDisplayed(), "Order date is wrong");

    }

    public void ordernumber() {
        String ConfirmationorderNo = checkoutpage.OrderActualNumber;
        String ViewDtailorder = viewdetail.ordernumber.getAttribute("label");
        Assert.assertTrue(ViewDtailorder.contains(ConfirmationorderNo), "It is different order number");

    }

    public void orderTotal() {
        String ConfirmationorderNo = checkoutpage.OrderActualNumber;
        String ViewDtailorder = viewdetail.orderTotalCost.getAttribute("label");
        Assert.assertTrue(ViewDtailorder.contains(ConfirmationorderNo), "It is different order number");

    }


}

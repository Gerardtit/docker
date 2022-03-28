package com.automation.pages;


import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_OrderStatusPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GG_OrderStatusPage extends BasePage {

    private final GG_OrderStatusPageElements orderStatusPageElements = new GG_OrderStatusPageElements();

    public GG_OrderStatusPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), orderStatusPageElements);
    }

    public boolean isPickupOrderStatusDisplayed() {
        return isElementDisplayed(orderStatusPageElements.pickupOrderFirstStatus);
    }

    public boolean isPickupOrderFirstStatusDisplayed() {
        return isElementDisplayed(orderStatusPageElements.pickupOrderFirstStatus);
    }

    public boolean isChangeOrderLinkTextDisplayed() {
        return isElementDisplayed(orderStatusPageElements.changeOrderLinkText);
    }

    public void clickChangeOrderLinkOnOrderStatus() {
        new CommonActions(driver).new ClickAction().clickElement(orderStatusPageElements.changeOrderLinkText);
    }

    public boolean isEditOrderScreenDisplayed() {
        new WaitAction(driver).waitForLoaderToDisappear();
        return isElementDisplayed(orderStatusPageElements.editOrderScreenTitle);
    }

    public void clickViewDetailsOnOrderStatus() {
        new CommonActions(driver).new ClickAction().clickElement(orderStatusPageElements.viewDetailsButton);
    }

    // Need to check Attribute check once id is added properly.
    public boolean isOrderPlacedStatusIconHighlited() {
        return isElementDisplayed(orderStatusPageElements.orderPlacedStatusIcon);
    }

    // Need to check Attribute check once id is added properly.
    public boolean isOrderPackedStatusIconNotHighlited() {
        return isElementDisplayed(orderStatusPageElements.orderPackedStatusIcon);
    }

    // Need to check Attribute check once id is added properly.
    public boolean isOrderOnTheWayStatusIconNotHighlited() {
        return isElementDisplayed(orderStatusPageElements.orderOnTheWayStatusIcon);
    }

    // Need to check Attribute check once id is added properly.
    public boolean isOrderDeliveredStatusIconNotHighlited() {
        return isElementDisplayed(orderStatusPageElements.orderDeliveredStatusIcon);
    }

    public boolean isDeliveryOrderStatusDisplayed() {
        return isElementDisplayed(orderStatusPageElements.deliveyOrderFirstStatus);
    }

    public boolean isDeliveryOrderFirstStatusDisplayed() {
        return isElementDisplayed(orderStatusPageElements.deliveyOrderFirstStatus);
    }

    public boolean isOrderNumberDisplayed() {
        return isElementDisplayed(orderStatusPageElements.orderNumber);
    }

    public boolean isPickupOrderStatusNotDisplayed() {
        return orderStatusPageElements.orderNumberList.size() == 0;
    }

    public boolean isPickupOrderSecondStatusDisplayed() {
        return isElementDisplayed(orderStatusPageElements.pickupOrderSecondStatus);
    }

    public boolean isPickupOrderThirdStatusDisplayed() {
        return isElementDisplayed(orderStatusPageElements.pickupOrderThirdStatus);
    }

    public boolean isPickupOrderFourthStatusDisplayed() {
        return isElementDisplayed(orderStatusPageElements.pickupOrderFourthStatus);
    }

    public int getOrderNumberDisplayedHomePage() {
        return Integer.valueOf(orderStatusPageElements.orderNumber.getText().replaceAll("^[0-9]", "").trim());
    }

}

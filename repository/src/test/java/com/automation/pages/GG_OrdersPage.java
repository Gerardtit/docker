package com.automation.pages;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_OrdersPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.Arrays;


public class GG_OrdersPage extends BasePage {
    private final String CANCEL_BY_ORDERNUMBER_DYNAMIC_XPATH_ANDROID = "//*[contains(@text,'%s')]//preceding-sibling::android.widget.Button[@text='CANCEL ORDER']";
    private final String CANCEL_BY_ORDERNUMBER_DYNAMIC_XPATH_IOS = "//XCUIElementTypeButton[@label=\"Cancel Order\"]";
//    private final String CANCEL_BY_ORDERNUMBER_DYNAMIC_XPATH_IOS = "//XCUIElementTypeStaticText[contains(@name,'%s')]//preceding-sibling:: XCUIElementTypeButton[@name='Cancel Order']";


    private GG_OrdersPageElements ordersPageElements = new GG_OrdersPageElements();
    public int number;


    public GG_OrdersPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), ordersPageElements);
    }

    public boolean isOrdersPageDisplayed() {
        return isElementDisplayed(ordersPageElements.ordersHeaderTitle) && ordersPageElements.ordersHeaderTitle.getText().equals("Orders");
    }

    public boolean isPendingOrdersDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        return isElementDisplayed(ordersPageElements.pendingOrderLabel);
    }

    public void cancelAllPendingOrders() throws InterruptedException {
        while (!isElementDisplayed(ordersPageElements.noPendingOrders, 6)) {
            new CommonActions(driver).new ClickAction().clickElement(ordersPageElements.cancelOrderButton);
            clickOnCancelOrderButtonPopUp();
            new WaitAction(driver).pleaseWaitForTheLoadingToComplete();
            Thread.sleep(2000);
        }
    }

    public void cancelLatestOrder() throws InterruptedException {
        if (!isElementDisplayed(ordersPageElements.noPendingOrders, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(ordersPageElements.cancelOrderButton);
            clickOnCancelOrderButtonPopUp();
            new WaitAction(driver).pleaseWaitForTheLoadingToComplete();
            Thread.sleep(2000);
        }
    }

    public void clickOnCancelOrderButtonPopUp() {
        if (isElementDisplayed(ordersPageElements.cancelOrderPopUpButton, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(ordersPageElements.cancelOrderPopUpButton);
        }
    }

    public boolean isPendingOrdersNotDisplayed() {
        return isElementDisplayed(ordersPageElements.noPendingOrders);
    }

    public void addAddressDetailsInOrderInfo() throws IOException {
        String deliveryAddress = ThreadLocalHelper.testCaseData.get().get("DELIVERY_ADDRESS");
        enterKey(ordersPageElements.deliveryAddressField, deliveryAddress);
    }

    public void selectYourDeliveryWindow() {
        for (WebElement targetWindow : Arrays.asList(ordersPageElements.deliveryWindow1h, ordersPageElements.deliveryWindow2h, ordersPageElements.deliveryWindow4h)) {
            new CommonActions(driver).new ClickAction().clickElement(targetWindow);
            if (ordersPageElements.saveButton.isEnabled())
                break;
        }
    }

    public int getOrderNumberFromOrderConfirmationPage() {
        try {
            String ordNumber = ordersPageElements.orderNumberOrderConfirmationPage.getText();
            int odnumber = Integer.parseInt(ordNumber.substring(7));
            System.out.println(odnumber);
            number = odnumber;
            return odnumber;
            //  return Integer.valueOf(ordersPageElements.orderNumberOrderConfirmationPage.getText().trim());

        } catch (Exception e) {

            System.out.println("not a number");
            return 0;
        }

    }

    public void cancelOrderByOrderNumber(int orderNumber) throws InterruptedException {
        int maxSwipeDownsForOrder = 10;
        int swipeDownForOrderCounter = 0;
        String dynamicXpath = "";
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                dynamicXpath = String.format(CANCEL_BY_ORDERNUMBER_DYNAMIC_XPATH_IOS, orderNumber);
                break;
            case "ANDROID":
                dynamicXpath = String.format(CANCEL_BY_ORDERNUMBER_DYNAMIC_XPATH_ANDROID, orderNumber);
                break;
        }

        while (swipeDownForOrderCounter <= maxSwipeDownsForOrder) {
            if (!isElementDisplayed((MobileElement) driver.findElement(By.xpath(dynamicXpath)), 3)) {
                scrollDownForElement(dynamicXpath);
            } else {
                new CommonActions(driver).new ClickAction().clickElement(driver.findElement(By.xpath(dynamicXpath)));
                clickOnCancelOrderButtonPopUp();
                Thread.sleep(2000);
                break;
            }
            swipeDownForOrderCounter++;
        }
    }


    public void clickGoBackButtonOrdersPage() {
        if (isElementDisplayed(ordersPageElements.backButton, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(ordersPageElements.backButton);
        }
    }

    public void clickGoBackButtonOrdersDetailsPage() {
        if (isElementDisplayed(ordersPageElements.backOrdersDetailsButton, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(ordersPageElements.backOrdersDetailsButton);
        }
    }

    public void clickFirstViewDetailsButton() {
        if (isElementDisplayed(ordersPageElements.firstViewDetailsButton, 10)) {
            new CommonActions(driver).new ClickAction().clickElement(ordersPageElements.firstViewDetailsButton);
        }
    }

    public void clickEditOrderButton() {
        if (isElementDisplayed(ordersPageElements.editOrderButton, 10)) {
            new CommonActions(driver).new ClickAction().clickElement(ordersPageElements.editOrderButton);
        }
    }

    public void verifyOrderPlacedByOrderNumber() throws InterruptedException {
        waitForLoadingComplete();
        int order = Integer.parseInt(ordersPageElements.orderNumberOrderHistory.getText());
        Assert.assertEquals(order, number);

    }


    public boolean isOrderDateDisplayed() {
        //   return isElementDisplayed(ordersPageElements.orderDate) && ordersPageElements.orderDate.getText().equals("Order");
        return isElementDisplayed(ordersPageElements.orderDate);

    }


    public String amountItemsInOder() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            return ordersPageElements.amountItemsInOrder.getAttribute("label").split(" ")[0];
        }
        return ordersPageElements.amountItemsInOrder.getText().split(" ")[0];
    }

    public boolean chevrondisplayed() {
        return isElementDisplayed(ordersPageElements.chvronOrderDetail);
    }

    public void chvronselected() {
        ordersPageElements.chvronOrderDetail.click();
    }

    public void orderdisplayed() {
        String text = "is confirmed";
        String display = ordersPageElements.isconfirmed.getText();
        Assert.assertTrue(display.contains(text), "fulfillment method is not confirmed");
//        ordersPageElements.isconfirmed.isDisplayed();
    }

    public void trackdetaildisplayed() {
        scrollDownForElement(ordersPageElements.trackOrderDetail);
        String Text = "View Details or Track Order";
        String displayed = ordersPageElements.trackOrderDetail.getText();
        Assert.assertEquals(Text, displayed);
//        ordersPageElements.trackOrderDetail.isDisplayed();
    }

    public void isMapDisplayed() {
        if (isElementDisplayed(ordersPageElements.mapButton, 3)) {
            System.out.println("map is displayed");
        } else {
            System.out.println("map is not displayed");
        }

    }


    public void ValidatesYourOrdersHeading() throws InterruptedException {
        waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(ordersPageElements.yourOrdersHeader);
        Thread.sleep(2000);
    }

    public void verifyOrderDetailsHeading() {
        Assert.assertTrue(ordersPageElements.yourOrderDetailsHeader.isDisplayed());
    }

    public void clickOnItemDetailsChevron() {
        scrollDownForElement(ordersPageElements.itemDetailsChevron);
        new CommonActions(driver).new ClickAction().clickElement(ordersPageElements.itemDetailsChevron);
    }

    public void verifyItemDeatailsHeading() {
        waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(ordersPageElements.itemDetailsHeading);
    }

    public void verifyCOAEBTPaymentMethodDetails() {
        scrollDownForElement(ordersPageElements.creditAppliedTxt);
        Assert.assertTrue(ordersPageElements.creditAppliedTxt.isDisplayed());
        Assert.assertTrue(ordersPageElements.creditAppliedAmountValue.isDisplayed());
        scrollDownForElement(ordersPageElements.paymentMethodTxt);
        Assert.assertTrue(ordersPageElements.paymentMethodTxt.isDisplayed());
        //Assert.assertTrue(ordersPageElements.snapEBTTxt.isDisplayed());
        Assert.assertTrue(ordersPageElements.creditAccountTxt.isDisplayed());
    }

    public void verifyCOAPaymentMethodDetails() {
        scrollDownForElement(ordersPageElements.creditAppliedTxt);
        Assert.assertTrue(ordersPageElements.creditAppliedTxt.isDisplayed());
        Assert.assertTrue(ordersPageElements.creditAppliedAmountValue.isDisplayed());
        scrollDownForElement(ordersPageElements.paymentMethodTxt);
        Assert.assertTrue(ordersPageElements.paymentMethodTxt.isDisplayed());
        Assert.assertTrue(ordersPageElements.creditAccountTxt.isDisplayed());
    }

    public void selectEBTPaymentMethod() {
        waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(ordersPageElements.ebtPaymentMethod);
    }

    public void applyCreditOnAccount() {
        scrollDownForElement(ordersPageElements.applyCreditOnAccountBtn);
        new CommonActions(driver).new ClickAction().clickElement(ordersPageElements.applyCreditOnAccountBtn);
        ordersPageElements.applyCreditTxtFieldBox.clear();
        enterKey(ordersPageElements.applyCreditTxtFieldBox, "1.00");
        new CommonActions(driver).new ClickAction().clickElement(ordersPageElements.applyCreditBtn);
    }

    public void applyCreditOnAccountWholeAmount() {
        scrollDownForElement(ordersPageElements.applyCreditOnAccountBtn);
        new CommonActions(driver).new ClickAction().clickElement(ordersPageElements.applyCreditOnAccountBtn);
        new CommonActions(driver).new ClickAction().clickElement(ordersPageElements.applyCreditBtn);
    }


    public void continuereviewOrder() {
        new CommonActions(driver).new ClickAction().clickElement(ordersPageElements.continueReviewOrderBtn);
    }
}


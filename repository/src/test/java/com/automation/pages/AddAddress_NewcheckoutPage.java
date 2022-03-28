package com.automation.pages;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.AddAddress_OrderPageElements;
import com.automation.pageElements.GG_OrderInfoPageElements;
import com.automation.pageElements.GG_checkout_contactinfoElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class AddAddress_NewcheckoutPage extends BasePage {
    public AddAddress_OrderPageElements pageElements = new AddAddress_OrderPageElements();
    SelectOrderTypePage selectOrderTypePage = new SelectOrderTypePage(driver);
    private final GG_OrderInfoPageElements orderInfoPageElements = new GG_OrderInfoPageElements();
    private final GG_checkout_contactinfoElements contactinfoElements = new GG_checkout_contactinfoElements();

    public AddAddress_NewcheckoutPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), orderInfoPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), contactinfoElements);

    }

    public void addressdetails() {
        String address = ThreadLocalHelper.testCaseData.get().get("Address");
        String apt = ThreadLocalHelper.testCaseData.get().get("APT");
        String zipcode = ThreadLocalHelper.testCaseData.get().get("ZIP");
        String state = ThreadLocalHelper.testCaseData.get().get("STATE");
        String city = ThreadLocalHelper.testCaseData.get().get("CITY");
        String note = ThreadLocalHelper.testCaseData.get().get("NOTE");

        if (isElementDisplayed(orderInfoPageElements.streetaddress)) {
            new CommonActions(driver).new ClickAction().clickElement(orderInfoPageElements.streetaddress);
            enterKey(orderInfoPageElements.streetaddress, address);
        }
        if (isElementDisplayed(orderInfoPageElements.aptno)) {
            new CommonActions(driver).new ClickAction().clickElement(orderInfoPageElements.aptno);
            enterKey(orderInfoPageElements.aptno, apt);
        }
        if (isElementDisplayed(orderInfoPageElements.zipcode_delivery)) {
            new CommonActions(driver).new ClickAction().clickElement(orderInfoPageElements.zipcode_delivery);
            if (driver.getPlatformName().equalsIgnoreCase("android")) {
                orderInfoPageElements.zipcode_delivery.clear();
            }

            enterKey(orderInfoPageElements.zipcode_delivery, zipcode);
        }
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            if (isElementDisplayed(orderInfoPageElements.city_delivery)) {
                orderInfoPageElements.city_delivery.click();
                new CommonActions(driver).new ClickAction().clickElement(orderInfoPageElements.nextOnKeyboard);
            }
        }
        waitForLoadingComplete();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (isElementDisplayed(orderInfoPageElements.nextOnKeyboard)) {

                new CommonActions(driver).new ClickAction().clickElement(orderInfoPageElements.nextOnKeyboard);
            }
            if (isElementDisplayed(orderInfoPageElements.doneOnkeyboard)) {
                new CommonActions(driver).new ClickAction().clickElement(orderInfoPageElements.doneOnkeyboard);
            }
        }
        scrollDownForElement(contactinfoElements.savetab);
        if (isElementDisplayed(contactinfoElements.savetab)) {
            contactinfoElements.savetab.isEnabled();
            contactinfoElements.savetab.click();
        }
    }


    public void addressdetailsonCartpage() {


        AppiumDevice device = AppiumDeviceManager.getDevice();

        String address = ThreadLocalHelper.testCaseData.get().get("Address");
        String apt = ThreadLocalHelper.testCaseData.get().get("APT");
        String zipcode = ThreadLocalHelper.testCaseData.get().get("ZIP");
        String state = ThreadLocalHelper.testCaseData.get().get("STATE");
        String city = ThreadLocalHelper.testCaseData.get().get("CITY");
        String note = ThreadLocalHelper.testCaseData.get().get("NOTE");

        if (isElementDisplayed(orderInfoPageElements.streetaddress)) {
            new CommonActions(driver).new ClickAction().clickElement(orderInfoPageElements.streetaddress);
            enterKey(orderInfoPageElements.streetaddress, address);
        }
    }

    public void validatecursor() {
        String address = ThreadLocalHelper.testCaseData.get().get("Address");

        waitForDisplayed(orderInfoPageElements.streetaddress);
        orderInfoPageElements.streetaddress.isSelected();
        if (isElementDisplayed(orderInfoPageElements.streetaddress)) {
            new CommonActions(driver).new ClickAction().clickElement(orderInfoPageElements.streetaddress);
            enterKey(orderInfoPageElements.streetaddress, address);
        }
    }

    public boolean city() {
        return isElementDisplayed(orderInfoPageElements.city_delivery);
    }

    public boolean state() {
        return isElementDisplayed(orderInfoPageElements.state_delivery);
    }

    public boolean state_unchangable() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            waitForElementToBeClickable(orderInfoPageElements.state_delivery, 100);
        }

        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            waitForElementToBeClickable(orderInfoPageElements.state_delivery, 100);
        }
        return true;
    }

    public boolean apt_optional() {
        String apt = ThreadLocalHelper.testCaseData.get().get("APT");
        String displayed = orderInfoPageElements.aptno.getText();
        if (displayed.contains("(optional)")) {
            return true;
        }
        if (isElementDisplayed(orderInfoPageElements.aptno)) {
            new CommonActions(driver).new ClickAction().clickElement(orderInfoPageElements.aptno);
            enterKey(orderInfoPageElements.aptno, apt);
        }
        return false;
    }
}










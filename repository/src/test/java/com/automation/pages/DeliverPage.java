package com.automation.pages;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.entities.BannerConfType;
import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.DeliverPageElements;
import com.automation.pageElements.MyAccountPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;

public class DeliverPage extends BasePage {
    public AppiumDevice device = AppiumDeviceManager.getDevice();
    public DeliverPageElements pageElements = new DeliverPageElements();
    public EditDeliveryAddressPage deliveryAddressPage;
    private final CheckoutPage checkoutPage = new CheckoutPage(driver);
    private final MyAccountPageElements myAccountPageElements = new MyAccountPageElements();

    public DeliverPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), myAccountPageElements);
        deliveryAddressPage = new EditDeliveryAddressPage(driver);
    }


    public void waitForOrderInfoWindowDisplayed() {
        if (!(getCurrentBanner().equalsIgnoreCase("tomthumb")) && (!getCurrentBanner().equalsIgnoreCase("safeway")) && (!getCurrentBanner().equalsIgnoreCase("shaws")) && (!getCurrentBanner().equalsIgnoreCase("acme")) && (!getCurrentBanner().equalsIgnoreCase("pavilions"))) {
            waitForDisplayed(pageElements.saveButton);
        }
    }

    public void selectDeliveryOption(String deliverOption) {
        if ((getCurrentBanner().equalsIgnoreCase("tomthumb")) || (getCurrentBanner().equalsIgnoreCase("safeway")) || (getCurrentBanner().equalsIgnoreCase("shaws")) || (getCurrentBanner().equalsIgnoreCase("acme")) || (getCurrentBanner().equalsIgnoreCase("pavilions"))) {
            try {
                AppiumDevice device = AppiumDeviceManager.getDevice();
                String address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE1_FORSR);
                deliveryAddressPage.enterAddressLine1(address);
                if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                    new CommonActions(driver).new ClickAction().clickElement(myAccountPageElements.next);
                } else {
                    deliveryAddressPage.clickAddressLine2();
                    tapSearchAndroidKeyboard();
                    tapSearchAndroidKeyboard();
                    scrollDown();
                }
                new CommonActions(driver).new ClickAction().clickElement(myAccountPageElements.saveButton);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }

      /*  if(deliverOption.toLowerCase().contains("unattend")){
          new CommonActions(driver).new ClickAction().clickElement(pageElements.unattendedButton);
        }else if(deliverOption.toLowerCase().contains("attend")){
         new CommonActions(driver).new ClickAction().clickElement(pageElements.attendedButton);
        }*/
        } else {
            try {
                AppiumDevice device = AppiumDeviceManager.getDevice();
                String address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE1_FORSR);

                deliveryAddressPage.enterAddressLine1(address);
                if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                    new CommonActions(driver).new ClickAction().clickElement(myAccountPageElements.next);
                } else {
                    deliveryAddressPage.clickAddressLine2();
                    tapSearchAndroidKeyboard();
                    tapSearchAndroidKeyboard();
                    scrollDown();
                }
                new CommonActions(driver).new ClickAction().clickElement(myAccountPageElements.saveButton);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void clickSaveButton() throws InterruptedException {
        if (!(getCurrentBanner().equalsIgnoreCase("tomthumb")) && (!getCurrentBanner().equalsIgnoreCase("safeway")) && (!getCurrentBanner().equalsIgnoreCase("shaws")) && (!getCurrentBanner().equalsIgnoreCase("acme")) && (!getCurrentBanner().equalsIgnoreCase("pavilions"))) {
            waitForLoadingComplete();
            Thread.sleep(1000);
            if ((pageElements.saveButton).isEnabled()) {
                waitForClickableAndClick(pageElements.saveButton);
            } else if (!(pageElements.saveButton).isEnabled()) {
                new CommonActions(driver).new ClickAction().clickElement(pageElements.backButton);
            }
            Thread.sleep(5000);
        }
    }

    public void waitForDateTimePickerDisplayed() {
        waitForDisplayed(pageElements.datePicker);
    }

    public void waitForCurrentReservedTimeIsDisplayed() {
        waitForDisplayed(pageElements.currentReserveTimeText);
    }


    public void changeDatePickerInOrderInfoScreen() throws InterruptedException {
        waitForLoadingComplete();
        scrollDown();
        MobileElement element = null;
        element = pageElements.datePicker;

        if (device.getPlatform().equalsIgnoreCase("ios")) {
           /* HashMap<String, Object> params = new HashMap<>();
            params.put("order", "next");
            params.put("offset", 0.15);
            params.put("element", ((RemoteWebElement) element).getId());
            driver.executeScript("mobile: selectPickerWheelValue", params);*/
            Dimension dimension = element.getSize();
            Point center = element.getCenter();
            Point tapPoint = new Point(center.x, (int) (center.y + dimension.height * 0.15));
            scroll(tapPoint.x, tapPoint.y, center.x, center.y);
        } else {
            Dimension dimension = element.getSize();
            Point center = element.getCenter();
            Point tapPoint = new Point(center.x, (int) (center.y + dimension.height * 0.5));

            scroll(tapPoint.x, tapPoint.y, center.x, center.y);
        }
        Thread.sleep(2000);
        waitForLoadingComplete();
        waitVar.until(ExpectedConditions.elementToBeClickable(pageElements.saveButton));
    }


    public void changeDatePickerToEnableSave() throws InterruptedException {
        if ((getCurrentBanner().equalsIgnoreCase("tomthumb")) || (getCurrentBanner().equalsIgnoreCase("safeway")) || (getCurrentBanner().equalsIgnoreCase("shaws")) || (getCurrentBanner().equalsIgnoreCase("acme")) || (getCurrentBanner().equalsIgnoreCase("pavilions"))) {
            checkoutPage.continueToPaymentCTA();
        } else {
            waitForLoadingComplete();
            waitForDateTimePickerDisplayed();
//        scrollDown();
            MobileElement element = null;
            element = pageElements.datePicker;
            if (device.getPlatform().equalsIgnoreCase("ios")) {
                HashMap<String, Object> params = new HashMap<>();
                params.put("order", "next");
                params.put("offset", 0.15);
                params.put("element", element.getId());
                try {
                    driver.executeScript("mobile: selectPickerWheelValue", params);
                } catch (Exception e) {

                }

            } else {
                if (!pageElements.saveButton.isEnabled()) {
                    Dimension dimension = element.getSize();
                    Point center = element.getCenter();
                    Point tapPoint = new Point(center.x, (int) (center.y + dimension.height * 0.5));

                    scroll(tapPoint.x, tapPoint.y, center.x, center.y);
                }
            }
            Thread.sleep(2000);
            waitForLoadingComplete();
        }
    }

    public void selectHourOption(int hour) {
        MobileElement hourElement = null;

        switch (hour) {
            case 1:
                hourElement = pageElements.oneHourDeliveryButton;
                break;
            case 2:
                hourElement = pageElements.twoHourDeliveryButton;
                break;
            case 4:
                hourElement = pageElements.fourHourDeliveryButton;
                break;
            default:
                break;
        }
        new CommonActions(driver).new ClickAction().clickElement(hourElement);
    }


    public void dayNextToTodayCTA() throws InterruptedException {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (pageElements.dayNextToToday.isDisplayed()) {
                tapCoordinate(pageElements.dayNextToToday.getCenter().getX(), pageElements.dayNextToToday.getCenter().getY());
                checkoutPage.continueToPaymentCTA();
            }
        }

    }

    public void selectslotonly() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (pageElements.dayNextToToday.isDisplayed()) {
                tapCoordinate(pageElements.dayNextToToday.getCenter().getX(), pageElements.dayNextToToday.getCenter().getY());
            }
        }
    }
}
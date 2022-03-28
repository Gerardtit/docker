package com.automation.pages;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.entities.BannerConfType;
import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.CartPageElements;
import com.automation.pageElements.EditDeliveryAddressPageElements;
import com.automation.pageElements.GG_MyCartPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class EditDeliveryAddressPage extends BasePage {
    GG_MyCartPage gg_myCartPage = new GG_MyCartPage(driver);
    private final EditDeliveryAddressPageElements pageElements = new EditDeliveryAddressPageElements();
    private final GG_MyCartPageElements myCartPageElements = new GG_MyCartPageElements();
    private final CartPageElements cartPageElements = new CartPageElements();

    public EditDeliveryAddressPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);

        PageFactory.initElements(new AppiumFieldDecorator(driver), myCartPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cartPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_myCartPage);
    }

    public void enterAddressLine1(String address) {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            deleteCurrentTextInEditText(pageElements.addressLine1TextField);
        } else {
            pageElements.addressLine1TextField.clear();
        }
        enterKey(pageElements.addressLine1TextField, address);
    }

    public void clickAddressLine2() {
        pageElements.addressLine2TextField.click();

    }

    public void editNewAddress() {
        AppiumDevice device = AppiumDeviceManager.getDevice();
        String address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE1_FORSR);
        enterAddressLine1(address);
    }

    public void editAddress() {
        AppiumDevice device = AppiumDeviceManager.getDevice();
        String address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE);
        enterAddressLine1(address);
    }

    public void editOriginalAddress() throws IOException {
        AppiumDevice device = AppiumDeviceManager.getDevice();
        String address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE1);
        enterAddressLine1(address);
    }

    public void navigateBackTopLeftArrow() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.topLeftArrowBack);
    }

    public void addNewAddress() {
        pageElements.addNewAddress.click();
    }

    public void addressCarousel() {
        pageElements.addressCarousel.click();
    }

    public boolean validateNewAddressAdded() {
        return pageElements.addressAdded.isDisplayed();
    }

    public void EditCartPage() {
        pageElements.editcartTitle.isDisplayed();

    }

    public void itemsCTA() {
        waitForLoadingComplete();
        waitForDisplayed(pageElements.ItemsatEdit);
        pageElements.ItemsatEdit.click();
    }

    public void firstitematEditCart() {
        waitForLoadingComplete();
        waitForDisplayed(pageElements.Firstitem);
        pageElements.Firstitem.click();
    }


    public void editorderbutton() {
        waitForLoadingComplete();
        scrollDownForElement(pageElements.editbutton);
        pageElements.editbutton.click();
    }

    public void add2cart() {
        for (int i = 0; i <= 12; i++) {
            waitForClickableAndClick(pageElements.addQuantity);
//            pageElements.addQuantity.click();
            waitForLoadingComplete();
        }
        new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.myCart);
    }

    public void add2checkout() {
        waitForLoadingComplete();
        pageElements.firstitemfromrecentsearch.click();
        waitForLoadingComplete();
        pageElements.firstitemfromPLP.click();
        if (isElementDisplayed(pageElements.Addtocartab)) {
            pageElements.Addtocartab.click();

        }
        new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.myCart);
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            waitForLoadingComplete();
            gg_myCartPage.clickOnCloseButtonOnMyCartScreen();
        } else {
            gg_myCartPage.clickOnCloseButtonOnMyCartScreen();
        }
        add2cart();

        if (cartPageElements.checkoutButton.isEnabled()) {
            cartPageElements.checkoutButton.click();
//            waitForClickableAndClick(cartPageElements.checkoutButton);
        }
    }

    public void addtoCheckout() {
        waitForLoadingComplete();
        pageElements.firstitemfromrecentsearch.click();
        pageElements.firstitemfromPLP.click();
        if (isElementDisplayed(pageElements.Addtocartab)) {
            pageElements.Addtocartab.click();

        }
        new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.myCart);
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            waitForLoadingComplete();
            gg_myCartPage.clickOnCloseButtonOnMyCartScreen();
            waitForLoadingComplete();
            new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.myCart);
        }
        if (!cartPageElements.checkoutButton.isEnabled()) {
            gg_myCartPage.clickOnCloseButtonOnMyCartScreen();
            add2cart();
        }

    }


    public void editPickUpPage() {
        waitForLoadingComplete();
        pageElements.PickupAtEdit.click();
    }

    public void changeItemNewQuantity(String quantity) throws InterruptedException {


        waitForLoadingComplete();
        waitForLoadingComplete();
        Thread.sleep(2000);
        pageElements.firstitemfromrecentsearch.click();
        Thread.sleep(2000);
        pageElements.firstitemfromPLP.click();
        Thread.sleep(300);
        if (isElementDisplayed(pageElements.Addtocartab)) {
            pageElements.Addtocartab.click();
        }

        //new CommonActions(driver).new ClickAction().clickElement(cartPageElements.firstCartItem);
        new CommonActions(driver).new ClickAction().clickElement(myCartPageElements.myCart);
        new CommonActions(driver).new ClickAction().clickElement(cartPageElements.firstCartItem);
        for (int i = 0; i < Integer.parseInt(quantity); i++) {
            Thread.sleep(3000);
            for (MobileElement element : cartPageElements.quantityFieldList) {
                //if (isElementDisplayed(element)) {
                //clickElement(element);
                element.click();
                waitForLoadingComplete();
                Thread.sleep(5000);
            }
        }

        waitForLoadingComplete();

        new CommonActions(driver).new ClickAction().clickElement(cartPageElements.shoppingCartButton);

        waitForLoadingComplete();
        Thread.sleep(5000);
    }


}

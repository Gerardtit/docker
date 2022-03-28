package com.automation.pages;


import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_FoodLotPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class GG_FoodLot_PaymentPage extends BasePage {
    AppiumDevice device = AppiumDeviceManager.getDevice();
    private final GG_FoodLotPageElements foodLotPageElements = new GG_FoodLotPageElements();

    public GG_FoodLot_PaymentPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), foodLotPageElements);
    }

    public void verifyPaymentPage() {
        Assert.assertTrue(isElementDisplayed(foodLotPageElements.paymentScreen, 15), "Payment screen is not displayed");
    }

    public void enterCreditCardNo(String creditCardNo) {
        enterValue(foodLotPageElements.creditCardNo, creditCardNo);
    }

    public void enterCreditCadExpiryDate(String expiryDate) {
        enterValue(foodLotPageElements.creditCardExpiryDate, expiryDate);
    }

    public void enterPostalCode(String postalCode) {
        scrollDownForElement(foodLotPageElements.billingPostalCode);
        enterValue(foodLotPageElements.billingPostalCode, postalCode);
    }

    public void enterCustPhoneNo() {
        enterValue(foodLotPageElements.custPhone, "8278328777");
    }

    public void enterCardCVC(String cVC) {
        enterValue(foodLotPageElements.creditCardCVC, cVC);
    }

    public void enterCardName(String cardName) {
        enterValue(foodLotPageElements.billingName, cardName);
    }

    public void clickPayButton() {
        scrollDownForElement(foodLotPageElements.payButton);
        new CommonActions(driver).new ClickAction().clickElement(foodLotPageElements.payButton);
    }


    public void clickCheckoutCTA() {
        new CommonActions(driver).new ClickAction().clickElement(foodLotPageElements.checkoutCTA);
    }
}

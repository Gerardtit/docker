package com.automation.pages;


import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_FoodLotPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class GG_FoodLot_CustInfoScreenPage extends BasePage {
    AppiumDevice device = AppiumDeviceManager.getDevice();
    private final GG_FoodLotPageElements foodLotPageElements = new GG_FoodLotPageElements();

    public GG_FoodLot_CustInfoScreenPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), foodLotPageElements);
    }

    public void verifyCustInfoScreen() {
        Assert.assertTrue(isElementDisplayed(foodLotPageElements.custInfoScreen, 15), "Customer details info screen is not displayed");
    }

    public void verifyEmail() {
        Assert.assertTrue(foodLotPageElements.custEmail.getText() != "", "Email is not displayed on customer info screen");
    }

    public void verifyFirstName() {
        Assert.assertTrue(foodLotPageElements.custFirstName.getText() != "", "First name is not displayed on customer info screen");
    }

    public void verifyLastName() {
        Assert.assertTrue(foodLotPageElements.custLastName.getText() != "", "Last name is not displayed on customer info screen");
    }

    public void enterCustPhoneNo() {
        enterValue(foodLotPageElements.custPhone, "8278328777");
        hideKeyBoard();
    }

    public void clickCheckoutCTA() {
        new CommonActions(driver).new ClickAction().clickElement(foodLotPageElements.checkoutCTA);
    }

    public void clickBFTTermsAndConditionsCheckbox() {
        new CommonActions(driver).new ClickAction().clickElement(foodLotPageElements.termsAndConditionsCheckbox);
    }
}

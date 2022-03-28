package com.automation.pages;


import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_FoodLotPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class GG_FoodLot_CustDetailsDrawerPage extends BasePage {
    AppiumDevice device = AppiumDeviceManager.getDevice();
    private final GG_FoodLotPageElements foodLotPageElements = new GG_FoodLotPageElements();

    public GG_FoodLot_CustDetailsDrawerPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), foodLotPageElements);
    }

    public void verifyCustDetailDrawerScreen() throws InterruptedException {
        Assert.assertTrue(isElementDisplayed(foodLotPageElements.custDetailDrawer, 15), "FoodLot Customer details drawer screen is not displayed");
    }

    public void verifyFoodLotLogo() {
        Assert.assertTrue(foodLotPageElements.foodLotLogo.isDisplayed(), "FoodLot logo on customer drawer screen is not displayed");
    }

    public void verifyCustDetailHeader() {
        Assert.assertTrue(foodLotPageElements.custDetailHeader.isDisplayed(), "Header is not displayed on FoodLot Customer details screen");
    }

    public void verifyFirstNameLastNameField() {
        Assert.assertTrue(foodLotPageElements.firstName.isDisplayed(), "First Name field is not displayed on FoodLot Customer details screen");
        Assert.assertTrue(foodLotPageElements.lastName.isDisplayed(), "Last Name field is not displayed on FoodLot Customer details screen");
    }

    public void enterFirstName(String firstName) {
        enterKey(foodLotPageElements.firstName, firstName);
    }

    public void enterLastName(String lastName) {
        enterKey(foodLotPageElements.lastName, lastName);
    }

    public void isEmailFieldAutoFilled() {
        Assert.assertTrue(foodLotPageElements.emailField.getText() != "", "Email field is not auto filled on FoodLot Customer details screen");
    }

    public void verifyEmailFieldNonEditable() {
        Assert.assertFalse(foodLotPageElements.emailField.isEnabled(), "Email field is editable on FoodLot Customer details screen");
    }

    public void isConfirmCTAButtonEnabled() {
        Assert.assertTrue(foodLotPageElements.confirmCTAButton.isEnabled(), "Confirm CTA Button is not enabled");
    }

    public void clickConfirmCTAButton() {
        new CommonActions(driver).new ClickAction().clickElement(foodLotPageElements.confirmCTAButton);
    }
}

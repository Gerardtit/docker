package com.automation.pages;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_AccountProfilePageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GG_MyAccountPage extends BasePage {
    private final GG_AccountProfilePageElements myAccountPageElementsPage = new GG_AccountProfilePageElements();
    private final AppiumDevice device = AppiumDeviceManager.getDevice();
    private String updated_User_Id = " ";
    private String updatedPhone = " ";


    public GG_MyAccountPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), myAccountPageElementsPage);

    }


    public void clickOnUserProfile() {
        myAccountPageElementsPage.accountIconOnHome.click();
    }

    public void verifyAccountOtion() {
        waitVar.until(ExpectedConditions.visibilityOf(myAccountPageElementsPage.accountButton));


    }

    public void clickAccountOtion() {
        myAccountPageElementsPage.accountButton.click();
    }

    public void verifyMyAccount() {
        Dimension dimension = driver.manage().window().getSize();
        for (int i = 0; i < 2; i++)
            scroll(dimension.getWidth() - 100, dimension.getHeight() - 100, dimension.getWidth() - 100, 100);
        waitVar.until(ExpectedConditions.visibilityOf(myAccountPageElementsPage.welcomeTitle));

    }

    public void verifyEmailIdInMyAccount(String emailID) {
        new CommonActions(driver).new ClickAction().clickElement(myAccountPageElementsPage.welcomeTitle);
        waitVar.until(ExpectedConditions.visibilityOf(myAccountPageElementsPage.emailValue));
        System.out.println("Email id from screen :" + myAccountPageElementsPage.emailValue.getText());
        Assert.assertTrue(myAccountPageElementsPage.emailValue.getText().equalsIgnoreCase(emailID), " Email Id mismatch");

    }

    public void verifyPasswordInMyAccount() {
        try {
            waitVar.until(ExpectedConditions.visibilityOf(myAccountPageElementsPage.password));
            Assert.assertTrue(false, "password field is present on screen");

        } catch (Exception e) {

        }
    }

    public void updateNewEmail() throws InterruptedException {

        String uniqueString = "";
        uniqueString = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "@mailinator.com";
        updated_User_Id = "UMA_" + uniqueString;
        myAccountPageElementsPage.welcomeTitle.click();
//        myAccountPageElementsPage.emailField.clear();
        myAccountPageElementsPage.emailSection.click();
        deleteCurrentTextInEditText(myAccountPageElementsPage.emailField);
        enterValue(myAccountPageElementsPage.emailField, updated_User_Id);
        deleteCurrentTextInEditText(myAccountPageElementsPage.confirmEmailField);
        enterValue(myAccountPageElementsPage.confirmEmailField, updated_User_Id);
        if (getPlatformName().equalsIgnoreCase("ios")) {
            myAccountPageElementsPage.doneButton.click();
        } else {
            scrollUp();
        }
        myAccountPageElementsPage.saveButton.click();
        Thread.sleep(5000);
        waitVar.until(ExpectedConditions.visibilityOf(myAccountPageElementsPage.emailValue));
//        Thread.sleep(2000);
        Assert.assertTrue(myAccountPageElementsPage.emailValue.getText().equalsIgnoreCase(updated_User_Id), " Email Id mismatch");
    }

    public void updatePhoneNumber() {

        Random rand = new Random();
        int pickedNumber = rand.nextInt(7000000) + 2000000;
        updatedPhone = "299" + pickedNumber;
        myAccountPageElementsPage.phoneNumberField.clear();
        enterValue(myAccountPageElementsPage.phoneNumberField, updatedPhone);
        enterValue(myAccountPageElementsPage.confirmPhoneNumber, updatedPhone);
        if (getPlatformName().equalsIgnoreCase("ios"))
            myAccountPageElementsPage.doneButton.click();
        myAccountPageElementsPage.saveButton.click();
        Assert.assertTrue(myAccountPageElementsPage.phoneNumberValue.getText().equalsIgnoreCase(updatedPhone), " Email Id mismatch");

    }

    public void updateContactNumber() {

        Random rand = new Random();
        int pickedNumber = rand.nextInt(7000000) + 2000000;
        updatedPhone = "299" + pickedNumber;
        myAccountPageElementsPage.contactNumberField.clear();
        enterValue(myAccountPageElementsPage.contactNumberField, updatedPhone);
        if (getPlatformName().equalsIgnoreCase("ios"))
            myAccountPageElementsPage.doneButton.click();
        myAccountPageElementsPage.saveButton.click();
        Assert.assertTrue(myAccountPageElementsPage.contactNumberValue.getText().equalsIgnoreCase(updatedPhone), " Email Id mismatch");

    }

    public void clickPhoneNumber() {
        scrollDown();
        myAccountPageElementsPage.phoneNumber.click();
    }

    public void clickContactNumber() {
        scrollDown();
        myAccountPageElementsPage.contactNumber.click();
    }


}

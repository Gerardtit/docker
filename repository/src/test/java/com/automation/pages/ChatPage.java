package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.ChatPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ChatPage extends BasePage {
    public ChatPageElements chatPageElements = new ChatPageElements();
    Boolean text;

    public ChatPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), chatPageElements);
    }

    public boolean waitForLinkDisplayed(String link) {

        switch (link) {

            case "I need help with Sign In":
                new WaitAction(driver).waitForDisplayed(chatPageElements.needHelpWithSignIn);
                text = chatPageElements.needHelpWithSignIn.getText().equalsIgnoreCase(link);
                break;
            case "Where is my order?":
                new WaitAction(driver).waitForDisplayed(chatPageElements.whereIsMyOrder);

                text = chatPageElements.whereIsMyOrder.getText().equalsIgnoreCase(link);
                break;
            case "Edit my order":
                if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                    new WaitAction(driver).waitForDisplayed(chatPageElements.editMyOrder);
                    text = chatPageElements.editMyOrder.getText().equalsIgnoreCase(link);
                } else {
                    scrollUpForElement(chatPageElements.editMyOrder);
//                    new WaitAction(driver).waitForDisplayed(chatPageElements.editMyOrder);
                    text = chatPageElements.editMyOrder.getText().equalsIgnoreCase(link);
                }
                break;
            case "Loyalty Program Info":
                if (driver.getPlatformName().equalsIgnoreCase("ios")) {

                    new WaitAction(driver).waitForDisplayed(chatPageElements.loyaltyProgramInfo);

                    text = chatPageElements.loyaltyProgramInfo.getText().equalsIgnoreCase(link);
                } else {
                    scrollUpForElement(chatPageElements.loyaltyProgramInfo);
//                    new WaitAction(driver).waitForDisplayed(chatPageElements.loyaltyProgramInfo);
                    text = chatPageElements.loyaltyProgramInfo.getText().equalsIgnoreCase(link);
                }
                break;
            case "I have a problem with my order":
                if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                    new WaitAction(driver).waitForDisplayed(chatPageElements.problemWithOrder);
                    text = chatPageElements.problemWithOrder.getText().equalsIgnoreCase(link);
                } else {
                    scrollUpForElement(chatPageElements.problemWithOrder);
//                    new WaitAction(driver).waitForDisplayed(chatPageElements.problemWithOrder);
                    text = chatPageElements.problemWithOrder.getText().equalsIgnoreCase(link);
                }
                break;
            case "Pickup and Delivery options":
                if (driver.getPlatformName().equalsIgnoreCase("ios")) {

                    new WaitAction(driver).waitForDisplayed(chatPageElements.pickUpDeliveryOptions);
                    text = chatPageElements.pickUpDeliveryOptions.getText().equalsIgnoreCase(link);
                } else {
                    scrollUpForElement(chatPageElements.pickUpDeliveryOptions);
//                    new WaitAction(driver).waitForDisplayed(chatPageElements.pickUpDeliveryOptions);

                    text = chatPageElements.pickUpDeliveryOptions.getText().equalsIgnoreCase(link);
                }
                break;
            default:
        }
        return text;
    }

    public void clickChatLink(String link) {
        switch (link) {

            case "I need help with Sign In":
                new CommonActions(driver).new ClickAction().clickElement(chatPageElements.needHelpWithSignIn);
                break;
            case "Where is my order?":
                new CommonActions(driver).new ClickAction().clickElement(chatPageElements.whereIsMyOrder);
                break;
            case "Edit my order":
                new CommonActions(driver).new ClickAction().clickElement(chatPageElements.editMyOrder);
                break;

            case "Loyalty Program info":
                scrollUpForElement(chatPageElements.loyaltyProgramInfo);
                new CommonActions(driver).new ClickAction().clickElement(chatPageElements.loyaltyProgramInfo);
                break;
            case "I have a problem with my Order":
                scrollUpForElement(chatPageElements.problemWithOrder);
                new CommonActions(driver).new ClickAction().clickElement(chatPageElements.problemWithOrder);
                break;
            case "Pickup and Delivery options":
                scrollUpForElement(chatPageElements.pickUpDeliveryOptions);
                new CommonActions(driver).new ClickAction().clickElement(chatPageElements.pickUpDeliveryOptions);
                break;
            default:
        }

    }

    public void verifyChatOptions(String link) {
        switch (link) {
            case "I need help with Sign In":
                Assert.assertTrue(chatPageElements.signInHelpResolutionText.isDisplayed());
                Assert.assertTrue(chatPageElements.resetPassword.isDisplayed());
                Assert.assertTrue(chatPageElements.loginToAccount.isDisplayed());
                Assert.assertTrue(chatPageElements.accountLocked.isDisplayed());
                Assert.assertTrue(chatPageElements.other.isDisplayed());
                break;
            case "Where is my order?":
                Assert.assertTrue(chatPageElements.noPendingOrdersText.isDisplayed());
                break;
            case "Edit my order":
                Assert.assertTrue(chatPageElements.noPendingOrderToEdit.isDisplayed());
                break;
            case "Loyalty Program Info":
                Assert.assertTrue(chatPageElements.loyaltyProgramText.isDisplayed());
                Assert.assertTrue(chatPageElements.justForULoyaltyProgram.isDisplayed());
                Assert.assertTrue(chatPageElements.gasRewardsLoyaltyProgram.isDisplayed());
                Assert.assertTrue(chatPageElements.groceryRewardsLoyaltyProgram.isDisplayed());
                break;
            case "I have a problem with my Order":
                Assert.assertTrue(chatPageElements.problemWithOrderText.isDisplayed());
                Assert.assertTrue(chatPageElements.orderStatus.isDisplayed());
                Assert.assertTrue(chatPageElements.productIssue.isDisplayed());
                Assert.assertTrue(chatPageElements.charges.isDisplayed());
                Assert.assertTrue(chatPageElements.promoCode.isDisplayed());
                Assert.assertTrue(chatPageElements.digitalOfferCoupon.isDisplayed());
                Assert.assertTrue(chatPageElements.deliveryPickupAddress.isDisplayed());
                Assert.assertTrue(chatPageElements.editCancelOrder.isDisplayed());
                Assert.assertTrue(chatPageElements.orderNotDelivered.isDisplayed());
                break;
            case "Pickup and Delivery Options":
                Assert.assertTrue(chatPageElements.pickupDeliveryOptionsText.isDisplayed());
                Assert.assertTrue(chatPageElements.delivery.isDisplayed());
                Assert.assertTrue(chatPageElements.sameOrNextDayDelivery.isDisplayed());
                Assert.assertTrue(chatPageElements.dUG.isDisplayed());
                Assert.assertTrue(chatPageElements.dUGText.isDisplayed());
                Assert.assertTrue(chatPageElements.rushDelivery.isDisplayed());
                Assert.assertTrue(chatPageElements.rushDeliveryText.isDisplayed());
                Assert.assertTrue(chatPageElements.uDC.isDisplayed());
                Assert.assertTrue(chatPageElements.uDCText.isDisplayed());
                Assert.assertTrue(chatPageElements.additionalDetails.isDisplayed());
                Assert.assertTrue(chatPageElements.onlineShoppingFAQs.isDisplayed());
                break;
            default:
        }

    }

}

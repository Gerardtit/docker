package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.OrderPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class OrderPage extends BasePage {
    public OrderPageElements pageElements = new OrderPageElements();

    public OrderPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
    }

    public void waitForPageDisplayed() {
        new WaitAction(driver).waitForDisplayed(pageElements.orderTitle);
    }

    public void clickCancelOrder() {
        new WaitAction(driver).waitForClickableAndClick(pageElements.cancelOrderButton);
    }

    public void waitForCancelOrderPopUp() {
        new WaitAction(driver).waitForDisplayed(pageElements.cancelOrderAlertWindow);
    }

    public void clickCancelOrderConfirmation() {

        if (platformName.equalsIgnoreCase("android")) {

            new CommonActions(driver).new ClickAction().clickElement(pageElements.cancelOrderConfirmButton);
        } else {
            Dimension d = driver.manage().window().getSize();
            int y = d.getHeight();
            int x = d.getWidth();
            tapCoordinate(x / 2, y / 2);
        }

    }

    public boolean verifyNoPendingOrderDisplayed() throws InterruptedException {
        Thread.sleep(5000);
        return pageElements.orderNumberList.size() == 0;

    }

    public void scrollDownToOrderHistory() {

        scrollDownForElement(pageElements.orderHistoryText);
    }

    public void waitForNeedHelpText() {
        new WaitAction(driver).waitForDisplayed(pageElements.needHelpText);
    }


    public void waitForPastOrderText() {
        new WaitAction(driver).waitForDisplayed(pageElements.pastOrderText);
    }

    public void waitForCurrentOrderText() {
        new WaitAction(driver).waitForDisplayed(pageElements.currentOrderText);
    }

    public void clickBackButtonToMenuPage() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.backButtonToMenu);
    }

    public void waitForPastOrderList() {
        new WaitAction(driver).waitForDisplayed(pageElements.pastOrder);
    }

    public void clickEditOrder() {
        pageElements.editOrder.click();
    }


    public boolean isMapDisplayed() {
        return isElementDisplayed(pageElements.map);
    }

    public void waitForOrderNumberDisplayed() {
        // waitForDisplayed(pageElements.orderNumber);
        waitForDisplayed(pageElements.orderNumber, 5);
    }

    public void waitForOrderHitstoryPageDisplayed() {
        waitForDisplayed(pageElements.orderHistoryTitle, 5);
        waitForLoadingComplete();
    }

    public void clickBackButtonOnEditOrderPage() {
        waitForDisplayed(pageElements.backButtonOnEditOrdersPage, 20);
        pageElements.backButtonOnEditOrdersPage.click();
        if (driver.getPlatformName().equalsIgnoreCase("android")) {

        }
    }

    public void clickContactInfoTileOnEditOrderPage() {
        waitForDisplayed(pageElements.contactInfoTitle, 20);
        pageElements.contactInfoTitle.click();
    }

    public void clickBackButtonOnEditCartPage() {
        pageElements.backarrowatEditCartPage.click();
    }

    public void verifyCancelChangesPopup() {
        waitForLoaderToDisappear();
        pageElements.cancelChangesHeaderPopup.isDisplayed();
        pageElements.discardChangesButtonPopup.isDisplayed();
        pageElements.keepEditingButtonPopup.isDisplayed();
//        waitForDisplayed(pageElements.cancelChangesHeaderPopup, 20);
//        waitForDisplayed( pageElements.discardChangesButtonPopup, 20);
//        waitForDisplayed(pageElements.keepEditingButtonPopup, 20);
    }

    public void editAndEnterPhoneNumberInContactInfoPage(String phoneNumber) {
        if (isElementDisplayed(pageElements.enterPhoneNumber)) {
            waitForDisplayed(pageElements.enterPhoneNumber);
            pageElements.enterPhoneNumber.clear();
            enterKey(pageElements.enterPhoneNumber, phoneNumber);
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                pageElements.saveChangesInEditContactInfo.click();
            } else {
                enterValue(pageElements.enterPhoneNumber, phoneNumber);
            }

        }
    }

    public void addPromoCodeAndApplyInEditOrderPage(String promoCode) {
        waitForLoaderToDisappear();
        scrollDownForElementOnEditPage(pageElements.estimatedTotalInEditYourOrderPage);
        waitForLoaderToDisappear();
        pageElements.enterPromoCodeTextBox.click();
        pageElements.enterPromoCodeTextBox.clear();
        enterKey(pageElements.enterPromoCodeTextBox, promoCode);
        waitForLoaderToDisappear();
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            pageElements.applypromoButton.click();
        }
        waitForLoaderToDisappear();
    }

    public void clickOnDiscardChangesButton() {
        pageElements.discardChangesButtonPopup.click();
    }

    public boolean scrollDownForElementOnEditPage(WebElement element) {
        for (int i = 0; i < 1; i++) {
            try {
                if (element.isDisplayed()) {
                    return true;
                }
            } catch (Exception e) {
            }
            scrollDown();
        }
        return false;
    }

    public void clickOnViewDetialsOrTrackOrder() {
        waitForLoaderToDisappear();
        waitForClickableAndClick(pageElements.viewDetialsOrTrackOrder);
        waitForLoadingComplete();
    }

    public void clickOnEditOrderInYourOrderDetailsPage() {
        waitForLoaderToDisappear();
        waitForClickableAndClick(pageElements.EditOrderInYourOrderDetailsPage);
        waitForLoadingComplete();

    }

    public void clickOnSaveChangesInEditYourOrderPage() {
        waitForLoaderToDisappear();
        waitForClickableAndClick(pageElements.SaveChangesInEditYourOrderPage);
        waitForLoadingComplete();
    }

    public void clickOnEditOrderInOrderConfirmationPage() {
        waitForLoaderToDisappear();
        waitForClickableAndClick(pageElements.EditOrderInOrderConfirmationPage);
        waitForLoadingComplete();
    }

    public void clickOnContinueShoppingInOrderConfirmationPage() {
        waitForLoaderToDisappear();
        waitForClickableAndClick(pageElements.ContinueShoppingInOrderConfirmationPage);
        waitForLoadingComplete();
    }

    public void displaySearchProductsOrDeals() {
        pageElements.SearchProductsOrDealsOnHomePage.isDisplayed();
        waitForLoadingComplete();
    }


    public void waitForOrderDetailsPageDisplayed() {
        waitForDisplayed(pageElements.yourOrderDetailsPageTitle, 5);
        waitForLoadingComplete();
    }

    public void clickOnViewDetailsOrTrackOrderSection_DUG() {
        waitForLoaderToDisappear();
        waitForClickableAndClick(pageElements.viewDetialsOrTrackOrderSection);
        waitForLoadingComplete();
    }

    public void orderHistoryPageStatusBarDetails() {
        waitForDisplayed(pageElements.orderHistoryTitle, 5);
        Assert.assertTrue(pageElements.orderInProgressStatus.isDisplayed());
        Assert.assertTrue(pageElements.orderCreatedStatusBar.isEnabled());
        Assert.assertTrue(pageElements.deliveryConfirmedTxt.isDisplayed());
        waitForLoadingComplete();
    }


    public void clickOnViewDetailsOrTrackOrderSection_Delivery() {
        waitForLoaderToDisappear();
        scrollDown(2);
        waitForClickableAndClick(pageElements.viewDetialsOrTrackOrderSection);
        waitForLoadingComplete();

    }
}

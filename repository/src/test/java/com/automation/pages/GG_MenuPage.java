package com.automation.pages;


import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.CheckoutPageElements;
import com.automation.pageElements.GG_AccountProfilePageElements;
import com.automation.pageElements.GG_MenuPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GG_MenuPage extends BasePage {
    private final GG_MenuPageElements gg_menuPageElements = new GG_MenuPageElements();
    private final GG_AccountProfilePageElements accountProfilePageElements = new GG_AccountProfilePageElements();
    public CheckoutPageElements pageElements = new CheckoutPageElements();


    public GG_MenuPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_menuPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), accountProfilePageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
    }

    public boolean isMenuPageDisplayed() {
        return isElementDisplayed(gg_menuPageElements.signOutButton);
    }


    public void closeMenuPage() {
        if (driver.getPlatformName().equalsIgnoreCase("Android")) {
            new CommonActions(driver).new ClickAction().clickElement(gg_menuPageElements.closeIcon);


        } else {
            new CommonActions(driver).new ClickAction().clickElement(accountProfilePageElements.backButton);
        }
    }


    public void CancelOrderLink() {
        scrollDown(5);
        scrollDownForElement(gg_menuPageElements.Cancelorder);

        if (isElementDisplayed(gg_menuPageElements.Cancelorder)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_menuPageElements.Cancelorder);
        }
    }

    public void CancelOrderWindowPopup() {

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Assert.assertTrue(isElementDisplayed(gg_menuPageElements.ConfirmationCancelorder));
        } else {
            String CancelOrderWindow = gg_menuPageElements.ConfirmationCancelorder.getAttribute("text");
            Assert.assertTrue(CancelOrderWindow.contains("Please confirm that you would like to cancel this order"));
        }
    }

    public void ClickYesButtonCancelOrder() {
        new CommonActions(driver).new ClickAction().clickElement(gg_menuPageElements.ConfirmationYesButtonCancelorder);
    }

    public void ClickNoButtonCancelOrder() {
        new CommonActions(driver).new ClickAction().clickElement(gg_menuPageElements.NobutttonCancel);
    }

    public void CancelOrderWindowPopupisNotpresent() {
        Assert.assertFalse(isElementDisplayed(gg_menuPageElements.ConfirmationCancelorder));
    }

    public void OrderDetailsScreenCancelledOrder() throws InterruptedException {
        waitForLoadingComplete();

        Thread.sleep(50000);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if ((isElementDisplayed(gg_menuPageElements.OrderDetailsScreen))) {
                String status = gg_menuPageElements.OrderCancelledOrderDetailsScreen.getAttribute("name");
                Thread.sleep(50000);
                Assert.assertTrue(status.contains("Canceled."));
                //   Assert.assertTrue(gg_menuPageElements.OrderStatuscancel.isDisplayed());
            } else {
                String Ordetails = gg_menuPageElements.OrderDetailsScreen.getAttribute("text");
                Assert.assertTrue(Ordetails.equals("Your order details"));
                String status = gg_menuPageElements.OrderCancelledOrderDetailsScreen.getAttribute("text");
                // Assert.assertTrue(status.equals("Canceled."));
                System.out.println(true);
                Assert.assertTrue(gg_menuPageElements.OrderStatuscancel.isDisplayed());
                String ProgressBar = gg_menuPageElements.OrderStatuscancel.getAttribute("content-desc");
                Assert.assertTrue(ProgressBar.equals("Step one of four failed"));

            }
        }
    }

    public void clickBackButtonOrderHistoryPage() {
        new CommonActions(driver).new ClickAction().clickElement(gg_menuPageElements.BackButtonOrderHistory);
        waitForLoadingComplete();
    }

    public void OrderStatusCancelled() throws InterruptedException {
        waitForLoadingComplete();
        waitForLoadingComplete();
        Thread.sleep(5000);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if ((isElementDisplayed(gg_menuPageElements.YourOrderScreen))) {
                String status = gg_menuPageElements.OrderCancelledOrderDetailsScreen.getAttribute("name");
                Assert.assertTrue(status.equals("Canceled."));
                //  Assert.assertTrue(gg_menuPageElements.OrderStatuscancel.isDisplayed());
            } else {
                String YourOrder = gg_menuPageElements.YourOrderScreen.getAttribute("text");
                Assert.assertTrue(YourOrder.equals("Your Orders"));
                String status = gg_menuPageElements.OrderCancelledOrderDetailsScreen.getAttribute("text");
                //   Assert.assertTrue(status.equals("Canceled."));
                System.out.println(true);
                Assert.assertTrue(gg_menuPageElements.OrderStatuscancel.isDisplayed());
                String ProgressBar = gg_menuPageElements.OrderStatuscancel.getAttribute("content-desc");
                Assert.assertTrue(ProgressBar.equals("Step one of four failed"));

            }
        }
    }

    public void VerifyOrderHistoryPage() throws InterruptedException {

        scrollDown(3);
        Thread.sleep(1000);
        if (pageElements.ViewDetailsorTrackOrder.isEnabled()) {
            pageElements.ViewDetailsorTrackOrder.click();
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                String strOrderTitle = pageElements.Ordertitle.getAttribute("name");
                Assert.assertTrue(strOrderTitle.equals("Your order details"));
            } else {
                String strOrderTitle = pageElements.Ordertitle.getAttribute("text");
                Assert.assertTrue(strOrderTitle.equals("Your order details"));
            }
        }
    }
}




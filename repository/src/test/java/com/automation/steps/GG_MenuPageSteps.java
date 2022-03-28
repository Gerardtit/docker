package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_MenuPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class GG_MenuPageSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_MenuPage gg_menuPage = new GG_MenuPage(driver);

    @Then("^verify menu page is displayed$")
    public void verifyMenuPageDisplayed() {
        Assert.assertTrue(gg_menuPage.isMenuPageDisplayed());
    }

    @And("close menu page")
    public void closeMenuPage() {
        gg_menuPage.closeMenuPage();
    }

    @Then("^click on Cancel Order link$")
    public void click_on_cancel_order_link() throws Throwable {
        gg_menuPage.CancelOrderLink();

    }


    @Then("^Verify CancelOrder window appears$")
    public void verify_cancelorder_window_appears() throws Throwable {
        gg_menuPage.CancelOrderWindowPopup();

    }


    @And("^Click on Yes button on Cancel Order Window$")
    public void click_on_yes_button_on_cancel_order_window() throws Throwable {
        gg_menuPage.ClickYesButtonCancelOrder();
    }

    @Then("^Verify CancelOrder popups dismissed$")
    public void verify_cancelorder_popups_dismissed() throws Throwable {
        gg_menuPage.CancelOrderWindowPopupisNotpresent();
    }

    @Then("^Verify Status changed to Cancelled Order at Order Details Screen$")
    public void verify_status_changed_to_cancelled_order_at_order_details_screen() throws Throwable {
        gg_menuPage.OrderDetailsScreenCancelledOrder();

    }

    @And("^click on back button to go to order history page$")
    public void click_on_back_button_to_go_to_order_history_page() throws Throwable {
        gg_menuPage.clickBackButtonOrderHistoryPage();
    }


    @Then("^Verify order status is cancelled at order history page$")
    public void verify_order_status_is_cancelled_at_order_history_page() throws Throwable {
        gg_menuPage.OrderStatusCancelled();
    }

    @And("^User click on ViewDetailsorTrackOrder Order$")
    public void user_click_on_viewdetailsortrackorder_order() throws Throwable {
        gg_menuPage.VerifyOrderHistoryPage();
    }


    @And("^Click on No button on Cancel Order Window$")
    public void click_on_no_button_on_cancel_order_window() throws Throwable {
        gg_menuPage.ClickNoButtonCancelOrder();
    }

}

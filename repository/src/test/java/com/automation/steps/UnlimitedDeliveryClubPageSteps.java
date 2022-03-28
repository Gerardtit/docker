package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.UnlimitedDeliveryClubPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class UnlimitedDeliveryClubPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public AppiumDevice device = AppiumDeviceManager.getDevice();
    public UnlimitedDeliveryClubPage udcPage = new UnlimitedDeliveryClubPage(driver);

    @When("^user clicks Unlimited Delivery Club on menu page$")
    public void user_clicks_Unlimited_Delivery_Club_on_account_page() throws Throwable {
        udcPage.click_UDC();
    }

    @When("^user clicks Annual Plan on UDC window$")
    public void user_clicks_Annual_Plan_on_UDC_window() throws Throwable {
        udcPage.clickAnnualPlan();
    }

    @When("^user clicks Monthly Plan on UDC window$")
    public void user_clicks_Monthly_Plan_on_UDC_window() throws Throwable {
        udcPage.clickMonthlyPlan();
    }

    @When("^user clicks FAQ on UDC page$")
    public void uaer_clicks_FAQ_on_UDC_window() throws Throwable {
        udcPage.clickFAQ();
    }

    @When("^user clicks Terms and Conditions on UDC page$")
    public void user_clicks_Terms_and_Conditions_on_UDC_window() throws Throwable {
        udcPage.clickTermsAndConditions();
    }

    @Then("^\"([^\"]*)\" page is displayed$")
    public void page_is_displayed(String title) throws Throwable {
        Thread.sleep(3000);
        udcPage.waitForPageDisplayed(title);
    }

    @Then("^user press back button$")
    public void user_press_back_button() throws Throwable {
        Thread.sleep(3000);
        udcPage.navigateBack();
    }

    @When("^user clicks Payment on \"([^\"]*)\" page$")
    public void user_clicks_Payment_on_page(String arg1) throws Throwable {
        udcPage.clickOnPayment();
    }

    @Then("^user enters name as \"([^\"]*)\" appears on card$")
    public void user_enters_Name_as_appears_on_card(String name) throws Throwable {
        udcPage.enter_CardName(name);
    }

    @Then("^user enters card number as \"([^\"]*)\" appears on card$")
    public void user_enters_Card_Number_as_appears_on_card(String CardNumber) throws Throwable {
        udcPage.enter_CardNumber(CardNumber);

    }

    @Then("^user enters month and year as \"([^\"]*)\" appears on card$")
    public void user_enters_Expiration_month_and_year_as_appears_on_card(String MonthAndYear) throws Throwable {
        udcPage.enter_MonthYear(MonthAndYear);
    }

    @Then("^user enters \"([^\"]*)\" as Billing Zipcode$")
    public void user_enters_zipcode_on_Billing_Zipcode_field(String zipcode) throws Throwable {
        udcPage.enter_BillingZipcode(zipcode);

    }

    @When("^user clicks continue button on Payment Page$")
    public void user_clicks_continue_button_on_Payment_Page() throws Throwable {
        udcPage.clickContinue();
    }

    @When("^user enters CVV as \"([^\"]*)\" appears on card$")
    public void user_enters_CVV_number_as_appears_on_card(String number) throws Throwable {
        Thread.sleep(3000);
//        driver.navigate().refresh();
        udcPage.enter_CVVnumber(number);
        udcPage.confirmCVV();
    }

    @When("^user clicks agree checkbox$")
    public void user_clicks_agree_checkbox() throws Throwable {
        udcPage.clickAgree();
    }

    @When("^user clicks Start Subscription button$")
    public void user_clicks_Start_subscription_button() throws Throwable {
        udcPage.clickSave();
    }

    @Then("^Confirmation page displayed with All Set message$")
    public void Confirmation_page_displayed_with_All_Set_message() throws Throwable {
        udcPage.isConfirmationPageDisplayed();
    }

    @Then("^verify Current Subscription Plan and Current Payment Method is displayed$")
    public void verify_Current_Subscription_Plan_and_Current_Payment_Method_is_displayed() throws Throwable {
        udcPage.isCurrentSubscriptionDisplayed();
        udcPage.isCurrentPaymentDisplayed();
    }

    @When("^user clicks Change button on Current Subscription Plan$")
    public void user_clicks_Change_button_on_Current_Subscription_Plan() throws Throwable {
        udcPage.clickChangePlan();
    }

    @Then("^verify Switch to Monthly Plan is displayed on the page$")
    public void verify_Switch_to_Monthly_Plan_is_displayed_on_the_page() throws Throwable {
        udcPage.isSwitchToMonthlyPlanDisplayed();
    }

    @Then("^verify Switch to Annual Plan is displayed on the page$")
    public void verify_Switch_to_Annual_Plan_is_displayed_on_the_page() throws Throwable {
        udcPage.isSwitchToAnnualPlanDisplayed();
    }


    @When("^user clicks update button on Current Payment Method$")
    public void user_clicks_update_button_on_Current_Payment_Method() throws Throwable {
        udcPage.clickUpdatePayment();
    }

    @Then("^verify Update Payment is displayed on the page$")
    public void verify_Update_Payment_is_displayed_on_the_page() throws Throwable {
        udcPage.isUpdatePaymentDisplayed();
    }

    @When("^user clicks on Cancel Subscription$")
    public void user_clicks_on_Cancel_Subscription() throws Throwable {
        udcPage.cancelSubscription();
    }

    @Then("^user click on the first option$")
    public void user_click_on_the_first_option() throws Throwable {
        udcPage.clickFirstCancelReason();
    }

    @When("^user clicks confirm cancellation$")
    public void user_clicks_confirm_cancellation() throws Throwable {
        udcPage.clickConfirmCancel();
    }

    @Then("^Subscription Plan Details window is displayed$")
    public void subscription_Plan_Details_window_is_displayed() throws Throwable {
        udcPage.isSubscriptionPlanDisplayed();
    }

    @When("^user press the close button on Confirmation Page$")
    public void user_press_the_close_button_on_Confirmation_Page() throws Throwable {
        udcPage.clickClose();
    }

}

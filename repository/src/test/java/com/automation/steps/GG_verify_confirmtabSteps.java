package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_verify_confirmFreshPAssPage;
import com.automation.pages.PaymentPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class GG_verify_confirmtabSteps {
    AppiumDevice device = AppiumDeviceManager.getDevice();
    AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_verify_confirmFreshPAssPage monthlyFreshPAss = new GG_verify_confirmFreshPAssPage(driver);
    PaymentPage paymentPage = new PaymentPage(driver);

    @Then("^validate selected tab on freshpassPage$")
    public void validateSelectedTabOnFreshpassPage() {
        monthlyFreshPAss.selectedTab();

    }

    @Then("^Startsubscription tab is enabled$")
    public void startsubscriptionTabIsEnabled() {
        monthlyFreshPAss.subscriptiontabEnabled();
    }

    @Then("^addPayment is selected$")
    public void addpaymentIsSelected() {
        monthlyFreshPAss.addpayment();
    }


    @And("^user clicks continue tab$")
    public void userClicksContinueTab() {

        monthlyFreshPAss.continuetab();
    }

    @Then("^user clicks on selects tab$")
    public void userClicksOnSelects() {
        monthlyFreshPAss.selectTabSelected();
    }

    @Then("^payment details are entered$")
    public void paymentDetailsAreEntered(String name, String cardNumber, String monthYear, String zipcode) {
        monthlyFreshPAss.paymentNamedetails("Name_MonthlyFreshPass");
        monthlyFreshPAss.paymentCarddetails("cardnumber_MonthlyFreshPass");
        monthlyFreshPAss.paymentYeardetails("monthYear_MonthlyFreshPass");
        monthlyFreshPAss.paymentZipdetails("zipcode_MonthlyFreshPass");
        monthlyFreshPAss.submitSelected();
    }

    @When("^CVV number is refreshed with choose date$")
    public void DetailsCompletedNPlaceOrder_Enabled() {
        monthlyFreshPAss.cvvnumber();
    }

    @Then("^cvv details are entered$")
    public void cvvDetailsAreEntered(String arg0) throws Exception {
        paymentPage.waitForCvvWindowDisplayed();
        paymentPage.enterCvvInfo(arg0);
    }

    @And("^Iagree box is selected$")
    public void iagreeBoxIsSelected() {
        monthlyFreshPAss.checkBoxSelected();
    }

    @Then("^Validate confirm tab is enabled$")
    public void validateConfirmTabIsEnabled() {
        monthlyFreshPAss.confirmTabEnabled();
    }

    @Then("^validate Both plans are displayed$")
    public void validateBothPlansAreDisplayed() {
        monthlyFreshPAss.twoplansdisplay();
    }
}


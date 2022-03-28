package com.automation.pages;


import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_Verify_FreshpassElements;
import com.automation.pageElements.PaymentPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GG_verify_confirmFreshPAssPage extends BasePage {
    public GG_Verify_FreshpassElements freshpassElements = new GG_Verify_FreshpassElements();
    public PaymentPageElements paymentElements = new PaymentPageElements();

    public GG_verify_confirmFreshPAssPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), freshpassElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), paymentElements);


    }

    public void selectedTab() {
        freshpassElements.Selectedtab.isDisplayed();
    }

    public void subscriptiontabEnabled() {

        freshpassElements.subscribetab.isEnabled();

    }

    public void continuetab() {
        scrollDownForElement(freshpassElements.submitPayment);
        new WaitAction(driver).waitForLoadingComplete();
        new WaitAction(driver).waitForDisplayed(freshpassElements.submitPayment);
        freshpassElements.submitPayment.isEnabled();
        freshpassElements.submitPayment.click();

    }


    public void cvvnumber() {
        waitForDisplayed(freshpassElements.confirmCVV);

        freshpassElements.confirmCVV.click();
    }

    public void submitSelected() {
        freshpassElements.submitPayment.isEnabled();
        freshpassElements.submitPayment.click();
    }

    public void selectTabSelected() {
        freshpassElements.Selecttab.click();
    }

    public void EnterCVV() {
        freshpassElements.cvvEditText.click();
    }


    public void addpayment() {
        waitForLoadingComplete();
        freshpassElements.AddnewCard.click();
    }

    public void paymentNamedetails(String name) {

        enterKey(freshpassElements.namePayment, name);

    }


    public void paymentCarddetails(String cardNumber) {


        enterKey(freshpassElements.cardNoPayment, cardNumber);

    }

    public void paymentYeardetails(String monthYear) {


        enterKey(freshpassElements.ExpirePayment, monthYear);

    }

    public void paymentZipdetails(String zipcode) {

        enterKey(freshpassElements.zipcodePayment, zipcode);
    }

    public void checkBoxSelected() {
        scrollDownForElement(freshpassElements.IAgree);
        freshpassElements.IAgree.click();

    }

    public void confirmTabEnabled() {
        scrollDownForElement(freshpassElements.Confirmtab);
        freshpassElements.Confirmtab.isEnabled();
    }


    public void twoplansdisplay() {
        freshpassElements.AnnualselectPlan.isDisplayed();
        scrollDownForElement(freshpassElements.MonthlyselectPlan);
        waitForDisplayed(freshpassElements.MonthlyselectPlan);
        freshpassElements.MonthlyselectPlan.isDisplayed();

    }
}

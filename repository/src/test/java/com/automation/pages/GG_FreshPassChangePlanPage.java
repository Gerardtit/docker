package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_FreshPass_ChangePlanElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GG_FreshPassChangePlanPage extends BasePage {
    public GG_FreshPass_ChangePlanElements changePassElements = new GG_FreshPass_ChangePlanElements();

    public GG_FreshPassChangePlanPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), changePassElements);
    }

    public void monthlySelect() {

        scrollDownForElement(changePassElements.monthlySelectPlan);
        new CommonActions(driver).new ClickAction().clickElement(changePassElements.monthlySelectPlan);

    }


    public void frshpasstitle() {
        changePassElements.FreshPassAtTitle.isDisplayed();
        String title = changePassElements.FreshPassAtTitle.getText();
        Assert.assertEquals(title, "FreshPass");
    }

    public void plantitle() {
        changePassElements.AnnualPlan.isDisplayed();
        String title = changePassElements.AnnualPlan.getText();
        Assert.assertEquals(title, "Annual plan");
    }

    public void yrplan() {
        changePassElements.yrplan.isDisplayed();

    }


    public void paymentdisplay() {
        scrollDownForElement(changePassElements.Paymentmethod);
        changePassElements.Paymentmethod.isDisplayed();
        String title = changePassElements.Paymentmethod.getText();
        Assert.assertEquals(title, "Payment method");
    }

    public void cvvdisplay() {
        changePassElements.checkBox.isDisplayed();
        String title = changePassElements.ConfirmCVV.getText();
        Assert.assertEquals(title, "Confirm CVV");
    }


    public void iagreedisplay() {
        changePassElements.iagree.isDisplayed();
    }

    public void checkboxdisplay() {
        scrollDownForElement(changePassElements.checkBox);
        changePassElements.checkBox.isDisplayed();
    }

    public void faqtitle() {
        scrollDownForElement(changePassElements.TNCtab);
        String FaQtext = changePassElements.FAQtab.getText();
        Assert.assertEquals(FaQtext, "FAQ");
    }

    public void fAQpage() {
        String FaQtext = changePassElements.FAQtitle.getText();
        Assert.assertEquals(FaQtext, "FAQ");
    }

    public void TNC() {
        scrollDownForElement(changePassElements.TNCtab);
        String TNC = changePassElements.TNCtab.getText();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Assert.assertEquals(TNC, "Terms and Conditions");
        }
        Assert.assertEquals(TNC, "Terms and conditions");
    }

    public void TNCpage() {
        String TNC = changePassElements.TNCtitle.getText();
        Assert.assertEquals(TNC, "Terms and Conditions");
    }

    public void confirmtabenable() {
        changePassElements.Confirmtab.isEnabled();
    }

    public void confirmtabselected() {
        changePassElements.Confirmtab.click();
    }

}


package com.automation.pages;

import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_Cancellation_FreshpassElements;
import com.automation.pageElements.GG_FreshPassMemberTab_Elements;
import com.automation.pageElements.GG_Verify_FreshpassElements;
import com.automation.pageElements.GG_user_subscriptionElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GG_freshpass_user_subscriptionPage extends BasePage {
    public GG_Verify_FreshpassElements freshpassElements = new GG_Verify_FreshpassElements();
    public GG_Cancellation_FreshpassElements cancellation = new GG_Cancellation_FreshpassElements();
    public GG_user_subscriptionElements subscriptionElements = new GG_user_subscriptionElements();
    public GG_FreshPassMemberTab_Elements membertabelements = new GG_FreshPassMemberTab_Elements();

    public GG_freshpass_user_subscriptionPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), freshpassElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), cancellation);
        PageFactory.initElements(new AppiumFieldDecorator(driver), subscriptionElements);

    }

    public void textvalidation() {
        String FaQtext = freshpassElements.FAQtab.getText();
        Assert.assertEquals(FaQtext, "FAQ");
        String TNC = freshpassElements.TNCtab.getText();
        Assert.assertEquals(TNC, "Terms and Conditions");
    }

    public void confirmTabselected() {
        freshpassElements.Confirmtab.click();

    }

    public void confirmpage() {
        new WaitAction(driver).waitForLoadingComplete();
        cancellation.allSetText.isDisplayed();
    }

    public void currentplan() {
        subscriptionElements.currentplan.isDisplayed();
        String currnetplan = subscriptionElements.currentplan.getText();
        Assert.assertEquals(currnetplan, "Current plan");

    }

    public void curannualplan() {
        subscriptionElements.annualplan.isDisplayed();
        String annualplan = subscriptionElements.annualplan.getText();
        Assert.assertEquals(annualplan, "Annual plan");
        subscriptionElements.annualyrSubplan.isDisplayed();
    }

    public void urnewplan() {
        scrollDownForElement(freshpassElements.TNCtitle);
        subscriptionElements.urnewplan.isDisplayed();
        String urnewplan = subscriptionElements.urnewplan.getText();
        Assert.assertEquals(urnewplan, "Your new plan");

    }


    public void newmonthlyplan() {
        scrollDownForElement(freshpassElements.TNCtitle);
        subscriptionElements.newmonthlyplan.isDisplayed();
        String newmonthlyplan = subscriptionElements.newmonthlyplan.getText();
        Assert.assertEquals(newmonthlyplan, "Your monthly plan");
        subscriptionElements.taxnmonthlyplan.isDisplayed();
        subscriptionElements.newmonthlyplanSub.isDisplayed();
    }

    public void donebutton() {
        freshpassElements.Donetab.click();
    }

    public void curmonthlyplan() {
        freshpassElements.Crrentplantitle.isDisplayed();
        membertabelements.monthlytext.isDisplayed();
        String plan = membertabelements.monthlytext.getText();
        Assert.assertEquals(plan, "Monthly plan");
    }

    public void annualstatus() {
        membertabelements.annualFPUser.isDisplayed();
    }

    public void monthlystatus() {

        membertabelements.monthlyUser.isDisplayed();
    }

    public void changeplanElements() {
        String manageText = freshpassElements.Manageyourplan.getText();
        Assert.assertEquals(manageText, "Manage your plan");
        String subtext = freshpassElements.subtextWithplan.getText();
        Assert.assertEquals(subtext, "You can update or cancel your plan, view FAQs and terms here.");
        freshpassElements.Crrentplantitle.isDisplayed();
    }
}

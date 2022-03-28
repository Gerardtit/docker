package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_FreshPass_ChangePlanElements;
import com.automation.pageElements.GG_Verify_FreshpassElements;
import com.automation.pageElements.GG_suspendedFp_accountElements;
import com.automation.pageElements.PaymentPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class GG_updateCardFlowPage extends BasePage {
    public GG_suspendedFp_accountElements suspendedfpElements = new GG_suspendedFp_accountElements();
    public GG_FreshPass_ChangePlanElements changePlanElements = new GG_FreshPass_ChangePlanElements();
    public PaymentPageElements pageElements = new PaymentPageElements();
    public GG_Verify_FreshpassElements freshpassElements = new GG_Verify_FreshpassElements();
    String lastfourdigits = "";

    public GG_updateCardFlowPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), suspendedfpElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), changePlanElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), freshpassElements);


    }

    public void titletvalidate() {
        freshpassElements.FreshPassAtTitle.isDisplayed();
    }

    public void cardarrow() {
        scrollDownForElement(suspendedfpElements.cardArrow);
        suspendedfpElements.cardArrow.click();
    }

    public void planSelect() {
        new CommonActions(driver).new ClickAction().clickElement(changePlanElements.AnnualselectPlan);
    }

    public void cardnumber() {
        scrollDownForElement(suspendedfpElements.cardNumber);
        suspendedfpElements.cardNumber.isDisplayed();
    }

    public void validateCard(String cardNumber) {
//        enterKey(pageElements.cardNumber, cardNumber)
        if (cardNumber.length() > 4) {
            lastfourdigits = cardNumber.substring(cardNumber.length() - 4);
        }
        String displayednumber = suspendedfpElements.cardNumber.getText();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Assert.assertEquals("Visa ending in " + lastfourdigits + " edit", displayednumber);

        } else {
            Assert.assertEquals("•••• •••• •••• " + lastfourdigits, displayednumber);
        }


    }

    public void confirmcvv() {
        changePlanElements.ConfirmCVV.isDisplayed();
    }
}


















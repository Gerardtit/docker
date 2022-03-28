package com.automation.pages;


import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_FreshPassMemberTab_Elements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GG_freshPass_membertabPage extends BasePage {

    public GG_FreshPassMemberTab_Elements membertabElements = new GG_FreshPassMemberTab_Elements();
    public GG_SignInPage signInPage = new GG_SignInPage(driver);
    public GG_OtpPasswordPage otpPasswordPage = new GG_OtpPasswordPage(driver);


    public GG_freshPass_membertabPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), membertabElements);
    }

    public void membertabtext() {
        membertabElements.EnjoyMesaage.isDisplayed();
        String enjoytext = membertabElements.EnjoyMesaage.getText();
        Assert.assertEquals(enjoytext, "Enjoy free delivery & perks* with FreshPass™");
    }

    public void membertabSubtext() {
        membertabElements.yrplanMember.isDisplayed();
        String subtext = "Only $99 / yr. or $12.99 / mo. plus applicable taxes";
        Assert.assertEquals(subtext, "Only $99 / yr. or $12.99 / mo. plus applicable taxes");
    }

    public void freedelivery() {
        membertabElements.freedelivery.isDisplayed();
        String freedelivery = "Free delivery";
        Assert.assertEquals(freedelivery, "Free delivery");
    }

    public void freedeliverysubtext() {
        membertabElements.subcribeerTxt.isDisplayed();
        String subText = "Subscribers enjoy free unlimited deliveries for all their orders (where available)";
        Assert.assertEquals(subText, "Subscribers enjoy free unlimited deliveries for all their orders (where available)");
    }

    public void exclusivetext() {
        membertabElements.ExclusiveText.isDisplayed();
        String exclusive = "Exclusive deals";
        Assert.assertEquals(exclusive, "Exclusive deals");
    }

    public void exclusivesubtext() {
        membertabElements.exclusivesubtext.isDisplayed();
        String subexclusive = "Save 5% on O Organics® and Open Nature®.";
        Assert.assertEquals(subexclusive, "Save 5% on O Organics® and Open Nature®.");
    }

    public void exclusiveStar() {
        membertabElements.starbuckstext.isDisplayed();
        String starbucks = "Exclusive monthly Starbucks perks";
        Assert.assertEquals(starbucks, "Exclusive monthly Starbucks perks");
    }

    public void handicraftText() {
        membertabElements.handicraftText.isDisplayed();
        String crafttext = "Get your favorite handcrafted beverage on us.";
        Assert.assertEquals(crafttext, "Get your favorite handcrafted beverage on us.");
    }

    public void dontexpireText() {
        scrollDownForElement(membertabElements.VIPcustomer);
        membertabElements.dontexpireText.isDisplayed();
        String expire = "Rewards don't expire";
        Assert.assertEquals(expire, "Rewards don't expire");
    }

    public void restEasyText() {
        membertabElements.restEasyText.isDisplayed();
        String easytext = "Rest easy, they'll always be there.";
        Assert.assertEquals(easytext, "Rest easy, they'll always be there.");
    }

    public void TNCatMember() {
        membertabElements.TNCatMember.isDisplayed();
        String Tnctext = "* Restrictions apply. Full program Terms & Conditions here.";
        Assert.assertEquals(Tnctext, "* Restrictions apply. Full program Terms & Conditions here.");
    }

    public void promotext() {
        membertabElements.promotext.isDisplayed();
        String promotext = "** $5 promo credit every month until December 31, 2021, for annual paid subscribers only.";
        Assert.assertEquals(promotext, "** $5 promo credit every month until December 31, 2021, for annual paid subscribers only.");
    }

    public void vip() {
        scrollDown();
        membertabElements.VIPcustomer.isDisplayed();
        String text = "VIP customer service line";
        Assert.assertEquals(text, "VIP customer service line");
    }

    public void vipsubtext() {
        membertabElements.VIPcustomersubText.isDisplayed();
        String vip = "Want to talk to a real, live person?";
        Assert.assertEquals(vip, "Want to talk to a real, live person?");
    }

    public void groceryText() {
        membertabElements.groceryText.isDisplayed();
        String grocery = "Grocery & wine experiences";
        Assert.assertEquals(grocery, "Grocery & wine experiences");

    }

    public void grocerysubText() {

        membertabElements.grocerysubText.isDisplayed();
        String grocerysub = "Impress your friends and family.";
        Assert.assertEquals(grocerysub, "Impress your friends and family.");
    }

    public void exclusivetexttab() {
        swipeLeftOnElement(membertabElements.VIPcustomer);
        membertabElements.grocerysubText.isDisplayed();
        String exclusivetexttab = "Exclusive deals";
        Assert.assertEquals(exclusivetexttab, "Exclusive deals");
    }

    public void exclusivetextsubtab() {
        membertabElements.organictext.isDisplayed();
        String exclusivetextsubtab = "Exclusive deals";
        Assert.assertEquals(exclusivetextsubtab, "Exclusive deals");
    }

    public void monthlystarbuck() {
        swipeLeftOnElement(membertabElements.organictext);
        membertabElements.monthlystarbuck.isDisplayed();
        String monthlystarbuck = "Monthly Starbucks perk";
        Assert.assertEquals(monthlystarbuck, "Monthly Starbucks perk");
    }

    public void emonthlystarbuckSubText() {
        membertabElements.emonthlystarbuckSubText.isDisplayed();
        String emonthlystarbuckSubText = "Get your favorite handcrafted beverage on us.";
        Assert.assertEquals(emonthlystarbuckSubText, "Get your favorite handcrafted beverage on us.");
    }

    public void starbuckSubTexttab() {
        membertabElements.starbuckSubTexttab.isDisplayed();
        String starbuckSubTexttab = "The gift that keeps on giving.\"";
        Assert.assertEquals(starbuckSubTexttab, "The gift that keeps on giving.\"");
    }

    public void rewardNoexpire() {
        swipeLeftOnElement(membertabElements.starbuckSubTexttab);
        membertabElements.rewardNoexpire.isDisplayed();
        String rewardNoexpire = "Rewards don’t expire";
        Assert.assertEquals(rewardNoexpire, "Rewards don’t expire");
    }

    public void rewardNoexpiresubtext() {
        membertabElements.rewardNoexpiresubtext.isDisplayed();
        String rewardNoexpiresubtext = "Rest easy, they’ll always be there.";
        Assert.assertEquals(rewardNoexpiresubtext, "Rest easy, they’ll always be there.");
    }

    public void deliverytext() {
        swipeLeftOnElement(membertabElements.rewardNoexpiresubtext);
        membertabElements.deliverytext.isDisplayed();
        String deliverytext = "Unlimited free delivery";
        Assert.assertEquals(deliverytext, "Unlimited free delivery");
    }

    public void deliverysubtext() {
        membertabElements.deliverysubtext.isDisplayed();
        String deliverysubtext = "No fees on all orders over $30.";
        Assert.assertEquals(deliverysubtext, "No fees on all orders over $30.");

    }


    public void clickOnMemberTab() {
        new CommonActions(driver).new ClickAction().clickElement(membertabElements.membertabatHomepage);

    }

    public void clickOnFreshPass() {
        new CommonActions(driver).new ClickAction().clickElement(membertabElements.freshpassAtMemberpage);

    }

    public void verifyAnnualMemberStatus() {
        Assert.assertTrue(isElementDisplayed(membertabElements.annualFPUser), "user is not annualy susbcribed");
    }

    public void verifyFreeAnnualMemberStatus() {
        Assert.assertTrue(isElementDisplayed(membertabElements.freeTrailAnnualFPUser, 35), "user is not free trail annualy susbcribed");
    }

    public void verifyFreeMonthlyMemberStatus() {
        Assert.assertTrue(isElementDisplayed(membertabElements.freeTrailMonthlyFPUser, 35), "user is not free trail monthly susbcribed");
    }


    public void verifymonthlyAndCreditOffer() {
        Assert.assertTrue(isElementDisplayed(membertabElements.FreshPassPerks), "FreshPass perks heading is not displayed");
        Assert.assertTrue(isElementDisplayed(membertabElements.monthlyOffer), "monthly credit offer is not displayed");
        Assert.assertTrue(isElementDisplayed(membertabElements.creditOffer), "credit offer is not displayed");
        scrollDown();
        Assert.assertTrue(isElementDisplayed(membertabElements.freshPassBenifitHeading), "FreshPass benifit carousel heading is not displayed");
        Assert.assertTrue(isElementDisplayed(membertabElements.freshPassBenifitCarousel), "FreshPass benefit  offers in carousel is not displayed");
        scrollUp();
    }


    public void clickOnMonthlyCreditOffer() {
        new CommonActions(driver).new ClickAction().clickElement(membertabElements.monthlyOffer);
    }

    public void clickOnCreditOffer() {
        new CommonActions(driver).new ClickAction().clickElement(membertabElements.creditOffer);

    }

    public void verifyDisclaimer() {
        Assert.assertTrue(isElementDisplayed(membertabElements.disclaimer), "offer disclaimer is not displayed");
    }

    public void verifyMonthlyUserStatus() {
        Assert.assertTrue(isElementDisplayed(membertabElements.monthlyUser), "user is not annualy susbcribed");
    }

}

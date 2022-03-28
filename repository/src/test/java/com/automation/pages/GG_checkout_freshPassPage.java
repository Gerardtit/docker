package com.automation.pages;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_checkout_FreshPassElements;
import com.automation.pageElements.PaymentPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static java.lang.Thread.sleep;


public class GG_checkout_freshPassPage extends BasePage {
    public AppiumDevice device = AppiumDeviceManager.getDevice();

    public GG_checkout_FreshPassElements gg_checkout_freshPassElements = new GG_checkout_FreshPassElements();
    public PaymentPageElements pageElements = new PaymentPageElements();
    NewCheckoutPage newCheckoutPage = new NewCheckoutPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    public GG_CheckoutPage gg_checkoutPage = new GG_CheckoutPage(driver);

    public GG_checkout_freshPassPage(AppiumDriver driver) {
        super(driver);

        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_checkout_freshPassElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
    }

    public void verifyFreshPassBanner() {
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.slotsScreenFPBanner, 35));
        String str1 = "Unlimited free delivery & exclusive perks with a 30-day free trial.";
        String str2;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {

            String text[] = gg_checkout_freshPassElements.slotsScreenFPBanner.getText().trim().split("exclusive");
            str2 = text[0] + " " + text[1];
            //System.out.println("str2"+str2);
            Assert.assertTrue(str1.contains(text[0].trim()) && str1.contains(text[1].trim()), "FreshPass banner in slots screen is not displayed.");
        } else {
            str2 = gg_checkout_freshPassElements.slotsScreenFPBanner.getAttribute("label");
            Assert.assertTrue((str2.contains(str1) | str1.contains(str2)), "FreshPass banner in slots screen is not displayed.");
        }
    }

    public void verifySelectPlanScreen() {
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.selectFPPlanScreenHeading), "Select FreshPass plan heading is not displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.backButton), "Back button in select plan screen is not displayed");

    }

    public void verifyAnnualPlanInSelectPlanScreen() {


        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.annualPlan), "Annual plan  is not displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.planPrice), "annual plan price is not displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.annualPlanPriceDetailText1), "which is equal to text is not displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.annualPlanPriceDetailText2), "Automattically renews text is not displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.selectFPPlanScreenHeading), "Select FreshPass plan heading is not displayed");

        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.thirtyDayFreeTrail), "30 day free trail text is not displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.fiveDollarMonthlyText), "$5 monthly credit text is not displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.saveThirthyPercent), "save 35% text is not displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.annualPlanSelectButton), "Annual plan select button is not displayed");

    }

    public void verifyMonthlyPlanInSelectPlanScreen() {

        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.monthlyPlan), "Monthly plan  is not displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.monthlyPlanPrice), "Monthly plan price is not displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.automaticallyRenews), "Automatically renews text is not displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.billedMonthly), "billed monthly text is not displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.mpnthlyThirtyFreeTrail), "30 day free trail text is not displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.monthlyPlanSelectButton), "monthly plan select button is not displayed");

    }

    public void verifyTermsAndConditions() {

        String str1 = "By tapping the button below, I agree to the FreshPass terms. I consent to and authorize storage of my debit and/or credit card data and authorize charges for subscription fees after 30-day free trial and for subsequent auto-renewals until I cancel.";
        String str2;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            str2 = gg_checkout_freshPassElements.termsAndConditions.getText();
            Assert.assertTrue(str2.equals(str1), "Terms and condition text is not displayed.");
        } else {
            str2 = gg_checkout_freshPassElements.termsAndConditions.getAttribute("label");
            Assert.assertTrue((str2.contains(str1) | str1.contains(str2)), "Terms and condition text is not displayed.");
        }
    }

    public void verifySignUpButton() {

        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.signUpButton), "signup button is not displayed");

    }


    public void clickOnFreshPassBanner() throws Exception {
        if (isElementDisplayed(pageElements.cvvEditText)) {
            enterCVVifDisplayed("123");
            newCheckoutPage.tapSlotSelctionCard();
            waitForDisplayed(gg_checkout_freshPassElements.slotsScreenFPBanner);
            gg_checkout_freshPassElements.slotsScreenFPBanner.click();

        } else {
            waitForDisplayed(gg_checkout_freshPassElements.slotsScreenFPBanner);
            gg_checkout_freshPassElements.slotsScreenFPBanner.click();
        }
    }

    public void navigateToSlotsscreen() throws Exception {
        if (isElementDisplayed(pageElements.cardNumber)) {
            checkoutPage.clickCloseButtonOnPayment();
            newCheckoutPage.tapSlotSelctionCard();
        }
        if (isElementDisplayed(pageElements.cvvEditText)) {
            enterCVVifDisplayed("123");
            newCheckoutPage.tapSlotSelctionCard();
        } else {
            newCheckoutPage.tapSlotSelctionCard();
        }
    }

    public void enterCVVifDisplayed(String arg0) throws InterruptedException {
        if (isElementDisplayed(pageElements.cvvEditText)) {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                enterKey(pageElements.cvvEditText, arg0);
                new CommonActions(driver).new ClickAction().clickElement(pageElements.doneButton);
                waitForLoadingComplete();
                new CommonActions(driver).new ClickAction().clickElement(pageElements.continueCTA);
            } else {
                waitForLoadingComplete();
                //   waitForElement(pageElements.cvvEditText,5);
                waitForDisplayed(pageElements.cvvEditText, 30);
                enterKey(pageElements.cvvEditText, arg0);
                pressEnterAndroid();
                // pressEnterAndroid();
                sleep(30);
                System.out.println("hide keyboard");
                waitForLoadingComplete();
                sleep(20000);
            }
        }

    }

    public void verifyFPBannerReenrollUser() {
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.slotsScreenFPBanner, 20));
        String str1 = "Enjoy free delivery and exclusive perks with FreshPass™";
        String str2;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {

            str2 = gg_checkout_freshPassElements.slotsScreenFPBanner.getText().trim();
            System.out.println("str2" + str2);
            Assert.assertTrue(str2.contains(str1), "FreshPass banner in slots screen is not displayed.");
        } else {
            str2 = gg_checkout_freshPassElements.slotsScreenFPBanner.getAttribute("label");
            Assert.assertTrue((str2.contains(str1) | str1.contains(str2)), "FreshPass banner in slots screen is not displayed.");
        }
    }

    public void verifyAnnualPlanInSelectPlanScreenReenroll() {

        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.annualPlan), "Annual plan  is not displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.planPrice), "annual plan price is not displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.annualPlanPriceDetailText1), "which is equal to text is not displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.annualPlanPriceDetailText2), "Automattically renews text is not displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.selectFPPlanScreenHeading), "Select FreshPass plan heading is not displayed");
        Assert.assertFalse(isElementDisplayed(gg_checkout_freshPassElements.thirtyDayFreeTrail), "30 day free trail text is displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.fiveDollarMonthlyText), "$5 monthly credit text is not displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.saveThirthyPercent), "save 35% text is not displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.annualPlanSelectButton), "Annual plan select button is not displayed");

    }

    public void verifyMonthlyPlanInSelectPlanScreenReenroll() {

        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.monthlyPlan), "Monthly plan  is not displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.monthlyPlanPrice), "Monthly plan price is not displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.automaticallyRenews), "Automatically renews text is not displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.billedMonthly), "billed monthly text is not displayed");
        Assert.assertFalse(isElementDisplayed(gg_checkout_freshPassElements.mpnthlyThirtyFreeTrail), "30 day free trail text is displayed");
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.monthlyPlanSelectButton), "monthly plan select button is not displayed");

    }

    public void verifyTermsAndConditionsReenrollUser() {

        String str1 = "By tapping the button below, I agree to the FreshPass terms. I consent to and authorize storage of my debit and/or credit card data and authorize charges for current subscription fees and future auto-renewals until I cancel.";
        String str2;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            str2 = gg_checkout_freshPassElements.termsAndConditions.getText();
            Assert.assertTrue(str2.equals(str1), "Terms and condition text is not displayed.");
        } else {
            str2 = gg_checkout_freshPassElements.termsAndConditions.getAttribute("label");
            Assert.assertTrue((str2.contains(str1) | str1.contains(str2)), "Terms and condition text is not displayed.");
        }
    }

    public void verifyFPBannerActiveUser() {

        Assert.assertFalse(isElementDisplayed(gg_checkout_freshPassElements.FPTextNewUSer, 20), "FP banner is displayed for Active USer");
        Assert.assertFalse(isElementDisplayed(gg_checkout_freshPassElements.FPTextReturningUSer, 20), "FP banner is displayed for Active USer");
    }

    public void verifyDeliveryFeeFree() throws Exception {
        waitForLoadingComplete();
        sleep(3000);
        String fee = "";
        if (driver.getPlatformName().equalsIgnoreCase("ios"))
            fee = gg_checkout_freshPassElements.deliveryFree.getAttribute("label").trim();
        else
            fee = gg_checkout_freshPassElements.deliveryFree.getText().trim();
        Assert.assertTrue(fee.contains("Free"), "delivery fee is not free for Active USer");


    }

    public void verifyDeliveryFeeNotFree() {
        Assert.assertFalse(isElementDisplayed(gg_checkout_freshPassElements.deliveryFree, 20), "delivery fee is free for Active USer");

    }

    public void selectAnnualPlanNewUser() {
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.thirtyDayFreeTrail, 35), "30 day free trail text is not displayed");
        gg_checkout_freshPassElements.annualPlanSelectButton.click();
    }

    public void tapOnSignUpButton() {

        gg_checkout_freshPassElements.activeSignupButton.click();
    }

    public void verifyFPPlanAddedBanner() {
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.fpPlanAdded), "FreshPass plan added text is not displayed");
    }

    public void selectMonthlyPlanNewUser() {

        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.mpnthlyThirtyFreeTrail), "30 day free trail text is not displayed");
        gg_checkout_freshPassElements.monthlyPlanSelectButton.click();

    }

    public void selectAnnualPlanReenrollUser() {
        Assert.assertFalse(isElementDisplayed(gg_checkout_freshPassElements.thirtyDayFreeTrail), "30 day free trail text is  displayed");
        gg_checkout_freshPassElements.annualPlanSelectButton.click();


    }

    public void tapOnBackButton() {
        gg_checkout_freshPassElements.backButton.click();
    }

    public void selectMonthlyPlanReenrollUser() {
        Assert.assertFalse(isElementDisplayed(gg_checkout_freshPassElements.mpnthlyThirtyFreeTrail), "30 day free trail text is  displayed");
        gg_checkout_freshPassElements.monthlyPlanSelectButton.click();

    }

    public void verifyFreeWithFreshPass() {
        waitForLoadingComplete();
        scrollUp();
        scrollDownForElement(gg_checkout_freshPassElements.freeWithFP);
        Assert.assertTrue(isElementDisplayed(gg_checkout_freshPassElements.freeWithFP, 30), "Delivery fee is not free in order summary");
    }

    public void verifyDisclaimerNewUserAnnual() {
        scrollDownForElement(gg_checkout_freshPassElements.disclaimerOrderSummary);
        String expDis = "Your FreshPass is billed separately and is not reflected in the Estimated Total. You have chosen the Annual Plan and will be charged $99.00 per year plus applicable taxes after the 30-day Free Trial expires. A confirmation email will be sent to you shortly.";
        String actDis = "";
        if (driver.getPlatformName().equalsIgnoreCase("ios"))
            actDis = gg_checkout_freshPassElements.disclaimerOrderSummary.getAttribute("label").trim();
        else
            actDis = gg_checkout_freshPassElements.disclaimerOrderSummary.getText().trim();
        Assert.assertEquals(actDis, expDis, "Disclaimer is not correct for New user signup for annual plan");

    }

    public void verifyDisclaimerNewAnnualOrderConfirmation() {
        scrollDownForElement(gg_checkout_freshPassElements.disclaimerOrderSummary);
        String expDis = "Your FreshPass is billed separately and is not reflected in the Estimated Total. You have chosen the Annual Plan and will be charged $99.00 per year ($8.25 per month) plus applicable taxes after the 30-day Free Trial expires. A confirmation email will be sent to you shortly.";
        String actDis = "";
        if (driver.getPlatformName().equalsIgnoreCase("ios"))
            actDis = gg_checkout_freshPassElements.disclaimerOrderSummary.getAttribute("label").trim();
        else
            actDis = gg_checkout_freshPassElements.disclaimerOrderSummary.getText().trim();
        Assert.assertEquals(actDis, expDis, "Disclaimer is not correct for New user signup for annual plan");

    }

    public void verifyDisclaimerNewUserMonthly() {
        scrollDownForElement(gg_checkout_freshPassElements.disclaimerOrderSummary);
        String expDis = "Your FreshPass is billed separately and is not reflected in the Estimated Total. You have chosen the Monthly Plan and will be charged $12.99 per month plus applicable taxes after the 30-day Free Trial expires. A confirmation email will be sent to you shortly.";
        String actDis = "";
        if (driver.getPlatformName().equalsIgnoreCase("ios"))
            actDis = gg_checkout_freshPassElements.disclaimerOrderSummary.getAttribute("label").trim();
        else
            actDis = gg_checkout_freshPassElements.disclaimerOrderSummary.getText().trim();
        Assert.assertEquals(actDis, expDis, "Disclaimer is not correct for New user signup for Monthly plan");

    }

    public void verifyDisclaimerNewMonthlyOrderConfirmation() {
        scrollDownForElement(gg_checkout_freshPassElements.disclaimerOrderSummary);
        String expDis = "Your FreshPass is billed separately and is not reflected in the Estimated Total. You have chosen the Monthly Plan and will be charged $12.99 per month plus applicable taxes after the 30-day Free Trial expires. A confirmation email will be sent to you shortly.";
        String actDis = "";
        if (driver.getPlatformName().equalsIgnoreCase("ios"))
            actDis = gg_checkout_freshPassElements.disclaimerOrderSummary.getAttribute("label").trim();
        else
            actDis = gg_checkout_freshPassElements.disclaimerOrderSummary.getText().trim();
        Assert.assertEquals(actDis, expDis, "Disclaimer is not correct for New user signup for Monthly plan");

    }

    public void verifyDisclaimerReenrollMonthly() {
        scrollDownForElement(gg_checkout_freshPassElements.disclaimerOrderSummary);
        String expDis = "Your FreshPass is billed separately and is not reflected in the Estimated Total. You have chosen the Monthly Plan and will be charged $12.99 per month plus applicable taxes. A confirmation email will be sent to you shortly.";
        String actDis = "";
        if (driver.getPlatformName().equalsIgnoreCase("ios"))
            actDis = gg_checkout_freshPassElements.disclaimerOrderSummary.getAttribute("label").trim();
        else
            actDis = gg_checkout_freshPassElements.disclaimerOrderSummary.getText().trim();
        Assert.assertEquals(actDis, expDis, "Disclaimer is not correct for reenroll user signup for Monthly plan");

    }


    public void verifyDisclaimerReenrollAnnual() {
        scrollDownForElement(gg_checkout_freshPassElements.disclaimerOrderSummary);
        String expDis = "Your FreshPass is billed separately and is not reflected in the Estimated Total. You have chosen the Annual Plan and will be charged $99.00 per year plus applicable taxes. A confirmation email will be sent to you shortly.";
        String actDis = "";
        if (driver.getPlatformName().equalsIgnoreCase("ios"))
            actDis = gg_checkout_freshPassElements.disclaimerOrderSummary.getAttribute("label").trim();
        else
            actDis = gg_checkout_freshPassElements.disclaimerOrderSummary.getText().trim();
        Assert.assertEquals(actDis, expDis, "Disclaimer is not correct for reenroll user signup for annual plan");

    }

    public void deSelectAnnualPlan() {
        gg_checkout_freshPassElements.annualPlanSelectedButton.click();
    }

    public void deSelectMonthlyPlan() {
        gg_checkout_freshPassElements.monthlyPlanSelectedButton.click();
    }

    public void clickOnbuttonSlotsScreen() throws Exception {

        gg_checkout_freshPassElements.clickSlotsButton.click();
        //   gg_checkoutPage.clickonContinue_to_review_order();
        // newCheckoutPage.clickSaveButton();

    }

    public void verifyDisclaimerMonthlyPlanNotDisplay() {
        scrollDownForElement(gg_checkout_freshPassElements.urFPSavedU);
        Assert.assertFalse(isElementDisplayed(gg_checkout_freshPassElements.disclaimerOrderSummary), "Disclaimer is displayed for New user signup for Monthly plan from member tab");


    }

    public void verifidisclaimerAnnualPlanNotDisplay() {
        scrollDownForElement(gg_checkout_freshPassElements.urFPSavedU);
        Assert.assertFalse(isElementDisplayed(gg_checkout_freshPassElements.disclaimerOrderSummary), "Disclaimer is not correct for New user signup for annual plan");


    }


}





package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_Deals_PromoPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import org.testng.Assert;

public class GG_Deals_PromoSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_Deals_PromoPage dealsPage = new GG_Deals_PromoPage(driver);

    @And("^Verify 'Promo card' is displayed$")
    public void verifyPromoCardInDisplayed() {
        Assert.assertTrue(dealsPage.verifyPromoCard(), "Promo deal card is not displayed");
    }

    @And("^verify Promo card subject title$")
    public void verifyPromoCardSubjectTitle() {
        Assert.assertTrue(dealsPage.verifyPromoCardSubjectTitle(), "Promo deal subject line is not displayed");
    }

    @And("^verify Promo card description$")
    public void verifyPromoCardDescription() {
        Assert.assertTrue(dealsPage.verifyPromoCardDescription(), "Promo deal description is not displayed");
    }

    @And("^verify Promo card CTA button$")
    public void verifyPromoBigCardCTAButton() {
        Assert.assertTrue(dealsPage.verifyPromoDealCTA(), "CTA button on promo card is not displayed");
    }

    @And("^click on promo deal CTA button and verify toast message 'Promo code copied to clipboard' displayed$")
    public void verifyPromoCodeCopiedAnimationLabelDisplayed() {
        Assert.assertTrue(dealsPage.clickPromoCardCtaBtnAndCheckForToastMsg(), "Toast message 'Promo code copied to clipboard' is not displayed");
    }

    @And("^verify toast message 'Promo code copied to clipboard' not displayed$")
    public void verfifyPromoCodeCopiedAnimationLabelDisplayed() {
        Assert.assertFalse(dealsPage.isPromoCodeCopiedAnimationLabelDisplayed(), "Toast message 'Promo code copied to clipboard' is displayed");
    }

    @And("^wait Three seconds$")
    public void waitThreeSeconds() throws InterruptedException {
        dealsPage.waitThreeSeconds();
    }

    @And("^verify Image on promo deal$")
    public void verifyPromoDealImage() {
        Assert.assertTrue(dealsPage.verifyImageOnPromoDeal(), "Image on promo deal card is not displayed");
    }

    @And("^verify promo deal details page is displayed$")
    public void verifyPromoDealDetailPage() {
        Assert.assertTrue(dealsPage.verifyPromoDealDetailPage(), "Promo deal detail page is not displayed");
    }

    @And("^click on promo deal$")
    public void clickOnPromoDeal() {
        dealsPage.clickOnPromoDeal();
    }

    @And("^click on search icon on promo deal details page$")
    public void clickOnSearchItemOnPromoDealPage() {
        dealsPage.clickSearchIcon();
    }
}

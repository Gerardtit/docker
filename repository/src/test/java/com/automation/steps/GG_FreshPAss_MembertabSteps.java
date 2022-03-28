package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_freshPass_membertabPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GG_FreshPAss_MembertabSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_freshPass_membertabPage FreshPassmemberPage = new GG_freshPass_membertabPage(driver);
    AppiumDevice device = AppiumDeviceManager.getDevice();

    @Then("^validate the text on freshpass page of memeber tab$")
    public void validateTheTextOnFreshpassPageOfMemeberTab() {
        FreshPassmemberPage.membertabtext();
        FreshPassmemberPage.membertabSubtext();
        FreshPassmemberPage.freedelivery();
        FreshPassmemberPage.freedeliverysubtext();
        FreshPassmemberPage.exclusivetext();
        FreshPassmemberPage.exclusivetextsubtab();
        FreshPassmemberPage.exclusiveStar();
        FreshPassmemberPage.emonthlystarbuckSubText();
        FreshPassmemberPage.dontexpireText();
        FreshPassmemberPage.restEasyText();
        FreshPassmemberPage.TNCatMember();
        FreshPassmemberPage.promotext();
    }


    @And("^validate tabs at freshpass of member tab$")
    public void validateTabsAtFreshpassOfMemberTab() {
        FreshPassmemberPage.vip();
        FreshPassmemberPage.vipsubtext();
        FreshPassmemberPage.groceryText();
        FreshPassmemberPage.grocerysubText();
        FreshPassmemberPage.exclusivetexttab();
        FreshPassmemberPage.exclusivetextsubtab();
        FreshPassmemberPage.monthlystarbuck();
        FreshPassmemberPage.starbuckSubTexttab();
        FreshPassmemberPage.rewardNoexpire();
        FreshPassmemberPage.deliverytext();
        FreshPassmemberPage.deliverysubtext();
    }


    @When("user click on member tab")
    public void userClicksOnMemberTab() {
        FreshPassmemberPage.clickOnMemberTab();
    }


    @When("user click on member tab from Home page")
    public void user_click_on_member_tab_from_Home_page() {
        FreshPassmemberPage.clickOnMemberTab();
    }

    @Then("user click on freshpass at member tab")

    public void userClicksOnFreshpassAtMemberTab() {
        FreshPassmemberPage.clickOnFreshPass();
    }


    @Then("user click on freshPass at member tab")
    public void userClickOnFreshPassAtMemberTab() throws InterruptedException {
        FreshPassmemberPage.clickOnFreshPass();
    }

    @When("user is annual subscribed")
    public void userIsAnnualSubscribed() {
        FreshPassmemberPage.verifyAnnualMemberStatus();
    }

    @When("user is free trail annual subscribed")
    public void userIsFreeAnnualSubscribed() {
        FreshPassmemberPage.verifyFreeAnnualMemberStatus();
    }

    @When("user is free trail Monthly subscribed")
    public void userIsFreeMonthlySubscribed() {
        FreshPassmemberPage.verifyFreeMonthlyMemberStatus();
    }

    @Then("validate credit offer and monthly credit offer benifit carousel")
    public void validateCreditOfferAndMonthlyCreditOfferBenifitCarousel() {
        FreshPassmemberPage.verifymonthlyAndCreditOffer();
    }

    @When("tap on monthly credit offer")
    public void tapOnMonthlyCreditOffer() {
        FreshPassmemberPage.clickOnMonthlyCreditOffer();

    }

    @When("user is monthly subscribed")
    public void userIsMonthlySubscribed() {
        FreshPassmemberPage.verifyMonthlyUserStatus();
    }


    @And("verify disclaimer text")
    public void verifyDisclaimerText() {
        FreshPassmemberPage.verifyDisclaimer();
    }

    @When("tap on credit offer")
    public void tapOnCreditOffer() {
        FreshPassmemberPage.clickOnCreditOffer();
    }
}
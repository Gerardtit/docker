package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.BasePage;
import com.automation.pages.GG_Tutorial_ToolTipPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class GG_Tutorial_ToolTipSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_Tutorial_ToolTipPage gg_tutorial_toolTipPage = new GG_Tutorial_ToolTipPage(driver);
    public BasePage basePage = new BasePage(driver);

    @Then("^verify tutorial tool tip description on deal Tab$")
    public void verifyToolTipDescriptionOnDealTab() {
        Assert.assertTrue(gg_tutorial_toolTipPage.verifyToolTipDescriptionForDealsTab());
    }

    @Then("^click next button on welcome tutorial on deals tab$")
    public void clickOnNextButtonOnToolTip() {
        gg_tutorial_toolTipPage.clickOnNextButtonOnTutorialToolTip();
    }

    @Then("^click anywhere on screen when tutorials is displayed on deals tab$")
    public void clickRandomLocationOnTutorialScreen() {
        gg_tutorial_toolTipPage.clickRandomLocationOnScreenTutorials();
    }

    @Then("^verify select shopping method stage is displayed$")
    public void verifySelectShoppingMethodStageIsDisplayed() {
        Assert.assertTrue(gg_tutorial_toolTipPage.isShoppingMethodStageDisplayed());
    }

    @Then("^verify Deals stage is displayed$")
    public void verifyDealsStageIsDisplayed() {
        Assert.assertTrue(gg_tutorial_toolTipPage.isDealStageDisplayed());
    }

    @Then("^verify wallet stage is displayed$")
    public void verifyWalletStageIsDisplayed() {
        Assert.assertTrue(gg_tutorial_toolTipPage.isWalletStageDisplayed());
    }

}

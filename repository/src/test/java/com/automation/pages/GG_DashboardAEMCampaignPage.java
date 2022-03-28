package com.automation.pages;

import com.automation.helpers.PageActions;
import com.automation.pageElements.GG_DashboardAEMCampaignElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GG_DashboardAEMCampaignPage extends BasePage {
    private final GG_DashboardAEMCampaignElements dashboardAEMCampaignElements = new GG_DashboardAEMCampaignElements();

    public GG_DashboardAEMCampaignPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dashboardAEMCampaignElements);
    }

    public boolean verifyTitleOfAEMCampaign() {
        scrollDownForElement(dashboardAEMCampaignElements.aemTitle);
        return isElementDisplayed(dashboardAEMCampaignElements.aemTitle, 5);
    }

    public boolean verifyDealCard() {
        return isElementDisplayed(dashboardAEMCampaignElements.dealCard);
    }

    public boolean hasCarouselViewAEMProducts() throws InterruptedException {
        String attrText = driver.getPlatformName().equalsIgnoreCase("ios") ? "label" : "content-desc";
        return new PageActions(driver).hasCarouselView(dashboardAEMCampaignElements.dealDescription, attrText);
    }

    public boolean scrollDownAndCheckIfAEMCarouselDisplayed() {
        scrollDownForElement(dashboardAEMCampaignElements.aemTitle);
        return scrollDownForElement(dashboardAEMCampaignElements.firstDealDescription);
    }

    public void scrollUptoAemCampaign() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            scrollUpForElement(dashboardAEMCampaignElements.aemTitle);
        }
    }
}

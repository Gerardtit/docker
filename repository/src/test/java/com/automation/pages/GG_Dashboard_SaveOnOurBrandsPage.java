package com.automation.pages;

import com.automation.helpers.PageActions;
import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_DashboardPageElements;
import com.automation.pageElements.GG_Dashboard_SaveOnOurBrandsPageElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GG_Dashboard_SaveOnOurBrandsPage extends BasePage {
    private final GG_Dashboard_SaveOnOurBrandsPageElement exclusivePageElement = new GG_Dashboard_SaveOnOurBrandsPageElement();
    private final GG_DashboardPageElements dashboardPageElement = new GG_DashboardPageElements();

    public GG_Dashboard_SaveOnOurBrandsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), exclusivePageElement);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dashboardPageElement);
    }

    public boolean scrollToExclusiveBrand() {
        return scrollDownForElement(exclusivePageElement.exclusiveBrandTitle);
    }

    public boolean scrollDownUpToExclusiveBrandsModuleDealCard() {
        return scrollDownForElement(exclusivePageElement.dealCTAButton);
    }

    public String getExclusiveBrandTitleText() {
        scrollDownForElement(exclusivePageElement.exclusiveBrandTitle);
        return exclusivePageElement.exclusiveBrandTitle.getText();
    }

    public void clickOnSeeAllExclusiveBrandsModule() {
        scrollDownForElement(exclusivePageElement.seeAllLink);
        new CommonActions(driver).new ClickAction().clickElement(exclusivePageElement.seeAllLink);
    }

    public boolean verifyExclusiveBrandImage() {
        return scrollDownForElement(exclusivePageElement.exclusiveBrandImage);
    }

    public boolean isExclusiveBrandDealsDetailsPageDisplayed() {
        return isElementDisplayed(exclusivePageElement.countExclusiveBrandDeals) && isElementDisplayed(exclusivePageElement.closeExclusiveBrandDetails);
    }

    public void clickOnDealCardOnExclusiveStoreBrandsModule() {
        scrollDownForElement(dashboardPageElement.dealName);
        new CommonActions(driver).new ClickAction().clickElement(dashboardPageElement.dealName);
    }

    public boolean isDealCardDetailsPageDisplayed() {
        return isElementDisplayed(exclusivePageElement.dealCardDetailsPageAllCoupon);
    }

    public void scrollDownForSaveYourBrandsModule() {
        scrollDownForElement(exclusivePageElement.saveOnYourBrandModuleTitle);
    }

    public boolean isSeeAllButtonDisplayed() {
        return scrollDownForElement(exclusivePageElement.saveOnYourBrandModuleSeeAll);
    }

    public boolean isSaveOnYourBrandDisplayed() {
        scrollDownForElement(exclusivePageElement.saveOnYourBrandModuleTitle);
        return isElementDisplayed(exclusivePageElement.saveOnYourBrandModuleTitle);
    }

    public boolean hasCarouselSaveOnOurBrandsSection() throws InterruptedException {
        scrollDownForElement(exclusivePageElement.dealCardExpiryDate);
        String attrText = driver.getPlatformName().equalsIgnoreCase("ios") ? "label" : "text";
        return new PageActions(driver).hasCarouselView(exclusivePageElement.dealDescription, attrText);
    }

}
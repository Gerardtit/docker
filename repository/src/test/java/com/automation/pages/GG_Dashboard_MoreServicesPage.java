package com.automation.pages;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.pageElements.GG_DashboardMoreServicesPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GG_Dashboard_MoreServicesPage extends BasePage {

    private final GG_DashboardMoreServicesPageElements dashboardMoreServicesPageElements = new GG_DashboardMoreServicesPageElements();

    public GG_Dashboard_MoreServicesPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dashboardMoreServicesPageElements);
    }

    public boolean verifyDeliveryPickUpPod() {
        return scrollDownForElement(dashboardMoreServicesPageElements.DeliveryPickUpPod);
    }

    public boolean verifyPharmacyPod() {
        return ThreadLocalHelper.testCaseData.get().get("STORENAME_PHARMACY").trim().equals("NA") || scrollDownForElement(dashboardMoreServicesPageElements.PharmacyPod, 2);
    }

    public boolean verifyFuelPod() {
        return ThreadLocalHelper.testCaseData.get().get("STORENAME_FUEL").trim().equals("NA") || scrollDownForElement(dashboardMoreServicesPageElements.FuelPod, 2);
    }

    public boolean verifyPharmacyFuelPods() {
        scrollDownForElement(dashboardMoreServicesPageElements.PharmacyPod);
        return ThreadLocalHelper.testCaseData.get().get("STORENAME_FUEL_PHARMACY").trim().equals("NA") || isElementDisplayed(dashboardMoreServicesPageElements.PharmacyPod, 2) && isElementDisplayed(dashboardMoreServicesPageElements.FuelPod, 2);
    }


    public boolean verifyMoreServicesModule() {
        return scrollDownForElement(dashboardMoreServicesPageElements.moreServicesModule);
    }

    public void scrollDownUptoMoreServices() {
        scrollDownForElement(dashboardMoreServicesPageElements.moreServicesModule);
    }

    public boolean scrollUptoMoreServices() {
        return scrollUpForElement(dashboardMoreServicesPageElements.moreServicesModule);
    }

    public boolean scrollUpToShoppingModeArrow() {
        return scrollUpForElement(dashboardMoreServicesPageElements.shoppingModeDownArrow);
    }

    public boolean verifyWeCanHelpSectionIsPresent() {
        scrollDownBySmallAmount();
        return scrollUpForElement(dashboardMoreServicesPageElements.moreServicesModule);
    }

}

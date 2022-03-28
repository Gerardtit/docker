package com.automation.pages;

import com.automation.pageElements.GG_OfferCTAElements;
import com.automation.pageElements.HomePageElements;
import com.automation.pageElements.PaymentPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GG_offerCTAPage extends BasePage {
    public HomePageElements homePageElements = new HomePageElements();
    public PaymentPageElements pageElements = new PaymentPageElements();
    private final GG_OfferCTAElements offerCTAElements = new GG_OfferCTAElements();

    public GG_offerCTAPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), offerCTAElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);

        PageFactory.initElements(new AppiumFieldDecorator(driver), homePageElements);
    }

    public void weeklyadHomepage() {
        scrollDownForElement(homePageElements.weeklyadcoupons);
        homePageElements.weeklyadcoupons.isDisplayed();
        homePageElements.weeklyadcouponSEEALL.click();
    }

    public void addedtext() {
        waitForLoadingComplete();
        homePageElements.AddedCoupons.isDisplayed();
        waitForLoadingComplete();
    }

    public void clickproduct() {
        offerCTAElements.AddProduct.click();

    }

    public void validatetext() {
        offerCTAElements.expiresdates.isDisplayed();
        offerCTAElements.pricetag.isDisplayed();
        offerCTAElements.productdesc.isDisplayed();
        offerCTAElements.productdetail.isDisplayed();
    }
}



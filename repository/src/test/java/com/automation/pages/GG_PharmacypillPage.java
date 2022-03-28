package com.automation.pages;


import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_PharmacyPillElements;
import com.automation.pageElements.HomePageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GG_PharmacypillPage extends BasePage {

    private GG_PharmacyPillElements gg_pharmacyPillElements = new GG_PharmacyPillElements();
    public HomePageElements homePageElements = new HomePageElements();


    public GG_PharmacypillPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_pharmacyPillElements);

        PageFactory.initElements(new AppiumFieldDecorator(driver), homePageElements);
    }

    public void pharmacypill() {

        new WaitAction(driver).waitForLoadingComplete();
        gg_pharmacyPillElements.pharmacypill.click();
    }

    public void pharmacyPage() {
        new WaitAction(driver).waitForLoadingComplete();

        gg_pharmacyPillElements.Pharmacypage.isDisplayed();
    }

}


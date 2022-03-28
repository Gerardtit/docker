package com.automation.pages;

import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_RelatedProductsElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GG_RelatedProductsPage extends BasePage {
    private GG_RelatedProductsElements gg_relatedProductsElements = new GG_RelatedProductsElements();

    public GG_RelatedProductsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_relatedProductsElements);
    }

    public String getPageTitle() {
        new WaitAction(driver).waitForDisplayed(gg_relatedProductsElements.pageTitle, 5);
        return getText(gg_relatedProductsElements.pageTitle);
    }
}

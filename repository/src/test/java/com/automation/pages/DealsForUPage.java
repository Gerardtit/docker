package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.DealsForUPageElements;
import com.automation.pageElements.HomePageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DealsForUPage extends BasePage {
    public HomePageElements homePageElements = new HomePageElements();
    public DealsForUPageElements dealsForUPageElements = new DealsForUPageElements();

    public DealsForUPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), homePageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dealsForUPageElements);
    }

    public void clickOnDealsTab() {
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.dealsTab);
        waitForLoadingComplete();
    }

    public void validateDealsPage() {
        Assert.assertTrue(homePageElements.allDealsHeader.isDisplayed());
    }

    public void clickOnForU() {
        new CommonActions(driver).new ClickAction().clickElement(dealsForUPageElements.forUTab);
        waitForLoadingComplete();
    }

    public void validateForU() {
        Assert.assertTrue(dealsForUPageElements.dealsForUHeader.isDisplayed());
    }

}

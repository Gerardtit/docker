package com.automation.pages;


import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.ClubCardDealElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ClubCardDealsPage extends BasePage {
    public ClubCardDealElements pageElements = new ClubCardDealElements();

    public ClubCardDealsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
    }


    public void clickFilter() {
        new WaitAction(driver).waitForDisplayed(pageElements.clickFilter);
        new CommonActions(driver).new ClickAction().clickElement(pageElements.clickFilter);
    }

    public boolean verifySortFilterPageDisplayed() {
        new WaitAction(driver).waitForLoadingComplete();
        return isElementDisplayed(pageElements.SortFilter, 50);
    }

    public void clickBestMatch() {
        new WaitAction(driver).waitForDisplayed(pageElements.bestMatch);
        new CommonActions(driver).new ClickAction().clickElement(pageElements.bestMatch);
    }

    public boolean verifySortByPageDisplayed() {
        new WaitAction(driver).waitForLoadingComplete();
        return isElementDisplayed(pageElements.SortByWindow, 50);
    }

    public void clickClubCardSpecials() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.clickClubCardSpecials);
    }

    public void clickBackButton() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new CommonActions(driver).new ClickAction().clickElement(pageElements.backButton);
        }
    }

    public void clickSave() {
        new WaitAction(driver).waitForDisplayed(pageElements.saveButton);
        new CommonActions(driver).new ClickAction().clickElement(pageElements.saveButton);
    }

    public void selectProduct() {
        scrollDownForElement(pageElements.selectProduct);
        new CommonActions(driver).new ClickAction().clickElement(pageElements.selectProduct);
    }

    public void AddProduct() {
        if (pageElements.addProduct.getText().contains("Add")) {
            new CommonActions(driver).new ClickAction().clickElement(pageElements.addProduct);
        } else if (pageElements.addProduct.getText().contains("Out of stock")) {
            driver.navigate().back();
        }
    }

    public void IncreaseQuantity() {

        try {
            for (int i = 1; i < 6; i++) {
                Thread.sleep(1000);
                new CommonActions(driver).new ClickAction().clickElement(pageElements.Increment);
            }
        } catch (Exception exe) {
        }
    }

    public void DecreaseQuantity() {
        try {
            for (int i = 1; i < 2; i++) {
                Thread.sleep(1000);
                new CommonActions(driver).new ClickAction().clickElement(pageElements.Decrement);
            }
        } catch (Exception exe) {
        }
    }

    public boolean checkCartItems() {
        new WaitAction(driver).waitForLoadingComplete();
        return isElementDisplayed(pageElements.checkCartItems, 50);
    }
}
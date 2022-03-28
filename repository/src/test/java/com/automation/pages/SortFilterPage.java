package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.SortFilterPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class SortFilterPage extends BasePage {
    public SortFilterPageElements pageElements = new SortFilterPageElements();

    public SortFilterPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
    }

    public void sortAndFilterPageDisplayed() {
        new WaitAction(driver).waitForDisplayed(pageElements.sortFilterTitle);
    }

    public void clickSortBy() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.selectSortText);
    }

    public void clickSortandFilterIcon() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.sortfilterIcon);
    }

    public void waitForSortFilterByWindowDisplayed() {
        new WaitAction(driver).waitForDisplayed(pageElements.sortByWindowTitle);
    }

    public void selectBestMatch() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.selectBestMatch);
    }

    public void selectClubCardSpecial() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.selectClubCardSpecial);
    }

    public void selectRewardCardSpecial() {

        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new CommonActions(driver).new ClickAction().clickElement(pageElements.SortByOptions);

        }

        new CommonActions(driver).new ClickAction().clickElement(pageElements.selectRewardCardSpecial);
    }


    public void selectMostPopular() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.selectMostPopular);
    }

    public void selectPriceLowToHigh() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.selectPriceLowToHigh);
    }

    public void selectAlphabetical(String arg0) {
        waitForDisplayed(pageElements.selectAlphabetical);
        new CommonActions(driver).new ClickAction().clickElement(pageElements.selectAlphabetical);
    }

    public void waitForSelectedSortByOptionDisplayed(String arg0) {

        new WaitAction(driver).waitForDisplayed(pageElements.selectSortText);
        Assert.assertTrue(pageElements.selectSortText.getText().contains(arg0));

    }

    public void clickSavePage() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.saveSortFilterPage);
    }
}

package com.automation.pages;


import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_SearchPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.Locale;

public class GG_SearchPage extends BasePage {
    public GG_SearchPageElements gg_searchPageElements = new GG_SearchPageElements();


    public GG_SearchPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_searchPageElements);
    }

    public void clickSearchField() {

        waitForLoadingComplete();
        waitForLoadingComplete();
//        waitForDisplayed(gg_searchPageElements.searchTextField, 5);
        if (isElementDisplayed(gg_searchPageElements.searchTextField)) {
            tapCoordinate(gg_searchPageElements.searchTextField.getCenter().getX(), gg_searchPageElements.searchTextField.getCenter().getY());
        }
    }

    public void UserclickSearchField() {

        waitForLoadingComplete();
        waitForDisplayed(gg_searchPageElements.searchTextField, 5);

        waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(gg_searchPageElements.searchTextField);

        waitForLoadingComplete();
    }

    public void clickSearchProductsOrDealsField() {
        waitForDisplayed(gg_searchPageElements.searchProductsOrDealsField, 5);
        tapCoordinate(gg_searchPageElements.searchProductsOrDealsField.getCenter().getX(), gg_searchPageElements.searchProductsOrDealsField.getCenter().getY());
    }

    public void clickSearchIcon() {
        if (isElementDisplayed(gg_searchPageElements.searchIcon, 5)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_searchPageElements.searchIcon);
        }
    }

    public void clickDealsToggle() {
        if (isElementDisplayed(gg_searchPageElements.dealsToggle, 5)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_searchPageElements.dealsToggle);
        }
    }

    public void clickCancelSearch() {
        if (isElementDisplayed(gg_searchPageElements.cancelSearchButton, 5)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_searchPageElements.cancelSearchButton);

        }
    }

    public boolean verifyKeyboardOpened() {
        boolean opened = true;
        try {
            driver.hideKeyboard();
        } catch (Exception e) {
            opened = false;
        }
        return opened;
    }

    public void clickDetailSearchField() {
        new CommonActions(driver).new ClickAction().clickElement(gg_searchPageElements.detailSearchField);
    }

    public boolean checkCrossButtonIsDisplayed() {
        return isElementDisplayed(gg_searchPageElements.crossButton, 5);
    }

    public void selectKeywordFromSearchResult() {
        new CommonActions(driver).new ClickAction().clickElement(gg_searchPageElements.searchKeywordFromResult.get(0));
    }

    public boolean isProductsDisplayedOnClickingSearchResultsList() {
        return isElementDisplayed(gg_searchPageElements.productPriceProductListingPage, 4);
    }

    public boolean isDealToggleIsPresent() {
        return isElementDisplayed(gg_searchPageElements.dealsToggle);
    }

    public void clickOnDealToggle() {
        new CommonActions(driver).new ClickAction().clickElement(gg_searchPageElements.dealsToggle);
    }

    public boolean isDealCardIsDisplayed() {
        return isElementDisplayed(gg_searchPageElements.dealsCard);
    }

    public void waitForPageDisplayed() {
        new WaitAction(driver).waitForDisplayed(gg_searchPageElements.dealPageTitle);
    }


    public boolean isFilterButtonPresent() {
        return isElementDisplayed(gg_searchPageElements.filterButton);
    }

    public void verifySearchResult() throws IOException {
        for (int i = 0; i < gg_searchPageElements.searchKeywordFromResult.size(); i++) {
            Assert.assertTrue(isElementDisplayed(gg_searchPageElements.searchTextField));
        }
    }

    public boolean getDealsToggleBtnStatus() {
        String attributeName = platformName.equalsIgnoreCase("iOS") ? "value" : "text";

        boolean switchStatus = gg_searchPageElements.dealsToggle.getAttribute(attributeName).toLowerCase(Locale.ROOT).contains("on") ? true : false;

        return switchStatus;
    }

    public void clickCancelCTA() {

        new CommonActions(driver).new ClickAction().clickElement(gg_searchPageElements.cancelCTA);

    }

    public boolean isCancelDisplayed() {
        return isElementDisplayed(gg_searchPageElements.cancelCTA);
    }

    public void clickSave() {

        new CommonActions(driver).new ClickAction().clickElement(gg_searchPageElements.clickSave);

    }

    public void verifyZeroResultsDisplayed(String zero) {
        new WaitAction(driver).waitForLoadingComplete();
        String zeroResult = "";
        zeroResult = gg_searchPageElements.resultCount.getText().trim();
        System.out.println("Zero Result..." + zeroResult);
        Assert.assertEquals(zeroResult, zero, "zero results displayed on searching invalid product");
    }

    public void verifyNoResultMessageDisplayed(String arg0) {
        new WaitAction(driver).waitForLoadingComplete();
        String defaultText1 = "";
        defaultText1 = gg_searchPageElements.noResultMessage.getText().substring(0, 36) + arg0 + "'";
        System.out.println("defaultText1--" + defaultText1);
        Assert.assertEquals(defaultText1, "Hmm… we didn’t find any results for '" + arg0 + "'");

        String defaultText2 = "";
        defaultText2 = gg_searchPageElements.noResultDefaultMessage.getText();
        System.out.println("defaultText2--" + defaultText2);
        Assert.assertEquals(defaultText2, "You can check the spelling and try again, or it could be we don’t carry this item");
    }

    public void clickOutOfStock() {

        new CommonActions(driver).new ClickAction().clickElement(gg_searchPageElements.outOfStock);
    }

    public void clickProductWithDeals() {
        new CommonActions(driver).new ClickAction().clickElement(gg_searchPageElements.productWithDeals);

    }

    public boolean isProductWithDealsSelected() {
        boolean isSelected = false;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (gg_searchPageElements.productWithDeals.isDisplayed()) {
                isSelected = true;
            }
        } else {
            if (gg_searchPageElements.productWithDeals.getAttribute("checked").equalsIgnoreCase("true")) {
                isSelected = true;
            }
        }
        return isSelected;
    }

    public boolean productWithAndWithoutDeals() {
        if (scrollDownForElement(gg_searchPageElements.productWithAndWithoutDeals)) {
            scrollDown();
            return true;
        } else {
            return false;
        }
    }

    public boolean productWithDealsDisplayed() {
        if (scrollDownForElement(gg_searchPageElements.productWithDealsDisplayed)) {
            scrollDown();
            return true;
        } else {
            return false;
        }
    }

    public void clickRefineButton() {
        new CommonActions(driver).new ClickAction().clickElement(gg_searchPageElements.refineButton);
    }

    public String savingsHeaderDisplayed() {
        return getText(gg_searchPageElements.savingsHeader);
    }

    public void clickOutOfStockItem() {
        new CommonActions(driver).new ClickAction().clickElement(gg_searchPageElements.clickOutOfStockItem);
    }

    public void clickDismiss() {
        new CommonActions(driver).new ClickAction().clickElement(gg_searchPageElements.clickDismiss);
    }

    public void clickBackBtnToClose() {
        new CommonActions(driver).new ClickAction().clickElement(gg_searchPageElements.closeBackBtn);
    }

    public void navigateBackToLandingPage() {
        gg_searchPageElements.navigateBack.click();
    }

}

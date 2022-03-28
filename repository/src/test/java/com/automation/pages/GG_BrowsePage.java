package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_BrowsePageElements;
import com.automation.pageElements.GG_DashboardPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class GG_BrowsePage extends BasePage {


    private final GG_BrowsePageElements browsePageElements = new GG_BrowsePageElements();
    private final GG_DashboardPageElements dashboardPageElements = new GG_DashboardPageElements();

    public GG_BrowsePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), browsePageElements);
    }

    public void clickBrowseTab() throws InterruptedException {
        new CommonActions(driver).new ClickAction().clickElement(browsePageElements.browseTab);
        new WaitAction(driver).waitForLoadingComplete();
        new WaitAction(driver).pleaseWaitForTheLoadingToComplete();
    }

    public boolean verifyBrowsePageTitle() {
        return isElementDisplayed(browsePageElements.browsePageTitle);
    }

    public boolean verifyBrowseCategoryTitle() {
        return isElementDisplayed(browsePageElements.browseCategoryTitle);
    }

    public void verifyAllTheCategories() {
        Assert.assertEquals(browsePageElements.browseCategoryTypeList.size() != 0, true, "Browse category list is not displayed");
    }

    public boolean verifyAllTheCategoriesAreCollapsed() {
        return browsePageElements.browseCategorySubType.size() == 0;
    }

    public boolean verifyExpandOptionForCategories() {
        return isElementDisplayed(browsePageElements.browseCategoryTypeDropDown.get(2));
    }

    public boolean verifyCollapseOptionForCategories() {
        return isElementDisplayed(browsePageElements.collapseOptionForCategories);
    }


    public boolean verifyExpandOptionForSubCategories() {
        return isElementDisplayed(browsePageElements.expandOptionForSubCategories);
    }

    public boolean verifyCollapsedOptionForSubCategories() {
        return isElementDisplayed(browsePageElements.collapseOptionForSubCategories);
    }

    public void clickOnExpandCollapseOfCategory() {
        new CommonActions(driver).new ClickAction().clickElement(browsePageElements.collapseOptionForCategories);
    }

    public void clickOnBabyCareCategoryCard() {
        new CommonActions(driver).new ClickAction().clickElement(browsePageElements.babyCareCategoryCardContainer);
    }

    public void clickOnBeveragesCategoryCard() {
        new CommonActions(driver).new ClickAction().clickElement(browsePageElements.beveragesCategoryCardContainer);
    }

    public void clickOnBabyAccessoriesSubCategoryCard() {
        new CommonActions(driver).new ClickAction().clickElement(browsePageElements.babyAccessoriesSubCategoryCard);
    }

    public void clickOnCoffeeSubCategoryCard() {
        new CommonActions(driver).new ClickAction().clickElement(browsePageElements.coffeeSubCategoryCard);
    }

    public void clickOnCoffeeGroundSubCategoryCard() {
        new CommonActions(driver).new ClickAction().clickElement(browsePageElements.coffeeGroundSubCategoryCard);
    }

    public void clickOnBottlesNursingSubCategoryCard() {
        new CommonActions(driver).new ClickAction().clickElement(browsePageElements.bottlesNursingSubCategoryCard);
    }

    public boolean isProductsListingPageDisplayed() {
        if (isElementDisplayed(browsePageElements.closeToggleIt, 4)) {
            new CommonActions(driver).new ClickAction().clickElement(browsePageElements.closeToggleIt);
        }
        return isElementDisplayed(browsePageElements.refineFilterButton, 10);
    }


    public void clickOnExpandOptionForCategories() {
//        scrollUpForElement(browsePageElements.browseCategoryType1,2);
//        waitForDisplayed(browsePageElements.browseCategoryType1);
//        new CommonActions(driver).new ClickAction().clickElement(browsePageElements.browseCategoryType1);

        if (!isElementDisplayed(browsePageElements.browseCategoryTypeDropDown.get(1))) {
            scrollUpForElement(browsePageElements.browseCategoryTypeDropDown.get(1));
        }
        new CommonActions(driver).new ClickAction().clickElement(browsePageElements.browseCategoryTypeDropDown.get(1));
    }


    public void clickOnExpandOptionForSubCategories() {
        new CommonActions(driver).new ClickAction().clickElement(browsePageElements.expandOptionForSubCategories);
    }

    public boolean verifyBrowseTabInNavigationBar() {
        return isElementDisplayed(dashboardPageElements.browseTab);
    }

    public boolean verifySearchBarIsDisplayedInBrowseTab() {
        return isElementDisplayed(browsePageElements.searchBar);
    }

    public boolean verifyScanIconIsDisplayedInBrowseTab() {
        return isElementDisplayed(browsePageElements.scanIcon);
    }

    public boolean verifyMyCartIsDisplayedInBrowseTab() {
        return isElementDisplayed(browsePageElements.myCart);
    }

    public String getCategoryTitleTextDisplayed() {
        return getText(browsePageElements.categoryTitle);
    }

    public List<String> getAllSubCategoryProductNamesForTheExpandedCategory() {
        List<String> subCategoryNames = new ArrayList<String>();
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                browsePageElements.browseCategorySubType.forEach(indCategory -> subCategoryNames.add(indCategory.getAttribute("label")));
                subCategoryNames.removeIf(indVal -> (indVal.contains("Collapsed") || indVal.contains("Expanded")));
                break;
            case "ANDROID":
                browsePageElements.browseCategorySubType.forEach(indCategory -> subCategoryNames.add(getText(indCategory)));
                break;
        }
        return subCategoryNames;
    }

    public void clickGoToDealsButton() {
        browsePageElements.goToDealsBtn.click();
    }

    public boolean isCategoriesDisplayedAlphabetical() {

        boolean isOrdered;
        List<String> eventNameList = new ArrayList<String>();
        {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                for (int i = 0; i < 4; i++)
                    scrollDown();
                eventNameList.add(browsePageElements.browseCategoryTypeList.get(1).getText());
            } else {
                for (int i = 0; i < 4; i++)
                    scrollDown();
                eventNameList.add(browsePageElements.browseCategoryTypeList.get(0).getText());
            }
        }

        isOrdered = eventNameList.stream().sorted().equals(eventNameList);

        return isOrdered;
    }

    public boolean isCategoryTitleDisplayed() {
        return isElementDisplayed(browsePageElements.browseCategoryType);
    }

    public boolean isCategoryImageDisplayed() {
        return isElementDisplayed(browsePageElements.categoryTypeImage);
    }


    //    public boolean scrollDownToCategoriesListInBrowseTab() {
//        scrollDownForElement(browsePageElements.categoryTypeImage);
//        return isElementDisplayed(browsePageElements.categoryTypeImage);
//    }
    public void scrollDownToCategoriesListInBrowseTab() {
        scrollDown();
//        scrollDownForElement(browsePageElements.categoryTypeImage);


    }

    public void clickOnRefineButton() {
        new CommonActions(driver).new ClickAction().clickElement(browsePageElements.refineFilterButton);
    }

    public boolean verifySortAndFilterPageOpened() {
        return isElementDisplayed(browsePageElements.sortAndFilter) && (driver.getPlatformName().equalsIgnoreCase("ANDROID") ? browsePageElements.sortAndFilter.getText().contains("Sort") : browsePageElements.sortAndFilter.getAttribute("label").contains("Sort"));
    }

    public void clickOnBestMatch() {
        new CommonActions(driver).new ClickAction().clickElement(browsePageElements.bestMatch);
    }

    public boolean verifySortByPageOpened() {
        return isElementDisplayed(browsePageElements.sortByPage);
    }

    public void selectClubCardSpecials() {
        new CommonActions(driver).new ClickAction().clickElement(browsePageElements.clubCardSpecials);
    }

    public void clickBackButton() {

        if (driver.getPlatformName().toUpperCase().equals("ANDROID")) {
            new CommonActions(driver).new ClickAction().clickElement(browsePageElements.backButton);

        }
    }

    public void clickSaveButton() {
        new CommonActions(driver).new ClickAction().clickElement(browsePageElements.saveButton);
    }
}

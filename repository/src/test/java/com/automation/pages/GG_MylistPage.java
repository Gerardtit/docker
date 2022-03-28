package com.automation.pages;

import com.automation.helpers.PageActions;
import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.TapAction;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_MylistPageElements;
import com.automation.rest.cache.CommonCache;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.*;
import java.util.stream.Collectors;

public class GG_MylistPage extends BasePage {


    public PageActions.SwipeActions slideActions = new PageActions(driver).new SwipeActions();

    public PageActions pageActions = new PageActions(driver);
    private final GG_MylistPageElements mylistPageElements = new GG_MylistPageElements();


    public GG_MylistPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), mylistPageElements);
    }


    public void clickMylistTab() {

        if (!isElementDisplayed(mylistPageElements.mylistTab) && isElementDisplayed(mylistPageElements.closeOfferDetailsBtn)) {
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.closeOfferDetailsBtn);
        }
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.mylistTab);

    }

    public void verifyALLoption() {
        waitVar.until(ExpectedConditions.visibilityOf(mylistPageElements.mylistAll));
    }

    public void verifyItemsoption() {
        waitVar.until(ExpectedConditions.visibilityOf(mylistPageElements.mylistItems));
    }

    public void verifyDealsoption() {
        waitVar.until(ExpectedConditions.visibilityOf(mylistPageElements.mylistDeals));
    }

    public void verifyselectedstate() {
        waitVar.until(ExpectedConditions.visibilityOf(mylistPageElements.selectedstate));
    }


    public void clickAlloption() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.mylistAll);
    }

    public void clickItemsoption() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.mylistItems);
    }

    public void clickDealsoption() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.mylistDeals);
    }


    public void verifyAddNewItemButton() {
        waitVar.until(ExpectedConditions.visibilityOf(mylistPageElements.addNewItemButton));
    }

    public String getSelectedTab() {
        new WaitAction(driver).waitForDisplayed(mylistPageElements.tabSelected, 4);
        return getText(mylistPageElements.tabSelected).split(" selected")[0].trim();
    }

    public void expandFirstCategoryDisplayedInList() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.categoryDropDown.get(0));
    }

    public Map<String, String> fetchTheCategoryNameAndTotalCountOfItemsForTheExpandedCategory() {
        //Iterate over list and fetch teh one which is expanded
        //The iterator for cat names is also iterate
        //On match fetch the cate name itr

        Map<String, String> expandedCategoryDetails = new HashMap<String, String>();
        Iterator<MobileElement> catNameIterator = mylistPageElements.categoryNamesInList.iterator();
        Iterator<MobileElement> catCountIterator = mylistPageElements.categoryTotalItemCount.iterator();
        for (MobileElement indDropDown : mylistPageElements.categoryDropDown) {
            MobileElement countValForCategory = catCountIterator.next();
            MobileElement nameOfCategory = catNameIterator.next();
            //Add case for android
            switch (driver.getPlatformName().toUpperCase()) {
                case "IOS":
                    if (indDropDown.getAttribute("label").contains("up")) {
                        // Text contains alphanumeric so getting alphabets and number
                        expandedCategoryDetails.put(getText(nameOfCategory).replaceAll("[^A-Za-z]+", ""), getText(countValForCategory).replaceAll("\\D+", ""));
                        return expandedCategoryDetails;
                    }
                    break;
                case "ANDROID":
                    expandedCategoryDetails.put(getText(mylistPageElements.expandedCategoryHeader).replaceAll("[^A-Za-z]+", ""), getText(mylistPageElements.expandedCategoryHeader).replaceAll("\\D+", ""));
                    return expandedCategoryDetails;
            }
        }
        return expandedCategoryDetails;
    }


    public List<String> getAllCategoryNamesDisplayedInList() {
        List<String> categoryNames = new ArrayList<>();
        List<String> finalCategoryNames = categoryNames;
        for (int cntVal = 0; cntVal < 3; cntVal++) {
            mylistPageElements.categoryNamesInList.stream().filter(indCatElement -> isElementDisplayed(indCatElement)).collect(Collectors.toList()).forEach(indCatName -> {
                String catName = getCategoryName(indCatName).replaceAll("[^A-Za-z]+", "");
                if (!finalCategoryNames.contains(catName)) {
                    finalCategoryNames.add(catName);
                }
            });
            scrollDownBySmallAmount();
            waitForLoaderToDisappear();
        }
        return categoryNames;
    }

    private String getCategoryName(MobileElement ele) {
        return driver.getPlatformName().equalsIgnoreCase("IOS") ? ele.getAttribute("name") : ele.getText();
    }

    public void selectItemsFromTheExpandedSubcategory(int noOfItems) {
        Iterator<MobileElement> uncheckedItemsItr = mylistPageElements.categorySelectionCheckBox.iterator();
        for (int cntVal = 0; cntVal < noOfItems; cntVal++) {
            new CommonActions(driver).new ClickAction().clickElement(uncheckedItemsItr.next());
        }
    }

    public List<String> getProductAndDealNamesFromSubCategoryByExpandingIt(String desiredCategoryName) {
        /**
         * This method will get all the product/deal names
         */
        //Expand the category if not expanded in list
        new CommonActions(driver).new TableActions().scrollDownTillCategoryIsDisplayed(mylistPageElements.categoryNamesInList, desiredCategoryName);
        expandCategoryInMyList(desiredCategoryName);
        Map.Entry<String, String> expandedCatDetails = fetchTheCategoryNameAndTotalCountOfItemsForTheExpandedCategory().entrySet().stream().findFirst().get();
        Set<String> productDealNamesInSubCategory = new HashSet<String>();
        //Scroll down till all element names are fetched for 5 scrolls , commenting as of now
        int scrollThreshold = Integer.parseInt(expandedCatDetails.getValue()) <= 3 ? 1 : (Integer.parseInt(expandedCatDetails.getValue()) / 2) + 2;
        for (int scrollCnt = 0; scrollCnt < scrollThreshold; scrollCnt++) {
            productDealNamesInSubCategory.addAll(getDealNames());
            scrollDownBySmallAmount();
        }
        return new ArrayList<String>(productDealNamesInSubCategory);
    }

    public List<String> geDealNamesFromExpandedSubCategory() {
        Set<String> productDealNamesInSubCategory = new HashSet<String>();
        productDealNamesInSubCategory.addAll(getDealNames());
        return productDealNamesInSubCategory.stream().collect(Collectors.toList());
    }

    public void verifyItemNamesInCheckedSectionAreDisplayedStrikethrough() {
    }

    public int getNoOfCheckedUncheckedItems(String checkUncheckOption) {
        String selectOption = checkUncheckOption;
        return mylistPageElements.categorySelectionCheckBox.stream().filter(indCheckBox -> indCheckBox.getAttribute("CHECKED_ATTRIBUTE").contains(selectOption)).collect(Collectors.toList()).size();
    }


    public boolean checkIfEllipsesCTAIsDisplayed() {
        return isElementDisplayed(mylistPageElements.ellipsesCTAOption);
    }

    public void clickEllipsesCTA() {
        scrollUpForElement(mylistPageElements.ellipsesCTAOption, 2);
        if (isElementDisplayed(mylistPageElements.ellipsesCTAOption, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.ellipsesCTAOption);
            waitForLoadingComplete();
        } else {
            slideActions.slideElementFromLeftToRight(mylistPageElements.categoryTab);
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.ellipsesCTAOption);
            waitForLoadingComplete();
        }
    }

    public boolean checkIfListToolsIsDisplayed() {
        return isElementDisplayed(mylistPageElements.listToolsHeaderText);
    }

    public List<String> getListToolsOptions() {
        List<String> listToolsOptnsText = new ArrayList<String>();
        new WaitAction(driver).waitForDisplayed(mylistPageElements.listToolsHeaderText, 5);
        mylistPageElements.listToolsOptions.forEach(indOptn -> listToolsOptnsText.add(getText(indOptn)));
        return listToolsOptnsText;
    }

    public void selectOptionFromListTools(String optnName) {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.listToolsOptions.stream().filter(indOptn -> getText(indOptn).equalsIgnoreCase(optnName)).collect(Collectors.toList()).get(0));
    }

    public String getTabNameSelectedOnMyListNavigationBar() {
        String tabSelected = null;
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                tabSelected = isElementDisplayed(mylistPageElements.ellipsesCTAOption) ? "List" : "";
                break;
            case "ANDROID":
                new WaitAction(driver).waitForDisplayed(mylistPageElements.myListNavBarOptions.get(0), 5);
                MobileElement desiredElement = mylistPageElements.myListNavBarOptions.stream().filter(indElement -> indElement.isSelected()).collect(Collectors.toList()).get(0);
                tabSelected = getText(desiredElement);
                break;
        }
        return tabSelected;
    }

    public boolean getVisibilityOfListToolsOptions(String optnName) {
        boolean isEnabled = false;
        new WaitAction(driver).waitForDisplayed(mylistPageElements.listToolsOptions.get(0), 5);
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                isEnabled = mylistPageElements.listToolsOptions.stream().filter(indOptn -> getText(indOptn).equalsIgnoreCase(optnName)).collect(Collectors.toList()).get(0).getAttribute("name").contains("lblTooltrue");
                break;
            case "ANDROID":
                isEnabled = mylistPageElements.listToolsOptions.stream().filter(indOptn -> getText(indOptn).equalsIgnoreCase(optnName)).collect(Collectors.toList()).get(0).isEnabled();
                break;
        }
        return isEnabled;
    }

    public void expandCategoryInMyList(String desiredCategoryName) {
        Iterator<MobileElement> catNameIterator = mylistPageElements.categoryNamesInList.iterator();
        CAT_FOUND:
        for (MobileElement indDropDown : mylistPageElements.categoryDropDown) {
            MobileElement nameOfCategory = catNameIterator.next();
            switch (driver.getPlatformName().toUpperCase()) {
                case "IOS":
                    if (desiredCategoryName.replaceAll("[^A-Za-z]+", "").contains(nameOfCategory.getAttribute("name").replaceAll("[^A-Za-z]+", "")) && indDropDown.getAttribute("label").contains("down")) {
                        new CommonActions(driver).new ClickAction().clickElement(indDropDown);
                        break CAT_FOUND;
                    }
                    break;
                case "ANDROID":
                    Iterator<MobileElement> catExpandCollapseFlag = mylistPageElements.categoryExpandCollapseFlag.iterator();
                    if (desiredCategoryName.replaceAll("[^A-Za-z]+", "").contains(getText(nameOfCategory).replaceAll("[^A-Za-z]+", "")) && catExpandCollapseFlag.next().getAttribute("content-desc").contains("Collapsed")) {
                        new CommonActions(driver).new ClickAction().clickElement(indDropDown);
                        break CAT_FOUND;
                    }
                    break;
            }
        }
    }


    private Set<String> getDealNames() {
        Set<String> productDealNamesInSubCategory = new HashSet<String>();
        mylistPageElements.dealNamesInSubCategory.stream().filter(indProductName -> indProductName.isDisplayed()).collect(Collectors.toList()).forEach(indDisplayedElement -> productDealNamesInSubCategory.add(getText(indDisplayedElement)));
        return productDealNamesInSubCategory;
    }


    public void selectAllItemsFromTheExpandedSubcategory() {
        Map.Entry<String, String> expandedCatDetails = fetchTheCategoryNameAndTotalCountOfItemsForTheExpandedCategory().entrySet().stream().findFirst().get();
        for (int cntVal = 0; cntVal < Integer.parseInt(expandedCatDetails.getValue()); cntVal++) {
            clickCategorySelectCheckBox();
        }
    }

    private void clickCategorySelectCheckBox() {
        //new WaitAction(driver).waitForDisplayed(mylistPageElements.categorySelectionCheckBox.get(0));
        try {
            Thread.sleep(4000);
            new WaitAction(driver).waitForDisplayed(mylistPageElements.categorySelectionSingleCheckBox);
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.categorySelectionSingleCheckBox);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void uncheckItemsFromList(int noOfItems) {
        for (int cntVal = 0; cntVal < noOfItems; cntVal++) {
            switch (driver.getPlatformName().toUpperCase()) {
                case "IOS":
                    scrollDownForElementWithSmallScroll(driver.findElementByAccessibilityId("btnMyListDealCellCheck"), 5);
                    new WaitAction(driver).waitForDisplayed((MobileElement) driver.findElementByAccessibilityId("btnMyListDealCellCheck"), 5);
                    new CommonActions(driver).new ClickAction().clickElement(driver.findElementByAccessibilityId("btnMyListDealCellCheck"));
                    break;
                case "ANDROID":
                    scrollDownForElementWithSmallScroll(driver.findElementByAccessibilityId("Checked"), 5);
                    new WaitAction(driver).waitForDisplayed((MobileElement) driver.findElementByAccessibilityId("Checked"), 5);
                    new CommonActions(driver).new ClickAction().clickElement(driver.findElementByAccessibilityId("Checked"));
                    break;
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void uncheckAllItemsFromTheExpandedSubcategory(int totalItemsInCheckedBasket) {
        //Map.Entry<String, String> expandedCatDetails = fetchTheCategoryNameAndTotalCountOfItemsForTheExpandedCategory().entrySet().stream().findFirst().get();
        //scrollTillExpandedCategoryIsDisplayed();
        for (int cntVal = 0; cntVal < totalItemsInCheckedBasket; cntVal++) {
            uncheckItemsFromList(1);
        }
    }

    public void collapseExpandedCategory() {
        //Iterate over list and fetch teh one which is expanded
        //The iterator for cat names is also iterate
        //On match fetch the cate name itr
        Iterator<MobileElement> catNameIterator = mylistPageElements.categorySelectionCheckBox.iterator();
        CAT_FOUND_LOOP:
        for (MobileElement indDropDown : mylistPageElements.categoryDropDown) {
            switch (driver.getPlatformName().toUpperCase()) {
                case "IOS":
                    if (indDropDown.getAttribute("label").contains("up")) {
                        new CommonActions(driver).new ClickAction().clickElement(indDropDown);
                        break CAT_FOUND_LOOP;
                    }
                    break;
                case "ANDROID":
                    scrollUpForElement(mylistPageElements.expandedDropdownBtn);
                    new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.expandedDropdownBtn);
                    break CAT_FOUND_LOOP;
            }
        }
    }

    private void scrollTillExpandedCategoryIsDisplayed() {
        scrollDownForElement(mylistPageElements.firstProductAndDealNameInSubCategory, 5);
        scrollDownBySmallAmount();
    }

    public void scrollToTopOfTheList() {
        for (int cntVal = 0; cntVal < 3; cntVal++) {
            scrollUp();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickBackButtonInListToolsPage() {
        if (isElementDisplayed(mylistPageElements.backButtonInListTools, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.backButtonInListTools);
        }
    }

    public boolean isSelectCheckBoxDisplayed() {
        return isElementDisplayed(mylistPageElements.categorySelectionSingleCheckBox);
    }

    public void clickOnDeleteCheckedItem() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.deleteCheckedItem);
    }

    public void addDealToList() {
        if (isElementDisplayed(mylistPageElements.clipCoupon, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.clipCoupon);
        }
        if (isElementDisplayed(mylistPageElements.addToListButton, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.addToListButton);
        }
    }

    public void goToListTab() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.addedToListButton);
    }

    public void clipDeal() {
        if (mylistPageElements.dealClipped.size() == 0) {
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.dealClip.get(0));
        } else {
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.dealName.get(0));
            addDealToList();
            goToListTab();
        }
    }

    public String getDealCardContent() {
        new WaitAction(driver).waitForDisplayed(mylistPageElements.dealDescriptionRelatedOffers.get(0));
        String dealName = mylistPageElements.dealDescriptionRelatedOffers.get(0).getText();
        return dealName;
    }

    public String getDealCardUnderMyList() {
        return mylistPageElements.dealsNameInMyList.getText();
    }

    public String getItemNameUnderMyList() {
        return mylistPageElements.itemInMyList.getText();
    }

    public String getRelatableOffer() {
        waitForLoaderToDisappear();
        return mylistPageElements.dealDescriptionRelatedOffers.get(0).getText();
    }

    public boolean isAddToListButtonDisplayed() {
        return isElementDisplayed(mylistPageElements.addToListButton);
    }

    public boolean isAddedToListLinkDisplayed() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.addToListButton);
        return isElementDisplayed(mylistPageElements.addedToListButton);
    }

    public void clickOnDealCardToAddList() {
        scrollDownForElement(mylistPageElements.couponClipped);
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.couponClipped);
    }

    public boolean verifyCheckedItemAreDeleted() {
        return isElementDisplayed(mylistPageElements.checkedOutCategory);
    }

    public void clickOnDeleteAllItems() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.deleteAllItem);
    }

    public boolean verifyAllItemsAreDeleted() {
        return isElementDisplayed(mylistPageElements.categoryName);
    }

    public void checkAllItems() throws InterruptedException {
        expandAllCategories();
        int counter = 0;
        while (isElementDisplayed(mylistPageElements.categoryName, 2)) {
            if (isElementDisplayed(mylistPageElements.checkOutButtonForDeals, 1)) {
                new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.checkOutButtonForDeals);
            }
            if (isElementDisplayed(mylistPageElements.checkOutButtonForItems, 1)) {
                new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.checkOutButtonForItems);
            }
            counter++;
            if (counter >= 10) {
                break;
            }
        }
    }

    public boolean verifyAllItemsAreChecked() {
        return isElementDisplayed(mylistPageElements.categoryName);
    }

    public boolean isDeleteCheckedItemDisplayed() {
        return isElementDisplayed(mylistPageElements.deleteCheckedItem);
    }

    public boolean isDeleteAllItemsDisplayed() {
        return isElementDisplayed(mylistPageElements.deleteAllItem);
    }

    public void addMultipleItemsAndDeals() {
        addAnItem(ThreadLocalHelper.testCaseData.get().get("ITEM_NAME"));
        new GG_DashboardPage(driver).clickOnDealsTab();
        new GG_DealsPage(driver).goToAllDealsTab();
        new GG_Deals_AllDealsPage(driver).clipDesiredNumberOfDeals(2);
        clickMylistTab();
        new WaitAction(driver).pleaseWaitForTheLoadingToComplete();
    }

    private List<String> getCategoryNamesDisplayedWithoutScroll() {
        List<String> categoryNames = new ArrayList<String>();
        String attributeVal = driver.getPlatformName().toUpperCase().contains("IOS") ? "name" : "text";
        mylistPageElements.categoryNamesInList.stream().filter(indCatElement -> isElementDisplayed(indCatElement, 3)).collect(Collectors.toList()).forEach(indCatName -> categoryNames.add(indCatName.getAttribute(attributeVal).split("\\(")[0].trim()));
        return categoryNames;
    }

    public void addAnItemAndDealIfEmpty() {
        if (mylistPageElements.categoryNamesInList.size() == 0) {
            addAnItem(ThreadLocalHelper.testCaseData.get().get("ITEM_NAME"));
            new GG_DashboardPage(driver).clickOnDealsTabWithLoveAppPopUpHandling();
            new GG_DealsPage(driver).scrollUpTillDealsTopNavigationBarDisplayed();
            new GG_DealsPage(driver).goToAllDealsTab();
            new GG_Deals_AllDealsPage(driver).clipDesiredNumberOfDeals(1);
            clickMylistTab();
        }
    }

    public void addAnItem(String itemName) {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.addNewItemButton);
        if (!isElementDisplayed(mylistPageElements.searchItemTextField, 5)) {
            mylistPageElements.addNewItemButton.click();
        }
        enterKey(mylistPageElements.searchItemTextField, itemName);
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.backBtnItemSearch);
        waitForLoaderToDisappear();
        scrollUp();
        if (isElementDisplayed(mylistPageElements.okBtn, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.okBtn);
        }
    }

    public void waitForLoaderToDisappear() {
        new WaitAction(driver).waitForElementToDisappear(mylistPageElements.loadingSpinner, 20);
    }

    public void clickOnEmailAppFromShareOptionsBasedOnPlatform() {
        // If there is no email service found then fail the scenario
        if (isElementDisplayed(mylistPageElements.noEmailServicePopUp, 5)) {
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.okButton);
            Assert.assertTrue(false, "No email app found on this device!!");
        }

        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                // Do nothing here since by default mail app is opened when clicked on Email list from list tools
                break;
            case "ANDROID":
                if (isElementDisplayed(mylistPageElements.gmailAppShareOption, 5)) {
                    mylistPageElements.gmailAppShareOption.click();
                } else {
                    Assert.assertTrue(false, "Gmail app is not installed on android device!!");
                }
                break;
        }
    }

    public void verifyEmailDetails(List<String> categories, List<String> items, List<String> deals) {
        setDeviceOrientationToPortrait();
        try {
            final String DISCLAIMER_TEXT = "Disclaimer:\nAdd offers to your loyalty account prior to in-store or online check-out, then redeem in the store where you regularly shop or apply to your online order.";
            scrollUpForElement(mylistPageElements.recipientAddress);

            //Verify recipient email address
            String attribute = driver.getPlatformName().equalsIgnoreCase("IOS") ? "value" : "text";
            Assert.assertTrue(mylistPageElements.recipientAddress.getAttribute(attribute).trim().contains(ThreadLocalHelper.testCaseData.get().get("SIGNUP_USERNAME")), "Recipient address in email is incorrect!!");

            // Verify subject
            String expectedSubjectName = getCurrentBanner().equalsIgnoreCase("TOMTHUMB") ? "TOM THUMB SHOPPING LIST" : String.format("%s Shopping List", getCurrentBanner()).toUpperCase();
            Assert.assertEquals(mylistPageElements.emailSubject.getAttribute(attribute).trim().toUpperCase(), expectedSubjectName, "Subject in email is incorrect!!");

            String emailBody = mylistPageElements.emailBody.getAttribute(attribute).trim();

            // Verify store name is present in email body
            Assert.assertTrue(emailBody.contains(ThreadLocalHelper.testCaseData.get().get("STORENAME_PRODUCTS")), "Store name is not present in email body!!");

            // Verify zip code is present in email body
            Assert.assertTrue(emailBody.contains(ThreadLocalHelper.testCaseData.get().get("ZIPCODE_PRODUCTS")), "Zip code is not present in email body!!");

            //Verify item names are present in email body
            items.forEach((item) -> Assert.assertTrue(emailBody.contains(item), String.format("Item %s is not present in email body", item)));

            //Verify deal names are present in email body
            deals.forEach((deal) -> Assert.assertTrue(emailBody.contains(deal.split("\\n")[0].trim()), String.format("Deal %s is not present in email body", deal)));

            //Verify disclaimer text is present in email body
            Assert.assertTrue(emailBody.contains(DISCLAIMER_TEXT), "Disclaimer is not present in email body!!");

            //Verify category names are present in email body
            categories.forEach((category) -> Assert.assertTrue(emailBody.contains(category), String.format("Category '%s' is not present in email body", category)));
        } finally {
            discardMailBasedOnPlatform();
        }
    }

    public void discardMailBasedOnPlatform() {
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.cancelMailIos);
                new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.deleteMailDraftIos);
                break;
            case "ANDROID":
                setDeviceOrientationToPortrait();
                new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.moreOptionsGmail);
                new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.discardMailGmail);
                break;
        }
    }

    public void sendMailBasedOnPlatform() {
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.sendMailIos);
                break;
            case "ANDROID":
                new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.sendMailGmail);
                break;
        }
    }

    public boolean isListToolsHeaderDisplayed() {
        return isElementDisplayed(mylistPageElements.listToolsHeader);
    }

    public boolean isListToolsBackBtnDisplayed() {
        return isElementDisplayed(mylistPageElements.backButtonInListTools);
    }

    public void deleteAllItemsFromMyListUsingListTool() {
        clickEllipsesCTA();
        if (getVisibilityOfListToolsOptions("Delete all items")) {
            selectOptionFromListTools("Delete all items");
            clickOnOkButton();
            waitForLoaderToDisappear();
        }
        clickBackButtonInListToolsPage();
    }

    public void clickOnOkButton() {
        if (isElementDisplayed(mylistPageElements.okButton, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.okButton);
        }
    }

    public void expandAllCategories() throws InterruptedException {
        int noCollapsedCategoryCounter = 0;
        int i;
        for (i = 0; i < 3; i++) {
            if (mylistPageElements.downArrowCategoryName.size() == 0) {
                noCollapsedCategoryCounter++;
            } else {
                try {
                    for (MobileElement collapsedCategory : mylistPageElements.downArrowCategoryName) {
                        new CommonActions(driver).new ClickAction().clickElement(collapsedCategory);
                        Thread.sleep(1500);
                    }
                } catch (TimeoutException te) {
                    // Do nothing
                }
            }

            if (noCollapsedCategoryCounter == 1) {
                break;
            }
            scrollDown();
        }
        scrollUpForElement(mylistPageElements.ellipsesCTAOption);
        clickOnOkButton();
    }

    public void collapseAllCategories() {
        int noExpandedCategoryCounter = 0;
        int i;
        for (i = 0; i < 10; i++) {
            if (mylistPageElements.upArrowCategoryName.size() == 0) {
                noExpandedCategoryCounter++;
            } else {
                mylistPageElements.upArrowCategoryName.forEach(expandedCategory -> new CommonActions(driver).new ClickAction().clickElement(expandedCategory));
            }

            if (noExpandedCategoryCounter == 2) {
                break;
            }
            scrollDown();
        }
        for (int j = 0; j < i; j++) {
            scrollUp();
        }
    }

    public List<String> getAllCategoryNamesWithoutScroll() {
        collapseAllCategories();
        return getCategoryNamesDisplayedWithoutScroll();
    }

    public List<String> getAllItemNamesWithoutScroll() throws InterruptedException {
        List<String> allItemNames = new ArrayList<>();
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                mylistPageElements.itemNameUnderCategory.stream().forEach(item -> allItemNames.add(item.getAttribute("label").split("\\.")[0]));
                break;
            case "ANDROID":
                mylistPageElements.itemNameUnderCategory.stream().forEach(item -> allItemNames.add(item.getText().split("\\(Qty")[0].trim()));
                break;
        }
        return allItemNames;
    }

    public void clickUncheckAllItemsFromListTools() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.uncheckAllItems);
    }

    public void clickOnUncheckAllItemsPromptMessage(String popupCTA) {
        if (popupCTA.equalsIgnoreCase("Ok")) {
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.okButtonInPromptMessage);
            new WaitAction(driver).waitForLoadingComplete();
        } else {
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.cancelButtonInPromptMessage);
        }
    }

    public boolean isOkDisplayedInPrompt() {
        return isElementDisplayed(mylistPageElements.okButtonInPromptMessage, 5);
    }

    public boolean isCancelDisplayedInPrompt() {
        return isElementDisplayed(mylistPageElements.cancelButtonInPromptMessage, 5);
    }

    public Boolean checkItemDealsIfNot() {
        scrollDownForElement(mylistPageElements.checkedInStoreBasket);
        if (!isElementDisplayed(mylistPageElements.checkedInStoreBasket)) ;
        {
            scrollUp();
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.categoriesName.get(0));
            if (isElementDisplayed(mylistPageElements.checkOutButtonForDeals)) {
                new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.checkOutButtonForDeals);
            } else {
                new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.checkOutButtonForItems);
            }
            scrollDownForElement(mylistPageElements.checkedInStoreBasket);
        }
        return isElementDisplayed(mylistPageElements.checkedInStoreBasket);
    }

    public boolean uncheckAllTheItems() {
        int count = 0;
        scrollDownForElement(mylistPageElements.checkedOutCategory);
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.checkedOutCategory);
        while ((isElementDisplayed(mylistPageElements.checkedOutCategory, 3)) && count <= 5) {
            scrollDown(1);
            if (isElementDisplayed(mylistPageElements.unCheckForItems, 2)) {
                new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.unCheckForItems);
            }
            if (isElementDisplayed(mylistPageElements.unCheckForDeals, 2)) {
                new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.unCheckForDeals);
            }
            count++;
        }
        return !isElementDisplayed(mylistPageElements.checkedOutCategory, 3);
    }

    public void clickCategoryOnMyList(String desiredCategoryName) {
        new CommonActions(driver).new TableActions().scrollDownTillCategoryIsDisplayed(mylistPageElements.categoryNamesInList, desiredCategoryName);
        expandCategoryInMyList(desiredCategoryName);
    }

    public boolean isScanBtnDisplayedInSearchPageInMyList() {
        return isElementDisplayed(mylistPageElements.scanBtnInSearchPageInMyList);
    }

    public void clickOnScanBtnInSearchPageInsideMyListScreen() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.scanBtnInSearchPageInMyList);
    }

    public boolean isScanScreenDisplayedInMyListScreen() {
        return isElementDisplayed(mylistPageElements.scanScreen);
    }

    public void clickOnCloseBtnInScanScreen() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.closeBtnInScanScreen);
    }

    public void removeItemByName(String itemName) {
        Optional<MobileElement> itemToRemove = null;
        for (int i = 0; i < 3; i++) {
            itemToRemove = mylistPageElements.itemNameUnderCategory.stream().filter(item -> getAbsoluteItemName(item).contentEquals(itemName)).findFirst();
            if (itemToRemove.isPresent()) {
                break;
            }
            scrollDown();
            waitForLoaderToDisappear();
        }

        Assert.assertTrue(itemToRemove.isPresent(), String.format("Item %s was not found in MyList", itemName));
        String itemCellXpath = driver.getPlatformName().equalsIgnoreCase("IOS") ? String.format("//*[contains(@label,\"%s.\")]/parent::XCUIElementTypeCell", itemName) : String.format("//*[@text=\"%s\"]/parent::android.view.ViewGroup", itemName);
        slideActions.slideTheCardFromRightToLeft((MobileElement) driver.findElement(By.xpath(itemCellXpath)));

        new TapAction(driver).tapCoordinate(mylistPageElements.removeItemBtn.getCenter().getX(), mylistPageElements.removeItemBtn.getCenter().getY());

        try {
            Thread.sleep(1500);
        } catch (InterruptedException ie) {
        }
    }

    public boolean isItemPresent(String itemName) throws InterruptedException {
        List<String> itemsInList = getAllItemNamesWithoutScroll();
        return itemsInList.stream().anyMatch(item -> itemsInList.contains(itemName));
    }

    public void changeItemQuantity(String itemName, int desiredQty) throws InterruptedException {
        Optional<MobileElement> itemToModify = null;
        for (int i = 0; i < 3; i++) {
            itemToModify = mylistPageElements.itemNameUnderCategory.stream().filter(item -> getAbsoluteItemName(item).contentEquals(itemName)).findFirst();
            if (itemToModify.isPresent()) {
                break;
            }
            scrollDown();
        }

        Assert.assertTrue(itemToModify.isPresent(), String.format("Item %s was not found in MyList", itemName));
        new CommonActions(driver).new ClickAction().clickElement(itemToModify.get());
        enterTextNoPressEnter(mylistPageElements.itemQuantity, String.valueOf(desiredQty));
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.backBtnItemSearch);
    }


    public boolean isItemWithDesiredQuantityPresent(String itemName, int expectedQuantity) throws InterruptedException {
        boolean itemWithQtyFound = false;
        Optional<MobileElement> itemToModify = null;
        for (int i = 0; i < 3; i++) {
            itemToModify = mylistPageElements.itemNameUnderCategory.stream().filter(item -> getAbsoluteItemName(item).contentEquals(itemName)).findFirst();
            if (itemToModify.isPresent()) {
                break;
            }
            scrollDown();
        }

        if (itemToModify.isPresent()) {
            switch (driver.getPlatformName().toUpperCase()) {
                case "IOS":
                    String itemTxt = itemToModify.get().getText();
                    itemTxt = itemTxt.contains(". unchecked") ? itemTxt.split(". unchecked")[0].trim() : itemTxt;
                    itemTxt = itemTxt.contains(". checked") ? itemTxt.split(". unchecked")[0].trim() : itemTxt;
                    itemTxt = itemTxt.contains("Quantity") ? itemTxt.split("Quantity")[1].trim() : itemTxt;
                    if (Integer.valueOf(itemTxt) == expectedQuantity) {
                        itemWithQtyFound = true;
                    }
                    break;
                case "ANDROID":
                    if (itemToModify.get().getText().contains("Qty")) {
                        if (Integer.valueOf(itemToModify.get().getText().split("Qty")[1].trim().split("\\)")[0]) == expectedQuantity) {
                            itemWithQtyFound = true;
                        }
                    } else {
                        // Qty text is not present then check if expected quantity is 0
                        if (expectedQuantity == 0) {
                            itemWithQtyFound = true;
                        }
                    }

                    break;
            }
        }
        return itemWithQtyFound;
    }

    private String getAbsoluteItemName(MobileElement item) {
        String itemNameText = null;
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                itemNameText = item.getText();
                if (itemNameText.contains(". unchecked")) {
                    itemNameText = itemNameText.split(". unchecked")[0].trim();
                } else if (itemNameText.contains(". checked")) {
                    itemNameText = itemNameText.split(". checked")[0].trim();
                }

                itemNameText = itemNameText.contains("Quantity") ? itemNameText.split("Quantity")[0].trim() : itemNameText;
                itemNameText = itemNameText.split("\\s\\d+$")[0].trim();
                break;
            case "ANDROID":
                itemNameText = item.getText().split("\\(Qty")[0].trim();
                break;
        }
        return itemNameText;
    }

    public void checkUnCheckItemByName(String itemName, String desiredStatus) throws InterruptedException {
        Optional<MobileElement> itemToCheck = null;
        for (int i = 0; i < 3; i++) {
            itemToCheck = mylistPageElements.itemNameUnderCategory.stream().filter(item -> getAbsoluteItemName(item).contentEquals(itemName)).findFirst();
            if (itemToCheck.isPresent()) {
                break;
            }
            scrollDown();
        }

        if (itemToCheck.isPresent()) {
            String itemCheckboxXpath = null;
            boolean isAlreadyChecked = false;
            switch (driver.getPlatformName().toUpperCase()) {
                case "IOS":

                    itemCheckboxXpath = String.format("//*[contains(@label,\"%s\")]/preceding-sibling::*[@name='btnMyListCategoryCellCheck']", itemName);
                    isAlreadyChecked = driver.findElement(By.xpath(itemCheckboxXpath)).getAttribute("label").contentEquals("checked") ? true : false;

                    break;
                case "ANDROID":
                    // Since Qty is part of item text in android, below condition handles the 2 possible scenarios
                    if (itemToCheck.get().getText().contains("Qty")) {
                        itemCheckboxXpath = String.format("//*[contains(@text,\"%s (Qty\")]/preceding-sibling::android.widget.CheckBox", itemName);
                    } else {
                        itemCheckboxXpath = String.format("//*[@text=\"%s\"]/preceding-sibling::android.widget.CheckBox", itemName);
                    }
                    isAlreadyChecked = driver.findElement(By.xpath(itemCheckboxXpath)).getAttribute("content-desc").contentEquals("Checked");
                    break;
            }

            switch (desiredStatus.toUpperCase()) {
                case "CHECK":
                    if (!isAlreadyChecked) {
                        new CommonActions(driver).new ClickAction().clickElement(driver.findElement(By.xpath(itemCheckboxXpath)));
                        Thread.sleep(2000);
                    }
                    break;
                case "UNCHECK":
                    if (isAlreadyChecked) {
                        new CommonActions(driver).new ClickAction().clickElement(driver.findElement(By.xpath(itemCheckboxXpath)));
                        Thread.sleep(2000);
                    }
                    break;
            }
        }
    }

    public int getCheckedInStoreBasketCount() {
        if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
            return !(scrollDownForElementWithSmallScroll(mylistPageElements.checkedInStoreBasket, 2)) ? 0 : Integer.valueOf(mylistPageElements.checkedInStoreBasket.getText().split("Basket")[1].split("\\)")[0].replaceAll("[^0-9]", ""));
        } else {
            return !(scrollDownForElementWithSmallScroll(mylistPageElements.checkedInStoreBasket, 2)) ? 0 : Integer.valueOf(mylistPageElements.checkedInStoreBasket.getText().replaceAll("[^0-9]", ""));
        }
    }

    public boolean isEmptyListMessageDispalyed() {
        return isElementDisplayed(mylistPageElements.myListNoItemsNoDealsMessage, 3);
    }

    public void slideTheDealCardToNaviagateToItemEditPage() {
        waitForLoaderToDisappear();
        slideActions.slideTheCardFromRightToLeft(mylistPageElements.itemCardListView);
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.itemsEditButton);
    }

    public boolean isRelatableOfferCTADisplayed() {
        return isElementDisplayed(mylistPageElements.relatableOffers);
    }

    public void clickOnRelatableOffers() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.relatableOffers);
    }

    public boolean isRelatableOffersPageDisplayed() {
        return isElementDisplayed(mylistPageElements.relatableOffersPage);
    }

    public void clickOnBackButtonOnRelatableOfferPage() {
        if (isElementDisplayed(mylistPageElements.relatableOffersPageBackButton, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.relatableOffersPageBackButton);
        }
    }

    public boolean isEditItemScreenDisplayed() {
        return isElementDisplayed(mylistPageElements.editItemPage);
    }

    public void clickOnBackButtonOnEditItemPage() {
        if (isElementDisplayed(mylistPageElements.editItemPageBackButton, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.editItemPageBackButton);
        }
    }

    public boolean isStoreAisleTabDisplayed() {
        return isElementDisplayed(mylistPageElements.storeAisleTab);
    }

    public void clickOnStoreAisleTab() {
        scrollUpForElement(mylistPageElements.storeAisleTab, 2);
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.storeAisleTab);
    }

    public boolean isStoreAisleTabNotDisplayed() {
        boolean isStoreAisleTabDisplayed = isElementDisplayed(mylistPageElements.storeAisleTab);
        return isStoreAisleTabDisplayed;
    }

    public boolean isCategoryTabContentsInCollapsedView() {
        return mylistPageElements.upArrowCategoryName.size() == 0;
    }

    public boolean isStoreAisleTabContentsInCollapsedView() {
        return mylistPageElements.upArrowCategoryName.size() == 0;
    }

    public boolean isCategoryTabContentsInExpandedView() {
        return mylistPageElements.downArrowCategoryName.size() == 0;
    }

    public boolean isStoreAisleTabContentsInExpandedView() {
        return mylistPageElements.upArrowCategoryName.size() > 0;
    }

    public void clickOnCategoryTab() {
        scrollUp();
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.categoryTab);
    }

    public boolean isCategoryNameNotDisplayed() {
        return mylistPageElements.categoriesName.size() == 0;
    }

    public void clickOnListTab() throws InterruptedException {
        Thread.sleep(4000);
        waitForLoaderToDisappear();
        scrollLeftThroughMyListTab("List", 2);
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.listTab);
        waitForLoaderToDisappear();
        if (!isElementDisplayed(mylistPageElements.ellipsesCTAOption, 1)) {
            scrollUp();
        }
        waitForLoadingComplete();
    }

    public boolean isNewItemsButtonIsDisplayed() {
        return isElementDisplayed(mylistPageElements.addNewItemButton);
    }

    public void clickOnNewItems() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.addNewItemButton);
    }

    public boolean isMyListSearchPageIsDisplayed() {
        return isElementDisplayed(mylistPageElements.myListSearch);
    }

    public void searchByProductName(String productName) {
        clickSearchFieldMyListPage();
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                enterTextNoPressEnter(mylistPageElements.myListSearch, productName);
                new WaitAction(driver).waitForDisplayed(mylistPageElements.searchResult.get(0), 2);
                new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.searchResult.get(0));
                break;
            case "IOS":
                enterKey(mylistPageElements.myListSearch, productName);
                break;
        }
    }

    public void searchAnItemInRelatedOffersPage(String productName) {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.relatableOffersPage);
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                enterTextNoPressEnter(mylistPageElements.relatableOffersPage, productName);
                break;
            case "IOS":
                enterKey(mylistPageElements.myListRelatableOffersSearch, productName);
                break;
        }
    }

    public void clickSearchFieldMyListPage() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.myListSearch);
    }

    public void enterTextInSearchField(String productName) throws InterruptedException {
        enterTextNoPressEnter(mylistPageElements.myListSearch, productName);
        Thread.sleep(2000);
    }

    public boolean isSearchResultDisplayedOnMyListPage() {
        return mylistPageElements.searchResult.size() != 0;
    }

    public void selectFirstItemFromSearchResult() {
        waitForLoaderToDisappear();
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.searchResult.get(0));
    }

    public boolean toastMessageText(String toastMessage) {
        boolean isToastMessageDisplayed = false;
        isToastMessageDisplayed = isElementDisplayed(mylistPageElements.toastMessage);
        return isToastMessageDisplayed;
    }

    public void clickTextClearButtonOnSearchField() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.textClearButtonOnSearchField);
    }

    public boolean isTextCleared() {
        return isElementDisplayed(mylistPageElements.myListSearch);
    }

    public void clickBackbuttonOnMyListSearchPage() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.backButtonOnMyListSearchPage);
    }

    public void clickCancelButtonOnMyListSearchPage() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.backCancelOnMyListSearchPage);
        } else {
            new TapAction(driver).tapElement(mylistPageElements.backCancelOnMyListSearchPage);
        }
    }

    public boolean isMyListHeaderDisplayed() {
        return isElementDisplayed(mylistPageElements.myListPageHeader);
    }

    public void enterTextInItemNameField(String itemName) {
        mylistPageElements.itemNameField.clear();
        enterKey(mylistPageElements.itemNameField, itemName);
    }

    public void enterInItemQuantityField(String quantity) {
        mylistPageElements.quantityField.clear();
        enterKey(mylistPageElements.quantityField, quantity);
    }

    public void clickBackButtonOnItemCardDetailsPage() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.backButtonOnItemCardDetailsPage);
    }

    public boolean myItemNameIsUpdated(String itemNameUpdated) {
        boolean myItemIsUpdated = false;
        String itemName = mylistPageElements.itemInMyList.getText().replaceAll("[0-9]", "").split("[(Qty)]")[0].trim();
        if (itemName.equals(itemNameUpdated)) {
            myItemIsUpdated = true;
        }
        return myItemIsUpdated;
    }

    public boolean myItemQuantityIsUpdated(String quantityUpdated) {
        String attributeVal = driver.getPlatformName().toLowerCase().equals("ios")?"label":"text";
        String itemQuantity = mylistPageElements.itemInMyList.getAttribute(attributeVal).split("\\.")[0].replaceAll("[^0-9]", "");
        return itemQuantity.equals(quantityUpdated);
    }

    public boolean verifyItemNameFieldIsDisplayed() {
        return isElementDisplayed(mylistPageElements.itemNameField);
    }

    public boolean verifyItemQuantityFieldIsDisplayed() {
        return isElementDisplayed(mylistPageElements.quantityField);
    }

    public boolean verifyItemTitleIsDisplayed() {
        return isElementDisplayed(mylistPageElements.itemsTitle);
    }

    public boolean verifyCategoryNameIsDisplayed() {
        return isElementDisplayed(mylistPageElements.categoryNameInEditItem);
    }

    public boolean verifyRemoveButtonIsDisplayed() {
        return isElementDisplayed(mylistPageElements.removeButtonItem);
    }

    public void clickOnCategoryName() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.categoryNameInEditItem);
    }

    public void clickOnRemoveButton() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.removeButtonItem);
    }

    public boolean isItemsDisplayedUnderCategories() {
        int i;
        for (i = 0; i < 5; i++) {
            if (!isElementDisplayed(mylistPageElements.itemInMyList, 2)) {
                new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.categoriesName.get(i));
            }
            if (i >= 2) {
                scrollDown();
            }
        }
        return isElementDisplayed(mylistPageElements.itemInMyList);
    }

    public void clickOnItemCard() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.itemInMyList);
    }

    public boolean isItemCardDetailPageDisplayed() {
        return isElementDisplayed(mylistPageElements.itemCardDetailPage);
    }

    public boolean isCategoryListPageIsDisplayed() {
        new WaitAction(driver).waitForDisplayed(mylistPageElements.categoryTitle, 5);
        return isElementDisplayed(mylistPageElements.categoryTitle);
    }

    public void selectsACategoryAndVerifyCategoryIsUpdated() {
        String beforeSelect = CommonCache.commonCache.get("CAT_NAME_SELECTED");
        String attributeVal = platformName.toUpperCase().contains("IOS") ? "label" : "text";
        CommonCache.commonCache.put("CATEGORY_SELECTED_ITEM_EDIT", mylistPageElements.categoryListInEditCategory.stream().filter(indCatOptn -> indCatOptn.isDisplayed() && !beforeSelect.contains(indCatOptn.getAttribute(attributeVal))).findFirst().get().getAttribute(attributeVal).replace("Unselected", "").trim());
        mylistPageElements.categoryListInEditCategory.stream().filter(indCatOptn -> indCatOptn.isDisplayed() && !beforeSelect.contains(indCatOptn.getAttribute(attributeVal))).findFirst().get().click();
    }

    public boolean isKeyBoardOpened() {
        boolean isKeyBoardOpened = false;
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                boolean opened = true;
                try {
                    driver.hideKeyboard();
                } catch (Exception e) {
                    opened = false;
                }
                isKeyBoardOpened = opened;
                break;
            case "IOS":
                isKeyBoardOpened = isElementDisplayed(mylistPageElements.keyBoard);
                break;
        }
        return isKeyBoardOpened;
    }


    public void selectDealOrProductFromExpandedCategory(String dealProductName) {
        Map.Entry<String, String> expandedCatDetails = fetchTheCategoryNameAndTotalCountOfItemsForTheExpandedCategory().entrySet().stream().findFirst().get();
        //Scroll down till all element names are fetched for 5 scrolls , commenting as of now
        int scrollThreshold = Integer.parseInt(expandedCatDetails.getValue()) <= 3 ? 1 : (Integer.parseInt(expandedCatDetails.getValue()) / 2) + 2;
        for (int scrollCnt = 0; scrollCnt < scrollThreshold; scrollCnt++) {
            if (checkIfDealPresentAndClickOnTheDeal(dealProductName)) {
                break;
            }
            scrollDownBySmallAmount();
        }
    }

    private boolean checkIfDealPresentAndClickOnTheDeal(String dealProductName) {
        MobileElement desiredDealElement = mylistPageElements.dealNamesInSubCategory.stream().filter(indProductName -> indProductName.isDisplayed()).collect(Collectors.toList()).stream().filter(indDealName -> getText(indDealName).contains(dealProductName)).collect(Collectors.toList()).get(0);
        if (desiredDealElement != null) {
            new CommonActions(driver).new ClickAction().clickElement(desiredDealElement);
            return true;
        }
        return false;
    }


    public boolean isDealsDisplayedUnderCategories() {
        boolean isDealDisplayed = false;
        for (int scrollCounter = 0; scrollCounter <= 5; scrollCounter++) {
            if (mylistPageElements.downArrowCategoryName.size() > 0)
                mylistPageElements.downArrowCategoryName.forEach(ele -> new CommonActions(driver).new ClickAction().clickElement(ele));
            if (isElementDisplayed(mylistPageElements.dealsInMyList, 2)) {
                isDealDisplayed = true;
                break;
            } else {
                scrollDown();
            }
        }
        return isDealDisplayed;
    }


    public boolean isProductCountDisplayed() {
        boolean isProductCountDisplayed = false;
        String count = mylistPageElements.categoriesName.get(0).getText().replace("[0-9]", "");
        if (count != null) {
            isProductCountDisplayed = true;
        }
        return isProductCountDisplayed;
    }

    public void clickOnDealCard() {
        if (!isElementDisplayed(mylistPageElements.dealsInMyList, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.categoriesName.get(0));
        }
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.dealsInMyList);
    }

    public boolean isDealCardDetailPageDisplayed() {
        return isElementDisplayed(mylistPageElements.dealCardDetailPage);
    }


    public void expandCategory() {
        waitForLoaderToDisappear();
        if (mylistPageElements.expandCategory.size() > 0) {
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.expandCategory.get(0));
        }
    }

    public void collapseCategory() {
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.collapseCategory);
                break;
            case "IOS":
                if (isElementDisplayed(mylistPageElements.collapseCategory, 2)) {
                    new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.collapseCategory);
                }
                break;
        }

    }

    public void collapseAllCategory() {
        for (int i = 0; i < 5; i++) {
            if ((isElementDisplayed(mylistPageElements.itemInMyList, 2)) || (isElementDisplayed(mylistPageElements.dealsInMyList, 2))) {
                new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.categoryName);
            }
        }
    }

    public boolean checkOutCategoriesForDeals() {
        waitForLoaderToDisappear();
        int i;
        for (i = 1; i < 4; i++) {
            if (!isElementDisplayed(mylistPageElements.checkOutButtonForDeals)) {
                new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.categoriesName.get(i));
            }
        }
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.checkOutButtonForDeals);
        scrollDownForElement(mylistPageElements.checkedOutCategory);
        waitForLoaderToDisappear();
        return isElementDisplayed(mylistPageElements.checkedOutCategory);
    }

    public void unCheckOutCategoriesForDeals() {
        scrollDownForElement(mylistPageElements.checkedOutCategory);
        if (!isElementDisplayed(mylistPageElements.unCheckForDeals)) {
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.checkedOutCategory);
        }
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.unCheckForDeals);
    }

    public boolean checkOutCategoriesForItems() {
        waitForLoaderToDisappear();
        if (!isElementDisplayed(mylistPageElements.checkOutButtonForItems)) {
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.expandCategory.get(1));
        }
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.checkOutButtonForItems);
        scrollDownForElement(mylistPageElements.checkedOutCategory);
        return isElementDisplayed(mylistPageElements.checkedOutCategory);
    }

    public void unCheckOutCategoriesForItems() {
        scrollDownForElement(mylistPageElements.checkedOutCategory);
        if (!isElementDisplayed(mylistPageElements.unCheckForItems)) {
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.checkedOutCategory);
        }
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.unCheckForItems);
    }

    public boolean areCategoriesDisplayedAlphabetical() {
        List<String> dealNameList = mylistPageElements.categoriesName.stream().map(ele -> ele.getText()).collect(Collectors.toList());
        return dealNameList.stream().sorted().collect(Collectors.toList()).equals(dealNameList);
    }

    public boolean isDealCardHeaderDisplayed() {
        int i;
        for (i = 1; i < 5; i++) {
            if (!isElementDisplayed(mylistPageElements.dealsInMyList)) {
                new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.categoriesName.get(i));
                break;
            }
        }
        return isElementDisplayed(mylistPageElements.dealsInMyList);
    }

    public boolean isDealCardOfferDisplayed() {
        return isElementDisplayed(mylistPageElements.dealCardOffer);

    }

    public boolean isDealCardImageDisplayed() {
        return isElementDisplayed(mylistPageElements.dealCardImage);
    }

    public boolean isDealCardDescriptionDisplayed() {
        return isElementDisplayed(mylistPageElements.dealCardDescription);
    }

    public Set<String> getTheCategoriesOfMyList() {
        Set<String> dealCategories = new LinkedHashSet<String>();
        for (int cntVal = 0; cntVal < 3; cntVal++) {
            //Fetching category text also gets count of deals info formatting with split
            new WaitAction(driver).waitForDisplayed(mylistPageElements.categoriesName.get(0));
            mylistPageElements.categoriesName.forEach(indCategoryName -> dealCategories.add(getText(indCategoryName).split("[0-9]")[0].split("\\(")[0].split("\\)")[0].trim()));
        }
        scrollDown();
        // Scroll till all categories are fetched
        return dealCategories;
    }

    public String getCategoryName() {
        return getText(mylistPageElements.categoriesName.get(0));
    }

    public boolean isLatestCategoryDisplayed() {
        boolean isLatestCategoryDisplayed = false;
        String categoryBeforeRefresh = getCategoryName();
        refreshScreen();
        String categoryAfterRefresh = getCategoryName();
        if (categoryAfterRefresh != categoryBeforeRefresh || categoryAfterRefresh == categoryBeforeRefresh) {
            isLatestCategoryDisplayed = true;
        }
        return isLatestCategoryDisplayed;
    }

    public boolean isCategoryNameDisplayed() {
        return mylistPageElements.categoriesName.size() > 0;
    }


    public boolean isBuyItAgainSelected() {
        boolean isSelected = false;
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                if (mylistPageElements.buyItAgainTitleMyItemsTab.getAttribute("clickable").equalsIgnoreCase("true")) {
                    isSelected = true;
                }
                break;
            case "IOS":
                if (isElementDisplayed(mylistPageElements.buyItAgainSelected, 5)) {
                    isSelected = true;
                }
                break;
        }
        return isSelected;
    }

    public boolean isMyListTabDisplayed() {
        return isElementDisplayed(mylistPageElements.myListTab);
    }

    public void verifyUserLandingByTabName(String tab) {
        switch (tab.toUpperCase()) {
            case "LIST":
                Assert.assertTrue(isElementDisplayed(mylistPageElements.ellipses, 5), "User did not land on My list tab");
                break;
            case "BUY IT AGAIN":
                Assert.assertTrue(isBuyItAgainSelected(), "User did not land on But it again tab");
                break;
            case "CLIPPED DEALS":
                Assert.assertTrue(isUserOnClippedDeals(), "User did not land on Clipped deals tab");
                break;
        }
    }

    public void verifyTabsAndTheirOrderInMyList() {
        scrollLeftThroughMyListTab("List", 2);
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.listTab);
        Assert.assertTrue(isElementDisplayed(mylistPageElements.listTab), "List tab is not displayed in MyList");
        Assert.assertTrue(isElementDisplayed(mylistPageElements.buyItAgainTitleMyItemsTab), "Buy it again tab is not displayed in MyList");
        Assert.assertTrue(isElementDisplayed(mylistPageElements.clippedDealstab), "Clipped deals tab is not displayed in MyList");
        // Verifying order of tabs by checking their x coordinate
        Assert.assertTrue(mylistPageElements.listTab.getLocation().getX() < mylistPageElements.buyItAgainTitleMyItemsTab.getLocation().getX() && mylistPageElements.buyItAgainTitleMyItemsTab.getLocation().getX() < mylistPageElements.clippedDealstab.getLocation().getX(), "Order of first 3 tabs in MyList page could not be verified");

        scrollRightThroughMyListTab("Last", 2);
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.lastOrderTab);
        Assert.assertTrue(isElementDisplayed(mylistPageElements.lastOrderTab), "Last order tab is not displayed in MyList");
        // Verifying order of tabs by checking their x coordinate
        Assert.assertTrue(mylistPageElements.clippedDealstab.getLocation().getX() < mylistPageElements.lastOrderTab.getLocation().getX(), "Order of Last order in MyList page could not be verified");
    }

    public boolean isUserOnClippedDeals() {
        return isElementDisplayed(mylistPageElements.dealsCategoryClippedDeals, 5) || isElementDisplayed(mylistPageElements.exploreDealsbtn, 2);
    }

    public void scrollRightThroughMyListTab(String tabNameDesired, int maxScrollCnt) {
        List<MobileElement> tabNamesDisplayed = null;
        ELEMENT_FOUND_LOOP:
        for (int scrollCnt = 0; scrollCnt < maxScrollCnt; scrollCnt++) {
            //Fetch all the tab names and check if the tab is displayed
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                tabNamesDisplayed = mylistPageElements.tabNames;
            } else {
                tabNamesDisplayed = driver.findElementsByXPath("//*[contains(@resource-id,'tablayout_mylist')]//android.widget.TextView");
            }
            for (MobileElement tabName : tabNamesDisplayed) {
                if (getText(tabName).contains(tabNameDesired)) {
                    break ELEMENT_FOUND_LOOP;
                }
            }
            //Scroll from  last to first element
            scroll(tabNamesDisplayed.get(tabNamesDisplayed.size() - 1).getCenter().getX(), tabNamesDisplayed.get(tabNamesDisplayed.size() - 1).getCenter().getY(), tabNamesDisplayed.get(0).getCenter().getX(), tabNamesDisplayed.get(0).getCenter().getY());
        }
    }

    public void scrollLeftThroughMyListTab(String tabNameDesired, int maxScrollCnt) {
        List<MobileElement> tabNamesDisplayed = null;
        ELEMENT_FOUND_LOOP:
        for (int scrollCnt = 0; scrollCnt < maxScrollCnt; scrollCnt++) {

            //Fetch all the tab names and check if the tab is displayed
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                tabNamesDisplayed = mylistPageElements.tabNames;
            } else {
                tabNamesDisplayed = driver.findElementsByXPath("//*[contains(@resource-id,'tablayout_mylist')]//android.widget.TextView");
            }

            for (MobileElement tabName : tabNamesDisplayed) {
                if (getText(tabName).contains(tabNameDesired)) {
                    break ELEMENT_FOUND_LOOP;
                }
            }
            //Scroll from  first to last element
            scroll(tabNamesDisplayed.get(0).getCenter().getX(), tabNamesDisplayed.get(0).getCenter().getY(), tabNamesDisplayed.get(tabNamesDisplayed.size() - 1).getCenter().getX(), tabNamesDisplayed.get(tabNamesDisplayed.size() - 1).getCenter().getY());
        }
    }


    //  Need to handle selected/unselected validation once added remaining tabs. PGG-7926
    public boolean isCategoryTabSelectedByDefault() {
        return isElementDisplayed(mylistPageElements.categoryTab);
    }

    public boolean isCategoryTabDisplayedUnderMyList() {
        return isElementDisplayed(mylistPageElements.categoryTab);
    }

    public boolean isEllipsesDisplayedUnderMyList() {
        return isElementDisplayed(mylistPageElements.ellipses);

    }

    public void slideTheCardToRemoveCategories() {
        if (isElementDisplayed(mylistPageElements.itemInMyList, 2)) {
            slideActions.slideTheCardFromRightToLeft(mylistPageElements.itemInMyList);
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.itemsRemoveButton);
        } else {
            slideActions.slideTheCardFromRightToLeft(mylistPageElements.dealsInMyList);
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.dealsRemoveButton);
        }
    }

    public boolean slideTheCardToVerifyRemoveButton() {
        boolean isRemoveButtonDisplayed = false;
        if (isElementDisplayed(mylistPageElements.itemInMyList, 2)) {
            slideActions.slideTheCardFromRightToLeft(mylistPageElements.itemInMyList);
            isRemoveButtonDisplayed = isElementDisplayed(mylistPageElements.itemsRemoveButton);
        } else {
            slideActions.slideTheCardFromRightToLeft(mylistPageElements.dealsInMyList);
            isRemoveButtonDisplayed = isElementDisplayed(mylistPageElements.dealsInMyList);
        }
        return isRemoveButtonDisplayed;
    }

    public void slideTheCardToRemoveDeals() {
        slideActions.slideTheCardFromRightToLeft(mylistPageElements.dealsInMyList);
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.dealsRemoveButton);
    }

    public void uncheckAllItemsFromMyListUsingListTool() {
        clickEllipsesCTA();
        if (getVisibilityOfListToolsOptions("Uncheck all items")) {
            selectOptionFromListTools("Uncheck all items");
            clickOnOkButton();
        }
        clickBackButtonInListToolsPage();
    }

    public boolean areDealsUnderCheckedInStoreSortedAlphabetically() {
        List<String> dealNameList = mylistPageElements.dealNamesInSubCategory.stream().map(ele -> ele.getText().toUpperCase()).collect(Collectors.toList());
        return dealNameList.stream().sorted().collect(Collectors.toList()).equals(dealNameList);
    }

    public boolean areItemsUnderCheckedInStoreSortedAlphabetically() {
        List<String> itemNameListWithoutSort = mylistPageElements.itemNameUnderCategory.stream().map(ele -> ele.getText().toUpperCase()).collect(Collectors.toList());
        return itemNameListWithoutSort.stream().sorted().collect(Collectors.toList()).equals(itemNameListWithoutSort);
    }

    public boolean verifyStoreAisleListSortedBasedOnCount() {
        boolean isOrdered;
        int categorySize = mylistPageElements.categoriesName.size();
        List<Integer> dealCount = new ArrayList<Integer>();
        for (int i = 0; i < categorySize; i++) {
            dealCount.add(Integer.valueOf(mylistPageElements.categoriesName.get(i).getText().replaceAll("[^0-9]", "")));
        }
        isOrdered = dealCount.stream().sorted().equals(dealCount);
        return isOrdered;
    }

    public void clickOnMostRecentTabUnderList() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.mostRecentTab);
    }

    public List<String> getItemsOrderInCategory() throws InterruptedException {
        List<String> itemOrder = new ArrayList<>();
        for (int i = 0; i < mylistPageElements.itemNameUnderCategory.size(); i++) {
            itemOrder.add(mylistPageElements.itemNameUnderCategory.get(i).getText());
        }
        return itemOrder;
    }

    public boolean isAisleFeedbackOptionDisplayed() {
        return isElementDisplayed(mylistPageElements.aisleFeedbackBtn);
    }

    public void clickOnAisleFeedback() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.aisleFeedbackBtn);
    }

    public boolean verifyAisleFeedbackPageIsDisplayed() {
        waitForDisplayed(mylistPageElements.aisleFeedbackList, 5);
        return isElementDisplayed(mylistPageElements.aisleFeedbackList);
    }

    public void clickOnAisleFeedback(String aisleFeedback) {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.aisleFeedbacks.stream().filter(feedback -> getText(feedback).equalsIgnoreCase(aisleFeedback)).collect(Collectors.toList()).get(0));
    }

    public boolean verifyBackButtonInAisleFeedbackPage() {
        return isElementDisplayed(mylistPageElements.aisleFeedbackBackBtn);
    }

    public boolean isNoInternetMessageDisplayed() {
        boolean isDisplayed = false;
        if (isElementDisplayed(mylistPageElements.noInternetPopMsg, 5)) {
            isDisplayed = true;
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.okBtn);
        }
        return isDisplayed;
    }

    public boolean isErrorMsgDisplayedForAisleFeedbackWithInternetOff() {
        boolean isDisplayed = false;
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                if (isElementDisplayed(mylistPageElements.errorUpdatingAisleFeedback, 5)) {
                    isDisplayed = true;
                    new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.cancelBtn);
                }
                break;
            case "ANDROID":
                if (isElementDisplayed(mylistPageElements.noInternetPopMsg, 5)) {
                    isDisplayed = true;
                    new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.okBtn);
                }
                break;
        }
        return isDisplayed;
    }

    public void clickOnMostRecentTabInMyList() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.mostRecentTab);
    }

    public boolean verifyDealsAndItemsAreListed() {
        return (mylistPageElements.dealNamesInSubCategory.size() > 0 && mylistPageElements.itemNameUnderCategory.size() > 0);
    }

    public void clipMultipleDeals() {
        for (int i = 0; i < 2; i++) {
            new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.dealClip.stream().filter(indElement -> indElement.isDisplayed()).findFirst().get());
        }
    }

    public void checkUnCheckDealByName(String dealName, String desiredStatus) throws InterruptedException {
        Optional<MobileElement> dealToCheck = null;
        for (int i = 0; i < 3; i++) {
            dealToCheck = mylistPageElements.dealNamesInSubCategory.stream().filter(deal -> driver.getPlatformName().equalsIgnoreCase("IOS") ? deal.getText().contains(dealName) : deal.getText().contentEquals(dealName)).findFirst();
            if (dealToCheck.isPresent()) {
                break;
            }
            scrollDown();
        }

        if (dealToCheck.isPresent()) {
            String dealCheckboxXpath = null;
            boolean isAlreadyChecked = false;
            switch (driver.getPlatformName().toUpperCase()) {
                case "IOS":

                    dealCheckboxXpath = String.format("//*[contains(@label,\"%s\")]/preceding-sibling::*[@name='btnMyListDealCellCheck']", dealName);
                    isAlreadyChecked = driver.findElement(By.xpath(dealCheckboxXpath)).getAttribute("label").contentEquals("checked") ? true : false;
                    break;
                case "ANDROID":
                    dealCheckboxXpath = String.format("//*[@text=\"%s\"]/preceding-sibling::android.widget.CheckBox", dealName);
                    isAlreadyChecked = driver.findElement(By.xpath(dealCheckboxXpath)).getAttribute("content-desc").contentEquals("Checked") ? true : false;

                    break;
            }

            switch (desiredStatus.toUpperCase()) {
                case "CHECK":
                    if (!isAlreadyChecked) {
                        new CommonActions(driver).new ClickAction().clickElement(driver.findElement(By.xpath(dealCheckboxXpath)));
                        Thread.sleep(2000);
                    }
                    break;
                case "UNCHECK":
                    if (isAlreadyChecked) {
                        new CommonActions(driver).new ClickAction().clickElement(driver.findElement(By.xpath(dealCheckboxXpath)));
                        Thread.sleep(2000);
                    }
                    break;
            }
        } else {
            Assert.assertTrue(false, String.format("Unable to check the deal, deal with name %s is not found in the list", dealName));
        }
    }

    public boolean isAlertDisplayed(String toolOption) {
        boolean isDisplayed = false;
        switch (toolOption.toUpperCase()) {
            case "UNCHECK ALL ITEMS":
                isDisplayed = isElementDisplayed(mylistPageElements.uncheckAllItemsAlertTitle, 5);
                break;
            case "DELETE CHECKED ITEMS":
                isDisplayed = isElementDisplayed(mylistPageElements.deleteCheckedItemsAlertTitle, 5);
                break;
            case "DELETE ALL ITEMS":
                isDisplayed = isElementDisplayed(mylistPageElements.deleteAllItemsAlertTitle, 5);
                break;
        }
        return isDisplayed;
    }

    public boolean isAlertMessageDisplayed(String toolOption) {
        boolean isDisplayed = false;
        switch (toolOption.toUpperCase()) {
            case "UNCHECK ALL ITEMS":
                isDisplayed = isElementDisplayed(mylistPageElements.uncheckAllItemsAlertMessage, 5);
                break;
            case "DELETE CHECKED ITEMS":
                isDisplayed = isElementDisplayed(mylistPageElements.deleteCheckedItemsAlertMessage, 5);
                break;
            case "DELETE ALL ITEMS":
                isDisplayed = isElementDisplayed(mylistPageElements.deleteAllItemsAlertMessage, 5);
                break;
        }
        return isDisplayed;
    }

    public GG_MylistPageElements getPageElements() {
        return mylistPageElements;
    }

    public String getCategoryNameSelected() {
        String catName = null;
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                catName = getText(mylistPageElements.categoryNameInEditItem);
                break;
            case "IOS":
                catName = mylistPageElements.categoryNameInEditItem.getAttribute("label");
                break;
        }
        return catName;
    }

    public boolean isCheckedInStoreBasketExpanded() {
        boolean isExpanded = false;
        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                isExpanded = mylistPageElements.checkedInStoreBasketExpandCollapseArrow.getAttribute("content-desc").contains("Expanded");
                break;
            case "IOS":
                isExpanded = mylistPageElements.checkedInStoreBasketExpandCollapseArrow.getAttribute("label").contains("upArrow");
                break;
        }
        return isExpanded;
    }

    public void slideTheCardToRemoveOnlyProduct() {
        slideActions.slideTheCardFromRightToLeft(mylistPageElements.productInMyList);
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.itemsRemoveButton);
    }

    public void goToClippedDealsTab() {
        new CommonActions(driver).new ClickAction().clickElement(mylistPageElements.clippedDealstab);
        waitForLoaderToDisappear();
    }

}

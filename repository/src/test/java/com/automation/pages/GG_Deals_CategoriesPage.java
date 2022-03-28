package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_Deals_CategoriesPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.*;
import java.util.stream.Collectors;

public class GG_Deals_CategoriesPage extends BasePage {
    public GG_Deals_CategoriesPageElements pageElements = new GG_Deals_CategoriesPageElements();

    public GG_Deals_CategoriesPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
    }

    public boolean isSavingEventsDisplayed() {
        return scrollDownForElement(pageElements.savingEventsLabel);
    }

    public boolean isSeeAllSavingEventsOptionDisplayed() {
        return scrollDownForElement(pageElements.seeAllSavingEventsButton);
    }

    public int getSavingEventCardsSize() {
        scrollDownForElement(pageElements.firstSavingEventCardName);
        return pageElements.allSavingEventCardNames.size();
    }

    public int getSavingEventCardDealsCountSize() {
        scrollDownForElement(pageElements.firstSavingEventCardDealCount);
        return pageElements.allSavingCardDealsCount.size();
    }

    public boolean isSavingEventCardFocusIndicatorDisplayed() {
        boolean found = false;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            scrollDownForElement(pageElements.firstSavingEventCardName);
            scrollDownBySmallAmount();
        } else {
            scrollDownForElement(pageElements.firstSavingEventCardFocusIndicator);
        }
        if (pageElements.savingEventCardFocusIndicator.size() > 0) {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                if (pageElements.savingEventCardFocusIndicator.get(0).getAttribute("visible").equalsIgnoreCase("true")) {
                    found = true;
                }
            } else {
                if (pageElements.savingEventCardFocusIndicator.get(0).getAttribute("checked").equalsIgnoreCase("true")) {
                    found = true;
                }
            }
        }
        return found;
    }

    public boolean verifySavingEventsCardFocusIndicator(int index) throws IndexOutOfBoundsException {
        boolean verified = false;
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                scrollDownForElement(pageElements.firstSavingEventCardName);
                scrollDownBySmallAmount();
                if (pageElements.savingEventCardFocusIndicator.get(index).getAttribute("visible").equalsIgnoreCase("true")) {
                    verified = true;
                }
                break;
            case "ANDROID":
                scrollDownForElement(pageElements.firstSavingEventCardFocusIndicator);
                if (pageElements.savingEventCardFocusIndicator.get(index).getAttribute("checked").equalsIgnoreCase("true")) {
                    verified = true;
                }
                break;
        }
        return verified;
    }

    public boolean isSavingEventsCardsDisplayedAlphabetical() throws InterruptedException {
        boolean isOrdered = true;
        List<String> eventNameList = new ArrayList<String>();
        TreeSet<String> sortedEventNameList = new TreeSet<String>();

        // Fetch text from 1st card
        scrollDownForElement(pageElements.firstSavingEventCardName);
        eventNameList.add(pageElements.allSavingEventCardNames.get(0).getText());
        sortedEventNameList.add(pageElements.allSavingEventCardNames.get(0).getText());

        // Fetch text from remaining cards
        for (int i = 0; i < pageElements.savingEventCardFocusIndicator.size() - 1; i++) {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                slideTheDealCardFromRightToLeft(pageElements.allSavingEventCardNames.get(1), i);
                eventNameList.add(pageElements.allSavingEventCardNames.get(1).getText());
                sortedEventNameList.add(pageElements.allSavingEventCardNames.get(1).getText());
            } else {
                slideTheDealCardFromRightToLeft(pageElements.allSavingEventCardNames.get(0), i);
                eventNameList.add(pageElements.allSavingEventCardNames.get(0).getText());
                sortedEventNameList.add(pageElements.allSavingEventCardNames.get(0).getText());
            }
        }

        Iterator it = sortedEventNameList.iterator();
        int k = 0;
        while (it.hasNext()) {
            String eventName = eventNameList.get(k);
            String sortedEventName = (String) it.next();
            if (!sortedEventName.equals(eventName)) {
                isOrdered = false;
            }
            k++;
        }
        return isOrdered;
    }

    public int getSavingEventDealFocusIndicatorCount() {
        scrollDownForElement(pageElements.firstSavingEventCardFocusIndicator);
        return pageElements.savingEventCardFocusIndicator.size();
    }

    public void slideTheDealCardFromRightToLeft(MobileElement ele, int cardNumberInList) throws InterruptedException {
        Point pt = ele.getLocation();
        int count = 0;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            while (count < 10) {
                scroll(pt.getX() + 100, pt.getY(), pt.getX() - 100, pt.getY());
                if (verifySavingEventsCardFocusIndicator(cardNumberInList + 1)) {
                    count = 10;
                    Thread.sleep(500);
                }
                count++;
            }
        } else {
            while (count < 10) {
                scroll(pt.getX() + 350, pt.getY(), pt.getX() - 150, pt.getY());
                if (verifySavingEventsCardFocusIndicator(cardNumberInList + 1)) {
                    count = 10;
                    Thread.sleep(500);
                }
                count++;
            }
        }
    }

    public void slideTheSavingEventCardFromRightToLeft() throws InterruptedException {
        int count = 0;
        Map<String, Integer> cardNameXCoordinateMap = new HashMap<>();
        if (!isElementDisplayed(pageElements.firstSavingEventCardName, 2)) {
            scrollDownForElement(pageElements.firstSavingEventCardName);
        }

        Point pt = pageElements.firstSavingEventCardName.getLocation();
        Dimension firstCardSize = pageElements.firstSavingEventCardName.getSize();
        for (MobileElement ele : pageElements.allSavingEventCardNames) {
            cardNameXCoordinateMap.put(ele.getText(), ele.getLocation().getX());
        }

        while (count < 10) {
            if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
                scroll(pt.getX() + (firstCardSize.getWidth() * 3) / 4, pt.getY(), pt.getX(), pt.getY());
            } else {
                scroll(pt.getX() + firstCardSize.getWidth(), pt.getY(), pt.getX(), pt.getY());
            }

            if (isSavingEventCardSwipedLeftSuccessfully(cardNameXCoordinateMap)) {
                count = 10;
                Thread.sleep(500);
            }
            count++;
        }

    }

    public void slideTheSavingEventCardFromLeftToRight() {
        int count = 0;
        Map<String, Integer> cardNameXCoordinateMap = new HashMap<>();
        if (!isElementDisplayed(pageElements.firstSavingEventCardName, 2)) {
            scrollDownForElement(pageElements.firstSavingEventCardName);
        }

        Point pt = pageElements.allSavingEventCardNames.get(0).getLocation();
        Dimension secondCardSize = pageElements.allSavingEventCardNames.get(1).getSize();
        for (MobileElement ele : pageElements.allSavingEventCardNames) {
            cardNameXCoordinateMap.put(ele.getText(), ele.getLocation().getX());
        }

        while (count < 10) {
            if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
                scroll(pt.getX(), pt.getY(), pt.getX() + secondCardSize.getWidth(), pt.getY());
            } else {
                scroll(pt.getX(), pt.getY(), pt.getX() + secondCardSize.getWidth(), pt.getY());
            }

            if (isSavingEventCardSwipedRightSuccessfully(cardNameXCoordinateMap)) {
                count = 10;
            }
            count++;
        }
    }

    public boolean isSavingEventCardSwipedLeftSuccessfully(Map<String, Integer> cardNameXCoordinateMap) {
        boolean isSwiped = false;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            for (MobileElement ele : pageElements.allSavingEventCardNames) {
                if (!cardNameXCoordinateMap.containsKey(ele.getText())) {
                    isSwiped = true;
                }
            }
        } else {
            for (MobileElement ele : pageElements.allSavingEventCardNames) {
                if (!cardNameXCoordinateMap.containsKey(ele.getText())) {
                    cardNameXCoordinateMap.put(ele.getText(), ele.getLocation().getX());
                }
            }

            String firstSavingCardNameAfterSwipe = pageElements.allSavingEventCardNames.get(0).getText();
            int firstSavingCardXCoordinateAfterSwipe = pageElements.allSavingEventCardNames.get(0).getLocation().getX();
            isSwiped = firstSavingCardXCoordinateAfterSwipe < cardNameXCoordinateMap.get(firstSavingCardNameAfterSwipe);
        }

        return isSwiped;
    }

    public boolean isSavingEventCardSwipedRightSuccessfully(Map<String, Integer> cardNameXCoordinateMap) {
        boolean isSwiped;
        for (MobileElement ele : pageElements.allSavingEventCardNames) {
            if (!cardNameXCoordinateMap.containsKey(ele.getText())) {
                cardNameXCoordinateMap.put(ele.getText(), ele.getLocation().getX());
            }
        }

        String firstSavingCardNameAfterSwipe = pageElements.allSavingEventCardNames.get(0).getText();
        int firstSavingCardXCoordinateAfterSwipe = pageElements.allSavingEventCardNames.get(0).getLocation().getX();
        isSwiped = firstSavingCardXCoordinateAfterSwipe > cardNameXCoordinateMap.get(firstSavingCardNameAfterSwipe);
        return isSwiped;
    }

    public boolean isYourCategoriesDisplayed() {
        scrollDownForElement(pageElements.yourCategoriesTitle);
        return isElementDisplayed(pageElements.yourCategoriesTitle);
    }

    public void scrollTillTopOfScreen() {
        scrollUpForElement(pageElements.savingEventsLabel, 6);
        scrollUp();
    }

    public boolean areDealCategoriesSortedAlphabetically() {
        // To do:: check the implementation for iOS
        List<String> categoryNameList = new ArrayList<>();
        List<MobileElement> categoryElements;
        int maxScrolls = 5;
        int scrollCounter = 1;
        while (scrollCounter < maxScrolls) {
            if (driver.getPlatformName().equalsIgnoreCase("ANDROID")) {
                categoryElements = driver.findElements(By.id("tv_my_category_name"));
            } else {
                categoryElements = driver.findElements(By.xpath("//*[contains(@name,'categoryNameLabel')]/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther"));
            }
            for (MobileElement category : categoryElements) {
                String categoryNameText = driver.getPlatformName().equalsIgnoreCase("ANDROID") ? category.getText() : category.getAttribute("name");
                if (!categoryNameList.contains(categoryNameText)) {
                    categoryNameList.add(categoryNameText);
                }
            }
            scrollCounter++;
        }
        return categoryNameList.stream().sorted().collect(Collectors.toList()).equals(categoryNameList);
    }


    public void clickOnDealCategoryItem() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.dealCategory);
    }

    public boolean isDealsCategoryDetailsPageIsDisplayed() {
        return isElementDisplayed(pageElements.dealCategoryImage, 5) && isElementDisplayed(pageElements.dealsCountDealCategoryDetail, 1);
    }

    public void isCategoryListScrollable() {
        scrollDown(2);
    }

    public void clickOnBackButtonOnDealCategoryListPage() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.dealCategoryListingPageBackButton);
    }

    public boolean isCategoryNameDisplayed() {
        return isElementDisplayed(pageElements.dealCategoryName);
    }

    public void clickSavingEventCard() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.firstSavingEventCardName);
    }

    public int getCountOfSavingEvents() {
        return Integer.valueOf(pageElements.countOfSavingEvents.getText().replaceAll("[^0-9]", ""));
    }

    public void clipDealAndVerifyInSavingEventsForNewUser() {
        // Pre-requisite: User must sign up to the application or must login with account in which no deal was clipped before
        List<MobileElement> savingEvents = pageElements.savingEventCategoryTitleList;
        new CommonActions(driver).new ClickAction().clickElement(savingEvents.get(0));
        new CommonActions(driver).new ClickAction().clickElement(pageElements.clipButton);
        Assert.assertTrue(isElementDisplayed(pageElements.couponAddedLabel), "Saving event deal was not clipped!!");
        new CommonActions(driver).new ClickAction().clickElement(pageElements.crossBtnSavingEvent);
        if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
            if (isElementDisplayed(pageElements.closeButtonSavingEventList, 2)) {
                new CommonActions(driver).new ClickAction().clickElement(pageElements.closeButtonSavingEventList);
            }
        }
    }


    public List<Map<String, String>> clipDealFromYourCategoriesAndReturnDealsData(int dealsCount) {
        String dealNameAnd = "//*[@text='Clip deal']//ancestor::*[contains(@resource-id,'btn_clip_deal_new')]//preceding-sibling::*[contains(@resource-id,'tv_deal_name')]";
        String dealDescAnd = "//*[@text='Clip deal']//ancestor::*[contains(@resource-id,'btn_clip_deal_new')]//preceding-sibling::*[contains(@resource-id,'tv_deal_desc')]";
        String dealNameiOS = "//*[contains(@label,'Clip deal')]//preceding-sibling::*[contains(@name,'lblCardMediumVerticalNameLabel')]";
        String dealDesciOS = "//*[contains(@label,'Clip deal')]//preceding-sibling::*[contains(@name,'lblCardMediumVerticalDescritionLabel')]";

        scrollDownForElement(pageElements.yourCategoriesTitle);
        scrollDownForElement(pageElements.dealCategory);
        Map<String, String> dealsMap;
        int dealsClipped = 0;
        List<String> categoriesVisited = new ArrayList<>();
        List<Map<String, String>> dealsMapList = new ArrayList<>();
        int maxScrolls = 15;
        int scrollCounter = 0;
        DEALS_LOOP:
        while (dealsClipped < dealsCount) {
            List<MobileElement> categories = pageElements.categoryNames;
            String categoryName = "";
            for (MobileElement category : categories) {
                try {
                    categoryName = driver.getPlatformName().equalsIgnoreCase("ANDROID") ? category.getText() : category.getAttribute("name");
                } catch (StaleElementReferenceException se) {
                    // Element not in dome anymore, break loop and fetch categories again
                    break;
                }
                if (categoryName != null && !categoriesVisited.contains(categoryName)) {
                    categoriesVisited.add(categoryName);
                    new CommonActions(driver).new ClickAction().clickElement(category);
                    List<MobileElement> dealNamesNotClipped;
                    List<MobileElement> dealDescriptionsNotClipped;
                    List<MobileElement> dealsNotClipped = pageElements.clipDealBtnList;
                    if (driver.getPlatformName().equalsIgnoreCase("ANDROID")) {
                        dealNamesNotClipped = driver.findElements(By.xpath(dealNameAnd));
                        dealDescriptionsNotClipped = driver.findElements(By.xpath(dealDescAnd));
                    } else {
                        dealNamesNotClipped = driver.findElements(By.xpath(dealNameiOS));
                        dealDescriptionsNotClipped = driver.findElements(By.xpath(dealDesciOS));
                    }

                    for (int i = 0; i < dealsNotClipped.size(); i++) {
                        dealsMap = new HashMap<>();
                        dealsMap.put("dealName", dealNamesNotClipped.get(i).getText());
                        dealsMap.put("dealDescription", dealDescriptionsNotClipped.get(i).getText());
                        dealsMapList.add(dealsMap);
                        new CommonActions(driver).new ClickAction().clickElement(dealsNotClipped.get(i));
                        dealsClipped++;
                        if (dealsClipped >= dealsCount) {
                            new CommonActions(driver).new ClickAction().clickElement(pageElements.dealCategoryListingPageBackButton);
                            new GG_DashboardPage(driver).handleLoveAppPopup();
                            break DEALS_LOOP;
                        }
                    }

                    new CommonActions(driver).new ClickAction().clickElement(pageElements.dealCategoryListingPageBackButton);
                    new GG_DashboardPage(driver).handleLoveAppPopup();
                }
            }
            scrollDownBySmallAmount();
            scrollCounter++;
            if (scrollCounter >= maxScrolls) {
                break DEALS_LOOP;
            }
        }

        return dealsMapList;
    }

    public void clickAllDealsTab() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.allDealsTab);
    }

    public void clickCloseButtonSavingEventListIfDisplayed() {
        if (isElementDisplayed(pageElements.closeButtonSavingEventList, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(pageElements.closeButtonSavingEventList);
        }
    }

    public void clickCloseButtondealsEventListIfDisplayed() {
        if (isElementDisplayed(pageElements.closeButtondealsEventList, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(pageElements.closeButtondealsEventList);
        }
    }

    public void clickSeeAllSavingEvent() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.seeAllSavingEvent);
    }

    public void closeSavingEventList() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.closeButtonSavingEventList);
    }

    public Set<String> getSavingEventNamesAfterClickingSeeAll() {
        Set<String> eventSet = new HashSet<>();
        int maxScrollsDown = 3;
        for (int i = 0; i < maxScrollsDown; i++) {
            pageElements.savingEventCategoryTitleList.forEach((event) -> eventSet.add(event.getText()));
            scrollDown();
        }
        return eventSet;
    }

    public void clickOnDesiredCategory(String categoryName) {
        for (int i = 0; i < 5; i++) {
            MobileElement categoryEle = getDesiredCategoryElement(categoryName);
            if (categoryEle != null) {
                if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                    new CommonActions(driver).new ClickAction().tapElementCoordinate(categoryEle);
                } else
                    categoryEle.click();
                break;
            } else {
                //Perform Scroll if no match
                scrollDown();
                new CommonActions(driver).new ClickAction().clickElement(pageElements.memberTab);
                new WaitAction(driver).waitForLoaderToDisappear();
                if (isElementDisplayed(pageElements.dismissCTA, 3)) {
                    pageElements.dismissCTA.click();
                }
                new CommonActions(driver).new ClickAction().clickElement(pageElements.dealsTab);
            }
        }
    }

    private String getCategoryName(MobileElement category) {
        String txt = driver.getPlatformName().equalsIgnoreCase("ANDROID") ? category.getText() : category.getAttribute("name");
        return txt == null ? "" : txt;
    }

    public String getDealNameSelectedFromCategories() {
        return getText(pageElements.dealName);
    }

    private MobileElement getDesiredCategoryElement(String categoryName) {
        return pageElements.categoryNamesInList.stream().filter((category) -> getCategoryName(category).replaceAll("\\s+", "").contains(categoryName.replaceAll("\\s+", ""))).collect(Collectors.toList()).stream().findFirst().get();
    }

}



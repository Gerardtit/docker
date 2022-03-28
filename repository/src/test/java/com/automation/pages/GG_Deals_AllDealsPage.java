package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_Deals_AllDealsPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class GG_Deals_AllDealsPage extends BasePage {
    public GG_Deals_AllDealsPageElements pageElements = new GG_Deals_AllDealsPageElements();

    public GG_Deals_AllDealsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
    }

    public boolean isDealDisplayed() {
        return isElementDisplayed(pageElements.firstDealExpiryLabel);
    }

    public boolean isRefineButtonDisplayed() {
        return isElementDisplayed(pageElements.refineButton);
    }

    public boolean isTotalDealsCountDisplayed() {
        return isElementDisplayed(pageElements.totalDealCount);
    }

    public void clickClipButton() {
        scrollDownForElement(pageElements.clipDealButton, 10);
        new CommonActions(driver).new ClickAction().clickElement(pageElements.clipDealButton);
    }

    public void clickOnFirstCoupon() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.firstDealExpiryLabel);
    }

    public boolean isClipButtonDisplayed() {
        return scrollDownForElement(pageElements.clipDealButton);
    }

    public void clipAndVerifyAdded() {
        scrollDownForElement(pageElements.clipDealButton);
        int viewProductsElementsSizeBefore = pageElements.viewProductsAllButtons.size();
        int clipElementsSizeBefore = pageElements.clipDealAllButtons.size();
        new CommonActions(driver).new ClickAction().clickElement(pageElements.clipDealButton);
        int viewProductsElementsSizeAfter = pageElements.viewProductsAllButtons.size();
        int clipElementsSizeAfter = pageElements.clipDealAllButtons.size();
        Assert.assertTrue(viewProductsElementsSizeAfter > viewProductsElementsSizeBefore && clipElementsSizeAfter < clipElementsSizeBefore);
    }

    public void clipDesiredNumberOfDeals(int numberOfDeals) {
        for (int dealsClipped = 0; dealsClipped < numberOfDeals; dealsClipped++) {
            scrollDownForElement(pageElements.clipDealButton);
            new CommonActions(driver).new ClickAction().clickElement(pageElements.clipDealButton);
        }
    }

    public boolean isAllDealsTabDisplayed() {
        return isElementDisplayed(pageElements.allDealsTab);
    }

    public void goToAllDealsTab() throws InterruptedException {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.allDealsTab);
        Thread.sleep(2000);
    }

    public boolean isRefineDrawerScreenDisplayed() {
        return isElementDisplayed(pageElements.refineTitle);
    }

    public void clickRefineButtonOnAllCoupon() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.refineButtonOnAllCoupon);
    }

    public boolean isFilterSelected(String filterName) {
        boolean isSelected = false;
        MobileElement ele = findElementByLabel(filterName);
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                if (ele.getAttribute("value").equals("Selected")) {
                    isSelected = true;
                }
                break;
            case "ANDROID":
                if (ele.getAttribute("checked").equals("true")) {
                    isSelected = true;
                }
                break;
        }
        return isSelected;
    }

    public void clickShowResultButton() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.showResultButton);
    }

    public boolean isShowResultButtonDisplayed() {
        return isElementDisplayed(pageElements.showResultButton, 2);
    }

    public void clickRefineDrawerCloseButton() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.refineDrawerCloseButton);
    }

    public boolean isCloseRefineDisplayed() {
        return isElementDisplayed(pageElements.refineDrawerCloseButton);
    }

    public boolean isResetButtonDisplayed() {
        return isElementDisplayed(pageElements.resetButton);
    }

    public boolean isDateExpiringSoonListedFirst() throws ParseException {
        String firstCardExpiryDate = "";
        String secondCardExpiryDate = "";
        String thirdCardExpiryDate = "";
        boolean sortByExpiringDate = false;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            firstCardExpiryDate = pageElements.allDealsExpiryLabel.get(0).getAttribute("label").split("Expires ")[1];
            scrollDown(10);
            secondCardExpiryDate = pageElements.allDealsExpiryLabel.get(0).getAttribute("label").split("Expires ")[1];
            scrollDown(10);
            thirdCardExpiryDate = pageElements.allDealsExpiryLabel.get(0).getAttribute("label").split("Expires ")[1];
        } else {
            firstCardExpiryDate = pageElements.allDealsExpiryLabel.get(0).getAttribute("text").split("Expires ")[1];
            scrollDown(10);
            secondCardExpiryDate = pageElements.allDealsExpiryLabel.get(0).getAttribute("text").split("Expires ")[1];
            scrollDown(10);
            thirdCardExpiryDate = pageElements.allDealsExpiryLabel.get(0).getAttribute("text").split("Expires ")[1];
        }

        Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(firstCardExpiryDate);
        Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse(secondCardExpiryDate);
        Date date3 = new SimpleDateFormat("MM/dd/yyyy").parse(thirdCardExpiryDate);

        if (date1.compareTo(date2) <= 0 && date2.compareTo(date3) <= 0) {
            sortByExpiringDate = true;
        }
        return sortByExpiringDate;
    }


    public boolean isNewestListedFirst() {
        boolean sortByNewest = false;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            String firstCardExpiryDate = pageElements.allDealsExpiryLabel.get(0).getAttribute("label").split("Expires ")[1];
            String[] firstCardDateParts = firstCardExpiryDate.split("/");
            int firstCardExpiryDay = Integer.parseInt(firstCardDateParts[1]);
            int firstCardExpiryMonth = Integer.parseInt(firstCardDateParts[0]);
            int firstCardExpiryYear = Integer.parseInt(firstCardDateParts[2]);
            String SecondCardExpiryDate = pageElements.allDealsExpiryLabel.get(1).getAttribute("label").split("Expires ")[1];
            String[] secondCardDateParts = SecondCardExpiryDate.split("/");
            int secondCardExpiryDay = Integer.parseInt(secondCardDateParts[1]);
            int secondCardExpiryMonth = Integer.parseInt(secondCardDateParts[0]);
            int secondCardExpiryYear = Integer.parseInt(secondCardDateParts[2]);
            if (firstCardExpiryYear >= secondCardExpiryYear) {
                if (firstCardExpiryMonth >= secondCardExpiryMonth) {
                    if (firstCardExpiryDay >= secondCardExpiryDay) {
                        sortByNewest = true;
                    }
                }

            }
        } else {
            String firstCardExpiryDate = pageElements.allDealsExpiryLabel.get(0).getAttribute("text").split("Expires ")[1];
            String[] firstCardDateParts = firstCardExpiryDate.split("/");
            int firstCardExpiryDay = Integer.parseInt(firstCardDateParts[1]);
            int firstCardExpiryMonth = Integer.parseInt(firstCardDateParts[0]);
            int firstCardExpiryYear = Integer.parseInt(firstCardDateParts[2]);
            String SecondCardExpiryDate = pageElements.allDealsExpiryLabel.get(1).getAttribute("text").split("Expires ")[1];
            String[] secondCardDateParts = SecondCardExpiryDate.split("/");
            int secondCardExpiryDay = Integer.parseInt(secondCardDateParts[1]);
            int secondCardExpiryMonth = Integer.parseInt(secondCardDateParts[0]);
            int secondCardExpiryYear = Integer.parseInt(secondCardDateParts[2]);
            if (firstCardExpiryYear >= secondCardExpiryYear) {
                if (firstCardExpiryMonth >= secondCardExpiryMonth) {
                    if (firstCardExpiryDay >= secondCardExpiryDay) {
                        sortByNewest = true;
                    }
                }

            }

        }
        return sortByNewest;
    }

    public void clickOnResetButton() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.resetButton);
    }

    public boolean isDealsCountDisplayedOnShowResultsCTA() {
        String showResultCTAText = driver.getPlatformName().equalsIgnoreCase("ios") ? pageElements.showResultButton.getAttribute("label") : pageElements.showResultButton.getAttribute("text");
        String countStr = showResultCTAText.split("Show results \\(")[1].split("\\)")[0];
        return Pattern.matches("[0-9]+", countStr);
    }

    public boolean verifyDealCardIsDisplayed() {
        return isElementDisplayed(pageElements.dealCardOnForYou);
    }

    public void selectFilterByText(String filterName) {
        findElementByLabel(filterName).click();
    }

    public boolean isFilterDisplayed(String filterName) {
        return findElementByLabel(filterName).isDisplayed();
    }

    public void scrollTillTopOfScreen() {
        scrollUpForElement(pageElements.allDealsFilter, 10);
        scrollUp();
    }

    public void clickCancelBtnDealSearch() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.cancelBtnDealSearch);
        if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
            if (isElementDisplayed(pageElements.cancelBtnDealSearch, 2)) {
                new CommonActions(driver).new ClickAction().clickElement(pageElements.cancelBtnDealSearch);
            }
        }
    }

    public boolean isDesiredDealClipped(String dealName, String dealDescription) {
        boolean isClipped = false;
        String dealCTAXpath;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            dealCTAXpath = String.format("//XCUIElementTypeStaticText[@value='%s']//following-sibling::*[@value='%s']//following-sibling::XCUIElementTypeButton", dealName, dealDescription);
        } else {
            dealCTAXpath = String.format("//*[@text='%s']//following-sibling::*[@text='%s']//following-sibling::*[contains(@resource-id,'btn_clip_deal_new')]", dealName, dealDescription);
        }

        int scrollCounter = 0;
        int maxScrolls = 5;
        while (scrollCounter < maxScrolls) {
            if (scrollDownForElement(dealCTAXpath, 20)) {
                if (driver.getPlatformName().equalsIgnoreCase("android")) {
                    if (driver.findElement(By.xpath(dealCTAXpath)).getAttribute("content-desc").contains("Added")) {
                        isClipped = true;
                    }
                } else {
                    if (driver.findElement(By.xpath(dealCTAXpath)).getText().contains("Added")) {
                        isClipped = true;
                    }
                }

                break;
            }
            scrollCounter++;
        }

        return isClipped;
    }

    public boolean isFilteredDealCountDisplayedAfterSearch() {
        return isElementDisplayed(pageElements.filteredDealsCountSearch);
    }

    public boolean isErrorMessageDisplayed() {
        boolean isDisplayed = false;
        if (driver.getPlatformName().equalsIgnoreCase("IOS")) {
            isDisplayed = isElementDisplayed(pageElements.networkProblemMsg, 5);
        } else {
            isDisplayed = isElementDisplayed(pageElements.serviceProblemMsg, 5);
        }

        if (isDisplayed) new CommonActions(driver).new ClickAction().clickElement(pageElements.okBtn);
        return isDisplayed;
    }

    public void clickOkPopUp() {
        if (isElementDisplayed(pageElements.okBtn, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(pageElements.okBtn);
        }
    }

    public void verifyIfDealsPageDisplayed() {
        Assert.assertTrue(pageElements.dealsPage.isDisplayed(), "Deals page is not displayed");
    }

    public void verifyIfAllDealsScreenSelected() {
        Assert.assertTrue(pageElements.allDeals.isSelected(), "All deals tab is not selected");
    }


}


package com.automation.pages;


import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_SelectStoreElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class GG_SelectStorePage extends BasePage {

    private GG_SelectStoreElements selectStoreElements = new GG_SelectStoreElements();

    public GG_SelectStorePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), selectStoreElements);
    }

    public void waitForMapScreenDisplayed() {

        waitVar.until(ExpectedConditions.visibilityOf(selectStoreElements.mapView));
    }

    public void VerifyStoreListsDisplayed() {

        waitVar.until(ExpectedConditions.visibilityOf(selectStoreElements.storeListsView));
    }

    public void verifyStoreSelectedButton() {

        waitVar.until(ExpectedConditions.visibilityOf(selectStoreElements.storeSelectedButton));
    }


    public void scrollStoreLists() {

        scrollDown();

        scrollTop();
    }

    public void scrollMapView() {

        scrollDown();

        scrollTop();
    }


    public void verifySelectStoreButton() {
        waitVar.until(ExpectedConditions.visibilityOf(selectStoreElements.selectStoreButton));
    }


    public void zipcodeSearchInShareLocation(String zipcode) {
        selectStoreElements.searchLocationTextFieldInShareLocation.clear();
        enterKey(selectStoreElements.searchLocationTextFieldInShareLocation, zipcode);
    }

    public void addressSearchInShareLocation(String address) {
        selectStoreElements.searchLocationTextFieldInShareLocation.clear();
        enterKey(selectStoreElements.searchLocationTextFieldInShareLocation, address);
    }

    public void zipcodeSearchInMap(String zipcode) throws InterruptedException {
        selectStoreElements.searchLocationTextFieldInMap.clear();
        enterKey(selectStoreElements.searchLocationTextFieldInMap, zipcode);
    }

    public void addressSearchInMap(String address) {
        selectStoreElements.searchLocationTextFieldInMap.clear();
        enterKey(selectStoreElements.searchLocationTextFieldInMap, address);
    }

    public void verifyStoreLocationIcon() {
        waitVar.until(ExpectedConditions.visibilityOf(selectStoreElements.storeLocationIcon));
    }


    public void VerifyStoreInfoDisplayed() {
        waitVar.until(ExpectedConditions.visibilityOf(selectStoreElements.selectStoreCard));
    }

    public void verifyLoaderDismissed() {
        waitVar.until(ExpectedConditions.invisibilityOf(selectStoreElements.loader));
    }

    public String getLocationInfo() {
        System.out.print(selectStoreElements.searchLocationTextFieldInMap.getText());
        return selectStoreElements.searchLocationTextFieldInMap.getText();
    }

    public void storeList() {
        Point pt = selectStoreElements.bottomDrawerButton.getLocation();
        scroll(pt.getX(), pt.getY(), pt.getX(), pt.getX() - 300);
    }

    public void selectStoreByIndex(int index) {
        selectStoreElements.allStoreCards.get(index).click();
    }

    public String getCurrentStoreAddress() {
        return selectStoreElements.storeAddress.getText();
    }


    public void chooseNthStoreFromStoreList(int index) {
        clickOnCurrentStore();
        storeList();
        selectStoreByIndex(index);
        clickSelectStore();
    }

    public void clickDrawerBtn() {

        new CommonActions(driver).new ClickAction().clickElement(selectStoreElements.bottomDrawerButton);
    }


    public void selectStoreUsingAddress(String address) {

        clickTextOnScreen(address);
    }

    public void clickSelectStore() {

        new CommonActions(driver).new ClickAction().clickElement(selectStoreElements.selectStoreButton);
    }


    public void clickStoreLocationIcon() {
        new CommonActions(driver).new ClickAction().clickElement(selectStoreElements.storeLocationIcon);
    }

    public void selectStorefromList() {
        new CommonActions(driver).new ClickAction().clickElement(selectStoreElements.selectStoreCard);
    }

    public void selectOtherStore() {
        new CommonActions(driver).new ClickAction().clickElement(selectStoreElements.selectOtherStoreCard.get(0));
    }

    public void clickOnCurrentStore() {
        new CommonActions(driver).new ClickAction().clickElement(selectStoreElements.storeAddress);
    }


    public boolean isStoreLogoDisplayed() {
        return isElementDisplayed(selectStoreElements.storeLogo);
    }
}

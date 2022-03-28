package com.automation.steps;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.manager.ConfigFileManager;
import com.automation.pages.GG_SelectStorePage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.util.Map;

public class GG_SelectStoreSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_SelectStorePage selectStorePage = new GG_SelectStorePage(driver);

    public String getCurrentBanner() {
        return driver.getCapabilities().getCapability("banner").toString();
    }

    public String getCurrentEnv() {
        return driver.getCapabilities().getCapability("env").toString();
    }

    @Then("^Pull the drawer from the bottom over the screen$")
    public void clickDrawerBtn() throws Throwable {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            selectStorePage.clickDrawerBtn();
        } else {
            selectStorePage.storeList();
        }
    }

    @Then("^Verify user is able to see the Map and Store Lists$")
    public void verifyMapAndStoreList() throws Throwable {

        selectStorePage.waitForMapScreenDisplayed();

        selectStorePage.VerifyStoreListsDisplayed();
    }

    @Then("^Verify User is able to see the full location lists$")
    public void verifyStoreListInfo() throws Throwable {

        selectStorePage.VerifyStoreInfoDisplayed();
    }

    @Then("^Verify User is able to scroll up and down through the list$")
    public void scrollStoreLists() throws Throwable {

        selectStorePage.scrollStoreLists();
    }

    @Then("^Select Store using Address$")
    public void selectStoreAddress() throws Throwable {

        String banner = getCurrentBanner();

        String env = getCurrentEnv();

        Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);

        String address = bannerProperty.get("STOREADDRESS");

        selectStorePage.selectStoreUsingAddress(address);
    }

    @Then("^Click on Select Store Button$")
    public void clickSelectStoreBtn() throws Throwable {

        selectStorePage.clickSelectStore();
    }

    @Then("^Verify Selected Store is still selected on Store Lists$")
    public void verifyStoreSelected() throws Throwable {
        selectStorePage.verifyStoreSelectedButton();
    }

    @Then("^verify user is in store selection screen$")
    public void verifyUserIsInStoreSelectionScreen() {
        selectStorePage.VerifyStoreListsDisplayed();
    }

    @Then("^verify Select Store button is displayed$")
    public void verifySelectStoreButtonIsDisplayed() {
        selectStorePage.verifySelectStoreButton();
    }

    @When("^search location using zipcode$")
    public void searchLocationUsingZipcode() throws IOException {

        String zipcode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE");

        selectStorePage.zipcodeSearchInShareLocation(zipcode);
//		localStorePage.zipcodeSearchInShareLocation("96766");
    }

    @Then("^verify store locations are displayed on map$")
    public void verifyStoreLocationsAreDisplayedOnMap() {
        selectStorePage.verifyStoreLocationIcon();
    }

    @When("^search location using address$")
    public void searchLocationUsingAddress() throws IOException {
        String banner = getCurrentBanner();

        String env = getCurrentEnv();

        Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);

        String address = bannerProperty.get("STOREADDRESS");

        selectStorePage.addressSearchInShareLocation(address);
    }

    @When("^tap on store location icon on map$")
    public void tapOnStoreLocationIconOnMap() {
        selectStorePage.clickStoreLocationIcon();
    }

    @Then("^verify scroll up and down on map$")
    public void verifyScrollUpAndDownOnMap() {
        selectStorePage.scrollMapView();
    }

    @Then("^Select Store from the List$")
    public void selectStoreFromTheList() throws InterruptedException {
//		localStorePage.verifyLoaderDismissed();
        Thread.sleep(3000);
        selectStorePage.selectStorefromList();
    }

    @And("^Select Other Store from the List$")
    public void selectOtherStoreFromTheList() throws InterruptedException {
//		localStorePage.verifyLoaderDismissed();
        Thread.sleep(2000);
        selectStorePage.selectOtherStore();
    }

    @When("^search location using zipcode in map$")
    public void searchLocationUsingZipcodeInMap() throws IOException, InterruptedException {

        String zipcode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE");

        selectStorePage.zipcodeSearchInMap(zipcode);
//		localStorePage.zipcodeSearchInMap("94560");
    }

    @When("^search location using address in map$")
    public void searchLocationUsingAddressInMap() throws IOException {
        String banner = getCurrentBanner();

        String env = getCurrentEnv();

        Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);

        String address = bannerProperty.get("STOREADDRESS");

        selectStorePage.addressSearchInMap(address);
//		localStorePage.addressSearchInMap("california");
    }

    @Then("^Verify location in search field$")
    public void verifyLocationInSearchField() throws IOException {
        String zipcode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE");
//		String zipcode = "96766";

        Assert.assertEquals(selectStorePage.getLocationInfo(), zipcode);

    }

    @And("^search location using zipcode with purchase history$")
    public void searchLocationUsingZipcodeWithPurchaseHistory() throws IOException {
        String banner = getCurrentBanner();

        String env = getCurrentEnv();

        Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);

        String zipcode = bannerProperty.get("ZIPCODE_DIFF");

        selectStorePage.zipcodeSearchInShareLocation(zipcode);
    }


}

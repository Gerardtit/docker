package com.automation.steps;

import java.io.IOException;
import java.util.Map;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.manager.ConfigFileManager;
import com.automation.pages.CategoryPage;
import com.automation.pages.LocalStorePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;

public class LocalStoreSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public LocalStorePage localStorePage = new LocalStorePage(driver);
    public CategoryPage categoryPage = new CategoryPage(driver);

    public String getCurrentBanner() {
        return driver.getCapabilities().getCapability("banner").toString();
    }

    public String getCurrentEnv() {
        return driver.getCapabilities().getCapability("env").toString();
    }

    @Then("^Pull the drawer from the bottom over the screen$")
    public void clickDrawerBtn() throws Throwable {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            localStorePage.clickDrawerBtn();
        } else {
            localStorePage.storeList();
        }
    }

    @Then("^Verify user is able to see the Map and Store Lists$")
    public void verifyMapAndStoreList() throws Throwable {

        localStorePage.waitForMapScreenDisplayed();

        localStorePage.VerifyStoreListsDisplayed();
    }

    @Then("^Verify User is able to see the full location lists$")
    public void verifyStoreListInfo() throws Throwable {

        localStorePage.VerifyStoreInfoDisplayed();
    }

    @Then("^Verify User is able to scroll up and down through the list$")
    public void scrollStoreLists() throws Throwable {

        localStorePage.scrollStoreLists();
    }

    @Then("^Select Store using Address$")
    public void selectStoreAddress() throws Throwable {

        String banner = getCurrentBanner();

        String env = getCurrentEnv();

        Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);

        String address = bannerProperty.get("STOREADDRESS");

        localStorePage.selectStoreUsingAddress(address);
    }

    @Then("^Click on Select Store Button$")
    public void clickSelectStoreBtn() throws Throwable {

        localStorePage.clickSelectStore();
    }

    @Then("^Verify Selected Store is still selected on Store Lists$")
    public void verifyStoreSelected() throws Throwable {
        localStorePage.verifyStoreSelectedButton();
    }

    @Then("^verify user is in store selection screen$")
    public void verifyUserIsInStoreSelectionScreen() {
        localStorePage.VerifyStoreListsDisplayed();
    }

    @Then("^verify Select Store button is displayed$")
    public void verifySelectStoreButtonIsDisplayed() {
        localStorePage.verifySelectStoreButton();
    }

    @When("^search location using zipcode$")
    public void searchLocationUsingZipcode() throws IOException {
        String zipcode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE");

        localStorePage.zipcodeSearchInShareLocation(zipcode);
//		localStorePage.zipcodeSearchInShareLocation("96766");
    }

    @Then("^verify store locations are displayed on map$")
    public void verifyStoreLocationsAreDisplayedOnMap() {
        localStorePage.verifyStoreLocationIcon();
    }

    @When("^search location using address$")
    public void searchLocationUsingAddress() throws IOException {
        String banner = getCurrentBanner();

        String env = getCurrentEnv();

        Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);

        String address = bannerProperty.get("STOREADDRESS");

        localStorePage.addressSearchInShareLocation(address);
    }

    @When("^tap on store location icon on map$")
    public void tapOnStoreLocationIconOnMap() {
        localStorePage.clickStoreLocationIcon();
    }

    @Then("^verify scroll up and down on map$")
    public void verifyScrollUpAndDownOnMap() {
        localStorePage.scrollMapView();
    }

    @Then("^Select Store from the List$")
    public void selectStoreFromTheList() throws InterruptedException {
//		localStorePage.verifyLoaderDismissed();
        Thread.sleep(3000);
        localStorePage.selectStorefromList();
    }

    @And("^Select Other Store from the List$")
    public void selectOtherStoreFromTheList() throws InterruptedException {
//		localStorePage.verifyLoaderDismissed();
        Thread.sleep(2000);
        localStorePage.selectOtherStore();
    }

    @When("^search location using zipcode in map$")
    public void searchLocationUsingZipcodeInMap() throws IOException, InterruptedException {
        String zipcode = ThreadLocalHelper.testCaseData.get().get("ZIPCODE");

        localStorePage.zipcodeSearchInMap(zipcode);
//		localStorePage.zipcodeSearchInMap("94560");
    }

    @When("^search location using address in map$")
    public void searchLocationUsingAddressInMap() throws IOException {
        String banner = getCurrentBanner();

        String env = getCurrentEnv();

        Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);

        String address = bannerProperty.get("STOREADDRESS");

        localStorePage.addressSearchInMap(address);
//		localStorePage.addressSearchInMap("california");
    }

    @Then("^Verify location in search field$")
    public void verifyLocationInSearchField() throws IOException {
        String banner = getCurrentBanner();

        String env = getCurrentEnv();

        Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);

        String zipcode = bannerProperty.get("ZIPCODE");
//		String zipcode = "96766";

        Assert.assertEquals(localStorePage.getLocationInfo(), zipcode);

    }
}

package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.GG_DashboardPage;
import com.automation.pages.GG_MyRewards_GasRewardStoresPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

/**
 * This class contains step definitions for gas reward store card list page
 */
public class GG_MyRewards_GasRewardStoresPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_MyRewards_GasRewardStoresPage gasRewardStoresPage = new GG_MyRewards_GasRewardStoresPage(driver);
    String previousFirstStoreCardAddress;
    String zipBeforeUserSharesLocation;

    public String getCurrentBanner() {
        return driver.getCapabilities().getCapability("banner").toString();
    }

    public String getCurrentEnv() {
        return driver.getCapabilities().getCapability("env").toString();
    }

    @Then("^verify maps app is opened$")
    public void verifyMapsOpened() {
        Assert.assertTrue(gasRewardStoresPage.isMapsOpened());
    }

    @And("^user shares current location$")
    public void shareLocation() {
        gasRewardStoresPage.clickOnCurrentLocationButton();
        gasRewardStoresPage.allowLocation();
        gasRewardStoresPage.clickOnCurrentLocationButton();
    }

    @Then("^verify store distance is displayed on store card$")
    public void verifyDistanceDisplayed() {
        Assert.assertTrue(gasRewardStoresPage.isStoreDistanceDisplayed());
    }

    @And("^get zip code from search field$")
    public void getZipCodeFromSearchField() {
        zipBeforeUserSharesLocation = gasRewardStoresPage.getZipCodeFromSearchField();
    }

    @Then("^verify store name and logo is displayed on store card$")
    public void verifyStoreNameLogoDisplayed() {
        Assert.assertTrue(gasRewardStoresPage.isStoreNameLogoDisplayed());
    }

    @When("^search for stores using zipcode on gas store lists section$")
    public void searchStoreUsingZipcode() throws IOException, InterruptedException {
        gasRewardStoresPage.searchStoreUsingZipcode("ZIPCODE_GAS_REWARDS");
    }

    @Then("^pin a different store on map and verify the store name/address$")
    public void pinStoreVerifyStoreNameAddress() {
        gasRewardStoresPage.pinDifferentStoreOnMap(2);
        Assert.assertTrue(gasRewardStoresPage.verifyStoreNameAddressAfterPinningDifferentStore());
        if (driver.getPlatformName().equalsIgnoreCase("iOS"))
            gasRewardStoresPage.storeListClose();
    }

    @And("^search for stores using invalid address$")
    public void searchForStoresUsingInvalidAddress() throws InterruptedException {
        gasRewardStoresPage.searchStoreUsingInvalidAddress();
    }

    @And("^search for stores using invalid zipcode$")
    public void searchForStoresUsingInvalidZipcode() {
        gasRewardStoresPage.searchStoreUsingInvalidZipcode();
    }

    @Then("^verify invalid state error message$")
    public void verifyInvalidStateErrorMessage() {
        String msg = gasRewardStoresPage.getInvalidStateErrorMessage();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Assert.assertEquals(msg, "No gas stations found within 20 miles of the location. Please use a different location");
        }
    }
//        } else {
//            Assert.assertEquals(msg, "We don't have any store close by.Please try again with a different location");
//        }
//    }

    @And("^click on clear address icon$")
    public void clickOnClearAddressIcon() {
        gasRewardStoresPage.clickOnClearAddressIcon();
    }

    @Then("^verify search bar is empty$")
    public void verifySearchBarIsEmpty() {
        Assert.assertTrue(gasRewardStoresPage.verifySearchBarIsEmpty());
    }

    @And("^search for stores using other zipcode on gas rewards section$")
    public void searchForStoresUsingOtherZipcodeOnGasRewardsSection() throws IOException, InterruptedException {
        gasRewardStoresPage.clickDrawerBtn();
        previousFirstStoreCardAddress = gasRewardStoresPage.firstStoreCardAddress();
        gasRewardStoresPage.storeListClose();
        gasRewardStoresPage.searchStoreUsingZipcode("DIFFERENT_ZIPCODE_GAS_REWARDS");
    }

    @Then("^verify updated gas stations list$")
    public void verifyUpdatedGasStationsList() {
        String currentFirstStoreCardAddress = gasRewardStoresPage.firstStoreCardAddress();
        Assert.assertFalse(previousFirstStoreCardAddress.equalsIgnoreCase(currentFirstStoreCardAddress));
    }

    @Then("^verify store location icons are displayed on map")
    public void verifyStoreLocationsDisplayedOnMap() {
        Assert.assertTrue(gasRewardStoresPage.isStoreLocationsDisplayedOnMap());
    }


    @When("^click on back button$")
    public void clickOnBackButton() {
        gasRewardStoresPage.clickOnBackButton();
        new GG_DashboardPage(AppiumDriverManager.getDriver()).handleLoveAppPopup();
        new GG_DashboardPage(AppiumDriverManager.getDriver()).clickOnCancelButtonFeedbackFormIfDisplayed();
    }

    @Then("^verify that my rewards page is displayed")
    public void verifyMyRewardsPageDisplayed() {
        new GG_DashboardPage(AppiumDriverManager.getDriver()).handleLoveAppPopup();
        gasRewardStoresPage.isMyRewardsPageDisplayed();
    }

    @Then("^click Navigation Arrow$")
    public void ClickNavigationArrow() {
        gasRewardStoresPage.clickNavigationArrow();
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            gasRewardStoresPage.clickAllowWhileUsingNotification();
        }
    }

    @And("^click Allow While Using App PopUp$")
    public void ClickAllowNotification() {
        gasRewardStoresPage.clickAllowWhileUsingNotification();
    }

    @Then("^verify Go further with Gas Reward Title$")
    public void verifyGasScreenHeader() throws InterruptedException {
        if (driver.getPlatformName().equalsIgnoreCase("iOS")) {
            Assert.assertTrue(gasRewardStoresPage.verifyGasScreenHeaderDisplayed());
        } else {
            Assert.assertFalse(gasRewardStoresPage.verifyGasScreenHeaderDisplayed());
        }
    }

    @Then("^verify current Balance is displayed$")
    public void verifyGasScreenCurrentBalance() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Assert.assertTrue(gasRewardStoresPage.verifyGasScreenCurrentBalanceDisplayed());
        }
    }

    @Then("^verify navigation to gas station screen$")
    public void verifyNavigation() {
        Assert.assertTrue(gasRewardStoresPage.isLocateMeIconDisplayed(), "Gas Station screen not displayed");
    }

    @And("^get address of first store card$")
    public void getFirstStoreCardAddress() {
        previousFirstStoreCardAddress = gasRewardStoresPage.firstStoreCardAddress();
    }

    @When("^verify stores updated after user shares location$")
    public void verifyStoresUpdatedAfterUserSharesLocation() {
        String zipAfterUserSharesLocation = gasRewardStoresPage.getZipCodeFromSearchField();
        Assert.assertNotEquals(zipAfterUserSharesLocation, zipBeforeUserSharesLocation, "Zip code in search field is not updated after user shared location");
        String storeAddressAfterUserSharesLocation = gasRewardStoresPage.firstStoreCardAddress();
        Assert.assertNotEquals(storeAddressAfterUserSharesLocation, previousFirstStoreCardAddress, "Store cards are not updated after user shared location");
    }

    @When("^click on refine Button$")
    public void clickRefineButton() throws InterruptedException {
        gasRewardStoresPage.clickRefineButton();
    }

    @Then("^verify refine screen is displayed$")
    public void verifyRefineScreenDisplayed() {
        Assert.assertEquals(gasRewardStoresPage.isRefineScreenDisplayed(), "Refine");
    }

    @Then("^click on refine close Button$")
    public void clickRefineCloseButton() {
        gasRewardStoresPage.clickRefineCloseButton();
    }

    @And("^verify store listing screen$")
    public void verifyStoreListingScreen() {
        Assert.assertTrue(gasRewardStoresPage.verifyStoreListingScreen());
    }

    @And("^verify Fuel Station Option on Refine Screen$")
    public void verifyFuelStationOption() {
        Assert.assertTrue(gasRewardStoresPage.verifyFuelStationOption());
    }

    @And("^verify All Station Participating Option on Refine Screen$")
    public void verifyAllStationParticipatingOption() {
        Assert.assertTrue(gasRewardStoresPage.verifyAllParticipationOption());
    }

    @And("^verify 'Show Result' Button$")
    public void verifyShowAllButton() {
        Assert.assertTrue(gasRewardStoresPage.verifyShowResultButton());
    }

    @Then("^verify All participating stations option is selected$")
    public void verifyAllParticipatingStationsOptionSelected() {
        Assert.assertTrue(gasRewardStoresPage.isAllParticipatingStationsOptionSelected());
    }

    @When("^select banner specific fuel station from refine filters$")
    public void selectBannerSpecificGasStations() {
        gasRewardStoresPage.selectBannerSpecficStationsFromRefineOptions();
    }

    @When("^click on reset filter$")
    public void resetRefineFilter() {
        gasRewardStoresPage.resetRefineFilter();
    }

    @And("^close the map view$")
    public void closeTheMapView() {
        gasRewardStoresPage.closeTheMapView();
    }

    @Then("^Pull the drawer from bottom over the screen$")
    public void clickDrawerBtn() {
        gasRewardStoresPage.clickDrawerBtn();
    }

    @And("^verify store card list$")
    public void verifyStoreCardList() {
        Assert.assertTrue(gasRewardStoresPage.verifyStoreCardList());
    }

    @And("^collapse the drawer$")
    public void collapseDrawer() {
        gasRewardStoresPage.storeListClose();
    }


}

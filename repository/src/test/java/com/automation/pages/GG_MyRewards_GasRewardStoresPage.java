package com.automation.pages;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_MyRewards_GasRewardStoresPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * This class contains methods that will act on gas rewards stores page
 */
public class GG_MyRewards_GasRewardStoresPage extends BasePage {

    private final GG_MyRewards_GasRewardStoresPageElements gasRewardStoresPageElements = new GG_MyRewards_GasRewardStoresPageElements();
    private final GG_MyRewardsPage myRewardsPage = new GG_MyRewardsPage(driver);


    public GG_MyRewards_GasRewardStoresPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gasRewardStoresPageElements);
    }

    /**
     * Clicks on navigation arrow button on first card
     */


    /**
     * Method to check if google maps is dislayed
     *
     * @return
     */
    public boolean isMapsOpened() {
        if (platformName.equalsIgnoreCase("android")) {
            if (isElementDisplayed(gasRewardStoresPageElements.allowCurrentLocationPermission, 5)) {

                new CommonActions(driver).new ClickAction().clickElement(gasRewardStoresPageElements.allowCurrentLocationPermission);
                if (isElementDisplayed(gasRewardStoresPageElements.updateLater, 2)) {
                    new CommonActions(driver).new ClickAction().clickElement(gasRewardStoresPageElements.updateLater);
                }
                clickNavigationArrow();
            }
            if (isElementDisplayed(gasRewardStoresPageElements.feedBackForm)) {
                new CommonActions(driver).new ClickAction().clickElement(gasRewardStoresPageElements.closeFeedbackForm);

            }
            if (isElementDisplayed(gasRewardStoresPageElements.navigationArrow)) {
                clickNavigationArrow();
            }
            if (isElementDisplayed(gasRewardStoresPageElements.skipButtonGoogleMaps)) {
                new CommonActions(driver).new ClickAction().clickElement(gasRewardStoresPageElements.skipButtonGoogleMaps);

            }
            return isElementDisplayed(gasRewardStoresPageElements.startButtonGoogleMaps);
        } else {
            return isElementDisplayed(gasRewardStoresPageElements.mapOption);
        }
    }

    /**
     * Method to allow location permission
     */

    public void allowLocation() {
        if (isElementDisplayed(gasRewardStoresPageElements.allowCurrentLocationPermission)) {
            new CommonActions(driver).new ClickAction().clickElement(gasRewardStoresPageElements.allowCurrentLocationPermission);
            waitForLoaderToDisappear();
        }
        if (isElementDisplayed(gasRewardStoresPageElements.updateLater, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(gasRewardStoresPageElements.updateLater);
        }
        if (isElementDisplayed(gasRewardStoresPageElements.feedBackForm)) {
            new CommonActions(driver).new ClickAction().clickElement(gasRewardStoresPageElements.closeFeedbackForm);

        }
    }

    /**
     * Method to verify if store distance is displayed
     */
    public boolean isStoreDistanceDisplayed() {
        waitForLoaderToDisappear();
        waitForLoadingComplete();
        return isElementDisplayed(gasRewardStoresPageElements.storeDistance.get(0)) && !gasRewardStoresPageElements.storeDistance.get(0).getText().isEmpty();

    }

    /**
     * Method to verify if store name is displayed
     */
    public Boolean isStoreNameLogoDisplayed() {
        waitForLoaderToDisappear();
        return isElementDisplayed(gasRewardStoresPageElements.storeName.get(0)) && !gasRewardStoresPageElements.storeName.get(0).getText().isEmpty() && isElementDisplayed(gasRewardStoresPageElements.storeLogo.get(0));
    }

    /**
     * Method to click on current location button
     */

    public void clickOnCurrentLocationButton() {
        new CommonActions(driver).new ClickAction().clickElement(gasRewardStoresPageElements.currentLocationButton);


    }

    /**
     * Wait for loading spinner to disappear
     */

    public void waitForLoaderToDisappear() {
        new WaitAction(driver).waitForElementToDisappear(gasRewardStoresPageElements.loadingSpinner, 25);

    }

    /**
     * Method to search for stores using zip code
     */
    public void searchStoreUsingZipcode(String arg) throws IOException, InterruptedException {
        String zipcode = ThreadLocalHelper.testCaseData.get().get(arg);
        gasRewardStoresPageElements.zipCodeCitySearchTextField.clear();
        enterKey(gasRewardStoresPageElements.zipCodeCitySearchTextField, zipcode);
        Thread.sleep(1000);
        waitForLoaderToDisappear();
        Thread.sleep(4000);
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            tapEnterAndroidKeyboard();
        }
    }

    /**
     * Pin a store by index
     *
     * @param index
     */
    public void pinDifferentStoreOnMap(int index) {
        gasRewardStoresPageElements.storeMarkersOnMap.get(index).click();
    }

    /**
     * Verify store name/address updated after pinning a different store on map
     */
    public boolean verifyStoreNameAddressAfterPinningDifferentStore() {
        boolean isStoreUpdated = false;
        waitForLoaderToDisappear();
        if (platformName.equalsIgnoreCase("android")) {
            gasRewardStoresPageElements.bottomDrawerButton.click();
        }
        String storeAddressBeforePinning = gasRewardStoresPageElements.storeAddress.get(0).getText();

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            pinDifferentStoreOnMap(gasRewardStoresPageElements.storeMarkersOnMap.size() - 1);
            storeList();
        } else {
            pinDifferentStoreOnMap(1);
        }

        PageFactory.initElements(new AppiumFieldDecorator(driver), gasRewardStoresPageElements);

        String storeNameAfterPinning = gasRewardStoresPageElements.storeName.get(0).getText();
        String storeAddressAfterPinning = gasRewardStoresPageElements.storeAddress.get(0).getText();

        if (!storeNameAfterPinning.isEmpty() && !storeAddressBeforePinning.equalsIgnoreCase(storeAddressAfterPinning)) {
            isStoreUpdated = true;
        } else {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                storeListClose();
                pinDifferentStoreOnMap(gasRewardStoresPageElements.storeMarkersOnMap.size() - 3);
                storeList();
            } else {
                pinDifferentStoreOnMap(1);
            }

            PageFactory.initElements(new AppiumFieldDecorator(driver), gasRewardStoresPageElements);
            storeNameAfterPinning = gasRewardStoresPageElements.storeName.get(1).getText();
            storeAddressAfterPinning = gasRewardStoresPageElements.storeAddress.get(1).getText();
            if (!storeNameAfterPinning.isEmpty() && !storeAddressBeforePinning.equalsIgnoreCase(storeAddressAfterPinning)) {
                isStoreUpdated = true;
            }
        }
        return isStoreUpdated;
    }

    public void searchStoreUsingInvalidAddress() {
        gasRewardStoresPageElements.zipCodeCitySearchTextField.clear();
        enterKey(gasRewardStoresPageElements.zipCodeCitySearchTextField, "IDONTEXISTONEARTH");
    }

    public void searchStoreUsingInvalidZipcode() {
        gasRewardStoresPageElements.zipCodeCitySearchTextField.clear();
        enterKey(gasRewardStoresPageElements.zipCodeCitySearchTextField, "111111111111111");
    }

    public String getInvalidStateErrorMessage() {
        String errorMsg = "";
        waitForLoaderToDisappear();

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            errorMsg = gasRewardStoresPageElements.invalidSearchErrorMessage.getText();
            new CommonActions(driver).new ClickAction().clickElement(gasRewardStoresPageElements.noGasStationsFoundPopUpOkBtn);
        } else {
            for (int i = 0; i < 5; i++) {
                try {
                    errorMsg = gasRewardStoresPageElements.invalidSearchErrorMessage.getText();
                    if (errorMsg.length() > 0) {
                        break;
                    }
                } catch (Exception e) {
                    // Try again

                }

            }

        }
        return errorMsg;
    }

    public void clickOnClearAddressIcon() {
        new CommonActions(driver).new ClickAction().clickElement(gasRewardStoresPageElements.clearAddressIcon);
    }

    public boolean verifySearchBarIsEmpty() {
        return gasRewardStoresPageElements.zipCodeCitySearchTextField.getText().equalsIgnoreCase("Enter your ZIP or City");
    }

    public String firstStoreCardAddress() {
        waitForLoaderToDisappear();

        return gasRewardStoresPageElements.storeAddress.get(0).getText();
    }

    /**
     * Method to click on back button
     */
    public void clickOnBackButton() {
        if (platformName.equalsIgnoreCase("android")) {
            if (!isElementDisplayed(gasRewardStoresPageElements.backButton, 5)) {
                driver.navigate().back();
            }
        }
        new CommonActions(driver).new ClickAction().clickElement(gasRewardStoresPageElements.backButton);
        waitForLoaderToDisappear();
    }

    /**
     * Verify store location markers are displayed on map
     */
    public boolean isStoreLocationsDisplayedOnMap() {
        return gasRewardStoresPageElements.storeMarkersOnMap.size() > 0;
    }

    /**
     * Method to check if my rewards page is displayed
     *
     * @return true if my rewards page is displayed
     */

    public void isMyRewardsPageDisplayed() {
        myRewardsPage.verifyRewardsPageTitle();
    }

    public void storeList() {
        Point pt = gasRewardStoresPageElements.bottomDrawerButton.getLocation();
        scroll(pt.getX(), pt.getY(), pt.getX(), pt.getX() - 300);
    }

    public void storeListClose() {
        Point pt = gasRewardStoresPageElements.bottomDrawerButton.getLocation();
        scroll(pt.getX(), pt.getY(), pt.getX(), pt.getY() + 300);
    }

    public boolean isLocateMeIconDisplayed() {
        return isElementDisplayed(gasRewardStoresPageElements.currentLocationButton);
    }

    public void clickNavigationArrow() {
        new CommonActions(driver).new ClickAction().clickElement(gasRewardStoresPageElements.navigationArrow);
    }

    public void clickAllowWhileUsingNotification() {
        if (isElementDisplayed(gasRewardStoresPageElements.allowCurrentLocationPermission, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(gasRewardStoresPageElements.allowCurrentLocationPermission);
        }
    }

    public boolean verifyGasScreenHeaderDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        return isElementDisplayed(gasRewardStoresPageElements.headerGasStore);
    }

    public boolean verifyGasScreenCurrentBalanceDisplayed() {

        return isElementDisplayed(gasRewardStoresPageElements.currentBalance);
    }

    public void clickRefineButton() {
        waitForLoaderToDisappear();
        new CommonActions(driver).new ClickAction().clickElement(gasRewardStoresPageElements.refineButton);
    }

    public void clickRefineCloseButton() {

        new CommonActions(driver).new ClickAction().clickElement(gasRewardStoresPageElements.refineCloseButton);
    }

    public boolean verifyStoreListingScreen() {
        return isElementDisplayed(gasRewardStoresPageElements.refineButton);
    }

    public boolean verifyFuelStationOption() {
        return isElementDisplayed(gasRewardStoresPageElements.bannerSpecificFuelStations);
    }

    public boolean verifyAllParticipationOption() {
        return isElementDisplayed(gasRewardStoresPageElements.allParticipatingFuelStations);
    }

    public boolean verifyShowResultButton() {
        return isElementDisplayed(gasRewardStoresPageElements.showResultButton);
    }

    public String isRefineScreenDisplayed() {
        String refineTxt = (gasRewardStoresPageElements.refineHeader).getText();
        return refineTxt;
    }

    public boolean isAllParticipatingStationsOptionSelected() {
        boolean isSelected = false;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (gasRewardStoresPageElements.allParticipatingFuelStations.getAttribute("value").equalsIgnoreCase("selected")) {
                isSelected = true;
            } else {
                gasRewardStoresPageElements.allParticipatingFuelStations.getAttribute("value").equalsIgnoreCase("enabled");
                isSelected = true;
            }
        } else {
            if (gasRewardStoresPageElements.allParticipatingFuelStations.isSelected() == true && gasRewardStoresPageElements.allParticipatingFuelStations.getAttribute("text").equals("All participating stations")) {
                isSelected = true;
            } else {
                gasRewardStoresPageElements.allParticipatingFuelStations.getAttribute("checked").equalsIgnoreCase("true");
                isSelected = true;

            }
        }
        return isSelected;
    }


    public void selectBannerSpecficStationsFromRefineOptions() {
        new CommonActions(driver).new ClickAction().clickElement(gasRewardStoresPageElements.bannerSpecificFuelStations);
    }

    public void resetRefineFilter() {
        new CommonActions(driver).new ClickAction().clickElement(gasRewardStoresPageElements.resetButton);

    }

    public String getZipCodeFromSearchField() {
        String zip = "";
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            zip = gasRewardStoresPageElements.zipCodeCitySearchTextField.getAttribute("value");
        } else {
            isElementDisplayed(gasRewardStoresPageElements.zipCodeCitySearchTextField, 5);
            zip = gasRewardStoresPageElements.zipCodeCitySearchTextField.getText();
        }
        return zip;
    }

    public void closeTheMapView() {
        new CommonActions(driver).new ClickAction().clickElement(gasRewardStoresPageElements.mapOptionCancel);
    }

    public void clickDrawerBtn() {

        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new CommonActions(driver).new ClickAction().clickElement(gasRewardStoresPageElements.bottomDrawerButton);
        } else {

            storeList();
        }
    }

    public boolean verifyStoreCardList() {
        waitForLoaderToDisappear();
        return isElementDisplayed(gasRewardStoresPageElements.storeAddress.get(0));
    }

}


package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_BarCodeScanPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GG_BarCodeScanPage extends BasePage {

    private GG_BarCodeScanPageElements barCodeScanElements = new GG_BarCodeScanPageElements();

    public GG_BarCodeScanPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), barCodeScanElements);
    }

    public void clickScanSetting() {
        new CommonActions(driver).new ClickAction().clickElement(barCodeScanElements.scanSetting);
    }

    public boolean verifyScanSettingOption() {
        return isElementDisplayed(barCodeScanElements.scanSetting);
    }

    public boolean verifyUserIsInScanSettingPage() {
        return isElementDisplayed(barCodeScanElements.toggleTitle);
    }

    public void clickToggleToONState() {
        new CommonActions(driver).new ClickAction().clickElement(barCodeScanElements.toggleOFFState);
    }

    public boolean verifyToggleSettingIsONState() {
        return isElementDisplayed(barCodeScanElements.toggleONState);
    }

    public void clickToggleToOFFState() {
        new CommonActions(driver).new ClickAction().clickElement(barCodeScanElements.toggleONState);
    }

    public boolean verifyToggleSettingIsOFFState() {
        return isElementDisplayed(barCodeScanElements.toggleOFFState);
    }

    public boolean verifyThatBarcodeScanOption() {
        return isElementDisplayed(barCodeScanElements.barcodeScanOptionOnSearch);
    }

    public void clickOnBarcodeScanOption() {
        new CommonActions(driver).new ClickAction().clickElement(barCodeScanElements.barcodeScanOptionOnSearch);
    }

    public void clickAllowOnCameraPermissionPopup() {
        if (isElementDisplayed(barCodeScanElements.cameraPermissionAllow, 5)) {
            barCodeScanElements.cameraPermissionAllow.click();
        }
    }

    public boolean userIsAllowToScan() {
        return isElementDisplayed(barCodeScanElements.scanSection);
    }

    public void clickCloseIconOnScanScreen() {
        new CommonActions(driver).new ClickAction().clickElement(barCodeScanElements.closeIcon);
    }

    public void clickGetStartedOnTutorials() {
        if (isElementDisplayed(barCodeScanElements.updateLaterOnBarCodeScanScreen)) {
            new CommonActions(driver).new ClickAction().clickElement(barCodeScanElements.updateLaterOnBarCodeScanScreen);
        }
        if (isElementDisplayed(barCodeScanElements.getStarted, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(barCodeScanElements.getStarted);
        }
        if (isElementDisplayed(barCodeScanElements.feedBackForm, 4)) {
            new CommonActions(driver).new ClickAction().clickElement(barCodeScanElements.closeFeedbackForm);
            if (isElementDisplayed(barCodeScanElements.updateLaterOnBarCodeScanScreen, 2)) {
                new CommonActions(driver).new ClickAction().clickElement(barCodeScanElements.updateLaterOnBarCodeScanScreen);
            }
            if (isElementDisplayed(barCodeScanElements.getStarted)) {
                new CommonActions(driver).new ClickAction().clickElement(barCodeScanElements.getStarted);
            }
        }

    }

    public boolean verifyFlashOptionIsDisplayed() {
        return isElementDisplayed(barCodeScanElements.flash);
    }

    public void clickOnFlash() {
        new CommonActions(driver).new ClickAction().clickElement(barCodeScanElements.flash);
    }

    public boolean verifyFlashStatusAsOFF() {
        return isElementDisplayed(barCodeScanElements.flashStatusOFF, 5) || !isElementDisplayed(barCodeScanElements.flashStatusON, 1);
    }

    public boolean verifyToggleButton() {
        return isElementDisplayed(barCodeScanElements.toggleButton);
    }

    public boolean verifyDealsOptionPresentOnToggleButton() {
        return isElementDisplayed(barCodeScanElements.dealsOption);
    }

    public boolean verifyProductOptionPresentOnToggleButton() {
        return isElementDisplayed(barCodeScanElements.productOption);
    }

    public boolean verifyTextView() {
        return isElementDisplayed(barCodeScanElements.verifyTextView);
    }

    public boolean verifyCancelButton() {
        return isElementDisplayed(barCodeScanElements.cancelButton);
    }

    public boolean verifyDealsOptionSelected() {
        boolean isSelected = false;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            if (barCodeScanElements.dealsOption.getAttribute("selected").equalsIgnoreCase("true")) {
                isSelected = true;
            }
        } else {
            if (barCodeScanElements.dealsOption.getAttribute("value").contains("Deals")) {
                isSelected = true;
            }
        }
        return isSelected;
    }

    public boolean verifyProductOptionSelected() {
        boolean isSelected = false;
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            if (barCodeScanElements.productOption.getAttribute("selected").equalsIgnoreCase("true")) {
                isSelected = true;
            }
        } else {
            if (barCodeScanElements.productOption.getAttribute("value").contains("Products")) {
                isSelected = true;
            }
        }
        return isSelected;
    }

    public void toggleDealsToProduct() {
        new CommonActions(driver).new ClickAction().clickElement(barCodeScanElements.productOption);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            try {
                if (!barCodeScanElements.productOption.getAttribute("value").trim().equalsIgnoreCase("1")) {
                    new CommonActions(driver).new ClickAction().clickElement(barCodeScanElements.productOption);
                }
            } catch (NullPointerException ne) {
                new CommonActions(driver).new ClickAction().clickElement(barCodeScanElements.productOption);
            }
        }
    }

    public void toggleProductToDeals() {
        new CommonActions(driver).new ClickAction().clickElement(barCodeScanElements.dealsOption);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            try {
                if (!barCodeScanElements.dealsOption.getAttribute("value").trim().equalsIgnoreCase("1")) {
                    new CommonActions(driver).new ClickAction().clickElement(barCodeScanElements.dealsOption);
                }
            } catch (NullPointerException ne) {
                new CommonActions(driver).new ClickAction().clickElement(barCodeScanElements.dealsOption);
            }
        }
    }

    public void isScanToShopDisplayed() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Assert.assertTrue(barCodeScanElements.scanToShopTitle.getAttribute("label").equalsIgnoreCase("Scan to shop"));
        } else {
            Assert.assertTrue(barCodeScanElements.scanToShopTitle.getAttribute("text").equalsIgnoreCase("Scan to shop"));
        }
    }

    public void isScanToClipDisplayed() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Assert.assertTrue(barCodeScanElements.scanToShopTitle.getAttribute("label").equalsIgnoreCase("Scan to clip"));
        } else {
            Assert.assertTrue(barCodeScanElements.scanToShopTitle.getAttribute("text").equalsIgnoreCase("Scan to clip"));
        }
    }

    public void pullTheDrawerUp() {
        Point pt = barCodeScanElements.scanToShopDrawer.getLocation();
        scroll(pt.getX(), pt.getY(), pt.getX(), pt.getX() - 300);
    }

    public void pullTheDrawerDown() {
        Point pt = barCodeScanElements.scanToShopDrawer.getLocation();
        scroll(pt.getX(), pt.getY(), pt.getX(), pt.getY() + 500);
    }

    public boolean verifyScanAndSaveDialogtitle() {
        return isElementDisplayed(barCodeScanElements.scanandSaveTitle);

    }

    public boolean verifyScanAndSaveDialogSubtitle() {
        return isElementDisplayed(barCodeScanElements.scanandSaveSubtitle);
    }

    public boolean verifyFlashStatusAsON() {
        return isElementDisplayed(barCodeScanElements.flashStatusON);
    }

    public void verifyScanToClipDrawerText() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Assert.assertTrue(barCodeScanElements.scanToClipDrawer.getAttribute("name").equalsIgnoreCase("Scan it to clip the coupon and save to Wallet."));
        } else {
            Assert.assertTrue(barCodeScanElements.scanToClipDrawer.getAttribute("text").equalsIgnoreCase("Scan it to clip the coupon and save to Wallet."));
        }
    }

    public void verifyScanToShopDrawerText(String shoppingMode) throws InterruptedException {
        if (shoppingMode.equalsIgnoreCase("InStore")) {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                Assert.assertTrue(barCodeScanElements.scanToShopText.getAttribute("name").equalsIgnoreCase("Scan it straight to your in-store list."));
            } else {
                Assert.assertTrue(barCodeScanElements.scanToShopText.getAttribute("text").equalsIgnoreCase("Scan it straight to your in-store list."));
            }
        } else {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                Assert.assertTrue(barCodeScanElements.scanToShopText.getAttribute("name").equalsIgnoreCase("Scan it straight to your cart."));
            } else {
                Assert.assertTrue(barCodeScanElements.scanToShopText.getAttribute("text").equalsIgnoreCase("Scan it straight to your cart."));
            }
        }

    }

    public boolean isCameraPleasePopUpDisplayed() {
        return isElementDisplayed(barCodeScanElements.cameraPleasePopUp);
    }

    public void isOpenSettingCTADisplayed() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            Assert.assertTrue(barCodeScanElements.openSettingCTA.getAttribute("text").equalsIgnoreCase("Open Settings"));
        } else {
            Assert.assertTrue(barCodeScanElements.openSettingCTA.getAttribute("label").equalsIgnoreCase("Open Settings"));
        }
    }

    public void clickOnOpenSettingCTA() {
        new CommonActions(driver).new ClickAction().clickElement(barCodeScanElements.openSettingCTA);
    }

    public void clickPermissionDenyOnPopUp() {
        if (isElementDisplayed(barCodeScanElements.permissionDenyButton)) {
            new CommonActions(driver).new ClickAction().clickElement(barCodeScanElements.permissionDenyButton);
        }
    }

    public boolean isSettingPageDisplayed() {
        return isElementDisplayed(barCodeScanElements.cameraSettingPageTitle);
    }

    public boolean isGetStartedOnTutorialsDisplayed() {
        if (isElementDisplayed(barCodeScanElements.updateLaterOnBarCodeScanScreen)) {
            new CommonActions(driver).new ClickAction().clickElement(barCodeScanElements.updateLaterOnBarCodeScanScreen);
        }
        if (isElementDisplayed(barCodeScanElements.feedBackForm)) {
            new CommonActions(driver).new ClickAction().clickElement(barCodeScanElements.closeFeedbackForm);
        }
        return isElementDisplayed(barCodeScanElements.getStarted);
    }

    public void clickOnCancelButtonFeedbackFormIfDisplayedOnBarCodeScanScreen() {
        if (!isElementDisplayed(barCodeScanElements.dealsOption, 1)) {
            new CommonActions(driver).new ClickAction().clickElement(barCodeScanElements.cancelButtonOnFeedBackFormOnBarcodeScanScreen);
        }
    }

    public void clickOnUpdateLaterIfDisplayedOnBarCodeScanScreen() {
        if (isElementDisplayed(barCodeScanElements.updateLaterOnBarCodeScanScreen, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(barCodeScanElements.updateLaterOnBarCodeScanScreen);
        }
    }
}

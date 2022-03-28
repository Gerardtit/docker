package com.automation.pages;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.entities.BannerConfType;
import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.AddToListOnWeeklyAdElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class AddToListOnWeeklyAdPage extends BasePage {
    public GG_MylistPage GGMylistPage = new GG_MylistPage(driver);
    public AddToListOnWeeklyAdElements addToListOnWeeklyAdElements = new AddToListOnWeeklyAdElements();

    public AddToListOnWeeklyAdPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), addToListOnWeeklyAdElements);
    }

    public void clickOnViewWeeklyAdButton() {
        new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.viewWeeklyAdButton);
    }

    public void clickOnAnyAd() {
        new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.weeklyAd3rd);
    }

    public void clickOnAdToList() throws InterruptedException {
        scrollDown(3);
        new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.addToListButton);
    }

    public void validateRemoveFromList(String string) {
        Assert.assertTrue(isElementDisplayed(addToListOnWeeklyAdElements.removeFromListButton, 10));
    }

    public void clickOnMyListTab() {
        if (isElementDisplayed(addToListOnWeeklyAdElements.myListTab, 5)) {
            new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.myListTab);
        } else if (!isElementDisplayed(addToListOnWeeklyAdElements.myListTab, 5) && addToListOnWeeklyAdElements.closeOfferDetailsBtn.isDisplayed()) {
            new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.closeOfferDetailsBtn);
            waitForDisplayed(addToListOnWeeklyAdElements.myListTab, 10);
            new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.myListTab);
        }
    }

    public void validateAdIsAddedToListUnderMyListPage() throws InterruptedException {
        clickOnMyListTab();
        GGMylistPage.clickOnListTab();
        Assert.assertTrue(addToListOnWeeklyAdElements.addedItemsList.isDisplayed());
    }

    public void validateValidityDateMyListPage() throws InterruptedException {
        clickOnMyListTab();
        GGMylistPage.clickOnListTab();
        Assert.assertTrue(addToListOnWeeklyAdElements.validityDate.isDisplayed());
    }

    public void userClickOnAnyFirstAdBanner() {
        new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.firstAdBanner);
    }

    public void userChooseFirstItemOfBanner() {
        new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.firstItemOfBanner);
    }

    public void userHasAddedThisItemtoTheList() {
        new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.addToListButton);
    }


    public void validateFlyerPreview() {
        if (platformName.equalsIgnoreCase("android")) {
            Assert.assertTrue(addToListOnWeeklyAdElements.weeklyAdHeader.isDisplayed());
        } else {
            Assert.assertTrue(addToListOnWeeklyAdElements.flyerPreview.isDisplayed());
        }
    }

    public void clickOnFlyerDetailView() {
        if (platformName.equalsIgnoreCase("android")) {
            new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.weeklyAdHeader);
        } else {
            new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.flyerPreview);
        }
    }

    public void validateWeeklyAdHeaderandDate() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //waitForElement(addToListOnWeeklyAdElements.weeklyAdHeaderBy, 5);
        Assert.assertTrue(addToListOnWeeklyAdElements.weeklyAdHeader.isDisplayed());
        Assert.assertTrue(addToListOnWeeklyAdElements.weeklyAdDateRange.isDisplayed());
    }

    public void clickOnScrollView() {
        scrollDown();
        if (platformName.equalsIgnoreCase("android")) {
            new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.scrollView);

        } else {
            new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.scrollView);

        }
    }

    public void clickOMenuItemMeatAndSeaFood() {
        if (platformName.equalsIgnoreCase("android")) {
            new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.pickUpButton);
        } else {
            new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.pickUpButton);
        }
    }

    public void clickOnCloseOfferDetailsScreen() {
        if (platformName.equalsIgnoreCase("android")) {
            new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.closeOfferDetailsBtn);
        } else {
            new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.closeOfferDetailsBtn);
        }
    }

    public void validateWeeklyAdHeaderAndDate() {
        addToListOnWeeklyAdElements.weeklyAdHeader.isDisplayed();
        addToListOnWeeklyAdElements.weeklyAdDateRange.isDisplayed();
    }

    public void clickOnOffer() {
        new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.clickOnFlyerOffer);
    }

    public void validatingIndividualWeeklyOfferDetails() {

        if (platformName.equalsIgnoreCase("android")) {
            Assert.assertTrue(addToListOnWeeklyAdElements.weeklyAdProductImage.isEnabled());
            Assert.assertTrue(addToListOnWeeklyAdElements.weeklyAdOfferPrice.isDisplayed());
            Assert.assertTrue(addToListOnWeeklyAdElements.weeklyAdProductName.isDisplayed());
            Assert.assertTrue(addToListOnWeeklyAdElements.weeklyAdOfferExpiryDate.isDisplayed());
            Assert.assertTrue(addToListOnWeeklyAdElements.weeklyAdOfferValidText.isDisplayed());
            Assert.assertTrue(addToListOnWeeklyAdElements.offerDetailsContainer.isDisplayed());
            new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.offerDetailsContainer);
        } else {
            Assert.assertTrue(addToListOnWeeklyAdElements.weeklyAdProductImage.isEnabled());
            Assert.assertTrue(addToListOnWeeklyAdElements.weeklyAdSubHeader.isDisplayed());
            Assert.assertTrue(addToListOnWeeklyAdElements.weeklyAdOfferPrice.isDisplayed());
            Assert.assertTrue(addToListOnWeeklyAdElements.weeklyAdProductName.isDisplayed());
            Assert.assertTrue(addToListOnWeeklyAdElements.offerDetailsContainer.isDisplayed());
            new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.offerDetailsContainer);
        }
    }

    public void clickSpecificOffer() {
        //waitForElement(addToListOnWeeklyAdElements.flyerSpecificOfferBy, 5);
        WebElement el = addToListOnWeeklyAdElements.flyerSpecificOffer;
        el.click();
        if (isElementPresent(addToListOnWeeklyAdElements.flyerSpecificOfferBy)) {
            Point pt = el.getLocation();
            Dimension size = el.getSize();
            int x = pt.getX() + (size.getWidth() / 2);
            int y = pt.getY() + (size.getHeight() / 2);
            System.out.println(x + " coordinates " + y);
            TouchAction touchAction = new TouchAction(driver);
            touchAction.press(PointOption.point(x, y)).release().perform();
        }
    }

    public void validateWeeklyAdOfferDetails() {
        AppiumDevice device = AppiumDeviceManager.getDevice();
        Assert.assertTrue(addToListOnWeeklyAdElements.weeklyAdProductImage.isEnabled());
        Assert.assertTrue(addToListOnWeeklyAdElements.weeklyAdSubHeader.isDisplayed());
        if (platformName.equalsIgnoreCase("android")) {
            Assert.assertTrue(addToListOnWeeklyAdElements.weeklyAdOfferPrice.isDisplayed());
        } else {
            String price = device.getConfigureData(BannerConfType.FLIP_WEEKLY_AD_PRODUCT_PRICE);
            Assert.assertTrue(driver.findElement(By.xpath("//*[@name='" + price + "']")).isDisplayed());
        }
        if (platformName.equalsIgnoreCase("android")) {
            Assert.assertTrue(addToListOnWeeklyAdElements.weeklyAdProductName.isDisplayed());
            String offerName = addToListOnWeeklyAdElements.weeklyAdProductName.getText();
            Assert.assertTrue(!offerName.isEmpty());

            if (addToListOnWeeklyAdElements.weeklyAdProductDescription.isDisplayed()) {
                Assert.assertTrue(addToListOnWeeklyAdElements.weeklyAdProductDescription.isDisplayed());
                String offerDescription = addToListOnWeeklyAdElements.weeklyAdProductDescription.getText();
                Assert.assertTrue(!offerDescription.isEmpty());
            }
            Assert.assertTrue(addToListOnWeeklyAdElements.weeklyAdOfferExpiryDate.isDisplayed());
            String offerExpiryDate = addToListOnWeeklyAdElements.weeklyAdOfferExpiryDate.getText();
            Assert.assertTrue(!offerExpiryDate.isEmpty());
            Assert.assertTrue(addToListOnWeeklyAdElements.weeklyAdOfferValidText.isDisplayed());
            String bannerName = driver.getCapabilities().getCapability("banner").toString();
            String banner = bannerName.substring(0, 1).toUpperCase() + bannerName.substring(1);
            Assert.assertTrue(driver.findElement(By.xpath("//*[@class='android.widget.TextView'][contains(@text,'" + banner + "')]")).isDisplayed());
            String address = device.getConfigureData(BannerConfType.FLIP_WEEKLY_AD_ADDRESS);
            Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@text,'" + address + "')]")).isDisplayed());
        } else {
            String prodName = device.getConfigureData(BannerConfType.FLIP_WEEKLY_AD_PRODUCT_NAME);
            Assert.assertTrue(driver.findElement(By.xpath("//*[@name='" + prodName + "']")).isDisplayed());
            String prodDesc = device.getConfigureData(BannerConfType.FLIP_WEEKLY_AD_PRODUCT_DESC);
            if (driver.findElement(By.xpath("//*[@name='" + prodDesc + "']")).isDisplayed()) {
                Assert.assertTrue(driver.findElement(By.xpath("//*[@name='" + prodDesc + "']")).isDisplayed());
            }
            String validDate = device.getConfigureData(BannerConfType.FLIP_WEEKLY_AD_VALID_DATE);
            Assert.assertTrue(driver.findElement(By.xpath("//*[@name='" + validDate + "']")).isDisplayed());
            Assert.assertTrue(addToListOnWeeklyAdElements.weeklyAdOfferValidText.isDisplayed());
            String bannerName = driver.getCapabilities().getCapability("banner").toString();
            String banner = bannerName.substring(0, 1).toUpperCase() + bannerName.substring(1);
            Assert.assertTrue(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + banner + "']")).isDisplayed());
            String address = device.getConfigureData(BannerConfType.FLIP_WEEKLY_AD_ADDRESS);
            Assert.assertTrue(driver.findElement(By.xpath("//*[@name='" + address + "']")).isDisplayed());
        }
    }

    public void verifyWeeklyAdsPage() {
        Assert.assertTrue(isElementDisplayed(addToListOnWeeklyAdElements.weeklyAdsTitle, 10), "Weekly ads page is not displayed");
    }

    public void clickOnFirstAdBanner() {
        new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.firstAdBanner);
    }

    public void chooseFirstItemFromBanner() {
        new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.firstItemOfBanner);
    }

    public void addItemToList() {
        new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.addToListBtn);
    }

    public void validateAddToList() {
        Assert.assertTrue(isElementDisplayed(addToListOnWeeklyAdElements.addToListBtn, 10));
    }

    public void clickRemoveFromListButton() {
        new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.removeFromListButton);

    }

    public void clickBackToAdButton() {
        new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.backToWeekAdPDF);

    }

    public void clickNavBarBackToButton() {
        waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.backToNavBarBtn);

    }


    public void selectPickUpOption() {
        if (platformName.equalsIgnoreCase("android")) {
            new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.deliveryButton);
            new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.pickUpButton);
            scrollDown();
        } else {
            new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.pickUpButton);
            new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.pickUpButton);
        }
    }

    public void selectPickUpStore() {
        waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(addToListOnWeeklyAdElements.selectPickUpStoreBtn);
    }

    public void verifyFlyerPageIsVisible() {
        Assert.assertTrue(isElementDisplayed(addToListOnWeeklyAdElements.firstAdBanner), "Weekly ads flyer page is not displayed");
    }

    public void verifyFullViewOfFlyerPage() {
        Assert.assertTrue(isElementDisplayed(addToListOnWeeklyAdElements.firstItemOfBanner), "Detailed page of weekly ad flyer is not displayed");
    }

    public void validateWeeklyHeaderAndDate() {
        Assert.assertTrue(isElementDisplayed(addToListOnWeeklyAdElements.weeklyAdHeader), "Detailed page of weekly ad flyer is not displayed");
        Assert.assertTrue(isElementDisplayed(addToListOnWeeklyAdElements.weeklyAdDate), "Detailed page of weekly ad date in flyer is not displayed");
    }

    public void scrollVerticallyOnFlyerPage() {
        scrollDown();
        scrollDown();
        scrollUp();
        scrollUp();
    }

    public void scrollVerticallyOnFlyerDetailViewPage() {
        scrollDown();
        scrollDown();
        scrollDown();
        scrollUp();
        scrollUp();
        scrollUp();
    }

    public void validateOfferDetailsDisclaimerSection() {
        Assert.assertTrue(addToListOnWeeklyAdElements.offerDetailsLabel.isDisplayed(), "Offer Details section is not displayed");
        Assert.assertTrue(addToListOnWeeklyAdElements.disclaimerSection.isDisplayed(), "Disclaimer section is not displayed");
    }

}

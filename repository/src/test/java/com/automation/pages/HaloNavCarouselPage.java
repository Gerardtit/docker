package com.automation.pages;


import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.HomePageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HaloNavCarouselPage extends BasePage {

    HomePageElements homePageElements = new HomePageElements();

    public HaloNavCarouselPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), homePageElements);
    }

    public void validateHaloNavCarousel() {
        Assert.assertTrue(homePageElements.haloNavCarouselList.isDisplayed(), "HaloNav Carousel is not displayed !!!!");
    }

    public void validateHaloNavCarouselNotDisplayed() {
        try {
            Assert.assertTrue(homePageElements.haloNavCarouselList.isDisplayed(), "HaloNav Carousel is not displayed !!!!");
        } catch (NoSuchElementException e) {
            System.out.println("Halo Nav Carousel not Visible");

        }
    }


    //3 methods for Scenario: Scrolling down on the Home page, HaloNav carousel is not sticky or not displayed
    public boolean isHaloNavCarouselDisplayed() {
        return isElementDisplayed(homePageElements.haloNavCarouselList);
    }


    public boolean isSearchProductDisplayed() {
        return isElementDisplayed(homePageElements.searchProduct);
    }

    public boolean isCartIconDisplayed() {
        return isElementDisplayed(homePageElements.cartIcon);
    }

    public void haloNavOptions(String carouselName) {

        switch (carouselName) {
            case "Rewards":
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.haloNavRewardsBtn);
                break;
            case "Pharmacy":
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.haloNavPharmacyBtn);
                break;
            case "Weekly Ad":
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.haloNavWeeklyAdsBtn);
                break;
            case "Deals":
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.haloNavDealsBtn);
                break;
            case "FreshPass":
                new CommonActions(driver).new ClickAction().clickElement(homePageElements.haloNavFreshPassBtn);
                break;
        }
    }

    public void validateHaloNavInteractions(String pageName) {

        switch (pageName) {
            case "Rewards":
                Assert.assertTrue(homePageElements.rewardsBtn.isDisplayed());
                break;
            case "Pharmacy":
                Assert.assertTrue(homePageElements.pharmacyServicesHeader.isDisplayed());
                break;
            case "Weekly Ad":
                Assert.assertTrue(homePageElements.weeklyAdsHeader.isDisplayed());
                break;
            case "Deals":
                Assert.assertTrue(homePageElements.allDealsHeader.isDisplayed());
                break;
            case "FreshPass":
                Assert.assertTrue(homePageElements.freshPassHeader.isDisplayed());
                break;
        }
    }


    public void pharmacyNavigationBack() {
        new CommonActions(driver).new ClickAction().clickElement(homePageElements.backNavigatePharmacy);

    }

    public void validateCarouselPages(String relatedPage) {
        switch (relatedPage) {
            case "Grocery Rewards":
                Assert.assertTrue(homePageElements.groceryRrwardsLabel.isDisplayed());
                break;

        }


    }

    public void scrollDownOnHomePage() throws InterruptedException {
        Dimension dim = driver.manage().window().getSize();
        int height = dim.getHeight();
        int width = dim.getWidth();

        int startx = width / 2;
        int endx = width / 2;
        int starty = (int) (height * .80);
        int endy = (int) (height * .20);

        TouchAction action = new TouchAction(driver);
        action.longPress(PointOption.point(startx, starty)).moveTo(PointOption.point(endx, endy)).release().perform();
        Thread.sleep(5000);
    }

    public void validateStaticHaloNavGuest(String rewards, String pharmacy, String weeklyad, String deals, String freshpass) {
        Assert.assertTrue(homePageElements.rewardsBtn.isDisplayed());
        Assert.assertTrue(homePageElements.haloNavPharmacyBtn.isDisplayed());
        Assert.assertTrue(homePageElements.haloNavWeeklyAdsBtn.isDisplayed());
        Assert.assertTrue(homePageElements.haloNavDealsBtn.isDisplayed());
        Assert.assertTrue(homePageElements.haloNavFreshPassBtn.isDisplayed());
    }
}

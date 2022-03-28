package com.automation.pages;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.TapAction;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.DealsAllCouponPageElements;
import com.automation.pageElements.DealsPageElements;
import com.automation.pageElements.GG_MyItemsPageElements;
import com.automation.pageElements.GG_SearchPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

public class DealsPage extends BasePage {
    public DealsPageElements pageElements = new DealsPageElements();
    public GG_MyItemsPageElements myItemsElements = new GG_MyItemsPageElements();
    private GG_SearchPageElements gg_searchPageElements = new GG_SearchPageElements();
    public DealsAllCouponPageElements dealspageElements = new DealsAllCouponPageElements();

    public DealsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), myItemsElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_searchPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dealspageElements);

    }


    public void waitForPageDisplayed() {

        new WaitAction(driver).waitForDisplayed(pageElements.dealPageTitle);

    }

    public void clickBackButton() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.backButton);
    }

    public void clickPromoCode() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.promoCodeDeal);
    }

    public void waitForPromoCodeWindowDisplayed() {
        new WaitAction(driver).waitForDisplayed(pageElements.promoCodeTitle);
    }

    public void clickClubCard() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.clubCardSpecials);
    }

    public void clickBuyOneGetOneFree() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.buyOneGetOneFree);
    }

    public void waitForClubCardDealsWindowDisplayed() {
        new WaitAction(driver).waitForDisplayed(pageElements.clubCardSpecialsTitle);
    }

    public void waitForBuyOneGetOneFreeDisplayed() {
        new WaitAction(driver).waitForDisplayed(pageElements.buyOneGetOneFree);
    }

    public void clickSearchIcon() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.searchIcon);
    }

    public void clickItemInDealsPage() throws InterruptedException {
        new WaitAction(driver).waitForLoadingComplete();
        Thread.sleep(1000);
        String category = ThreadLocalHelper.testCaseData.get().get("BOGO_CATEGORY");
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new TapAction(driver).tapElementCoordinate(findElementByName(category));
        } else {

            new TapAction(driver).tapElementCoordinate((MobileElement) driver.findElementByXPath("//*[contains(@label, '" + category + "')]"));

        }
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void dealstab() {
        pageElements.Alldealstab.click();
    }

    public void clickonExpiring_soon_deals_pills() {
        pageElements.Expiring_soon_pills.click();

    }

    public void clickonNew_pills() {
        pageElements.New_pills.click();

    }


    public void clickonCoupon_center_pills() {
        swipeLeftOnElement(dealspageElements.weeklyAdPill);

        pageElements.Coupon_center_pills.click();

    }

    public void clickDealsSearchBar() {
        pageElements.clickDealsearch.click();
    }

    public void enterSearchItemondeals(String arg0) {
        try {
            if (driver.getPlatformName().equalsIgnoreCase("android")) {

                if (AppiumDeviceManager.getDevice().getDeviceType().equalsIgnoreCase("cloud")) {
                    pageElements.clickDealsearch.click();
                    pageElements.clickDealsearch.sendKeys(arg0);
                    //tapCoordinate(1358, 2901);
                    tapSearchAndroidKeyboard();
                    driver.hideKeyboard();
                    waitForLoadingComplete();
                } else {
                    enterKey(pageElements.clickDealsearch, arg0);
                    // tapCoordinate(990, 1983);
                    androidKeyboardClickDone();
                }
            } else {
//                if (isElementDisplayed(pageElements.clickDealsearch)) {
//                    tapCoordinate(gg_searchPageElements.searchTextField.getCenter().getX(), gg_searchPageElements.searchTextField.getCenter().getY());
//                    Thread.sleep(5000);
//                    waitForLoadingComplete();
//                }
                enterKey(pageElements.clickDealsearch, arg0 + Keys.RETURN);
                if (isElementVisible(myItemsElements.dealToggleSwitch)) {
                    myItemsElements.dealToggleSwitch.get(0).click();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
//            homePageElements.milkProduct.click();
            //homePageElements.sodaProduct.click();
        }
        /*try {
            homePageElements.closeToggle.click();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

    public void cancelatdeals() {
        pageElements.cancelatdeal.click();
    }

    public void dealscount() {
        pageElements.dealscountnumber.isDisplayed();
    }

    public void dealsItemsyoumaylike() {
        waitForLoadingComplete();
        scrollDownForElement(pageElements.dealsItemsyoulike);
        pageElements.dealsSeeAllCTA.click();

    }


    public void expringdeals() {

        pageElements.expiringdeal.click();
    }

    public void addeddeal() {
        waitForLoadingComplete();
        pageElements.addedAtDeal.click();

    }

    public void clipAdeal() {
        pageElements.firstcoupon.click();
    }


}

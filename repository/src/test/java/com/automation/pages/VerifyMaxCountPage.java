package com.automation.pages;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.manager.ConfigFileManager;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_MyItemsPageElements;
import com.automation.pageElements.PopUpHandleElements;
import com.automation.pageElements.VerifyMaxCountPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.Map;

public class VerifyMaxCountPage extends BasePage {

    public GG_MyItemsPageElements myItemsElements = new GG_MyItemsPageElements();
    public PopUpHandleElements popUpHandleElements = new PopUpHandleElements();
    private final VerifyMaxCountPageElements verifyMaxCountPageElements = new VerifyMaxCountPageElements();

    public VerifyMaxCountPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), verifyMaxCountPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), myItemsElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), popUpHandleElements);
    }

    public void verifyMaxCountPDP() throws IOException {

        new WaitAction(driver).waitForLoadingComplete();
        Assert.assertTrue(isElementDisplayed(verifyMaxCountPageElements.addtocart), "User is not navigated to PDP");

        verifyMaxCountPageElements.addtocart.click();
        waitForDisplayed(verifyMaxCountPageElements.oneincart);
        verifyMaxCountPageElements.oneincart.click();

        String banner = getCurrentBanner();
        String env = getCurrentEnv();
        Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);
        Integer count_ios = Integer.parseInt(ThreadLocalHelper.testCaseData.get().get("MAX_QUANTITY")) + 1;
        Integer count_android = Integer.parseInt(ThreadLocalHelper.testCaseData.get().get("MAX_QUANTITY")) - 1;
//        Integer count_ios = Integer.parseInt(bannerProperty.get("MAX_QUANTITY")) + 1;
//        Integer count_android = Integer.parseInt(bannerProperty.get("MAX_QUANTITY")) - 1;

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            verifyMaxCountPageElements.oneincart.sendKeys(count_ios.toString());
            verifyMaxCountPageElements.updateqty.click();
        } else {
            verifyMaxCountPageElements.editqty.sendKeys(count_android.toString());
            verifyMaxCountPageElements.plusbtn.click();
        }

        Assert.assertTrue(isElementDisplayed(verifyMaxCountPageElements.incrementdisabled), "Quantity Increament is not disabled");
        Assert.assertTrue(isElementDisplayed(verifyMaxCountPageElements.maxquantity), "Max QTY is not appearing");

    }

    public void verifyMaxCountCart() throws IOException {
        new WaitAction(driver).waitForLoadingComplete();

        String banner = getCurrentBanner();
        String env = getCurrentEnv();
        Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);
        String cartcount = bannerProperty.get("MAX_QUANTITY");
        System.out.println("cartcount: " + cartcount);
        System.out.println("QTY:" + verifyMaxCountPageElements.qtyincart.getText());

        Assert.assertTrue(verifyMaxCountPageElements.qtyincart.getText().contains(cartcount), "Cart not Showing Max Quantity");

        System.out.println("Platform" + driver.getPlatformName());
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            Assert.assertTrue(isElementDisplayed(verifyMaxCountPageElements.incrementdisabled), "Quantity Increament is not disabled");
        }
    }

    public void handlePopupsHomePage() {

        new WaitAction(driver).waitForLoadingComplete();
        if (isElementDisplayed(verifyMaxCountPageElements.ClickCacheText, 3)) {
            verifyMaxCountPageElements.ClickCacheText.click();
        }
        new WaitAction(driver).waitForLoadingComplete();
        if (isElementDisplayed(verifyMaxCountPageElements.ClickNextButton, 3)) {

            for (int i = 1; i <= 3; i++) {
                new CommonActions(driver).new ClickAction().clickElement(verifyMaxCountPageElements.ClickNextButton);
            }
        }
        new WaitAction(driver).waitForLoadingComplete();
        if (isElementDisplayed(verifyMaxCountPageElements.ClickCacheTextMA, 3)) {

            verifyMaxCountPageElements.ClickCacheTextMA.click();
        }
    }

    public void searchProduct(String arg0) throws InterruptedException {
        new WaitAction(driver).waitForLoadingComplete();
        verifyMaxCountPageElements.search.click();
        verifyMaxCountPageElements.searchmilk.click();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (myItemsElements.dealsToggleSwitch.isDisplayed()) {
                myItemsElements.dealsToggleSwitch.click();
            }
        }
    }

    public void navigatePdp() {
        new WaitAction(driver).waitForLoadingComplete();
        verifyMaxCountPageElements.firstproduct.click();
    }
}

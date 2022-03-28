package com.automation.pages;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.pageElements.HomePageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class GG_idealconditionPage extends BasePage {

    public HomePageElements homePageElements = new HomePageElements();

    public GG_idealconditionPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), homePageElements);
    }

    public void runbackground() throws Exception {
        String app_background_runtime = ThreadLocalHelper.testCaseData.get().get("APP_BACKGROUND_RUNTIME");
        long time = Long.parseLong(app_background_runtime);
        driver.runAppInBackground(Duration.ofSeconds(time));

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            driver.activateApp(getBannerPropertiesMap().get("bundleId"));
        } else {
            driver.activateApp(getBannerPropertiesMap().get("packageName"));

        }

    }
}



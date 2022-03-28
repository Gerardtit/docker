package com.automation.pages.mealsPages;

import com.automation.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MealsUtils extends BasePage {

    public MealsUtils(AppiumDriver driver) {
        super(driver);
    }

    //todo : if this does not work, then instead of thread.sleep create a different method similar to isElementDisplayed
    public boolean checkMobileElementExist(MobileElement element) {
        boolean objectExist = false;
        try {
            if (checkMobileElementIsDisplayed(element)) {
                objectExist = true;
            } else {
                objectExist = isElementDisplayed(element, 10);
            }
            return objectExist;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkMobileElementIsDisplayed(MobileElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    //todo - move back button related methods in this class to reduce element duplication
}

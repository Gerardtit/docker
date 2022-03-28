package com.automation.mobile.util;

import com.automation.mobile.appium.AppiumDeviceManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

public class TapAction {

    AppiumDriver driver;

    public TapAction(AppiumDriver driver) {
        this.driver = driver;
    }

    //Tap
    public void tapCoordinate(int x, int y) {
        TouchAction touch = new TouchAction(driver);
        touch.tap(new PointOption().withCoordinates(x, y)).perform();
    }

    //Tap
    public void tapElementCoordinate(MobileElement element) {
        TouchAction touch = new TouchAction(driver);
        Point point = element.getCenter();
        touch.tap(new PointOption().withCoordinates(point)).perform();
    }

    //Tap
    public void tapSearchAndroidKeyboard() {
        Map<String, Object> params = new HashMap<>();
        params.put("keySequence", "KEYBOARD_SEARCH");
        driver.executeScript("mobile:presskey", params);
//        Dimension dimension = driver.manage().window().getSize();
//        int height = (int) (dimension.getHeight() * .95);
//        int width = (int) (dimension.getWidth() * .92);
//        tapCoordinate(width, height);
    }

    //Tap
    public void tapEnterAndroidKeyboard() {
        Dimension dimension = driver.manage().window().getSize();
        int height = (int) (dimension.getHeight() * .97);
        int width = (int) (dimension.getWidth() * .90);
        tapCoordinate(width, height);
    }


    //Tap
    public void tapElement(MobileElement element) {
        TouchAction touch = new TouchAction(driver);
        touch.tap(
                        new TapOptions().withElement(
                                ElementOption.element(
                                        element)))
                .perform();

    }

    //Tap
    public void pressEnterAndroid() {
        if (AppiumDeviceManager.getDevice().getDeviceType().equalsIgnoreCase("local")) {
            Actions action1 = new Actions(driver);
            action1.sendKeys(Keys.ENTER).perform();
        } else {
            Map<String, Object> EnterKeyEvent = new HashMap<>();
            EnterKeyEvent.put("key", "66");
            driver.executeScript("mobile:key:event", EnterKeyEvent);
        }
    }

    //Tap
    // Method to tap on search or enter(next) on keyboard for android
    public void tapSearchEnterAndroid() {
        int height = driver.findElement(By.id("drawer_layout")).getSize().getHeight();
        int width = driver.findElement(By.id("drawer_layout")).getSize().getWidth();

        int searchX = driver.findElement(By.id("drawer_layout")).getLocation().getX() + width - 10;
        int searchY = driver.findElement(By.id("drawer_layout")).getLocation().getY() + height - 15;

        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(searchX, searchY)).perform();
    }

}

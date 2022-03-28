package com.automation.pages;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.entities.CommandArgument;
import com.automation.mobile.helpers.AppRelaunchHelper;
import com.automation.mobile.manager.ConfigFileManager;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.TapAction;
import com.automation.mobile.util.WaitAction;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class BasePage {
    private final int APP_BACKGROUND_TIME = 5;
    private final int WAIT_FOR_ELEMENT_TIMEOUT = 10;
    public AppiumDriver driver;
    public WebDriverWait waitVar;
    public String platformName;
    private final AppRelaunchHelper appRelaunchHelper;


    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        this.waitVar = new WebDriverWait(driver, 10);
        this.platformName = driver.getPlatformName().toLowerCase();
        appRelaunchHelper = new AppRelaunchHelper(driver);
    }

    public Map<String, String> getBannerPropertiesMap() throws IOException {
        String banner = getCurrentBanner();
        String env = getCurrentEnv();
        Map<String, String> bannerProperties = ConfigFileManager.getBannerPropertyMap(banner, env);
        return bannerProperties;
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public boolean textDisplayed(String text) {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            waitVar.until(ExpectedConditions.presenceOfElementLocated(MobileBy.name(text)));
            return true;
        } else if (driver.getPlatformName().equalsIgnoreCase("android")) {
            String textNew = text.substring(0, 1).toUpperCase() + text.substring(1);
            String selector = "new UiSelector().textContains(" + "\"" + textNew + "\"" + ")";
            waitVar.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(selector)));
            return true;
        }
        return false;
    }

    public boolean containTextDisplayed(String text) {
        new WaitAction(driver).waitForLoadingComplete();
        WebElement element;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            String iosText = "type == 'XCUIElementTypeStaticText' AND label CONTAINS "
                    + "'"
                    + text
                    + "'";
            element = waitVar.until(ExpectedConditions.presenceOfElementLocated(MobileBy.iOSNsPredicateString(iosText)));

            if (element.isDisplayed())
                return true;
            else
                return false;


        } else {
            String selector = "new UiSelector().textContains(" + "\"" + text + "\"" + ")";
            element = waitVar.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(selector)));
            if (element.isDisplayed())
                return true;
            else
                return false;
        }
    }

    public void enterMobileNumber(MobileElement element, String keyValue) {
        element.click();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {

            try {
                if (AppiumDeviceManager.getDevice().getDeviceType().equalsIgnoreCase("cloud")) {
                    Thread.sleep(1000);
                } else {
                    Thread.sleep(1500);
                }
                TouchAction action = new TouchAction(driver);
                action.tap(TapOptions.tapOptions().withElement(ElementOption.element(element)).withTapsCount(2)).perform();
                element.sendKeys(Keys.DELETE);
                if (AppiumDeviceManager.getDevice().getDeviceType().equalsIgnoreCase("cloud")) {
                    Thread.sleep(500);
                } else {
                    Thread.sleep(1000);
                }
                element.sendKeys(keyValue + "\n");
            } catch (InterruptedException e) {
                // do nothing
            }
        } else {
            element.clear();
            element.sendKeys(keyValue);

        }
    }

    public void waitForTextPresentInElement(MobileElement element, String text) {
        waitVar.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitForElementToBeClickable(MobileElement element, int secondsToWait) {
        try {
            new FluentWait<>(driver).withTimeout(Duration.ofSeconds(secondsToWait)).pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class).until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException te) {
            // Do nothing
        }
    }

    public void waitForLoaderToDisappear() {
        try {
            if (driver.getPlatformName().equalsIgnoreCase("android")) {
                waitForElementToDisappear((MobileElement) driver.findElement(By.className("android.widget.ProgressBar")), 60);
            } else {
                waitForElementToDisappear((MobileElement) driver.findElement(By.id("In progress")), 60);
            }
        } catch (NoSuchElementException e) {
            return;
        }
    }

    public void waitForElementToDisappear(MobileElement ele, int waitTime) {
        for (int i = 0; i < waitTime; i++) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 1);
                wait.until(ExpectedConditions.visibilityOf(ele));

            } catch (TimeoutException | StaleElementReferenceException | NoSuchElementException e) {
                return;
            }
        }
    }


    public void clickTextOnScreen(String arg0) {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            String text = "new UiSelector().text(\"" + arg0 + "\")";
            scrollDownForElement(driver.findElement(MobileBy.AndroidUIAutomator(text)));
            new CommonActions(driver).new ClickAction().clickElement(driver.findElement(MobileBy.AndroidUIAutomator(text)));
        } else {
            scrollDownForElement(driver.findElementByName(arg0));
            new CommonActions(driver).new ClickAction().clickElement(driver.findElementByName(arg0));
        }
    }

    public void enterKey(MobileElement element, String keyValue) {
        element.click();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {

            try {
                if (AppiumDeviceManager.getDevice().getDeviceType().equalsIgnoreCase("cloud")) {
                    Thread.sleep(1000);
                } else {
                    Thread.sleep(1500);
                }
                TouchAction action = new TouchAction(driver);
                action.tap(TapOptions.tapOptions().withElement(ElementOption.element(element)).withTapsCount(2)).perform();
                element.sendKeys(Keys.DELETE);
                if (AppiumDeviceManager.getDevice().getDeviceType().equalsIgnoreCase("cloud")) {
                    Thread.sleep(500);
                } else {
                    Thread.sleep(1000);
                }
                element.sendKeys(keyValue + "\n");
            } catch (InterruptedException e) {
                // do nothing
            }
        } else {
            element.clear();
            element.sendKeys(keyValue);

            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                // Do nothing
            }
            if (AppiumDeviceManager.getDevice().getDeviceType().equalsIgnoreCase("local")) {
                Actions action = new Actions(driver);
                action.sendKeys(Keys.ENTER).perform();
            } else {
                new TapAction(driver).tapSearchEnterAndroid();

            }
        }
    }


    // Method to tap on search or enter(next) on keyboard for android
    public void tapSearchEnterAndroid() {
        int height = driver.findElement(By.xpath("//*[contains(@resource-id,'action_bar_root')]")).getSize().getHeight();
        int width = driver.findElement(By.xpath("//*[contains(@resource-id,'action_bar_root')]")).getSize().getWidth();

        int searchX = driver.findElement(By.xpath("//*[contains(@resource-id,'action_bar_root')]")).getLocation().getX() + width - 10;
        int searchY = driver.findElement(By.xpath("//*[contains(@resource-id,'action_bar_root')]")).getLocation().getY() + height - 15;

        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(searchX, searchY)).perform();
    }

    public String getTextFromTextField(MobileElement element) {
        String val = "";
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            TouchAction action = new TouchAction(driver);
            action.tap(TapOptions.tapOptions().withElement(ElementOption.element(element)).withTapsCount(2)).perform();
            driver.findElement(By.name("Copy")).click();
            val = ((IOSDriver) driver).getClipboardText();
            //val= ((HasClipboard) driver).getClipboardText();


        }
        return val;
    }

    public void searchProductByOS(MobileElement element, MobileElement element2, String keyValue) {

        switch (driver.getPlatformName().toUpperCase()) {
            case "ANDROID":
                enterTextNoPressEnter(element, keyValue);
                new TapAction(driver).tapSearchEnterAndroid();
                // I use Element2 for "x" in search bar element
                if (isElementDisplayed(element2, 2)) {
                    enterTextNoPressEnter(element, keyValue);
                    // This is for different keyboard
                    driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));
                }
                break;
            case "IOS":
                enterKey(element, keyValue);
                break;
        }
    }

    public void enterTextNoPressEnter(MobileElement element, String keyValue) {
        element.click();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            try {
                if (AppiumDeviceManager.getDevice().getDeviceType().equalsIgnoreCase("cloud")) {
                    Thread.sleep(1000);
                } else {
                    Thread.sleep(1500);
                }
                TouchAction action = new TouchAction(driver);
                action.tap(TapOptions.tapOptions().withElement(ElementOption.element(element)).withTapsCount(2)).perform();
                element.sendKeys(Keys.DELETE);
                if (AppiumDeviceManager.getDevice().getDeviceType().equalsIgnoreCase("cloud")) {
                    Thread.sleep(1000);
                } else {
                    Thread.sleep(1500);
                }
                element.sendKeys(keyValue);
            } catch (InterruptedException e) {
                // do nothing
            }
        } else {
            element.sendKeys(keyValue);
        }
    }


    public void scrollDown() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            int pressX = driver.manage().window().getSize().width / 3;
            int bottomY = (driver.manage().window().getSize().height * 2) / 3;
            int topY = driver.manage().window().getSize().height / 4;
            scroll(pressX, bottomY, pressX, topY);
        } else {
            int pressX = driver.manage().window().getSize().width / 3;
            int bottomY = (driver.manage().window().getSize().height * 3) / 4;
            int topY = driver.manage().window().getSize().height / 2;
            scroll(pressX, bottomY, pressX, topY);
        }
    }

    public void scrollUp() {
        Dimension size = driver.manage().window().getSize();
        int starty = size.height / 3;
        int endy = (size.height * 5) / 6;
        int startx = size.width / 2;

        // Swipe from Bottom to Top
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(startx, starty)).moveTo(PointOption.point(startx, endy)).release().perform();
    }

    public void scrollDownForDeliverySlot() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            int pressX = driver.manage().window().getSize().width / 3;
            int bottomY = (int) (driver.manage().window().getSize().height / 1.5);
            int topY = (int) (driver.manage().window().getSize().height / 1.7);
            scroll(pressX, bottomY, pressX, topY);
        } else {
            int pressX = driver.manage().window().getSize().width / 2;
            int bottomY = driver.manage().window().getSize().height * 2 / 5;
            int topY = driver.manage().window().getSize().height / 8;
            scroll(pressX, bottomY, pressX, topY);
        }
    }

    public void scrollDown(int count) {
        for (int i = 0; i < count; i++) {
            int pressX = driver.manage().window().getSize().width / 2;
            int bottomY = driver.manage().window().getSize().height * 2 / 5;
            int topY = driver.manage().window().getSize().height / 8;
            scroll(pressX, bottomY, pressX, topY);
        }
    }

    public void swipeLeft() {
        int fromX = driver.manage().window().getSize().width * 2 / 4;
        int toX = driver.manage().window().getSize().width / 10;
        int fromY = driver.manage().window().getSize().height / 2;
        scroll(fromX, fromY, toX, fromY);
    }

    public void scrollTop() {
        int pressX = driver.manage().window().getSize().width / 2;
        int bottomY = driver.manage().window().getSize().height * 4 / 5;
        int topY = driver.manage().window().getSize().height / 8;
        scroll(pressX, topY, pressX, bottomY);
    }

    public void swipeLeftOnElement(MobileElement element) {
        scroll(element.getCenter().getX(), element.getCenter().getY(), 0, element.getCenter().getY());
    }

    public boolean scrollDownForElement(WebElement element) {
        for (int i = 0; i < 20; i++) {
            try {
                if (element.isDisplayed()) {
                    return true;
                }
            } catch (Exception e) {
            }
            scrollDown();
        }
        return false;
    }

    public boolean scrollDownForElement(WebElement element, int numberOfScrolls) {
        for (int i = 0; i < numberOfScrolls; i++) {
            try {
                if (element.isDisplayed()) {
                    return true;
                }
            } catch (Exception e) {
            }
            scrollDown();
        }
        return false;
    }

    public boolean scrollUpForElement(WebElement element, int numberOfScrolls) {
        for (int i = 0; i < numberOfScrolls; i++) {
            try {
                if (element.isDisplayed()) {
                    return true;
                }
            } catch (Exception e) {
            }
            scrollUp();
        }
        return false;
    }

    public boolean scrollDownForElement(String xpath) {
        for (int i = 0; i < 20; i++) {
            try {
                WebElement ele = driver.findElement(By.xpath(xpath));
                if (ele.isDisplayed()) {
                    return true;
                }
            } catch (Exception e) {
            }
            scrollDown();
        }
        return false;
    }

    public boolean swipeLeftForElement(String xpath) {
        for (int i = 0; i < 10; i++) {
            try {
                WebElement ele = driver.findElement(By.xpath(xpath));
                if (ele.isDisplayed()) {
                    return true;
                }
            } catch (Exception e) {
            }
            swipeLeft();
        }
        return false;
    }

    public boolean scrollDownForElement(String xpath, int scrollCount) {
        for (int i = 0; i < scrollCount; i++) {
            try {
                WebElement ele = driver.findElement(By.xpath(xpath));
                if (ele.isDisplayed()) {
                    return true;
                }
            } catch (Exception e) {
            }
            scrollDown();
        }
        return false;
    }

    public boolean scrollUpForElement(By by, int scrollCount) {
        for (int i = 0; i < scrollCount; i++) {
            try {
                WebElement ele = driver.findElement(by);
                if (ele.isDisplayed()) {
                    return true;
                }
            } catch (Exception e) {
            }
            scrollUp();
        }
        return false;
    }

    public boolean scrollUpForElement(WebElement element) {
        for (int i = 0; i < 20; i++) {
            try {
                if (element.isDisplayed()) {
                    return true;
                }
            } catch (Exception e) {
            }
            scrollUp();
        }
        return false;
    }


    public MobileElement findElementByName(String name) {
        AppiumDevice device = AppiumDeviceManager.getDevice();
        if (device.getPlatform().equalsIgnoreCase("ios")) {
            return (MobileElement) driver.findElementByName(name);
        } else {
            ArrayList<MobileElement> elementList = (ArrayList<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
            for (MobileElement element : elementList) {
                if (element.getText().replaceAll("\\s+", "").equalsIgnoreCase(name.replaceAll("\\s+", ""))) {
                    return element;
                }
            }
        }
        return null;
    }

    public MobileElement findElementByLabel(String label) {
        String xpath = "";
        AppiumDevice device = AppiumDeviceManager.getDevice();
        if (device.getPlatform().equalsIgnoreCase("ios")) {

            new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(driver.findElement(MobileBy.iOSNsPredicateString(String.format("label BEGINSWITH '%s' and visible==1", label)))));
            try {
                return (MobileElement) driver.findElement(MobileBy.iOSNsPredicateString(String.format("label BEGINSWITH '%s' and visible==1", label)));
            } catch (Exception e) {
                return (MobileElement) driver.findElement(MobileBy.iOSNsPredicateString(String.format("label=='%s'", label)));

            }
        } else {
            // label==text here
            ArrayList<MobileElement> elementList = (ArrayList<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
            for (MobileElement element : elementList) {
                if (element.getText().equalsIgnoreCase(label.trim())) {
                    return element;
                }
            }
        }


        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            scrollDownForElement(driver.findElement(MobileBy.iOSNsPredicateString(String.format("label BEGINSWITH '%s'", label))));
            return (MobileElement) driver.findElement(MobileBy.iOSNsPredicateString(String.format("label BEGINSWITH '%s'", label)));
        } else {
            xpath = String.format("//*[@text='%s']", label);
            scrollDownForElement(driver.findElement(MobileBy.xpath(xpath)));
            return (MobileElement) driver.findElement(MobileBy.xpath(xpath));
        }
    }

    public void scroll(int fromX, int fromY, int toX, int toY) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
    }

    public void scrollDownBySmallAmount() {
        int pressX = driver.manage().window().getSize().width / 2;
        int bottomY = driver.manage().window().getSize().height * 2 / 5;
        int topY = driver.manage().window().getSize().height / 4;
        scroll(pressX, bottomY, pressX, topY);
    }


    public void enterFromKeyboard(MobileElement element, String keyValue) {
        element.click();
        driver.getKeyboard().pressKey(keyValue);
        driver.getKeyboard().pressKey(Keys.ENTER);
    }


    public void doubleClick(MobileElement element) {
        Actions action = new Actions(driver);
        action.doubleClick(element);
        action.perform();


    }


    public void deleteCurrentTextInEditText(MobileElement element) {
        new CommonActions(driver).new ClickAction().clickElement(element);
        String temp = "";
        int stringLength = element.getText().length();
        for (int i = 0; i < stringLength; i++) {
            temp = temp + "\b";
        }
        element.sendKeys(temp);
    }

    /* public void tapIOSCoordinate() {
         IOSTouchAction touch = new IOSTouchAction (driver);
         touch.tap (TapOptions.tapOptions ()
                 .withElement (ElementOption.element (e)))
                 .perform ();
     }*/


    public void tapCoordinate(int x, int y) {
        TouchAction touch = new TouchAction(driver);
        touch.tap(new PointOption().withCoordinates(x, y)).perform();
    }

    public void tapElementCoordinate(MobileElement element) {
        TouchAction touch = new TouchAction(driver);
        Point point = element.getCenter();
        touch.tap(new PointOption().withCoordinates(point)).perform();
    }

    public void tapSearchAndroidKeyboard() {
        Map<String, Object> params = new HashMap<>();
        params.put("keySequence", "KEYBOARD_SEARCH");
        driver.executeScript("mobile:presskey", params);
//        Dimension dimension = driver.manage().window().getSize();
//        int height = (int) (dimension.getHeight() * .95);
//        int width = (int) (dimension.getWidth() * .92);
//        tapCoordinate(width, height);
    }


    public void tapNextAndroidFromKeyboard() {


        Map<String, Object> params = new HashMap<>();
        params.put("keySequence", "KEYBOARD_NEXT");
        driver.executeScript("mobile:presskey", params);
        Map<String, Object> params1 = new HashMap<>();
        params1.put("keySequence", "KEYBOARD_SEARCH");
        driver.executeScript("mobile:presskey", params1);

    }


    public void tapNextAndroidKeyboard() {
        Map<String, Object> params = new HashMap<>();
        params.put("keySequence", "KEYBOARD_GO");
        driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "next"));
    }


    public void tapEnterAndroidKeyboard() {
        driver.getKeyboard();
        Dimension dimension = driver.manage().window().getSize();
        int height = (int) (dimension.getHeight() * .996);
        int width = (int) (dimension.getWidth() * .90);
        tapCoordinate(width, height);
    }

    public void tapElement(MobileElement element) {
        TouchAction touch = new TouchAction(driver);
        touch.tap(
                        new TapOptions().withElement(
                                ElementOption.element(
                                        element)))
                .perform();

    }

    public void waitForLoadingComplete() {
        waitVar.until(ExpectedConditions.invisibilityOfElementLocated((By.xpath("//AndroidLoading | //iOSLoading"))));
    }

    public void androidKeyboardClickDone() {
        try {
            driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Done"));
        } catch (Exception e) {
            Map<String, Object> params = new HashMap<>();
            params.put("keySequence", "KEYBOARD_DONE");
            driver.executeScript("mobile:presskey", params);
        }
    }


    public String getCurrentBanner() {
        return driver.getCapabilities().getCapability("banner").toString();
    }


    public String getmfaexistingAccountUser() {
        return driver.getCapabilities().getCapability("USERNAME_MFA").toString();
    }


    public String getCurrentEnv() {
        return driver.getCapabilities().getCapability("env").toString();
    }

    public String getPlatformName() {
        return driver.getPlatformName();
    }

    public void closeAndRelaunch() throws InterruptedException {
        appRelaunchHelper.closeAndRelaunchApp();

    }

    public void relaunch() throws InterruptedException {

        driver.launchApp();
    }

    public void closeApp() {
        driver.closeApp();
    }


    public void hideKeyBoard() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            driver.hideKeyboard();
        } else {
            driver.getKeyboard().sendKeys(Keys.RETURN);
        }
    }

    public void showKeyBoard() {
        driver.getKeyboard();
    }

    public void androidNavigateBack() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            navigateBack();
        }
    }

    public boolean isElementDisplayed(MobileElement ele) {
        boolean found = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT);
            MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOf(ele));
            if (element.isDisplayed()) {
                found = true;
            }
        } catch (Exception e) {
            found = false;
        }
        return found;
    }

    public boolean isElementDisplayed(MobileElement ele, int waitTime) {
        boolean found = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, waitTime);
            MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOf(ele));
            if (element.isDisplayed()) {
                found = true;
            }
        } catch (Exception e) {
            found = false;
        }
        return found;
    }


    public void moveAppToBackground() {
        driver.runAppInBackground(Duration.ofSeconds(APP_BACKGROUND_TIME));
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            if (driver.getOrientation().toString().equalsIgnoreCase("landscape")) {
                driver.rotate(ScreenOrientation.PORTRAIT);
            }
        }
    }

    public void setDeviceOrientationToPortrait() {
        if (driver.getOrientation().toString().equalsIgnoreCase("landscape")) {
            driver.rotate(ScreenOrientation.PORTRAIT);
        }
    }

    public void enterValue(MobileElement element, String keyValue) {
        element.click();
        element.sendKeys(keyValue);
    }


    public String getText(MobileElement targetElement) {
        new WaitAction(driver).waitForDisplayed(targetElement, 10);
        return targetElement.getText();
    }


    public void refreshScreen() {
        int deviceWidth = driver.manage().window().getSize().getWidth();
        int deviceHeight = driver.manage().window().getSize().getHeight();
        int midX = (deviceWidth / 2);
        int midY = (deviceHeight / 2);
        int bottomEdge = (deviceHeight * 95) / 100;
        new TouchAction(driver)
                .press(point(midX, midY))
                .waitAction(waitOptions(ofMillis(2000)))
                .moveTo(point(midX, bottomEdge))
                .release().perform();
    }

    public boolean isMFAEnabled() {
        return System.getProperty(CommandArgument.MFA_ENABLED, "true").equalsIgnoreCase("true");
    }

    public String generateMFAUserForMailinator() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime ldt = LocalDateTime.now();

        return String.format("test.%s@mailinator.com", dtf.format(ldt));

    }

    public boolean scrollDownForElementWithSmallScroll(WebElement element, int numberOfScrolls) {
        for (int i = 0; i < numberOfScrolls; i++) {
            try {
                if (element.isDisplayed()) {
                    return true;
                }
            } catch (Exception e) {
            }
            scrollDownBySmallAmount();
        }
        return false;
    }

    public String generateMFAUserForGuerrillaMail() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime ldt = LocalDateTime.now();
        return String.format("test.%s@guerrillamail.com", dtf.format(ldt));
    }

    public String generateMFAUserForMail7() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime ldt = LocalDateTime.now();
        return String.format("test.%s@mail7.io", dtf.format(ldt));
    }

    public void waitForDisplayed(MobileElement element) {
        waitVar.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForDisplayed(MobileElement element, int waitTime) {
        //Added Index out of bound to handle List Views which are dynamic
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class).ignoring(IndexOutOfBoundsException.class).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickableAndClick(MobileElement element) {
        waitVar.until(ExpectedConditions.elementToBeClickable(element)).click();
    }


    public Boolean isElementVisible(List<MobileElement> elements) {
        if (elements.size() != 0) {
            return true;
        }
        return false;
    }


    public boolean isElementPresent(By by) {
        boolean found = false;
        try {
            driver.findElement(by);
            found = true;
        } catch (Exception e) {
            found = false;
        }
        return found;

    }

    public void scrollHorizontalCarousal() {
        int fromX = driver.manage().window().getSize().width * 2 / 4;
        int toX = driver.manage().window().getSize().width / 10;
        int fromY = driver.manage().window().getSize().height / 2;
        //   scroll(fromX, fromY, toX, fromY);
        scroll(256, 2314, 0, fromY);
        scroll(fromX, 2314, toX, fromY);
        scroll(fromX, 2314, toX, fromY);

    }

    public boolean scrollDownForEnabledElement(WebElement element) {
        for (int i = 0; i < 20; i++) {
            try {
                if (element.isEnabled()) {
                    return true;
                }
            } catch (Exception e) {
            }
            scrollDown();
        }
        return false;
    }


    public void pleaseWaitForTheLoadingToComplete() {
        try {
            new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class).until((Function<WebDriver, WebElement>) driver -> driver.findElement(By.xpath("//*[contains(@text,'Please')]")));
        } catch (TimeoutException e) {
            //Element is not visible
        }
    }

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

    public void waitForElementToAppear(MobileElement ele, int waitTime) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, waitTime);
            wait.until(ExpectedConditions.visibilityOf(ele));
        } catch (TimeoutException | StaleElementReferenceException | NoSuchElementException e) {
        }

    }

    public String getAttribute(MobileElement ele, String attribute) {
        return ele.getAttribute(attribute);
    }

}





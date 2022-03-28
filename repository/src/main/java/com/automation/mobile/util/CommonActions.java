package com.automation.mobile.util;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.stream.Collectors;

public class CommonActions {
    AppiumDriver driver;

    public CommonActions(AppiumDriver driver) {
        this.driver = driver;
    }

    // Adding the below class for all actions related to table /list
    public class TableActions {

        AppiumDriver driver = CommonActions.this.driver;

        public void scrollDownTillCategoryIsDisplayed(List<MobileElement> allElementsInList, String desiredCategoryName) {
            Set<String> categoryNames;
            ScrollGestures scrollGest = new ScrollGestures();
            CAT_FOUND_LOOP:
            for (int cntVal = 0; cntVal < 20; cntVal++) {
                categoryNames = new HashSet<String>(getCategoryNamesDisplayedWithoutScroll(allElementsInList).stream().map(i -> i.replaceAll("\\s+", "")).collect(Collectors.toList()));
                for (String indCatName : categoryNames) {
                    if (indCatName.contains(desiredCategoryName.replaceAll("\\s+", ""))) {
                        scrollGest.scrollDownBySmallAmount();
                        break CAT_FOUND_LOOP;
                    }
                }
                scrollGest.scrollDownBySmallAmount();
            }
        }

        public List<String> getCategoryNamesDisplayedWithoutScroll(List<MobileElement> allElementsInList) {
            List<String> categoryNames = new ArrayList<String>();
            String attributeVal = driver.getPlatformName().toUpperCase().contains("IOS") ? "name" : "text";
            allElementsInList.stream().forEach(indCatName -> categoryNames.add(indCatName.getAttribute(attributeVal).trim()));
            return categoryNames;
        }
    }

    public class ScrollGestures {
        AppiumDriver driver = CommonActions.this.driver;

        public void scrollDownBySmallAmount() {
            int pressX = driver.manage().window().getSize().width / 2;
            int bottomY = driver.manage().window().getSize().height * 2 / 5;
            int topY = driver.manage().window().getSize().height / 4;
            scroll(pressX, bottomY, pressX, topY);
        }

        public void scroll(int fromX, int fromY, int toX, int toY) {
            TouchAction touchAction = new TouchAction(driver);
            touchAction.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
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

    }

    public class ClickAction {
        AppiumDriver driver = CommonActions.this.driver;
        private final int WAIT_FOR_ELEMENT_TIMEOUT = 10;

        //Click
        public void clickElement(WebElement ele) {
            int count = 0;
            while (count < 3) {
                try {
                    WebDriverWait wait = new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT);
                    MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOf(ele));
                    if (element.isDisplayed()) {
                        element.click();
                        break;
                    }
                } catch (StaleElementReferenceException e) {
                    //StaleElementReferenceException caught, trying again..
                }
                count++;
            }
        }

        public void clickIfEnabled(WebElement ele) {
            int count = 0;
            while (count < 3) {
                try {
                    if (ele.isEnabled()) {
                        ele.click();
                        break;
                    }
                } catch (StaleElementReferenceException e) {
                    //StaleElementReferenceException caught, trying again..
                }
                count++;
            }
        }

        public void doubleClick(MobileElement element) {
            new CommonActions(driver).new ClickAction().clickElement(element);
            new CommonActions(driver).new ClickAction().clickElement(element);
        }

        //Click
        public void androidKeyboardClickDone() {
            driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Done"));
        }

        public void clickTextOnScreen(String arg0) {
            if (driver.getPlatformName().equalsIgnoreCase("android")) {
                String text = "new UiSelector().text(\"" + arg0 + "\")";
                new ScrollGestures().scrollDownForElement(driver.findElement(MobileBy.AndroidUIAutomator(text)));
                new CommonActions(driver).new ClickAction().clickElement(driver.findElement(MobileBy.AndroidUIAutomator(text)));
            } else {
                new ScrollGestures().scrollDownForElement(driver.findElementByName(arg0));
                new CommonActions(driver).new ClickAction().clickElement(driver.findElementByName(arg0));
            }
        }

        public void clickButtonText(String button) {
            MobileElement element;
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                element = (MobileElement) driver.findElementByName(button);
            } else {
                String selector = "new UiSelector().textContains(" + "\"" + button + "\"" + ")";
                element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(selector));
            }
            element.click();
        }

        public void tapElementCoordinate(MobileElement element) {
            TouchAction touch = new TouchAction(driver);
            Point point = element.getCenter();
            touch.tap(new PointOption().withCoordinates(point)).perform();
        }
    }

    public class ElementActions {
        public boolean checkPresenceOfChildUsingParentElement(MobileElement parentElement, String locatorType, String locatorValue) {
            try {
                switch (locatorType.toUpperCase()) {
                    case "XPATH":
                        parentElement.findElementByXPath(locatorValue);
                        break;
                    case "NAME":
                        parentElement.findElementByName(locatorValue);
                        break;
                    case "ID":
                        parentElement.findElementById(locatorValue);
                        break;
                    default:
                        throw new RuntimeException("Please select valid locator");
                }
            } catch (NoSuchElementException e) {
                return false;
            }

            return true;
        }

        public Map<String, String> getElementLocatorValueAndType(MobileElement desiredElement) {
            Map<String, String> elemValues = new HashMap<>();
            String elementValue = desiredElement.toString().split(">")[1];
            elemValues.put(elementValue.split(":")[0].trim(), StringUtils.chop(elementValue.split(":")[1].trim()));
            return elemValues;
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
    }
}

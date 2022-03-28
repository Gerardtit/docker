package com.automation.mobile.util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WaitAction {
    private static Logger logger = LogManager.getLogger();
    private WebDriverWait waitVar;
    private static AppiumDriver driver;

    public WaitAction(AppiumDriver driver) {
        this.driver = driver;
        this.waitVar = new WebDriverWait(driver, 10);
    }

    public void waitForDisplayed(MobileElement element) {
        waitVar.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForDisplayed(MobileElement element, int waitTime) {
        //Added Index out of bound to handle List Views which are dynamic
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class).ignoring(IndexOutOfBoundsException.class).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
    }

    //Wait
    public void waitForLoadingComplete() {
        waitVar.until(ExpectedConditions.invisibilityOfElementLocated((By.xpath("//AndroidLoading | //iOSLoading"))));
    }

    //Wait
    public void waitForClickableAndClick(MobileElement element) {
        waitVar.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    //Wait
    public void waitForTextPresentInElement(MobileElement element, String text) {
        waitVar.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    //Wait
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

    //Wait
    public void waitForElementToDisappear(String xpath, int waitTime) {
        for (int i = 0; i < waitTime; i++) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 1);
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
            } catch (Exception e) {
                return;
            }
        }
    }

    //Wait
    public void waitforUMAhomeScreen(MobileElement element) {
        waitVar.until(ExpectedConditions.invisibilityOf(element));
    }

    //Wait
    public void pleaseWaitForTheLoadingToComplete() {
        try {
            new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class).until((Function<WebDriver, WebElement>) driver -> driver.findElement(By.xpath("//*[contains(@text,'Please')]")));
        } catch (TimeoutException e) {
            //Element is not visible
        }
    }

    //Wait
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

    //Wait
    public void waitForElementToBeClickable(MobileElement element, int secondsToWait) {
        try {
            new FluentWait<>(driver).withTimeout(Duration.ofSeconds(secondsToWait)).pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException te) {
            // Do nothing
        }
    }

    //Wait
    public MobileElement waitForElement(By by, int durationInSeconds) {
        FluentWait<AppiumDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(durationInSeconds)).pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(TimeoutException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return (MobileElement) element;
    }

    public static void sleep(String platform, int milliSeconds) {
        logger.info(String.format("Sleeping %s milliseconds...", milliSeconds));
        if (platform.equalsIgnoreCase("BOTH") || driver.getPlatformName().equalsIgnoreCase(platform)) {
            try {
                Thread.sleep(milliSeconds);
            } catch (InterruptedException ie) {
                // Do nothing here
            }
        }
    }

    public static void waitForElementToBeEnabled(MobileElement element, int secondsToWait) {
        try{
            Awaitility.waitAtMost(secondsToWait, TimeUnit.SECONDS).pollInterval(1, TimeUnit.SECONDS).until(() -> element.isEnabled());
        }catch (ConditionTimeoutException cte){
        }
    }
}

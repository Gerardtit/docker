package com.automation.mobile.util;

import com.automation.mobile.appium.AppiumDriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;


public class ADAUtils {
    AppiumDriver driver = AppiumDriverManager.getDriver();
    Map<String, Object> params = new HashMap<>();
    public int Counter = 15;
    public int ShopCounter = 8;


    public void ADAWait() throws InterruptedException {
        Thread.sleep(5000);
    }

    public void ADAscroll(int fromX, int fromY, int toX, int toY) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
    }

    public void addProduct() {

    }

    public void ADAscrollDown() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            int pressX = driver.manage().window().getSize().width / 3;
            int bottomY = (driver.manage().window().getSize().height * 2) / 3;
            int topY = driver.manage().window().getSize().height / 4;
            ADAscroll(pressX, bottomY, pressX, topY);
        } else {
            int pressX = driver.manage().window().getSize().width / 3;
            int bottomY = (driver.manage().window().getSize().height * 3) / 4;
            int topY = driver.manage().window().getSize().height / 14;
            ADAscroll(pressX, bottomY, pressX, topY);
        }
    }

    public void ADAAudit(String ADATag) throws InterruptedException {
        ADAWait();
        params.put("tag", ADATag);
        try {
            driver.executeScript("mobile:checkAccessibility:audit", params);
        } catch (Exception e) {
            System.out.println("ADA Error Caught!!");
        }
        ADAWait();
    }

    public boolean scrollDownForElement(WebElement element) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            try {
                if (element.isDisplayed()) {
                    return true;
                }
            } catch (Exception e) {
            }
            ADAInspector("Search");
            ADAscrollDown();
        }
        return false;
    }


//    public void ADAInspector(String ADATag) throws InterruptedException {
//        if (ADATag == "Home") {
//            for (int i = 0; i < Counter; i++) {
//                ADAAudit(ADATag);
//                ADAscrollDown();
//            }
//        } else if (ADATag == "Shop") {
//            ADAWait();
//            for (int i = 0; i < ShopCounter; i++) {
//                ADAAudit(ADATag);
//                ADAscrollDown();
//            }
//        } else if (ADATag == "Member") {
//            ADAAudit(ADATag);
//
//        }
//        else {ADAAudit(ADATag);}
//    }

    public void Home(String ADATag) throws InterruptedException {
        for (int i = 0; i < Counter; i++) {

            ADAAudit(ADATag);
            ADAscrollDown();
        }
    }

    public void Shop(String ADATag) throws InterruptedException {
        for (int i = 0; i < ShopCounter; i++) {

            ADAAudit(ADATag);
            ADAscrollDown();
        }
    }


    public void ADAScrolldown(String ADATag) throws InterruptedException {
        ADAAudit(ADATag);
        ADAscrollDown();
    }

    public void ADAInspector(String ADATag) throws InterruptedException {
        switch (ADATag) {
            case "Home":
                Home(ADATag);
            case "Shop":
                Shop(ADATag);
            default:
                ADAScrolldown(ADATag);
        }
    }


}

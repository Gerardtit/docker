package com.automation.mobile.util;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.entities.FileLocations;
import com.automation.mobile.entities.MobileConfType;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {
    static public String captureScreenshot(AppiumDevice device, AppiumDriver driver) throws IOException {
        String banner = device.getBanner();
        String deviceName = device.getConfigureData(MobileConfType.DEVICE_NAME);
        String currentDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = FileLocations.REPORT_DIRECTORY + "screenshot/"
                + banner + "_" + deviceName + "/" + "screenshot" + currentDate + ".png";
        File target = new File(path);
        FileUtils.copyFile(src, target);
        return "./screenshot/" + banner + "_" + deviceName + "/" + "screenshot" + currentDate + ".png";
        //return path;

    }


    static public byte[] captureScresenshot(AppiumDriver driver) throws IOException {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    public String getMatchFromStringUsingRegex(String regexPattern, String inputVal, int desiredIndex) {
        Matcher m = Pattern.compile(regexPattern).matcher(inputVal);
        m.find();
        return m.group(desiredIndex);
    }

    public String resolveBannerNameForHost(String banner) {
        String resolvedBanner = banner;
        if (banner.contains("acme")) {
            resolvedBanner = "acmemarkets";
        } else if (banner.contains("carrs")) {
            resolvedBanner = "carrsqc";
        }
        return resolvedBanner;
    }
}


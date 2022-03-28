package com.automation.mobile.core.execution.banner;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.DesiredCapabilityBuilder;
import com.automation.mobile.core.execution.device.DeviceManager;
import com.automation.mobile.entities.Banner;
import com.automation.mobile.entities.Device;
import com.automation.mobile.helpers.ExecutionHelper;
import com.automation.mobile.manager.ConfigFileManager;

import java.io.IOException;
import java.util.Map;

public class BannerProcessor {

    private Banner banner;

    public BannerProcessor(Banner pBanner) {

        this.banner = pBanner;
    }

    public void start() throws IOException, InterruptedException {

        setAppDetails();

        DeviceManager.getInstance().startDeviceExecutions(banner);
    }

    private void setAppDetails() throws IOException, InterruptedException {

        AppiumDevice appiumDevice;

        String branchName = "";

        String buildSlug = "";

        String appSlug = "";

        System.setProperty("BITRISE_TOKEN", banner.getBitriseToken());

        for (Device device : banner.getDevices()) {

            Map<String, String> deviceProps = ConfigFileManager.getMobilePropertyMap(device.getName());

            deviceProps.put("banner", banner.getName());
            deviceProps.put("env", banner.getEnvironment());
            deviceProps.put("app", "shop");
            deviceProps.put("STATE", "AVAILABLE");
            deviceProps.put("REGISTERUSER", "");
            deviceProps.put("app_slug", device.getBitriseBuild().getString("appSlug"));
            deviceProps.put("mobileDevice", device.getName());

            if (device.getBitriseBuild().has("buildSlug")) {

                buildSlug = device.getBitriseBuild().getString("buildSlug");
            } else if (!branchName.equals(device.getBitriseBuild().getString("branch"))
                    && !appSlug.equalsIgnoreCase(device.getBitriseBuild().getString("appSlug"))) {

                appSlug = device.getBitriseBuild().getString("appSlug");

                branchName = device.getBitriseBuild().getString("branch");

                appiumDevice = new AppiumDevice(deviceProps);

                appiumDevice.setBitriseData(device.getBitriseBuild());

                buildSlug = ExecutionHelper.startBitriseBuild(appiumDevice);
            }

            deviceProps.put("build_slug", buildSlug);

            appiumDevice = new AppiumDevice(deviceProps);

            appiumDevice.setBitriseData(device.getBitriseBuild());

            device.setAppPath(DesiredCapabilityBuilder.getAppPath(appiumDevice));

            device.setAppName(DesiredCapabilityBuilder.getAppName(appiumDevice));

            device.setBuildSlug(buildSlug);

            device.setAppSlug(device.getBitriseBuild().getString("appSlug"));
        }
    }
}
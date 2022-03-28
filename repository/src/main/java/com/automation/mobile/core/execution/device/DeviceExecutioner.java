package com.automation.mobile.core.execution.device;

import com.automation.mobile.core.execution.FeatureExecutioner;
import com.automation.mobile.entities.Banner;
import com.automation.mobile.entities.Device;

public class DeviceExecutioner extends Thread {

    private Device device;

    private Banner banner;

    public DeviceExecutioner(Device device, Banner banner) {

        this.device = device;

        this.banner = banner;
    }

    @Override
    public void run() {

        try {

            for (String featureName : device.getFeatures()) {

                FeatureExecutioner featureExecutioner = new FeatureExecutioner(banner, device, featureName);

                featureExecutioner.execute();

                System.gc();
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}

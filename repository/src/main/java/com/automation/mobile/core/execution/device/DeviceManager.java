package com.automation.mobile.core.execution.device;

import com.automation.mobile.entities.Banner;
import com.automation.mobile.entities.Device;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DeviceManager {

    public static ExecutorService threadPool;

    private static DeviceManager _deviceManager = null;

    public static DeviceManager getInstance() {

        if (DeviceManager._deviceManager == null) {

            DeviceManager._deviceManager = new DeviceManager();
        }

        return DeviceManager._deviceManager;
    }

    public void startDeviceExecutions(Banner banner) {

        try {

            threadPool = Executors.newFixedThreadPool(banner.getDevices().size());

            for (Device device : banner.getDevices()) {

                DeviceExecutioner deviceExecutioner = new DeviceExecutioner(device, banner);

                threadPool.submit(deviceExecutioner);
            }
            threadPool.shutdown();

            threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }
}

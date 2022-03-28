package com.automation.mobile.core.framework;

import com.automation.mobile.core.configurations.ConfigHandler;
import com.automation.mobile.core.execution.ExecutionManager;
import com.automation.mobile.entities.Banner;
import com.automation.mobile.entities.Device;
import com.automation.mobile.helpers.TestRailHelper;
import com.automation.mobile.services.testrail.APIException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Framework {

    public void startExecution() throws IOException, APIException {

        ConfigHandler.initConfig();

        initTestRail();

        List<Banner> banners = getBannerDetails();

        ExecutionManager.getInstance().StartBannerExecution(banners);
    }

    private List<Banner> getBannerDetails() {

        Banner banner;

        List<Banner> banners = new ArrayList<>();

        JSONArray bannersArray = ConfigHandler.config.getJSONArray("banners");

        boolean testrail = ConfigHandler.config.getBoolean("isTestrail");

        for (int i = 0; i < bannersArray.length(); i++) {

            Device device;

            List<Device> devices = new ArrayList<>();

            banner = new Banner();

            JSONObject bannerObject = bannersArray.getJSONObject(i);

            banner.setName(bannerObject.getString("name"));

            banner.setEnvironment(ConfigHandler.config.getString("environment"));

            banner.setBitriseToken(ConfigHandler.config.getString("bitriseToken"));

            JSONArray devicesArray = bannerObject.getJSONArray("devices");

            for (int x = 0; x < devicesArray.length(); x++) {

                JSONObject deviceObject = devicesArray.getJSONObject(x);

                device = new Device();

                device.setName(deviceObject.getString("name"));

                device.setFeatures(deviceObject.has("features") ? getList(deviceObject.getJSONArray("features"))
                        : getList(bannerObject.getJSONArray("features")));

                if (deviceObject.has("tags") || (bannerObject.has("tags"))) {
                    device.setTag(deviceObject.has("tags") ? deviceObject.getString("tags")
                            : bannerObject.getString("tags"));
                }
                device.setBitriseBuild(deviceObject.has("bitriseBuild") ? deviceObject.getJSONObject("bitriseBuild")
                        : bannerObject.getJSONObject("bitriseBuild"));

                devices.add(device);
            }

            banner.setDevices(devices);

            if (testrail) {

                banner.setPlanName(ConfigHandler.config.getJSONObject("testrail").getString("planName"));

                banner.setTestrailUser(ConfigHandler.config.getJSONObject("testrail").getString("userName"));

                banner.setTestrailPassword(ConfigHandler.config.getJSONObject("testrail").getString("password"));
            }

            banners.add(banner);
        }

        return banners;
    }

    private List<String> getList(JSONArray jsonArray) {

        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {

            stringList.add(jsonArray.getString(i));
        }

        return stringList;
    }

    private void initTestRail() throws IOException, APIException {

        if (ConfigHandler.config.getBoolean("isTestrail")) {

            System.setProperty("TESTRAIL_USER", ConfigHandler.config.getJSONObject("testrail").getString("userName"));

            System.setProperty("TESTRAIL_PASSWORD", ConfigHandler.config.getJSONObject("testrail").getString("password"));

            TestRailHelper.initTesPlan(ConfigHandler.config.getJSONObject("testrail").getString("planName"));
        }
    }
}
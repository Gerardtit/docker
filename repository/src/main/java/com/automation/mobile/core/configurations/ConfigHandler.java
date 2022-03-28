package com.automation.mobile.core.configurations;

import com.automation.mobile.entities.FileLocations;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;

public class ConfigHandler {

    public static JSONObject config;

    public static void initConfig() {

        String configFileName = FileLocations.CONFIG_FILE_NAME;
        try {
            if (new File(configFileName).exists()) {

                FileInputStream inputStream = new FileInputStream(configFileName);

                String contents = IOUtils.toString(inputStream, "UTF-8");

                config = new JSONObject(contents);
            } else {

                config = new JSONObject(System.getenv("APP_CONFIG"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

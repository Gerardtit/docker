package com.automation.mobile.entities;

import org.json.JSONObject;

import java.util.List;

public class Device {

    private String name;

    private List<String> features;

    private JSONObject bitriseBuild;

    private String appSlug;

    private String buildSlug;

    private String appName;

    private String appPath;

    private String tag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppSlug() {
        return appSlug;
    }

    public void setAppSlug(String appSlug) {
        this.appSlug = appSlug;
    }

    public String getBuildSlug() {
        return buildSlug;
    }

    public void setBuildSlug(String buildSlug) {
        this.buildSlug = buildSlug;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public String getAppPath() {
        return appPath;
    }

    public void setAppPath(String appPath) {
        this.appPath = appPath;
    }

    public JSONObject getBitriseBuild() {
        return bitriseBuild;
    }

    public void setBitriseBuild(JSONObject bitriseBuild) {
        this.bitriseBuild = bitriseBuild;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}

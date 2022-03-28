package com.automation.mobile.entities;

import java.util.List;

public class Banner {

    private String name;

    private String environment;

    private String bitriseToken;

    private String planName;

    private String testrailUser;

    private String testrailPassword;

    private List<Device> devices;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getBitriseToken() {
        return bitriseToken;
    }

    public void setBitriseToken(String bitriseToken) {
        this.bitriseToken = bitriseToken;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getTestrailUser() {
        return testrailUser;
    }

    public void setTestrailUser(String testrailUser) {
        this.testrailUser = testrailUser;
    }

    public String getTestrailPassword() {
        return testrailPassword;
    }

    public void setTestrailPassword(String testrailPassword) {
        this.testrailPassword = testrailPassword;
    }
}

package com.automation.mobile.core.execution;

import com.automation.mobile.core.configurations.ConfigHandler;
import com.automation.mobile.entities.Banner;
import com.automation.mobile.entities.Device;
import com.automation.mobile.entities.FileLocations;
import org.apache.maven.shared.invoker.*;

import java.io.File;
import java.util.Arrays;
import java.util.Properties;

public class FeatureExecutioner {

    private final Banner banner;

    private final Device appiumDevice;

    private final String featureName;

    public FeatureExecutioner(Banner banner, Device appiumDevice, String featureName) {

        this.banner = banner;

        this.appiumDevice = appiumDevice;

        this.featureName = featureName;
    }

    public void execute() throws MavenInvocationException {

        String[] args;

        String mobileDevice = appiumDevice.getName();

        String banner = this.banner.getName();

        String environment = this.banner.getEnvironment();

        String appSlug = appiumDevice.getAppSlug();

        String buildSlug = appiumDevice.getBuildSlug();

        String tag = appiumDevice.getTag();

        Properties props = new Properties();

        props.setProperty("APP_SLUG", appSlug);

        props.setProperty("BUILD_SLUG", buildSlug);

        props.setProperty("APP_PATH", appiumDevice.getAppPath());

        props.setProperty("APP_NAME", appiumDevice.getAppName());

        props.setProperty("BITRISE_TOKEN", this.banner.getBitriseToken());

        if (ConfigHandler.config.getBoolean("isTestrail")) {

            props.setProperty("PLAN_NAME", (null != this.banner.getPlanName()) ? this.banner.getPlanName() : "");

            props.setProperty("TESTRAIL_USER", (null != this.banner.getTestrailUser()) ? this.banner.getTestrailUser() : "");

            props.setProperty("TESTRAIL_PASSWORD", (null != this.banner.getTestrailPassword()) ? this.banner.getTestrailPassword() : "");
        }

        if (null != appiumDevice.getTag() && !appiumDevice.getTag().isEmpty()) {

            args = new String[]{"test", "-Dtest=MobileRunner -Dbanner=" + banner, "-DmobileDevice=" + mobileDevice,
                    "-DmobileEnv=" + environment, "-Dcucumber.features=" + featureName, "-Dcucumber.filter.tags=" + appiumDevice.getTag()};

        } else {

            args = new String[]{"test", "-Dtest=MobileRunner -Dbanner=" + banner, "-DmobileDevice=" + mobileDevice,
                    "-DmobileEnv=" + environment, "-Dcucumber.features=" + featureName};
        }
        Invoker invoker = new DefaultInvoker();

        invoker.setMavenHome(new File(System.getenv("M2_HOME")));

        InvocationRequest request = new DefaultInvocationRequest();

        request.setPomFile(new File(FileLocations.APPLICATION_DIRECTORY + "/pom.xml"));

        request.setGoals(Arrays.asList(args));

        request.setProperties(props);

        InvocationResult result = invoker.execute(request);

        if (result.getExitCode() != 0) {
            if (null != result.getExecutionException()) {
                System.out.println(result.getExecutionException().getMessage());
            }
        }
    }
}

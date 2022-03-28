package com.automation.steps;

import com.automation.helpers.AppActions;
import com.automation.helpers.DeviceHelper;
import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.appium.DesiredCapabilityBuilder;
import com.automation.mobile.entities.FileLocations;
import com.automation.mobile.entities.MobileConfType;
import com.automation.mobile.helpers.TestRailHelper;
import com.automation.mobile.manager.DataFileManager;
import com.automation.mobile.manager.ThreadLocalManager;
import com.automation.mobile.models.Feature;
import com.automation.mobile.models.FeatureScenario;
import com.automation.mobile.models.ScenarioStep;
import com.automation.mobile.services.testrail.APIException;
import com.automation.mobile.util.CommonUtil;
import com.automation.mobile.util.ExecutionData;
import com.automation.mobile.util.GlobalVar;
import com.automation.pages.GG_DashboardPage;
import com.automation.pages.GG_ShoppingModePage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.*;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HookService {
    AppiumDevice appiumDevice = AppiumDeviceManager.getDevice();
    boolean testrail = GlobalVar.testrail;
    GG_DashboardPage dashboardPage;
    PickleStepTestStep currentStep;
    int counter = 0;

    @Before("@start_scenario")
    public void before(Scenario scenario) throws IOException, APIException {
        System.out.println("**************hooks*********************" + Thread.currentThread().getId());

        if (appiumDevice == null) {
            synchronized (GlobalVar.DEVICE_LIST) {
                for (String mobile : GlobalVar.DEVICE_LIST.keySet()) {
                    Map<String, String> tempMap = GlobalVar.DEVICE_LIST.get(mobile);
                    if (tempMap.get("STATE").equalsIgnoreCase("available")) {
                        tempMap.put("STATE", "BUSY");
                        System.out.println(GlobalVar.DEVICE_LIST);

                        //create appium device
                        appiumDevice = new AppiumDevice(tempMap);
                        appiumDevice.setBitriseData(GlobalVar.BITRISE_DATA.get(mobile));
                        AppiumDeviceManager.setDevice(appiumDevice);

                        //create desired capability
                        DesiredCapabilityBuilder.buildDesiredCapability(appiumDevice);
                        System.out.println(appiumDevice);
                        System.out.println(Thread.currentThread().getId());

                        //create appium server
                        AppiumDriver appiumDriver = new AppiumDriverManager().
                                initializeDriver(new URL(appiumDevice.getConfigureData(MobileConfType.APPIUM_SERVER)),
                                        DesiredCapabilityBuilder.getDesiredCapability());
                        AppiumDriverManager.setDriver(appiumDriver);
                        AppiumDriverManager.addDriver(appiumDriver);

                        //Below code will install the app again, this will ensure execution always starts on signin page
                        try {
                            new DeviceHelper(AppiumDriverManager.getDriver()).unInstallApp();
                            new DeviceHelper(AppiumDriverManager.getDriver()).installApp();
                            AppiumDriverManager.getDriver().launchApp();
                        } catch (Exception e) {
                            System.out.println("Exception caught while installing the app again, that's ok moving on..");
                        }

                        // Storing below key/value pairs which are used at the end to download perfecto accessibility reports for scenarios involving for Accessibility(ADA) test
                        ExecutionData.executionData.put("IS_ADA", scenario.getSourceTagNames().toString().toUpperCase().contains("ADA"));
                        ExecutionData.executionData.put("EXECUTION_ID", (String) AppiumDriverManager.getDriver().getCapabilities().getCapability("executionId"));
                        ExecutionData.executionData.put("PERFECTO_TOKEN", AppiumDeviceManager.getDevice().getConfigureData(MobileConfType.CLOUD_TOKEN));
                        break;
                    }
                }
            }
        }

        setTestCaseData();

        // App is launched already when driver is created, so now launching app based on flag
        if (AppiumDriverManager.getDriver() != null) {
            AppiumDriverManager.getDriver().launchApp();
        }
    }

    public void setTestCaseData() throws IOException, APIException {

        String featureName = getFeatureName();

        if (!featureName.equalsIgnoreCase(ThreadLocalHelper.featureName.get())) {

            DataFileManager dataFileManager = new DataFileManager(featureName, appiumDevice);

            ThreadLocalHelper.featureName.set(featureName);
            dataFileManager.read();
            ThreadLocalHelper.testCaseData.set(dataFileManager.getTestCaseData());
            if (testrail) {

                TestRailHelper.setupTestRail(ThreadLocalHelper.feature.get().getUri().getPath(),
                        appiumDevice);
            }

        }
    }

    @BeforeStep
    public void getStepName(Scenario scenario) throws Exception {

        Field f1 = scenario.getClass().getDeclaredField("delegate");
        f1.setAccessible(true);
        TestCaseState tcs = (TestCaseState) f1.get(scenario);

        Field f2 = tcs.getClass().getDeclaredField("testCase");
        f2.setAccessible(true);
        TestCase r = (TestCase) f2.get(tcs);

        List<PickleStepTestStep> stepDefs = r.getTestSteps()
                .stream()
                .filter(x -> x instanceof PickleStepTestStep)
                .map(x -> (PickleStepTestStep) x)
                .collect(Collectors.toList());

        currentStep = stepDefs.get(counter);
    }

    @AfterStep
    public void afterStep(Scenario scenario) throws IOException {
        if (AppiumDriverManager.getDriver() != null) {
            if (scenario.isFailed()) {
                takeScreenShot(scenario);
            }
        }
        if (testrail) {
            Feature lFeature = ThreadLocalManager.feature.get();
            FeatureScenario featureScenario = lFeature.getFromName(scenario.getName());
            ScenarioStep scenarioStep = featureScenario.getFromName(currentStep.getStep().getText());
            if (scenario.isFailed()) {
                scenarioStep.setStatus(5);
                scenarioStep.setComment(ExceptionUtils.getFullStackTrace(getError(scenario)));
                String fileName = takeScreenShot();
                featureScenario.setFileName(fileName);
            } else {
                scenarioStep.setStatus(1);
                scenarioStep.setComment("Step is Passed");
                scenarioStep.setCounter(counter + 1);
            }
        }

        counter += 1;
    }

    @After("@network_scenario")
    public void afterStepNetworkScenario() throws IOException, InterruptedException {
        // Relaunching app at the end of scenario involving turning off/on internet
        Thread.sleep(5000);
        new AppActions().relaunchApp();
        Thread.sleep(5000);
    }

    @After("@end_scenario")
    public void afterScenario(Scenario scenario) {
        if (AppiumDriverManager.getDriver() != null) {
            try {
                dashboardPage = new GG_DashboardPage(AppiumDriverManager.getDriver());
                new AppActions().terminateApp();
                new AppActions().relaunchApp();
                if (appiumDevice.getPlatform().equalsIgnoreCase("android")) {
                    if (dashboardPage.waitForCacheContinue(7)) {
                        dashboardPage.clickContinueCache();
                    }
                }
                if (scenario.getSourceTagNames().toString().contains("@network_scenario")) {
                    dashboardPage.clickOkIfDisplayed();
                }
                dashboardPage.handleTutorial(2);
                dashboardPage.goToHomeTabWithTutorialHandling();
                dashboardPage.signOutFromTheApp();
            } catch (Exception e) {
                e.printStackTrace();
            }
            AppiumDriverManager.getDriver().closeApp();
        }
    }

    @After
    public void performStepsForScenarioSignInConsistency(Scenario desiredScenario) throws IOException, APIException {
        if (AppiumDriverManager.getDriver() != null) {
            if (desiredScenario.isFailed()) {
                if (!desiredScenario.getSourceTagNames().toString().contains("@end_scenario")) {
                    try {
                        //Perform Failure Steps
                        new AppActions().terminateApp();
                        new AppActions().relaunchApp();
                        dashboardPage = new GG_DashboardPage(AppiumDriverManager.getDriver());
                        if (dashboardPage.waitForFeedbackForm(7)) {
                            dashboardPage.clickOnCancelButtonFeedbackFormIfDisplayed();
                        } else {
                            new GG_ShoppingModePage(AppiumDriverManager.getDriver()).enterDefaultZipCodeAndStartShopping();
                        }

                        dashboardPage.clickAllow();

                        if (desiredScenario.getSourceTagNames().toString().contains("@network_scenario")) {
                            dashboardPage.clickOkIfDisplayed();
                        }

                        if (appiumDevice.getPlatform().equalsIgnoreCase("android")) {
                            dashboardPage.clickContinueCache();
                        }
                        dashboardPage.handleTutorial(2);
                        if (!dashboardPage.isStartupPageDisplayed()) {
                            if (desiredScenario.getSourceTagNames().toString().contains("@network_scenario")) {
                                dashboardPage.clickHomeTab();
                                dashboardPage.clickOkIfDisplayed();
                                dashboardPage.handleTutorial(2);
                            } else {
                                dashboardPage.goToHomeTabWithTutorialHandling();
                            }
                        }

                        // Handling failures involving network scenarios: we will turn on the internet here if the network scenario has failed
                        if (desiredScenario.getSourceTagNames().toString().contains("@network_scenario")) {
                            try {
                                new DeviceHelper(AppiumDriverManager.getDriver()).turnOnInternetByPlatform();
                                Thread.sleep(5000);
                            } finally {
                                new AppActions().relaunchApp();
                                Thread.sleep(5000);
                                dashboardPage.handleTutorial(2);
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (testrail) {
            Feature lFeature = ThreadLocalManager.feature.get();
            FeatureScenario featureScenario = lFeature.getFromName(desiredScenario.getName());
            if (desiredScenario.isFailed()) {
                featureScenario.setStatus(5);
                featureScenario.setComment(ExceptionUtils.getFullStackTrace(getError(desiredScenario)));
            } else {
                featureScenario.setStatus(1);
                featureScenario.setComment("Scenario is Passed");
            }
            TestRailHelper.updateResult(lFeature, featureScenario);
        }
    }

    private String getFeatureName() {
        String featurePath = ThreadLocalHelper.feature.get().getUri().getPath();
        return FilenameUtils.removeExtension(featurePath.substring(featurePath.lastIndexOf("/") + 1));
    }

    private String takeScreenShot() throws IOException {

        String fileName = "screenshot-" + new SimpleDateFormat("yyyyMMddHHmm'.png'").format(new Date());

        Path path = Paths.get(FileLocations.SCREENSHOT_DIRECTORY);

        if (Files.notExists(path)) {

            Files.createDirectories(path);
        }

        String filePath = FileLocations.SCREENSHOT_DIRECTORY + fileName;

        File file = ((TakesScreenshot) AppiumDriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(file, new File(filePath));

        return filePath;
    }

    private Throwable getError(Scenario scenario) throws IOException {
        Method getError;
        try {
            Field f1 = scenario.getClass().getDeclaredField("delegate");
            f1.setAccessible(true);
            TestCaseState tcs = (TestCaseState) f1.get(scenario);
            getError = MethodUtils.getMatchingMethod(tcs.getClass(), "getError");
            getError.setAccessible(true);
            return (Throwable) getError.invoke(tcs);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void takeScreenShot(Scenario scenario) throws IOException {
        AppiumDevice device = AppiumDeviceManager.getDevice();
        String deviceName = device.getConfigureData(MobileConfType.DEVICE_NAME);
        String currentDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        scenario.attach(CommonUtil.captureScresenshot(AppiumDriverManager.getDriver()), "image/png", device.getBanner() + "_" + deviceName + "_" + currentDate);
    }
}


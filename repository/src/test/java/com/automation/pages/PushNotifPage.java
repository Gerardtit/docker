package com.automation.pages;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.PushNotifPageElements;
import com.automation.rest.constants.RestConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PushNotifPage extends BasePage {

    //    public AppiumDriver driver;
    public JSONArray currentTSDataRowsJSONArray = null;
    public JSONObject currentTestDataJSONObj = null;
    public Response response = null;
    public String testScriptName = null;
    public String bodyParams = null;
    public File bodyDataFile = null;
    public Integer statusCode = null;
    public Map<String, String> queryParams = new HashMap<String, String>();
    public Map<String, String> headersParams = new HashMap<String, String>();
    public Map<String, String> pathParams = new HashMap<String, String>();
    public RestConstants restConstants = new RestConstants();
    List<String> pathParamsNames = new ArrayList<String>();
    private boolean notificationFound = false;
    private final PushNotifPageElements pageElements = new PushNotifPageElements();
    private final TouchAction touchAction = new TouchAction(driver);
//    AndroidDriver androidDriver = new AndroidDriver(remoteAddress, desiredCapabilities);

    public PushNotifPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
        testScriptName = this.getClass().getSimpleName();
        testScriptName = "Verify" + testScriptName + "Test";

//        if (driver.getPlatformName().equalsIgnoreCase("android")) {
//            currentTSDataRowsJSONArray = getJSONParseAuthData(getCurrentEnv(), ThreadLocalHelper.testCaseData.get().get("BOGO_CATEGORY");, GlobalConstants.bannerName.toUpperCase());
//        } else {
//            currentTSDataRowsJSONArray = getJSONParseAuthData(GlobalConstants.currentEnv.toLowerCase(), GlobalConstants.LocalyticsAPIData.LOCALYTICS_API_DATA_IOS.toString(), GlobalConstants.bannerName.toUpperCase());
//        }
    }

    public Response performPostCallWithBodyAsFileWithBasicAuth(String userName, String password, String restURI, String getCallParamsProcess, Map<String, String> queryParams, Map<String, String> pathParams, List<String> pathParamsNames, Map<String, String> headerParams, File bodyDataFile) throws Exception {
        Response response = null;
        try {
            if (getCallParamsProcess.equalsIgnoreCase("NoParams")) {
                response =
                        given().
                                auth().preemptive().basic(userName, password).
                                body(bodyDataFile).contentType("application/json").
                                when().
                                post(restURI);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return (response);
    }


    public File getBodyDataFile(String bodyDataFolderPath, String testEnvironment, String bodyDatafileName) throws Exception {
        File bodyDataFile = null;
        try {
            String bodyDataFilePath = RestConstants.testDataFilePathWindows + "\\" + bodyDataFolderPath + "\\" + testEnvironment.toLowerCase() + "\\" + bodyDatafileName;
            System.out.println(bodyDataFilePath);
            bodyDataFile = new File(bodyDataFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (bodyDataFile);
    }


    public void parseJson(String str) throws Exception {
        RestAssured.baseURI = ThreadLocalHelper.testCaseData.get().get("URI");
        bodyParams = testScriptName + ".json";
//        String pushSection = str;
        if (driver.getPlatformName().equalsIgnoreCase("android"))
            bodyDataFile = getBodyDataFile(RestConstants.PushNotificationData.PUSH_NOTIFICATION_DATA_ANDROID.toString(), getCurrentEnv(), bodyParams);
        else
            bodyDataFile = getBodyDataFile(RestConstants.PushNotificationData.PUSH_NOTIFICATION_DATA_IOS.toString(), getCurrentEnv(), bodyParams);
        response = performPostCallWithBodyAsFileWithBasicAuth(ThreadLocalHelper.testCaseData.get().get("USER"), ThreadLocalHelper.testCaseData.get().get("PASSWORD"), RestAssured.baseURI, GetCallArgs.NOPARAMS.toString(), queryParams, pathParams, pathParamsNames, headersParams, bodyDataFile);
        statusCode = response.getStatusCode();
        System.out.println(":::Status Code:::" + statusCode);
        System.out.println("Message" + response.asString());
    }

    public void dragNotificationBar() throws InterruptedException {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
//            ((AndroidDriver) driver).openNotifications();
            scroll(500, 0, 500, 1900);
            Thread.sleep(2000);
            List<MobileElement> allnotifications = driver.findElementsById(("android:id/big_text"));
            System.out.println("no of notifications " + allnotifications.size());

            for (WebElement mobileElement : allnotifications) {
                System.out.println(mobileElement.getText());
                if (mobileElement.getText().contains("UMA Android Push Notif")) {
                    System.out.println("Notification found");
                    mobileElement.click();
                    notificationFound = true;
                    break;
                }
            }

        } else {
            Thread.sleep(3000);
            driver.launchApp();
            scroll(150, 0, 150, 500);
            Thread.sleep(3000);
            String notif = pageElements.allNotif.getAttribute("label");
            if (notif.contains(getCurrentBanner())) {
                new CommonActions(driver).new ClickAction().clickElement(pageElements.allNotif);
                notificationFound = true;
            }
        }
        Assert.assertTrue(notificationFound, "Notification not found ");

    }

    public enum GetCallArgs {

        QUERYPARAM {
            @Override
            public String toString() {
                return "Query";
            }
        },
        HEADERPARAM {
            @Override
            public String toString() {
                return "Headers";
            }
        },
        PATHPARAM {
            @Override
            public String toString() {
                return "Path";
            }
        },
        QUERYHEADERS {
            @Override
            public String toString() {
                return "QueryHeaders";
            }
        },
        QUERYPATH {
            @Override
            public String toString() {
                return "QueryPath";
            }
        },
        PATHHEADERS {
            @Override
            public String toString() {
                return "PathHeaders";
            }
        },
        NOPARAMS {
            @Override
            public String toString() {
                return "NoParams";
            }
        },
        ALLPARAMS {
            @Override
            public String toString() {
                return "AllParams";
            }
        }
    }
}

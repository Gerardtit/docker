package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.PushNotifPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class PushNotifSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    PushNotifPage pushNotifPage = new PushNotifPage(driver);


    @When("^updated the json file for \"([^\"]*)\"$")
    public void update_json_file(String pushSection) throws Exception {
        pushNotifPage.parseJson(pushSection);
    }

    @And("^user drag down notification bar to check for incoming notification$")
    public void drag_notification_bar() throws Exception {
        pushNotifPage.dragNotificationBar();
    }

}

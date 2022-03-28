package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.util.WaitAction;
import com.automation.pages.ChatPage;
import com.automation.pages.HomePage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChatPageSteps {

    AppiumDriver driver = AppiumDriverManager.getDriver();
    public HomePage homePage = new HomePage(driver);
    public ChatPage chatPage = new ChatPage(driver);

    @Then("^\"([^\"]*)\" link is displayed$")
    public void linkIsDisplayed(String link) {

//        Thread.sleep(3000);
        new WaitAction(driver).waitForLoadingComplete();

        chatPage.waitForLinkDisplayed(link);
    }

    @When("^user click on \"([^\"]*)\" link$")
    public void user_click_link(String link) throws Throwable {
        Thread.sleep(3000);
        try {
            chatPage.clickChatLink(link);
        } catch (Exception e) {
        }
    }

    @Then("^user sees chat Help for \"([^\"]*)\"$")
    public void chat_help_options(String link) throws Throwable {
        try {
            chatPage.verifyChatOptions(link);
        } catch (Exception e) {
        }
    }
}

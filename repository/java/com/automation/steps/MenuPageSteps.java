package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.MenuPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;

public class MenuPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public MenuPage menuPage = new MenuPage(driver);

    @Then("^menu page is displayed$")
    public void menu_page_is_displayed() throws Throwable {
        try {
            menuPage.waitForMenuPageDisplayed();
        } catch (Exception e) {
        }
    }

    @When("^user click sign out button on menu page$")
    public void user_click_sign_out_button_on_menu_page() throws Throwable {
        try {
            menuPage.clickSignOutButton();
        } catch (Exception e) {
        }
    }

    @Then("^confirm sign out page is displayed$")
    public void confirm_sign_out_page_is_displayed() throws Throwable {
        try {
            menuPage.waitForConfirmSignOutDisplayed();
        } catch (Exception e) {
        }
    }

    @When("^user click ok button to confirm sign out$")
    public void user_click_ok_button_to_confirm_sign_out() throws Throwable {
        try {
            menuPage.clickSignOutConfirmButton();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @When("^user clicks account on menu page$")
    public void userClicksAccountOnMenuPage() {
        menuPage.clickAccount();
    }


    @When("^user clicks feedback on menu page$")
    public void userClicksFeedbackOnMenuPage() {
        menuPage.hideKeyBoard();
        menuPage.clickFeedback();
    }

    @When("^user clicks orders on menu page$")
    public void userClicksOrdersOnMenuPage() {
        menuPage.clickOrder();
    }

    @When("^navigate back to previous level$")
    public void navigateBackToPreviousLevel() {
        menuPage.navigateFromSubLevel();
    }

    @When("^user clicks Help FAQ on menu page$")
    public void userClicksHelpFAQOnMenuPage() {
        menuPage.clickHelpFAQ();
    }

    @Then("^help FAQ window is displayed$")
    public void helpFAQWindowIsDisplayed() {
        menuPage.waitForHelpFAQDisplayed();
    }

    @When("^user clicks Contact Us on menu page$")
    public void userClicksContactUsOnMenuPage() {
        menuPage.clickContactUs();
    }

    @When("^user clicks Chat on the contact us page$")
    public void userClicksChatOnTheContactUsPage() {
        menuPage.clickChat();
    }

    @When("^user clicks Delivery & Pickup Questions$")
    public void userClicksDeliveryPickupQuestions() {
        menuPage.clickDeliveryPickUp();
    }

    @When("^user clicks Terms and policy on menu page$")
    public void userClicksTermsAndPolicyOnMenuPage() {
        menuPage.clickTermsPolicy();
    }

    @When("^user clicks \"([^\"]*)\" text on page$")
    public void userClicksTextOnPage(String arg0) {
        menuPage.waitForLoadingComplete();
        menuPage.clickTextOnScreen(arg0);
    }

    @When("^user clicks Need Help Chatbot on current page$")
    public void userClicksNeedHelpChatbotOnCurrentPage() {
        menuPage.clickNeedHelpChatbot();
    }

    @And("^verify Version is displayed on menu page$")
    public void verifyVersionIsDisplayedOnMenuPage() {
        menuPage.verifyVersionDisplayed();
        menuPage.scrollTop();
    }
}

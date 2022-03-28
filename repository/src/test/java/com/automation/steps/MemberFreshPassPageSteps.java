package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.MemberFreshPassPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MemberFreshPassPageSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public AppiumDevice device = AppiumDeviceManager.getDevice();
    MemberFreshPassPage memberFreshPassPage = new MemberFreshPassPage(driver);


    @When("user verify How much you could save")
    public void user_verify_how_much_you_could_save() {
        memberFreshPassPage.verifyHowMuchYouCouldSave();
    }

    @When("user click on the dollar 425 link")
    public void user_click_on_the_dollar_425_link() throws InterruptedException {
        memberFreshPassPage.clickOnSaveUpToDollarAYearLink();
    }

    @Then("user should see Estimated Savings is appear with text")
    public void user_should_see_estimated_savings_is_appear_with_text() {
        memberFreshPassPage.verifyEstimatedSavings();
        memberFreshPassPage.verifyEstimatedSavingsText();
    }

    @Then("user should see welcome if no first name")
    public void user_should_see_if_no_first_name() {
        memberFreshPassPage.verifyWelcomeTextIfNoFirstNameLastName();
    }

    @Then("user should see first name appear if first name last name is available")
    public void user_should_see_first_name_appear_if_first_name_last_name_is_available() {
        memberFreshPassPage.verifyFirstNameIfFirstNameLastNameIsAvailable();
    }

    @Then("user should see long first name appear with three dot if too many characters to fit in text label")
    public void user_should_see_long_first_name_appear_with_three_dot_if_too_many_characters_to_fit_in_text_label() {
        memberFreshPassPage.verifyLongFirstNameIfFirstNameHaveTooManyCharacter();
    }

}

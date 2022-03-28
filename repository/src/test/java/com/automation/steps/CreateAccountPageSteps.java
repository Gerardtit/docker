package com.automation.steps;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.manager.ConfigFileManager;
import com.automation.pages.CreateAccountPage;
import com.automation.pages.MyAccountPage;
import com.automation.pages.SignInPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class CreateAccountPageSteps {
    public AppiumDevice device = AppiumDeviceManager.getDevice();
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public SignInPage signInPage = new SignInPage(driver);
    public CreateAccountPage createAccountPage = new CreateAccountPage(driver);
    public MyAccountPage myAccountPage = new MyAccountPage(driver);
    public SignInPageSteps signInPageSteps = new SignInPageSteps();
    public ZipCodePageSteps zipCodePageSteps = new ZipCodePageSteps();
    public String zipCode = "zipcode";
    public String firstName = "firstname";
    public String lastName = "lastname";
    public String password = "password";

    public String getCurrentBanner() {
        return driver.getCapabilities().getCapability("banner").toString();
    }

    public String getCurrentEnv() {
        return driver.getCapabilities().getCapability("env").toString();
    }

    @When("^user enters \"([^\"]*)\" in phone number field on CreateAccount Page$")
    public void user_enters_in_phone_number_field_on_CreateAccount_Page(String arg1) throws Throwable {
        arg1 = "7022" + new SimpleDateFormat("HHmmss").format(new Date());
        createAccountPage.enterPhoneOrCardNumber(arg1);
    }

    @When("^user enters \"([^\"]*)\" in email field on CreateAccount Page$")
    public void user_enters_in_email_field_on_CreateAccount_Page(String arg1) throws IOException {
        String banner = getCurrentBanner();
        String env = getCurrentEnv();
        String currentDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String email = banner + "_" + env + "_" + currentDate + "@example.com";
        Map<String, String> bannerProperty = ConfigFileManager.getBannerPropertyMap(banner, env);
        ThreadLocalHelper.testCaseData.get().put("USERNAME", email);
        createAccountPage.enterEmail(email);
    }

    @When("^user enters \"([^\"]*)\" in password field on CreateAccount Page$")
    public void user_enters_in_password_field_on_CreateAccount_Page(String arg1) {
        createAccountPage.enterPassword("Pass1234");
    }

    @When("^user clicks continue button on createAccount page$")
    public void user_clicks_continue_button_on_createAccount_page() throws InterruptedException {
        createAccountPage.clickContinueButton();
        Thread.sleep(1000);
    }

    @Then("^create account page (\\d+) is displayed$")
    public void create_account_page_is_displayed(int pageNumber) throws Throwable {
        createAccountPage.waitForCreateAccountPageDisplayed(pageNumber);
    }

    @When("^user enters \"([^\"]*)\" in address field on CreateAccount Page$")
    public void user_enters_in_address_field_on_CreateAccount_Page(String arg1) throws Throwable {
        createAccountPage.enterAddress1(ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE1"));
    }

    @When("^user enters \"([^\"]*)\" and \"([^\"]*)\" as first name and last name on CreateAccount Page$")
    public void user_enters_and_as_first_name_and_last_name_on_CreateAccount_Page(String arg1, String arg2) throws Throwable {
        createAccountPage.enterFirstLastName(ThreadLocalHelper.testCaseData.get().get("FIRSTNAME"), ThreadLocalHelper.testCaseData.get().get("LASTNAME"));
    }

    @When("^user select Agree on CreateAccount Page$")
    public void user_select_Agree_on_CreateAccount_Page() throws Throwable {
        createAccountPage.checkAgreeBox();
    }

    @When("^user select \"([^\"]*)\" reference on CreateAccount Page$")
    public void user_select_reference_on_CreateAccount_Page(String arg1) throws Throwable {
        createAccountPage.selectReference(arg1);
    }

    @When("^user select residential on createAccount page$")
    public void user_select_residential_on_createAccount_page() throws Throwable {
        createAccountPage.selectResidential();
    }

    @And("^user clicks shop now button on createAccount page$")
    public void userClicksShopNowButtonOnCreateAccountPage() {
        createAccountPage.clickShopNowButton();
    }


    @And("^user clicks continue button second time for android on createAccount page$")
    public void userClicksContinueButtonSecondTimeForAndroidOnCreateAccountPage() throws InterruptedException {
        if (driver.getPlatformName().equalsIgnoreCase("android"))
            user_clicks_continue_button_on_createAccount_page();
    }

    @Then("^ios user select not save the password$")
    public void iosUserSelectNotSaveThePassword() {
        createAccountPage.iosUserClickNotSaveFromPopup();
    }

    @Then("^Sign up page is displayed$")
    public void signUpPageIsDisplayed() {
        createAccountPage.waitForSignupPageDisplayed();
    }

    @When("^user enters \"([^\"]*)\" on First Name field on Sign up page$")
    public void userEntersOnFirstNameFieldOnSignUpPage(String firstName) throws Throwable {
        createAccountPage.enterFirstName(firstName);
    }

    @And("^user enters \"([^\"]*)\" on Last Name field on Sign up page$")
    public void userEntersOnLastNameFieldOnSignUpPage(String lastName) {
        createAccountPage.enterLastName(lastName);
    }

    @And("^user enters random email address on Email Address field on Sign up page$")
    public void userEntersRandomEmailAddressOnEmailAddressFieldOnSignUpPage() {
        String banner = device.getBanner();
        String env = device.getEnv();
        String currentDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String email = banner + "_" + env + "_" + currentDate + "@example.com";
        createAccountPage.enterEmail(email);
    }

    @And("^user enters \"([^\"]*)\" password on Sign up page$")
    public void userEntersPasswordOnSignUpPage(String password) {
        createAccountPage.enterPassword(password);
    }

    @And("^user enters random phone number on Sign up page$")
    public void userEntersRandomPhoneNumberOnSignUpPage() {
        String number = new SimpleDateFormat("yyMM").format(new Date())
                + new SimpleDateFormat("ddmmss").format(new Date());
        createAccountPage.enterPhoneCardNo(number);
    }

    @And("^user clicks Create Account button on Sign up page$")
    public void userClicksCreateAccountButtonOnSignUpPage() {
        createAccountPage.clickCreateAccountButton();
    }

    @Then("^ios popup save confirm message$")
    public void iosPopupSaveConfirmMessage() {
        if (device.getPlatform().equalsIgnoreCase("ios")) {
            myAccountPage.PopupSaveConfirmMessage();
        }
    }

    @And("^user enters \"([^\"]*)\" phone or club card number on Sign up page$")
    public void userEntersClubCardNumberOnSignUpPage(String cardNumber) {
        createAccountPage.enterPhoneCardNo(cardNumber);
    }

    @When("^user clicks term of use link on Sign up page$")
    public void userClicksTermOfUseLinkOnSignUpPage() {
        createAccountPage.clickTermOfUse();
    }

    @And("^android user clicks using webview browser$")
    public void androidUserClicksUsingWebviewBrowser() {
        createAccountPage.clickUsingWebviewBrowser();
    }

    @And("^user clicks navigate back to the previous page$")
    public void userClicksNavigateBackToThePreviousPage() {
        createAccountPage.navigateBack();
    }

    @And("^user clicks privacy term link on Sign up page$")
    public void userClicksPrivacyTermLinkOnSignUpPage() {
        createAccountPage.clickPrivacyTerm();
    }

    @And("^user enters \"([^\"]*)\" email address on Email Address field on Sign up page$")
    public void userEntersEmailAddressOnEmailAddressFieldOnSignUpPage(String email) {
        createAccountPage.enterEmail(email);
    }

    @Then("^email error mark is displayed on Sign up page$")
    public void emailErrorMarkIsDisplayedOnSignUpPage() {
        createAccountPage.verifyEmailErrorMark();
    }

    @Then("^phone card error mark is displayed on Sign up page$")
    public void phoneCardErrorMarkIsDisplayedOnSignUpPage() {
        createAccountPage.verifyPhoneCardErrorMark();
    }

    @Then("^password error mark is displayed on Sign up page$")
    public void passwordErrorMarkIsDisplayedOnSignUpPage() {
        if (device.getPlatform().equalsIgnoreCase("ios")) {
            createAccountPage.verifyPasswordErrorMark();
        } else {
            //android create account grey
        }
    }


    @And("^username should be there$")
    public void usernameShouldBeThere() {
    }

    @And("^user successfully creates an Account$")
    public void user_successfully_creates_an_Account() throws Throwable {
        signInPageSteps.user_clicks_CreateAccount_on_Sign_In_Page();
        zipCodePageSteps.zipcode_page_is_displayed();
        zipCodePageSteps.user_enters_in_zipcode_page(zipCode);
        zipCodePageSteps.user_clicks_next_button_on_zipcode_page();
        signUpPageIsDisplayed();
        userEntersOnFirstNameFieldOnSignUpPage(firstName);
        userEntersOnLastNameFieldOnSignUpPage(lastName);
        userEntersRandomEmailAddressOnEmailAddressFieldOnSignUpPage();
        userEntersPasswordOnSignUpPage(password);
        userEntersRandomPhoneNumberOnSignUpPage();
        userClicksCreateAccountButtonOnSignUpPage();

    }


}

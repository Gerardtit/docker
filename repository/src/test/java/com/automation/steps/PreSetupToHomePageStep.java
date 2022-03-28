package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.util.WaitAction;
import com.automation.pages.*;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class PreSetupToHomePageStep {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public AppiumDevice device = AppiumDeviceManager.getDevice();
    public ZipCodePage zipCodePage = new ZipCodePage(driver);
    public HomePage homePage = new HomePage(driver);
    public MenuPage menuPage = new MenuPage(driver);
    public SignInPageSteps signInPageSteps = new SignInPageSteps();
    public HomePageSteps homePageSteps = new HomePageSteps();
    public CartPageSteps cartPageSteps = new CartPageSteps();


    public PreSetupToHomePageStep() {
    }

    @Given("^navigate to home page$")
    public void navigateFromAnyPageToHomePage() throws Throwable {
        SignInPageSteps signInPageSteps = new SignInPageSteps();
        HomePageSteps homePageSteps = new HomePageSteps();
        ZipCodePageSteps zipCodePageSteps = new ZipCodePageSteps();
        ChooseAccountPageSteps chooseAccountPageSteps = new ChooseAccountPageSteps();

        try {
            //displayed home page
            homePageSteps.home_page_is_displayed();
            return;
        } catch (Throwable throwable) {
            try {
                //displayed zip code page with sign in button
                zipCodePageSteps.zipcode_page_is_displayed();
                try {
                    //displayed signin button
                    zipCodePageSteps.user_clicks_Sign_in_button_on_zipcode_page();
                    signInPageSteps.sign_in_page_is_displayed();
                    navigateFromSigninPageToHomepage();
                    return;
                } catch (Exception e) {
                    // not displayed sign in button
                    //When user enters "zipcode" in zipcode page
                    zipCodePageSteps.user_enters_in_zipcode_page("zipcode");
                    //And user clicks next button on zipcode page
                    zipCodePageSteps.user_clicks_next_button_on_zipcode_page();
                    return;
                }
            } catch (Throwable e) {
                //displayed SSO page
                //click continue as guest
                chooseAccountPageSteps.click_continue_as_guest();
                //wait for zipcode page displayed
                zipCodePageSteps.zipcode_page_is_displayed();
                //click sign in button
                zipCodePageSteps.user_clicks_Sign_in_button_on_zipcode_page();
                signInPageSteps.sign_in_page_is_displayed();
                navigateFromSigninPageToHomepage();
                return;
            }
        }
    }

    @Given("^navigate to sign in page$")
    public void navigateFromAnyPageToSigninPage() throws Throwable {
        SignInPageSteps signInPageSteps = new SignInPageSteps();
        HomePageSteps homePageSteps = new HomePageSteps();
        ZipCodePageSteps zipCodePageSteps = new ZipCodePageSteps();
        ChooseAccountPageSteps chooseAccountPageSteps = new ChooseAccountPageSteps();

        try {
            //zipcode page
            zipCodePageSteps.zipcode_page_is_displayed();
            try {
                //sign in button displayed
                zipCodePageSteps.user_clicks_Sign_in_button_on_zipcode_page();
                return;
            } catch (Exception e) {
                // no signin button displayed
                //When user enters "zipcode" in zipcode page
                zipCodePageSteps.user_enters_in_zipcode_page("zipcode");
                //And user clicks next button on zipcode page
                zipCodePageSteps.user_clicks_next_button_on_zipcode_page();
                homePageSteps.home_page_is_displayed();
                navigateFromHomePageToSigninpage();
                return;
            }

        } catch (Throwable throwable) {
            try {
                //home page displayed
                homePageSteps.home_page_is_displayed();
                navigateFromHomePageToSigninpage();
                return;
            } catch (Exception e) {
                //SSO page displayed
                try {
                    chooseAccountPageSteps.choose_account_page_displayed();
                } catch (Exception exception) {
                    Thread.sleep(3000);
                }
                chooseAccountPageSteps.click_continue_as_guest();
                zipCodePageSteps.zipcode_page_is_displayed();
                zipCodePageSteps.user_clicks_Sign_in_button_on_zipcode_page();
                return;
            }
        }

    }

    public void navigateToHomePage() throws Throwable {
        new WaitAction(driver).waitForLoadingComplete();
        try {
            homePage.waitForHomePageDisplayed();
            return;
        } catch (Exception e) {
            navigateToSignInPage();
            signInPageSteps.user_enters_in_username_field_on_Sign_In_page("email");
            signInPageSteps.user_enters_in_password_field_on_Sign_In_page("password");
            signInPageSteps.user_clicks_sign_in_on_sign_in_page();
        }
    }


    public void navigateToSignInPage() throws Throwable {
        ZipCodePageSteps zipCodePageSteps = new ZipCodePageSteps();

        new WaitAction(driver).waitForLoadingComplete();
        try {
            //if zipcode page
            zipCodePage.waitForZipCodePageDisplayed();
            //try {
            zipCodePage.clickSignInButton();
            //} catch (Exception e) {
            //    zipCodePageSteps.user_enters_in_zipcode_page("zipcode");
            //    zipCodePageSteps.user_clicks_next_button_on_zipcode_page();
            //}
        } catch (Exception e) {
            //if home page
            homePage.waitForHomePageDisplayed();
            homePage.clickMenuIcon();
            menuPage.waitForMenuPageDisplayed();
            menuPage.clickSignOutButton();
            menuPage.waitForConfirmSignOutDisplayed();
            menuPage.clickSignOutConfirmButton();
        }
    }

    @When("^navigate to available checkout page from home page$")
    public void navigateToAvailableCheckoutPageFromHomePage() throws Throwable {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPageSteps checkoutPageSteps = new CheckoutPageSteps();

        homePageSteps.user_clicks_shopping_cart_button_on_home_page();
        cartPageSteps.shopping_cart_page_is_displayed();
        Thread.sleep(2000);

        String pageStatus = "new";

        try {
            //checkout button found
            //enabled
            if (cartPage.checkoutButtonEnabled()) {
                cartPage.navigateBack();
                return;
            } else {
                //checkout button disabled
                cartPageSteps.user_empty_shopping_cart();
                cartPageSteps.shopping_cart_empty_page_is_displayed();
            }
        } catch (Exception e) {
            //no checkout button - empty cart
        }
        cartPage.navigateBack();
        homePageSteps.home_page_is_displayed();
        homePageSteps.userClicksSearchBarOnHomePage();
        homePageSteps.userTypesOnSearchBarAndClickSearchOnHomePage("Baby lotion");
        homePageSteps.verifyResultIsDisplayedOnThePage();
        homePageSteps.userClicksItemAddButtonOnFirstItem("1");
        homePageSteps.userChangeQuantityToNumberOfItems("9");
        homePageSteps.userGoesBackToHomePageFromSearchPage();
    }

    @When("^navigate from signin page to homepage$")
    public void navigateFromSigninPageToHomepage() throws Throwable {

        SignInPageSteps signInPageSteps = new SignInPageSteps();
        SelectOrderTypePageSteps selectOrderTypePageSteps = new SelectOrderTypePageSteps();

        //When user enters "email" in username field on Sign In page
        signInPageSteps.user_enters_in_username_field_on_Sign_In_page("email");
        //And user enters "password" in password field on Sign In page
        signInPageSteps.user_enters_in_password_field_on_Sign_In_page("password");
        //And user clicks sign in on sign in page
        signInPageSteps.user_clicks_sign_in_on_sign_in_page();
        //Then select order type page is displayed
        //  selectOrderTypePageSteps.select_order_type_page_is_displayed();
        //When user click delivery option
        //  selectOrderTypePageSteps.user_click_delivery_option();
        //And user click start shopping button on Sign In page
        //  selectOrderTypePageSteps.user_click_start_shopping_button_on_Sign_In_page();
    }

    @When("^navigate from homepage to signin page$")
    public void navigateFromHomePageToSigninpage() throws Throwable {

        MenuPageSteps menuPageSteps = new MenuPageSteps();
        HomePageSteps homePageSteps = new HomePageSteps();

        //When user click menu button on home page
        homePageSteps.user_click_menu_button_on_home_page();
        //Then menu page is displayed
        menuPageSteps.menu_page_is_displayed();
        //When user click sign out button on menu page
        menuPageSteps.user_click_sign_out_button_on_menu_page();
        //Then confirm sign out page is displayed
        menuPageSteps.confirm_sign_out_page_is_displayed();
        //When user click ok button to confirm sign out
        menuPageSteps.user_click_ok_button_to_confirm_sign_out();
    }
}

package com.automation.steps;

import com.automation.pages.FindStorePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import cucumber.api.java.en.Then;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.models.Result;
import com.automation.pages.WelcomePage;
import com.automation.rest.LoginService;
import com.automation.rest.Lists.ListsServices;
import com.automation.rest.Miscs.MiscsServices;
import com.automation.rest.Rewards.RewardsServices;
import com.automation.rest.Stores.StoresServices;
import com.automation.rest.UCA.UCAServices;
import com.automation.rest.offers.OffersService;

import cucumber.api.java.en.And;
import cucumber.api.java.en.But;

public class WelcomeScreenSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public WelcomePage welcomePage = new WelcomePage(driver);
    public FindStorePage findStorePage = new FindStorePage(driver);


    @Then("^Verify the Welcome Title is visible$")
    public void verifyWelcomeTitle() throws Throwable {

        welcomePage.waitForWelcomeScreenDisplayed();
    }

    @Then("^Verify the Welcome Text is visible$")
    public void verifyWelcomeText() throws Throwable {

        welcomePage.verifyWelcomeText();
    }

    @Then("^Click on Get Started Button$")
    public void clickGetStartedBtn() throws Throwable {
        welcomePage.waitForWelcomeScreenDisplayed();
        Thread.sleep(2000);
        welcomePage.clickGetStartedBtn();
    }

    @Then("^verify next preference screen$")
    public void verifyNextPreferenceScreen() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            findStorePage.waitForFindStoreScreenDisplayed();
        } else {
            welcomePage.pushNotificationScreenIsDisplayed();
        }
    }

    @And("^allow push notification permission$")
    public void allowPushNotificationPermission() throws InterruptedException {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Thread.sleep(3000);
            welcomePage.clickAllowNotificationButton();
            welcomePage.clickAllowInNotificaitonPopUp();
        }
    }

    @When("^authenticate the app$")
    public void authenticateTheApp() throws InterruptedException {
        Thread.sleep(5000);
        welcomePage.clickContinueButton();
//      if(driver.getPlatformName().equalsIgnoreCase("android")) {
////        welcomePage.errorPopupClose();
//          welcomePage.enterUsername();
//          welcomePage.enterPassword();
//          welcomePage.clickSignInButton();
//        } else {
//          welcomePage.clickContinueButton();
//        }
    }

    @Then("^Get Access Token$")
    public void getAccessToken() throws Throwable {
        LoginService loginService = new LoginService(this.driver);

        Result result = loginService.getAccessToken();

        System.out.println(result.getStatusMsg());
    }

    @Then("^Get All Offers$")
    public void getAllOffers() throws Throwable {
        OffersService offersService = new OffersService(this.driver);

        Result result = offersService.getAllOffers();

        System.out.println(result.getStatusMsg());
    }


    @Then("^Get Category$")
    public void getCategory() throws Throwable {
        OffersService offersService = new OffersService(this.driver);

        Result result = offersService.getCategory();

        System.out.println(result.getStatusMsg());
    }

    @Then("^Get Weekly Specials$")
    public void getWeeklySpecials() throws Throwable {
        OffersService offersService = new OffersService(this.driver);

        Result result = offersService.getWeeklySpecials();

        System.out.println(result.getStatusMsg());
    }

    @Then("^Post Offer Clip$")
    public void postOfferClip() throws Throwable {
        OffersService offersService = new OffersService(this.driver);

        Result result = offersService.postOfferClip();

        System.out.println(result.getStatusMsg());
    }


    @Then("^Get Hidden Categories$")
    public void getHiddenCategories() throws Throwable {
        UCAServices ucaService = new UCAServices(this.driver);

        Result result = ucaService.getHiddenCategories();

        System.out.println(result.getStatusMsg());
    }

    @Then("^Get List Of Categories$")
    public void getListOfCategories() throws Throwable {
        UCAServices ucaService = new UCAServices(this.driver);

        Result result = ucaService.getListOfCategories();

        System.out.println(result.getStatusMsg());
    }

    @Then("^Get Preferred Store$")
    public void getPreferredStore() throws Throwable {
        UCAServices ucaService = new UCAServices(this.driver);

        Result result = ucaService.getPreferredStore();

        System.out.println(result.getStatusMsg());
    }

    @Then("^Get UCA Profile$")
    public void getUCAProfile() throws Throwable {
        UCAServices ucaService = new UCAServices(this.driver);

        Result result = ucaService.getUCAProfile();

        System.out.println(result.getStatusMsg());
    }

    @Then("^Patch Communication Preferences$")
    public void patchCommunicationPreferences() throws Throwable {
        UCAServices ucaService = new UCAServices(this.driver);

        Result result = ucaService.patchCommunicationPreferences();

        System.out.println(result.getStatusMsg());
    }


    @Then("^Patch Update Category Preference$")
    public void patchUpdateCategoryPreference() throws Throwable {
        UCAServices ucaService = new UCAServices(this.driver);

        Result result = ucaService.patchUpdateCategoryPreference();

        System.out.println(result.getStatusMsg());
    }

    @Then("^Get List Of Stores$")
    public void getListOfStores() throws Throwable {
        StoresServices storeService = new StoresServices(this.driver);

        Result result = storeService.getListOfStores();

        System.out.println(result.getStatusMsg());
    }

    @Then("^Get Store Detail$")
    public void getStoreDetail() throws Throwable {
        StoresServices storeService = new StoresServices(this.driver);

        Result result = storeService.getStoreDetail();

        System.out.println(result.getStatusMsg());
    }


    @Then("^Get Store Resolver Home$")
    public void getStoreResolverHome() throws Throwable {
        StoresServices storeService = new StoresServices(this.driver);

        Result result = storeService.getStoreResolverHome();

        System.out.println(result.getStatusMsg());
    }


    @Then("^Get Grocery Rewards$")
    public void getGroceryRewards() throws Throwable {
        RewardsServices rewardService = new RewardsServices(this.driver);

        Result result = rewardService.getGroceryRewards();

        System.out.println(result.getStatusMsg());
    }

    @Then("^Get Rewards Summary$")
    public void getRewardsSummary() throws Throwable {
        RewardsServices rewardService = new RewardsServices(this.driver);

        Result result = rewardService.getRewardsSummary();

        System.out.println(result.getStatusMsg());
    }


    @Then("^Get mobile Ads$")
    public void getmobileAds() throws Throwable {
        MiscsServices miscService = new MiscsServices(this.driver);

        Result result = miscService.getmobileAds();

        System.out.println(result.getStatusMsg());
    }

    @Then("^Get Nimbus Feature API$")
    public void getNimbusFeatureAPI() throws Throwable {
        MiscsServices miscService = new MiscsServices(this.driver);

        Result result = miscService.getNimbusFeatureAPI();

        System.out.println(result.getStatusMsg());
    }

    @Then("^Get My List$")
    public void getMyList() throws Throwable {
        ListsServices listService = new ListsServices(this.driver);

        Result result = listService.getMyList();

        System.out.println(result.getStatusMsg());
    }


    @Then("^Post My List Delete Item$")
    public void postMyListDeleteItem() throws Throwable {
        ListsServices listService = new ListsServices(this.driver);

        Result result = listService.postMyListDeleteItem();

        System.out.println(result.getStatusMsg());
    }


    @Then("^Post Aisle Sort$")
    public void postAisleSort() throws Throwable {
        ListsServices listService = new ListsServices(this.driver);

        Result result = listService.postAisleSort();

        System.out.println(result.getStatusMsg());
    }


}

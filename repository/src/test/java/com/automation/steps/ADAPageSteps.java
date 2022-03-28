package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.helpers.ExecutionHelper;
import com.automation.mobile.util.ADAUtils;
import com.automation.pageElements.*;
import com.automation.pages.*;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.time.Instant;


public class ADAPageSteps {
    AppiumDriver driver = AppiumDriverManager.getDriver();
    public HomePage homePage = new HomePage(driver);
    public GG_DealsPage dealsPage = new GG_DealsPage(driver);
    public BrowsePage browsePage = new BrowsePage(driver);
    public GG_MylistPage myADAListPage = new GG_MylistPage(driver);
    public GG_DashboardPage hamburgerMenu = new GG_DashboardPage(driver);
    public GG_WalletPage walletPage = new GG_WalletPage(driver);
    public GG_foru_rewardsPage learnMore = new GG_foru_rewardsPage(driver);
    public GG_MyRewardsElements rewadsforuElements = new GG_MyRewardsElements();
    public DealsAllCouponPageElements pageElements = new DealsAllCouponPageElements();
    public Deals_AllCouponsPage couponClickPage = new Deals_AllCouponsPage(driver);
    public GG_Deals_ForYouSteps couponsClickPage = new GG_Deals_ForYouSteps();
    public HomePage homeElements = new HomePage(driver);
    public HomePageElements ADAhomePageElements = new HomePageElements();
    public GG_OtpPasswordPage otpPasswordPage = new GG_OtpPasswordPage(driver);
    public GG_MyCartPage myADACartPage = new GG_MyCartPage(driver);
    public Deals_AllCouponsPage ADAdealsPage = new Deals_AllCouponsPage(driver);
    public GG_Deals_AllDealsPageElements ADApageElements = new GG_Deals_AllDealsPageElements();
    public GG_Deals_AllDealsPage ADApageElement = new GG_Deals_AllDealsPage(driver);
    public GG_Deals_ForYouPageElements ADAdealsForYouPageElements = new GG_Deals_ForYouPageElements();
    public GG_ShoppingModePage ADAReserveTime = new GG_ShoppingModePage(driver);
    public GG_FreshPAss_MembertabSteps ADAFreshPass = new GG_FreshPAss_MembertabSteps();
    public Deals_AllCouponsPage ADAClippeddeals = new Deals_AllCouponsPage(driver);
    public GG_MyItemsPage ADALastorderTab = new GG_MyItemsPage(driver);
    public GG_MylistPage ADAmyListPage = new GG_MylistPage(driver);

    public ADAUtils adaUtils = new ADAUtils();


    @When("^user clicks on ADA Home page Tab$")
    public void userClicksOnADAHomePage() throws InterruptedException {
        homePage.clickHomePageTab();
        adaUtils.ADAInspector("Home");
    }

    @When("^user clicks on ADA Deals page$")
    public void userClicksOnADADealsPage() throws InterruptedException {
        homePage.clickHomePageTab();
        homePage.clickDealTab();
        adaUtils.ADAInspector("Deal");
    }

    @When("^user clicks on ADA Shop page$")

    public void userClickonADAShop() throws InterruptedException {
        homePage.clickHomePageTab();
        browsePage.clickonSHOPTabofHomePage();
        adaUtils.ADAInspector("Shop");
    }

    @When("^user clicks on ADA MyList page$")

    public void userClickonADAMyList() throws InterruptedException {
        homePage.clickHomePageTab();
        myADAListPage.clickMylistTab();
        adaUtils.ADAInspector("My List");
    }

    @When("^user clicks on ADA Settings page$")
    public void userClickonADASettings() throws InterruptedException {
        homePage.clickHomePageTab();
        hamburgerMenu.clickHamburgerMenu();
        adaUtils.ADAscrollDown();
        adaUtils.ADAInspector("Settings");
    }

    @When("^user clicks on ADA Member page$")
    public void userClickonADAMember() throws InterruptedException {
        homePage.clickHomePageTab();
        walletPage.clickMemberTab();
        adaUtils.ADAInspector("Member");
    }

    @When("^user clicks on Search page$")
    public void userClickonADASearch() throws InterruptedException {
        homePage.clickHomePageTab();
        homePage.clickSearchBar();
        adaUtils.ADAInspector("Search");
    }

    @And("^user types \"([^\"]*)\" on ADA search bar and click search on home page$")
    public void userTypesOnSearchBarAndClickSearchOnHomePage(String arg0) throws Throwable {
        homePage.enterSearchItem(arg0);
        adaUtils.ADAInspector("Search");
    }

    @When("^user visits Login page$")
    public void userClickonADASign() throws InterruptedException {
        String mfaUser = otpPasswordPage.userEnterTheEmailIdForOTPToSignUp();
        otpPasswordPage.handleSSO(false);
        long currentEpochTime = Instant.now().toEpochMilli();
        adaUtils.ADAInspector("Get Started");
        otpPasswordPage.switchToEmail(mfaUser);
        String otpCode = ExecutionHelper.getOtp(mfaUser, 0);
        adaUtils.ADAInspector("OTP");
        otpPasswordPage.EnterAndSubmitOtp(otpCode);
    }

    @When("^user clicks on ADA My Cart Icon$")

    public void clickOnNavigationArrow() throws InterruptedException {
        homePage.clickHomePageTab();
        myADACartPage.clickOnMyCart();
        adaUtils.ADAInspector("Cart");
    }

    @When("^user clicks on ADA Clipping Deals$")

    public void clipADADeals() throws InterruptedException {
        homePage.clickHomePageTab();
        homePage.clickDealTab();
        ADApageElement.clickClipButton();
        adaUtils.ADAInspector("Clipping Deals");
    }


    @When("^user clicks on ADA Reserve Time$")

    public void clickOnADAReserveTime() throws InterruptedException {
        homePage.clickHomePageTab();
        ADAReserveTime.clickOnReserveTime();
        adaUtils.ADAInspector("Reserve Time");
    }

    @When("^user clicks on ADA FreshPass$")

    public void clickOnFreshPass() throws InterruptedException {
        homePage.clickHomePageTab();

        walletPage.clickMemberTab();
        ADAFreshPass.userClickOnFreshPassAtMemberTab();
        adaUtils.ADAInspector("FreshPass");
    }

    @When("^user clicks on ADA Wallet$")
    public void clickOnWallet() throws InterruptedException {
        homePage.clickHomePageTab();

        walletPage.clickMemberTab();
        walletPage.goToWalletTab();
        adaUtils.ADAInspector("FreshPass");
    }

    @When("^user clicks on ADA MyListPageTabs$")
    public void clickOnClippedDeals() throws InterruptedException {
        homePage.clickHomePageTab();
        myADAListPage.clickMylistTab();
        ADAmyListPage.verifyTabsAndTheirOrderInMyList();
        adaUtils.ADAInspector("Clipped Deals");
    }

}




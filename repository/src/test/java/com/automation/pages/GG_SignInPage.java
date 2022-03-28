package com.automation.pages;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.TapAction;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_DashboardPageElements;
import com.automation.pageElements.GG_ShoppingModePageElements;
import com.automation.pageElements.GG_SignInPageElements;
import com.automation.pageElements.GG_StartUpPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class contains methods that will act on Sign In page
 */
public class GG_SignInPage extends BasePage {
    // public GG_OtpPasswordPage gg_otpPasswordPage = new GG_OtpPasswordPage(driver);
    private final GG_SignInPageElements signInPageElements = new GG_SignInPageElements();
    private final GG_StartUpPageElements statUpPageElements = new GG_StartUpPageElements();
    private final GG_DashboardPageElements dashboardPageElements = new GG_DashboardPageElements();
    private final GG_ShoppingModePageElements gg_shoppingModePageElements = new GG_ShoppingModePageElements();
    private final GG_ShoppingModePage gg_shoppingModePage = new GG_ShoppingModePage(driver);
    private final GG_StartUpPage startUpPage = new GG_StartUpPage(driver);
    private final GG_DashboardPage dashboardPage = new GG_DashboardPage(driver);
    private final GG_OtpPasswordPage otpPasswordPage = new GG_OtpPasswordPage(driver);

    public GG_SignInPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), signInPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), statUpPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), dashboardPageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_shoppingModePageElements);
    }

    /**
     * Method to enter email
     *
     * @throws IOException
     */
    public void enterEmail(String arg) {
        String username = ThreadLocalHelper.testCaseData.get().get(arg);
        if (isElementDisplayed(signInPageElements.emailTextField, 20)) {
            enterKey(signInPageElements.emailTextField, username);
        }
    }

    /**
     * Method to enter password
     *
     * @throws IOException
     */
    public void enterPassword(String arg) {
        String password = ThreadLocalHelper.testCaseData.get().get(arg);
        enterKey(signInPageElements.passwordTextField, password);
    }

    /**
     * Method to sign in to the application with existing rewards
     *
     * @param userType
     * @throws IOException
     */
    public void signInApp(String userType) throws IOException {

        // dashboardPage.signOut();

        if (!driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (isElementDisplayed(signInPageElements.continueButtonCache, 60)) {
                new CommonActions(driver).new ClickAction().clickElement(signInPageElements.continueButtonCache);
            }
        }

        for (int i = 0; i < 10; i++) {
            if (isElementDisplayed(statUpPageElements.signInHereButton, 1)) {
                if (isElementDisplayed(signInPageElements.continueButton, 1)) {
                    new CommonActions(driver).new ClickAction().clickElement(signInPageElements.continueAsGuestButton);
                }
                break;
            } else if (isElementDisplayed(signInPageElements.continueButton, 1)) {
                new CommonActions(driver).new ClickAction().clickElement(signInPageElements.continueAsGuestButton);
                break;
            }
        }
        startUpPage.clickOnSignInHereButton();
        enterEmail("USERNAME_REWARDS");
        enterPassword("PASSWORD_REWARDS");
        new CommonActions(driver).new ClickAction().clickElement(signInPageElements.signInButton);
        waitForLoaderToDisappear();
    }

    public void waitForLoaderToDisappear() {
        new WaitAction(driver).waitForElementToDisappear(dashboardPageElements.loadingSpinner, 60);
    }


    public void signInApp() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME", "PASSWORD");
        postSignInActions();
    }

    public void signInWithProdCredentials() throws IOException {
        enterEmail("USERNAME_PROD");
        enterPassword("PASSWORD_PROD");
        new CommonActions(driver).new ClickAction().clickElement(signInPageElements.signInButton);
        waitForLoaderToDisappear();
    }

    public void signInWithExistingCredentials() throws IOException {
        enterEmail("USERNAME_REWARDS");
        enterPassword("PASSWORD_REWARDS");
        new CommonActions(driver).new ClickAction().clickElement(signInPageElements.signInButton);
        waitForLoaderToDisappear();
    }

    public void signInWithCOACredentials() throws IOException {
        enterEmail("USERNAME_COA");
        enterPassword("PASSWORD_COA");
        new CommonActions(driver).new ClickAction().clickElement(signInPageElements.signInButton);
        waitForLoaderToDisappear();
    }

    public void postSignInActions() throws InterruptedException, IOException {

        for (int i = 1; i < 20; i++) {

            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                if (isElementDisplayed(dashboardPageElements.allowNotificationsButton, 1)) {
                    dashboardPageElements.allowNotificationsButton.click();
                }

                if (isElementDisplayed(dashboardPageElements.allowNotificationPermissionPopup, 1)) {
                    dashboardPageElements.allowNotificationPermissionPopup.click();
                }
            }


            if (isElementDisplayed(gg_shoppingModePageElements.zipCodeTextField, 1)) {

                gg_shoppingModePage.enterDefaultZipCodeAndStartShopping();
            }

            if (driver.getPlatformName().equalsIgnoreCase("android")) {
                if (isElementDisplayed(dashboardPageElements.cachingContinueBtn, 1)) {
                    dashboardPageElements.cachingContinueBtn.click();
                }
            }

            for (int j = 0; j < 3; j++) {
                if (isElementDisplayed(dashboardPageElements.nextButtonOfTutorialScreen, 1)) {
                    dashboardPageElements.nextButtonOfTutorialScreen.click();
                } else {
                    break;
                }
            }

            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                if (isElementDisplayed(dashboardPageElements.cachingContinueBtn, 1)) {
                    dashboardPageElements.cachingContinueBtn.click();
                }
            }

            if (isElementDisplayed(dashboardPageElements.dismissCTA, 1)) {
                dashboardPageElements.dismissCTA.click();
                if (!isElementDisplayed(dashboardPageElements.dealsTitleHeader, 1)) {
                    if (isElementDisplayed(dashboardPageElements.dismissCTA, 1)) {
                        dashboardPageElements.dismissCTA.click();
                    }
                    if (isElementDisplayed(signInPageElements.signInButton, 1)) {
                        signInPageElements.signInButton.click();
                        gg_shoppingModePage.enterDefaultZipCodeAndStartShopping();
                        if (isElementDisplayed(dashboardPageElements.dismissCTA, 20)) {
                            dashboardPageElements.dismissCTA.click();
                        }
                    }
                } else {
                    if (isElementDisplayed(signInPageElements.signInButton, 1)) {
                        signInPageElements.signInButton.click();
                        gg_shoppingModePage.enterDefaultZipCodeAndStartShopping();
                        if (isElementDisplayed(dashboardPageElements.nextButtonOfTutorialScreen, 20)) {
                            dashboardPageElements.nextButtonOfTutorialScreen.click();
                            break;
                        }
                    }
                }
            }

            if (isElementDisplayed(dashboardPageElements.dealsTitleHeader, 1) || isElementDisplayed(dashboardPageElements.profileIcon, 1)) {
                break;
            }
        }
    }

    public void postSignInActionsforDeliveryOption() throws InterruptedException, IOException {
        for (int i = 1; i < 20; i++) {

            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                if (isElementDisplayed(dashboardPageElements.allowNotificationsButton, 1)) {
                    dashboardPageElements.allowNotificationsButton.click();
                }

                if (isElementDisplayed(dashboardPageElements.allowNotificationPermissionPopup, 1)) {
                    dashboardPageElements.allowNotificationPermissionPopup.click();
                }
            }

            if (isElementDisplayed(gg_shoppingModePageElements.zipCodeTextField, 2)) {
                gg_shoppingModePage.enterDefaultZipCodeAndStartShoppingforDelivery();
            }

            if (driver.getPlatformName().equalsIgnoreCase("android")) {
                if (isElementDisplayed(dashboardPageElements.cachingContinueBtn, 1)) {
                    dashboardPageElements.cachingContinueBtn.click();
                }
            }

            for (int j = 0; j < 3; j++) {
                if (isElementDisplayed(dashboardPageElements.nextButtonOfTutorialScreen, 1)) {
                    dashboardPageElements.nextButtonOfTutorialScreen.click();
                } else {
                    break;
                }
            }

            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                if (isElementDisplayed(dashboardPageElements.cachingContinueBtn, 1)) {
                    dashboardPageElements.cachingContinueBtn.click();
                }
            }

            if (isElementDisplayed(dashboardPageElements.dismissCTA, 1)) {
                dashboardPageElements.dismissCTA.click();
                if (!isElementDisplayed(dashboardPageElements.dealsTitleHeader, 1)) {
                    if (isElementDisplayed(dashboardPageElements.dismissCTA, 1)) {
                        dashboardPageElements.dismissCTA.click();
                    }
                    if (isElementDisplayed(signInPageElements.signInButton, 1)) {
                        signInPageElements.signInButton.click();
                        gg_shoppingModePage.enterDefaultZipCodeAndStartShopping();
                        if (isElementDisplayed(dashboardPageElements.dismissCTA, 20)) {
                            dashboardPageElements.dismissCTA.click();
                        }
                    }
                } else {
                    if (isElementDisplayed(signInPageElements.signInButton, 1)) {
                        signInPageElements.signInButton.click();
                        gg_shoppingModePage.enterDefaultZipCodeAndStartShopping();
                        if (isElementDisplayed(dashboardPageElements.nextButtonOfTutorialScreen, 20)) {
                            dashboardPageElements.nextButtonOfTutorialScreen.click();
                            break;
                        }
                    }
                }
            }

            if (isElementDisplayed(dashboardPageElements.dealsTitleHeader, 1) || isElementDisplayed(dashboardPageElements.profileIcon, 1)) {
                break;
            }
        }
    }


    public void postSignInActionsWithoutTutorialHandling() throws InterruptedException, IOException {
        waitForOtpPageToDisappear();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (isElementDisplayed(dashboardPageElements.allowNotificationsButton, 5)) {
                dashboardPageElements.allowNotificationsButton.click();
            }
            if (isElementDisplayed(dashboardPageElements.allowNotificationPermissionPopup, 5)) {
                dashboardPageElements.allowNotificationPermissionPopup.click();
            }
        }

        if (isElementDisplayed(gg_shoppingModePageElements.zipCodeRightArrow, 5)) {
            gg_shoppingModePage.enterDefaultZipCodeAndStartShopping();
        }

        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            if (isElementDisplayed(dashboardPageElements.cachingContinueBtn, 3)) {
                dashboardPageElements.cachingContinueBtn.click();
                if (isElementDisplayed(dashboardPageElements.dontAllowBtn, 1)) {
                    dashboardPageElements.dontAllowBtn.click();
                }
            }
        }

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (isElementDisplayed(dashboardPageElements.cachingContinueBtn, 1)) {
                dashboardPageElements.cachingContinueBtn.click();
            }
        }

        if (isElementDisplayed(dashboardPageElements.dismissCTA, 1)) {
            dashboardPageElements.dismissCTA.click();
            if (isElementDisplayed(signInPageElements.signInButton, 1)) {
                signInPageElements.signInButton.click();
                gg_shoppingModePage.enterDefaultZipCodeAndStartShopping();
                if (isElementDisplayed(dashboardPageElements.dismissCTA, 20)) {
                    dashboardPageElements.dismissCTA.click();
                }
            }
        }
    }

    public void enterCredentials(String user, String password) throws Exception {
        enterEmail(user);
        enterPassword(password);
        new CommonActions(driver).new ClickAction().clickElement(signInPageElements.signInButton);
        waitForLoaderToDisappear();
    }

    public void preSignInPageActions() throws IOException, InterruptedException {
        waitForLoaderToDisappear();
        if (isElementDisplayed(signInPageElements.updateLater, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(signInPageElements.updateLater);
        }
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (!isElementDisplayed(statUpPageElements.signInHereButton, 3)) {
                if (!isElementDisplayed(signInPageElements.signInButton, 1)) {
                    if (!isElementDisplayed(signInPageElements.continueButton, 1)) {
                        if (isElementDisplayed(dashboardPageElements.dontAllowBtn, 1)) {
                            new CommonActions(driver).new ClickAction().clickElement(dashboardPageElements.dontAllowBtn);
                        }
                        if (isElementDisplayed(gg_shoppingModePageElements.zipCodeRightArrow, 1)) {
                            gg_shoppingModePage.enterDefaultZipCodeAndStartShopping();
                            dashboardPage.clickHomeTab();
                            dashboardPage.handlePopUpsAndTutorialOnDashboard();
                            dashboardPage.signOut();
                        } else if (isElementDisplayed(dashboardPageElements.nextButtonOfTutorialScreen, 1)) {
                            dashboardPage.skipTutorial();
                            dashboardPage.signOut();
                        } else {
                            dashboardPage.clickHomeTab();
                            dashboardPage.handlePopUpsAndTutorialOnDashboard();
                            dashboardPage.signOut();
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            if (driver.getPlatformName().equalsIgnoreCase("android") && AppiumDeviceManager.getDevice().getDeviceType().equalsIgnoreCase("cloud")) {
                new TapAction(driver).tapSearchEnterAndroid();
                new TapAction(driver).tapEnterAndroidKeyboard();
            }

            if (isElementDisplayed(statUpPageElements.signInHereButton, 2)) {
                startUpPage.clickOnSignInHereButton();
                break;
            } else if (isElementDisplayed(signInPageElements.signInButton, 1)) {
                break;
            } else if (isElementDisplayed(signInPageElements.continueButton, 1)) {
                signInPageElements.continueAsGuestButton.click();
                if (isElementDisplayed(signInPageElements.continueAsGuestButton, 2)) {
                    signInPageElements.continueAsGuestButton.click();
                }
                new WaitAction(driver).waitForDisplayed(statUpPageElements.signInHereButton, 2);
                startUpPage.clickOnSignInHereButton();
                break;
            }
        }
    }


    /**
     * Method to sign in to the application to verify delivery order status
     *
     * @throws IOException
     */
    public void signInDelivery() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME_DELIVERYSTATUS", "PASSWORD_DELIVERYSTATUS");
        postSignInActions();
    }

    /**
     * Method to sign in to the application to very pick up order status
     *
     * @throws IOException
     */
    public void signInPickUp() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME_PICKUPSTATUS", "PASSWORD_PICKUPSTATUS");
        postSignInActions();
    }

    /**
     * Method to sign in to the application with existing rewards
     *
     * @throws IOException
     */
    public void signInWithRewards() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME_REWARDS", "PASSWORD_REWARDS");
        postSignInActions();
    }

    /**
     * Method to sign in to the application using account with default rewards balance
     *
     * @throws IOException
     */
    public void signInWithDefaultRewardsBalance() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME_REWARDS_DEFAULT", "PASSWORD_REWARDS_DEFAULT");
        postSignInActions();
    }

    /**
     * Method to sign in to the application using account with no rewards
     *
     * @throws IOException
     */
    public void signInNoRewards() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME_NOREWARDS", "PASSWORD_NOREWARDS");
        postSignInActions();
    }

    /**
     * Method to sign in to the application using account with redeemed rewards
     *
     * @throws IOException
     */
    public void signInRedeemedRewards() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME_REDEEMED_REWARDS", "PASSWORD_REDEEMED_REWARDS");
        postSignInActions();
    }

    /**
     * Method to sign in to the application using account with no redeemed rewards
     *
     * @throws IOException
     */
    public void signInNoRedeemedRewards() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME_NOREDEEMED_REWARDS", "PASSWORD_NOREDEEMED_REWARDS");
        postSignInActions();
    }

    /**
     * Method to sign in to the application using account with purchase history
     *
     * @throws IOException
     */
    public void signInWithPurchaseHistory() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME_PURCHASEHISTORY", "PASSWORD_PURCHASEHISTORY");
        postSignInActions();
    }

    public void signInWithItemYouBuy() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME_ITEM", "PASSWORD_ITEM");
        postSignInActions();
    }


    /**
     * Method to sign in to the application using account with no purchase history
     *
     * @throws IOException
     */
    public void signInWithNoPurchaseHistory() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME_NOPURCHASEHISTORY", "PASSWORD_NOPURCHASEHISTORY");
        postSignInActions();
    }

    /**
     * Method to sign in to the application using account with save on favorites
     *
     * @throws IOException
     */
    public void signInToTheApplicationUsingAccountWithSaveOnYourFavorites() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME_SAVEONYOURFAVORITES", "PASSWORD_SAVEONYOURFAVORITES");
        postSignInActions();
    }

    /**
     * Method to sign in to the application using account with Past Orders
     *
     * @throws IOException
     */
    public void signInPastOrders() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME_PASTORDER", "PASSWORD_PASTORDER");
        postSignInActions();
    }

    public void signInPayBanner() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME_STOREPAYBANNER", "PASSWORD_STOREPAYBANNER");
        postSignInActions();
    }

    public void signInNoClippedFreshCoupons() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME_NOCLIPPED_FRESH_NEW_COUPONS", "PASSWORD_NOCLIPPED_FRESH_NEW_COUPONS");
        postSignInActions();
    }

    public void signInMonopolyDeals() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME_MONOPOLY", "PASSWORD_MONOPOLY");
        postSignInActions();
    }

    public void signInShoppingModeNotChanged() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME_DEFAULT_SHOPPING_MODE", "PASSWORD_DEFAULT_SHOPPING_MODE");
        postSignInActions();
    }

    public void signUpToTheApplicationUsingEmailId() throws Exception {
        preSignInPageActions();
        AppiumDevice device = AppiumDeviceManager.getDevice();
        String currentDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String email = device.getBanner() + "_" + device.getEnv() + "_" + currentDate + "@yopmail.com";
        enterCredentials(email, "PASSWORD");
    }


    public void signInTutorials() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME_NOCLIPPED_FRESH_NEW_COUPONS", "PASSWORD_NOCLIPPED_FRESH_NEW_COUPONS");
        postSignInActionsWithoutTutorialHandling();
    }

    public void signInNoShoppingPreference() throws Exception {
        if (isElementDisplayed(signInPageElements.continueButton, 3)) {
            new CommonActions(driver).new ClickAction().clickElement(signInPageElements.continueAsGuestButton);
            if (isElementDisplayed(signInPageElements.continueAsGuestButton, 3)) {
                new CommonActions(driver).new ClickAction().clickElement(signInPageElements.continueAsGuestButton);
            }
        }
        startUpPage.clickOnSignInHereButton();
        enterCredentials("USERNAME_NO_SHOPPING_PREF", "PASSWORD_NO_SHOPPING_PREF");
    }

    /**
     * Method to sign in to the application to verify cart related scenarios
     *
     * @throws IOException
     */
    public void signInCart() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME_CART", "PASSWORD_CART");
        postSignInActions();
    }


    public void signInWithPickupOrderTwo() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME_PICKUPSTATUSTWO", "PASSWORD_PICKUPSTATUSTWO");
        postSignInActions();
    }

    public void signInWithPickupOrderThree() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME_PICKUPSTATUSTHREE", "PASSWORD_PICKUPSTATUSTHREE");
        postSignInActions();
    }

    public void signInWithPickupOrderFour() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME_PICKUPSTATUSFOUR", "PASSWORD_PICKUPSTATUSFOUR");
        postSignInActions();
    }

    public void closeAppUpdatePopUp() {
        if (isElementDisplayed(signInPageElements.updateLater, 2)) {
            new CommonActions(driver).new ClickAction().clickElement(signInPageElements.updateLater);
        }
    }

    public void signInWithAnnualFPUser() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME_ANNUAL", "PASSWORD");
        postSignInActions();
    }


    public void signInWithMonthlyFPUser() throws Exception {
        preSignInPageActions();
        enterCredentials("USERNAME_MONTHLY", "PASSWORD");
        postSignInActions();
    }

    public void handlePushNotificationPage() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            if (isElementDisplayed(dashboardPageElements.allowNotificationsButton, 1)) {
                dashboardPageElements.allowNotificationsButton.click();
                if (isElementDisplayed(dashboardPageElements.allowNotificationPermissionPopup, 2)) {
                    dashboardPageElements.allowNotificationPermissionPopup.click();
                }
            }
        }
    }

    public void waitForOtpPageToDisappear() {

        new WaitAction(driver).waitForElementToDisappear(dashboardPageElements.loadingSpinnerOTP, 120);

    }
}



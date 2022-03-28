package com.automation.pages;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_WelcomePageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.IOException;

public class GG_WelcomePage extends BasePage {

    private final GG_WelcomePageElements welcomePageElements = new GG_WelcomePageElements();

    public GG_WelcomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), welcomePageElements);
    }

    public boolean waitForWelcomeScreenDisplayed() {
        return isElementDisplayed(welcomePageElements.welcomeTitle, 25);
    }


    public void verifyWelcomeText() {
        waitVar.until(ExpectedConditions.visibilityOf(welcomePageElements.welcomeText));
    }

    public void clickGetStartedBtn() {
        new WaitAction(driver).waitForDisplayed(welcomePageElements.getStartedBtn);
        new CommonActions(driver).new ClickAction().clickElement(welcomePageElements.getStartedBtn);
    }


    public void pushNotificationScreenIsDisplayed() {
        waitVar.until(ExpectedConditions.visibilityOf(welcomePageElements.allowNotificationButton));
    }


    public void clickAllowNotificationButton() {
        new CommonActions(driver).new ClickAction().clickElement(welcomePageElements.allowNotificationButton);
    }


    public void clickMaybeLaterButton() {
        new CommonActions(driver).new ClickAction().clickElement(welcomePageElements.maybeLaterButton);
    }


    public boolean getAllowNotificationButton() {
        return welcomePageElements.allowNotificationButtonVisiblity.size() > 0;
    }


    public void clickAllowInNotificaitonPopUp() {
        new CommonActions(driver).new ClickAction().clickElement(welcomePageElements.clickAllowInNotificationPopUp);
    }

    public void clickContinueButton() {
        new CommonActions(driver).new ClickAction().clickElement(welcomePageElements.continueButton);
    }

    public void clickCloseButton() {
        if (isElementDisplayed(welcomePageElements.closeBtn)) {
            new CommonActions(driver).new ClickAction().clickElement(welcomePageElements.closeBtn);
        }
    }

//	public String getCurrentBanner() {
//		return driver.getCapabilities().getCapability("banner").toString();
//	}

    public void enterUsername() throws IOException {
        String username = ThreadLocalHelper.testCaseData.get().get("USERNAME");
        enterKey(welcomePageElements.usernameTextField, username);

//		enterKey(welcomePageElements.usernameTextField, "test_rewards1@example.com");
    }

    public void enterPassword() throws IOException {
        String password = ThreadLocalHelper.testCaseData.get().get("PASSWORD");

        enterKey(welcomePageElements.passwordTextField, password);
//		enterKey(welcomePageElements.passwordTextField, "testpwd1");
    }


    public void clickSignInButton() {
        new CommonActions(driver).new ClickAction().clickElement(welcomePageElements.signInButton);
    }

    public void errorPopupClose() {
        new CommonActions(driver).new ClickAction().clickElement(welcomePageElements.okButton);
    }

    public boolean isSignInButtonDisplayed(int waitTime) {
        return isElementDisplayed(welcomePageElements.signInButton, waitTime);
    }

    public boolean isContinueButtonDisplayed(int waitTime) {
        return isElementDisplayed(welcomePageElements.continueButton, waitTime);
    }

    public boolean isFirstImageDisplayed() {
        return isElementDisplayed(welcomePageElements.onBoardingImageOne);
    }

    public boolean isSecondImageDisplayed() {
        slideTheDealCardFromRightToLeft(welcomePageElements.onBoardingImageOne);
//		slideTheDealCardFromRightToLeft(welcomePageElements.onBoardingImageOne);
        new WaitAction(driver).waitForDisplayed(welcomePageElements.onBoardingImageTwo);
        return isElementDisplayed(welcomePageElements.onBoardingImageTwo);
    }

    public void slideTheDealCardFromRightToLeft(MobileElement ele) {
        Point pt = ele.getLocation();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            scroll(100, pt.getY(), 30, pt.getY());
        } else {
//			scroll(100, pt.getY(), 30, pt.getY());
            scroll(pt.getX() + 400, pt.getY(), pt.getX() - 200, pt.getY());

//			scroll(pt.getX() + 100, pt.getY(), pt.getX() - 100, pt.getY());
        }
    }

    public boolean isThirdImageDisplayed() {
        slideTheDealCardFromRightToLeft(welcomePageElements.onBoardingImageTwo);
        return isElementDisplayed(welcomePageElements.onBoardingImageThree);
    }

    public boolean isFourthImageDisplayed() {
        slideTheDealCardFromRightToLeft(welcomePageElements.onBoardingImageThree);
        return isElementDisplayed(welcomePageElements.onBoardingImageFourth);
    }

    public void isFourImagesAreScrollable() {
        slideTheDealCardFromRightToLeft(welcomePageElements.onBoardingImageOne);
        slideTheDealCardFromRightToLeft(welcomePageElements.onBoardingImageTwo);
        slideTheDealCardFromRightToLeft(welcomePageElements.onBoardingImageThree);
    }

    public void isLetsGetStartedButtonDisplayed() {
        Assert.assertTrue(welcomePageElements.letsGetStartedButton.getAttribute("text").equalsIgnoreCase("Let's Get Started"));
    }

    public void clickOnLetsGetStaretedButton() {
        new CommonActions(driver).new ClickAction().clickElement(welcomePageElements.letsGetStartedButton);
    }

    public void isNextPageDisplayed() {
        Assert.assertFalse(welcomePageElements.letsGetStartedButton.getAttribute("text").equalsIgnoreCase("Let's Get Started"));
    }

    public void isALittleDifferenceALotEasierTitleDisplayed() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Assert.assertTrue(welcomePageElements.littleDifferecneLotEasierTitle.getAttribute("label").equalsIgnoreCase("A little different. A lot easier"));
        } else {
            Assert.assertTrue(welcomePageElements.littleDifferecneLotEasierTitle.getAttribute("text").equalsIgnoreCase("A little different. A lot easier"));
        }
    }

    public boolean isWelcomeScreenMessageDisplayed() {
        return isElementDisplayed(welcomePageElements.welcomePageMsg, 4);
    }


    public boolean isAllowPushNotificationDisplayed() {
        boolean allowNotificationDisplayed = true;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            allowNotificationDisplayed = isElementDisplayed(welcomePageElements.allowpushNotification);
        }
        return allowNotificationDisplayed;
    }

    public boolean isNotRightNowPushNotificationDisplayed() {
        boolean notRightNowDisplayed = true;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            notRightNowDisplayed = isElementDisplayed(welcomePageElements.notRightNowpushNotification);
        }
        return notRightNowDisplayed;
    }

    public void clickOnAllowNotificationButton() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new CommonActions(driver).new ClickAction().clickElement(welcomePageElements.allowpushNotification);
        }
    }

    public boolean isPermissionPopupDisplayed() {
        boolean isPermissionPopupDisplayed = true;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            isPermissionPopupDisplayed = isElementDisplayed(welcomePageElements.allowNotificationPermissionPopup);
        }
        return isPermissionPopupDisplayed;
    }

    public void allowNotificationPermissionPopUp() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new CommonActions(driver).new ClickAction().clickElement(welcomePageElements.allowNotificationPermissionPopup);
        }
    }

    public void dontAllowNotificationPermissionPopUp() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new CommonActions(driver).new ClickAction().clickElement(welcomePageElements.dontAllowNotificationPermissionPopup);
        }
    }

    public void clickNotRightNowNotificationButton() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new CommonActions(driver).new ClickAction().clickElement(welcomePageElements.notRightNowpushNotification);
        }
    }


}

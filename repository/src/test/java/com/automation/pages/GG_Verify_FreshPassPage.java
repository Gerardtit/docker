package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_Verify_FreshpassElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class GG_Verify_FreshPassPage extends BasePage {
    public GG_Verify_FreshpassElements freshpassElements = new GG_Verify_FreshpassElements();

    public GG_Verify_FreshPassPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), freshpassElements);
    }

    public void InStoreDeliveryselected() {

        if (freshpassElements.InStore.isSelected()) {
            scrollDownForElement(freshpassElements.TTshopAtZipcode);
            freshpassElements.TTshopAtZipcode.click();
        } else {
            freshpassElements.InStore.click();
            scrollDownForElement(freshpassElements.TTshopAtZipcode);
            freshpassElements.TTshopAtZipcode.click();
        }
    }

    public void DUGListDisplayed() {
        new WaitAction(driver).waitForDisplayed(freshpassElements.dugStore);
    }

    public void DismissWindow() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            freshpassElements.dismissAlert.click();
        }
    }

    public void navigateToWelcomePage() {
        waitVar.until(ExpectedConditions.visibilityOf(freshpassElements.switchEmail));
    }

    public void FAQpageselect() {
        scrollDownForElement(freshpassElements.FAQtab);
        freshpassElements.FAQtab.click();

    }

    public void FAQPagedisplay() {
        new WaitAction(driver).waitForLoadingComplete();
        freshpassElements.FAQtitle.isDisplayed();
    }

    public void TNCselect() {
        scrollDownForElement(freshpassElements.TNCtab);
        freshpassElements.TNCtab.click();


    }

    public void TNCpage() {

        new WaitAction(driver).waitForLoadingComplete();
        freshpassElements.TNCtitle.isDisplayed();

    }

    public void cancelFreshPAssSelected() {
        scrollDownForElement(freshpassElements.CancelFreshPass);
        freshpassElements.CancelFreshPass.click();
    }

    public void cancelPlanPage() {
        freshpassElements.CancelplanPageTitle.isDisplayed();
    }

    public void closeUpdate() {
        new WaitAction(driver).waitForDisplayed(freshpassElements.SoftUpgrade);
        freshpassElements.SoftUpgrade.click();
    }

    public void selectAllow() {
        new WaitAction(driver).waitForLoadingComplete();

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new WaitAction(driver).waitForDisplayed(freshpassElements.allowElement);
            freshpassElements.allowElement.click();
        }
    }

    //------------landing at deals page-----------
    public void handlePopupsHomePage() {
        new WaitAction(driver).waitForLoadingComplete();
        if (isElementDisplayed(freshpassElements.ClickCacheText, 3)) {
            freshpassElements.ClickCacheText.click();
        }
        new WaitAction(driver).waitForLoadingComplete();
        if (isElementDisplayed(freshpassElements.ClickNextButton, 3)) {

            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                for (int i = 1; i <= 2; i++) {
                    new CommonActions(driver).new ClickAction().clickElement(freshpassElements.ClickNextButton);
                }
            }

            waitForLoadingComplete();
            if (isElementDisplayed(freshpassElements.dismiss, 3)) {
                //clickElement(verifyMaxCountPageElements.dismiss);
                freshpassElements.dismiss.click();
            }
//        waitForLoadingComplete();

//        if(isElementDisplayed(verifyMaxCountPageElements.dismiss,3)) {
//            //new CommonActions(driver).new ClickAction().clickElement(verifyMaxCountPageElements.dismiss);
//            verifyMaxCountPageElements.close.click();
        }
    }
    //======================================
//    public void handlePopupsHomePage() {
//        new WaitAction(driver).waitForLoadingComplete();
//        if (isElementDisplayed(freshpassElements.ClickCacheText, 3)) {
//            freshpassElements.ClickCacheText.click();
//        }
//        new WaitAction(driver).waitForLoadingComplete();
//        if (isElementDisplayed(freshpassElements.ClickNextButton, 3)) {
////            for (int i = 1; i <= 3; i++) {
//                new CommonActions(driver).new ClickAction().clickElement(freshpassElements.ClickNextButton);
//            }
////        }
//
//        new WaitAction(driver).waitForLoadingComplete();
//        if (isElementDisplayed(freshpassElements.dismiss, 3)) {
//            //new CommonActions(driver).new ClickAction().clickElement(verifyMaxCountPageElements.dismiss);
//            freshpassElements.dismiss.click();
//        }
////        new WaitAction(driver).waitForLoadingComplete();
////        if(isElementDisplayed(verifyMaxCountPageElements.dismiss,3)) {
////            //new CommonActions(driver).new ClickAction().clickElement(verifyMaxCountPageElements.dismiss);
////            verifyMaxCountPageElements.close.click();
//    }

    public void homeiconselected() {
        new WaitAction(driver).waitForLoadingComplete();
        new WaitAction(driver).waitForDisplayed(freshpassElements.homeicon);
        freshpassElements.homeicon.click();

        if (isElementDisplayed(freshpassElements.ClickCacheText)) {
            // waitForDisplayed(freshpassElements.ClickCacheText);
            freshpassElements.ClickCacheText.click();
        }

    }

    public void clickprofileicon() {
        new WaitAction(driver).waitForDisplayed(freshpassElements.userProfile);
        freshpassElements.userProfile.click();
    }

    public void tofreshpassPage() {
        new WaitAction(driver).waitForLoadingComplete();
        new WaitAction(driver).waitForDisplayed(freshpassElements.FreshPassAtSettings);
        new CommonActions(driver).new ClickAction().clickElement(freshpassElements.FreshPassAtSettings);


    }

    public void enterZipCode(String zipCode) {
        freshpassElements.zipCodeEditText.clear();
        if (driver.getPlatformName().equalsIgnoreCase("android"))
            enterFromKeyboard(freshpassElements.zipCodeEditText, zipCode);
        else if (driver.getPlatformName().equalsIgnoreCase("ios"))
            enterKey(freshpassElements.zipCodeEditText, zipCode);
    }

    public void clickNextButton() {
        freshpassElements.enterButton.click();
    }

    public void annualplan() {
        freshpassElements.AnnualselectPlan.click();
        freshpassElements.IAgree.click();
        freshpassElements.Confirmtab.click();
        freshpassElements.Donetab.click();
    }

    public void tohomepage() {
        new WaitAction(driver).waitForLoadingComplete();
        new WaitAction(driver).waitForDisplayed(freshpassElements.homeicon);
        new WaitAction(driver).waitForClickableAndClick(freshpassElements.homeicon);
        new CommonActions(driver).new ClickAction().clickElement(freshpassElements.homeicon);

//       if (isElementDisplayed(freshpassElements.ClickCacheText, 3)) {
//            freshpassElements.ClickCacheText.click();
//        }

    }

    public void messageisdisplayed() {
        new WaitAction(driver).waitForLoadingComplete();
        freshpassElements.changeAtPlan.click();
    }


    public void tosettingspage() {
        freshpassElements.navigatebacktoSettings.click();
//        freshpassElements.FreshPassAtSettings.isDisplayed();
//        freshpassElements.FreshPassAtSettings.click();
    }

    public void changePlan() {
        freshpassElements.changeAtPlan.click();
    }

    public void freshpassTextAtSetting() {
        freshpassElements.FreshPassAtSettings.isDisplayed();
    }

    public void backbutton() {
        driver.navigate().back();
    }

    public void freshpasspage() {
        new WaitAction(driver).waitForLoadingComplete();
        freshpassElements.FreshPassAtSettings.click();
        freshpassElements.FreshPassAtTitle.isDisplayed();
    }

    public void FreshpassPageElements() {
        freshpassElements.FreshPassAtSettings.click();
        String titleText = freshpassElements.FreshPassAtTitle.getText();
        Assert.assertEquals(titleText, "FreshPass");
        String manageText = freshpassElements.Manageyourplan.getText();
        Assert.assertEquals(manageText, "Manage your plan");
        String subtext = freshpassElements.subtextWithplan.getText();
        Assert.assertEquals(subtext, "You can update or cancel your plan, view FAQs and terms here.");
        freshpassElements.Crrentplantitle.isDisplayed();
        scrollDownForElement(freshpassElements.enrolledplantext);
        freshpassElements.enrolledplantext.isDisplayed();
        freshpassElements.planperiod.isDisplayed();
        freshpassElements.planamount.isDisplayed();
//        String changeText = freshpassElements.changeAtPlan.getText();
//        Assert.assertEquals(changeText, "Change");
        freshpassElements.VIPtext.isDisplayed();
        scrollDownForElement(freshpassElements.CancelFreshPass);
        String FaQtext = freshpassElements.FAQtab.getText();
        Assert.assertEquals(FaQtext, "FAQ");
        String TNC = freshpassElements.TNCtab.getText();
        Assert.assertEquals(TNC, "Terms and conditions");
        String cancelText = freshpassElements.CancelFreshPass.getText();
        Assert.assertEquals(cancelText, "Cancel FreshPass");
    }

    public void Accountdisplay() {
        freshpassElements.accountText.isDisplayed();

    }

    public void AccountSelected() {
        freshpassElements.accountText.click();
    }

    public void freshPassTextAtAccount() {
        new WaitAction(driver).waitForLoadingComplete();
        freshpassElements.FreshPassAtAccount.isDisplayed();
    }

    public void FreshPassfromAccountPage() {
        waitForLoadingComplete();
        freshpassElements.FreshPassAtAccount.click();
        freshpassElements.FreshPassAtTitle.isDisplayed();
    }
}

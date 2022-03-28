package com.automation.steps;

import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.entities.BannerConfType;
import com.automation.pages.GG_Verify_FreshPassPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class GG_Verify_FreshpassSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_Verify_FreshPassPage FreshPassPage = new GG_Verify_FreshPassPage(driver);
    AppiumDevice device = AppiumDeviceManager.getDevice();

    public String getCurrentBanner() {
        return driver.getCapabilities().getCapability("banner").toString();
    }

    public String getCurrentEnv() {
        return driver.getCapabilities().getCapability("env").toString();
    }


    @Then("^storelist is displayed$")
    public void storelistisdisplayed() {
        FreshPassPage.DUGListDisplayed();
    }

    @Then("^user clicks continue for Popups$")
    public void userClicksContinueForPopups() {
        FreshPassPage.handlePopupsHomePage();
    }

    @When("^user clicks on profile icon$")
    public void userclicksonprofileicon() {
        FreshPassPage.clickprofileicon();
    }

    @Then("^FreshPass page is selected$")
    public void freshpassIsDisplayedOnSettingpageAndSelected() {
        FreshPassPage.tofreshpassPage();
    }

    @When("^user clicks on homeicon$")
    public void userclicksonhomeicon() {
        FreshPassPage.homeiconselected();
    }

    @Then("^user clicks dismiss$")
    public void clickedDismiss() {
        FreshPassPage.DismissWindow();
    }

    @Then("^softupdate is handled$")
    public void softupdateIsHandled() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            FreshPassPage.closeUpdate();
        }
    }

    @When("^user enters \"([^\"]*)\" in zipcodepage$")
    public void user_enters_in_zipcode_page(String zipcode) throws Throwable {
        if (zipcode.equalsIgnoreCase("zipcode")) {
            FreshPassPage.enterZipCode(device.getZipCode("zipcode"));
        } else if (zipcode.equalsIgnoreCase("zipcode_diff")) {
            FreshPassPage.enterZipCode(device.getConfigureData(BannerConfType.BANNER_ZIPCODE_DIFF));
        } else {
            FreshPassPage.enterZipCode(zipcode);
        }
        FreshPassPage.clickNextButton();
    }

    @When("^user handle allow window$")
    public void userHandleAllowWindow() {
        FreshPassPage.selectAllow();
    }

    @When("^user selects Tomthumb Store$")
    public void userSelectsTomthumbStore() {
        FreshPassPage.InStoreDeliveryselected();
    }

    @When("^user selects Annual plan$")
    public void userSelectsAnnualPlan() {
        FreshPassPage.annualplan();
    }

    @When("^change monthly plan$")
    public void changeMonthlyPlan() {
        FreshPassPage.changePlan();
    }

    //
    @Then("^validate Freshpass text at setting$")
    public void validateFreshpassTextAtSetting() {
        FreshPassPage.freshpassTextAtSetting();
    }

    @Then("^validate Freshpass page is displayed with all text$")
    public void validateFreshpassPageTextIsvalidated() {
        FreshPassPage.FreshpassPageElements();
    }

    @Then("^navigate to homepage$")
    public void navigateToHomepage() {
        FreshPassPage.tohomepage();
    }

    @Then("^validate back arrow in freshpass page$")
    public void validateBackArrowInFreshpassPage() {
        FreshPassPage.tosettingspage();
    }

    @When("^user clicks on Change tab$")
    public void changePlanIsSlectedAtFreshpassPage() {
        FreshPassPage.messageisdisplayed();
    }

    @Then("^return to previuos page$")
    public void returnToPreviuosPage() {
        FreshPassPage.backbutton();
    }

    @When("^freshPass is selected$")
    public void freshpassIsSelected() {
        FreshPassPage.freshpasspage();
    }

    @When("^user clicks on FAQ at FreshPass page$")
    public void withFAQSelectedFAQPageIsDisplayed() {
        FreshPassPage.FAQpageselect();
    }


    @When("^user clicks TNC at FreshPass page$")
    public void withTNCSelectedTNCPageIsDisplayed() {
        FreshPassPage.TNCselect();
    }

    @When("^cancelFreshPass is selected$")
    public void cancelfreshpassIsSelected() {
        FreshPassPage.cancelFreshPAssSelected();
    }

    @Then("^cancelFreshPass page is displayed$")
    public void cancelfreshpassPageIsDisplayed() {
        FreshPassPage.cancelPlanPage();
    }


    @Then("^FAQ PAge is displayed$")
    public void faqPAgeIsDisplayed() {
        FreshPassPage.FAQPagedisplay();
    }

    @Then("^TNC Page is displayed$")
    public void tncPAgeIsDisplpayed() {
        FreshPassPage.TNCpage();
    }

    @Then("^validate Account text at setting$")
    public void validateAccountTextAtSetting() {
        FreshPassPage.Accountdisplay();
    }

    @When("^verify Account page displayed$")
    public void verifyAccountPageDisplayed() {
        FreshPassPage.AccountSelected();
    }

    @Then("^Freshpass  Text is displayed$")
    public void freshpassTextIsDisplayed() {
        FreshPassPage.freshPassTextAtAccount();
    }

    @When("^FreshPass section  is selected$")
    public void freshpassSectionIsSelected() {
        FreshPassPage.FreshPassfromAccountPage();
    }

    @Then("^user returns to settings page from Freshpass page$")
    public void userReturnsToSettingsPageFromFreshpassPage() {
        FreshPassPage.tosettingspage();
    }
}



package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.VerifyMaxCountPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;

public class VerifyMaxCountSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public VerifyMaxCountPage verifyMaxCountPage = new VerifyMaxCountPage(driver);

    @Then("^user clicks continue Popups$")
    public void clickedPopupsonHomepage() {
        verifyMaxCountPage.handlePopupsHomePage();
    }

    @Then("^user search product \"([^\"]*)\"$")
    public void searchProduct(String arg0) throws Throwable {
        verifyMaxCountPage.searchProduct(arg0);
    }

    @Then("^user navigate to pdp of first product$")
    public void navigatePdp() throws Throwable {
        verifyMaxCountPage.navigatePdp();
    }

    @Then("^user verify max quantity in PDP$")
    public void verifyMaxCountPDP() throws Throwable {
        verifyMaxCountPage.verifyMaxCountPDP();
    }

    @Then("^user verify max quantity in cart$")
    public void verifyMaxCountCart() throws Throwable {
        verifyMaxCountPage.verifyMaxCountCart();
    }

}

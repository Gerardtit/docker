package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.CreateAccountPageElements;
import com.automation.pageElements.DeliverPageElements;
import com.automation.pageElements.EditDeliveryAddressPageElements;
import com.automation.pages.BasePage;
import com.automation.pages.DeliverPage;
import com.automation.pages.EditDeliveryAddressPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class EditDeliveryAddressPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public EditDeliveryAddressPage editDeliveryAddressPage = new EditDeliveryAddressPage(driver);
    private final CreateAccountPageElements createAccountPageElements = new CreateAccountPageElements();
    private final EditDeliveryAddressPageElements pageElements = new EditDeliveryAddressPageElements();
    private final DeliverPage deliverPage = new DeliverPage(driver);
    private final DeliverPageElements deliverPageElements = new DeliverPageElements();
    private final BasePage basePage;


    public EditDeliveryAddressPageSteps() {
        basePage = new BasePage(driver);
//        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
    }

    @When("^user edit new address on edit delivery address page$")
    public void userEditNewAddressOnEditDeliveryAddressPage() {
        editDeliveryAddressPage.editNewAddress();
    }

    @When("^user edit original address on edit delivery address page$")
    public void userEditOriginalAddressOnEditDeliveryAddressPage() throws IOException {
        editDeliveryAddressPage.editOriginalAddress();
    }

    @When("^navigate back to previous level from address book page$")
    public void navigateBackToPreviousLevelFromAddressBookPage() throws Throwable {
//        MenuPageSteps menuPageSteps = new MenuPageSteps();
        editDeliveryAddressPage.navigateBackTopLeftArrow();
//        if (driver.getPlatformName().equalsIgnoreCase("android")) {
//            menuPageSteps.menu_page_is_displayed();
//            menuPageSteps.userClicksAccountOnMenuPage();
//        }
    }

    @When("^user clicks on Add delivery address$")
    public void userClicksOnAddDeliveryAddress() throws Throwable {
        editDeliveryAddressPage.addNewAddress();
        new WaitAction(driver).waitForDisplayed(pageElements.addDeliveryAddressTitle);
    }

    @And("user clicks on Add address carousel")
    public void userClicksOnAddAddressCarousel() {
        editDeliveryAddressPage.addressCarousel();
        editDeliveryAddressPage.waitForDisplayed(pageElements.addresspreferances);
    }

    @And("^user click save button$")

    public void userClickSaveButtonOnOrderInfoWindow() throws InterruptedException {

        if (driver instanceof IOSDriver) {
            basePage.scrollDownForElement(deliverPageElements.saveButton);
        }
        deliverPage.clickSaveButton();
    }

    @And("^user sees address added in Address Book$")
    public void userSeesAddressAddedInAddressBook() {
        Assert.assertTrue(editDeliveryAddressPage.validateNewAddressAdded());
    }

    @Then("user selects the items")
    public void userSelectsTheItems() {
        editDeliveryAddressPage.itemsCTA();
    }

    @When("user selects the first item")
    public void userSelectsTheFirstItem() {
        editDeliveryAddressPage.firstitematEditCart();
    }


    @Then("user lands on the Edit cart page")
    public void userLandsOnTheEditCartPage() {
        editDeliveryAddressPage.EditCartPage();
    }

    @Then("user clicks Edit order at order page")
    public void userClicksEditOrderAtOrderPage() {
        editDeliveryAddressPage.editorderbutton();
    }

    @Then("user add item to cart and click checkout")
    public void userAddItemToCart() {
        editDeliveryAddressPage.add2checkout();
    }

    @Then("^user add \"([^\"]*)\" item to cart$")
    public void user_add_something_item_to_cart(String strArg1) throws Throwable {
        editDeliveryAddressPage.changeItemNewQuantity(strArg1);
    }


    @And("^click on Edit pickup time$")
    public void click_on_edit_pickup_time() {
        editDeliveryAddressPage.editPickUpPage();
    }
}

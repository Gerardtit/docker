package com.automation.pages;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDevice;
import com.automation.mobile.appium.AppiumDeviceManager;
import com.automation.mobile.entities.BannerConfType;
import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.CheckoutPageElements;
import com.automation.pageElements.GG_CartPageElements;
import com.automation.pageElements.NewCheckoutPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewCheckoutPage extends BasePage {
    public NewCheckoutPageElements newCheckoutPageElements = new NewCheckoutPageElements();
    public CheckoutPageElements pageElements = new CheckoutPageElements();

    GG_CartPage ggCartpage = new GG_CartPage(driver);
    private GG_CartPageElements gg_cartPageElements = new GG_CartPageElements();


    public String preFilledZip;
//    GG_CartPage ggCartpage = new GG_CartPage(driver);

    AppiumDevice device = AppiumDeviceManager.getDevice();
    String Zipcode;
    String lastStoreDistance;
    String defaultaddress;
    String address = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE1_FORSR);
    String prefilledAddress;
    String prefilledSlotAddress;
    String afterChangingtipAtordersummery;
    String afterChangingtipAtEditPage;
    String tip = ThreadLocalHelper.testCaseData.get().get("Desired_Tip");
    MobileElement Keyboard = newCheckoutPageElements.numericKeyboard;
    int pressX = driver.manage().window().getSize().width;
    double bottomY = driver.manage().window().getSize().height * 0.57;
    int bottomY_int = (int) bottomY;
    double topY = driver.manage().window().getSize().height * 0.3;
    int topY_int = (int) topY;
    String orderNoOnOC;
    String orderNoOnOH;
    String cancelOrderTitileTxt;
    String cancelOrderTitileCopyTxt;
//    private final GG_CartPageElements gg_cartPageElements = new GG_CartPageElements();

    public NewCheckoutPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), newCheckoutPageElements);
    }

    public void pickupIsSelected() {
        waitVar.until(ExpectedConditions.visibilityOf(newCheckoutPageElements.slotPickuptoggle));
        newCheckoutPageElements.slotPickuptoggle.isSelected();
    }

    public void deliveryIsSelected() {
        waitVar.until(ExpectedConditions.visibilityOf(newCheckoutPageElements.slotDeliveryToggle));
        newCheckoutPageElements.slotDeliveryToggle.isSelected();
    }

    public void clickEditBtn() {
        waitForClickableAndClick(newCheckoutPageElements.slotEditBtn);
    }

    public void selectPickupStoreDisplayed() {
        waitForLoadingComplete();
        Assert.assertTrue(newCheckoutPageElements.selectPickupStoreTxt.isDisplayed());
        System.out.println(newCheckoutPageElements.selectPickupStoreTxt.getText());
    }

    public void zipPreFilled(String zipcode) {
        preFilledZip = newCheckoutPageElements.slotsearchZip.getText();
        Zipcode = device.getZipCode(zipcode);
        Assert.assertEquals(preFilledZip, Zipcode, "ZipCode matches");
    }

    public void tapEnterZipCodeSearchfield() {
        tapElement(newCheckoutPageElements.slotsearchZip);
    }

    public void verifyNumericKeyboard() {

        try {
            Assert.assertTrue(Keyboard.isDisplayed());

            for (MobileElement keysElement : newCheckoutPageElements.numericKeys) {
                Assert.assertTrue(keysElement.getAttribute("label").matches("\\d+"));
                if (keysElement.getAttribute("label").equals("9")) {
                    break;
                }
            }
            System.out.println("Numeric Keyboard is displayed");
        } catch (Exception e) {

        }
    }

    public void enterZip() {
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.slotsearchZip);
        driver.getKeyboard().pressKey(Zipcode);
        //enterTextNoPressEnter(newCheckoutPageElements.slotsearchZip, Zipcode);
    }

    public void keyboardSlidesDown() {
        Assert.assertFalse(isElementDisplayed(newCheckoutPageElements.numericKeyboard));
    }

    public void searchAutoTrigger() {
        Assert.assertTrue(isElementDisplayed(newCheckoutPageElements.allStoreCards));
    }

    public void scrollableSearchResults() {
        scrollDownForElement(newCheckoutPageElements.lastStore);
        waitForLoadingComplete();
        lastStoreDistance = newCheckoutPageElements.lastStore.getAttribute("label");

    }

    public boolean verifyDUGWUG() {

        ArrayList<MobileElement> elements = (ArrayList<MobileElement>) driver.findElementsByClassName("XCUIElementTypeButton");
        boolean bFlag = true;
        for (MobileElement element : elements) {
            if (element.getAttribute("label").equalsIgnoreCase("Delivery")) {
                bFlag = false;
            } else bFlag = !element.getAttribute("label").equalsIgnoreCase("in-store");
        }
        return bFlag;
    }

    public void verify50MilesRadius() {
        Pattern p = Pattern.compile("\\d*\\.\\d{1,2}");
        Matcher m = p.matcher(lastStoreDistance);
        if (m.find()) {
            float distance = Float.parseFloat(m.group());
            if (distance < 50)
                Assert.assertTrue(true, "Distance of last store was less than 50 miles");
            else
                Assert.assertTrue(false, "Distance of last store was more than 50 miles");
        } else
            Assert.assertTrue(false, "Matcher couldn't find");


    }

    public void defaultMidPoint() {
        Assert.assertTrue(isElementDisplayed(newCheckoutPageElements.scndStore));
        Assert.assertFalse(isElementDisplayed(newCheckoutPageElements.thirdStore), "default midpoint is retained on landing");
    }

    public void storePinVisible() {
        Assert.assertTrue(isElementDisplayed(newCheckoutPageElements.storePin), "Store Pin is visible");
    }

    public void storePinInVisible() {
        Assert.assertTrue(isElementDisplayed(newCheckoutPageElements.slideUp5thStore), "Sheet is pulled up");
        //Assert.assertFalse(isElementDisplayed(newCheckoutPageElements.storePin), "Store Pin is not visible");
    }

    public void pullUpSheetToViewStoreList() {
        waitForLoadingComplete();

    }

    public void pullUpSheet() {

        scroll(pressX / 2, bottomY_int, pressX / 2, topY_int);
    }

    public void pullDownSheet() {

        scroll(pressX / 2, topY_int, pressX / 2, bottomY_int);

    }

    public void pullDownFurther() {
        double further_bottomY = driver.manage().window().getSize().height * 0.9;
        int further_bottomY_int = (int) further_bottomY;
        scroll(pressX / 2, bottomY_int, pressX / 2, further_bottomY_int);
    }

    public void mapZoomed() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(isElementDisplayed(newCheckoutPageElements.horizontal_FirstStore));
        Assert.assertFalse(isElementDisplayed(newCheckoutPageElements.scndStore));
    }

    public void clickPaymentMethod() {

        if (newCheckoutPageElements.continueToPaymentBtn.isEnabled()) {
            new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.continueToPaymentBtn);

            waitForLoadingComplete();
        } else {
            new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.anotherDaySlot);
            new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.continueToPaymentBtn);

        }
    }

    public void enterCardPage() {
        isElementDisplayed(newCheckoutPageElements.enterCardDeatilsPage);
    }

    public void clickDone() {
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.keypadDoneBtn);
    }

    public void clickContinue() throws InterruptedException {
        Thread.sleep(3000);
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.continueBtn);
    }


    public void addressScreen() {
        //  isElementDisplayed(pageElements.addressLine1TextField);
        isElementDisplayed(newCheckoutPageElements.addressLineTextField);
    }

    public void cvvScreen() {
        isElementDisplayed(newCheckoutPageElements.confirmCvvTxt);
    }

    public void placeOrderisDisplayed() throws InterruptedException {
        waitForLoadingComplete();
        isElementDisplayed(newCheckoutPageElements.placeOrderCTA);
        Thread.sleep(3000);
    }

    public void reservetimeWindowisDisplayed() {
        isElementDisplayed(newCheckoutPageElements.reserveTimeText);
        waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.continueBtn);
        waitForLoadingComplete();
    }

    public void addPromocodeisDisplayed() {
        waitForLoadingComplete();
        isElementDisplayed(newCheckoutPageElements.addPromoCode);
    }

    public void addPromoCode(String promoCode) {
        // enterKey(pageElements.promoCodeTextField, promoCode);
        waitForLoadingComplete();
        // waitForLoadingComplete();
        waitVar.until(ExpectedConditions.visibilityOf(newCheckoutPageElements.promoCodeTextField));
        waitVar.until(ExpectedConditions.visibilityOf(newCheckoutPageElements.applyPromoCode));
        //new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.promoCodeTextField);
        enterKey(newCheckoutPageElements.promoCodeTextField, "abc");
        // enterValue(newCheckoutPageElements.promoCodeTextField, promoCode);
        waitForLoadingComplete();
        //new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.applyPromoCode);
    }

    public void clickAddPromoCode() {
        waitForLoadingComplete();
        //  isElementDisplayed(newCheckoutPageElements.addPromoCode);
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.addPromoCode);
        waitForLoadingComplete();
        //   enterKey(newCheckoutPageElements.promoCodeTextField, "FREEDELIVERY");
        //   waitForLoadingComplete();
    }

    public void enterAddPromoCode() {
        waitForLoadingComplete();
        //  isElementDisplayed(newCheckoutPageElements.addPromoCode);
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.addPromoCode);
        waitForLoadingComplete();
        enterKey(newCheckoutPageElements.promoCodeTextField, "FREEDELIVERY");
        waitForLoadingComplete();
    }

    public void paymentDetails() {
        // isElementDisplayed(newCheckoutPageElements.textOrderStatus);
       /* enterKey(pageElements.expirationMonthYear, monthYear);
        waitForLoadingComplete();
        enterKey(pageElements.billingZip, zipcode);
        tapSearchAndroidKeyboard();
*/
    }

    public void textOrderisDisplayed() {
        isElementDisplayed(newCheckoutPageElements.textOrderStatus);
    }


    public void clickContinueOnSlotSelection() {
        waitForLoadingComplete();
        try {
            if (newCheckoutPageElements.continueToPaymentCTA.isDisplayed()) {
                //   pageElements.continueToPaymentCTA.click();
                new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.continueToPaymentCTA);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        waitForLoadingComplete();
    }

    //  waitForLoadingComplete();
    public void clickOnSearchField() {
        waitForLoadingComplete();
        waitForDisplayed(newCheckoutPageElements.searchTextField, 5);
        tapCoordinate(newCheckoutPageElements.searchTextField.getCenter().getX(), newCheckoutPageElements.searchTextField.getCenter().getY());
        // new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.searchTextField);
    }


    public void keyboardDismissed() {
        Assert.assertFalse(isElementDisplayed(Keyboard), "Keyboard dismissed on clicking Done");
    }

    public void continueToReviewOrder() {
        Assert.assertTrue(newCheckoutPageElements.continueToReviewOrder.isEnabled(), "Continue to review order button is active");
    }


    public void tapOnPaymentCard() {
        tapElementCoordinate(newCheckoutPageElements.paymentCard);
    }


  /*  public void navigateToContactInfo() {
      new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.continueToReviewOrder);
        Assert.assertTrue(isElementDisplayed(newCheckoutPageElements.contactInfoPage), "Clicking on continue to contact info, takes user to contact info page");
    }*/

    public void clickCloseCTA() {
        waitForLoadingComplete();
        waitForLoadingComplete();
        //   waitForDisplayed(newCheckoutPageElements.closeButton);
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.closeButton);
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.closeButton);
//      new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.confirmNo);
        waitForLoadingComplete();
    }

    public void exitslotselectionscreen() {
        waitForLoadingComplete();
        waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.closeButton);
        waitForLoadingComplete();
    }


    public void clickEditOnCvvScreen() {
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.editOnCvvScreen);
    }

    public void continueToContactInfo() {
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.continueToContactInfo);
        Assert.assertTrue(isElementDisplayed(newCheckoutPageElements.contactInfoPage), "Clicking on continue to contact info, takes user to contact info page");
    }

    public void verifyStateFieldIsNotEditable() {
        String state = newCheckoutPageElements.stateTextField.getText();
        if (state.isEmpty()) {
            System.out.println("State field is empty");
        } else {
            enterValue(newCheckoutPageElements.stateTextField, "xyz");
            System.out.println("Unable to edit state Field");
        }
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.stateTextField);
        //  Assert.assertTrue(isElementDisplayed(newCheckoutPageElements.contactInfoPage), "Clicking on continue to contact info, takes user to contact info page");
    }

    public void verify2ndLineisOptional() {
        //new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.addressLine2TestField);
        Assert.assertTrue(isElementDisplayed(newCheckoutPageElements.addressLine2TextField), "Address line 2 is optional");
    }

    public void verifyPrefilledTextFields() {
        String zip = newCheckoutPageElements.zipCodeTextField.getText();
        String city = newCheckoutPageElements.cityTextField.getText();
        String state = newCheckoutPageElements.stateTextField.getText();
        if (zip.isEmpty()) {
            System.out.println("Zipcode field is empty");
        } else {
            System.out.println("Zipcode field is prefilled");
        }
        if (city.isEmpty()) {
            System.out.println("City field is empty");
        } else {
            System.out.println("City field is prefilled");
        }
        if (state.isEmpty()) {
            System.out.println("State field is empty");
        } else {
            System.out.println("State field is prefilled");
        }
    }


    public void enterContactInformation() {
        if (platformName.equalsIgnoreCase("android")) {
            //new CommonActions(driver).new ClickAction().clickElement(pageElements.closeCTA);
            newCheckoutPageElements.enterFirstname.sendKeys("fname");
            newCheckoutPageElements.enterLastname.sendKeys("fname");
            newCheckoutPageElements.enterMobileNumber.sendKeys("8908908989");
            new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.toggleButton);
            new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.continueToReviewOrderCTA);

         /*   enterKey(newCheckoutPageElements.enterFirstname, "Fname");
            enterKey(newCheckoutPageElements.enterLastname, "Lname");
            enterKey(newCheckoutPageElements.enterMobileNumber, "9988787987");
            waitForLoadingComplete();
            //waitForDisplayed(newCheckoutPageElements.contactInfoTitle);
          new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.toggleButton);

            waitForLoadingComplete();
            //scrollDown();
            newCheckoutPageElements.mobileNumberEntered.click();
            tapEnterAndroidKeyboard();

            newCheckoutPageElements.mobileNumberEntered.click();
            tapNextAndroidKeyboard();
            tapNextAndroidKeyboard();
            tapNextAndroidKeyboard();
            tapNextAndroidKeyboard();
            tapNextAndroidKeyboard();
            tapNextAndroidKeyboard();
            tapNextAndroidKeyboard();

          new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.saveCTA);
          */

        } else {
            newCheckoutPageElements.enterFirstname.sendKeys("Fname");
            newCheckoutPageElements.enterLastname.sendKeys("Lname");
            newCheckoutPageElements.enterMobileNumber.sendKeys("8908908989");
            new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.toggleButton);
            new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.doneButton);
            new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.continueToReviewOrderCTA);
            waitForLoadingComplete();

        }
    }

    public void saveAddressPagedisplay() {
        isElementDisplayed(newCheckoutPageElements.savedAddressesPage);
    }

    public void defaultAddressSelected() {
        try {
            defaultaddress = newCheckoutPageElements.defaultAddress.getAttribute("label");
            Assert.assertTrue(defaultaddress.contains(address));
            Assert.assertTrue(newCheckoutPageElements.radioBtnSavedAddresses.isSelected(), "default address is selected");
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void navigateToCheckout() {
        //clickElement(newCheckoutPageElements.continueToReviewOrder);
        Assert.assertTrue(isElementDisplayed(newCheckoutPageElements.yourorderTxt), "Clicking on continue to review order, takes user to checkout page");
    }

    public void clickCloseBttn() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            waitVar.until(ExpectedConditions.visibilityOf(newCheckoutPageElements.closeButton));
            new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.closeButton);
        } else {
            scrollUp();
            if (isElementDisplayed(newCheckoutPageElements.saveChangesPopUp)) {
                newCheckoutPageElements.Clickyespopup.click();
            }
        }
        /*Dimension d= driver.manage().window().getSize();
        int y= d.getHeight();
        int x=d.getWidth();
        System.out.println("y axis is"+y+ " and x axis is "+x);
        tapCoordinate((int) (driver.manage().window().getSize().width * 0.89), (int) (driver.manage().window().getSize().height * 0.17));
    */
        //  verifypopupifdisplay();
    }

    public void navigateToSlotSelection() {
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.continueToSLotSelection);
    }

    public void updateContactToggle() {
        //new CommonActions(driver).new ClickAction().clickElement(pageElements.closeCTA);
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.toggleButton);
        waitForLoadingComplete();
        //   pressEnterAndroid();
        scrollDown();
        tapCoordinate(139, 2875);
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.continueToReviewOrderCTA);
        // pressEnterAndroid();
        waitForLoadingComplete();
        //new CommonActions(driver).new ClickAction().clickElement(pageElements.continueToReviewOrderCTA);
        waitForLoadingComplete();

    }

    public void verifyTextOrderStatusMessage() {
        Assert.assertTrue(isElementDisplayed(newCheckoutPageElements.textmyOrderStatusMessage), "Text me my order status message not there");

    }

    public void verifyWarningTextOrderStatus() {
        Assert.assertTrue(isElementDisplayed(newCheckoutPageElements.turnOnTextMessage, 10), "Clicking on continue to contact info, takes user to contact info page");

    }

    public void clickSaveButton() {
        waitForClickableAndClick(newCheckoutPageElements.saveButton);
    }

    public void cardLogoDisplayed() {
        isElementDisplayed(newCheckoutPageElements.cardLogo);
    }

    public void validateCardNumber(String cardLast4Digits) {
        try {
            String cardNumber = "";
            if (driver.getPlatformName().equalsIgnoreCase("android")) {
                cardNumber = newCheckoutPageElements.cardLastDigits.getText();
                Assert.assertTrue(cardNumber.contains(cardLast4Digits));
            } else {
                Assert.assertTrue(newCheckoutPageElements.cardLastDigits.getAttribute("label").contains(cardLast4Digits));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clickPaymentTile() {
        newCheckoutPageElements.cardLastDigits.click();
    }

    public void selecteddatetimeSlotIsDisplayed() {
        isElementDisplayed(newCheckoutPageElements.selectedSlot);
    }

    public void dateSlotIsDisplayed() {
        isElementDisplayed(newCheckoutPageElements.dateSlot);
    }

    public void timeSlotIsDisplayed() {
        isElementDisplayed(newCheckoutPageElements.timeSlot);
    }

    public void deliveryHeaderIsDisplayed() {
        isElementDisplayed(newCheckoutPageElements.deliveryHeaderText);
    }

    public void pickupHeaderIsDisplayed() {
        isElementDisplayed(newCheckoutPageElements.pickupHeaderText);
    }

    public void clickEditAddress() {
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.slotEditBtn);
    }

    public void editAddressPagedisplayed() {
        isElementDisplayed(newCheckoutPageElements.editAddressPage);
    }

    public void verifyAddress() {
        try {
            prefilledAddress = pageElements.addressLine1TextField.getAttribute("label");
            Assert.assertTrue(prefilledAddress.contains(address));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clickEditAddBackBtn() {
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.EditAddBackBtn);
    }

    public void tapPlusIcon() {
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.addAddressBtn);
    }

    public void verfifyAddressOnSlotScreen() {
        try {
            prefilledSlotAddress = newCheckoutPageElements.addressOnSlotSelection.getAttribute("label");
            Assert.assertTrue(prefilledSlotAddress.contains(address));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tapsUseThisAddress() {
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.useThisAddressBtn);
    }

    public void plusIconDissapears() {
        Assert.assertFalse(isElementDisplayed(newCheckoutPageElements.addAddressBtn), "plus icon to add address dissapears post 13 addresses added");
    }
  /*public String getAddress(String deliveryAddress) throws Exception{

            String newAddress;
            AppiumDevice device = AppiumDeviceManager.getDevice();

      switch (deliveryAddress) {
          case "address2":
              newAddress = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE2");
              break;
          case "address3":
              newAddress = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE3");
              break;
          case "address4":
              newAddress = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE4");
              break;
          case "address5":
              newAddress = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE5");
              break;
          case "address6":
              newAddress = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE6");
              break;
          case "address7":
              newAddress = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE7");
              break;
          case "address8":
              newAddress = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE8");
              break;
          case "address9":
              newAddress = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE9");
              break;
          case "address10":
              newAddress = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE10");
              break;
          case "address11":
              newAddress = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE11");
              break;
          case "address12":
              newAddress = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE12");
              break;
          case "address13":
              newAddress = ThreadLocalHelper.testCaseData.get().get("ADDRESSLINE13");
              break;

          default:
              newAddress = device.getConfigureData(BannerConfType.BANNER_ADDRESS_LINE1_FORSR);
      }
      return newAddress;
  }
    public void enterNewAddressDetails(String deliveryAddress) throws Exception{

        AppiumDevice device = AppiumDeviceManager.getDevice();

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            enterKey(pageElements.addressLine1TextField, deliveryAddress);
          new CommonActions(driver).new ClickAction().clickElement(pageElements.egMsg);
            pageElements.egMsg.sendKeys("\n");
            Thread.sleep(1000);
          new CommonActions(driver).new ClickAction().clickElement(pageElements.saveCTA);
        }
        else{
            enterKey(pageElements.addressField, deliveryAddress);
            //   hideKeyBoard();
            //  waitForLoaderToDisappear();
            waitForLoadingComplete();
            Thread.sleep(5000);
            // new CommonActions(driver).new ClickAction().clickElement(pageElements.saveCTA);
        }
    }*/

    public void tapSlotSelctionCard() {
        scrollUpForElement(newCheckoutPageElements.slotSelectionCard);
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.slotSelectionCard);

    }

    public void verifyAgeRestrictedMsg() {
        isElementDisplayed(newCheckoutPageElements.ageRestrictedMessage);
        Assert.assertTrue(newCheckoutPageElements.ageRestrictedMessage.getAttribute("label").contains("Your cart contains age-restricted items. Someone over 21 with a valid ID must be present to accept this order."));
    }

    public void toggleToDelivery() {
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.slotDeliveryToggle);
    }


    public void clickOnCartCard() {
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.cartCardOnCheckout);
    }

    public void clickItemsCount() {
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.itemSizeOnCart);
    }

    public void reduceItemsinCart(String qty) throws InterruptedException {
        for (int i = 0; i < Integer.parseInt(qty); i++) {
            Thread.sleep(3000);
            for (MobileElement element : newCheckoutPageElements.minusIcon) {
                element.click();
                waitForLoadingComplete();
                Thread.sleep(5000);

            }
        }
    }

    public void verifyCartValueLessThan30$() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            String cartAmount = newCheckoutPageElements.cartWorth.getText();
            Assert.assertTrue(Integer.parseInt(cartAmount) < 30);
        } else {
            String cartAmount = newCheckoutPageElements.cartWorth.getAttribute("label");
            Assert.assertTrue(Integer.parseInt(cartAmount) < 30);
        }
    }

    public void clickBackBtnToCloseCart() {
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.closeCartBackBtn);
    }


    public void verifyCartDeficitAlertMsg() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            Assert.assertTrue(isElementDisplayed(newCheckoutPageElements.alertMsgForLessCartSize));
            System.out.println(newCheckoutPageElements.alertMsgForLessCartSize.getText());
        } else
            Assert.assertTrue(isElementDisplayed(newCheckoutPageElements.alertMsgForLessCartSize));
        System.out.println(newCheckoutPageElements.alertMsgForLessCartSize.getAttribute("label"));
    }


    public void clickNoForSaveChanges() {
        waitForDisplayed(newCheckoutPageElements.saveChangesPopUp, 10);
        newCheckoutPageElements.saveChangesNoButton.click();
    }

    public void verifySlotSelectionPageDisplayed() {
        waitForDisplayed(newCheckoutPageElements.pickUpOption, 10);
    }

    public void tippingchange() {
        scrollDownForElement(newCheckoutPageElements.drivertipchange);
        newCheckoutPageElements.drivertipchange.isDisplayed();

    }

    public void tippingchangeclickable() {
        scrollDownForElement(newCheckoutPageElements.drivertipchange);
        newCheckoutPageElements.drivertipchange.isDisplayed();
        newCheckoutPageElements.drivertipchange.click();

    }

    public void tippingtext() {
        scrollDownForElement(newCheckoutPageElements.drivertipchangetext);
        newCheckoutPageElements.drivertipchangetext.isDisplayed();
    }

    public void custometipping() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            newCheckoutPageElements.drivertipchange.click();
            newCheckoutPageElements.chevronatcustom.click();
        } else {
            newCheckoutPageElements.drivertipchange.click();
        }
        newCheckoutPageElements.customtipwindow.isDisplayed();

    }

    public void customtipZero() {
        String Customtip = ThreadLocalHelper.testCaseData.get().get("tipzero");
        waitForLoadingComplete();
        enterKey(newCheckoutPageElements.customtipeditbox, Customtip);
        newCheckoutPageElements.customtipapply.click();
        newCheckoutPageElements.customtipsave.isEnabled();
        newCheckoutPageElements.customtipsave.click();
    }

    public void copytipping() {
        scrollDownForElement(newCheckoutPageElements.drivertip);
        newCheckoutPageElements.drivertip.isDisplayed();
        scrollDownForElement(newCheckoutPageElements.drivertipatSummary);
        waitForDisplayed(newCheckoutPageElements.drivertipatSummary);
        newCheckoutPageElements.drivertipatSummary.isDisplayed();

    }

    public boolean savetipping() {

        newCheckoutPageElements.customtipsave.isEnabled();
        return true;
    }

    public void customtipApply() {
        String Customtip = ThreadLocalHelper.testCaseData.get().get("tipAbove20%");
        waitForLoadingComplete();
        enterKey(newCheckoutPageElements.customtipeditbox, Customtip);
        newCheckoutPageElements.customtipapply.click();
        newCheckoutPageElements.customtipsave.isEnabled();
        newCheckoutPageElements.customtipsave.click();
    }


    public void tippercent() {
        waitForLoadingComplete();
        waitForDisplayed(newCheckoutPageElements.tip5);
        newCheckoutPageElements.tip5.isDisplayed();
        newCheckoutPageElements.tip10.isDisplayed();
        newCheckoutPageElements.tip15.isDisplayed();
        newCheckoutPageElements.customtip.isDisplayed();


    }

    public boolean firsttip() {
        newCheckoutPageElements.tip5.click();
        return newCheckoutPageElements.saveButton.isEnabled();
    }

    public boolean secondtip() {

        newCheckoutPageElements.tip10.click();
        return newCheckoutPageElements.saveButton.isEnabled();
    }

    public boolean thirdtip() {

        newCheckoutPageElements.tip15.click();
        return newCheckoutPageElements.saveButton.isEnabled();
    }

    public void verifypopup() {
        newCheckoutPageElements.savechangeslabel.isDisplayed();
        newCheckoutPageElements.Clickyespopup.click();
        waitForLoadingComplete();

    }

    public void verifypopupifdisplay() {
        if (isElementDisplayed(newCheckoutPageElements.savechangeslabel, 20)) ;
        {
            newCheckoutPageElements.Clickyespopup.click();
            waitForLoadingComplete();
        }

    }

    public void clickslot() {
        newCheckoutPageElements.slotselect.click();
    }

    public void incrementProductQuantityNew(int qty) {
        tapCoordinate(gg_cartPageElements.stepperQty.getCenter().getX(), gg_cartPageElements.stepperQty.getCenter().getY());
        for (int i = 0; i < qty; i++) {
            switch (driver.getPlatformName().toUpperCase()) {
                case "IOS":
                    tapCoordinate(gg_cartPageElements.stepperView.getCenter().getX() + gg_cartPageElements.stepperView.getSize().getWidth() / 3, gg_cartPageElements.stepperView.getCenter().getY());
                    break;
                case "ANDROID":
                    new CommonActions(driver).new ClickAction().clickElement(gg_cartPageElements.incrementProductQty);
                    break;
            }
        }
    }

    public void verifyProductIconsOnCartsCard() {
        isElementVisible(newCheckoutPageElements.productIconsOnCartsCard);

        for (MobileElement element : newCheckoutPageElements.productIconsOnCartsCard) {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                element.getAttribute("label");

            }
            element.getText();
            //verify more on the count part

        }
    }

    public void verifyFourPlusXItemsOnCartsCard() {
        isElementDisplayed(newCheckoutPageElements.fourPlusXItemsOnCartsCard);
        //verify the calculation
    }

    public void verifyitemsCountOnCartsCard() {
        isElementDisplayed(newCheckoutPageElements.itemsCountOnCartsCard);
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            newCheckoutPageElements.itemsCountOnCartsCard.getAttribute("label");
        }
        newCheckoutPageElements.itemsCountOnCartsCard.getText();
        //verify the calculation
    }

    public void verifyCompleteCartscardIsTappable() {
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.completeCartscard);
    }

    public void clearSearchtext() {
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.clearXBtnOnSearchAgain);
    }

    public void updateCustomTipAndVerify() {
        waitForLoadingComplete();
        enterKey(newCheckoutPageElements.enterTipAmountTextField, "100.00");
        waitForLoadingComplete();
        Assert.assertTrue(newCheckoutPageElements.tipExceedErrorMessage.isDisplayed());
    }


    public void verifyDriverTippingOptionNotDisplayed() {
        Assert.assertFalse(isElementDisplayed(newCheckoutPageElements.drivertip), "Driver tipping option is visible");
    }


    public void verifyDriverTippingOptionDisplayed() {
        Assert.assertTrue(isElementDisplayed(newCheckoutPageElements.drivertip), "Driver tipping option is not visible");
    }

    public void updateTip() {
        newCheckoutPageElements.slotselect.click();
    }

    public void editatordersummery() {
        scrollUp();
        if (!isElementDisplayed(newCheckoutPageElements.Editatordersummery)) {
            newCheckoutPageElements.vieworderCTA.click();
        }
        newCheckoutPageElements.Editatordersummery.click();
    }

    public void tipatEditpage() {
        waitForLoadingComplete();
        waitForLoaderToDisappear();
        scrollDownForElement(newCheckoutPageElements.TipatEdit);
        newCheckoutPageElements.TipatEdit.isDisplayed();
        waitForDisplayed(newCheckoutPageElements.tipamountatedit);
        newCheckoutPageElements.tipamountatedit.isDisplayed();

    }

    public boolean tipafterchange() {
        waitForLoaderToDisappear();
        waitForLoaderToDisappear();
        waitForLoaderToDisappear();
        waitForLoaderToDisappear();
        waitForLoadingComplete();
        waitForLoadingComplete();
        scrollDown();
        waitForDisplayed(newCheckoutPageElements.tipamountatedit);
        if (newCheckoutPageElements.tipamountatedit.getAttribute("name").endsWith(tip)) {
            return true;
        }
        return false;
    }

    public void clickconfirm() {
        waitForLoadingComplete();
        scrollDown();
        newCheckoutPageElements.ConfirmEditChange.click();
    }

    public void validatetipatOrdersummery() {
        waitForLoadingComplete();
        scrollDown();
        scrollDownForElement(newCheckoutPageElements.tipamountordersummery);
        waitForLoadingComplete();
        waitForDisplayed(newCheckoutPageElements.tipamountordersummery);
        afterChangingtipAtordersummery = newCheckoutPageElements.tipamountordersummery.getText();
        newCheckoutPageElements.tipamountordersummery.isDisplayed();

    }

    public void selectDesiredtip() {
        String tip = ThreadLocalHelper.testCaseData.get().get("Desired_Tip");
        List<MobileElement> Tips_percentage = new ArrayList<>();
        Tips_percentage.add(newCheckoutPageElements.tip5);
        Tips_percentage.add(newCheckoutPageElements.tip10);
        Tips_percentage.add(newCheckoutPageElements.tip15);
        for (MobileElement Tipradiobutton : Tips_percentage) {
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                if (Tipradiobutton.getAttribute("name").startsWith(tip)) {
                    Tipradiobutton.click();
                }
            }
            if (driver.getPlatformName().equalsIgnoreCase("android")) {

                if (Tipradiobutton.getAttribute("text").contains(tip)) {
                    Tipradiobutton.click();
                }
            }
        }


    }

    public boolean tipnotdiplayed() {
        if (!isElementDisplayed(newCheckoutPageElements.drivertipatSummary)) {
            return true;
        }
        return false;
    }

    public boolean Notipatordercofirmation() {
        if (!isElementDisplayed(newCheckoutPageElements.drivertipatOrderConfirmation)) {
            return true;
        }
        return false;
    }


    public void giventipatOrdersummery() {
        waitForLoaderToDisappear();
        waitForLoadingComplete();
        scrollDown();
        newCheckoutPageElements.Editatordersummery.isDisplayed();
    }

    public void userNotesOrderNumber() {
        if (platformName.equalsIgnoreCase("ios")) {
            orderNoOnOC = newCheckoutPageElements.orderNumberOnOrderConfirmationPage.getAttribute("label");
        } else {
            orderNoOnOC = newCheckoutPageElements.orderNumberOnOrderConfirmationPage.getText();
        }

    }

    public void clickOnOrderBtn() {
        newCheckoutPageElements.ordersBtnUnderMenu.click();
    }

    public void veriyOrderHistoryPage() {
        isElementDisplayed(newCheckoutPageElements.yourOrderTxtOnOrderHistoryScreen);
    }

    public void verfiyMapOnOrderHistoryPage() {
        isElementDisplayed(newCheckoutPageElements.mapOnOrderHistory);
    }

    public void verifyOrderNumber() {
        if (platformName.equalsIgnoreCase("ios")) {
            orderNoOnOH = newCheckoutPageElements.orderNumberOnOrderHistory.getAttribute("label");
            Assert.assertTrue(orderNoOnOC.contains(orderNoOnOH));
        } else {
            orderNoOnOH = newCheckoutPageElements.orderNumberOnOrderHistory.getText();
            Assert.assertTrue(orderNoOnOC.contains(orderNoOnOH));
        }

    }

    public void clickTrackOrder() {
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.trackOrderBtn);
    }

    public void clickCancelOrder() {
        new CommonActions(driver).new ClickAction().clickElement(newCheckoutPageElements.cancelOrderBtn);
    }

    public void verifyCancelOrderPopUp() {
        Assert.assertTrue(isElementDisplayed(newCheckoutPageElements.cancelOrderPopUp));
    }

    public void verifyCancelOrderTitle(String expectedTxt) {
        if (platformName.equalsIgnoreCase("ios")) {
            cancelOrderTitileTxt = newCheckoutPageElements.cancelOrderTitle.getAttribute("label");
            Assert.assertTrue(cancelOrderTitileTxt.matches(expectedTxt));
        } else {
            cancelOrderTitileTxt = newCheckoutPageElements.cancelOrderTitle.getText();
            Assert.assertTrue(cancelOrderTitileTxt.matches(expectedTxt));
        }
    }

    public void verifyCancelOrderCopy(String expectedTxt) {
        if (platformName.equalsIgnoreCase("ios")) {
            cancelOrderTitileCopyTxt = newCheckoutPageElements.cancelOrderCopy.getAttribute("label");
            Assert.assertTrue(cancelOrderTitileCopyTxt.matches(expectedTxt));
        } else {
            cancelOrderTitileCopyTxt = newCheckoutPageElements.cancelOrderCopy.getText();
            Assert.assertTrue(cancelOrderTitileCopyTxt.matches(expectedTxt));
        }

    }

    public void scrollDownToFind() {
        double further_bottomY = driver.manage().window().getSize().height * 0.9;
        int further_bottomY_int = (int) further_bottomY;
        scroll(pressX / 2, further_bottomY_int, pressX / 2, bottomY_int);
    }

    public void scrollDownToFindCO() {
        scrollDownForElement(newCheckoutPageElements.cancelOrderBtn);
    }


}



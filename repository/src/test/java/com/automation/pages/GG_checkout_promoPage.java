package com.automation.pages;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.pageElements.GG_checkout_promoElements;
import com.automation.pageElements.HomePageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GG_checkout_promoPage extends BasePage {
    public HomePageElements homePageElements = new HomePageElements();
    private final GG_checkout_promoElements contactPromoElements = new GG_checkout_promoElements();

    public GG_checkout_promoPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), contactPromoElements);

        PageFactory.initElements(new AppiumFieldDecorator(driver), homePageElements);
    }

    public void promocode() {
        scrollDownForElement(contactPromoElements.promocodetext);
        contactPromoElements.promocodetext.isDisplayed();
    }

    public void promocodeclicked() {
        contactPromoElements.promocodetext.click();
    }

    public void ctainactive() {

        String firstalpha = ThreadLocalHelper.testCaseData.get().get("Aletter");
        contactPromoElements.promoeditbox.click();
        if (!isElementDisplayed(contactPromoElements.applypromo)) {
            enterKey(contactPromoElements.promoeditbox, firstalpha);
            waitForTextPresentInElement(contactPromoElements.promoeditbox, firstalpha);
        }
        contactPromoElements.applypromo.isEnabled();
    }


    public void errormessage() {
        String invalidPromo = ThreadLocalHelper.testCaseData.get().get("InvalidPromo");
        if (isElementDisplayed(contactPromoElements.promocodetext)) {
            contactPromoElements.promocodetext.click();
        }
        contactPromoElements.promoeditbox.click();
        enterKey(contactPromoElements.promoeditbox, invalidPromo);
        contactPromoElements.applypromo.click();
        scrollDownForElement(contactPromoElements.warningmessage);
        contactPromoElements.warningmessage.isDisplayed();
    }

    public void clearbox() {
        contactPromoElements.crosssigninedit.click();

    }

    public void Applyclicked() {
        String validPromo = ThreadLocalHelper.testCaseData.get().get("validPromo");
        contactPromoElements.promoeditbox.click();
        enterKey(contactPromoElements.promoeditbox, validPromo);
        contactPromoElements.applypromo.click();

    }

    public void pricesaved() {
        contactPromoElements.closepromoapply.click();
        String before = contactPromoElements.costbefore.getText();
        String validPromo = ThreadLocalHelper.testCaseData.get().get("validPromo");
        contactPromoElements.promoeditbox.click();
        enterKey(contactPromoElements.promoeditbox, validPromo);
        contactPromoElements.applypromo.click();
        String after = contactPromoElements.costbefore.getText();
        Assert.assertNotSame(before, after, "not same");
    }

    public void clearpromo() {
        waitForLoadingComplete();
        waitForDisplayed(contactPromoElements.closepromoapply);
        contactPromoElements.closepromoapply.click();
    }

    public void extrapromocode() {
        String validPromo = ThreadLocalHelper.testCaseData.get().get("validPromo");
        String ExtraPromo = ThreadLocalHelper.testCaseData.get().get("Promo");
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            scrollDownForElement(contactPromoElements.promoeditbox);
        }
        waitForLoadingComplete();
        if (isElementDisplayed(contactPromoElements.promocodetext)) {
            contactPromoElements.promocodetext.click();
        }
        contactPromoElements.promoeditbox.click();
        enterKey(contactPromoElements.promoeditbox, validPromo);
        contactPromoElements.applypromo.click();
        scrollDownForElement(contactPromoElements.promocodetext);
        contactPromoElements.promocodetext.click();
        contactPromoElements.promoeditbox.click();
        enterKey(contactPromoElements.promoeditbox, ExtraPromo);
        contactPromoElements.applypromo.click();
    }
}


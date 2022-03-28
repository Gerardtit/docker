package com.automation.pages;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.pageElements.GG_checkout_COAElements;
import com.automation.pageElements.HomePageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GG_checkout_COAPage extends BasePage {
    public HomePageElements homePageElements = new HomePageElements();
    private final GG_checkout_COAElements contactCOAElements = new GG_checkout_COAElements();

    public GG_checkout_COAPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), contactCOAElements);

        PageFactory.initElements(new AppiumFieldDecorator(driver), homePageElements);
    }

    public void applycredit() {
        scrollDownForElement(contactCOAElements.COActa);
        contactCOAElements.COActa.isDisplayed();
    }

    public void applycreditclicked() {
        contactCOAElements.COActa.click();
        contactCOAElements.totalCOA.isDisplayed();
    }

    public void creditamountentered() {
        contactCOAElements.COAeditbox.click();
        String coaamount = ThreadLocalHelper.testCaseData.get().get("COA_amount");
        enterKey(contactCOAElements.COAeditbox, coaamount);

    }

    public void creditedtext() {
        waitForDisplayed(contactCOAElements.creditapplied);
        contactCOAElements.creditapplied.isDisplayed();
    }

    public void cancelcredit() {
        contactCOAElements.closecreditapply.click();
    }

    public boolean regainCredit() {
        contactCOAElements.postCOActa.isDisplayed();
//        String pretext = contactCOAElements.COActa.getText();
        String posttext = contactCOAElements.postCOActa.getText();
        return posttext.contains("Apply credit on account");
    }


}


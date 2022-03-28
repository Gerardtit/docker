package com.automation.pages;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.pageElements.Analytics_PageElements.StepperQtyPageElements;
import com.automation.pageElements.GG_checkout_contactinfoElements;
import com.automation.pageElements.HomePageElements;
import com.automation.pageElements.PaymentPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GG_E2E_freshpassPage extends BasePage {
    public HomePageElements homePageElements = new HomePageElements();
    public PaymentPageElements pageElements = new PaymentPageElements();
    public StepperQtyPageElements qtyPageElements = new StepperQtyPageElements();
    private final GG_checkout_contactinfoElements contactinfoElements = new GG_checkout_contactinfoElements();

    public GG_E2E_freshpassPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), contactinfoElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), qtyPageElements);

        PageFactory.initElements(new AppiumFieldDecorator(driver), homePageElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
    }


    public void cvvtext() {
        String cvv = ThreadLocalHelper.testCaseData.get().get("CVV");
        waitForLoadingComplete();
        enterKey(contactinfoElements.cvvText, cvv);
        contactinfoElements.Continuetorevieworder.isEnabled();
        contactinfoElements.Continuetorevieworder.click();

    }


    public void closepaymentad() {
        if (!isElementDisplayed(contactinfoElements.confirmCVVtext)) {
            qtyPageElements.androidBackArrow.click();
        }
    }

    public void savecard() {
        contactinfoElements.savecreditcard.click();
    }

}


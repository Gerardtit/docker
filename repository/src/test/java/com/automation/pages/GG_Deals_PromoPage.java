package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_Deals_PromoPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GG_Deals_PromoPage extends BasePage {

    public GG_Deals_PromoPageElements pageElements = new GG_Deals_PromoPageElements();

    public GG_Deals_PromoPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), pageElements);
    }

    public boolean verifyPromoCard() {
        return isElementDisplayed(pageElements.promoCardSubjectTitle);
    }

    public boolean verifyPromoCardSubjectTitle() {
        return isElementDisplayed(pageElements.promoCardSubjectTitle);
    }

    public boolean verifyPromoCardDescription() {
        return isElementDisplayed(pageElements.promoCardDescription);
    }

    public boolean clickPromoCardCtaBtnAndCheckForToastMsg() {
        pageElements.promoCardCTAbutton.click();
        return pageElements.promoCodeCopiedAnimationLabel.isDisplayed();
    }

    public void waitThreeSeconds() throws InterruptedException {
        Thread.sleep(3000);
    }

    public boolean isPromoCodeCopiedAnimationLabelDisplayed() {
        return isElementDisplayed(pageElements.promoCodeCopiedAnimationLabel);
    }

    public boolean verifyImageOnPromoDeal() {
        return isElementDisplayed(pageElements.promoDealImage);
    }

    public void clickOnPromoDeal() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.promoCard);
    }

    public boolean verifyPromoDealDetailPage() {
        waitForLoadingComplete();
        return isElementDisplayed(pageElements.promoDealDetailPage, 15);
    }

    public boolean verifyPromoDealCTA() {
        return isElementDisplayed(pageElements.promoCardCTAbutton);
    }

    public void clickSearchIcon() {
        new CommonActions(driver).new ClickAction().clickElement(pageElements.searchIconOnPromoDealPage);
    }

}

package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_Tutorial_ToolTipPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.PageFactory;

public class GG_Tutorial_ToolTipPage extends BasePage {
    private final GG_Tutorial_ToolTipPageElements tutorial_toolTipPageElements = new GG_Tutorial_ToolTipPageElements();

    public GG_Tutorial_ToolTipPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), tutorial_toolTipPageElements);
    }

    public boolean verifyToolTipDescriptionForDealsTab() {
        return isElementDisplayed(tutorial_toolTipPageElements.toolTipDescriptionOnDealTab);
    }

    public void clickOnNextButtonOnTutorialToolTip() {

        if (isElementDisplayed(tutorial_toolTipPageElements.toolTipDescriptionOnDealTab)) {
            new CommonActions(driver).new ClickAction().clickElement(tutorial_toolTipPageElements.toolTipNextButtonOnTab);

        }
    }

    public void clickRandomLocationOnScreenTutorials() {
        if (!isElementDisplayed(tutorial_toolTipPageElements.toolTipNextButtonOnTab, 5)) {
            return;
        }

        if (!isElementDisplayed(tutorial_toolTipPageElements.dealsTab, 5)) {
            TouchAction action = new TouchAction(driver);
            int windowWidth = driver.manage().window().getSize().getWidth();
            int windowHeight = driver.manage().window().getSize().getHeight();
            action.tap(PointOption.point(windowWidth, windowHeight / 2)).perform();
        }
    }

    public boolean isShoppingMethodStageDisplayed() {
        return isElementDisplayed(tutorial_toolTipPageElements.shoppingModeToolTip);
    }

    public boolean isDealStageDisplayed() {
        return isElementDisplayed(tutorial_toolTipPageElements.dealsToolTip);
    }

    public boolean isWalletStageDisplayed() {
        return isElementDisplayed(tutorial_toolTipPageElements.walletToolTip);
    }
}

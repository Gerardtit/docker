package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_RefineElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GG_RefinePage extends BasePage {
    private final GG_RefineElements gg_refinePageElements = new GG_RefineElements();

    public GG_RefinePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), gg_refinePageElements);
    }

    public void clickRefineButton() {
        new WaitAction(driver).waitForLoaderToDisappear();
        if (isElementDisplayed(gg_refinePageElements.refineButtonInProductListSearchInEditCart)) {
            new CommonActions(driver).new ClickAction().clickElement(gg_refinePageElements.refineButtonInProductListSearchInEditCart);
        } else {
            new WaitAction(driver).waitForDisplayed(gg_refinePageElements.refineButton, 5);
            new CommonActions(driver).new ClickAction().clickElement(gg_refinePageElements.refineButton);
        }
    }

    public void filterByDesiredOption(String optionName, String optionCheckValue) {
        switch (driver.getPlatformName().toUpperCase()) {
            case "IOS":
                String desiredCheckUncheckOption = optionCheckValue.equalsIgnoreCase("check") ? "unchecked" : "checked";
                gg_refinePageElements.filterOptions.stream().filter(filterOptn -> getText(filterOptn).contains(optionName) && getText(filterOptn).split("\\.")[1].replaceAll("\\s", "").equalsIgnoreCase(desiredCheckUncheckOption)).findFirst().ifPresent(elem -> elem.click());
                break;
            case "ANDROID":
                desiredCheckUncheckOption = optionCheckValue.equalsIgnoreCase("check") ? "false" : "true";
                gg_refinePageElements.filterOptions.stream().filter(filterOptn -> getText(filterOptn).contains(optionName) && filterOptn.getAttribute("checked").contains(desiredCheckUncheckOption)).findFirst().ifPresent(elem -> elem.click());
                break;
        }
    }

    public void saveTheRefineFilterOptns() {
        new CommonActions(driver).new ClickAction().clickElement(gg_refinePageElements.saveRefineFilterBtn);
        waitForLoadingComplete();
    }

}

package com.automation.pages;

import com.automation.pageElements.GG_Verify_FreshpassElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class GG_Annual_FreshPassPage extends BasePage {

    public GG_Verify_FreshpassElements freshpassElements = new GG_Verify_FreshpassElements();

    public GG_Annual_FreshPassPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), freshpassElements);
    }

    public void managePlantext() {
        freshpassElements.Manageyourplan.isDisplayed();
    }

    public void subPlantext() {
        freshpassElements.subtextWithplan.isDisplayed();
    }

    public void plantype() {
        freshpassElements.Crrentplantitle.isDisplayed();
    }

    public void planAmount() {
        freshpassElements.planamount.isDisplayed();
    }

    public void customerservice() {
        freshpassElements.VIPtext.isDisplayed();
    }

    public void changetab() {
        freshpassElements.changeAtPlan.isDisplayed();

    }

    public void cancelText() {
        scrollDownForElement(freshpassElements.CancelFreshPass);
        freshpassElements.CancelFreshPass.isDisplayed();
    }


}

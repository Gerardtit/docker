package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.pageElements.GG_SaveCategoryPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GG_SaveCategoryPage extends BasePage {


    private final GG_SaveCategoryPageElements categoryPageElements = new GG_SaveCategoryPageElements();

    public GG_SaveCategoryPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), categoryPageElements);
    }


    public void clickBackBtn() {

        new CommonActions(driver).new ClickAction().clickElement(categoryPageElements.backBtn);
    }


    public void clickAcountBackBtn() {

        new CommonActions(driver).new ClickAction().clickElement(categoryPageElements.acountBackBtn);
    }


    public void getCategoryPageDescription() {
        waitVar.until(ExpectedConditions.visibilityOf(categoryPageElements.categoryDescription));
    }


    public void clickSkip() {
        new CommonActions(driver).new ClickAction().clickElement(categoryPageElements.skip);
    }

    public void selectFirstCategory() {
        new CommonActions(driver).new ClickAction().clickElement(categoryPageElements.selectFirstCategory);
    }

    public void selectSecondCategory() {
        new CommonActions(driver).new ClickAction().clickElement(categoryPageElements.selectSecondCategory);
    }

    public void getContinueButton() {
        new CommonActions(driver).new ClickAction().clickElement(categoryPageElements.continueButton);
    }


    public void selectMultipleCategory() {
        new CommonActions(driver).new ClickAction().clickElement(categoryPageElements.selectMultipleCategory.get(0));
        new CommonActions(driver).new ClickAction().clickElement(categoryPageElements.selectMultipleCategory.get(1));
    }


    public boolean checkContinueButtonNotDisplayed() {
        return categoryPageElements.continueButtonVisiblity.size() == 0;
    }

    public boolean checkContinueButtonDisplayed() {
        return categoryPageElements.continueButtonVisiblity.size() == 1;
    }


}

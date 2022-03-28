package com.automation.pages;

import com.automation.pageElements.GG_FreshPassMemberTab_Elements;
import com.automation.pageElements.MemberFreshPassPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MemberFreshPassPage extends BasePage {
    public MemberFreshPassPageElements memberFreshPassPageElements = new MemberFreshPassPageElements();
    public GG_FreshPassMemberTab_Elements ggFreshPassMemberTabElements = new GG_FreshPassMemberTab_Elements();

    public MemberFreshPassPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), ggFreshPassMemberTabElements);
        PageFactory.initElements(new AppiumFieldDecorator(driver), memberFreshPassPageElements);
    }

    public void verifyHowMuchYouCouldSave() {
        scrollDown(3);
        waitForDisplayed(ggFreshPassMemberTabElements.howMuchYouCouldSave);
        Assert.assertTrue(ggFreshPassMemberTabElements.howMuchYouCouldSave.isDisplayed());
    }

    public void clickOnSaveUpToDollarAYearLink() throws InterruptedException {
        Thread.sleep(5000);
        String text = ggFreshPassMemberTabElements.saveUpToDollarAYear.getText();
        System.out.println("Text value : " + text);
        String newTest = text.substring(46, 50);
        System.out.println(newTest);
        int gY = ggFreshPassMemberTabElements.saveUpToDollarAYear.getCenter().getY();
        int gX = ggFreshPassMemberTabElements.saveUpToDollarAYear.getCenter().getX();
        System.out.println(gX + " " + gY);
        tapCoordinate(283, 1524);
        waitForClickableAndClick(ggFreshPassMemberTabElements.saveUpToDollarAYear);
//      new CommonActions(driver).new ClickAction().clickElement(ggFreshPassMemberTabElements.saveUpToDollarAYear);
    }

    public void verifyEstimatedSavings() {
        waitForDisplayed(ggFreshPassMemberTabElements.estimatedSavings);
        Assert.assertTrue(ggFreshPassMemberTabElements.estimatedSavings.isDisplayed());
        ggFreshPassMemberTabElements.closesheet.click();
    }

    public void verifyEstimatedSavingsText() {
        waitForDisplayed(ggFreshPassMemberTabElements.estimatedSavingsText);
        Assert.assertTrue(ggFreshPassMemberTabElements.estimatedSavingsText.isDisplayed());
    }

    public void verifyWelcomeTextIfNoFirstNameLastName() {
        waitForDisplayed(memberFreshPassPageElements.welcomeText);
        Assert.assertTrue(memberFreshPassPageElements.welcomeText.isDisplayed());
    }

    public void verifyFirstNameIfFirstNameLastNameIsAvailable() {
        waitForDisplayed(memberFreshPassPageElements.firstName);
        Assert.assertTrue(memberFreshPassPageElements.firstName.isDisplayed());
    }

    public void verifyLongFirstNameIfFirstNameHaveTooManyCharacter() {
        waitForDisplayed(memberFreshPassPageElements.longFirstName);
        Assert.assertTrue(memberFreshPassPageElements.longFirstName.isDisplayed());
    }


}

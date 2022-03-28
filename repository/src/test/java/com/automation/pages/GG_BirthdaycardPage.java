package com.automation.pages;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.GG_birthdaycardElements;
import com.automation.pageElements.HomePageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GG_BirthdaycardPage extends BasePage {
    public HomePageElements homePageElements = new HomePageElements();
    private final GG_birthdaycardElements bdaycardElements = new GG_birthdaycardElements();

    public GG_BirthdaycardPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), bdaycardElements);

        PageFactory.initElements(new AppiumFieldDecorator(driver), homePageElements);
    }

    public void closebdaycard() {
        if (driver.getPlatformName().equalsIgnoreCase("android")) {
            new WaitAction(driver).waitForLoadingComplete();
            if (isElementDisplayed(bdaycardElements.crossSign, 3)) {
                bdaycardElements.crossSign.click();
            }
            new WaitAction(driver).waitForLoadingComplete();
        }
        if (isElementDisplayed(bdaycardElements.crossSign, 3)) {
            bdaycardElements.crossSign.click();
        }
    }

    public void bdaycardselected() {

//        scrollDownForElement(bdaycardElements.pdeals);
        new WaitAction(driver).waitForDisplayed(bdaycardElements.bdaycard);
        new WaitAction(driver).waitForClickableAndClick(bdaycardElements.bdaycard);
//        bdaycardElements.bdaycard.click();
//       bdaycardElements.bdayPage.isDisplayed();

    }

    public void validdobenter() {
        String DOB = "02 / 25";
        bdaycardElements.dobedit.click();
        enterKey(bdaycardElements.dobedit, DOB);

//        waitForTextPresentInElement(bdaycardElements.dobedit, DOB);
        new WaitAction(driver).waitForLoadingComplete();
        bdaycardElements.confirmDOB.isEnabled();
        bdaycardElements.confirmDOB.click();
    }

    public void invaliddobenter() throws Exception {
        String dob;
        dob = ThreadLocalHelper.testCaseData.get().get("INValid_DateOFBirth");
        enterKey(bdaycardElements.dobedit, dob);
        new WaitAction(driver).waitForLoadingComplete();
        String regex = "^(0[1-9]|1[0-2](0[1-9]|[12][0-9]|3[01]))$";
        if (dob.matches(regex)) {
            bdaycardElements.confirmDOB.isEnabled();
        } else {

//                  waitForTextPresentInElement(bdaycardElements.dobedit, dob);


            //if(isElementDisplayed(bdaycardElements.entervaliddate)) {
            Assert.assertTrue(isElementDisplayed(bdaycardElements.entervaliddate), "Enter valid date error msg is not displayed");
            // }
            Assert.assertFalse(bdaycardElements.confirmDOB.isEnabled(), "Confirm button is enabled");
            if (driver.getPlatformName().equalsIgnoreCase("ios")) {
                Assert.assertTrue(isElementDisplayed(bdaycardElements.cleareditbox), "red cross icon is not displayed");
                bdaycardElements.cleareditbox.click();
                waitForLoadingComplete();
                Assert.assertFalse(isElementDisplayed(bdaycardElements.cleareditbox), "red cross icon is displayed");
                Assert.assertFalse(isElementDisplayed(bdaycardElements.entervaliddate), "Enter valid date error msg is displayed");
            } else {
                bdaycardElements.dobedit.clear();
                waitForLoadingComplete();
                Assert.assertFalse(isElementDisplayed(bdaycardElements.entervaliddate), "Enter valid date error msg is displayed");

            }


        }
    }

    public void bdaycardtext() {
        new WaitAction(driver).waitForLoadingComplete();
        new WaitAction(driver).waitForDisplayed(bdaycardElements.cardtitle);
        bdaycardElements.cardtitle.isDisplayed();
        bdaycardElements.cardsubtitle.isDisplayed();
        bdaycardElements.closeDOB.isDisplayed();

    }


    public void verifyBirthdayCardText() {

        String text = "";

        scrollDownForElement(bdaycardElements.bdaycard);
       /* if(driver.getPlatformName().equalsIgnoreCase("android"))
        {
             text= bdaycardElements.bdaycard.getText().trim();
        }
        else {
             text= bdaycardElements.bdaycard.getAttribute("label").trim();
        }
        System.out.println("text"+text);
       */// Assert.assertTrue(text.contains("Get a birthday treat on us"),"message is incorrect on bday card");

        Assert.assertTrue(isElementDisplayed(bdaycardElements.bdaycard), "bday card section is not displayed");
    }

    public void verifyToastMessage() {

        Boolean text = false;
     /*   String toastMsg = "";
        if(driver.getPlatformName().equalsIgnoreCase("android"))
        toastMsg = bdaycardElements.bdayToastMsg.getText().trim();
        else
            toastMsg =bdaycardElements.bdayToastMsg.getAttribute("label").trim();
        System.out.println("msg"+toastMsg);*/
        //Assert.assertEquals(toastMsg.contains("Come back in your birthday month for a special treat!"),"message is not displayed");
        // for(int i=0;i<3;i++) {
        // waitForDisplayed(bdaycardElements.bdayToastMsg,20);
        if (bdaycardElements.bdayToastMsg.isDisplayed()) {
            text = true;
        }
        // }

        Assert.assertTrue(text, "message is not displayed");
    }

    public void verifyBirthdayCardTextNotDisplayed() {
        Assert.assertFalse(isElementDisplayed(bdaycardElements.bdaycard), "get special treat message is displaying in Rewards tab");

    }

    public void clickOnUserName() {
        bdaycardElements.userName.click();
    }

    public void verifyBirthdayInAccount() {
        Assert.assertTrue(isElementDisplayed(bdaycardElements.birthdayText), "Birthday is not displayed");
        Assert.assertTrue(isElementDisplayed(bdaycardElements.infoIcon), "Info icon is not displayed");
        Assert.assertTrue(isElementDisplayed(bdaycardElements.bdayEditButton), "edit button is not displayed");
    }

    public void clickOnBirthday() {
        bdaycardElements.birthdayText.click();
    }

    public void verifyEditButtonInBdayNotDisplay() {
        Assert.assertFalse(isElementDisplayed(bdaycardElements.bdayEditButton), "Edit button is displayed");
    }
}


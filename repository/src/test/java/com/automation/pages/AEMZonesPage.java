package com.automation.pages;

import com.automation.mobile.util.CommonActions;
import com.automation.mobile.util.WaitAction;
import com.automation.pageElements.AEMZonesPageElements;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class AEMZonesPage extends BasePage {

    public AEMZonesPageElements aemZonesPageElements = new AEMZonesPageElements();

    public String medBannerTitle;
    public String lpName;
    public String medBannerTitleBrowsePage;
    public String lpNamebrowsepage;
    public String medBannerTitle_subString;
    public String medBannerTitle_subStringBrowsePage;
    public String productName;

    public AEMZonesPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), aemZonesPageElements);
    }

    public void scrollDownForLPCarouselBrowsePage(String text) {
//        scrollDownForElement(findElementByName(item));
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            //  scrollDownForElement(aemZonesPageElements.carouselLPATitleHomePage);
            scrollDownForElement(aemZonesPageElements.carouselLPATitleBrowsePage);
          /*  WebElement element = findElementByLabel(text);
            if (element.isDisplayed()) {

            } else {
                scrollDown();
            }*/
        } else {
            scrollDownForElement(aemZonesPageElements.carouselLPATitleBrowsePage);

          /*  for (int i = 0; i < 10; i++) {
                ArrayList<MobileElement> elementList = (ArrayList<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
                for (MobileElement element : elementList) {
                    if (element.getText().equalsIgnoreCase(text)) {
                        return;
                    }
                }
                scrollDown();
                scrollDown();
                // scrollDownForElement(aemZonesPageElements.carouselLPATitleHomePage);
            }*/
            scrollDown();
        }
    }

    public void screenPositionRetained(String text) {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            Assert.assertTrue(findElementByLabel(text).isDisplayed());
        } else {
            Assert.assertTrue(textDisplayed(text));
//            Assert.assertTrue(containTextDisplayed(text));

        }
    }

    public void scrollDownForLPCarouselHomePage(String text) {
//        scrollDownForElement(findElementByName(item));
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            scrollDownForElement(aemZonesPageElements.carouselLPATitleHomePage);
          /*  WebElement element = findElementByLabel(text);
            if (element.isDisplayed()) {

            } else {
                scrollDown();
            }*/
        } else {
            for (int i = 0; i < 10; i++) {
                ArrayList<MobileElement> elementList = (ArrayList<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
                for (MobileElement element : elementList) {
                    if (element.getText().equalsIgnoreCase(text)) {
                        return;
                    }
                }
                scrollDown();
                scrollDown();
                // scrollDownForElement(aemZonesPageElements.carouselLPATitleHomePage);
            }
        }
    }

    public boolean verifyCarouselTitle(String text) {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            ArrayList<MobileElement> elements = (ArrayList<MobileElement>) driver.findElementsByName("lblSeeAllTitle");
            for (MobileElement element : elements) {
                if (element.getAttribute("label").equalsIgnoreCase(text)) {
                    return true;
                }
            }
        } else {
            ArrayList<MobileElement> elementList = (ArrayList<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
            for (MobileElement element : elementList) {
                if (element.getText().equalsIgnoreCase(text)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verifyCarouselSubTitle(String text) {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            ArrayList<MobileElement> elements = (ArrayList<MobileElement>) driver.findElementsByName("lblSeeAllSubTitle");
            for (MobileElement element : elements) {
                if (element.getAttribute("label").equalsIgnoreCase(text)) {
                    return true;
                }
            }
        } else {
            ArrayList<MobileElement> elementList = (ArrayList<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
            for (MobileElement element : elementList) {
                if (element.getText().equalsIgnoreCase(text)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verifySeeAllButtonTitle(String text) {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            ArrayList<MobileElement> elements = (ArrayList<MobileElement>) driver.findElementsByName("btnSeeAllButtonTitle");
            for (MobileElement element : elements) {
                if (element.getAttribute("label").equalsIgnoreCase(text)) {
                    return true;
                }
            }
        } else {
            ArrayList<MobileElement> elementList = (ArrayList<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
            for (MobileElement element : elementList) {
                if (element.getText().equalsIgnoreCase(text)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean userClickSeeAllButton(String text) {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            ArrayList<MobileElement> elements = (ArrayList<MobileElement>) driver.findElementsByName("btnSeeAllButtonTitle");
            for (MobileElement element : elements) {
                if (element.isDisplayed()) {
                    if (element.getAttribute("label").equalsIgnoreCase(text)) {
                        new CommonActions(driver).new ClickAction().clickElement(element);
                        return true;
                    }
                }
            }
        } else {
            ArrayList<MobileElement> elementList = (ArrayList<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
            for (MobileElement element : elementList) {
                if (element.getText().equalsIgnoreCase(text)) {
                    new CommonActions(driver).new ClickAction().clickElement(element);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean userClickctaLabel(String text) {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            ArrayList<MobileElement> elements = (ArrayList<MobileElement>) driver.findElementsByName("btnSeeAllButtonTitle");
            for (MobileElement element : elements) {
                if (element.isDisplayed()) {
                    if (element.getAttribute("label").equalsIgnoreCase(text)) {
                        new CommonActions(driver).new ClickAction().clickElement(element);
                        return true;
                    }
                }
            }
        } else {

//            text = "Carousel Title " + text;
            ArrayList<MobileElement> elementList = (ArrayList<MobileElement>) driver.findElementsByClassName("android.widget.Button");
            for (MobileElement element : elementList) {
                if (element.getText().equalsIgnoreCase(text)) {
                    new CommonActions(driver).new ClickAction().clickElement(element);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verifySheetUiNotOpened() {
//        boolean sheetUi = aemZonesPageElements.carouselsheetClose.isDisplayed();
//        Assert.assertFalse(sheetUi);
        return (isElementDisplayed(aemZonesPageElements.carouselsheetClose));
//        Assert.assertTrue(!aemZonesPageElements.carouselsheetClose.isDisplayed());
    }

    public void scrollDownForCarouselLandingPage(String text) {
//        scrollDownForElement(findElementByName(item));
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            scrollDown();

        } else {
            for (int i = 0; i < 10; i++) {
                ArrayList<MobileElement> elementList = (ArrayList<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
                for (MobileElement element : elementList) {
                    if (element.getText().equalsIgnoreCase(text)) {
                        return;
                    }
                }
                scrollDown();
                scrollDown();
            }
        }
    }

    public void clickButton(String text) {
//        scrollDownForElement(findElementByName(item));
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new CommonActions(driver).new ClickAction().clickElement(findElementByLabel(text));

        } else {
            driver.findElement(By.xpath("//android.widget.TextView[contains(@text, '" + text + "')]")).click();
        }
    }

    public void scrollDownForCarouselHomePage(String text) {
//        scrollDownForElement(findElementByName(item));
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            scrollDownForElement(aemZonesPageElements.carouselTitleHomePage);
          /*  WebElement element = findElementByLabel(text);
            if (element.isDisplayed()) {

            } else {
                scrollDown();
            }*/
        } else {
            for (int i = 0; i < 10; i++) {
                ArrayList<MobileElement> elementList = (ArrayList<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
                for (MobileElement element : elementList) {
                    if (element.getText().equalsIgnoreCase(text)) {
                        return;
                    }
                }
                scrollDown();
                scrollDown();
                // scrollDownForElement(aemZonesPageElements.carouselLPATitleHomePage);
            }
        }
    }

    public void scrollDownForCarousel(String text) {
//        scrollDownForElement(findElementByName(item));

        waitForLoadingComplete();

        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            for (int i = 0; i < 30; i++) {
                try {
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    WebElement ele = findElementByLabel(text);
                    if (ele.isDisplayed()) {
                        return;
                    }
                } catch (Exception e) {
                }
                scrollDown();
            }
//            return false;
        } else {
            for (int i = 0; i < 30; i++) {              // Preeti: updated the iteration to 20
                ArrayList<MobileElement> elementList = (ArrayList<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
                for (MobileElement element : elementList) {
                    if (element.getText().equalsIgnoreCase(text)) {
                        return;
                    }
                }
                scrollDown();
            }
        }
    }

    /*public void scrollDownForBanner(String text) {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            for (int i = 0;i<20; i++) {
                ArrayList<MobileElement> elementList = (ArrayList<MobileElement>) driver.findElementsByClassName("XCUIElementTypeButton");
                for (MobileElement element : elementList) {
                    if (element.getText().contains(text)) {
                        return;
                    }
                }
                scrollDown();
            }
//            return false;
        } else {
            for (int i = 0; i < 20; i++) {              // Preeti: updated the iteration to 20
                ArrayList<MobileElement> elementList = (ArrayList<MobileElement>) driver.findElementsByClassName("android.widget.TextView");
                for (MobileElement element : elementList) {
                    if (element.getText().equalsIgnoreCase(text)) {
                        return;
                    }
                }
                scrollDown();
            }
        }

    }*/


    public void verifyCarouselTitleHomePage() {
        new WaitAction(driver).waitForLoadingComplete();
        Assert.assertTrue(aemZonesPageElements.carouselTitleHomePage.isDisplayed());
    }

    public void clickLPACarouselHomePage() {

        new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.carouselLPATitleHomePage);
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void clickCarouselLPACTAHomePage() {

        new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.carouselLPACTAHomePage);
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void verifyAddbuttonLandingPage() {
        new WaitAction(driver).waitForLoadingComplete();
        Assert.assertTrue(aemZonesPageElements.addCTA_LandingPage.isDisplayed());

    }

    public void verifyLPACarouselCTAHomePage() {
        // new WaitAction(driver).waitForLoadingComplete();
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new WaitAction(driver).waitForLoadingComplete();
        } else {
            Assert.assertTrue(aemZonesPageElements.carouselLPACTAHomePage.isDisplayed());
        }

    }

    public void verifyLPACarouselSubTitleHomePage() {
        // new WaitAction(driver).waitForLoadingComplete();
        Assert.assertTrue(aemZonesPageElements.carouselLPASubTitleHomePage.isDisplayed());
    }

    public void navigateBackToPreviousPage() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            driver.navigate().back();
            new WaitAction(driver).waitForLoadingComplete();
            //   sleep(50000);
            //   wait(50000);
        } else {
            driver.navigate().back();
        }

    }

    public void verifyLPACarouselTitleHomePage() {
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {

            Assert.assertTrue(aemZonesPageElements.carouselLPATitleHomePage.isDisplayed());
            new WaitAction(driver).waitForLoadingComplete();
        } else {
            Assert.assertTrue(aemZonesPageElements.carouselLPATitleHomePage.isDisplayed());
        }

    }

    public void verifyCarouselTitle() {
        Assert.assertTrue(aemZonesPageElements.carouselTitle.isDisplayed());
    }

    public void verifyLargeBannerLpCta() {
        Assert.assertTrue(aemZonesPageElements.largeBannerLpCta.isDisplayed());
    }

    public void verifyCarouselSheetTitle() {
        Assert.assertTrue(aemZonesPageElements.carouselsheetTitle.isDisplayed());
    }

    public void verifyCarouselSheetSubTitle() {
        Assert.assertTrue(aemZonesPageElements.carouselsheetSubTitle.isDisplayed());
    }

    public void verifyCarouselSheetCloseCTA() {
        Assert.assertTrue(aemZonesPageElements.carouselsheetClose.isDisplayed());
    }

    public void verifyClickCarouselSheetCloseCTA() {
        //  Assert.assertTrue(aemZonesPageElements.carouselsheetClose.isDisplayed());
        new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.carouselsheetClose);
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void clickCloseSheetiOS() {
        //  Assert.assertTrue(aemZonesPageElements.carouselsheetClose.isDisplayed());
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.carouselsheetClose);
            waitForLoadingComplete();
        }
    }

    public void scrollLeftandRightToViewProducts() {

        for (int i = 0; i < 5; i++) {
            //    swipeLeftOnElement(aemZonesPageElements.buyItAgainCards);
            swipeLeft();
        }
        new WaitAction(driver).waitForLoadingComplete();

    }

    public void scrollUpandDownToViewProducts() {
        //  Assert.assertTrue(aemZonesPageElements.carouselsheetClose.isDisplayed());
        scrollDown();

        waitForLoadingComplete();
        scrollUp();
        waitForLoadingComplete();

    }

    public void verifyCarouselSubTitle() {
        Assert.assertTrue(aemZonesPageElements.carouselSubTitle.isDisplayed());
    }

    public void verifyCarouselCtaText() {
        Assert.assertTrue(aemZonesPageElements.carouselCtaText.isDisplayed());
    }

    public void verifyBannerCTAType() {
        Assert.assertTrue(aemZonesPageElements.ctaLp.isDisplayed());
        medBannerTitle = aemZonesPageElements.mediumBannerLpTitle.getText();
    }

    public void verifyCustomLP() {
        waitVar.until(ExpectedConditions.visibilityOf(aemZonesPageElements.ctaLp));
        aemZonesPageElements.ctaLp.click();
        Assert.assertTrue(aemZonesPageElements.landingPageName.isDisplayed());
        lpName = aemZonesPageElements.landingPageName.getText();
    }


    public void verifyCustomLandingPage() {
        waitVar.until(ExpectedConditions.visibilityOf(aemZonesPageElements.carouselCtaText));
        aemZonesPageElements.carouselCtaText.click();
        Assert.assertTrue(aemZonesPageElements.landingPageName.isDisplayed());
        lpName = aemZonesPageElements.landingPageName.getText();
    }

    public void verifySimpleCarouselCustomLandingPage() {
        waitVar.until(ExpectedConditions.visibilityOf(aemZonesPageElements.carouselSimpleLpCtaText));
        aemZonesPageElements.carouselSimpleLpCtaText.click();
        Assert.assertTrue(aemZonesPageElements.landingPageName.isDisplayed());
        lpName = aemZonesPageElements.landingPageName.getText();
    }

    public void verifyLargeBannerCustomLandingPage() {
        waitVar.until(ExpectedConditions.visibilityOf(aemZonesPageElements.largeBannerLpCta));
        aemZonesPageElements.largeBannerLpCta.click();
        Assert.assertTrue(aemZonesPageElements.landingPageName.isDisplayed());
        lpName = aemZonesPageElements.landingPageName.getText();
    }

    public void verifyCustomSheetUI() {
        waitVar.until(ExpectedConditions.visibilityOf(aemZonesPageElements.carouselCtaText));
        aemZonesPageElements.carouselCtaText.click();
    }

    public void verifyLPNameAsBannerTitle() {
        Assert.assertTrue(medBannerTitle.contains(lpName));
        //Assert.assertEquals(lpName, medBannerTitle);
    }

    public void verifyLargeBannerLPNameAsBannerTitle() {
        Assert.assertNotNull("LP title is null", lpName);
    }

    public void verifyPositionOnBackBtnClick() {
        waitVar.until(ExpectedConditions.visibilityOf(aemZonesPageElements.LpBackBtn));
        aemZonesPageElements.LpBackBtn.click();
        Assert.assertTrue(aemZonesPageElements.ctaLp.isDisplayed());
        System.out.println(aemZonesPageElements.ctaLp.getText());
        System.out.println("Position is retained");
    }

    public void clickOnBackBtnInLandingPage() throws InterruptedException {
        waitVar.until(ExpectedConditions.visibilityOf(aemZonesPageElements.LpBackBtn));
        aemZonesPageElements.LpBackBtn.click();
        Thread.sleep(2);
    }

    public void verifyCarouselCtaHomePage() {
        Assert.assertTrue(aemZonesPageElements.carouselCTA.isDisplayed());
    }

    public void clickCarouselCTA() {
        //  Assert.assertTrue(aemZonesPageElements.carouselCtaText.isDisplayed());
        new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.carouselCtaText);
    }

    public void clickCarouselCTAHomePage() {
        //  Assert.assertTrue(aemZonesPageElements.carouselCtaText.isDisplayed());
        new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.carouselCTA);
    }


    public void verifyBannerCTATypeBrowsePage() {
        Assert.assertTrue(aemZonesPageElements.ctaLpBrowsePage.isDisplayed());
        medBannerTitleBrowsePage = aemZonesPageElements.mediumBannerLpTitleBrowsePage.getText();
    }

    public void verifyCustomLPBrowsePage() {
        waitVar.until(ExpectedConditions.visibilityOf(aemZonesPageElements.ctaLpBrowsePage));
        aemZonesPageElements.ctaLpBrowsePage.click();
        Assert.assertTrue(aemZonesPageElements.landingPageNameBrowsePage.isDisplayed());
        lpNamebrowsepage = aemZonesPageElements.landingPageNameBrowsePage.getText();


    }

    public void verifyLPNameAsBannerTitleBrowsePage() {
        Assert.assertTrue(medBannerTitleBrowsePage.contains(lpNamebrowsepage));

        //Assert.assertEquals(lpNamebrowsepage,medBannerTitleBrowsePage );
    }

    public void verifyPositionOnBackBtnClickBP() {
        waitVar.until(ExpectedConditions.visibilityOf(aemZonesPageElements.LpBackBtn));
        aemZonesPageElements.LpBackBtn.click();
        Assert.assertTrue(aemZonesPageElements.ctaLpBrowsePage.isDisplayed());
        System.out.println(aemZonesPageElements.ctaLpBrowsePage.getText());
        System.out.println("Position is retained");
    }

    public void verifyBannerCTATypeNone() {
        waitVar.until(ExpectedConditions.visibilityOf(aemZonesPageElements.ctaNone));
        Assert.assertTrue(aemZonesPageElements.mediumBannerNoneTitle.isDisplayed());
    }

    public void noActionCtaHomePage() {
        aemZonesPageElements.ctaNone.click();
        Assert.assertTrue(aemZonesPageElements.mediumBannerNoneTitle.isDisplayed());
        Assert.assertTrue(aemZonesPageElements.ctaNone.isDisplayed());
    }

    public void verifyBannerCTATypeNoneBrowsePage() {
        waitVar.until(ExpectedConditions.visibilityOf(aemZonesPageElements.ctaNoneBrowsePage));
        Assert.assertTrue(aemZonesPageElements.mediumBannerNoneTitleBrowsePage.isDisplayed());
        Assert.assertTrue(aemZonesPageElements.ctaNoneBrowsePage.isDisplayed());
    }

    public void noActionCtaBrowsePage() {
        aemZonesPageElements.ctaNoneBrowsePage.click();
        Assert.assertTrue(aemZonesPageElements.mediumBannerNoneTitleBrowsePage.isDisplayed());
        Assert.assertTrue(aemZonesPageElements.ctaNoneBrowsePage.isDisplayed());
    }


    public void clickBanner(String banner) {
        if (banner.equalsIgnoreCase("CTA search"))
            new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.ctaSearch);

        else if (banner.equalsIgnoreCase("CTA external"))
            new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.ctaExternal);

    }

    public void verifyLPACarouselTitleBrowsePage() {
        //   scrollDownForElement(aemZonesPageElements.carouselLPATitleBrowsePage);
        Assert.assertTrue(aemZonesPageElements.carouselLPATitleBrowsePage.isDisplayed());
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void verifyLPACarouselSubTitleBrowsePage() {
        Assert.assertTrue(aemZonesPageElements.carouselLPASubTitleBrowsePage.isDisplayed());
    }

    public void clickAddItem(String arg0) throws InterruptedException {
//        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
//            try {
//                if (homePageElements.iosTogglePopUp.isDisplayed())
//                    homePageElements.iosCloseToggle.click();
//            } catch (Exception e) {
//            }
//        }
        Thread.sleep(1000);
        new WaitAction(driver).waitForLoadingComplete();
        MobileElement element = aemZonesPageElements.addButtonList.get(Integer.parseInt(arg0) - 1);
        element.click();
    }


    public void verifyAddItem(String arg0) throws InterruptedException {
        Thread.sleep(1000);
        new WaitAction(driver).waitForLoadingComplete();
        MobileElement element = aemZonesPageElements.addButtonList.get(Integer.parseInt(arg0) - 1);
        Assert.assertTrue(element.isDisplayed());

    }

    public void clickAddButton() throws InterruptedException {
        if (driver.getPlatformName().equalsIgnoreCase("Android")) {
            scrollDown();
            MobileElement element = aemZonesPageElements.addButtonList.get(0);
            element.click();
        } else {
            scrollDownForElement(aemZonesPageElements.summerGrillingCarouselAddButton);
            aemZonesPageElements.summerGrillingCarouselAddButton.click();
//            new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.bpnCarouselAddButton);
        }

    }

    public void verifyLPACarouselCTABrowsePage() {
        Assert.assertTrue(aemZonesPageElements.carouselLPACTABrowsePage.isDisplayed());
    }

    public void clickLPACarouselBrowsePage() {
        //  Assert.assertTrue(aemZonesPageElements.carouselLPACTABrowsePage.isDisplayed());
        //   new WaitAction(driver).waitForLoadingComplete();
        new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.carouselLPASubTitleBrowsePage);
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void scrolldownLandingPage() {
        //  Assert.assertTrue(aemZonesPageElements.carouselLPACTABrowsePage.isDisplayed());
        scrollDown();
        new WaitAction(driver).waitForLoadingComplete();
    }

    public void verifyExternalLandingPageDisplayed() {
        Boolean titleParam1;
        Boolean titleParam2;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
            titleParam1 = isElementDisplayed(findElementByName("lblTopNavBarTitle"));
            titleParam2 = isElementDisplayed(findElementByLabel(productName));
            Assert.assertTrue(titleParam1 && titleParam2, "User has not landed in External landing page");
        } else {
            titleParam1 = isElementDisplayed((MobileElement) driver.findElementById("webview_tv_title"));
            Assert.assertTrue(titleParam1 && driver.findElementById("webview_tv_title").getText().equalsIgnoreCase(productName), "User has not landed in External landing page");
        }
    }

    public void verifyLandingPageDisplayed() {
        Boolean titleParam1;
        Boolean titleParam2;
        if (driver.getPlatformName().equalsIgnoreCase("ios")) {
//            titleParam1 = isElementDisplayed(findElementByName("lblTopNavBarTitle"));
            titleParam2 = isElementDisplayed(findElementByLabel(productName));
            Assert.assertTrue(titleParam2, "User has not landed in External landing page");
        } else {
            titleParam1 = isElementDisplayed((MobileElement) driver.findElementById("tv_title"));
            Assert.assertTrue(titleParam1 && driver.findElementById("tv_title").getText().equalsIgnoreCase(productName), "User has not landed in External landing page");
        }
    }

    public void navigateBackFromExternalLink() {
        aemZonesPageElements.navigateBackFromExternalLink.click();
//        new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.navigateBackFromExternalLink);
    }

    public void bufferNameOfProduct(String arg0) {
        productName = arg0;
        System.out.println(productName);
    }


    public void clickFirstProductInSheet() {
        new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.firstProductInSheet);
    }

    public void clickCancelButton() {
        new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.searchCancelButton);
    }

    public void clickProductsToggle() {
        new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.productsToggleSelected);
    }

    public void clickDealsToggle() {
        new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.dealsToggleSelected);
    }

    public boolean verifyToggleSettingIsONState() {
        return isElementDisplayed(aemZonesPageElements.dealsToggleONState);
    }

    public boolean verifyToggleSettingIsOFFState() {
        return isElementDisplayed(aemZonesPageElements.dealsToggleOFFState);
    }

    public boolean VerifyMediumBanner(String strArg1) {
        if (strArg1.contains("Pros in Produce")) {
            scrollDownForElement(aemZonesPageElements.prosInProduce);
            return isElementDisplayed(aemZonesPageElements.prosInProduce, 50);
        } else if (strArg1.contains("Meals Made Easy")) {
            scrollDownForElement(aemZonesPageElements.Mealsmadeeasy);
            return isElementDisplayed(aemZonesPageElements.Mealsmadeeasy, 50);
        } else if (strArg1.contains("LPA Banner AEM")) {
            scrollDownForElement(aemZonesPageElements.LPBanner);
            return isElementDisplayed(aemZonesPageElements.LPBanner, 50);
        } else if (strArg1.contains("Banner No CTA")) {
            scrollDownForElement(aemZonesPageElements.BannerNoCTA);
            return isElementDisplayed(aemZonesPageElements.BannerNoCTA, 50);
        } else {
            return false;
        }
    }

    public void SignoutfromApp() {
        new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.SignOutApp);
    }


    public void clickConfirmSignout() {
        new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.clickConfirmSignout);
    }

    public void clickOnViewAllForRelatedProducts() {
        new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.clickViewAll);
    }

    public void clickTabOnPdpPage(String arg0) {
        if (arg0.contains("Ingredients")) {
            new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.PdpIngredientsText);
        } else if (arg0.contains("More")) {
            new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.pdpMoreText);
        } else if (arg0.contains("Details")) {
            new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.PdpDetailsText);
        }
    }

    public boolean verifyTabOnPdpPage(String arg0) {
        if (arg0.contains("Ingredients")) {
            scrollDownForElement(aemZonesPageElements.PdpIngredientsText);
            new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.PdpIngredientsText);
            return isElementDisplayed(aemZonesPageElements.PdpIngredientsDescription, 50);
        } else if (arg0.contains("Details")) {
            scrollDownForElement(aemZonesPageElements.PdpDetailsText);
            new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.PdpDetailsText);
            return isElementDisplayed(aemZonesPageElements.PdpDetailsDescription, 50);
        } else if (arg0.contains("More")) {
            scrollDownForElement(aemZonesPageElements.pdpMoreText);
            new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.pdpMoreText);
            return isElementDisplayed(aemZonesPageElements.pdpMoreDescription, 50);
        } else {
            return false;
        }
    }

    public void clickSearchOnPdpPage() {
        new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.clickSearchOnpdpPage);
    }

    public void addItemFromRelatedProducts() {
        new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.clickFirstAddFromRelatedProduct);
    }

    public void userClickShowNowctaLabel() {
        new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.clickctaShopNowLabel);
    }

    public void userClickBackButtonFromPdpPage() {
        new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.clickBackButtonFromPdpPage);
    }

    public void clickOnLargeBannerWithPdpCta() {
        new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.clickOnLargeBannerWithPdpCta);
    }

    public void verifyPDPScreen() {
        isElementDisplayed(aemZonesPageElements.relatedProductsText);
    }

    public void userClickButtonToAddRemoveItemInPdpPage(String arg0, String arg1) {
        int num = Integer.parseInt(arg1);
        if (arg0.contains("+"))
            for (int i = 0; i < num; i++) {
                new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.plusItemButton);
                waitForLoadingComplete();
            }
        else if (arg0.contains("-"))
            for (int i = 0; i < num; i++) {
                new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.minusItemButton);
                waitForLoadingComplete();
            }
    }

    public void verifyTheQuantityOfTheProductSelected(String arg0) {
        waitForLoadingComplete();
        Assert.assertTrue(aemZonesPageElements.quantityText.getText().contains(arg0));
    }

    public void scrollDownForBrowseCategories() {
        scrollDownForElement(aemZonesPageElements.browserAtHomePage);
    }

    public void userClicksOnBackButtonOnPage() {
        new CommonActions(driver).new ClickAction().clickElement(aemZonesPageElements.clickBackButton);
    }
}
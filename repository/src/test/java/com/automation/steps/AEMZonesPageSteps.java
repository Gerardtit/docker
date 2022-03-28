package com.automation.steps;

import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.pages.AEMZonesPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class AEMZonesPageSteps {
    public AppiumDriver driver = AppiumDriverManager.getDriver();
    AEMZonesPage aemZonesPage = new AEMZonesPage(driver);


    @When("^scroll down for \"([^\"]*)\" carousel on Landing page$")
    public void scroll_down_for_carousel_landingpage(String text) {
        //   aemZonesPage.scrollDownForCarousel(text);
        aemZonesPage.scrollDownForCarouselLandingPage(text);
    }


    @And("^scroll down for \"([^\"]*)\" carousel$")
    public void scroll_down_for_carousel(String text) {
        aemZonesPage.scrollDownForCarousel(text);
        //   aemZonesPage.scrollDownForCarouselLandingPage(text);
    }

    @And("^scroll down for \"([^\"]*)\" carousel on browse page$")
    public void scroll_down_for_carousel_browsepage(String text) {

        aemZonesPage.scrollDownForLPCarouselBrowsePage(text);
    }

    @And("^verify user is able to see \"([^\"]*)\"$")
    public void verify_screen_position_retained(String text) {
        aemZonesPage.screenPositionRetained(text);
    }

    @And("^scroll down for \"([^\"]*)\" carousel on home page$")
    public void scroll_down_for_carousel_homepage(String text) {
        aemZonesPage.scrollDownForCarouselHomePage(text);

    }

    @And("^scroll down for \"([^\"]*)\" lp carousel on home page$")
    public void scroll_down_for_lp_carousel_homepage(String text) {

        aemZonesPage.scrollDownForLPCarouselHomePage(text);
    }

    @Then("^verify \"([^\"]*)\" title is displayed$")
    public void verify_carousel_title(String text) {
        aemZonesPage.verifyCarouselTitle(text);
    }

    @Then("^verify \"([^\"]*)\" sub title is displayed$")
    public void verify_carousel_sub_title(String text) {
        aemZonesPage.verifyCarouselSubTitle(text);
    }

    @Then("^verify \"([^\"]*)\" seeAll button title is displayed$")
    public void verify_SeeAll_button_title(String text) {
        aemZonesPage.verifySeeAllButtonTitle(text);
    }

    @Then("^user clicks on \"([^\"]*)\" seeAll button title$")
    public void user_clicks_seeAll_button(String text) {
        aemZonesPage.userClickSeeAllButton(text);
    }

    @And("^user clicks on \"([^\"]*)\" ctaLabel button$")
    //this method is written in contrary to similar method as in android 2 similar objects are differenciated by content-desc
    public void user_clicks_ctaLabel(String text) {
        aemZonesPage.userClickctaLabel(text);
    }

    @Then("^verify user is not taken to sheetUI$")
    public void verify_user_not_taken_to_sheet_ui() {
        Assert.assertFalse(aemZonesPage.verifySheetUiNotOpened(), "SheetUI is displayed");
    }

    @Then("^verify Carousel title is displayed$")
    public void verify_carousel_title_is_displayed() {
        aemZonesPage.verifyCarouselTitle();
    }

    @Then("^verify Large Banner with Landing Page CTA is displayed$")
    public void verify_large_banner_lp_is_displayed() {
        aemZonesPage.verifyLargeBannerLpCta();
    }

    @Then("^verify Carousel title is displayed on home page$")
    public void verify_carousel_title_is_displayed_homepage() {
        aemZonesPage.verifyCarouselTitleHomePage();
    }

    @Then("^verify Carousel sub title is displayed$")
    public void verify_carousel_sub_title_is_displayed() {
        aemZonesPage.verifyCarouselSubTitle();
    }

    @Then("^verify Carousel ctaText is displayed$")
    public void verify_carousel_ctaText_is_displayed() {
        aemZonesPage.verifyCarouselCtaText();
    }

   /* @When("^scroll down for \"([^\"]*)\" medium banner$")
    public void scroll_down_for_something_medium_banner(String strArg1) throws Throwable {
        aemZonesPage.scrollDownForBanner(strArg1);
    }*/

    @Then("^verify banner CTA Type LP is displayed$")
    public void verify_banner_cta_type_lp_is_displayed() throws Throwable {
        aemZonesPage.verifyBannerCTAType();
    }

    @Then("^Verify takes user to the custom landing page$")
    public void verify_takes_user_to_the_custom_landing_page() throws Throwable {
        aemZonesPage.verifyCustomLP();
    }

    @Then("^Verify CTA link takes user to the custom landing page$")
    public void verify_CTA_link_takes_user_to_the_custom_landing_page() throws Throwable {
        aemZonesPage.verifyCustomLandingPage();
    }


    @Then("^Verify CTA link takes user to the Simple Carousel custom landing page$")
    public void verify_CTA_link_takes_user_to_the_simple_carousel_custom_landing_page() throws Throwable {
        aemZonesPage.verifySimpleCarouselCustomLandingPage();
    }

    @Then("^Verify click on Large Banner takes user to custom landing page$")
    public void verify_CTA_link_takes_user_to_the_large_banner_custom_landing_page() throws Throwable {
        aemZonesPage.verifyLargeBannerCustomLandingPage();
    }

    @Then("^Verify CTA link takes user to the custom sheet UI$")
    public void verify_CTA_link_takes_user_to_the_custom_sheetUI() throws Throwable {
        aemZonesPage.verifyCustomSheetUI();
    }

    @And("^Verify banner title as page name for landing page$")
    public void verify_banner_title_as_page_name_for_landing_page() throws Throwable {
        aemZonesPage.verifyLPNameAsBannerTitle();
    }

    @And("^Verify Large banner title as page name for landing page$")
    public void verify_large_banner_title_as_page_name_for_landing_page() throws Throwable {
        aemZonesPage.verifyLargeBannerLPNameAsBannerTitle();
    }

    @When("^Verify Click back arrow takes the user to home page and should retain position$")
    public void verify_click_back_arrow_takes_the_user_to_home_page_and_should_retain_position() throws Throwable {
        aemZonesPage.verifyPositionOnBackBtnClick();
    }

    @When("^user clicks on back arrow in landing page$")
    public void click_back_arrow_in_LandingPage() throws Throwable {
        aemZonesPage.clickOnBackBtnInLandingPage();
    }

    @When("^user clicks on CTA button from Carousel zones$")
    public void click_on_Carousel_CTA() {
        aemZonesPage.clickCarouselCTA();
    }

    @Then("^verify Carousel CTA is displayed at home page$")
    public void verify_carousel_ctaText_is_displayed_homepage() {
        aemZonesPage.verifyCarouselCtaHomePage();
    }

    @When("^user clicks on CTA button from Carousel zones at home page$")
    public void click_on_Carousel_CTA_HomePage() {
        aemZonesPage.clickCarouselCTAHomePage();
    }

    @Then("^verify Carousel sheet title is displayed$")
    public void verify_carousel_sheet_title_is_displayed() {
        aemZonesPage.verifyCarouselSheetTitle();
    }

    @Then("verify Carousel sheet sub title is displayed$")
    public void verify_carousel_sheet_sub_title_is_displayed() {
        aemZonesPage.verifyCarouselSheetSubTitle();
    }

    @Then("^verify Carousel sheet close CTA is displayed$")
    public void verify_carousel_sheet_close_cta_is_displayed() {
        aemZonesPage.verifyCarouselSheetCloseCTA();
    }

    @And("^user scroll up and down to view products in Sheet UI$")
    public void scroll_up_and_down_to_view_products() {
        aemZonesPage.scrollUpandDownToViewProducts();
    }

    @And("^user scroll left and right to view products in carousel$")
    public void scroll_left_and_right_to_view_products() {
        aemZonesPage.scrollLeftandRightToViewProducts();
    }

    @Then("^verify \"X\" should close the sheet reveal the behind screen$")
    public void verify_close_the_sheet() {
        aemZonesPage.verifyClickCarouselSheetCloseCTA();
    }

    @Then("^click \"X\" should close sheet in iOS$")
    public void click_close_the_sheet_iOS() {
        aemZonesPage.clickCloseSheetiOS();
    }


    @Then("^verify banner CTA Type LP is displayed in browse Page$")
    public void verify_banner_cta_type_lp_is_displayed_in_browse_page() throws Throwable {
        aemZonesPage.verifyBannerCTATypeBrowsePage();
    }

    @Then("^Verify takes user to the custom landing page from browse Page$")
    public void verify_takes_user_to_the_custom_landing_page_from_browse_page() throws Throwable {
        aemZonesPage.verifyCustomLPBrowsePage();
    }

    @And("^Verify banner title as page name for landing page from browse Page$")
    public void verify_banner_title_as_page_name_for_landing_page_from_browse_page() throws Throwable {
        aemZonesPage.verifyLPNameAsBannerTitleBrowsePage();
    }

    @When("^Verify Click back arrow takes the user to browse page and should retain position$")
    public void verify_click_back_arrow_takes_the_user_to_browse_page_and_should_retain_position() throws Throwable {
        aemZonesPage.verifyPositionOnBackBtnClickBP();
    }

    @Then("^verify banner CTA Type None is displayed$")
    public void verify_banner_cta_type_none_is_displayed() throws Throwable {
        aemZonesPage.verifyBannerCTATypeNone();
    }

    @And("^Then verify no action on CTA click and user remains on the home page$")
    public void then_verify_no_action_on_cta_click_and_user_remains_on_the_home_page() throws Throwable {
        aemZonesPage.noActionCtaHomePage();
    }

    @Then("^verify banner CTA Type None is displayed on browse page$")
    public void verify_banner_cta_type_none_is_displayed_on_browse_page() throws Throwable {
        aemZonesPage.verifyBannerCTATypeNoneBrowsePage();
    }

    @And("^Then verify no action on CTA click and user remains on the browse page$")
    public void then_verify_no_action_on_cta_click_and_user_remains_on_the_browse_page() throws Throwable {
        aemZonesPage.noActionCtaBrowsePage();
    }


    @When("scroll down for {string} banner")
    public void scrollDownForBanner(String arg0) {
        aemZonesPage.scrollDownForCarousel(arg0);
    }

    @Then("click {string} banner")
    public void clickBanner(String banner) {
        aemZonesPage.clickBanner(banner);
    }

    /*    Then verify LPA Carousel title is displayed on home page
        Then
        Then verify LPA Carousel CTA is displayed at home page
        When user clicks on LPA CTA button from Carousel zones at home page*/
    @Then("^user navigate back to the previous screen$")
    public void navigate_back_to_previous_screen() {
        //  aemZonesPage.verifyLPACarouselTitleHomePage();
        aemZonesPage.navigateBackToPreviousPage();


    }

    @Then("^verify LPA Carousel title is displayed$")
    public void verify_lpa_carousel_title_is_displayed() {
        aemZonesPage.verifyLPACarouselTitleHomePage();
    }

    @Then("^verify LPA Carousel title is displayed on landing page$")
    public void verify_lpa_carousel_title_is_displayed_landingpage() {
        aemZonesPage.verifyLPACarouselTitleBrowsePage();
    }

    @Then("^verify LPA Carousel title is displayed on browse page$")
    public void verify_lpa_carousel_title_is_displayed_browsepage() {
        aemZonesPage.verifyLPACarouselTitleBrowsePage();
    }

    @Then("^verify LPA Carousel sub title is displayed on browse page$")
    public void verify_lpa_carousel_subtitle_is_displayed_browsepage() {
        aemZonesPage.verifyLPACarouselSubTitleBrowsePage();
    }

    @Then("^verify LPA Carousel CTA is displayed at browse page$")
    public void verify_lpa_carousel_cta_is_displayed_browsepage() {
        aemZonesPage.verifyLPACarouselCTABrowsePage();
    }

    @Then("^verify LPA Carousel title is displayed on home page$")
    public void verify_lpa_carousel_title_is_displayed_homepage() {
        aemZonesPage.verifyLPACarouselTitleHomePage();
    }

    @Then("^verify LPA Carousel sub title is displayed on home page$")
    public void verify_lpa_carousel_subtitle_is_displayed_homepage() {
        aemZonesPage.verifyLPACarouselSubTitleHomePage();
    }

    @Then("^verify LPA Carousel CTA is displayed at home page$")
    public void verify_lpa_carousel_cta_is_displayed_homepage() {
        aemZonesPage.verifyLPACarouselCTAHomePage();
    }

    @When("^user clicks on LPA CTA button from Carousel zones at home page$")
    public void click_on_Carousel_LPA_CTA_HomePage() {
        aemZonesPage.clickCarouselLPACTAHomePage();
    }

    @When("^user clicks on LPA Carousel zones at home page$")
    public void click_on_LPA_Carousel_HomePage() {
        aemZonesPage.clickLPACarouselHomePage();
    }

    @Then("^verify \"Add\" button is displayed on the Landing page$")
    public void verify_add_button_on_landingpage() {
        aemZonesPage.verifyAddbuttonLandingPage();
    }

    @And("^scroll down on the Landing page$")
    public void scroll_down_on_landingpage() {
        aemZonesPage.scrolldownLandingPage();
    }

    @When("^user clicks on Banner Landing Carousel zones at browse page$")
    public void click_on_LPA_Carousel_BrowsePage() {
        aemZonesPage.clickLPACarouselBrowsePage();
    }

    @When("^user clicks \"([^\"]*)\" item add button on carousel$")
    public void userClicksItemAddButtonOnFirstItem(String arg0) throws Throwable {
        aemZonesPage.clickAddItem(arg0);
    }

    @Then("^verify \"([^\"]*)\" item add button on first item$")
    public void verifyItemAddButtonOnFirstItem(String arg0) throws Throwable {
        aemZonesPage.verifyAddItem(arg0);
    }

    @Then("^user click item add on carousel in HomePage$")
    public void user_click_item_add_on_carousel() throws Throwable {
        aemZonesPage.clickAddButton();
    }

    @And("^user clicks on \"([^\"]*)\" button$")
    public void user_click_on_button(String text) throws Throwable {
        aemZonesPage.clickButton(text);
    }

    @Then("^user lands in external landing page$")
    public void userLandsInExternalLandingPage() {
        aemZonesPage.verifyExternalLandingPageDisplayed();
    }

    @Then("^user lands in landing page$")
    public void userLandsInLandingPage() {
        aemZonesPage.verifyLandingPageDisplayed();
    }

    @When("^user navigates back from External link to landing page$")
    public void userNavigateBackFromExternalToLandingPage() {
        aemZonesPage.navigateBackFromExternalLink();
    }

    @And("^user buffers \"([^\"]*)\" product name in landing page$")
    public void userBuffersProductNameInLP(String arg0) {
        aemZonesPage.bufferNameOfProduct(arg0);
    }


    @And("^click on the first product to go to pdp$")
    public void clickOnFirstProduct() {
        aemZonesPage.clickFirstProductInSheet();
    }

    @And("^click on Cancel in Search page$")
    public void clickCancelButton() {
        aemZonesPage.clickCancelButton();
    }

    @And("^click on Products toggle in search page$")
    public void clickProductsToggle() {
        aemZonesPage.clickProductsToggle();
    }

    @And("^click on Deals toggle in search page$")
    public void clickDealsToggle() {
        aemZonesPage.clickDealsToggle();
    }

    @Then("^verify Deals toggle setting is ON state$")
    public void verifyToggleSettingIsONState() {
        Assert.assertTrue(aemZonesPage.verifyToggleSettingIsONState());
    }

    @Then("^verify Deals toggle setting is OFF state$")
    public void verifyToggleSettingIsOFFState() {
        Assert.assertTrue(aemZonesPage.verifyToggleSettingIsOFFState());
    }

    @Then("^verify Pros in Produce AEM zone is present$")
    public void verify_pros_in_produce_aem_zone_is_present() {
        aemZonesPage.VerifyMediumBanner("Pros in Produce");
    }

    @And("^verify Meals made easy AEM zone is present$")
    public void verify_meals_made_easy_aem_zone_is_present() {
        aemZonesPage.VerifyMediumBanner("Meals Made Easy");

    }

    @Then("^verify LPA Banner AEM zone is present$")
    public void verify_lpa_banner_aem_zone_is_present() {
        aemZonesPage.VerifyMediumBanner("LPA Banner AEM");
    }

    @Then("^verify Banner No CTA AEM zone is present$")
    public void verify_banner_no_cta_aem_zone_is_present() {
        aemZonesPage.VerifyMediumBanner("NO CTA Banner");
    }

    @Then("^user clicks on Sign out$")
    public void user_clicks_on_sign_out() throws Throwable {
        aemZonesPage.SignoutfromApp();
        aemZonesPage.clickConfirmSignout();
    }

    @Then("user clicks on View All for Related products")
    public void userClickOnViewAllForRelatedProducts() {
        aemZonesPage.clickOnViewAllForRelatedProducts();
    }

    @Then("verify {string} tab is clickable")
    public void verifyTabIsClickable(String arg0) {
        aemZonesPage.verifyTabOnPdpPage(arg0);
        aemZonesPage.clickTabOnPdpPage(arg0);
    }

    @Then("user click on search icon on pdp page")
    public void userClickOnSearchIconOnPdpPage() {
        aemZonesPage.clickSearchOnPdpPage();
    }

    @Then("Add Item from Related Products")
    public void addItemInRelatedProducts() {
        aemZonesPage.addItemFromRelatedProducts();
    }

    @When("user clicks on Shop Now ctaLabel button")
    public void userClicksOnShopNowCtaLabelButton() {
        aemZonesPage.userClickShowNowctaLabel();
    }

    @And("user click back button from pdp page")
    public void userClickBackButtonFromPdpPage() {
        aemZonesPage.userClickBackButtonFromPdpPage();
    }

    @And("click on Large Banner with Pdp Cta")
    public void clickOnLargeBannerWithTextPlaTitle() {
        aemZonesPage.clickOnLargeBannerWithPdpCta();
    }

    @Then("verify PDP screen")
    public void verifyPDPScreen() {
        aemZonesPage.verifyPDPScreen();
    }

    @When("scroll down for Browse categories")
    public void scrollDownForBrowseCategories() {
        aemZonesPage.scrollDownForBrowseCategories();
    }

    @And("user clicks on back button on page")
    public void userClicksOnBackButtonOnPage() {
        aemZonesPage.userClicksOnBackButtonOnPage();
    }

    @When("user clicks {string} button {string} number of times to add or remove item in pdp page")
    public void userClicksButtonNumberOfTimesToAddOrRemoveItemInPdpPage(String arg0, String arg1) {
        aemZonesPage.userClickButtonToAddRemoveItemInPdpPage(arg0, arg1);
    }

    @Then("verify the quantity of the product selected is {string}")
    public void verifyTheQuantityOfTheProductSelected(String arg0) {
        aemZonesPage.verifyTheQuantityOfTheProductSelected(arg0);
    }

}

package com.automation.steps;

import com.automation.helpers.ThreadLocalHelper;
import com.automation.mobile.appium.AppiumDriverManager;
import com.automation.mobile.util.CommonActions;

import com.automation.pages.GG_DashboardPage;
import com.automation.pages.GG_DealsPage;
import com.automation.pages.GG_Deals_CategoriesPage;
import com.automation.pages.GG_MylistPage;
import com.automation.rest.cache.CommonCache;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GG_MyListPageSteps {

    public AppiumDriver driver = AppiumDriverManager.getDriver();
    public GG_MylistPage GGMylistPage = new GG_MylistPage(driver);
    public Map<String, Object> testDataAcrossSteps = new HashMap<String, Object>();
    //String clippedDeals;
    String clippedDealsInMYList;
    //String itemInMYList;

    @And("^Click on my list tab$")
    public void clickOnMyListTab() {
        GGMylistPage.clickMylistTab();
    }

    @And("go to List Tab")
    public void goToListTab() throws InterruptedException {
        GGMylistPage.clickOnListTab();
    }

    @And("^verify All option is displayed in my list page$")
    public void verifyAllOptionIsDisplayed() {
        GGMylistPage.verifyALLoption();
    }

    @Then("^verify Deals option is displayed in my list page$")
    public void verifyDealsOptionIsDisplayed() {
        GGMylistPage.verifyDealsoption();
    }

    @And("^verify Items option is displayed in my list page$")
    public void verifyItemsOptionIsDisplayed() {
        GGMylistPage.verifyItemsoption();
    }

    @And("^verify the selected state on navigation bar$")
    public void verifyTheSelectedStateOnNavigationBar() {
        GGMylistPage.verifyselectedstate();
    }

    @And("^click on All option in my list page$")
    public void clickOnAllOptionInMyListPage() {
        GGMylistPage.clickAlloption();
    }

    @When("^click on Items option in my list page$")
    public void clickOnItemsOptionInMyListPage() {
        GGMylistPage.clickItemsoption();
    }

    @Then("^click on Deals option in my list page$")
    public void clickOnDealsOptionInMyListPage() {
        GGMylistPage.clickDealsoption();
    }

    @And("^verify New item option in the my list page$")
    public void verifyNewItemOptionInTheMyListPage() {
        GGMylistPage.verifyAddNewItemButton();
    }

    @And("verify {string} tab is selected in MyList")
    public void verifyTabIsSelectedInMyList(String desiredCategoryName) {
        Assert.assertEquals(GGMylistPage.getSelectedTab(), desiredCategoryName, "The desired category is not selected");
    }

    @And("expand first category from the list")
    public void expandAnyCategoryFromTheList() {
        GGMylistPage.expandFirstCategoryDisplayedInList();
    }

    @And("fetch the name and total count of items for the expanded category")
    public void fetchTheTotalCountOfItemsForTheExpandedCategory() {
        Map.Entry<String, String> expandedCatDetails = GGMylistPage.fetchTheCategoryNameAndTotalCountOfItemsForTheExpandedCategory().entrySet().stream().findFirst().get();
        testDataAcrossSteps.put("EXPANDED_CATEGORY_DETAILS", expandedCatDetails.getKey() + "-" + expandedCatDetails.getValue());
    }

    @Then("verify all the items are in unchecked state")
    public void verifyAllTheItemsAreInUncheckedState() {
        Assert.assertEquals(GGMylistPage.isSelectCheckBoxDisplayed(), true, "Select checkbox aren't displayed");
    }

    @And("the {string} section {string} displayed")
    public void thereAreSectionDisplayed(String desiredCategoryName, String categoryNameVisibility) {
        boolean isDisplayed = !categoryNameVisibility.contains("not");
        Assert.assertEquals(GGMylistPage.getAllCategoryNamesDisplayedInList().contains(desiredCategoryName.replaceAll("[^A-Za-z]+", "")), isDisplayed, "The desired category visibility is not as expected");
    }

    @And("select {string} item from the list for the expanded category")
    public void selectItemFromTheList(String noOfItemsToBeSelected) {
        if (noOfItemsToBeSelected.equalsIgnoreCase("All")) {
            GGMylistPage.selectAllItemsFromTheExpandedSubcategory();
        } else {
            GGMylistPage.selectItemsFromTheExpandedSubcategory(Integer.parseInt(noOfItemsToBeSelected));
        }
    }

    @Then("verify selected items are moved to {string} section")
    public void verifySelectedItemsAreMovedToSection(String desiredCategoryName) throws InterruptedException {
        //Get The names of products
        List<String> productNamesInExpandedCategory = GGMylistPage.getProductAndDealNamesFromSubCategoryByExpandingIt(desiredCategoryName);
        List<String> productNamesDuringSelection = (List<String>) testDataAcrossSteps.get("PRODUCT_DEAL_NAMES_EXPANDED_CATEGORY");
        // Verify common between two list
        Set<String> itemsMovedFromCategoryToCheckedBasket = productNamesDuringSelection.stream().distinct().filter(productNamesInExpandedCategory::contains).collect(Collectors.toSet());
        Assert.assertEquals(!itemsMovedFromCategoryToCheckedBasket.isEmpty(), true, "All the product/deals are not moved " + desiredCategoryName);
    }

    @Then("verify all items are moved to {string} section")
    public void verifyAllItemsAreMovedToSection(String desiredCategoryName) {
        //Check the matches in PRODUCT_DEAL_NAMES_BEFORE_SELECT and PRODUCT_DEAL_NAMES_EXPANDED_CATEGORY;
        List<String> productNamesInExpandedCategory = GGMylistPage.getProductAndDealNamesFromSubCategoryByExpandingIt(desiredCategoryName);
        List<String> productNamesDuringSelection = (List<String>) testDataAcrossSteps.get("PRODUCT_DEAL_NAMES_EXPANDED_CATEGORY");
        // Verify common between two list
        Set<String> itemsMovedFromCategoryToCheckedBasket = productNamesDuringSelection.stream().distinct().filter(productNamesInExpandedCategory::contains).collect(Collectors.toSet());
        Assert.assertEquals(itemsMovedFromCategoryToCheckedBasket.size() >= 2, true, "All the product/deals are not moved " + desiredCategoryName);

    }

    @And("all items in Checked In Store Basket are graded out and displayed in strikethrough view")
    public void allItemsInCheckedInStoreBasketAreGradedOutAndDisplayedInStrikethroughView() {
        //Verifying the test property is not supported
    }

    @And("get all the item names displayed in expanded category")
    public void getAllTheItemNamesDisplayedInExpandedCategory() {
        //Get The names of products
        testDataAcrossSteps.put("PRODUCT_DEAL_NAMES_EXPANDED_CATEGORY", GGMylistPage.geDealNamesFromExpandedSubCategory());
    }

    @And("verify the count of {string} category is displayed")
    public void verifyTheCountOfCategoryIsDisplayed(String categoryName) {
        Map.Entry<String, String> expandedCatDetails = GGMylistPage.fetchTheCategoryNameAndTotalCountOfItemsForTheExpandedCategory().entrySet().stream().findFirst().get();
        testDataAcrossSteps.put("CHECKED_BASKET_COUNT_BEFORE", expandedCatDetails.getValue());
        //Verify the count values is not zero and category is matched
        Assert.assertEquals(Integer.parseInt(expandedCatDetails.getValue()) != 0 && categoryName.replaceAll("[^A-Za-z]+", "").contains(expandedCatDetails.getKey().replaceAll("[^A-Za-z]+", "")), true, "The count of desired category is Zero");
    }


    @When("uncheck any item from Checked In Store Basket")
    public void uncheckAnyItemFromCheckedInStoreBasket() {
        GGMylistPage.selectItemsFromTheExpandedSubcategory(1);
    }

    @Then("the item is removed from Checked In Store Basket")
    public void theItemIsRemovedFromCheckedInStoreBasket() {
        Map.Entry<String, String> expandedCatDetails = GGMylistPage.fetchTheCategoryNameAndTotalCountOfItemsForTheExpandedCategory().entrySet().stream().findFirst().get();
        int initialCheckedBaskedCnt = (int) testDataAcrossSteps.get("CHECKED_BASKET_COUNT_BEFORE");
        Assert.assertEquals(initialCheckedBaskedCnt > Integer.parseInt(expandedCatDetails.getValue()), true, "The item count before and after is same hence item is not removed");

    }

    @And("verify total count of items for the expanded category is retained")
    public void verifyTotalCountOfItemsForTheExpandedCategoryIsRetained() {
        Map.Entry<String, String> expandedCatDetails = GGMylistPage.fetchTheCategoryNameAndTotalCountOfItemsForTheExpandedCategory().entrySet().stream().findFirst().get();
        testDataAcrossSteps.put("EXPANDED_CATEGORY_DETAILS_AFTER_UNCHECK", expandedCatDetails.getKey() + "-" + expandedCatDetails.getValue());
        Assert.assertEquals((String) testDataAcrossSteps.get("EXPANDED_CATEGORY_DETAILS_AFTER_UNCHECK"), (String) testDataAcrossSteps.get("EXPANDED_CATEGORY_DETAILS"), "All items are not unchecked");
    }


    @Then("verify some items in expanded category are {string}")
    public void verifySomeItemsInExpandedCategoryAre(String checkUncheckOption) {
        Assert.assertEquals(GGMylistPage.getNoOfCheckedUncheckedItems(checkUncheckOption) != 0, true, "The items check/uncheck is not happening");
    }

    @And("click {string} category")
    public void clickSection(String categoryName) {
    }

    @Then("Ellipses CTA on navigation bar in My List {string} displayed")
    public void ellipsesCTAOnNavigationBarInMyListDisplayed(String displayOption) {
        boolean isDisplayed = !displayOption.contains("not");
        Assert.assertEquals(GGMylistPage.checkIfEllipsesCTAIsDisplayed(), isDisplayed, "CTA Ellipses visibility check failed");
    }

    @When("click on Ellipses CTA option")
    public void clickOnEllipsesCTAOption() {
        GGMylistPage.clickEllipsesCTA();
    }

    @Then("List Tools screen {string} displayed")
    public void listToolsScreenDisplayed(String displayOption) {
        boolean isDisplayed = !displayOption.contains("not");
        Assert.assertEquals(GGMylistPage.checkIfListToolsIsDisplayed(), isDisplayed, "CTA Ellipses visibility check failed");
    }

    @Then("verify List Tools screen options displayed with defined ordering")
    public void verifyListToolsScreenOptionsDisplayedWithDefinedOrdering() {
        Assert.assertEquals(GGMylistPage.getListToolsOptions(), Stream.of("Uncheck all items", "Delete checked items", "Delete all items", "Email list", "Sync").collect(Collectors.toList()), "Ordering on list tools is not maintained");
    }

    @And("click {string} from List Tools options")
    public void clickFromListToolsOptions(String optnName) {
        GGMylistPage.selectOptionFromListTools(optnName);
    }

    @Then("verify user is landed on {string} section in My List")
    public void verifyUserIsLandedOnSectionInMyList(String sectioNameDesired) {
        Assert.assertEquals(GGMylistPage.getTabNameSelectedOnMyListNavigationBar(), sectioNameDesired, "The view selected is not as expected on nav bar");
    }

    @Then("verify {string} option in List Tools is in {string} state")
    public void verifyOptionInListToolsIsInState(String optnName, String optionVisibility) {
        boolean isDisplayed = !optionVisibility.contains("disabled");
        Assert.assertEquals(GGMylistPage.getVisibilityOfListToolsOptions(optnName), isDisplayed, "The list tools option visibility is not as expected");
    }

    @And("collapse the expanded category in list")
    public void collapseTheExpandedCategoryInList() {
        GGMylistPage.collapseExpandedCategory();
    }

    @And("uncheck {string} item from the expanded list")
    public void unselectItemFromList(String noOfItemsToBeSelected) {
        int initialCheckedBaskedCnt = Integer.parseInt((String) testDataAcrossSteps.get("CHECKED_BASKET_COUNT_BEFORE"));
        if (noOfItemsToBeSelected.equalsIgnoreCase("All")) {
            GGMylistPage.uncheckAllItemsFromTheExpandedSubcategory(initialCheckedBaskedCnt);
        } else {
            GGMylistPage.uncheckItemsFromList(Integer.parseInt(noOfItemsToBeSelected));
        }
    }

    @And("verify the count of initially expanded category is restored after unchecking from Checked - In Store Basket")
    public void verifyTheCountOfInitiallyExpandedCategoryIsIncreased() {
        String expandCatDetailsInitial = (String) testDataAcrossSteps.get("EXPANDED_CATEGORY_DETAILS");
        Map.Entry<String, String> expandedCatDetails = GGMylistPage.fetchTheCategoryNameAndTotalCountOfItemsForTheExpandedCategory().entrySet().stream().findFirst().get();
        String expandCatDetailsAfter = expandedCatDetails.getKey() + "-" + expandedCatDetails.getValue();
        Assert.assertEquals(expandCatDetailsAfter, expandCatDetailsInitial, "Items aren't properly restored after uncheck");
    }


    @And("scroll up till top in MyList categories")
    public void scrollUpTillTopInMyListCategories() {
        GGMylistPage.scrollToTopOfTheList();
    }

    @And("click back button in List Tools")
    public void clickBackButtonInListTools() {
        GGMylistPage.clickBackButtonInListToolsPage();
    }

    @And("add an item and deal if list is empty")
    public void addItemDealIfEmpty() {
        GGMylistPage.addAnItemAndDealIfEmpty();
    }

    @And("select email app from share options based on platform")
    public void clickOnEmailAppFromShareOptionsBasedOnPlatform() {
        GGMylistPage.clickOnEmailAppFromShareOptionsBasedOnPlatform();
    }

    @And("discard email with MyList based on platform")
    public void discardMailBasedOnPlatform() {
        GGMylistPage.discardMailBasedOnPlatform();
    }

    @And("send email with MyList based on platform")
    public void sendMailBasedOnPlatform() {
        GGMylistPage.sendMailBasedOnPlatform();
    }

    @Then("verify header in list tools screen")
    public void verifyListToolsHeader() {
        Assert.assertTrue(GGMylistPage.isListToolsHeaderDisplayed(), "List Tools header is not displayed on list tools page");
    }

    @Then("verify back button in list tools screen")
    public void verifyListToolsBackBtn() {
        Assert.assertTrue(GGMylistPage.isListToolsBackBtnDisplayed(), "Back button is not displayed on list tools page");
    }

    @And("delete all items from MyList using list tool")
    public void deleteAllItemsFromMyList() {
        if (!GGMylistPage.isEmptyListMessageDispalyed()) {
            GGMylistPage.deleteAllItemsFromMyListUsingListTool();
        }
    }

    @And("uncheck all items from MyList using list tool")
    public void uncheckAllItemsFromMyList() {
        GGMylistPage.uncheckAllItemsFromMyListUsingListTool();
    }

    @And("get and store categories, items and deals from MyList")
    public void getAndStoreItemsAndDealsAdded() throws InterruptedException {
        testDataAcrossSteps.put("categoryNames", GGMylistPage.getAllCategoryNamesWithoutScroll());
        testDataAcrossSteps.put("itemNames", GGMylistPage.getAllItemNamesWithoutScroll());
        testDataAcrossSteps.put("dealNames", GGMylistPage.geDealNamesFromExpandedSubCategory());
    }

    @Then("verify email details")
    public void verifyEmailTemplate() {
        GGMylistPage.verifyEmailDetails((List) testDataAcrossSteps.get("categoryNames"), (List) testDataAcrossSteps.get("itemNames"), (List) testDataAcrossSteps.get("dealNames"));
    }

    @And("click uncheck all items from list tools")
    public void clickUncheckAllItemsFromListTools() {
        GGMylistPage.clickUncheckAllItemsFromListTools();
    }

    @And("click {string} on uncheck all items - prompt message")
    public void clickOnUncheckAllItemsPromptMessage(String popupCTA) {
        GGMylistPage.clickOnUncheckAllItemsPromptMessage(popupCTA);
    }

    @And("click {string} on list tools - prompt message")
    public void clickOnPromptMessage(String popupCTA) {
        GGMylistPage.clickOnUncheckAllItemsPromptMessage(popupCTA);
    }

    @And("verify the alert when user clicks on {string} from list tools")
    public void verifyPrompt(String toolOption) {
        Assert.assertTrue(GGMylistPage.isAlertDisplayed(toolOption), "Either alert was not displayed or incorrect alert was displayed when user clicked on " + toolOption + "from list tools");
        Assert.assertTrue(GGMylistPage.isAlertMessageDisplayed(toolOption), "Incorrect alert message(description) was displayed when user clicked on " + toolOption + "from list tools");
        Assert.assertTrue(GGMylistPage.isOkDisplayedInPrompt(), "Ok button was not displayed in alert when user clicked on " + toolOption + "from list tools");
        Assert.assertTrue(GGMylistPage.isCancelDisplayedInPrompt(), "Cancel button was not displayed in alert when user clicked on " + toolOption + "from list tools");
    }

    @And("add items if not present \"Checked - In Store Basket\" section")
    public void addItemDealsIfNotPresentToSection() {
        Assert.assertTrue(GGMylistPage.checkItemDealsIfNot(), "The deals/items are not added in checked list");
    }

    @And("uncheck all the items from \"Checked - In Store Basket\" section")
    public void uncheckAllTheItemsFromSection() {
        Assert.assertTrue(GGMylistPage.uncheckAllTheItems(), "The deals/items are not removed in checked list");
    }

    @And("clip a deal to add under list")
    public void clipDealToAddUnderList() {
        GGMylistPage.clipDeal();
    }

    @And("click on Add to list button")
    public void addDealToList() {
        GGMylistPage.addDealToList();
    }

    @And("click on Added to list button")
    public void goToListTabOnClickingAddedToListLink() {
        GGMylistPage.goToListTab();
    }

    @And("get clipped deal name from list")
    public void getTheClippedDealName() {
        clippedDealsInMYList = GGMylistPage.getDealCardUnderMyList();
    }

    @And("get item name from list")
    public void getTheItemName() {
        CommonCache.commonCache.put("ItemInMyList", GGMylistPage.getItemNameUnderMyList());
    }

    @And("verify relatable offers based on catagories are displayed")
    public void verify() {
        String offerNamesOnRelatableScreen = GGMylistPage.getRelatableOffer();
        Assert.assertTrue(offerNamesOnRelatableScreen.contains(CommonCache.commonCache.get("ItemInMyList")), "Actual in relatable offers " + offerNamesOnRelatableScreen + "  In My List " + CommonCache.commonCache.get("ItemInMyList"));
    }


    @And("verify deal is re-added")
    public void verifyDealIsReAdded() {
        String dealsUnderMyList = GGMylistPage.getDealCardUnderMyList();
        Assert.assertEquals(clippedDealsInMYList, dealsUnderMyList);
    }

    @And("verify add to list button displayed")
    public void verifyAddToListButton() {
        Assert.assertTrue(GGMylistPage.isAddToListButtonDisplayed());
    }

    @And("clip a deal and verify added to list link displayed")
    public void verifyAddedToListButton() {
        Assert.assertTrue(GGMylistPage.isAddedToListLinkDisplayed());
    }

    @And("click on deal card to re add under list")
    public void clickDealCardToAddItToTheList() {
        GGMylistPage.clickOnDealCardToAddList();
    }

    @And("click on delete checked item")
    public void clickOnDeleteCheckedItem() {
        GGMylistPage.clickOnDeleteCheckedItem();
    }

    @And("verify all checked items are deleted")
    public void verifyCheckedItemsAreDeleted() {
        Assert.assertFalse(GGMylistPage.verifyCheckedItemAreDeleted());
    }

    @And("click on delete all items")
    public void clickOnDeleteAllItem() {
        GGMylistPage.clickOnDeleteAllItems();
    }

    @And("verify all items are deleted")
    public void verifyAllItemsAreDeleted() {
        Assert.assertFalse(GGMylistPage.verifyAllItemsAreDeleted());
    }

    @And("check all the items and deals")
    public void checkAllTheItems() throws InterruptedException {
        GGMylistPage.checkAllItems();
    }

    @And("verify all items are checked")
    public void verifyAllItemsAreChecked() {
        Assert.assertFalse(GGMylistPage.verifyAllItemsAreChecked());
    }

    @And("verify delete checked items are displayed")
    public void verifyDeleteCheckedItemDisplayed() {
        Assert.assertTrue(GGMylistPage.isDeleteCheckedItemDisplayed());
    }

    @And("verify delete all items are displayed")
    public void verifyDeleteAllItemDisplayed() {
        Assert.assertTrue(GGMylistPage.isDeleteAllItemsDisplayed());
    }

    @And("add multiple deals to my list")
    public void addMultipleDealsToMyList() {
        GGMylistPage.addMultipleItemsAndDeals();
    }

    @And("^user clicks item \"([^\"]*)\" on my list page$")
    public void userClicksOnDealsPage(String desiredCategoryName) throws Throwable {
        GGMylistPage.clickCategoryOnMyList(desiredCategoryName);
    }

    @And("verify scan button in search page inside MyList Screen")
    public void isScanBtnDisplayedInSearchPageInMyList() {
        Assert.assertTrue(GGMylistPage.isScanBtnDisplayedInSearchPageInMyList(), "Scan Button is not displayed");
    }

    @Then("click on scan button in search page inside MyList Screen")
    public void clickOnScanBtnInSearchPageInsideMyListScreen() {
        GGMylistPage.clickOnScanBtnInSearchPageInsideMyListScreen();
    }

    @And("verify scan screen is displayed in My List Screen")
    public void isScanScreenDisplayedInMyList() {
        Assert.assertTrue(GGMylistPage.isScanScreenDisplayedInMyListScreen(), "Scan Screen is not displayed");
    }

    @Then("click close button in Scan Screen")
    public void clickOnCloseBtnInScanScreen() {
        GGMylistPage.clickOnCloseBtnInScanScreen();
    }

    @Then("verify the add manual item Screen in My List Screen")
    public void verifyAddManualItemScreen() {
        Assert.assertTrue(GGMylistPage.isScanBtnDisplayedInSearchPageInMyList(), "Scan Screen is not displayed");
    }

    @And("add item {string} to MyList")
    public void addItem(String item) {
        GGMylistPage.addAnItem(item);
    }

    @And("remove item {string} from MyList")
    public void removeItem(String item) throws InterruptedException {
        GGMylistPage.removeItemByName(item);
    }

    @And("verify item {string} {string} present in MyList")
    public void verifyItemInList(String item, String itemStatus) throws InterruptedException {
        if (itemStatus.contains("not")) {
            Assert.assertEquals(GGMylistPage.isItemPresent(item), false, String.format("Item %s is present in MyList", item));
        } else {
            Assert.assertEquals(GGMylistPage.isItemPresent(item), true, String.format("Item %s is not present in MyList", item));
        }
    }

    @And("set quantity of item {string} to {int}")
    public void editItemQuantity(String item, int quantity) throws InterruptedException {
        GGMylistPage.changeItemQuantity(item, quantity);
    }

    @And("verify item {string} with quantity {int} is present in MyList")
    public void verifyItemAndQuantityInList(String item, int quantity) throws InterruptedException {
        Assert.assertEquals(GGMylistPage.isItemWithDesiredQuantityPresent(item, quantity), true, String.format("Item %s with quantity %s is not present in List", item, quantity));
    }

    @And("{string} item {string} in MyList")
    public void checkItemByName(String desiredStatus, String item) throws InterruptedException {
        GGMylistPage.checkUnCheckItemByName(item, desiredStatus);
    }

    @Then("get and store checked-in store basket count")
    public void getAndStoreCheckedInStoreBasketCount() {
        ThreadLocalHelper.testCaseData.get().put("CHECKED_INSTORE_BASKET_COUNT", String.valueOf(GGMylistPage.getCheckedInStoreBasketCount()));
    }

    //Possible value for increasedDecreased is INCREASED or DECREASED
    @Then("verify checked-in store basket count is {string} by {int}")
    public void verifyItemIsnList(String increasedDecreased, int changeQty) {
        int previousCount = Integer.valueOf(ThreadLocalHelper.testCaseData.get().get("CHECKED_INSTORE_BASKET_COUNT"));
        switch (increasedDecreased.toUpperCase()) {
            case "INCREASED":
                Assert.assertEquals(GGMylistPage.getCheckedInStoreBasketCount(), previousCount + changeQty, "Count of items in checked-in store basket is not increased");
                break;
            case "DECREASED":
                Assert.assertEquals(GGMylistPage.getCheckedInStoreBasketCount(), previousCount - changeQty, "Count of items in checked-in store basket is not decreased");
                break;
        }
    }

    @Then("verify my list screen is in empty state having zero items and deals in the list")
    public void verifyMyListScreenHasZeroItemsDealsInMyList() {
        Assert.assertTrue(GGMylistPage.isEmptyListMessageDispalyed(), "Empty state image is not displayed when there are no deals/items in list");
    }

    @Then("verify my list screen is not in empty state having 1 item in the list")
    public void verifyMyListScreenHasOneItemandZeroDealsInMyList() {
        Assert.assertFalse(GGMylistPage.isEmptyListMessageDispalyed(), "My List Screen doesn't have one item");
    }

    @Then("verify my list screen is not in empty state having 1 deal in the list")
    public void verifyMyListScreenHasOneDealandZeroItemssInMyList() {
        Assert.assertFalse(GGMylistPage.isEmptyListMessageDispalyed(), "My List Screen doesn't have one deal");
    }

    @Then("verify my list screen is not in empty state having more than one item and more than one deal in the list")
    public void verifyMyListScreenHasMoreThanOneItemAndMoreThanOneDealInMyList() {
        Assert.assertFalse(GGMylistPage.isEmptyListMessageDispalyed(), "My List Screen doesn't have more than one item and more than one deal");
    }

    @Then("slide the item card and click on edit button")
    public void clickOnEditButton() {
        GGMylistPage.slideTheDealCardToNaviagateToItemEditPage();
    }

    @Then("verify 'Relatable Offers' CTA")
    public void verifyRelatableOffersCTA() {
        Assert.assertTrue(GGMylistPage.isRelatableOfferCTADisplayed(), "relatable offers CTA is not displayed");
    }

    @Then("click on relatable offers button")
    public void clickOnRelatableOffers() {
        GGMylistPage.clickOnRelatableOffers();
    }

    @Then("verify Relatable Offers page is displayed")
    public void verifyRelatableOffersPageDisplayed() {
        Assert.assertTrue(GGMylistPage.isRelatableOffersPageDisplayed(), "relatable offers page is not displayed");
    }

    @Then("click back button on relatable offers page")
    public void clickBackButtonOnRelatableOffersPage() {
        GGMylistPage.clickOnBackButtonOnRelatableOfferPage();
    }

    @Then("verify edit item page is displayed")
    public void verifyEditItemPageDisplayed() {
        Assert.assertTrue(GGMylistPage.isEditItemScreenDisplayed(), "edit item page is not displayed");
    }

    @Then("click back button on edit item page")
    public void clickBackButtonOnEditItemPage() {
        GGMylistPage.clickOnBackButtonOnEditItemPage();
    }

    @Then("verify store aisle tab under my list")
    public void verifyStoreAisleTabUnderMyList() {
        Assert.assertTrue(GGMylistPage.isStoreAisleTabDisplayed(), "Store Aisle Tab is not displayed");
    }

    @And("click on store aisle tab")
    public void clickOnStoreAisleTab() {
        GGMylistPage.clickOnStoreAisleTab();
    }

    @Then("verify store aisle tab not displayed under my list")
    public void verifyStoreAisleTabNotDisplayedUnderMyList() {
        Assert.assertFalse(GGMylistPage.isStoreAisleTabNotDisplayed(), "Store Aisle Tab is displayed");
    }

    @Then("verify category tab contents in collapsed view")
    public void verifyCategoryTabContentsInCollapsedView() {
        Assert.assertTrue(GGMylistPage.isCategoryTabContentsInCollapsedView(), "Category tab contents are not in collapsed view");
    }

    @Then("verify store aisle tab contents in collapsed view")
    public void verifyStoreAisleTabContentsInCollapsedView() {
        Assert.assertTrue(GGMylistPage.isStoreAisleTabContentsInCollapsedView(), "Store Aisle tab contents are not in collapsed view");
    }

    @Then("verify category tab contents in expanded view")
    public void verifyCategoryTabContentsInExpandedView() {
        Assert.assertTrue(GGMylistPage.isCategoryTabContentsInExpandedView(), "Category tab contents are not in expanded view");
    }

    @Then("verify store aisle tab contents in expanded view")
    public void verifyStoreAisleTabContentsInExpandedView() {
        Assert.assertTrue(GGMylistPage.isStoreAisleTabContentsInExpandedView(), "Store Aisle tab contents are not in expanded view");
    }

    @And("click on category tab under my list")
    public void clickOnCategoryTabUnderMyList() {
        GGMylistPage.clickOnCategoryTab();
    }

    @Then("^verify category name is not displayed in my list$")
    public void verifyCategoryNameIsNotDisplayed() {
        Assert.assertTrue(GGMylistPage.isCategoryNameNotDisplayed(), "category name is displayed");
    }

    @And("verify New items button")
    public void verifyNewItemsButton() {
        Assert.assertTrue(GGMylistPage.isNewItemsButtonIsDisplayed(), "New Items button is not displayed");
    }

    @Then("click on New items")
    public void clickOnNewItems() {
        GGMylistPage.clickOnNewItems();
    }

    @Then("verify my list search page is displayed")
    public void verifyMyListSearchPageIsDisplayed() {
        Assert.assertTrue(GGMylistPage.isMyListSearchPageIsDisplayed(), "My list search page is not displayed");
    }

    @And("search for product {string} on my list search page")
    public void searchForProductOnMyListSearchPage(String productName) {
        GGMylistPage.searchByProductName(productName);
    }

    @And("search for product {string} on my relatable offers page")
    public void searchForProductOnRelatableOffersPage(String productName) {
        GGMylistPage.searchAnItemInRelatedOffersPage(productName);
    }

    @And("verify {string} related search results are displayed")
    public void verifySearchRelatedResultsAreDisplayed(String productName) {
        Assert.assertTrue(GGMylistPage.getDealCardContent().contains(productName));
    }

    @And("click on search field in my list search page")
    public void clickSearchFieldinMyListSearchPage() {
        GGMylistPage.clickSearchFieldMyListPage();
    }

    @Then("enter text {string} in my list search page")
    public void enterTextInMyListSearchPage(String itemName) throws InterruptedException {
        GGMylistPage.enterTextInSearchField(itemName);
    }

    @And("verify search result is displayed on my list page")
    public void verifySearchResultIsDisplayedOnMyListPage() {
        Assert.assertTrue(GGMylistPage.isSearchResultDisplayedOnMyListPage(), "Search result is not displayed");
    }

    @Then("select first item from search result in my list page")
    public void selectFirstItemFromSearchResultInMyListPage() {
        GGMylistPage.selectFirstItemFromSearchResult();
    }

    @Then("verify {string} toast message")
    public void verifyItemAddedToYourListToastMessage(String toastMessage) {
        Assert.assertTrue(GGMylistPage.toastMessageText(toastMessage), "Toast message is not displayed");
    }

    @Then("verify keyboard is opened")
    public void verifyKeyBoardIsOpened() {
        Assert.assertTrue(GGMylistPage.isKeyBoardOpened(), "key board is not displayed");
    }

    @And("click text clear button on search field in my list search page")
    public void clickTextClearButtonOnSearchFieldInMyListSearchPage() {
        GGMylistPage.clickTextClearButtonOnSearchField();
    }

    @Then("verify text is cleared at my list search")
    public void verifyTextCleared() {
        Assert.assertTrue(GGMylistPage.isTextCleared(), "text is not cleared");
    }

    @And("click back button on my list search page")
    public void clickBackButtonOnMyListSearchPage() {
        GGMylistPage.clickBackbuttonOnMyListSearchPage();
    }

    @And("user clicks cancel button on my list search page")
    public void clickCancelButtonOnMyListSearchPage() {
        GGMylistPage.clickCancelButtonOnMyListSearchPage();
    }


    @And("verify MyList page is displayed")
    public void verifyMyListHeader() {
        Assert.assertTrue(GGMylistPage.isMyListHeaderDisplayed(), "My list page header is not displayed");
    }

    @And("enter text {string} in item name field")
    public void enterInItemName(String itemName) {
        GGMylistPage.enterTextInItemNameField(itemName);
    }

    @Then("enter {string} in item quantity field")
    public void enterInItemQuantityField(String quantity) {
        GGMylistPage.enterInItemQuantityField(quantity);
    }

    @And("click back button on item card details page")
    public void clickBackButtonOnItemCardDetailsPage() {
        GGMylistPage.clickBackButtonOnItemCardDetailsPage();
    }

    @And("verify Item name field is displayed in item card detail page")
    public void verifyItemNameFieldIsDisplayed() {
        Assert.assertTrue(GGMylistPage.verifyItemNameFieldIsDisplayed(), "Item name field is not displayed");
    }

    @Then("verify Item quantity field is displayed in item card detail page")
    public void verifyItemQuantityFieldIsDisplayed() {
        Assert.assertTrue(GGMylistPage.verifyItemQuantityFieldIsDisplayed(), "Item quantity field is not displayed");
    }

    @When("verify Item title is displayed in item card detail page")
    public void verifyItemTitleIsDisplayed() {
        Assert.assertTrue(GGMylistPage.verifyItemTitleIsDisplayed(), "Item title is not displayed");
    }

    @And("verify category name is displayed in item card detail page")
    public void verifyCategoryNameIsDisplayedInItemCardDetailPage() {
        Assert.assertTrue(GGMylistPage.verifyCategoryNameIsDisplayed(), "Category name is not displayed");
    }

    @Then("verify remove button is displayed in item card detail page")
    public void verifyRemoveButtonIsDisplayedInItemCardDetailPage() {
        Assert.assertTrue(GGMylistPage.verifyRemoveButtonIsDisplayed(), "Remove button is not displayed");
    }


    @Then("click on category name in item card detail page")
    public void clickOnCategoryNameInItemCardDetailPage() {
        GGMylistPage.clickOnCategoryName();
    }

    @Then("click on remove button in item card detail page")
    public void clickOnRemoveButtonInItemCardDetailPage() {
        GGMylistPage.clickOnRemoveButton();
    }

    @Then("^verify items are listed under categories$")
    public void verifyItemsUnderCategories() {
        Assert.assertTrue(GGMylistPage.isItemsDisplayedUnderCategories(), "Items are not listed");
    }

    @And("^click on item card under categories$")
    public void clickOnItemCard() {
        GGMylistPage.clickOnItemCard();
    }

    @Then("^verify item card detail page is displayed$")
    public void verifyItemCardDetailpageIsDisplayed() {
        Assert.assertTrue(GGMylistPage.isItemCardDetailPageDisplayed(), "Item card detail page is not displayed");
    }

    @And("verify category list page is displayed")
    public void verifyCategoryListPageIsDisplayed() {
        Assert.assertTrue(GGMylistPage.isCategoryListPageIsDisplayed(), "Category list page is not displayed");
    }

    @Then("changes the category in item card details page")
    public void selectsACategoryAndVerifyCategoryIsUpdatedItemCardDetailPage() {
        GGMylistPage.selectsACategoryAndVerifyCategoryIsUpdated();
    }


    @Then("verify item name {string} is updated")
    public void verifyItemNameIsUpdated(String itemNameUpdated) {
        Assert.assertTrue(GGMylistPage.myItemNameIsUpdated(itemNameUpdated), "Item name is not updated");
    }

    @And("verify item quantity {string} is updated")
    public void verifyItemQuantityIsUpdated(String quantityUpdated) {
        Assert.assertTrue(GGMylistPage.myItemQuantityIsUpdated(quantityUpdated), "Item name is not updated");
    }

    @Then("verify item name {string} is not updated")
    public void verifyItemNameIsNotUpdated(String itemNameUpdated) {
        Assert.assertFalse(GGMylistPage.myItemNameIsUpdated(itemNameUpdated), "Item name is updated");
    }

    @And("verify item quantity {string} is not updated")
    public void verifyItemQuantityIsNotUpdated(String quantityUpdated) {
        Assert.assertFalse(GGMylistPage.myItemQuantityIsUpdated(quantityUpdated), "Item name is updated");
    }

    @And("scroll down to expand {string} category from the list")
    public void scrollDownToExpandCategoryFromTheList(String desiredCategoryName) {
        new CommonActions(driver).new TableActions().scrollDownTillCategoryIsDisplayed(GGMylistPage.getPageElements().categoryNamesInList, desiredCategoryName);
        //GGMylistPage.scrollDownTillCategoryIsDisplayed(desiredCategoryName);
    }

    @And("click on  a deal with of {string} type")
    public void clickOnADealWithOfType(String dealTypeToSelect) {
        // Access the API's to get desired deal
        /*List<ApiResponse.MyList.ShoppingList> allOffersAPI = (List<ApiResponse.MyList.ShoppingList>) CommonCache.myListInAPI.get("myList");
        String wsTypeDeal = allOffersAPI.stream().filter(dealsMyList -> dealsMyList.itemType.equalsIgnoreCase("WS")).collect(Collectors.toList()).get(0).title;
        String grTypeDeal =allOffersAPI.stream().filter(dealsMyList -> dealsMyList.itemType.equalsIgnoreCase("GR")).collect(Collectors.toList()).get(0).title;
        String noOfferIdDeal =allOffersAPI.stream().filter(dealsMyList -> dealsMyList.offerId.isEmpty()).collect(Collectors.toList()).get(0).title;
*/
        String wsTypeDeal = "Reward Flat";
        String noOfferIdDeal = "Reward Flat";
        String grTypeDeal = "Reward Flat";
        GGMylistPage.selectDealOrProductFromExpandedCategory(wsTypeDeal);

    }


    @Then("^verify deals are listed under categories$")
    public void verifyDealsUnderCategories() {
        Assert.assertTrue(GGMylistPage.isDealsDisplayedUnderCategories(), "deals are not listed");
    }

    @Then("^verify product count is displayed in my list$")
    public void verifyDealsCountUnderCategories() {
        Assert.assertTrue(GGMylistPage.isProductCountDisplayed(), "product count is not displayed");
    }

    @And("^click on deal card under categories$")
    public void clickOnDealCard() {
        GGMylistPage.clickOnDealCard();
    }

    @Then("^verify deals card detail page is displayed$")
    public void verifyDealsCardDetailpageIsDisplayed() {
        Assert.assertTrue(GGMylistPage.isDealCardDetailPageDisplayed(), "deals card detail page is not displayed");
    }

    @And("^expand a category$")
    public void expandCategories() {
        GGMylistPage.expandCategory();
    }

    @And("^collapse a category$")
    public void collapseCategories() {
        GGMylistPage.collapseCategory();
    }

    @And("^collapse all categories$")
    public void collapseAllCategories() {
        GGMylistPage.collapseAllCategory();
    }

    @And("^checkout a category for deals$")
    public void checkOutCategoriesForDeals() {
        Assert.assertTrue(GGMylistPage.checkOutCategoriesForDeals());
    }

    @And("^uncheck a category for deals$")
    public void unCheckCategoriesForDeals() {
        GGMylistPage.unCheckOutCategoriesForDeals();
    }

    @And("^checkout a category for items$")
    public void checkOutCategoriesForItems() {
        Assert.assertTrue(GGMylistPage.checkOutCategoriesForItems());
    }

    @And("^uncheck a category for items$")
    public void unCheckCategoriesForItems() {
        GGMylistPage.unCheckOutCategoriesForItems();
    }

    @And("^verify categories are sorted alphabetically under my list$")
    public void verifyCategoriesAreSortedAlphabetically() {
        GGMylistPage.areCategoriesDisplayedAlphabetical();
    }

    @Then("^verify deal card header is displayed$")
    public void verifyDealCardHeaderIsDisplayed() {
        Assert.assertTrue(GGMylistPage.isDealCardHeaderDisplayed(), "deal card header is not displayed");
    }

    @Then("^verify deal card image is displayed$")
    public void verifyDealCardImageIsDisplayed() {
        Assert.assertTrue(GGMylistPage.isDealCardImageDisplayed(), "deal card image is not displayed");
    }

    @Then("^verify deal card offer is displayed$")
    public void verifyDealCardOfferIsDisplayed() {
        Assert.assertTrue(GGMylistPage.isDealCardOfferDisplayed(), "deal card offer is not displayed");
    }

    @Then("^verify deal card description is displayed$")
    public void verifyDealCardDescriptionIsDisplayed() {
        Assert.assertTrue(GGMylistPage.isDealCardDescriptionDisplayed(), "deal card description is not displayed");
    }

    @Then("^verify deal category \"([^\"]*)\" shown at the top in 'My List'$")
    public void verifyTheCategoryIsShownAtTopInDeals(String categoryName) throws IOException {
        Assert.assertEquals(GGMylistPage.getTheCategoriesOfMyList().stream().findFirst().get(), categoryName, "Special Categories not displayed on the top");
    }

    @Then("^refresh the page and verify latest categories are displayed$")
    public void verifyLatestCategoriesareDisplayed() {
        Assert.assertTrue(GGMylistPage.isLatestCategoryDisplayed(), "latest categories is not displayed");
    }

    @Then("^verify category name is displayed in my list$")
    public void verifyCategoryNameIsDisplayed() {
        Assert.assertTrue(GGMylistPage.isCategoryNameDisplayed(), "category name is not displayed");
    }

    @Then("verify MyList tab {string} displayed")
    public void verifyMyListTab(String expectedVal) {
        boolean actualValue = GGMylistPage.isMyListTabDisplayed();
        if (expectedVal.contains("not")) {
            Assert.assertFalse(actualValue, "My List tab is displayed");
        } else {
            Assert.assertTrue(actualValue, "My List tab is not displayed");
        }
    }

    @Then("verify user is in {string} tab in MyList")
    public void verifyUserLandingByTabNameMyList(String tabName) {
        GGMylistPage.verifyUserLandingByTabName(tabName);
    }

    @And("verify tabs and their order in MyList page")
    public void verifyTabsAndTheirOrderInMyList() {
        GGMylistPage.verifyTabsAndTheirOrderInMyList();
    }

    @Then("verify category tab under my list is selected by default")
    public void verifyCategoryTabUnderMyListIsSelectedByDefault() {
        Assert.assertTrue(GGMylistPage.isCategoryTabSelectedByDefault());
    }

    @Then("verify category tab under my list")
    public void verifyCategoryTabUnderMyList() {
        Assert.assertTrue(GGMylistPage.isCategoryTabDisplayedUnderMyList());
    }

    @Then("verify Ellipses under my list")
    public void verifyEllipsesUnderMyList() {
        Assert.assertTrue(GGMylistPage.isEllipsesDisplayedUnderMyList());
    }

    @And("slide the card to remove the product from the list")
    public void slideTheCardToRemoveCategory() {
        GGMylistPage.slideTheCardToRemoveOnlyProduct();
    }

    @And("slide the card to remove the deals from the list")
    public void slideTheCardToRemoveDeals() {
        GGMylistPage.slideTheCardToRemoveDeals();
    }

    @And("slide the card and verify remove button")
    public void slideTheCardAndVerifyRemoveButton() {
        GGMylistPage.slideTheCardToVerifyRemoveButton();
    }

    @And("expand {string} category")
    public void expandCategory(String categoryName) {
        GGMylistPage.expandCategoryInMyList(categoryName);
    }

    @Then("verify deals and items under 'Checked - In Store Basket' are sorted alphabetically")
    public void dealsItemsCheckedUnderCategoryTabShouldBeSortedAlphabetically() {
        Assert.assertTrue(GGMylistPage.areItemsUnderCheckedInStoreSortedAlphabetically(), "Items under checked in store basket are not sorted alphabetically!!");
        Assert.assertTrue(GGMylistPage.areDealsUnderCheckedInStoreSortedAlphabetically(), "Deals under checked in store basket are not sorted alphabetically!!");
    }

    @Then("verify store aisle list sorted based on count")
    public void verifyStoreAisleListSortedBasedOnCount() {
        GGMylistPage.verifyStoreAisleListSortedBasedOnCount();
    }

    @And("click on most recent tab under list")
    public void clickOnMostRecentTabUnderList() {
        GGMylistPage.clickOnMostRecentTabUnderList();
    }

    @Then("user pulls the screen down to refresh")
    public void refreshScreen() {
        GGMylistPage.refreshScreen();
    }

    @And("Add item {string} to list")
    public void addItemToList(String itemName) {
        GGMylistPage.addAnItem(itemName);
    }

    @Then("verify the list order as {string}, {string} and {string}")
    public void verifyTheListOrderAsAnd(String itemOne, String itemTwo, String itemThree) throws InterruptedException {
        List<String> itemsList = GGMylistPage.getItemsOrderInCategory();
        Assert.assertEquals(itemsList.get(0).contains(itemOne), true, "The items order inside the list is not proper.");
        Assert.assertEquals(itemsList.get(1).contains(itemTwo), true, "The items order inside the list is not proper.");
        Assert.assertEquals(itemsList.get(2).contains(itemThree), true, "The items order inside the list is not proper.");
    }

    @And("^click on 'Most Recent' tab$")
    public void clickOnMostRecentTab() {
        GGMylistPage.clickOnMostRecentTabInMyList();
    }

    @And("verify {string} item is added to Most Recent Tab")
    public void verifyItemIsAddedToMostRecentTab(String productName) {
        Assert.assertTrue(GGMylistPage.getItemNameUnderMyList().contains(productName), "item is not added under most recent tab");
    }

    @And("verify deal is added after deal is clipped")
    public void verifyDealIsAdded() {
        Assert.assertEquals(GGMylistPage.getDealCardUnderMyList().contains(CommonCache.commonCache.get("CLIPPED_DEAL")), true, "deals are not added under most recent tab Actual :" + CommonCache.commonCache.get("CLIPPED_DEAL"));
    }

    @And("verify deal is present in Most Recent tab under MyList")
    public void verifyDealIsAddedUnderMostRecent() {
        Assert.assertEquals(GGMylistPage.getDealCardUnderMyList().contains(ThreadLocalHelper.testCaseData.get().get("DEAL_NAME_MYLIST")), true, "Deal is not added under most recent tab, Actual :" + ThreadLocalHelper.testCaseData.get().get("DEAL_NAME_MYLIST"));
    }

    @And("verify deals and items {string} listed under Most Recent tab")
    public void verifyItemDealsAreListed(String desiredStatus) {
        if (desiredStatus.contains("not")) {
            Assert.assertFalse(GGMylistPage.verifyDealsAndItemsAreListed(), "Deals and items are listed!!");
        } else {
            Assert.assertTrue(GGMylistPage.verifyDealsAndItemsAreListed(), "Deals and items are not listed!!");
        }
    }

    @Then("verify checked-In store category is expanded by default")
    public void verifyCheckedOutCategoriesInExpandedView() {
        Assert.assertTrue(GGMylistPage.isCheckedInStoreBasketExpanded(), "Checked-In store category is not expanded by default");
    }

    @And("verify Aisle feedback option is displayed")
    public void verifyAisleFeedbackOptionIsDisplayed() {
        Assert.assertTrue(GGMylistPage.isAisleFeedbackOptionDisplayed());
    }

    @Then("click on Aisle feedback option")
    public void clickOnAisleFeedback() {
        GGMylistPage.clickOnAisleFeedback();
    }

    @And("verify Aisle feedback listing page is displayed")
    public void verifyAisleFeedbackPageIsDisplayed() {
        Assert.assertTrue(GGMylistPage.verifyAisleFeedbackPageIsDisplayed());
    }

    @Then("click on {string} Aisle Feedback")
    public void clickOnAisleFeedback(String aisleFeedback) {
        GGMylistPage.clickOnAisleFeedback(aisleFeedback);
    }

    @Then("verify back button in Aisle feedback page")
    public void verifyBackButtonInAisleFeedbackPage() {
        Assert.assertTrue(GGMylistPage.verifyBackButtonInAisleFeedbackPage());
    }

    @Then("verify error message is displayed when user tries to submit aisle feedback with internet off")
    public void verifyServiceProblemMessageIsDisplayedWhenUserTriesToClickAisleFeedback() {
        Assert.assertTrue(GGMylistPage.isErrorMsgDisplayedForAisleFeedbackWithInternetOff(), "Error message is not displayed when user tried to submit aisle feedback with internet off");
    }

    @Then("verify network error pop up is displayed for {string} platform")
    public void verifyNetworkErrorForPlatform(String platform) {
        switch (platform.toUpperCase()) {
            case "IOS":
            case "ANDROID":
                if (driver.getPlatformName().equalsIgnoreCase(platform)) {
                    Assert.assertTrue(GGMylistPage.isNoInternetMessageDisplayed(), "Network error pop up is not displayed!!");
                }
                break;
            case "BOTH":
                Assert.assertTrue(GGMylistPage.isNoInternetMessageDisplayed(), "Network error pop up is not displayed!!");
                break;
        }
    }

    @Then("clip multiple deals")
    public void clickmultipleDeals() {
        GGMylistPage.clipMultipleDeals();
    }

    @And("add a deal to MyList and store deal name")
    public void addADealToMyListAndStoreDealName() {
        new GG_DashboardPage(driver).clickOnDealsTabWithLoveAppPopUpHandling();
        new GG_DealsPage(driver).scrollUpTillDealsTopNavigationBarDisplayed();
        new GG_DealsPage(driver).goToCategoriesTab();
        List<Map<String, String>> dealData = new GG_Deals_CategoriesPage(driver).clipDealFromYourCategoriesAndReturnDealsData(1);
        ThreadLocalHelper.testCaseData.get().put("DEAL_NAME_MYLIST", dealData.get(0).get("dealName"));
    }

    // Works best when single deal is present in mylist
    // Make sure to use the step 'add a deal to MyList and store deal name' before using this step
    @And("{string} the deal in MyList")
    public void checkDealByName(String desiredStatus) throws InterruptedException {
        GGMylistPage.checkUnCheckDealByName(ThreadLocalHelper.testCaseData.get().get("DEAL_NAME_MYLIST"), desiredStatus);
    }

    @And("slide the item card to add a deal from Relatable Offers")
    public void slideTheItemCardToAddADealFromRelatableOffers() {
        clickOnEditButton();
        verifyRelatableOffersCTA();
        clickOnRelatableOffers();
        verifyRelatableOffersPageDisplayed();
        new GG_Deals_CategoriesSteps().getClippedDealDescriptionFromDealsCategories();
        clipDealToAddUnderList();
        clickBackButtonOnRelatableOffersPage();
        clickBackButtonOnEditItemPage();
    }

    @And("user views the category name in item card details")
    public void userViewsTheCategoryNameInItemCardDetails() {
        CommonCache.commonCache.put("CAT_NAME_SELECTED", GGMylistPage.getCategoryNameSelected());
    }

    @And("user clicks previously selected category in deals on my list page")
    public void userClicksPreviouslySelectedCategoryInDealsOnMyListPage() throws Throwable {
        userClicksOnDealsPage(CommonCache.commonCache.get("firstDisplayedCategoryDeals"));
    }

    @Then("verify updated category in list details is present in my list categories")
    public void verifyUpdatedCategoryInListDetailsIsPresentInMyListCategories() {
        List<String>catNames= GGMylistPage.getAllCategoryNamesWithoutScroll();
        String catNameSelected = CommonCache.commonCache.get("CATEGORY_SELECTED_ITEM_EDIT");
        Assert.assertTrue(catNames.contains(catNameSelected)||catNames.stream().filter(indVal->catNameSelected.contains(indVal)).collect(Collectors.toList()).size()!=0,"Category name not present in list");
    }


    @And("go to Clipped Deals tab in MyList")
    public void goToClippedDealsTabInMyList() {
        GGMylistPage.goToClippedDealsTab();
    }

    @Then("verify my list screen is empty having zero items and deals in the list")
    public void verify_my_list_screen_is_empty_having_zero_items_and_deals_in_the_list() {
        clickOnMyListTab();
        Assert.assertTrue(GGMylistPage.isEmptyListMessageDispalyed(), "Empty state image is not displayed when there are no deals/items in list");
    }

}



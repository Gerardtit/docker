Feature: My List - categories


  #C70510
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab  @functional @start_scenario
  Scenario: As a user, I should be able to see 'Special offer' at the top of categories list and other categories should be sorted by alphabetical order
    When sign up to the application with popup handling
    And go to Home tab
    When go to MyList tab
    And go to List Tab
    Then add an item and deal if list is empty
    And go to Deals tab
    And click on categories tab
    When scroll down to expand "Special Offers" category from deals categories
    And user clicks category "Special Offers" from Your categories
    And clip multiple deals
    And go to MyList tab
    Then verify deal category "Special Offers" shown at the top in 'My List'
    And verify categories are sorted alphabetically under my list

  #C70563
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab
  Scenario: UI validation for the 'Add to list' and 'Added to List' CTA
    And go to Deals tab
    And click on categories tab
    And scroll up till top of the categories tab
    And user clicks category "Bread & Bakery" from Your categories
    And click on deal card
    Then verify deal detail page is displayed
    When click on clip deal in deals details page
    And close deal details page
    And go to MyList tab
    And go to List Tab
    And scroll up till top in MyList categories
    And verify "Category" tab is selected in MyList
    And delete all items from MyList using list tool
    And go to Deals tab
    And scroll up till top of the categories tab
    And click on categories tab
    And user clicks category "Bread & Bakery" from Your categories
    And click on deal card to re add under list
    Then verify deal detail page is displayed
    And verify add to list button displayed
    And clip a deal and verify added to list link displayed
    And close deal details page

  #C70455
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab  @functional
  Scenario: As a user, I should able to add the items manually and user should be able to navigate to the Items details page on tapping items card. User should be able to check and uncheck the items
    When go to MyList tab
    And go to List Tab
    When click on New items
    And verify my list search page is displayed
    And search for product "Beer" on my list search page
    And click back button on my list search page
    Then verify my list page is displayed
    Then verify items are listed under categories
    And click on item card under categories
    Then verify item card detail page is displayed
    And click back button on item card details page
    Then expand a category
    When checkout a category for items
    Then collapse all categories
    And uncheck a category for items

  #C70453
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab
  Scenario: As a user, I should see Items and deals are added (depends on API response) in My List tab under the category section
    Then go to MyList tab
    And go to List Tab
    And scroll up till top in MyList categories
    And delete all items from MyList using list tool
    And add an item and deal if list is empty
    And go to List Tab
    And expand a category
    Then verify items are listed under categories
    And verify deals are listed under categories
    And collapse a category

  #C70454
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab  @functional
  Scenario: As a user, I should see the name and count of deals and items cards. User should able to expand and collapse the categories.
    When go to MyList tab
    And go to List Tab
    When verify category name is displayed in my list
    Then verify product count is displayed in my list
    And expand a category
    Then verify items are listed under categories
    And verify deals are listed under categories
    Then collapse a category

  #C70456
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab  @functional

  Scenario: As a user, I should be able to navigate to the Deals details page on tapping Deals card. User should be able to check and uncheck the Deals
    Then go to MyList tab
    And go to List Tab
    And scroll up till top in MyList categories
    And delete all items from MyList using list tool
    And add an item and deal if list is empty
    Then expand a category
    And verify deals are listed under categories
    When checkout a category for deals
    And uncheck a category for deals
    When verify deals are listed under categories
    And click on deal card under categories
    And verify deals card detail page is displayed
    And close deal details page
    And collapse a category

  #C70457

  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab
  Scenario: As a user, I should be able to see the UI of Deals card should be as per the figma design
    Then go to MyList tab
    And go to List Tab
    And scroll up till top in MyList categories
    And delete all items from MyList using list tool
    And add an item and deal if list is empty
    Then verify deals are listed under categories
    And verify deal card header is displayed
    Then verify deal card image is displayed
    And verify deal card offer is displayed
    Then verify deal card description is displayed
    And collapse a category

  #C70459
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab  @functional
  Scenario: As a user, I should be able to see the Loader and latest data under categories when user Pull to refresh the screen
    Then go to MyList tab
    And go to List Tab
    When scroll up on the page
    And expand a category
    When refresh the page and verify latest categories are displayed
    And refresh the page and verify progress spinner is displayed
    Then collapse a category

  #C70472
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab  @functional
  Scenario: As a user I Should be able to delete the product/deals from the 'My List'.
    When go to MyList tab
    And go to List Tab
    And scroll up till top in MyList categories
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    And add a deal to MyList and store deal name
    When go to MyList tab
    And remove item "Milk" from MyList
    And slide the card to remove the deals from the list
    Then verify my list screen is in empty state having zero items and deals in the list

  #C70503
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab
  Scenario: As a user I Should see the delete option as per the figma design
    Then go to MyList tab
    And go to List Tab
    And scroll up till top in MyList categories
    And delete all items from MyList using list tool
    And add an item and deal if list is empty
    And expand a category
    Then verify items are listed under categories
    And verify deals are listed under categories
    Then slide the card and verify remove button
    And collapse a category

  #C70504
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab
  Scenario: As a user I Should see the ' "Checked in-store basket" according to figma
    When go to MyList tab
    And go to List Tab
    And scroll up till top in MyList categories
    And verify "Category" tab is selected in MyList
    And delete all items from MyList using list tool
    When click on New items
    And verify my list search page is displayed
    And search for product "Milk" on my list search page
    And click back button on my list search page
    Then verify my list page is displayed
    And user clicks item "Dairy,Eggs & Cheese" on my list page
    And slide the item card to add a deal from Relatable Offers
    And checkout a category for deals
    And the "Checked In Store Basket" section "is" displayed


  #C70470
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab
  Scenario: As a user, I should able to navigate to the deals details screen when user tap on any of the deals under the category section
    When go to MyList tab
    And go to List Tab
    And scroll up till top in MyList categories
    And verify "Category" tab is selected in MyList
    And delete all items from MyList using list tool
    Then add an item and deal if list is empty
    When scroll up on the page
    When expand a category
    Then verify deals are listed under categories
    And click on deal card under categories
    Then verify deals card detail page is displayed
    And close deal details page
    And collapse a category

  #C70471
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab
  Scenario: As a user, I should see the UI of details detail screen is as same as UX design in respective banners and themes
    When go to MyList tab
    And go to List Tab
    And scroll up till top in MyList categories
    And verify "Category" tab is selected in MyList
    And delete all items from MyList using list tool
    Then add an item and deal if list is empty
    When scroll up on the page
    When expand a category
    Then verify deals are listed under categories
    And click on deal card under categories
    And verify offer terms and condition in deal card
    Then verify eligible products are displayed in offer details page
    And close deal details page
    And collapse a category

  #C70559
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab  @functional
  Scenario: As a user I Should be able to readd the deleted item to list
    When go to MyList tab
    And go to List Tab
    And scroll up till top in MyList categories
    And verify "Category" tab is selected in MyList
    And delete all items from MyList using list tool
    And go to Deals tab
    And scroll up till top of the categories tab
    And click on categories tab
    When scroll down and expand first displayed category from deals categories
    And clip a deal to add under list
    Then go to MyList tab
    And go to List Tab
    Then verify category tab under my list
    And user clicks previously selected category in deals on my list page
    When get clipped deal name from list
    Then slide the card to remove the deals from the list
    And go to Deals tab
    And scroll up till top of the categories tab
    And click on categories tab
    When scroll down and expand first displayed category from deals categories
    And click on deal card to re add under list
    Then verify deal detail page is displayed
    And click on Add to list button
    When click on Added to list button
    And user clicks previously selected category in deals on my list page
    And verify deal is re-added

  #C70559
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab @functional
  Scenario: As a user I Should able to clip the deal and add it to List
    When go to MyList tab
    And go to List Tab
    And scroll up till top in MyList categories
    And verify "Category" tab is selected in MyList
    And delete all items from MyList using list tool
    And go to Deals tab
    And scroll up till top of the categories tab
    And click on categories tab
    And scroll down to expand "Dairy,Eggs & Cheese" category from deals categories
    And user clicks category "Dairy,Eggs & Cheese" from Your categories
    When get clipped deal name from deals categories
    And clip a deal to add under list
    Then go to MyList tab
    And go to List Tab
    And scroll up on the page
    And verify "Category" tab is selected in MyList
    And user clicks item "Dairy,Eggs & Cheese" on my list page
    Then verify deal is added after deal is clipped

  #C70617
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab
  Scenario: As a User, I should be able to see 'Related Offers' CTA in Edit items Screen
    Then go to MyList tab
    And go to List Tab
    And scroll up on the page
    Then verify category tab under my list
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    Then verify my list page is displayed
    Then slide the item card and click on edit button
    And verify 'Relatable Offers' CTA
    When click back button on edit item page
    And collapse a category

  #C70618
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab  @functional
  Scenario: As a User, I should be navigated to "Related Offers' screen on tapping on Related offers CTA
    Then go to MyList tab
    And go to List Tab
    And scroll up on the page
    Then verify category tab under my list
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    Then verify my list page is displayed
    Then slide the item card and click on edit button
    And verify 'Relatable Offers' CTA
    When click on relatable offers button
    Then verify Relatable Offers page is displayed
    When click back button on relatable offers page
    And verify edit item page is displayed
    And click back button on edit item page
    And collapse a category

  #C70619
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab  @functional
  Scenario: As a User, I should be able to see Related offers based on Category which user has selected
    Then go to MyList tab
    And go to List Tab
    And scroll up on the page
    Then verify category tab under my list
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    Then verify my list page is displayed
    And get item name from list
    Then slide the item card and click on edit button
    And verify 'Relatable Offers' CTA
    When click on relatable offers button
    Then verify Relatable Offers page is displayed
    And verify relatable offers based on catagories are displayed
    When click back button on relatable offers page
    And verify edit item page is displayed
    And click back button on edit item page
    And collapse a category

  #C70621
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab  @functional
  Scenario:  As a User, I should be able to clip a deal in Related offers screen
    Then go to MyList tab
    And go to List Tab
    And scroll up on the page
    Then verify category tab under my list
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    Then verify my list page is displayed
    And get item name from list
    Then slide the item card and click on edit button
    And verify 'Relatable Offers' CTA
    When click on relatable offers button
    Then verify Relatable Offers page is displayed
    When get clipped deal name from deals categories
    When clip a deal to add under list
    When click back button on relatable offers page
    And click back button on edit item page
    And collapse a category

  #C70621
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab  @functional
  Scenario: As a User, I should be able to see the deal clipped from Related offers screen is added to my List
    Then go to MyList tab
    And go to List Tab
    And scroll up on the page
    Then verify category tab under my list
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    Then verify my list page is displayed
    Then slide the item card and click on edit button
    And verify 'Relatable Offers' CTA
    When click on relatable offers button
    Then verify Relatable Offers page is displayed
    When get clipped deal name from deals categories
    When clip a deal to add under list
    When click back button on relatable offers page
    And click back button on edit item page
    And user clicks item "Dairy,Eggs & Cheese" on my list page
    Then verify deal is added after deal is clipped
    And collapse a category

  #C70622
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab  @functional
  Scenario: As a User, I should navigate back to edit items screen on tapping on back button from Related Offers screen
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    Then verify my list page is displayed
    And get item name from list
    Then slide the item card and click on edit button
    And verify 'Relatable Offers' CTA
    When click on relatable offers button
    Then verify Relatable Offers page is displayed
    When click back button on relatable offers page
    And verify edit item page is displayed
    And click back button on edit item page
    And collapse a category

  #C70623
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab
  Scenario: As a User, I should be able to see UI of related offers screen as per figma dsign
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    Then verify my list page is displayed
    And get item name from list
    Then slide the item card and click on edit button
    And verify 'Relatable Offers' CTA
    When click on relatable offers button
    Then verify Relatable Offers page is displayed
    And verify deal card components
    When click back button on relatable offers page
    And verify edit item page is displayed
    And click back button on edit item page
    And collapse a category

  #C70624
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab  @functional
  Scenario: As a User, i shoudl be able to see related offers screen on backgrounding and foregrounding the app
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    Then verify my list page is displayed
    And get item name from list
    Then slide the item card and click on edit button
    And verify 'Relatable Offers' CTA
    When click on relatable offers button
    Then verify Relatable Offers page is displayed
    When keep app in background and relaunching the same
    And verify Relatable Offers page is displayed
    When click back button on relatable offers page
    And verify edit item page is displayed
    And click back button on edit item page
    And collapse a category

  #C70640
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab  @functional
  Scenario: As a User, I should be able to search respective related offers and results are retrieved as per search
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    Then verify my list page is displayed
    Then slide the item card and click on edit button
    And verify 'Relatable Offers' CTA
    When click on relatable offers button
    Then verify Relatable Offers page is displayed
    And click on search field in my list search page
    And click text clear button on search field in my list search page
    When search for product "Milk" on my relatable offers page
    And verify deals related to "Milk" are displayed
    When click back button on relatable offers page
    And verify edit item page is displayed
    And click back button on edit item page
    And collapse a category

  #C70565
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab  @functional
  Scenario: As a User, I should be able navigate to the Item detail screen On clicking Item card/ on clicking Edit CTA and Heading should be item name. UI should be as per the figma design
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    Then verify my list page is displayed
    And click on item card under categories
    Then verify item card detail page is displayed
    When verify Item title is displayed in item card detail page
    And verify Item name field is displayed in item card detail page
    Then verify Item quantity field is displayed in item card detail page
    And verify category name is displayed in item card detail page
    Then verify remove button is displayed in item card detail page
    Then click back button on edit item page

  #C70566
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab  @functional
  Scenario: As a User, I should be able edit (item name, item quantity )in item detail screen
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    Then verify my list page is displayed
    Then verify items are listed under categories
    And click on item card under categories
    Then verify item card detail page is displayed
    And enter text "Corona Beer" in item name field
    Then enter "15" in item quantity field
    And click back button on item card details page
    Then verify item name "Corona Beer" is updated
    And verify item quantity "15" is updated
    And collapse a category

  #C70567
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab  @functional
  Scenario: As a User, I should see edited data should not update when i switch the tab.
    Then go to MyList tab
    And go to List Tab
    Then verify items are listed under categories
    And click on item card under categories
    Then verify item card detail page is displayed
    And enter text "Blue Beer" in item name field
    Then enter "18" in item quantity field
    And hide keyboard if opened
    And go to Browse tab
    When go to MyList tab
    And go to List Tab
    Then verify items are listed under categories
    Then verify item name "Blue Beer" is not updated
    And verify item quantity "18" is not updated

  #C70568
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab  @functional
  Scenario: As a User, I should able to navigate to the 'Select category' screen on clicking Category name
    Then go to MyList tab
    And go to List Tab
    And scroll up till top in MyList categories
    And delete all items from MyList using list tool
    And add an item and deal if list is empty
    Then verify items are listed under categories
    And click on item card under categories
    Then verify item card detail page is displayed
    And verify category name is displayed in item card detail page
    And user views the category name in item card details
    Then click on category name in item card detail page
    And verify category list page is displayed
    Then changes the category in item card details page
    And verify item card detail page is displayed
    And click back button on item card details page
    Then verify updated category in list details is present in my list categories

  #C70571
  #Author: Rohith
  @regression @module_mylist @module_mylist_categories_tab  @functional @end_scenario
  Scenario: As a User, I should be able to remove item from the list on clicking 'Remove From list' CTA and i should be able to navigate to the list screen on clicking back button and List screen should be loaded with new data
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    Then verify my list page is displayed
    Then verify items are listed under categories
    And click on item card under categories
    And verify item card detail page is displayed
    And verify remove button is displayed in item card detail page
    And click on remove button in item card detail page
    Then verify my list screen is in empty state having zero items and deals in the list

    ##C70607
  ##cannot check the upgrade flow
  #  @regression @module_mylist @module_mylist_categories_tab  @functional
  #  Scenario: As a user I Should be able to Delete Checked in items/ Delete All items after UPGRADE
  #    When go to MyList tab
  #    And go to List Tab
  #    Then go to Deals tab
  #    And scroll up on the page
  #    When go to 'All Deals' Tab
  #    And add multiple deals to my list
  #    Then expand a category
  #    When checkout a category for deals
  #    And scroll up on the page
  #    When click on Ellipses CTA option
  #    Then List Tools screen "is" displayed
  #    And click on delete checked item
  #    And click "Ok" on list tools - prompt message
  #    #Then verify "Delete checked items" option in List Tools is in "disabled" state
  #    And click on Ellipses CTA option
  #    When click on delete all items
  #    And click "Ok" on list tools - prompt message
  #    #Then verify "Delete all items" option in List Tools is in "disabled" state
  #    When click back button in List Tools
  #    Then verify all items are deleted
  #    And the "Checked In Store" section "is not" displayed
Feature: My List - Store Aisles

  ##### Scenarios related to Store Aisles tab ########
  #C70551
  #Author: Harish
  @regression @module_mylist @module_mylist_storeaisle_tab @start_scenario
  Scenario: As a user, when i first land on the store aisle tab, by default all the category/aisles must in collapsed view and on switching tabs, the expand/collapse state must be remembered
    When sign up to the application with popup handling
    And go to Home tab
    And go to MyList tab
    And go to List Tab
    And click on category tab under my list
    And delete all items from MyList using list tool
    And add item "Bread" to MyList
    Then verify store aisle tab under my list
    And verify category tab contents in expanded view
    When collapse the expanded category in list
    And click on store aisle tab
    Then verify store aisle tab contents in expanded view
    When collapse the expanded category in list
    And click on category tab under my list
    Then verify category tab contents in collapsed view
    When click on store aisle tab
    Then verify store aisle tab contents in collapsed view

  #C70659
  #Author: Harish
  @regression @module_mylist @module_mylist_storeaisle_tab
  Scenario: As a user, In  Aisle section of list , Aisle should be sorted  based on count
    When go to MyList tab
    And go to List Tab
    And click on category tab under my list
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    And add item "Eggs" to MyList
    And add an item and deal if list is empty
    And "check" item "Milk" in MyList
    And click on store aisle tab
    Then verify store aisle list sorted based on count

  #C70542
  #Author: Harish
  @regression @module_mylist @module_mylist_storeaisle_tab
  Scenario: As a user, I should see Items and deals are added (depends on API response) in My List tab under the Store aisle tab
    When go to MyList tab
    And go to List Tab
    And click on category tab under my list
    And delete all items from MyList using list tool
    And verify category name is not displayed in my list
    And add an item and deal if list is empty
    And click on store aisle tab
    And verify category name is displayed in my list

   #C70544
  #Author: Harish
  @regression @module_mylist @module_mylist_storeaisle_tab
  Scenario: As a user, I should see the name and count of deals and items cards. User should able to expand and collapse the categories.
    When go to MyList tab
    And go to List Tab
    And click on category tab under my list
    And delete all items from MyList using list tool
    And add an item and deal if list is empty
    And click on store aisle tab
    When verify category name is displayed in my list
    Then verify product count is displayed in my list
    And expand a category
    Then verify items are listed under categories
    And verify deals are listed under categories
    Then collapse a category

  #C70545
  #Author: Harish
  @regression @module_mylist @module_mylist_storeaisle_tab
  Scenario: As a user, I should able to add the items manually and user should be able to navigate to the Items details page on tapping items card. User should be able to check and uncheck the items
    When go to MyList tab
    And go to List Tab
    And click on category tab under my list
    And delete all items from MyList using list tool
    And click on store aisle tab
    And add item "Milk" to MyList
    And add item "Eggs" to MyList
    And the "Checked - In Store Basket" section "is not" displayed
    And get and store checked-in store basket count
    When "check" item "Milk" in MyList
    Then verify checked-in store basket count is "increased" by 1
    When expand a category
    Then verify items are listed under categories
    When click on item card under categories
    Then verify item card detail page is displayed
    And click back button on edit item page
    When get and store checked-in store basket count
    And "uncheck" item "Milk" in MyList
    Then verify checked-in store basket count is "decreased" by 1

  #C70546
  #Author: Harish
  @regression @module_mylist @module_mylist_storeaisle_tab @functional
  Scenario: As a user, I should be able to navigate to the Deals details page on tapping Deals card. User should be able to check and uncheck the Deals
    Then go to MyList tab
    And go to List Tab
    And click on category tab under my list
    And delete all items from MyList using list tool
    And add an item and deal if list is empty
    And click on store aisle tab
    Then expand a category
    And verify deals are listed under categories
    When checkout a category for deals
    And uncheck a category for deals
    And click on deal card under categories
    And verify deals card detail page is displayed
    And close deal details page
    And collapse a category

    #C70547
  #Author: Harish
  @regression @module_mylist @module_mylist_storeaisle_tab
  Scenario:  As a user, I should be able to see the UI of Deals card should be as per the figma design
    When go to MyList tab
    And go to List Tab
    And click on category tab under my list
    And delete all items from MyList using list tool
    And click on deals tab
    And click 'Yes' if 'Love the app' popup is displayed
    And go to MyList tab
    And add an item and deal if list is empty
    And click on store aisle tab
    Then expand a category
    When verify deals are listed under categories
    And verify deal card header is displayed
    Then verify deal card image is displayed
    And verify deal card offer is displayed
    Then verify deal card description is displayed
    And collapse a category

  #C70548
  #Author: Harish
  @regression @module_mylist @module_mylist_storeaisle_tab
  Scenario:  As a user, I should be able to see the Loader and latest data under categories when user Pull to refresh the screen
    When go to MyList tab
    And go to List Tab
    And click on category tab under my list
    And delete all items from MyList using list tool
    And add an item and deal if list is empty
    When refresh the page and verify latest categories are displayed
    And refresh the page and verify progress spinner is displayed

  #C70549
  #Author: Harish
  @regression @module_mylist @module_mylist_storeaisle_tab
  Scenario: As a user, I should be able to see list and aisles to be sorted by alphabetical order in Store aisle screen
    When go to MyList tab
    And go to List Tab
    And click on category tab under my list
    And delete all items from MyList using list tool
    And click on deals tab
    And click 'Yes' if 'Love the app' popup is displayed
    And go to 'All Deals' Tab
    And user clips 12 number of deals in all deals screen
    And go to MyList tab
    And click on store aisle tab
    And verify categories are sorted alphabetically under my list

  #C70553
  #Author: Harish
  @regression @module_mylist @module_mylist_storeaisle_tab
  Scenario: As a user, I should see that the store aisle screen should be as per the design and respective banner
    And click on deals tab
    And click 'Yes' if 'Love the app' popup is displayed
    When go to MyList tab
    And go to List Tab
    And click on category tab under my list
    And delete all items from MyList using list tool
    And add an item and deal if list is empty
    And click on store aisle tab
    Then verify "Store Aisles" tab is selected in MyList
    Then verify category name is displayed in my list
    Then verify New item option in the my list page

  #C70661
  #Author: Harish
  @regression @module_mylist @module_mylist_storeaisle_tab
  Scenario: As a user , I should see that deals checked under Aisle  tab should be sorted alphabhetically as per deal title in ascending order
    When go to MyList tab
    And go to List Tab
    And click on category tab under my list
    And delete all items from MyList using list tool
    And add an item and deal if list is empty
    And add item "Milk" to MyList
    And add item "Eggs" to MyList
    And add a deal to MyList and store deal name
    And add a deal to MyList and store deal name
    And go to MyList tab
    And click on store aisle tab
    When check all the items and deals
    Then verify all items are checked
    When expand "Checked - In Store Basket" category
    Then verify deals and items under 'Checked - In Store Basket' are sorted alphabetically

   #C70660
  #Author: Harish
  @regression @module_mylist @module_mylist_storeaisle_tab @end_scenario
  Scenario: As a user , In Aisle section of list ,deals added should be sorted in descending order as per added date
    When go to MyList tab
    And go to List Tab
    And click on category tab under my list
    And delete all items from MyList using list tool
    And add an item and deal if list is empty
    And Add item "Butter Milk" to list
    And Add item "Horizon Milk" to list
    And Add item "Fat Free Milk" to list
    And click on store aisle tab
    And expand "Unknown, Ask for Help" category
    Then verify the list order as "Fat Free Milk", "Horizon Milk" and "Butter Milk"

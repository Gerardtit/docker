Feature: My List - most recent tab

  #### most recent tab scenarios ####
  #C70641
  @regression @module_mylist @functional @start_scenario
  Scenario: As a User, I should be able see recently added Items and deals in the my list, are added to Most recent tab
    When sign up to the application using ahem email client with popup handling
    And go to Home tab
    Then verify MyList tab "is" displayed
    When go to MyList tab
    And go to List Tab
    Then verify category tab under my list
    When click on New items
    And verify my list search page is displayed
    And search for product "Bread" on my list search page
    And click back button on my list search page
    Then verify my list page is displayed
    And go to Deals tab
    And go to 'All Deals' Tab
    When get clipped deal name
    And clip a deal to add under list
    Then go to MyList tab
    And go to List Tab
    Then verify category tab under my list
    When click on 'Most Recent' tab
    Then verify "Bread" item is added to Most Recent Tab
    And verify deal is added under Most Recent tab

  #C70642
  @regression @module_mylist
  Scenario: As a User, I should not be able see the listing of deals and items in Most recent tab
    When go to MyList tab
    And go to List Tab
    When scroll up on the page
    And click on 'Most Recent' tab
    Then verify deals and item are not listed under Most Recent tab

    #C70644
  @regression @module_mylist @functional
  Scenario: As a User, I should be able see Checked in store basket should be in default collapse view and count of items or deals in Most recent tab
    When go to MyList tab
    And go to List Tab
    And click on 'Most Recent' tab
    Then checkout a category for deals
    And checkout a category for items
    Then verify checked-In store is collapsed by default
    And verify product count is displayed in my list
    And uncheck a category for items
    And uncheck a category for deals

  #C70645
  @regression @module_mylist @functional
  Scenario: As a User, I should be able see Unchecked item sorted by 'addeddate' in descending order and checked item sorted by â€œtitleâ€� alphabetically in ascending order
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And click on 'Most Recent' tab
    And Add item "Butter Milk" to list
    And Add item "Horizon Milk" to list
    And Add item "Fat Free Milk" to list
    And expand "Dairy, Eggs & Cheese" category
    Then verify the list order as "Fat Free Milk", "Horizon Milk" and "Butter Milk"
    When check all the items and deals
    And verify list and deals are sorted alphabetically under most recent tab

  #C70655
  @regression @module_mylist
  Scenario: As a user, I should see the most recent section should be as per the design and respective banner
    When go to MyList tab
    And go to List Tab
    And click on 'Most Recent' tab
    Then verify deals are listed under categories
    And verify items are listed under categories

  #C70643
  @regression @module_mylist @functional
  Scenario: As a User, I should be able check and uncheck the Dealis or items and I should be able to edit and delete deals and items
    When go to MyList tab
    And go to List Tab
    And click on 'Most Recent' tab
    Then checkout a category for deals
    And checkout a category for items
    And uncheck a category for items
    Then uncheck a category for deals
    When set quantity of item "Bread" to 10
    Then verify item "Bread" with quantity 10 is present in MyList
    When slide the card to remove the deals from the list

   #C70663
  @regression @module_mylist
  Scenario: As a user , I should see that deals checked under Most Recent tab should be sorted alphabhetically as per deal title in ascending order
    When go to MyList tab
    And go to List Tab
    And add an item and deal if list is empty
    And click on most recent tab under list
    And check all the items and deals
    And verify all items are checked
    And expand "Checked - In Store Basket" category
    Then deals items checked under category tab should be sorted alphabetically

  #C70662
  @regression @module_mylist
  Scenario: As a user , In Most Recent section of list ,deals added should be sorted in descending order as per added date
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And Add item "Butter Milk" to list
    And Add item "Horizon Milk" to list
    And Add item "Fat Free Milk" to list
    And click on most recent tab under list
    Then verify the list order as "Fat Free Milk", "Horizon Milk" and "Butter Milk"

  #C70664
  @regression @module_mylist @end_scenario
  Scenario: As a user on App kill and relaunch or background and foreground , sorting order should be maintained
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And Add item "Butter Milk" to list
    And Add item "Horizon Milk" to list
    And Add item "Fat Free Milk" to list
    And expand "Dairy, Eggs & Cheese" category
    Then verify the list order as "Fat Free Milk", "Horizon Milk" and "Butter Milk"
    And click on store aisle tab
    And expand "Unknown, Ask for Help" category
    Then verify the list order as "Fat Free Milk", "Horizon Milk" and "Butter Milk"
    And click on most recent tab under list
    Then verify the list order as "Fat Free Milk", "Horizon Milk" and "Butter Milk"
    When keep app in background and relaunching the same
    And click on category tab under my list
    And expand "Dairy, Eggs & Cheese" category
    Then verify the list order as "Fat Free Milk", "Horizon Milk" and "Butter Milk"
    And click on store aisle tab
    And expand "Unknown, Ask for Help" category
    Then verify the list order as "Fat Free Milk", "Horizon Milk" and "Butter Milk"
    And click on most recent tab under list
    Then verify the list order as "Fat Free Milk", "Horizon Milk" and "Butter Milk"
    When kill and relaunch the application without popup handling
    And click Continue on cache pop up for "android" platform
    And handle tutorial if displayed
    And go to MyList tab
    And go to List Tab
    And expand "Dairy, Eggs & Cheese" category
    Then verify the list order as "Fat Free Milk", "Horizon Milk" and "Butter Milk"
    And click on store aisle tab
    And expand "Unknown, Ask for Help" category
    Then verify the list order as "Fat Free Milk", "Horizon Milk" and "Butter Milk"
    And click on most recent tab under list
    Then verify the list order as "Fat Free Milk", "Horizon Milk" and "Butter Milk"

 #C70518
  @regression @module_mylist  @start_scenario
  Scenario: Verify the name of My Items tab and navigation title is updated to My List when myList feature flag is turned ON
    When sign up to the application using ahem email client with popup handling
    And go to Home tab
    Then verify MyList tab "is" displayed
    When go to MyList tab
    Then verify MyList page is displayed

  #C70466
  @regression @module_mylist @functional
  Scenario: As a user I Should see the navigation bar under the 'My List'  tab bar
    Then go to MyList tab
    And go to List Tab
    Then verify category tab under my list is selected by default

  #C70494
  @regression @module_mylist
  Scenario: As a user, I should able to see List tab under My list navigation bar and land on Clipped deals by default
    Then verify MyList tab "is" displayed
    When go to Home tab
    And click on shopping mode down arrow
    And select the pick-up store
    When kill and relaunch the application without popup handling
    And click Continue on cache pop up
    And handle tutorial if displayed
    And go to MyList tab
    Then verify user is in "Clipped deals" tab in MyList
    When kill and relaunch the application without popup handling
    And click Continue on cache pop up
    And handle tutorial if displayed
    And go to MyList tab
    Then verify user is in "Clipped deals" tab in MyList
    When keep app in background and relaunching the same
    Then verify user is in "Clipped deals" tab in MyList

   #C70501
  @regression @module_mylist
  Scenario: As a user, I should able to see the My List tab section as per the design and respective banner
    Then verify MyList tab "is" displayed
    And go to MyList tab
    Then verify search icon is displayed
    And verify My Cart icon is displayed
    And verify my list page is displayed
    And verify tabs and their order in MyList page

  #C70490
  @regression @module_mylist @end_scenario
  Scenario: As a User, I should be able to see screen retaining its state on keeping the app background and getting forefront
    When go to MyList tab
    And go to List Tab
    And click on Ellipses CTA option
    Then List Tools screen "is" displayed
    And move app to background and then bring it to foreground
    Then List Tools screen "is" displayed
    And click back button in List Tools

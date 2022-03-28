Feature: My List - list tab

  #C70518
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab @start_scenario
  Scenario: Verify the name of My Items tab and navigation title is updated to My List when myList feature flag is turned ON
    When sign up to the application with popup handling
    And go to Home tab
    Then verify MyList tab "is" displayed
    When go to MyList tab
    Then verify MyList page is displayed

  #C70466
  #Author: Harish
  @regression @module_mylist @functional @module_mylist_list_tab
  Scenario: As a user I Should see the navigation bar under the 'My List'  tab bar
    Then go to MyList tab
    And go to List Tab
    Then verify category tab under my list is selected by default

  #C70494
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab
  Scenario: As a user, I should able to see List tab under My list navigation bar and land on Clipped deals by default
    Then verify MyList tab "is" displayed
    When go to Home tab
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
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab
  Scenario: As a user, I should able to see the My List tab section as per the design and respective banner
    Then verify MyList tab "is" displayed
    And go to MyList tab
    Then verify search icon is displayed
    And verify My Cart icon is displayed
    And verify my list page is displayed
    And verify tabs and their order in MyList page

  #C70490
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab
  Scenario: As a User, I should be able to see screen retaining its state on keeping the app background and getting forefront
    When go to MyList tab
    And go to List Tab
    And click on Ellipses CTA option
    Then List Tools screen "is" displayed
    And move app to background and then bring it to foreground
    Then List Tools screen "is" displayed
    And click back button in List Tools

   #C70596
  #Author: Harish
  @regression @functional @module_mylist @module_mylist_list_tab
  Scenario: Verify Email list button is disabled when there are zero items+deals count in the list
    And go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And click on Ellipses CTA option
    Then verify "Email list" option in List Tools is in "disabled" state
    And click back button in List Tools

   #C70608
  #Author: Harish
  @regression @functional @module_mylist @module_mylist_list_tab
  Scenario: As a User, I should be able navigate to the List Tool screen on clicking Ellipses(...) on the navigation bar of my list and I should see the List Tools screen should be as per the figma design
    When go to MyList tab
    And go to List Tab
    And click on Ellipses CTA option
    Then verify header in list tools screen
    And verify back button in list tools screen
    And verify List Tools screen options displayed with defined ordering
    And click back button in List Tools

  #C70597
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab  @functional
  Scenario: Verify Email list button is enabled when there are more than or equal to 1 items+deals count in the list.
    And go to MyList tab
    And go to List Tab
    And add an item and deal if list is empty
    And click on Ellipses CTA option
    Then verify "Email list" option in List Tools is in "enabled" state
    And click back button in List Tools

  #C70599
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab  @functional
  Scenario: Verify sync loader is shown and the native mailbox is opened when the user taps on the Email list
    When go to MyList tab
    And go to List Tab
    And add an item and deal if list is empty
    And click on Ellipses CTA option
    And click "Email list" from List Tools options
    And select email app from share options based on platform
    And discard email with MyList based on platform
    Then verify Ellipses under my list

  #C70600
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab  @functional
  Scenario: Verify the Email details when the user taps on the Email list
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add an item and deal if list is empty
    And go to MyList tab
    And get and store categories, items and deals from MyList
    And click on Ellipses CTA option
    And click "Email list" from List Tools options
    And select email app from share options based on platform
    Then verify email details
    Then verify Ellipses under my list

  #C70613
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab  @functional
  Scenario: As a user, I should be able to navigate back to the list screen once sending or cancelling the email.and I should navigate to the list screen on clicking Back button on list tools screen.
    When go to MyList tab
    And go to List Tab
    And add an item and deal if list is empty
    And click on Ellipses CTA option
    And click "Email list" from List Tools options
    And select email app from share options based on platform
    And discard email with MyList based on platform
    Then verify Ellipses under my list
    And click on Ellipses CTA option
    When click "Email list" from List Tools options
    And select email app from share options based on platform
    And send email with MyList based on platform
    Then verify Ellipses under my list

  #C70502
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab  @functional
  Scenario: As a user I Should see the 'My List' tab and other elements in the screen as per Figma/UI.
    Then go to MyList tab
    And go to List Tab
    Then verify category tab under my list
    Then verify Ellipses under my list

  #C70475
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab  @functional
  Scenario: As a User, I should be able to see 'New Items' CTA on my list tab screen and User should navigate to 'My list search screen' on clicking New item CTA.
    Then go to MyList tab
    And go to List Tab
    And verify New items button
    When click on New items
    Then verify my list search page is displayed
    And click back button on my list search page

  #C70476
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab  @functional
  Scenario: As a User, I should be able to see list of search result on searching items and The keyboard should be up and It should have the next button.
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    When click on New items
    And click on search field in my list search page
    Then enter text "Beer" in my list search page
    And verify search result is displayed on my list page
    Then verify keyboard is opened
    And click back button on my list search page

  #C70477
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab  @functional
  Scenario: As a User, I should be able to add the item to list when i click Next in keyboard and on tapping the searched item list.
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    When click on New items
    And click on search field in my list search page
    And enter text "Cereal" in my list search page
    And verify search result is displayed on my list page
    And select first item from search result in my list page
    And click back button on my list search page
    Then verify item "Cereal" "is" present in MyList

  #C70478
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab  @functional
  Scenario: As a User, I should be able to see 'Item added to your list' toast message once item is added and user should navigate to list tab screen when i click on Back button
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    When click on New items
    And click on search field in my list search page
    Then enter text "Beer" in my list search page
    Then select first item from search result in my list page
    Then verify "Item added to your list" toast message
    And click back button on my list search page
    Then verify MyList page is displayed
    And verify New items button

  #C70513
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab
  Scenario: As a User, I should be able to see entered text on search tab when I perform Background and foreground the app and Entered text should be deleted on tapping ''X'' (cancel) button
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    When click on New items
    Then verify my list search page is displayed
    And enter text "Beer" in my list search page
    Then keep app in background and relaunching the same
    And click text clear button on search field in my list search page
    Then verify text is cleared at my list search
    And click back button on my list search page

  #C70460
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab
  Scenario: As a user I Should be able to see the 'Checked- In Store Basket' section category/ Store Aisle
    And go to Home tab
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    And add a deal to MyList and store deal name
    And click 'Yes' if 'Love the app' popup is displayed
    When go to MyList tab
    And the "Checked - In Store Basket" section "is not" displayed
    And get and store checked-in store basket count
    When "check" item "Milk" in MyList
    Then verify checked-in store basket count is "increased" by 1
    And get and store checked-in store basket count
    When "check" the deal in MyList
    Then verify checked-in store basket count is "increased" by 1
    And get and store checked-in store basket count
    When "uncheck" item "Milk" in MyList
    Then verify checked-in store basket count is "decreased" by 1
    And get and store checked-in store basket count
    When "uncheck" the deal in MyList
    Then verify checked-in store basket count is "decreased" by 1
    And the "Checked - In Store Basket" section "is not" displayed


  #C70577
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab  @functional
  Scenario: As a user I Should be able to Delete Checked in items
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    And add a deal to MyList and store deal name
    When go to MyList tab
    And get and store checked-in store basket count
    When "check" the deal in MyList
    Then verify checked-in store basket count is "increased" by 1
    When click on Ellipses CTA option
    And click on delete checked item
    And click "Cancel" on list tools - prompt message
    Then verify item "Milk" "is" present in MyList
    When click on Ellipses CTA option
    And click on delete checked item
    And click "Ok" on list tools - prompt message
    And click on Ellipses CTA option
    Then verify "Delete checked items" option in List Tools is in "disabled" state
    When click back button in List Tools
    Then verify item "Milk" "is" present in MyList
    And the "Checked - In Store Basket" section "is not" displayed

  #C70604
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab  @functional
  Scenario: As a user I Should be able to Delete Checked in items when only checked in items are available
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add an item and deal if list is empty
    And check all the items and deals
    And verify all items are checked
    And click on Ellipses CTA option
    When click on delete checked item
    And click "CANCEL" on list tools - prompt message
    And click on Ellipses CTA option
    Then click on delete checked item
    And click "Ok" on list tools - prompt message
    And click on Ellipses CTA option
    Then verify "Delete checked items" option in List Tools is in "disabled" state
    And click back button in List Tools

  #C70605
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab  @functional
  Scenario: As a user I Should be able to Delete All items
    When go to MyList tab
    And go to List Tab
    And add an item and deal if list is empty
    And click on Ellipses CTA option
    Then List Tools screen "is" displayed
    When click on delete all items
    And click "CANCEL" on list tools - prompt message
    And click on Ellipses CTA option
    When click on delete all items
    And click "Ok" on list tools - prompt message
    When click back button in List Tools
    Then verify all items are deleted

  #C70578
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab  @functional
  Scenario: As a user I Should be able to Delete All items when only unchecked items or Only checked in item are available
    When go to MyList tab
    And go to List Tab
    And add item "Milk" to MyList
    And add item "Eggs" to MyList
    And click on Ellipses CTA option
    And click on delete all items
    And click "Ok" on list tools - prompt message
    Then verify my list screen is in empty state having zero items and deals in the list
    And click on Ellipses CTA option
    Then verify "Uncheck all items" option in List Tools is in "disabled" state
    And verify "Delete all items" option in List Tools is in "disabled" state
    And verify "Delete checked items" option in List Tools is in "disabled" state
    And verify "Email list" option in List Tools is in "disabled" state
    And verify "Sync" option in List Tools is in "enabled" state
    And click back button in List Tools
    When add item "Milk" to MyList
    And add item "Eggs" to MyList
    And click on Ellipses CTA option
    Then verify "Uncheck all items" option in List Tools is in "disabled" state
    And verify "Delete all items" option in List Tools is in "enabled" state
    And verify "Delete checked items" option in List Tools is in "disabled" state
    And verify "Email list" option in List Tools is in "enabled" state
    And verify "Sync" option in List Tools is in "enabled" state
    And click back button in List Tools
    When "check" item "Milk" in MyList
    And "check" item "Eggs" in MyList
    And click on Ellipses CTA option
    Then verify "Uncheck all items" option in List Tools is in "enabled" state
    And verify "Delete checked items" option in List Tools is in "enabled" state
    And verify "Sync" option in List Tools is in "enabled" state

  #C70581
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab
  Scenario: UI validation for the 'Delete Checked items' and 'Delete All Items'.
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    And add item "Eggs" to MyList
    And "check" item "Milk" in MyList
    And click on Ellipses CTA option
    And click "Uncheck all items" from List Tools options
    Then verify the alert when user clicks on "Uncheck all items" from list tools
    And click "Cancel" on list tools - prompt message
    When click on Ellipses CTA option
    And click "Delete checked items" from List Tools options
    Then verify the alert when user clicks on "Delete checked items" from list tools
    And click "Cancel" on list tools - prompt message
    When click on Ellipses CTA option
    And click "Delete all items" from List Tools options
    Then verify the alert when user clicks on "Delete all items" from list tools
    And click "Cancel" on list tools - prompt message

  #C70481
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab
  Scenario: As a User, I should be able to see 'Ellipses' CTA on navigation bar in My List
    When go to MyList tab
    Then go to List Tab
    And delete all items from MyList using list tool
    Then Ellipses CTA on navigation bar in My List "is" displayed

  #C70482
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab
  Scenario: As a User, I should be able to navigate to 'List Tools' screen on clicking Ellipses
    When go to MyList tab
    Then go to List Tab
    When click on Ellipses CTA option
    Then List Tools screen "is" displayed
    And click back button in List Tools

  #C70534
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab
  Scenario: As a User, I should be able to navigate to 'List Tools' screen on clicking Ellipses the navigation bar and see the the list of items in List Tools
    When go to MyList tab
    Then go to List Tab
    When click on Ellipses CTA option
    Then verify List Tools screen options displayed with defined ordering
    And click back button in List Tools

  #C70485
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab
  Scenario: As a User, I should navigate back to List tab of My list on clicking on sync with activity indicator till screen is loaded
    When go to MyList tab
    Then go to List Tab
    When click on Ellipses CTA option
    And click "Sync" from List Tools options
    Then verify user is landed on "List" section in My List

  #C70486
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab
  Scenario: As a User, I should be able to see 'Uncheck all items' , 'Delete all items', 'Email list' in disabled state
    When go to MyList tab
    Then go to List Tab
    When click on Ellipses CTA option
    Then verify "Uncheck all Items" option in List Tools is in "disabled" state
    Then verify "Delete checked items" option in List Tools is in "disabled" state
    Then verify "Delete all items" option in List Tools is in "disabled" state
    Then verify "Email list" option in List Tools is in "disabled" state
    And click back button in List Tools

  #C70488
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab
  Scenario: As a User, I should navigate to 'List' tab in 'My list' on clicking on 'Back' icon from List Tools screen
    When go to MyList tab
    Then go to List Tab
    When click on Ellipses CTA option
    And click back button in List Tools
    Then verify user is landed on "List" section in My List

  #C70489
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab
  Scenario: As a User, I should be able to see List Tools UI as per figma design
    When go to MyList tab
    Then go to List Tab
    And click on Ellipses CTA option
    Then List Tools screen "is" displayed
    Then verify List Tools screen options displayed with defined ordering
    And click back button in List Tools

  #C70586
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab  @functional
  Scenario: Verify a scan button is displayed on the search screen of my list
    Then go to MyList tab
    And go to List Tab
    When click on New items
    Then verify scan button in search page inside MyList Screen
    Then click back button on my list search page

  #C70587
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab  @functional
  Scenario: Verify the scan screen is displayed when user taps on the scan button
    Then go to MyList tab
    And go to List Tab
    When click on New items
    Then click on scan button in search page inside MyList Screen
    And click allow on camera permission popup
    And click get started on tutorials
    Then verify scan screen is displayed in My List Screen
    Then click close icon on scan screen
    Then click back button on my list search page

  #C70588
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab  @functional
  Scenario: Verify user is navigated back to add a manual item screen when back/close button is tapped on the scan screen
    Then go to MyList tab
    And go to List Tab
    When click on New items
    Then click on scan button in search page inside MyList Screen
    Then verify scan screen is displayed in My List Screen
    Then click close button in Scan Screen
    Then verify the add manual item Screen in My List Screen
    Then click back button on my list search page

  #C70540
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab
  Scenario: As a User, i should see that after unchecking all the items/deals, or if there are no deal in the Checked in store basket the 'Uncheck all items' and 'Delete all checked items' options must be disabled/greyed out
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    And add item "Eggs" to MyList
    And get and store checked-in store basket count
    And "check" item "Milk" in MyList
    Then verify checked-in store basket count is "increased" by 1
    When click on Ellipses CTA option
    Then verify "Uncheck all Items" option in List Tools is in "enabled" state
    And verify "Delete checked items" option in List Tools is in "enabled" state
    When click uncheck all items from list tools
    And click "Ok" on uncheck all items - prompt message
    And click on Ellipses CTA option
    Then verify "Uncheck all Items" option in List Tools is in "disabled" state
    And verify "Delete checked items" option in List Tools is in "disabled" state
    And click back button in List Tools

  #C70573
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab
  Scenario: As a User, i should see that the prompt message shown to the user works as expected and unchecked/checked state is retained after background foreground, switching tabs and killing and relaunching the app
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    And add item "Eggs" to MyList
    And "check" item "Milk" in MyList
    And scroll up till top in MyList categories
    When click on Ellipses CTA option
    Then verify "Uncheck all Items" option in List Tools is in "enabled" state
    Then verify "Delete checked items" option in List Tools is in "enabled" state
    And click uncheck all items from list tools
    And click "Cancel" on uncheck all items - prompt message
    And keep app in background and relaunching the same
    When click on Ellipses CTA option
    Then verify "Uncheck all Items" option in List Tools is in "enabled" state
    Then verify "Delete checked items" option in List Tools is in "enabled" state
    And kill and relaunch the application without popup handling
    And click Continue on cache pop up
    And handle tutorial if displayed
    And go to MyList tab
    And go to List Tab
    When click on Ellipses CTA option
    Then verify "Uncheck all Items" option in List Tools is in "enabled" state
    Then verify "Delete checked items" option in List Tools is in "enabled" state
    And click uncheck all items from list tools
    And click "Ok" on uncheck all items - prompt message
    And keep app in background and relaunching the same
    When click on Ellipses CTA option
    Then verify "Uncheck all Items" option in List Tools is in "disabled" state
    Then verify "Delete checked items" option in List Tools is in "disabled" state
    And kill and relaunch the application without popup handling
    And click Continue on cache pop up
    And handle tutorial if displayed
    And go to MyList tab
    And go to List Tab
    When click on Ellipses CTA option
    Then verify "Uncheck all Items" option in List Tools is in "disabled" state
    Then verify "Delete checked items" option in List Tools is in "disabled" state

  #C70658
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab
  Scenario: As a user , I should see that deals checked under category tab should be sorted alphabhetically as per deal title in ascending order
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    And add item "Eggs" to MyList
    And add a deal to MyList and store deal name
    And go to MyList tab
    And check all the items and deals
    And verify all items are checked
    And expand "Checked - In Store Basket" category
    Then verify deals and items under 'Checked - In Store Basket' are sorted alphabetically

   #C70657
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab
  Scenario: As a user ,  In  category section of list ,deals added should be sorted  in descending order as per added date
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And Add item "Butter Milk" to list
    And Add item "Horizon Milk" to list
    And Add item "Fat Free Milk" to list
    Then verify the list order as "Fat Free Milk", "Horizon Milk" and "Butter Milk"

  #C70666
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab
  Scenario: As a user I Should be able to see 'Aisle Feedback' option in the item details.
    Then go to MyList tab
    And go to List Tab
    And add an item and deal if list is empty
    Then verify items are listed under categories
    And click on item card under categories
    Then verify item card detail page is displayed
    And verify Aisle feedback option is displayed

  #C70667
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab  @functional
  Scenario: As a user I Should be redirected 'Feedback Listing' screen after clicking on 'Aisle Feedback'
    Then go to MyList tab
    And go to List Tab
    And add an item and deal if list is empty
    Then verify items are listed under categories
    And click on item card under categories
    Then verify item card detail page is displayed
    And verify Aisle feedback option is displayed
    Then click on Aisle feedback option
    And verify Aisle feedback listing page is displayed

  #C70668
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab  @functional
  Scenario: As a user I Should see the message after submitting the feedback
    Then go to MyList tab
    And go to List Tab
    And add an item and deal if list is empty
    Then verify items are listed under categories
    And click on item card under categories
    Then verify item card detail page is displayed
    And verify Aisle feedback option is displayed
    Then click on Aisle feedback option
    And verify Aisle feedback listing page is displayed
    Then click on "Out of stock" Aisle Feedback
    And verify item card detail page is displayed

  #C70669
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab
  Scenario: As a user I Should see 'Feedback Listing' screen should be retained when app is backgrounded and foregrounded
    Then go to MyList tab
    And go to List Tab
    And add an item and deal if list is empty
    Then verify items are listed under categories
    And click on item card under categories
    Then verify item card detail page is displayed
    And verify Aisle feedback option is displayed
    Then click on Aisle feedback option
    And verify Aisle feedback listing page is displayed
    Then keep app in background and relaunching the same
    And verify Aisle feedback listing page is displayed

  #C70672
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab
  Scenario: As a user I Should see the listed elements in the 'Feedback' listing screen according to UI.
    Then go to MyList tab
    And go to List Tab
    And add an item and deal if list is empty
    Then verify items are listed under categories
    And click on item card under categories
    Then verify item card detail page is displayed
    And verify Aisle feedback option is displayed
    Then click on Aisle feedback option
    And verify Aisle feedback listing page is displayed
    Then verify back button in Aisle feedback page

  #C70636
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab  @functional
  Scenario:Verify the empty state in the list screen when there are 0 items+ deals counts in the list
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    Then verify my list screen is in empty state having zero items and deals in the list

  #C70637
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab  @functional
  Scenario:Verify the empty state is not displayed in the list screen when there is 1 item in the list
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    Then verify item "Milk" "is" present in MyList
    And verify my list screen is not in empty state having 1 item in the list

  #C70638
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab  @functional
  Scenario:Verify the empty state is not displayed in the list screen when there is 1 deal in the list
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add a deal to MyList and store deal name
    And go to MyList tab
    Then verify my list screen is not in empty state having 1 deal in the list

  #C70639
  #Author: Harish
  @regression @module_mylist @module_mylist_list_tab  @functional @end_scenario
  Scenario:Verify the empty state is not displayed in the list screen when there are more than 1 items+deals in the list
    Given click 'Yes' if 'Love the app' popup is displayed
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add an item and deal if list is empty
    Then verify my list screen is not in empty state having more than one item and more than one deal in the list

Feature: My List - list_Network offline scenarios

  #C70692
  #Author: Harish
  @regression @module_mylist @module_mylist_offline_scenarios @functional @start_scenario @network_scenario
  Scenario: As a User, I should not be allowed to clip deals in offline mode
    When sign up to the application with popup handling
    And go to Home tab
    And go to Deals tab
    And go to 'All Deals' Tab
    When turn "OFF" internet and relaunch app
    And user clicks ok on network error popup
    And click Clip button on deal
    Then verify error message "is" displayed when user tries to clip a deal while being offline
    When turn "ON" internet and relaunch app
    And user clicks ok on network error popup

  #C70682
  #Author: Harish
  @regression @module_mylist @module_mylist_offline_scenarios @functional @network_scenario
  Scenario: As a user, i should be able to see that resync happens when app comes to foreground
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    And add item "Bread" to MyList
    When turn "OFF" internet and relaunch app
    And user clicks ok on network error popup
    And add item "Eggs" to MyList
    And remove item "Milk" from MyList
    Then verify item "Milk" "is not" present in MyList
    When set quantity of item "Bread" to 20
    Then verify item "Bread" with quantity 20 is present in MyList
    And launch settings app to move app under test to background
    When turn "ON" internet and relaunch app
    And user clicks ok on network error popup
    And verify item "Milk" "is not" present in MyList
    And verify item "Eggs" "is" present in MyList
    And verify item "Bread" with quantity 20 is present in MyList

  #C70693
  #Author: Harish
  @regression @module_mylist @module_mylist_offline_scenarios @functional @network_scenario
  Scenario: As a user, i should be able to see that resync happens when list screen is viewed
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    And add item "Bread" to MyList
    When turn "OFF" internet and relaunch app
    And user clicks ok on network error popup
    And add item "Eggs" to MyList
    And remove item "Milk" from MyList
    Then verify item "Milk" "is not" present in MyList
    When set quantity of item "Bread" to 10
    Then verify item "Bread" with quantity 10 is present in MyList
    When click on deals tab
    When turn "ON" internet and relaunch app
    And user clicks ok on network error popup
    And user clicks ok on network error popup
    And go to MyList tab
    Then verify item "Milk" "is not" present in MyList
    And verify item "Eggs" "is" present in MyList
    And verify item "Bread" with quantity 10 is present in MyList

  #C70684
  #Author: Harish
  @regression @module_mylist @module_mylist_offline_scenarios @functional @network_scenario
  Scenario: As a user, i should be able to see empty state image if i delete all the items in offline mode
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    When turn "OFF" internet and relaunch app
    And user clicks ok on network error popup
    And delete all items from MyList using list tool
    Then verify my list screen is in empty state having zero items and deals in the list
    When turn "ON" internet and relaunch app
    And user clicks ok on network error popup

  #C70633
  #Author: Harish
  @regression @module_mylist @module_mylist_offline_scenarios @functional @network_scenario
  Scenario: As a User, I be able to load my list screen, add items,remove deals/items and modiify items in the list in offline mode and resync it successfully
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    And add item "Bread" to MyList
    When turn "OFF" internet and relaunch app
    And user clicks ok on network error popup
    And add item "Eggs" to MyList
    And remove item "Milk" from MyList
    Then verify item "Milk" "is not" present in MyList
    When set quantity of item "Bread" to 10
    Then verify item "Bread" with quantity 10 is present in MyList
    When turn "ON" internet and relaunch app
    And user clicks ok on network error popup
    And click on deals tab
    And go to MyList tab
    Then verify item "Milk" "is not" present in MyList
    And verify item "Eggs" "is" present in MyList
    And verify item "Bread" with quantity 10 is present in MyList

  #C70634
  #Author: Harish
  @regression @module_mylist @module_mylist_offline_scenarios @functional @network_scenario
  Scenario: As a User, I be able to check or uncheck any item/deal and do the list tools screen operation in offline mode and sync it successfully
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    And add item "Bread" to MyList
    And get and store checked-in store basket count
    And "check" item "Milk" in MyList
    Then verify checked-in store basket count is "increased" by 1
    When turn "OFF" internet and relaunch app
    And user clicks ok on network error popup
    And get and store checked-in store basket count
    When uncheck all items from MyList using list tool
    Then verify checked-in store basket count is "decreased" by 1
    And get and store checked-in store basket count
    When "check" item "Bread" in MyList
    Then verify checked-in store basket count is "increased" by 1
    And get and store checked-in store basket count
    When "uncheck" item "Bread" in MyList
    Then verify checked-in store basket count is "decreased" by 1
    When delete all items from MyList using list tool
    Then verify item "Milk" "is not" present in MyList
    And verify item "Bread" "is not" present in MyList
    When turn "ON" internet and relaunch app
    And user clicks ok on network error popup
    And click on Ellipses CTA option
    And click "Sync" from List Tools options
    Then verify item "Milk" "is not" present in MyList
    And verify item "Bread" "is not" present in MyList

  #C70635
  #Author: Harish
  @regression @module_mylist @module_mylist_offline_scenarios @functional @network_scenario
  Scenario: As a User, I be able to check or uncheck any item/deal and do the list tools screen operation in offline mode and resync it successfully
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add item "Milk" to MyList
    And add item "Bread" to MyList
    And get and store checked-in store basket count
    And "check" item "Milk" in MyList
    Then verify checked-in store basket count is "increased" by 1
    When turn "OFF" internet and relaunch app
    And user clicks ok on network error popup
    And get and store checked-in store basket count
    When uncheck all items from MyList using list tool
    Then verify checked-in store basket count is "decreased" by 1
    And get and store checked-in store basket count
    When "check" item "Bread" in MyList
    Then verify checked-in store basket count is "increased" by 1
    And get and store checked-in store basket count
    When "uncheck" item "Bread" in MyList
    Then verify checked-in store basket count is "decreased" by 1
    When delete all items from MyList using list tool
    Then verify item "Milk" "is not" present in MyList
    And verify item "Bread" "is not" present in MyList
    When turn "ON" internet and relaunch app
    And user clicks ok on network error popup
    And click on deals tab
    And go to MyList tab
    Then verify item "Milk" "is not" present in MyList
    And verify item "Bread" "is not" present in MyList

  #C70654
  #Author: Harish
  @regression @module_mylist @module_mylist_offline_scenarios @functional @network_scenario
  Scenario: As a user, I should be able to see error message with a pop up on network and API failure
    When go to MyList tab
    And go to List Tab
    And click on most recent tab under list
    And turn "OFF" internet and relaunch app
    And user clicks ok on network error popup
    And user pulls the screen down to refresh
    Then verify network error pop up is displayed for "ANDROID" platform
    And turn "ON" internet and relaunch app
    And user clicks ok on network error popup

  #C70671
  #Author: Harish
  @regression @module_mylist @module_mylist_offline_scenarios @network_scenario @end_scenario
  Scenario: As a user I Should see the error message when Network is not available
    When go to MyList tab
    And go to List Tab
    And delete all items from MyList using list tool
    And add an item and deal if list is empty
    Then verify items are listed under categories
    And click on item card under categories
    Then verify item card detail page is displayed
    And verify Aisle feedback option is displayed
    Then click on Aisle feedback option
    And verify Aisle feedback listing page is displayed
    When turn "OFF" internet and relaunch app
    And user clicks ok on network error popup
    And click on "Out of stock" Aisle Feedback
    Then verify error message is displayed when user tries to submit aisle feedback with internet off
    And turn "ON" internet and relaunch app
    And user clicks ok on network error popup
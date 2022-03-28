Feature: My List
#-----------------------MOVED TO ANOTHER FEATURE TO OPTIMISED-----------------------------
#  #C70518
#  @regression @module_mylist  @start_scenario
#  Scenario: Verify the name of My Items tab and navigation title is updated to My List when myList feature flag is turned ON
#    When sign up to the application using ahem email client with popup handling
#    And go to Home tab
#    Then verify MyList tab "is" displayed
#    When go to MyList tab
#    Then verify MyList page is displayed
#
#  #C70466
#  @regression @module_mylist @functional
#  Scenario: As a user I Should see the navigation bar under the 'My List'  tab bar
#    Then go to MyList tab
#    And go to List Tab
#    Then verify category tab under my list is selected by default
#
#  #C70494
#  @regression @module_mylist
#  Scenario: As a user, I should able to see List tab under My list navigation bar and land on Clipped deals by default
#    Then verify MyList tab "is" displayed
#    When go to Home tab
#    And click on shopping mode down arrow
#    And select the pick-up store
#    When kill and relaunch the application without popup handling
#    And click Continue on cache pop up
#    And handle tutorial if displayed
#    And go to MyList tab
#    Then verify user is in "Clipped deals" tab in MyList
#    When kill and relaunch the application without popup handling
#    And click Continue on cache pop up
#    And handle tutorial if displayed
#    And go to MyList tab
#    Then verify user is in "Clipped deals" tab in MyList
#    When keep app in background and relaunching the same
#    Then verify user is in "Clipped deals" tab in MyList
#
#   #C70501
#  @regression @module_mylist
#  Scenario: As a user, I should able to see the My List tab section as per the design and respective banner
#    Then verify MyList tab "is" displayed
#    And go to MyList tab
#    Then verify search icon is displayed
#    And verify My Cart icon is displayed
#    And verify my list page is displayed
#    And verify tabs and their order in MyList page
#
#  #C70490
#  @regression @module_mylist @end_scenario
#  Scenario: As a User, I should be able to see screen retaining its state on keeping the app background and getting forefront
#    When go to MyList tab
#    And go to List Tab
#    And click on Ellipses CTA option
#    Then List Tools screen "is" displayed
#    And move app to background and then bring it to foreground
#    Then List Tools screen "is" displayed
#    And click back button in List Tools


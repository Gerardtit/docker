@shop_cart
Feature: Shop Cart Feature

  Background: setup user on Home Page
    When navigate to home page
    Then home page is displayed
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user empty shopping cart
    Then shopping cart empty page is displayed
    When user clicks navigate back to the previous page
    Then home page is displayed

  @regression
  Scenario: Add item, and verify update Qty from Qty field, and remove item
    When user clicks search bar on home page
    And user types "baby lotion" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    Then shopping cart shows 10 as total number
    And checkout button is enabled on the shopping cart
    And estimation total information icon is displayed
    When scroll down the screen
    Then cart summary is displayed on the shopping cart page
    When user empty shopping cart
    Then shopping cart empty page is displayed

  @regression
  Scenario: Add deal item, and verify update Qty from Qty field, and remove item
    When user clicks search bar on home page
    And user types "baby lotion" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks deals toggle switch on the search page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user increase the all item quantity by 1 on shopping cart page
    Then shopping cart shows 2 as total number
    When user decrease the all item quantity by 1 on shopping cart page
    Then shopping cart shows 1 as total number
    When scroll down the screen
    And Estimated Savings information icon is displayed on shopping cart page
    When user swipe left to remove all item in shopping cart
    Then shopping cart empty page is displayed

  @regression
  Scenario: Verify Global substitution option is enabled/check all/Uncheck all/add new items
    When user clicks search bar on home page
    And user types "baby lotion" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And "Substitution Preference" text is displayed on the screen
    When user clicks global substitution checkbox on shopping cart page
    Then global substitution checkbox is enabled
    And All item substitution checkbox is enabled
    When user clicks global substitution checkbox on shopping cart page
    Then global substitution checkbox is disabled
    And All item substitution checkbox is disabled

  @regression
  Scenario: Item Preferences, Note to Personal Shopper
    When user clicks search bar on home page
    And user types "baby lotion" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user clicks "Item Preferences" text on page
    And scroll down the screen
    Then "Note to Personal Shopper" text is displayed on the screen
    And "Same brand" text is displayed on the screen
    And "Same size" text is displayed on the screen
    And No Substitution text is displayed on the screen

  @regression
  Scenario: verify prop 65 warning for california state
    When user clicks search bar on home page
    And user types "non alcoholic beer" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And "Prop 65 WARNING" text is displayed on the screen for California banner


  @smoke @regression
  Scenario: take users to cart after changing shopping method verification
    When user set up in store mode on home page
    And user types "milk" on search bar and click search on home page and enter first milk
    When user handle the toggle to access search page
    When user add first milk on search page
    When user click on shopping cart button on homepage
    When user tabs on change shopping method
    When user click on zip code right arrow button
    When user click on pick up option
    When user click on start shopping button
    When user verify cart page is displayed





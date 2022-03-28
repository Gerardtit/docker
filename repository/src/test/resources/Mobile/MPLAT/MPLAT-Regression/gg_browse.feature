Feature: Browse Tab

  
  #C66983
  @regression @start_scenario
  Scenario: As a User, i should be able to reach browse tab on clicking the see all button of Browse categories module in dashboard page and expand, collapse the tabs in browse screen
    When sign in to the application
    When go to Home tab
    And select the pick-up store
    And go to browse tab
    And verify navigated to browse tab
    And scroll down to categories list in browse tab
    Then verify all the categories
    And click on expand option for categories
    Then verify that the category is Expandable
    And Collapse the Browse category
    Then verify all the categories are collapsed

#  C66989
  @regression
  Scenario: As a User, i should be able to add the product to cart and I should see that the cart value gets incremented/decremented as and when we add or remove the products from the product detail page
    When go to Home tab
    And search a product on home page
    Then verify products listing page displayed
#    And add a product on product details page
    And get count of items from cart
    Then item should be added to the cart
    And get count of items from cart
    When user adds the item to cart using the '+' icon on product details page
    Then item should be added to the cart
    And get count of items from cart
    When user removes the item to cart using the '-' icon on product details page
    Then item should be removed from the cart
    And click on My Cart Icon
    And clear cart items
    And click on close button on my cart screen
#  When Verify Click back arrow takes the user to home page and should retain position
    And click cancel button on product search page

##  C66955
  @regression
  Scenario: As a user, I should see all the categories/Sub categories are collapsed and I should navigate to the browse screen on tapping the browse tab from navigation bar
    And go to browse tab
#    When verify navigated to browse tab
    And scroll down to categories list in browse tab
    Then verify all the categories are collapsed
#    When verify expand option for categories
    And click on expand option for categories
    Then verify expand option for sub categories

  #C66998
  @regression
  Scenario: As a user, I should to see "Browse" in Navigation Bar and I should be able to navigate to Browse Page from Browse Tab
    When click on home tab
    And select the delivery store
    And verify delivery shopping mode is selected
    And go to browse tab
    Then verify page with "Shop" title is displayed

#  C66994
  @regression
  Scenario: As a user, i should see that Product detail page is as per the design and as per the respective theme
    When go to browse tab
    And scroll down to categories list in browse tab
    And click on expand option for categories
#    And user expands category "Beverages" on category list
    When user clicks item "Coffee" on aisle list
    And user clicks item "Coffee - Ground" on aisle list
    When add a product on product details page
    Then verify product details page is displayed

#  #C66959
  @regression
  Scenario: As a user, i should see that the font and design on browse screen is as per the UI
    When go to browse tab
    And scroll down to categories list in browse tab
    And click on expand option for categories
#    Then verify expand option for sub categories
    And click on expand option for sub categories
    Then verify sub categories are displayed

#  #C66990
  @regression
  Scenario: As a User, i should see that on keeping the app in the background and getting it to the forefront, the cart value remains the same
    When go to Home tab
    And search a product on home page
    Then verify products listing page displayed
    And get count of items from cart
    And add a product on product details page
    Then item should be added to the cart
    And get count of items from cart
    When keep app in background and relaunching the same
    Then items in the cart should be unchanged
    And click on My Cart Icon
    And clear cart items
    And click on close button on my cart screen
    And click cancel button on product search page

  #C67002
  @regression
  Scenario: As a user, i should land on dashboard screen on killing the app and relaunching it
    When go to Home tab
#    And select the delivery store
#    And verify delivery shopping mode is selected-+
    When go to browse tab
#    And scroll down to categories list in browse tab
#    Then verify expand option for categories
    And click on expand option for categories
#    Then verify expand option for sub categories
    And click on expand option for sub categories
    Then verify sub categories are displayed
    And kill the application
    And relaunch the application
    And handle zip code page if displayed
    And handle tutorial if displayed on home page
    Then verify home screen is displayed

  #C69912
  @regression @functional
  Scenario: As a user, I should be able to see all the categories sorted by alphabetical order in a card format and Cards must have category image and category name, When the feature flag is true.
    When go to browse tab
    And scroll down to categories list in browse tab
    And verify category name is displayed
#    Then verify category image is displayed
    And verify all categories are sorted alphabetically

  #C69914
  @regression @functional @end_scenario
  Scenario: As a user, I should not be able see category section is in expanded state when user kill the app and relaunch the app
    When go to browse tab
#    And scroll down to categories list in browse tab
    And click on expand option for categories
    When kill the application
    And relaunch the application
    And handle zip code page if displayed
    And handle tutorial if displayed on home page
    When go to browse tab
    Then click on expand option for categories
    And click on expand option for sub categories
    And verify collapse option for sub categories

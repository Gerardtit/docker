@ShopCart
Feature: Shopping Cart operations

  Background: setup user on SignIn Page
    Given navigate to home page
    Then home page is displayed
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user empty shopping cart
    Then shopping cart empty page is displayed
    When user click check mark on shopping cart page
    Then home page is displayed

  @smoke
  Scenario: User add item and remove it from shopping cart
    When user add an item to shopping cart on homepage
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And shopping cart shows 1 as total number
    When user click remove 1st on shopping cart page
    Then shopping cart empty page is displayed

  @smoke
  Scenario: User search item from auto suggest list and add to shopping cart
    When user clicks search bar on home page
    And user types "baby health" on search bar and click search on home page
    And user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And shopping cart shows 1 as total number
    When user click remove 1st on shopping cart page
    Then shopping cart empty page is displayed
    When user click check mark on shopping cart page
    And user goes back to home page from search page
    Then home page is displayed

  @smoke
  Scenario: User search item from auto suggest list and add to shopping cart
    When user clicks search bar on home page
    And user clicks 3 item on auto suggest list
    And user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And shopping cart shows 1 as total number
    When user click remove 1st on shopping cart page
    Then shopping cart empty page is displayed
    When user click check mark on shopping cart page
    And user goes back to home page from search page
    Then home page is displayed

  @smoke
  Scenario: User update shopping cart by increase and decrease item
    When user clicks search bar on home page
    And user types "baby health" on search bar and click search on home page
    And user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And shopping cart shows 1 as total number
    When user click "increase" button on 1st item on shopping cart page
    Then shopping cart shows 2 as total number
    When user click "decrease" button on 1st item on shopping cart page
    Then shopping cart shows 1 as total number
    When user click remove 1st on shopping cart page
    Then shopping cart empty page is displayed
    When user click check mark on shopping cart page
    Then home page is displayed






@my_purchase
Feature: My Purchase Feature

  Background: setup user on Home Page
    When navigate to home page
    Then home page is displayed
    When user click my purchase tab on home page
    Then "All Past Purchases" button is displayed on the screen

  @regression
  Scenario: verify all past purchases and last order is displayed on my purchase page
    Then "All Past Purchases" button is displayed on the screen
    And "My Last Order" button is displayed on the screen

  @regression
  Scenario: Deals toggle button
    When user clicks "My Last Order" button on page
    Then Deals toggle switch is displayed on the page

  @regression
  Scenario: add product from last order and max qty for the product
    When user clicks "My Last Order" button on page
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user empty shopping cart
    And user click check mark on shopping cart page
    Then "My Last Order" button is displayed on the screen
    When user add an item to shopping cart on homepage
    And user change quantity to "10" number of items
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And verify shopping cart is not empty

  @regression
  Scenario: user add product with offer
    When user clicks "My Last Order" button on page
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user empty shopping cart
    And user click check mark on shopping cart page
    Then Deals toggle switch is displayed on the page
    When user clicks deals toggle switch on the search page
    Then "Found" text is displayed on the screen
    When user add an item to shopping cart on homepage
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And verify shopping cart is not empty

  @regression
  Scenario: user click product from my last order list and add item from product page
    When user clicks "My Last Order" button on page
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user empty shopping cart
    And user click check mark on shopping cart page
    Then Deals toggle switch is displayed on the page
    When user clicks 1 product in the search list
    Then product detail page is displayed
    And related item is displayed on the product detail page
    When user clicks add button on the product detail page
    And user clicks shopping cart button on home page
    Then shopping cart shows 1 as total number
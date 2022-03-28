@deals
Feature: Deals Feature

  Background: setup user on Home Page
    When navigate to home page
    Then home page is displayed
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user empty shopping cart
    Then shopping cart empty page is displayed
    When user clicks navigate back to the previous page
    Then home page is displayed
    When user clicks deals on home page
    Then deals page is displayed

  @regression
  Scenario: Promo Code Deals - click coupon, add item, click cart, and come back click search
    When user clicks Promo Code Deals on deals page
    Then promo code deals window is displayed
    When user clicks "SAVE NOW" text on page
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user clicks navigate back to the previous page
    Then promo code deals window is displayed
    When user clicks search icon from deals page
    Then "Currently Trending" text is displayed on the screen

  @regression
  Scenario: Club Card Deals - Select from aisle, add item, change Qty to max, check PDP and related product
    When user clicks Club Card Deals on deals page
    Then club card deals window is displayed
    When scroll down the screen
    And user clicks "Deli" text on page
    Then verify item is found from aisle
    When user clicks "1" item add button on first item
    And user change quantity to "10" number of items
    And user clicks 1 product in the search list
    Then product detail page is displayed
    And related item is displayed on the product detail page
    When scroll down the screen
    When scroll down the screen
    And "Details" text is displayed on the screen
    And "Ingredients" text is displayed on the screen
    And "View All" text is displayed on the screen

  @regression
  Scenario: BOGO Deals - Select from aisle, add item, change Qty to max, check PDP and related product
    When user clicks Buy one get one free on deals page
    Then "Buy One, Get One Free" window is displayed
    When user clicks "Cookies, Snacks & Candy" text on page
    Then "Cookie, Snacks & Candy" window is displayed
    And buy one get on free text is displayed on the screen
    When user clicks "1" item add button on first item
    And user change quantity to "10" number of items
    And user clicks 1 product in the search list
    Then product detail page is displayed
    And related item is displayed on the product detail page
    When scroll down the screen
    And "Details" text is displayed on the screen
    And "Ingredients" text is displayed on the screen
    And "View All" text is displayed on the screen
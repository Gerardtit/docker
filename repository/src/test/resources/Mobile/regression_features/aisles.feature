@aisles
Feature: Aisles Feature

  Background: setup user on Home Page
    When navigate to home page
    Then home page is displayed
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user empty shopping cart
    Then shopping cart empty page is displayed
    When user clicks navigate back to the previous page
    Then home page is displayed
    When user click aisles tab on home page
    Then aisles department list is displayed on home page

  @regression
  Scenario: Verify Aisles - L1/L2/L3 Product, and add products and max the quantity
    When user clicks item "Baby Care" on aisle list
    When user clicks item "Baby Bath & Skin Care" on aisle list
    When user clicks item "Baby Body Wash" on aisle list
    Then verify item is found from aisle
    When user clicks "1" item add button on first item
    And user change quantity to "10" number of items
    And user clicks shopping cart button on home page
    Then shopping cart shows 10 as total number

  @regression
  Scenario: From Aisles - PDP pages - Add/ Max QTY - verify product details/ingredients - related products, view all
    When user clicks item "Baby Care" on aisle list
    When user clicks item "Baby Bath & Skin Care" on aisle list
    When user clicks item "Baby Body Wash" on aisle list
    Then verify item is found from aisle
    When user clicks 1 product in the search list
    Then product detail page is displayed
    And related item is displayed on the product detail page
    When user clicks add button on the product detail page
    And user change quantity to "10" number of items
    And "Details" text is displayed on the screen
    And "Ingredients" text is displayed on the screen
    And "View All" text is displayed on the screen
    And user clicks shopping cart button on home page
    Then shopping cart shows 10 as total number

  @regression
  Scenario: PDP - Details(Prop 65) and all links should work
    When scroll down the screen
    When scroll down the screen
    And user clicks item "Wine, Beer & Spirits" on aisle list
    And user clicks item "Beer" on aisle list
    And user clicks item "Non-Alcoholic Beer" on aisle list
    Then verify item is found from aisle
    When user clicks 1 product in the search list
    Then product detail page is displayed
    And "Prop 65 WARNING" text is displayed on the screen for California banner

  @regression
  Scenario: Add product with offer/Offer details page
    When user clicks item "Baby Care" on aisle list
    When user clicks item "Baby Bath & Skin Care" on aisle list
    When user clicks item "Baby Body Wash" on aisle list
    Then verify item is found from aisle
    When user clicks deals toggle switch on the search page
    Then verify item is found from aisle
    And  "Club Card Price" text is displayed on the screen
    When user clicks "1" item add button on first item
    When user clicks 1 product in the search list
    Then product detail page is displayed
    And  "Club Card Price" text is displayed on the screen

  @regression
  Scenario: Related Products- Deals Toggle and filters/View All
    When user clicks item "Baby Care" on aisle list
    When user clicks item "Baby Bath & Skin Care" on aisle list
    When user clicks item "Baby Body Wash" on aisle list
    Then verify item is found from aisle
    When user clicks 1 product in the search list
    Then product detail page is displayed
    And related item is displayed on the product detail page
    When user clicks "View All" text on page
    Then "Related Products" window is displayed
    When user clicks deals toggle switch on the search page
    Then verify item is found from aisle
    When user click sort or filters from item list window
    Then "Best Match" text is displayed on the screen

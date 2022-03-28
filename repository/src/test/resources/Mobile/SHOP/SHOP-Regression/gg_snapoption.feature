@snapoption
Feature: User verify SNAP and Non SNAP items

#  Background:
#    When Launch the MFA app

  @mtang30
  Scenario: User See SnapOption remove Non SNAP item by selecting view cart on cart page
    When sign in to the application for delivery orders
#    Then zipcode page is displayed
#    When user enters "zipcode" in zipcode page
#    Then select order type page is displayed
#    When user clicks pickup on delivery select page
#    Then store list is displayed
#    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    And user click aisles tab on home page
    When user clicks item "Bread & Bakery" on aisle list
    When user clicks item "Bagels & Muffins" on aisle list
    When user clicks item "Bagels" on aisle list
    Then verify item is found from aisle
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user click check mark on shopping cart page
    And user clicks back button
    And user clicks item "Bagels & Muffins" on aisle list
    And scroll down to see "Wine, Beer & Spirits"
    And user clicks item "Beer & Spiked Seltzers" on aisle list
    And user clicks item "Craft & Microbrewery Beer" on aisle list
    Then verify item is found from aisle
    And user captures name of product adding in cart
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    And user clicks checkout button on cart page
    Then checkout page is displayed
    Then user sees the snap option


  @mtang30
  Scenario: User See SnapOption remove Non SNAP item by selecting view cart on cart page
    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    And user click aisles tab on home page
    When user clicks item "Bread & Bakery" on aisle list
    When user clicks item "Bagels & Muffins" on aisle list
    When user clicks item "Bagels" on aisle list
    Then verify item is found from aisle
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user click check mark on shopping cart page
    And user clicks back button
    And user clicks item "Bagels & Muffins" on aisle list
    And scroll down to see "Wine, Beer & Spirits"
    And user clicks item "Beer & Spiked Seltzers" on aisle list
    And user clicks item "Craft & Microbrewery Beer" on aisle list
    Then verify item is found from aisle
    And user captures name of product adding in cart
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user selects the snap option


  @mtang30
  Scenario: User is able to see split on estimated total when placed transaction with SNAP and Non Snap items.
    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    And user click aisles tab on home page
    When user clicks item "Bread & Bakery" on aisle list
    When user clicks item "Bagels & Muffins" on aisle list
    When user clicks item "Bagels" on aisle list
    Then verify item is found from aisle
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user click check mark on shopping cart page
    And user clicks back button
    And user clicks item "Bagels & Muffins" on aisle list
    And scroll down to see "Wine, Beer & Spirits"
    And user clicks item "Beer & Spiked Seltzers" on aisle list
    And user clicks item "Craft & Microbrewery Beer" on aisle list
    Then verify item is found from aisle
    And user captures name of product adding in cart
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user sees a pop-up with View Cart CTA
























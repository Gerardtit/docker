Feature: WUG Checkout

  Background:
    When  Launch the MFA app

  @smoke @YRM-173
  Scenario:User selects WUG pickup store  and place order
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And select the pick-up store
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "baby oil" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "11" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then verify "Add address" window is displayed
    When user enters "address" details
    And user clicks on Continue to payment CTA
    Then user enters "visa" as name on credit card
    And user enters "4111111111111111" as credit card number
    And user enters "02/28" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    Then place order button is displayed
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    Then get order number from order confirmation page
    When user clicks Continue Shopping
    Then verify MFA home screen is displayed
    When click on settings icon
    When click on Order button
    Then past orders list is displayed on the order page
    And verify placed order displayed in the Order History screen

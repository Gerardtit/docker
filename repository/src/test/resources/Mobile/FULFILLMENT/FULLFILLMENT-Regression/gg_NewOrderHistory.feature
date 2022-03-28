@gg_NewOrderHistory   @regression
Feature: New Order History Screen - DUG / Delivery

  Scenario:Verify Map should NOT be displayed for Pickup Order (DUG/WUG) in the Order History screen

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    When user clicks second store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user clicks on first cart item
    And user changes quantity to "10" number of items for all item in pdp
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
    Then checkout page is displayed
    Then user lands on slot selection page for pickup
    And user clicks on continue to payment method button
    Then user verify enter card details page is displayed
    When user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
  #  And user enters "1226" as card expiration month year
    And user enters "02/28" as card expiration month year
    And user enters "99999" as billing zip code
    When user enters "111" as CVV and clicks next
  #  Then checkout page is displayed
#    When user clicks contact on checkout page
    And user enters contact information
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    Then get order number from order confirmation page
    When user clicks Continue Shopping
    Then verify MFA home screen is displayed
    When click on settings icon
    When click on Order button
    Then verify Order history page is displayed
   # And verify order number is displayed
    And verify placed order displayed in the Order History screen
    And verify Map is not displayed

  @regression
  Scenario: Verify OrderDate and OrderNumber displayed in the Order History screen

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user clicks on first cart item
    And user changes quantity to "10" number of items for all item in pdp
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
    Then verify "Add address" window is displayed
    When user enters "address" details
    And user clicks on Continue to payment CTA
 #  # Then user clicks on slotselction screen
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
 #   Then get order date from order confirmation page
    When user clicks Continue Shopping
    Then verify MFA home screen is displayed
    When click on settings icon
    When click on Order button
    Then verify Order history page is displayed
    And verify placed order displayed in the Order History screen
    And verify order date displayed in the Order History screen


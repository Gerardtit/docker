Feature: Checkout

  Background:
    When  Launch the MFA app


  @smoke
  Scenario:User selects Pickup/DUG option and place order

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "76109" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When user clicks search bar on home page
    And user types "baby lotion" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "20" number of items for all item in shopping cart
#    Then shopping cart shows 10 as total number
#    And checkout button is enabled on the shopping cart
#    And estimation total information icon is displayed
#    When scroll down the screen
#    Then cart summary is displayed on the shopping cart page
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks payment on checkout pagex
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    When user click continue on payment page
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    Then checkout page is displayed
    When user clicks contact on checkout page
    Then user fills contact details
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Done button
#    Then home page is displayed
#    When user click menu button on home page
#    Then menu page is displayed
#    When user clicks orders on menu page
#    Then order page is displayed
#    When user click cancel order on order page
#    And user wait for cancel order pop up window
#    And user click cancel order button from pop up
#    Then order page is displayed
#    Then past orders list is displayed on the order page

  @smoke @YRM-172
  Scenario:User selects Delivery option and place order
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When click on search field
    And user types "water" on search bar and click search on home page
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


  @DriverTip
  Scenario: UMA - Automation - Verify user should displayed an error message if user enter tip more than Cart Total amount
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
   # When user click on search field
    And user types "Milk" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    #And change quantity to "10" number of items for all item in cart
   # And Verify Cart Total is greater than "50.00" dollar
    And user clicks checkout button on cart page


  @CustomTip
  Scenario: UMA - Automation

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And user types "Water" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user clicks checkout button on cart page
    Then click on Close button Add Address window
    Then Verify Driver Tip Section is displayed on Checkout Landing page
    And User Click on Change Link near to Driver Tip Section
    Then Verify Add a Custom Tip Window is present
    When User Clicks on Custom Tip Radio Button
    Then Verify Custom Tip Field will be present to enter Tip Amount
    When User enter "75.00$" more than cart total amount in custom tip field
    Then Verify User gets the toast Message "NOTE: Your entered gratuity is more than 20% of your total."


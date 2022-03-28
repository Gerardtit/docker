@coa_checkout
Feature: COA Checkout Feature


  Background:
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed


  @smoke @regression

  Scenario: verify all the details including Locker/Kiosk/Counter details for DUG option

    When user clicks delivery option on home page
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks next button after registration on zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And verify 'Counter Pickup' text is displayed
    And user click start shopping button on Sign In page
    Then home page is displayed
   # Then verify MFA home screen is displayed
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    #And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And verify 'Counter Pickup' text is displayed
    When user select "attended" option
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks payment on checkout pagex
   # Then user enters "visa" as name on credit card
   # And user enters "4242424242424242" as credit card number
   # And user enters "09/22" as card expiration month year
   # And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    Then checkout page is displayed
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    And verify 'Counter Pickup' text is displayed
    When user clicks Done button
    Then home page is displayed


  @smoke @regression @miniRegression
  Scenario: Verify estimated total/ service fee/ delivery fee / club card savings / COA And Subscriptions on Check out Page
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed

    Then OrderInfo window is displayed
    When user select "attended" option
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed

    When user clicks payment on checkout pagex
    Then payment CVV window is displayed
    When user enters "1234" as CVV and clicks next
    Then checkout page is displayed
    When user clicks coa on checkout page
    And user enters coa amount "1000" and click next
    Then credit Amount Applied is displayed on page
    And user select back button from coa page
    Then checkout page is displayed
    When user scroll down to total summary
    Then "Estimated Subtotal" text is displayed in checkout page
    #Then "Estimated Subtotal" text is displayed on the screen
    Then "Estimated Reward Card Savings" text is displayed in checkout page
    Then "Credit on Account Applied" text is displayed in checkout page
    Then "Delivery Fee" text is displayed in checkout page
    And scroll down the screen
    Then "Estimated Total" text is displayed in checkout page
    Then "Delivery Subscription Fee" text is displayed in checkout page


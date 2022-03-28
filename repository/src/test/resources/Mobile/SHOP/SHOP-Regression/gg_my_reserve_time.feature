@my_reserve_time
Feature: Verify Reserve time pre book

  Background:
    When Launch the MFA app

  @smoke
  Scenario:User selects Delivery option and Verify Reserve time pre book

    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When user clicks search bar on home page
    And user types "baby lotion" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    When user select "attended" option
   # And user select 2 hour option on delivery window
    Then user change date picker on order info screen
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks payment on checkout pagex
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    Then checkout page is displayed
    When user clicks contact on checkout page
    Then user fills contact details
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    Then "Current reserved time" text is displayed on the order info screen
    When user select back button
    Then checkout page is displayed
    And place order button is clickable and click place order
    Then order confirmation page is displayed
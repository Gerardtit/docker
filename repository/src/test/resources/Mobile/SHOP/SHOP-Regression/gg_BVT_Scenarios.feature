Feature: Place Order And Edit Order

  Background:
    When  Launch the MFA app


#  @smoke151
#  Scenario Outline: checkout as Delivery - unattended and attended order
#  User selects DUG option and place order
#
#    When click on NewSignup for OTP
#    Then zipcode page is displayed
#    When user enters "zipcode" in zipcode page on MFA signup
#    Then select order type page is displayed
#    When user clicks pickup on delivery select page
#    Then store list is displayed
#    And user click start shopping button on Sign In page
#    Then verify MFA home screen is displayed
#    When user clicks search bar on home page
#    And user types "baby lotion" on search bar and click search on home page
#    Then verify result is displayed on the page
#    When user clicks "1" item add button on first item
#    And user clicks shopping cart button on home page
#    Then shopping cart page is displayed
#    And checkout button is disabled on shopping cart
#    And user change quantity to "10" number of items for all item in shopping cart
#    Then shopping cart shows 10 as total number
#    And checkout button is enabled on the shopping cart
#    And estimation total information icon is displayed
#    When scroll down the screen
#    Then cart summary is displayed on the shopping cart page
#    And user clicks checkout button on cart page
#    Then checkout page is displayed
#    When user clicks OrderInfo on checkout page
#    Then OrderInfo window is displayed
#    When user select "<delivery type>" option
#    And scroll down the screen
#    And user change date picker to enable save
#    And user click save button on orderInfo window
#    Then checkout page is displayed
#    When user clicks "Payment" text on page
#    Then payment CVV window is displayed
#    When user enters "111" as CVV and clicks next
#    Then checkout page is displayed
#    And place order button is clickable and click place order
#    Then order confirmation page is displayed
#    When user clicks Done button
#    Then home page is displayed
#    When user click menu button on home page
#    Then menu page is displayed
#    When user clicks orders on menu page
#    Then order page is displayed
#    When user click cancel order on order page
#    And user wait for cancel order pop up window
#    And user click cancel order button from pop up
#    Then past orders list is displayed on the order page
#
#
#    Examples:
#      | delivery type |
#      | unattended    |
#      | attended      |


  @smoke151
  Scenario:User selects Pickup/DUG option and place order

    When sign in to the application using account with existing rewards
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page on MFA signup
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
    And user change quantity to "10" number of items for all item in shopping cart
    Then shopping cart shows 10 as total number
    And checkout button is enabled on the shopping cart
    And estimation total information icon is displayed
    When scroll down the screen
    Then cart summary is displayed on the shopping cart page
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks "Payment" text on page
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    Then checkout page is displayed

    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Done button
    Then home page is displayed
    When user click menu button on home page
    Then menu page is displayed
    When user clicks orders on menu page
    Then order page is displayed
    When user click cancel order on order page
    And user wait for cancel order pop up window
    And user click cancel order button from pop up
    Then order page is displayed
    Then past orders list is displayed on the order page


  @smoke151
  Scenario:User edit DUG order

    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page on MFA signup
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
    And user change quantity to "10" number of items for all item in shopping cart
    Then shopping cart shows 10 as total number
    And checkout button is enabled on the shopping cart
    And estimation total information icon is displayed
    When scroll down the screen
    Then cart summary is displayed on the shopping cart page
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks "Payment" text on page
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    Then checkout page is displayed

    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Done button
    Then home page is displayed
    When user click menu button on home page
    Then menu page is displayed
    When user clicks orders on menu page
    Then order page is displayed

#  @smoke151
#  Scenario Outline: Edit Order as Delivery - unattended and attended order
#  User selects DUG option and place order
#
#    When click on NewSignup for OTP
#    Then zipcode page is displayed
#    When user enters "zipcode" in zipcode page on MFA signup
#    Then select order type page is displayed
#    When user clicks pickup on delivery select page
#    Then store list is displayed
#    And user click start shopping button on Sign In page
#    Then verify MFA home screen is displayed
#    When user clicks search bar on home page
#    And user types "baby lotion" on search bar and click search on home page
#    Then verify result is displayed on the page
#    When user clicks "1" item add button on first item
#    And user clicks shopping cart button on home page
#    Then shopping cart page is displayed
#    And checkout button is disabled on shopping cart
#    And user change quantity to "10" number of items for all item in shopping cart
#    Then shopping cart shows 10 as total number
#    And checkout button is enabled on the shopping cart
#    And estimation total information icon is displayed
#    When scroll down the screen
#    Then cart summary is displayed on the shopping cart page
#    And user clicks checkout button on cart page
#    Then checkout page is displayed
#    When user clicks OrderInfo on checkout page
#    Then OrderInfo window is displayed
#    When user select "<delivery type>" option
#    And scroll down the screen
#    And user change date picker to enable save
#    And user click save button on orderInfo window
#    Then checkout page is displayed
#    When user clicks "Payment" text on page
#    Then payment CVV window is displayed
#    When user enters "111" as CVV and clicks next
#    Then checkout page is displayed
#    And place order button is clickable and click place order
#    Then order confirmation page is displayed
#    When user clicks Done button
#    Then home page is displayed
#    When user click menu button on home page
#    Then menu page is displayed
#    When user clicks orders on menu page
#    Then order page is displayed
#
#
#    Examples:
#      | delivery type |
#      | unattended    |
#      | attended      |
#

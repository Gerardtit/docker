@remove_item
Feature: Verify Remove Product in Cart

  Background:
    When Launch the MFA app

  @regression
  Scenario: Verify PDP after adding items to Cart with new user
    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "76109" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then verify that 'For you' Tab is displayed
    #Then verify home screen is displayed
    When go to Home tab
    Then verify MFA home screen is displayed
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user empty shopping cart
    Then shopping cart empty page is displayed
    When user clicks navigate back to the previous page
    And scroll down the screen
    When user clicks "1" item add button on first item
    And user clicks search bar on home page
    And user types "baby lotion" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    #And Estimated Savings information icon is displayed on shopping cart page
    And user click remove icon in shopping cart
    When user swipe left to remove all items
    Then shopping cart empty page is displayed


  @checkoutframe
  Scenario: checkout frame  as pickup
    When user clicks delivery option on home page
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks next button after registration on zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then home page is displayed
    And verify "pickup" option is selected as preference on home page
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed

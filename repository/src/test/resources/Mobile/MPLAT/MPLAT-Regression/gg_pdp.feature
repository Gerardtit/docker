Feature: PDP Page

  Background:
    When Launch the MFA app


  @pdp
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
    When go to browse tab
    And user expands category "Beverages" on category list
    When user clicks item "Coffee" on aisle list
    And user clicks item "Coffee - Ground" on aisle list
    When add a product on product details page
    Then verify product details page is displayed
    And click on My Cart Icon
    Then shopping cart page is displayed
    And user clicks first item on cart page
    Then verify product details page is displayed





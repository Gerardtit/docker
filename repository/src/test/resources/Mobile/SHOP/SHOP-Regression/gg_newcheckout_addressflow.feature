@gg_addressflow
Feature:Address flow - Automation

  @regression
  Scenario:Delivery
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    And if Service Problem is displayed
    Then verify "Add address" window is displayed
  #  And user verify upon landing on CVV screen, cursor will be active in CVV entry field
    And verify the cursor is already on the street field
    Then user verify numeric keyboard is displayed
    Then user verify Zip code ,City, and State are pre-filled
    And verify State field will not be editable
    And verify 2nd line for street is optional
    When user enters "address" details
    And user clicks on Continue to payment CTA

  @editAddress
  Scenario:Edit Address - New Checkout
     # When click on NewSignup Api for OTP
#      Then zipcode page is displayed
#      When user enters "zipcode" in zipcode page
#      Then select order type page is displayed
#      When user click delivery option
#      And user click start shopping button on Sign In page
#      Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    And if Service Problem is displayed
    Then verify "Add address" window is displayed
    And verify the cursor is already on the street field
    When user enters "address" details
    When user enters "13" different address details


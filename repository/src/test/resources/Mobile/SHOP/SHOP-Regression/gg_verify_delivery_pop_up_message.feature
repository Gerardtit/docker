Feature: Verify Delivery Pop up Message

  @SMF-5695
  Scenario: Verify back arrow navigation from Order Details screen to Order history screen for DUG
    When click on NewSignup Api for OTP
    When sign in with New OTP for delivery orders
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks on first cart item
    And user changes quantity to "6" number of items for all item in pdp
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
    Then verify "Add address" window is displayed
    When user enters "address" details
    Then user clicks on Pickup button
    When user clicks on Edit button on slot selection page for pickup
    Then user lands on select pickup store page
    And user verify "94566" will be pre filled if previously provided
    Then User taps on the search entry field
    Then user verify numeric keyboard is displayed
    When user enters vons "92110" in store zipcode page
    When user clicks next button on zipcode page
    And user clicks on first available store from list
    Then user validates pick up available pop up

  @SMF-5696
  Scenario: Verify back arrow navigation from Order Details screen to Order history screen for DUG
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94523" in zipcode page
    Then select order type page is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks on first cart item
    And user changes quantity to "5" number of items for all item in pdp
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
    When user clicks on Edit chevron button
    And User can tap on plus icon to enter new address entry form
    Then verify "Add address" window is displayed
    When user enters "94566" details
    Then user should continue with zip code alert change
    Then switch to address two from saved addresses
    And user navigating back to home page
    Then user verify new address is displayed




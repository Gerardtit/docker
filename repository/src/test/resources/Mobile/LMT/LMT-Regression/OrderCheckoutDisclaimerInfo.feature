Feature: Add disclaimer on Contact info summary screen on Checkout screen

  Background: setup user on Home Page for Delivery Fulfillment type
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then Verify Start shopping button on Sign In page
    When user click delivery option
    And user click start shopping button on After Signup
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed

  @regression @orderCheckoutContactInfo
  Scenario: verify user sees an inline message within Content info box if enable
    When click on shopping mode down arrow
    And select the delivery store
    When click on search field
    And user types "baby oil" on search bar and click search on home page
    Then verify result is displayed on the page
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    Then checkout button should be enabled
    When click on Checkout Button
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And user click on contact info button
    And SMS alerts toggle is on content info screen
    When user comes to Checkout landing screen
    Then user sees an inline message within Content info box if enable

  @regression @orderCheckoutContactInfo
  Scenario: verify user sees an inline message within Content info box if not enable
    When click on shopping mode down arrow
    And select the delivery store
    When click on search field
    And user types "baby oil" on search bar and click search on home page
    Then verify result is displayed on the page
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    Then checkout button should be enabled
    When click on Checkout Button
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And user click on contact info button
    Given SMS alerts toggle is off content info screen
    When user comes to Checkout landing screen
    Then user sees an inline message within Content info box if not enable


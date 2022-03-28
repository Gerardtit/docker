Feature: Verify Transfer Refill


  Background:
    When  Launch the MFA app


  @smoke
  Scenario:User selects Delivery option and Verify Transfer Refill into Settings page

    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "76109" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    And user clicks on Next button
    Then verify home screen is displayed
    When go to Home tab
    Then verify MFA home screen is displayed
    When user click menu button on home page
    Then menu page is displayed
    When user clicks "Transfer Refill" text on page
    Then verify Transfer Refill text is displayed on the screen


  Scenario:Login with sso and Verify Transfer Refill into Settings page
    When click on SSO user signin
    Then verify MFA home screen is displayed
    When user click menu button on home page
    Then menu page is displayed
    When user clicks "Transfer Refill" text on page
    Then verify Transfer Refill text is displayed on the screen
Feature: Removed Search Icon- Deals Page

  Background:
    When Launch the MFA app

  @regression
  Scenario: Verify Search Icon is Removed from Deals Page Header
    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And verify search bar on home page
    When user clicks Deals on home page
    Then verify search bar is not displayed

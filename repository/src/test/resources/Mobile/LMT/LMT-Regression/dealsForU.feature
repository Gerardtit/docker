Feature: Member Tab & Deals > Update to "for U"

  Background: setup user on Home Page for Delivery Fulfillment type
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then Verify Start shopping button on Sign In page
    When user click delivery option
    And user click start shopping button on After Signup
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed


  @regression @forU
  Scenario: Member Tab and Deals should have Update to "for U"
    When user clicks on home page Tab
    And user clicks on Deals page
    And user is landed on Deals page
    And user clicks on for U page
    Then user is landed on for U page




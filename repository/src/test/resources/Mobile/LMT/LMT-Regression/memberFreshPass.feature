# this feature is not working because of the defect https://jira.safeway.com/browse/LMT-882
Feature: FreshPass member should see Disclaimer Info Sheet link on how much you save section

  Background: setup user on Home Page for Delivery Fulfillment type
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then Verify Start shopping button on Sign In page
    When user click delivery option
    And user click start shopping button on After Signup
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed

  @regression @FreshPass
  Scenario: FreshPass member should see the disclaimer info sheet
    When user clicks on home page Tab
    And user clicks on "FreshPass"
    Then user is landed on "FreshPass" page
    And user verify How much you could save
    When user click on the dollar 425 link
    Then user should see Estimated Savings is appear with text
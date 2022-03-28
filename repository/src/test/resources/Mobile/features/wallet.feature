@Wallet
Feature: Verify Wallet Section

  Background: setup user on SignIn Page
    When  Launch the MFA app
    When sign in to the application
    And user is logged in to the app for Existing user
    Then verify MFA home screen is displayed

  @bvt_regression
  Scenario: To verify Wallet Section
    When user clicks wallet on HomePage
    Then the "Wallet" page is displayed
    When click on wallet sub tab
    Then verify Loyalty card, clipped rewards and clipped deals are displayed

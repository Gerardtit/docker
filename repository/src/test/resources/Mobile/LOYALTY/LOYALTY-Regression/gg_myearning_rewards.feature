@earn_rewards
Feature: Feature Verify Start earnings rewards today on Home Page

  Background: setup user on Home Page
#    Given startup page is displayed
#    Then zipcode page is displayed
#    When user clicks Sign in button on zipcode page
#    Then sign in page is displayed
    When Launch the MFA app


  @regression

  Scenario: As a user ,verify Start earnings rewards today on Home Page and rewards balance text , expring date text on Rewards Page
#    When sign in to the application using account with existing credentials
#    And allow push notification permission at home page
#    Then verify home screen is displayed
    And click on existing user signin for OTP
    And user click Dismiss
    Then verify MFA home screen is displayed
    Then "Start earning rewards today" button is displayed on the screen
    When user clicks "Start earning rewards today" button on page
    Then verify reward page title
    Then verify rewards balance text
    Then verify expiring date text

  @smoke @regression
  Scenario: As a user ,Verify Rewards on Home Page and rewards balance text , expring date text on My Rewards Page
#    When sign in to the application using account with existing credentials
#    And allow push notification permission at home page
#    Then verify home screen is displayed
    And click on existing user signin for OTP
    And user click Dismiss
    Then verify MFA home screen is displayed
    And scroll down the screen
    When user clicks "Rewards" button on page
    Then verify reward page title
    Then verify rewards balance text
    Then verify expiring date text

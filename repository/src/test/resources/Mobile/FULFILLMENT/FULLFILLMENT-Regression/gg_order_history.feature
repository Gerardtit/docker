@earn_rewards   @regression @MRR
Feature: Feature Verify Order history on Home Page

  Background: setup user on Home Page
#    Given startup page is displayed
#    Then zipcode page is displayed
#    When user clicks Sign in button on zipcode page
#    Then sign in page is displayed
    When Launch the MFA app


  @smoke @regression

  Scenario: As a user Verify Order history on Home Page,current orders, need help section, past orders section in order page.
#    When sign in to the application using account with existing credentials
#    And allow push notification permission at home page
#    Then verify home screen is displayed
    And click on existing user signin for OTP
    And user click Dismiss
    Then verify MFA home screen is displayed
    And user scroll down to order history
    When user clicks "Order history" button on page
    Then order page is displayed
    Then current orders text is displayed on the order page
    Then past orders text is displayed on the order page
    Then need help text is displayed on the order page
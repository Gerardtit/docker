@past_purchase
Feature: Feature Past Purchase Verify and My Last Order Verify

  Background: setup user on Home Page
    When Launch the MFA app


  @smoke @regression @bvt_regression
  Scenario: As a user i should be able to see the 'My Last Order' category in the My Items Page.
    When sign in to the application
    And user is logged in to the app for Existing user
    And user click Dismiss
    Then verify MFA home screen is displayed
    When user click my items button on home screen
#    Then verify that 'My Items' Page is displayed
    When click on my last order tab
    Then verify that My Last Order Page is displayed


  @regression
  Scenario: As a user i should be able to see the 'Past Purchases' category in the My Items Page and display PDP screen.
    When click on "PROD" user signin for OTP
#    When sign in to the application using prod credentials
    #And allow push notification permission
#    And allow push notification permission at home page
#    Then verify home screen is displayed
    Then verify MFA home screen is displayed
    When user click my items button on home screen
    Then verify that 'My Items' Page is displayed
    When user clicks "My Last Order" button on page
    And user clicks "All Past Purchases" button on page
    Then Deals toggle switch is displayed on the page
    When user clicks deals toggle switch on the my items page
    #Then "Found" text is displayed on the screen
    And user click on items found from past purchase screen
    Then verify PDP screen is displayed
    Then verify that 'My Items' Page is displayed


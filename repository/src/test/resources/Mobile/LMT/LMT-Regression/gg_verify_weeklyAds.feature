Feature: Validate weeklyAD on App

  Scenario:Verify Weekly Ads on Home Page

    When sign in to the application using account with existing rewards
    Then user clicks continue Popups
    Then verify home screen is displayed
    Then verify Weekly Ads

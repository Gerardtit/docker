Feature: Email notification for "Account" page updates

  Background:
    When  Launch the MFA app


  @miniRegression
  Scenario: Verify Email users to receive email notification for "Account" page updates using existing user
    When sign in to the application
    And user is logged in to the app for Existing user
    And user click Dismiss
    Then verify MFA home screen is displayed
  #  And click on existing user signin for OTP
  #  Then verify that 'For you' Tab is displayed
  #  When go to Home tab
  #  Then verify MFA home screen is displayed
    When user click menu button on home page
    Then menu page is displayed
    When user clicks account on menu page
    Then my account page is displayed
    Given user verify phone number used in store is displayed
    When user click edit phone number on account page
    Then phone number edit window is displayed
    When user edit and confirm new phone number on account edit window
    Then my account page is displayed
    And verify confirmation mail recieved 'Thank you for updating your phone number'

Feature: Verify Privacy Policy Page

  Background:
    When  Launch the MFA app

  Scenario:User selects Delivery option and Verify TOS & Privacy Policy hyperlink location on Welcome Pages
    When click on NewSignup
    And verify 'Hi friend' text is displayed
    Then verify 'Privacy Policy' text is displayed
    And user clicks on 'Privacy Policy' link
    Then verify 'Privacy Policy' page is displayed
    #And navigate back to Welcome Page
    And come back to app and verify OTP screen

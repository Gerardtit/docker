Feature: Locked_Out Error Message Header

  Background:
    When Launch the MFA app


  Scenario: Verify "Locked_Out" error state page UI on the OTP Screen
    When User Enter the Existing Email Id For OTP
    And user enters OTP on the OTP Screen
    When User click on Start over button
    And verify let get started screen is displayed
    When user clicks on the existing user signin for OTP
    And verify "We see you're already a customer" text is displayed
    Then verify "Please contact support" text is displayed
    And verify Contact Support CTA is displayed
   # Then user clicks on Contact Support CTA
    When user clicks on the Cancel link under CTA button
    Then verify let get started screen is displayed


  @miniRegression
  Scenario: Verify Tapping on CTA button automatically dials the contact support phone number
    When User Enter the Existing Email Id For OTP
    And user enters OTP on the OTP Screen
    When User click on Start over button
    And verify let get started screen is displayed
    When User Enter the Existing Email Id For OTP
#    And verify Image error icon at center of page
#    And verify "We see you're already a customer" text is displayed
#    Then verify "Please contact support" text is displayed
#    And verify Contact Support CTA is displayed
#    When user clicks on Contact Support CTA
#    And allow to contiue using dialpad
#    Then verify DialPad is displayed on the screen
#    When user navigates back to the application
#    Then verify "Please contact support" text is displayed


Feature: OTP screen CTA

  Background:
    When Launch the MFA app

  @regression
  Scenario: Verify New User Email flow OTP screen CTA
    When click on NewSignup
    Then verify OTP Page is displayed
    And verify "Didn't get a code" text is displayed
    When user clicks on "Didn't get a code" in the OTP Screen
    And verify code description text is displayed
    When user clicks on "Didn't get a code" in the OTP Screen
    Then verify code description text is collapsed
    Then verify resend code text is displayed
    Then verify try different email text is displayed









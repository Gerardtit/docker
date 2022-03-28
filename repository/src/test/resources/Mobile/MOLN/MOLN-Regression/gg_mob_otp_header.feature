Feature: Mobile flow OTP screen header

  Background:
    When Launch the MFA app


  @mob
  Scenario: Verify New User Mobile flow OTP screen header
    And verify let get started screen is displayed
    When New User Enters number and navigated to OTP screen with Create acc message
    Then verify 'Check your text message' text is displayed on the OTP screen


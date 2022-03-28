Feature: OTP Screen error Validation

  Background:
    When  Launch the MFA app

  @smoke2
  Scenario: In lets get started screen, if user entered some invalid email then user should see invalid email error message

    When user enter some invalid email format error message should appear
    Then user enter valid email after error message navigate to otp screen

  @smoke3
  Scenario: In lets get started screen, if user entered some invalid mobile number then user should see invalid mobile
  number error

    When user enters invalid mobile number verify invalid mobile error message
    Then clear invalid mobile number verify error message gone
    When New User Enters number and navigated to OTP screen with Create acc message






Feature: Lets Get Started Page

  Background:
    When Launch the MFA app

  @regression
  Scenario: Verify "Let's Get Started" page using valid email
   #  When click on NewSignup
    Then Verify Input Field For Email
    And verify let get started screen is displayed
    When user enters valid Email in Input Field
    Then Verify Submit button is enabled
    And user tap on done button
    Then verify OTP Page is displayed

  @regression
  Scenario: Verify "Let's Get Started" page using invalid email
   #  When click on NewSignup
    Then Verify Input Field For Email
    And verify let get started screen is displayed
    When user enters invalid Email in Input Field
#    Then Verify Submit button is disabled
    And user tap on done button
    Then Verify Invalid Email Text is displayed





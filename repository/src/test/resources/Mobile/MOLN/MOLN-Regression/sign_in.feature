@sign_in
Feature: Sign In Feature

  Background: setup user on SignIn Page
    Given navigate to sign in page
    Then sign in page is displayed

  @regression @Demo
  Scenario: check forgot password link w/ valid email
    When user click forgot password link on Sign In page
    Then forgot password page is displayed
    When user enters "vonsaaa@example.com" on forgot password page
    And user click next button on forgot password page
    Then verify Password Reset Email Sent displayed

  @regression @Demo
  Scenario: check forgot password link w/ invalid email
    When user click forgot password link on Sign In page
    Then forgot password page is displayed
    When user enters "zzzyyy@example.com" on forgot password page
    And user click next button on forgot password page
    Then verify no account record error message is displayed on forgot password page

  @regression
  Scenario: check forgot password link - error scenarios not email format
    When user click forgot password link on Sign In page
    Then forgot password page is displayed
    When user enters "zzzyyy" on forgot password page
    Then verify next button is not enabled for send forgot password email

  @regression @Demo
  Scenario: sign in with correct credentials - happy path
    When user enters "email" in username field on Sign In page
    And user enters "password" in password field on Sign In page
    And user clicks sign in on sign in page
    Then home page is displayed
    When user click menu button on home page
    Then menu page is displayed
    When user click sign out button on menu page
    Then confirm sign out page is displayed
    When user click ok button to confirm sign out
    Then sign in page is displayed

  @regression
  Scenario: sign in with Invalid account
    When user enters "email" in username field on Sign In page
    And user enters "wrong pass" in password field on Sign In page
    And user clicks sign in on sign in page
    Then verify email and password mismatch error message is displayed


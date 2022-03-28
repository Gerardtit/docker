@smoke
Feature: Sign In Feature

  Background: setup user on SignIn Page
    #Given startup page is displayed
    #When user clicks continue button on startup page
    Then zipcode page is displayed
    When user clicks Sign in button on zipcode page
    #When navigate to sign in page
    Then sign in page is displayed

  @smoke @SignInTest
  Scenario: check forgot password link
    When user click forgot password link on Sign In page
    Then forgot password page is displayed
    When user enters "vonsaaa@example.com" on forgot password page
    And user click next button on forgot password page
    Then verify Password Reset Email Sent displayed

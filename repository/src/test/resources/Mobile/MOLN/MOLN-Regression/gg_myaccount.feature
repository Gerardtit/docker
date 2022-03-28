@my_account
Feature: Feature to Verify "My Account" details in My Acount Page

  Background: setup user on Home Page
    Given startup page is displayed
    Then zipcode page is displayed
    When user clicks Sign in button on zipcode page
    Then sign in page is displayed

  @smoke @regression
  Scenario: As a user i should be able to see the 'My Account' details in the My Account Page.
    When sign in to the application using account with existing credentials
    And allow push notification permission at home page
    Then verify home screen is displayed
    When user click menu button on home page
    Then menu page is displayed
    When user clicks account on menu page
    Then my account page is displayed
    When user verify savings summery is displayed on account page
    And user verify address window is displayed on account page
    And user verify Dug store info is displayed on account page
    And user verify UDC info is displayed on account page
    And user verify phone number used in store is displayed
    And user verify email address is displayed on account page
    And user verify communication preference is displayed on account page

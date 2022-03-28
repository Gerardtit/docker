Feature: Validate my account on app

  Scenario:Verify My account on Home Page

    When sign in to the application using account with existing rewards
    Then user clicks continue Popups
    Then verify home screen is displayed
    Then verify My account field
    When user click on the link at page
    Then verify Account page is opened
    Then user verify all the section on account page

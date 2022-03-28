Feature: Verify ZIPCODE Text

  Scenario: As a new user Verify ZIPCODE Text
    When sign in to the application using account with existing rewards
    Then user clicks continue Popups
    Then verify home screen is displayed after POPup
    Then verify home screen is displayed
    When user clicks delivery option on home page
    Then zipcode page is displayed
    Then zipCode new Updated text is displayed
    Then zipCode Updated Statement is displayed
    Then validate title and statement
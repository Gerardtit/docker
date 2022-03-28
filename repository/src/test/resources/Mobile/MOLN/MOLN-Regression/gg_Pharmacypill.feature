Feature: verify Pharmacy pill at homepage

  @est
  Scenario:verify pharmacy pill at homepage
    When sign in to the application
    Then verify MFA home screen is displayed
    Then user clicks on pharmacy pill
    And user is at Pharmacy page




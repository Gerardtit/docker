Feature: verify idealcondition

  Background:
    When sign in to the application


  Scenario:verify ideal condition
    Then verify MFA home screen is displayed
    Then user minimise the app

  Scenario:verify ideal condition
    And go to browse tab
    Then user minimise the app

  Scenario:verify ideal condition
    And go to Deals tab
    Then user minimise the app


  Scenario:verify ideal condition
    When go to MyList tab
    Then user minimise the app


  Scenario:verify ideal condition
    When go to Wallet tab
    Then user minimise the app


  Scenario:verify ideal condition
    When user clicks on member tab
    Then user minimise the app


  Scenario:verify ideal condition
    When user clicks on member tab
    Then clicks ForU tab
    Then user minimise the app
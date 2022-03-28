Feature: verify bday card

  Background:
    When sign in to the application
    When user clicks on member tab
    Then clicks ForU tab
    Then birthday card is displayed

  Scenario:verify bday card at Foru
    And user clicks on birthday card


  Scenario:validate bday card text
    And user clicks on birthday card
    And validate the text on birthday card page


  Scenario:valid date entered for bday
    And user clicks on birthday card
    Then user enters valid dates


  Scenario:invalid date entered for bday
    And user clicks on birthday card
    Then user enters invalid dates
Feature: verify FreshPass page

  @es
  Scenario: validate text in ForU at rewards from home

    When sign in to the application
    Then user clicks notnow text
    Then user handle landing scenario
    And click continue option on pop up
    When user clicks on rewards pills at homepage
    Then validate the "Get endless perks*" chart


  Scenario: validate text in ForU at rewards from deals

    When sign in to the application
    Then user clicks notnow text
    Then user handle landing scenario
    And user clicks on deals tab
    When user clicks on rewards pills at dealspage
    Then validate the "Get endless perks*" chart

  Scenario: validate text bday card at member tab

    When sign in to the application
    Then user clicks notnow text
    Then user handle landing scenario
    When user clicks on member tab
    Then clicks ForU tab
    Then bday card is displayed

  @smoke
  Scenario: Score card interaction with no rewards and point
    When sign in to the application
  #Then user clicks notnow text
    Then user handle landing scenario
  #And user clicks on deals tab
    When user clicks Deals on home page
    When user clicks on rewards pills at dealspage
    Then verify Scorecard in for u tab for no rewards
    When click on scorecard POD
    Then verify how for u screen
    And verify FAQ and T&C link content

  @smoke
  Scenario: Score card interaction with some rewards and no point
    When  sign in to the application using account with existing rewards
  #Then user clicks notnow text
    Then user handle landing scenario
    When user clicks Deals on home page
    When user clicks on rewards pills at dealspage
    Then verify Scorecard in for u tab for some rewards balance
    When click on scorecard POD with Rewards
    Then verify how for u screen for rewards user
    And verify FAQ and T&C link content
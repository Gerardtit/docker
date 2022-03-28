Feature: verify FreshPass page

#@test
  Scenario: verify page of suspended freshpass account
    When sign in to the application using account with existing rewards
    Then user clicks notnow text
    Then user handle landing scenario
    When user clicks on profile icon
    Then validate Account text at setting
    When Account page is displayed
    Then Freshpass  Text is displayed
    And Validate suspended text
    When FreshPass section  is selected
    Then Freshpass page is displayed
    And validate card expired text
    When user clicks on member tab
    Then user clicks on freshpass at member tab
    Then suspended text is displayed

#@test
  Scenario: verify page of suspended with payment refiled
    When sign in to the application using account with existing rewards
    Then user clicks notnow text
    Then user handle landing scenario
    When user clicks on profile icon
    Then validate Account text at setting
    When Account page is displayed
    Then Freshpass  Text is displayed
    And Validate suspended text
    When FreshPass section  is selected
    Then Freshpass page is displayed
    And validate card expired text
    Then user clicks card expired text
    When user enters "aaa" as name on credit card
    And user enters "4112344112344113" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    When user clicks navigate to freshpass page
    Then navigate to homepage
    When user clicks on profile icon
    Then validate Account text at setting
    When Account page is displayed
    Then Freshpass  Text is displayed
    And Validate suspended text
    When FreshPass section  is selected
    Then Freshpass page is displayed
    When user clicks on member tab
    Then user clicks on freshpass at member tab
    Then suspended text is displayed

  @test
  Scenario: verify re-enrollment flow to monthly
    When Launch the MFA app
    And click on existing user signin for OTP
    Then user clicks notnow text
    Then user handle landing scenario
    When user clicks on profile icon
    Then validate Account text at setting
    When Account page is displayed
    When FreshPass section  is selected
    Then Freshpass page is displayed
    When cancelFreshPass is selected
    Then cancelFreshPass page is displayed
    Then user selects cancel reason
    And user clicks on yes tab
    When user clicks on shop now
    When user clicks on profile icon
    Then validate Account text at setting
    When Account page is displayed
    When FreshPass section  is selected
    Then user clicks unsubscribed
    When user clicks on selecttab of monthly plan
    When CVV number is refreshed with choose date
    When user enters "111" as CVV and clicks next
    And Iagree box is selected
    And Startsubscription tab is clicked
    Then Done tab is selected
    When user clicks on homeicon
    When user clicks on profile icon
    Then validate Freshpass text at setting
    When FreshPass page is selected


Feature: verify FreshPass page
#  @test
  Scenario: verify update card for a monthly user
    When Launch the MFA app
    And click on existing user signin for OTP
    Then user clicks notnow text
    Then user handle landing scenario
    When user clicks on profile icon
    Then validate Account text at setting
    When Account page is displayed
    When FreshPass section  is selected
    Then Freshpass page is displayed
    Then user click on card detail arrow
    When user enters "aaa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    Then user validates card number "4242424242424242" entered from freshpass page

#  @test
  Scenario: verify change plan and then cancellation
    When Launch the MFA app
    When click on NewSignup for OTP
    Then user clicks notnow text
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page on MFA signup
    When user clicks pickup on delivery select page
    And user click start shopping button on Sign In page
    Then user handle landing scenario
    When user clicks on profile icon
    Then validate Account text at setting
    When Account page is displayed
    When FreshPass section  is selected
    When Trial button is selected
    When Freshpass page is displayed
    When user clicks on selecttab of monthly plan
    When user clicks add new card on page
    When user enters "aaa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    Then "CVV" text is displayed on the screen
    When user enters "111" as CVV and clicks next
    And Iagree box is selected
    And Startsubscription tab is clicked
    Then Done tab is selected
    Then navigate to homepage
    When user clicks on profile icon
    Then validate Account text at setting
    When Account page is displayed
    When FreshPass section  is selected
    Then Freshpass page is displayed
    When user clicks on Change tab
    Then user clicks on selects tab
    When CVV number is refreshed with choose date
    When user enters "111" as CVV and clicks next
    And Iagree box is selected
    When confirm tab is selected
    Then Current plan is displayed
    And user new plan is displayed
    Then Done button is selected
    When FreshPass section  is selected
    When cancelFreshPass is selected
    Then cancelFreshPass page is displayed
    Then user selects cancel reason
    And user clicks on yes tab
    When user clicks Done button
    When FreshPass section  is selected
#  @test
  Scenario: verify cancellation of active monthly user
    When Launch the MFA app
    And click on existing user signin for OTP
    Then user clicks notnow text
    Then user handle landing scenario
    When user clicks on profile icon
    Then validate Account text at setting
    When Account page is displayed
    When FreshPass section  is selected
    When Freshpass page is displayed
    When cancelFreshPass is selected
    Then user selects cancel reason
    And user clicks on yes tab
    When user clicks Done button
    When FreshPass section  is selected
    Then user clicks unsubscribed
    Then validate Both plans are displayed
    Then navigate to homepage
    When user clicks on profile icon
    Then validate Freshpass text at setting
    Then user clicks unsubscribed
    Then validate Both plans are displayed
#  @test
  Scenario: verify re-enroll of monthly user
    When Launch the MFA app
    And click on existing user signin for OTP
    Then user clicks notnow text
    Then user handle landing scenario
    When user clicks on profile icon
    Then validate Account text at setting
    When Account page is displayed
    When FreshPass section  is selected
    When Freshpass page is displayed
    When cancelFreshPass is selected
    Then user selects cancel reason
    And user clicks on yes tab
    When user clicks Done button
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
#   @test
  Scenario: verify re-enroll of annual user
    When Launch the MFA app
    And click on existing user signin for OTP
    Then user clicks notnow text
    Then user handle landing scenario
    When user clicks on profile icon
    Then validate Account text at setting
    When Account page is displayed
    When FreshPass section  is selected
    When Freshpass page is displayed
    When cancelFreshPass is selected
    Then user selects cancel reason
    And user clicks on yes tab
    When user clicks Done button
    When FreshPass section  is selected
    Then user clicks unsubscribed
    When user clicks on selecttab of annual plan
    When CVV number is refreshed with choose date
    When user enters "111" as CVV and clicks next
    And Iagree box is selected
    And Startsubscription tab is clicked
    Then Done tab is selected
    When user clicks on homeicon
    When user clicks on profile icon
    Then validate Freshpass text at setting
    When FreshPass page is selected
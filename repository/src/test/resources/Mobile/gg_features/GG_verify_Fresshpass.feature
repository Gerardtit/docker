Feature: verify FreshPass page


#  Scenario: Validate FreshPass page from Account Page
#    Then softupdate is handled
#    When Launch the MFA app
#    And click on existing user signin for OTP
#    When user handle allow window
#    Then user clicks continue Popups
##    Then navigate to homepage
#    When user clicks on profile icon
#    Then validate Account text at setting
#    When Account page is displayed
#    Then Freshpass  Text is displayed
#    When FreshPass section  is selected
#    Then validate Freshpass page is displayed
#  Then user returns to settings page from Freshpass page


  Scenario: Validate Terms And Condition at FreshPass page
    Then softupdate is handled
    When Launch the MFA app
    And click on existing user signin for OTP
#    When user handle allow window
    Then user clicks continue Popups
    Then navigate to homepage
    When user clicks on profile icon
    When user handle allow window
    Then validate Freshpass text at setting
    When FreshPass page is selected
    When user clicks TNC at FreshPass page
    Then TNC Page is displayed
#
#
#  Scenario: Validate FAQ at FreshPass page
#    Then softupdate is handled
#    When Launch the MFA app
#    And click on existing user signin for OTP
#    When user handle allow window
#    Then user clicks continue Popups
##    Then navigate to homepage
#    When user clicks on profile icon
#    Then validate Freshpass text at setting
#    When FreshPass page is selected
#    When user clicks on FAQ at FreshPass page
#    Then FAQ PAge is displayed
#
#
#  Scenario: Validate Cancel at FreshPass Page
#    Then softupdate is handled
#    When Launch the MFA app
#    And click on existing user signin for OTP
#    When user handle allow window
#    Then user clicks continue Popups
##    Then navigate to homepage
#    When user clicks on profile icon
#    Then validate Freshpass text at setting
#    When FreshPass page is selected
#    When cancelFreshPass is selected
#    Then cancelFreshPass page is displayed
#
#  Scenario: Validate change tab at Fresh pass page
#    Then softupdate is handled
#    When Launch the MFA app
#    And click on existing user signin for OTP
#    When user handle allow window
#    Then user clicks continue Popups
##    Then navigate to homepage
#    When user clicks on profile icon
#    Then validate Freshpass text at setting
#    When FreshPass page is selected
#    When user clicks on Change tab
#    Then Manage plan page is displayed
#
#  Scenario: Validate freshPass page text
#    Then softupdate is handled
#    When Launch the MFA app
#    And click on existing user signin for OTP
#    Then user clicks continue Popups
#    Then navigate to homepage
#    When user handle allow window
#    When user clicks on profile icon
#    Then validate Freshpass text at setting
#    Then validate Freshpass page is displayed
#
##  Scenario: change FreshPass plan Monthly to Annual
##    Then softupdate is handled
##    When Launch the MFA app
##    And click on existing user signin for OTP
##    When user handle allow window
##    Then user clicks continue Popups
##    When user clicks on profile icon
##    Then FreshPass is displayed on settingpage and selected
#    When change monthly plan
#    When user selects Annual plan
#
#  Scenario: verify FreshPass text and FreshPass page
#    Then softupdate is handled
#    When Launch the MFA app
#    And click on existing user signin for OTP
#    When user handle allow window
#    Then user clicks continue Popups
#    When user clicks on profile icon
#    Then validate Freshpass text at setting
#    Then validate Freshpass page is displayed
#
#  Scenario: verify plans at freshpass page
#    Then softupdate is handled
#    When Launch the MFA app
#    When click on NewSignup for OTP
#    Then zipcode page is displayed
#    When user enters "76109" in zipcode page
#    When user clicks pickup on delivery select page
#    Then storelist is displayed
#    And user click start shopping button on Sign In page
#    When user handle allow window
#    Then user clicks continue Popups
#    When user clicks on profile icon
#    Then validate Freshpass text at setting
#   Then validate Freshpass page is displayed
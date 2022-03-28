Feature: Analytics


  @analytics


  Scenario: Demo for Analytics Testing
    When invoke Charles Proxy
    Then start Charles Proxy Recording
    Then sign in to the application
    Then download Charles Logs in File "signIn"
    Then stop Charles Proxy Recording
    Then verify Charles Proxy Logs for all attribute with tag "signIn"


  @analytics

  Scenario: Demo for Analytics Testing
    When invoke Charles Proxy
    Then start Charles Proxy Recording
    Then sign in to the application
    Then download Charles Logs in File "demo"
    Then stop Charles Proxy Recording
    Then verify Charles Proxy Logs for all attribute with tag "demo"

      #@analytics
  Scenario: When the home screen is loaded tags are coming

    When sign in to the application using account with existing rewards
    Then user clicks continue Popups
    Then verify home screen is displayed
  # When Launch the MFA app
   # And click on existing user signin for OTP
    #Then verify MFA home screen is displayed
    #Then user clicks continue Popups
    Then verify home screen is displayed

  #@analytics
  Scenario: When the Browse screen is loaded tags are coming
    When sign in to the application using account with existing rewards
    Then user clicks continue Popups
    Then verify home screen is displayed
  # When Launch the MFA app
   #And click on existing user signin for OTP
   #Then verify MFA home screen is displayed
   #Then user clicks continue Popups
   #Then verify home screen is displayed
    Then user click on Browse Tab

# @analytics
  Scenario: When the Deal screen is loaded tags are coming
    When sign in to the application using account with existing rewards
    Then user clicks continue Popups
    Then verify home screen is displayed
 # When Launch the MFA app
  # And click on existing user signin for OTP
   #Then verify MFA home screen is displayed
   #Then user clicks continue Popups
   #Then verify home screen is displayed
    Then user click on Deals Tab


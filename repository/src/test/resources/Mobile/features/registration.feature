@Registration
Feature: Registration Feature

  Background: setup user on SignIn Page
    When navigate to sign in page
    Then sign in page is displayed


  @smoke
  Scenario: Verify fully register new user from sign in page
    When user clicks CreateAccount on Sign In Page
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks next button on zipcode page
    Then create account page 1 is displayed
    When user enters "phone number" in phone number field on CreateAccount Page
    And user enters "firstname" and "lastname" as first name and last name on CreateAccount Page
    And user enters "email" in email field on CreateAccount Page
    And user enters "password" in password field on CreateAccount Page
    And user clicks continue button on createAccount page
    And user clicks continue button second time for android on createAccount page
    Then ios user select not save the password
    Then create account page 2 is displayed
    When user select residential on createAccount page
    And user enters "address" in address field on CreateAccount Page
    And user clicks continue button on createAccount page
    Then create account page 3 is displayed
    When user select Agree on CreateAccount Page
    And user select "Mail" reference on CreateAccount Page
    And user clicks shop now button on createAccount page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then home page is displayed






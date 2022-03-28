@registration
Feature: Registration Feature

  Background: setup user on SignIn Page
    When navigate to sign in page
    Then sign in page is displayed
    When user clicks CreateAccount on Sign In Page
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks next button on zipcode page
    Then Sign up page is displayed

  @regression
  Scenario: Verify register new user - guest flow
    When user enters "firstname" on First Name field on Sign up page
    And user enters "lastname" on Last Name field on Sign up page
    And user enters random email address on Email Address field on Sign up page
    And user enters "Pass1234" password on Sign up page
    And user enters random phone number on Sign up page
    And user clicks Create Account button on Sign up page
    Then ios popup save confirm message
    And ios user select not save the password
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks next button after registration on zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then home page is displayed

  @regression
  Scenario: New user registers account from mobile app - from APP launch
    When user enters "firstname" on First Name field on Sign up page
    And user enters "lastname" on Last Name field on Sign up page
    And user enters random email address on Email Address field on Sign up page
    And user enters "Pass1234" password on Sign up page
    And user enters random phone number on Sign up page
    And user clicks Create Account button on Sign up page
    Then ios popup save confirm message
    And ios user select not save the password
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks next button after registration on zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then home page is displayed

  @regression
  Scenario: Register with Club Card
    When user enters "firstname" on First Name field on Sign up page
    And user enters "lastname" on Last Name field on Sign up page
    And user enters random email address on Email Address field on Sign up page
    And user enters "Pass1234" password on Sign up page
    And user enters "49131032211" phone or club card number on Sign up page
    And user clicks Create Account button on Sign up page
    Then ios popup save confirm message
    And ios user select not save the password
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks next button after registration on zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then home page is displayed

  @regression
  Scenario: Registration check all the links
    When user clicks term of use link on Sign up page
    And android user clicks using webview browser
    And user clicks navigate back to the previous page
    And user clicks privacy term link on Sign up page
    And android user clicks using webview browser
    And user clicks navigate back to the previous page
    When user enters "firstname" on First Name field on Sign up page
    And user enters "lastname" on Last Name field on Sign up page
    And user enters random email address on Email Address field on Sign up page
    And user enters "Pass1234" password on Sign up page
    And user enters random phone number on Sign up page
    And user clicks Create Account button on Sign up page
    Then ios popup save confirm message
    And ios user select not save the password
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks next button after registration on zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then home page is displayed

  @regression
  Scenario: Registration negative test - Registration Negative use cases - Existing email
    And user enters "vonsaaa@example.com" email address on Email Address field on Sign up page
    Then email error mark is displayed on Sign up page

  @regression
  Scenario: Registration negative test - Registration Negative use cases - Existing Phone number
    And scroll down the screen
    And user enters "2223334567" phone or club card number on Sign up page
    Then phone card error mark is displayed on Sign up page

  @regression
  Scenario: Registration negative test - Registration Negative use cases - Password length
    And user enters "2" password on Sign up page
    Then password error mark is displayed on Sign up page

  @regression
  Scenario: Registration negative test - Registration Negative use cases - Existing club card
    And scroll down the screen
    And user enters "42000562957" phone or club card number on Sign up page
    Then phone card error mark is displayed on Sign up page


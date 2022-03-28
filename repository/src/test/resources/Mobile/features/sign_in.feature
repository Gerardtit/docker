@Signin
Feature: Sign In Feature

  Background: setup user on SignIn Page
    #Given startup page is displayed
    #When user clicks continue button on startup page
    #Then zipcode page is displayed
    #When user clicks Sign in button on zipcode page
    When navigate to sign in page
    Then sign in page is displayed

  @smoke @SignInTest
  Scenario: check forgot password link
    When user click forgot password link on Sign In page
    Then forgot password page is displayed
    When user enters "vonsaaa@example.com" on forgot password page
    And user click next button on forgot password page
    Then verify Password Reset Email Sent displayed

  @smoke @SignInTest
  Scenario: sign in with correct credentials
    When user enters "email" in username field on Sign In page
    And user enters "password" in password field on Sign In page
    And user clicks sign in on sign in page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then home page is displayed
    When user click menu button on home page
    Then menu page is displayed
    When user click sign out button on menu page
    Then confirm sign out page is displayed
    When user click ok button to confirm sign out
    Then sign in page is displayed

  Scenario: sign in with different banner credentials
    When user enters different banner "email" in username field on Sign In page
    And user enters "password" in password field on Sign In page
    And user clicks sign in on sign in page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    And user enters zipcode and search in zipcode field
    Then store list is displayed
    When user clicks 1st store on the list
    #When user click delivery option
    And user click start shopping button on Sign In page
    Then home page is displayed
    When user click menu button on home page
    Then menu page is displayed
    When user click sign out button on menu page
    Then confirm sign out page is displayed
    When user click ok button to confirm sign out
    Then sign in page is displayed
    #Then instruction to download correct banner is displayed
    #When user close application and relaunch

  @smoke
  Scenario: signed in user is able to provide feedback
    When user enters "email" in username field on Sign In page
    And user enters "password" in password field on Sign In page
    And user clicks sign in on sign in page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then home page is displayed
    When user click menu button on home page
    Then menu page is displayed
    When user clicks feedback on menu page
    Then feedback page is displayed
    When user select "General" as feedback topic
    And user enters "test user comments" in comment box
    And user click submit to submit comments
    Then comment successfully sent id displayed



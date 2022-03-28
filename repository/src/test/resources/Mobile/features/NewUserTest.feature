@NewUserTest
Feature: New user test Feature

  Background: setup user on SignIn Page
    Given navigate to sign in page
    Then sign in page is displayed

  @smoke @UserSignIn
  Scenario: sign in with correct credentials
    When user enters "email" in username field on Sign In page
    And user enters "password" in password field on Sign In page
    And user clicks sign in on sign in page
    Then ios notification window displayed
    When ios user clicks not allow on notification window
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

  @smoke @UserRegistration
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
    When user click menu button on home page
    Then menu page is displayed
    When user click sign out button on menu page
    Then confirm sign out page is displayed
    When user click ok button to confirm sign out
    Then sign in page is displayed

  @smoke @UserForgotPassword
  Scenario: check forgot password link
    When user click forgot password link on Sign In page
    Then forgot password page is displayed
    When user enters "vonsaaa@example.com" on forgot password page
    And user click next button on forgot password page
    Then verify Password Reset Email Sent displayed

  @UserShopPlaceOrder
  Scenario: check shop cart and add item to place order
    When user enters "email" in username field on Sign In page
    And user enters "password" in password field on Sign In page
    And user clicks sign in on sign in page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then home page is displayed
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user empty shopping cart
    Then shopping cart empty page is displayed
    When user click check mark on shopping cart page
    Then home page is displayed
    When user clicks search bar on home page
    And user types "baby health" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    When user increase the 1st item quantity by 10 on search page
    And user goes back to home page from search page
    Then home page is displayed
    When user clicks shopping cart button on home page
    Then shopping cart page is displayed
    When user increase the 1st item quantity by 10 on shopping cart page
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    When user select "unattended" option
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks payment on checkout page
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    Then checkout page is displayed
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Done button
    Then popup feedback alert window
    When user select yes on alert window
    Then popup rating window
    When user select not now button
    Then home page is displayed
    When user click menu button on home page
    Then menu page is displayed
    When user clicks orders on menu page
    Then order page is displayed
    When user click cancel order on order page
    And user wait for cancel order pop up window
    And user click cancel order button from pop up

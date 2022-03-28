@addOffBannerAccount
Feature: Verify Registered user is able to add multiple offBanner address from account page

  Background: setup user on SignIn Page
    Given startup page is displayed
    Then zipcode page is displayed
    When user clicks Sign in button on zipcode page
    Then sign in page is displayed
    When user enter "email" in username field on Sign In page
    And user enter "password" in password field on Sign In page
    And user clicks sign in on sign in page
    When user clicks continue for CacheText

    When user clicks Shopping mode option on home page
    And user enter zipcode and search in zipcode field
    Then select order type page is displayed
    When user clicks delivery option
    And user clicks start shopping button on Sign In page

    Then Home page is displayed
    When user clicks menu button on home page
    And user click account on menu page
    Then user account page is displayed
    When user clicks edit address on account page
    Then "Address Book" window is displayed

  Scenario: To verify user able to add multiple offBanner address

    When user clicks "Add Button" to add new delivery address
    Then "Add Delivery Address" window is displayed
    Then user enter the "zipcode" to check for the order availability
    Then user enters Address details as "AddressLine" and AddressType as "Residential/Business"
    When user clicks on the save button
    Then user click continue to update zipcode with new delivery address
    Then "OffBanner" window is displayed










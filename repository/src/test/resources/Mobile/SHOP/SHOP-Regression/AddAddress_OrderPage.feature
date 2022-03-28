@AddAddress
Feature: Add Multiple Address from Order Info Page for delivery

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
    When user click shopping cart button on home page
    Then shopping cart page displayed
    And user click checkout button on cart page
    Then Checkout page is displayed
    When User clicks "Order Info" text on page
    Then "Order Info" window is displayed
    When user clicks "Edit" text on page
    Then "Address Book" window is displayed

  @AddAddress
  Scenario: Add Multiple delivery Address from Order Info Page

    When user clicks "Add Button" to add new delivery address
    Then "Add Delivery Address" window is displayed
    Then user enters the "zipcode" to check for the order availability
    Then user enters AddressLines as "AddressLine" and FloorNumber as "Apt/FlrNum" and AddressType as "Residential/Business"
    And user clicks on the save button
    And user clicks continue to update zipcode with new delivery address
    When user clicks View cart button to view the cart changes
    Then shopping cart page is displayed



















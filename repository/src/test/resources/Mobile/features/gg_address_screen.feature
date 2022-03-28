Feature: Address screen feature

  Background:
    When user click on soft upgrade message
    And navigate to sign in page
    Then sign in page is displayed

  @smoke
  Scenario: Add multiple addresses in address field from Account screen
    When user successfully creates an Account
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    And user clicks next button after registration on zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then home page is displayed
    When user click menu button on home page
    Then menu page is displayed
    When user clicks account on menu page
    Then my account page is displayed
    And user verify address window is displayed on account page
    When user click edit address on account page
    Then "Add Delivery Address" window is displayed
    When user edit new address on edit delivery address page
    And user click save button
    Then user sees address added in Address Book






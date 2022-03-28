Feature: Verify order link

  Scenario: Verify order link

    When sign in to the application using account with existing rewards
    Then user clicks continue Popups
    Then verify home screen is displayed
    When user clicks shopping cart button on home page
    When user empty shopping cart
    Then shopping cart empty page is displayed
    When user clicks navigate back to the previous page
    Then home page is displayed back
    Then user search product "MILK"
    Then user clicks Add button of first item
    And add quantity to selected item
    When user clicks shopping cart button on home page
    And user clicks checkout button on cart page
    When  clicks "Order Info" text on page
    Then Select and save open window
    When CVV number is refreshed with choose date
    When user enters "111" as CVV and clicks next
    Then placeorder is clicked
    Then At OrderConfirmationPage,OrderLink is displayed



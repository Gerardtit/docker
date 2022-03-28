Feature: COA login

  Scenario: COA Account Login

    When sign in to the application using account with existing rewards
    Then user clicks continue Popups
    Then verify home screen is displayed after POPup
    Then user search product "MILK"
    Then user clicks Add button of first item
    And add quantity to selected item
    When user clicks shopping cart button on home page
    And user clicks checkout button on cart page
    Then validate COATEXT on checkoutPage
    And Textbox is clicked
    When user enters "0.01" on text bar
    Then coa credits are displayed
    And user navigate to checkout page
    Then validate COATEXT on checkoutPage back

Feature: Verify Info Icon

  Scenario: Verify info Icon

    When sign in to the application using account with existing rewards
    Then user clicks continue Popups
    Then verify home screen is displayed after POPup
    Then user clicks Add button of first item
    And add quantity to selected item
    When user clicks shopping cart button on home page
    And user clicks checkout button on cart page
    When user clicks on InfoIcon beside the estimation total
    Then Estimation Page is open with text before
    When  clicks "Order Info" text on page
    Then Select and save open window
    When CVV number is refreshed with choose date
    When user enters "111" as CVV and clicks next
    Then placeorder is clicked
    When user clicks on InfoIcon At Order page
    Then Estimation Page is open from order page
    Then validate text thro' order page is same as Estimation page
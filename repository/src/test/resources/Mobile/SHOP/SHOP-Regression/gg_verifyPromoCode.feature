Feature: Verify PromoCode at checkout Page

  Scenario: Verify PromoCode


    When sign in to the application using account with existing rewards
    Then user clicks continue Popups
    Then verify home screen is displayed after POPup
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


    When user click promocode on checkoutpage
    When user enter promo code "LUVFRESH" and enters
    And PromoCode is Removed
    When user click promocode on checkoutpage
    When invalid Promocode is applied
    Then invalid Promocode message
    When  clicks "Order Info" text on page
    Then Select and save open window
    When  user Clicks on checkoutCart
    When user empty shopping cart
    Then shopping cart empty page is displayed
    When user clicks navigate back to the previous page
    When user click promocode on checkoutpage
    When user enter promo code "LUVFRESH" with empty cart
    And message is displayed
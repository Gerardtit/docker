Feature: Verify that Payment Method (COA) used to place order

  @SMF-5729
  Scenario: Pick Up - Verify that Payment Method (SNAP+COA) used to place order should be displayed in Order Summary section in Item Details screen
    When sign in to the application for COA and SnapEBT member
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user clicks on first cart item
    And user changes quantity to "6" number of items for all item in pdp
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
#   And user clicks on continue to payment method button
    And user enters "111" as cvv number
    And user selects snap EBT payment method
    Then user selects apply credits on account
    Then place order button is displayed
    And place order button is clickable and click place order
    Then get order number from order confirmation page
    When user clicks Continue Shopping
    Then verify MFA home screen is displayed
    When click on settings icon
    When click on Order button
    Then verify your orders heading
    And user clicks on view Details to track details chevron
    Then verify individual order details heading
    Then user clicks on item details chevron
    And verify item details heading
    Then verify COA and EBT payment method details

  @SMF-5729
  Scenario: Verify that Payment Method (COA) used to place order should be displayed in Order Summary section in Item Details screen
    When sign in to the application for COA member
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user clicks on first cart item
    And user changes quantity to "6" number of items for all item in pdp
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
#   And user clicks on continue to payment method button
    And user enters "111" as cvv number
    Then user selects apply credits on account for whole amount
    Then place order button is displayed
    And place order button is clickable and click place order
    Then get order number from order confirmation page
    When user clicks Continue Shopping
    Then verify MFA home screen is displayed
    When click on settings icon
    When click on Order button
    Then verify your orders heading
    And user clicks on view Details to track details chevron
    Then verify individual order details heading
    Then user clicks on item details chevron
    And verify item details heading
    Then verify COA payment method details


  @SMF-functionalCOAEBT
  Scenario: Pick Up - Verify that Payment Method (COA) used to place order should be displayed in Order Summary section in Item Details screen
    When sign in to the application for COA and SnapEBT member
    Then verify MFA home screen is displayed
    When click on settings icon
    When click on Order button
    Then verify your orders heading
    And user clicks on view Details to track details chevron
    Then verify individual order details heading
    Then user clicks on item details chevron
    And verify item details heading
    Then verify COA and EBT payment method details


  @SMF-functionalCOA
  Scenario: Pick Up - Verify that Payment Method (COA) used to place order should be displayed in Order Summary section in Item Details screen
    When sign in to the application for COA member
    Then verify MFA home screen is displayed
    When click on settings icon
    When click on Order button
    Then verify your orders heading
    And user clicks on view Details to track details chevron
    Then verify individual order details heading
    Then user clicks on item details chevron
    And verify item details heading
    Then verify COA payment method details



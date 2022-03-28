Feature: Orders - Pickup



   #C69064
  @regression @start_scenario

  Scenario:  As a user, I should see the 1st state of pickup order status as per the figma (Pickup confirmed)
    When sign in to the application for pickup orders
    Then verify home screen is displayed
    When go to Home tab
    When click on shopping mode down arrow
    And select the pick-up store
  #  When search a product on home page
  #  Then verify products listing page displayed
    When click on search field
    And user types "baby oil" on search bar and click search on home page
    Then verify result is displayed on the page
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    Then checkout button should be enabled
    When click on Checkout Button
    Then checkout page is displayed
    When user clicks "Order Info" text on page
    Then "Order Info" window is displayed
    When scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
  #  And click On Confirm CVV
  #  Then payment CVV window is displayed
  #  When user enters "123" as CVV and clicks next
  #  Then checkout page is displayed
    When user clicks payment on checkout pagex
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    Then checkout page is displayed
    #When place order button is clickable and click place order
    #Then order confirmation page is displayed
    When user clicks contact on checkout page
    Then user fills contact details
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Done button
    And  go to Home tab
    Then verify pickup order status is displayed

         #C69173
  @regression
  Scenario:  As a user, i should see that on clicking the View details CTA, i should navigate to Orders screen
    When sign in to the application for pickup orders
    Then verify home screen is displayed
    When user clicks search bar on home page
    And user types "baby cereal" on search bar and click search on home page
    Then verify result is displayed on the page
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    Then checkout button should be enabled
    When click on Checkout Button
    Then checkout page is displayed
    When user clicks "Order Info" text on page
    Then "Order Info" window is displayed
    When scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
  #  And click On Confirm CVV
  #  Then payment CVV window is displayed
  #  When user enters "123" as CVV and clicks next
  #  Then checkout page is displayed
    When user clicks payment on checkout pagex
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    Then checkout page is displayed
    #When place order button is clickable and click place order
    #Then order confirmation page is displayed
    When user clicks contact on checkout page
    Then user fills contact details
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Done button
    When go to Home tab
    Then verify Home tab is selected
    And click view details on order status
    And edit order screen is displayed


  #C69066
  @regression
  Scenario: As a user, I should see the 2nd state of pickup order status as per the figma (Counter pickup confirmed)
    And forced sign out from the application
    When sign in to the application using account with pickup order status two
    Then verify home screen is displayed
    And go to Home tab
    When click on shopping mode down arrow
    And enters zipcode belonging to pickup order status two
    When click on right arrow button on zipcode page
    Then select Pick UP shopping mode
    Then click on start Shopping Button
    Then verify pickup order second status is displayed

  #C69067
  @regression
  Scenario: As a user, I should see the 3rd state of pickup order status as per the figma (Locker pickup confirmed)
    And forced sign out from the application
    When sign in to the application using account with pickup order status three
    Then verify home screen is displayed
    And go to Home tab
    When click on shopping mode down arrow
    And enters zipcode belonging to pickup order status three
    When click on right arrow button on zipcode page
    Then select Pick UP shopping mode
    Then click on start Shopping Button
    Then verify pickup order third status is displayed

  #C69068
  @regression
  Scenario: As a user, I should see the 4th state of pickup order status as per the figma ("Kiosk" pickup confirmed)
    And forced sign out from the application
    When sign in to the application using account with pickup order status four
    Then verify home screen is displayed
    And go to Home tab
    When click on shopping mode down arrow
    And enters zipcode belonging to pickup order status four
    When click on right arrow button on zipcode page
    Then select Pick UP shopping mode
    Then click on start Shopping Button
    Then verify pickup order fourth status is displayed

  #C69065
  @regression @end_scenario
  Scenario: As a user, I should not see Pickup order status  for the Pickup mode of shopping, when he/she has not placed any order
    And forced sign out from the application
    When sign in to the application using account with no purchase history
    Then verify home screen is displayed
    When go to Home tab
    When click on shopping mode down arrow
    And select the pick-up store
    Then verify pickup order status is not displayed

    #YRM30
  @Ajith
  Scenario: Store Picker store card
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    Then select Pick UP shopping mode
    Then click on start Shopping Button
    And click continue option on pop up
    Then verify home screen is displayed
    Then click on Click your deals
    When user clicks search bar on home page
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "8" number of items for all item in shopping cart
    Then click edit on pickup sheet
    And Validate the Store card is displayed
    #And validate the store on the card
    Then swipe left on store card
    And Validate the Store card is displayed
    Then swipe left on store card
    And Validate the Store card is displayed

  @regression
  Scenario:Verify Map should NOT be displayed for Pickup Order (DUG/WUG) in the Order Details screen
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    Then select Pick UP shopping mode
    Then click on start Shopping Button
    And click continue option on pop up
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user clicks on first cart item
    And user changes quantity to "5" number of items for all item in pdp
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
    And user clicks on Continue to payment CTA
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "02/28" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    Then place order button is displayed
    And place order button is clickable and click place order
    Then get order number from order confirmation page
    When user clicks Continue Shopping
    Then verify MFA home screen is displayed
    When click on settings icon
    When click on Order button
    Then Verify status bar and the order status message and sub message displayed in Order Details screen
    And verify placed order displayed in the Order History screen
    And verify order date displayed in the Order History screen
    Then Verify Map is displayed or not

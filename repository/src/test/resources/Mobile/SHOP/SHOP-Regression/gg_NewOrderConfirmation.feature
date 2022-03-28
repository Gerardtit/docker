@gg_NewOrderConfirmation
Feature: New Order Confirmation Screen - Delivery & DUG

  @regression
  Scenario: verify all the details including Locker details for WUG option

    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And verify 'Locker Pickup' text is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And verify 'Locker Pickup' text is displayed
    When user select "attended" option
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks payment on checkout pagex
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    Then checkout page is displayed
    When user clicks contact on checkout page
    Then user fills contact details
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    And verify 'Locker Pickup' text is displayed
    When user clicks Done button
    And user click 'yes' love the app
    Then home page is displayed

  @regression
  Scenario: verify all the details including Counter details for WUG option

    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And verify 'Counter Pickup' text is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    #And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And verify 'Counter Pickup' text is displayed
    When user select "attended" option
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks payment on checkout pagex
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    Then checkout page is displayed
    When user clicks contact on checkout page
    Then user fills contact details
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    And verify 'Counter Pickup' text is displayed
    When user clicks Done button
    And user click 'yes' love the app
    Then home page is displayed

  @regression
  Scenario: verify all the details including Kiosk details for DUG option

    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "90505" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And verify 'Kiosk Pickup' text is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
   # Then verify MFA home screen is displayed
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    #And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And verify 'Kiosk Pickup' text is displayed
    When user select "attended" option
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks payment on checkout pagex
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    Then checkout page is displayed
    When user clicks contact on checkout page
    Then user fills contact details
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    And verify 'Kiosk Pickup' text is displayed
    When user clicks Done button
    And user click 'yes' love the app
    Then home page is displayed


  @regression
  Scenario:Verify and validation of New Order Confirmation Screen - DUG Order Locker Pickup

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
 #   Then user selects the In-store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user clicks on first cart item
    And user changes quantity to "10" number of items for all item in pdp
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
    Then checkout page is displayed
 #   Then user lands on slot selection page for pickup
    And user clicks on continue to payment method button
    Then user verify enter card details page is displayed
    When user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    When user enters "111" as CVV and clicks next
 #   Then checkout page is displayed
#    When user clicks contact on checkout page
    And user enters contact information
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    Then verify the content at the top will be "Your order is being processed"
    Then verify "View order" CTA on order confirmation page
    Then verify Locker Pickup is displayed on order confirmation page
    Then verify Instructions is displayed on order confirmation page
    When user clicks Continue Shopping
    #And click on close button
    Then verify MFA home screen is displayed

  @regression
  Scenario:Verify and validation of New Order Confirmation Screen including Edit Order - DUG Order DriveUp & Go

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    When user clicks second store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user clicks on first cart item
    And user changes quantity to "10" number of items for all item in pdp
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
    Then checkout page is displayed
    Then user lands on slot selection page for pickup
    And user clicks on continue to payment method button
    Then user verify enter card details page is displayed
    When user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    When user enters "111" as CVV and clicks next
  #  Then checkout page is displayed
#    When user clicks contact on checkout page
    And user enters contact information
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    Then verify "Edit order" CTA on order confirmation page
    Then verify Pickup is displayed on order confirmation page
    Then verify DriveUp & Go is displayed on order confirmation page
    Then verify Instructions is displayed on order confirmation page
    When user clicks on Edit order CTA
    Then verify Edit Order screen is displayed
    #And click on close button
    And user click on save CTA on Edit Order page
    Then verify the content at the top will be "Your order has been saved"
  #  Then order confirmation page is displayed
    And user clicks on close CTA
    Then verify MFA home screen is displayed

  @regression
  Scenario:Verify and validation of New Order Confirmation Screen - Delivery Order
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user clicks on first cart item
    And user changes quantity to "10" number of items for all item in pdp
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
 # #  Then user clicks on slotselction screen
    Then verify "Add address" window is displayed
    When user enters "address" details
    And user clicks on Continue to payment CTA
 #  # Then user clicks on slotselction screen
    Then user enters "visa" as name on credit card
    And user enters "4111111111111111" as credit card number
    And user enters "02/28" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    Then place order button is displayed
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    And "Delivery" text is displayed on the screen
    Then verify "Edit order" CTA on order confirmation page
    When user clicks on Edit order CTA
    Then verify Edit Order screen is displayed
    #And click on close button
    And user click on save CTA on Edit Order page
    Then verify the content at the top will be "Your order has been saved"
    Then verify Continue CTA is displayed
    When user clicks Continue Shopping
    Then verify MFA home screen is displayed

  @delnew
  Scenario:Verify and validation of New Order Confirmation Screen - Delivery Order
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user clicks on first cart item
    And user changes quantity to "10" number of items for all item in pdp
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
    Then user clicks on slotselction screen
    Then verify "Add address" window is displayed
    When user enters "address" details
    And user clicks on Continue to payment CTA
 #  # Then user clicks on slotselction screen
    Then user enters "visa" as name on credit card
    And user enters "4111111111111111" as credit card number
    And user enters "02/28" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    Then place order button is displayed
    And place order button is clickable and click place order
    Then order confirmation page is displayed
  #  And "Delivery" text is displayed on the screen
    Then verify "Edit order" CTA on order confirmation page
    When user clicks on Edit order CTA
    Then verify Edit Order screen is displayed
    #And click on close button
    And user click on save CTA on Edit Order page
    Then verify the content at the top will be "Your order has been saved"
    Then verify Continue CTA is displayed
    When user clicks Continue Shopping
    Then verify MFA home screen is displayed
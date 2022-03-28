Feature: Orders - Delivery


    #C66776
  @regression @start_scenario
  Scenario:  As a user, I should see the 1st state of order delivery status as per the figma
    When sign in to the application for delivery orders
    Then verify home screen is displayed
    And go to Home tab
    When click on search field
    And user types "milk" on search bar and click search on home page and enter first milk
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    Then checkout button should be enabled
    When click on Checkout Button
    Then user enters address details
    Then pickup time slot is selected
    Then user enters contact details
    And user enter credit card details
    When user enters "aaa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    When user enters "111" as CVV and clicks continue
    Then user enters contact details
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Continue Shopping
    And click 'Yes' if 'Love the app' popup is displayed
    And go to Home tab
    Then verify delivery order status is displayed
#
   #C69257
  @regression @fi
  Scenario: As a user, i should see that on clicking the View details CTA, i should navigate to Orders screen
    And go to Home tab
    And select the delivery store
    When click on search field
    And user types "milk" on search bar and click search on home page and enter first milk
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    Then checkout button should be enabled
    When click on Checkout Button
    Then user enters address details
    Then pickup time slot is selected
    Then user enters contact details
    And user enter credit card details
    When user enters "aaa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    When user enters "111" as CVV and clicks continue
    Then user enters contact details
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Continue Shopping
    And click 'Yes' if 'Love the app' popup is displayed
    And go to Home tab
    Then verify Home tab is selected
    And click view details on order status
    And edit order screen is displayed
    Then navigate back to previous screen

   #C69084
  @regression @end_scenario
  Scenario: Kill  and Relaunch  - Dashboard order status (Pickup/Delivery)
    When go to Home tab
    And select the pick-up store
    When click on search field
    And user types "milk" on search bar and click search on home page and enter first milk
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    Then checkout button should be enabled
    When click on Checkout Button
    Then user enters address details
    Then pickup time slot is selected
    Then user enters contact details
    And user enter credit card details
    When user enters "aaa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    When user enters "111" as CVV and clicks continue
    Then user enters contact details
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    And get order number from order confirmation page
    When user clicks Continue Shopping
    And click 'Yes' if 'Love the app' popup is displayed
    And  go to Home tab
    Then verify pickup order status is displayed
    When keep app in background and relaunching the same
    Then verify pickup order status is displayed
    When kill the application
    And relaunch the application
    And handle zip code page if displayed
    And handle tutorial if displayed on home page
    And go to Home tab
    Then verify pickup order status is displayed
    When click on settings icon
    When click on Order button
    Then order page is displayed
    And cancel order by order number
    Then handle cancel order confirmation window
    Then navigate back and close setting page
    And click 'Yes' if 'Love the app' popup is displayed
    And click close button on setting page
    And  go to Home tab
    And select the delivery store
    When click on search field
    And user types "milk" on search bar and click search on home page and enter first milk
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    Then checkout button should be enabled
    When click on Checkout Button
    Then user enters address details
    Then pickup time slot is selected
    Then user enters contact details
    And user enter credit card details
    When user enters "aaa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    When user enters "111" as CVV and clicks continue
    Then user enters contact details
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Continue Shopping
    And  go to Home tab
    Then verify delivery order status is displayed
    When keep app in background and relaunching the same
    Then verify delivery order status is displayed
    When kill the application
    And relaunch the application
    And handle zip code page if displayed
    And handle tutorial if displayed on home page
    And go to Home tab
    Then verify delivery order status is displayed
    When click on settings icon
    When click on Order button
    Then order page is displayed
    And cancel order by order number

  @order_details
  Scenario:Verify status bar and the order status message and sub message displayed in Order Details screen

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
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
    And user changes quantity to "5" number of items for all item in pdp
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
    Then verify "Add address" window is displayed
    When user enters "address" details
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

  @regression
  Scenario:Verify Map should be displayed for Delivery Order in the Order Details screen
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
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
    And user changes quantity to "5" number of items for all item in pdp
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user clicks checkout button on cart page
    Then verify "Add address" window is displayed
    When user enters "address" details
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


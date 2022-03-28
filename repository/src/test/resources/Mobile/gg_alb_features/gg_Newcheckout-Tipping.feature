Feature: validate tipping at checkout

# MRR-749
  Scenario:validate tipping at checkout

    When sign in to the application for delivery orders
    When click on shopping mode down arrow
    And Enter the ZipCode
    When click on right arrow button on zipcode page
    And select the delivery store
    Then verify delivery shopping mode is selected
    When click on search field
    And user types "milk" on search bar and click search on home page and enter first milk
    And add products on product details page till cart value is equal to or more than 30 dollars
    And click on My Cart Icon
    And user clicks checkout button on cart page
    And user click cross sign checkout flow
    And user validates driver tipping text
    And user validates change at driver tipping and click change
    And user validates the percentageof tipping
    And validates that user can select any tipping percentage
    And Custom tipping window is displayed
    Then Validate save tab is enabled
    Then user is able to save tipping


    # MRR-748
  Scenario: validate tipping at edit order page

    When sign in with newOTP for delivery orders
    When click on search field
    Then user add item to cart and click checkout
    Then user enters delivery address
    Then delivery time slot is selected oflaterdays
    When user enters "aaa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    When user enters "111" as CVV and clicks continue
    And user validates change at driver tipping and click change
    Then user is able to save zero tipping
    Then user validates driver tip is not added to order
    When place order button is clickable and click place order
    Then user validates driver tip is not added in order confirmation page


# MRR-749

  Scenario: validate tipping at edit order page

#    When click on NewSignup Api for OTP
#    And select the delivery store
    When sign in with New OTP for delivery orders
    Then zipcode page is displayed
    Then user add item to cart and click checkout
    Then user enters delivery address
    Then delivery time slot is selected oflaterdays
    When user enters "aaa" as name on credit card
    And user enters "6559906559906557" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    When user enters "111" as CVV and clicks continue
    Then user enters contact details
    When place order button is clickable and click place order
    And user click Dismiss
    When place order button is clickable and click place order
    Then user verifies driver tip on order confirmation
    Then user clicks edit button on order confirmation page
    And user verifies driver tip  in edit order
    And user validates change at driver tipping and click change
    Then user selects desired tip percentage in driver tip and  click save
    And user clicks save button
    And user validates driver tip at edit page
    Then user clicks confirm changes at edit page
    And user validates driver tip at Order summery page


  @MRR949
  Scenario: UMA - Automation - Verify if user click on View Details or Track Order navigate to Order Details screen

    When click on NewSignup Api for OTP
    When user enters "94566" in zipcode page of the application
    Then verify MFA home screen is displayed
    When click on search field
    Then user add "7" item to cart
    And user clicks checkout button on cart page
    Then user enters delivery address in progressive flow
    Then delivery time slot is selected oflaterdays
    When user enters "aaa" as name on credit card
    And user enters "6559906559906557" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    When user enters "111" as CVV on payment page
    Then user enters contact details
    When place order button is clickable and click place order on page
    Then Verify Order Confirmation Page is displayed
    Then Verify and store OrderNumber,Fullfillment type ,Date,Time is displayed
    When User click on Continue Shopping
    When user clicks menu button on home page
    Then User clicks on Order submenu in home page
    And Verify  after clicking on ViewDetailsorTrackOrder Order details screen is displayed
    Then Verify Order Confirmation Page is displayed

  @OrderStatusMessage
  Scenario: UMA - Automation - Verify status bar and the order status message and sub message displayed

    When click on NewSignup Api for OTP
    When user enters "94566" in zipcode page of the application
    Then verify MFA home screen is displayed
    When click on search field
    Then user add "7" item to cart
    And user clicks checkout button on cart page
    Then user enters delivery address in progressive flow
    Then delivery time slot is selected oflaterdays
    When user enters "aaa" as name on credit card
    And user enters "6559906559906557" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    When user enters "111" as CVV on payment page
    Then user enters contact details
    When place order button is clickable and click place order on page
    Then Verify Order Confirmation Page is displayed
    Then Verify and store OrderNumber,Fullfillment type ,Date,Time is displayed
    When User click on Continue Shopping
    When user clicks menu button on home page
    Then User clicks on Order submenu in home page
    And Verify status bar and the order status message, submessage is displayed


  @MRR950
  Scenario: Verify user should be able to go to Edit Order flow

    When click on NewSignup Api for OTP
    When user enters "94566" in zipcode page of the application
    Then verify MFA home screen is displayed
    When click on search field
    Then user add "7" item to cart
    And user clicks checkout button on cart page
    Then user enters delivery address in progressive flow
    Then delivery time slot is selected oflaterdays
    When user enters "aaa" as name on credit card
    And user enters "6559906559906557" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    When user enters "111" as CVV on payment page
    Then user enters contact details
    When place order button is clickable and click place order on page
    Then Verify Order Confirmation Page is displayed
    When user click on Cart in Edit Order of cart page
    Then user decrease the all item quantity on shopping cart page
    When user click back on cart page
    Then after clicking back button user see Edit Order page
    When user click on Save change button
    Then Verify Order Confirmation Page is displayed

  @Bannerlogo
  Scenario: UMA - Automation - Verify banner Logo, Banner Name and Order Fulfillment Type, Date/Time displayed

    When click on NewSignup Api for OTP
    When user enters "94566" in zipcode page of the application
    Then verify MFA home screen is displayed
    When click on search field
    Then user add "7" item to cart
    And user clicks checkout button on cart page
    Then user enters delivery address in progressive flow
    Then delivery time slot is selected oflaterdays
    When user enters "aaa" as name on credit card
    And user enters "6559906559906557" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    When user enters "111" as CVV on payment page
    Then user enters contact details
    When place order button is clickable and click place order on page
    Then Verify Order Confirmation Page is displayed
    Then Verify and store OrderNumber,Fullfillment type ,Date,Time is displayed
    When User click on Continue Shopping
    When user clicks menu button on home page
    Then User clicks on Order submenu in home page
    And Verify Banner Name ,Banner Logo and Order Fullfillment type ,Date Time Displayed

  @MRR947
  Scenario: UMA - Automation - Verify status bar and the order status message and sub message displayed

    When click on NewSignup Api for OTP
    When user enters "94566" in zipcode page of the application
    Then verify MFA home screen is displayed
    When click on search field
    Then user add "7" item to cart
    And user clicks checkout button on cart page
    Then user enters delivery address in progressive flow
    Then delivery time slot is selected oflaterdays
    When user enters "aaa" as name on credit card
    And user enters "6559906559906557" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    When user enters "111" as CVV on payment page
    Then user enters contact details
    When place order button is clickable and click place order on page
    Then Verify Order Confirmation Page is displayed
    Then Verify and store OrderNumber,Fullfillment type ,Date,Time is displayed
    When User click on Continue Shopping
    When user clicks menu button on home page
    Then User clicks on Order submenu in home page
    And Verify status bar and the order status message, submessage is displayed

  @MRR1028
  Scenario: UMA - Automation - Verify the ability to cancel the order from Order Details screen

    When click on NewSignup Api for OTP
    When user enters "94566" in zipcode page of the application
    Then verify MFA home screen is displayed
    When click on search field
    Then user add "7" item to cart
    And user clicks checkout button on cart page
    Then user enters delivery address in progressive flow
    Then delivery time slot is selected oflaterdays
    When user enters "aaa" as name on credit card
    And user enters "6559906559906557" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code on payment page
    When user enters "111" as CVV on payment page
    Then user enters contact details
    When place order button is clickable and click place order on page
    Then Verify Order Confirmation Page is displayed
    Then Verify and store OrderNumber,Fullfillment type ,Date,Time is displayed
    When User click on Continue Shopping
    When user clicks menu button on home page
    Then User clicks on Order submenu in home page
    And User click on ViewDetailsorTrackOrder Order
    Then click on Cancel Order link
    Then Verify CancelOrder window appears
    And Click on Yes button on Cancel Order Window
    Then Verify CancelOrder popups dismissed
    And User click on ViewDetailsorTrackOrder Order
    Then Verify Status changed to Cancelled Order at Order Details Screen
    And click on back button to go to order history page
    Then Verify order status is cancelled at order history page

  @MRR1026
  Scenario: UMA - Automation - Verify the ability to cancel the order from Order Details screen

    When click on NewSignup Api for OTP
    When user enters "94566" in zipcode page of the application
    Then verify MFA home screen is displayed
    When click on search field
    Then user add "7" item to cart
    And user clicks checkout button on cart page
    Then user enters delivery address in progressive flow
    Then delivery time slot is selected oflaterdays
    When user enters "aaa" as name on credit card
    And user enters "6559906559906557" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code on payment page
    When user enters "111" as CVV on payment page
    Then user enters contact details
    When place order button is clickable and click place order on page
    Then Verify Order Confirmation Page is displayed
    Then Verify and store OrderNumber,Fullfillment type ,Date,Time is displayed
    When User click on Continue Shopping
    When user clicks menu button on home page
    Then User clicks on Order submenu in home page
    And User click on ViewDetailsorTrackOrder Order
    Then click on Cancel Order link
    Then Verify CancelOrder window appears
    And Click on No button on Cancel Order Window
    Then Verify CancelOrder popups dismissed


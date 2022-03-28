@my_checkout
Feature: Cancel Order Scenario

  Background:
    When Launch the MFA app


  @bvt_regression @miniRegression
  Scenario:User selects Delivery option and place order , then cancel order
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
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
    #And checkout button is disabled on shopping cart
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page

    Then verify "Add address" window is displayed
    When user enters "address" details
    And user clicks on Continue to payment CTA
    #And user clicks on continue to payment method button
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    Then place order button is displayed
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    Then user clicks on Continue shopping in order confirmation page
    Then verify MFA home screen is displayed
    And user clicks on hamburger menu
    Then user clicks on orders button
    Then user lands on order history page



#    //to be updated
    When user click cancel order on order page
    And user click cancel order button from pop up
    Then user is logged in to the app for Existing user


  @regression @miniRegression
  Scenario: verify all the details including Locker details for WUG option

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And verify 'Locker Pickup' text is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page

    And user clicks on Continue to payment CTA
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    Then place order button is displayed
    And place order button is clickable and click place order

    Then order confirmation page is displayed
    When user clicks Done button

  @regression @miniRegression
  Scenario: verify all the details including Counter details for WUG option

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94063" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And verify 'Counter Pickup' text is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page

    And user clicks on Continue to payment CTA
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    Then place order button is displayed
    And place order button is clickable and click place order

    Then order confirmation page is displayed
    When user clicks Done button

  @regression @miniRegression123
  Scenario: verify all the details including Kiosk details for DUG option

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "90505" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And verify 'Kiosk Pickup' text is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
   # Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page

    And user clicks on Continue to payment CTA
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    Then place order button is displayed
    And place order button is clickable and click place order

    Then order confirmation page is displayed
    When user clicks Done button


  @bvt_regression
  Scenario:User Place Dug Order


    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And verify 'Counter Pickup' text is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    And user clicks on Continue to payment CTA
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    Then place order button is displayed
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    Then user clicks on Continue shopping in order confirmation page
    When user select yes on alert window
    Then verify MFA home screen is displayed


  @bvt_regression
  Scenario:User place Delivery Order


    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
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
    #And checkout button is disabled on shopping cart
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page

    Then verify "Add address" window is displayed
    When user enters "address" details
    And user clicks on Continue to payment CTA
    #And user clicks on continue to payment method button
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    Then place order button is displayed
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    Then user clicks on Continue shopping in order confirmation page
    Then verify MFA home screen is displayed


  @MOLN-38291 @miniRegression

  Scenario: Verify Tooltip of SNAP option

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94611" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    Then user close the slot selection page
    And User see Snap option for payment
    When user click on Snap option for payment
    Then User should see inline message as "Remember to bring your EBT Card, and Debit or Credit card for any non-EBT items."

  @MOLN-38293

  Scenario: Verify Tooltip of SNAP option

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94611" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When user clicks search bar on home page
    And user types "pen" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "12" number of items for all item in shopping cart
    And user click check mark on shopping cart page
    When user clicks search bar on result page
    And user types "milk" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "12" number of items for all item in shopping cart

#    Then shopping cart shows 10 as total number
#    And checkout button is enabled on the shopping cart
#    And estimation total information icon is displayed
#    When scroll down the screen
#    Then cart summary is displayed on the shopping cart page
    And user clicks checkout button on cart page
    Then user close the slot selection page
    And User see Snap option for payment
    When user click on Snap option for payment
    Then user should be able to see Snap EBT Issue PopUp
    And user clicks on View Cart in the popup
    And verify Non-SNAP items displayed

  @MOLN-38294

  Scenario: Verify Tooltip of SNAP option

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94611" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When user clicks search bar on home page
    And user types "pen" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "12" number of items for all item in shopping cart
    And user click check mark on shopping cart page
    When user clicks search bar on result page
    And user types "milk" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "12" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then user close the slot selection page
    When user clicks Cart Tab on payment page
    Then shopping cart page is displayed
    And user removes the item from the cart
    And user clicks checkout button on cart page
    Then user close the slot selection page
    And User see Snap option for payment
    And User should see inline message as "The items in your cart don't qualify for SNAP EBT payment. Please pay with Credit Card."


  @smoke1

  Scenario: Verify Tooltip of Delivery Fee and estimated Total

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When user clicks search bar on home page
    And user types "milk" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "20" number of items for all item in shopping cart
#    Then shopping cart shows 10 as total number
#    And checkout button is enabled on the shopping cart
#    And estimation total information icon is displayed
#    When scroll down the screen
#    Then cart summary is displayed on the shopping cart page
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    When user select "attended" option
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    And user see delivery Fee tool tip
    And user see Estimated total tool tip

  @miniRegression
  Scenario: Verify SMS alert message on your order page

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94063" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And verify 'Counter Pickup' text is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page

    And user clicks on Continue to payment CTA
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    Then place order button is displayed


  @smoketest
  Scenario: User validates message in Checkout page
    # Reference story MMM-1798

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When user clicks search bar on home page
    And user types "baby lotion" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When scroll down the screen
    Then user should be able to see Auth message below Estimated Total
    When user scroll down
    Then user should be able to see Looking for your savings text
    When user scroll down
    Then user should be able to see savings message
    When scroll down the screen
    Then user should be able to see terms use message


  @smoke @miniRegression
  Scenario: Verify Contact in Checkout Page
    #Reference story MMM-2257
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94063" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And verify 'Counter Pickup' text is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page

    And user clicks on Continue to payment CTA
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    Then place order button is displayed
    When user clicks contact on checkout page


  @regression
  Scenario: Verify Checkout page Summary section
    When sign in to the application
    And user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    Then verify search bar appears in home page
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "10" number of items for all item in shopping cart
    Then checkout button should be enabled
    Then Click on checkout button
    Then verify new slot selection screen is displayed
    When user toggle pickup to delivery
    And user click on the day next to today
    And user click on Continue Payment on slot selection page
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    When user enters CVV number and clicks next
    And user clicks on Continue to review order
    And "Est. total" text is displayed
    And verify Place Order Button Is available

  @regression @miniRegression
  Scenario:As a new user, I want the system to direct me to address form if I have not provided one before I proceed to the payment screen.

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "10" number of items for all item in shopping cart
    Then checkout button should be enabled
    Then Click on checkout button
    Then verify new slot selection screen is displayed
    When user toggle pickup to delivery
    And user click on the day next to today
    And user click on Continue Payment on slot selection page
    And verify Add Address page is displayed

  @regression
  Scenario:As a new user, I want the system to direct me to address form if I have not provided one before and after proceeding to the payment screen.

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "10" number of items for all item in shopping cart
    Then checkout button should be enabled
    Then Click on checkout button
    Then verify new slot selection screen is displayed
    When user toggle pickup to delivery
    And user click on the day next to today
    And user click on Continue Payment on slot selection page
    And verify Add Address page is displayed
    When user click back arrow in Add Address page
    And close the slot selection screen
    Then user confirms the selection
    Then verify user navigates to Your order screen
    When user clicks Enter payment on Your order screen
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    When user enters CVV number and clicks next
    When user clicks on Continue to slot selection
    Then verify Add Address page is displayed


  @smoke @miniRegression
  Scenario:User update DUG store and verify same in Map

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94063" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And verify 'Counter Pickup' text is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
#    And user see pick up order info page
    When user click Edit option to change pickup store
    Then User see option to see change the zip code
    And user see map and stores selected


  @smoke
  Scenario:As a user, I would like to be informed about the possible impact of changing a store during checkout experience so that I can make an informed decision.

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    And user see pick up order info page
    When user click Edit option to change pickup store
    Then User see option to see change the zip code
    When User updates zipcode
    Then user is seeing the pop-up
    When user taps on continue
    Then shopping cart page is displayed
    When user clicks checkout button on cart page
    Then checkout page is displayed
    And user see pick up order info page

  @regression
  Scenario: Verify Checkout page Summary section
    When sign in to the application
    And user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    Then verify search bar appears in home page
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "10" number of items for all item in shopping cart
    Then checkout button should be enabled
    Then Click on checkout button
    Then verify new slot selection screen is displayed
    When user toggle pickup to delivery
    And user click on the day next to today
    And user click on Continue Payment on slot selection page
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    When user enters CVV number and clicks next
    And user clicks on Continue to review order
    And "Est. total" text is displayed
    And verify Place Order Button Is available

  @regression
  Scenario:As a new user, I want the system to direct me to address form if I have not provided one before I proceed to the payment screen.

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "10" number of items for all item in shopping cart
    Then checkout button should be enabled
    Then Click on checkout button
    Then verify new slot selection screen is displayed
    When user toggle pickup to delivery
    And user click on the day next to today
    And user click on Continue Payment on slot selection page
    And verify Add Address page is displayed

  @regression
  Scenario:As a new user, I want the system to direct me to address form if I have not provided one before and after proceeding to the payment screen.

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "10" number of items for all item in shopping cart
    Then checkout button should be enabled
    Then Click on checkout button
    Then verify new slot selection screen is displayed
    When user toggle pickup to delivery
    And user click on the day next to today
    And user click on Continue Payment on slot selection page
    And verify Add Address page is displayed
    When user click back arrow in Add Address page
    And close the slot selection screen
    Then user confirms the selection
    Then verify user navigates to Your order screen
    When user clicks Enter payment on Your order screen
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    When user enters CVV number and clicks next
    When user clicks on Continue to slot selection
    Then verify Add Address page is displayed

  @regression
  Scenario:Verify no app crash while user placing, editing and cancelling the order

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
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
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And user change date picker to enable save
    And user click save button on orderInfo window
    Then checkout page is displayed
    When user clicks payment on checkout pagex
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
    When user enters CVV number and clicks next
    When user clicks contact on checkout page
    Then user fills contact details
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Done button
    And user click 'yes' love the app
    Then user is logged in to the app for Existing user
    When user click menu button on home page
    Then menu page is displayed
    When user clicks orders on menu page
    Then order page is displayed
    When user click on Edit Order
    When user clicks OrderInfo on checkout page
    Then OrderInfo window is displayed
    And scroll down the screen
    And user change date picker to enable save
    And user click save button on orderInfo window
    When user click on Cart in Edit Order
    Then user decrease the all item quantity on shopping cart page
    When user click back on cart page
    Then user see Edit Order page
    When user click on confirm change button
    Then order confirmation page is displayed
    When user clicks Done button
    And click yes if you love Safeway app
    Then user is logged in to the app for Existing user
    When user click menu button on home page
    Then menu page is displayed
    When user clicks orders on menu page
    Then order page is displayed
    When user click cancel order on order page
    And user wait for cancel order pop up window
    And user click cancel order button from pop up


  @smoke
  Scenario:User click cancel on popup to update DUG store

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    And user see pick up order info page
    When user click Edit option to change pickup store
    Then User see option to see change the zip code
    When User updates zipcode
    Then user is seeing the pop-up
    When user taps on Cancel
    Then user see Popup closed


  @smoke @miniRegression12
  Scenario:User see order info page when click back on cart page after updating dug store

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94063" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And verify 'Counter Pickup' text is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
#    And user see pick up order info page
    When user click Edit option to change pickup store
    Then User see option to see change the zip code
    When User updates zipcode
    Then user is seeing the pop-up
    When user taps on continue
    Then shopping cart page is displayed
    When user clicks back button
    Then user see pick up order info page

  @promoCode @miniRegression #MEMM-661 miniRegression
  Scenario: Verify user is able to add promo code and removed a promo code - [Andriod] Promo code - Automation

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94063" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And verify 'Counter Pickup' text is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    And user clicks on Continue to payment CTA
    And user clicks on close button on Payment Screen
    And user clicks promo code on checkout page
    And user enters promo code "SAVE20" and click next
    Then verify promocode "SAVE20" gets applied
#    And user deleted a promocode
#    Then promo code "SAVE20" is removed and total adjusted accordingly


  @promoCode #MEMM-661
  Scenario:Verify user throws an error for invalid promo code - [Andriod] Promo code - Automation

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And user click aisles tab on home page
    And scroll down for "Baby Care" category
    When user clicks item "Baby Care" on aisle list
    When user clicks item "Baby Bath & Skin Care" on aisle list
    When user clicks item "Baby Lotion & Oil" on aisle list
    Then verify item is found from aisle
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then verify "Add address" window is displayed
    When user enters "address" details
    And user clicks on Continue to payment CTA
    And user clicks on close button on Payment Screen
    And user clicks promo code on checkout page
    And user enters promo code "SAVE20" and click next
    Then Verify error message for invalid promo code

  @MEMM-736
  Scenario:Verify user throws an error for invalid promo code - [Andriod] Promo code - Automation

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And user click aisles tab on home page
    And scroll down for "Baby Care" category
    When user clicks item "Baby Care" on aisle list
    When user clicks item "Baby Bath & Skin Care" on aisle list
    When user clicks item "Baby Lotion & Oil" on aisle list
    Then verify item is found from aisle
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page

  @MEMM-737 @miniRegression
  Scenario:Verify added address shown on Slot Reservation Screen

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
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
    And user clicks on items count icon displaying plus minus
    And user changes the quantity to "20" for cart item
    And user clicks checkout button on cart page
    Then checkout page is displayed
    Then verify "Add address" window is displayed
    When user enters "address" details
#    Then verify address will be shown on slot selection screen


  @MEMM-73
  Scenario:Verify when user switches from Delivery to pick-up, the first store (same store that shows up first with user searches for the given zip) for that zip gets selected by default

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "76109" in zipcode page
    Then select order type page is displayed
    When user click on pick up option
    And user store first address of store
    And user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And user click aisles tab on home page
    And scroll down for "Baby Care" category
    When user clicks item "Baby Care" on aisle list
    When user clicks item "Baby Bath & Skin Care" on aisle list
    When user clicks item "Baby Lotion & Oil" on aisle list
    Then verify item is found from aisle
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then verify "Add address" window is displayed
    And user click back arrow in Add Address page
    And user clicks on Pickup toggle
    Then the first store gets selected by default

  @MEMM-737 @miniRegression
  Scenario:verify selected store address will be shown; state and zip not to be shown for Pick-up order type

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And verify 'Counter Pickup' text is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
#    Then the first store gets selected by default

  @MEMM-737 @miniRegression
  Scenario:Verify when user switches from pick-up to delivery, the zip code provided at the start of the app will be used, if not provided then zip code for previously selected store will be used.

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And verify 'Counter Pickup' text is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    And user clicks on Delivery toggle
    Then verify zip code will be shown with CTA of Add address
#    And user clicks checkout button on cart page

#AUTHOR -SHRADDHA JAIN
  @ValidateAEMZone
  Scenario:Fresh install-new user, signout-signin user select dug/instore not showing zones on home page

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    Then verify Pros in Produce AEM zone is present
    And verify Meals made easy AEM zone is present
    Then verify Banner No CTA AEM zone is present
    Then verify LPA Banner AEM zone is present


#AUTHOR -SHRADDHA JAIN
  @ValidateAEMZoneSignINSignOut
  Scenario:Signout-signin user select dug/instore not showing zones on home page

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on profile icon
    Then user clicks on Sign out
    When sign in to the application for pickup orders
    Then verify MFA home screen is displayed
    Then verify Pros in Produce AEM zone is present
    And verify Meals made easy AEM zone is present
    Then verify Banner No CTA AEM zone is present
    Then verify LPA Banner AEM zone is present

    #AUTHOR -SHRADDHA JAIN
  @ValidateCTALabel
  Scenario:Select see all on AEM carousel from Browse Page and Return to Browse Results in infinite Loading Indicator and No user interaction

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    Then user tabs on SHOP
    And scroll down for CTA Label
    Then Verify Carousel Title is present for any zone Carousel
    And user tabs on CTA Label of Browse for any zone Carousel
    Then Verify User see sheet UI page of product Collection
    Then Close the sheet UI page
    Then Verify there is no infinity loader in browse tab
    And go to Home tab
    Then Verify there is no infinity loader in home tab

  @cartPreview @mahmud
  Scenario:User selects Delivery option and place order , then cancel order
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
    When user click on plus button to add more product on first item
#    When user clicks "1" item add button on second item
#    And user clicks shopping cart button on home page
#    Then shopping cart page is displayed
    #And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed


  @MRR-752
  Scenario:Verify All fees in Check out , Order Confirmation Pages
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
#    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
#And checkout button is disabled on shopping cart
    And user clicks on items count icon displaying plus minus
    And user changes the quantity to "20" for cart item
    And user clicks checkout button on cart page
    Then verify "Add address" window is displayed
    When user enters "address" details
    And user clicks on Continue to payment CTA
#And user clicks on continue to payment method button
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/24" as card expiration month year
    And user enters "94566" as billing zip code
    Then payment CVV window is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    Then place order button is displayed
    And place order button is clickable and click place order
    Then order confirmation page is displayed
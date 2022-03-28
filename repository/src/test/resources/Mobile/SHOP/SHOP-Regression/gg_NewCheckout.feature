Feature: pick-up and delivery new checkout flow


  @Smoke
  Scenario: user should be able to easily search for a store for my pick-up order
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    #Then user selects the In-store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks search bar on home page
    And user types "baby lotion" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then user lands on slot selection page for pickup
    And user clicks on Edit button on slot selection page for pickup
    Then user lands on select pickup store page
    And user verify "zipcode" will be pre filled if previously provided
    Then User taps on the search entry field
    Then user verify numeric keyboard is displayed
    And User enters the 5 digit Zip code
    Then user verify keyboard slides down
    Then user verify search gets auto triggered after 5 digits have been entered
    And user verify search results are scrollable
    Then user verify only DUG and WUG stores are shown in the search results
    And user verify the last store is within 50 miles radius


  @Smoke

  Scenario: user should be able to view 3 placement points for the store locations sheet for easier navigation
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    #Then user selects the In-store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks search bar on home page
    And user types "baby lotion" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then user lands on slot selection page for pickup
    And user clicks on Edit button on slot selection page for pickup
    Then user lands on select pickup store page
    Then user verify mid point is the default for select pickup store
    And Store pin is visible to the user
    When user pulls up the sheet it goes full screen
    And Store pin is not visible to the user
    And user pulls down the sheet
    Then user verify mid point is the default for select pickup store
    And Store pin is visible to the user
    Then user pulls down the sheet further it goes to minimum point
    And user verify the map is zoomed in
    And Store pin is visible to the user


  @US-34161
  Scenario: Users will be presented the credit card entry screen through the progressive flow
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    #Then user selects the In-store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks search bar on home page
    And user types "baby lotion" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user clicks on items count icon displaying plus minus
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    #Then user lands on slot selection page for pickup
    And user clicks on continue to payment method button
    #Then user verify enter card details page is displayed
    When user enters "aaa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    #Then user clicks on Done button of the keypad so that continue button is displayed to click
    #Then user clicks on continue button on credit card form
    And user verify upon landing on CVV screen, cursor will be active in CVV entry field
    Then user verify numeric keyboard is displayed
    When user enters "111" as CVV and clicks next
    Then user clicks on Done button of the keypad so that continue button is displayed to click
    And user verify On CVV screen,clicking on done dismiss keyboard
    And User verify CTA on CVV screen will be active after user has entered 3 digits
    Then new user verify continue to contact info button takes users to contact info page
    Then user close the contact info page
    And User lands Checkout summary page
    #Then user verify continue to Review Order button takes users to Checkout summary page



  @Smoke

  Scenario: Users will be presented the credit card entry screen through directly tapping on the payment card on the summary page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    #Then user selects the In-store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks search bar on home page
    And user types "baby lotion" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user clicks on items count icon displaying plus minus
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then user lands on slot selection page for pickup
    Then user close the slot selection page
    And User lands Checkout summary page
    And user taps on the payment card on the summary page
    #Then user clicks on Edit button on CVV screen
    Then user verify enter card details page is displayed
    When user enters "aaa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    And user verify upon landing on CVV screen, cursor will be active in CVV entry field
    Then user verify numeric keyboard is displayed
    When user enters "111" as CVV and clicks next
    Then user clicks on Done button of the keypad so that continue button is displayed to click
    And user verify On CVV screen,clicking on done dismiss keyboard
    And User verify CTA on CVV screen will be active after user has entered 3 digits
    Then new user verify continue to slot selection button takes users to slot selection page
    Then new user verify continue to contact info button takes users to contact info page
    Then user close the contact info page
    And User lands Checkout summary page


  @Smoke
  Scenario: When user switches from Delivery to pick-up at slot selection screen
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
   # And click on settings icon
   # And scroll down and click on developer settings
   # When turn "ON" newCheckout feature
    #When click on search field
    When user clicks on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then verify "Add address" window is displayed
    When user enters "address" details
    And change pref to Pickup
    Then verify "Add address" window is displayed
    When user enters "address" details
    And user clicks on Continue to payment CTA
    Then user lands on slot selection page for pickup
    When user close the slot selection page
    Then User lands Checkout summary page


  @Smoke1
  Scenario: When user switches from Pickup to Delivery at slot selection screen
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    #Then user selects the In-store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks search bar on home page
    And user types "baby lotion" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then user lands on slot selection page for pickup
    When change pref to delivery
    Then verify "Add address" window is displayed
    When user enters "address" details
    And user clicks on Continue to payment CTA


  Scenario:User can select an address from previously provided addresses so that user don't have to re-enter
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then verify "Add address" window is displayed
    When user enters "address" details
    And user clicks on Continue to payment CTA
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
  #  And user clicks on Continue CTA
    Then payment CVV window is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    Then place order button is displayed
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    When user clicks Done button
    #comment below, if not happening
    And user click 'yes' love the app
    Then user is logged in to the app for Existing user
    And user click Cancel in Feedback form
    And user click on Delivery Next popup
    When user clicks on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then user lands on slot selection page for delivery
    When user taps on 'edit' button on the slot selection screen
    Then Saved Addresses page opens
    Then user verify already entered address for the current session will be selected by default
    And User taps on the chevron icon
    Then user enters edit address screen
    Then user verify selected address detail prefilled
    And user clicks on back button
    Then Saved Addresses page opens
    And User can tap on plus icon to enter new address entry form
    Then verify "Add address" window is displayed
    When user enters "address2" details
    #add a different address here
    Then user verify 'Save' CTA takes users to address list screen
    #Then Saved Addresses page opens
    And user clicks on back button
    Then user lands on slot selection page for delivery
    And user verify same address is displayed on slot selection screen that was previously selected
    When user taps on 'edit' button on the slot selection screen
    And user verify 'Use this address' CTA takes users to slot selection screen
    Then user lands on slot selection page for delivery


  Scenario:User verfiy Max 13 addresses can be added to the list,post which+ sign will not be shown.
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "15" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then verify "Add address" window is displayed
    When user enters "address" details
    #And user clicks on Continue to payment CTA
    Then user lands on slot selection page for delivery
    When user taps on 'edit' button on the slot selection screen
    Then Saved Addresses page opens
    And User can tap on plus icon to enter new address entry form
    Then verify "Add address" window is displayed
    When user enters "address2" details
    And User can tap on plus icon to enter new address entry form
    Then verify "Add address" window is displayed
    When user enters "address3" details
    And User can tap on plus icon to enter new address entry form
    Then verify "Add address" window is displayed
    When user enters "address4" details
    And User can tap on plus icon to enter new address entry form
    Then verify "Add address" window is displayed
    When user enters "address5" details
    And User can tap on plus icon to enter new address entry form
    Then verify "Add address" window is displayed
    When user enters "address6" details
    And User can tap on plus icon to enter new address entry form
    Then verify "Add address" window is displayed
    When user enters "address7" details
    And User can tap on plus icon to enter new address entry form
    Then verify "Add address" window is displayed
    When user enters "address8" details
    And User can tap on plus icon to enter new address entry form
    Then verify "Add address" window is displayed
    When user enters "address9" details
    And User can tap on plus icon to enter new address entry form
    Then verify "Add address" window is displayed
    When user enters "address10" details
    And User can tap on plus icon to enter new address entry form
    Then verify "Add address" window is displayed
    When user enters "address11" details
    And User can tap on plus icon to enter new address entry form
    Then verify "Add address" window is displayed
    When user enters "address12" details
    And User can tap on plus icon to enter new address entry form
    Then verify "Add address" window is displayed
    When user enters "address13" details
    Then user verify plus icon to add address disappears after 13 addresses have been added

  @MRR625
  Scenario: User want an easy way to pick a store for Pick-up orders so that he can complete orders quickly
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    #Then user selects the In-store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks search bar on home page
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then user lands on slot selection page for pickup
    And user clicks on Edit button on slot selection page for pickup
    Then user lands on select pickup store page
    Then user verify mid point is the default for select pickup store
    And Store pin is visible to the user
    And user verify "zipcode" will be pre filled if previously provided

  @US-34767
  Scenario:User should see age restricted message on slot selection screen if the same is available in the cart
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks search bar on home page
    And user types "wine" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "20" number of items for all item in shopping cart
    #When user clicks Done button
    #Then user clears the text from search bar
    And user clicks checkout button on cart page
    Then user lands on slot selection page for pickup
    And User is able to see age restricted message
    Then User toggle for delivery in the slot selection screen
    Then user lands on slot selection page for delivery
    And User is able to see age restricted message

  @US-34804
  Scenario: User should be informed if cart size goes less than $30
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When click on search field
    And user types "wine" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user clicks on items count icon displaying plus minus
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    #And user clicks on Continue to payment CTA
    And user clicks on continue to payment method button
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
  #  And user clicks on Continue CTA
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    #Then user close the contact info page
    Then user enters contact information
    Then place order button is displayed
    And user clicks on Cart card on checkout page
    Then shopping cart page is displayed
    And user clicks on items count icon displaying plus minus
    And user change quantity to "5" for all item in shopping cart
    Then User verify that the cart value is less than 30 dollars
    And user clicks back button to close the cart and land on checkout
    And user is able to see the alert message as cart size goes less than 30 dollars
    Then place order button is displayed

  @US-35317
  Scenario: User should see a pre-view of my cart in the Checkout screen so that cart can be quickly accessed if needed
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed

    When click on search field
    And user types "wine" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item

    When click on search field
    When user clears the text from search bar
    And user types "milk" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item

    When click on search field
    When user clears the text from search bar
    And user types "eggs" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item

    When click on search field
    When user clears the text from search bar
    And user types "Bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item

    When click on search field
    When user clears the text from search bar
    And user types "water" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item

    When click on search field
    When user clears the text from search bar
    And user types "chicken" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item

    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
      #And checkout button is disabled on shopping cart
    And user clicks on items count icon displaying plus minus
    And user change quantity to "10" number of items for all item in shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    #And user clicks on Continue to payment CTA
    And user clicks on continue to payment method button
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94566" as billing zip code
  #  And user clicks on Continue CTA
    Then payment CVV window is displayed
    When user enters "111" as CVV and clicks next
    #Then user close the contact info page
    Then user enters contact information
    Then place order button is displayed

    Then user verify thumbnails of 4 items is shown
    And If there are more than 4 items, plus X will be shown
      #(X=Total items - 4)
    And total number of items will be shown
    And the entire feild will be tappable, not just the chevron

    And user clicks on Cart card on checkout page
    Then shopping cart page is displayed

  @StoreMapValidation
  Scenario: Verify if the user is able to select the stores from the picker - pick up fulfillment type
#  When click on NewSignup Api for OTP
#  Then zipcode page is displayed
#  When user enters "zipcode" in zipcode page
#  Then select order type page is displayed
#  When user clicks pickup on delivery select page
#  Then store list is displayed
#  And user click start shopping button on Sign In page
#  Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    When user clicks on Edit chevron button
    Then user navigates to respective store details on map view
    Then user clicks on multiple stores to view the details of the store

  @MRR45
  Scenario:Verify Driver Tipping should not be Displayed for PICKUP orders in Edit Order Flow.
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "60559" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on search field
    And user types "bread" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
   # And user change quantity to "10" number of items for all item in shopping cart
   # And user clicks checkout button on cart page
   # When user clicks on Edit chevron button
   # Then user navigates to respective store details on map view
   # Then user clicks on multiple stores to view the details of the store
    And user change quantity to "20" number of items for all item in shopping cart
    And user clicks checkout button on cart page
#   And user clicks on Continue to payment CTA at the slot selection
    And user clicks on Continue to payment CTA
    Then user enters "visa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "09/22" as card expiration month year
    And user enters "94523" billing zip code
    And user click save card details checkbox and continue
    Then payment CVV window is displayed
#   Then user verify numeric keyboard is displayed
    And user enters "111" as cvv number
    Then user enters contact information
    Then place order button is displayed
    And user verify driver tipping option is displayed
    When user update tip to 10%
    And place order button is clickable and click place order
    And order confirmation page is displayed

  @US-35968
  Scenario:Verify Map displayed for Delivery Order in the Order History screen
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
    And user clicks on items count icon displaying plus minus
    And user changes the quantity to "20" for cart item
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
    And user note the order number
    Then user clicks on Continue shopping in order confirmation page
    Then verify MFA home screen is displayed
    And user clicks on hamburger menu
    Then user clicks on orders button
    Then user lands on order history page
    And user verify the order number
    Then user verify Map displayed for Delivery Order in the Order History screen

  @US-36389
  Scenario:Verify the cancel order pop up tittle and the copy in the pop up in Order Details screens
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
    And user clicks on items count icon displaying plus minus
    And user changes the quantity to "20" for cart item
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
    And user note the order number
    Then user clicks on Continue shopping in order confirmation page
    Then verify MFA home screen is displayed
    And user clicks on hamburger menu
    Then user clicks on orders button
    Then user lands on order history page
    And user verify the order number
    And user scroll down for track order link
    Then user clicks on track order to go to order details page
    And user scroll down for cancel order link
    Then user clicks on cancel order
    Then user verify the cancel order popup appears
    And Verify the Pop up tittle be "Cancel Order?"
    Then Verify the copy in the pop up "Please confirm that you would like to cancel this order"


  # YRM-203
  Scenario:User should be able to switch between delivery addresses
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And user clicks on member tab
    And user clicks account on member tab
    And user clicks on Add address carousel
    And user clicks on Add delivery address
    When user enters "address" details
    And User can tap on plus icon to enter new address entry form
    Then verify "Add address" window is displayed
    When user enters "address2" details
    Then verify two address are saved
    Then switch to address two from saved addresses


    #YRM-341 #YRM-340
  Scenario:Validate user is able to add birthday from profile info screen and not able to edit it once added and add contact phone number and edit it.
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    And user clicks on member tab
    Then user navigates to personal info screen
    And user adds DOB
    Then verify Date of birth is not editable
    When user click edit contact phone number on account page
    Then contact phone number edit window is displayed
    When user edit new contact phone number on account edit window
    And user clicks back button on store phone edit window
    When popup save confirm message
    And user select "yes" on save confirm window
    And user verify new contact phone number is displayed
    When user click edit contact phone number on account page
    Then contact phone number edit window is displayed
    When user edit original contact phone number on account edit window
    And user clicks back button on store phone edit window
    When popup save confirm message
    And user select "yes" on save confirm window
    And user verify new contact phone number is displayed
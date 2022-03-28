Feature: freshpass regression

  @demoSprnt
  Scenario:validate new member ,subscribe ,place an order and cancel freshpass membership

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    And user click start shopping button on Sign In page
    Then complete tutorial flow
    When user clicks on member tab
    Then user clicks on freshpass at member tab
    When Trial button is selected
    When Freshpass page is displayed
    When user clicks on selecttab of annual plan
    When user clicks add new card on page
    When user enters "aaa" as name on credit card
    And user enters "4112344112344113" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code

    When user enters "111" as CVV and clicks next
    And Iagree box is selected
    And Startsubscription tab is clicked
    Then navigate to homepage
    When click on search field
    Then user add item to cart and click checkout
    Then user enters delivery address
    And Verify Delivery Fee is not FREE
    Then delivery time slot is selected oflaterdays
    When user enters "aaa" as name on credit card
    And user enters "4242424242424242" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    When user enters "111" as CVV and clicks continue
    Then user enters contact details
    When place order button is clickable and click place order
    When user clicks Continue Shopping
#    Then popup feedback alert window
#    Then popup rating window
#    When user select not now button
#    When user clicks Done button
#    When user select yes on alert window
    When user clicks on homeicon
    When user clicks on profile icon
    When FreshPass page is selected
    When cancelFreshPass is selected
    Then user selects cancel reason
    And user clicks on yes tab
    Then validate cancel subscription page
    When user clicks on shop now


  Scenario: new ,validate save link @member page,subscribe monthly plan ,validate text and change plan

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    And user click start shopping button on Sign In page
    Then complete tutorial flow
    When user clicks on member tab
    Then user clicks on freshpass at member tab
#    Then user verify How much you could save
#    When user click on the dollar 425 link
#    Then user should see Estimated Savings is appear with text
    When Trial button is selected
    When Freshpass page is displayed
    Then validate Both plans are displayed
    Then FAQ text is displayed
    When user clicks on selecttab of monthly plan
    When user clicks add new card on page
    When user enters "aaa" as name on credit card
    And user enters "4112344112344113" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    Then payment CVV window is displayed
    When CVV number is refreshed with choose date
    When user enters "111" as CVV and clicks next
    And Iagree box is selected
    And Startsubscription tab is clicked
    Then navigate to homepage
    When user clicks on homeicon
    When user clicks on profile icon
    When FreshPass page is selected
    Then user validates card number "4112344112344113" entered from freshpass page
    Then cancelFreshPass is displayed
    When user clicks on Change tab
    Then user clicks on selects tab
    When CVV number is refreshed with choose date
    When user enters "111" as CVV and clicks next
    And Iagree box is selected
    When confirm tab is selected
    Then Current plan is displayed
    And user new plan is displayed
    Then Done button is selected
    When user clicks on homeicon
    When user clicks on profile icon
    When FreshPass page is selected

  Scenario: verify page of suspended freshpass account
    When Signin to the application with existing FP user in suspended state
    Then user clicks notnow text
    Then user handle landing scenario
    When user clicks on profile icon
    Then validate Freshpass text at setting
    When FreshPass page is selected
    Then Freshpass  Text is displayed
    And Validate suspended text
    When FreshPass section  is selected
    Then Freshpass page is displayed
    And validate card expired text
    When user clicks on member tab
    Then user clicks on freshpass at member tab
    Then suspended text is displayed

  Scenario: verify cancellation of active annual user

    When Signin to the application with existing annual FreshPass user
    Then navigate to homepage
    When user clicks on profile icon
    Then validate Freshpass text at setting
    When FreshPass page is selected
    When FreshPass section  is selected
    When Freshpass page is displayed
    When cancelFreshPass is selected
    Then user selects cancel reason
    And user clicks on yes tab
    When user clicks Done button
    When FreshPass section  is selected
    Then user clicks unsubscribed
    Then validate Both plans are displayed
    Then navigate to homepage
    When user clicks on profile icon
    Then validate Freshpass text at setting
    Then user clicks unsubscribed
    Then validate Both plans are displayed


  Scenario: verify re-enroll of annual user

    When Signin to the application with existing annual FreshPass user
    Then navigate to homepage
    When user clicks on profile icon
    Then validate Freshpass text at setting
    When FreshPass page is selected
    When Freshpass page is displayed
    When cancelFreshPass is selected
    Then user selects cancel reason
    And user clicks on yes tab
    When user clicks Done button
    When FreshPass section  is selected
    Then user clicks unsubscribed
    When user clicks on selecttab of annual plan
    When CVV number is refreshed with choose date
    When user enters "111" as CVV and clicks next
    And Iagree box is selected
    And Startsubscription tab is clicked
    Then Done tab is selected
    When user clicks on homeicon
    When user clicks on profile icon
    Then validate Freshpass text at setting
    When FreshPass page is selected

  Scenario:validate freshpass disclaimer

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    And select the delivery store
    And user click start shopping button on Sign In page
    Then complete tutorial flow
    Then navigate to homepage
    When click on search field
    Then user add item to cart and click checkout
    Then user enters delivery address
    When user clicks on freshpass banner
    And Selects Annual free trail plan
    When user taps on signup button on select plan screen
    Then Verify Fresh Plan Added banner in checkout screen
    And Verify Delivery Fee is FREE
    And user clicks on continue to payment method button
    And user clicks on close button on Payment Screen
    And verify Delivery fee is Free with FreshPass displayed in order summary
    And verify disclaimer for user signed up annual plan
    Then user clicks on slot selection card on order summary page
    When user clicks on freshpass banner
    And Selects Monthly free trail plan
    When user taps on signup button on select plan screen
    Then Verify Fresh Plan Added banner in checkout screen
    And Verify Delivery Fee is FREE
    And user clicks on continue to payment method button
    And user clicks on close button on Payment Screen
    And verify Delivery fee is Free with FreshPass displayed in order summary
    And verify Disclaimer for new user signed up for monthly plan



#    ios done
  Scenario:New user can place the order with Monthly free trail plan signup from checkout
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then complete tutorial flow
    When click on search field
    Then user add item to cart and click checkout
    Then user enters delivery address
    When user clicks on freshpass banner
    And Selects Monthly free trail plan
    When user taps on signup button on select plan screen
    Then Verify Fresh Plan Added banner in checkout screen
    And user clicks on continue to payment method button
    When user enters "aaa" as name on credit card
    And user enters "4112344112344113" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    Then "Confirm CVV" text is displayed on the screen
    When enters "111" as CVV
    Then user enters contact information
    And verify Delivery fee is Free with FreshPass displayed in order summary
#    And verify Disclaimer for new user signed up for monthly plan
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    And verify Delivery fee is Free with FreshPass displayed in order confirmation page
    And verify Disclaimer for new user signed up for monthly plan in order confirmation screen
    When user clicks Done button
    And go to Home tab
    And click 'Yes' if 'Love the app' popup is displayed
   # And click close button on setting page
    When user clicks on member tab
    Then user clicks on freshpass at member tab
    Then user is free trail Monthly subscribed


  Scenario:Reenroll user change the plan from monthly to annual from slots screen and verify order summary disclaimer and delivery fee
    When sign in to the application using reenroll user
    Then verify MFA home screen is displayed
    #When user click item add on carousel in HomePage
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    And if Service Problem is displayed
    Then verify "Add address" window is displayed
    When user enters "address" details
    When user enters "aaa" as name on credit card
    And user enters "4112344112344113" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    Then "Confirm CVV" text is displayed on the screen
    When enters "111" as CVV
    Then user enters contact information
    Then user clicks on slot selection card on order summary page
    When user clicks on freshpass banner
    And Selects Monthly plan
    When user taps on signup button on select plan screen
    Then Verify Fresh Plan Added banner in checkout screen
    And Verify Delivery Fee is FREE
    And click on Continue to review order Or Save
    #And user clicks on close button on Payment Screen
    And enter cvv if cvv screen is displayed
   # Then user clicks on slot selection card on order summary page
    And verify Delivery fee is Free with FreshPass displayed in order summary
    And verify disclaimer for reenrol user signed up for monthly plan
    Then user clicks on slot selection card on order summary page
    When user clicks on freshpass banner
    And Selects Annual plan
    When user taps on signup button on select plan screen
    Then Verify Fresh Plan Added banner in checkout screen
    And Verify Delivery Fee is FREE
    And click on Continue to review order Or Save
    #And user clicks on close button on Payment Screen
    And verify Delivery fee is Free with FreshPass displayed in order summary
    And verify disclaimer for reenrol user signed up for annaul plan
    Then user clicks on slot selection card on order summary page
    When user clicks on freshpass banner
    And deselects Annual free trail plan
    Then user taps on back button in select plan screen
    And user wait for "20" seconds to pass
    And Verify Fresh Pass banner for reenrol user

  Scenario:validate slots screen and order summary for monthly freshpass user subscribed from member tab
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on member tab
    Then user clicks on freshpass at member tab
    When Trial button is selected
    When Freshpass page is displayed
    When user clicks on selecttab of monthly plan
    When user clicks add new card on page
    When user enters "aaa" as name on credit card
    And user enters "4112344112344113" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    Then payment CVV window is displayed
   # When CVV number is refreshed with choose date
    When user enters "111" as CVV and clicks next
    And Iagree box is selected
    And Startsubscription tab is clicked
    Then user is free trail Monthly subscribed
    And click on home
    When user click item add on carousel in HomePage
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
   # And if Service Problem is displayed
    Then verify "Add address" window is displayed
    When user enters "address" details
    And user clicks on continue to payment method button
    When user enters "aaa" as name on credit card
    And user enters "4112344112344113" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    Then "Confirm CVV" text is displayed on the screen
    When enters "111" as CVV
    Then user enters contact information
    And verify Delivery fee is Free with FreshPass displayed in order summary
    And verify Disclaimer for new user signed up for monthly plan is not displayed
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    And verify Delivery fee is Free with FreshPass displayed in order confirmation page


  @smoke
  Scenario:validate slots screen and order summary for annual freshpass user subscribed from member tab
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks on member tab
    Then user clicks on freshpass at member tab
    When Trial button is selected
    When Freshpass page is displayed
    When user clicks on selecttab of annual plan
    When user clicks add new card on page
    When user enters "aaa" as name on credit card
    And user enters "4112344112344113" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    Then payment CVV window is displayed
    #When CVV number is refreshed with choose date
    When user enters "111" as CVV and clicks next
    And Iagree box is selected
    And Startsubscription tab is clicked
    Then user is free trail annual subscribed
    And click on home
    When user click item add on carousel in HomePage
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
   # And if Service Problem is displayed
    Then verify "Add address" window is displayed
    When user enters "address" details
    And user clicks on continue to payment method button
    When user enters "aaa" as name on credit card
    And user enters "4112344112344113" as credit card number
    And user enters "1226" as card expiration month year
    And user enters "99999" as billing zip code
    Then "Confirm CVV" text is displayed on the screen
    When enters "111" as CVV
    Then user enters contact information
    And verify Delivery fee is Free with FreshPass displayed in order summary
    And verify disclaimer for user signed up annual plan is not displayed
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    And verify Delivery fee is Free with FreshPass displayed in order confirmation page

  Scenario:Verify FreshPass banner and delivery fee is not FREE in checkout slots screen for suspended user
    When Signin to the application with existing FP user in suspended state
    Then verify MFA home screen is displayed
    When user click item add on carousel in HomePage
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    And if Service Problem is displayed
    Then verify "Add address" window is displayed
    When user enters "address" details
    And user lands on slot selection page for delivery
    And Verify Fresh Pass banner for Active user
    And Verify Delivery Fee is not FREE


  Scenario:Verify FreshPass banner and delivery fee in checkout slots screen for Pending Cancellation user
    When Signin to the application with existing FP user in Pending Cancellation
    Then verify MFA home screen is displayed
    When user click item add on carousel in HomePage
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    And if Service Problem is displayed
    Then verify "Add address" window is displayed
    When user enters "address" details
    And user lands on slot selection page for delivery
    And Verify Fresh Pass banner for Active user
    And Verify Delivery Fee is FREE

  Scenario:Verify select Freshpass screen for reenroll new user
    When sign in to the application using reenroll user
    Then verify MFA home screen is displayed
   # When user click item add on carousel in HomePage
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    #And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    And if Service Problem is displayed
    When user clicks on freshpass banner
    And Verify select Plan Screen for reenroll user
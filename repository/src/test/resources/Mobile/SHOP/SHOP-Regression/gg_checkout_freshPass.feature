Feature:Checkout FreshPass Flow

  @smoke1
  Scenario:Verify FreshPass banner in checkout slots screen for new user
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
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
    And Verify Fresh Pass banner for new user

  @smoke1
  Scenario:Verify select Freshpass screen for new user
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
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
    When user clicks on freshpass banner
    And Verify select Plan Screen for new user

  @smoke1
  Scenario:Verify FreshPass banner in checkout slots screen for reenroll user
    When sign in to the application using reenroll user
    Then verify MFA home screen is displayed
    #When user click item add on carousel in HomePage
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    #And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    And if Service Problem is displayed
    And Verify Fresh Pass banner for reenrol user

  @smoke1
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


  @smoke
  Scenario:Verify FreshPass banner and delivery fee in checkout slots screen and order summary for Annual user
    When Signin to the application with existing annual FreshPass user
    Then verify MFA home screen is displayed
   # When user click item add on carousel in HomePage
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    #And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    #And if Service Problem is displayed
    #Then verify "Add address" window is displayed
    #When user enters "address" details
    And go to slots screen
    And Verify Fresh Pass banner for Active user
    And Verify Delivery Fee is FREE
    And click on continue to payment or Continue to review order Or Save
    And verify Delivery fee is Free with FreshPass displayed in order summary


  @smoke
  Scenario:Verify FreshPass banner and delivery fee in checkout slots screen and order summary for Monthly user
    When Signin to the application with existing Monthly FreshPass user
    Then verify MFA home screen is displayed
   # When user click item add on carousel in HomePage
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    #And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    #And if Service Problem is displayed
    #Then verify "Add address" window is displayed
    #When user enters "address" details
    And go to slots screen
    And Verify Fresh Pass banner for Active user
    And Verify Delivery Fee is FREE
    And click on continue to payment or Continue to review order Or Save
    And verify Delivery fee is Free with FreshPass displayed in order summary

  @smoke1
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


  @smoke1
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


  @smoke1
  Scenario:Verify user can add Annual free trail plan and remove added plan in checkout from slots screen for new user
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
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
    When user clicks on freshpass banner
    And Selects Annual free trail plan
    When user taps on signup button on select plan screen
    Then Verify Fresh Plan Added banner in checkout screen
    When user clicks on freshpass banner
    And deselects Annual free trail plan
    And user taps on back button in select plan screen
    Then Verify Fresh Pass banner for new user

  @smoke1
  Scenario:Verify user can add Monthly free trail plan and remove added plan in checkout from slots screen for new user
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
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
    When user clicks on freshpass banner
    And Selects Monthly free trail plan
    When user taps on signup button on select plan screen
    Then Verify Fresh Plan Added banner in checkout screen
    When user clicks on freshpass banner
    And deselects Monthly free trail plan
    And user taps on back button in select plan screen
    Then Verify Fresh Pass banner for new user


  @smoke1
  Scenario:Verify FreshPlan added banner is displayed on Annual plan signup from checkout for reenroll user
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
    And Selects Annual plan
    When user taps on signup button on select plan screen
    Then Verify Fresh Plan Added banner in checkout screen
    When user clicks on freshpass banner
    And deselects Annual free trail plan
    Then user taps on back button in select plan screen
    And user wait for "20" seconds to pass
    And Verify Fresh Pass banner for reenrol user


  @smoke1
  Scenario:Verify FreshPlan added banner is displayed on Monthly plan signup from checkout for reenroll user
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
    And Selects Monthly plan
    When user taps on signup button on select plan screen
    Then Verify Fresh Plan Added banner in checkout screen
    When user clicks on freshpass banner
    And deselects Monthly free trail plan
    Then user taps on back button in select plan screen
    And user wait for "20" seconds to pass
    And Verify Fresh Pass banner for reenrol user

  @smoke
  Scenario:New user can place the order with Annual free trail plan signup from checkout
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
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
    When user clicks on freshpass banner
    And Selects Annual free trail plan
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
    And verify disclaimer for user signed up annual plan
    And place order button is clickable and click place order
    Then order confirmation page is displayed
    And verify Delivery fee is Free with FreshPass displayed in order confirmation page
    And verify Disclaimer for new user signed up for annual plan in order confirmation screen
    When user clicks Done button
    And go to Home tab
    And click 'Yes' if 'Love the app' popup is displayed
    #And click close button on setting page
    When user clicks on member tab
    Then user clicks on freshpass at member tab
    Then user is free trail annual subscribed

  @smoke
  Scenario:New user can place the order with Monthly free trail plan signup from checkout
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
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
    And verify Disclaimer for new user signed up for monthly plan
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


  @smoke
  Scenario:New user change the plan from annual to monthly from slots screen and verify order summary disclaimer and delivery fee
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user click item add on carousel in HomePage
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    #And if Service Problem is displayed
    Then verify "Add address" window is displayed
    When user enters "address" details
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


  @smoke
  Scenario:New user change the plan from Monthly to annual from slots screen and verify order summary disclaimer and delivery fee
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user click item add on carousel in HomePage
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
   # And if Service Problem is displayed
    Then verify "Add address" window is displayed
    When user enters "address" details
    When user clicks on freshpass banner
    And Selects Monthly free trail plan
    When user taps on signup button on select plan screen
    Then Verify Fresh Plan Added banner in checkout screen
    And Verify Delivery Fee is FREE
    And user clicks on continue to payment method button
    And user clicks on close button on Payment Screen
    And verify Delivery fee is Free with FreshPass displayed in order summary
    And verify Disclaimer for new user signed up for monthly plan
    Then user clicks on slot selection card on order summary page
   # Then user close the slot selection page
    When user clicks on freshpass banner
    And Selects Annual free trail plan
    When user taps on signup button on select plan screen
    Then Verify Fresh Plan Added banner in checkout screen
    And Verify Delivery Fee is FREE
    And user clicks on continue to payment method button
    And user clicks on close button on Payment Screen
    And verify Delivery fee is Free with FreshPass displayed in order summary
    And verify disclaimer for user signed up annual plan


  @smoke
  Scenario:Reenroll user change the plan from annual to monthly from slots screen and verify order summary disclaimer and delivery fee
    When sign in to the application using reenroll user
    Then verify MFA home screen is displayed
    #When user click item add on carousel in HomePage
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    #And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    #And if Service Problem is displayed
    #Then verify "Add address" window is displayed
    #When user enters "address" details
    #Then user enters "111" as CVV
    #Then user clicks on slot selection card on order summary page
    And go to slots screen
    When user clicks on freshpass banner
    And Selects Annual plan
    When user taps on signup button on select plan screen
    Then Verify Fresh Plan Added banner in checkout screen
    And Verify Delivery Fee is FREE
    And user close the slot selection page
    #And user clicks on close button on Payment Screen
    And verify Delivery fee is Free with FreshPass displayed in order summary
    And verify disclaimer for reenrol user signed up for annaul plan
    Then user clicks on slot selection card on order summary page
    When user clicks on freshpass banner
    And Selects Monthly plan
    When user taps on signup button on select plan screen
    Then Verify Fresh Plan Added banner in checkout screen
    And Verify Delivery Fee is FREE
    And click on Continue to review order Or Save
    #And user clicks on close button on Payment Screen
    And enter cvv if cvv screen is displayed
    And verify Delivery fee is Free with FreshPass displayed in order summary
    And verify disclaimer for reenrol user signed up for monthly plan
    Then user clicks on slot selection card on order summary page
    When user clicks on freshpass banner
    And deselects Monthly free trail plan
    Then user taps on back button in select plan screen
    And user wait for "20" seconds to pass
    And Verify Fresh Pass banner for reenrol user


  @smoke
  Scenario:Reenroll user change the plan from monthly to annual from slots screen and verify order summary disclaimer and delivery fee
    When sign in to the application using reenroll user
    Then verify MFA home screen is displayed
    #When user click item add on carousel in HomePage
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    #And user change quantity to "10" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then checkout page is displayed
    #And if Service Problem is displayed
    #Then verify "Add address" window is displayed
    #When user enters "address" details
    #When user enters "aaa" as name on credit card
    #And user enters "4112344112344113" as credit card number
    #And user enters "1226" as card expiration month year
    #And user enters "99999" as billing zip code
    #Then "Confirm CVV" text is displayed on the screen
   # When enters "111" as CVV
    #Then user enters contact information
    #Then user clicks on slot selection card on order summary page
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

  @smoke
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


Feature: Dashboard - Contactless Pay Banner

  #C69442
  @regression @module_dashboard @start_scenario
  Scenario: As a user, I should able to navigate to the 'Set up contactless pay' flow when user clicks on 'Set up contactless pay' banner in the Dashboard
    When sign up to the application with popup handling
    And go to Home tab
    And select the store which has contact less pay banner
    When scroll down upto 'Setup contactless pay' banner
    Then verify 'Setup contactless pay' banner
    And click on 'Setup contactless pay' banner
    Then verify 'Setup contactless pay' screen is displayed
    And handle tutorial for contact less pay set up
    And user closes pay screen
    When scroll up to profile icon on home page
    And scroll down upto 'Setup contactless pay' banner
    Then verify 'Setup contactless pay' banner

  #C69444
  @regression @module_dashboard
  Scenario: As a user, I should able to see contactless pay banner as per design and respective banner
    When scroll down upto 'Setup contactless pay' banner
    Then verify 'Setup contactless pay' banner

  #C46223
  @regression @module_dashboard @functional @smoke
  Scenario: As a user, I want to see the setup contactless pay banner on the wallet screen if I have not setup contactless pay on my account
    When go to Wallet in Member tab
    Then verify wallet header
    When scroll down to 'Setup contactless pay' banner on wallet screen
    Then verify 'Setup contactless pay' banner in Wallet screen

  #C46323
  @regression @module_dashboard @functional
  Scenario: As a user, I should navigate back and forth from payless banner and next screen
    When go to Wallet in Member tab
    Then verify wallet header
    When scroll down to 'Setup contactless pay' banner on wallet screen
    And click on 'Setup contactless pay' banner in Wallet screen
    And user closes pay screen
    Then verify 'Setup contactless pay' banner in Wallet screen

   #C67160
  @regression @module_dashboard
  Scenario: Verify that the Wallet with the payment card  is per Figma design
    When go to Wallet in Member tab
    Then verify wallet header
    When scroll down to 'Setup contactless pay' banner on wallet screen
    And verify 'Setup contactless pay' banner in Wallet screen

   #C30091
  @regression @module_dashboard
  Scenario: Killing and relaunching the app. Pay card.
    When go to Wallet in Member tab
    Then verify wallet header
    When scroll down to 'Setup contactless pay' banner on wallet screen
    And verify 'Setup contactless pay' banner in Wallet screen
    And click on 'Setup contactless pay' banner in Wallet screen
    And user closes pay screen
    Then verify 'Setup contactless pay' banner in Wallet screen
    And kill the application
    And relaunch the application
    And handle zip code page if displayed
    And click continue option on pop up
    And handle tutorial if displayed
    Then verify home screen is displayed
    When go to Wallet tab
    Then verify wallet header
    When scroll down to 'Setup contactless pay' banner on wallet screen
    And click on 'Setup contactless pay' banner in Wallet screen
    And user closes pay screen
    And verify 'Setup contactless pay' banner in Wallet screen

    #C70035
  @regression @module_dashboard @end_scenario
  Scenario:  As a user , i want see Update copy for Contactless pay banner on both Home page & on Wallet page
    When go to Home tab
    And scroll down upto 'Setup contactless pay' banner
    Then verify title & description of contactless pay
    When go to Wallet in Member tab
    Then verify wallet header
    When scroll down to 'Setup contactless pay' banner on wallet screen
    Then verify 'Setup contactless pay' banner in Wallet screen
    And verify title & description of contactless pay in wallet screen


    #AJ #YRM-134
 #@ @Ajith @AJI
 # Scenario: validate contactless pay carousal
   # When click on NewSignup Api for OTP
  #  Then zipcode page is displayed
   # When user enters "94566" in zipcode page
   # Then select order type page is displayed
   #  When user click on pick up option
   # Then click on radio to select 7499 dublin store
    #And  user click start shopping button on Sign In page
   # Then user is logged in to the app for Existing user
   # Then verify MFA home screen is displayed
   # Then click on Hamburger menu and select developer settings
   # And  switch on My Account Feature Enabled
   # And kill the application
   # And relaunch the application
    #Then verify MFA home screen is displayed
    # Then click on Members icon
    #Then click on Account screen
    #And verify title & description of contactless pay in Account screen


  @smoke @YRM-172
  Scenario:User selects Delivery option and place order
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When click on search field
    And user types "water" on search bar and click search on home page
    Then verify result is displayed on the page
    When user clicks "1" item add button on first item
    And user clicks shopping cart button on home page
    Then shopping cart page is displayed
    And checkout button is disabled on shopping cart
    And user change quantity to "11" number of items for all item in shopping cart
    And user clicks checkout button on cart page
    Then verify "Add address" window is displayed
    When user enters "address" details
    And user clicks on Continue to payment CTA
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
    Then get order number from order confirmation page
    When user clicks Continue Shopping
    Then verify MFA home screen is displayed
    When click on settings icon
    When click on Order button
    Then past orders list is displayed on the order page
    And verify placed order displayed in the Order History screen


    #AJ #YRM-123
  @AJI @YRM-123
  Scenario: Validate navigations from Hamburger menu
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    Then click on hamburger menu
    And click on Account from settings and verify
    Then click on home
    Then click on hamburger menu
    And click on freshpass from settings and verify
    Then click on home
    Then click on hamburger menu
    And click on Help/FAQ button in settings
    And validate help/FAQ header
    Then click on home
    Then click on hamburger menu
    And click on Feedback button
    And Validate Feedback header
    Then click on home
    Then click on hamburger menu
    And click on Contact us module
    And validate Contact us header
    Then click on home
    Then click on hamburger menu
    And click on terms & policies
    And Validate Terms and Policies header

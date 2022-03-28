@bogo_item
Feature: Feature for bogo items


  @smoke @regression
  Scenario: As a user i should be able to see the 'Bogo' category in the navigation bar

    When sign in to the application for delivery orders
#    And allow push notification permission
#    When user clicks delivery option on home page
#    Then zipcode page is displayed
#    When user enters "zipcode" in zipcode page
##    And user clicks next button after registration on zipcode page
#    Then user click delivery option
#    And user click start shopping button on Sign In page
    When go to Deals tab
#    And please take survey
    Then verify deals screen is displayed
    And verify 'Bogo' tab is displayed
    When user navigate to 'BOGO' Tab
#    And go to 'Bogo' Menu Items
    Then verify that 'Bogo' Text is displayed

  @bvt_regression
  Scenario:User selects instore option and navigate to BOGO Option

#    When sign in to the application for delivery orders
#
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When go to Deals tab
    And user click Dismiss
    Then verify deals screen is displayed
    When user navigate to 'BOGO' Tab

    And user clicks Bogo item on deals page
    And user scroll down for Buy One Get One Free offer
    And adds the first BOGO offer
    And user clicks shopping cart button on home page
    Then verify BOGO offer is added in cart


  @bvt_regression
  Scenario: User selects pickup option and navigate to BOGO Option
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
    When go to Deals tab
    And user click Dismiss
    Then verify deals screen is displayed
    When user navigate to 'BOGO' Tab
    And user clicks Bogo item on deals page
    And user scroll down for Buy One Get One Free offer
    And adds the first BOGO offer
    And user clicks shopping cart button on home page
    Then verify BOGO offer is added in cart

  @regression
  Scenario: Scenario 1 :Verify Minimize Crash Scenario on Home, Browse, Deals, My List , Member , Wallet, For You, Cart
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
#    When user clicks 1st store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
#    Then verify home screen is displayed
    Then verify MFA home screen is displayed
    Then verify Home tab is selected
    When go to Browse tab
    Then verify Browse tab is selected
    When user closes and launch the app
    Then  verify Browse tab is selected

  @regression
  Scenario: Scenario 2 :Verify Minimize Crash Scenario on Home, Browse, Deals, My List , Member , Wallet, For You, Cart
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
#    When user clicks 1st store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
#    Then verify home screen is displayed
    Then verify MFA home screen is displayed
    When go to Home tab
    Then verify Home tab is selected
    When navigate to deals tab
    Then verify Deals tab is selected
    When user closes and launch the app
    Then verify Deals tab is selected

  @regression
  Scenario: Scenario 3 :Verify Minimize Crash Scenario on Home, Browse, Deals, My List , Member , Wallet, For You, Cart
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
#    When user clicks 1st store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
#    Then verify home screen is displayed
    Then verify MFA home screen is displayed
    When go to Home tab
    Then verify Home tab is selected
    When Click on my list tab
    Then verify My Items tab is selected
    When user closes and launch the app
    Then verify My Items tab is selected

  @regression
  Scenario: Scenario 4 :Verify Minimize Crash Scenario on Home, Browse, Deals, My List , Member , Wallet, For You, Cart
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
#    When user clicks 1st store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
#    Then verify home screen is displayed
    Then verify MFA home screen is displayed
    When go to Home tab
    Then verify Home tab is selected
    When Click on my list tab
    Then verify My Items tab is selected
    When user closes and launch the app
    Then verify My Items tab is selected

  @regression
  Scenario: Scenario 5 :Verify Minimize Crash Scenario on Home, Browse, Deals, My List , Member , Wallet, For You, Cart
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
#    When user clicks 1st store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
#    Then verify home screen is displayed
    Then verify MFA home screen is displayed
    When go to Home tab
    Then verify Home tab is selected
    When go to Wallet tab
    Then verify wallet tab is selected
    When user closes and launch the app
    Then verify wallet tab is selected


  @regression
  Scenario: Scenario 6 :Verify Minimize Crash Scenario on Home, Browse, Deals, My List , Member , Wallet, For You, Cart
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
#    When user clicks 1st store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
#    Then verify home screen is displayed
    Then verify MFA home screen is displayed
    When go to Home tab
    Then verify Home tab is selected
    When go to Member tab
    Then verify member tab selected
    When user closes and launch the app
    Then verify member tab selected

  @regression
  Scenario: Scenario 7 :Verify Minimize Crash Scenario on Home, Browse, Deals, My List , Member , Wallet, For You, Cart
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
#    When user clicks 1st store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
#    Then verify home screen is displayed
    Then verify MFA home screen is displayed
    When go to Home tab
    Then verify Home tab is selected
    When go to cart screen
    Then checkout button is disabled on shopping cart
    When user closes and launch the app
    Then checkout button is disabled on shopping cart


  @regression
  Scenario: Scenario 8 :Verify Minimize Crash Scenario on Home, Browse, Deals, My List , Member , Wallet, For You, Cart
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then store list is displayed
    Then user selects the In-store on the list
#    When user clicks 1st store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
#    Then verify home screen is displayed
    Then verify MFA home screen is displayed
    When go to Home tab
    Then verify Home tab is selected
    When navigate to deals tab
    Then verify Deals tab is selected
    When clicks ForU tab
    Then for u tab selected
    When user closes and launch the app
    Then for u tab selected

  @MOLN-3999
  Scenario: User selects pickup option and navigate to BOGO Option
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
    When go to Deals tab
    And user click Dismiss
    Then verify deals screen is displayed
    When go to 'BOGO' Tab
    And user clicks Bogo item on deals page
    And user scroll down for Buy One Get One Free offer
    And adds the first BOGO offer
    And user clicks shopping cart button on home page
    Then verify BOGO offer is added in cart
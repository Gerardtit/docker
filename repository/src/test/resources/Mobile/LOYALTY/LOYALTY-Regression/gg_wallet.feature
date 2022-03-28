Feature: Wallet - MFA

  @bvt_regression
  Scenario:User selects Delivery option and navigate to BOGO Option
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks Deals on home page
    And user click Dismiss
    Then verify deals screen is displayed
    When user clicks All coupons in deals page
    When user tap on clip then user should see View Products
#    Then verify Wallet tab bar is displayed
    When navigate to Member tab
    And user click Dismiss
    And user click Cancel in Feedback form
    Then verify wallet header
    When click on wallet sub tab
    And user click on clipped Deals
    Then verify Wallet View products


  @smokeBVT
  Scenario:User selects Delivery option and navigate to BOGO Option
    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "75214" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When user clicks Deals on home page
#    And please take survey
    Then verify deals screen is displayed
    And verify that 'Fresh new coupons' is displayed
    And verify clip CTA is displayed
    When user tap on clip then user should see View Products
    Then verify Wallet tab bar is displayed
    When go to Wallet tab
    Then verify wallet header
    When user click on clipped Deals
    Then verify Wallet View products


  @smokeBVT
  Scenario:Verify "You clipped x Deal/Deals" in Wallet page when user has clipped coupon
    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then store list is displayed
    When user clicks 1st store on the list
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
#    Then verify home screen is displayed
    Then verify MFA home screen is displayed
    When go to Deals tab
    And user click Dismiss
    Then verify deals screen is displayed
    When user clicks on clip coupon on deals page
    And go to member tab
    Then verify wallet header
    And verify clipped Deals message


  @smokeBVT
  Scenario:Verify "See your clipped deals" in Wallet page when user has not clipped any coupon
    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When go to Deals tab
    And user click Dismiss
    Then verify deals screen is displayed
    When go to member tab
    Then verify wallet header
    And verify See your clipped deals message

  @smokeBVT
  Scenario:Verify "See your clipped deals" in Wallet page when user has not clipped any coupon
    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When go to Deals tab
    And user click Dismiss
    Then verify deals screen is displayed
    When go to member tab
    Then verify wallet header
    And verify See your clipped deals message


  @smokeBVT
  Scenario:Verify "See your clipped deals" in Wallet page when existing user has not clipped any coupon
    When click on existing user signin for OTP
    And user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When go to Deals tab
    And user click Dismiss
    Then verify deals screen is displayed
    When go to member tab
    Then verify wallet header
    And verify See your clipped deals message

  @myscript3    #reference story MMM-2126, 2127
  Scenario: Navigation to the Clipped Deal section under My List tab when user tap on "See you clipped deals" under Member tab.
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When user clicks wallet on HomePage
    Then verify wallet header
    And verify See your clipped deals message
    When User click on See your Clipped deals
    Then verify that 'My Items' Page is displayed
    And verify Clipped deals is selected in my list tab
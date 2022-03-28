Feature: Accessibility Checks for UMA app


  @ADALogin @start_scenario
  Scenario: Accessibility Checks in ADA Adding Product on Home Page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed


  @ADALogin
  Scenario: Accessibility Checks in ADA Adding Product on Home Page
    When user visits Login page


  @ADAHome
  Scenario: Accessibility Checks in Home Page
    When user clicks on ADA Home page Tab

  @ADADeals
  Scenario: Accessibility Checks in Deals Page
    When user clicks on ADA Deals page

  @ADAShop
  Scenario: Accessibility Checks in SHOP Page
    When user clicks on ADA Shop page

  @ADAMyList
  Scenario: Accessibility Checks in My List Page
    When user clicks on ADA MyList page

  @ADASettings
  Scenario: Accessibility Checks in Settings Page
    When user clicks on ADA Settings page

  @ADAMember
  Scenario: Accessibility Checks in Member Page
    When user clicks on ADA Member page

  @ADASearch
  Scenario: Accessibility Checks in Search Page
    When user clicks on Search page
    And user types "milk" on ADA search bar and click search on home page

  @ADACart
  Scenario: Accessibility Checks in Search Page
    When user clicks on ADA My Cart Icon


  @ADAClippingCoupons
  Scenario: Accessibility Checks in ClippingCoupons Page
    When user clicks on ADA Clipping Deals

  @ADAReserveTime
  Scenario: Accessibility Checks in ReserveTime Page
    When user clicks on ADA Reserve Time

  @ADAFreshPass
  Scenario: Accessibility Checks in FreshPass Page
    When user clicks on ADA Member page
    When user clicks on ADA FreshPass

  @ADAWallet
  Scenario: Accessibility Checks in Wallet Page
    When user clicks on ADA Member page
    When user clicks on ADA Wallet

  @ADAMyListPageTabs
  Scenario: Accessibility Checks in ADAMyListPageTabs
    When user clicks on ADA MyList page
    When user clicks on ADA MyListPageTabs


  @ADAClippingCoupons @end_scenario
  Scenario: Accessibility Checks in ClippingCoupons Page
    When user clicks on ADA Clipping Deals

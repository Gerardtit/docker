@AllDeals
Feature: All Deals category features

  Background:
    When Launch the MFA app

  @smoke        #reference story MMM-2256
  Scenario:User validates pills in All Deals tab

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
    Then user is able to see Rewards pill in All deals tab
    When user clicks on Rewards pill
    Then verify reward page title
    When click back button from my rewards
    Then user is able to see Rewards pill in All deals tab
    Then user is able to see Clipped deals pill in All deals tab
    When user clicks on Clipped deals pill
    Then "Clipped Deals" page is displayed
    When user clicks Deals on home page
    Then user is able to see Weekly Ad pill in All deals tab
    When user clicks on Weekly Ad pill
    Then WeeklyAd page should be displayed


  @smoke
  Scenario:"Clip deal" button state changes to "Clipped!" in offer detail page
    When sign in to the application for delivery orders
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
    Then user is able to see Rewards pill in All deals tab
    When click on deal card
    Then verify eligible products are displayed in offer details page
    When clip a deal on all coupons page
    Then verify clipped deals label is displayed
    And click on close button


  @smoke @miniRegression
  Scenario:"clip" button state changes to "Offer complete" in offer detail page

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
    Then user is able to see Rewards pill in All deals tab
    When click on deal card
    Then verify eligible products are displayed in offer details page
    And user click add button to add qualifying Products
    When clip a deal on all coupons page
    Then verify offer completed message
    And click on close button

  @myscript1             #reference story MMM-2126, 2127
  Scenario:User tap Clipped Deals under All Deals section to navigate to Clipped Deals screen

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When go to Deals tab
    Then user is able to see Clipped deals pill in All deals tab
    When user clicks on Clipped deals pill
    Then verify that 'My List' Page is displayed
    And verify Clipped deals is selected in my list tab

  @myscript2           #reference story MMM-2126, 2127
  Scenario:User tap Clipped Deals under For You section to navigate to Clipped Deals screen

    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then user is logged in to the app for Existing user
    Then verify MFA home screen is displayed
    When go to Deals tab
    When go to 'For you' Tab
    Then verify that 'For you' Tab is displayed
    When user clicks on Clipped deals pill
    Then verify that 'My List' Page is displayed
    And verify Clipped deals is selected in my list tab

  @MOLN-3965
  Scenario:User tap clip your deals section to navigate to Deals page and clip deals to verify deal detail page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "75019" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    And verify Clip your deals section is displayed
    And verify count on clip your deals section displayed
    When user click see all button displayed next to clip your deals section
    Then verify user navigates to Deals Page and all deals view screen
    #Then verify deal cards are displayed in All deals screen
    Then click On Button clip
    And validate Added text is displayed on dealspage
    When click on eligible products CTA on deal card
    Then verify clipped deals label is displayed
    And verify offer terms and condition in deal card
    And verify qualifying Products is displayed

  @MOLN-39652
  Scenario:User wouldn't see clip your deals section if selects pickup or delivery option
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "75019" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    And verify Clip your favorites section is not displayed
    And verify must have grabs label displayed

  @LMT-1242
  Scenario:Legal enhancements to offer detail page and deal card
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then verify MFA home screen is displayed
    When user clicks on "Deals"
    Then user is landed on "Deals" page
    When user clicks on specific deal
    Then user validates offer details and eligible products on deal card
    When user clicks on clip deal
    When user clicks on view list on deal card
    Then user validates offer details and eligible products on My List

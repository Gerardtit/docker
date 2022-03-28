Feature: Verify ADD/Add to list


  Background:
    When  Launch the MFA app

  @smoke
  Scenario:User selects Delivery option and Verify  "ADD" CTA on Home Screen
    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "76109" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    And user clicks on Next button
    Then verify home screen is displayed
    When go to Home tab
    Then verify MFA home screen is displayed
    When go to Home tab
    And user scroll down
    Then verify add button is displayed

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
    And verify Clip your favorites section is displayed
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

  Scenario:User selects Pickup/DUG option and Verify  "ADD" CTA on Home Screen

    When click on NewSignup for OTP
    Then zipcode page is displayed
    When user enters "76109" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page

    And user clicks on Next button
    Then verify home screen is displayed
    When go to Home tab
    Then verify MFA home screen is displayed

    Then verify MFA home screen is displayed
   # And user click Dismiss
   # Then verify home screen is displayed
   # When go to Home tab

    And user scroll down
    Then verify add button is displayed


  Scenario: Verify Verify "Add to list" CTA displays when user selects Instore Seletion Mode as preference
    When click on NewSignup for OTP

    #When user clicks delivery option on home page

    Then zipcode page is displayed
    When user enters "instore" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then store list is displayed
    When user clicks 1st store on the list
    And user click start shopping button on Sign In page
    And user clicks on Next button
    Then verify home screen is displayed
    When go to Home tab
    Then verify MFA home screen is displayed
   # And user scroll down
    Then verify add to List button is displayed
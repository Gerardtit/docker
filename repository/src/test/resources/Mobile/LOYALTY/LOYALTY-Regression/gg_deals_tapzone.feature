Feature: Optimize tappable zone on Deals Card

  Background:
    When Launch the MFA app

  @miniRegression
  Scenario:Verify Optimize tappable zone on deal cards
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "zipcode" in zipcode page
    Then select order type page is displayed
    When user click delivery option
    And user click start shopping button on Sign In page
    Then complete tutorial flow
    When navigate to deals tab
    Then verify Deals tab is selected
    When clicks ForU tab
    When click on clip cta button on deals page
    Then verify Eligible products button is displayed on deals page
    When user click on Eligible products button is displayed on deals page
    And user click cross sign

  Scenario:User wouldn't see clip your deals section if selects pickup or delivery option
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    When user clicks pickup on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then complete tutorial flow
    And verify Clip your deals section is not displayed
    And verify must have grabs label displayed


  Scenario:User tap clip your deals section to navigate to Deals page and clip deals to verify deal detail page
    When click on NewSignup Api for OTP
    Then zipcode page is displayed
    When user enters "94566" in zipcode page
    Then select order type page is displayed
    When user clicks instore on delivery select page
    Then store list is displayed
    And user click start shopping button on Sign In page
    Then complete tutorial flow
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
#    And verify offer terms and condition in deal card
#    And verify qualifying Products is displayed



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
    When click on clip cta button on deals page
    When user clicks on offer details at clipped deals
    Then verify that 'My List' Page is displayed
    And verify Clipped deals is selected in my list tab

#  /////////////////////////////////does nt have step definition------------------

#  Scenario:  Display sort and filter pills on "All deals" page
#    When click on NewSignup Api for OTP
#    Then zipcode page is displayed
#    When user enters "zipcode" in zipcode page
#    Then select order type page is displayed
#    When user click delivery option
#    And user click start shopping button on Sign In page
#    Then user is logged in to the app for Existing user
#    Then verify MFA home screen is displayed
#    When go to Deals tab
#    Then verify user navigates to For you page
#    And click on categories tab
#    Then verify user navigates to Categories page
#    When user clicks All Deals tab
#    Then verify user navigates to All Deals page
#    When user clicks For you tab
#    Then verify user navigates to For you page
#    When user click on Expiring Soon tab
##   Then verify user navigates to Expiring Soon page
#    When user clicks Promo tab
#    Then verify user navigates to Promo page
#    When user clicks BOGO tab
#    Then verify user navigates to BOGO page